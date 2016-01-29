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
package com.helger.ubltr;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.ubl.api.builder.AbstractUBLReaderBuilder;
import com.helger.ubl21.EUBL21DocumentType;
import com.helger.ubl21.UBL21DocumentTypes;

/**
 * A reader builder for UBL 2.1 documents.
 *
 * @author Philip Helger
 * @param <T>
 *          The UBL 2.1 implementation class to be read
 */
@NotThreadSafe
public class UBLTRReaderBuilder <T> extends AbstractUBLReaderBuilder <T, UBLTRReaderBuilder <T>>
{
  public UBLTRReaderBuilder (@Nonnull final EUBL21DocumentType eDocType, @Nonnull final Class <T> aImplClass)
  {
    super (eDocType, aImplClass);
  }

  public UBLTRReaderBuilder (@Nonnull final Class <T> aClass)
  {
    this (UBL21DocumentTypes.getDocumentTypeOfImplementationClass (aClass), aClass);
  }

  /**
   * Create a new reader builder.
   *
   * @param aClass
   *          The UBL class to be read. May not be <code>null</code>.
   * @return The new reader builder. Never <code>null</code>.
   * @param <T>
   *          The UBL 2.1 document implementation type
   */
  @Nonnull
  public static <T> UBLTRReaderBuilder <T> create (@Nonnull final Class <T> aClass)
  {
    return new UBLTRReaderBuilder <T> (aClass);
  }

  /**
   * Create a new reader builder that is not typed, because only the document
   * type enumeration value is available.
   *
   * @param eDocType
   *          The UBL 2.1 document type to be read. May not be <code>null</code>
   *          .
   * @return The new reader builder. Never <code>null</code>.
   */
  @Nonnull
  public static UBLTRReaderBuilder <?> createGeneric (@Nonnull final EUBL21DocumentType eDocType)
  {
    return new UBLTRReaderBuilder <Object> (eDocType, Object.class);
  }
}
