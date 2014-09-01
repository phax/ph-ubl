/**
 * Copyright (C) 2014 Philip Helger (www.helger.com)
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
package com.helger.ubl;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import com.helger.commons.error.IResourceErrorGroup;
import com.helger.commons.io.IReadableResource;
import com.helger.commons.xml.schema.IHasSchema;

/**
 * Base interface describing a single UBL document type, independent of the
 * version.
 *
 * @author Philip Helger
 */
public interface IUBLDocumentType extends IHasSchema, Serializable
{
  /**
   * @return The class implementing this document type. Never <code>null</code>.
   */
  @Nonnull
  Class <?> getImplementationClass ();

  /**
   * @return The package of the implementation class. Never <code>null</code>.
   */
  @Nonnull
  Package getPackage ();

  /**
   * @return The local name of the root element of an XML document of this type.
   *         Corresponds to the name of the implementation class (without a
   *         package).
   */
  @Nonnull
  String getLocalName ();

  /**
   * @return The non-<code>null</code> XML namespace of this UBL document type.
   */
  @Nonnull
  String getNamespaceURI ();

  /**
   * @return The combination of local name and namespace URI matching this
   *         document type. Never <code>null</code>.
   */
  @Nonnull
  QName getQName ();

  /**
   * @return The path within the classpath where the main XSD file resides.
   */
  @Nonnull
  String getXSDPath ();

  /**
   * @return The resource from which the XSD can be read.
   */
  @Nonnull
  IReadableResource getXSDResource ();

  /**
   * @return The non-<code>null</code> compiled {@link Schema} object retrieved
   *         by the {@link com.helger.commons.xml.schema.XMLSchemaCache}.
   */
  @Nonnull
  Schema getSchema ();

  /**
   * @return The non-<code>null</code> compiled {@link Validator} object
   *         retrieved from the schema to be obtained from {@link #getSchema()}.
   */
  @Nonnull
  Validator getValidator ();

  /**
   * Validate the passed XML instance against the XML Schema of this document
   * type.
   *
   * @param aXML
   *          The XML resource to be validated.
   * @return A non-<code>null</code> group of validation errors. Is empty if no
   *         error occurred.
   */
  @Nonnull
  IResourceErrorGroup validateXML (@Nonnull final IReadableResource aXML);
}
