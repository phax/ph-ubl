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
package com.helger.ubl;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_2.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.billoflading_2.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.catalogue_2.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_2.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_2.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_2.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_2.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_2.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_2.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_2.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_2.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.order_2.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_2.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_2.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_2.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_2.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_2.PackingListType;
import oasis.names.specification.ubl.schema.xsd.quotation_2.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_2.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_2.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_2.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_2.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_2.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_2.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_2.StatementType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_2.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.waybill_2.WaybillType;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.error.IResourceErrorGroup;

/**
 * Validate all UBL 2.0 document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL20Validator extends AbstractUBLDocumentMarshaller
{
  @PresentForCodeCoverage
  @SuppressWarnings ("unused")
  private static final UBL20Validator s_aInstance = new UBL20Validator ();

  private UBL20Validator ()
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
    return UBL20Marshaller.validateUBLObject (aApplicationResponse, EUBL20DocumentType.APPLICATION_RESPONSE);
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
    return UBL20Marshaller.validateUBLObject (aAttachedDocument, EUBL20DocumentType.ATTACHED_DOCUMENT);
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
   * Validate the passed {@link BillOfLadingType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateBillOfLading (@Nonnull final BillOfLadingType aBillOfLading)
  {
    return UBL20Marshaller.validateUBLObject (aBillOfLading, EUBL20DocumentType.BILL_OF_LADING);
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
   * Validate the passed {@link CatalogueType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateCatalogue (@Nonnull final CatalogueType aCatalogue)
  {
    return UBL20Marshaller.validateUBLObject (aCatalogue, EUBL20DocumentType.CATALOGUE);
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
    return UBL20Marshaller.validateUBLObject (aCatalogueDeletion, EUBL20DocumentType.CATALOGUE_DELETION);
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
    return UBL20Marshaller.validateUBLObject (aCatalogueItemSpecificationUpdate,
                                              EUBL20DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE);
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
    return UBL20Marshaller.validateUBLObject (aCataloguePricingUpdate, EUBL20DocumentType.CATALOGUE_PRICING_UPDATE);
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
    return UBL20Marshaller.validateUBLObject (aCatalogueRequest, EUBL20DocumentType.CATALOGUE_REQUEST);
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
    return UBL20Marshaller.validateUBLObject (aCertificateOfOrigin, EUBL20DocumentType.CERTIFICATE_OF_ORIGIN);
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
   * Validate the passed {@link CreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateCreditNote (@Nonnull final CreditNoteType aCreditNote)
  {
    return UBL20Marshaller.validateUBLObject (aCreditNote, EUBL20DocumentType.CREDIT_NOTE);
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
    return UBL20Marshaller.validateUBLObject (aDebitNote, EUBL20DocumentType.DEBIT_NOTE);
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
    return UBL20Marshaller.validateUBLObject (aDespatchAdvice, EUBL20DocumentType.DESPATCH_ADVICE);
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
   * Validate the passed {@link ForwardingInstructionsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions)
  {
    return UBL20Marshaller.validateUBLObject (aForwardingInstructions, EUBL20DocumentType.FORWARDING_INSTRUCTIONS);
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
    return UBL20Marshaller.validateUBLObject (aFreightInvoice, EUBL20DocumentType.FREIGHT_INVOICE);
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
   * Validate the passed {@link InvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateInvoice (@Nonnull final InvoiceType aInvoice)
  {
    return UBL20Marshaller.validateUBLObject (aInvoice, EUBL20DocumentType.INVOICE);
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
   * Validate the passed {@link OrderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateOrder (@Nonnull final OrderType aOrder)
  {
    return UBL20Marshaller.validateUBLObject (aOrder, EUBL20DocumentType.ORDER);
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
    return UBL20Marshaller.validateUBLObject (aOrderCancellation, EUBL20DocumentType.ORDER_CANCELLATION);
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
    return UBL20Marshaller.validateUBLObject (aOrderChange, EUBL20DocumentType.ORDER_CHANGE);
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
    return UBL20Marshaller.validateUBLObject (aOrderResponse, EUBL20DocumentType.ORDER_RESPONSE);
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
    return UBL20Marshaller.validateUBLObject (aOrderResponseSimple, EUBL20DocumentType.ORDER_RESPONSE_SIMPLE);
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
    return UBL20Marshaller.validateUBLObject (aPackingList, EUBL20DocumentType.PACKING_LIST);
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
   * Validate the passed {@link QuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateQuotation (@Nonnull final QuotationType aQuotation)
  {
    return UBL20Marshaller.validateUBLObject (aQuotation, EUBL20DocumentType.QUOTATION);
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
    return UBL20Marshaller.validateUBLObject (aReceiptAdvice, EUBL20DocumentType.RECEIPT_ADVICE);
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
    return UBL20Marshaller.validateUBLObject (aReminder, EUBL20DocumentType.REMINDER);
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
    return UBL20Marshaller.validateUBLObject (aRemittanceAdvice, EUBL20DocumentType.REMITTANCE_ADVICE);
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
    return UBL20Marshaller.validateUBLObject (aRequestForQuotation, EUBL20DocumentType.REQUEST_FOR_QUOTATION);
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
   * Validate the passed {@link SelfBilledCreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote)
  {
    return UBL20Marshaller.validateUBLObject (aSelfBilledCreditNote, EUBL20DocumentType.SELF_BILLED_CREDIT_NOTE);
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
    return UBL20Marshaller.validateUBLObject (aSelfBilledInvoice, EUBL20DocumentType.SELF_BILLED_INVOICE);
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
    return UBL20Marshaller.validateUBLObject (aStatement, EUBL20DocumentType.STATEMENT);
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
   * Validate the passed {@link TransportationStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus)
  {
    return UBL20Marshaller.validateUBLObject (aTransportationStatus, EUBL20DocumentType.TRANSPORTATION_STATUS);
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
   * Validate the passed {@link WaybillType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Nullable
  public static IResourceErrorGroup validateWaybill (@Nonnull final WaybillType aWaybill)
  {
    return UBL20Marshaller.validateUBLObject (aWaybill, EUBL20DocumentType.WAYBILL);
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
