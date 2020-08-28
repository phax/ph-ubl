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
import oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_23.ImportCustomsDeclarationType;
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
import oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_23.ProofOfReexportationRequestType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_23.ProofOfReexportationReminderType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_23.QualificationApplicationRequestType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_23.QualificationApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.quotation_23.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_23.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_23.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_23.RemittanceAdviceType;
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
import oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_23.TransitCustomsDeclarationType;
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
 * Validate all UBL 2.3 document types.
 * 
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL23Validator
{
  @PresentForCodeCoverage
  private static final UBL23Validator s_aInstance = new UBL23Validator ();

  private UBL23Validator () {}
/** Create a validation builder for ApplicationResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ApplicationResponseType> applicationResponse(){return UBL23ValidatorBuilder.create(ApplicationResponseType.class);}
/** Create a validation builder for AttachedDocument.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<AttachedDocumentType> attachedDocument(){return UBL23ValidatorBuilder.create(AttachedDocumentType.class);}
/** Create a validation builder for AwardedNotification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<AwardedNotificationType> awardedNotification(){return UBL23ValidatorBuilder.create(AwardedNotificationType.class);}
/** Create a validation builder for BillOfLading.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<BillOfLadingType> billOfLading(){return UBL23ValidatorBuilder.create(BillOfLadingType.class);}
/** Create a validation builder for BusinessCard.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<BusinessCardType> businessCard(){return UBL23ValidatorBuilder.create(BusinessCardType.class);}
/** Create a validation builder for CallForTenders.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<CallForTendersType> callForTenders(){return UBL23ValidatorBuilder.create(CallForTendersType.class);}
/** Create a validation builder for Catalogue.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<CatalogueType> catalogue(){return UBL23ValidatorBuilder.create(CatalogueType.class);}
/** Create a validation builder for CatalogueDeletion.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<CatalogueDeletionType> catalogueDeletion(){return UBL23ValidatorBuilder.create(CatalogueDeletionType.class);}
/** Create a validation builder for CatalogueItemSpecificationUpdate.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate(){return UBL23ValidatorBuilder.create(CatalogueItemSpecificationUpdateType.class);}
/** Create a validation builder for CataloguePricingUpdate.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<CataloguePricingUpdateType> cataloguePricingUpdate(){return UBL23ValidatorBuilder.create(CataloguePricingUpdateType.class);}
/** Create a validation builder for CatalogueRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<CatalogueRequestType> catalogueRequest(){return UBL23ValidatorBuilder.create(CatalogueRequestType.class);}
/** Create a validation builder for CertificateOfOrigin.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<CertificateOfOriginType> certificateOfOrigin(){return UBL23ValidatorBuilder.create(CertificateOfOriginType.class);}
/** Create a validation builder for ContractAwardNotice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ContractAwardNoticeType> contractAwardNotice(){return UBL23ValidatorBuilder.create(ContractAwardNoticeType.class);}
/** Create a validation builder for ContractNotice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ContractNoticeType> contractNotice(){return UBL23ValidatorBuilder.create(ContractNoticeType.class);}
/** Create a validation builder for CreditNote.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<CreditNoteType> creditNote(){return UBL23ValidatorBuilder.create(CreditNoteType.class);}
/** Create a validation builder for DebitNote.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<DebitNoteType> debitNote(){return UBL23ValidatorBuilder.create(DebitNoteType.class);}
/** Create a validation builder for DespatchAdvice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<DespatchAdviceType> despatchAdvice(){return UBL23ValidatorBuilder.create(DespatchAdviceType.class);}
/** Create a validation builder for DigitalAgreement.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<DigitalAgreementType> digitalAgreement(){return UBL23ValidatorBuilder.create(DigitalAgreementType.class);}
/** Create a validation builder for DigitalCapability.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<DigitalCapabilityType> digitalCapability(){return UBL23ValidatorBuilder.create(DigitalCapabilityType.class);}
/** Create a validation builder for DocumentStatus.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<DocumentStatusType> documentStatus(){return UBL23ValidatorBuilder.create(DocumentStatusType.class);}
/** Create a validation builder for DocumentStatusRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<DocumentStatusRequestType> documentStatusRequest(){return UBL23ValidatorBuilder.create(DocumentStatusRequestType.class);}
/** Create a validation builder for Enquiry.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<EnquiryType> enquiry(){return UBL23ValidatorBuilder.create(EnquiryType.class);}
/** Create a validation builder for EnquiryResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<EnquiryResponseType> enquiryResponse(){return UBL23ValidatorBuilder.create(EnquiryResponseType.class);}
/** Create a validation builder for ExceptionCriteria.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ExceptionCriteriaType> exceptionCriteria(){return UBL23ValidatorBuilder.create(ExceptionCriteriaType.class);}
/** Create a validation builder for ExceptionNotification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ExceptionNotificationType> exceptionNotification(){return UBL23ValidatorBuilder.create(ExceptionNotificationType.class);}
/** Create a validation builder for ExportCustomsDeclaration.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ExportCustomsDeclarationType> exportCustomsDeclaration(){return UBL23ValidatorBuilder.create(ExportCustomsDeclarationType.class);}
/** Create a validation builder for ExpressionOfInterestRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ExpressionOfInterestRequestType> expressionOfInterestRequest(){return UBL23ValidatorBuilder.create(ExpressionOfInterestRequestType.class);}
/** Create a validation builder for ExpressionOfInterestResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ExpressionOfInterestResponseType> expressionOfInterestResponse(){return UBL23ValidatorBuilder.create(ExpressionOfInterestResponseType.class);}
/** Create a validation builder for Forecast.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ForecastType> forecast(){return UBL23ValidatorBuilder.create(ForecastType.class);}
/** Create a validation builder for ForecastRevision.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ForecastRevisionType> forecastRevision(){return UBL23ValidatorBuilder.create(ForecastRevisionType.class);}
/** Create a validation builder for ForwardingInstructions.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ForwardingInstructionsType> forwardingInstructions(){return UBL23ValidatorBuilder.create(ForwardingInstructionsType.class);}
/** Create a validation builder for FreightInvoice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<FreightInvoiceType> freightInvoice(){return UBL23ValidatorBuilder.create(FreightInvoiceType.class);}
/** Create a validation builder for FulfilmentCancellation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<FulfilmentCancellationType> fulfilmentCancellation(){return UBL23ValidatorBuilder.create(FulfilmentCancellationType.class);}
/** Create a validation builder for GoodsCertificate.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<GoodsCertificateType> goodsCertificate(){return UBL23ValidatorBuilder.create(GoodsCertificateType.class);}
/** Create a validation builder for GoodsItemItinerary.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<GoodsItemItineraryType> goodsItemItinerary(){return UBL23ValidatorBuilder.create(GoodsItemItineraryType.class);}
/** Create a validation builder for GoodsItemPassport.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<GoodsItemPassportType> goodsItemPassport(){return UBL23ValidatorBuilder.create(GoodsItemPassportType.class);}
/** Create a validation builder for GuaranteeCertificate.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<GuaranteeCertificateType> guaranteeCertificate(){return UBL23ValidatorBuilder.create(GuaranteeCertificateType.class);}
/** Create a validation builder for ImportCustomsDeclaration.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ImportCustomsDeclarationType> importCustomsDeclaration(){return UBL23ValidatorBuilder.create(ImportCustomsDeclarationType.class);}
/** Create a validation builder for InstructionForReturns.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<InstructionForReturnsType> instructionForReturns(){return UBL23ValidatorBuilder.create(InstructionForReturnsType.class);}
/** Create a validation builder for InventoryReport.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<InventoryReportType> inventoryReport(){return UBL23ValidatorBuilder.create(InventoryReportType.class);}
/** Create a validation builder for Invoice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<InvoiceType> invoice(){return UBL23ValidatorBuilder.create(InvoiceType.class);}
/** Create a validation builder for ItemInformationRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ItemInformationRequestType> itemInformationRequest(){return UBL23ValidatorBuilder.create(ItemInformationRequestType.class);}
/** Create a validation builder for Order.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<OrderType> order(){return UBL23ValidatorBuilder.create(OrderType.class);}
/** Create a validation builder for OrderCancellation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<OrderCancellationType> orderCancellation(){return UBL23ValidatorBuilder.create(OrderCancellationType.class);}
/** Create a validation builder for OrderChange.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<OrderChangeType> orderChange(){return UBL23ValidatorBuilder.create(OrderChangeType.class);}
/** Create a validation builder for OrderResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<OrderResponseType> orderResponse(){return UBL23ValidatorBuilder.create(OrderResponseType.class);}
/** Create a validation builder for OrderResponseSimple.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<OrderResponseSimpleType> orderResponseSimple(){return UBL23ValidatorBuilder.create(OrderResponseSimpleType.class);}
/** Create a validation builder for PackingList.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<PackingListType> packingList(){return UBL23ValidatorBuilder.create(PackingListType.class);}
/** Create a validation builder for PriorInformationNotice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<PriorInformationNoticeType> priorInformationNotice(){return UBL23ValidatorBuilder.create(PriorInformationNoticeType.class);}
/** Create a validation builder for ProductActivity.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ProductActivityType> productActivity(){return UBL23ValidatorBuilder.create(ProductActivityType.class);}
/** Create a validation builder for ProofOfReexportation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ProofOfReexportationType> proofOfReexportation(){return UBL23ValidatorBuilder.create(ProofOfReexportationType.class);}
/** Create a validation builder for ProofOfReexportationReminder.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ProofOfReexportationReminderType> proofOfReexportationReminder(){return UBL23ValidatorBuilder.create(ProofOfReexportationReminderType.class);}
/** Create a validation builder for ProofOfReexportationRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ProofOfReexportationRequestType> proofOfReexportationRequest(){return UBL23ValidatorBuilder.create(ProofOfReexportationRequestType.class);}
/** Create a validation builder for QualificationApplicationRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<QualificationApplicationRequestType> qualificationApplicationRequest(){return UBL23ValidatorBuilder.create(QualificationApplicationRequestType.class);}
/** Create a validation builder for QualificationApplicationResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<QualificationApplicationResponseType> qualificationApplicationResponse(){return UBL23ValidatorBuilder.create(QualificationApplicationResponseType.class);}
/** Create a validation builder for Quotation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<QuotationType> quotation(){return UBL23ValidatorBuilder.create(QuotationType.class);}
/** Create a validation builder for ReceiptAdvice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ReceiptAdviceType> receiptAdvice(){return UBL23ValidatorBuilder.create(ReceiptAdviceType.class);}
/** Create a validation builder for Reminder.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<ReminderType> reminder(){return UBL23ValidatorBuilder.create(ReminderType.class);}
/** Create a validation builder for RemittanceAdvice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<RemittanceAdviceType> remittanceAdvice(){return UBL23ValidatorBuilder.create(RemittanceAdviceType.class);}
/** Create a validation builder for RequestForQuotation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<RequestForQuotationType> requestForQuotation(){return UBL23ValidatorBuilder.create(RequestForQuotationType.class);}
/** Create a validation builder for RetailEvent.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<RetailEventType> retailEvent(){return UBL23ValidatorBuilder.create(RetailEventType.class);}
/** Create a validation builder for SelfBilledCreditNote.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<SelfBilledCreditNoteType> selfBilledCreditNote(){return UBL23ValidatorBuilder.create(SelfBilledCreditNoteType.class);}
/** Create a validation builder for SelfBilledInvoice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<SelfBilledInvoiceType> selfBilledInvoice(){return UBL23ValidatorBuilder.create(SelfBilledInvoiceType.class);}
/** Create a validation builder for Statement.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<StatementType> statement(){return UBL23ValidatorBuilder.create(StatementType.class);}
/** Create a validation builder for StockAvailabilityReport.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<StockAvailabilityReportType> stockAvailabilityReport(){return UBL23ValidatorBuilder.create(StockAvailabilityReportType.class);}
/** Create a validation builder for Tender.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TenderType> tender(){return UBL23ValidatorBuilder.create(TenderType.class);}
/** Create a validation builder for TenderContract.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TenderContractType> tenderContract(){return UBL23ValidatorBuilder.create(TenderContractType.class);}
/** Create a validation builder for TendererQualification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TendererQualificationType> tendererQualification(){return UBL23ValidatorBuilder.create(TendererQualificationType.class);}
/** Create a validation builder for TendererQualificationResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TendererQualificationResponseType> tendererQualificationResponse(){return UBL23ValidatorBuilder.create(TendererQualificationResponseType.class);}
/** Create a validation builder for TenderReceipt.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TenderReceiptType> tenderReceipt(){return UBL23ValidatorBuilder.create(TenderReceiptType.class);}
/** Create a validation builder for TenderStatus.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TenderStatusType> tenderStatus(){return UBL23ValidatorBuilder.create(TenderStatusType.class);}
/** Create a validation builder for TenderStatusRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TenderStatusRequestType> tenderStatusRequest(){return UBL23ValidatorBuilder.create(TenderStatusRequestType.class);}
/** Create a validation builder for TenderWithdrawal.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TenderWithdrawalType> tenderWithdrawal(){return UBL23ValidatorBuilder.create(TenderWithdrawalType.class);}
/** Create a validation builder for TradeItemLocationProfile.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TradeItemLocationProfileType> tradeItemLocationProfile(){return UBL23ValidatorBuilder.create(TradeItemLocationProfileType.class);}
/** Create a validation builder for TransitCustomsDeclaration.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TransitCustomsDeclarationType> transitCustomsDeclaration(){return UBL23ValidatorBuilder.create(TransitCustomsDeclarationType.class);}
/** Create a validation builder for TransportationStatus.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TransportationStatusType> transportationStatus(){return UBL23ValidatorBuilder.create(TransportationStatusType.class);}
/** Create a validation builder for TransportationStatusRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TransportationStatusRequestType> transportationStatusRequest(){return UBL23ValidatorBuilder.create(TransportationStatusRequestType.class);}
/** Create a validation builder for TransportExecutionPlan.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TransportExecutionPlanType> transportExecutionPlan(){return UBL23ValidatorBuilder.create(TransportExecutionPlanType.class);}
/** Create a validation builder for TransportExecutionPlanRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TransportExecutionPlanRequestType> transportExecutionPlanRequest(){return UBL23ValidatorBuilder.create(TransportExecutionPlanRequestType.class);}
/** Create a validation builder for TransportProgressStatus.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TransportProgressStatusType> transportProgressStatus(){return UBL23ValidatorBuilder.create(TransportProgressStatusType.class);}
/** Create a validation builder for TransportProgressStatusRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TransportProgressStatusRequestType> transportProgressStatusRequest(){return UBL23ValidatorBuilder.create(TransportProgressStatusRequestType.class);}
/** Create a validation builder for TransportServiceDescription.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TransportServiceDescriptionType> transportServiceDescription(){return UBL23ValidatorBuilder.create(TransportServiceDescriptionType.class);}
/** Create a validation builder for TransportServiceDescriptionRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<TransportServiceDescriptionRequestType> transportServiceDescriptionRequest(){return UBL23ValidatorBuilder.create(TransportServiceDescriptionRequestType.class);}
/** Create a validation builder for UnawardedNotification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<UnawardedNotificationType> unawardedNotification(){return UBL23ValidatorBuilder.create(UnawardedNotificationType.class);}
/** Create a validation builder for UnsubscribeFromProcedureRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest(){return UBL23ValidatorBuilder.create(UnsubscribeFromProcedureRequestType.class);}
/** Create a validation builder for UnsubscribeFromProcedureResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse(){return UBL23ValidatorBuilder.create(UnsubscribeFromProcedureResponseType.class);}
/** Create a validation builder for UtilityStatement.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<UtilityStatementType> utilityStatement(){return UBL23ValidatorBuilder.create(UtilityStatementType.class);}
/** Create a validation builder for Waybill.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<WaybillType> waybill(){return UBL23ValidatorBuilder.create(WaybillType.class);}
/** Create a validation builder for WeightStatement.
@return The builder and never <code>null</code> */
@Nonnull public static UBL23ValidatorBuilder<WeightStatementType> weightStatement(){return UBL23ValidatorBuilder.create(WeightStatementType.class);}
}