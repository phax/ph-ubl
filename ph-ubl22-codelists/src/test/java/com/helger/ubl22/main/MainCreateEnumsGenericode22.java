/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
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
package com.helger.ubl22.main;

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
import com.helger.genericode.v10.CodeListDocument;
import com.helger.genericode.v10.Column;
import com.helger.genericode.v10.Row;
import com.helger.genericode.v10.SimpleCodeList;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.JBlock;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JEnumConstant;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JOp;
import com.helger.jcodemodel.JVar;

/**
 * Utility class to create:
 * <ul>
 * <li>src/main/java/com/helger/ubl/codelist - generated Java Code for the
 * codelists</li>
 * </ul>
 *
 * @author Philip Helger
 */
public final class MainCreateEnumsGenericode22
{
  private static final String PACKAGE = "com.helger.ubl22.codelist";
  private static final String COLID_NAME = "name";
  private static final String COLID_CODE = "code";
  private static final JCodeModel s_aCodeModel = new JCodeModel ();

  @Nonnull
  private static String _getVarName (@Nonnull final String sOtherCol)
  {
    String sVar = sOtherCol.substring (0, 1).toUpperCase (Locale.US) + sOtherCol.substring (1);
    sVar = StringHelper.replaceAll (sVar, '-', '_');
    return sVar;
  }

  private static void _createGenericode10 (final File aFile,
                                           final CodeListDocument aCodeList10) throws JClassAlreadyExistsException
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
    if (aFile.getName ().equals ("BinaryObjectMimeCode-2.2.gc") || aFile.getName ().equals ("UnitOfMeasureCode-2.2.gc"))
    {
      // Otherwise we get a "code too large" in compilation
      aOtherCols.clear ();
    }

    // Maximum number of enum elements
    final int nEntries = aCodeList10.getSimpleCodeList ().getRow ().size ();
    final boolean bIsTooLargeForEnum = nEntries > 4000;
    if (bIsTooLargeForEnum)
      _createHelperClasses10 (aFile, aCodeList10, bHasNameColumn);
    else
      _createEnum10 (aFile, aCodeList10, aOtherCols, bHasNameColumn);
  }

  private static void _createEnum10 (final File aFile,
                                     final CodeListDocument aCodeList10,
                                     final Set <String> aOtherCols,
                                     final boolean bHasNameColumn) throws JClassAlreadyExistsException
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

    final JDefinedClass jEnum = s_aCodeModel._package (PACKAGE)
                                            ._enum (sEnumName)
                                            ._implements (s_aCodeModel.ref (IHasID.class).narrow (String.class));
    if (bHasNameColumn)
      jEnum._implements (IHasDisplayName.class);
    jEnum.annotate (CodingStyleguideUnaware.class);
    jEnum.javadoc ()
         .add ("This file was automatically generated from Genericode file " + aFile.getName () + ". Do NOT edit!\n");
    jEnum.javadoc ()
         .add ("It contains a total of " + aCodeList10.getSimpleCodeList ().getRow ().size () + " entries!\n");
    jEnum.javadoc ().add ("@author " + MainCreateEnumsGenericode22.class.getName ());

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
    final JMethod jCtor = jEnum.constructor (JMod.PRIVATE);
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
     ._return (s_aCodeModel.ref (EnumHelper.class)
                           .staticInvoke ("getFromIDOrNull")
                           .arg (JExpr.dotclass (jEnum))
                           .arg (jID));

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

  private static void _createHelperClasses10 (@Nonnull final File aFile,
                                              @Nonnull final CodeListDocument aCodeList10,
                                              final boolean bHasNameColumn) throws JClassAlreadyExistsException
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
    final int nEntries = aCodeList10.getSimpleCodeList ().getRow ().size ();

    final JDefinedClass jClass = s_aCodeModel._package (PACKAGE)._class (JMod.FINAL | JMod.PUBLIC, sClassName);
    jClass.annotate (Immutable.class);
    jClass.javadoc ()
          .add ("This file was automatically generated from Genericode file " + aFile.getName () + ". Do NOT edit!\n");
    jClass.javadoc ().add ("It contains a total of " + nEntries + " entries!\n");
    jClass.javadoc ().add ("The number of elements is too large to create an enum from it!\n");
    jClass.javadoc ().add ("@author " + MainCreateEnumsGenericode22.class.getName ());

    final AbstractJClass aSetDecl = s_aCodeModel.ref (ICommonsSet.class).narrow (String.class);
    final AbstractJClass aSetImpl = s_aCodeModel.ref (CommonsHashSet.class).narrowEmpty ();
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
    JMethod aMethod = jClass.method (JMod.PUBLIC | JMod.STATIC, s_aCodeModel.BOOLEAN, "containsCode");
    JVar aParam = aMethod.param (JMod.FINAL, String.class, "sCode");
    aParam.annotate (Nullable.class);
    aMethod.body ()._return (aCodeSet.invoke ("contains").arg (aParam));

    aMethod = jClass.method (JMod.PUBLIC | JMod.STATIC, aSetDecl, "getAllCodes");
    aMethod.annotate (Nonnull.class);
    aMethod.annotate (ReturnsMutableCopy.class);
    aMethod.body ()._return (aCodeSet.invoke ("getClone"));

    if (bHasNameColumn && aNameSet != null)
    {
      aMethod = jClass.method (JMod.PUBLIC | JMod.STATIC, s_aCodeModel.BOOLEAN, "containsName");
      aParam = aMethod.param (JMod.FINAL, String.class, "sName");
      aParam.annotate (Nullable.class);
      aMethod.body ()._return (aNameSet.invoke ("contains").arg (aParam));

      aMethod = jClass.method (JMod.PUBLIC | JMod.STATIC, aSetDecl, "getAllNames");
      aMethod.annotate (Nonnull.class);
      aMethod.annotate (ReturnsMutableCopy.class);
      aMethod.body ()._return (aNameSet.invoke ("getClone"));
    }
  }

  public static void main (final String [] args) throws JClassAlreadyExistsException, IOException
  {
    for (final File aFile : new FileSystemRecursiveIterator (new File ("src/main/resources/codelists")).withFilter (IFileFilter.filenameEndsWith (".gc")))
    {
      final CodeListDocument aCodeList10 = new Genericode10CodeListMarshaller ().read (aFile);
      if (aCodeList10 != null)
        _createGenericode10 (aFile, aCodeList10);
    }
    s_aCodeModel.build (new File ("src/main/java"));
  }
}
