/**
 * Copyright (C) 2014-2019 Philip Helger (www.helger.com)
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
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_23.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_23.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.awardednotification_23.AwardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.billoflading_23.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.businesscard_23.BusinessCardType;
import oasis.names.specification.ubl.schema.xsd.callfortenders_23.CallForTendersType;
import oasis.names.specification.ubl.schema.xsd.catalogue_23.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_23.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_23.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_23.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_23.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_23.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_23.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.creditnote_23.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_23.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_23.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.digitalagreement_23.DigitalAgreementType;
import oasis.names.specification.ubl.schema.xsd.digitalcapability_23.DigitalCapabilityType;
import oasis.names.specification.ubl.schema.xsd.documentstatus_23.DocumentStatusType;
import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_23.DocumentStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.enquiry_23.EnquiryType;
import oasis.names.specification.ubl.schema.xsd.enquiryresponse_23.EnquiryResponseType;
import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_23.ExceptionCriteriaType;
import oasis.names.specification.ubl.schema.xsd.exceptionnotification_23.ExceptionNotificationType;
import oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_23.ExportCustomsDeclarationType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_23.ExpressionOfInterestRequestType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_23.ExpressionOfInterestResponseType;
import oasis.names.specification.ubl.schema.xsd.forecast_23.ForecastType;
import oasis.names.specification.ubl.schema.xsd.forecastrevision_23.ForecastRevisionType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_23.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_23.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_23.FulfilmentCancellationType;
import oasis.names.specification.ubl.schema.xsd.goodscertificate_23.GoodsCertificateType;
import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_23.GoodsItemItineraryType;
import oasis.names.specification.ubl.schema.xsd.goodsitempassport_23.GoodsItemPassportType;
import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_23.GuaranteeCertificateType;
import oasis.names.specification.ubl.schema.xsd.instructionforreturns_23.InstructionForReturnsType;
import oasis.names.specification.ubl.schema.xsd.inventoryreport_23.InventoryReportType;
import oasis.names.specification.ubl.schema.xsd.invoice_23.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_23.ItemInformationRequestType;
import oasis.names.specification.ubl.schema.xsd.order_23.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_23.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_23.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_23.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_23.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_23.PackingListType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.PriorInformationNoticeType;
import oasis.names.specification.ubl.schema.xsd.productactivity_23.ProductActivityType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportation_23.ProofOfReexportationType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_23.QualificationApplicationRequestType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_23.QualificationApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.quotation_23.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_23.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_23.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_23.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforproofofreexportation_23.RequestForProofOfReexportationType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_23.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.retailevent_23.RetailEventType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_23.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_23.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_23.StatementType;
import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_23.StockAvailabilityReportType;
import oasis.names.specification.ubl.schema.xsd.tender_23.TenderType;
import oasis.names.specification.ubl.schema.xsd.tendercontract_23.TenderContractType;
import oasis.names.specification.ubl.schema.xsd.tendererqualification_23.TendererQualificationType;
import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_23.TendererQualificationResponseType;
import oasis.names.specification.ubl.schema.xsd.tenderreceipt_23.TenderReceiptType;
import oasis.names.specification.ubl.schema.xsd.tenderstatus_23.TenderStatusType;
import oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_23.TenderStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_23.TenderWithdrawalType;
import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_23.TradeItemLocationProfileType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_23.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_23.TransportationStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_23.TransportExecutionPlanType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_23.TransportExecutionPlanRequestType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_23.TransportProgressStatusType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_23.TransportProgressStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescription_23.TransportServiceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_23.TransportServiceDescriptionRequestType;
import oasis.names.specification.ubl.schema.xsd.unawardednotification_23.UnawardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_23.UnsubscribeFromProcedureRequestType;
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_23.UnsubscribeFromProcedureResponseType;
import oasis.names.specification.ubl.schema.xsd.utilitystatement_23.UtilityStatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_23.WaybillType;
import oasis.names.specification.ubl.schema.xsd.weightstatement_23.WeightStatementType;

/**
 * Read all UBL 2.3 document types.
 * 
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL23Reader
{
  @PresentForCodeCoverage
  private static final UBL23Reader s_aInstance = new UBL23Reader ();

  private UBL23Reader () {}
/** Create a reader builder for ApplicationResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ApplicationResponseType> applicationResponse(){return UBL23ReaderBuilder.create(ApplicationResponseType.class);}
/** Create a reader builder for AttachedDocument.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<AttachedDocumentType> attachedDocument(){return UBL23ReaderBuilder.create(AttachedDocumentType.class);}
/** Create a reader builder for AwardedNotification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<AwardedNotificationType> awardedNotification(){return UBL23ReaderBuilder.create(AwardedNotificationType.class);}
/** Create a reader builder for BillOfLading.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<BillOfLadingType> billOfLading(){return UBL23ReaderBuilder.create(BillOfLadingType.class);}
/** Create a reader builder for BusinessCard.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<BusinessCardType> businessCard(){return UBL23ReaderBuilder.create(BusinessCardType.class);}
/** Create a reader builder for CallForTenders.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<CallForTendersType> callForTenders(){return UBL23ReaderBuilder.create(CallForTendersType.class);}
/** Create a reader builder for Catalogue.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<CatalogueType> catalogue(){return UBL23ReaderBuilder.create(CatalogueType.class);}
/** Create a reader builder for CatalogueDeletion.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<CatalogueDeletionType> catalogueDeletion(){return UBL23ReaderBuilder.create(CatalogueDeletionType.class);}
/** Create a reader builder for CatalogueItemSpecificationUpdate.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate(){return UBL23ReaderBuilder.create(CatalogueItemSpecificationUpdateType.class);}
/** Create a reader builder for CataloguePricingUpdate.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<CataloguePricingUpdateType> cataloguePricingUpdate(){return UBL23ReaderBuilder.create(CataloguePricingUpdateType.class);}
/** Create a reader builder for CatalogueRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<CatalogueRequestType> catalogueRequest(){return UBL23ReaderBuilder.create(CatalogueRequestType.class);}
/** Create a reader builder for CertificateOfOrigin.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<CertificateOfOriginType> certificateOfOrigin(){return UBL23ReaderBuilder.create(CertificateOfOriginType.class);}
/** Create a reader builder for ContractAwardNotice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ContractAwardNoticeType> contractAwardNotice(){return UBL23ReaderBuilder.create(ContractAwardNoticeType.class);}
/** Create a reader builder for ContractNotice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ContractNoticeType> contractNotice(){return UBL23ReaderBuilder.create(ContractNoticeType.class);}
/** Create a reader builder for CreditNote.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<CreditNoteType> creditNote(){return UBL23ReaderBuilder.create(CreditNoteType.class);}
/** Create a reader builder for DebitNote.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<DebitNoteType> debitNote(){return UBL23ReaderBuilder.create(DebitNoteType.class);}
/** Create a reader builder for DespatchAdvice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<DespatchAdviceType> despatchAdvice(){return UBL23ReaderBuilder.create(DespatchAdviceType.class);}
/** Create a reader builder for DigitalAgreement.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<DigitalAgreementType> digitalAgreement(){return UBL23ReaderBuilder.create(DigitalAgreementType.class);}
/** Create a reader builder for DigitalCapability.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<DigitalCapabilityType> digitalCapability(){return UBL23ReaderBuilder.create(DigitalCapabilityType.class);}
/** Create a reader builder for DocumentStatus.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<DocumentStatusType> documentStatus(){return UBL23ReaderBuilder.create(DocumentStatusType.class);}
/** Create a reader builder for DocumentStatusRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<DocumentStatusRequestType> documentStatusRequest(){return UBL23ReaderBuilder.create(DocumentStatusRequestType.class);}
/** Create a reader builder for Enquiry.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<EnquiryType> enquiry(){return UBL23ReaderBuilder.create(EnquiryType.class);}
/** Create a reader builder for EnquiryResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<EnquiryResponseType> enquiryResponse(){return UBL23ReaderBuilder.create(EnquiryResponseType.class);}
/** Create a reader builder for ExceptionCriteria.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ExceptionCriteriaType> exceptionCriteria(){return UBL23ReaderBuilder.create(ExceptionCriteriaType.class);}
/** Create a reader builder for ExceptionNotification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ExceptionNotificationType> exceptionNotification(){return UBL23ReaderBuilder.create(ExceptionNotificationType.class);}
/** Create a reader builder for ExportCustomsDeclaration.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ExportCustomsDeclarationType> exportCustomsDeclaration(){return UBL23ReaderBuilder.create(ExportCustomsDeclarationType.class);}
/** Create a reader builder for ExpressionOfInterestRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ExpressionOfInterestRequestType> expressionOfInterestRequest(){return UBL23ReaderBuilder.create(ExpressionOfInterestRequestType.class);}
/** Create a reader builder for ExpressionOfInterestResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ExpressionOfInterestResponseType> expressionOfInterestResponse(){return UBL23ReaderBuilder.create(ExpressionOfInterestResponseType.class);}
/** Create a reader builder for Forecast.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ForecastType> forecast(){return UBL23ReaderBuilder.create(ForecastType.class);}
/** Create a reader builder for ForecastRevision.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ForecastRevisionType> forecastRevision(){return UBL23ReaderBuilder.create(ForecastRevisionType.class);}
/** Create a reader builder for ForwardingInstructions.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ForwardingInstructionsType> forwardingInstructions(){return UBL23ReaderBuilder.create(ForwardingInstructionsType.class);}
/** Create a reader builder for FreightInvoice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<FreightInvoiceType> freightInvoice(){return UBL23ReaderBuilder.create(FreightInvoiceType.class);}
/** Create a reader builder for FulfilmentCancellation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<FulfilmentCancellationType> fulfilmentCancellation(){return UBL23ReaderBuilder.create(FulfilmentCancellationType.class);}
/** Create a reader builder for GoodsCertificate.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<GoodsCertificateType> goodsCertificate(){return UBL23ReaderBuilder.create(GoodsCertificateType.class);}
/** Create a reader builder for GoodsItemItinerary.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<GoodsItemItineraryType> goodsItemItinerary(){return UBL23ReaderBuilder.create(GoodsItemItineraryType.class);}
/** Create a reader builder for GoodsItemPassport.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<GoodsItemPassportType> goodsItemPassport(){return UBL23ReaderBuilder.create(GoodsItemPassportType.class);}
/** Create a reader builder for GuaranteeCertificate.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<GuaranteeCertificateType> guaranteeCertificate(){return UBL23ReaderBuilder.create(GuaranteeCertificateType.class);}
/** Create a reader builder for InstructionForReturns.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<InstructionForReturnsType> instructionForReturns(){return UBL23ReaderBuilder.create(InstructionForReturnsType.class);}
/** Create a reader builder for InventoryReport.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<InventoryReportType> inventoryReport(){return UBL23ReaderBuilder.create(InventoryReportType.class);}
/** Create a reader builder for Invoice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<InvoiceType> invoice(){return UBL23ReaderBuilder.create(InvoiceType.class);}
/** Create a reader builder for ItemInformationRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ItemInformationRequestType> itemInformationRequest(){return UBL23ReaderBuilder.create(ItemInformationRequestType.class);}
/** Create a reader builder for Order.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<OrderType> order(){return UBL23ReaderBuilder.create(OrderType.class);}
/** Create a reader builder for OrderCancellation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<OrderCancellationType> orderCancellation(){return UBL23ReaderBuilder.create(OrderCancellationType.class);}
/** Create a reader builder for OrderChange.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<OrderChangeType> orderChange(){return UBL23ReaderBuilder.create(OrderChangeType.class);}
/** Create a reader builder for OrderResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<OrderResponseType> orderResponse(){return UBL23ReaderBuilder.create(OrderResponseType.class);}
/** Create a reader builder for OrderResponseSimple.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<OrderResponseSimpleType> orderResponseSimple(){return UBL23ReaderBuilder.create(OrderResponseSimpleType.class);}
/** Create a reader builder for PackingList.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<PackingListType> packingList(){return UBL23ReaderBuilder.create(PackingListType.class);}
/** Create a reader builder for PriorInformationNotice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<PriorInformationNoticeType> priorInformationNotice(){return UBL23ReaderBuilder.create(PriorInformationNoticeType.class);}
/** Create a reader builder for ProductActivity.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ProductActivityType> productActivity(){return UBL23ReaderBuilder.create(ProductActivityType.class);}
/** Create a reader builder for ProofOfReexportation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ProofOfReexportationType> proofOfReexportation(){return UBL23ReaderBuilder.create(ProofOfReexportationType.class);}
/** Create a reader builder for QualificationApplicationRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<QualificationApplicationRequestType> qualificationApplicationRequest(){return UBL23ReaderBuilder.create(QualificationApplicationRequestType.class);}
/** Create a reader builder for QualificationApplicationResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<QualificationApplicationResponseType> qualificationApplicationResponse(){return UBL23ReaderBuilder.create(QualificationApplicationResponseType.class);}
/** Create a reader builder for Quotation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<QuotationType> quotation(){return UBL23ReaderBuilder.create(QuotationType.class);}
/** Create a reader builder for ReceiptAdvice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ReceiptAdviceType> receiptAdvice(){return UBL23ReaderBuilder.create(ReceiptAdviceType.class);}
/** Create a reader builder for Reminder.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<ReminderType> reminder(){return UBL23ReaderBuilder.create(ReminderType.class);}
/** Create a reader builder for RemittanceAdvice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<RemittanceAdviceType> remittanceAdvice(){return UBL23ReaderBuilder.create(RemittanceAdviceType.class);}
/** Create a reader builder for RequestForProofOfReexportation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<RequestForProofOfReexportationType> requestForProofOfReexportation(){return UBL23ReaderBuilder.create(RequestForProofOfReexportationType.class);}
/** Create a reader builder for RequestForQuotation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<RequestForQuotationType> requestForQuotation(){return UBL23ReaderBuilder.create(RequestForQuotationType.class);}
/** Create a reader builder for RetailEvent.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<RetailEventType> retailEvent(){return UBL23ReaderBuilder.create(RetailEventType.class);}
/** Create a reader builder for SelfBilledCreditNote.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<SelfBilledCreditNoteType> selfBilledCreditNote(){return UBL23ReaderBuilder.create(SelfBilledCreditNoteType.class);}
/** Create a reader builder for SelfBilledInvoice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<SelfBilledInvoiceType> selfBilledInvoice(){return UBL23ReaderBuilder.create(SelfBilledInvoiceType.class);}
/** Create a reader builder for Statement.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<StatementType> statement(){return UBL23ReaderBuilder.create(StatementType.class);}
/** Create a reader builder for StockAvailabilityReport.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<StockAvailabilityReportType> stockAvailabilityReport(){return UBL23ReaderBuilder.create(StockAvailabilityReportType.class);}
/** Create a reader builder for Tender.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TenderType> tender(){return UBL23ReaderBuilder.create(TenderType.class);}
/** Create a reader builder for TenderContract.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TenderContractType> tenderContract(){return UBL23ReaderBuilder.create(TenderContractType.class);}
/** Create a reader builder for TendererQualification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TendererQualificationType> tendererQualification(){return UBL23ReaderBuilder.create(TendererQualificationType.class);}
/** Create a reader builder for TendererQualificationResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TendererQualificationResponseType> tendererQualificationResponse(){return UBL23ReaderBuilder.create(TendererQualificationResponseType.class);}
/** Create a reader builder for TenderReceipt.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TenderReceiptType> tenderReceipt(){return UBL23ReaderBuilder.create(TenderReceiptType.class);}
/** Create a reader builder for TenderStatus.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TenderStatusType> tenderStatus(){return UBL23ReaderBuilder.create(TenderStatusType.class);}
/** Create a reader builder for TenderStatusRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TenderStatusRequestType> tenderStatusRequest(){return UBL23ReaderBuilder.create(TenderStatusRequestType.class);}
/** Create a reader builder for TenderWithdrawal.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TenderWithdrawalType> tenderWithdrawal(){return UBL23ReaderBuilder.create(TenderWithdrawalType.class);}
/** Create a reader builder for TradeItemLocationProfile.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TradeItemLocationProfileType> tradeItemLocationProfile(){return UBL23ReaderBuilder.create(TradeItemLocationProfileType.class);}
/** Create a reader builder for TransportationStatus.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TransportationStatusType> transportationStatus(){return UBL23ReaderBuilder.create(TransportationStatusType.class);}
/** Create a reader builder for TransportationStatusRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TransportationStatusRequestType> transportationStatusRequest(){return UBL23ReaderBuilder.create(TransportationStatusRequestType.class);}
/** Create a reader builder for TransportExecutionPlan.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TransportExecutionPlanType> transportExecutionPlan(){return UBL23ReaderBuilder.create(TransportExecutionPlanType.class);}
/** Create a reader builder for TransportExecutionPlanRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TransportExecutionPlanRequestType> transportExecutionPlanRequest(){return UBL23ReaderBuilder.create(TransportExecutionPlanRequestType.class);}
/** Create a reader builder for TransportProgressStatus.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TransportProgressStatusType> transportProgressStatus(){return UBL23ReaderBuilder.create(TransportProgressStatusType.class);}
/** Create a reader builder for TransportProgressStatusRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TransportProgressStatusRequestType> transportProgressStatusRequest(){return UBL23ReaderBuilder.create(TransportProgressStatusRequestType.class);}
/** Create a reader builder for TransportServiceDescription.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TransportServiceDescriptionType> transportServiceDescription(){return UBL23ReaderBuilder.create(TransportServiceDescriptionType.class);}
/** Create a reader builder for TransportServiceDescriptionRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<TransportServiceDescriptionRequestType> transportServiceDescriptionRequest(){return UBL23ReaderBuilder.create(TransportServiceDescriptionRequestType.class);}
/** Create a reader builder for UnawardedNotification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<UnawardedNotificationType> unawardedNotification(){return UBL23ReaderBuilder.create(UnawardedNotificationType.class);}
/** Create a reader builder for UnsubscribeFromProcedureRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest(){return UBL23ReaderBuilder.create(UnsubscribeFromProcedureRequestType.class);}
/** Create a reader builder for UnsubscribeFromProcedureResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse(){return UBL23ReaderBuilder.create(UnsubscribeFromProcedureResponseType.class);}
/** Create a reader builder for UtilityStatement.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<UtilityStatementType> utilityStatement(){return UBL23ReaderBuilder.create(UtilityStatementType.class);}
/** Create a reader builder for Waybill.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<WaybillType> waybill(){return UBL23ReaderBuilder.create(WaybillType.class);}
/** Create a reader builder for WeightStatement.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ReaderBuilder<WeightStatementType> weightStatement(){return UBL23ReaderBuilder.create(WeightStatementType.class);}
}