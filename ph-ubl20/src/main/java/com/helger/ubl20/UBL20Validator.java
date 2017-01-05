/**
 * Copyright (C) 2014-2017 Philip Helger (www.helger.com)
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
package com.helger.ubl20;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;

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

/**
 * Validate all UBL 2.0 document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL20Validator
{
  @PresentForCodeCoverage
  private static final UBL20Validator s_aInstance = new UBL20Validator ();

  private UBL20Validator ()
  {}

  /**
   * Create a validation builder for ApplicationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL20ValidatorBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a validation builder for AttachedDocument.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL20ValidatorBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Create a validation builder for BillOfLading.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL20ValidatorBuilder.create (BillOfLadingType.class);
  }

  /**
   * Create a validation builder for Catalogue.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CatalogueType> catalogue ()
  {
    return UBL20ValidatorBuilder.create (CatalogueType.class);
  }

  /**
   * Create a validation builder for CatalogueDeletion.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL20ValidatorBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Create a validation builder for CatalogueItemSpecificationUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL20ValidatorBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Create a validation builder for CataloguePricingUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL20ValidatorBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Create a validation builder for CatalogueRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL20ValidatorBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Create a validation builder for CertificateOfOrigin.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL20ValidatorBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Create a validation builder for CreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CreditNoteType> creditNote ()
  {
    return UBL20ValidatorBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a validation builder for DebitNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <DebitNoteType> debitNote ()
  {
    return UBL20ValidatorBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a validation builder for DespatchAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL20ValidatorBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Create a validation builder for ForwardingInstructions.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL20ValidatorBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Create a validation builder for FreightInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL20ValidatorBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Create a validation builder for Invoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <InvoiceType> invoice ()
  {
    return UBL20ValidatorBuilder.create (InvoiceType.class);
  }

  /**
   * Create a validation builder for Order.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <OrderType> order ()
  {
    return UBL20ValidatorBuilder.create (OrderType.class);
  }

  /**
   * Create a validation builder for OrderCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL20ValidatorBuilder.create (OrderCancellationType.class);
  }

  /**
   * Create a validation builder for OrderChange.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <OrderChangeType> orderChange ()
  {
    return UBL20ValidatorBuilder.create (OrderChangeType.class);
  }

  /**
   * Create a validation builder for OrderResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <OrderResponseType> orderResponse ()
  {
    return UBL20ValidatorBuilder.create (OrderResponseType.class);
  }

  /**
   * Create a validation builder for OrderResponseSimple.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL20ValidatorBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Create a validation builder for PackingList.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <PackingListType> packingList ()
  {
    return UBL20ValidatorBuilder.create (PackingListType.class);
  }

  /**
   * Create a validation builder for Quotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <QuotationType> quotation ()
  {
    return UBL20ValidatorBuilder.create (QuotationType.class);
  }

  /**
   * Create a validation builder for ReceiptAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL20ValidatorBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Create a validation builder for Reminder.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <ReminderType> reminder ()
  {
    return UBL20ValidatorBuilder.create (ReminderType.class);
  }

  /**
   * Create a validation builder for RemittanceAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL20ValidatorBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Create a validation builder for RequestForQuotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL20ValidatorBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Create a validation builder for SelfBilledCreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL20ValidatorBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Create a validation builder for SelfBilledInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL20ValidatorBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Create a validation builder for Statement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <StatementType> statement ()
  {
    return UBL20ValidatorBuilder.create (StatementType.class);
  }

  /**
   * Create a validation builder for TransportationStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL20ValidatorBuilder.create (TransportationStatusType.class);
  }

  /**
   * Create a validation builder for Waybill.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <WaybillType> waybill ()
  {
    return UBL20ValidatorBuilder.create (WaybillType.class);
  }
}
