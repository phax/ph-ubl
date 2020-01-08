/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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

import com.helger.jaxb.builder.JAXBReaderBuilder;

/**
 * A reader builder for UBLPE documents.
 *
 * @author Philip Helger
 * @param <JAXBTYPE>
 *        The UBLPE implementation class to be read
 */
@NotThreadSafe
public class UBLPEReaderBuilder <JAXBTYPE> extends JAXBReaderBuilder <JAXBTYPE, UBLPEReaderBuilder <JAXBTYPE>>
{
  public UBLPEReaderBuilder (@Nonnull final EUBLPEDocumentType aDocType, @Nonnull final Class <JAXBTYPE> aImplClass)
  {
    super (aDocType, aImplClass);
  }

  public UBLPEReaderBuilder (@Nonnull final Class <JAXBTYPE> aClass)
  {
    this (UBLPEDocumentTypes.getDocumentTypeOfImplementationClass (aClass), aClass);
  }

  /**
   * Create a new reader builder.
   *
   * @param aClass
   *        The UBL class to be read. May not be <code>null</code>.
   * @return The new reader builder. Never <code>null</code>.
   * @param <T>
   *        The UBLPE document implementation type
   */
  @Nonnull
  public static <T> UBLPEReaderBuilder <T> create (@Nonnull final Class <T> aClass)
  {
    return new UBLPEReaderBuilder <> (aClass);
  }

  /**
   * Create a new reader builder that is not typed, because only the document
   * type enumeration value is available.
   *
   * @param eDocType
   *        The UBLPE document type to be read. May not be <code>null</code> .
   * @return The new reader builder. Never <code>null</code>.
   */
  @Nonnull
  public static UBLPEReaderBuilder <?> createGeneric (@Nonnull final EUBLPEDocumentType eDocType)
  {
    return new UBLPEReaderBuilder <> (eDocType, Object.class);
  }
}
