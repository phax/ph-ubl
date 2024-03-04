/*
 * Copyright (C) 2014-2024 Philip Helger (www.helger.com)
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

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;

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
  AWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.awardednotification_21.AwardedNotificationType.class,
                        UBL21Marshaller.getAllAwardedNotificationXSDs ()),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_21.BillOfLadingType.class,
                  UBL21Marshaller.getAllBillOfLadingXSDs ()),
  CALL_FOR_TENDERS (oasis.names.specification.ubl.schema.xsd.callfortenders_21.CallForTendersType.class,
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
  CONTRACT_AWARD_NOTICE (oasis.names.specification.ubl.schema.xsd.contractawardnotice_21.ContractAwardNoticeType.class,
                         UBL21Marshaller.getAllContractAwardNoticeXSDs ()),
  CONTRACT_NOTICE (oasis.names.specification.ubl.schema.xsd.contractnotice_21.ContractNoticeType.class,
                   UBL21Marshaller.getAllContractNoticeXSDs ()),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType.class, UBL21Marshaller.getAllCreditNoteXSDs ()),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType.class, UBL21Marshaller.getAllDebitNoteXSDs ()),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_21.DespatchAdviceType.class,
                   UBL21Marshaller.getAllDespatchAdviceXSDs ()),
  DOCUMENT_STATUS (oasis.names.specification.ubl.schema.xsd.documentstatus_21.DocumentStatusType.class,
                   UBL21Marshaller.getAllDocumentStatusXSDs ()),
  DOCUMENT_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.documentstatusrequest_21.DocumentStatusRequestType.class,
                           UBL21Marshaller.getAllDocumentStatusRequestXSDs ()),
  EXCEPTION_CRITERIA (oasis.names.specification.ubl.schema.xsd.exceptioncriteria_21.ExceptionCriteriaType.class,
                      UBL21Marshaller.getAllExceptionCriteriaXSDs ()),
  EXCEPTION_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.exceptionnotification_21.ExceptionNotificationType.class,
                          UBL21Marshaller.getAllExceptionNotificationXSDs ()),
  FORECAST (oasis.names.specification.ubl.schema.xsd.forecast_21.ForecastType.class, UBL21Marshaller.getAllForecastXSDs ()),
  FORECAST_REVISION (oasis.names.specification.ubl.schema.xsd.forecastrevision_21.ForecastRevisionType.class,
                     UBL21Marshaller.getAllForecastRevisionXSDs ()),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_21.ForwardingInstructionsType.class,
                           UBL21Marshaller.getAllForwardingInstructionsXSDs ()),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_21.FreightInvoiceType.class,
                   UBL21Marshaller.getAllFreightInvoiceXSDs ()),
  FULFILMENT_CANCELATION (oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_21.FulfilmentCancellationType.class,
                          UBL21Marshaller.getAllFulfilmentCancellationXSDs ()),
  GOODS_ITEM_ITINERARY (oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_21.GoodsItemItineraryType.class,
                        UBL21Marshaller.getAllGoodsItemItineraryXSDs ()),
  GUARANTEE_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.guaranteecertificate_21.GuaranteeCertificateType.class,
                         UBL21Marshaller.getAllGuaranteeCertificateXSDs ()),
  INSTRUCTION_FOR_RETURNS (oasis.names.specification.ubl.schema.xsd.instructionforreturns_21.InstructionForReturnsType.class,
                           UBL21Marshaller.getAllInstructionForReturnsXSDs ()),
  INVENTORY_REPORT (oasis.names.specification.ubl.schema.xsd.inventoryreport_21.InventoryReportType.class,
                    UBL21Marshaller.getAllInventoryReportXSDs ()),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType.class, UBL21Marshaller.getAllInvoiceXSDs ()),
  ITEM_INFORMATION_REQUEST (oasis.names.specification.ubl.schema.xsd.iteminformationrequest_21.ItemInformationRequestType.class,
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
  PRIOR_INFORMATION_NOTICE (oasis.names.specification.ubl.schema.xsd.priorinformationnotice_21.PriorInformationNoticeType.class,
                            UBL21Marshaller.getAllPriorInformationNoticeXSDs ()),
  PRODUCT_ACTIVITY (oasis.names.specification.ubl.schema.xsd.productactivity_21.ProductActivityType.class,
                    UBL21Marshaller.getAllProductActivityXSDs ()),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_21.QuotationType.class, UBL21Marshaller.getAllQuotationXSDs ()),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_21.ReceiptAdviceType.class,
                  UBL21Marshaller.getAllReceiptAdviceXSDs ()),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_21.ReminderType.class, UBL21Marshaller.getAllReminderXSDs ()),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_21.RemittanceAdviceType.class,
                     UBL21Marshaller.getAllRemittanceAdviceXSDs ()),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_21.RequestForQuotationType.class,
                         UBL21Marshaller.getAllRequestForQuotationXSDs ()),
  RETAIL_EVENT (oasis.names.specification.ubl.schema.xsd.retailevent_21.RetailEventType.class, UBL21Marshaller.getAllRetailEventXSDs ()),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_21.SelfBilledCreditNoteType.class,
                           UBL21Marshaller.getAllSelfBilledCreditNoteXSDs ()),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_21.SelfBilledInvoiceType.class,
                       UBL21Marshaller.getAllSelfBilledInvoiceXSDs ()),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_21.StatementType.class, UBL21Marshaller.getAllStatementXSDs ()),
  STOCK_AVAILABILITY_REPORT (oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_21.StockAvailabilityReportType.class,
                             UBL21Marshaller.getAllStockAvailabilityReportXSDs ()),
  TENDER (oasis.names.specification.ubl.schema.xsd.tender_21.TenderType.class, UBL21Marshaller.getAllTenderXSDs ()),
  TENDERER_QUALIFICATION (oasis.names.specification.ubl.schema.xsd.tendererqualification_21.TendererQualificationType.class,
                          UBL21Marshaller.getAllTendererQualificationXSDs ()),
  TENDERER_QUALIFICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_21.TendererQualificationResponseType.class,
                                   UBL21Marshaller.getAllTendererQualificationResponseXSDs ()),
  TENDER_RECEIPT (oasis.names.specification.ubl.schema.xsd.tenderreceipt_21.TenderReceiptType.class,
                  UBL21Marshaller.getAllTenderReceiptXSDs ()),
  TRADE_ITEM_LOCATION_PROFILE (oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_21.TradeItemLocationProfileType.class,
                               UBL21Marshaller.getAllTradeItemLocationProfileXSDs ()),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_21.TransportationStatusType.class,
                         UBL21Marshaller.getAllTransportationStatusXSDs ()),
  TRANSPORTATION_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_21.TransportationStatusRequestType.class,
                                 UBL21Marshaller.getAllTransportationStatusRequestXSDs ()),
  TRANSPORT_EXECUTION_PLAN (oasis.names.specification.ubl.schema.xsd.transportexecutionplan_21.TransportExecutionPlanType.class,
                            UBL21Marshaller.getAllTransportExecutionPlanXSDs ()),
  TRANSPORT_EXECUTION_PLAN_REQUEST (oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_21.TransportExecutionPlanRequestType.class,
                                    UBL21Marshaller.getAllTransportExecutionPlanRequestXSDs ()),
  TRANSPORT_PROGRESS_STATUS (oasis.names.specification.ubl.schema.xsd.transportprogressstatus_21.TransportProgressStatusType.class,
                             UBL21Marshaller.getAllTransportProgressStatusXSDs ()),
  TRANSPORT_PROGRESS_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_21.TransportProgressStatusRequestType.class,
                                     UBL21Marshaller.getAllTransportProgressStatusRequestXSDs ()),
  TRANSPORT_SERVICE_DESCRIPTION (oasis.names.specification.ubl.schema.xsd.transportservicedescription_21.TransportServiceDescriptionType.class,
                                 UBL21Marshaller.getAllTransportServiceDescriptionXSDs ()),
  TRANSPORT_SERVICE_DESCRIPTION_REQUEST (oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_21.TransportServiceDescriptionRequestType.class,
                                         UBL21Marshaller.getAllTransportServiceDescriptionRequestXSDs ()),
  UNAWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.unawardednotification_21.UnawardedNotificationType.class,
                          UBL21Marshaller.getAllUnawardedNotificationXSDs ()),
  UTILITY_STATEMENT (oasis.names.specification.ubl.schema.xsd.utilitystatement_21.UtilityStatementType.class,
                     UBL21Marshaller.getAllUtilityStatementXSDs ()),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_21.WaybillType.class, UBL21Marshaller.getAllWaybillXSDs ());

  private final Class <?> m_aImplClass;
  private final ICommonsList <ClassPathResource> m_aXSDs;

  EUBL21DocumentType (@Nonnull final Class <?> aClass, @Nonnull final ICommonsList <ClassPathResource> aXSDs)
  {
    m_aImplClass = aClass;
    m_aXSDs = aXSDs;
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aImplClass;
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableCopy
  public ICommonsList <ClassPathResource> getAllXSDResources ()
  {
    return m_aXSDs.getClone ();
  }
}
