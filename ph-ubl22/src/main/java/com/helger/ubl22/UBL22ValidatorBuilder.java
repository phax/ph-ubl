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
package com.helger.ubl22;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.jaxb.builder.JAXBValidationBuilder;

/**
 * A writer builder for UBL 2.2 documents.
 *
 * @author Philip Helger
 * @param <JAXBTYPE>
 *        The UBL 2.2 implementation class to be read
 * @deprecated Use {@link UBL22Marshaller} instead
 */
@NotThreadSafe
@Deprecated (forRemoval = true, since = "8.0.0")
public class UBL22ValidatorBuilder <JAXBTYPE> extends JAXBValidationBuilder <JAXBTYPE, UBL22ValidatorBuilder <JAXBTYPE>>
{
  public UBL22ValidatorBuilder (@Nonnull final EUBL22DocumentType eDocType)
  {
    super (eDocType);
  }

  public UBL22ValidatorBuilder (@Nonnull final Class <JAXBTYPE> aClass)
  {
    this (UBL22DocumentTypes.getDocumentTypeOfImplementationClass (aClass));
  }

  /**
   * Create a new validation builder.
   *
   * @param aClass
   *        The UBL class to be validated. May not be <code>null</code>.
   * @return The new validation builder. Never <code>null</code>.
   * @param <T>
   *        The UBL 2.2 document implementation type
   */
  @Nonnull
  public static <T> UBL22ValidatorBuilder <T> create (@Nonnull final Class <T> aClass)
  {
    return new UBL22ValidatorBuilder <> (aClass);
  }
}
