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
package com.helger.ubl20.supplementary.tools;

import java.io.File;
import java.util.Locale;

import javax.xml.XMLConstants;

import com.helger.annotation.Nonempty;
import com.helger.cache.regex.RegExHelper;
import com.helger.collection.commons.CommonsHashSet;
import com.helger.collection.commons.CommonsTreeMap;
import com.helger.collection.commons.ICommonsNavigableMap;
import com.helger.collection.commons.ICommonsSet;
import com.helger.datetime.xml.XMLOffsetDate;
import com.helger.datetime.xml.XMLOffsetDateTime;
import com.helger.datetime.xml.XMLOffsetTime;
import com.helger.io.resource.FileSystemResource;
import com.helger.jaxb.adapter.AdapterXMLOffsetDate;
import com.helger.jaxb.adapter.AdapterXMLOffsetDateTime;
import com.helger.jaxb.adapter.AdapterXMLOffsetTime;
import com.helger.ubl.api.codegen.AbstractUBLCodeGen;
import com.helger.xml.microdom.IMicroDocument;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroDocument;
import com.helger.xml.microdom.MicroQName;
import com.helger.xml.microdom.serialize.MicroReader;
import com.helger.xml.microdom.serialize.MicroWriter;
import com.helger.xml.microdom.util.XMLMapHandler;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xml.serialize.write.EXMLIncorrectCharacterHandling;
import com.helger.xml.serialize.write.XMLWriterSettings;

import jakarta.annotation.Nonnull;

/**
 * Utility class that creates:
 * <ul>
 * <li>src/main/jaxb/bindings20.xjb - the JAXB binding file</li>
 * <li>src/main/resources/external/schemas/*.xsd.mapping - mapping files that contain the generated
 * explicit enum mappings</li>
 * </ul>
 *
 * @author Philip Helger
 */
public final class MainCreateJAXBBinding20 extends AbstractUBLCodeGen
{
  private static final String JAXB_NS_URI = "https://jakarta.ee/xml/ns/jaxb";
  private static final String XJC_NS_URI = "http://java.sun.com/xml/ns/jaxb/xjc";

  @Nonnull
  private static IMicroDocument _createBaseDoc ()
  {
    final IMicroDocument eDoc = new MicroDocument ();
    eDoc.addComment ("This file is generated. Do NOT edit.\n");
    final IMicroElement eRoot = eDoc.addElementNS (JAXB_NS_URI, "bindings");
    eRoot.setAttribute (new MicroQName (XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "schemaLocation"),
                        JAXB_NS_URI + " https://jakarta.ee/xml/ns/jaxb/bindingschema_3_0.xsd");
    // This is the JAXB version, not the UBL version :)
    eRoot.setAttribute ("version", "3.0");

    final IMicroElement eGlobal = eRoot.addElementNS (JAXB_NS_URI, "globalBindings");
    eGlobal.setAttribute ("typesafeEnumMaxMembers", "2000");
    eGlobal.setAttribute ("typesafeEnumMemberName", "generateError");

    // When in "xjc" namespace "adapter" can be used, when in "jaxb"
    // namespace, parse and print must be used
    eGlobal.addElementNS (XJC_NS_URI, "javaType")
           .setAttribute ("name", XMLOffsetDateTime.class.getName ())
           .setAttribute ("xmlType", "xsd:dateTime")
           .setAttribute ("adapter", AdapterXMLOffsetDateTime.class.getName ());
    eGlobal.addElementNS (XJC_NS_URI, "javaType")
           .setAttribute ("name", XMLOffsetDate.class.getName ())
           .setAttribute ("xmlType", "xsd:date")
           .setAttribute ("adapter", AdapterXMLOffsetDate.class.getName ());
    eGlobal.addElementNS (XJC_NS_URI, "javaType")
           .setAttribute ("name", XMLOffsetTime.class.getName ())
           .setAttribute ("xmlType", "xsd:time")
           .setAttribute ("adapter", AdapterXMLOffsetTime.class.getName ());

    return eDoc;
  }

