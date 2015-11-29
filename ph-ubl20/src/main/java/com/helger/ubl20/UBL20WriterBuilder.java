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
import javax.annotation.Nullable;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;

import org.w3c.dom.Document;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.ESuccess;
import com.helger.commons.xml.XMLFactory;
import com.helger.commons.xml.namespace.MapBasedNamespaceContext;
import com.helger.ubl.api.AbstractUBLDocumentMarshaller;
import com.helger.ubl.api.builder.AbstractUBLWriterBuilder;

/**
 * A writer builder for UBL 2.0 documents.
 *
 * @author Philip Helger
 */
public class UBL20WriterBuilder extends AbstractUBLWriterBuilder <UBL20WriterBuilder>
{
  public UBL20WriterBuilder (@Nonnull final EUBL20DocumentType eDocType)
  {
    super (eDocType);

    // Set global event handler
    setValidationEventHandler (AbstractUBLDocumentMarshaller.getGlobalValidationEventHandler ());

    // Create a special namespace context for the passed document type
    final MapBasedNamespaceContext aNSContext = new MapBasedNamespaceContext ();
    aNSContext.addMappings (UBL20NamespaceContext.getInstance ());
    aNSContext.setDefaultNamespaceURI (eDocType.getNamespaceURI ());
    setNamespaceContext (aNSContext);
  }

  @Nullable
  public Document write (@Nonnull final Object aUBLDocument)
  {
    final Document aDoc = XMLFactory.newDocument ();
    final DOMResult aResult = new DOMResult (aDoc);
    return write (aUBLDocument, aResult).isSuccess () ? aDoc : null;
  }

  @Nonnull
  public ESuccess write (@Nonnull final Object aUBLDocument, @Nonnull final Result aResult)
  {
    ValueEnforcer.notNull (aUBLDocument, "UBLDocument");
    return UBL20Marshaller.writeUBLDocument (aUBLDocument,
                                             m_aClassLoader,
                                             (EUBL20DocumentType) m_aDocType,
                                             m_aEventHandler,
                                             m_aNSContext,
                                             aResult);
  }
}
