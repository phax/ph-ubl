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
import oasis.names.specification.ubl.schema.xsd.commontransportationreport_23.CommonTransportationReportType;
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
import oasis.names.specification.ubl.schema.xsd.manifest_23.ManifestType;
import oasis.names.specification.ubl.schema.xsd.order_23.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_23.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_23.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_23.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_23.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_23.PackingListType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.PriorInformationNoticeType;
import oasis.names.specification.ubl.schema.xsd.productactivity_23.ProductActivityType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportation_23.ProofOfReexportationType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_23.ProofOfReexportationReminderType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_23.ProofOfReexportationRequestType;
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
 * Write all UBL 2.3 document types.
 *
 * @author Philip Helger
 * @deprecated Use {@link UBL23Marshaller} instead
 */
@NotThreadSafe
@Deprecated (forRemoval = true, since = "8.0.0")
public final class UBL23Writer
{
  @PresentForCodeCoverage
  private static final UBL23Writer INSTANCE = new UBL23Writer ();

  private UBL23Writer ()
  {}

  /**
   * Create a writer builder for ApplicationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL23WriterBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a writer builder for AttachedDocument.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL23WriterBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Create a writer builder for AwardedNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <AwardedNotificationType> awardedNotification ()
  {
    return UBL23WriterBuilder.create (AwardedNotificationType.class);
  }

  /**
   * Create a writer builder for BillOfLading.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL23WriterBuilder.create (BillOfLadingType.class);
  }

  /**
   * Create a writer builder for BusinessCard.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <BusinessCardType> businessCard ()
  {
    return UBL23WriterBuilder.create (BusinessCardType.class);
  }

  /**
   * Create a writer builder for CallForTenders.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <CallForTendersType> callForTenders ()
  {
    return UBL23WriterBuilder.create (CallForTendersType.class);
  }

  /**
   * Create a writer builder for Catalogue.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <CatalogueType> catalogue ()
  {
    return UBL23WriterBuilder.create (CatalogueType.class);
  }

  /**
   * Create a writer builder for CatalogueDeletion.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL23WriterBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Create a writer builder for CatalogueItemSpecificationUpdate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL23WriterBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Create a writer builder for CataloguePricingUpdate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL23WriterBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Create a writer builder for CatalogueRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL23WriterBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Create a writer builder for CertificateOfOrigin.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL23WriterBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Create a writer builder for CommonTransportationReport.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <CommonTransportationReportType> commonTransportationReport ()
  {
    return UBL23WriterBuilder.create (CommonTransportationReportType.class);
  }

  /**
   * Create a writer builder for ContractAwardNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ContractAwardNoticeType> contractAwardNotice ()
  {
    return UBL23WriterBuilder.create (ContractAwardNoticeType.class);
  }

  /**
   * Create a writer builder for ContractNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ContractNoticeType> contractNotice ()
  {
    return UBL23WriterBuilder.create (ContractNoticeType.class);
  }

  /**
   * Create a writer builder for CreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <CreditNoteType> creditNote ()
  {
    return UBL23WriterBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a writer builder for DebitNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <DebitNoteType> debitNote ()
  {
    return UBL23WriterBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a writer builder for DespatchAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL23WriterBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Create a writer builder for DigitalAgreement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <DigitalAgreementType> digitalAgreement ()
  {
    return UBL23WriterBuilder.create (DigitalAgreementType.class);
  }

  /**
   * Create a writer builder for DigitalCapability.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <DigitalCapabilityType> digitalCapability ()
  {
    return UBL23WriterBuilder.create (DigitalCapabilityType.class);
  }

  /**
   * Create a writer builder for DocumentStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <DocumentStatusType> documentStatus ()
  {
    return UBL23WriterBuilder.create (DocumentStatusType.class);
  }

  /**
   * Create a writer builder for DocumentStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <DocumentStatusRequestType> documentStatusRequest ()
  {
    return UBL23WriterBuilder.create (DocumentStatusRequestType.class);
  }

  /**
   * Create a writer builder for Enquiry.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <EnquiryType> enquiry ()
  {
    return UBL23WriterBuilder.create (EnquiryType.class);
  }

  /**
   * Create a writer builder for EnquiryResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <EnquiryResponseType> enquiryResponse ()
  {
    return UBL23WriterBuilder.create (EnquiryResponseType.class);
  }

  /**
   * Create a writer builder for ExceptionCriteria.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ExceptionCriteriaType> exceptionCriteria ()
  {
    return UBL23WriterBuilder.create (ExceptionCriteriaType.class);
  }

  /**
   * Create a writer builder for ExceptionNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ExceptionNotificationType> exceptionNotification ()
  {
    return UBL23WriterBuilder.create (ExceptionNotificationType.class);
  }

  /**
   * Create a writer builder for ExportCustomsDeclaration.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ExportCustomsDeclarationType> exportCustomsDeclaration ()
  {
    return UBL23WriterBuilder.create (ExportCustomsDeclarationType.class);
  }

  /**
   * Create a writer builder for ExpressionOfInterestRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ExpressionOfInterestRequestType> expressionOfInterestRequest ()
  {
    return UBL23WriterBuilder.create (ExpressionOfInterestRequestType.class);
  }

  /**
   * Create a writer builder for ExpressionOfInterestResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ExpressionOfInterestResponseType> expressionOfInterestResponse ()
  {
    return UBL23WriterBuilder.create (ExpressionOfInterestResponseType.class);
  }

  /**
   * Create a writer builder for Forecast.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ForecastType> forecast ()
  {
    return UBL23WriterBuilder.create (ForecastType.class);
  }

  /**
   * Create a writer builder for ForecastRevision.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ForecastRevisionType> forecastRevision ()
  {
    return UBL23WriterBuilder.create (ForecastRevisionType.class);
  }

  /**
   * Create a writer builder for ForwardingInstructions.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL23WriterBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Create a writer builder for FreightInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL23WriterBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Create a writer builder for FulfilmentCancellation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return UBL23WriterBuilder.create (FulfilmentCancellationType.class);
  }

  /**
   * Create a writer builder for GoodsCertificate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <GoodsCertificateType> goodsCertificate ()
  {
    return UBL23WriterBuilder.create (GoodsCertificateType.class);
  }

  /**
   * Create a writer builder for GoodsItemItinerary.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return UBL23WriterBuilder.create (GoodsItemItineraryType.class);
  }

  /**
   * Create a writer builder for GoodsItemPassport.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <GoodsItemPassportType> goodsItemPassport ()
  {
    return UBL23WriterBuilder.create (GoodsItemPassportType.class);
  }

  /**
   * Create a writer builder for GuaranteeCertificate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return UBL23WriterBuilder.create (GuaranteeCertificateType.class);
  }

  /**
   * Create a writer builder for ImportCustomsDeclaration.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ImportCustomsDeclarationType> importCustomsDeclaration ()
  {
    return UBL23WriterBuilder.create (ImportCustomsDeclarationType.class);
  }

  /**
   * Create a writer builder for InstructionForReturns.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <InstructionForReturnsType> instructionForReturns ()
  {
    return UBL23WriterBuilder.create (InstructionForReturnsType.class);
  }

  /**
   * Create a writer builder for InventoryReport.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <InventoryReportType> inventoryReport ()
  {
    return UBL23WriterBuilder.create (InventoryReportType.class);
  }

  /**
   * Create a writer builder for Invoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <InvoiceType> invoice ()
  {
    return UBL23WriterBuilder.create (InvoiceType.class);
  }

  /**
   * Create a writer builder for ItemInformationRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ItemInformationRequestType> itemInformationRequest ()
  {
    return UBL23WriterBuilder.create (ItemInformationRequestType.class);
  }

  /**
   * Create a writer builder for Manifest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ManifestType> manifest ()
  {
    return UBL23WriterBuilder.create (ManifestType.class);
  }

  /**
   * Create a writer builder for Order.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <OrderType> order ()
  {
    return UBL23WriterBuilder.create (OrderType.class);
  }

  /**
   * Create a writer builder for OrderCancellation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL23WriterBuilder.create (OrderCancellationType.class);
  }

  /**
   * Create a writer builder for OrderChange.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <OrderChangeType> orderChange ()
  {
    return UBL23WriterBuilder.create (OrderChangeType.class);
  }

  /**
   * Create a writer builder for OrderResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <OrderResponseType> orderResponse ()
  {
    return UBL23WriterBuilder.create (OrderResponseType.class);
  }

  /**
   * Create a writer builder for OrderResponseSimple.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL23WriterBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Create a writer builder for PackingList.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <PackingListType> packingList ()
  {
    return UBL23WriterBuilder.create (PackingListType.class);
  }

  /**
   * Create a writer builder for PriorInformationNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <PriorInformationNoticeType> priorInformationNotice ()
  {
    return UBL23WriterBuilder.create (PriorInformationNoticeType.class);
  }

  /**
   * Create a writer builder for ProductActivity.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ProductActivityType> productActivity ()
  {
    return UBL23WriterBuilder.create (ProductActivityType.class);
  }

  /**
   * Create a writer builder for ProofOfReexportation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ProofOfReexportationType> proofOfReexportation ()
  {
    return UBL23WriterBuilder.create (ProofOfReexportationType.class);
  }

  /**
   * Create a writer builder for ProofOfReexportationReminder.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ProofOfReexportationReminderType> proofOfReexportationReminder ()
  {
    return UBL23WriterBuilder.create (ProofOfReexportationReminderType.class);
  }

  /**
   * Create a writer builder for ProofOfReexportationRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ProofOfReexportationRequestType> proofOfReexportationRequest ()
  {
    return UBL23WriterBuilder.create (ProofOfReexportationRequestType.class);
  }

  /**
   * Create a writer builder for QualificationApplicationRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <QualificationApplicationRequestType> qualificationApplicationRequest ()
  {
    return UBL23WriterBuilder.create (QualificationApplicationRequestType.class);
  }

  /**
   * Create a writer builder for QualificationApplicationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <QualificationApplicationResponseType> qualificationApplicationResponse ()
  {
    return UBL23WriterBuilder.create (QualificationApplicationResponseType.class);
  }

  /**
   * Create a writer builder for Quotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <QuotationType> quotation ()
  {
    return UBL23WriterBuilder.create (QuotationType.class);
  }

  /**
   * Create a writer builder for ReceiptAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL23WriterBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Create a writer builder for Reminder.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <ReminderType> reminder ()
  {
    return UBL23WriterBuilder.create (ReminderType.class);
  }

  /**
   * Create a writer builder for RemittanceAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL23WriterBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Create a writer builder for RequestForQuotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL23WriterBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Create a writer builder for RetailEvent.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <RetailEventType> retailEvent ()
  {
    return UBL23WriterBuilder.create (RetailEventType.class);
  }

  /**
   * Create a writer builder for SelfBilledCreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL23WriterBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Create a writer builder for SelfBilledInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL23WriterBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Create a writer builder for Statement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <StatementType> statement ()
  {
    return UBL23WriterBuilder.create (StatementType.class);
  }

  /**
   * Create a writer builder for StockAvailabilityReport.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return UBL23WriterBuilder.create (StockAvailabilityReportType.class);
  }

  /**
   * Create a writer builder for Tender.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TenderType> tender ()
  {
    return UBL23WriterBuilder.create (TenderType.class);
  }

  /**
   * Create a writer builder for TenderContract.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TenderContractType> tenderContract ()
  {
    return UBL23WriterBuilder.create (TenderContractType.class);
  }

  /**
   * Create a writer builder for TendererQualification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TendererQualificationType> tendererQualification ()
  {
    return UBL23WriterBuilder.create (TendererQualificationType.class);
  }

  /**
   * Create a writer builder for TendererQualificationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return UBL23WriterBuilder.create (TendererQualificationResponseType.class);
  }

  /**
   * Create a writer builder for TenderReceipt.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TenderReceiptType> tenderReceipt ()
  {
    return UBL23WriterBuilder.create (TenderReceiptType.class);
  }

  /**
   * Create a writer builder for TenderStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TenderStatusType> tenderStatus ()
  {
    return UBL23WriterBuilder.create (TenderStatusType.class);
  }

  /**
   * Create a writer builder for TenderStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TenderStatusRequestType> tenderStatusRequest ()
  {
    return UBL23WriterBuilder.create (TenderStatusRequestType.class);
  }

  /**
   * Create a writer builder for TenderWithdrawal.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TenderWithdrawalType> tenderWithdrawal ()
  {
    return UBL23WriterBuilder.create (TenderWithdrawalType.class);
  }

  /**
   * Create a writer builder for TradeItemLocationProfile.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return UBL23WriterBuilder.create (TradeItemLocationProfileType.class);
  }

  /**
   * Create a writer builder for TransitCustomsDeclaration.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TransitCustomsDeclarationType> transitCustomsDeclaration ()
  {
    return UBL23WriterBuilder.create (TransitCustomsDeclarationType.class);
  }

  /**
   * Create a writer builder for TransportationStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL23WriterBuilder.create (TransportationStatusType.class);
  }

  /**
   * Create a writer builder for TransportationStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return UBL23WriterBuilder.create (TransportationStatusRequestType.class);
  }

  /**
   * Create a writer builder for TransportExecutionPlan.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return UBL23WriterBuilder.create (TransportExecutionPlanType.class);
  }

  /**
   * Create a writer builder for TransportExecutionPlanRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return UBL23WriterBuilder.create (TransportExecutionPlanRequestType.class);
  }

  /**
   * Create a writer builder for TransportProgressStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TransportProgressStatusType> transportProgressStatus ()
  {
    return UBL23WriterBuilder.create (TransportProgressStatusType.class);
  }

  /**
   * Create a writer builder for TransportProgressStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return UBL23WriterBuilder.create (TransportProgressStatusRequestType.class);
  }

  /**
   * Create a writer builder for TransportServiceDescription.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return UBL23WriterBuilder.create (TransportServiceDescriptionType.class);
  }

  /**
   * Create a writer builder for TransportServiceDescriptionRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return UBL23WriterBuilder.create (TransportServiceDescriptionRequestType.class);
  }

  /**
   * Create a writer builder for UnawardedNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <UnawardedNotificationType> unawardedNotification ()
  {
    return UBL23WriterBuilder.create (UnawardedNotificationType.class);
  }

  /**
   * Create a writer builder for UnsubscribeFromProcedureRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest ()
  {
    return UBL23WriterBuilder.create (UnsubscribeFromProcedureRequestType.class);
  }

  /**
   * Create a writer builder for UnsubscribeFromProcedureResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse ()
  {
    return UBL23WriterBuilder.create (UnsubscribeFromProcedureResponseType.class);
  }

  /**
   * Create a writer builder for UtilityStatement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <UtilityStatementType> utilityStatement ()
  {
    return UBL23WriterBuilder.create (UtilityStatementType.class);
  }

  /**
   * Create a writer builder for Waybill.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <WaybillType> waybill ()
  {
    return UBL23WriterBuilder.create (WaybillType.class);
  }

  /**
   * Create a writer builder for WeightStatement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL23WriterBuilder <WeightStatementType> weightStatement ()
  {
    return UBL23WriterBuilder.create (WeightStatementType.class);
  }
}
