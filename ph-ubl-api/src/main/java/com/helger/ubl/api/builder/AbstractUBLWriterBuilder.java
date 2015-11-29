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
import javax.annotation.Nullable;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.namespace.NamespaceContext;

import com.helger.ubl.api.IUBLDocumentType;

/**
 * Abstract builder class for writing UBL documents.
 *
 * @author Philip Helger
 * @param <IMPLTYPE>
 *          The implementation class implementing this abstract class.
 */
public abstract class AbstractUBLWriterBuilder <IMPLTYPE extends AbstractUBLWriterBuilder <IMPLTYPE>>
                                               extends AbstractUBLBuilder <IMPLTYPE>
{
  protected ValidationEventHandler m_aEventHandler;
  protected NamespaceContext m_aNSContext;

  public AbstractUBLWriterBuilder (@Nonnull final IUBLDocumentType aDocType)
  {
    super (aDocType);
  }

  /**
   * Set the JAXB validation event handler to be used. May be <code>null</code>.
   *
   * @param aEventHandler
   *          The event handler to be used. May be <code>null</code>.
   * @return this
   */
  @Nonnull
  public IMPLTYPE setValidationEventHandler (@Nullable final ValidationEventHandler aEventHandler)
  {
    m_aEventHandler = aEventHandler;
    return thisAsT ();
  }

  @Nonnull
  public IMPLTYPE setNamespaceContext (@Nullable final NamespaceContext aNSContext)
  {
    m_aNSContext = aNSContext;
    return thisAsT ();
  }
}