  private static void _generateExplicitEnumMapping (@Nonnull final IMicroDocument aDoc,
                                                    @Nonnull @Nonempty final String sFilename,
                                                    @Nonnull final IMicroElement eBindings)
  {
    final ICommonsSet <String> aUsedNames = new CommonsHashSet <> ();
    final ICommonsNavigableMap <String, String> aValueToConstants = new CommonsTreeMap <> ();
    final IMicroElement eSimpleType = aDoc.getDocumentElement ().getFirstChildElement ();

    final IMicroElement eInnerBindings = eBindings.addElementNS (JAXB_NS_URI, "bindings")
                                                  .setAttribute ("node",
                                                                 "xsd:simpleType[@name='" +
                                                                         eSimpleType.getAttributeValue ("name") +
                                                                         "']");
    final IMicroElement eTypesafeEnumClass = eInnerBindings.addElementNS (JAXB_NS_URI, "typesafeEnumClass");

    final IMicroElement eRestriction = eSimpleType.getFirstChildElement ();
    for (final IMicroElement eEnumeration : eRestriction.getAllChildElements (XMLConstants.W3C_XML_SCHEMA_NS_URI,
                                                                              "enumeration"))
    {
      final IMicroElement eAnnotation = eEnumeration.getFirstChildElement (XMLConstants.W3C_XML_SCHEMA_NS_URI,
                                                                           "annotation");
      if (eAnnotation == null)
        throw new IllegalStateException ("annotation is missing");
      final IMicroElement eDocumentation = eAnnotation.getFirstChildElement (XMLConstants.W3C_XML_SCHEMA_NS_URI,
                                                                             "documentation");
      if (eDocumentation == null)
        throw new IllegalStateException ("documentation is missing");
      final IMicroElement eCodeName = eDocumentation.getFirstChildElement ("urn:un:unece:uncefact:documentation:2",
                                                                           "CodeName");
      if (eCodeName == null)
        throw new IllegalStateException ("CodeName is missing");

      final String sValue = eEnumeration.getAttributeValue ("value");
      // Create an upper case Java identifier, without duplicate "_"
      String sCodeName = RegExHelper.getAsIdentifier (eCodeName.getTextContent ().trim ().toUpperCase (Locale.US))
                                    .replaceAll ("_+", "_");

      if (!aUsedNames.add (sCodeName))
      {
        // Ensure uniqueness of the enum member name
        int nSuffix = 1;
        while (true)
        {
          final String sSuffixedCodeName = sCodeName + "_" + nSuffix;
          if (aUsedNames.add (sSuffixedCodeName))
          {
            sCodeName = sSuffixedCodeName;
            break;
          }
          ++nSuffix;
        }
      }

      eTypesafeEnumClass.addElementNS (JAXB_NS_URI, "typesafeEnumMember")
                        .setAttribute ("value", sValue)
                        .setAttribute ("name", sCodeName);
      aValueToConstants.put (sValue, sCodeName);
    }

    // Write out the mapping file for easy later-on resolving
    XMLMapHandler.writeMap (aValueToConstants,
                            new FileSystemResource ("src/main/resources/external/schemas/" + sFilename + ".mapping"));
  }

  public static void main (final String [] args)
  {
    // UBL 2.0
    {
      System.out.println ("UBL 2.0");
      final IMicroDocument eDoc = _createBaseDoc ();
      final ICommonsSet <String> aNamespaces = new CommonsHashSet <> ();
      for (final String sPart : new String [] { "common", "maindoc" })
      {
        final String sBasePath = "/resources/external/schemas/ubl20/" + sPart;
        for (final File aFile : getXSDFileList ("src/main" + sBasePath))
        {
          // Each namespace should handled only once
          final IMicroDocument aDoc = MicroReader.readMicroXML (new FileSystemResource (aFile));
          final String sTargetNamespace = getTargetNamespace (aDoc);
          if (!aNamespaces.add (sTargetNamespace))
          {
            System.out.println ("Ignored " + sTargetNamespace + " in " + aFile.getName ());
            continue;
          }
          final String sPackageName = getAsPackageName (sTargetNamespace);
          // schemaLocation must be relative to bindings file!
          final IMicroElement eBindings = eDoc.getDocumentElement ()
                                              .addElementNS (JAXB_NS_URI, "bindings")
                                              .setAttribute ("schemaLocation",
                                                             ".." + sBasePath + "/" + aFile.getName ())
                                              .setAttribute ("node", "/xsd:schema");

          eBindings.addComment ("Target namespace: " + sTargetNamespace);
          eBindings.addElementNS (JAXB_NS_URI, "schemaBindings")
                   .addElementNS (JAXB_NS_URI, "package")
                   .setAttribute ("name", sPackageName);

          if (aFile.getName ().equals ("CodeList_UnitCode_UNECE_7_04.xsd") ||
              aFile.getName ().equals ("CodeList_LanguageCode_ISO_7_04.xsd"))
          {
            _generateExplicitEnumMapping (aDoc, aFile.getName (), eBindings);
          }
        }
      }
      if (MicroWriter.writeToFile (eDoc,
                                   new File ("src/main/jaxb/bindings20.xjb"),
                                   new XMLWriterSettings ().setIncorrectCharacterHandling (EXMLIncorrectCharacterHandling.DO_NOT_WRITE_LOG_WARNING)
                                                           .setNamespaceContext (new MapBasedNamespaceContext ().addMapping ("jaxb",
                                                                                                                             JAXB_NS_URI)
                                                                                                                .addMapping ("xjc",
                                                                                                                             XJC_NS_URI)
                                                                                                                .addMapping ("xsd",
                                                                                                                             XMLConstants.W3C_XML_SCHEMA_NS_URI)
                                                                                                                .addMapping ("xsi",
                                                                                                                             XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI))
                                                           .setPutNamespaceContextPrefixesInRoot (true)).isFailure ())
        throw new IllegalStateException ("Failed to write file");
    }

    System.out.println ("Done");
  }
}
