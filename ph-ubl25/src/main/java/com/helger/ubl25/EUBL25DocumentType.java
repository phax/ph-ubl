/*
 * Copyright (C) 2026 Philip Helger (www.helger.com)
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
package com.helger.ubl25;

import org.jspecify.annotations.NonNull;

import com.helger.annotation.Nonempty;
import com.helger.annotation.misc.Since;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.base.lang.clazz.ClassHelper;
import com.helger.base.string.StringHelper;
import com.helger.collection.commons.ICommonsList;
import com.helger.io.resource.ClassPathResource;

/**
 * Enumeration with all available UBL 2.5 document types.
 *
 * @author Philip Helger
 */
public enum EUBL25DocumentType
{
  APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_25.ApplicationResponseType.class,
                        UBL25Marshaller.getAllApplicationResponseXSDs ()),
  ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_25.AttachedDocumentType.class,
                     UBL25Marshaller.getAllAttachedDocumentXSDs ()),
  AWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.awardednotification_25.AwardedNotificationType.class,
                        UBL25Marshaller.getAllAwardedNotificationXSDs ()),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_25.BillOfLadingType.class,
                  UBL25Marshaller.getAllBillOfLadingXSDs ()),
  BUSINESS_CARD (oasis.names.specification.ubl.schema.xsd.businesscard_25.BusinessCardType.class,
                 UBL25Marshaller.getAllBusinessCardXSDs ()),
  BUSINESS_INFORMATION (oasis.names.specification.ubl.schema.xsd.businessinformation_25.BusinessInformationType.class,
                        UBL25Marshaller.getAllBusinessInformationXSDs ()),
  CALL_FOR_TENDERS (oasis.names.specification.ubl.schema.xsd.callfortenders_25.CallForTendersType.class,
                    UBL25Marshaller.getAllCallForTendersXSDs ()),
  CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_25.CatalogueType.class,
             UBL25Marshaller.getAllCatalogueXSDs ()),
  CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_25.CatalogueDeletionType.class,
                      UBL25Marshaller.getAllCatalogueDeletionXSDs ()),
  CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_25.CatalogueItemSpecificationUpdateType.class,
                                       UBL25Marshaller.getAllCatalogueItemSpecificationUpdateXSDs ()),
  CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_25.CataloguePricingUpdateType.class,
                            UBL25Marshaller.getAllCataloguePricingUpdateXSDs ()),
  CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_25.CatalogueRequestType.class,
                     UBL25Marshaller.getAllCatalogueRequestXSDs ()),
  CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_25.CertificateOfOriginType.class,
                         UBL25Marshaller.getAllCertificateOfOriginXSDs ()),
  COMMON_TRANSPORTATION_REPORT (oasis.names.specification.ubl.schema.xsd.commontransportationreport_25.CommonTransportationReportType.class,
                                UBL25Marshaller.getAllCommonTransportationReportXSDs ()),
  CONTRACT_AWARD_NOTICE (oasis.names.specification.ubl.schema.xsd.contractawardnotice_25.ContractAwardNoticeType.class,
                         UBL25Marshaller.getAllContractAwardNoticeXSDs ()),
  CONTRACT_NOTICE (oasis.names.specification.ubl.schema.xsd.contractnotice_25.ContractNoticeType.class,
                   UBL25Marshaller.getAllContractNoticeXSDs ()),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_25.CreditNoteType.class,
               UBL25Marshaller.getAllCreditNoteXSDs ()),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_25.DebitNoteType.class,
              UBL25Marshaller.getAllDebitNoteXSDs ()),
  @Since ("2.5")
  DELIVERY_NOTE(oasis.names.specification.ubl.schema.xsd.deliverynote_25.DeliveryNoteType.class,
                UBL25Marshaller.getAllDeliveryNoteXSDs ()),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_25.DespatchAdviceType.class,
                   UBL25Marshaller.getAllDespatchAdviceXSDs ()),
  DIGITAL_AGREEMENT (oasis.names.specification.ubl.schema.xsd.digitalagreement_25.DigitalAgreementType.class,
                     UBL25Marshaller.getAllDigitalAgreementXSDs ()),
  DIGITAL_CAPABILITY (oasis.names.specification.ubl.schema.xsd.digitalcapability_25.DigitalCapabilityType.class,
                      UBL25Marshaller.getAllDigitalCapabilityXSDs ()),
  DOCUMENT_STATUS (oasis.names.specification.ubl.schema.xsd.documentstatus_25.DocumentStatusType.class,
                   UBL25Marshaller.getAllDocumentStatusXSDs ()),
  DOCUMENT_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.documentstatusrequest_25.DocumentStatusRequestType.class,
                           UBL25Marshaller.getAllDocumentStatusRequestXSDs ()),
  ENQUIRY (oasis.names.specification.ubl.schema.xsd.enquiry_25.EnquiryType.class, UBL25Marshaller.getAllEnquiryXSDs ()),
  ENQUIRY_RESPONSE (oasis.names.specification.ubl.schema.xsd.enquiryresponse_25.EnquiryResponseType.class,
                    UBL25Marshaller.getAllEnquiryResponseXSDs ()),
  EXCEPTION_CRITERIA (oasis.names.specification.ubl.schema.xsd.exceptioncriteria_25.ExceptionCriteriaType.class,
                      UBL25Marshaller.getAllExceptionCriteriaXSDs ()),
  EXCEPTION_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.exceptionnotification_25.ExceptionNotificationType.class,
                          UBL25Marshaller.getAllExceptionNotificationXSDs ()),
  EXPORT_CUSTOMS_DECLARATION (oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_25.ExportCustomsDeclarationType.class,
                              UBL25Marshaller.getAllExportCustomsDeclarationXSDs ()),
  EXPRESSION_OF_INTEREST_REQUEST (oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_25.ExpressionOfInterestRequestType.class,
                                  UBL25Marshaller.getAllExpressionOfInterestRequestXSDs ()),
  EXPRESSION_OF_INTEREST_RESPONSE (oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_25.ExpressionOfInterestResponseType.class,
                                   UBL25Marshaller.getAllExpressionOfInterestResponseXSDs ()),
  FORECAST (oasis.names.specification.ubl.schema.xsd.forecast_25.ForecastType.class,
            UBL25Marshaller.getAllForecastXSDs ()),
  FORECAST_REVISION (oasis.names.specification.ubl.schema.xsd.forecastrevision_25.ForecastRevisionType.class,
                     UBL25Marshaller.getAllForecastRevisionXSDs ()),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_25.ForwardingInstructionsType.class,
                           UBL25Marshaller.getAllForwardingInstructionsXSDs ()),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_25.FreightInvoiceType.class,
                   UBL25Marshaller.getAllFreightInvoiceXSDs ()),
  FULFILMENT_CANCELLATION (oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_25.FulfilmentCancellationType.class,
                           UBL25Marshaller.getAllFulfilmentCancellationXSDs ()),
  GOODS_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.goodscertificate_25.GoodsCertificateType.class,
                     UBL25Marshaller.getAllGoodsCertificateXSDs ()),
  GOODS_ITEM_ITINERARY (oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_25.GoodsItemItineraryType.class,
                        UBL25Marshaller.getAllGoodsItemItineraryXSDs ()),
  GOODS_ITEM_PASSPORT (oasis.names.specification.ubl.schema.xsd.goodsitempassport_25.GoodsItemPassportType.class,
                       UBL25Marshaller.getAllGoodsItemPassportXSDs ()),
  GUARANTEE_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.guaranteecertificate_25.GuaranteeCertificateType.class,
                         UBL25Marshaller.getAllGuaranteeCertificateXSDs ()),
  IMPORT_CUSTOMS_DECLARATION (oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_25.ImportCustomsDeclarationType.class,
                              UBL25Marshaller.getAllImportCustomsDeclarationXSDs ()),
  INSTRUCTION_FOR_RETURNS (oasis.names.specification.ubl.schema.xsd.instructionforreturns_25.InstructionForReturnsType.class,
                           UBL25Marshaller.getAllInstructionForReturnsXSDs ()),
  INVENTORY_REPORT (oasis.names.specification.ubl.schema.xsd.inventoryreport_25.InventoryReportType.class,
                    UBL25Marshaller.getAllInventoryReportXSDs ()),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_25.InvoiceType.class, UBL25Marshaller.getAllInvoiceXSDs ()),
  @Since ("2.5")
  INVOICE_STATUS_REQUEST(oasis.names.specification.ubl.schema.xsd.invoicestatusrequest_25.InvoiceStatusRequestType.class,
                         UBL25Marshaller.getAllInvoiceStatusRequestXSDs ()),
  @Since ("2.5")
  INVOICE_STATUS_RESPONSE(oasis.names.specification.ubl.schema.xsd.invoicestatusresponse_25.InvoiceStatusResponseType.class,
                          UBL25Marshaller.getAllInvoiceStatusResponseXSDs ()),
  ITEM_INFORMATION_REQUEST (oasis.names.specification.ubl.schema.xsd.iteminformationrequest_25.ItemInformationRequestType.class,
                            UBL25Marshaller.getAllItemInformationRequestXSDs ()),
  MANIFEST (oasis.names.specification.ubl.schema.xsd.manifest_25.ManifestType.class,
            UBL25Marshaller.getAllManifestXSDs ()),
  ORDER (oasis.names.specification.ubl.schema.xsd.order_25.OrderType.class, UBL25Marshaller.getAllOrderXSDs ()),
  ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_25.OrderCancellationType.class,
                      UBL25Marshaller.getAllOrderCancellationXSDs ()),
  ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_25.OrderChangeType.class,
                UBL25Marshaller.getAllOrderChangeXSDs ()),
  ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_25.OrderResponseType.class,
                  UBL25Marshaller.getAllOrderResponseXSDs ()),
  ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_25.OrderResponseSimpleType.class,
                         UBL25Marshaller.getAllOrderResponseSimpleXSDs ()),
  PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_25.PackingListType.class,
                UBL25Marshaller.getAllPackingListXSDs ()),
  PRIOR_INFORMATION_NOTICE (oasis.names.specification.ubl.schema.xsd.priorinformationnotice_25.PriorInformationNoticeType.class,
                            UBL25Marshaller.getAllPriorInformationNoticeXSDs ()),
  PRODUCT_ACTIVITY (oasis.names.specification.ubl.schema.xsd.productactivity_25.ProductActivityType.class,
                    UBL25Marshaller.getAllProductActivityXSDs ()),
  @Since ("2.5")
  PROCUREMENT_STATUS(oasis.names.specification.ubl.schema.xsd.procurementstatus_25.ProcurementStatusType.class,
                     UBL25Marshaller.getAllProcurementStatusXSDs ()),
  @Since ("2.5")
  PROCUREMENT_STATUS_REQUEST(oasis.names.specification.ubl.schema.xsd.procurementstatusrequest_25.ProcurementStatusRequestType.class,
                             UBL25Marshaller.getAllProcurementStatusRequestXSDs ()),
  PROOF_OF_REEXPORTATION (oasis.names.specification.ubl.schema.xsd.proofofreexportation_25.ProofOfReexportationType.class,
                          UBL25Marshaller.getAllProofOfReexportationXSDs ()),
  PROOF_OF_REEXPORTATION_REMINDER (oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_25.ProofOfReexportationReminderType.class,
                                   UBL25Marshaller.getAllProofOfReexportationReminderXSDs ()),
  PROOF_OF_REEXPORTATION_REQUEST (oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_25.ProofOfReexportationRequestType.class,
                                  UBL25Marshaller.getAllProofOfReexportationRequestXSDs ()),
  @Since ("2.4")
  PURCHASE_RECEIPT(oasis.names.specification.ubl.schema.xsd.purchasereceipt_25.PurchaseReceiptType.class,
                   UBL25Marshaller.getAllPurchaseReceiptXSDs ()),
  QUALIFICATION_APPLICATION_REQUEST (oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_25.QualificationApplicationRequestType.class,
                                     UBL25Marshaller.getAllQualificationApplicationRequestXSDs ()),
  QUALIFICATION_APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_25.QualificationApplicationResponseType.class,
                                      UBL25Marshaller.getAllQualificationApplicationResponseXSDs ()),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_25.QuotationType.class,
             UBL25Marshaller.getAllQuotationXSDs ()),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_25.ReceiptAdviceType.class,
                  UBL25Marshaller.getAllReceiptAdviceXSDs ()),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_25.ReminderType.class,
            UBL25Marshaller.getAllReminderXSDs ()),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_25.RemittanceAdviceType.class,
                     UBL25Marshaller.getAllRemittanceAdviceXSDs ()),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_25.RequestForQuotationType.class,
                         UBL25Marshaller.getAllRequestForQuotationXSDs ()),
  RETAIL_EVENT (oasis.names.specification.ubl.schema.xsd.retailevent_25.RetailEventType.class,
                UBL25Marshaller.getAllRetailEventXSDs ()),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_25.SelfBilledCreditNoteType.class,
                           UBL25Marshaller.getAllSelfBilledCreditNoteXSDs ()),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_25.SelfBilledInvoiceType.class,
                       UBL25Marshaller.getAllSelfBilledInvoiceXSDs ()),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_25.StatementType.class,
             UBL25Marshaller.getAllStatementXSDs ()),
  STOCK_AVAILABILITY_REPORT (oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_25.StockAvailabilityReportType.class,
                             UBL25Marshaller.getAllStockAvailabilityReportXSDs ()),
  TENDER (oasis.names.specification.ubl.schema.xsd.tender_25.TenderType.class, UBL25Marshaller.getAllTenderXSDs ()),
  TENDER_CONTRACT (oasis.names.specification.ubl.schema.xsd.tendercontract_25.TenderContractType.class,
                   UBL25Marshaller.getAllTenderContractXSDs ()),
  TENDER_RECEIPT (oasis.names.specification.ubl.schema.xsd.tenderreceipt_25.TenderReceiptType.class,
                  UBL25Marshaller.getAllTenderReceiptXSDs ()),
  TENDER_STATUS (oasis.names.specification.ubl.schema.xsd.tenderstatus_25.TenderStatusType.class,
                 UBL25Marshaller.getAllTenderStatusXSDs ()),
  TENDER_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_25.TenderStatusRequestType.class,
                         UBL25Marshaller.getAllTenderStatusRequestXSDs ()),
  TENDER_WITHDRAWAL (oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_25.TenderWithdrawalType.class,
                     UBL25Marshaller.getAllTenderWithdrawalXSDs ()),
  TENDERER_QUALIFICATION (oasis.names.specification.ubl.schema.xsd.tendererqualification_25.TendererQualificationType.class,
                          UBL25Marshaller.getAllTendererQualificationXSDs ()),
  TENDERER_QUALIFICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_25.TendererQualificationResponseType.class,
                                   UBL25Marshaller.getAllTendererQualificationResponseXSDs ()),
  TRADE_ITEM_LOCATION_PROFILE (oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_25.TradeItemLocationProfileType.class,
                               UBL25Marshaller.getAllTradeItemLocationProfileXSDs ()),
  TRANSIT_CUSTOMS_DECLARATION (oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_25.TransitCustomsDeclarationType.class,
                               UBL25Marshaller.getAllTransitCustomsDeclarationXSDs ()),
  TRANSPORT_EXECUTION_PLAN (oasis.names.specification.ubl.schema.xsd.transportexecutionplan_25.TransportExecutionPlanType.class,
                            UBL25Marshaller.getAllTransportExecutionPlanXSDs ()),
  TRANSPORT_EXECUTION_PLAN_REQUEST (oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_25.TransportExecutionPlanRequestType.class,
                                    UBL25Marshaller.getAllTransportExecutionPlanRequestXSDs ()),
  TRANSPORT_PROGRESS_STATUS (oasis.names.specification.ubl.schema.xsd.transportprogressstatus_25.TransportProgressStatusType.class,
                             UBL25Marshaller.getAllTransportProgressStatusXSDs ()),
  TRANSPORT_PROGRESS_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_25.TransportProgressStatusRequestType.class,
                                     UBL25Marshaller.getAllTransportProgressStatusRequestXSDs ()),
  TRANSPORT_SERVICE_DESCRIPTION (oasis.names.specification.ubl.schema.xsd.transportservicedescription_25.TransportServiceDescriptionType.class,
                                 UBL25Marshaller.getAllTransportServiceDescriptionXSDs ()),
  TRANSPORT_SERVICE_DESCRIPTION_REQUEST (oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_25.TransportServiceDescriptionRequestType.class,
                                         UBL25Marshaller.getAllTransportServiceDescriptionRequestXSDs ()),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_25.TransportationStatusType.class,
                         UBL25Marshaller.getAllTransportationStatusXSDs ()),
  TRANSPORTATION_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_25.TransportationStatusRequestType.class,
                                 UBL25Marshaller.getAllTransportationStatusRequestXSDs ()),
  UNAWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.unawardednotification_25.UnawardedNotificationType.class,
                          UBL25Marshaller.getAllUnawardedNotificationXSDs ()),
  UNSUBSCRIBE_FROM_PROCEDURE_REQUEST (oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_25.UnsubscribeFromProcedureRequestType.class,
                                      UBL25Marshaller.getAllUnsubscribeFromProcedureRequestXSDs ()),
  UNSUBSCRIBE_FROM_PROCEDURE_RESPONSE (oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_25.UnsubscribeFromProcedureResponseType.class,
                                       UBL25Marshaller.getAllUnsubscribeFromProcedureResponseXSDs ()),
  UTILITY_STATEMENT (oasis.names.specification.ubl.schema.xsd.utilitystatement_25.UtilityStatementType.class,
                     UBL25Marshaller.getAllUtilityStatementXSDs ()),
  @Since ("2.5")
  WASTE_MOVEMENT(oasis.names.specification.ubl.schema.xsd.wastemovement_25.WasteMovementType.class,
                 UBL25Marshaller.getAllWasteMovementXSDs ()),
  @Since ("2.5")
  WASTE_NOTIFICATION(oasis.names.specification.ubl.schema.xsd.wastenotification_25.WasteNotificationType.class,
                     UBL25Marshaller.getAllWasteNotificationXSDs ()),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_25.WaybillType.class, UBL25Marshaller.getAllWaybillXSDs ()),
  WEIGHT_STATEMENT (oasis.names.specification.ubl.schema.xsd.weightstatement_25.WeightStatementType.class,
                    UBL25Marshaller.getAllWeightStatementXSDs ()),
  @Since ("2.5")
  WORK_REPORT(oasis.names.specification.ubl.schema.xsd.workreport_25.WorkReportType.class,
              UBL25Marshaller.getAllWorkReportXSDs ());

  private final Class <?> m_aImplClass;
  private final ICommonsList <ClassPathResource> m_aXSDs;
  private final String m_sRootElementLocalName;
  private final String m_sRootElementNSURI;

  EUBL25DocumentType (@NonNull final Class <?> aClass, @NonNull final ICommonsList <ClassPathResource> aXSDs)
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
   * @return The local element name of the root element of this document type. E.g.
   *         <code>OrderCancellation</code> for "Order Cancellation".
   */
  @NonNull
  @Nonempty
  public String getRootElementLocalName ()
  {
    return m_sRootElementLocalName;
  }

  /**
   * @return The XML namespace URI of the root element of this document type. E.g.
   *         <code>urn:oasis:names:specification:ubl:schema:xsd:OrderCancellation-2</code> for
   *         "Order Cancellation".
   */
  @NonNull
  @Nonempty
  public String getRootElementNamespaceURI ()
  {
    return m_sRootElementNSURI;
  }
}
