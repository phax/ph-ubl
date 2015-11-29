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
package com.helger.ubl20;

import javax.annotation.Nonnull;

import com.helger.ubl.api.builder.AbstractUBLReaderBuilder;

/**
 * A reader builder for UBL 2.0 documents.
 *
 * @author Philip Helger
 * @param <T>
 *          The UBL 2.0 implementation class to be read
 */
public class UBL20ReaderBuilder <T> extends AbstractUBLReaderBuilder <T, UBL20ReaderBuilder <T>>
{
  public UBL20ReaderBuilder (@Nonnull final Class <T> aClass)
  {
    super (UBL20DocumentTypes.getDocumentTypeOfImplementationClass (aClass), aClass);
  }

  /**
   * Create a new reader builder.
   *
   * @param aClass
   *          The UBL class to be read. May not be <code>null</code>.
   * @return The new reader builder. Never <code>null</code>.
   */
  @Nonnull
  public static <T> UBL20ReaderBuilder <T> create (@Nonnull final Class <T> aClass)
  {
    return new UBL20ReaderBuilder <T> (aClass);
  }
}
