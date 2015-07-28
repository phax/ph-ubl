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

import oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_21.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.awardednotification_21.AwardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.billoflading_21.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.callfortenders_21.CallForTendersType;
import oasis.names.specification.ubl.schema.xsd.catalogue_21.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_21.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_21.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_21.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_21.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_21.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_21.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_21.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_21.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.documentstatus_21.DocumentStatusType;
import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_21.DocumentStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_21.ExceptionCriteriaType;
import oasis.names.specification.ubl.schema.xsd.exceptionnotification_21.ExceptionNotificationType;
import oasis.names.specification.ubl.schema.xsd.forecast_21.ForecastType;
import oasis.names.specification.ubl.schema.xsd.forecastrevision_21.ForecastRevisionType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_21.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_21.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_21.FulfilmentCancellationType;
import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_21.GoodsItemItineraryType;
import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_21.GuaranteeCertificateType;
import oasis.names.specification.ubl.schema.xsd.instructionforreturns_21.InstructionForReturnsType;
import oasis.names.specification.ubl.schema.xsd.inventoryreport_21.InventoryReportType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_21.ItemInformationRequestType;
import oasis.names.specification.ubl.schema.xsd.order_21.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_21.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_21.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_21.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_21.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_21.PackingListType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_21.PriorInformationNoticeType;
import oasis.names.specification.ubl.schema.xsd.productactivity_21.ProductActivityType;
import oasis.names.specification.ubl.schema.xsd.quotation_21.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_21.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_21.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_21.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_21.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.retailevent_21.RetailEventType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_21.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_21.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_21.StatementType;
import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_21.StockAvailabilityReportType;
import oasis.names.specification.ubl.schema.xsd.tender_21.TenderType;
import oasis.names.specification.ubl.schema.xsd.tendererqualification_21.TendererQualificationType;
import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_21.TendererQualificationResponseType;
import oasis.names.specification.ubl.schema.xsd.tenderreceipt_21.TenderReceiptType;
import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_21.TradeItemLocationProfileType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_21.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_21.TransportationStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_21.TransportExecutionPlanType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_21.TransportExecutionPlanRequestType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_21.TransportProgressStatusType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_21.TransportProgressStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescription_21.TransportServiceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_21.TransportServiceDescriptionRequestType;
import oasis.names.specification.ubl.schema.xsd.unawardednotification_21.UnawardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.utilitystatement_21.UtilityStatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_21.WaybillType;

