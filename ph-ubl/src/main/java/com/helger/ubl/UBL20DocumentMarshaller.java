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
package com.helger.ubl;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

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

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.state.ESuccess;

/**
 * This is a specialized version of the {@link UBL20Marshaller} that contains
 * utility methods for all known document types.<br>
 * This class was deprecated in favor of {@link UBL20Reader} and
 * {@link UBL20Writer}.
 *
 * @author Philip Helger
 */
@NotThreadSafe
@Deprecated
public final class UBL20DocumentMarshaller extends AbstractUBLDocumentMarshaller
{
  @PresentForCodeCoverage
  @SuppressWarnings ("unused")
  private static final UBL20DocumentMarshaller s_aInstance = new UBL20DocumentMarshaller ();

  private UBL20DocumentMarshaller ()
  {}

  // Everything starting from here is automatically generated:

  /**
   * Interpret the passed DOM {@link Node} as a ApplicationResponse using the
   * global validation event handler.
   *
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Node aNode)
  {
    return readApplicationResponse (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Node aNode,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, ApplicationResponseType.class, aCustomEventHandler);
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
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Source aSource)
  {
    return readApplicationResponse (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Source aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, ApplicationResponseType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse)
  {
    return writeApplicationResponse (aApplicationResponse, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aApplicationResponse,
                                             EUBL20DocumentType.APPLICATION_RESPONSE,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nonnull final Result aResult)
  {
    return writeApplicationResponse (aApplicationResponse, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aApplicationResponse,
                                             EUBL20DocumentType.APPLICATION_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Node aNode)
  {
    return readAttachedDocument (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Node aNode,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, AttachedDocumentType.class, aCustomEventHandler);
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
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Source aSource)
  {
    return readAttachedDocument (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Source aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, AttachedDocumentType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument)
  {
    return writeAttachedDocument (aAttachedDocument, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aAttachedDocument,
                                             EUBL20DocumentType.ATTACHED_DOCUMENT,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nonnull final Result aResult)
  {
    return writeAttachedDocument (aAttachedDocument, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aAttachedDocument,
                                             EUBL20DocumentType.ATTACHED_DOCUMENT,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Node aNode)
  {
    return readBillOfLading (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Node aNode,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, BillOfLadingType.class, aCustomEventHandler);
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
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Source aSource)
  {
    return readBillOfLading (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Source aSource,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, BillOfLadingType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading)
  {
    return writeBillOfLading (aBillOfLading, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aBillOfLading, EUBL20DocumentType.BILL_OF_LADING, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading, @Nonnull final Result aResult)
  {
    return writeBillOfLading (aBillOfLading, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ValidationEventHandler aCustomEventHandler,
                                            @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aBillOfLading,
                                             EUBL20DocumentType.BILL_OF_LADING,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Node aNode)
  {
    return readCatalogue (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Node aNode,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CatalogueType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Source aSource)
  {
    return readCatalogue (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Source aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CatalogueType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue)
  {
    return writeCatalogue (aCatalogue, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogue, EUBL20DocumentType.CATALOGUE, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue, @Nonnull final Result aResult)
  {
    return writeCatalogue (aCatalogue, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogue, EUBL20DocumentType.CATALOGUE, aCustomEventHandler, aResult);
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
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Node aNode)
  {
    return readCatalogueDeletion (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Node aNode,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CatalogueDeletionType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Source aSource)
  {
    return readCatalogueDeletion (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Source aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CatalogueDeletionType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             EUBL20DocumentType.CATALOGUE_DELETION,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nonnull final Result aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             EUBL20DocumentType.CATALOGUE_DELETION,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Node aNode)
  {
    return readCatalogueItemSpecificationUpdate (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Node aNode,
                                                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CatalogueItemSpecificationUpdateType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Source aSource)
  {
    return readCatalogueItemSpecificationUpdate (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Source aSource,
                                                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CatalogueItemSpecificationUpdateType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             EUBL20DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             EUBL20DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Node aNode)
  {
    return readCataloguePricingUpdate (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Node aNode,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CataloguePricingUpdateType.class, aCustomEventHandler);
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
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Source aSource)
  {
    return readCataloguePricingUpdate (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Source aSource,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CataloguePricingUpdateType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             EUBL20DocumentType.CATALOGUE_PRICING_UPDATE,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nonnull final Result aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             EUBL20DocumentType.CATALOGUE_PRICING_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Node aNode)
  {
    return readCatalogueRequest (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Node aNode,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CatalogueRequestType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Source aSource)
  {
    return readCatalogueRequest (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Source aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CatalogueRequestType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest)
  {
    return writeCatalogueRequest (aCatalogueRequest, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueRequest,
                                             EUBL20DocumentType.CATALOGUE_REQUEST,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nonnull final Result aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueRequest,
                                             EUBL20DocumentType.CATALOGUE_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Node aNode)
  {
    return readCertificateOfOrigin (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Node aNode,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CertificateOfOriginType.class, aCustomEventHandler);
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
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Source aSource)
  {
    return readCertificateOfOrigin (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Source aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CertificateOfOriginType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             EUBL20DocumentType.CERTIFICATE_OF_ORIGIN,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nonnull final Result aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             EUBL20DocumentType.CERTIFICATE_OF_ORIGIN,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Node aNode)
  {
    return readCreditNote (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Node aNode,
                                               @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CreditNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Source aSource)
  {
    return readCreditNote (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Source aSource,
                                               @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CreditNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote)
  {
    return writeCreditNote (aCreditNote, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCreditNote, EUBL20DocumentType.CREDIT_NOTE, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote, @Nonnull final Result aResult)
  {
    return writeCreditNote (aCreditNote, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ValidationEventHandler aCustomEventHandler,
                                          @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCreditNote, EUBL20DocumentType.CREDIT_NOTE, aCustomEventHandler, aResult);
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
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Node aNode)
  {
    return readDebitNote (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Node aNode,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, DebitNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Source aSource)
  {
    return readDebitNote (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Source aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, DebitNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote)
  {
    return writeDebitNote (aDebitNote, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aDebitNote, EUBL20DocumentType.DEBIT_NOTE, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote, @Nonnull final Result aResult)
  {
    return writeDebitNote (aDebitNote, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aDebitNote, EUBL20DocumentType.DEBIT_NOTE, aCustomEventHandler, aResult);
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
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Node aNode)
  {
    return readDespatchAdvice (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Node aNode,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, DespatchAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Source aSource)
  {
    return readDespatchAdvice (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Source aSource,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, DespatchAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice)
  {
    return writeDespatchAdvice (aDespatchAdvice, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aDespatchAdvice, EUBL20DocumentType.DESPATCH_ADVICE, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nonnull final Result aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aDespatchAdvice,
                                             EUBL20DocumentType.DESPATCH_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Node aNode)
  {
    return readForwardingInstructions (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Node aNode,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, ForwardingInstructionsType.class, aCustomEventHandler);
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
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Source aSource)
  {
    return readForwardingInstructions (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Source aSource,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, ForwardingInstructionsType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions)
  {
    return writeForwardingInstructions (aForwardingInstructions, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aForwardingInstructions,
                                             EUBL20DocumentType.FORWARDING_INSTRUCTIONS,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nonnull final Result aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aForwardingInstructions,
                                             EUBL20DocumentType.FORWARDING_INSTRUCTIONS,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Node aNode)
  {
    return readFreightInvoice (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Node aNode,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, FreightInvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Source aSource)
  {
    return readFreightInvoice (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Source aSource,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, FreightInvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice)
  {
    return writeFreightInvoice (aFreightInvoice, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aFreightInvoice, EUBL20DocumentType.FREIGHT_INVOICE, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nonnull final Result aResult)
  {
    return writeFreightInvoice (aFreightInvoice, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aFreightInvoice,
                                             EUBL20DocumentType.FREIGHT_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Node aNode)
  {
    return readInvoice (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Node aNode,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, InvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Source aSource)
  {
    return readInvoice (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Source aSource,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, InvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice)
  {
    return writeInvoice (aInvoice, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aInvoice, EUBL20DocumentType.INVOICE, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice, @Nonnull final Result aResult)
  {
    return writeInvoice (aInvoice, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aInvoice, EUBL20DocumentType.INVOICE, aCustomEventHandler, aResult);
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
  @Nullable
  public static OrderType readOrder (@Nonnull final Node aNode)
  {
    return readOrder (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static OrderType readOrder (@Nonnull final Node aNode,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, OrderType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderType readOrder (@Nonnull final Source aSource)
  {
    return readOrder (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static OrderType readOrder (@Nonnull final Source aSource,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, OrderType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder)
  {
    return writeOrder (aOrder, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrder, EUBL20DocumentType.ORDER, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder, @Nonnull final Result aResult)
  {
    return writeOrder (aOrder, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                     @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrder, EUBL20DocumentType.ORDER, aCustomEventHandler, aResult);
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
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Node aNode)
  {
    return readOrderCancellation (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Node aNode,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, OrderCancellationType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Source aSource)
  {
    return readOrderCancellation (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Source aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, OrderCancellationType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation)
  {
    return writeOrderCancellation (aOrderCancellation, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderCancellation,
                                             EUBL20DocumentType.ORDER_CANCELLATION,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nonnull final Result aResult)
  {
    return writeOrderCancellation (aOrderCancellation, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderCancellation,
                                             EUBL20DocumentType.ORDER_CANCELLATION,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Node aNode)
  {
    return readOrderChange (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Node aNode,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, OrderChangeType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Source aSource)
  {
    return readOrderChange (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Source aSource,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, OrderChangeType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange)
  {
    return writeOrderChange (aOrderChange, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderChange, EUBL20DocumentType.ORDER_CHANGE, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange, @Nonnull final Result aResult)
  {
    return writeOrderChange (aOrderChange, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderChange,
                                             EUBL20DocumentType.ORDER_CHANGE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Node aNode)
  {
    return readOrderResponse (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Node aNode,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, OrderResponseType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Source aSource)
  {
    return readOrderResponse (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Source aSource,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, OrderResponseType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse)
  {
    return writeOrderResponse (aOrderResponse, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponse, EUBL20DocumentType.ORDER_RESPONSE, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nonnull final Result aResult)
  {
    return writeOrderResponse (aOrderResponse, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponse,
                                             EUBL20DocumentType.ORDER_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Node aNode)
  {
    return readOrderResponseSimple (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Node aNode,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, OrderResponseSimpleType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Source aSource)
  {
    return readOrderResponseSimple (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Source aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, OrderResponseSimpleType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             EUBL20DocumentType.ORDER_RESPONSE_SIMPLE,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nonnull final Result aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             EUBL20DocumentType.ORDER_RESPONSE_SIMPLE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Node aNode)
  {
    return readPackingList (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Node aNode,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, PackingListType.class, aCustomEventHandler);
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
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Source aSource)
  {
    return readPackingList (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Source aSource,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, PackingListType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList)
  {
    return writePackingList (aPackingList, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aPackingList, EUBL20DocumentType.PACKING_LIST, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList, @Nonnull final Result aResult)
  {
    return writePackingList (aPackingList, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aPackingList,
                                             EUBL20DocumentType.PACKING_LIST,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Node aNode)
  {
    return readQuotation (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Node aNode,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, QuotationType.class, aCustomEventHandler);
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
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Source aSource)
  {
    return readQuotation (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Source aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, QuotationType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation)
  {
    return writeQuotation (aQuotation, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aQuotation, EUBL20DocumentType.QUOTATION, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation, @Nonnull final Result aResult)
  {
    return writeQuotation (aQuotation, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aQuotation, EUBL20DocumentType.QUOTATION, aCustomEventHandler, aResult);
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
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Node aNode)
  {
    return readReceiptAdvice (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Node aNode,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, ReceiptAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Source aSource)
  {
    return readReceiptAdvice (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Source aSource,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, ReceiptAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice)
  {
    return writeReceiptAdvice (aReceiptAdvice, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aReceiptAdvice, EUBL20DocumentType.RECEIPT_ADVICE, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nonnull final Result aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aReceiptAdvice,
                                             EUBL20DocumentType.RECEIPT_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static ReminderType readReminder (@Nonnull final Node aNode)
  {
    return readReminder (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static ReminderType readReminder (@Nonnull final Node aNode,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, ReminderType.class, aCustomEventHandler);
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
  @Nullable
  public static ReminderType readReminder (@Nonnull final Source aSource)
  {
    return readReminder (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static ReminderType readReminder (@Nonnull final Source aSource,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, ReminderType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder)
  {
    return writeReminder (aReminder, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aReminder, EUBL20DocumentType.REMINDER, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder, @Nonnull final Result aResult)
  {
    return writeReminder (aReminder, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aReminder, EUBL20DocumentType.REMINDER, aCustomEventHandler, aResult);
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
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Node aNode)
  {
    return readRemittanceAdvice (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Node aNode,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, RemittanceAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Source aSource)
  {
    return readRemittanceAdvice (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Source aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, RemittanceAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             EUBL20DocumentType.REMITTANCE_ADVICE,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nonnull final Result aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             EUBL20DocumentType.REMITTANCE_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Node aNode)
  {
    return readRequestForQuotation (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Node aNode,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, RequestForQuotationType.class, aCustomEventHandler);
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
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Source aSource)
  {
    return readRequestForQuotation (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Source aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, RequestForQuotationType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation)
  {
    return writeRequestForQuotation (aRequestForQuotation, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aRequestForQuotation,
                                             EUBL20DocumentType.REQUEST_FOR_QUOTATION,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nonnull final Result aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aRequestForQuotation,
                                             EUBL20DocumentType.REQUEST_FOR_QUOTATION,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Node aNode)
  {
    return readSelfBilledCreditNote (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Node aNode,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, SelfBilledCreditNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Source aSource)
  {
    return readSelfBilledCreditNote (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Source aSource,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, SelfBilledCreditNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             EUBL20DocumentType.SELF_BILLED_CREDIT_NOTE,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nonnull final Result aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             EUBL20DocumentType.SELF_BILLED_CREDIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Node aNode)
  {
    return readSelfBilledInvoice (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Node aNode,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, SelfBilledInvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Source aSource)
  {
    return readSelfBilledInvoice (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Source aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, SelfBilledInvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             EUBL20DocumentType.SELF_BILLED_INVOICE,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nonnull final Result aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             EUBL20DocumentType.SELF_BILLED_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static StatementType readStatement (@Nonnull final Node aNode)
  {
    return readStatement (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static StatementType readStatement (@Nonnull final Node aNode,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, StatementType.class, aCustomEventHandler);
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
  @Nullable
  public static StatementType readStatement (@Nonnull final Source aSource)
  {
    return readStatement (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static StatementType readStatement (@Nonnull final Source aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, StatementType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement)
  {
    return writeStatement (aStatement, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aStatement, EUBL20DocumentType.STATEMENT, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement, @Nonnull final Result aResult)
  {
    return writeStatement (aStatement, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aStatement, EUBL20DocumentType.STATEMENT, aCustomEventHandler, aResult);
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
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Node aNode)
  {
    return readTransportationStatus (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Node aNode,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, TransportationStatusType.class, aCustomEventHandler);
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
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Source aSource)
  {
    return readTransportationStatus (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Source aSource,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, TransportationStatusType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus)
  {
    return writeTransportationStatus (aTransportationStatus, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aTransportationStatus,
                                             EUBL20DocumentType.TRANSPORTATION_STATUS,
                                             aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nonnull final Result aResult)
  {
    return writeTransportationStatus (aTransportationStatus, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aTransportationStatus,
                                             EUBL20DocumentType.TRANSPORTATION_STATUS,
                                             aCustomEventHandler,
                                             aResult);
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
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Node aNode)
  {
    return readWaybill (aNode, getGlobalValidationEventHandler ());
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
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Node aNode,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, WaybillType.class, aCustomEventHandler);
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
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Source aSource)
  {
    return readWaybill (aSource, getGlobalValidationEventHandler ());
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
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Source aSource,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, WaybillType.class, aCustomEventHandler);
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
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill)
  {
    return writeWaybill (aWaybill, getGlobalValidationEventHandler ());
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
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aWaybill, EUBL20DocumentType.WAYBILL, aCustomEventHandler);
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
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill, @Nonnull final Result aResult)
  {
    return writeWaybill (aWaybill, getGlobalValidationEventHandler (), aResult);
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
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aWaybill, EUBL20DocumentType.WAYBILL, aCustomEventHandler, aResult);
  }
}
