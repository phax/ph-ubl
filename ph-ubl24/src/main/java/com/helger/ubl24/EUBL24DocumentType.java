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
package com.helger.ubl24;

import javax.annotation.Nonnull;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.annotation.Since;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.lang.ClassHelper;
import com.helger.commons.string.StringHelper;

/**
 * Enumeration with all available UBL 2.4 document types.
 *
 * @author Philip Helger
 */
public enum EUBL24DocumentType
{
  APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_24.ApplicationResponseType.class,
                        UBL24Marshaller.getAllApplicationResponseXSDs ()),
  ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_24.AttachedDocumentType.class,
                     UBL24Marshaller.getAllAttachedDocumentXSDs ()),
  AWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.awardednotification_24.AwardedNotificationType.class,
                        UBL24Marshaller.getAllAwardedNotificationXSDs ()),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_24.BillOfLadingType.class,
                  UBL24Marshaller.getAllBillOfLadingXSDs ()),
  BUSINESS_CARD (oasis.names.specification.ubl.schema.xsd.businesscard_24.BusinessCardType.class,
                 UBL24Marshaller.getAllBusinessCardXSDs ()),
  @Since ("2.4")
  BUSINESS_INFORMATION(oasis.names.specification.ubl.schema.xsd.businessinformation_24.BusinessInformationType.class,
                       UBL24Marshaller.getAllBusinessInformationXSDs ()),
  CALL_FOR_TENDERS (oasis.names.specification.ubl.schema.xsd.callfortenders_24.CallForTendersType.class,
                    UBL24Marshaller.getAllCallForTendersXSDs ()),
  CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_24.CatalogueType.class, UBL24Marshaller.getAllCatalogueXSDs ()),
  CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_24.CatalogueDeletionType.class,
                      UBL24Marshaller.getAllCatalogueDeletionXSDs ()),
  CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_24.CatalogueItemSpecificationUpdateType.class,
                                       UBL24Marshaller.getAllCatalogueItemSpecificationUpdateXSDs ()),
  CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_24.CataloguePricingUpdateType.class,
                            UBL24Marshaller.getAllCataloguePricingUpdateXSDs ()),
  CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_24.CatalogueRequestType.class,
                     UBL24Marshaller.getAllCatalogueRequestXSDs ()),
  CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_24.CertificateOfOriginType.class,
                         UBL24Marshaller.getAllCertificateOfOriginXSDs ()),
  COMMON_TRANSPORTATION_REPORT (oasis.names.specification.ubl.schema.xsd.commontransportationreport_24.CommonTransportationReportType.class,
                                UBL24Marshaller.getAllCommonTransportationReportXSDs ()),
  CONTRACT_AWARD_NOTICE (oasis.names.specification.ubl.schema.xsd.contractawardnotice_24.ContractAwardNoticeType.class,
                         UBL24Marshaller.getAllContractAwardNoticeXSDs ()),
  CONTRACT_NOTICE (oasis.names.specification.ubl.schema.xsd.contractnotice_24.ContractNoticeType.class,
                   UBL24Marshaller.getAllContractNoticeXSDs ()),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_24.CreditNoteType.class, UBL24Marshaller.getAllCreditNoteXSDs ()),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_24.DebitNoteType.class, UBL24Marshaller.getAllDebitNoteXSDs ()),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_24.DespatchAdviceType.class,
                   UBL24Marshaller.getAllDespatchAdviceXSDs ()),
  DIGITAL_AGREEMENT (oasis.names.specification.ubl.schema.xsd.digitalagreement_24.DigitalAgreementType.class,
                     UBL24Marshaller.getAllDigitalAgreementXSDs ()),
  DIGITAL_CAPABILITY (oasis.names.specification.ubl.schema.xsd.digitalcapability_24.DigitalCapabilityType.class,
                      UBL24Marshaller.getAllDigitalCapabilityXSDs ()),
  DOCUMENT_STATUS (oasis.names.specification.ubl.schema.xsd.documentstatus_24.DocumentStatusType.class,
                   UBL24Marshaller.getAllDocumentStatusXSDs ()),
  DOCUMENT_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.documentstatusrequest_24.DocumentStatusRequestType.class,
                           UBL24Marshaller.getAllDocumentStatusRequestXSDs ()),
  ENQUIRY (oasis.names.specification.ubl.schema.xsd.enquiry_24.EnquiryType.class, UBL24Marshaller.getAllEnquiryXSDs ()),
  ENQUIRY_RESPONSE (oasis.names.specification.ubl.schema.xsd.enquiryresponse_24.EnquiryResponseType.class,
                    UBL24Marshaller.getAllEnquiryResponseXSDs ()),
  EXCEPTION_CRITERIA (oasis.names.specification.ubl.schema.xsd.exceptioncriteria_24.ExceptionCriteriaType.class,
                      UBL24Marshaller.getAllExceptionCriteriaXSDs ()),
  EXCEPTION_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.exceptionnotification_24.ExceptionNotificationType.class,
                          UBL24Marshaller.getAllExceptionNotificationXSDs ()),
  EXPORT_CUSTOMS_DECLARATION (oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_24.ExportCustomsDeclarationType.class,
                              UBL24Marshaller.getAllExportCustomsDeclarationXSDs ()),
  EXPRESSION_OF_INTEREST_REQUEST (oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_24.ExpressionOfInterestRequestType.class,
                                  UBL24Marshaller.getAllExpressionOfInterestRequestXSDs ()),
  EXPRESSION_OF_INTEREST_RESPONSE (oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_24.ExpressionOfInterestResponseType.class,
                                   UBL24Marshaller.getAllExpressionOfInterestResponseXSDs ()),
  FORECAST (oasis.names.specification.ubl.schema.xsd.forecast_24.ForecastType.class, UBL24Marshaller.getAllForecastXSDs ()),
  FORECAST_REVISION (oasis.names.specification.ubl.schema.xsd.forecastrevision_24.ForecastRevisionType.class,
                     UBL24Marshaller.getAllForecastRevisionXSDs ()),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_24.ForwardingInstructionsType.class,
                           UBL24Marshaller.getAllForwardingInstructionsXSDs ()),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_24.FreightInvoiceType.class,
                   UBL24Marshaller.getAllFreightInvoiceXSDs ()),
  FULFILMENT_CANCELLATION (oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_24.FulfilmentCancellationType.class,
                           UBL24Marshaller.getAllFulfilmentCancellationXSDs ()),
  GOODS_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.goodscertificate_24.GoodsCertificateType.class,
                     UBL24Marshaller.getAllGoodsCertificateXSDs ()),
  GOODS_ITEM_ITINERARY (oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_24.GoodsItemItineraryType.class,
                        UBL24Marshaller.getAllGoodsItemItineraryXSDs ()),
  GOODS_ITEM_PASSPORT (oasis.names.specification.ubl.schema.xsd.goodsitempassport_24.GoodsItemPassportType.class,
                       UBL24Marshaller.getAllGoodsItemPassportXSDs ()),
  GUARANTEE_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.guaranteecertificate_24.GuaranteeCertificateType.class,
                         UBL24Marshaller.getAllGuaranteeCertificateXSDs ()),
  IMPORT_CUSTOMS_DECLARATION (oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_24.ImportCustomsDeclarationType.class,
                              UBL24Marshaller.getAllImportCustomsDeclarationXSDs ()),
  INSTRUCTION_FOR_RETURNS (oasis.names.specification.ubl.schema.xsd.instructionforreturns_24.InstructionForReturnsType.class,
                           UBL24Marshaller.getAllInstructionForReturnsXSDs ()),
  INVENTORY_REPORT (oasis.names.specification.ubl.schema.xsd.inventoryreport_24.InventoryReportType.class,
                    UBL24Marshaller.getAllInventoryReportXSDs ()),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_24.InvoiceType.class, UBL24Marshaller.getAllInvoiceXSDs ()),
  ITEM_INFORMATION_REQUEST (oasis.names.specification.ubl.schema.xsd.iteminformationrequest_24.ItemInformationRequestType.class,
                            UBL24Marshaller.getAllItemInformationRequestXSDs ()),
  MANIFEST (oasis.names.specification.ubl.schema.xsd.manifest_24.ManifestType.class, UBL24Marshaller.getAllManifestXSDs ()),
  ORDER (oasis.names.specification.ubl.schema.xsd.order_24.OrderType.class, UBL24Marshaller.getAllOrderXSDs ()),
  ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_24.OrderCancellationType.class,
                      UBL24Marshaller.getAllOrderCancellationXSDs ()),
  ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_24.OrderChangeType.class, UBL24Marshaller.getAllOrderChangeXSDs ()),
  ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_24.OrderResponseType.class,
                  UBL24Marshaller.getAllOrderResponseXSDs ()),
  ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_24.OrderResponseSimpleType.class,
                         UBL24Marshaller.getAllOrderResponseSimpleXSDs ()),
  PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_24.PackingListType.class, UBL24Marshaller.getAllPackingListXSDs ()),
  PRIOR_INFORMATION_NOTICE (oasis.names.specification.ubl.schema.xsd.priorinformationnotice_24.PriorInformationNoticeType.class,
                            UBL24Marshaller.getAllPriorInformationNoticeXSDs ()),
  PRODUCT_ACTIVITY (oasis.names.specification.ubl.schema.xsd.productactivity_24.ProductActivityType.class,
                    UBL24Marshaller.getAllProductActivityXSDs ()),
  PROOF_OF_REEXPORTATION (oasis.names.specification.ubl.schema.xsd.proofofreexportation_24.ProofOfReexportationType.class,
                          UBL24Marshaller.getAllProofOfReexportationXSDs ()),
  PROOF_OF_REEXPORTATION_REMINDER (oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_24.ProofOfReexportationReminderType.class,
                                   UBL24Marshaller.getAllProofOfReexportationReminderXSDs ()),
  PROOF_OF_REEXPORTATION_REQUEST (oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_24.ProofOfReexportationRequestType.class,
                                  UBL24Marshaller.getAllProofOfReexportationRequestXSDs ()),
  @Since ("2.4")
  PURCHASE_RECEIPT(oasis.names.specification.ubl.schema.xsd.purchasereceipt_24.PurchaseReceiptType.class,
                   UBL24Marshaller.getAllPurchaseReceiptXSDs ()),
  QUALIFICATION_APPLICATION_REQUEST (oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_24.QualificationApplicationRequestType.class,
                                     UBL24Marshaller.getAllQualificationApplicationRequestXSDs ()),
  QUALIFICATION_APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_24.QualificationApplicationResponseType.class,
                                      UBL24Marshaller.getAllQualificationApplicationResponseXSDs ()),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_24.QuotationType.class, UBL24Marshaller.getAllQuotationXSDs ()),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_24.ReceiptAdviceType.class,
                  UBL24Marshaller.getAllReceiptAdviceXSDs ()),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_24.ReminderType.class, UBL24Marshaller.getAllReminderXSDs ()),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_24.RemittanceAdviceType.class,
                     UBL24Marshaller.getAllRemittanceAdviceXSDs ()),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_24.RequestForQuotationType.class,
                         UBL24Marshaller.getAllRequestForQuotationXSDs ()),
  RETAIL_EVENT (oasis.names.specification.ubl.schema.xsd.retailevent_24.RetailEventType.class, UBL24Marshaller.getAllRetailEventXSDs ()),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_24.SelfBilledCreditNoteType.class,
                           UBL24Marshaller.getAllSelfBilledCreditNoteXSDs ()),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_24.SelfBilledInvoiceType.class,
                       UBL24Marshaller.getAllSelfBilledInvoiceXSDs ()),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_24.StatementType.class, UBL24Marshaller.getAllStatementXSDs ()),
  STOCK_AVAILABILITY_REPORT (oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_24.StockAvailabilityReportType.class,
                             UBL24Marshaller.getAllStockAvailabilityReportXSDs ()),
  TENDER (oasis.names.specification.ubl.schema.xsd.tender_24.TenderType.class, UBL24Marshaller.getAllTenderXSDs ()),
  TENDER_CONTRACT (oasis.names.specification.ubl.schema.xsd.tendercontract_24.TenderContractType.class,
                   UBL24Marshaller.getAllTenderContractXSDs ()),
  TENDER_RECEIPT (oasis.names.specification.ubl.schema.xsd.tenderreceipt_24.TenderReceiptType.class,
                  UBL24Marshaller.getAllTenderReceiptXSDs ()),
  TENDER_STATUS (oasis.names.specification.ubl.schema.xsd.tenderstatus_24.TenderStatusType.class,
                 UBL24Marshaller.getAllTenderStatusXSDs ()),
  TENDER_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_24.TenderStatusRequestType.class,
                         UBL24Marshaller.getAllTenderStatusRequestXSDs ()),
  TENDER_WITHDRAWAL (oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_24.TenderWithdrawalType.class,
                     UBL24Marshaller.getAllTenderWithdrawalXSDs ()),
  TENDERER_QUALIFICATION (oasis.names.specification.ubl.schema.xsd.tendererqualification_24.TendererQualificationType.class,
                          UBL24Marshaller.getAllTendererQualificationXSDs ()),
  TENDERER_QUALIFICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_24.TendererQualificationResponseType.class,
                                   UBL24Marshaller.getAllTendererQualificationResponseXSDs ()),
  TRADE_ITEM_LOCATION_PROFILE (oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_24.TradeItemLocationProfileType.class,
                               UBL24Marshaller.getAllTradeItemLocationProfileXSDs ()),
  TRANSIT_CUSTOMS_DECLARATION (oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_24.TransitCustomsDeclarationType.class,
                               UBL24Marshaller.getAllTransitCustomsDeclarationXSDs ()),
  TRANSPORT_EXECUTION_PLAN (oasis.names.specification.ubl.schema.xsd.transportexecutionplan_24.TransportExecutionPlanType.class,
                            UBL24Marshaller.getAllTransportExecutionPlanXSDs ()),
  TRANSPORT_EXECUTION_PLAN_REQUEST (oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_24.TransportExecutionPlanRequestType.class,
                                    UBL24Marshaller.getAllTransportExecutionPlanRequestXSDs ()),
  TRANSPORT_PROGRESS_STATUS (oasis.names.specification.ubl.schema.xsd.transportprogressstatus_24.TransportProgressStatusType.class,
                             UBL24Marshaller.getAllTransportProgressStatusXSDs ()),
  TRANSPORT_PROGRESS_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_24.TransportProgressStatusRequestType.class,
                                     UBL24Marshaller.getAllTransportProgressStatusRequestXSDs ()),
  TRANSPORT_SERVICE_DESCRIPTION (oasis.names.specification.ubl.schema.xsd.transportservicedescription_24.TransportServiceDescriptionType.class,
                                 UBL24Marshaller.getAllTransportServiceDescriptionXSDs ()),
  TRANSPORT_SERVICE_DESCRIPTION_REQUEST (oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_24.TransportServiceDescriptionRequestType.class,
                                         UBL24Marshaller.getAllTransportServiceDescriptionRequestXSDs ()),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_24.TransportationStatusType.class,
                         UBL24Marshaller.getAllTransportationStatusXSDs ()),
  TRANSPORTATION_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_24.TransportationStatusRequestType.class,
                                 UBL24Marshaller.getAllTransportationStatusRequestXSDs ()),
  UNAWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.unawardednotification_24.UnawardedNotificationType.class,
                          UBL24Marshaller.getAllUnawardedNotificationXSDs ()),
  UNSUBSCRIBE_FROM_PROCEDURE_REQUEST (oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_24.UnsubscribeFromProcedureRequestType.class,
                                      UBL24Marshaller.getAllUnsubscribeFromProcedureRequestXSDs ()),
  UNSUBSCRIBE_FROM_PROCEDURE_RESPONSE (oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_24.UnsubscribeFromProcedureResponseType.class,
                                       UBL24Marshaller.getAllUnsubscribeFromProcedureResponseXSDs ()),
  UTILITY_STATEMENT (oasis.names.specification.ubl.schema.xsd.utilitystatement_24.UtilityStatementType.class,
                     UBL24Marshaller.getAllUtilityStatementXSDs ()),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_24.WaybillType.class, UBL24Marshaller.getAllWaybillXSDs ()),
  WEIGHT_STATEMENT (oasis.names.specification.ubl.schema.xsd.weightstatement_24.WeightStatementType.class,
                    UBL24Marshaller.getAllWeightStatementXSDs ());

  private final Class <?> m_aImplClass;
  private final ICommonsList <ClassPathResource> m_aXSDs;
  private final String m_sRootElementLocalName;
  private final String m_sRootElementNSURI;

  EUBL24DocumentType (@Nonnull final Class <?> aClass, @Nonnull final ICommonsList <ClassPathResource> aXSDs)
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
