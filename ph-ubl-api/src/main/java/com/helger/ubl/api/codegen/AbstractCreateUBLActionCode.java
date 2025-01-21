/*
 * Copyright (C) 2014-2025 Philip Helger (www.helger.com)
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

import java.util.Locale;

import javax.annotation.Nonnull;

import com.helger.commons.string.StringHelper;

/**
 * Base class for internal code generation. You should not care too much about
 * this one...
 *
 * @author Philip Helger
 */
public abstract class AbstractCreateUBLActionCode extends AbstractUBLCodeGen
{
  public static void appendMarshaller (@Nonnull final String sMarshallerClassName,
                                       @Nonnull final String sXSDPath,
                                       @Nonnull final Class <?> aImplClass,
                                       @Nonnull final StringBuilder aSB)
  {
    final String sClassName = aImplClass.getSimpleName ();
    final String sNoTypeName = StringHelper.trimEnd (sClassName, "Type");

    // Local constant to avoid it is resolved over and over again
    final String sCPRName = "CPR_" + sNoTypeName.toUpperCase (Locale.ROOT);
    aSB.append ("private static final ClassPathResource ")
       .append (sCPRName)
       .append (" = _getCPR (\"")
       .append (sXSDPath)
       .append ("\");\n\n");

    final String sGetAllXSDsName = "getAll" + sNoTypeName + "XSDs";
    aSB.append ("@Nonnull\n");
    aSB.append ("@ReturnsMutableCopy\n");
    aSB.append ("public static ICommonsList <ClassPathResource> ").append (sGetAllXSDsName).append (" ()\n");
    aSB.append ("{\n");
    aSB.append ("  return _getAllXSDs (").append (sCPRName).append (");\n");
    aSB.append ("}\n\n");

    final String sMarshallerMethodName = lcFirst (sNoTypeName);
    aSB.append ("@Nonnull\n");
    aSB.append ("public static ")
       .append (sMarshallerClassName)
       .append (" <")
       .append (sClassName)
       .append ("> ")
       .append (sMarshallerMethodName)
       .append (" ()\n");
    aSB.append ("{\n");
    aSB.append ("  return new ")
       .append (sMarshallerClassName)
       .append (" <> (")
       .append (sClassName)
       .append (".class, ")
       .append (sGetAllXSDsName)
       .append (" (), ")
       .append (aImplClass.getPackage ().getName ())
       .append (".ObjectFactory._")
       .append (sNoTypeName)
       .append ("_QNAME);\n");
    aSB.append ("}\n\n");
  }

  protected static void appendVESIDCode (@Nonnull final Class <?> aImplClass,
                                         @Nonnull final StringBuilder aSB1,
                                         @Nonnull final StringBuilder aSB2,
                                         @Nonnull final String sVersion)
  {
    final String s = StringHelper.trimEnd (aImplClass.getSimpleName (), "Type");
    final String sVES = "VID_UBL_" + sVersion + "_" + s.toUpperCase (Locale.ROOT);
    aSB1.append ("public static final VESID ")
        .append (sVES)
        .append (" = new VESID (GROUP_ID, \"")
        .append (s.toLowerCase (Locale.ROOT))
        .append ("\", VERSION_")
        .append (sVersion)
        .append (");\n");

    aSB2.append ("aRegistry.registerValidationExecutorSet (ValidationExecutorSet.create (")
        .append (sVES)
        .append (", \"UBL ")
        .append (getDisplayNameFromType (s))
        .append (" \" + VERSION_")
        .append (sVersion)
        .append (", bNotDeprecated, ValidationExecutorXSD.create (UBL")
        .append (sVersion)
        .append ("Marshaller.getAll")
        .append (s)
        .append ("XSDs ())));\n");
  }
}
