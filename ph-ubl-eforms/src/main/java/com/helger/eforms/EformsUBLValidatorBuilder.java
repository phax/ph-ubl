/*
 * Copyright (C) 2021-2023 Jonatan Sunden
 * Copyright (C) 2021-2023 Philip Helger (www.helger.com)
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
package com.helger.eforms;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.jaxb.builder.JAXBValidationBuilder;

/**
 * eForms XML validator builder
 *
 * @author Jonatan Sunden
 * @author Philip Helger
 * @since 6.7.0
 * @param <JAXBTYPE>
 *        JAXB implementation type
 * @deprecated Use {@link EformsUBLMarshaller} instead
 */
@NotThreadSafe
@Deprecated (forRemoval = true, since = "8.0.0")
public class EformsUBLValidatorBuilder <JAXBTYPE> extends
                                       JAXBValidationBuilder <JAXBTYPE, EformsUBLValidatorBuilder <JAXBTYPE>>
{
  public EformsUBLValidatorBuilder (@Nonnull final EFormsUBLDocumentType eDocType)
  {
    super (eDocType);
  }

  public EformsUBLValidatorBuilder (@Nonnull final Class <JAXBTYPE> aClass)
  {
    this (EformsUBLDocumentTypes.getDocumentTypeOfImplementationClass (aClass));
  }

  @Nonnull
  public static <T> EformsUBLValidatorBuilder <T> create (@Nonnull final Class <T> aClass)
  {
    return new EformsUBLValidatorBuilder <> (aClass);
  }
}
