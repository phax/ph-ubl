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
package com.helger.ubl22.supplementary.tools;

import java.io.File;

import com.helger.commons.collection.impl.CommonsHashSet;
import com.helger.commons.collection.impl.ICommonsSet;
import com.helger.commons.io.resource.FileSystemResource;
import com.helger.ubl.api.codegen.AbstractUBLCodeGen;
import com.helger.xml.microdom.IMicroDocument;
import com.helger.xml.microdom.serialize.MicroReader;

/**
 * Utility class that creates the content for EUBL22DocumentType
 *
 * @author Philip Helger
 */
public final class MainCreateDocTypeList22 extends AbstractUBLCodeGen
{
  public static void main (final String [] args)
  {
    final StringBuilder aSB = new StringBuilder ();

    final ICommonsSet <String> aNamespaces = new CommonsHashSet <> ();
    for (final String sPart : new String [] { "maindoc" })
    {
      final String sBasePath = "src/main/resources/external/schemas/ubl22/" + sPart;
      for (final File aFile : getXSDFileList (sBasePath))
      {
        // UBL-CallForTenders-2.2.xsd
        final String sFilename = aFile.getName ();

        // CallForTenders
        final String sDocTypeCC = sFilename.substring (4, sFilename.length () - 8);

        // CALL_FOR_TENDERS
        final String sDocTypeUC = toUpperCase (sDocTypeCC);

        // Each namespace should handled only once
        final IMicroDocument aDoc = MicroReader.readMicroXML (new FileSystemResource (aFile));
        final String sTargetNamespace = getTargetNamespace (aDoc);
        if (!aNamespaces.add (sTargetNamespace))
        {
          System.out.println ("Ignored " + sTargetNamespace + " in " + aFile.getName ());
          continue;
        }
        String sPackageName = getAsPackageName (sTargetNamespace);
        if (sPackageName.endsWith ("_2"))
        {
          // Change "_2" to "_22"
          sPackageName += "2";
        }

        {
          final String sPrevBasePath = "../ph-ubl21/src/main/resources/external/schemas/ubl21/" + sPart;
          final String sPrevFilename = aFile.getName ().replace ("2.2", "2.1");
          if (!new File (sPrevBasePath, sPrevFilename).exists ())
            aSB.append ("@Since (\"2.2\")\n");
        }

        // APPLICATION_RESPONSE
        // (oasis.names.specification.ubl.schema.xsd.applicationresponse_22.ApplicationResponseType.class,
        // UBL22Marshaller.getAllApplicationResponseXSDs ()),

        aSB.append (sDocTypeUC)
           .append (" (")
           .append (sPackageName)
           .append (".")
           .append (sDocTypeCC)
           .append ("Type.class, UBL22Marshaller.getAll")
           .append (sDocTypeCC)
           .append ("XSDs ()),\n");
      }
    }

    System.out.println (aSB.toString ());
  }
}
