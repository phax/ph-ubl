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

import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.base.array.ArrayHelper;
import com.helger.base.string.StringHelper;
import com.helger.base.string.StringImplode;
import com.helger.base.string.StringReplace;
import com.helger.base.url.URLHelper;
import com.helger.cache.regex.RegExHelper;
import com.helger.collection.helper.CollectionSort;
import com.helger.io.file.FileSystemIterator;
import com.helger.io.file.IFileFilter;
import com.helger.xml.CXML;
import com.helger.xml.microdom.IMicroDocument;

/**
 * Base class for internal code generation.
 *
 * @author Philip Helger
 */
public abstract class AbstractUBLCodeGen
{
  @NonNull
  protected static String lcFirst (@NonNull final String s)
  {
    return s.substring (0, 1).toLowerCase (Locale.ROOT) + s.substring (1);
  }

  @NonNull
  protected static String toUpperCase (@NonNull final String sCC)
  {
    final StringBuilder ret = new StringBuilder (sCC.length () * 2);
    for (int i = 0; i < sCC.length (); ++i)
    {
      final char cSrc = sCC.charAt (i);
      final char cUp = Character.toUpperCase (cSrc);
      if (cSrc == cUp && i > 0)
        ret.append ('_');
      ret.append (cUp);
    }
    return ret.toString ();
  }

  @NonNull
  protected static String getDisplayNameFromType (@NonNull final String s)
  {
    final StringBuilder ret = new StringBuilder ();
    for (final char c : s.toCharArray ())
    {
      if (Character.isUpperCase (c) && ret.length () > 0)
        ret.append (' ');
      ret.append (c);
    }
    return ret.toString ();
  }

  @NonNull
  protected static Iterable <File> getXSDFileList (final String sPath)
  {
    return CollectionSort.getSorted (new FileSystemIterator (sPath).withFilter (IFileFilter.filenameEndsWith (".xsd"))
                                                                   .withFilter (IFileFilter.filenameMatchNoRegEx (".*CCTS.*",
                                                                                                                  ".*xmldsig.*",
                                                                                                                  ".*XAdES.*")),
                                     Comparator.comparing (File::getName));
  }

  @Nullable
  protected static String getTargetNamespace (@NonNull final IMicroDocument aDoc)
  {
    return aDoc.getDocumentElement ().getAttributeValue (CXML.XML_ATTR_XSD_TARGETNAMESPACE);
  }

  @NonNull
  protected static String getAsPackageName (@NonNull final String sNamespaceURI)
  {
    // Lowercase everything
    String s = sNamespaceURI.toLowerCase (Locale.ROOT);

    String [] aParts;
    final URL aURL = URLHelper.getAsURL (sNamespaceURI, false);
    if (aURL != null)
    {
      // Host
      String sHost = aURL.getHost ();

      // Kick static prefix: www.helger.com -> helger.com
      sHost = StringHelper.trimStart (sHost, "www.");

      // Reverse domain: helger.com -> com.helger
      final List <String> x = StringHelper.getExploded ('.', sHost);
      Collections.reverse (x);

      // Path in regular order:
      final String sPath = StringHelper.trimStart (aURL.getPath (), '/');
      x.addAll (StringHelper.getExploded ('/', sPath));

      // Convert to array
      aParts = ArrayHelper.createArray (x, String.class);
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
      s = StringReplace.replaceAll (s, ':', '.');
      s = StringReplace.replaceAll (s, '-', '_');
      aParts = StringHelper.getExplodedArray ('.', s);
    }

    // Split into pieces and replace all illegal package parts (e.g. only
    // numeric) with valid ones
    for (int i = 0; i < aParts.length; ++i)
      aParts[i] = RegExHelper.getAsIdentifier (aParts[i]);

    return StringImplode.imploder ().source (aParts).separator ('.').build ();
  }
}
