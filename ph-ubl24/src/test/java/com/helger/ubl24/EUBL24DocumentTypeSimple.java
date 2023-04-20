/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
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
package com.helger.ubl24;

import javax.annotation.Nonnull;
import javax.xml.validation.Schema;

import com.helger.commons.annotation.Since;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.ubl.api.codegen.IUBLDocTypeEnumSimple;
import com.helger.xml.schema.XMLSchemaCache;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;
import com.helger.xsds.xades132.CXAdES132;
import com.helger.xsds.xades141.CXAdES141;
import com.helger.xsds.xmldsig.CXMLDSig;

/**
 * Enumeration with all available UBL 2.4 document types.
 *
 * @author Philip Helger
 */
public enum EUBL24DocumentTypeSimple implements IUBLDocTypeEnumSimple
{
  APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_24.ApplicationResponseType.class,
                        "UBL-ApplicationResponse-2.4.xsd"),
  ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_24.AttachedDocumentType.class,
                     "UBL-AttachedDocument-2.4.xsd"),
  AWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.awardednotification_24.AwardedNotificationType.class,
                        "UBL-AwardedNotification-2.4.xsd"),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_24.BillOfLadingType.class,
                  "UBL-BillOfLading-2.4.xsd"),
  BUSINESS_CARD (oasis.names.specification.ubl.schema.xsd.businesscard_24.BusinessCardType.class,
                 "UBL-BusinessCard-2.4.xsd"),
  @Since ("2.4")
  BUSINESS_INFORMATION(oasis.names.specification.ubl.schema.xsd.businessinformation_24.BusinessInformationType.class,
                       "UBL-BusinessInformation-2.4.xsd"),
  CALL_FOR_TENDERS (oasis.names.specification.ubl.schema.xsd.callfortenders_24.CallForTendersType.class,
                    "UBL-CallForTenders-2.4.xsd"),
  CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_24.CatalogueType.class, "UBL-Catalogue-2.4.xsd"),
  CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_24.CatalogueDeletionType.class,
                      "UBL-CatalogueDeletion-2.4.xsd"),
  CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_24.CatalogueItemSpecificationUpdateType.class,
                                       "UBL-CatalogueItemSpecificationUpdate-2.4.xsd"),
  CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_24.CataloguePricingUpdateType.class,
                            "UBL-CataloguePricingUpdate-2.4.xsd"),
  CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_24.CatalogueRequestType.class,
                     "UBL-CatalogueRequest-2.4.xsd"),
  CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_24.CertificateOfOriginType.class,
                         "UBL-CertificateOfOrigin-2.4.xsd"),
  COMMON_TRANSPORTATION_REPORT (oasis.names.specification.ubl.schema.xsd.commontransportationreport_24.CommonTransportationReportType.class,
                                "UBL-CommonTransportationReport-2.4.xsd"),
  CONTRACT_AWARD_NOTICE (oasis.names.specification.ubl.schema.xsd.contractawardnotice_24.ContractAwardNoticeType.class,
                         "UBL-ContractAwardNotice-2.4.xsd"),
  CONTRACT_NOTICE (oasis.names.specification.ubl.schema.xsd.contractnotice_24.ContractNoticeType.class,
                   "UBL-ContractNotice-2.4.xsd"),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_24.CreditNoteType.class, "UBL-CreditNote-2.4.xsd"),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_24.DebitNoteType.class, "UBL-DebitNote-2.4.xsd"),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_24.DespatchAdviceType.class,
                   "UBL-DespatchAdvice-2.4.xsd"),
  DIGITAL_AGREEMENT (oasis.names.specification.ubl.schema.xsd.digitalagreement_24.DigitalAgreementType.class,
                     "UBL-DigitalAgreement-2.4.xsd"),
  DIGITAL_CAPABILITYT (oasis.names.specification.ubl.schema.xsd.digitalcapability_24.DigitalCapabilityType.class,
                       "UBL-DigitalCapability-2.4.xsd"),
  DOCUMENT_STATUS (oasis.names.specification.ubl.schema.xsd.documentstatus_24.DocumentStatusType.class,
                   "UBL-DocumentStatus-2.4.xsd"),
  DOCUMENT_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.documentstatusrequest_24.DocumentStatusRequestType.class,
                           "UBL-DocumentStatusRequest-2.4.xsd"),
  ENQUIRY (oasis.names.specification.ubl.schema.xsd.enquiry_24.EnquiryType.class, "UBL-Enquiry-2.4.xsd"),
  ENQUIRY_RESPONSE (oasis.names.specification.ubl.schema.xsd.enquiryresponse_24.EnquiryResponseType.class,
                    "UBL-EnquiryResponse-2.4.xsd"),
  EXCEPTION_CRITERIA (oasis.names.specification.ubl.schema.xsd.exceptioncriteria_24.ExceptionCriteriaType.class,
                      "UBL-ExceptionCriteria-2.4.xsd"),
  EXCEPTION_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.exceptionnotification_24.ExceptionNotificationType.class,
                          "UBL-ExceptionNotification-2.4.xsd"),
  EXPORT_CUSTOMS_DECLARATION (oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_24.ExportCustomsDeclarationType.class,
                              "UBL-ExportCustomsDeclaration-2.4.xsd"),
  EXPRESSION_OF_INTEREST_REQUEST (oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_24.ExpressionOfInterestRequestType.class,
                                  "UBL-ExpressionOfInterestRequest-2.4.xsd"),
  EXPRESSION_OF_INTEREST_RESPONSE (oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_24.ExpressionOfInterestResponseType.class,
                                   "UBL-ExpressionOfInterestResponse-2.4.xsd"),
  FORECAST (oasis.names.specification.ubl.schema.xsd.forecast_24.ForecastType.class, "UBL-Forecast-2.4.xsd"),
  FORECAST_REVISION (oasis.names.specification.ubl.schema.xsd.forecastrevision_24.ForecastRevisionType.class,
                     "UBL-ForecastRevision-2.4.xsd"),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_24.ForwardingInstructionsType.class,
                           "UBL-ForwardingInstructions-2.4.xsd"),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_24.FreightInvoiceType.class,
                   "UBL-FreightInvoice-2.4.xsd"),
  FULFILMENT_CANCELATION (oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_24.FulfilmentCancellationType.class,
                          "UBL-FulfilmentCancellation-2.4.xsd"),
  GOODS_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.goodscertificate_24.GoodsCertificateType.class,
                     "UBL-GoodsCertificate-2.4.xsd"),
  GOODS_ITEM_ITINERARY (oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_24.GoodsItemItineraryType.class,
                        "UBL-GoodsItemItinerary-2.4.xsd"),
  GOODS_ITEM_PASSPORT (oasis.names.specification.ubl.schema.xsd.goodsitempassport_24.GoodsItemPassportType.class,
                       "UBL-GoodsItemPassport-2.4.xsd"),
  GUARANTEE_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.guaranteecertificate_24.GuaranteeCertificateType.class,
                         "UBL-GuaranteeCertificate-2.4.xsd"),
  IMPORT_CUSTOMS_DECLARATION (oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_24.ImportCustomsDeclarationType.class,
                              "UBL-ImportCustomsDeclaration-2.4.xsd"),
  INSTRUCTION_FOR_RETURNS (oasis.names.specification.ubl.schema.xsd.instructionforreturns_24.InstructionForReturnsType.class,
                           "UBL-InstructionForReturns-2.4.xsd"),
  INVENTORY_REPORT (oasis.names.specification.ubl.schema.xsd.inventoryreport_24.InventoryReportType.class,
                    "UBL-InventoryReport-2.4.xsd"),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_24.InvoiceType.class, "UBL-Invoice-2.4.xsd"),
  ITEM_INFORMATION_REQUEST (oasis.names.specification.ubl.schema.xsd.iteminformationrequest_24.ItemInformationRequestType.class,
                            "UBL-ItemInformationRequest-2.4.xsd"),
  MANIFEST (oasis.names.specification.ubl.schema.xsd.manifest_24.ManifestType.class, "UBL-Manifest-2.4.xsd"),
  ORDER (oasis.names.specification.ubl.schema.xsd.order_24.OrderType.class, "UBL-Order-2.4.xsd"),
  ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_24.OrderCancellationType.class,
                      "UBL-OrderCancellation-2.4.xsd"),
  ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_24.OrderChangeType.class,
                "UBL-OrderChange-2.4.xsd"),
  ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_24.OrderResponseType.class,
                  "UBL-OrderResponse-2.4.xsd"),
  ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_24.OrderResponseSimpleType.class,
                         "UBL-OrderResponseSimple-2.4.xsd"),
  PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_24.PackingListType.class,
                "UBL-PackingList-2.4.xsd"),
  PRIOR_INFORMATION_NOTICE (oasis.names.specification.ubl.schema.xsd.priorinformationnotice_24.PriorInformationNoticeType.class,
                            "UBL-PriorInformationNotice-2.4.xsd"),
  PRODUCT_ACTIVITY (oasis.names.specification.ubl.schema.xsd.productactivity_24.ProductActivityType.class,
                    "UBL-ProductActivity-2.4.xsd"),
  PROOF_OF_REEXPORTATION (oasis.names.specification.ubl.schema.xsd.proofofreexportation_24.ProofOfReexportationType.class,
                          "UBL-ProofOfReexportation-2.4.xsd"),
  PROOF_OF_REEXPORTATION_REMINDER (oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_24.ProofOfReexportationReminderType.class,
                                   "UBL-ProofOfReexportationReminder-2.4.xsd"),
  PROOF_OF_REEXPORTATION_REQUEST (oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_24.ProofOfReexportationRequestType.class,
                                  "UBL-ProofOfReexportationRequest-2.4.xsd"),
  PURCHASE_RECEIPT (oasis.names.specification.ubl.schema.xsd.purchasereceipt_24.PurchaseReceiptType.class,
                    "UBL-PurchaseReceipt-2.4.xsd"),
  QUALIFICATION_APPLICATION_REQUEST (oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_24.QualificationApplicationRequestType.class,
                                     "UBL-QualificationApplicationRequest-2.4.xsd"),
  QUALIFICATION_APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_24.QualificationApplicationResponseType.class,
                                      "UBL-QualificationApplicationResponse-2.4.xsd"),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_24.QuotationType.class, "UBL-Quotation-2.4.xsd"),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_24.ReceiptAdviceType.class,
                  "UBL-ReceiptAdvice-2.4.xsd"),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_24.ReminderType.class, "UBL-Reminder-2.4.xsd"),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_24.RemittanceAdviceType.class,
                     "UBL-RemittanceAdvice-2.4.xsd"),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_24.RequestForQuotationType.class,
                         "UBL-RequestForQuotation-2.4.xsd"),
  RETAIL_EVENT (oasis.names.specification.ubl.schema.xsd.retailevent_24.RetailEventType.class,
                "UBL-RetailEvent-2.4.xsd"),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_24.SelfBilledCreditNoteType.class,
                           "UBL-SelfBilledCreditNote-2.4.xsd"),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_24.SelfBilledInvoiceType.class,
                       "UBL-SelfBilledInvoice-2.4.xsd"),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_24.StatementType.class, "UBL-Statement-2.4.xsd"),
  STOCK_AVAILABILITY_REPORT (oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_24.StockAvailabilityReportType.class,
                             "UBL-StockAvailabilityReport-2.4.xsd"),
  TENDER (oasis.names.specification.ubl.schema.xsd.tender_24.TenderType.class, "UBL-Tender-2.4.xsd"),
  TENDER_CONTRACT (oasis.names.specification.ubl.schema.xsd.tendercontract_24.TenderContractType.class,
                   "UBL-TenderContract-2.4.xsd"),
  TENDERER_QUALIFICATION (oasis.names.specification.ubl.schema.xsd.tendererqualification_24.TendererQualificationType.class,
                          "UBL-TendererQualification-2.4.xsd"),
  TENDERER_QUALIFICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_24.TendererQualificationResponseType.class,
                                   "UBL-TendererQualificationResponse-2.4.xsd"),
  TENDER_RECEIPT (oasis.names.specification.ubl.schema.xsd.tenderreceipt_24.TenderReceiptType.class,
                  "UBL-TenderReceipt-2.4.xsd"),
  TENDER_STATUS (oasis.names.specification.ubl.schema.xsd.tenderstatus_24.TenderStatusType.class,
                 "UBL-TenderStatus-2.4.xsd"),
  TENDER_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_24.TenderStatusRequestType.class,
                         "UBL-TenderStatusRequest-2.4.xsd"),
  TENDER_WITHDRAWAL (oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_24.TenderWithdrawalType.class,
                     "UBL-TenderWithdrawal-2.4.xsd"),
  TRADE_ITEM_LOCATION_PROFILE (oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_24.TradeItemLocationProfileType.class,
                               "UBL-TradeItemLocationProfile-2.4.xsd"),
  TRANSIT_CUSTOMS_DECLARATION (oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_24.TransitCustomsDeclarationType.class,
                               "UBL-TransitCustomsDeclaration-2.4.xsd"),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_24.TransportationStatusType.class,
                         "UBL-TransportationStatus-2.4.xsd"),
  TRANSPORTATION_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_24.TransportationStatusRequestType.class,
                                 "UBL-TransportationStatusRequest-2.4.xsd"),
  TRANSPORT_EXECUTION_PLAN (oasis.names.specification.ubl.schema.xsd.transportexecutionplan_24.TransportExecutionPlanType.class,
                            "UBL-TransportExecutionPlan-2.4.xsd"),
  TRANSPORT_EXECUTION_PLAN_REQUEST (oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_24.TransportExecutionPlanRequestType.class,
                                    "UBL-TransportExecutionPlanRequest-2.4.xsd"),
  TRANSPORT_PROGRESS_STATUS (oasis.names.specification.ubl.schema.xsd.transportprogressstatus_24.TransportProgressStatusType.class,
                             "UBL-TransportProgressStatus-2.4.xsd"),
  TRANSPORT_PROGRESS_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_24.TransportProgressStatusRequestType.class,
                                     "UBL-TransportProgressStatusRequest-2.4.xsd"),
  TRANSPORT_SERVICE_DESCRIPTION (oasis.names.specification.ubl.schema.xsd.transportservicedescription_24.TransportServiceDescriptionType.class,
                                 "UBL-TransportServiceDescription-2.4.xsd"),
  TRANSPORT_SERVICE_DESCRIPTION_REQUEST (oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_24.TransportServiceDescriptionRequestType.class,
                                         "UBL-TransportServiceDescriptionRequest-2.4.xsd"),
  UNAWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.unawardednotification_24.UnawardedNotificationType.class,
                          "UBL-UnawardedNotification-2.4.xsd"),
  UNSUBSCRIBE_FROM_PROCEDURE_REQUEST (oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_24.UnsubscribeFromProcedureRequestType.class,
                                      "UBL-UnsubscribeFromProcedureRequest-2.4.xsd"),
  UNSUBSCRIBE_FROM_PROCEDURE_RESPONSE (oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_24.UnsubscribeFromProcedureResponseType.class,
                                       "UBL-UnsubscribeFromProcedureResponse-2.4.xsd"),
  UTILITY_STATEMENT (oasis.names.specification.ubl.schema.xsd.utilitystatement_24.UtilityStatementType.class,
                     "UBL-UtilityStatement-2.4.xsd"),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_24.WaybillType.class, "UBL-Waybill-2.4.xsd"),
  WEIGHT_STATEMENT (oasis.names.specification.ubl.schema.xsd.weightstatement_24.WeightStatementType.class,
                    "UBL-WeightStatement-2.4.xsd");

  private final Class <?> m_aClass;
  private final String m_sXSDPath;

  EUBL24DocumentTypeSimple (@Nonnull final Class <?> aClass, @Nonnull final String sXSDPath)
  {
    m_aClass = aClass;
    m_sXSDPath = sXSDPath;
  }

  @Nonnull
  public Class <?> getClazz ()
  {
    return m_aClass;
  }

  @Nonnull
  public String getXSDPath ()
  {
    return m_sXSDPath;
  }

  @Nonnull
  public Schema getSchema ()
  {
    return XMLSchemaCache.getInstance ()
                         .getFromCache (new CommonsArrayList <> (CCCTS.getXSDResource (),
                                                                 CXMLDSig.getXSDResource (),
                                                                 CXAdES132.getXSDResource (),
                                                                 CXAdES141.getXSDResource (),
                                                                 new ClassPathResource (CUBL24.SCHEMA_DIRECTORY +
                                                                                        m_sXSDPath,
                                                                                        CUBL24.getCL ())));
  }
}
