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
package com.helger.ublpe;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.jaxb.builder.JAXBWriterBuilder;
import com.helger.xml.namespace.MapBasedNamespaceContext;

/**
 * A writer builder for UBLPE documents.
 *
 * @author Philip Helger
 * @param <JAXBTYPE>
 *        The UBLPE implementation class to be read
 */
@NotThreadSafe
public class UBLPEWriterBuilder <JAXBTYPE> extends JAXBWriterBuilder <JAXBTYPE, UBLPEWriterBuilder <JAXBTYPE>>
{
  public UBLPEWriterBuilder (@Nonnull final EUBLPEDocumentType eDocType)
  {
    super (eDocType);

    // Create a special namespace context for the passed document type
    final MapBasedNamespaceContext aNSContext = new MapBasedNamespaceContext ();
    aNSContext.addMappings (new UBLPENamespaceContext ());
    aNSContext.addDefaultNamespaceURI (m_aDocType.getNamespaceURI ());
    setNamespaceContext (aNSContext);
  }

  public UBLPEWriterBuilder (@Nonnull final Class <JAXBTYPE> aClass)
  {
    this (UBLPEDocumentTypes.getDocumentTypeOfImplementationClass (aClass));
  }

  /**
   * Create a new writer builder.
   *
   * @param aClass
   *        The UBL class to be written. May not be <code>null</code>.
   * @return The new writer builder. Never <code>null</code>.
   * @param <T>
   *        The UBLPE document implementation type
   */
  @Nonnull
  public static <T> UBLPEWriterBuilder <T> create (@Nonnull final Class <T> aClass)
  {
    return new UBLPEWriterBuilder <> (aClass);
  }
}
