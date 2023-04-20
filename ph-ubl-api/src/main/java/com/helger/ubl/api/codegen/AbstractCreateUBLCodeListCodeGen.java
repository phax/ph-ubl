/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.ubl.api.codegen;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.CollectionHelper;
import com.helger.commons.collection.impl.CommonsHashSet;
import com.helger.commons.collection.impl.CommonsLinkedHashSet;
import com.helger.commons.collection.impl.ICommonsOrderedSet;
import com.helger.commons.collection.impl.ICommonsSet;
import com.helger.commons.id.IHasID;
import com.helger.commons.io.file.FileSystemRecursiveIterator;
import com.helger.commons.io.file.IFileFilter;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;
import com.helger.commons.regex.RegExHelper;
import com.helger.commons.string.StringHelper;
import com.helger.genericode.Genericode10CodeListMarshaller;
import com.helger.genericode.Genericode10Helper;
import com.helger.genericode.v10.Agency;
import com.helger.genericode.v10.CodeListDocument;
import com.helger.genericode.v10.Column;
import com.helger.genericode.v10.Identification;
import com.helger.genericode.v10.LongName;
import com.helger.genericode.v10.Row;
import com.helger.genericode.v10.SimpleCodeList;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.JBlock;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JCodeModelException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JEnumConstant;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JOp;
import com.helger.jcodemodel.JVar;
import com.helger.jcodemodel.writer.JCMWriter;

public abstract class AbstractCreateUBLCodeListCodeGen
{
  private static final String COLID_NAME = "name";
  private static final String COLID_CODE = "code";

  @Nonnull
  protected static String _getVarName (@Nonnull final String sOtherCol)
  {
    String sVar = sOtherCol.substring (0, 1).toUpperCase (Locale.US) + sOtherCol.substring (1);
    sVar = StringHelper.replaceAll (sVar, '-', '_');
    sVar = StringHelper.replaceAllRepeatedly (sVar, "__", "_");
    return sVar;
  }

  private static void _classConstants (@Nonnull final CodeListDocument aCodeList10, @Nonnull final JDefinedClass jClass)
  {
    final Identification aIdentification = aCodeList10.getIdentification ();

    final Agency aAgency = aIdentification.getAgency ();
    if (aAgency != null)
    {
      if (aAgency.hasIdentifierEntries ())
        jClass.field (JMod.PUBLIC_STATIC_FINAL,
                      String.class,
                      "AGENCY_ID",
                      JExpr.lit (aAgency.getIdentifierAtIndex (0).getValue ()));

      if (aAgency.hasLongNameEntries ())
        jClass.field (JMod.PUBLIC_STATIC_FINAL,
                      String.class,
                      "AGENCY_LONG_NAME",
                      JExpr.lit (aAgency.getLongNameAtIndex (0).getValue ()));
    }

    final LongName aListID = CollectionHelper.findFirst (aIdentification.getLongName (),
                                                         x -> x.getIdentifier () != null &&
                                                              x.getIdentifier ().equals ("listID"));
    if (aListID != null)
      jClass.field (JMod.PUBLIC_STATIC_FINAL, String.class, "LIST_ID", JExpr.lit (aListID.getValue ()));

    final String sVersion = aIdentification.getVersion ();
    if (StringHelper.hasText (sVersion))
      jClass.field (JMod.PUBLIC_STATIC_FINAL, String.class, "LIST_VERSION", JExpr.lit (sVersion));
  }

