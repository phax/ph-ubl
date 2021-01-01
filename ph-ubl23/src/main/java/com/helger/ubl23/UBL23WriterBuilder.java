/**
 * Copyright (C) 2014-2021 Philip Helger (www.helger.com)
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
package com.helger.ubl23;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.jaxb.builder.JAXBWriterBuilder;
import com.helger.xml.namespace.MapBasedNamespaceContext;

/**
 * A writer builder for UBL 2.3 documents.
 *
 * @author Philip Helger
 * @param <JAXBTYPE>
 *        The UBL 2.3 implementation class to be read
 */
@NotThreadSafe
public class UBL23WriterBuilder <JAXBTYPE> extends JAXBWriterBuilder <JAXBTYPE, UBL23WriterBuilder <JAXBTYPE>>
{
  public UBL23WriterBuilder (@Nonnull final EUBL23DocumentType eDocType)
  {
    super (eDocType);

    // Create a special namespace context for the passed document type
    final MapBasedNamespaceContext aNSContext = UBL23NamespaceContext.getInstance ().getClone ();
    aNSContext.addDefaultNamespaceURI (m_aDocType.getNamespaceURI ());
    setNamespaceContext (aNSContext);
  }

  public UBL23WriterBuilder (@Nonnull final Class <JAXBTYPE> aClass)
  {
    this (UBL23DocumentTypes.getDocumentTypeOfImplementationClass (aClass));
  }

  /**
   * Create a new writer builder.
   *
   * @param aClass
   *        The UBL class to be written. May not be <code>null</code>.
   * @return The new writer builder. Never <code>null</code>.
   * @param <T>
   *        The UBL 2.3 document implementation type
   */
  @Nonnull
  public static <T> UBL23WriterBuilder <T> create (@Nonnull final Class <T> aClass)
  {
    return new UBL23WriterBuilder <> (aClass);
  }
}
