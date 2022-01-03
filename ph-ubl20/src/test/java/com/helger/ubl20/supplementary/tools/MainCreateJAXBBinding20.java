/*
 * Copyright (C) 2014-2022 Philip Helger (www.helger.com)
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
import java.net.URL;
import java.util.Comparator;
import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.XMLConstants;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.ArrayHelper;
import com.helger.commons.collection.CollectionHelper;
import com.helger.commons.collection.impl.CommonsHashSet;
import com.helger.commons.collection.impl.CommonsTreeMap;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.collection.impl.ICommonsNavigableMap;
import com.helger.commons.collection.impl.ICommonsSet;
import com.helger.commons.io.file.FileSystemIterator;
import com.helger.commons.io.file.IFileFilter;
import com.helger.commons.io.resource.FileSystemResource;
import com.helger.commons.regex.RegExHelper;
import com.helger.commons.string.StringHelper;
import com.helger.commons.url.URLHelper;
import com.helger.xml.CXML;
import com.helger.xml.microdom.IMicroDocument;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroDocument;
import com.helger.xml.microdom.serialize.MicroReader;
import com.helger.xml.microdom.serialize.MicroWriter;
import com.helger.xml.microdom.util.XMLMapHandler;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xml.serialize.write.EXMLIncorrectCharacterHandling;
import com.helger.xml.serialize.write.XMLWriterSettings;

/**
 * Utility class that creates:
 * <ul>
 * <li>src/main/jaxb/bindings20.xjb - the JAXB binding file</li>
 * <li>src/main/resources/schemas/*.xsd.mapping - mapping files that contain the
 * generated explicit enum mappings</li>
 * </ul>
 *
 * @author Philip Helger
 */
public final class MainCreateJAXBBinding20
{
  private static final String JAXB_NS_URI = "http://java.sun.com/xml/ns/jaxb";
  private static final String XJC_NS_URI = "http://java.sun.com/xml/ns/jaxb/xjc";

  @Nonnull
  private static IMicroDocument _createBaseDoc ()
  {
    final IMicroDocument eDoc = new MicroDocument ();
    final IMicroElement eRoot = eDoc.appendElement (JAXB_NS_URI, "bindings");
    if (false)
      eRoot.setAttribute ("xsi:schemaLocation", JAXB_NS_URI + " http://java.sun.com/xml/ns/jaxb/bindingschema_2_0.xsd");
    eRoot.setAttribute ("version", "2.1");

    final IMicroElement eGlobal = eRoot.appendElement (JAXB_NS_URI, "globalBindings");
    eGlobal.setAttribute ("typesafeEnumMaxMembers", "2000");
    eGlobal.setAttribute ("typesafeEnumMemberName", "generateError");

    // When in "xjc" namespace "adapter" can be used, when in "jaxb"
    // namespace, parse and print must be used
    eGlobal.appendElement (XJC_NS_URI, "javaType")
           .setAttribute ("name", "com.helger.commons.datetime.XMLOffsetDateTime")
           .setAttribute ("xmlType", "xsd:dateTime")
           .setAttribute ("adapter", "com.helger.jaxb.adapter.AdapterXMLOffsetDateTime");
    eGlobal.appendElement (XJC_NS_URI, "javaType")
           .setAttribute ("name", "com.helger.commons.datetime.XMLOffsetDate")
           .setAttribute ("xmlType", "xsd:date")
           .setAttribute ("adapter", "com.helger.jaxb.adapter.AdapterXMLOffsetDate");
    eGlobal.appendElement (XJC_NS_URI, "javaType")
           .setAttribute ("name", "com.helger.commons.datetime.XMLOffsetTime")
           .setAttribute ("xmlType", "xsd:time")
           .setAttribute ("adapter", "com.helger.jaxb.adapter.AdapterXMLOffsetTime");

    return eDoc;
  }

  @Nonnull
  private static Iterable <File> _getFileList (final String sPath)
  {
    return CollectionHelper.getSorted (new FileSystemIterator (sPath).withFilter (IFileFilter.filenameEndsWith (".xsd"))
                                                                     .withFilter (IFileFilter.filenameMatchNoRegEx ("^CCTS.*")),
                                       Comparator.comparing (File::getName));
  }

  @Nullable
  private static String _getTargetNamespace (@Nonnull final IMicroDocument aDoc)
  {
    return aDoc.getDocumentElement ().getAttributeValue (CXML.XML_ATTR_XSD_TARGETNAMESPACE);
  }

