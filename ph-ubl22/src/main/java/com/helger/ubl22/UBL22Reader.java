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
import oasis.names.specification.ubl.schema.xsd.digitalagreement_22.DigitalAgreementType;
import oasis.names.specification.ubl.schema.xsd.digitalcapability_22.DigitalCapabilityType;
import oasis.names.specification.ubl.schema.xsd.documentstatus_22.DocumentStatusType;
import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_22.DocumentStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.enquiry_22.EnquiryType;
import oasis.names.specification.ubl.schema.xsd.enquiryresponse_22.EnquiryResponseType;
import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_22.ExceptionCriteriaType;
import oasis.names.specification.ubl.schema.xsd.exceptionnotification_22.ExceptionNotificationType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_22.ExpressionOfInterestRequestType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_22.ExpressionOfInterestResponseType;
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
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_22.QualificationApplicationRequestType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_22.QualificationApplicationResponseType;
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
import oasis.names.specification.ubl.schema.xsd.tendercontract_22.TenderContractType;
import oasis.names.specification.ubl.schema.xsd.tendererqualification_22.TendererQualificationType;
import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_22.TendererQualificationResponseType;
import oasis.names.specification.ubl.schema.xsd.tenderreceipt_22.TenderReceiptType;
import oasis.names.specification.ubl.schema.xsd.tenderstatus_22.TenderStatusType;
import oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_22.TenderStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_22.TenderWithdrawalType;
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
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_22.UnsubscribeFromProcedureRequestType;
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_22.UnsubscribeFromProcedureResponseType;
import oasis.names.specification.ubl.schema.xsd.utilitystatement_22.UtilityStatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_22.WaybillType;
import oasis.names.specification.ubl.schema.xsd.weightstatement_22.WeightStatementType;

/**
 * Read all UBL 2.2 document types.
 *
 * @author Philip Helger
 * @deprecated Use {@link UBL22Marshaller} instead
 */
@NotThreadSafe
@Deprecated (forRemoval = true, since = "8.0.0")
public final class UBL22Reader
{
  @PresentForCodeCoverage
  private static final UBL22Reader INSTANCE = new UBL22Reader ();

  private UBL22Reader ()
  {}

