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
 * Read all UBL 2.0 document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL20Reader
{
  @PresentForCodeCoverage
  private static final UBL20Reader INSTANCE = new UBL20Reader ();

  private UBL20Reader ()
  {}

  /**
   * Create a reader builder for ApplicationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL20ReaderBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a reader builder for AttachedDocument.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL20ReaderBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Create a reader builder for BillOfLading.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL20ReaderBuilder.create (BillOfLadingType.class);
  }

  /**
   * Create a reader builder for Catalogue.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CatalogueType> catalogue ()
  {
    return UBL20ReaderBuilder.create (CatalogueType.class);
  }

  /**
   * Create a reader builder for CatalogueDeletion.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL20ReaderBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Create a reader builder for CatalogueItemSpecificationUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL20ReaderBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Create a reader builder for CataloguePricingUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL20ReaderBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Create a reader builder for CatalogueRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL20ReaderBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Create a reader builder for CertificateOfOrigin.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL20ReaderBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Create a reader builder for CreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <CreditNoteType> creditNote ()
  {
    return UBL20ReaderBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a reader builder for DebitNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <DebitNoteType> debitNote ()
  {
    return UBL20ReaderBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a reader builder for DespatchAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL20ReaderBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Create a reader builder for ForwardingInstructions.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL20ReaderBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Create a reader builder for FreightInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL20ReaderBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Create a reader builder for Invoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <InvoiceType> invoice ()
  {
    return UBL20ReaderBuilder.create (InvoiceType.class);
  }

  /**
   * Create a reader builder for Order.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <OrderType> order ()
  {
    return UBL20ReaderBuilder.create (OrderType.class);
  }

  /**
   * Create a reader builder for OrderCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL20ReaderBuilder.create (OrderCancellationType.class);
  }

  /**
   * Create a reader builder for OrderChange.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <OrderChangeType> orderChange ()
  {
    return UBL20ReaderBuilder.create (OrderChangeType.class);
  }

  /**
   * Create a reader builder for OrderResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <OrderResponseType> orderResponse ()
  {
    return UBL20ReaderBuilder.create (OrderResponseType.class);
  }

  /**
   * Create a reader builder for OrderResponseSimple.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL20ReaderBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Create a reader builder for PackingList.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <PackingListType> packingList ()
  {
    return UBL20ReaderBuilder.create (PackingListType.class);
  }

  /**
   * Create a reader builder for Quotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <QuotationType> quotation ()
  {
    return UBL20ReaderBuilder.create (QuotationType.class);
  }

  /**
   * Create a reader builder for ReceiptAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL20ReaderBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Create a reader builder for Reminder.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <ReminderType> reminder ()
  {
    return UBL20ReaderBuilder.create (ReminderType.class);
  }

  /**
   * Create a reader builder for RemittanceAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL20ReaderBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Create a reader builder for RequestForQuotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL20ReaderBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Create a reader builder for SelfBilledCreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL20ReaderBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Create a reader builder for SelfBilledInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL20ReaderBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Create a reader builder for Statement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <StatementType> statement ()
  {
    return UBL20ReaderBuilder.create (StatementType.class);
  }

  /**
   * Create a reader builder for TransportationStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL20ReaderBuilder.create (TransportationStatusType.class);
  }

  /**
   * Create a reader builder for Waybill.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ReaderBuilder <WaybillType> waybill ()
  {
    return UBL20ReaderBuilder.create (WaybillType.class);
  }
}
