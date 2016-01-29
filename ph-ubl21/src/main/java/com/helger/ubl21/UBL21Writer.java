/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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
package com.helger.ubl21;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_21.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.awardednotification_21.AwardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.billoflading_21.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.callfortenders_21.CallForTendersType;
import oasis.names.specification.ubl.schema.xsd.catalogue_21.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_21.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_21.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_21.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_21.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_21.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_21.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_21.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_21.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.documentstatus_21.DocumentStatusType;
import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_21.DocumentStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_21.ExceptionCriteriaType;
import oasis.names.specification.ubl.schema.xsd.exceptionnotification_21.ExceptionNotificationType;
import oasis.names.specification.ubl.schema.xsd.forecast_21.ForecastType;
import oasis.names.specification.ubl.schema.xsd.forecastrevision_21.ForecastRevisionType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_21.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_21.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_21.FulfilmentCancellationType;
import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_21.GoodsItemItineraryType;
import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_21.GuaranteeCertificateType;
import oasis.names.specification.ubl.schema.xsd.instructionforreturns_21.InstructionForReturnsType;
import oasis.names.specification.ubl.schema.xsd.inventoryreport_21.InventoryReportType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_21.ItemInformationRequestType;
import oasis.names.specification.ubl.schema.xsd.order_21.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_21.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_21.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_21.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_21.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_21.PackingListType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_21.PriorInformationNoticeType;
import oasis.names.specification.ubl.schema.xsd.productactivity_21.ProductActivityType;
import oasis.names.specification.ubl.schema.xsd.quotation_21.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_21.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_21.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_21.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_21.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.retailevent_21.RetailEventType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_21.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_21.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_21.StatementType;
import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_21.StockAvailabilityReportType;
import oasis.names.specification.ubl.schema.xsd.tender_21.TenderType;
import oasis.names.specification.ubl.schema.xsd.tendererqualification_21.TendererQualificationType;
import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_21.TendererQualificationResponseType;
import oasis.names.specification.ubl.schema.xsd.tenderreceipt_21.TenderReceiptType;
import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_21.TradeItemLocationProfileType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_21.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_21.TransportationStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_21.TransportExecutionPlanType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_21.TransportExecutionPlanRequestType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_21.TransportProgressStatusType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_21.TransportProgressStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescription_21.TransportServiceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_21.TransportServiceDescriptionRequestType;
import oasis.names.specification.ubl.schema.xsd.unawardednotification_21.UnawardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.utilitystatement_21.UtilityStatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_21.WaybillType;

