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
import javax.annotation.concurrent.NotThreadSafe;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.namespace.NamespaceContext;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.debug.GlobalDebug;
import com.helger.commons.io.resource.IWritableResource;
import com.helger.commons.io.stream.StreamHelper;
import com.helger.commons.state.ESuccess;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.xml.XMLFactory;
import com.helger.commons.xml.transform.ResourceStreamResult;
import com.helger.commons.xml.transform.StringStreamResult;
import com.helger.jaxb.JAXBMarshallerHelper;
import com.helger.jaxb.validation.LoggingValidationEventHandler;
import com.helger.ubl.api.IUBLDocumentType;

/**
 * Abstract builder class for writing UBL documents.
 *
 * @author Philip Helger
 * @param <T>
 *          The UBL implementation class to be written
 * @param <IMPLTYPE>
 *          The implementation class implementing this abstract class.
 */
@NotThreadSafe
public abstract class AbstractUBLWriterBuilder <T, IMPLTYPE extends AbstractUBLWriterBuilder <T, IMPLTYPE>>
                                               extends AbstractWritingUBLBuilder <T, IMPLTYPE>
{
  private static final Logger s_aLogger = LoggerFactory.getLogger (AbstractUBLWriterBuilder.class);

  protected ValidationEventHandler m_aEventHandler = UBLBuilderDefaultSettings.getDefaultValidationEventHandler ();
  protected NamespaceContext m_aNSContext = UBLBuilderDefaultSettings.getDefaultNamespaceContext ();

  public AbstractUBLWriterBuilder (@Nonnull final IUBLDocumentType aDocType)
  {
    super (aDocType);
  }

  /**
   * @return The special JAXB validation event handler to be used. By default
   *         {@link UBLBuilderDefaultSettings#getDefaultValidationEventHandler()}
   *         is used.
   */
  @Nullable
  public ValidationEventHandler getValidationEventHandler ()
  {
    return m_aEventHandler;
  }

  /**
   * Set the JAXB validation event handler to be used. May be <code>null</code>.
   *
   * @param aEventHandler
   *          The event handler to be used. May be <code>null</code>.
   * @return this for chaining
   */
  @Nonnull
  public IMPLTYPE setValidationEventHandler (@Nullable final ValidationEventHandler aEventHandler)
  {
    m_aEventHandler = aEventHandler;
    return thisAsT ();
  }

  /**
   * @return The special JAXB namespace context to be used. By default
   *         {@link UBLBuilderDefaultSettings#getDefaultNamespaceContext()} is
   *         used.
   */
  @Nullable
  public NamespaceContext getNamespaceContext ()
  {
    return m_aNSContext;
  }

  /**
   * Set the namespace context (prefix to namespace URL mapping) to be used.
   *
   * @param aNSContext
   *          The namespace context to be used. May be <code>null</code>.
   * @return this for chaining
   */
  @Nonnull
  public IMPLTYPE setNamespaceContext (@Nullable final NamespaceContext aNSContext)
  {
    m_aNSContext = aNSContext;
    return thisAsT ();
  }

  /**
   * Convert the passed UBL document to a DOM {@link Document}.
   *
   * @param aUBLDocument
   *          The source object to write. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public Document writeToDocument (@Nonnull final T aUBLDocument)
  {
    final Document aDoc = XMLFactory.newDocument ();
    final DOMResult aResult = new DOMResult (aDoc);
    return write (aUBLDocument, aResult).isSuccess () ? aDoc : null;
  }

  /**
   * Convert the passed UBL document to a String.
   *
   * @param aUBLDocument
   *          The source object to write. May not be <code>null</code>.
   * @return The created String or <code>null</code> in case of conversion error
   */
  @Nullable
  public String writeToString (@Nonnull final T aUBLDocument)
  {
    final StringStreamResult aResult = new StringStreamResult ();
    return write (aUBLDocument, aResult).isSuccess () ? aResult.getAsString () : null;
  }

  /**
   * Convert the passed UBL document to a custom {@link File}.
   *
   * @param aUBLDocument
   *          The source object to write. May not be <code>null</code>.
   * @param aResult
   *          The result file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public ESuccess write (@Nonnull final T aUBLDocument, @Nonnull final File aResult)
  {
    return write (aUBLDocument, new StreamResult (aResult));
  }

  /**
   * Convert the passed UBL document to a custom {@link OutputStream}.
   *
   * @param aUBLDocument
   *          The source object to write. May not be <code>null</code>.
   * @param aResult
   *          The result stream to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
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

  /**
   * Convert the passed UBL document to a custom {@link IWritableResource}.
   *
   * @param aUBLDocument
   *          The source object to write. May not be <code>null</code>.
   * @param aResult
   *          The result resource to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public ESuccess write (@Nonnull final T aUBLDocument, @Nonnull final IWritableResource aResult)
  {
    return write (aUBLDocument, new ResourceStreamResult (aResult));
  }

  @Override
  @Nonnull
  protected Marshaller createMarshaller () throws JAXBException
  {
    final Marshaller aMarshaller = super.createMarshaller ();

    if (m_aEventHandler != null)
      aMarshaller.setEventHandler (m_aEventHandler);
    else
      aMarshaller.setEventHandler (new LoggingValidationEventHandler (aMarshaller.getEventHandler ()));

    if (m_aNSContext != null)
      try
      {
        JAXBMarshallerHelper.setSunNamespacePrefixMapper (aMarshaller, m_aNSContext);
      }
      catch (final Throwable t)
      {
        // Might be an IllegalArgumentException or a NoClassDefFoundError
        s_aLogger.error ("Failed to set the namespace context " +
                         m_aNSContext +
                         ": " +
                         t.getClass ().getName () +
                         " -- " +
                         t.getMessage (),
                         GlobalDebug.isDebugMode () ? t.getCause () : null);
      }

    return aMarshaller;
  }

  /**
   * Convert the passed UBL document to a custom {@link Result}.
   *
   * @param aUBLDocument
   *          The source object to write. May not be <code>null</code>.
   * @param aResult
   *          The result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public ESuccess write (@Nonnull final T aUBLDocument, @Nonnull final Result aResult)
  {
    ValueEnforcer.notNull (aUBLDocument, "UBLDocument");
    ValueEnforcer.notNull (aResult, "Result");

    // Avoid class cast exception later on
    if (!m_aDocType.getPackage ().equals (aUBLDocument.getClass ().getPackage ()))
    {
      s_aLogger.error ("You cannot write a '" +
                       aUBLDocument.getClass () +
                       "' as a " +
                       m_aDocType.getPackage ().getName ());
      return ESuccess.FAILURE;
    }

    try
    {
      final Marshaller aMarshaller = createMarshaller ();

      // Customize on demand
      customizeMarshaller (aMarshaller);

      // start marshalling
      final JAXBElement <?> aJAXBElement = _createJAXBElement (m_aDocType.getQName (), aUBLDocument);
      aMarshaller.marshal (aJAXBElement, aResult);
      return ESuccess.SUCCESS;
    }
    catch (final MarshalException ex)
    {
      s_aLogger.error ("Marshal exception writing UBL document", ex);
    }
    catch (final JAXBException ex)
    {
      s_aLogger.warn ("JAXB Exception writing UBL document", ex);
    }
    return ESuccess.FAILURE;
  }

  @Override
  public String toString ()
  {
    return ToStringGenerator.getDerived (super.toString ())
                            .append ("EventHandler", m_aEventHandler)
                            .append ("NamespaceContext", m_aNSContext)
                            .toString ();
  }
}
