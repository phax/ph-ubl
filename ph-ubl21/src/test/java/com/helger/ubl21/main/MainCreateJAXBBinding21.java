/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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
package com.helger.ubl21.main;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.XMLConstants;

import com.helger.commons.collection.ArrayHelper;
import com.helger.commons.collection.CollectionHelper;
import com.helger.commons.io.file.ComparatorFileName;
import com.helger.commons.io.file.FileHelper;
import com.helger.commons.io.file.filter.FileFilterFilenameEndsWith;
import com.helger.commons.io.file.iterate.FileSystemIterator;
import com.helger.commons.io.resource.FileSystemResource;
import com.helger.commons.microdom.IMicroDocument;
import com.helger.commons.microdom.IMicroElement;
import com.helger.commons.microdom.MicroDocument;
import com.helger.commons.microdom.serialize.MicroReader;
import com.helger.commons.microdom.serialize.MicroWriter;
import com.helger.commons.regex.RegExHelper;
import com.helger.commons.string.StringHelper;
import com.helger.commons.url.URLHelper;
import com.helger.commons.xml.CXML;
import com.helger.commons.xml.namespace.MapBasedNamespaceContext;
import com.helger.commons.xml.serialize.write.EXMLIncorrectCharacterHandling;
import com.helger.commons.xml.serialize.write.XMLWriterSettings;

/**
 * Utility class that creates:
 * <ul>
 * <li>src/main/jaxb/bindings21.xjb - the JAXB binding file</li>
 * </ul>
 *
 * @author Philip Helger
 */
public final class MainCreateJAXBBinding21
{
  private static final String JAXB_NS_URI = "http://java.sun.com/xml/ns/jaxb";
  private static final String BASE_XSD_PATH = "/resources/schemas/ubl21/";
  private static final String DEFAULT_BINDING_FILE = "src/main/jaxb/bindings21.xjb";

  @Nonnull
  private static IMicroDocument _createBaseDoc ()
  {
    final IMicroDocument eDoc = new MicroDocument ();
    final IMicroElement eRoot = eDoc.appendElement (JAXB_NS_URI, "bindings");
    eRoot.setAttribute ("xsi:schemaLocation", JAXB_NS_URI + " http://java.sun.com/xml/ns/jaxb/bindingschema_2_0.xsd");
    eRoot.setAttribute ("version", "2.1");

    final IMicroElement eGlobal = eRoot.appendElement (JAXB_NS_URI, "globalBindings");
    eGlobal.setAttribute ("typesafeEnumMaxMembers", "2000");
    eGlobal.setAttribute ("typesafeEnumMemberName", "generateError");
    return eDoc;
  }

  @Nonnull
  private static Iterable <File> _getFileList (final String sPath)
  {
    return CollectionHelper.getSorted (FileSystemIterator.create (sPath, new FileFilterFilenameEndsWith (".xsd")),
                                       new ComparatorFileName ());
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
      final List <String> x = CollectionHelper.getReverseList (StringHelper.getExploded ('.', sHost));

      // Path in regular order:
      final String sPath = StringHelper.trimStart (aURL.getPath (), "/");
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
      s = s.replace (':', '.').replace ('-', '_');
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
    // UBL 2.1
    {
      System.out.println ("UBL 2.1");
      final IMicroDocument eDoc = _createBaseDoc ();
      final Set <String> aNamespaces = new HashSet <String> ();
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
            System.out.println ("Ignored " + sTargetNamespace + " in " + aFile.getName ());
            continue;
          }
          String sPackageName = _convertToPackage (sTargetNamespace);
          if (sPackageName.endsWith ("_2"))
          {
            // Change "_2" to "_21"
            sPackageName += "1";
          }
          // schemaLocation must be relative to bindings file!
          final IMicroElement eBindings = eDoc.getDocumentElement ()
                                              .appendElement (JAXB_NS_URI, "bindings")
                                              .setAttribute ("schemaLocation",
                                                             ".." + sBasePath + "/" + aFile.getName ())
                                              .setAttribute ("node", "/xsd:schema");
          eBindings.appendElement (JAXB_NS_URI, "schemaBindings")
                   .appendElement (JAXB_NS_URI, "package")
                   .setAttribute ("name", sPackageName);
        }
      }
      MicroWriter.writeToStream (eDoc,
                                 FileHelper.getOutputStream (DEFAULT_BINDING_FILE),
                                 new XMLWriterSettings ().setIncorrectCharacterHandling (EXMLIncorrectCharacterHandling.DO_NOT_WRITE_LOG_WARNING)
                                                         .setNamespaceContext (new MapBasedNamespaceContext ().addMapping (XMLConstants.DEFAULT_NS_PREFIX,
                                                                                                                           JAXB_NS_URI)
                                                                                                              .addMapping ("xsd",
                                                                                                                           CXML.XML_NS_XSD)
                                                                                                              .addMapping ("xsi",
                                                                                                                           CXML.XML_NS_XSI))
                                                         .setPutNamespaceContextPrefixesInRoot (true));
    }

    System.out.println ("Done");
  }
}