  /**
   * Create a reader builder for ApplicationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL22ReaderBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a reader builder for AttachedDocument.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL22ReaderBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Create a reader builder for AwardedNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <AwardedNotificationType> awardedNotification ()
  {
    return UBL22ReaderBuilder.create (AwardedNotificationType.class);
  }

  /**
   * Create a reader builder for BillOfLading.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL22ReaderBuilder.create (BillOfLadingType.class);
  }

  /**
   * Create a reader builder for BusinessCard.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <BusinessCardType> businessCard ()
  {
    return UBL22ReaderBuilder.create (BusinessCardType.class);
  }

  /**
   * Create a reader builder for CallForTenders.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <CallForTendersType> callForTenders ()
  {
    return UBL22ReaderBuilder.create (CallForTendersType.class);
  }

  /**
   * Create a reader builder for Catalogue.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <CatalogueType> catalogue ()
  {
    return UBL22ReaderBuilder.create (CatalogueType.class);
  }

  /**
   * Create a reader builder for CatalogueDeletion.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL22ReaderBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Create a reader builder for CatalogueItemSpecificationUpdate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL22ReaderBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Create a reader builder for CataloguePricingUpdate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL22ReaderBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Create a reader builder for CatalogueRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL22ReaderBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Create a reader builder for CertificateOfOrigin.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL22ReaderBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Create a reader builder for ContractAwardNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ContractAwardNoticeType> contractAwardNotice ()
  {
    return UBL22ReaderBuilder.create (ContractAwardNoticeType.class);
  }

  /**
   * Create a reader builder for ContractNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ContractNoticeType> contractNotice ()
  {
    return UBL22ReaderBuilder.create (ContractNoticeType.class);
  }

  /**
   * Create a reader builder for CreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <CreditNoteType> creditNote ()
  {
    return UBL22ReaderBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a reader builder for DebitNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <DebitNoteType> debitNote ()
  {
    return UBL22ReaderBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a reader builder for DespatchAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL22ReaderBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Create a reader builder for DigitalAgreement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <DigitalAgreementType> digitalAgreement ()
  {
    return UBL22ReaderBuilder.create (DigitalAgreementType.class);
  }

  /**
   * Create a reader builder for DigitalCapability.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <DigitalCapabilityType> digitalCapability ()
  {
    return UBL22ReaderBuilder.create (DigitalCapabilityType.class);
  }

  /**
   * Create a reader builder for DocumentStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <DocumentStatusType> documentStatus ()
  {
    return UBL22ReaderBuilder.create (DocumentStatusType.class);
  }

  /**
   * Create a reader builder for DocumentStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <DocumentStatusRequestType> documentStatusRequest ()
  {
    return UBL22ReaderBuilder.create (DocumentStatusRequestType.class);
  }

  /**
   * Create a reader builder for Enquiry.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <EnquiryType> enquiry ()
  {
    return UBL22ReaderBuilder.create (EnquiryType.class);
  }

  /**
   * Create a reader builder for EnquiryResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <EnquiryResponseType> enquiryResponse ()
  {
    return UBL22ReaderBuilder.create (EnquiryResponseType.class);
  }

  /**
   * Create a reader builder for ExceptionCriteria.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ExceptionCriteriaType> exceptionCriteria ()
  {
    return UBL22ReaderBuilder.create (ExceptionCriteriaType.class);
  }

  /**
   * Create a reader builder for ExceptionNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ExceptionNotificationType> exceptionNotification ()
  {
    return UBL22ReaderBuilder.create (ExceptionNotificationType.class);
  }

  /**
   * Create a reader builder for ExpressionOfInterestRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ExpressionOfInterestRequestType> expressionOfInterestRequest ()
  {
    return UBL22ReaderBuilder.create (ExpressionOfInterestRequestType.class);
  }

  /**
   * Create a reader builder for ExpressionOfInterestResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ExpressionOfInterestResponseType> expressionOfInterestResponse ()
  {
    return UBL22ReaderBuilder.create (ExpressionOfInterestResponseType.class);
  }

  /**
   * Create a reader builder for Forecast.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ForecastType> forecast ()
  {
    return UBL22ReaderBuilder.create (ForecastType.class);
  }

  /**
   * Create a reader builder for ForecastRevision.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ForecastRevisionType> forecastRevision ()
  {
    return UBL22ReaderBuilder.create (ForecastRevisionType.class);
  }

  /**
   * Create a reader builder for ForwardingInstructions.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL22ReaderBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Create a reader builder for FreightInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL22ReaderBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Create a reader builder for FulfilmentCancellation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return UBL22ReaderBuilder.create (FulfilmentCancellationType.class);
  }

  /**
   * Create a reader builder for GoodsItemItinerary.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return UBL22ReaderBuilder.create (GoodsItemItineraryType.class);
  }

  /**
   * Create a reader builder for GuaranteeCertificate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return UBL22ReaderBuilder.create (GuaranteeCertificateType.class);
  }

  /**
   * Create a reader builder for InstructionForReturns.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <InstructionForReturnsType> instructionForReturns ()
  {
    return UBL22ReaderBuilder.create (InstructionForReturnsType.class);
  }

  /**
   * Create a reader builder for InventoryReport.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <InventoryReportType> inventoryReport ()
  {
    return UBL22ReaderBuilder.create (InventoryReportType.class);
  }

  /**
   * Create a reader builder for Invoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <InvoiceType> invoice ()
  {
    return UBL22ReaderBuilder.create (InvoiceType.class);
  }

  /**
   * Create a reader builder for ItemInformationRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ItemInformationRequestType> itemInformationRequest ()
  {
    return UBL22ReaderBuilder.create (ItemInformationRequestType.class);
  }

  /**
   * Create a reader builder for Order.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <OrderType> order ()
  {
    return UBL22ReaderBuilder.create (OrderType.class);
  }

  /**
   * Create a reader builder for OrderCancellation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL22ReaderBuilder.create (OrderCancellationType.class);
  }

  /**
   * Create a reader builder for OrderChange.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <OrderChangeType> orderChange ()
  {
    return UBL22ReaderBuilder.create (OrderChangeType.class);
  }

  /**
   * Create a reader builder for OrderResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <OrderResponseType> orderResponse ()
  {
    return UBL22ReaderBuilder.create (OrderResponseType.class);
  }

  /**
   * Create a reader builder for OrderResponseSimple.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL22ReaderBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Create a reader builder for PackingList.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <PackingListType> packingList ()
  {
    return UBL22ReaderBuilder.create (PackingListType.class);
  }

  /**
   * Create a reader builder for PriorInformationNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <PriorInformationNoticeType> priorInformationNotice ()
  {
    return UBL22ReaderBuilder.create (PriorInformationNoticeType.class);
  }

  /**
   * Create a reader builder for ProductActivity.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ProductActivityType> productActivity ()
  {
    return UBL22ReaderBuilder.create (ProductActivityType.class);
  }

  /**
   * Create a reader builder for QualificationApplicationRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <QualificationApplicationRequestType> qualificationApplicationRequest ()
  {
    return UBL22ReaderBuilder.create (QualificationApplicationRequestType.class);
  }

  /**
   * Create a reader builder for QualificationApplicationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <QualificationApplicationResponseType> qualificationApplicationResponse ()
  {
    return UBL22ReaderBuilder.create (QualificationApplicationResponseType.class);
  }

  /**
   * Create a reader builder for Quotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <QuotationType> quotation ()
  {
    return UBL22ReaderBuilder.create (QuotationType.class);
  }

  /**
   * Create a reader builder for ReceiptAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL22ReaderBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Create a reader builder for Reminder.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <ReminderType> reminder ()
  {
    return UBL22ReaderBuilder.create (ReminderType.class);
  }

  /**
   * Create a reader builder for RemittanceAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL22ReaderBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Create a reader builder for RequestForQuotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL22ReaderBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Create a reader builder for RetailEvent.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <RetailEventType> retailEvent ()
  {
    return UBL22ReaderBuilder.create (RetailEventType.class);
  }

  /**
   * Create a reader builder for SelfBilledCreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL22ReaderBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Create a reader builder for SelfBilledInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL22ReaderBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Create a reader builder for Statement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <StatementType> statement ()
  {
    return UBL22ReaderBuilder.create (StatementType.class);
  }

  /**
   * Create a reader builder for StockAvailabilityReport.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return UBL22ReaderBuilder.create (StockAvailabilityReportType.class);
  }

  /**
   * Create a reader builder for Tender.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TenderType> tender ()
  {
    return UBL22ReaderBuilder.create (TenderType.class);
  }

  /**
   * Create a reader builder for TenderContract.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TenderContractType> tenderContract ()
  {
    return UBL22ReaderBuilder.create (TenderContractType.class);
  }

  /**
   * Create a reader builder for TendererQualification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TendererQualificationType> tendererQualification ()
  {
    return UBL22ReaderBuilder.create (TendererQualificationType.class);
  }

  /**
   * Create a reader builder for TendererQualificationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return UBL22ReaderBuilder.create (TendererQualificationResponseType.class);
  }

  /**
   * Create a reader builder for TenderReceipt.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TenderReceiptType> tenderReceipt ()
  {
    return UBL22ReaderBuilder.create (TenderReceiptType.class);
  }

  /**
   * Create a reader builder for TenderStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TenderStatusType> tenderStatus ()
  {
    return UBL22ReaderBuilder.create (TenderStatusType.class);
  }

  /**
   * Create a reader builder for TenderStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TenderStatusRequestType> tenderStatusRequest ()
  {
    return UBL22ReaderBuilder.create (TenderStatusRequestType.class);
  }

  /**
   * Create a reader builder for TenderWithdrawal.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TenderWithdrawalType> tenderWithdrawal ()
  {
    return UBL22ReaderBuilder.create (TenderWithdrawalType.class);
  }

  /**
   * Create a reader builder for TradeItemLocationProfile.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return UBL22ReaderBuilder.create (TradeItemLocationProfileType.class);
  }

  /**
   * Create a reader builder for TransportationStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL22ReaderBuilder.create (TransportationStatusType.class);
  }

  /**
   * Create a reader builder for TransportationStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return UBL22ReaderBuilder.create (TransportationStatusRequestType.class);
  }

  /**
   * Create a reader builder for TransportExecutionPlan.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return UBL22ReaderBuilder.create (TransportExecutionPlanType.class);
  }

  /**
   * Create a reader builder for TransportExecutionPlanRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return UBL22ReaderBuilder.create (TransportExecutionPlanRequestType.class);
  }

  /**
   * Create a reader builder for TransportProgressStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TransportProgressStatusType> transportProgressStatus ()
  {
    return UBL22ReaderBuilder.create (TransportProgressStatusType.class);
  }

  /**
   * Create a reader builder for TransportProgressStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return UBL22ReaderBuilder.create (TransportProgressStatusRequestType.class);
  }

  /**
   * Create a reader builder for TransportServiceDescription.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return UBL22ReaderBuilder.create (TransportServiceDescriptionType.class);
  }

  /**
   * Create a reader builder for TransportServiceDescriptionRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return UBL22ReaderBuilder.create (TransportServiceDescriptionRequestType.class);
  }

  /**
   * Create a reader builder for UnawardedNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <UnawardedNotificationType> unawardedNotification ()
  {
    return UBL22ReaderBuilder.create (UnawardedNotificationType.class);
  }

  /**
   * Create a reader builder for UnsubscribeFromProcedureRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest ()
  {
    return UBL22ReaderBuilder.create (UnsubscribeFromProcedureRequestType.class);
  }

  /**
   * Create a reader builder for UnsubscribeFromProcedureResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse ()
  {
    return UBL22ReaderBuilder.create (UnsubscribeFromProcedureResponseType.class);
  }

  /**
   * Create a reader builder for UtilityStatement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <UtilityStatementType> utilityStatement ()
  {
    return UBL22ReaderBuilder.create (UtilityStatementType.class);
  }

  /**
   * Create a reader builder for Waybill.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <WaybillType> waybill ()
  {
    return UBL22ReaderBuilder.create (WaybillType.class);
  }

  /**
   * Create a reader builder for WeightStatement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ReaderBuilder <WeightStatementType> weightStatement ()
  {
    return UBL22ReaderBuilder.create (WeightStatementType.class);
  }
}
