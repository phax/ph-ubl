/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
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
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_22.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_22.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.awardednotification_22.AwardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.billoflading_22.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.businesscard_22.BusinessCardType;
import oasis.names.specification.ubl.schema.xsd.callfortenders_22.CallForTendersType;
import oasis.names.specification.ubl.schema.xsd.catalogue_22.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_22.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_22.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_22.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_22.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_22.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_22.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_22.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.creditnote_22.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_22.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_22.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.documentstatus_22.DocumentStatusType;
import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_22.DocumentStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_22.ExceptionCriteriaType;
import oasis.names.specification.ubl.schema.xsd.exceptionnotification_22.ExceptionNotificationType;
import oasis.names.specification.ubl.schema.xsd.forecast_22.ForecastType;
import oasis.names.specification.ubl.schema.xsd.forecastrevision_22.ForecastRevisionType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_22.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_22.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_22.FulfilmentCancellationType;
import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_22.GoodsItemItineraryType;
import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_22.GuaranteeCertificateType;
import oasis.names.specification.ubl.schema.xsd.instructionforreturns_22.InstructionForReturnsType;
import oasis.names.specification.ubl.schema.xsd.inventoryreport_22.InventoryReportType;
import oasis.names.specification.ubl.schema.xsd.invoice_22.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_22.ItemInformationRequestType;
import oasis.names.specification.ubl.schema.xsd.order_22.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_22.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_22.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_22.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_22.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_22.PackingListType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_22.PriorInformationNoticeType;
import oasis.names.specification.ubl.schema.xsd.productactivity_22.ProductActivityType;
import oasis.names.specification.ubl.schema.xsd.quotation_22.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_22.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_22.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_22.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_22.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.retailevent_22.RetailEventType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_22.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_22.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_22.StatementType;
import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_22.StockAvailabilityReportType;
import oasis.names.specification.ubl.schema.xsd.tender_22.TenderType;
import oasis.names.specification.ubl.schema.xsd.tendererqualification_22.TendererQualificationType;
import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_22.TendererQualificationResponseType;
import oasis.names.specification.ubl.schema.xsd.tenderreceipt_22.TenderReceiptType;
import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_22.TradeItemLocationProfileType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_22.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_22.TransportationStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_22.TransportExecutionPlanType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_22.TransportExecutionPlanRequestType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_22.TransportProgressStatusType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_22.TransportProgressStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescription_22.TransportServiceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_22.TransportServiceDescriptionRequestType;
import oasis.names.specification.ubl.schema.xsd.unawardednotification_22.UnawardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.utilitystatement_22.UtilityStatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_22.WaybillType;
/**
 * Write all UBL 2.1 document types.
 * 
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL22Writer
{
  @PresentForCodeCoverage
  private static final UBL22Writer s_aInstance = new UBL22Writer ();

  private UBL22Writer () {}
/** Create a writer builder for ApplicationResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ApplicationResponseType> applicationResponse(){return UBL22WriterBuilder.create(ApplicationResponseType.class);}
/** Create a writer builder for AttachedDocument.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<AttachedDocumentType> attachedDocument(){return UBL22WriterBuilder.create(AttachedDocumentType.class);}
/** Create a writer builder for AwardedNotification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<AwardedNotificationType> awardedNotification(){return UBL22WriterBuilder.create(AwardedNotificationType.class);}
/** Create a writer builder for BillOfLading.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<BillOfLadingType> billOfLading(){return UBL22WriterBuilder.create(BillOfLadingType.class);}
/** Create a writer builder for BusinessCard.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<BusinessCardType> businessCard(){return UBL22WriterBuilder.create(BusinessCardType.class);}
/** Create a writer builder for CallForTenders.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<CallForTendersType> callForTenders(){return UBL22WriterBuilder.create(CallForTendersType.class);}
/** Create a writer builder for Catalogue.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<CatalogueType> catalogue(){return UBL22WriterBuilder.create(CatalogueType.class);}
/** Create a writer builder for CatalogueDeletion.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<CatalogueDeletionType> catalogueDeletion(){return UBL22WriterBuilder.create(CatalogueDeletionType.class);}
/** Create a writer builder for CatalogueItemSpecificationUpdate.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate(){return UBL22WriterBuilder.create(CatalogueItemSpecificationUpdateType.class);}
/** Create a writer builder for CataloguePricingUpdate.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<CataloguePricingUpdateType> cataloguePricingUpdate(){return UBL22WriterBuilder.create(CataloguePricingUpdateType.class);}
/** Create a writer builder for CatalogueRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<CatalogueRequestType> catalogueRequest(){return UBL22WriterBuilder.create(CatalogueRequestType.class);}
/** Create a writer builder for CertificateOfOrigin.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<CertificateOfOriginType> certificateOfOrigin(){return UBL22WriterBuilder.create(CertificateOfOriginType.class);}
/** Create a writer builder for ContractAwardNotice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ContractAwardNoticeType> contractAwardNotice(){return UBL22WriterBuilder.create(ContractAwardNoticeType.class);}
/** Create a writer builder for ContractNotice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ContractNoticeType> contractNotice(){return UBL22WriterBuilder.create(ContractNoticeType.class);}
/** Create a writer builder for CreditNote.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<CreditNoteType> creditNote(){return UBL22WriterBuilder.create(CreditNoteType.class);}
/** Create a writer builder for DebitNote.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<DebitNoteType> debitNote(){return UBL22WriterBuilder.create(DebitNoteType.class);}
/** Create a writer builder for DespatchAdvice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<DespatchAdviceType> despatchAdvice(){return UBL22WriterBuilder.create(DespatchAdviceType.class);}
/** Create a writer builder for DocumentStatus.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<DocumentStatusType> documentStatus(){return UBL22WriterBuilder.create(DocumentStatusType.class);}
/** Create a writer builder for DocumentStatusRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<DocumentStatusRequestType> documentStatusRequest(){return UBL22WriterBuilder.create(DocumentStatusRequestType.class);}
/** Create a writer builder for ExceptionCriteria.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ExceptionCriteriaType> exceptionCriteria(){return UBL22WriterBuilder.create(ExceptionCriteriaType.class);}
/** Create a writer builder for ExceptionNotification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ExceptionNotificationType> exceptionNotification(){return UBL22WriterBuilder.create(ExceptionNotificationType.class);}
/** Create a writer builder for Forecast.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ForecastType> forecast(){return UBL22WriterBuilder.create(ForecastType.class);}
/** Create a writer builder for ForecastRevision.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ForecastRevisionType> forecastRevision(){return UBL22WriterBuilder.create(ForecastRevisionType.class);}
/** Create a writer builder for ForwardingInstructions.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ForwardingInstructionsType> forwardingInstructions(){return UBL22WriterBuilder.create(ForwardingInstructionsType.class);}
/** Create a writer builder for FreightInvoice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<FreightInvoiceType> freightInvoice(){return UBL22WriterBuilder.create(FreightInvoiceType.class);}
/** Create a writer builder for FulfilmentCancellation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<FulfilmentCancellationType> fulfilmentCancellation(){return UBL22WriterBuilder.create(FulfilmentCancellationType.class);}
/** Create a writer builder for GoodsItemItinerary.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<GoodsItemItineraryType> goodsItemItinerary(){return UBL22WriterBuilder.create(GoodsItemItineraryType.class);}
/** Create a writer builder for GuaranteeCertificate.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<GuaranteeCertificateType> guaranteeCertificate(){return UBL22WriterBuilder.create(GuaranteeCertificateType.class);}
/** Create a writer builder for InstructionForReturns.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<InstructionForReturnsType> instructionForReturns(){return UBL22WriterBuilder.create(InstructionForReturnsType.class);}
/** Create a writer builder for InventoryReport.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<InventoryReportType> inventoryReport(){return UBL22WriterBuilder.create(InventoryReportType.class);}
/** Create a writer builder for Invoice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<InvoiceType> invoice(){return UBL22WriterBuilder.create(InvoiceType.class);}
/** Create a writer builder for ItemInformationRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ItemInformationRequestType> itemInformationRequest(){return UBL22WriterBuilder.create(ItemInformationRequestType.class);}
/** Create a writer builder for Order.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<OrderType> order(){return UBL22WriterBuilder.create(OrderType.class);}
/** Create a writer builder for OrderCancellation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<OrderCancellationType> orderCancellation(){return UBL22WriterBuilder.create(OrderCancellationType.class);}
/** Create a writer builder for OrderChange.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<OrderChangeType> orderChange(){return UBL22WriterBuilder.create(OrderChangeType.class);}
/** Create a writer builder for OrderResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<OrderResponseType> orderResponse(){return UBL22WriterBuilder.create(OrderResponseType.class);}
/** Create a writer builder for OrderResponseSimple.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<OrderResponseSimpleType> orderResponseSimple(){return UBL22WriterBuilder.create(OrderResponseSimpleType.class);}
/** Create a writer builder for PackingList.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<PackingListType> packingList(){return UBL22WriterBuilder.create(PackingListType.class);}
/** Create a writer builder for PriorInformationNotice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<PriorInformationNoticeType> priorInformationNotice(){return UBL22WriterBuilder.create(PriorInformationNoticeType.class);}
/** Create a writer builder for ProductActivity.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ProductActivityType> productActivity(){return UBL22WriterBuilder.create(ProductActivityType.class);}
/** Create a writer builder for Quotation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<QuotationType> quotation(){return UBL22WriterBuilder.create(QuotationType.class);}
/** Create a writer builder for ReceiptAdvice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ReceiptAdviceType> receiptAdvice(){return UBL22WriterBuilder.create(ReceiptAdviceType.class);}
/** Create a writer builder for Reminder.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<ReminderType> reminder(){return UBL22WriterBuilder.create(ReminderType.class);}
/** Create a writer builder for RemittanceAdvice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<RemittanceAdviceType> remittanceAdvice(){return UBL22WriterBuilder.create(RemittanceAdviceType.class);}
/** Create a writer builder for RequestForQuotation.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<RequestForQuotationType> requestForQuotation(){return UBL22WriterBuilder.create(RequestForQuotationType.class);}
/** Create a writer builder for RetailEvent.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<RetailEventType> retailEvent(){return UBL22WriterBuilder.create(RetailEventType.class);}
/** Create a writer builder for SelfBilledCreditNote.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<SelfBilledCreditNoteType> selfBilledCreditNote(){return UBL22WriterBuilder.create(SelfBilledCreditNoteType.class);}
/** Create a writer builder for SelfBilledInvoice.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<SelfBilledInvoiceType> selfBilledInvoice(){return UBL22WriterBuilder.create(SelfBilledInvoiceType.class);}
/** Create a writer builder for Statement.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<StatementType> statement(){return UBL22WriterBuilder.create(StatementType.class);}
/** Create a writer builder for StockAvailabilityReport.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<StockAvailabilityReportType> stockAvailabilityReport(){return UBL22WriterBuilder.create(StockAvailabilityReportType.class);}
/** Create a writer builder for Tender.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TenderType> tender(){return UBL22WriterBuilder.create(TenderType.class);}
/** Create a writer builder for TendererQualification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TendererQualificationType> tendererQualification(){return UBL22WriterBuilder.create(TendererQualificationType.class);}
/** Create a writer builder for TendererQualificationResponse.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TendererQualificationResponseType> tendererQualificationResponse(){return UBL22WriterBuilder.create(TendererQualificationResponseType.class);}
/** Create a writer builder for TenderReceipt.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TenderReceiptType> tenderReceipt(){return UBL22WriterBuilder.create(TenderReceiptType.class);}
/** Create a writer builder for TradeItemLocationProfile.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TradeItemLocationProfileType> tradeItemLocationProfile(){return UBL22WriterBuilder.create(TradeItemLocationProfileType.class);}
/** Create a writer builder for TransportationStatus.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TransportationStatusType> transportationStatus(){return UBL22WriterBuilder.create(TransportationStatusType.class);}
/** Create a writer builder for TransportationStatusRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TransportationStatusRequestType> transportationStatusRequest(){return UBL22WriterBuilder.create(TransportationStatusRequestType.class);}
/** Create a writer builder for TransportExecutionPlan.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TransportExecutionPlanType> transportExecutionPlan(){return UBL22WriterBuilder.create(TransportExecutionPlanType.class);}
/** Create a writer builder for TransportExecutionPlanRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TransportExecutionPlanRequestType> transportExecutionPlanRequest(){return UBL22WriterBuilder.create(TransportExecutionPlanRequestType.class);}
/** Create a writer builder for TransportProgressStatus.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TransportProgressStatusType> transportProgressStatus(){return UBL22WriterBuilder.create(TransportProgressStatusType.class);}
/** Create a writer builder for TransportProgressStatusRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TransportProgressStatusRequestType> transportProgressStatusRequest(){return UBL22WriterBuilder.create(TransportProgressStatusRequestType.class);}
/** Create a writer builder for TransportServiceDescription.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TransportServiceDescriptionType> transportServiceDescription(){return UBL22WriterBuilder.create(TransportServiceDescriptionType.class);}
/** Create a writer builder for TransportServiceDescriptionRequest.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<TransportServiceDescriptionRequestType> transportServiceDescriptionRequest(){return UBL22WriterBuilder.create(TransportServiceDescriptionRequestType.class);}
/** Create a writer builder for UnawardedNotification.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<UnawardedNotificationType> unawardedNotification(){return UBL22WriterBuilder.create(UnawardedNotificationType.class);}
/** Create a writer builder for UtilityStatement.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<UtilityStatementType> utilityStatement(){return UBL22WriterBuilder.create(UtilityStatementType.class);}
/** Create a writer builder for Waybill.
@return The builder and never <code>null</code> */
@Nonnull public static UBL22WriterBuilder<WaybillType> waybill(){return UBL22WriterBuilder.create(WaybillType.class);}
}