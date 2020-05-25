/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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
package com.helger.ubl20.main;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
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
import com.helger.genericode.Genericode04CodeListMarshaller;
import com.helger.genericode.Genericode04Helper;
import com.helger.genericode.v04.CodeListDocument;
import com.helger.genericode.v04.Column;
import com.helger.genericode.v04.Row;
import com.helger.genericode.v04.SimpleCodeList;
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

import un.unece.uncefact.codelist.specification._54217._2001.CurrencyCodeContentType;
import un.unece.uncefact.codelist.specification._5639._1988.LanguageCodeContentType;
import un.unece.uncefact.codelist.specification._66411._2001.UnitCodeContentType;

/**
 * Utility class to create:
 * <ul>
 * <li>src/main/java/com/helger/ubl/codelist - generated Java Code for the
 * codelists</li>
 * </ul>
 *
 * @author Philip Helger
 */
public final class MainCreateEnumsGenericode20
{
  private static final String COLID_NAME = "name";
  private static final String COLID_CODE = "code";
  private static final JCodeModel s_aCodeModel = new JCodeModel ();

  @Nonnull
  private static String _getVarName (@Nonnull final String sOtherCol)
  {
    return sOtherCol.substring (0, 1).toUpperCase (Locale.US) + sOtherCol.substring (1);
  }

  private static void _createGenericode04 (@Nonnull final File aFile, @Nonnull final CodeListDocument aCodeList) throws JCodeModelException
  {
    if (aFile.getName ().equals ("ContainerSizeTypeCode-2.0.gc") || aFile.getName ().equals ("PortCode-2.0.gc"))
    {
      // FIXME Created enum would be too big! (constant pool of 65535 entries
      // exceeded)
      // Note: using ID and name column only wouldn't solve the problem!
      return;
    }

    // Try to combine codelist with JAXB generated enum
    Class <? extends Enum <?>> aJAXBEnumClass = null;
    if (aFile.getName ().equals ("UnitOfMeasureCode-2.0.gc"))
      aJAXBEnumClass = UnitCodeContentType.class;
    else
      if (aFile.getName ().equals ("LanguageCode-2.0.gc"))
        aJAXBEnumClass = LanguageCodeContentType.class;
      else
        if (aFile.getName ().equals ("CurrencyCode-2.0.gc"))
          aJAXBEnumClass = CurrencyCodeContentType.class;

    final SimpleCodeList aSimpleCodeList = aCodeList.getSimpleCodeList ();
    if (aSimpleCodeList == null)
    {
      System.out.println ("  does not contain a SimpleCodeList!");
      return;
    }
    final Column aColCode = Genericode04Helper.getColumnOfID (aCodeList.getColumnSet (), COLID_CODE);
    if (aColCode == null)
    {
      System.out.println ("  No '" + COLID_CODE + "' column found");
      return;
    }
    if (!Genericode04Helper.isKeyColumn (aCodeList.getColumnSet (), COLID_CODE))
    {
      System.out.println ("  Column '" + COLID_CODE + "' is not a key");
      return;
    }
    final Column aColName = Genericode04Helper.getColumnOfID (aCodeList.getColumnSet (), COLID_NAME);
    final boolean bHasNameColumn = aColName != null;

    final ICommonsOrderedSet <String> aOtherCols = new CommonsLinkedHashSet <> ();
    Genericode04Helper.getAllColumnIDs (aCodeList.getColumnSet (), aOtherCols);
    aOtherCols.remove (COLID_CODE);
    aOtherCols.remove (COLID_NAME);

    String sEnumName = "E" + aCodeList.getIdentification ().getShortName ().getValue ();
    if (aFile.getName ().endsWith ("-2.0.gc"))
      sEnumName += "20";

    final JDefinedClass jEnum = s_aCodeModel._package ("com.helger.ubl20.codelist")
                                            ._enum (sEnumName)
                                            ._implements (s_aCodeModel.ref (IHasID.class).narrow (String.class))
                                            ._implements (IHasDisplayName.class);
    jEnum.annotate (CodingStyleguideUnaware.class);
    jEnum.javadoc ().add ("This file is generated from Genericode file " + aFile.getName () + ". Do NOT edit!");

    final ICommonsSet <String> aUsedIdentifier = new CommonsHashSet <> ();
    boolean bHasEmptyID = false;
    for (final Row aRow : aCodeList.getSimpleCodeList ().getRow ())
    {
      final String sCode = Genericode04Helper.getRowValue (aRow, COLID_CODE).trim ();
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
        jEnumConst.arg (JExpr.lit (Genericode04Helper.getRowValue (aRow, COLID_NAME).trim ()));

      for (final String sOtherCol : aOtherCols)
      {
        String sValue = Genericode04Helper.getRowValue (aRow, sOtherCol);
        if (sValue != null)
          sValue = sValue.trim ().replaceAll ("\\s+", " ");
        jEnumConst.arg (sValue == null ? JExpr._null () : JExpr.lit (sValue));
      }
    }

    // fields
    final JFieldVar fID = jEnum.field (JMod.PRIVATE | JMod.FINAL, String.class, "m_sID");
    final JFieldVar fDisplayName = bHasNameColumn ? jEnum.field (JMod.PRIVATE | JMod.FINAL, String.class, "m_sDisplayName") : null;

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
      final String sVarName = _getVarName (sOtherCol);
      m = jEnum.method (JMod.PUBLIC, String.class, "get" + sVarName);
      m.annotate (Nullable.class);
      m.body ()._return (jEnum.fields ().get ("m_s" + sVarName));
    }

