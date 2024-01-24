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
package com.helger.ubl22;

import javax.annotation.Nonnull;
import javax.xml.validation.Schema;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.annotation.Since;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.string.StringHelper;
import com.helger.jaxb.builder.IJAXBDocumentType;
import com.helger.jaxb.builder.JAXBDocumentType;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;
import com.helger.xsds.xades132.CXAdES132;
import com.helger.xsds.xades141.CXAdES141;
import com.helger.xsds.xmldsig.CXMLDSig;

/**
 * Enumeration with all available UBL 2.2 document types.
 *
 * @author Philip Helger
 */
@Deprecated (forRemoval = true, since = "8.0.0")
public enum EUBL22DocumentType implements IJAXBDocumentType
{
  APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_22.ApplicationResponseType.class,
                        "UBL-ApplicationResponse-2.2.xsd"),
  ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_22.AttachedDocumentType.class,
                     "UBL-AttachedDocument-2.2.xsd"),
  AWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.awardednotification_22.AwardedNotificationType.class,
                        "UBL-AwardedNotification-2.2.xsd"),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_22.BillOfLadingType.class,
                  "UBL-BillOfLading-2.2.xsd"),
  @Since ("2.2")
  BUSINESS_CARD(oasis.names.specification.ubl.schema.xsd.businesscard_22.BusinessCardType.class,
                "UBL-BusinessCard-2.2.xsd"),
  CALL_FOR_TENDERS (oasis.names.specification.ubl.schema.xsd.callfortenders_22.CallForTendersType.class,
                    "UBL-CallForTenders-2.2.xsd"),
  CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_22.CatalogueType.class, "UBL-Catalogue-2.2.xsd"),
  CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_22.CatalogueDeletionType.class,
                      "UBL-CatalogueDeletion-2.2.xsd"),
  CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_22.CatalogueItemSpecificationUpdateType.class,
                                       "UBL-CatalogueItemSpecificationUpdate-2.2.xsd"),
  CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_22.CataloguePricingUpdateType.class,
                            "UBL-CataloguePricingUpdate-2.2.xsd"),
  CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_22.CatalogueRequestType.class,
                     "UBL-CatalogueRequest-2.2.xsd"),
  CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_22.CertificateOfOriginType.class,
                         "UBL-CertificateOfOrigin-2.2.xsd"),
  CONTRACT_AWARD_NOTICE (oasis.names.specification.ubl.schema.xsd.contractawardnotice_22.ContractAwardNoticeType.class,
                         "UBL-ContractAwardNotice-2.2.xsd"),
  CONTRACT_NOTICE (oasis.names.specification.ubl.schema.xsd.contractnotice_22.ContractNoticeType.class,
                   "UBL-ContractNotice-2.2.xsd"),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_22.CreditNoteType.class, "UBL-CreditNote-2.2.xsd"),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_22.DebitNoteType.class, "UBL-DebitNote-2.2.xsd"),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_22.DespatchAdviceType.class,
                   "UBL-DespatchAdvice-2.2.xsd"),
  @Since ("2.2")
  DIGITAL_AGREEMENT(oasis.names.specification.ubl.schema.xsd.digitalagreement_22.DigitalAgreementType.class,
                    "UBL-DigitalAgreement-2.2.xsd"),
  @Since ("2.2")
  DIGITAL_CAPABILITYT(oasis.names.specification.ubl.schema.xsd.digitalcapability_22.DigitalCapabilityType.class,
                      "UBL-DigitalCapability-2.2.xsd"),
  DOCUMENT_STATUS (oasis.names.specification.ubl.schema.xsd.documentstatus_22.DocumentStatusType.class,
                   "UBL-DocumentStatus-2.2.xsd"),
  DOCUMENT_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.documentstatusrequest_22.DocumentStatusRequestType.class,
                           "UBL-DocumentStatusRequest-2.2.xsd"),
  @Since ("2.2")
  ENQUIRY(oasis.names.specification.ubl.schema.xsd.enquiry_22.EnquiryType.class, "UBL-Enquiry-2.2.xsd"),
  @Since ("2.2")
  ENQUIRY_RESPONSE(oasis.names.specification.ubl.schema.xsd.enquiryresponse_22.EnquiryResponseType.class,
                   "UBL-EnquiryResponse-2.2.xsd"),
  EXCEPTION_CRITERIA (oasis.names.specification.ubl.schema.xsd.exceptioncriteria_22.ExceptionCriteriaType.class,
                      "UBL-ExceptionCriteria-2.2.xsd"),
  EXCEPTION_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.exceptionnotification_22.ExceptionNotificationType.class,
                          "UBL-ExceptionNotification-2.2.xsd"),
  @Since ("2.2")
  EXPRESSION_OF_INTEREST_REQUEST(oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_22.ExpressionOfInterestRequestType.class,
                                 "UBL-ExpressionOfInterestRequest-2.2.xsd"),
  @Since ("2.2")
  EXPRESSION_OF_INTEREST_RESPONSE(oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_22.ExpressionOfInterestResponseType.class,
                                  "UBL-ExpressionOfInterestResponse-2.2.xsd"),
  FORECAST (oasis.names.specification.ubl.schema.xsd.forecast_22.ForecastType.class, "UBL-Forecast-2.2.xsd"),
  FORECAST_REVISION (oasis.names.specification.ubl.schema.xsd.forecastrevision_22.ForecastRevisionType.class,
                     "UBL-ForecastRevision-2.2.xsd"),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_22.ForwardingInstructionsType.class,
                           "UBL-ForwardingInstructions-2.2.xsd"),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_22.FreightInvoiceType.class,
                   "UBL-FreightInvoice-2.2.xsd"),
  FULFILMENT_CANCELATION (oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_22.FulfilmentCancellationType.class,
                          "UBL-FulfilmentCancellation-2.2.xsd"),
  GOODS_ITEM_ITINERARY (oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_22.GoodsItemItineraryType.class,
                        "UBL-GoodsItemItinerary-2.2.xsd"),
  GUARANTEE_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.guaranteecertificate_22.GuaranteeCertificateType.class,
                         "UBL-GuaranteeCertificate-2.2.xsd"),
  INSTRUCTION_FOR_RETURNS (oasis.names.specification.ubl.schema.xsd.instructionforreturns_22.InstructionForReturnsType.class,
                           "UBL-InstructionForReturns-2.2.xsd"),
  INVENTORY_REPORT (oasis.names.specification.ubl.schema.xsd.inventoryreport_22.InventoryReportType.class,
                    "UBL-InventoryReport-2.2.xsd"),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_22.InvoiceType.class, "UBL-Invoice-2.2.xsd"),
  ITEM_INFORMATION_REQUEST (oasis.names.specification.ubl.schema.xsd.iteminformationrequest_22.ItemInformationRequestType.class,
                            "UBL-ItemInformationRequest-2.2.xsd"),
  ORDER (oasis.names.specification.ubl.schema.xsd.order_22.OrderType.class, "UBL-Order-2.2.xsd"),
  ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_22.OrderCancellationType.class,
                      "UBL-OrderCancellation-2.2.xsd"),
  ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_22.OrderChangeType.class,
                "UBL-OrderChange-2.2.xsd"),
  ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_22.OrderResponseType.class,
                  "UBL-OrderResponse-2.2.xsd"),
  ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_22.OrderResponseSimpleType.class,
                         "UBL-OrderResponseSimple-2.2.xsd"),
  PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_22.PackingListType.class,
                "UBL-PackingList-2.2.xsd"),
  PRIOR_INFORMATION_NOTICE (oasis.names.specification.ubl.schema.xsd.priorinformationnotice_22.PriorInformationNoticeType.class,
                            "UBL-PriorInformationNotice-2.2.xsd"),
  PRODUCT_ACTIVITY (oasis.names.specification.ubl.schema.xsd.productactivity_22.ProductActivityType.class,
                    "UBL-ProductActivity-2.2.xsd"),
  @Since ("2.2")
  QUALIFICATION_APPLICATION_REQUEST(oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_22.QualificationApplicationRequestType.class,
                                    "UBL-QualificationApplicationRequest-2.2.xsd"),
  @Since ("2.2")
  QUALIFICATION_APPLICATION_RESPONSE(oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_22.QualificationApplicationResponseType.class,
                                     "UBL-QualificationApplicationResponse-2.2.xsd"),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_22.QuotationType.class, "UBL-Quotation-2.2.xsd"),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_22.ReceiptAdviceType.class,
                  "UBL-ReceiptAdvice-2.2.xsd"),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_22.ReminderType.class, "UBL-Reminder-2.2.xsd"),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_22.RemittanceAdviceType.class,
                     "UBL-RemittanceAdvice-2.2.xsd"),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_22.RequestForQuotationType.class,
                         "UBL-RequestForQuotation-2.2.xsd"),
  RETAIL_EVENT (oasis.names.specification.ubl.schema.xsd.retailevent_22.RetailEventType.class,
                "UBL-RetailEvent-2.2.xsd"),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_22.SelfBilledCreditNoteType.class,
                           "UBL-SelfBilledCreditNote-2.2.xsd"),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_22.SelfBilledInvoiceType.class,
                       "UBL-SelfBilledInvoice-2.2.xsd"),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_22.StatementType.class, "UBL-Statement-2.2.xsd"),
  STOCK_AVAILABILITY_REPORT (oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_22.StockAvailabilityReportType.class,
                             "UBL-StockAvailabilityReport-2.2.xsd"),
  TENDER (oasis.names.specification.ubl.schema.xsd.tender_22.TenderType.class, "UBL-Tender-2.2.xsd"),
  @Since ("2.2")
  TENDER_CONTRACT(oasis.names.specification.ubl.schema.xsd.tendercontract_22.TenderContractType.class,
                  "UBL-TenderContract-2.2.xsd"),
  TENDERER_QUALIFICATION (oasis.names.specification.ubl.schema.xsd.tendererqualification_22.TendererQualificationType.class,
                          "UBL-TendererQualification-2.2.xsd"),
  TENDERER_QUALIFICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_22.TendererQualificationResponseType.class,
                                   "UBL-TendererQualificationResponse-2.2.xsd"),
  TENDER_RECEIPT (oasis.names.specification.ubl.schema.xsd.tenderreceipt_22.TenderReceiptType.class,
                  "UBL-TenderReceipt-2.2.xsd"),
  @Since ("2.2")
  TENDER_STATUS(oasis.names.specification.ubl.schema.xsd.tenderstatus_22.TenderStatusType.class,
                "UBL-TenderStatus-2.2.xsd"),
  @Since ("2.2")
  TENDER_STATUS_REQUEST(oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_22.TenderStatusRequestType.class,
                        "UBL-TenderStatusRequest-2.2.xsd"),
  @Since ("2.2")
  TENDER_WITHDRAWAL(oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_22.TenderWithdrawalType.class,
                    "UBL-TenderWithdrawal-2.2.xsd"),
  TRADE_ITEM_LOCATION_PROFILE (oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_22.TradeItemLocationProfileType.class,
                               "UBL-TradeItemLocationProfile-2.2.xsd"),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_22.TransportationStatusType.class,
                         "UBL-TransportationStatus-2.2.xsd"),
  TRANSPORTATION_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_22.TransportationStatusRequestType.class,
                                 "UBL-TransportationStatusRequest-2.2.xsd"),
  TRANSPORT_EXECUTION_PLAN (oasis.names.specification.ubl.schema.xsd.transportexecutionplan_22.TransportExecutionPlanType.class,
                            "UBL-TransportExecutionPlan-2.2.xsd"),
  TRANSPORT_EXECUTION_PLAN_REQUEST (oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_22.TransportExecutionPlanRequestType.class,
                                    "UBL-TransportExecutionPlanRequest-2.2.xsd"),
  TRANSPORT_PROGRESS_STATUS (oasis.names.specification.ubl.schema.xsd.transportprogressstatus_22.TransportProgressStatusType.class,
                             "UBL-TransportProgressStatus-2.2.xsd"),
  TRANSPORT_PROGRESS_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_22.TransportProgressStatusRequestType.class,
                                     "UBL-TransportProgressStatusRequest-2.2.xsd"),
  TRANSPORT_SERVICE_DESCRIPTION (oasis.names.specification.ubl.schema.xsd.transportservicedescription_22.TransportServiceDescriptionType.class,
                                 "UBL-TransportServiceDescription-2.2.xsd"),
  TRANSPORT_SERVICE_DESCRIPTION_REQUEST (oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_22.TransportServiceDescriptionRequestType.class,
                                         "UBL-TransportServiceDescriptionRequest-2.2.xsd"),
  UNAWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.unawardednotification_22.UnawardedNotificationType.class,
                          "UBL-UnawardedNotification-2.2.xsd"),
  @Since ("2.2")
  UNSUBSCRIBE_FROM_PROCEDURE_REQUEST(oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_22.UnsubscribeFromProcedureRequestType.class,
                                     "UBL-UnsubscribeFromProcedureRequest-2.2.xsd"),
  @Since ("2.2")
  UNSUBSCRIBE_FROM_PROCEDURE_RESPONSE(oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_22.UnsubscribeFromProcedureResponseType.class,
                                      "UBL-UnsubscribeFromProcedureResponse-2.2.xsd"),
  UTILITY_STATEMENT (oasis.names.specification.ubl.schema.xsd.utilitystatement_22.UtilityStatementType.class,
                     "UBL-UtilityStatement-2.2.xsd"),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_22.WaybillType.class, "UBL-Waybill-2.2.xsd"),
  @Since ("2.2")
  WEIGHT_STATEMENT(oasis.names.specification.ubl.schema.xsd.weightstatement_22.WeightStatementType.class,
                   "UBL-WeightStatement-2.2.xsd");

  @Nonnull
  private static ClassLoader _getCL ()
  {
    return EUBL22DocumentType.class.getClassLoader ();
  }

  private final JAXBDocumentType m_aDocType;

  EUBL22DocumentType (@Nonnull final Class <?> aClass, @Nonnull final String sXSDPath)
  {
    m_aDocType = new JAXBDocumentType (aClass,
                                       new CommonsArrayList <> (CCCTS.getXSDResource (),
                                                                CXMLDSig.getXSDResource (),
                                                                CXAdES132.getXSDResource (),
                                                                CXAdES141.getXSDResource (),
                                                                new ClassPathResource (CUBL22.SCHEMA_DIRECTORY +
                                                                                       sXSDPath,
                                                                                       _getCL ())),
                                       s -> StringHelper.trimEnd (s, "Type"));
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aDocType.getImplementationClass ();
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableCopy
  public ICommonsList <ClassPathResource> getAllXSDResources ()
  {
    return m_aDocType.getAllXSDResources ();
  }

  @Nonnull
  public String getNamespaceURI ()
  {
    return m_aDocType.getNamespaceURI ();
  }

  @Nonnull
  @Nonempty
  public String getLocalName ()
  {
    return m_aDocType.getLocalName ();
  }

  @Nonnull
  public Schema getSchema ()
  {
    return m_aDocType.getSchema ();
  }
}