  @Nonnull
  private static String _convertToPackage (@Nonnull final String sNamespaceURI)
  {
    // Lowercase everything
    String s = sNamespaceURI.toLowerCase (Locale.US);

    String [] aParts;
    final URL aURL = URLHelper.getAsURL (sNamespaceURI);
    if (aURL != null)
    {
      // Host
      String sHost = aURL.getHost ();

      // Kick static prefix: www.helger.com -> helger.com
      sHost = StringHelper.trimStart (sHost, "www.");

      // Reverse domain: helger.com -> com.helger
      final ICommonsList <String> x = StringHelper.getExploded ('.', sHost);
      x.reverse ();

      // Path in regular order:
      final String sPath = StringHelper.trimStart (aURL.getPath (), '/');
      x.addAll (StringHelper.getExploded ('/', sPath));

      // Convert to array
      aParts = ArrayHelper.newArray (x, String.class);
    }
    else
    {
      // Kick known prefixes
      for (final String sPrefix : new String [] { "urn:", "http://" })
        if (s.startsWith (sPrefix))
        {
          s = s.substring (sPrefix.length ());
          break;
        }

      // Replace all illegal characters
      s = StringHelper.replaceAll (s, ':', '.');
      s = StringHelper.replaceAll (s, '-', '_');
      aParts = StringHelper.getExplodedArray ('.', s);
    }

    // Split into pieces and replace all illegal package parts (e.g. only
    // numeric) with valid ones
    for (int i = 0; i < aParts.length; ++i)
      aParts[i] = RegExHelper.getAsIdentifier (aParts[i]);

    return StringHelper.getImploded (".", aParts);
  }

  private static void _generateExplicitEnumMapping (@Nonnull final IMicroDocument aDoc,
                                                    @Nonnull @Nonempty final String sFilename,
                                                    @Nonnull final IMicroElement eBindings)
  {
    final ICommonsSet <String> aUsedNames = new CommonsHashSet <> ();
    final ICommonsNavigableMap <String, String> aValueToConstants = new CommonsTreeMap <> ();
    final IMicroElement eSimpleType = aDoc.getDocumentElement ().getFirstChildElement ();

    final IMicroElement eInnerBindings = eBindings.appendElement (JAXB_NS_URI, "bindings")
                                                  .setAttribute ("node",
                                                                 "xsd:simpleType[@name='" +
                                                                         eSimpleType.getAttributeValue ("name") +
                                                                         "']");
    final IMicroElement eTypesafeEnumClass = eInnerBindings.appendElement (JAXB_NS_URI, "typesafeEnumClass");

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

      eTypesafeEnumClass.appendElement (JAXB_NS_URI, "typesafeEnumMember")
                        .setAttribute ("value", sValue)
                        .setAttribute ("name", sCodeName);
      aValueToConstants.put (sValue, sCodeName);
    }

    // Write out the mapping file for easy later-on resolving
    XMLMapHandler.writeMap (aValueToConstants,
                            new FileSystemResource ("src/main/resources/schemas/" + sFilename + ".mapping"));
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
        final String sBasePath = "/resources/schemas/ubl20/" + sPart;
        for (final File aFile : _getFileList ("src/main" + sBasePath))
        {
          // Each namespace should handled only once
          final IMicroDocument aDoc = MicroReader.readMicroXML (new FileSystemResource (aFile));
          final String sTargetNamespace = _getTargetNamespace (aDoc);
          if (!aNamespaces.add (sTargetNamespace))
          {
            System.out.println ("Ignored " + sTargetNamespace + " in " + aFile.getName ());
            continue;
          }
          final String sPackageName = _convertToPackage (sTargetNamespace);
          // schemaLocation must be relative to bindings file!
          final IMicroElement eBindings = eDoc.getDocumentElement ()
                                              .appendElement (JAXB_NS_URI, "bindings")
                                              .setAttribute ("schemaLocation",
                                                             ".." + sBasePath + "/" + aFile.getName ())
                                              .setAttribute ("node", "/xsd:schema");

          eBindings.appendElement (JAXB_NS_URI, "schemaBindings")
                   .appendElement (JAXB_NS_URI, "package")
                   .setAttribute ("name", sPackageName);

          if (aFile.getName ().equals ("CodeList_UnitCode_UNECE_7_04.xsd") ||
              aFile.getName ().equals ("CodeList_LanguageCode_ISO_7_04.xsd"))
          {
            _generateExplicitEnumMapping (aDoc, aFile.getName (), eBindings);
          }
        }
      }
      MicroWriter.writeToFile (eDoc,
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
                                                       .setPutNamespaceContextPrefixesInRoot (true));
    }

    System.out.println ("Done");
  }
}