  private void _createEnum10 (@Nonnull final JCodeModel cm,
                              @Nonnull final String sTargetPackage,
                              final File aFile,
                              final CodeListDocument aCodeList10,
                              final Set <String> aOtherCols,
                              final boolean bHasNameColumn) throws JCodeModelException
  {
    String sEnumName = "E" + aCodeList10.getIdentification ().getShortName ().getValue ();
    sEnumName = StringHelper.replaceAll (sEnumName, '-', '_');
    if (aFile.getName ().contains ("-2.0"))
      sEnumName += "20";
    else
      if (aFile.getName ().contains ("-2.1"))
        sEnumName += "21";
      else
        if (aFile.getName ().contains ("-2.2"))
          sEnumName += "22";
        else
          if (aFile.getName ().contains ("-2.3"))
            sEnumName += "23";
          else
            if (aFile.getName ().contains ("-2.4"))
              sEnumName += "24";

    final JDefinedClass jEnum = cm._package (sTargetPackage)
                                  ._enum (sEnumName)
                                  ._implements (cm.ref (IHasID.class).narrow (String.class));
    if (bHasNameColumn)
      jEnum._implements (IHasDisplayName.class);
    jEnum.annotate (CodingStyleguideUnaware.class);
    jEnum.javadoc ()
         .add ("This file was automatically generated from Genericode file " + aFile.getName () + ". Do NOT edit!\n");
    jEnum.javadoc ()
         .add ("It contains a total of " + aCodeList10.getSimpleCodeList ().getRow ().size () + " entries!\n");
    jEnum.javadoc ().add ("@author " + getClass ().getName ());

    _classConstants (aCodeList10, jEnum);

    final ICommonsSet <String> aUsedIdentifier = new CommonsHashSet <> ();
    boolean bHasEmptyID = false;
    for (final Row aRow : aCodeList10.getSimpleCodeList ().getRow ())
    {
      final String sCode = Genericode10Helper.getRowValue (aRow, COLID_CODE).trim ();
      String sIdentifier = RegExHelper.getAsIdentifier (sCode);
      if (StringHelper.hasNoText (sIdentifier))
      {
        System.out.println ("  Code '" + sCode + "' ends up in empty identifier!");
        sIdentifier = "_";
        bHasEmptyID = true;
      }

      if (!aUsedIdentifier.add (sIdentifier))
      {
        int i = 1;
        while (true)
        {
          final String sNewIdentifier = sIdentifier + "_" + i;
          if (aUsedIdentifier.add (sNewIdentifier))
          {
            sIdentifier = sNewIdentifier;
            break;
          }
          ++i;
        }
      }

      final JEnumConstant jEnumConst = jEnum.enumConstant (sIdentifier);
      jEnumConst.arg (JExpr.lit (sCode));
      if (bHasNameColumn)
        jEnumConst.arg (JExpr.lit (Genericode10Helper.getRowValue (aRow, COLID_NAME).trim ()));

      for (final String sOtherCol : aOtherCols)
      {
        String sValue = Genericode10Helper.getRowValue (aRow, sOtherCol);
        if (sValue != null)
          sValue = sValue.trim ().replaceAll ("\\s+", " ");
        jEnumConst.arg (sValue == null ? JExpr._null () : JExpr.lit (sValue));
      }
    }

    // fields
    final JFieldVar fID = jEnum.field (JMod.PRIVATE | JMod.FINAL, String.class, "m_sID");
    final JFieldVar fDisplayName = bHasNameColumn ? jEnum.field (JMod.PRIVATE | JMod.FINAL,
                                                                 String.class,
                                                                 "m_sDisplayName")
                                                  : null;

    // Constructor
    final JMethod jCtor = jEnum.constructor (JMod.NONE);
    JVar jID = jCtor.param (JMod.FINAL, String.class, "sID");
    jID.annotate (Nonnull.class);
    if (!bHasEmptyID)
      jID.annotate (Nonempty.class);
    JBlock aCtorBody = jCtor.body ().assign (fID, jID);

    if (bHasNameColumn)
    {
      final JVar jDisplayName = jCtor.param (JMod.FINAL, String.class, "sDisplayName");
      jDisplayName.annotate (Nonnull.class);
      aCtorBody.assign (fDisplayName, jDisplayName);
    }

    for (final String sOtherCol : aOtherCols)
    {
      final JFieldVar fOther = jEnum.field (JMod.PRIVATE | JMod.FINAL, String.class, "m_s" + _getVarName (sOtherCol));
      final JVar jOther = jCtor.param (JMod.FINAL, String.class, "s" + _getVarName (sOtherCol));
      jOther.annotate (Nullable.class);
      aCtorBody = aCtorBody.assign (fOther, jOther);
    }

    // public String getID ()
    JMethod m = jEnum.method (JMod.PUBLIC, String.class, "getID");
    m.annotate (Nonnull.class);
    if (!bHasEmptyID)
      m.annotate (Nonempty.class);
    m.body ()._return (fID);

    if (bHasNameColumn)
    {
      // public String getDisplayName ()
      m = jEnum.method (JMod.PUBLIC, String.class, "getDisplayName");
      m.annotate (Nonnull.class);
      m.body ()._return (fDisplayName);
    }

    for (final String sOtherCol : aOtherCols)
    {
      m = jEnum.method (JMod.PUBLIC, String.class, "get" + _getVarName (sOtherCol));
      m.annotate (Nullable.class);
      m.body ()._return (jEnum.fields ().get ("m_s" + _getVarName (sOtherCol)));
    }

    // public static E... getFromIDOrNull (@Nullable String sID)
    m = jEnum.method (JMod.PUBLIC | JMod.STATIC, jEnum, "getFromIDOrNull");
    m.annotate (Nullable.class);
    jID = m.param (JMod.FINAL, String.class, "sID");
    jID.annotate (Nullable.class);
    m.body ()
     ._return (cm.ref (EnumHelper.class).staticInvoke ("getFromIDOrNull").arg (JExpr.dotClass (jEnum)).arg (jID));

    if (bHasNameColumn)
    {
      // public static String getDisplayNameFromIDOrNull (@Nullable String sID)
      m = jEnum.method (JMod.PUBLIC | JMod.STATIC, String.class, "getDisplayNameFromIDOrNull");
      m.annotate (Nullable.class);
      jID = m.param (JMod.FINAL, String.class, "sID");
      jID.annotate (Nullable.class);
      final JVar jValue = m.body ()
                           .decl (JMod.FINAL, jEnum, "eValue", jEnum.staticInvoke ("getFromIDOrNull").arg (jID));
      m.body ()._return (JOp.cond (jValue.eq (JExpr._null ()), JExpr._null (), jValue.invoke ("getDisplayName")));
    }
  }

