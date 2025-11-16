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
package com.helger.ubl22;

import org.jspecify.annotations.NonNull;

import com.helger.annotation.Nonempty;
import com.helger.annotation.misc.Since;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.base.lang.clazz.ClassHelper;
import com.helger.base.string.StringHelper;
import com.helger.collection.commons.ICommonsList;
import com.helger.io.resource.ClassPathResource;

/**
 * Enumeration with all available UBL 2.2 document types.
 *
 * @author Philip Helger
 */
public enum EUBL22DocumentType
{
  APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_22.ApplicationResponseType.class,
                        UBL22Marshaller.getAllApplicationResponseXSDs ()),
  ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_22.AttachedDocumentType.class,
                     UBL22Marshaller.getAllAttachedDocumentXSDs ()),
  AWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.awardednotification_22.AwardedNotificationType.class,
                        UBL22Marshaller.getAllAwardedNotificationXSDs ()),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_22.BillOfLadingType.class,
                  UBL22Marshaller.getAllBillOfLadingXSDs ()),
  @Since ("2.2")
  BUSINESS_CARD(oasis.names.specification.ubl.schema.xsd.businesscard_22.BusinessCardType.class, UBL22Marshaller.getAllBusinessCardXSDs ()),
  CALL_FOR_TENDERS (oasis.names.specification.ubl.schema.xsd.callfortenders_22.CallForTendersType.class,
                    UBL22Marshaller.getAllCallForTendersXSDs ()),
  CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_22.CatalogueType.class, UBL22Marshaller.getAllCatalogueXSDs ()),
  CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_22.CatalogueDeletionType.class,
                      UBL22Marshaller.getAllCatalogueDeletionXSDs ()),
  CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_22.CatalogueItemSpecificationUpdateType.class,
                                       UBL22Marshaller.getAllCatalogueItemSpecificationUpdateXSDs ()),
  CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_22.CataloguePricingUpdateType.class,
                            UBL22Marshaller.getAllCataloguePricingUpdateXSDs ()),
  CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_22.CatalogueRequestType.class,
                     UBL22Marshaller.getAllCatalogueRequestXSDs ()),
  CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_22.CertificateOfOriginType.class,
                         UBL22Marshaller.getAllCertificateOfOriginXSDs ()),
  CONTRACT_AWARD_NOTICE (oasis.names.specification.ubl.schema.xsd.contractawardnotice_22.ContractAwardNoticeType.class,
                         UBL22Marshaller.getAllContractAwardNoticeXSDs ()),
  CONTRACT_NOTICE (oasis.names.specification.ubl.schema.xsd.contractnotice_22.ContractNoticeType.class,
                   UBL22Marshaller.getAllContractNoticeXSDs ()),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_22.CreditNoteType.class, UBL22Marshaller.getAllCreditNoteXSDs ()),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_22.DebitNoteType.class, UBL22Marshaller.getAllDebitNoteXSDs ()),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_22.DespatchAdviceType.class,
                   UBL22Marshaller.getAllDespatchAdviceXSDs ()),
  @Since ("2.2")
  DIGITAL_AGREEMENT(oasis.names.specification.ubl.schema.xsd.digitalagreement_22.DigitalAgreementType.class,
                    UBL22Marshaller.getAllDigitalAgreementXSDs ()),
  @Since ("2.2")
  DIGITAL_CAPABILITY(oasis.names.specification.ubl.schema.xsd.digitalcapability_22.DigitalCapabilityType.class,
                     UBL22Marshaller.getAllDigitalCapabilityXSDs ()),
  DOCUMENT_STATUS (oasis.names.specification.ubl.schema.xsd.documentstatus_22.DocumentStatusType.class,
                   UBL22Marshaller.getAllDocumentStatusXSDs ()),
  DOCUMENT_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.documentstatusrequest_22.DocumentStatusRequestType.class,
                           UBL22Marshaller.getAllDocumentStatusRequestXSDs ()),
  @Since ("2.2")
  ENQUIRY(oasis.names.specification.ubl.schema.xsd.enquiry_22.EnquiryType.class, UBL22Marshaller.getAllEnquiryXSDs ()),
  @Since ("2.2")
  ENQUIRY_RESPONSE(oasis.names.specification.ubl.schema.xsd.enquiryresponse_22.EnquiryResponseType.class,
                   UBL22Marshaller.getAllEnquiryResponseXSDs ()),
  EXCEPTION_CRITERIA (oasis.names.specification.ubl.schema.xsd.exceptioncriteria_22.ExceptionCriteriaType.class,
                      UBL22Marshaller.getAllExceptionCriteriaXSDs ()),
  EXCEPTION_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.exceptionnotification_22.ExceptionNotificationType.class,
                          UBL22Marshaller.getAllExceptionNotificationXSDs ()),
  @Since ("2.2")
  EXPRESSION_OF_INTEREST_REQUEST(oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_22.ExpressionOfInterestRequestType.class,
                                 UBL22Marshaller.getAllExpressionOfInterestRequestXSDs ()),
  @Since ("2.2")
  EXPRESSION_OF_INTEREST_RESPONSE(oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_22.ExpressionOfInterestResponseType.class,
                                  UBL22Marshaller.getAllExpressionOfInterestResponseXSDs ()),
  FORECAST (oasis.names.specification.ubl.schema.xsd.forecast_22.ForecastType.class, UBL22Marshaller.getAllForecastXSDs ()),
  FORECAST_REVISION (oasis.names.specification.ubl.schema.xsd.forecastrevision_22.ForecastRevisionType.class,
                     UBL22Marshaller.getAllForecastRevisionXSDs ()),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_22.ForwardingInstructionsType.class,
                           UBL22Marshaller.getAllForwardingInstructionsXSDs ()),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_22.FreightInvoiceType.class,
                   UBL22Marshaller.getAllFreightInvoiceXSDs ()),
  FULFILMENT_CANCELLATION (oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_22.FulfilmentCancellationType.class,
                           UBL22Marshaller.getAllFulfilmentCancellationXSDs ()),
  GOODS_ITEM_ITINERARY (oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_22.GoodsItemItineraryType.class,
                        UBL22Marshaller.getAllGoodsItemItineraryXSDs ()),
  GUARANTEE_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.guaranteecertificate_22.GuaranteeCertificateType.class,
                         UBL22Marshaller.getAllGuaranteeCertificateXSDs ()),
  INSTRUCTION_FOR_RETURNS (oasis.names.specification.ubl.schema.xsd.instructionforreturns_22.InstructionForReturnsType.class,
                           UBL22Marshaller.getAllInstructionForReturnsXSDs ()),
  INVENTORY_REPORT (oasis.names.specification.ubl.schema.xsd.inventoryreport_22.InventoryReportType.class,
                    UBL22Marshaller.getAllInventoryReportXSDs ()),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_22.InvoiceType.class, UBL22Marshaller.getAllInvoiceXSDs ()),
  ITEM_INFORMATION_REQUEST (oasis.names.specification.ubl.schema.xsd.iteminformationrequest_22.ItemInformationRequestType.class,
                            UBL22Marshaller.getAllItemInformationRequestXSDs ()),
  ORDER (oasis.names.specification.ubl.schema.xsd.order_22.OrderType.class, UBL22Marshaller.getAllOrderXSDs ()),
  ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_22.OrderCancellationType.class,
                      UBL22Marshaller.getAllOrderCancellationXSDs ()),
  ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_22.OrderChangeType.class, UBL22Marshaller.getAllOrderChangeXSDs ()),
  ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_22.OrderResponseType.class,
                  UBL22Marshaller.getAllOrderResponseXSDs ()),
  ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_22.OrderResponseSimpleType.class,
                         UBL22Marshaller.getAllOrderResponseSimpleXSDs ()),
  PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_22.PackingListType.class, UBL22Marshaller.getAllPackingListXSDs ()),
  PRIOR_INFORMATION_NOTICE (oasis.names.specification.ubl.schema.xsd.priorinformationnotice_22.PriorInformationNoticeType.class,
                            UBL22Marshaller.getAllPriorInformationNoticeXSDs ()),
  PRODUCT_ACTIVITY (oasis.names.specification.ubl.schema.xsd.productactivity_22.ProductActivityType.class,
                    UBL22Marshaller.getAllProductActivityXSDs ()),
  @Since ("2.2")
  QUALIFICATION_APPLICATION_REQUEST(oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_22.QualificationApplicationRequestType.class,
                                    UBL22Marshaller.getAllQualificationApplicationRequestXSDs ()),
  @Since ("2.2")
  QUALIFICATION_APPLICATION_RESPONSE(oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_22.QualificationApplicationResponseType.class,
                                     UBL22Marshaller.getAllQualificationApplicationResponseXSDs ()),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_22.QuotationType.class, UBL22Marshaller.getAllQuotationXSDs ()),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_22.ReceiptAdviceType.class,
                  UBL22Marshaller.getAllReceiptAdviceXSDs ()),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_22.ReminderType.class, UBL22Marshaller.getAllReminderXSDs ()),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_22.RemittanceAdviceType.class,
                     UBL22Marshaller.getAllRemittanceAdviceXSDs ()),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_22.RequestForQuotationType.class,
                         UBL22Marshaller.getAllRequestForQuotationXSDs ()),
  RETAIL_EVENT (oasis.names.specification.ubl.schema.xsd.retailevent_22.RetailEventType.class, UBL22Marshaller.getAllRetailEventXSDs ()),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_22.SelfBilledCreditNoteType.class,
                           UBL22Marshaller.getAllSelfBilledCreditNoteXSDs ()),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_22.SelfBilledInvoiceType.class,
                       UBL22Marshaller.getAllSelfBilledInvoiceXSDs ()),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_22.StatementType.class, UBL22Marshaller.getAllStatementXSDs ()),
  STOCK_AVAILABILITY_REPORT (oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_22.StockAvailabilityReportType.class,
                             UBL22Marshaller.getAllStockAvailabilityReportXSDs ()),
  TENDER (oasis.names.specification.ubl.schema.xsd.tender_22.TenderType.class, UBL22Marshaller.getAllTenderXSDs ()),
  @Since ("2.2")
  TENDER_CONTRACT(oasis.names.specification.ubl.schema.xsd.tendercontract_22.TenderContractType.class,
                  UBL22Marshaller.getAllTenderContractXSDs ()),
  TENDER_RECEIPT (oasis.names.specification.ubl.schema.xsd.tenderreceipt_22.TenderReceiptType.class,
                  UBL22Marshaller.getAllTenderReceiptXSDs ()),
  @Since ("2.2")
  TENDER_STATUS(oasis.names.specification.ubl.schema.xsd.tenderstatus_22.TenderStatusType.class, UBL22Marshaller.getAllTenderStatusXSDs ()),
  @Since ("2.2")
  TENDER_STATUS_REQUEST(oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_22.TenderStatusRequestType.class,
                        UBL22Marshaller.getAllTenderStatusRequestXSDs ()),
  @Since ("2.2")
  TENDER_WITHDRAWAL(oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_22.TenderWithdrawalType.class,
                    UBL22Marshaller.getAllTenderWithdrawalXSDs ()),
  TENDERER_QUALIFICATION (oasis.names.specification.ubl.schema.xsd.tendererqualification_22.TendererQualificationType.class,
                          UBL22Marshaller.getAllTendererQualificationXSDs ()),
  TENDERER_QUALIFICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_22.TendererQualificationResponseType.class,
                                   UBL22Marshaller.getAllTendererQualificationResponseXSDs ()),
  TRADE_ITEM_LOCATION_PROFILE (oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_22.TradeItemLocationProfileType.class,
                               UBL22Marshaller.getAllTradeItemLocationProfileXSDs ()),
  TRANSPORT_EXECUTION_PLAN (oasis.names.specification.ubl.schema.xsd.transportexecutionplan_22.TransportExecutionPlanType.class,
                            UBL22Marshaller.getAllTransportExecutionPlanXSDs ()),
  TRANSPORT_EXECUTION_PLAN_REQUEST (oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_22.TransportExecutionPlanRequestType.class,
                                    UBL22Marshaller.getAllTransportExecutionPlanRequestXSDs ()),
  TRANSPORT_PROGRESS_STATUS (oasis.names.specification.ubl.schema.xsd.transportprogressstatus_22.TransportProgressStatusType.class,
                             UBL22Marshaller.getAllTransportProgressStatusXSDs ()),
  TRANSPORT_PROGRESS_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_22.TransportProgressStatusRequestType.class,
                                     UBL22Marshaller.getAllTransportProgressStatusRequestXSDs ()),
  TRANSPORT_SERVICE_DESCRIPTION (oasis.names.specification.ubl.schema.xsd.transportservicedescription_22.TransportServiceDescriptionType.class,
                                 UBL22Marshaller.getAllTransportServiceDescriptionXSDs ()),
  TRANSPORT_SERVICE_DESCRIPTION_REQUEST (oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_22.TransportServiceDescriptionRequestType.class,
                                         UBL22Marshaller.getAllTransportServiceDescriptionRequestXSDs ()),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_22.TransportationStatusType.class,
                         UBL22Marshaller.getAllTransportationStatusXSDs ()),
  TRANSPORTATION_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_22.TransportationStatusRequestType.class,
                                 UBL22Marshaller.getAllTransportationStatusRequestXSDs ()),
  UNAWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.unawardednotification_22.UnawardedNotificationType.class,
                          UBL22Marshaller.getAllUnawardedNotificationXSDs ()),
  @Since ("2.2")
  UNSUBSCRIBE_FROM_PROCEDURE_REQUEST(oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_22.UnsubscribeFromProcedureRequestType.class,
                                     UBL22Marshaller.getAllUnsubscribeFromProcedureRequestXSDs ()),
  @Since ("2.2")
  UNSUBSCRIBE_FROM_PROCEDURE_RESPONSE(oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_22.UnsubscribeFromProcedureResponseType.class,
                                      UBL22Marshaller.getAllUnsubscribeFromProcedureResponseXSDs ()),
  UTILITY_STATEMENT (oasis.names.specification.ubl.schema.xsd.utilitystatement_22.UtilityStatementType.class,
                     UBL22Marshaller.getAllUtilityStatementXSDs ()),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_22.WaybillType.class, UBL22Marshaller.getAllWaybillXSDs ()),
  @Since ("2.2")
  WEIGHT_STATEMENT(oasis.names.specification.ubl.schema.xsd.weightstatement_22.WeightStatementType.class,
                   UBL22Marshaller.getAllWeightStatementXSDs ());

  private final Class <?> m_aImplClass;
  private final ICommonsList <ClassPathResource> m_aXSDs;
  private final String m_sRootElementLocalName;
  private final String m_sRootElementNSURI;

  EUBL22DocumentType (@NonNull final Class <?> aClass, @NonNull final ICommonsList <ClassPathResource> aXSDs)
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
