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
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.state.ESuccess;
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
 * Write all UBL 2.0 document types.
 *
 * @author Philip Helger
 */
@SuppressWarnings ("deprecation")
@NotThreadSafe
public final class UBL20Writer extends AbstractUBLDocumentMarshaller
{
  @PresentForCodeCoverage
  private static final UBL20Writer s_aInstance = new UBL20Writer ();

  private UBL20Writer ()
  {}

  /**
   * Create a writer builder for ApplicationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL20WriterBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse)
  {
    return writeApplicationResponse (aApplicationResponse, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader)
  {
    return writeApplicationResponse (aApplicationResponse, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aApplicationResponse,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.APPLICATION_RESPONSE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aApplicationResponse,
                                             aClassLoader,
                                             EUBL20DocumentType.APPLICATION_RESPONSE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nonnull final File aResult)
  {
    return writeApplicationResponse (aApplicationResponse, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final File aResult)
  {
    return writeApplicationResponse (aApplicationResponse, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeApplicationResponse (aApplicationResponse, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeApplicationResponse (aApplicationResponse,
                                     aClassLoader,
                                     aCustomEventHandler,
                                     new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nonnull final Result aResult)
  {
    return writeApplicationResponse (aApplicationResponse, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final Result aResult)
  {
    return writeApplicationResponse (aApplicationResponse, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aApplicationResponse,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.APPLICATION_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aApplicationResponse,
                                             aClassLoader,
                                             EUBL20DocumentType.APPLICATION_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for AttachedDocument.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL20WriterBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument)
  {
    return writeAttachedDocument (aAttachedDocument, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader)
  {
    return writeAttachedDocument (aAttachedDocument, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aAttachedDocument,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.ATTACHED_DOCUMENT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aAttachedDocument,
                                             aClassLoader,
                                             EUBL20DocumentType.ATTACHED_DOCUMENT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nonnull final File aResult)
  {
    return writeAttachedDocument (aAttachedDocument, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final File aResult)
  {
    return writeAttachedDocument (aAttachedDocument, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeAttachedDocument (aAttachedDocument, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeAttachedDocument (aAttachedDocument, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nonnull final Result aResult)
  {
    return writeAttachedDocument (aAttachedDocument, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final Result aResult)
  {
    return writeAttachedDocument (aAttachedDocument, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aAttachedDocument,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.ATTACHED_DOCUMENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aAttachedDocument,
                                             aClassLoader,
                                             EUBL20DocumentType.ATTACHED_DOCUMENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for BillOfLading.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL20WriterBuilder.create (BillOfLadingType.class);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading)
  {
    return writeBillOfLading (aBillOfLading, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader)
  {
    return writeBillOfLading (aBillOfLading, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a DOM {@link Document} using
   * a custom validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aBillOfLading,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.BILL_OF_LADING,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a DOM {@link Document} using
   * a custom validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader,
                                            @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aBillOfLading,
                                             aClassLoader,
                                             EUBL20DocumentType.BILL_OF_LADING,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading, @Nonnull final File aResult)
  {
    return writeBillOfLading (aBillOfLading, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader,
                                            @Nonnull final File aResult)
  {
    return writeBillOfLading (aBillOfLading, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ValidationEventHandler aCustomEventHandler,
                                            @Nonnull final File aResult)
  {
    return writeBillOfLading (aBillOfLading, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader,
                                            @Nullable final ValidationEventHandler aCustomEventHandler,
                                            @Nonnull final File aResult)
  {
    return writeBillOfLading (aBillOfLading, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nonnull final Result aResult)
  {
    return writeBillOfLading (aBillOfLading, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader,
                                            @Nonnull final Result aResult)
  {
    return writeBillOfLading (aBillOfLading, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ValidationEventHandler aCustomEventHandler,
                                            @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aBillOfLading,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.BILL_OF_LADING,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader,
                                            @Nullable final ValidationEventHandler aCustomEventHandler,
                                            @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aBillOfLading,
                                             aClassLoader,
                                             EUBL20DocumentType.BILL_OF_LADING,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Catalogue.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CatalogueType> catalogue ()
  {
    return UBL20WriterBuilder.create (CatalogueType.class);
  }

  /**
   * Convert the passed {@link CatalogueType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue)
  {
    return writeCatalogue (aCatalogue, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader)
  {
    return writeCatalogue (aCatalogue, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogue,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CATALOGUE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogue,
                                             aClassLoader,
                                             EUBL20DocumentType.CATALOGUE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue, @Nonnull final File aResult)
  {
    return writeCatalogue (aCatalogue, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final File aResult)
  {
    return writeCatalogue (aCatalogue, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeCatalogue (aCatalogue, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeCatalogue (aCatalogue, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue, @Nonnull final Result aResult)
  {
    return writeCatalogue (aCatalogue, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final Result aResult)
  {
    return writeCatalogue (aCatalogue, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogue,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CATALOGUE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CatalogueType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogue,
                                             aClassLoader,
                                             EUBL20DocumentType.CATALOGUE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CatalogueDeletion.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL20WriterBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CATALOGUE_DELETION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             aClassLoader,
                                             EUBL20DocumentType.CATALOGUE_DELETION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nonnull final File aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final File aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nonnull final Result aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final Result aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CATALOGUE_DELETION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             aClassLoader,
                                             EUBL20DocumentType.CATALOGUE_DELETION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CatalogueItemSpecificationUpdate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL20WriterBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  aClassLoader,
                                                  getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             aClassLoader,
                                             EUBL20DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nonnull final File aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader,
                                                                @Nonnull final File aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  aClassLoader,
                                                  new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                @Nonnull final File aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  aCustomEventHandler,
                                                  new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                @Nonnull final File aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  aClassLoader,
                                                  aCustomEventHandler,
                                                  new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nonnull final Result aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  getGlobalValidationEventHandler (),
                                                  aResult);
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader,
                                                                @Nonnull final Result aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  aClassLoader,
                                                  getGlobalValidationEventHandler (),
                                                  aResult);
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             aClassLoader,
                                             EUBL20DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CataloguePricingUpdate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL20WriterBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CATALOGUE_PRICING_UPDATE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             aClassLoader,
                                             EUBL20DocumentType.CATALOGUE_PRICING_UPDATE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nonnull final File aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final File aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate,
                                        aClassLoader,
                                        aCustomEventHandler,
                                        new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nonnull final Result aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final Result aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate,
                                        aClassLoader,
                                        getGlobalValidationEventHandler (),
                                        aResult);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CATALOGUE_PRICING_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             aClassLoader,
                                             EUBL20DocumentType.CATALOGUE_PRICING_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CatalogueRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL20WriterBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest)
  {
    return writeCatalogueRequest (aCatalogueRequest, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader)
  {
    return writeCatalogueRequest (aCatalogueRequest, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueRequest,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CATALOGUE_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueRequest,
                                             aClassLoader,
                                             EUBL20DocumentType.CATALOGUE_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nonnull final File aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final File aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nonnull final Result aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final Result aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueRequest,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CATALOGUE_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueRequest,
                                             aClassLoader,
                                             EUBL20DocumentType.CATALOGUE_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CertificateOfOrigin.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL20WriterBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CERTIFICATE_OF_ORIGIN,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             aClassLoader,
                                             EUBL20DocumentType.CERTIFICATE_OF_ORIGIN,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nonnull final File aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final File aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin,
                                     aClassLoader,
                                     aCustomEventHandler,
                                     new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nonnull final Result aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final Result aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CERTIFICATE_OF_ORIGIN,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             aClassLoader,
                                             EUBL20DocumentType.CERTIFICATE_OF_ORIGIN,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CreditNoteType> creditNote ()
  {
    return UBL20WriterBuilder.create (CreditNoteType.class);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote)
  {
    return writeCreditNote (aCreditNote, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CreditNoteType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader)
  {
    return writeCreditNote (aCreditNote, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CreditNoteType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCreditNote,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CREDIT_NOTE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader,
                                          @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCreditNote,
                                             aClassLoader,
                                             EUBL20DocumentType.CREDIT_NOTE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote, @Nonnull final File aResult)
  {
    return writeCreditNote (aCreditNote, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CreditNoteType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader,
                                          @Nonnull final File aResult)
  {
    return writeCreditNote (aCreditNote, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CreditNoteType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ValidationEventHandler aCustomEventHandler,
                                          @Nonnull final File aResult)
  {
    return writeCreditNote (aCreditNote, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CreditNoteType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader,
                                          @Nullable final ValidationEventHandler aCustomEventHandler,
                                          @Nonnull final File aResult)
  {
    return writeCreditNote (aCreditNote, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CreditNoteType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote, @Nonnull final Result aResult)
  {
    return writeCreditNote (aCreditNote, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader,
                                          @Nonnull final Result aResult)
  {
    return writeCreditNote (aCreditNote, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a custom {@link Result} using
   * a custom validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ValidationEventHandler aCustomEventHandler,
                                          @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCreditNote,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.CREDIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a custom {@link Result} using
   * a custom validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader,
                                          @Nullable final ValidationEventHandler aCustomEventHandler,
                                          @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCreditNote,
                                             aClassLoader,
                                             EUBL20DocumentType.CREDIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for DebitNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <DebitNoteType> debitNote ()
  {
    return UBL20WriterBuilder.create (DebitNoteType.class);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote)
  {
    return writeDebitNote (aDebitNote, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DebitNoteType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader)
  {
    return writeDebitNote (aDebitNote, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DebitNoteType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aDebitNote,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.DEBIT_NOTE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aDebitNote,
                                             aClassLoader,
                                             EUBL20DocumentType.DEBIT_NOTE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote, @Nonnull final File aResult)
  {
    return writeDebitNote (aDebitNote, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DebitNoteType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final File aResult)
  {
    return writeDebitNote (aDebitNote, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DebitNoteType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeDebitNote (aDebitNote, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DebitNoteType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeDebitNote (aDebitNote, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DebitNoteType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote, @Nonnull final Result aResult)
  {
    return writeDebitNote (aDebitNote, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final Result aResult)
  {
    return writeDebitNote (aDebitNote, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aDebitNote,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.DEBIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aDebitNote,
                                             aClassLoader,
                                             EUBL20DocumentType.DEBIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for DespatchAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL20WriterBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice)
  {
    return writeDespatchAdvice (aDespatchAdvice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader)
  {
    return writeDespatchAdvice (aDespatchAdvice, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aDespatchAdvice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.DESPATCH_ADVICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aDespatchAdvice,
                                             aClassLoader,
                                             EUBL20DocumentType.DESPATCH_ADVICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nonnull final File aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final File aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nonnull final Result aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final Result aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aDespatchAdvice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.DESPATCH_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aDespatchAdvice,
                                             aClassLoader,
                                             EUBL20DocumentType.DESPATCH_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for ForwardingInstructions.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL20WriterBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions)
  {
    return writeForwardingInstructions (aForwardingInstructions, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader)
  {
    return writeForwardingInstructions (aForwardingInstructions, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aForwardingInstructions,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.FORWARDING_INSTRUCTIONS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aForwardingInstructions,
                                             aClassLoader,
                                             EUBL20DocumentType.FORWARDING_INSTRUCTIONS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nonnull final File aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final File aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions,
                                        aClassLoader,
                                        aCustomEventHandler,
                                        new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nonnull final Result aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final Result aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions,
                                        aClassLoader,
                                        getGlobalValidationEventHandler (),
                                        aResult);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aForwardingInstructions,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.FORWARDING_INSTRUCTIONS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aForwardingInstructions,
                                             aClassLoader,
                                             EUBL20DocumentType.FORWARDING_INSTRUCTIONS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for FreightInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL20WriterBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice)
  {
    return writeFreightInvoice (aFreightInvoice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader)
  {
    return writeFreightInvoice (aFreightInvoice, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aFreightInvoice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.FREIGHT_INVOICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aFreightInvoice,
                                             aClassLoader,
                                             EUBL20DocumentType.FREIGHT_INVOICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nonnull final File aResult)
  {
    return writeFreightInvoice (aFreightInvoice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final File aResult)
  {
    return writeFreightInvoice (aFreightInvoice, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeFreightInvoice (aFreightInvoice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeFreightInvoice (aFreightInvoice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nonnull final Result aResult)
  {
    return writeFreightInvoice (aFreightInvoice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final Result aResult)
  {
    return writeFreightInvoice (aFreightInvoice, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aFreightInvoice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.FREIGHT_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aFreightInvoice,
                                             aClassLoader,
                                             EUBL20DocumentType.FREIGHT_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Invoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <InvoiceType> invoice ()
  {
    return UBL20WriterBuilder.create (InvoiceType.class);
  }

  /**
   * Convert the passed {@link InvoiceType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice)
  {
    return writeInvoice (aInvoice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link InvoiceType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice, @Nullable final ClassLoader aClassLoader)
  {
    return writeInvoice (aInvoice, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link InvoiceType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aInvoice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.INVOICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link InvoiceType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aInvoice, aClassLoader, EUBL20DocumentType.INVOICE, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link InvoiceType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice, @Nonnull final File aResult)
  {
    return writeInvoice (aInvoice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InvoiceType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nonnull final File aResult)
  {
    return writeInvoice (aInvoice, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InvoiceType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final File aResult)
  {
    return writeInvoice (aInvoice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InvoiceType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final File aResult)
  {
    return writeInvoice (aInvoice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InvoiceType} to a custom {@link Result} using the
   * global validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice, @Nonnull final Result aResult)
  {
    return writeInvoice (aInvoice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link InvoiceType} to a custom {@link Result} using the
   * global validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nonnull final Result aResult)
  {
    return writeInvoice (aInvoice, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link InvoiceType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aInvoice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link InvoiceType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aInvoice,
                                             aClassLoader,
                                             EUBL20DocumentType.INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Order.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <OrderType> order ()
  {
    return UBL20WriterBuilder.create (OrderType.class);
  }

  /**
   * Convert the passed {@link OrderType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder)
  {
    return writeOrder (aOrder, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder, @Nullable final ClassLoader aClassLoader)
  {
    return writeOrder (aOrder, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrder, (ClassLoader) null, EUBL20DocumentType.ORDER, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ClassLoader aClassLoader,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrder, aClassLoader, EUBL20DocumentType.ORDER, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder, @Nonnull final File aResult)
  {
    return writeOrder (aOrder, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ClassLoader aClassLoader,
                                     @Nonnull final File aResult)
  {
    return writeOrder (aOrder, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                     @Nonnull final File aResult)
  {
    return writeOrder (aOrder, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ClassLoader aClassLoader,
                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                     @Nonnull final File aResult)
  {
    return writeOrder (aOrder, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderType} to a custom {@link Result} using the
   * global validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder, @Nonnull final Result aResult)
  {
    return writeOrder (aOrder, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderType} to a custom {@link Result} using the
   * global validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ClassLoader aClassLoader,
                                     @Nonnull final Result aResult)
  {
    return writeOrder (aOrder, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                     @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrder,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.ORDER,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ClassLoader aClassLoader,
                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                     @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrder,
                                             aClassLoader,
                                             EUBL20DocumentType.ORDER,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for OrderCancellation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL20WriterBuilder.create (OrderCancellationType.class);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation)
  {
    return writeOrderCancellation (aOrderCancellation, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader)
  {
    return writeOrderCancellation (aOrderCancellation, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderCancellation,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.ORDER_CANCELLATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderCancellation,
                                             aClassLoader,
                                             EUBL20DocumentType.ORDER_CANCELLATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nonnull final File aResult)
  {
    return writeOrderCancellation (aOrderCancellation, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final File aResult)
  {
    return writeOrderCancellation (aOrderCancellation, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeOrderCancellation (aOrderCancellation, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeOrderCancellation (aOrderCancellation, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nonnull final Result aResult)
  {
    return writeOrderCancellation (aOrderCancellation, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final Result aResult)
  {
    return writeOrderCancellation (aOrderCancellation, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderCancellation,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.ORDER_CANCELLATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderCancellation,
                                             aClassLoader,
                                             EUBL20DocumentType.ORDER_CANCELLATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for OrderChange.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <OrderChangeType> orderChange ()
  {
    return UBL20WriterBuilder.create (OrderChangeType.class);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange)
  {
    return writeOrderChange (aOrderChange, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderChangeType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader)
  {
    return writeOrderChange (aOrderChange, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderChangeType} to a DOM {@link Document} using
   * a custom validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderChange,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.ORDER_CHANGE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a DOM {@link Document} using
   * a custom validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderChange,
                                             aClassLoader,
                                             EUBL20DocumentType.ORDER_CHANGE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange, @Nonnull final File aResult)
  {
    return writeOrderChange (aOrderChange, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderChangeType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final File aResult)
  {
    return writeOrderChange (aOrderChange, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderChangeType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writeOrderChange (aOrderChange, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderChangeType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writeOrderChange (aOrderChange, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderChangeType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange, @Nonnull final Result aResult)
  {
    return writeOrderChange (aOrderChange, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final Result aResult)
  {
    return writeOrderChange (aOrderChange, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a custom {@link Result} using
   * a custom validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderChange,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.ORDER_CHANGE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a custom {@link Result} using
   * a custom validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderChange,
                                             aClassLoader,
                                             EUBL20DocumentType.ORDER_CHANGE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for OrderResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <OrderResponseType> orderResponse ()
  {
    return UBL20WriterBuilder.create (OrderResponseType.class);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse)
  {
    return writeOrderResponse (aOrderResponse, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderResponseType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader)
  {
    return writeOrderResponse (aOrderResponse, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderResponseType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponse,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.ORDER_RESPONSE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponse,
                                             aClassLoader,
                                             EUBL20DocumentType.ORDER_RESPONSE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nonnull final File aResult)
  {
    return writeOrderResponse (aOrderResponse, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nonnull final File aResult)
  {
    return writeOrderResponse (aOrderResponse, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeOrderResponse (aOrderResponse, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeOrderResponse (aOrderResponse, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nonnull final Result aResult)
  {
    return writeOrderResponse (aOrderResponse, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nonnull final Result aResult)
  {
    return writeOrderResponse (aOrderResponse, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponse,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.ORDER_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponse,
                                             aClassLoader,
                                             EUBL20DocumentType.ORDER_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for OrderResponseSimple.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL20WriterBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.ORDER_RESPONSE_SIMPLE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             aClassLoader,
                                             EUBL20DocumentType.ORDER_RESPONSE_SIMPLE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nonnull final File aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final File aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple,
                                     aClassLoader,
                                     aCustomEventHandler,
                                     new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nonnull final Result aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final Result aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.ORDER_RESPONSE_SIMPLE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             aClassLoader,
                                             EUBL20DocumentType.ORDER_RESPONSE_SIMPLE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for PackingList.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <PackingListType> packingList ()
  {
    return UBL20WriterBuilder.create (PackingListType.class);
  }

  /**
   * Convert the passed {@link PackingListType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList)
  {
    return writePackingList (aPackingList, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link PackingListType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader)
  {
    return writePackingList (aPackingList, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link PackingListType} to a DOM {@link Document} using
   * a custom validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aPackingList,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.PACKING_LIST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link PackingListType} to a DOM {@link Document} using
   * a custom validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aPackingList,
                                             aClassLoader,
                                             EUBL20DocumentType.PACKING_LIST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link PackingListType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList, @Nonnull final File aResult)
  {
    return writePackingList (aPackingList, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PackingListType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final File aResult)
  {
    return writePackingList (aPackingList, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PackingListType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writePackingList (aPackingList, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PackingListType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writePackingList (aPackingList, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PackingListType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList, @Nonnull final Result aResult)
  {
    return writePackingList (aPackingList, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link PackingListType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final Result aResult)
  {
    return writePackingList (aPackingList, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link PackingListType} to a custom {@link Result} using
   * a custom validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aPackingList,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.PACKING_LIST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link PackingListType} to a custom {@link Result} using
   * a custom validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aPackingList,
                                             aClassLoader,
                                             EUBL20DocumentType.PACKING_LIST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Quotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <QuotationType> quotation ()
  {
    return UBL20WriterBuilder.create (QuotationType.class);
  }

  /**
   * Convert the passed {@link QuotationType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation)
  {
    return writeQuotation (aQuotation, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link QuotationType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader)
  {
    return writeQuotation (aQuotation, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link QuotationType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aQuotation,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.QUOTATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link QuotationType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aQuotation,
                                             aClassLoader,
                                             EUBL20DocumentType.QUOTATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link QuotationType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation, @Nonnull final File aResult)
  {
    return writeQuotation (aQuotation, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link QuotationType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final File aResult)
  {
    return writeQuotation (aQuotation, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link QuotationType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeQuotation (aQuotation, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link QuotationType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeQuotation (aQuotation, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link QuotationType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation, @Nonnull final Result aResult)
  {
    return writeQuotation (aQuotation, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link QuotationType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final Result aResult)
  {
    return writeQuotation (aQuotation, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link QuotationType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aQuotation,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.QUOTATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link QuotationType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aQuotation,
                                             aClassLoader,
                                             EUBL20DocumentType.QUOTATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for ReceiptAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL20WriterBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice)
  {
    return writeReceiptAdvice (aReceiptAdvice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader)
  {
    return writeReceiptAdvice (aReceiptAdvice, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aReceiptAdvice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.RECEIPT_ADVICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aReceiptAdvice,
                                             aClassLoader,
                                             EUBL20DocumentType.RECEIPT_ADVICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nonnull final File aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nonnull final File aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nonnull final Result aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nonnull final Result aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aReceiptAdvice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.RECEIPT_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aReceiptAdvice,
                                             aClassLoader,
                                             EUBL20DocumentType.RECEIPT_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Reminder.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <ReminderType> reminder ()
  {
    return UBL20WriterBuilder.create (ReminderType.class);
  }

  /**
   * Convert the passed {@link ReminderType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder)
  {
    return writeReminder (aReminder, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ReminderType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder, @Nullable final ClassLoader aClassLoader)
  {
    return writeReminder (aReminder, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ReminderType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aReminder,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.REMINDER,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ReminderType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aReminder, aClassLoader, EUBL20DocumentType.REMINDER, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ReminderType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder, @Nonnull final File aResult)
  {
    return writeReminder (aReminder, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReminderType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nonnull final File aResult)
  {
    return writeReminder (aReminder, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReminderType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final File aResult)
  {
    return writeReminder (aReminder, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReminderType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final File aResult)
  {
    return writeReminder (aReminder, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReminderType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder, @Nonnull final Result aResult)
  {
    return writeReminder (aReminder, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ReminderType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nonnull final Result aResult)
  {
    return writeReminder (aReminder, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ReminderType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aReminder,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.REMINDER,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ReminderType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aReminder,
                                             aClassLoader,
                                             EUBL20DocumentType.REMINDER,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for RemittanceAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL20WriterBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.REMITTANCE_ADVICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             aClassLoader,
                                             EUBL20DocumentType.REMITTANCE_ADVICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nonnull final File aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final File aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nonnull final Result aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final Result aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.REMITTANCE_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             aClassLoader,
                                             EUBL20DocumentType.REMITTANCE_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for RequestForQuotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL20WriterBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation)
  {
    return writeRequestForQuotation (aRequestForQuotation, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader)
  {
    return writeRequestForQuotation (aRequestForQuotation, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aRequestForQuotation,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.REQUEST_FOR_QUOTATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aRequestForQuotation,
                                             aClassLoader,
                                             EUBL20DocumentType.REQUEST_FOR_QUOTATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nonnull final File aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final File aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation,
                                     aClassLoader,
                                     aCustomEventHandler,
                                     new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nonnull final Result aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final Result aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aRequestForQuotation,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.REQUEST_FOR_QUOTATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aRequestForQuotation,
                                             aClassLoader,
                                             EUBL20DocumentType.REQUEST_FOR_QUOTATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for SelfBilledCreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL20WriterBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.SELF_BILLED_CREDIT_NOTE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             aClassLoader,
                                             EUBL20DocumentType.SELF_BILLED_CREDIT_NOTE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nonnull final File aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nonnull final File aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote,
                                      aClassLoader,
                                      aCustomEventHandler,
                                      new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nonnull final Result aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nonnull final Result aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.SELF_BILLED_CREDIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             aClassLoader,
                                             EUBL20DocumentType.SELF_BILLED_CREDIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for SelfBilledInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL20WriterBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.SELF_BILLED_INVOICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             aClassLoader,
                                             EUBL20DocumentType.SELF_BILLED_INVOICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nonnull final File aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final File aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nonnull final Result aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final Result aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.SELF_BILLED_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             aClassLoader,
                                             EUBL20DocumentType.SELF_BILLED_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Statement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <StatementType> statement ()
  {
    return UBL20WriterBuilder.create (StatementType.class);
  }

  /**
   * Convert the passed {@link StatementType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement)
  {
    return writeStatement (aStatement, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link StatementType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader)
  {
    return writeStatement (aStatement, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link StatementType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aStatement,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.STATEMENT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link StatementType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aStatement,
                                             aClassLoader,
                                             EUBL20DocumentType.STATEMENT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link StatementType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement, @Nonnull final File aResult)
  {
    return writeStatement (aStatement, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StatementType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final File aResult)
  {
    return writeStatement (aStatement, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StatementType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeStatement (aStatement, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StatementType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeStatement (aStatement, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StatementType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement, @Nonnull final Result aResult)
  {
    return writeStatement (aStatement, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link StatementType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final Result aResult)
  {
    return writeStatement (aStatement, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link StatementType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aStatement,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.STATEMENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link StatementType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aStatement,
                                             aClassLoader,
                                             EUBL20DocumentType.STATEMENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TransportationStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL20WriterBuilder.create (TransportationStatusType.class);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus)
  {
    return writeTransportationStatus (aTransportationStatus, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader)
  {
    return writeTransportationStatus (aTransportationStatus, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aTransportationStatus,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.TRANSPORTATION_STATUS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aTransportationStatus,
                                             aClassLoader,
                                             EUBL20DocumentType.TRANSPORTATION_STATUS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nonnull final File aResult)
  {
    return writeTransportationStatus (aTransportationStatus, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nonnull final File aResult)
  {
    return writeTransportationStatus (aTransportationStatus, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeTransportationStatus (aTransportationStatus, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeTransportationStatus (aTransportationStatus,
                                      aClassLoader,
                                      aCustomEventHandler,
                                      new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nonnull final Result aResult)
  {
    return writeTransportationStatus (aTransportationStatus, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nonnull final Result aResult)
  {
    return writeTransportationStatus (aTransportationStatus, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aTransportationStatus,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.TRANSPORTATION_STATUS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aTransportationStatus,
                                             aClassLoader,
                                             EUBL20DocumentType.TRANSPORTATION_STATUS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Waybill.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <WaybillType> waybill ()
  {
    return UBL20WriterBuilder.create (WaybillType.class);
  }

  /**
   * Convert the passed {@link WaybillType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill)
  {
    return writeWaybill (aWaybill, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link WaybillType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill, @Nullable final ClassLoader aClassLoader)
  {
    return writeWaybill (aWaybill, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link WaybillType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aWaybill,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.WAYBILL,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link WaybillType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aWaybill, aClassLoader, EUBL20DocumentType.WAYBILL, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link WaybillType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill, @Nonnull final File aResult)
  {
    return writeWaybill (aWaybill, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link WaybillType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nonnull final File aResult)
  {
    return writeWaybill (aWaybill, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link WaybillType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final File aResult)
  {
    return writeWaybill (aWaybill, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link WaybillType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final File aResult)
  {
    return writeWaybill (aWaybill, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link WaybillType} to a custom {@link Result} using the
   * global validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill, @Nonnull final Result aResult)
  {
    return writeWaybill (aWaybill, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link WaybillType} to a custom {@link Result} using the
   * global validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nonnull final Result aResult)
  {
    return writeWaybill (aWaybill, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link WaybillType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aWaybill,
                                             (ClassLoader) null,
                                             EUBL20DocumentType.WAYBILL,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link WaybillType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aWaybill,
                                             aClassLoader,
                                             EUBL20DocumentType.WAYBILL,
                                             aCustomEventHandler,
                                             aResult);
  }
}
