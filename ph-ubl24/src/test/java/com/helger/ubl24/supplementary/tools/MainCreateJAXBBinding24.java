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
package com.helger.ubl24.supplementary.tools;

import java.io.File;
import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.XMLConstants;

import com.helger.commons.collection.ArrayHelper;
import com.helger.commons.collection.CollectionHelper;
import com.helger.commons.collection.impl.CommonsHashSet;
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
import com.helger.xml.microdom.MicroQName;
import com.helger.xml.microdom.serialize.MicroReader;
import com.helger.xml.microdom.serialize.MicroWriter;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xml.serialize.write.EXMLIncorrectCharacterHandling;
import com.helger.xml.serialize.write.XMLWriterSettings;

/**
 * Utility class that creates:
 * <ul>
 * <li>src/main/jaxb/bindings24.xjb - the JAXB binding file</li>
 * </ul>
 *
 * @author Philip Helger
 */
public final class MainCreateJAXBBinding24
{
  private static final String JAXB_NS_URI = "https://jakarta.ee/xml/ns/jaxb";
  private static final String XJC_NS_URI = "http://java.sun.com/xml/ns/jaxb/xjc";

  private static final String BASE_XSD_PATH = "/resources/external/schemas/ubl24/";
  private static final String DEFAULT_BINDING_FILE = "src/main/jaxb/bindings24.xjb";

  @Nonnull
  private static IMicroDocument _createBaseDoc ()
  {
    final IMicroDocument eDoc = new MicroDocument ();
    eDoc.appendComment ("This file is generated. Do NOT edit.\n");
    final IMicroElement eRoot = eDoc.appendElement (JAXB_NS_URI, "bindings");
    eRoot.setAttribute (new MicroQName (XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "schemaLocation"),
                        JAXB_NS_URI + " https://jakarta.ee/xml/ns/jaxb/bindingschema_3_0.xsd");
    // This is the JAXB version, not the UBL version :)
    eRoot.setAttribute ("version", "3.0");

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
                                                                     .withFilter (IFileFilter.filenameMatchNoRegEx (".*CCTS.*",
                                                                                                                    ".*xmldsig.*",
                                                                                                                    ".*XAdES.*")),
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
    final URL aURL = URLHelper.getAsURL (sNamespaceURI, false);
    if (aURL != null)
    {
      // Host
      String sHost = aURL.getHost ();

      // Kick static prefix: www.helger.com -> helger.com
      sHost = StringHelper.trimStart (sHost, "www.");

      // Reverse domain: helger.com -> com.helger
      final List <String> x = CollectionHelper.getReverseList (StringHelper.getExploded ('.', sHost));

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

  public static void main (final String [] args)
  {
    // UBL 2.4
    {
      System.out.println ("UBL 2.4");
      final IMicroDocument eDoc = _createBaseDoc ();
      final ICommonsSet <String> aNamespaces = new CommonsHashSet <> ();
      for (final String sPart : new String [] { "common", "maindoc" })
      {
        final String sBasePath = BASE_XSD_PATH + sPart;
        for (final File aFile : _getFileList ("src/main" + sBasePath))
        {
          // Each namespace should handled only once
          final IMicroDocument aDoc = MicroReader.readMicroXML (new FileSystemResource (aFile));
          final String sTargetNamespace = _getTargetNamespace (aDoc);
          if (!aNamespaces.add (sTargetNamespace))
          {
            System.out.println ("Ignored namespace URI '" + sTargetNamespace + "' in '" + aFile.getName () + "'");
            continue;
          }
          String sPackageName = _convertToPackage (sTargetNamespace);
          if (sPackageName.endsWith ("_2"))
          {
            // Change "_2" to "_24"
            sPackageName += "4";
          }
          // schemaLocation must be relative to bindings file!
          final IMicroElement eBindings = eDoc.getDocumentElement ()
                                              .appendElement (JAXB_NS_URI, "bindings")
                                              .setAttribute ("schemaLocation",
                                                             ".." + sBasePath + "/" + aFile.getName ())
                                              .setAttribute ("node", "/xsd:schema");
          eBindings.appendComment ("Target namespace: " + sTargetNamespace);
          eBindings.appendElement (JAXB_NS_URI, "schemaBindings")
                   .appendElement (JAXB_NS_URI, "package")
                   .setAttribute ("name", sPackageName);
        }
      }
      MicroWriter.writeToFile (eDoc,
                               new File (DEFAULT_BINDING_FILE),
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