  private void _createHelperClasses10 (@Nonnull final JCodeModel cm,
                                       @Nonnull final String sTargetPackage,
                                       @Nonnull final File aFile,
                                       @Nonnull final CodeListDocument aCodeList10,
                                       final boolean bHasNameColumn) throws JCodeModelException
  {
    String sClassName = "C" + aCodeList10.getIdentification ().getShortName ().getValue ();
    sClassName = StringHelper.replaceAll (sClassName, '-', '_');
    if (aFile.getName ().contains ("-2.0"))
      sClassName += "20";
    else
      if (aFile.getName ().contains ("-2.1"))
        sClassName += "21";
      else
        if (aFile.getName ().contains ("-2.2"))
          sClassName += "22";
        else
          if (aFile.getName ().contains ("-2.3"))
            sClassName += "23";
          else
            if (aFile.getName ().contains ("-2.4"))
              sClassName += "24";
    final int nEntries = aCodeList10.getSimpleCodeList ().getRow ().size ();

    final JDefinedClass jClass = cm._package (sTargetPackage)._class (JMod.FINAL | JMod.PUBLIC, sClassName);
    jClass.annotate (Immutable.class);
    jClass.javadoc ()
          .add ("This file was automatically generated from Genericode file " + aFile.getName () + ". Do NOT edit!\n");
    jClass.javadoc ().add ("It contains a total of " + nEntries + " entries!\n");
    jClass.javadoc ().add ("The number of elements is too large to create an enum from it!\n");
    jClass.javadoc ().add ("@author " + getClass ().getName ());

    _classConstants (aCodeList10, jClass);

    final AbstractJClass aSetDecl = cm.ref (ICommonsSet.class).narrow (String.class);
    final AbstractJClass aSetImpl = cm.ref (CommonsHashSet.class).narrowEmpty ();
    final JVar aCodeSet = jClass.field (JMod.PRIVATE | JMod.FINAL | JMod.STATIC,
                                        aSetDecl,
                                        "s_aCodeSet",
                                        JExpr._new (aSetImpl).arg (JExpr.lit (nEntries)));
    final JVar aNameSet = bHasNameColumn ? jClass.field (JMod.PRIVATE | JMod.FINAL | JMod.STATIC,
                                                         aSetDecl,
                                                         "s_aNameSet",
                                                         JExpr._new (aSetImpl).arg (JExpr.lit (nEntries)))
                                         : null;

    int nRowIndex = 0;
    int nClassIndex = 1;
    JMethod aCodeMethod = null;
    JVar aCodeParam = null;
    JMethod aNameMethod = null;
    JVar aNameParam = null;
    for (final Row aRow : aCodeList10.getSimpleCodeList ().getRow ())
    {
      if ((nRowIndex % 1500) == 0 || aCodeMethod == null || aNameMethod == null)
      {
        final JDefinedClass aInnerCodeClass = jClass._class (JMod.PRIVATE | JMod.STATIC | JMod.FINAL,
                                                             "CodePart" + nClassIndex);
        final JDefinedClass aInnerNameClass = jClass._class (JMod.PRIVATE | JMod.STATIC | JMod.FINAL,
                                                             "NamePart" + nClassIndex);
        nClassIndex++;

        aCodeMethod = aInnerCodeClass.constructor (JMod.NONE);
        aCodeParam = aCodeMethod.param (JMod.FINAL, aSetDecl, "aCodeSet");
        aCodeParam.annotate (Nonnull.class);
        // Add init call
        jClass.init ().add (JExpr._new (aInnerCodeClass).arg (aCodeSet));

        if (bHasNameColumn)
        {
          aNameMethod = aInnerNameClass.constructor (JMod.NONE);
          aNameParam = aNameMethod.param (JMod.FINAL, aSetDecl, "aNameSet");
          aNameParam.annotate (Nonnull.class);

          // Add init call
          jClass.init ().add (JExpr._new (aInnerNameClass).arg (aNameSet));
        }
      }

      final String sRowCode = Genericode10Helper.getRowValue (aRow, COLID_CODE).trim ();
      aCodeMethod.body ().add (JExpr.invoke (aCodeParam, "add").arg (sRowCode));

      if (bHasNameColumn && aNameMethod != null)
      {
        final String sRowName = Genericode10Helper.getRowValue (aRow, COLID_NAME).trim ();
        aNameMethod.body ().add (JExpr.invoke (aNameParam, "add").arg (sRowName));
      }

      ++nRowIndex;
    }

    // private ctor
    jClass.constructor (JMod.PRIVATE);

    // Access methods
    JMethod aMethod = jClass.method (JMod.PUBLIC | JMod.STATIC, cm.BOOLEAN, "containsCode");
    JVar aParam = aMethod.param (JMod.FINAL, String.class, "sCode");
    aParam.annotate (Nullable.class);
    aMethod.body ()._return (aCodeSet.invoke ("contains").arg (aParam));

    aMethod = jClass.method (JMod.PUBLIC | JMod.STATIC, aSetDecl, "getAllCodes");
    aMethod.annotate (Nonnull.class);
    aMethod.annotate (ReturnsMutableCopy.class);
    aMethod.body ()._return (aCodeSet.invoke ("getClone"));

    if (bHasNameColumn && aNameSet != null)
    {
      aMethod = jClass.method (JMod.PUBLIC | JMod.STATIC, cm.BOOLEAN, "containsName");
      aParam = aMethod.param (JMod.FINAL, String.class, "sName");
      aParam.annotate (Nullable.class);
      aMethod.body ()._return (aNameSet.invoke ("contains").arg (aParam));

      aMethod = jClass.method (JMod.PUBLIC | JMod.STATIC, aSetDecl, "getAllNames");
      aMethod.annotate (Nonnull.class);
      aMethod.annotate (ReturnsMutableCopy.class);
      aMethod.body ()._return (aNameSet.invoke ("getClone"));
    }
  }

