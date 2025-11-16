/*
 * Copyright (C) 2014-2025 Philip Helger (www.helger.com)
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

import org.jspecify.annotations.NonNull;

import com.helger.annotation.Nonempty;
import com.helger.annotation.misc.Since;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.base.lang.clazz.ClassHelper;
import com.helger.base.string.StringHelper;
import com.helger.collection.commons.ICommonsList;
import com.helger.io.resource.ClassPathResource;

/**
 * Enumeration with all available UBL 2.1 document types.
 *
 * @author Philip Helger
 */
public enum EUBL21DocumentType
{
  APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ApplicationResponseType.class,
                        UBL21Marshaller.getAllApplicationResponseXSDs ()),
  ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_21.AttachedDocumentType.class,
                     UBL21Marshaller.getAllAttachedDocumentXSDs ()),
  @Since ("2.1")
  AWARDED_NOTIFICATION(oasis.names.specification.ubl.schema.xsd.awardednotification_21.AwardedNotificationType.class,
                       UBL21Marshaller.getAllAwardedNotificationXSDs ()),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_21.BillOfLadingType.class,
                  UBL21Marshaller.getAllBillOfLadingXSDs ()),
  @Since ("2.1")
  CALL_FOR_TENDERS(oasis.names.specification.ubl.schema.xsd.callfortenders_21.CallForTendersType.class,
                   UBL21Marshaller.getAllCallForTendersXSDs ()),
  CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_21.CatalogueType.class, UBL21Marshaller.getAllCatalogueXSDs ()),
  CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_21.CatalogueDeletionType.class,
                      UBL21Marshaller.getAllCatalogueDeletionXSDs ()),
  CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_21.CatalogueItemSpecificationUpdateType.class,
                                       UBL21Marshaller.getAllCatalogueItemSpecificationUpdateXSDs ()),
  CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_21.CataloguePricingUpdateType.class,
                            UBL21Marshaller.getAllCataloguePricingUpdateXSDs ()),
  CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_21.CatalogueRequestType.class,
                     UBL21Marshaller.getAllCatalogueRequestXSDs ()),
  CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_21.CertificateOfOriginType.class,
                         UBL21Marshaller.getAllCertificateOfOriginXSDs ()),
  @Since ("2.1")
  CONTRACT_AWARD_NOTICE(oasis.names.specification.ubl.schema.xsd.contractawardnotice_21.ContractAwardNoticeType.class,
                        UBL21Marshaller.getAllContractAwardNoticeXSDs ()),
  @Since ("2.1")
  CONTRACT_NOTICE(oasis.names.specification.ubl.schema.xsd.contractnotice_21.ContractNoticeType.class,
                  UBL21Marshaller.getAllContractNoticeXSDs ()),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType.class, UBL21Marshaller.getAllCreditNoteXSDs ()),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType.class, UBL21Marshaller.getAllDebitNoteXSDs ()),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_21.DespatchAdviceType.class,
                   UBL21Marshaller.getAllDespatchAdviceXSDs ()),
  @Since ("2.1")
  DOCUMENT_STATUS(oasis.names.specification.ubl.schema.xsd.documentstatus_21.DocumentStatusType.class,
                  UBL21Marshaller.getAllDocumentStatusXSDs ()),
  @Since ("2.1")
  DOCUMENT_STATUS_REQUEST(oasis.names.specification.ubl.schema.xsd.documentstatusrequest_21.DocumentStatusRequestType.class,
                          UBL21Marshaller.getAllDocumentStatusRequestXSDs ()),
  @Since ("2.1")
  EXCEPTION_CRITERIA(oasis.names.specification.ubl.schema.xsd.exceptioncriteria_21.ExceptionCriteriaType.class,
                     UBL21Marshaller.getAllExceptionCriteriaXSDs ()),
  @Since ("2.1")
  EXCEPTION_NOTIFICATION(oasis.names.specification.ubl.schema.xsd.exceptionnotification_21.ExceptionNotificationType.class,
                         UBL21Marshaller.getAllExceptionNotificationXSDs ()),
  @Since ("2.1")
  FORECAST(oasis.names.specification.ubl.schema.xsd.forecast_21.ForecastType.class, UBL21Marshaller.getAllForecastXSDs ()),
  @Since ("2.1")
  FORECAST_REVISION(oasis.names.specification.ubl.schema.xsd.forecastrevision_21.ForecastRevisionType.class,
                    UBL21Marshaller.getAllForecastRevisionXSDs ()),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_21.ForwardingInstructionsType.class,
                           UBL21Marshaller.getAllForwardingInstructionsXSDs ()),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_21.FreightInvoiceType.class,
                   UBL21Marshaller.getAllFreightInvoiceXSDs ()),
  @Since ("2.1")
  FULFILMENT_CANCELLATION(oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_21.FulfilmentCancellationType.class,
                          UBL21Marshaller.getAllFulfilmentCancellationXSDs ()),
  @Since ("2.1")
  GOODS_ITEM_ITINERARY(oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_21.GoodsItemItineraryType.class,
                       UBL21Marshaller.getAllGoodsItemItineraryXSDs ()),
  @Since ("2.1")
  GUARANTEE_CERTIFICATE(oasis.names.specification.ubl.schema.xsd.guaranteecertificate_21.GuaranteeCertificateType.class,
                        UBL21Marshaller.getAllGuaranteeCertificateXSDs ()),
  @Since ("2.1")
  INSTRUCTION_FOR_RETURNS(oasis.names.specification.ubl.schema.xsd.instructionforreturns_21.InstructionForReturnsType.class,
                          UBL21Marshaller.getAllInstructionForReturnsXSDs ()),
  @Since ("2.1")
  INVENTORY_REPORT(oasis.names.specification.ubl.schema.xsd.inventoryreport_21.InventoryReportType.class,
                   UBL21Marshaller.getAllInventoryReportXSDs ()),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType.class, UBL21Marshaller.getAllInvoiceXSDs ()),
  @Since ("2.1")
  ITEM_INFORMATION_REQUEST(oasis.names.specification.ubl.schema.xsd.iteminformationrequest_21.ItemInformationRequestType.class,
                           UBL21Marshaller.getAllItemInformationRequestXSDs ()),
  ORDER (oasis.names.specification.ubl.schema.xsd.order_21.OrderType.class, UBL21Marshaller.getAllOrderXSDs ()),
  ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_21.OrderCancellationType.class,
                      UBL21Marshaller.getAllOrderCancellationXSDs ()),
  ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_21.OrderChangeType.class, UBL21Marshaller.getAllOrderChangeXSDs ()),
  ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_21.OrderResponseType.class,
                  UBL21Marshaller.getAllOrderResponseXSDs ()),
  ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_21.OrderResponseSimpleType.class,
                         UBL21Marshaller.getAllOrderResponseSimpleXSDs ()),
  PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_21.PackingListType.class, UBL21Marshaller.getAllPackingListXSDs ()),
  @Since ("2.1")
  PRIOR_INFORMATION_NOTICE(oasis.names.specification.ubl.schema.xsd.priorinformationnotice_21.PriorInformationNoticeType.class,
                           UBL21Marshaller.getAllPriorInformationNoticeXSDs ()),
  @Since ("2.1")
  PRODUCT_ACTIVITY(oasis.names.specification.ubl.schema.xsd.productactivity_21.ProductActivityType.class,
                   UBL21Marshaller.getAllProductActivityXSDs ()),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_21.QuotationType.class, UBL21Marshaller.getAllQuotationXSDs ()),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_21.ReceiptAdviceType.class,
                  UBL21Marshaller.getAllReceiptAdviceXSDs ()),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_21.ReminderType.class, UBL21Marshaller.getAllReminderXSDs ()),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_21.RemittanceAdviceType.class,
                     UBL21Marshaller.getAllRemittanceAdviceXSDs ()),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_21.RequestForQuotationType.class,
                         UBL21Marshaller.getAllRequestForQuotationXSDs ()),
  @Since ("2.1")
  RETAIL_EVENT(oasis.names.specification.ubl.schema.xsd.retailevent_21.RetailEventType.class, UBL21Marshaller.getAllRetailEventXSDs ()),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_21.SelfBilledCreditNoteType.class,
                           UBL21Marshaller.getAllSelfBilledCreditNoteXSDs ()),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_21.SelfBilledInvoiceType.class,
                       UBL21Marshaller.getAllSelfBilledInvoiceXSDs ()),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_21.StatementType.class, UBL21Marshaller.getAllStatementXSDs ()),
  @Since ("2.1")
  STOCK_AVAILABILITY_REPORT(oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_21.StockAvailabilityReportType.class,
                            UBL21Marshaller.getAllStockAvailabilityReportXSDs ()),
  @Since ("2.1")
  TENDER(oasis.names.specification.ubl.schema.xsd.tender_21.TenderType.class, UBL21Marshaller.getAllTenderXSDs ()),
  @Since ("2.1")
  TENDER_RECEIPT(oasis.names.specification.ubl.schema.xsd.tenderreceipt_21.TenderReceiptType.class,
                 UBL21Marshaller.getAllTenderReceiptXSDs ()),
  @Since ("2.1")
  TENDERER_QUALIFICATION(oasis.names.specification.ubl.schema.xsd.tendererqualification_21.TendererQualificationType.class,
                         UBL21Marshaller.getAllTendererQualificationXSDs ()),
  @Since ("2.1")
  TENDERER_QUALIFICATION_RESPONSE(oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_21.TendererQualificationResponseType.class,
                                  UBL21Marshaller.getAllTendererQualificationResponseXSDs ()),
  @Since ("2.1")
  TRADE_ITEM_LOCATION_PROFILE(oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_21.TradeItemLocationProfileType.class,
                              UBL21Marshaller.getAllTradeItemLocationProfileXSDs ()),
  @Since ("2.1")
  TRANSPORT_EXECUTION_PLAN(oasis.names.specification.ubl.schema.xsd.transportexecutionplan_21.TransportExecutionPlanType.class,
                           UBL21Marshaller.getAllTransportExecutionPlanXSDs ()),
  @Since ("2.1")
  TRANSPORT_EXECUTION_PLAN_REQUEST(oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_21.TransportExecutionPlanRequestType.class,
                                   UBL21Marshaller.getAllTransportExecutionPlanRequestXSDs ()),
  @Since ("2.1")
  TRANSPORT_PROGRESS_STATUS(oasis.names.specification.ubl.schema.xsd.transportprogressstatus_21.TransportProgressStatusType.class,
                            UBL21Marshaller.getAllTransportProgressStatusXSDs ()),
  @Since ("2.1")
  TRANSPORT_PROGRESS_STATUS_REQUEST(oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_21.TransportProgressStatusRequestType.class,
                                    UBL21Marshaller.getAllTransportProgressStatusRequestXSDs ()),
  @Since ("2.1")
  TRANSPORT_SERVICE_DESCRIPTION(oasis.names.specification.ubl.schema.xsd.transportservicedescription_21.TransportServiceDescriptionType.class,
                                UBL21Marshaller.getAllTransportServiceDescriptionXSDs ()),
  @Since ("2.1")
  TRANSPORT_SERVICE_DESCRIPTION_REQUEST(oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_21.TransportServiceDescriptionRequestType.class,
                                        UBL21Marshaller.getAllTransportServiceDescriptionRequestXSDs ()),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_21.TransportationStatusType.class,
                         UBL21Marshaller.getAllTransportationStatusXSDs ()),
  @Since ("2.1")
  TRANSPORTATION_STATUS_REQUEST(oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_21.TransportationStatusRequestType.class,
                                UBL21Marshaller.getAllTransportationStatusRequestXSDs ()),
  @Since ("2.1")
  UNAWARDED_NOTIFICATION(oasis.names.specification.ubl.schema.xsd.unawardednotification_21.UnawardedNotificationType.class,
                         UBL21Marshaller.getAllUnawardedNotificationXSDs ()),
  @Since ("2.1")
  UTILITY_STATEMENT(oasis.names.specification.ubl.schema.xsd.utilitystatement_21.UtilityStatementType.class,
                    UBL21Marshaller.getAllUtilityStatementXSDs ()),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_21.WaybillType.class, UBL21Marshaller.getAllWaybillXSDs ());

  private final Class <?> m_aImplClass;
  private final ICommonsList <ClassPathResource> m_aXSDs;
  private final String m_sRootElementLocalName;
  private final String m_sRootElementNSURI;

  EUBL21DocumentType (@NonNull final Class <?> aClass, @NonNull final ICommonsList <ClassPathResource> aXSDs)
  {
    m_aImplClass = aClass;
    m_aXSDs = aXSDs;
    m_sRootElementLocalName = StringHelper.trimEnd (ClassHelper.getClassLocalName (aClass), "Type");
    m_sRootElementNSURI = aClass.getPackage ().getAnnotation (jakarta.xml.bind.annotation.XmlSchema.class).namespace ();
  }

  @NonNull
  public Class <?> getImplementationClass ()
  {
    return m_aImplClass;
  }

  @NonNull
  @Nonempty
  @ReturnsMutableCopy
  public ICommonsList <ClassPathResource> getAllXSDResources ()
  {
    return m_aXSDs.getClone ();
  }

  /**
   * @return The local element name of the root element of this document type.
   *         E.g. <code>OrderCancellation</code> for "Order Cancellation".
   */
  @NonNull
  @Nonempty
  public String getRootElementLocalName ()
  {
    return m_sRootElementLocalName;
  }

  /**
   * @return The XML namespace URI of the root element of this document type.
   *         E.g.
   *         <code>urn:oasis:names:specification:ubl:schema:xsd:OrderCancellation-2</code>
   *         for "Order Cancellation".
   */
  @NonNull
  @Nonempty
  public String getRootElementNamespaceURI ()
  {
    return m_sRootElementNSURI;
  }
}
