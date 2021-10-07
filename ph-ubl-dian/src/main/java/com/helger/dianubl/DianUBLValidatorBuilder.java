/*
 * Copyright (C) 2020-2021 Philip Helger (www.helger.com)
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
package com.helger.dianubl;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.jaxb.builder.JAXBValidationBuilder;

/**
 * A writer builder for DIAN UBL documents.
 *
 * @author Philip Helger
 * @param <JAXBTYPE>
 *        The DIAN UBL implementation class to be read
 */
@NotThreadSafe
public class DianUBLValidatorBuilder <JAXBTYPE> extends JAXBValidationBuilder <JAXBTYPE, DianUBLValidatorBuilder <JAXBTYPE>>
{
  public DianUBLValidatorBuilder (@Nonnull final EDianUBLDocumentType eDocType)
  {
    super (eDocType);
  }

  public DianUBLValidatorBuilder (@Nonnull final Class <JAXBTYPE> aClass)
  {
    this (DianUBLDocumentTypes.getDocumentTypeOfImplementationClass (aClass));
  }

  /**
   * Create a new validation builder.
   *
   * @param aClass
   *        The UBL class to be validated. May not be <code>null</code>.
   * @return The new validation builder. Never <code>null</code>.
   * @param <T>
   *        The UBLPE document implementation type
   */
  @Nonnull
  public static <T> DianUBLValidatorBuilder <T> create (@Nonnull final Class <T> aClass)
  {
    return new DianUBLValidatorBuilder <> (aClass);
  }
}