  private void _createGenericode10 (@Nonnull final JCodeModel cm,
                                    @Nonnull final String sTargetPackage,
                                    @Nonnull final File aFile,
                                    @Nonnull final CodeListDocument aCodeList10) throws JCodeModelException
  {
    System.out.println (aFile.getAbsolutePath ());
    final SimpleCodeList aSimpleCodeList = aCodeList10.getSimpleCodeList ();
    if (aSimpleCodeList == null)
    {
      System.out.println ("  does not contain a SimpleCodeList!");
      return;
    }
    final Column aColCode = Genericode10Helper.getColumnOfID (aCodeList10.getColumnSet (), COLID_CODE);
    if (aColCode == null)
    {
      System.out.println ("  No '" + COLID_CODE + "' column found");
      return;
    }
    if (!Genericode10Helper.isKeyColumn (aCodeList10.getColumnSet (), COLID_CODE))
    {
      System.out.println ("  Column '" + COLID_CODE + "' is not a key");
      return;
    }

    // Name column may be null
    final Column aColName = Genericode10Helper.getColumnOfID (aCodeList10.getColumnSet (), COLID_NAME);
    final boolean bHasNameColumn = aColName != null;

    final ICommonsOrderedSet <String> aOtherCols = new CommonsLinkedHashSet <> ();
    Genericode10Helper.getAllColumnIDs (aCodeList10.getColumnSet (), aOtherCols);
    aOtherCols.remove (COLID_CODE);
    aOtherCols.remove (COLID_NAME);
    if (aFile.getName ().startsWith ("BinaryObjectMimeCode-") || aFile.getName ().startsWith ("UnitOfMeasureCode-"))
    {
      // Otherwise we get a "code too large" in compilation
      aOtherCols.clear ();
    }

    // Maximum number of enum elements
    final int nEntries = aCodeList10.getSimpleCodeList ().getRow ().size ();
    final boolean bIsTooLargeForEnum = nEntries > 4000;
    if (bIsTooLargeForEnum)
      _createHelperClasses10 (cm, sTargetPackage, aFile, aCodeList10, bHasNameColumn);
    else
      _createEnum10 (cm, sTargetPackage, aFile, aCodeList10, aOtherCols, bHasNameColumn);
  }

  public void run (@Nonnull final String sTargetPackage) throws JCodeModelException, IOException
  {
    final JCodeModel cm = new JCodeModel ();
    for (final File aFile : new FileSystemRecursiveIterator (new File ("src/main/resources/external/codelists")).withFilter (IFileFilter.filenameEndsWith (".gc")))
      if (!aFile.getName ().endsWith ("-incl-deprecated.gc") && !aFile.getName ().endsWith ("-incl-deleted.gc"))
      {
        final CodeListDocument aCodeList10 = new Genericode10CodeListMarshaller ().read (aFile);
        if (aCodeList10 != null)
          _createGenericode10 (cm, sTargetPackage, aFile, aCodeList10);
      }
    new JCMWriter (cm).build (new File ("src/main/java"));
  }
}
