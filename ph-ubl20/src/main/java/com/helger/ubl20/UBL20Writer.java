/**
 * Copyright (C) 2014-2019 Philip Helger (www.helger.com)
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
 * Write all UBL 2.0 document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL20Writer
{
  @PresentForCodeCoverage
  private static final UBL20Writer s_aInstance = new UBL20Writer ();

  private UBL20Writer ()
  {}

  /**
   * Create a writer builder for ApplicationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL20WriterBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a writer builder for AttachedDocument.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL20WriterBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Create a writer builder for BillOfLading.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL20WriterBuilder.create (BillOfLadingType.class);
  }

  /**
   * Create a writer builder for Catalogue.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CatalogueType> catalogue ()
  {
    return UBL20WriterBuilder.create (CatalogueType.class);
  }

  /**
   * Create a writer builder for CatalogueDeletion.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL20WriterBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Create a writer builder for CatalogueItemSpecificationUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL20WriterBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Create a writer builder for CataloguePricingUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL20WriterBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Create a writer builder for CatalogueRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL20WriterBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Create a writer builder for CertificateOfOrigin.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL20WriterBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Create a writer builder for CreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <CreditNoteType> creditNote ()
  {
    return UBL20WriterBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a writer builder for DebitNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <DebitNoteType> debitNote ()
  {
    return UBL20WriterBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a writer builder for DespatchAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL20WriterBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Create a writer builder for ForwardingInstructions.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL20WriterBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Create a writer builder for FreightInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL20WriterBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Create a writer builder for Invoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <InvoiceType> invoice ()
  {
    return UBL20WriterBuilder.create (InvoiceType.class);
  }

  /**
   * Create a writer builder for Order.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <OrderType> order ()
  {
    return UBL20WriterBuilder.create (OrderType.class);
  }

  /**
   * Create a writer builder for OrderCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL20WriterBuilder.create (OrderCancellationType.class);
  }

  /**
   * Create a writer builder for OrderChange.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <OrderChangeType> orderChange ()
  {
    return UBL20WriterBuilder.create (OrderChangeType.class);
  }

  /**
   * Create a writer builder for OrderResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <OrderResponseType> orderResponse ()
  {
    return UBL20WriterBuilder.create (OrderResponseType.class);
  }

  /**
   * Create a writer builder for OrderResponseSimple.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL20WriterBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Create a writer builder for PackingList.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <PackingListType> packingList ()
  {
    return UBL20WriterBuilder.create (PackingListType.class);
  }

  /**
   * Create a writer builder for Quotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <QuotationType> quotation ()
  {
    return UBL20WriterBuilder.create (QuotationType.class);
  }

  /**
   * Create a writer builder for ReceiptAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL20WriterBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Create a writer builder for Reminder.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <ReminderType> reminder ()
  {
    return UBL20WriterBuilder.create (ReminderType.class);
  }

  /**
   * Create a writer builder for RemittanceAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL20WriterBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Create a writer builder for RequestForQuotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL20WriterBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Create a writer builder for SelfBilledCreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL20WriterBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Create a writer builder for SelfBilledInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL20WriterBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Create a writer builder for Statement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <StatementType> statement ()
  {
    return UBL20WriterBuilder.create (StatementType.class);
  }

  /**
   * Create a writer builder for TransportationStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL20WriterBuilder.create (TransportationStatusType.class);
  }

  /**
   * Create a writer builder for Waybill.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20WriterBuilder <WaybillType> waybill ()
  {
    return UBL20WriterBuilder.create (WaybillType.class);
  }
}
