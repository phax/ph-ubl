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
package com.helger.ubl.api.builder;

import javax.annotation.Nonnull;

import com.helger.commons.error.IResourceErrorGroup;
import com.helger.ubl.api.IUBLDocumentType;

/**
 * Abstract builder class for validating UBL documents.
 *
 * @author Philip Helger
 * @param <T>
 *          The UBL implementation class to be read
 * @param <IMPLTYPE>
 *          The implementation class implementing this abstract class.
 */
public abstract class AbstractUBLValidationBuilder <T, IMPLTYPE extends AbstractUBLValidationBuilder <T, IMPLTYPE>>
                                                   extends AbstractUBLBuilder <IMPLTYPE>
{
  public AbstractUBLValidationBuilder (@Nonnull final IUBLDocumentType aDocType)
  {
    super (aDocType);
  }

  public boolean isValid (@Nonnull final T aUBLDocument)
  {
    return validate (aUBLDocument).containsNoError ();
  }

  @Nonnull
  public abstract IResourceErrorGroup validate (@Nonnull T aUBLDocument);
}
