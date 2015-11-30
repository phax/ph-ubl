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
import javax.annotation.concurrent.Immutable;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.UnmarshalException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.validation.Schema;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.helpers.DefaultHandler;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.debug.GlobalDebug;
import com.helger.commons.error.IResourceErrorGroup;
import com.helger.commons.state.ESuccess;
import com.helger.commons.xml.XMLFactory;
import com.helger.commons.xml.XMLHelper;
import com.helger.jaxb.JAXBMarshallerHelper;
import com.helger.jaxb.validation.CollectingValidationEventHandler;
import com.helger.ubl.api.AbstractUBLMarshaller;

/**
 * This is the marshaller for UBL documents.
 *
 * @author Philip Helger
 */
@Immutable
@Deprecated
public final class UBL21Marshaller extends AbstractUBLMarshaller
{
  private static final Logger s_aLogger = LoggerFactory.getLogger (UBL21Marshaller.class);

  @PresentForCodeCoverage
  private static final UBL21Marshaller s_aInstance = new UBL21Marshaller ();

  private UBL21Marshaller ()
  {}

  /**
   * Convert the passed XML node into a domain object.<br>
   * Note: this is the generic API for reading all types of UBL documents.
   * Please refer to {@link UBL21Reader} for a type-safe API for all supported
   * document types.
   *
   * @param aNode
   *          The XML node to be converted. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aDestClass
   *          The UBL class of the result type. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          An optional custom event handler to be used in unmarshalling. May
   *          be <code>null</code>.
   * @return <code>null</code> in case conversion to the specified class failed.
   *         See the log output for details.
   * @param <T>
   *          The UBL document implementation type
   */
  @Nullable
  public static <T> T readUBLDocument (@Nonnull final Node aNode,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nonnull final Class <T> aDestClass,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    ValueEnforcer.notNull (aNode, "Node");
    ValueEnforcer.notNull (aDestClass, "destClass");

    final String sNodeNamespaceURI = XMLHelper.getNamespaceURI (aNode);
    final Class <?> aClass = UBL21DocumentTypes.getImplementationClassOfNamespace (sNodeNamespaceURI);

    // Avoid class cast exception later on
    if (!aDestClass.equals (aClass))
    {
      s_aLogger.error ("You cannot read an '" + sNodeNamespaceURI + "' as a " + aDestClass.getName ());
      return null;
    }

    final Schema aSchema = UBL21DocumentTypes.getSchemaOfNamespace (sNodeNamespaceURI, aClassLoader);
    if (aSchema == null)
      throw new IllegalStateException ("Internal inconsistency. Failed to resolve namespace URI '" +
                                       sNodeNamespaceURI +
                                       "'");

    T ret = null;
    try
    {
      final Unmarshaller aUnmarshaller = createFullUnmarshaller (aClass, aClassLoader, aSchema, aCustomEventHandler);

      // start unmarshalling
      ret = aUnmarshaller.unmarshal (aNode, aDestClass).getValue ();
      if (ret == null)
        throw new IllegalStateException ("Failed to read UBL 2.1 document of class " +
                                         aDestClass.getName () +
                                         " - without exception!");
    }
    catch (final UnmarshalException ex)
    {
      // The JAXB specification does not mandate how the JAXB provider
      // must behave when attempting to unmarshal invalid XML data. In
      // those cases, the JAXB provider is allowed to terminate the
      // call to unmarshal with an UnmarshalException.
      s_aLogger.error ("Unmarshal exception reading UBL 2.1 document", ex);
      return null;
    }
    catch (final JAXBException ex)
    {
      s_aLogger.warn ("JAXB Exception reading UBL 2.1 document", ex);
      return null;
    }

    return ret;
  }

  /**
   * Convert the passed XML node into a domain object.<br>
   * Note: this is the generic API for reading all types of UBL documents.
   * Please refer to {@link UBL21Reader} for a type-safe API for all supported
   * document types.
   *
   * @param aSource
   *          The source object to be converted. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aDestClass
   *          The UBL class of the result type. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          An optional custom event handler to be used in unmarshalling. May
   *          be <code>null</code>.
   * @return <code>null</code> in case conversion to the specified class failed.
   *         See the log output for details.
   * @param <T>
   *          The UBL document implementation type
   */
  @Nullable
  public static <T> T readUBLDocument (@Nonnull final Source aSource,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nonnull final Class <T> aDestClass,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    ValueEnforcer.notNull (aSource, "Source");
    ValueEnforcer.notNull (aDestClass, "DestClass");

    // as we don't have a node, we need to trust the implementation class
    final Schema aSchema = UBL21DocumentTypes.getSchemaOfImplementationClass (aDestClass, aClassLoader);
    if (aSchema == null)
    {
      s_aLogger.error ("Don't know how to read UBL 2.1 object of class " + aDestClass.getName ());
      return null;
    }

    T ret = null;
    try
    {
      final Unmarshaller aUnmarshaller = createFullUnmarshaller (aDestClass,
                                                                 aClassLoader,
                                                                 aSchema,
                                                                 aCustomEventHandler);

      // start unmarshalling
      ret = aUnmarshaller.unmarshal (aSource, aDestClass).getValue ();
      if (ret == null)
        throw new IllegalStateException ("Failed to read UBL 2.1 document of class " +
                                         aDestClass.getName () +
                                         " - without exception!");
    }
    catch (final UnmarshalException ex)
    {
      // The JAXB specification does not mandate how the JAXB provider
      // must behave when attempting to unmarshal invalid XML data. In
      // those cases, the JAXB provider is allowed to terminate the
      // call to unmarshal with an UnmarshalException.
      s_aLogger.error ("Unmarshal exception reading UBL 2.1 document", ex);
      return null;
    }
    catch (final JAXBException ex)
    {
      s_aLogger.warn ("JAXB Exception reading UBL 2.1 document", ex);
      return null;
    }

    return ret;
  }

