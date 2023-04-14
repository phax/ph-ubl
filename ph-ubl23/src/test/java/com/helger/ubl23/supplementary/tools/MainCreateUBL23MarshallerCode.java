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
package com.helger.ubl23.supplementary.tools;

import com.helger.commons.string.StringHelper;
import com.helger.ubl.api.codegen.AbstractCreateUBLActionCode;
import com.helger.ubl23.EUBL23DocumentTypeSimple;

public final class MainCreateUBL23MarshallerCode extends AbstractCreateUBLActionCode
{
  public static void main (final String [] args)
  {
    final StringBuilder aSB = new StringBuilder ();

    for (final EUBL23DocumentTypeSimple e : EUBL23DocumentTypeSimple.values ())
    {
      final String sClassName = e.getClazz ().getSimpleName ();
      final String sNoTypeName = StringHelper.trimEnd (sClassName, "Type");
      final String sMethodName = lcFirst (sNoTypeName);
      aSB.append ("@Nonnull\n");
      aSB.append ("public static GenericJAXBMarshaller <")
         .append (sClassName)
         .append ("> ")
         .append (sMethodName)
         .append (" ()\n");
      aSB.append ("{\n");
      aSB.append ("  return new UBL23JAXBMarshaller <> (")
         .append (sClassName)
         .append (".class, _getCPR (\"")
         .append (e.getXSDPath ())
         .append ("\"), ")
         .append (e.getClazz ().getPackage ().getName ())
         .append (".ObjectFactory._")
         .append (sNoTypeName)
         .append ("_QNAME);\n");
      aSB.append ("}\n\n");
    }
    System.out.println (aSB.toString ());
    // Insert into UBL23Marshaller
  }
}
