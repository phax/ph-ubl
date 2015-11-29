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

import java.io.File;
import java.io.OutputStream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.WillClose;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.namespace.NamespaceContext;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.helger.commons.io.resource.IWritableResource;
import com.helger.commons.io.stream.StreamHelper;
import com.helger.commons.state.ESuccess;
import com.helger.commons.xml.XMLFactory;
import com.helger.commons.xml.transform.ResourceStreamResult;
import com.helger.commons.xml.transform.StringStreamResult;
import com.helger.ubl.api.IUBLDocumentType;

/**
 * Abstract builder class for writing UBL documents.
 *
 * @author Philip Helger
 * @param <T>
 *          The UBL implementation class to be read
 * @param <IMPLTYPE>
 *          The implementation class implementing this abstract class.
 */
public abstract class AbstractUBLWriterBuilder <T, IMPLTYPE extends AbstractUBLWriterBuilder <T, IMPLTYPE>>
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

  @Nullable
  public Document writeToDocument (@Nonnull final T aUBLDocument)
  {
    final Document aDoc = XMLFactory.newDocument ();
    final DOMResult aResult = new DOMResult (aDoc);
    return write (aUBLDocument, aResult).isSuccess () ? aDoc : null;
  }

  @Nullable
  public String writeToString (@Nonnull final T aUBLDocument)
  {
    final StringStreamResult aResult = new StringStreamResult ();
    return write (aUBLDocument, aResult).isSuccess () ? aResult.getAsString () : null;
  }

  @Nonnull
  public ESuccess write (@Nonnull final T aUBLDocument, @Nonnull final File aResult)
  {
    return write (aUBLDocument, new StreamResult (aResult));
  }

  @Nonnull
  public ESuccess write (@Nonnull final T aUBLDocument, @Nonnull @WillClose final OutputStream aResult)
  {
    try
    {
      return write (aUBLDocument, new StreamResult (aResult));
    }
    finally
    {
      StreamHelper.close (aResult);
    }
  }

  @Nonnull
  public ESuccess write (@Nonnull final T aUBLDocument, @Nonnull final IWritableResource aResult)
  {
    return write (aUBLDocument, new ResourceStreamResult (aResult));
  }

  @Nonnull
  public abstract ESuccess write (@Nonnull T aUBLDocument, @Nonnull Result aResult);
}
