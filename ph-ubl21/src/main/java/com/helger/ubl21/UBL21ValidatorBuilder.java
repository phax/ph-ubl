/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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
package com.helger.ubl21;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.ubl.api.builder.AbstractUBLValidationBuilder;

/**
 * A writer builder for UBL 2.1 documents.
 *
 * @author Philip Helger
 * @param <T>
 *          The UBL 2.1 implementation class to be read
 */
@NotThreadSafe
public class UBL21ValidatorBuilder <T> extends AbstractUBLValidationBuilder <T, UBL21ValidatorBuilder <T>>
{
  protected UBL21ValidatorBuilder (@Nonnull final EUBL21DocumentType eDocType)
  {
    super (eDocType);
  }

  public UBL21ValidatorBuilder (@Nonnull final Class <T> aClass)
  {
    this (UBL21DocumentTypes.getDocumentTypeOfImplementationClass (aClass));
  }

  /**
   * Create a new validation builder.
   *
   * @param aClass
   *          The UBL class to be validated. May not be <code>null</code>.
   * @return The new validation builder. Never <code>null</code>.
   * @param <T>
   *          The UBL 2.1 document implementation type
   */
  @Nonnull
  public static <T> UBL21ValidatorBuilder <T> create (@Nonnull final Class <T> aClass)
  {
    return new UBL21ValidatorBuilder <T> (aClass);
  }
}