/**
 * Read all UBL 2.1 document types.
 * 
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL21Reader extends AbstractUBLDocumentMarshaller
{
  @PresentForCodeCoverage
  private static final UBL21Reader s_aInstance = new UBL21Reader ();

  private UBL21Reader ()
  {}

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
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Node aNode,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ApplicationResponseType.class, aCustomEventHandler);
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
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Source aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, ApplicationResponseType.class, aCustomEventHandler);
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
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Node aNode,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, AttachedDocumentType.class, aCustomEventHandler);
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
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, AttachedDocumentType.class, aCustomEventHandler);
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
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Source aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, AttachedDocumentType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a AwardedNotification using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final Node aNode)
  {
    return readAwardedNotification (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a AwardedNotification using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readAwardedNotification (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a AwardedNotification using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final Node aNode,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            AwardedNotificationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a AwardedNotification using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, AwardedNotificationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a AwardedNotification using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final File aSource)
  {
    return readAwardedNotification (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a AwardedNotification using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readAwardedNotification (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a AwardedNotification using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final File aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readAwardedNotification (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a AwardedNotification using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readAwardedNotification (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a AwardedNotification
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final IReadableResource aSource)
  {
    return readAwardedNotification (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a AwardedNotification
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readAwardedNotification (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a AwardedNotification
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readAwardedNotification (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a AwardedNotification
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readAwardedNotification (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a AwardedNotification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final Source aSource)
  {
    return readAwardedNotification (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a AwardedNotification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readAwardedNotification (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a AwardedNotification using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final Source aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            AwardedNotificationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a AwardedNotification using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AwardedNotificationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static AwardedNotificationType readAwardedNotification (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, AwardedNotificationType.class, aCustomEventHandler);
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
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Node aNode,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, BillOfLadingType.class, aCustomEventHandler);
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
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Node aNode,
                                                   @Nullable ClassLoader aClassLoader,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, BillOfLadingType.class, aCustomEventHandler);
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
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Source aSource,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, BillOfLadingType.class, aCustomEventHandler);
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
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Source aSource,
                                                   @Nullable ClassLoader aClassLoader,
                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, BillOfLadingType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CallForTenders using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final Node aNode)
  {
    return readCallForTenders (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CallForTenders using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readCallForTenders (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CallForTenders using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final Node aNode,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, CallForTendersType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CallForTenders using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final Node aNode,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, CallForTendersType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CallForTenders using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final File aSource)
  {
    return readCallForTenders (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CallForTenders using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readCallForTenders (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a CallForTenders using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final File aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCallForTenders (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CallForTenders using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final File aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCallForTenders (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CallForTenders using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final IReadableResource aSource)
  {
    return readCallForTenders (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CallForTenders using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final IReadableResource aSource,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return readCallForTenders (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CallForTenders using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final IReadableResource aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCallForTenders (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CallForTenders using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final IReadableResource aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readCallForTenders (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CallForTenders using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final Source aSource)
  {
    return readCallForTenders (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CallForTenders using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return readCallForTenders (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CallForTenders using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final Source aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, CallForTendersType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CallForTenders using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CallForTendersType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CallForTendersType readCallForTenders (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, CallForTendersType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Node aNode,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, CatalogueType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Node aNode,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, CatalogueType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Source aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, CatalogueType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Source aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, CatalogueType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Node aNode,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Node aNode,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, CatalogueDeletionType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Source aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Source aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, CatalogueDeletionType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Node aNode,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Node aNode,
                                                                                           @Nullable ClassLoader aClassLoader,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Source aSource,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Source aSource,
                                                                                           @Nullable ClassLoader aClassLoader,
                                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            CatalogueItemSpecificationUpdateType.class,
                                            aCustomEventHandler);
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
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Node aNode,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, CataloguePricingUpdateType.class, aCustomEventHandler);
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
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Source aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            CataloguePricingUpdateType.class,
                                            aCustomEventHandler);
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
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Node aNode,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, CatalogueRequestType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, CatalogueRequestType.class, aCustomEventHandler);
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
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Source aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, CatalogueRequestType.class, aCustomEventHandler);
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
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Node aNode,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, CertificateOfOriginType.class, aCustomEventHandler);
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
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Source aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, CertificateOfOriginType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ContractAwardNotice using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final Node aNode)
  {
    return readContractAwardNotice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ContractAwardNotice using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readContractAwardNotice (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ContractAwardNotice using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final Node aNode,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            ContractAwardNoticeType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ContractAwardNotice using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ContractAwardNoticeType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ContractAwardNotice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final File aSource)
  {
    return readContractAwardNotice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ContractAwardNotice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readContractAwardNotice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a ContractAwardNotice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final File aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readContractAwardNotice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ContractAwardNotice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final File aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readContractAwardNotice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ContractAwardNotice
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final IReadableResource aSource)
  {
    return readContractAwardNotice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ContractAwardNotice
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readContractAwardNotice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ContractAwardNotice
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readContractAwardNotice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ContractAwardNotice
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final IReadableResource aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readContractAwardNotice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ContractAwardNotice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final Source aSource)
  {
    return readContractAwardNotice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ContractAwardNotice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readContractAwardNotice (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ContractAwardNotice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final Source aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            ContractAwardNoticeType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ContractAwardNotice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractAwardNoticeType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ContractAwardNoticeType readContractAwardNotice (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, ContractAwardNoticeType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ContractNotice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final Node aNode)
  {
    return readContractNotice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ContractNotice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readContractNotice (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ContractNotice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final Node aNode,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, ContractNoticeType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ContractNotice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final Node aNode,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ContractNoticeType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ContractNotice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final File aSource)
  {
    return readContractNotice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ContractNotice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readContractNotice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a ContractNotice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final File aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readContractNotice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ContractNotice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final File aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readContractNotice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ContractNotice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final IReadableResource aSource)
  {
    return readContractNotice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ContractNotice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final IReadableResource aSource,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return readContractNotice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ContractNotice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final IReadableResource aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readContractNotice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ContractNotice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final IReadableResource aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readContractNotice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ContractNotice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final Source aSource)
  {
    return readContractNotice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ContractNotice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return readContractNotice (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ContractNotice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final Source aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, ContractNoticeType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ContractNotice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ContractNoticeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ContractNoticeType readContractNotice (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, ContractNoticeType.class, aCustomEventHandler);
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
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Node aNode,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, CreditNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Node aNode,
                                               @Nullable ClassLoader aClassLoader,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, CreditNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Source aSource,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, CreditNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Source aSource,
                                               @Nullable ClassLoader aClassLoader,
                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, CreditNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Node aNode,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, DebitNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Node aNode,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, DebitNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Source aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, DebitNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Source aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, DebitNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Node aNode,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, DespatchAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Node aNode,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, DespatchAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Source aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, DespatchAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, DespatchAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a DocumentStatus using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final Node aNode)
  {
    return readDocumentStatus (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a DocumentStatus using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readDocumentStatus (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a DocumentStatus using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final Node aNode,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, DocumentStatusType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a DocumentStatus using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final Node aNode,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, DocumentStatusType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a DocumentStatus using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final File aSource)
  {
    return readDocumentStatus (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a DocumentStatus using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readDocumentStatus (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a DocumentStatus using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final File aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDocumentStatus (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a DocumentStatus using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final File aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDocumentStatus (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DocumentStatus using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final IReadableResource aSource)
  {
    return readDocumentStatus (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DocumentStatus using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final IReadableResource aSource,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return readDocumentStatus (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DocumentStatus using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final IReadableResource aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDocumentStatus (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DocumentStatus using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final IReadableResource aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDocumentStatus (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a DocumentStatus using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final Source aSource)
  {
    return readDocumentStatus (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a DocumentStatus using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return readDocumentStatus (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a DocumentStatus using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final Source aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, DocumentStatusType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a DocumentStatus using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DocumentStatusType readDocumentStatus (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, DocumentStatusType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a DocumentStatusRequest using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final Node aNode)
  {
    return readDocumentStatusRequest (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a DocumentStatusRequest using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final Node aNode,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readDocumentStatusRequest (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a DocumentStatusRequest using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final Node aNode,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            DocumentStatusRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a DocumentStatusRequest using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final Node aNode,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, DocumentStatusRequestType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a DocumentStatusRequest using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final File aSource)
  {
    return readDocumentStatusRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a DocumentStatusRequest using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final File aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readDocumentStatusRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a DocumentStatusRequest using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final File aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDocumentStatusRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a DocumentStatusRequest using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final File aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDocumentStatusRequest (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DocumentStatusRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final IReadableResource aSource)
  {
    return readDocumentStatusRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DocumentStatusRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readDocumentStatusRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DocumentStatusRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDocumentStatusRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DocumentStatusRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readDocumentStatusRequest (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a DocumentStatusRequest using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final Source aSource)
  {
    return readDocumentStatusRequest (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a DocumentStatusRequest using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final Source aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readDocumentStatusRequest (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a DocumentStatusRequest using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final Source aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            DocumentStatusRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a DocumentStatusRequest using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DocumentStatusRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static DocumentStatusRequestType readDocumentStatusRequest (@Nonnull final Source aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            DocumentStatusRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ExceptionCriteria using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final Node aNode)
  {
    return readExceptionCriteria (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ExceptionCriteria using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final Node aNode,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readExceptionCriteria (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ExceptionCriteria using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final Node aNode,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            ExceptionCriteriaType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ExceptionCriteria using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final Node aNode,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ExceptionCriteriaType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ExceptionCriteria using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final File aSource)
  {
    return readExceptionCriteria (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ExceptionCriteria using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final File aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readExceptionCriteria (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a ExceptionCriteria using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final File aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readExceptionCriteria (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ExceptionCriteria using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final File aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readExceptionCriteria (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ExceptionCriteria using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final IReadableResource aSource)
  {
    return readExceptionCriteria (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ExceptionCriteria using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final IReadableResource aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readExceptionCriteria (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ExceptionCriteria using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final IReadableResource aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readExceptionCriteria (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ExceptionCriteria using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final IReadableResource aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readExceptionCriteria (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ExceptionCriteria using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final Source aSource)
  {
    return readExceptionCriteria (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ExceptionCriteria using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final Source aSource,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return readExceptionCriteria (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ExceptionCriteria using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final Source aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            ExceptionCriteriaType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ExceptionCriteria using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionCriteriaType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ExceptionCriteriaType readExceptionCriteria (@Nonnull final Source aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, ExceptionCriteriaType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ExceptionNotification using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final Node aNode)
  {
    return readExceptionNotification (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ExceptionNotification using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final Node aNode,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readExceptionNotification (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ExceptionNotification using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final Node aNode,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            ExceptionNotificationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ExceptionNotification using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final Node aNode,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ExceptionNotificationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ExceptionNotification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final File aSource)
  {
    return readExceptionNotification (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ExceptionNotification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final File aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readExceptionNotification (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a ExceptionNotification using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final File aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readExceptionNotification (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ExceptionNotification using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final File aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readExceptionNotification (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ExceptionNotification
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final IReadableResource aSource)
  {
    return readExceptionNotification (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ExceptionNotification
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readExceptionNotification (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ExceptionNotification
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readExceptionNotification (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ExceptionNotification
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readExceptionNotification (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ExceptionNotification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final Source aSource)
  {
    return readExceptionNotification (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ExceptionNotification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final Source aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readExceptionNotification (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ExceptionNotification using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final Source aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            ExceptionNotificationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ExceptionNotification using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ExceptionNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ExceptionNotificationType readExceptionNotification (@Nonnull final Source aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            ExceptionNotificationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Forecast using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final Node aNode)
  {
    return readForecast (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Forecast using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readForecast (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Forecast using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final Node aNode,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, ForecastType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Forecast using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final Node aNode,
                                           @Nullable ClassLoader aClassLoader,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ForecastType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Forecast using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final File aSource)
  {
    return readForecast (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Forecast using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readForecast (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a Forecast using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final File aSource,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForecast (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Forecast using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final File aSource,
                                           @Nullable ClassLoader aClassLoader,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForecast (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Forecast using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final IReadableResource aSource)
  {
    return readForecast (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Forecast using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final IReadableResource aSource, @Nullable ClassLoader aClassLoader)
  {
    return readForecast (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Forecast using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final IReadableResource aSource,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForecast (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Forecast using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final IReadableResource aSource,
                                           @Nullable ClassLoader aClassLoader,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForecast (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Forecast using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final Source aSource)
  {
    return readForecast (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Forecast using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readForecast (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Forecast using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final Source aSource,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, ForecastType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Forecast using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ForecastType readForecast (@Nonnull final Source aSource,
                                           @Nullable ClassLoader aClassLoader,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, ForecastType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ForecastRevision using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final Node aNode)
  {
    return readForecastRevision (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ForecastRevision using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readForecastRevision (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ForecastRevision using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final Node aNode,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, ForecastRevisionType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ForecastRevision using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ForecastRevisionType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ForecastRevision using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final File aSource)
  {
    return readForecastRevision (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ForecastRevision using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final File aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readForecastRevision (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a ForecastRevision using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final File aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForecastRevision (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ForecastRevision using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final File aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForecastRevision (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ForecastRevision using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final IReadableResource aSource)
  {
    return readForecastRevision (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ForecastRevision using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final IReadableResource aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readForecastRevision (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ForecastRevision using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final IReadableResource aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForecastRevision (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ForecastRevision using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final IReadableResource aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readForecastRevision (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ForecastRevision using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final Source aSource)
  {
    return readForecastRevision (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ForecastRevision using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readForecastRevision (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ForecastRevision using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final Source aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            ForecastRevisionType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ForecastRevision using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForecastRevisionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static ForecastRevisionType readForecastRevision (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, ForecastRevisionType.class, aCustomEventHandler);
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
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Node aNode,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ForwardingInstructionsType.class, aCustomEventHandler);
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
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Source aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            ForwardingInstructionsType.class,
                                            aCustomEventHandler);
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
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Node aNode,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, FreightInvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Node aNode,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, FreightInvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Source aSource,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, FreightInvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Source aSource,
                                                       @Nullable ClassLoader aClassLoader,
                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, FreightInvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a FulfilmentCancellation using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final Node aNode)
  {
    return readFulfilmentCancellation (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a FulfilmentCancellation using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readFulfilmentCancellation (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a FulfilmentCancellation using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final Node aNode,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            FulfilmentCancellationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a FulfilmentCancellation using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, FulfilmentCancellationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a FulfilmentCancellation using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final File aSource)
  {
    return readFulfilmentCancellation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a FulfilmentCancellation using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readFulfilmentCancellation (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a FulfilmentCancellation using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final File aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readFulfilmentCancellation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a FulfilmentCancellation using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readFulfilmentCancellation (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a FulfilmentCancellation
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final IReadableResource aSource)
  {
    return readFulfilmentCancellation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a FulfilmentCancellation
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readFulfilmentCancellation (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a FulfilmentCancellation
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readFulfilmentCancellation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a FulfilmentCancellation
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readFulfilmentCancellation (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a FulfilmentCancellation using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final Source aSource)
  {
    return readFulfilmentCancellation (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a FulfilmentCancellation using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readFulfilmentCancellation (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a FulfilmentCancellation using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final Source aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            FulfilmentCancellationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a FulfilmentCancellation using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FulfilmentCancellationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static FulfilmentCancellationType readFulfilmentCancellation (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            FulfilmentCancellationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a GoodsItemItinerary using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final Node aNode)
  {
    return readGoodsItemItinerary (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a GoodsItemItinerary using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final Node aNode,
                                                               @Nullable ClassLoader aClassLoader)
  {
    return readGoodsItemItinerary (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a GoodsItemItinerary using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final Node aNode,
                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            GoodsItemItineraryType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a GoodsItemItinerary using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final Node aNode,
                                                               @Nullable ClassLoader aClassLoader,
                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, GoodsItemItineraryType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a GoodsItemItinerary using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final File aSource)
  {
    return readGoodsItemItinerary (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a GoodsItemItinerary using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final File aSource,
                                                               @Nullable ClassLoader aClassLoader)
  {
    return readGoodsItemItinerary (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a GoodsItemItinerary using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final File aSource,
                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readGoodsItemItinerary (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a GoodsItemItinerary using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final File aSource,
                                                               @Nullable ClassLoader aClassLoader,
                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readGoodsItemItinerary (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a GoodsItemItinerary
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final IReadableResource aSource)
  {
    return readGoodsItemItinerary (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a GoodsItemItinerary
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final IReadableResource aSource,
                                                               @Nullable ClassLoader aClassLoader)
  {
    return readGoodsItemItinerary (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a GoodsItemItinerary
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final IReadableResource aSource,
                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readGoodsItemItinerary (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a GoodsItemItinerary
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final IReadableResource aSource,
                                                               @Nullable ClassLoader aClassLoader,
                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readGoodsItemItinerary (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a GoodsItemItinerary using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final Source aSource)
  {
    return readGoodsItemItinerary (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a GoodsItemItinerary using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final Source aSource,
                                                               @Nullable ClassLoader aClassLoader)
  {
    return readGoodsItemItinerary (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a GoodsItemItinerary using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final Source aSource,
                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            GoodsItemItineraryType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a GoodsItemItinerary using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GoodsItemItineraryType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GoodsItemItineraryType readGoodsItemItinerary (@Nonnull final Source aSource,
                                                               @Nullable ClassLoader aClassLoader,
                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, GoodsItemItineraryType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a GuaranteeCertificate using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final Node aNode)
  {
    return readGuaranteeCertificate (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a GuaranteeCertificate using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final Node aNode,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readGuaranteeCertificate (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a GuaranteeCertificate using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final Node aNode,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            GuaranteeCertificateType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a GuaranteeCertificate using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final Node aNode,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, GuaranteeCertificateType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a GuaranteeCertificate using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final File aSource)
  {
    return readGuaranteeCertificate (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a GuaranteeCertificate using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final File aSource,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readGuaranteeCertificate (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a GuaranteeCertificate using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final File aSource,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readGuaranteeCertificate (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a GuaranteeCertificate using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final File aSource,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readGuaranteeCertificate (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a GuaranteeCertificate
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final IReadableResource aSource)
  {
    return readGuaranteeCertificate (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a GuaranteeCertificate
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final IReadableResource aSource,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readGuaranteeCertificate (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a GuaranteeCertificate
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final IReadableResource aSource,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readGuaranteeCertificate (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a GuaranteeCertificate
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final IReadableResource aSource,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readGuaranteeCertificate (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a GuaranteeCertificate using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final Source aSource)
  {
    return readGuaranteeCertificate (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a GuaranteeCertificate using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final Source aSource,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return readGuaranteeCertificate (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a GuaranteeCertificate using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final Source aSource,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            GuaranteeCertificateType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a GuaranteeCertificate using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated GuaranteeCertificateType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static GuaranteeCertificateType readGuaranteeCertificate (@Nonnull final Source aSource,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, GuaranteeCertificateType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a InstructionForReturns using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final Node aNode)
  {
    return readInstructionForReturns (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a InstructionForReturns using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final Node aNode,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readInstructionForReturns (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a InstructionForReturns using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final Node aNode,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            InstructionForReturnsType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a InstructionForReturns using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final Node aNode,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, InstructionForReturnsType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a InstructionForReturns using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final File aSource)
  {
    return readInstructionForReturns (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a InstructionForReturns using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final File aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readInstructionForReturns (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a InstructionForReturns using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final File aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInstructionForReturns (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a InstructionForReturns using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final File aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInstructionForReturns (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a InstructionForReturns
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final IReadableResource aSource)
  {
    return readInstructionForReturns (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a InstructionForReturns
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readInstructionForReturns (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a InstructionForReturns
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInstructionForReturns (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a InstructionForReturns
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInstructionForReturns (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a InstructionForReturns using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final Source aSource)
  {
    return readInstructionForReturns (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a InstructionForReturns using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final Source aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readInstructionForReturns (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a InstructionForReturns using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final Source aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            InstructionForReturnsType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a InstructionForReturns using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InstructionForReturnsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static InstructionForReturnsType readInstructionForReturns (@Nonnull final Source aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            InstructionForReturnsType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a InventoryReport using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final Node aNode)
  {
    return readInventoryReport (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a InventoryReport using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readInventoryReport (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a InventoryReport using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final Node aNode,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, InventoryReportType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a InventoryReport using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final Node aNode,
                                                         @Nullable ClassLoader aClassLoader,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, InventoryReportType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a InventoryReport using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final File aSource)
  {
    return readInventoryReport (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a InventoryReport using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final File aSource,
                                                         @Nullable ClassLoader aClassLoader)
  {
    return readInventoryReport (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a InventoryReport using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final File aSource,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInventoryReport (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a InventoryReport using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final File aSource,
                                                         @Nullable ClassLoader aClassLoader,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInventoryReport (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a InventoryReport using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final IReadableResource aSource)
  {
    return readInventoryReport (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a InventoryReport using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final IReadableResource aSource,
                                                         @Nullable ClassLoader aClassLoader)
  {
    return readInventoryReport (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a InventoryReport using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final IReadableResource aSource,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInventoryReport (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a InventoryReport using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final IReadableResource aSource,
                                                         @Nullable ClassLoader aClassLoader,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readInventoryReport (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a InventoryReport using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final Source aSource)
  {
    return readInventoryReport (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a InventoryReport using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final Source aSource,
                                                         @Nullable ClassLoader aClassLoader)
  {
    return readInventoryReport (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a InventoryReport using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final Source aSource,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            InventoryReportType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a InventoryReport using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InventoryReportType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static InventoryReportType readInventoryReport (@Nonnull final Source aSource,
                                                         @Nullable ClassLoader aClassLoader,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, InventoryReportType.class, aCustomEventHandler);
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
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Node aNode,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, InvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Node aNode,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, InvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Source aSource,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, InvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Source aSource,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, InvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ItemInformationRequest using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final Node aNode)
  {
    return readItemInformationRequest (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ItemInformationRequest using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readItemInformationRequest (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ItemInformationRequest using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final Node aNode,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            ItemInformationRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ItemInformationRequest using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ItemInformationRequestType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ItemInformationRequest using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final File aSource)
  {
    return readItemInformationRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ItemInformationRequest using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readItemInformationRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a ItemInformationRequest using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final File aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readItemInformationRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ItemInformationRequest using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readItemInformationRequest (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ItemInformationRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final IReadableResource aSource)
  {
    return readItemInformationRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ItemInformationRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readItemInformationRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ItemInformationRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readItemInformationRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ItemInformationRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readItemInformationRequest (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ItemInformationRequest using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final Source aSource)
  {
    return readItemInformationRequest (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ItemInformationRequest using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readItemInformationRequest (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ItemInformationRequest using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final Source aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            ItemInformationRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ItemInformationRequest using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ItemInformationRequestType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ItemInformationRequestType readItemInformationRequest (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            ItemInformationRequestType.class,
                                            aCustomEventHandler);
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
  @Nullable
  public static OrderType readOrder (@Nonnull final Node aNode, @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, OrderType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderType readOrder (@Nonnull final Node aNode,
                                     @Nullable ClassLoader aClassLoader,
                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, OrderType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderType readOrder (@Nonnull final Source aSource,
                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, OrderType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderType readOrder (@Nonnull final Source aSource,
                                     @Nullable ClassLoader aClassLoader,
                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, OrderType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Node aNode,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Node aNode,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, OrderCancellationType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Source aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Source aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, OrderCancellationType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Node aNode,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, OrderChangeType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Node aNode,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, OrderChangeType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Source aSource,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, OrderChangeType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Source aSource,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, OrderChangeType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Node aNode,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, OrderResponseType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Node aNode,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, OrderResponseType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Source aSource,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, OrderResponseType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Source aSource,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, OrderResponseType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Node aNode,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, OrderResponseSimpleType.class, aCustomEventHandler);
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
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Source aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, OrderResponseSimpleType.class, aCustomEventHandler);
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
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Node aNode,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, PackingListType.class, aCustomEventHandler);
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
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Node aNode,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, PackingListType.class, aCustomEventHandler);
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
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Source aSource,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, PackingListType.class, aCustomEventHandler);
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
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Source aSource,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, PackingListType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a PriorInformationNotice using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final Node aNode)
  {
    return readPriorInformationNotice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a PriorInformationNotice using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readPriorInformationNotice (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a PriorInformationNotice using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final Node aNode,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            PriorInformationNoticeType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a PriorInformationNotice using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, PriorInformationNoticeType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a PriorInformationNotice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final File aSource)
  {
    return readPriorInformationNotice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a PriorInformationNotice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readPriorInformationNotice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a PriorInformationNotice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final File aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readPriorInformationNotice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a PriorInformationNotice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readPriorInformationNotice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a PriorInformationNotice
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final IReadableResource aSource)
  {
    return readPriorInformationNotice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a PriorInformationNotice
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readPriorInformationNotice (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a PriorInformationNotice
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readPriorInformationNotice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a PriorInformationNotice
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readPriorInformationNotice (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a PriorInformationNotice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final Source aSource)
  {
    return readPriorInformationNotice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a PriorInformationNotice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readPriorInformationNotice (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a PriorInformationNotice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final Source aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            PriorInformationNoticeType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a PriorInformationNotice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PriorInformationNoticeType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static PriorInformationNoticeType readPriorInformationNotice (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            PriorInformationNoticeType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ProductActivity using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final Node aNode)
  {
    return readProductActivity (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ProductActivity using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readProductActivity (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ProductActivity using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final Node aNode,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, ProductActivityType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ProductActivity using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final Node aNode,
                                                         @Nullable ClassLoader aClassLoader,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ProductActivityType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ProductActivity using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final File aSource)
  {
    return readProductActivity (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ProductActivity using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final File aSource,
                                                         @Nullable ClassLoader aClassLoader)
  {
    return readProductActivity (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a ProductActivity using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final File aSource,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readProductActivity (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ProductActivity using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final File aSource,
                                                         @Nullable ClassLoader aClassLoader,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readProductActivity (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ProductActivity using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final IReadableResource aSource)
  {
    return readProductActivity (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ProductActivity using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final IReadableResource aSource,
                                                         @Nullable ClassLoader aClassLoader)
  {
    return readProductActivity (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ProductActivity using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final IReadableResource aSource,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readProductActivity (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ProductActivity using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final IReadableResource aSource,
                                                         @Nullable ClassLoader aClassLoader,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readProductActivity (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ProductActivity using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final Source aSource)
  {
    return readProductActivity (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ProductActivity using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final Source aSource,
                                                         @Nullable ClassLoader aClassLoader)
  {
    return readProductActivity (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ProductActivity using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final Source aSource,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            ProductActivityType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ProductActivity using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ProductActivityType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ProductActivityType readProductActivity (@Nonnull final Source aSource,
                                                         @Nullable ClassLoader aClassLoader,
                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, ProductActivityType.class, aCustomEventHandler);
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
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Node aNode,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, QuotationType.class, aCustomEventHandler);
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
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Node aNode,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, QuotationType.class, aCustomEventHandler);
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
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Source aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, QuotationType.class, aCustomEventHandler);
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
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Source aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, QuotationType.class, aCustomEventHandler);
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
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Node aNode,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, ReceiptAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Node aNode,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ReceiptAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Source aSource,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, ReceiptAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Source aSource,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, ReceiptAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static ReminderType readReminder (@Nonnull final Node aNode,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, ReminderType.class, aCustomEventHandler);
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
  @Nullable
  public static ReminderType readReminder (@Nonnull final Node aNode,
                                           @Nullable ClassLoader aClassLoader,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, ReminderType.class, aCustomEventHandler);
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
  @Nullable
  public static ReminderType readReminder (@Nonnull final Source aSource,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, ReminderType.class, aCustomEventHandler);
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
  @Nullable
  public static ReminderType readReminder (@Nonnull final Source aSource,
                                           @Nullable ClassLoader aClassLoader,
                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, ReminderType.class, aCustomEventHandler);
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
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Node aNode,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, RemittanceAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, RemittanceAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Source aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, RemittanceAdviceType.class, aCustomEventHandler);
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
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Node aNode,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Node aNode,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, RequestForQuotationType.class, aCustomEventHandler);
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
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Source aSource,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Source aSource,
                                                                 @Nullable ClassLoader aClassLoader,
                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, RequestForQuotationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a RetailEvent using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final Node aNode)
  {
    return readRetailEvent (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a RetailEvent using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readRetailEvent (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a RetailEvent using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final Node aNode,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, RetailEventType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a RetailEvent using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final Node aNode,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, RetailEventType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a RetailEvent using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final File aSource)
  {
    return readRetailEvent (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a RetailEvent using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readRetailEvent (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a RetailEvent using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final File aSource,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRetailEvent (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a RetailEvent using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final File aSource,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRetailEvent (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RetailEvent using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final IReadableResource aSource)
  {
    return readRetailEvent (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RetailEvent using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final IReadableResource aSource,
                                                 @Nullable ClassLoader aClassLoader)
  {
    return readRetailEvent (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RetailEvent using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final IReadableResource aSource,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRetailEvent (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RetailEvent using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final IReadableResource aSource,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readRetailEvent (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a RetailEvent using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final Source aSource)
  {
    return readRetailEvent (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a RetailEvent using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readRetailEvent (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a RetailEvent using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final Source aSource,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, RetailEventType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a RetailEvent using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RetailEventType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static RetailEventType readRetailEvent (@Nonnull final Source aSource,
                                                 @Nullable ClassLoader aClassLoader,
                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, RetailEventType.class, aCustomEventHandler);
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
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Node aNode,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Node aNode,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, SelfBilledCreditNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Source aSource,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Source aSource,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, SelfBilledCreditNoteType.class, aCustomEventHandler);
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
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Node aNode,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Node aNode,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, SelfBilledInvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Source aSource,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Source aSource,
                                                             @Nullable ClassLoader aClassLoader,
                                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, SelfBilledInvoiceType.class, aCustomEventHandler);
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
  @Nullable
  public static StatementType readStatement (@Nonnull final Node aNode,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, StatementType.class, aCustomEventHandler);
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
  @Nullable
  public static StatementType readStatement (@Nonnull final Node aNode,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, StatementType.class, aCustomEventHandler);
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
  @Nullable
  public static StatementType readStatement (@Nonnull final Source aSource,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, StatementType.class, aCustomEventHandler);
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
  @Nullable
  public static StatementType readStatement (@Nonnull final Source aSource,
                                             @Nullable ClassLoader aClassLoader,
                                             @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, StatementType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a StockAvailabilityReport using
   * the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final Node aNode)
  {
    return readStockAvailabilityReport (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a StockAvailabilityReport using
   * the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final Node aNode,
                                                                         @Nullable ClassLoader aClassLoader)
  {
    return readStockAvailabilityReport (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a StockAvailabilityReport using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final Node aNode,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            StockAvailabilityReportType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a StockAvailabilityReport using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final Node aNode,
                                                                         @Nullable ClassLoader aClassLoader,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            aClassLoader,
                                            StockAvailabilityReportType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a StockAvailabilityReport using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final File aSource)
  {
    return readStockAvailabilityReport (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a StockAvailabilityReport using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final File aSource,
                                                                         @Nullable ClassLoader aClassLoader)
  {
    return readStockAvailabilityReport (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a StockAvailabilityReport using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final File aSource,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readStockAvailabilityReport (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a StockAvailabilityReport using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final File aSource,
                                                                         @Nullable ClassLoader aClassLoader,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readStockAvailabilityReport (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a StockAvailabilityReport
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final IReadableResource aSource)
  {
    return readStockAvailabilityReport (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a StockAvailabilityReport
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final IReadableResource aSource,
                                                                         @Nullable ClassLoader aClassLoader)
  {
    return readStockAvailabilityReport (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a StockAvailabilityReport
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final IReadableResource aSource,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readStockAvailabilityReport (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a StockAvailabilityReport
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final IReadableResource aSource,
                                                                         @Nullable ClassLoader aClassLoader,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readStockAvailabilityReport (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a StockAvailabilityReport using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final Source aSource)
  {
    return readStockAvailabilityReport (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a StockAvailabilityReport using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final Source aSource,
                                                                         @Nullable ClassLoader aClassLoader)
  {
    return readStockAvailabilityReport (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a StockAvailabilityReport using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final Source aSource,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            StockAvailabilityReportType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a StockAvailabilityReport using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StockAvailabilityReportType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static StockAvailabilityReportType readStockAvailabilityReport (@Nonnull final Source aSource,
                                                                         @Nullable ClassLoader aClassLoader,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            StockAvailabilityReportType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Tender using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final Node aNode)
  {
    return readTender (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Tender using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readTender (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Tender using a custom validation
   * event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final Node aNode, @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, TenderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Tender using a custom validation
   * event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final Node aNode,
                                       @Nullable ClassLoader aClassLoader,
                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, TenderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Tender using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final File aSource)
  {
    return readTender (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Tender using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readTender (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a Tender using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final File aSource,
                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTender (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Tender using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final File aSource,
                                       @Nullable ClassLoader aClassLoader,
                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTender (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Tender using the global
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final IReadableResource aSource)
  {
    return readTender (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Tender using the global
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final IReadableResource aSource, @Nullable ClassLoader aClassLoader)
  {
    return readTender (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Tender using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final IReadableResource aSource,
                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTender (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Tender using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final IReadableResource aSource,
                                       @Nullable ClassLoader aClassLoader,
                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTender (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Tender using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final Source aSource)
  {
    return readTender (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Tender using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readTender (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Tender using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final Source aSource,
                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, TenderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Tender using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static TenderType readTender (@Nonnull final Source aSource,
                                       @Nullable ClassLoader aClassLoader,
                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, TenderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TendererQualification using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final Node aNode)
  {
    return readTendererQualification (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TendererQualification using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final Node aNode,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTendererQualification (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TendererQualification using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final Node aNode,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            TendererQualificationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TendererQualification using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final Node aNode,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, TendererQualificationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TendererQualification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final File aSource)
  {
    return readTendererQualification (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TendererQualification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final File aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTendererQualification (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TendererQualification using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final File aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTendererQualification (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TendererQualification using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final File aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTendererQualification (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TendererQualification
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final IReadableResource aSource)
  {
    return readTendererQualification (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TendererQualification
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTendererQualification (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TendererQualification
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTendererQualification (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TendererQualification
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTendererQualification (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TendererQualification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final Source aSource)
  {
    return readTendererQualification (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TendererQualification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final Source aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTendererQualification (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TendererQualification using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final Source aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            TendererQualificationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TendererQualification using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TendererQualificationType readTendererQualification (@Nonnull final Source aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            TendererQualificationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TendererQualificationResponse
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final Node aNode)
  {
    return readTendererQualificationResponse (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TendererQualificationResponse
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final Node aNode,
                                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTendererQualificationResponse (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TendererQualificationResponse
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final Node aNode,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            TendererQualificationResponseType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TendererQualificationResponse
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final Node aNode,
                                                                                     @Nullable ClassLoader aClassLoader,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            aClassLoader,
                                            TendererQualificationResponseType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TendererQualificationResponse using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final File aSource)
  {
    return readTendererQualificationResponse (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TendererQualificationResponse using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final File aSource,
                                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTendererQualificationResponse (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TendererQualificationResponse using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final File aSource,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTendererQualificationResponse (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TendererQualificationResponse using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final File aSource,
                                                                                     @Nullable ClassLoader aClassLoader,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTendererQualificationResponse (TransformSourceFactory.create (aSource),
                                              aClassLoader,
                                              aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TendererQualificationResponse using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final IReadableResource aSource)
  {
    return readTendererQualificationResponse (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TendererQualificationResponse using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final IReadableResource aSource,
                                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTendererQualificationResponse (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TendererQualificationResponse using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final IReadableResource aSource,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTendererQualificationResponse (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TendererQualificationResponse using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final IReadableResource aSource,
                                                                                     @Nullable ClassLoader aClassLoader,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTendererQualificationResponse (TransformSourceFactory.create (aSource),
                                              aClassLoader,
                                              aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TendererQualificationResponse
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final Source aSource)
  {
    return readTendererQualificationResponse (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TendererQualificationResponse
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final Source aSource,
                                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTendererQualificationResponse (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TendererQualificationResponse
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final Source aSource,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            TendererQualificationResponseType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TendererQualificationResponse
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TendererQualificationResponseType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TendererQualificationResponseType readTendererQualificationResponse (@Nonnull final Source aSource,
                                                                                     @Nullable ClassLoader aClassLoader,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            TendererQualificationResponseType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TenderReceipt using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final Node aNode)
  {
    return readTenderReceipt (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TenderReceipt using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final Node aNode, @Nullable ClassLoader aClassLoader)
  {
    return readTenderReceipt (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TenderReceipt using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final Node aNode,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, TenderReceiptType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TenderReceipt using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final Node aNode,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, TenderReceiptType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TenderReceipt using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final File aSource)
  {
    return readTenderReceipt (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TenderReceipt using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final File aSource, @Nullable ClassLoader aClassLoader)
  {
    return readTenderReceipt (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TenderReceipt using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final File aSource,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTenderReceipt (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TenderReceipt using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final File aSource,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTenderReceipt (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TenderReceipt using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final IReadableResource aSource)
  {
    return readTenderReceipt (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TenderReceipt using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final IReadableResource aSource,
                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTenderReceipt (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TenderReceipt using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final IReadableResource aSource,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTenderReceipt (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TenderReceipt using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final IReadableResource aSource,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTenderReceipt (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TenderReceipt using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final Source aSource)
  {
    return readTenderReceipt (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TenderReceipt using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final Source aSource, @Nullable ClassLoader aClassLoader)
  {
    return readTenderReceipt (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TenderReceipt using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final Source aSource,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, TenderReceiptType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TenderReceipt using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TenderReceiptType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static TenderReceiptType readTenderReceipt (@Nonnull final Source aSource,
                                                     @Nullable ClassLoader aClassLoader,
                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, TenderReceiptType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TradeItemLocationProfile using
   * the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final Node aNode)
  {
    return readTradeItemLocationProfile (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TradeItemLocationProfile using
   * the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final Node aNode,
                                                                           @Nullable ClassLoader aClassLoader)
  {
    return readTradeItemLocationProfile (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TradeItemLocationProfile using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final Node aNode,
                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            TradeItemLocationProfileType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TradeItemLocationProfile using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final Node aNode,
                                                                           @Nullable ClassLoader aClassLoader,
                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            aClassLoader,
                                            TradeItemLocationProfileType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TradeItemLocationProfile using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final File aSource)
  {
    return readTradeItemLocationProfile (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TradeItemLocationProfile using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final File aSource,
                                                                           @Nullable ClassLoader aClassLoader)
  {
    return readTradeItemLocationProfile (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TradeItemLocationProfile using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final File aSource,
                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTradeItemLocationProfile (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TradeItemLocationProfile using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final File aSource,
                                                                           @Nullable ClassLoader aClassLoader,
                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTradeItemLocationProfile (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TradeItemLocationProfile using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final IReadableResource aSource)
  {
    return readTradeItemLocationProfile (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TradeItemLocationProfile using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final IReadableResource aSource,
                                                                           @Nullable ClassLoader aClassLoader)
  {
    return readTradeItemLocationProfile (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TradeItemLocationProfile using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final IReadableResource aSource,
                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTradeItemLocationProfile (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TradeItemLocationProfile using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final IReadableResource aSource,
                                                                           @Nullable ClassLoader aClassLoader,
                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTradeItemLocationProfile (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TradeItemLocationProfile using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final Source aSource)
  {
    return readTradeItemLocationProfile (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TradeItemLocationProfile using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final Source aSource,
                                                                           @Nullable ClassLoader aClassLoader)
  {
    return readTradeItemLocationProfile (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TradeItemLocationProfile using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final Source aSource,
                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            TradeItemLocationProfileType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TradeItemLocationProfile using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TradeItemLocationProfileType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TradeItemLocationProfileType readTradeItemLocationProfile (@Nonnull final Source aSource,
                                                                           @Nullable ClassLoader aClassLoader,
                                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            TradeItemLocationProfileType.class,
                                            aCustomEventHandler);
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
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Node aNode,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
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
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Node aNode,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, TransportationStatusType.class, aCustomEventHandler);
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
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Source aSource,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
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
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Source aSource,
                                                                   @Nullable ClassLoader aClassLoader,
                                                                   @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, TransportationStatusType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportationStatusRequest
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final Node aNode)
  {
    return readTransportationStatusRequest (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportationStatusRequest
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final Node aNode,
                                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readTransportationStatusRequest (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportationStatusRequest
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final Node aNode,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            TransportationStatusRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportationStatusRequest
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final Node aNode,
                                                                                 @Nullable ClassLoader aClassLoader,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            aClassLoader,
                                            TransportationStatusRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportationStatusRequest using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final File aSource)
  {
    return readTransportationStatusRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TransportationStatusRequest using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final File aSource,
                                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readTransportationStatusRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TransportationStatusRequest using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final File aSource,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportationStatusRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportationStatusRequest using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final File aSource,
                                                                                 @Nullable ClassLoader aClassLoader,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportationStatusRequest (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportationStatusRequest using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final IReadableResource aSource)
  {
    return readTransportationStatusRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportationStatusRequest using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final IReadableResource aSource,
                                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readTransportationStatusRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportationStatusRequest using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final IReadableResource aSource,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportationStatusRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportationStatusRequest using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final IReadableResource aSource,
                                                                                 @Nullable ClassLoader aClassLoader,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportationStatusRequest (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportationStatusRequest using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final Source aSource)
  {
    return readTransportationStatusRequest (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportationStatusRequest using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final Source aSource,
                                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readTransportationStatusRequest (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportationStatusRequest using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final Source aSource,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            TransportationStatusRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportationStatusRequest using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusRequestType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportationStatusRequestType readTransportationStatusRequest (@Nonnull final Source aSource,
                                                                                 @Nullable ClassLoader aClassLoader,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            TransportationStatusRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportExecutionPlan using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final Node aNode)
  {
    return readTransportExecutionPlan (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportExecutionPlan using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readTransportExecutionPlan (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportExecutionPlan using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final Node aNode,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            TransportExecutionPlanType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportExecutionPlan using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final Node aNode,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, TransportExecutionPlanType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportExecutionPlan using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final File aSource)
  {
    return readTransportExecutionPlan (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TransportExecutionPlan using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readTransportExecutionPlan (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TransportExecutionPlan using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final File aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportExecutionPlan (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportExecutionPlan using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final File aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportExecutionPlan (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportExecutionPlan
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final IReadableResource aSource)
  {
    return readTransportExecutionPlan (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportExecutionPlan
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readTransportExecutionPlan (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportExecutionPlan
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportExecutionPlan (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportExecutionPlan
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final IReadableResource aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportExecutionPlan (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportExecutionPlan using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final Source aSource)
  {
    return readTransportExecutionPlan (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportExecutionPlan using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readTransportExecutionPlan (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportExecutionPlan using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final Source aSource,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            TransportExecutionPlanType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportExecutionPlan using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanType readTransportExecutionPlan (@Nonnull final Source aSource,
                                                                       @Nullable ClassLoader aClassLoader,
                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            TransportExecutionPlanType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportExecutionPlanRequest
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final Node aNode)
  {
    return readTransportExecutionPlanRequest (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportExecutionPlanRequest
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final Node aNode,
                                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTransportExecutionPlanRequest (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportExecutionPlanRequest
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final Node aNode,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            TransportExecutionPlanRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportExecutionPlanRequest
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final Node aNode,
                                                                                     @Nullable ClassLoader aClassLoader,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            aClassLoader,
                                            TransportExecutionPlanRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportExecutionPlanRequest using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final File aSource)
  {
    return readTransportExecutionPlanRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TransportExecutionPlanRequest using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final File aSource,
                                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTransportExecutionPlanRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TransportExecutionPlanRequest using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final File aSource,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportExecutionPlanRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportExecutionPlanRequest using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final File aSource,
                                                                                     @Nullable ClassLoader aClassLoader,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportExecutionPlanRequest (TransformSourceFactory.create (aSource),
                                              aClassLoader,
                                              aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportExecutionPlanRequest using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final IReadableResource aSource)
  {
    return readTransportExecutionPlanRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportExecutionPlanRequest using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final IReadableResource aSource,
                                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTransportExecutionPlanRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportExecutionPlanRequest using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final IReadableResource aSource,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportExecutionPlanRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportExecutionPlanRequest using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final IReadableResource aSource,
                                                                                     @Nullable ClassLoader aClassLoader,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportExecutionPlanRequest (TransformSourceFactory.create (aSource),
                                              aClassLoader,
                                              aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportExecutionPlanRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final Source aSource)
  {
    return readTransportExecutionPlanRequest (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportExecutionPlanRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final Source aSource,
                                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readTransportExecutionPlanRequest (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportExecutionPlanRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final Source aSource,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            TransportExecutionPlanRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportExecutionPlanRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportExecutionPlanRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportExecutionPlanRequestType readTransportExecutionPlanRequest (@Nonnull final Source aSource,
                                                                                     @Nullable ClassLoader aClassLoader,
                                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            TransportExecutionPlanRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportProgressStatus using
   * the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final Node aNode)
  {
    return readTransportProgressStatus (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportProgressStatus using
   * the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final Node aNode,
                                                                         @Nullable ClassLoader aClassLoader)
  {
    return readTransportProgressStatus (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportProgressStatus using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final Node aNode,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            TransportProgressStatusType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportProgressStatus using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final Node aNode,
                                                                         @Nullable ClassLoader aClassLoader,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            aClassLoader,
                                            TransportProgressStatusType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportProgressStatus using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final File aSource)
  {
    return readTransportProgressStatus (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TransportProgressStatus using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final File aSource,
                                                                         @Nullable ClassLoader aClassLoader)
  {
    return readTransportProgressStatus (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TransportProgressStatus using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final File aSource,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportProgressStatus (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportProgressStatus using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final File aSource,
                                                                         @Nullable ClassLoader aClassLoader,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportProgressStatus (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportProgressStatus
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final IReadableResource aSource)
  {
    return readTransportProgressStatus (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportProgressStatus
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final IReadableResource aSource,
                                                                         @Nullable ClassLoader aClassLoader)
  {
    return readTransportProgressStatus (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportProgressStatus
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final IReadableResource aSource,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportProgressStatus (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportProgressStatus
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final IReadableResource aSource,
                                                                         @Nullable ClassLoader aClassLoader,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportProgressStatus (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportProgressStatus using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final Source aSource)
  {
    return readTransportProgressStatus (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportProgressStatus using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final Source aSource,
                                                                         @Nullable ClassLoader aClassLoader)
  {
    return readTransportProgressStatus (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportProgressStatus using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final Source aSource,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            TransportProgressStatusType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportProgressStatus using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusType readTransportProgressStatus (@Nonnull final Source aSource,
                                                                         @Nullable ClassLoader aClassLoader,
                                                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            TransportProgressStatusType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportProgressStatusRequest
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final Node aNode)
  {
    return readTransportProgressStatusRequest (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportProgressStatusRequest
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final Node aNode,
                                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readTransportProgressStatusRequest (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportProgressStatusRequest
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final Node aNode,
                                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            TransportProgressStatusRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportProgressStatusRequest
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final Node aNode,
                                                                                       @Nullable ClassLoader aClassLoader,
                                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            aClassLoader,
                                            TransportProgressStatusRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportProgressStatusRequest using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final File aSource)
  {
    return readTransportProgressStatusRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TransportProgressStatusRequest using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final File aSource,
                                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readTransportProgressStatusRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TransportProgressStatusRequest using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final File aSource,
                                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportProgressStatusRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportProgressStatusRequest using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final File aSource,
                                                                                       @Nullable ClassLoader aClassLoader,
                                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportProgressStatusRequest (TransformSourceFactory.create (aSource),
                                               aClassLoader,
                                               aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportProgressStatusRequest using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final IReadableResource aSource)
  {
    return readTransportProgressStatusRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportProgressStatusRequest using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final IReadableResource aSource,
                                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readTransportProgressStatusRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportProgressStatusRequest using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final IReadableResource aSource,
                                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportProgressStatusRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportProgressStatusRequest using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final IReadableResource aSource,
                                                                                       @Nullable ClassLoader aClassLoader,
                                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportProgressStatusRequest (TransformSourceFactory.create (aSource),
                                               aClassLoader,
                                               aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportProgressStatusRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final Source aSource)
  {
    return readTransportProgressStatusRequest (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportProgressStatusRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final Source aSource,
                                                                                       @Nullable ClassLoader aClassLoader)
  {
    return readTransportProgressStatusRequest (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportProgressStatusRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final Source aSource,
                                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            TransportProgressStatusRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportProgressStatusRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportProgressStatusRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportProgressStatusRequestType readTransportProgressStatusRequest (@Nonnull final Source aSource,
                                                                                       @Nullable ClassLoader aClassLoader,
                                                                                       @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            TransportProgressStatusRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportServiceDescription
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final Node aNode)
  {
    return readTransportServiceDescription (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportServiceDescription
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final Node aNode,
                                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readTransportServiceDescription (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportServiceDescription
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final Node aNode,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            TransportServiceDescriptionType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportServiceDescription
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final Node aNode,
                                                                                 @Nullable ClassLoader aClassLoader,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            aClassLoader,
                                            TransportServiceDescriptionType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportServiceDescription using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final File aSource)
  {
    return readTransportServiceDescription (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TransportServiceDescription using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final File aSource,
                                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readTransportServiceDescription (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TransportServiceDescription using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final File aSource,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportServiceDescription (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportServiceDescription using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final File aSource,
                                                                                 @Nullable ClassLoader aClassLoader,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportServiceDescription (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportServiceDescription using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final IReadableResource aSource)
  {
    return readTransportServiceDescription (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportServiceDescription using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final IReadableResource aSource,
                                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readTransportServiceDescription (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportServiceDescription using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final IReadableResource aSource,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportServiceDescription (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportServiceDescription using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final IReadableResource aSource,
                                                                                 @Nullable ClassLoader aClassLoader,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportServiceDescription (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportServiceDescription using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final Source aSource)
  {
    return readTransportServiceDescription (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportServiceDescription using
   * the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final Source aSource,
                                                                                 @Nullable ClassLoader aClassLoader)
  {
    return readTransportServiceDescription (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportServiceDescription using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final Source aSource,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            TransportServiceDescriptionType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportServiceDescription using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionType or <code>null</code>
   *         in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionType readTransportServiceDescription (@Nonnull final Source aSource,
                                                                                 @Nullable ClassLoader aClassLoader,
                                                                                 @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            TransportServiceDescriptionType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a
   * TransportServiceDescriptionRequest using the global validation event
   * handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final Node aNode)
  {
    return readTransportServiceDescriptionRequest (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a
   * TransportServiceDescriptionRequest using the global validation event
   * handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final Node aNode,
                                                                                               @Nullable ClassLoader aClassLoader)
  {
    return readTransportServiceDescriptionRequest (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a
   * TransportServiceDescriptionRequest using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final Node aNode,
                                                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            TransportServiceDescriptionRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a
   * TransportServiceDescriptionRequest using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final Node aNode,
                                                                                               @Nullable ClassLoader aClassLoader,
                                                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            aClassLoader,
                                            TransportServiceDescriptionRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportServiceDescriptionRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final File aSource)
  {
    return readTransportServiceDescriptionRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TransportServiceDescriptionRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final File aSource,
                                                                                               @Nullable ClassLoader aClassLoader)
  {
    return readTransportServiceDescriptionRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a TransportServiceDescriptionRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final File aSource,
                                                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportServiceDescriptionRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportServiceDescriptionRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final File aSource,
                                                                                               @Nullable ClassLoader aClassLoader,
                                                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportServiceDescriptionRequest (TransformSourceFactory.create (aSource),
                                                   aClassLoader,
                                                   aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportServiceDescriptionRequest using the global validation event
   * handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final IReadableResource aSource)
  {
    return readTransportServiceDescriptionRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportServiceDescriptionRequest using the global validation event
   * handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final IReadableResource aSource,
                                                                                               @Nullable ClassLoader aClassLoader)
  {
    return readTransportServiceDescriptionRequest (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportServiceDescriptionRequest using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final IReadableResource aSource,
                                                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportServiceDescriptionRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * TransportServiceDescriptionRequest using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final IReadableResource aSource,
                                                                                               @Nullable ClassLoader aClassLoader,
                                                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readTransportServiceDescriptionRequest (TransformSourceFactory.create (aSource),
                                                   aClassLoader,
                                                   aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportServiceDescriptionRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final Source aSource)
  {
    return readTransportServiceDescriptionRequest (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportServiceDescriptionRequest
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final Source aSource,
                                                                                               @Nullable ClassLoader aClassLoader)
  {
    return readTransportServiceDescriptionRequest (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportServiceDescriptionRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final Source aSource,
                                                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            TransportServiceDescriptionRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportServiceDescriptionRequest
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportServiceDescriptionRequestType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static TransportServiceDescriptionRequestType readTransportServiceDescriptionRequest (@Nonnull final Source aSource,
                                                                                               @Nullable ClassLoader aClassLoader,
                                                                                               @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            TransportServiceDescriptionRequestType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a UnawardedNotification using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final Node aNode)
  {
    return readUnawardedNotification (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a UnawardedNotification using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final Node aNode,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readUnawardedNotification (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a UnawardedNotification using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final Node aNode,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode,
                                            (ClassLoader) null,
                                            UnawardedNotificationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a UnawardedNotification using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final Node aNode,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, UnawardedNotificationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a UnawardedNotification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final File aSource)
  {
    return readUnawardedNotification (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a UnawardedNotification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final File aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readUnawardedNotification (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a UnawardedNotification using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final File aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readUnawardedNotification (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a UnawardedNotification using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final File aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readUnawardedNotification (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a UnawardedNotification
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final IReadableResource aSource)
  {
    return readUnawardedNotification (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a UnawardedNotification
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readUnawardedNotification (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a UnawardedNotification
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readUnawardedNotification (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a UnawardedNotification
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final IReadableResource aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readUnawardedNotification (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a UnawardedNotification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final Source aSource)
  {
    return readUnawardedNotification (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a UnawardedNotification using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final Source aSource,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return readUnawardedNotification (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a UnawardedNotification using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final Source aSource,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            UnawardedNotificationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a UnawardedNotification using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UnawardedNotificationType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static UnawardedNotificationType readUnawardedNotification (@Nonnull final Source aSource,
                                                                     @Nullable ClassLoader aClassLoader,
                                                                     @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            aClassLoader,
                                            UnawardedNotificationType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a UtilityStatement using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final Node aNode)
  {
    return readUtilityStatement (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a UtilityStatement using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readUtilityStatement (aNode, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a UtilityStatement using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final Node aNode,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, UtilityStatementType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a UtilityStatement using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final Node aNode,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, UtilityStatementType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a UtilityStatement using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final File aSource)
  {
    return readUtilityStatement (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a UtilityStatement using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final File aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readUtilityStatement (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link File} as a UtilityStatement using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final File aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readUtilityStatement (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a UtilityStatement using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final File aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readUtilityStatement (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a UtilityStatement using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final IReadableResource aSource)
  {
    return readUtilityStatement (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a UtilityStatement using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final IReadableResource aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readUtilityStatement (TransformSourceFactory.create (aSource), aClassLoader);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a UtilityStatement using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final IReadableResource aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readUtilityStatement (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a UtilityStatement using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final IReadableResource aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return readUtilityStatement (TransformSourceFactory.create (aSource), aClassLoader, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a UtilityStatement using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final Source aSource)
  {
    return readUtilityStatement (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a UtilityStatement using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return readUtilityStatement (aSource, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a UtilityStatement using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final Source aSource,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource,
                                            (ClassLoader) null,
                                            UtilityStatementType.class,
                                            aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a UtilityStatement using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated UtilityStatementType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static UtilityStatementType readUtilityStatement (@Nonnull final Source aSource,
                                                           @Nullable ClassLoader aClassLoader,
                                                           @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, UtilityStatementType.class, aCustomEventHandler);
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
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Node aNode,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, (ClassLoader) null, WaybillType.class, aCustomEventHandler);
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
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Node aNode,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aNode, aClassLoader, WaybillType.class, aCustomEventHandler);
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
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Source aSource,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, (ClassLoader) null, WaybillType.class, aCustomEventHandler);
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
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Source aSource,
                                         @Nullable ClassLoader aClassLoader,
                                         @Nullable ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.readUBLDocument (aSource, aClassLoader, WaybillType.class, aCustomEventHandler);
  }
}
