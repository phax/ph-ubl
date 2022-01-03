/*
 * Copyright (C) 2014-2022 Philip Helger (www.helger.com)
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
 * Validate all UBL 2.2 document types.
 * 
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL22Validator
{
  @PresentForCodeCoverage
  private static final UBL22Validator INSTANCE = new UBL22Validator ();

  private UBL22Validator ()
  {}

  /**
   * Create a validation builder for ApplicationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL22ValidatorBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a validation builder for AttachedDocument.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL22ValidatorBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Create a validation builder for AwardedNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <AwardedNotificationType> awardedNotification ()
  {
    return UBL22ValidatorBuilder.create (AwardedNotificationType.class);
  }

  /**
   * Create a validation builder for BillOfLading.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL22ValidatorBuilder.create (BillOfLadingType.class);
  }

  /**
   * Create a validation builder for BusinessCard.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <BusinessCardType> businessCard ()
  {
    return UBL22ValidatorBuilder.create (BusinessCardType.class);
  }

  /**
   * Create a validation builder for CallForTenders.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <CallForTendersType> callForTenders ()
  {
    return UBL22ValidatorBuilder.create (CallForTendersType.class);
  }

  /**
   * Create a validation builder for Catalogue.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <CatalogueType> catalogue ()
  {
    return UBL22ValidatorBuilder.create (CatalogueType.class);
  }

  /**
   * Create a validation builder for CatalogueDeletion.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL22ValidatorBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Create a validation builder for CatalogueItemSpecificationUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL22ValidatorBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Create a validation builder for CataloguePricingUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL22ValidatorBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Create a validation builder for CatalogueRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL22ValidatorBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Create a validation builder for CertificateOfOrigin.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL22ValidatorBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Create a validation builder for ContractAwardNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ContractAwardNoticeType> contractAwardNotice ()
  {
    return UBL22ValidatorBuilder.create (ContractAwardNoticeType.class);
  }

  /**
   * Create a validation builder for ContractNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ContractNoticeType> contractNotice ()
  {
    return UBL22ValidatorBuilder.create (ContractNoticeType.class);
  }

  /**
   * Create a validation builder for CreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <CreditNoteType> creditNote ()
  {
    return UBL22ValidatorBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a validation builder for DebitNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <DebitNoteType> debitNote ()
  {
    return UBL22ValidatorBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a validation builder for DespatchAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL22ValidatorBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Create a validation builder for DigitalAgreement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <DigitalAgreementType> digitalAgreement ()
  {
    return UBL22ValidatorBuilder.create (DigitalAgreementType.class);
  }

  /**
   * Create a validation builder for DigitalCapability.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <DigitalCapabilityType> digitalCapability ()
  {
    return UBL22ValidatorBuilder.create (DigitalCapabilityType.class);
  }

  /**
   * Create a validation builder for DocumentStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <DocumentStatusType> documentStatus ()
  {
    return UBL22ValidatorBuilder.create (DocumentStatusType.class);
  }

  /**
   * Create a validation builder for DocumentStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <DocumentStatusRequestType> documentStatusRequest ()
  {
    return UBL22ValidatorBuilder.create (DocumentStatusRequestType.class);
  }

  /**
   * Create a validation builder for Enquiry.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <EnquiryType> enquiry ()
  {
    return UBL22ValidatorBuilder.create (EnquiryType.class);
  }

  /**
   * Create a validation builder for EnquiryResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <EnquiryResponseType> enquiryResponse ()
  {
    return UBL22ValidatorBuilder.create (EnquiryResponseType.class);
  }

  /**
   * Create a validation builder for ExceptionCriteria.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ExceptionCriteriaType> exceptionCriteria ()
  {
    return UBL22ValidatorBuilder.create (ExceptionCriteriaType.class);
  }

  /**
   * Create a validation builder for ExceptionNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ExceptionNotificationType> exceptionNotification ()
  {
    return UBL22ValidatorBuilder.create (ExceptionNotificationType.class);
  }

  /**
   * Create a validation builder for ExpressionOfInterestRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ExpressionOfInterestRequestType> expressionOfInterestRequest ()
  {
    return UBL22ValidatorBuilder.create (ExpressionOfInterestRequestType.class);
  }

  /**
   * Create a validation builder for ExpressionOfInterestResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ExpressionOfInterestResponseType> expressionOfInterestResponse ()
  {
    return UBL22ValidatorBuilder.create (ExpressionOfInterestResponseType.class);
  }

  /**
   * Create a validation builder for Forecast.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ForecastType> forecast ()
  {
    return UBL22ValidatorBuilder.create (ForecastType.class);
  }

  /**
   * Create a validation builder for ForecastRevision.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ForecastRevisionType> forecastRevision ()
  {
    return UBL22ValidatorBuilder.create (ForecastRevisionType.class);
  }

  /**
   * Create a validation builder for ForwardingInstructions.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL22ValidatorBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Create a validation builder for FreightInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL22ValidatorBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Create a validation builder for FulfilmentCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return UBL22ValidatorBuilder.create (FulfilmentCancellationType.class);
  }

  /**
   * Create a validation builder for GoodsItemItinerary.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return UBL22ValidatorBuilder.create (GoodsItemItineraryType.class);
  }

  /**
   * Create a validation builder for GuaranteeCertificate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return UBL22ValidatorBuilder.create (GuaranteeCertificateType.class);
  }

  /**
   * Create a validation builder for InstructionForReturns.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <InstructionForReturnsType> instructionForReturns ()
  {
    return UBL22ValidatorBuilder.create (InstructionForReturnsType.class);
  }

  /**
   * Create a validation builder for InventoryReport.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <InventoryReportType> inventoryReport ()
  {
    return UBL22ValidatorBuilder.create (InventoryReportType.class);
  }

  /**
   * Create a validation builder for Invoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <InvoiceType> invoice ()
  {
    return UBL22ValidatorBuilder.create (InvoiceType.class);
  }

  /**
   * Create a validation builder for ItemInformationRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ItemInformationRequestType> itemInformationRequest ()
  {
    return UBL22ValidatorBuilder.create (ItemInformationRequestType.class);
  }

  /**
   * Create a validation builder for Order.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <OrderType> order ()
  {
    return UBL22ValidatorBuilder.create (OrderType.class);
  }

  /**
   * Create a validation builder for OrderCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL22ValidatorBuilder.create (OrderCancellationType.class);
  }

  /**
   * Create a validation builder for OrderChange.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <OrderChangeType> orderChange ()
  {
    return UBL22ValidatorBuilder.create (OrderChangeType.class);
  }

  /**
   * Create a validation builder for OrderResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <OrderResponseType> orderResponse ()
  {
    return UBL22ValidatorBuilder.create (OrderResponseType.class);
  }

  /**
   * Create a validation builder for OrderResponseSimple.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL22ValidatorBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Create a validation builder for PackingList.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <PackingListType> packingList ()
  {
    return UBL22ValidatorBuilder.create (PackingListType.class);
  }

  /**
   * Create a validation builder for PriorInformationNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <PriorInformationNoticeType> priorInformationNotice ()
  {
    return UBL22ValidatorBuilder.create (PriorInformationNoticeType.class);
  }

  /**
   * Create a validation builder for ProductActivity.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ProductActivityType> productActivity ()
  {
    return UBL22ValidatorBuilder.create (ProductActivityType.class);
  }

  /**
   * Create a validation builder for QualificationApplicationRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <QualificationApplicationRequestType> qualificationApplicationRequest ()
  {
    return UBL22ValidatorBuilder.create (QualificationApplicationRequestType.class);
  }

  /**
   * Create a validation builder for QualificationApplicationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <QualificationApplicationResponseType> qualificationApplicationResponse ()
  {
    return UBL22ValidatorBuilder.create (QualificationApplicationResponseType.class);
  }

  /**
   * Create a validation builder for Quotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <QuotationType> quotation ()
  {
    return UBL22ValidatorBuilder.create (QuotationType.class);
  }

  /**
   * Create a validation builder for ReceiptAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL22ValidatorBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Create a validation builder for Reminder.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <ReminderType> reminder ()
  {
    return UBL22ValidatorBuilder.create (ReminderType.class);
  }

  /**
   * Create a validation builder for RemittanceAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL22ValidatorBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Create a validation builder for RequestForQuotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL22ValidatorBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Create a validation builder for RetailEvent.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <RetailEventType> retailEvent ()
  {
    return UBL22ValidatorBuilder.create (RetailEventType.class);
  }

  /**
   * Create a validation builder for SelfBilledCreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL22ValidatorBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Create a validation builder for SelfBilledInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL22ValidatorBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Create a validation builder for Statement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <StatementType> statement ()
  {
    return UBL22ValidatorBuilder.create (StatementType.class);
  }

  /**
   * Create a validation builder for StockAvailabilityReport.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return UBL22ValidatorBuilder.create (StockAvailabilityReportType.class);
  }

  /**
   * Create a validation builder for Tender.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TenderType> tender ()
  {
    return UBL22ValidatorBuilder.create (TenderType.class);
  }

  /**
   * Create a validation builder for TenderContract.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TenderContractType> tenderContract ()
  {
    return UBL22ValidatorBuilder.create (TenderContractType.class);
  }

  /**
   * Create a validation builder for TendererQualification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TendererQualificationType> tendererQualification ()
  {
    return UBL22ValidatorBuilder.create (TendererQualificationType.class);
  }

  /**
   * Create a validation builder for TendererQualificationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return UBL22ValidatorBuilder.create (TendererQualificationResponseType.class);
  }

  /**
   * Create a validation builder for TenderReceipt.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TenderReceiptType> tenderReceipt ()
  {
    return UBL22ValidatorBuilder.create (TenderReceiptType.class);
  }

  /**
   * Create a validation builder for TenderStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TenderStatusType> tenderStatus ()
  {
    return UBL22ValidatorBuilder.create (TenderStatusType.class);
  }

  /**
   * Create a validation builder for TenderStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TenderStatusRequestType> tenderStatusRequest ()
  {
    return UBL22ValidatorBuilder.create (TenderStatusRequestType.class);
  }

  /**
   * Create a validation builder for TenderWithdrawal.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TenderWithdrawalType> tenderWithdrawal ()
  {
    return UBL22ValidatorBuilder.create (TenderWithdrawalType.class);
  }

  /**
   * Create a validation builder for TradeItemLocationProfile.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return UBL22ValidatorBuilder.create (TradeItemLocationProfileType.class);
  }

  /**
   * Create a validation builder for TransportationStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL22ValidatorBuilder.create (TransportationStatusType.class);
  }

  /**
   * Create a validation builder for TransportationStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return UBL22ValidatorBuilder.create (TransportationStatusRequestType.class);
  }

  /**
   * Create a validation builder for TransportExecutionPlan.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return UBL22ValidatorBuilder.create (TransportExecutionPlanType.class);
  }

  /**
   * Create a validation builder for TransportExecutionPlanRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return UBL22ValidatorBuilder.create (TransportExecutionPlanRequestType.class);
  }

  /**
   * Create a validation builder for TransportProgressStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TransportProgressStatusType> transportProgressStatus ()
  {
    return UBL22ValidatorBuilder.create (TransportProgressStatusType.class);
  }

  /**
   * Create a validation builder for TransportProgressStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return UBL22ValidatorBuilder.create (TransportProgressStatusRequestType.class);
  }

  /**
   * Create a validation builder for TransportServiceDescription.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return UBL22ValidatorBuilder.create (TransportServiceDescriptionType.class);
  }

  /**
   * Create a validation builder for TransportServiceDescriptionRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return UBL22ValidatorBuilder.create (TransportServiceDescriptionRequestType.class);
  }

  /**
   * Create a validation builder for UnawardedNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <UnawardedNotificationType> unawardedNotification ()
  {
    return UBL22ValidatorBuilder.create (UnawardedNotificationType.class);
  }

  /**
   * Create a validation builder for UnsubscribeFromProcedureRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest ()
  {
    return UBL22ValidatorBuilder.create (UnsubscribeFromProcedureRequestType.class);
  }

  /**
   * Create a validation builder for UnsubscribeFromProcedureResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse ()
  {
    return UBL22ValidatorBuilder.create (UnsubscribeFromProcedureResponseType.class);
  }

  /**
   * Create a validation builder for UtilityStatement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <UtilityStatementType> utilityStatement ()
  {
    return UBL22ValidatorBuilder.create (UtilityStatementType.class);
  }

  /**
   * Create a validation builder for Waybill.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <WaybillType> waybill ()
  {
    return UBL22ValidatorBuilder.create (WaybillType.class);
  }

  /**
   * Create a validation builder for WeightStatement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL22ValidatorBuilder <WeightStatementType> weightStatement ()
  {
    return UBL22ValidatorBuilder.create (WeightStatementType.class);
  }
}
