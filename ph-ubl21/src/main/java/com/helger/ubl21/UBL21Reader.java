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
 * Read all UBL 2.1 document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL21Reader
{
  @PresentForCodeCoverage
  private static final UBL21Reader s_aInstance = new UBL21Reader ();

  private UBL21Reader ()
  {}

  /**
   * Create a reader builder for ApplicationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL21ReaderBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a reader builder for AttachedDocument.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL21ReaderBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Create a reader builder for AwardedNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <AwardedNotificationType> awardedNotification ()
  {
    return UBL21ReaderBuilder.create (AwardedNotificationType.class);
  }

  /**
   * Create a reader builder for BillOfLading.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL21ReaderBuilder.create (BillOfLadingType.class);
  }

  /**
   * Create a reader builder for CallForTenders.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <CallForTendersType> callForTenders ()
  {
    return UBL21ReaderBuilder.create (CallForTendersType.class);
  }

  /**
   * Create a reader builder for Catalogue.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <CatalogueType> catalogue ()
  {
    return UBL21ReaderBuilder.create (CatalogueType.class);
  }

  /**
   * Create a reader builder for CatalogueDeletion.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL21ReaderBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Create a reader builder for CatalogueItemSpecificationUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL21ReaderBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Create a reader builder for CataloguePricingUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL21ReaderBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Create a reader builder for CatalogueRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL21ReaderBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Create a reader builder for CertificateOfOrigin.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL21ReaderBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Create a reader builder for ContractAwardNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ContractAwardNoticeType> contractAwardNotice ()
  {
    return UBL21ReaderBuilder.create (ContractAwardNoticeType.class);
  }

  /**
   * Create a reader builder for ContractNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ContractNoticeType> contractNotice ()
  {
    return UBL21ReaderBuilder.create (ContractNoticeType.class);
  }

  /**
   * Create a reader builder for CreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <CreditNoteType> creditNote ()
  {
    return UBL21ReaderBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a reader builder for DebitNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <DebitNoteType> debitNote ()
  {
    return UBL21ReaderBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a reader builder for DespatchAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL21ReaderBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Create a reader builder for DocumentStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <DocumentStatusType> documentStatus ()
  {
    return UBL21ReaderBuilder.create (DocumentStatusType.class);
  }

  /**
   * Create a reader builder for DocumentStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <DocumentStatusRequestType> documentStatusRequest ()
  {
    return UBL21ReaderBuilder.create (DocumentStatusRequestType.class);
  }

  /**
   * Create a reader builder for ExceptionCriteria.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ExceptionCriteriaType> exceptionCriteria ()
  {
    return UBL21ReaderBuilder.create (ExceptionCriteriaType.class);
  }

  /**
   * Create a reader builder for ExceptionNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ExceptionNotificationType> exceptionNotification ()
  {
    return UBL21ReaderBuilder.create (ExceptionNotificationType.class);
  }

  /**
   * Create a reader builder for Forecast.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ForecastType> forecast ()
  {
    return UBL21ReaderBuilder.create (ForecastType.class);
  }

  /**
   * Create a reader builder for ForecastRevision.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ForecastRevisionType> forecastRevision ()
  {
    return UBL21ReaderBuilder.create (ForecastRevisionType.class);
  }

  /**
   * Create a reader builder for ForwardingInstructions.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL21ReaderBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Create a reader builder for FreightInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL21ReaderBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Create a reader builder for FulfilmentCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return UBL21ReaderBuilder.create (FulfilmentCancellationType.class);
  }

  /**
   * Create a reader builder for GoodsItemItinerary.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return UBL21ReaderBuilder.create (GoodsItemItineraryType.class);
  }

  /**
   * Create a reader builder for GuaranteeCertificate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return UBL21ReaderBuilder.create (GuaranteeCertificateType.class);
  }

  /**
   * Create a reader builder for InstructionForReturns.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <InstructionForReturnsType> instructionForReturns ()
  {
    return UBL21ReaderBuilder.create (InstructionForReturnsType.class);
  }

  /**
   * Create a reader builder for InventoryReport.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <InventoryReportType> inventoryReport ()
  {
    return UBL21ReaderBuilder.create (InventoryReportType.class);
  }

  /**
   * Create a reader builder for Invoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <InvoiceType> invoice ()
  {
    return UBL21ReaderBuilder.create (InvoiceType.class);
  }

  /**
   * Create a reader builder for ItemInformationRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ItemInformationRequestType> itemInformationRequest ()
  {
    return UBL21ReaderBuilder.create (ItemInformationRequestType.class);
  }

  /**
   * Create a reader builder for Order.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <OrderType> order ()
  {
    return UBL21ReaderBuilder.create (OrderType.class);
  }

  /**
   * Create a reader builder for OrderCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL21ReaderBuilder.create (OrderCancellationType.class);
  }

  /**
   * Create a reader builder for OrderChange.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <OrderChangeType> orderChange ()
  {
    return UBL21ReaderBuilder.create (OrderChangeType.class);
  }

  /**
   * Create a reader builder for OrderResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <OrderResponseType> orderResponse ()
  {
    return UBL21ReaderBuilder.create (OrderResponseType.class);
  }

  /**
   * Create a reader builder for OrderResponseSimple.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL21ReaderBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Create a reader builder for PackingList.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <PackingListType> packingList ()
  {
    return UBL21ReaderBuilder.create (PackingListType.class);
  }

  /**
   * Create a reader builder for PriorInformationNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <PriorInformationNoticeType> priorInformationNotice ()
  {
    return UBL21ReaderBuilder.create (PriorInformationNoticeType.class);
  }

  /**
   * Create a reader builder for ProductActivity.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ProductActivityType> productActivity ()
  {
    return UBL21ReaderBuilder.create (ProductActivityType.class);
  }

  /**
   * Create a reader builder for Quotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <QuotationType> quotation ()
  {
    return UBL21ReaderBuilder.create (QuotationType.class);
  }

  /**
   * Create a reader builder for ReceiptAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL21ReaderBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Create a reader builder for Reminder.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <ReminderType> reminder ()
  {
    return UBL21ReaderBuilder.create (ReminderType.class);
  }

  /**
   * Create a reader builder for RemittanceAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL21ReaderBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Create a reader builder for RequestForQuotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL21ReaderBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Create a reader builder for RetailEvent.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <RetailEventType> retailEvent ()
  {
    return UBL21ReaderBuilder.create (RetailEventType.class);
  }

  /**
   * Create a reader builder for SelfBilledCreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL21ReaderBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Create a reader builder for SelfBilledInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL21ReaderBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Create a reader builder for Statement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <StatementType> statement ()
  {
    return UBL21ReaderBuilder.create (StatementType.class);
  }

  /**
   * Create a reader builder for StockAvailabilityReport.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return UBL21ReaderBuilder.create (StockAvailabilityReportType.class);
  }

  /**
   * Create a reader builder for Tender.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TenderType> tender ()
  {
    return UBL21ReaderBuilder.create (TenderType.class);
  }

  /**
   * Create a reader builder for TendererQualification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TendererQualificationType> tendererQualification ()
  {
    return UBL21ReaderBuilder.create (TendererQualificationType.class);
  }

  /**
   * Create a reader builder for TendererQualificationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return UBL21ReaderBuilder.create (TendererQualificationResponseType.class);
  }

  /**
   * Create a reader builder for TenderReceipt.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TenderReceiptType> tenderReceipt ()
  {
    return UBL21ReaderBuilder.create (TenderReceiptType.class);
  }

  /**
   * Create a reader builder for TradeItemLocationProfile.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return UBL21ReaderBuilder.create (TradeItemLocationProfileType.class);
  }

  /**
   * Create a reader builder for TransportationStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL21ReaderBuilder.create (TransportationStatusType.class);
  }

  /**
   * Create a reader builder for TransportationStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return UBL21ReaderBuilder.create (TransportationStatusRequestType.class);
  }

  /**
   * Create a reader builder for TransportExecutionPlan.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return UBL21ReaderBuilder.create (TransportExecutionPlanType.class);
  }

  /**
   * Create a reader builder for TransportExecutionPlanRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return UBL21ReaderBuilder.create (TransportExecutionPlanRequestType.class);
  }

  /**
   * Create a reader builder for TransportProgressStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TransportProgressStatusType> transportProgressStatus ()
  {
    return UBL21ReaderBuilder.create (TransportProgressStatusType.class);
  }

  /**
   * Create a reader builder for TransportProgressStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return UBL21ReaderBuilder.create (TransportProgressStatusRequestType.class);
  }

  /**
   * Create a reader builder for TransportServiceDescription.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return UBL21ReaderBuilder.create (TransportServiceDescriptionType.class);
  }

  /**
   * Create a reader builder for TransportServiceDescriptionRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return UBL21ReaderBuilder.create (TransportServiceDescriptionRequestType.class);
  }

  /**
   * Create a reader builder for UnawardedNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <UnawardedNotificationType> unawardedNotification ()
  {
    return UBL21ReaderBuilder.create (UnawardedNotificationType.class);
  }

  /**
   * Create a reader builder for UtilityStatement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <UtilityStatementType> utilityStatement ()
  {
    return UBL21ReaderBuilder.create (UtilityStatementType.class);
  }

  /**
   * Create a reader builder for Waybill.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ReaderBuilder <WaybillType> waybill ()
  {
    return UBL21ReaderBuilder.create (WaybillType.class);
  }
}
