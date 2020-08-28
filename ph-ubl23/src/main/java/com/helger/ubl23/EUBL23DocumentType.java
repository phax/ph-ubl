/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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
package com.helger.ubl23;

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

/**
 * Enumeration with all available UBL 2.3 document types.
 *
 * @author Philip Helger
 */
public enum EUBL23DocumentType implements IJAXBDocumentType
{
  APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_23.ApplicationResponseType.class,
                        "UBL-ApplicationResponse-2.3.xsd"),
  ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_23.AttachedDocumentType.class,
                     "UBL-AttachedDocument-2.3.xsd"),
  AWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.awardednotification_23.AwardedNotificationType.class,
                        "UBL-AwardedNotification-2.3.xsd"),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_23.BillOfLadingType.class, "UBL-BillOfLading-2.3.xsd"),
  BUSINESS_CARD (oasis.names.specification.ubl.schema.xsd.businesscard_23.BusinessCardType.class, "UBL-BusinessCard-2.3.xsd"),
  CALL_FOR_TENDERS (oasis.names.specification.ubl.schema.xsd.callfortenders_23.CallForTendersType.class, "UBL-CallForTenders-2.3.xsd"),
  CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_23.CatalogueType.class, "UBL-Catalogue-2.3.xsd"),
  CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_23.CatalogueDeletionType.class,
                      "UBL-CatalogueDeletion-2.3.xsd"),
  CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_23.CatalogueItemSpecificationUpdateType.class,
                                       "UBL-CatalogueItemSpecificationUpdate-2.3.xsd"),
  CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_23.CataloguePricingUpdateType.class,
                            "UBL-CataloguePricingUpdate-2.3.xsd"),
  CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_23.CatalogueRequestType.class,
                     "UBL-CatalogueRequest-2.3.xsd"),
  CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_23.CertificateOfOriginType.class,
                         "UBL-CertificateOfOrigin-2.3.xsd"),
  CONTRACT_AWARD_NOTICE (oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ContractAwardNoticeType.class,
                         "UBL-ContractAwardNotice-2.3.xsd"),
  CONTRACT_NOTICE (oasis.names.specification.ubl.schema.xsd.contractnotice_23.ContractNoticeType.class, "UBL-ContractNotice-2.3.xsd"),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_23.CreditNoteType.class, "UBL-CreditNote-2.3.xsd"),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_23.DebitNoteType.class, "UBL-DebitNote-2.3.xsd"),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_23.DespatchAdviceType.class, "UBL-DespatchAdvice-2.3.xsd"),
  DIGITAL_AGREEMENT (oasis.names.specification.ubl.schema.xsd.digitalagreement_23.DigitalAgreementType.class,
                     "UBL-DigitalAgreement-2.3.xsd"),
  DIGITAL_CAPABILITYT (oasis.names.specification.ubl.schema.xsd.digitalcapability_23.DigitalCapabilityType.class,
                       "UBL-DigitalCapability-2.3.xsd"),
  DOCUMENT_STATUS (oasis.names.specification.ubl.schema.xsd.documentstatus_23.DocumentStatusType.class, "UBL-DocumentStatus-2.3.xsd"),
  DOCUMENT_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.documentstatusrequest_23.DocumentStatusRequestType.class,
                           "UBL-DocumentStatusRequest-2.3.xsd"),
  ENQUIRY (oasis.names.specification.ubl.schema.xsd.enquiry_23.EnquiryType.class, "UBL-Enquiry-2.3.xsd"),
  ENQUIRY_RESPONSE (oasis.names.specification.ubl.schema.xsd.enquiryresponse_23.EnquiryResponseType.class, "UBL-EnquiryResponse-2.3.xsd"),
  EXCEPTION_CRITERIA (oasis.names.specification.ubl.schema.xsd.exceptioncriteria_23.ExceptionCriteriaType.class,
                      "UBL-ExceptionCriteria-2.3.xsd"),
  EXCEPTION_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.exceptionnotification_23.ExceptionNotificationType.class,
                          "UBL-ExceptionNotification-2.3.xsd"),
  @Since ("2.3")
  EXPORT_CUSTOMS_DECLARATION(oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_23.ExportCustomsDeclarationType.class,
                             "UBL-ExportCustomsDeclaration-2.3.xsd"),
  EXPRESSION_OF_INTEREST_REQUEST (oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_23.ExpressionOfInterestRequestType.class,
                                  "UBL-ExpressionOfInterestRequest-2.3.xsd"),
  EXPRESSION_OF_INTEREST_RESPONSE (oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_23.ExpressionOfInterestResponseType.class,
                                   "UBL-ExpressionOfInterestResponse-2.3.xsd"),
  FORECAST (oasis.names.specification.ubl.schema.xsd.forecast_23.ForecastType.class, "UBL-Forecast-2.3.xsd"),
  FORECAST_REVISION (oasis.names.specification.ubl.schema.xsd.forecastrevision_23.ForecastRevisionType.class,
                     "UBL-ForecastRevision-2.3.xsd"),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_23.ForwardingInstructionsType.class,
                           "UBL-ForwardingInstructions-2.3.xsd"),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_23.FreightInvoiceType.class, "UBL-FreightInvoice-2.3.xsd"),
  FULFILMENT_CANCELATION (oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_23.FulfilmentCancellationType.class,
                          "UBL-FulfilmentCancellation-2.3.xsd"),
  @Since ("2.3")
  GOODS_CERTIFICATE(oasis.names.specification.ubl.schema.xsd.goodscertificate_23.GoodsCertificateType.class,
                    "UBL-GoodsCertificate-2.3.xsd"),
  GOODS_ITEM_ITINERARY (oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_23.GoodsItemItineraryType.class,
                        "UBL-GoodsItemItinerary-2.3.xsd"),
  @Since ("2.3")
  GOODS_ITEM_PASSPORT(oasis.names.specification.ubl.schema.xsd.goodsitempassport_23.GoodsItemPassportType.class,
                      "UBL-GoodsItemPassport-2.3.xsd"),
  GUARANTEE_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.guaranteecertificate_23.GuaranteeCertificateType.class,
                         "UBL-GuaranteeCertificate-2.3.xsd"),
  @Since ("2.3")
  IMPORT_CUSTOMS_DECLARATION(oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_23.ImportCustomsDeclarationType.class,
                             "UBL-ImportCustomsDeclaration-2.3.xsd"),
  INSTRUCTION_FOR_RETURNS (oasis.names.specification.ubl.schema.xsd.instructionforreturns_23.InstructionForReturnsType.class,
                           "UBL-InstructionForReturns-2.3.xsd"),
  INVENTORY_REPORT (oasis.names.specification.ubl.schema.xsd.inventoryreport_23.InventoryReportType.class, "UBL-InventoryReport-2.3.xsd"),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_23.InvoiceType.class, "UBL-Invoice-2.3.xsd"),
  ITEM_INFORMATION_REQUEST (oasis.names.specification.ubl.schema.xsd.iteminformationrequest_23.ItemInformationRequestType.class,
                            "UBL-ItemInformationRequest-2.3.xsd"),
  ORDER (oasis.names.specification.ubl.schema.xsd.order_23.OrderType.class, "UBL-Order-2.3.xsd"),
  ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_23.OrderCancellationType.class,
                      "UBL-OrderCancellation-2.3.xsd"),
  ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_23.OrderChangeType.class, "UBL-OrderChange-2.3.xsd"),
  ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_23.OrderResponseType.class, "UBL-OrderResponse-2.3.xsd"),
  ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_23.OrderResponseSimpleType.class,
                         "UBL-OrderResponseSimple-2.3.xsd"),
  PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_23.PackingListType.class, "UBL-PackingList-2.3.xsd"),
  PRIOR_INFORMATION_NOTICE (oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.PriorInformationNoticeType.class,
                            "UBL-PriorInformationNotice-2.3.xsd"),
  PRODUCT_ACTIVITY (oasis.names.specification.ubl.schema.xsd.productactivity_23.ProductActivityType.class, "UBL-ProductActivity-2.3.xsd"),
  @Since ("2.3")
  PROOF_OF_REEXPORTATION(oasis.names.specification.ubl.schema.xsd.proofofreexportation_23.ProofOfReexportationType.class,
                         "UBL-ProofOfReexportation-2.3.xsd"),
  @Since ("2.3")
  PROOF_OF_REEXPORTATION_REMINDER(oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_23.ProofOfReexportationReminderType.class,
                                  "UBL-ProofOfReexportationReminder-2.3.xsd"),
  @Since ("2.3")
  PROOF_OF_REEXPORTATION_REQUEST(oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_23.ProofOfReexportationRequestType.class,
                                 "UBL-ProofOfReexportationRequest-2.3.xsd"),
  QUALIFICATION_APPLICATION_REQUEST (oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_23.QualificationApplicationRequestType.class,
                                     "UBL-QualificationApplicationRequest-2.3.xsd"),
  QUALIFICATION_APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_23.QualificationApplicationResponseType.class,
                                      "UBL-QualificationApplicationResponse-2.3.xsd"),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_23.QuotationType.class, "UBL-Quotation-2.3.xsd"),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_23.ReceiptAdviceType.class, "UBL-ReceiptAdvice-2.3.xsd"),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_23.ReminderType.class, "UBL-Reminder-2.3.xsd"),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_23.RemittanceAdviceType.class,
                     "UBL-RemittanceAdvice-2.3.xsd"),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_23.RequestForQuotationType.class,
                         "UBL-RequestForQuotation-2.3.xsd"),
  RETAIL_EVENT (oasis.names.specification.ubl.schema.xsd.retailevent_23.RetailEventType.class, "UBL-RetailEvent-2.3.xsd"),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_23.SelfBilledCreditNoteType.class,
                           "UBL-SelfBilledCreditNote-2.3.xsd"),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_23.SelfBilledInvoiceType.class,
                       "UBL-SelfBilledInvoice-2.3.xsd"),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_23.StatementType.class, "UBL-Statement-2.3.xsd"),
  STOCK_AVAILABILITY_REPORT (oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_23.StockAvailabilityReportType.class,
                             "UBL-StockAvailabilityReport-2.3.xsd"),
  TENDER (oasis.names.specification.ubl.schema.xsd.tender_23.TenderType.class, "UBL-Tender-2.3.xsd"),
  TENDER_CONTRACT (oasis.names.specification.ubl.schema.xsd.tendercontract_23.TenderContractType.class, "UBL-TenderContract-2.3.xsd"),
  TENDERER_QUALIFICATION (oasis.names.specification.ubl.schema.xsd.tendererqualification_23.TendererQualificationType.class,
                          "UBL-TendererQualification-2.3.xsd"),
  TENDERER_QUALIFICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_23.TendererQualificationResponseType.class,
                                   "UBL-TendererQualificationResponse-2.3.xsd"),
  TENDER_RECEIPT (oasis.names.specification.ubl.schema.xsd.tenderreceipt_23.TenderReceiptType.class, "UBL-TenderReceipt-2.3.xsd"),
  TENDER_STATUS (oasis.names.specification.ubl.schema.xsd.tenderstatus_23.TenderStatusType.class, "UBL-TenderStatus-2.3.xsd"),
  TENDER_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_23.TenderStatusRequestType.class,
                         "UBL-TenderStatusRequest-2.3.xsd"),
  TENDER_WITHDRAWAL (oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_23.TenderWithdrawalType.class,
                     "UBL-TenderWithdrawal-2.3.xsd"),
  TRADE_ITEM_LOCATION_PROFILE (oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_23.TradeItemLocationProfileType.class,
                               "UBL-TradeItemLocationProfile-2.3.xsd"),
  @Since ("2.3")
  TRANSIT_CUSTOMS_DECLARATION(oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_23.TransitCustomsDeclarationType.class,
                              "UBL-TransitCustomsDeclaration-2.3.xsd"),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_23.TransportationStatusType.class,
                         "UBL-TransportationStatus-2.3.xsd"),
  TRANSPORTATION_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_23.TransportationStatusRequestType.class,
                                 "UBL-TransportationStatusRequest-2.3.xsd"),
  TRANSPORT_EXECUTION_PLAN (oasis.names.specification.ubl.schema.xsd.transportexecutionplan_23.TransportExecutionPlanType.class,
                            "UBL-TransportExecutionPlan-2.3.xsd"),
  TRANSPORT_EXECUTION_PLAN_REQUEST (oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_23.TransportExecutionPlanRequestType.class,
                                    "UBL-TransportExecutionPlanRequest-2.3.xsd"),
  TRANSPORT_PROGRESS_STATUS (oasis.names.specification.ubl.schema.xsd.transportprogressstatus_23.TransportProgressStatusType.class,
                             "UBL-TransportProgressStatus-2.3.xsd"),
  TRANSPORT_PROGRESS_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_23.TransportProgressStatusRequestType.class,
                                     "UBL-TransportProgressStatusRequest-2.3.xsd"),
  TRANSPORT_SERVICE_DESCRIPTION (oasis.names.specification.ubl.schema.xsd.transportservicedescription_23.TransportServiceDescriptionType.class,
                                 "UBL-TransportServiceDescription-2.3.xsd"),
  TRANSPORT_SERVICE_DESCRIPTION_REQUEST (oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_23.TransportServiceDescriptionRequestType.class,
                                         "UBL-TransportServiceDescriptionRequest-2.3.xsd"),
  UNAWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.unawardednotification_23.UnawardedNotificationType.class,
                          "UBL-UnawardedNotification-2.3.xsd"),
  UNSUBSCRIBE_FROM_PROCEDURE_REQUEST (oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_23.UnsubscribeFromProcedureRequestType.class,
                                      "UBL-UnsubscribeFromProcedureRequest-2.3.xsd"),
  UNSUBSCRIBE_FROM_PROCEDURE_RESPONSE (oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_23.UnsubscribeFromProcedureResponseType.class,
                                       "UBL-UnsubscribeFromProcedureResponse-2.3.xsd"),
  UTILITY_STATEMENT (oasis.names.specification.ubl.schema.xsd.utilitystatement_23.UtilityStatementType.class,
                     "UBL-UtilityStatement-2.3.xsd"),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_23.WaybillType.class, "UBL-Waybill-2.3.xsd"),
  WEIGHT_STATEMENT (oasis.names.specification.ubl.schema.xsd.weightstatement_23.WeightStatementType.class, "UBL-WeightStatement-2.3.xsd");

  @Nonnull
  private static ClassLoader _getCL ()
  {
    return EUBL23DocumentType.class.getClassLoader ();
  }

  private final JAXBDocumentType m_aDocType;

  private EUBL23DocumentType (@Nonnull final Class <?> aClass, @Nonnull final String sXSDPath)
  {
    m_aDocType = new JAXBDocumentType (aClass,
                                       new CommonsArrayList <> (new ClassPathResource (CUBL23.SCHEMA_DIRECTORY + sXSDPath, _getCL ())),
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