    // public static E... getFromIDOrNull (@Nullable String sID)
    m = jEnum.method (JMod.PUBLIC | JMod.STATIC, jEnum, "getFromIDOrNull");
    m.annotate (Nullable.class);
    jID = m.param (JMod.FINAL, String.class, "sID");
    jID.annotate (Nullable.class);
    m.body ()._return (s_aCodeModel.ref (EnumHelper.class).staticInvoke ("getFromIDOrNull").arg (JExpr.dotClass (jEnum)).arg (jID));

    if (bHasNameColumn)
    {
      // public static String getDisplayNameFromIDOrNull (@Nullable String sID)
      m = jEnum.method (JMod.PUBLIC | JMod.STATIC, String.class, "getDisplayNameFromIDOrNull");
      m.annotate (Nullable.class);
      jID = m.param (JMod.FINAL, String.class, "sID");
      jID.annotate (Nullable.class);
      final JVar jValue = m.body ().decl (JMod.FINAL, jEnum, "eValue", jEnum.staticInvoke ("getFromIDOrNull").arg (jID));
      m.body ()._return (JOp.cond (jValue.eq (JExpr._null ()), JExpr._null (), jValue.invoke ("getDisplayName")));
    }

    if (aJAXBEnumClass != null)
    {
      m = jEnum.method (JMod.PUBLIC | JMod.STATIC, jEnum, "getFromJAXBOrNull");
      m.annotate (Nullable.class);
      jID = m.param (JMod.FINAL, s_aCodeModel.ref (aJAXBEnumClass), "aID");
      jID.annotate (Nullable.class);
      m.body ()
       ._return (JOp.cond (jID.eq (JExpr._null ()), JExpr._null (), jEnum.staticInvoke ("getFromIDOrNull").arg (jID.invoke ("value"))));

      m = jEnum.method (JMod.PUBLIC | JMod.STATIC, String.class, "getDisplayNameFromJAXBOrNull");
      m.annotate (Nullable.class);
      jID = m.param (JMod.FINAL, s_aCodeModel.ref (aJAXBEnumClass), "aID");
      jID.annotate (Nullable.class);
      m.body ()
       ._return (JOp.cond (jID.eq (JExpr._null ()),
                           JExpr._null (),
                           jEnum.staticInvoke ("getDisplayNameFromIDOrNull").arg (jID.invoke ("value"))));
    }
  }

  public static void main (final String [] args) throws JCodeModelException, IOException
  {
    for (final File aFile : new FileSystemRecursiveIterator (new File ("src/main/resources/codelists")).withFilter (IFileFilter.filenameEndsWith (".gc")))
    {
      System.out.println (aFile.getName ());
      final CodeListDocument aCodeList04 = new Genericode04CodeListMarshaller ().read (aFile);
      if (aCodeList04 != null)
        _createGenericode04 (aFile, aCodeList04);
      else
        throw new IllegalStateException ("Failed to read codelist file " + aFile);
    }
    new JCMWriter (s_aCodeModel).build (new File ("src/main/java"));
  }
}
