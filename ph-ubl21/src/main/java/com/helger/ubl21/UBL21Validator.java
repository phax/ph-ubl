/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.error.IResourceErrorGroup;
import com.helger.ubl.api.AbstractUBLDocumentMarshaller;

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
 */
@NotThreadSafe
public final class UBL21Validator extends AbstractUBLDocumentMarshaller
{
  @PresentForCodeCoverage
  @SuppressWarnings ("unused")
  private static final UBL21Validator s_aInstance = new UBL21Validator ();

  private UBL21Validator ()
  {}

  /**
   * Validate the passed {@link ApplicationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse)
  {
    return UBL21Marshaller.validateUBLObject (aApplicationResponse, EUBL21DocumentType.APPLICATION_RESPONSE);
  }

  /**
   * Validate the passed {@link ApplicationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse)
  {
    return validateApplicationResponse (aApplicationResponse).containsNoError ();
  }

  /**
   * Validate the passed {@link AttachedDocumentType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument)
  {
    return UBL21Marshaller.validateUBLObject (aAttachedDocument, EUBL21DocumentType.ATTACHED_DOCUMENT);
  }

  /**
   * Validate the passed {@link AttachedDocumentType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument)
  {
    return validateAttachedDocument (aAttachedDocument).containsNoError ();
  }

  /**
   * Validate the passed {@link AwardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification)
  {
    return UBL21Marshaller.validateUBLObject (aAwardedNotification, EUBL21DocumentType.AWARDED_NOTIFICATION);
  }

  /**
   * Validate the passed {@link AwardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification)
  {
    return validateAwardedNotification (aAwardedNotification).containsNoError ();
  }

  /**
   * Validate the passed {@link BillOfLadingType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateBillOfLading (@Nonnull final BillOfLadingType aBillOfLading)
  {
    return UBL21Marshaller.validateUBLObject (aBillOfLading, EUBL21DocumentType.BILL_OF_LADING);
  }

  /**
   * Validate the passed {@link BillOfLadingType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidBillOfLading (@Nonnull final BillOfLadingType aBillOfLading)
  {
    return validateBillOfLading (aBillOfLading).containsNoError ();
  }

  /**
   * Validate the passed {@link CallForTendersType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateCallForTenders (@Nonnull final CallForTendersType aCallForTenders)
  {
    return UBL21Marshaller.validateUBLObject (aCallForTenders, EUBL21DocumentType.CALL_FOR_TENDERS);
  }

  /**
   * Validate the passed {@link CallForTendersType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidCallForTenders (@Nonnull final CallForTendersType aCallForTenders)
  {
    return validateCallForTenders (aCallForTenders).containsNoError ();
  }

  /**
   * Validate the passed {@link CatalogueType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateCatalogue (@Nonnull final CatalogueType aCatalogue)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogue, EUBL21DocumentType.CATALOGUE);
  }

  /**
   * Validate the passed {@link CatalogueType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidCatalogue (@Nonnull final CatalogueType aCatalogue)
  {
    return validateCatalogue (aCatalogue).containsNoError ();
  }

  /**
   * Validate the passed {@link CatalogueDeletionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogueDeletion, EUBL21DocumentType.CATALOGUE_DELETION);
  }

  /**
   * Validate the passed {@link CatalogueDeletionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion)
  {
    return validateCatalogueDeletion (aCatalogueDeletion).containsNoError ();
  }

  /**
   * Validate the passed {@link CatalogueItemSpecificationUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogueItemSpecificationUpdate,
                                              EUBL21DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE);
  }

  /**
   * Validate the passed {@link CatalogueItemSpecificationUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate)
  {
    return validateCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate).containsNoError ();
  }

  /**
   * Validate the passed {@link CataloguePricingUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate)
  {
    return UBL21Marshaller.validateUBLObject (aCataloguePricingUpdate, EUBL21DocumentType.CATALOGUE_PRICING_UPDATE);
  }

  /**
   * Validate the passed {@link CataloguePricingUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate)
  {
    return validateCataloguePricingUpdate (aCataloguePricingUpdate).containsNoError ();
  }

  /**
   * Validate the passed {@link CatalogueRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogueRequest, EUBL21DocumentType.CATALOGUE_REQUEST);
  }

  /**
   * Validate the passed {@link CatalogueRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest)
  {
    return validateCatalogueRequest (aCatalogueRequest).containsNoError ();
  }

  /**
   * Validate the passed {@link CertificateOfOriginType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin)
  {
    return UBL21Marshaller.validateUBLObject (aCertificateOfOrigin, EUBL21DocumentType.CERTIFICATE_OF_ORIGIN);
  }

  /**
   * Validate the passed {@link CertificateOfOriginType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin)
  {
    return validateCertificateOfOrigin (aCertificateOfOrigin).containsNoError ();
  }

  /**
   * Validate the passed {@link ContractAwardNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice)
  {
    return UBL21Marshaller.validateUBLObject (aContractAwardNotice, EUBL21DocumentType.CONTRACT_AWARD_NOTICE);
  }

  /**
   * Validate the passed {@link ContractAwardNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice)
  {
    return validateContractAwardNotice (aContractAwardNotice).containsNoError ();
  }

  /**
   * Validate the passed {@link ContractNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateContractNotice (@Nonnull final ContractNoticeType aContractNotice)
  {
    return UBL21Marshaller.validateUBLObject (aContractNotice, EUBL21DocumentType.CONTRACT_NOTICE);
  }

  /**
   * Validate the passed {@link ContractNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidContractNotice (@Nonnull final ContractNoticeType aContractNotice)
  {
    return validateContractNotice (aContractNotice).containsNoError ();
  }

  /**
   * Validate the passed {@link CreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateCreditNote (@Nonnull final CreditNoteType aCreditNote)
  {
    return UBL21Marshaller.validateUBLObject (aCreditNote, EUBL21DocumentType.CREDIT_NOTE);
  }

  /**
   * Validate the passed {@link CreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidCreditNote (@Nonnull final CreditNoteType aCreditNote)
  {
    return validateCreditNote (aCreditNote).containsNoError ();
  }

  /**
   * Validate the passed {@link DebitNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateDebitNote (@Nonnull final DebitNoteType aDebitNote)
  {
    return UBL21Marshaller.validateUBLObject (aDebitNote, EUBL21DocumentType.DEBIT_NOTE);
  }

  /**
   * Validate the passed {@link DebitNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidDebitNote (@Nonnull final DebitNoteType aDebitNote)
  {
    return validateDebitNote (aDebitNote).containsNoError ();
  }

  /**
   * Validate the passed {@link DespatchAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice)
  {
    return UBL21Marshaller.validateUBLObject (aDespatchAdvice, EUBL21DocumentType.DESPATCH_ADVICE);
  }

  /**
   * Validate the passed {@link DespatchAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice)
  {
    return validateDespatchAdvice (aDespatchAdvice).containsNoError ();
  }

  /**
   * Validate the passed {@link DocumentStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus)
  {
    return UBL21Marshaller.validateUBLObject (aDocumentStatus, EUBL21DocumentType.DOCUMENT_STATUS);
  }

  /**
   * Validate the passed {@link DocumentStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus)
  {
    return validateDocumentStatus (aDocumentStatus).containsNoError ();
  }

  /**
   * Validate the passed {@link DocumentStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest)
  {
    return UBL21Marshaller.validateUBLObject (aDocumentStatusRequest, EUBL21DocumentType.DOCUMENT_STATUS_REQUEST);
  }

  /**
   * Validate the passed {@link DocumentStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest)
  {
    return validateDocumentStatusRequest (aDocumentStatusRequest).containsNoError ();
  }

  /**
   * Validate the passed {@link ExceptionCriteriaType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria)
  {
    return UBL21Marshaller.validateUBLObject (aExceptionCriteria, EUBL21DocumentType.EXCEPTION_CRITERIA);
  }

  /**
   * Validate the passed {@link ExceptionCriteriaType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria)
  {
    return validateExceptionCriteria (aExceptionCriteria).containsNoError ();
  }

  /**
   * Validate the passed {@link ExceptionNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification)
  {
    return UBL21Marshaller.validateUBLObject (aExceptionNotification, EUBL21DocumentType.EXCEPTION_NOTIFICATION);
  }

  /**
   * Validate the passed {@link ExceptionNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification)
  {
    return validateExceptionNotification (aExceptionNotification).containsNoError ();
  }

  /**
   * Validate the passed {@link ForecastType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateForecast (@Nonnull final ForecastType aForecast)
  {
    return UBL21Marshaller.validateUBLObject (aForecast, EUBL21DocumentType.FORECAST);
  }

  /**
   * Validate the passed {@link ForecastType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidForecast (@Nonnull final ForecastType aForecast)
  {
    return validateForecast (aForecast).containsNoError ();
  }

  /**
   * Validate the passed {@link ForecastRevisionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision)
  {
    return UBL21Marshaller.validateUBLObject (aForecastRevision, EUBL21DocumentType.FORECAST_REVISION);
  }

  /**
   * Validate the passed {@link ForecastRevisionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision)
  {
    return validateForecastRevision (aForecastRevision).containsNoError ();
  }

  /**
   * Validate the passed {@link ForwardingInstructionsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions)
  {
    return UBL21Marshaller.validateUBLObject (aForwardingInstructions, EUBL21DocumentType.FORWARDING_INSTRUCTIONS);
  }

  /**
   * Validate the passed {@link ForwardingInstructionsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions)
  {
    return validateForwardingInstructions (aForwardingInstructions).containsNoError ();
  }

  /**
   * Validate the passed {@link FreightInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice)
  {
    return UBL21Marshaller.validateUBLObject (aFreightInvoice, EUBL21DocumentType.FREIGHT_INVOICE);
  }

  /**
   * Validate the passed {@link FreightInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice)
  {
    return validateFreightInvoice (aFreightInvoice).containsNoError ();
  }

  /**
   * Validate the passed {@link FulfilmentCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation)
  {
    return UBL21Marshaller.validateUBLObject (aFulfilmentCancellation, EUBL21DocumentType.FULFILMENT_CANCELATION);
  }

  /**
   * Validate the passed {@link FulfilmentCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation)
  {
    return validateFulfilmentCancellation (aFulfilmentCancellation).containsNoError ();
  }

  /**
   * Validate the passed {@link GoodsItemItineraryType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary)
  {
    return UBL21Marshaller.validateUBLObject (aGoodsItemItinerary, EUBL21DocumentType.GOODS_ITEM_ITINERARY);
  }

  /**
   * Validate the passed {@link GoodsItemItineraryType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary)
  {
    return validateGoodsItemItinerary (aGoodsItemItinerary).containsNoError ();
  }

  /**
   * Validate the passed {@link GuaranteeCertificateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate)
  {
    return UBL21Marshaller.validateUBLObject (aGuaranteeCertificate, EUBL21DocumentType.GUARANTEE_CERTIFICATE);
  }

  /**
   * Validate the passed {@link GuaranteeCertificateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate)
  {
    return validateGuaranteeCertificate (aGuaranteeCertificate).containsNoError ();
  }

  /**
   * Validate the passed {@link InstructionForReturnsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns)
  {
    return UBL21Marshaller.validateUBLObject (aInstructionForReturns, EUBL21DocumentType.INSTRUCTION_FOR_RETURNS);
  }

  /**
   * Validate the passed {@link InstructionForReturnsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns)
  {
    return validateInstructionForReturns (aInstructionForReturns).containsNoError ();
  }

  /**
   * Validate the passed {@link InventoryReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateInventoryReport (@Nonnull final InventoryReportType aInventoryReport)
  {
    return UBL21Marshaller.validateUBLObject (aInventoryReport, EUBL21DocumentType.INVENTORY_REPORT);
  }

  /**
   * Validate the passed {@link InventoryReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidInventoryReport (@Nonnull final InventoryReportType aInventoryReport)
  {
    return validateInventoryReport (aInventoryReport).containsNoError ();
  }

  /**
   * Validate the passed {@link InvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateInvoice (@Nonnull final InvoiceType aInvoice)
  {
    return UBL21Marshaller.validateUBLObject (aInvoice, EUBL21DocumentType.INVOICE);
  }

  /**
   * Validate the passed {@link InvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidInvoice (@Nonnull final InvoiceType aInvoice)
  {
    return validateInvoice (aInvoice).containsNoError ();
  }

  /**
   * Validate the passed {@link ItemInformationRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest)
  {
    return UBL21Marshaller.validateUBLObject (aItemInformationRequest, EUBL21DocumentType.ITEM_INFORMATION_REQUEST);
  }

  /**
   * Validate the passed {@link ItemInformationRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest)
  {
    return validateItemInformationRequest (aItemInformationRequest).containsNoError ();
  }

  /**
   * Validate the passed {@link OrderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateOrder (@Nonnull final OrderType aOrder)
  {
    return UBL21Marshaller.validateUBLObject (aOrder, EUBL21DocumentType.ORDER);
  }

  /**
   * Validate the passed {@link OrderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidOrder (@Nonnull final OrderType aOrder)
  {
    return validateOrder (aOrder).containsNoError ();
  }

  /**
   * Validate the passed {@link OrderCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation)
  {
    return UBL21Marshaller.validateUBLObject (aOrderCancellation, EUBL21DocumentType.ORDER_CANCELLATION);
  }

  /**
   * Validate the passed {@link OrderCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation)
  {
    return validateOrderCancellation (aOrderCancellation).containsNoError ();
  }

  /**
   * Validate the passed {@link OrderChangeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateOrderChange (@Nonnull final OrderChangeType aOrderChange)
  {
    return UBL21Marshaller.validateUBLObject (aOrderChange, EUBL21DocumentType.ORDER_CHANGE);
  }

  /**
   * Validate the passed {@link OrderChangeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidOrderChange (@Nonnull final OrderChangeType aOrderChange)
  {
    return validateOrderChange (aOrderChange).containsNoError ();
  }

  /**
   * Validate the passed {@link OrderResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateOrderResponse (@Nonnull final OrderResponseType aOrderResponse)
  {
    return UBL21Marshaller.validateUBLObject (aOrderResponse, EUBL21DocumentType.ORDER_RESPONSE);
  }

  /**
   * Validate the passed {@link OrderResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidOrderResponse (@Nonnull final OrderResponseType aOrderResponse)
  {
    return validateOrderResponse (aOrderResponse).containsNoError ();
  }

  /**
   * Validate the passed {@link OrderResponseSimpleType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple)
  {
    return UBL21Marshaller.validateUBLObject (aOrderResponseSimple, EUBL21DocumentType.ORDER_RESPONSE_SIMPLE);
  }

  /**
   * Validate the passed {@link OrderResponseSimpleType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple)
  {
    return validateOrderResponseSimple (aOrderResponseSimple).containsNoError ();
  }

  /**
   * Validate the passed {@link PackingListType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validatePackingList (@Nonnull final PackingListType aPackingList)
  {
    return UBL21Marshaller.validateUBLObject (aPackingList, EUBL21DocumentType.PACKING_LIST);
  }

  /**
   * Validate the passed {@link PackingListType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidPackingList (@Nonnull final PackingListType aPackingList)
  {
    return validatePackingList (aPackingList).containsNoError ();
  }

  /**
   * Validate the passed {@link PriorInformationNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validatePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice)
  {
    return UBL21Marshaller.validateUBLObject (aPriorInformationNotice, EUBL21DocumentType.PRIOR_INFORMATION_NOTICE);
  }

  /**
   * Validate the passed {@link PriorInformationNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidPriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice)
  {
    return validatePriorInformationNotice (aPriorInformationNotice).containsNoError ();
  }

  /**
   * Validate the passed {@link ProductActivityType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateProductActivity (@Nonnull final ProductActivityType aProductActivity)
  {
    return UBL21Marshaller.validateUBLObject (aProductActivity, EUBL21DocumentType.PRODUCT_ACTIVITY);
  }

  /**
   * Validate the passed {@link ProductActivityType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidProductActivity (@Nonnull final ProductActivityType aProductActivity)
  {
    return validateProductActivity (aProductActivity).containsNoError ();
  }

  /**
   * Validate the passed {@link QuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateQuotation (@Nonnull final QuotationType aQuotation)
  {
    return UBL21Marshaller.validateUBLObject (aQuotation, EUBL21DocumentType.QUOTATION);
  }

  /**
   * Validate the passed {@link QuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidQuotation (@Nonnull final QuotationType aQuotation)
  {
    return validateQuotation (aQuotation).containsNoError ();
  }

  /**
   * Validate the passed {@link ReceiptAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice)
  {
    return UBL21Marshaller.validateUBLObject (aReceiptAdvice, EUBL21DocumentType.RECEIPT_ADVICE);
  }

  /**
   * Validate the passed {@link ReceiptAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice)
  {
    return validateReceiptAdvice (aReceiptAdvice).containsNoError ();
  }

  /**
   * Validate the passed {@link ReminderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateReminder (@Nonnull final ReminderType aReminder)
  {
    return UBL21Marshaller.validateUBLObject (aReminder, EUBL21DocumentType.REMINDER);
  }

  /**
   * Validate the passed {@link ReminderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidReminder (@Nonnull final ReminderType aReminder)
  {
    return validateReminder (aReminder).containsNoError ();
  }

  /**
   * Validate the passed {@link RemittanceAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice)
  {
    return UBL21Marshaller.validateUBLObject (aRemittanceAdvice, EUBL21DocumentType.REMITTANCE_ADVICE);
  }

  /**
   * Validate the passed {@link RemittanceAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice)
  {
    return validateRemittanceAdvice (aRemittanceAdvice).containsNoError ();
  }

  /**
   * Validate the passed {@link RequestForQuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation)
  {
    return UBL21Marshaller.validateUBLObject (aRequestForQuotation, EUBL21DocumentType.REQUEST_FOR_QUOTATION);
  }

  /**
   * Validate the passed {@link RequestForQuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation)
  {
    return validateRequestForQuotation (aRequestForQuotation).containsNoError ();
  }

  /**
   * Validate the passed {@link RetailEventType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateRetailEvent (@Nonnull final RetailEventType aRetailEvent)
  {
    return UBL21Marshaller.validateUBLObject (aRetailEvent, EUBL21DocumentType.RETAIL_EVENT);
  }

  /**
   * Validate the passed {@link RetailEventType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidRetailEvent (@Nonnull final RetailEventType aRetailEvent)
  {
    return validateRetailEvent (aRetailEvent).containsNoError ();
  }

  /**
   * Validate the passed {@link SelfBilledCreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote)
  {
    return UBL21Marshaller.validateUBLObject (aSelfBilledCreditNote, EUBL21DocumentType.SELF_BILLED_CREDIT_NOTE);
  }

  /**
   * Validate the passed {@link SelfBilledCreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote)
  {
    return validateSelfBilledCreditNote (aSelfBilledCreditNote).containsNoError ();
  }

  /**
   * Validate the passed {@link SelfBilledInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice)
  {
    return UBL21Marshaller.validateUBLObject (aSelfBilledInvoice, EUBL21DocumentType.SELF_BILLED_INVOICE);
  }

  /**
   * Validate the passed {@link SelfBilledInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice)
  {
    return validateSelfBilledInvoice (aSelfBilledInvoice).containsNoError ();
  }

  /**
   * Validate the passed {@link StatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateStatement (@Nonnull final StatementType aStatement)
  {
    return UBL21Marshaller.validateUBLObject (aStatement, EUBL21DocumentType.STATEMENT);
  }

  /**
   * Validate the passed {@link StatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidStatement (@Nonnull final StatementType aStatement)
  {
    return validateStatement (aStatement).containsNoError ();
  }

  /**
   * Validate the passed {@link StockAvailabilityReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport)
  {
    return UBL21Marshaller.validateUBLObject (aStockAvailabilityReport, EUBL21DocumentType.STOCK_AVAILABILITY_REPORT);
  }

  /**
   * Validate the passed {@link StockAvailabilityReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport)
  {
    return validateStockAvailabilityReport (aStockAvailabilityReport).containsNoError ();
  }

  /**
   * Validate the passed {@link TenderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTender (@Nonnull final TenderType aTender)
  {
    return UBL21Marshaller.validateUBLObject (aTender, EUBL21DocumentType.TENDER);
  }

  /**
   * Validate the passed {@link TenderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTender (@Nonnull final TenderType aTender)
  {
    return validateTender (aTender).containsNoError ();
  }

  /**
   * Validate the passed {@link TendererQualificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTendererQualification (@Nonnull final TendererQualificationType aTendererQualification)
  {
    return UBL21Marshaller.validateUBLObject (aTendererQualification, EUBL21DocumentType.TENDER_QUALIFICATION);
  }

  /**
   * Validate the passed {@link TendererQualificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTendererQualification (@Nonnull final TendererQualificationType aTendererQualification)
  {
    return validateTendererQualification (aTendererQualification).containsNoError ();
  }

  /**
   * Validate the passed {@link TendererQualificationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse)
  {
    return UBL21Marshaller.validateUBLObject (aTendererQualificationResponse,
                                              EUBL21DocumentType.TENDER_QUALIFICATION_RESPONSE);
  }

  /**
   * Validate the passed {@link TendererQualificationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse)
  {
    return validateTendererQualificationResponse (aTendererQualificationResponse).containsNoError ();
  }

  /**
   * Validate the passed {@link TenderReceiptType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt)
  {
    return UBL21Marshaller.validateUBLObject (aTenderReceipt, EUBL21DocumentType.TENDER_RECEIPT);
  }

  /**
   * Validate the passed {@link TenderReceiptType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt)
  {
    return validateTenderReceipt (aTenderReceipt).containsNoError ();
  }

  /**
   * Validate the passed {@link TradeItemLocationProfileType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile)
  {
    return UBL21Marshaller.validateUBLObject (aTradeItemLocationProfile, EUBL21DocumentType.TRADE_ITEM_LOCATION_PROFILE);
  }

  /**
   * Validate the passed {@link TradeItemLocationProfileType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile)
  {
    return validateTradeItemLocationProfile (aTradeItemLocationProfile).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportationStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus)
  {
    return UBL21Marshaller.validateUBLObject (aTransportationStatus, EUBL21DocumentType.TRANSPORTATION_STATUS);
  }

  /**
   * Validate the passed {@link TransportationStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus)
  {
    return validateTransportationStatus (aTransportationStatus).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportationStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest)
  {
    return UBL21Marshaller.validateUBLObject (aTransportationStatusRequest,
                                              EUBL21DocumentType.TRANSPORTATION_STATUS_REQUEST);
  }

  /**
   * Validate the passed {@link TransportationStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest)
  {
    return validateTransportationStatusRequest (aTransportationStatusRequest).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportExecutionPlanType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan)
  {
    return UBL21Marshaller.validateUBLObject (aTransportExecutionPlan, EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN);
  }

  /**
   * Validate the passed {@link TransportExecutionPlanType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan)
  {
    return validateTransportExecutionPlan (aTransportExecutionPlan).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportExecutionPlanRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest)
  {
    return UBL21Marshaller.validateUBLObject (aTransportExecutionPlanRequest,
                                              EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN_REQUEST);
  }

  /**
   * Validate the passed {@link TransportExecutionPlanRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest)
  {
    return validateTransportExecutionPlanRequest (aTransportExecutionPlanRequest).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportProgressStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus)
  {
    return UBL21Marshaller.validateUBLObject (aTransportProgressStatus, EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS);
  }

  /**
   * Validate the passed {@link TransportProgressStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus)
  {
    return validateTransportProgressStatus (aTransportProgressStatus).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportProgressStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest)
  {
    return UBL21Marshaller.validateUBLObject (aTransportProgressStatusRequest,
                                              EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS_REQUEST);
  }

  /**
   * Validate the passed {@link TransportProgressStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest)
  {
    return validateTransportProgressStatusRequest (aTransportProgressStatusRequest).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription)
  {
    return UBL21Marshaller.validateUBLObject (aTransportServiceDescription,
                                              EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION);
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription)
  {
    return validateTransportServiceDescription (aTransportServiceDescription).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest)
  {
    return UBL21Marshaller.validateUBLObject (aTransportServiceDescriptionRequest,
                                              EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION_REQUEST);
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest)
  {
    return validateTransportServiceDescriptionRequest (aTransportServiceDescriptionRequest).containsNoError ();
  }

  /**
   * Validate the passed {@link UnawardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification)
  {
    return UBL21Marshaller.validateUBLObject (aUnawardedNotification, EUBL21DocumentType.UNAWARDED_NOTIFICATION);
  }

  /**
   * Validate the passed {@link UnawardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification)
  {
    return validateUnawardedNotification (aUnawardedNotification).containsNoError ();
  }

  /**
   * Validate the passed {@link UtilityStatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement)
  {
    return UBL21Marshaller.validateUBLObject (aUtilityStatement, EUBL21DocumentType.UTILITY_STATEMENT);
  }

  /**
   * Validate the passed {@link UtilityStatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement)
  {
    return validateUtilityStatement (aUtilityStatement).containsNoError ();
  }

  /**
   * Validate the passed {@link WaybillType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateWaybill (@Nonnull final WaybillType aWaybill)
  {
    return UBL21Marshaller.validateUBLObject (aWaybill, EUBL21DocumentType.WAYBILL);
  }

  /**
   * Validate the passed {@link WaybillType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  public static boolean isValidWaybill (@Nonnull final WaybillType aWaybill)
  {
    return validateWaybill (aWaybill).containsNoError ();
  }
}
