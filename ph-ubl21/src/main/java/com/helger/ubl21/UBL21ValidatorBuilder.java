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

import com.helger.commons.ValueEnforcer;
import com.helger.commons.error.IResourceErrorGroup;
import com.helger.ubl.api.builder.AbstractUBLWriterBuilder;

/**
 * A writer builder for UBL 2.0 documents.
 *
 * @author Philip Helger
 */
public class UBL21ValidatorBuilder extends AbstractUBLWriterBuilder <UBL21ValidatorBuilder>
{
  public UBL21ValidatorBuilder (@Nonnull final EUBL21DocumentType eDocType)
  {
    super (eDocType);
  }

  @Nonnull
  public IResourceErrorGroup validate (@Nonnull final Object aUBLDocument)
  {
    ValueEnforcer.notNull (aUBLDocument, "UBLDocument");
    return UBL21Marshaller.validateUBLObject (aUBLDocument, m_aClassLoader, (EUBL21DocumentType) m_aDocType);
  }
}
