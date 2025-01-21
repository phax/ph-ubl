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
package com.helger.ubl23;

import javax.annotation.Nonnull;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.annotation.Since;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.lang.ClassHelper;
import com.helger.commons.string.StringHelper;

/**
 * Enumeration with all available UBL 2.3 document types.
 *
 * @author Philip Helger
 */
public enum EUBL23DocumentType
{
  APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_23.ApplicationResponseType.class,
                        UBL23Marshaller.getAllApplicationResponseXSDs ()),
  ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_23.AttachedDocumentType.class,
                     UBL23Marshaller.getAllAttachedDocumentXSDs ()),
  AWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.awardednotification_23.AwardedNotificationType.class,
                        UBL23Marshaller.getAllAwardedNotificationXSDs ()),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_23.BillOfLadingType.class,
                  UBL23Marshaller.getAllBillOfLadingXSDs ()),
  BUSINESS_CARD (oasis.names.specification.ubl.schema.xsd.businesscard_23.BusinessCardType.class,
                 UBL23Marshaller.getAllBusinessCardXSDs ()),
  CALL_FOR_TENDERS (oasis.names.specification.ubl.schema.xsd.callfortenders_23.CallForTendersType.class,
                    UBL23Marshaller.getAllCallForTendersXSDs ()),
  CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_23.CatalogueType.class, UBL23Marshaller.getAllCatalogueXSDs ()),
  CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_23.CatalogueDeletionType.class,
                      UBL23Marshaller.getAllCatalogueDeletionXSDs ()),
  CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_23.CatalogueItemSpecificationUpdateType.class,
                                       UBL23Marshaller.getAllCatalogueItemSpecificationUpdateXSDs ()),
  CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_23.CataloguePricingUpdateType.class,
                            UBL23Marshaller.getAllCataloguePricingUpdateXSDs ()),
  CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_23.CatalogueRequestType.class,
                     UBL23Marshaller.getAllCatalogueRequestXSDs ()),
  CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_23.CertificateOfOriginType.class,
                         UBL23Marshaller.getAllCertificateOfOriginXSDs ()),
  @Since ("2.3")
  COMMON_TRANSPORTATION_REPORT(oasis.names.specification.ubl.schema.xsd.commontransportationreport_23.CommonTransportationReportType.class,
                               UBL23Marshaller.getAllCommonTransportationReportXSDs ()),
  CONTRACT_AWARD_NOTICE (oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ContractAwardNoticeType.class,
                         UBL23Marshaller.getAllContractAwardNoticeXSDs ()),
  CONTRACT_NOTICE (oasis.names.specification.ubl.schema.xsd.contractnotice_23.ContractNoticeType.class,
                   UBL23Marshaller.getAllContractNoticeXSDs ()),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_23.CreditNoteType.class, UBL23Marshaller.getAllCreditNoteXSDs ()),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_23.DebitNoteType.class, UBL23Marshaller.getAllDebitNoteXSDs ()),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_23.DespatchAdviceType.class,
                   UBL23Marshaller.getAllDespatchAdviceXSDs ()),
  DIGITAL_AGREEMENT (oasis.names.specification.ubl.schema.xsd.digitalagreement_23.DigitalAgreementType.class,
                     UBL23Marshaller.getAllDigitalAgreementXSDs ()),
  DIGITAL_CAPABILITY (oasis.names.specification.ubl.schema.xsd.digitalcapability_23.DigitalCapabilityType.class,
                      UBL23Marshaller.getAllDigitalCapabilityXSDs ()),
  DOCUMENT_STATUS (oasis.names.specification.ubl.schema.xsd.documentstatus_23.DocumentStatusType.class,
                   UBL23Marshaller.getAllDocumentStatusXSDs ()),
  DOCUMENT_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.documentstatusrequest_23.DocumentStatusRequestType.class,
                           UBL23Marshaller.getAllDocumentStatusRequestXSDs ()),
  ENQUIRY (oasis.names.specification.ubl.schema.xsd.enquiry_23.EnquiryType.class, UBL23Marshaller.getAllEnquiryXSDs ()),
  ENQUIRY_RESPONSE (oasis.names.specification.ubl.schema.xsd.enquiryresponse_23.EnquiryResponseType.class,
                    UBL23Marshaller.getAllEnquiryResponseXSDs ()),
  EXCEPTION_CRITERIA (oasis.names.specification.ubl.schema.xsd.exceptioncriteria_23.ExceptionCriteriaType.class,
                      UBL23Marshaller.getAllExceptionCriteriaXSDs ()),
  EXCEPTION_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.exceptionnotification_23.ExceptionNotificationType.class,
                          UBL23Marshaller.getAllExceptionNotificationXSDs ()),
  @Since ("2.3")
  EXPORT_CUSTOMS_DECLARATION(oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_23.ExportCustomsDeclarationType.class,
                             UBL23Marshaller.getAllExportCustomsDeclarationXSDs ()),
  EXPRESSION_OF_INTEREST_REQUEST (oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_23.ExpressionOfInterestRequestType.class,
                                  UBL23Marshaller.getAllExpressionOfInterestRequestXSDs ()),
  EXPRESSION_OF_INTEREST_RESPONSE (oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_23.ExpressionOfInterestResponseType.class,
                                   UBL23Marshaller.getAllExpressionOfInterestResponseXSDs ()),
  FORECAST (oasis.names.specification.ubl.schema.xsd.forecast_23.ForecastType.class, UBL23Marshaller.getAllForecastXSDs ()),
  FORECAST_REVISION (oasis.names.specification.ubl.schema.xsd.forecastrevision_23.ForecastRevisionType.class,
                     UBL23Marshaller.getAllForecastRevisionXSDs ()),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_23.ForwardingInstructionsType.class,
                           UBL23Marshaller.getAllForwardingInstructionsXSDs ()),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_23.FreightInvoiceType.class,
                   UBL23Marshaller.getAllFreightInvoiceXSDs ()),
  FULFILMENT_CANCELLATION (oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_23.FulfilmentCancellationType.class,
                           UBL23Marshaller.getAllFulfilmentCancellationXSDs ()),
  @Since ("2.3")
  GOODS_CERTIFICATE(oasis.names.specification.ubl.schema.xsd.goodscertificate_23.GoodsCertificateType.class,
                    UBL23Marshaller.getAllGoodsCertificateXSDs ()),
  GOODS_ITEM_ITINERARY (oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_23.GoodsItemItineraryType.class,
                        UBL23Marshaller.getAllGoodsItemItineraryXSDs ()),
  @Since ("2.3")
  GOODS_ITEM_PASSPORT(oasis.names.specification.ubl.schema.xsd.goodsitempassport_23.GoodsItemPassportType.class,
                      UBL23Marshaller.getAllGoodsItemPassportXSDs ()),
  GUARANTEE_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.guaranteecertificate_23.GuaranteeCertificateType.class,
                         UBL23Marshaller.getAllGuaranteeCertificateXSDs ()),
  @Since ("2.3")
  IMPORT_CUSTOMS_DECLARATION(oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_23.ImportCustomsDeclarationType.class,
                             UBL23Marshaller.getAllImportCustomsDeclarationXSDs ()),
  INSTRUCTION_FOR_RETURNS (oasis.names.specification.ubl.schema.xsd.instructionforreturns_23.InstructionForReturnsType.class,
                           UBL23Marshaller.getAllInstructionForReturnsXSDs ()),
  INVENTORY_REPORT (oasis.names.specification.ubl.schema.xsd.inventoryreport_23.InventoryReportType.class,
                    UBL23Marshaller.getAllInventoryReportXSDs ()),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_23.InvoiceType.class, UBL23Marshaller.getAllInvoiceXSDs ()),
  ITEM_INFORMATION_REQUEST (oasis.names.specification.ubl.schema.xsd.iteminformationrequest_23.ItemInformationRequestType.class,
                            UBL23Marshaller.getAllItemInformationRequestXSDs ()),
  @Since ("2.3")
  MANIFEST(oasis.names.specification.ubl.schema.xsd.manifest_23.ManifestType.class, UBL23Marshaller.getAllManifestXSDs ()),
  ORDER (oasis.names.specification.ubl.schema.xsd.order_23.OrderType.class, UBL23Marshaller.getAllOrderXSDs ()),
  ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_23.OrderCancellationType.class,
                      UBL23Marshaller.getAllOrderCancellationXSDs ()),
  ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_23.OrderChangeType.class, UBL23Marshaller.getAllOrderChangeXSDs ()),
  ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_23.OrderResponseType.class,
                  UBL23Marshaller.getAllOrderResponseXSDs ()),
  ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_23.OrderResponseSimpleType.class,
                         UBL23Marshaller.getAllOrderResponseSimpleXSDs ()),
  PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_23.PackingListType.class, UBL23Marshaller.getAllPackingListXSDs ()),
  PRIOR_INFORMATION_NOTICE (oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.PriorInformationNoticeType.class,
                            UBL23Marshaller.getAllPriorInformationNoticeXSDs ()),
  PRODUCT_ACTIVITY (oasis.names.specification.ubl.schema.xsd.productactivity_23.ProductActivityType.class,
                    UBL23Marshaller.getAllProductActivityXSDs ()),
  @Since ("2.3")
  PROOF_OF_REEXPORTATION(oasis.names.specification.ubl.schema.xsd.proofofreexportation_23.ProofOfReexportationType.class,
                         UBL23Marshaller.getAllProofOfReexportationXSDs ()),
  @Since ("2.3")
  PROOF_OF_REEXPORTATION_REMINDER(oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_23.ProofOfReexportationReminderType.class,
                                  UBL23Marshaller.getAllProofOfReexportationReminderXSDs ()),
  @Since ("2.3")
  PROOF_OF_REEXPORTATION_REQUEST(oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_23.ProofOfReexportationRequestType.class,
                                 UBL23Marshaller.getAllProofOfReexportationRequestXSDs ()),
  QUALIFICATION_APPLICATION_REQUEST (oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_23.QualificationApplicationRequestType.class,
                                     UBL23Marshaller.getAllQualificationApplicationRequestXSDs ()),
  QUALIFICATION_APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_23.QualificationApplicationResponseType.class,
                                      UBL23Marshaller.getAllQualificationApplicationResponseXSDs ()),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_23.QuotationType.class, UBL23Marshaller.getAllQuotationXSDs ()),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_23.ReceiptAdviceType.class,
                  UBL23Marshaller.getAllReceiptAdviceXSDs ()),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_23.ReminderType.class, UBL23Marshaller.getAllReminderXSDs ()),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_23.RemittanceAdviceType.class,
                     UBL23Marshaller.getAllRemittanceAdviceXSDs ()),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_23.RequestForQuotationType.class,
                         UBL23Marshaller.getAllRequestForQuotationXSDs ()),
  RETAIL_EVENT (oasis.names.specification.ubl.schema.xsd.retailevent_23.RetailEventType.class, UBL23Marshaller.getAllRetailEventXSDs ()),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_23.SelfBilledCreditNoteType.class,
                           UBL23Marshaller.getAllSelfBilledCreditNoteXSDs ()),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_23.SelfBilledInvoiceType.class,
                       UBL23Marshaller.getAllSelfBilledInvoiceXSDs ()),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_23.StatementType.class, UBL23Marshaller.getAllStatementXSDs ()),
  STOCK_AVAILABILITY_REPORT (oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_23.StockAvailabilityReportType.class,
                             UBL23Marshaller.getAllStockAvailabilityReportXSDs ()),
  TENDER (oasis.names.specification.ubl.schema.xsd.tender_23.TenderType.class, UBL23Marshaller.getAllTenderXSDs ()),
  TENDER_CONTRACT (oasis.names.specification.ubl.schema.xsd.tendercontract_23.TenderContractType.class,
                   UBL23Marshaller.getAllTenderContractXSDs ()),
  TENDER_RECEIPT (oasis.names.specification.ubl.schema.xsd.tenderreceipt_23.TenderReceiptType.class,
                  UBL23Marshaller.getAllTenderReceiptXSDs ()),
  TENDER_STATUS (oasis.names.specification.ubl.schema.xsd.tenderstatus_23.TenderStatusType.class,
                 UBL23Marshaller.getAllTenderStatusXSDs ()),
  TENDER_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_23.TenderStatusRequestType.class,
                         UBL23Marshaller.getAllTenderStatusRequestXSDs ()),
  TENDER_WITHDRAWAL (oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_23.TenderWithdrawalType.class,
                     UBL23Marshaller.getAllTenderWithdrawalXSDs ()),
  TENDERER_QUALIFICATION (oasis.names.specification.ubl.schema.xsd.tendererqualification_23.TendererQualificationType.class,
                          UBL23Marshaller.getAllTendererQualificationXSDs ()),
  TENDERER_QUALIFICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_23.TendererQualificationResponseType.class,
                                   UBL23Marshaller.getAllTendererQualificationResponseXSDs ()),
  TRADE_ITEM_LOCATION_PROFILE (oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_23.TradeItemLocationProfileType.class,
                               UBL23Marshaller.getAllTradeItemLocationProfileXSDs ()),
  @Since ("2.3")
  TRANSIT_CUSTOMS_DECLARATION(oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_23.TransitCustomsDeclarationType.class,
                              UBL23Marshaller.getAllTransitCustomsDeclarationXSDs ()),
  TRANSPORT_EXECUTION_PLAN (oasis.names.specification.ubl.schema.xsd.transportexecutionplan_23.TransportExecutionPlanType.class,
                            UBL23Marshaller.getAllTransportExecutionPlanXSDs ()),
  TRANSPORT_EXECUTION_PLAN_REQUEST (oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_23.TransportExecutionPlanRequestType.class,
                                    UBL23Marshaller.getAllTransportExecutionPlanRequestXSDs ()),
  TRANSPORT_PROGRESS_STATUS (oasis.names.specification.ubl.schema.xsd.transportprogressstatus_23.TransportProgressStatusType.class,
                             UBL23Marshaller.getAllTransportProgressStatusXSDs ()),
  TRANSPORT_PROGRESS_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_23.TransportProgressStatusRequestType.class,
                                     UBL23Marshaller.getAllTransportProgressStatusRequestXSDs ()),
  TRANSPORT_SERVICE_DESCRIPTION (oasis.names.specification.ubl.schema.xsd.transportservicedescription_23.TransportServiceDescriptionType.class,
                                 UBL23Marshaller.getAllTransportServiceDescriptionXSDs ()),
  TRANSPORT_SERVICE_DESCRIPTION_REQUEST (oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_23.TransportServiceDescriptionRequestType.class,
                                         UBL23Marshaller.getAllTransportServiceDescriptionRequestXSDs ()),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_23.TransportationStatusType.class,
                         UBL23Marshaller.getAllTransportationStatusXSDs ()),
  TRANSPORTATION_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_23.TransportationStatusRequestType.class,
                                 UBL23Marshaller.getAllTransportationStatusRequestXSDs ()),
  UNAWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.unawardednotification_23.UnawardedNotificationType.class,
                          UBL23Marshaller.getAllUnawardedNotificationXSDs ()),
  UNSUBSCRIBE_FROM_PROCEDURE_REQUEST (oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_23.UnsubscribeFromProcedureRequestType.class,
                                      UBL23Marshaller.getAllUnsubscribeFromProcedureRequestXSDs ()),
  UNSUBSCRIBE_FROM_PROCEDURE_RESPONSE (oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_23.UnsubscribeFromProcedureResponseType.class,
                                       UBL23Marshaller.getAllUnsubscribeFromProcedureResponseXSDs ()),
  UTILITY_STATEMENT (oasis.names.specification.ubl.schema.xsd.utilitystatement_23.UtilityStatementType.class,
                     UBL23Marshaller.getAllUtilityStatementXSDs ()),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_23.WaybillType.class, UBL23Marshaller.getAllWaybillXSDs ()),
  WEIGHT_STATEMENT (oasis.names.specification.ubl.schema.xsd.weightstatement_23.WeightStatementType.class,
                    UBL23Marshaller.getAllWeightStatementXSDs ());

  private final Class <?> m_aImplClass;
  private final ICommonsList <ClassPathResource> m_aXSDs;
  private final String m_sRootElementLocalName;
  private final String m_sRootElementNSURI;

  EUBL23DocumentType (@Nonnull final Class <?> aClass, @Nonnull final ICommonsList <ClassPathResource> aXSDs)
  {
    m_aImplClass = aClass;
    m_aXSDs = aXSDs;
    m_sRootElementLocalName = StringHelper.trimEnd (ClassHelper.getClassLocalName (aClass), "Type");
    m_sRootElementNSURI = aClass.getPackage ().getAnnotation (jakarta.xml.bind.annotation.XmlSchema.class).namespace ();
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

  /**
   * @return The local element name of the root element of this document type.
   *         E.g. <code>OrderCancellation</code> for "Order Cancellation".
   */
  @Nonnull
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
  @Nonnull
  @Nonempty
  public String getRootElementNamespaceURI ()
  {
    return m_sRootElementNSURI;
  }
}
