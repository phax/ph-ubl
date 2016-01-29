/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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
package com.helger.ubl.api;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.lang.ClassHelper;
import com.helger.commons.string.StringHelper;
import com.helger.commons.xml.schema.XMLSchemaCache;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Standalone implementation of {@link IUBLDocumentType}
 *
 * @author Philip Helger
 */
public class UBLDocumentType implements IUBLDocumentType
{
  private final Class <?> m_aClass;
  private final String m_sLocalName;
  private final String m_sNamespaceURI;
  private final QName m_aQName;
  private final String m_sXSDPath;
  private Schema m_aSchema;

  /**
   * Constructor
   *
   * @param aClass
   *        The JAXB generated class of the root element.
   * @param sXSDPath
   *        The classpath relative path to the XML Schema.
   */
  public UBLDocumentType (@Nonnull final Class <?> aClass, @Nonnull final String sXSDPath)
  {
    ValueEnforcer.notNull (aClass, "Class");
    ValueEnforcer.notEmpty (sXSDPath, "XSDPath");

    // Check whether it is an @XmlType class
    final XmlType aXmlType = aClass.getAnnotation (XmlType.class);
    if (aXmlType == null)
      throw new IllegalArgumentException ("The passed class does not have an @XMLType annotation!");

    // Get the package of the passed Class
    final Package aPackage = aClass.getPackage ();

    // The package must have the annotation "XmlSchema" with the corresponding
    // namespace it supports
    final XmlSchema aXmlSchema = aPackage.getAnnotation (XmlSchema.class);
    if (aXmlSchema == null)
      throw new IllegalArgumentException ("The package '" + aPackage.getName () + "' has no @XmlSchema annotation!");

    // Hack: build the element name from the type, excluding the "Type" at the
    // end
    String sLocalName = ClassHelper.getClassLocalName (aClass);
    sLocalName = sLocalName.substring (0, sLocalName.length () - "Type".length ());

    m_aClass = aClass;
    m_sLocalName = sLocalName;
    m_sNamespaceURI = aXmlSchema.namespace ();
    if (StringHelper.hasNoText (m_sNamespaceURI))
      throw new IllegalArgumentException ("The package '" +
                                          aPackage.getName () +
                                          "' has no namespace in the @XmlSchema annotation!");
    m_aQName = new QName (m_sNamespaceURI, sLocalName);
    m_sXSDPath = sXSDPath;
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aClass;
  }

  @Nonnull
  public Package getPackage ()
  {
    return m_aClass.getPackage ();
  }

  @Nonnull
  public String getLocalName ()
  {
    return m_sLocalName;
  }

  @Nonnull
  public String getNamespaceURI ()
  {
    return m_sNamespaceURI;
  }

  @Nonnull
  public QName getQName ()
  {
    return m_aQName;
  }

  @Nonnull
  public String getXSDPath ()
  {
    return m_sXSDPath;
  }

  @Nonnull
  @SuppressFBWarnings ("RCN_REDUNDANT_NULLCHECK_OF_NONNULL_VALUE")
  public Schema getSchema (@Nullable final ClassLoader aClassLoader)
  {
    if (m_aSchema == null)
    {
      // Lazy initialization
      final IReadableResource aXSDRes = getXSDResource (aClassLoader);
      m_aSchema = XMLSchemaCache.getInstanceOfClassLoader (aClassLoader).getSchema (aXSDRes);
      if (m_aSchema == null)
        throw new IllegalStateException ("Failed to create Schema from " +
                                         aXSDRes +
                                         " using class loader " +
                                         aClassLoader);
    }
    return m_aSchema;
  }
}
