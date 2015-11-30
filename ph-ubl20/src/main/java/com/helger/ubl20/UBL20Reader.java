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

import java.io.File;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.Source;

import org.w3c.dom.Node;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.xml.transform.TransformSourceFactory;
import com.helger.ubl.api.AbstractUBLDocumentMarshaller;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_2.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.billoflading_2.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.catalogue_2.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_2.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_2.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_2.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_2.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_2.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_2.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_2.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_2.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.order_2.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_2.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_2.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_2.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_2.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_2.PackingListType;
import oasis.names.specification.ubl.schema.xsd.quotation_2.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_2.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_2.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_2.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_2.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_2.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_2.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_2.StatementType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_2.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.waybill_2.WaybillType;

/**
 * Read all UBL 2.0 document types.
 * 
 * @author Philip Helger
 */
@SuppressWarnings ("deprecation")
@NotThreadSafe
public final class UBL20Reader extends AbstractUBLDocumentMarshaller
{
  @PresentForCodeCoverage
  private static final UBL20Reader s_aInstance = new UBL20Reader ();

  private UBL20Reader ()
  {}

  /**
   * Create a reader builder for ApplicationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL20ReaderBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ApplicationResponse using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Node aNode)
  {
    return readApplicationResponse (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ApplicationResponse using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readApplicationResponse (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ApplicationResponse using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Node aNode,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            ApplicationResponseType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ApplicationResponse using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, ApplicationResponseType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ApplicationResponse using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final File aSource)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ApplicationResponse using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a ApplicationResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final File aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ApplicationResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ApplicationResponse
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final IReadableResource aSource)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ApplicationResponse
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ApplicationResponse
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ApplicationResponse
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ApplicationResponse using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Source aSource)
  {
    return readApplicationResponse (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ApplicationResponse using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readApplicationResponse (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ApplicationResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Source aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            ApplicationResponseType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ApplicationResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, ApplicationResponseType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for AttachedDocument.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL20ReaderBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a AttachedDocument using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Node aNode)
  {
    return readAttachedDocument (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a AttachedDocument using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readAttachedDocument (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a AttachedDocument using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Node aNode,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, AttachedDocumentType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a AttachedDocument using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, AttachedDocumentType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a AttachedDocument using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final File aSource)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a AttachedDocument using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final File aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a AttachedDocument using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final File aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a AttachedDocument using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final File aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a AttachedDocument using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final IReadableResource aSource)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a AttachedDocument using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final IReadableResource aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a AttachedDocument using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final IReadableResource aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a AttachedDocument using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final IReadableResource aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a AttachedDocument using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Source aSource)
  {
    return readAttachedDocument (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a AttachedDocument using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readAttachedDocument (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a AttachedDocument using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Source aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            AttachedDocumentType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a AttachedDocument using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, AttachedDocumentType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for BillOfLading.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL20ReaderBuilder.create (BillOfLadingType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a BillOfLading using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Node aNode)
  {
    return readBillOfLading (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a BillOfLading using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readBillOfLading (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a BillOfLading using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Node aNode,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, BillOfLadingType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a BillOfLading using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Node aNode,
                                                   @Nullable ClassLoader aClassLoader,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, BillOfLadingType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a BillOfLading using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final File aSource)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a BillOfLading using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a BillOfLading using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final File aSource,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a BillOfLading using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final File aSource,
                                                   @Nullable ClassLoader aClassLoader,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a BillOfLading using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final IReadableResource aSource)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a BillOfLading using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final IReadableResource aSource,
                                                   @Nullable ClassLoader aClassLoader)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a BillOfLading using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final IReadableResource aSource,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a BillOfLading using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final IReadableResource aSource,
                                                   @Nullable ClassLoader aClassLoader,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a BillOfLading using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Source aSource)
  {
    return readBillOfLading (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a BillOfLading using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readBillOfLading (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a BillOfLading using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Source aSource,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, BillOfLadingType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a BillOfLading using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Source aSource,
                                                   @Nullable ClassLoader aClassLoader,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, BillOfLadingType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for Catalogue.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CatalogueType> catalogue ()
  {
    return UBL20ReaderBuilder.create (CatalogueType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Catalogue using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Node aNode)
  {
    return readCatalogue (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Catalogue using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readCatalogue (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Catalogue using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Node aNode,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, CatalogueType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Catalogue using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Node aNode,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, CatalogueType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Catalogue using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final File aSource)
  {
    return readCatalogue (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Catalogue using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readCatalogue (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a Catalogue using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final File aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogue (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Catalogue using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final File aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogue (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Catalogue using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final IReadableResource aSource)
  {
    return readCatalogue (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Catalogue using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final IReadableResource aSource,
                                             @Nullable ClassLoader aClassLoader)
  {
    return readCatalogue (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Catalogue using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final IReadableResource aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogue (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Catalogue using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final IReadableResource aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogue (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Catalogue using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Source aSource)
  {
    return readCatalogue (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Catalogue using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readCatalogue (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Catalogue using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Source aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, CatalogueType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Catalogue using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Source aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, CatalogueType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for CatalogueDeletion.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL20ReaderBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueDeletion using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Node aNode)
  {
    return readCatalogueDeletion (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueDeletion using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Node aNode,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueDeletion (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueDeletion using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Node aNode,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            CatalogueDeletionType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueDeletion using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Node aNode,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, CatalogueDeletionType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueDeletion using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final File aSource)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CatalogueDeletion using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final File aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueDeletion using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final File aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueDeletion using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final File aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueDeletion using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final IReadableResource aSource)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueDeletion using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final IReadableResource aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueDeletion using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final IReadableResource aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueDeletion using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final IReadableResource aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueDeletion using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Source aSource)
  {
    return readCatalogueDeletion (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueDeletion using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Source aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueDeletion (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueDeletion using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Source aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            CatalogueDeletionType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueDeletion using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Source aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, CatalogueDeletionType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for CatalogueItemSpecificationUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL20ReaderBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueItemSpecificationUpdate
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Node aNode)
  {
    return readCatalogueItemSpecificationUpdate (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueItemSpecificationUpdate
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Node aNode,
                                                                                           @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueItemSpecificationUpdate (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueItemSpecificationUpdate
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Node aNode,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            CatalogueItemSpecificationUpdateType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueItemSpecificationUpdate
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Node aNode,
                                                                                           @Nullable ClassLoader aClassLoader,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            aClassLoader,
                                            CatalogueItemSpecificationUpdateType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueItemSpecificationUpdate
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final File aSource)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CatalogueItemSpecificationUpdate
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final File aSource,
                                                                                           @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueItemSpecificationUpdate
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final File aSource,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueItemSpecificationUpdate
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final File aSource,
                                                                                           @Nullable ClassLoader aClassLoader,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource),
                                                 aClassLoader,
                                                 aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * CatalogueItemSpecificationUpdate using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final IReadableResource aSource)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * CatalogueItemSpecificationUpdate using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final IReadableResource aSource,
                                                                                           @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * CatalogueItemSpecificationUpdate using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final IReadableResource aSource,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * CatalogueItemSpecificationUpdate using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final IReadableResource aSource,
                                                                                           @Nullable ClassLoader aClassLoader,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource),
                                                 aClassLoader,
                                                 aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueItemSpecificationUpdate
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Source aSource)
  {
    return readCatalogueItemSpecificationUpdate (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueItemSpecificationUpdate
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Source aSource,
                                                                                           @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueItemSpecificationUpdate (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueItemSpecificationUpdate
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Source aSource,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            CatalogueItemSpecificationUpdateType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueItemSpecificationUpdate
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Source aSource,
                                                                                           @Nullable ClassLoader aClassLoader,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            CatalogueItemSpecificationUpdateType.class,
                                            aCustomEventHandler);
  }

  /**
   * Create a reader builder for CataloguePricingUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL20ReaderBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CataloguePricingUpdate using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Node aNode)
  {
    return readCataloguePricingUpdate (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CataloguePricingUpdate using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readCataloguePricingUpdate (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CataloguePricingUpdate using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Node aNode,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            CataloguePricingUpdateType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CataloguePricingUpdate using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, CataloguePricingUpdateType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CataloguePricingUpdate using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final File aSource)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CataloguePricingUpdate using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a CataloguePricingUpdate using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final File aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CataloguePricingUpdate using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CataloguePricingUpdate
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final IReadableResource aSource)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CataloguePricingUpdate
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CataloguePricingUpdate
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CataloguePricingUpdate
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CataloguePricingUpdate using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Source aSource)
  {
    return readCataloguePricingUpdate (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CataloguePricingUpdate using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readCataloguePricingUpdate (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CataloguePricingUpdate using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Source aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            CataloguePricingUpdateType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CataloguePricingUpdate using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            CataloguePricingUpdateType.class,
                                            aCustomEventHandler);
  }

  /**
   * Create a reader builder for CatalogueRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL20ReaderBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueRequest using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Node aNode)
  {
    return readCatalogueRequest (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueRequest using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueRequest (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueRequest using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Node aNode,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, CatalogueRequestType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueRequest using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, CatalogueRequestType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueRequest using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final File aSource)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CatalogueRequest using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final File aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueRequest using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final File aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueRequest using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final File aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueRequest using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final IReadableResource aSource)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueRequest using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final IReadableResource aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueRequest using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final IReadableResource aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueRequest using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final IReadableResource aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueRequest using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Source aSource)
  {
    return readCatalogueRequest (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueRequest using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readCatalogueRequest (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueRequest using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Source aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            CatalogueRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueRequest using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, CatalogueRequestType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for CertificateOfOrigin.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL20ReaderBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CertificateOfOrigin using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Node aNode)
  {
    return readCertificateOfOrigin (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CertificateOfOrigin using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readCertificateOfOrigin (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CertificateOfOrigin using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Node aNode,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            CertificateOfOriginType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CertificateOfOrigin using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, CertificateOfOriginType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CertificateOfOrigin using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final File aSource)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CertificateOfOrigin using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a CertificateOfOrigin using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final File aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CertificateOfOrigin using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CertificateOfOrigin
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final IReadableResource aSource)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CertificateOfOrigin
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CertificateOfOrigin
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CertificateOfOrigin
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CertificateOfOrigin using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Source aSource)
  {
    return readCertificateOfOrigin (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CertificateOfOrigin using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readCertificateOfOrigin (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CertificateOfOrigin using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Source aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            CertificateOfOriginType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CertificateOfOrigin using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, CertificateOfOriginType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for CreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CreditNoteType> creditNote ()
  {
    return UBL20ReaderBuilder.create (CreditNoteType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CreditNote using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Node aNode)
  {
    return readCreditNote (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CreditNote using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readCreditNote (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CreditNote using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Node aNode,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, CreditNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CreditNote using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Node aNode,
                                               @Nullable ClassLoader aClassLoader,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, CreditNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CreditNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final File aSource)
  {
    return readCreditNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CreditNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readCreditNote (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a CreditNote using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final File aSource,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCreditNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CreditNote using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final File aSource,
                                               @Nullable ClassLoader aClassLoader,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCreditNote (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CreditNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final IReadableResource aSource)
  {
    return readCreditNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CreditNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final IReadableResource aSource,
                                               @Nullable ClassLoader aClassLoader)
  {
    return readCreditNote (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CreditNote using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final IReadableResource aSource,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCreditNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CreditNote using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final IReadableResource aSource,
                                               @Nullable ClassLoader aClassLoader,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCreditNote (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CreditNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Source aSource)
  {
    return readCreditNote (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CreditNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readCreditNote (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CreditNote using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Source aSource,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, CreditNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CreditNote using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Source aSource,
                                               @Nullable ClassLoader aClassLoader,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, CreditNoteType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for DebitNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <DebitNoteType> debitNote ()
  {
    return UBL20ReaderBuilder.create (DebitNoteType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a DebitNote using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Node aNode)
  {
    return readDebitNote (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a DebitNote using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readDebitNote (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a DebitNote using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Node aNode,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, DebitNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a DebitNote using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Node aNode,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, DebitNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a DebitNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final File aSource)
  {
    return readDebitNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a DebitNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readDebitNote (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a DebitNote using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final File aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDebitNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a DebitNote using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final File aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDebitNote (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DebitNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final IReadableResource aSource)
  {
    return readDebitNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DebitNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final IReadableResource aSource,
                                             @Nullable ClassLoader aClassLoader)
  {
    return readDebitNote (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DebitNote using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final IReadableResource aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDebitNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DebitNote using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final IReadableResource aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDebitNote (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a DebitNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Source aSource)
  {
    return readDebitNote (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a DebitNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readDebitNote (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a DebitNote using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Source aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, DebitNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a DebitNote using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Source aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, DebitNoteType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for DespatchAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL20ReaderBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a DespatchAdvice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Node aNode)
  {
    return readDespatchAdvice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a DespatchAdvice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readDespatchAdvice (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a DespatchAdvice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Node aNode,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, DespatchAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a DespatchAdvice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Node aNode,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, DespatchAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a DespatchAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final File aSource)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a DespatchAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a DespatchAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final File aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a DespatchAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final File aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DespatchAdvice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final IReadableResource aSource)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DespatchAdvice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final IReadableResource aSource,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DespatchAdvice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final IReadableResource aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DespatchAdvice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final IReadableResource aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a DespatchAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Source aSource)
  {
    return readDespatchAdvice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a DespatchAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return readDespatchAdvice (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a DespatchAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Source aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, DespatchAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a DespatchAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, DespatchAdviceType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for ForwardingInstructions.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL20ReaderBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ForwardingInstructions using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Node aNode)
  {
    return readForwardingInstructions (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ForwardingInstructions using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readForwardingInstructions (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ForwardingInstructions using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Node aNode,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            ForwardingInstructionsType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ForwardingInstructions using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, ForwardingInstructionsType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ForwardingInstructions using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final File aSource)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ForwardingInstructions using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a ForwardingInstructions using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final File aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ForwardingInstructions using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ForwardingInstructions
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final IReadableResource aSource)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ForwardingInstructions
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ForwardingInstructions
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ForwardingInstructions
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ForwardingInstructions using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Source aSource)
  {
    return readForwardingInstructions (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ForwardingInstructions using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readForwardingInstructions (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ForwardingInstructions using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Source aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            ForwardingInstructionsType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ForwardingInstructions using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Deprecated
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            ForwardingInstructionsType.class,
                                            aCustomEventHandler);
  }

  /**
   * Create a reader builder for FreightInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL20ReaderBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a FreightInvoice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Node aNode)
  {
    return readFreightInvoice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a FreightInvoice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readFreightInvoice (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a FreightInvoice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Node aNode,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, FreightInvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a FreightInvoice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Node aNode,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, FreightInvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a FreightInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final File aSource)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a FreightInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a FreightInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final File aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a FreightInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final File aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a FreightInvoice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final IReadableResource aSource)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a FreightInvoice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final IReadableResource aSource,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a FreightInvoice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final IReadableResource aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a FreightInvoice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final IReadableResource aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a FreightInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Source aSource)
  {
    return readFreightInvoice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a FreightInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return readFreightInvoice (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a FreightInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Source aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, FreightInvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a FreightInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, FreightInvoiceType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for Invoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <InvoiceType> invoice ()
  {
    return UBL20ReaderBuilder.create (InvoiceType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Invoice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Node aNode)
  {
    return readInvoice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Invoice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readInvoice (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Invoice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Node aNode,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, InvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Invoice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Node aNode,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, InvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Invoice using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final File aSource)
  {
    return readInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Invoice using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readInvoice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a Invoice using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final File aSource,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Invoice using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final File aSource,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInvoice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Invoice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final IReadableResource aSource)
  {
    return readInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Invoice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final IReadableResource aSource, @Nullable ClassLoader aClassLoader)
  {
    return readInvoice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Invoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final IReadableResource aSource,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Invoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final IReadableResource aSource,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInvoice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Invoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Source aSource)
  {
    return readInvoice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Invoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readInvoice (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Invoice using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Source aSource,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, InvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Invoice using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Source aSource,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, InvoiceType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for Order.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <OrderType> order ()
  {
    return UBL20ReaderBuilder.create (OrderType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Order using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final Node aNode)
  {
    return readOrder (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Order using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readOrder (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Order using a custom validation
   * event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final Node aNode, @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, OrderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Order using a custom validation
   * event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final Node aNode,
                                     @Nullable ClassLoader aClassLoader,
                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, OrderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Order using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final File aSource)
  {
    return readOrder (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Order using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readOrder (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a Order using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final File aSource, @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrder (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Order using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final File aSource,
                                     @Nullable ClassLoader aClassLoader,
                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrder (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Order using the global
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final IReadableResource aSource)
  {
    return readOrder (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Order using the global
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final IReadableResource aSource, @Nullable ClassLoader aClassLoader)
  {
    return readOrder (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Order using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final IReadableResource aSource,
                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrder (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Order using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final IReadableResource aSource,
                                     @Nullable ClassLoader aClassLoader,
                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrder (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Order using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final Source aSource)
  {
    return readOrder (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Order using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readOrder (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Order using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final Source aSource,
                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, OrderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Order using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static OrderType readOrder (@Nonnull final Source aSource,
                                     @Nullable ClassLoader aClassLoader,
                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, OrderType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for OrderCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL20ReaderBuilder.create (OrderCancellationType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderCancellation using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Node aNode)
  {
    return readOrderCancellation (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderCancellation using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Node aNode,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readOrderCancellation (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderCancellation using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Node aNode,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            OrderCancellationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderCancellation using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Node aNode,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, OrderCancellationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderCancellation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final File aSource)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a OrderCancellation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final File aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a OrderCancellation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final File aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderCancellation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final File aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderCancellation using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final IReadableResource aSource)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderCancellation using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final IReadableResource aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderCancellation using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final IReadableResource aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderCancellation using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final IReadableResource aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderCancellation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Source aSource)
  {
    return readOrderCancellation (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderCancellation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Source aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readOrderCancellation (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderCancellation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Source aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            OrderCancellationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderCancellation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Source aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, OrderCancellationType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for OrderChange.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <OrderChangeType> orderChange ()
  {
    return UBL20ReaderBuilder.create (OrderChangeType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderChange using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Node aNode)
  {
    return readOrderChange (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderChange using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readOrderChange (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderChange using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Node aNode,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, OrderChangeType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderChange using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Node aNode,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, OrderChangeType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderChange using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final File aSource)
  {
    return readOrderChange (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a OrderChange using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readOrderChange (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a OrderChange using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final File aSource,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderChange (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderChange using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final File aSource,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderChange (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderChange using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final IReadableResource aSource)
  {
    return readOrderChange (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderChange using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final IReadableResource aSource,
                                                 @Nullable ClassLoader aClassLoader)
  {
    return readOrderChange (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderChange using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final IReadableResource aSource,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderChange (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderChange using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final IReadableResource aSource,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderChange (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderChange using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Source aSource)
  {
    return readOrderChange (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderChange using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readOrderChange (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderChange using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Source aSource,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, OrderChangeType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderChange using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Source aSource,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, OrderChangeType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for OrderResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <OrderResponseType> orderResponse ()
  {
    return UBL20ReaderBuilder.create (OrderResponseType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponse using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Node aNode)
  {
    return readOrderResponse (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponse using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readOrderResponse (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponse using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Node aNode,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, OrderResponseType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponse using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Node aNode,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, OrderResponseType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderResponse using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final File aSource)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a OrderResponse using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a OrderResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final File aSource,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final File aSource,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponse using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final IReadableResource aSource)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponse using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final IReadableResource aSource,
                                                     @Nullable ClassLoader aClassLoader)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponse using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final IReadableResource aSource,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponse using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final IReadableResource aSource,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponse using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Source aSource)
  {
    return readOrderResponse (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponse using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readOrderResponse (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Source aSource,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, OrderResponseType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Source aSource,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, OrderResponseType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for OrderResponseSimple.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL20ReaderBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponseSimple using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Node aNode)
  {
    return readOrderResponseSimple (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponseSimple using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readOrderResponseSimple (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponseSimple using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Node aNode,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            OrderResponseSimpleType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponseSimple using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, OrderResponseSimpleType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderResponseSimple using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final File aSource)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a OrderResponseSimple using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a OrderResponseSimple using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final File aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderResponseSimple using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponseSimple
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final IReadableResource aSource)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponseSimple
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponseSimple
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponseSimple
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponseSimple using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Source aSource)
  {
    return readOrderResponseSimple (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponseSimple using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readOrderResponseSimple (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponseSimple using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Source aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            OrderResponseSimpleType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponseSimple using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, OrderResponseSimpleType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for PackingList.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <PackingListType> packingList ()
  {
    return UBL20ReaderBuilder.create (PackingListType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a PackingList using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Node aNode)
  {
    return readPackingList (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a PackingList using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readPackingList (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a PackingList using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Node aNode,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, PackingListType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a PackingList using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Node aNode,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, PackingListType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a PackingList using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final File aSource)
  {
    return readPackingList (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a PackingList using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readPackingList (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a PackingList using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final File aSource,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readPackingList (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a PackingList using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final File aSource,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readPackingList (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a PackingList using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final IReadableResource aSource)
  {
    return readPackingList (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a PackingList using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final IReadableResource aSource,
                                                 @Nullable ClassLoader aClassLoader)
  {
    return readPackingList (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a PackingList using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final IReadableResource aSource,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readPackingList (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a PackingList using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final IReadableResource aSource,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readPackingList (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a PackingList using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Source aSource)
  {
    return readPackingList (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a PackingList using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readPackingList (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a PackingList using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Source aSource,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, PackingListType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a PackingList using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Source aSource,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, PackingListType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for Quotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <QuotationType> quotation ()
  {
    return UBL20ReaderBuilder.create (QuotationType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Quotation using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Node aNode)
  {
    return readQuotation (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Quotation using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readQuotation (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Quotation using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Node aNode,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, QuotationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Quotation using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Node aNode,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, QuotationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Quotation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final File aSource)
  {
    return readQuotation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Quotation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readQuotation (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a Quotation using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final File aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readQuotation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Quotation using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final File aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readQuotation (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Quotation using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final IReadableResource aSource)
  {
    return readQuotation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Quotation using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final IReadableResource aSource,
                                             @Nullable ClassLoader aClassLoader)
  {
    return readQuotation (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Quotation using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final IReadableResource aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readQuotation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Quotation using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final IReadableResource aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readQuotation (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Quotation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Source aSource)
  {
    return readQuotation (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Quotation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readQuotation (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Quotation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Source aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, QuotationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Quotation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Source aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, QuotationType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for ReceiptAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL20ReaderBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ReceiptAdvice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Node aNode)
  {
    return readReceiptAdvice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ReceiptAdvice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readReceiptAdvice (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ReceiptAdvice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Node aNode,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, ReceiptAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ReceiptAdvice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Node aNode,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, ReceiptAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ReceiptAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final File aSource)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ReceiptAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a ReceiptAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final File aSource,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ReceiptAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final File aSource,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ReceiptAdvice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final IReadableResource aSource)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ReceiptAdvice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final IReadableResource aSource,
                                                     @Nullable ClassLoader aClassLoader)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ReceiptAdvice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final IReadableResource aSource,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ReceiptAdvice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final IReadableResource aSource,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ReceiptAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Source aSource)
  {
    return readReceiptAdvice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ReceiptAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readReceiptAdvice (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ReceiptAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Source aSource,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, ReceiptAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ReceiptAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Source aSource,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, ReceiptAdviceType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for Reminder.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <ReminderType> reminder ()
  {
    return UBL20ReaderBuilder.create (ReminderType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Reminder using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final Node aNode)
  {
    return readReminder (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Reminder using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readReminder (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Reminder using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final Node aNode,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, ReminderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Reminder using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final Node aNode,
                                           @Nullable ClassLoader aClassLoader,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, ReminderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Reminder using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final File aSource)
  {
    return readReminder (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Reminder using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readReminder (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a Reminder using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final File aSource,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readReminder (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Reminder using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final File aSource,
                                           @Nullable ClassLoader aClassLoader,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readReminder (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Reminder using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final IReadableResource aSource)
  {
    return readReminder (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Reminder using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final IReadableResource aSource, @Nullable ClassLoader aClassLoader)
  {
    return readReminder (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Reminder using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final IReadableResource aSource,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readReminder (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Reminder using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final IReadableResource aSource,
                                           @Nullable ClassLoader aClassLoader,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readReminder (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Reminder using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final Source aSource)
  {
    return readReminder (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Reminder using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readReminder (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Reminder using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final Source aSource,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, ReminderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Reminder using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static ReminderType readReminder (@Nonnull final Source aSource,
                                           @Nullable ClassLoader aClassLoader,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, ReminderType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for RemittanceAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL20ReaderBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a RemittanceAdvice using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Node aNode)
  {
    return readRemittanceAdvice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a RemittanceAdvice using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readRemittanceAdvice (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a RemittanceAdvice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Node aNode,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, RemittanceAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a RemittanceAdvice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, RemittanceAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a RemittanceAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final File aSource)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a RemittanceAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final File aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a RemittanceAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final File aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a RemittanceAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final File aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RemittanceAdvice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final IReadableResource aSource)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RemittanceAdvice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final IReadableResource aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RemittanceAdvice using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final IReadableResource aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RemittanceAdvice using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final IReadableResource aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a RemittanceAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Source aSource)
  {
    return readRemittanceAdvice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a RemittanceAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readRemittanceAdvice (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a RemittanceAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Source aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            RemittanceAdviceType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a RemittanceAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, RemittanceAdviceType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for RequestForQuotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL20ReaderBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a RequestForQuotation using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Node aNode)
  {
    return readRequestForQuotation (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a RequestForQuotation using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readRequestForQuotation (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a RequestForQuotation using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Node aNode,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            RequestForQuotationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a RequestForQuotation using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, RequestForQuotationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a RequestForQuotation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final File aSource)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a RequestForQuotation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a RequestForQuotation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final File aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a RequestForQuotation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RequestForQuotation
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final IReadableResource aSource)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RequestForQuotation
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RequestForQuotation
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RequestForQuotation
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a RequestForQuotation using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Source aSource)
  {
    return readRequestForQuotation (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a RequestForQuotation using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readRequestForQuotation (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a RequestForQuotation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Source aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            RequestForQuotationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a RequestForQuotation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, RequestForQuotationType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for SelfBilledCreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL20ReaderBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledCreditNote using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Node aNode)
  {
    return readSelfBilledCreditNote (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledCreditNote using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Node aNode,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readSelfBilledCreditNote (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledCreditNote using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Node aNode,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            SelfBilledCreditNoteType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledCreditNote using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Node aNode,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, SelfBilledCreditNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledCreditNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final File aSource)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledCreditNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final File aSource,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledCreditNote using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final File aSource,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledCreditNote using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final File aSource,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledCreditNote
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final IReadableResource aSource)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledCreditNote
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final IReadableResource aSource,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledCreditNote
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final IReadableResource aSource,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledCreditNote
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final IReadableResource aSource,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledCreditNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Source aSource)
  {
    return readSelfBilledCreditNote (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledCreditNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Source aSource,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readSelfBilledCreditNote (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledCreditNote using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Source aSource,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            SelfBilledCreditNoteType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledCreditNote using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Source aSource,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, SelfBilledCreditNoteType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for SelfBilledInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL20ReaderBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledInvoice using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Node aNode)
  {
    return readSelfBilledInvoice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledInvoice using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Node aNode,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readSelfBilledInvoice (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledInvoice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Node aNode,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            SelfBilledInvoiceType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledInvoice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Node aNode,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, SelfBilledInvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final File aSource)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final File aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final File aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final File aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledInvoice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final IReadableResource aSource)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledInvoice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final IReadableResource aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledInvoice using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final IReadableResource aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledInvoice using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final IReadableResource aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Source aSource)
  {
    return readSelfBilledInvoice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Source aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readSelfBilledInvoice (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Source aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            SelfBilledInvoiceType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Deprecated
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Source aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, SelfBilledInvoiceType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for Statement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <StatementType> statement ()
  {
    return UBL20ReaderBuilder.create (StatementType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Statement using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final Node aNode)
  {
    return readStatement (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Statement using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readStatement (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Statement using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final Node aNode,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, StatementType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Statement using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final Node aNode,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, StatementType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Statement using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final File aSource)
  {
    return readStatement (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Statement using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readStatement (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a Statement using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final File aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readStatement (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Statement using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final File aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readStatement (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Statement using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final IReadableResource aSource)
  {
    return readStatement (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Statement using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final IReadableResource aSource,
                                             @Nullable ClassLoader aClassLoader)
  {
    return readStatement (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Statement using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final IReadableResource aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readStatement (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Statement using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final IReadableResource aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readStatement (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Statement using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final Source aSource)
  {
    return readStatement (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Statement using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readStatement (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Statement using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final Source aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, StatementType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Statement using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Deprecated
  @Nullable
  public static StatementType readStatement (@Nonnull final Source aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, StatementType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for TransportationStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL20ReaderBuilder.create (TransportationStatusType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportationStatus using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Node aNode)
  {
    return readTransportationStatus (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportationStatus using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Node aNode,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readTransportationStatus (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportationStatus using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Node aNode,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            TransportationStatusType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportationStatus using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Node aNode,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, TransportationStatusType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportationStatus using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final File aSource)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TransportationStatus using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final File aSource,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TransportationStatus using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final File aSource,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportationStatus using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final File aSource,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportationStatus
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final IReadableResource aSource)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportationStatus
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final IReadableResource aSource,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportationStatus
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final IReadableResource aSource,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportationStatus
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final IReadableResource aSource,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportationStatus using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Source aSource)
  {
    return readTransportationStatus (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportationStatus using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Source aSource,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readTransportationStatus (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportationStatus using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Source aSource,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            TransportationStatusType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportationStatus using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Deprecated
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Source aSource,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, TransportationStatusType.class, aCustomEventHandler);
  }

  /**
   * Create a reader builder for Waybill.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <WaybillType> waybill ()
  {
    return UBL20ReaderBuilder.create (WaybillType.class);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Waybill using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Node aNode)
  {
    return readWaybill (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Waybill using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readWaybill (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Waybill using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Node aNode,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, (ClassLoader) null, WaybillType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Waybill using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Node aNode,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, aClassLoader, WaybillType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Waybill using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final File aSource)
  {
    return readWaybill (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Waybill using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readWaybill (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a Waybill using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final File aSource,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readWaybill (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Waybill using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final File aSource,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readWaybill (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Waybill using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final IReadableResource aSource)
  {
    return readWaybill (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Waybill using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final IReadableResource aSource, @Nullable ClassLoader aClassLoader)
  {
    return readWaybill (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Waybill using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final IReadableResource aSource,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readWaybill (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Waybill using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final IReadableResource aSource,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readWaybill (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Waybill using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Source aSource)
  {
    return readWaybill (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Waybill using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readWaybill (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Waybill using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Source aSource,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, (ClassLoader) null, WaybillType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Waybill using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Deprecated
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Source aSource,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, aClassLoader, WaybillType.class, aCustomEventHandler);
  }
}
