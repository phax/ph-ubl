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
 * Validate all UBL 2.1 document types.
 *
 * @author Philip Helger
 * @deprecated Use {@link UBL21Marshaller} instead
 */
@NotThreadSafe
@Deprecated (forRemoval = true, since = "8.0.0")
public final class UBL21Validator
{
  @PresentForCodeCoverage
  private static final UBL21Validator INSTANCE = new UBL21Validator ();

  private UBL21Validator ()
  {}

  /**
   * Create a validation builder for ApplicationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL21ValidatorBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a validation builder for AttachedDocument.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL21ValidatorBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Create a validation builder for AwardedNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <AwardedNotificationType> awardedNotification ()
  {
    return UBL21ValidatorBuilder.create (AwardedNotificationType.class);
  }

  /**
   * Create a validation builder for BillOfLading.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL21ValidatorBuilder.create (BillOfLadingType.class);
  }

  /**
   * Create a validation builder for CallForTenders.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CallForTendersType> callForTenders ()
  {
    return UBL21ValidatorBuilder.create (CallForTendersType.class);
  }

  /**
   * Create a validation builder for Catalogue.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CatalogueType> catalogue ()
  {
    return UBL21ValidatorBuilder.create (CatalogueType.class);
  }

  /**
   * Create a validation builder for CatalogueDeletion.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL21ValidatorBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Create a validation builder for CatalogueItemSpecificationUpdate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL21ValidatorBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Create a validation builder for CataloguePricingUpdate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL21ValidatorBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Create a validation builder for CatalogueRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL21ValidatorBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Create a validation builder for CertificateOfOrigin.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL21ValidatorBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Create a validation builder for ContractAwardNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ContractAwardNoticeType> contractAwardNotice ()
  {
    return UBL21ValidatorBuilder.create (ContractAwardNoticeType.class);
  }

  /**
   * Create a validation builder for ContractNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ContractNoticeType> contractNotice ()
  {
    return UBL21ValidatorBuilder.create (ContractNoticeType.class);
  }

  /**
   * Create a validation builder for CreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CreditNoteType> creditNote ()
  {
    return UBL21ValidatorBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a validation builder for DebitNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <DebitNoteType> debitNote ()
  {
    return UBL21ValidatorBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a validation builder for DespatchAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL21ValidatorBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Create a validation builder for DocumentStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <DocumentStatusType> documentStatus ()
  {
    return UBL21ValidatorBuilder.create (DocumentStatusType.class);
  }

  /**
   * Create a validation builder for DocumentStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <DocumentStatusRequestType> documentStatusRequest ()
  {
    return UBL21ValidatorBuilder.create (DocumentStatusRequestType.class);
  }

  /**
   * Create a validation builder for ExceptionCriteria.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ExceptionCriteriaType> exceptionCriteria ()
  {
    return UBL21ValidatorBuilder.create (ExceptionCriteriaType.class);
  }

  /**
   * Create a validation builder for ExceptionNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ExceptionNotificationType> exceptionNotification ()
  {
    return UBL21ValidatorBuilder.create (ExceptionNotificationType.class);
  }

  /**
   * Create a validation builder for Forecast.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ForecastType> forecast ()
  {
    return UBL21ValidatorBuilder.create (ForecastType.class);
  }

  /**
   * Create a validation builder for ForecastRevision.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ForecastRevisionType> forecastRevision ()
  {
    return UBL21ValidatorBuilder.create (ForecastRevisionType.class);
  }

  /**
   * Create a validation builder for ForwardingInstructions.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL21ValidatorBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Create a validation builder for FreightInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL21ValidatorBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Create a validation builder for FulfilmentCancellation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return UBL21ValidatorBuilder.create (FulfilmentCancellationType.class);
  }

  /**
   * Create a validation builder for GoodsItemItinerary.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return UBL21ValidatorBuilder.create (GoodsItemItineraryType.class);
  }

  /**
   * Create a validation builder for GuaranteeCertificate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return UBL21ValidatorBuilder.create (GuaranteeCertificateType.class);
  }

  /**
   * Create a validation builder for InstructionForReturns.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <InstructionForReturnsType> instructionForReturns ()
  {
    return UBL21ValidatorBuilder.create (InstructionForReturnsType.class);
  }

  /**
   * Create a validation builder for InventoryReport.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <InventoryReportType> inventoryReport ()
  {
    return UBL21ValidatorBuilder.create (InventoryReportType.class);
  }

  /**
   * Create a validation builder for Invoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <InvoiceType> invoice ()
  {
    return UBL21ValidatorBuilder.create (InvoiceType.class);
  }

  /**
   * Create a validation builder for ItemInformationRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ItemInformationRequestType> itemInformationRequest ()
  {
    return UBL21ValidatorBuilder.create (ItemInformationRequestType.class);
  }

  /**
   * Create a validation builder for Order.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <OrderType> order ()
  {
    return UBL21ValidatorBuilder.create (OrderType.class);
  }

  /**
   * Create a validation builder for OrderCancellation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL21ValidatorBuilder.create (OrderCancellationType.class);
  }

  /**
   * Create a validation builder for OrderChange.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <OrderChangeType> orderChange ()
  {
    return UBL21ValidatorBuilder.create (OrderChangeType.class);
  }

  /**
   * Create a validation builder for OrderResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <OrderResponseType> orderResponse ()
  {
    return UBL21ValidatorBuilder.create (OrderResponseType.class);
  }

  /**
   * Create a validation builder for OrderResponseSimple.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL21ValidatorBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Create a validation builder for PackingList.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <PackingListType> packingList ()
  {
    return UBL21ValidatorBuilder.create (PackingListType.class);
  }

  /**
   * Create a validation builder for PriorInformationNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <PriorInformationNoticeType> priorInformationNotice ()
  {
    return UBL21ValidatorBuilder.create (PriorInformationNoticeType.class);
  }

  /**
   * Create a validation builder for ProductActivity.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ProductActivityType> productActivity ()
  {
    return UBL21ValidatorBuilder.create (ProductActivityType.class);
  }

  /**
   * Create a validation builder for Quotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <QuotationType> quotation ()
  {
    return UBL21ValidatorBuilder.create (QuotationType.class);
  }

  /**
   * Create a validation builder for ReceiptAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL21ValidatorBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Create a validation builder for Reminder.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ReminderType> reminder ()
  {
    return UBL21ValidatorBuilder.create (ReminderType.class);
  }

  /**
   * Create a validation builder for RemittanceAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL21ValidatorBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Create a validation builder for RequestForQuotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL21ValidatorBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Create a validation builder for RetailEvent.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <RetailEventType> retailEvent ()
  {
    return UBL21ValidatorBuilder.create (RetailEventType.class);
  }

  /**
   * Create a validation builder for SelfBilledCreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL21ValidatorBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Create a validation builder for SelfBilledInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL21ValidatorBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Create a validation builder for Statement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <StatementType> statement ()
  {
    return UBL21ValidatorBuilder.create (StatementType.class);
  }

  /**
   * Create a validation builder for StockAvailabilityReport.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return UBL21ValidatorBuilder.create (StockAvailabilityReportType.class);
  }

  /**
   * Create a validation builder for Tender.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TenderType> tender ()
  {
    return UBL21ValidatorBuilder.create (TenderType.class);
  }

  /**
   * Create a validation builder for TendererQualification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TendererQualificationType> tendererQualification ()
  {
    return UBL21ValidatorBuilder.create (TendererQualificationType.class);
  }

  /**
   * Create a validation builder for TendererQualificationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return UBL21ValidatorBuilder.create (TendererQualificationResponseType.class);
  }

  /**
   * Create a validation builder for TenderReceipt.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TenderReceiptType> tenderReceipt ()
  {
    return UBL21ValidatorBuilder.create (TenderReceiptType.class);
  }

  /**
   * Create a validation builder for TradeItemLocationProfile.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return UBL21ValidatorBuilder.create (TradeItemLocationProfileType.class);
  }

  /**
   * Create a validation builder for TransportationStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL21ValidatorBuilder.create (TransportationStatusType.class);
  }

  /**
   * Create a validation builder for TransportationStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return UBL21ValidatorBuilder.create (TransportationStatusRequestType.class);
  }

  /**
   * Create a validation builder for TransportExecutionPlan.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return UBL21ValidatorBuilder.create (TransportExecutionPlanType.class);
  }

  /**
   * Create a validation builder for TransportExecutionPlanRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return UBL21ValidatorBuilder.create (TransportExecutionPlanRequestType.class);
  }

  /**
   * Create a validation builder for TransportProgressStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportProgressStatusType> transportProgressStatus ()
  {
    return UBL21ValidatorBuilder.create (TransportProgressStatusType.class);
  }

  /**
   * Create a validation builder for TransportProgressStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return UBL21ValidatorBuilder.create (TransportProgressStatusRequestType.class);
  }

  /**
   * Create a validation builder for TransportServiceDescription.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return UBL21ValidatorBuilder.create (TransportServiceDescriptionType.class);
  }

  /**
   * Create a validation builder for TransportServiceDescriptionRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return UBL21ValidatorBuilder.create (TransportServiceDescriptionRequestType.class);
  }

  /**
   * Create a validation builder for UnawardedNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <UnawardedNotificationType> unawardedNotification ()
  {
    return UBL21ValidatorBuilder.create (UnawardedNotificationType.class);
  }

  /**
   * Create a validation builder for UtilityStatement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <UtilityStatementType> utilityStatement ()
  {
    return UBL21ValidatorBuilder.create (UtilityStatementType.class);
  }

  /**
   * Create a validation builder for Waybill.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <WaybillType> waybill ()
  {
    return UBL21ValidatorBuilder.create (WaybillType.class);
  }
}
