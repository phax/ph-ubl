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
import javax.annotation.Nullable;
import javax.xml.transform.Source;

import org.w3c.dom.Node;

import com.helger.commons.ValueEnforcer;
import com.helger.ubl.api.AbstractUBLDocumentMarshaller;
import com.helger.ubl.api.builder.AbstractUBLReaderBuilder;

/**
 * A reader builder for UBL 2.0 documents.
 *
 * @author Philip Helger
 * @param <T>
 *          The UBL 2.0 implementation class to be read
 */
public class UBL21ReaderBuilder <T> extends AbstractUBLReaderBuilder <UBL21ReaderBuilder <T>>
{
  private final Class <T> m_aClass;

  public UBL21ReaderBuilder (@Nonnull final Class <T> aClass)
  {
    super (UBL21DocumentTypes.getDocumentTypeOfImplementationClass (aClass));
    m_aClass = ValueEnforcer.notNull (aClass, "Class");

    // Set global event handler
    setValidationEventHandler (AbstractUBLDocumentMarshaller.getGlobalValidationEventHandler ());
  }

  @Nullable
  public T read (@Nonnull final Source aSource)
  {
    ValueEnforcer.notNull (aSource, "Source");
    return UBL21Marshaller.readUBLDocument (aSource, m_aClassLoader, m_aClass, m_aEventHandler);
  }

  @Nullable
  public T read (@Nonnull final Node aNode)
  {
    ValueEnforcer.notNull (aNode, "Node");
    return UBL21Marshaller.readUBLDocument (aNode, m_aClassLoader, m_aClass, m_aEventHandler);
  }
}