  @Nonnull
  private static Marshaller _createFullMarshaller (@Nonnull final Class <?> aClass,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final Schema aSchema,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nullable final NamespaceContext aNSContext) throws JAXBException
  {
    // Create a generic marshaller
    final Marshaller aMarshaller = createBasicMarshaller (aClass, aClassLoader, aSchema, aCustomEventHandler);

    if (aNSContext != null)
      try
      {
        JAXBMarshallerHelper.setSunNamespacePrefixMapper (aMarshaller, aNSContext);
      }
      catch (final Throwable t)
      {
        // Might be an IllegalArgumentException or a NoClassDefFoundError
        s_aLogger.error ("Failed to set the namespace context " +
                         aNSContext +
                         ": " +
                         t.getClass ().getName () +
                         " -- " +
                         t.getMessage (),
                         GlobalDebug.isDebugMode () ? t.getCause () : null);
      }

    return aMarshaller;
  }

  @SuppressWarnings ("unchecked")
  @Nonnull
  private static JAXBElement <?> _createJAXBElement (@Nonnull final QName aQName, @Nonnull final Object aValue)
  {
    return new JAXBElement <Object> (aQName, (Class <Object>) aValue.getClass (), null, aValue);
  }

  /**
   * Convert the passed domain object into an XML node.<br>
   * Note: this is the generic API for writing all types of UBL documents.
   * Please refer to {@link UBL21Writer} for a type-safe API for all supported
   * document types.
   *
   * @param aUBLDocument
   *          The domain object to be converted. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param eDocType
   *          The UBL document type matching the document. May not be
   *          <code>null</code>.
   * @param aCustomEventHandler
   *          An optional custom event handler to be used in marshalling. May be
   *          null.
   * @return <code>null</code> in case conversion to the specified class failed.
   *         See the log output for details.
   */
  @Nullable
  public static Document writeUBLDocument (@Nonnull final Object aUBLDocument,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final EUBL21DocumentType eDocType,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return writeUBLDocument (aUBLDocument,
                             aClassLoader,
                             eDocType,
                             aCustomEventHandler,
                             UBL21NamespaceContext.getInstance ());
  }

  /**
   * Convert the passed domain object into an XML node.<br>
   * Note: this is the generic API for writing all types of UBL documents.
   * Please refer to {@link UBL21Writer} for a type-safe API for all supported
   * document types.
   *
   * @param aUBLDocument
   *          The domain object to be converted. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param eDocType
   *          The UBL document type matching the document. May not be
   *          <code>null</code>.
   * @param aCustomEventHandler
   *          An optional custom event handler to be used in marshalling. May be
   *          null.
   * @param aNSContext
   *          The namespace context to be used. May be <code>null</code>.
   * @return <code>null</code> in case conversion to the specified class failed.
   *         See the log output for details.
   */
  @Nullable
  public static Document writeUBLDocument (@Nonnull final Object aUBLDocument,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final EUBL21DocumentType eDocType,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nullable final NamespaceContext aNSContext)
  {
    final Document aDoc = XMLFactory.newDocument ();
    final DOMResult aResult = new DOMResult (aDoc);
    return writeUBLDocument (aUBLDocument,
                             aClassLoader,
                             eDocType,
                             aCustomEventHandler,
                             aNSContext,
                             aResult).isSuccess () ? aDoc : null;
  }

  /**
   * Convert the passed domain object into an XML node.<br>
   * Note: this is the generic API for writing all types of UBL documents.
   * Please refer to {@link UBL21Writer} for a type-safe API for all supported
   * document types.
   *
   * @param aUBLDocument
   *          The domain object to be converted. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param eDocType
   *          The UBL document type matching the document. May not be
   *          <code>null</code>.
   * @param aCustomEventHandler
   *          An optional custom event handler to be used in marshalling. May be
   *          <code>null</code>.
   * @param aResult
   *          the result object to write the marshaled document to. May not be
   *          <code>null</code>.
   * @return {@link ESuccess#FAILURE} in case conversion to the specified class
   *         failed.
   */
  @Nonnull
  public static ESuccess writeUBLDocument (@Nonnull final Object aUBLDocument,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final EUBL21DocumentType eDocType,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return writeUBLDocument (aUBLDocument,
                             aClassLoader,
                             eDocType,
                             aCustomEventHandler,
                             UBL21NamespaceContext.getInstance (),
                             aResult);
  }