/**
 * Write all UBL 2.1 document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL21Writer
{
  @PresentForCodeCoverage
  private static final UBL21Writer s_aInstance = new UBL21Writer ();

  private UBL21Writer ()
  {}

  /**
   * Create a writer builder for ApplicationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL21WriterBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a writer builder for AttachedDocument.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL21WriterBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Create a writer builder for AwardedNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <AwardedNotificationType> awardedNotification ()
  {
    return UBL21WriterBuilder.create (AwardedNotificationType.class);
  }

  /**
   * Create a writer builder for BillOfLading.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL21WriterBuilder.create (BillOfLadingType.class);
  }

  /**
   * Create a writer builder for CallForTenders.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CallForTendersType> callForTenders ()
  {
    return UBL21WriterBuilder.create (CallForTendersType.class);
  }

  /**
   * Create a writer builder for Catalogue.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CatalogueType> catalogue ()
  {
    return UBL21WriterBuilder.create (CatalogueType.class);
  }

  /**
   * Create a writer builder for CatalogueDeletion.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL21WriterBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Create a writer builder for CatalogueItemSpecificationUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL21WriterBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Create a writer builder for CataloguePricingUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL21WriterBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Create a writer builder for CatalogueRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL21WriterBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Create a writer builder for CertificateOfOrigin.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL21WriterBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Create a writer builder for ContractAwardNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ContractAwardNoticeType> contractAwardNotice ()
  {
    return UBL21WriterBuilder.create (ContractAwardNoticeType.class);
  }

  /**
   * Create a writer builder for ContractNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ContractNoticeType> contractNotice ()
  {
    return UBL21WriterBuilder.create (ContractNoticeType.class);
  }

  /**
   * Create a writer builder for CreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CreditNoteType> creditNote ()
  {
    return UBL21WriterBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a writer builder for DebitNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <DebitNoteType> debitNote ()
  {
    return UBL21WriterBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a writer builder for DespatchAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL21WriterBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Create a writer builder for DocumentStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <DocumentStatusType> documentStatus ()
  {
    return UBL21WriterBuilder.create (DocumentStatusType.class);
  }

  /**
   * Create a writer builder for DocumentStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <DocumentStatusRequestType> documentStatusRequest ()
  {
    return UBL21WriterBuilder.create (DocumentStatusRequestType.class);
  }

  /**
   * Create a writer builder for ExceptionCriteria.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ExceptionCriteriaType> exceptionCriteria ()
  {
    return UBL21WriterBuilder.create (ExceptionCriteriaType.class);
  }

  /**
   * Create a writer builder for ExceptionNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ExceptionNotificationType> exceptionNotification ()
  {
    return UBL21WriterBuilder.create (ExceptionNotificationType.class);
  }

  /**
   * Create a writer builder for Forecast.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ForecastType> forecast ()
  {
    return UBL21WriterBuilder.create (ForecastType.class);
  }

  /**
   * Create a writer builder for ForecastRevision.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ForecastRevisionType> forecastRevision ()
  {
    return UBL21WriterBuilder.create (ForecastRevisionType.class);
  }

  /**
   * Create a writer builder for ForwardingInstructions.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL21WriterBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Create a writer builder for FreightInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL21WriterBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Create a writer builder for FulfilmentCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return UBL21WriterBuilder.create (FulfilmentCancellationType.class);
  }

  /**
   * Create a writer builder for GoodsItemItinerary.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return UBL21WriterBuilder.create (GoodsItemItineraryType.class);
  }

  /**
   * Create a writer builder for GuaranteeCertificate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return UBL21WriterBuilder.create (GuaranteeCertificateType.class);
  }

  /**
   * Create a writer builder for InstructionForReturns.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <InstructionForReturnsType> instructionForReturns ()
  {
    return UBL21WriterBuilder.create (InstructionForReturnsType.class);
  }

  /**
   * Create a writer builder for InventoryReport.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <InventoryReportType> inventoryReport ()
  {
    return UBL21WriterBuilder.create (InventoryReportType.class);
  }

  /**
   * Create a writer builder for Invoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <InvoiceType> invoice ()
  {
    return UBL21WriterBuilder.create (InvoiceType.class);
  }

  /**
   * Create a writer builder for ItemInformationRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ItemInformationRequestType> itemInformationRequest ()
  {
    return UBL21WriterBuilder.create (ItemInformationRequestType.class);
  }

  /**
   * Create a writer builder for Order.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <OrderType> order ()
  {
    return UBL21WriterBuilder.create (OrderType.class);
  }

  /**
   * Create a writer builder for OrderCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL21WriterBuilder.create (OrderCancellationType.class);
  }

  /**
   * Create a writer builder for OrderChange.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <OrderChangeType> orderChange ()
  {
    return UBL21WriterBuilder.create (OrderChangeType.class);
  }

  /**
   * Create a writer builder for OrderResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <OrderResponseType> orderResponse ()
  {
    return UBL21WriterBuilder.create (OrderResponseType.class);
  }

  /**
   * Create a writer builder for OrderResponseSimple.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL21WriterBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Create a writer builder for PackingList.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <PackingListType> packingList ()
  {
    return UBL21WriterBuilder.create (PackingListType.class);
  }

  /**
   * Create a writer builder for PriorInformationNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <PriorInformationNoticeType> priorInformationNotice ()
  {
    return UBL21WriterBuilder.create (PriorInformationNoticeType.class);
  }

  /**
   * Create a writer builder for ProductActivity.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ProductActivityType> productActivity ()
  {
    return UBL21WriterBuilder.create (ProductActivityType.class);
  }

  /**
   * Create a writer builder for Quotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <QuotationType> quotation ()
  {
    return UBL21WriterBuilder.create (QuotationType.class);
  }

  /**
   * Create a writer builder for ReceiptAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL21WriterBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Create a writer builder for Reminder.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ReminderType> reminder ()
  {
    return UBL21WriterBuilder.create (ReminderType.class);
  }

  /**
   * Create a writer builder for RemittanceAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL21WriterBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Create a writer builder for RequestForQuotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL21WriterBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Create a writer builder for RetailEvent.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <RetailEventType> retailEvent ()
  {
    return UBL21WriterBuilder.create (RetailEventType.class);
  }

  /**
   * Create a writer builder for SelfBilledCreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL21WriterBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Create a writer builder for SelfBilledInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL21WriterBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Create a writer builder for Statement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <StatementType> statement ()
  {
    return UBL21WriterBuilder.create (StatementType.class);
  }

  /**
   * Create a writer builder for StockAvailabilityReport.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return UBL21WriterBuilder.create (StockAvailabilityReportType.class);
  }

  /**
   * Create a writer builder for Tender.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TenderType> tender ()
  {
    return UBL21WriterBuilder.create (TenderType.class);
  }

  /**
   * Create a writer builder for TendererQualification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TendererQualificationType> tendererQualification ()
  {
    return UBL21WriterBuilder.create (TendererQualificationType.class);
  }

  /**
   * Create a writer builder for TendererQualificationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return UBL21WriterBuilder.create (TendererQualificationResponseType.class);
  }

  /**
   * Create a writer builder for TenderReceipt.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TenderReceiptType> tenderReceipt ()
  {
    return UBL21WriterBuilder.create (TenderReceiptType.class);
  }

  /**
   * Create a writer builder for TradeItemLocationProfile.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return UBL21WriterBuilder.create (TradeItemLocationProfileType.class);
  }

  /**
   * Create a writer builder for TransportationStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL21WriterBuilder.create (TransportationStatusType.class);
  }

  /**
   * Create a writer builder for TransportationStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return UBL21WriterBuilder.create (TransportationStatusRequestType.class);
  }

  /**
   * Create a writer builder for TransportExecutionPlan.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return UBL21WriterBuilder.create (TransportExecutionPlanType.class);
  }

  /**
   * Create a writer builder for TransportExecutionPlanRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return UBL21WriterBuilder.create (TransportExecutionPlanRequestType.class);
  }

  /**
   * Create a writer builder for TransportProgressStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportProgressStatusType> transportProgressStatus ()
  {
    return UBL21WriterBuilder.create (TransportProgressStatusType.class);
  }

  /**
   * Create a writer builder for TransportProgressStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return UBL21WriterBuilder.create (TransportProgressStatusRequestType.class);
  }

  /**
   * Create a writer builder for TransportServiceDescription.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return UBL21WriterBuilder.create (TransportServiceDescriptionType.class);
  }

  /**
   * Create a writer builder for TransportServiceDescriptionRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return UBL21WriterBuilder.create (TransportServiceDescriptionRequestType.class);
  }

  /**
   * Create a writer builder for UnawardedNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <UnawardedNotificationType> unawardedNotification ()
  {
    return UBL21WriterBuilder.create (UnawardedNotificationType.class);
  }

  /**
   * Create a writer builder for UtilityStatement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <UtilityStatementType> utilityStatement ()
  {
    return UBL21WriterBuilder.create (UtilityStatementType.class);
  }

  /**
   * Create a writer builder for Waybill.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <WaybillType> waybill ()
  {
    return UBL21WriterBuilder.create (WaybillType.class);
  }
}