  /**
   * Convert the passed domain object into an XML node.<br>
   * Note: this is the generic API for writing all types of UBL documents.
   * Please refer to {@link UBL21Writer} for a type-safe API for all supported
   * document types.
   *
   * @param aUBLDocument
   *          The domain object to be converted. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param eDocType
   *          The UBL document type matching the document. May not be
   *          <code>null</code>.
   * @param aCustomEventHandler
   *          An optional custom event handler to be used in marshalling. May be
   *          <code>null</code>.
   * @param aNSContext
   *          The namespace context to be used. May be <code>null</code>.
   * @param aResult
   *          the result object to write the marshaled document to. May not be
   *          <code>null</code>.
   * @return {@link ESuccess#FAILURE} in case conversion to the specified class
   *         failed.
   */
  @Nonnull
  public static ESuccess writeUBLDocument (@Nonnull final Object aUBLDocument,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final EUBL21DocumentType eDocType,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nullable final NamespaceContext aNSContext,
                                           @Nonnull final Result aResult)
  {
    ValueEnforcer.notNull (aUBLDocument, "UBLDocument");
    ValueEnforcer.notNull (eDocType, "DocType");
    ValueEnforcer.notNull (aResult, "Result");

    // Avoid class cast exception later on
    if (!eDocType.getPackage ().equals (aUBLDocument.getClass ().getPackage ()))
    {
      s_aLogger.error ("You cannot write a '" +
                       aUBLDocument.getClass () +
                       "' as a " +
                       eDocType.getPackage ().getName ());
      return ESuccess.FAILURE;
    }

    try
    {
      final Marshaller aMarshaller = _createFullMarshaller (eDocType.getImplementationClass (),
                                                            aClassLoader,
                                                            eDocType.getSchema (aClassLoader),
                                                            aCustomEventHandler,
                                                            aNSContext);

      // start marshalling
      final JAXBElement <?> aJAXBElement = _createJAXBElement (eDocType.getQName (), aUBLDocument);
      aMarshaller.marshal (aJAXBElement, aResult);
      return ESuccess.SUCCESS;
    }
    catch (final MarshalException ex)
    {
      s_aLogger.error ("Marshal exception writing UBL 2.1 document", ex);
    }
    catch (final JAXBException ex)
    {
      s_aLogger.warn ("JAXB Exception writing UBL 2.1 document", ex);
    }
    return ESuccess.FAILURE;
  }

  /**
   * Validate the passed domain object against the XML Schema rules.<br>
   * Note: this is the generic API for validating all types of UBL documents.
   * Please refer to {@link UBL21Validator} for a type-safe API for all
   * supported document types.
   *
   * @param aUBLDocument
   *          The domain object to be converted. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param eDocType
   *          The UBL document type matching the document. May not be
   *          <code>null</code>.
   * @return Never <code>null</code>.
   */
  @Nonnull
  public static IResourceErrorGroup validateUBLObject (@Nonnull final Object aUBLDocument,
                                                       @Nullable final ClassLoader aClassLoader,
                                                       @Nonnull final EUBL21DocumentType eDocType)
  {
    ValueEnforcer.notNull (aUBLDocument, "UBLDocument");
    ValueEnforcer.notNull (eDocType, "DocType");

    // Avoid class cast exception later on
    if (!eDocType.getPackage ().equals (aUBLDocument.getClass ().getPackage ()))
    {
      throw new IllegalArgumentException ("You cannot validate a '" +
                                          aUBLDocument.getClass () +
                                          "' as a " +
                                          eDocType.getPackage ().getName ());
    }

    // Validating!
    final Schema aSchema = eDocType.getSchema (aClassLoader);

    final CollectingValidationEventHandler aEventHandler = new CollectingValidationEventHandler ();
    try
    {
      // create a Marshaller
      final Marshaller aMarshaller = createBasicMarshaller (eDocType.getImplementationClass (),
                                                            aClassLoader,
                                                            aSchema,
                                                            aEventHandler);

      // start marshalling
      final JAXBElement <?> aJAXBElement = _createJAXBElement (eDocType.getQName (), aUBLDocument);
      // DefaultHandler has very little overhead
      aMarshaller.marshal (aJAXBElement, new DefaultHandler ());
    }
    catch (final JAXBException ex)
    {
      // Should already be contained as an entry in the event handler
    }
    return aEventHandler.getResourceErrors ();
  }
}
