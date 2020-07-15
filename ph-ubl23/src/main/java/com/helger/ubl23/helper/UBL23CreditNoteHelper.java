/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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
package com.helger.ubl23.helper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.BillingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.DeliveryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.LineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.OrderLineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.PaymentTermsType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.ProjectReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.SignatureType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_23.CreditNoteTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_23.CreditedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_23.InvoiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_23.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_23.NoteType;
import oasis.names.specification.ubl.schema.xsd.creditnote_23.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_23.InvoiceType;

/**
 * Some helper methods based on Credit Note data types.
 *
 * @author Philip Helger
 */
@Immutable
public final class UBL23CreditNoteHelper
{
  private UBL23CreditNoteHelper ()
  {}

  /**
   * @param aSrc
   *        Source {@link CreditedQuantityType}
   * @return The created {@link InvoicedQuantityType}
   */
  @Nonnull
  public static InvoicedQuantityType cloneToInvoicedQuantity (@Nonnull final CreditedQuantityType aSrc)
  {
    final InvoicedQuantityType ret = new InvoicedQuantityType ();
    aSrc.cloneTo (ret);
    return ret;
  }

  /**
   * @param aSrc
   *        Source {@link CreditNoteTypeCodeType}
   * @return The created {@link InvoiceTypeCodeType}
   */
  @Nullable
  public static InvoiceTypeCodeType cloneToInvoiceTypeCode (@Nullable final CreditNoteTypeCodeType aSrc)
  {
    if (aSrc == null)
      return null;
    final InvoiceTypeCodeType ret = new InvoiceTypeCodeType ();
    aSrc.cloneTo (ret);
    return ret;
  }

  /**
   * Clone an {@link CreditNoteLineType} to a {@link InvoiceLineType}. No values
   * or signs or anything is changed.
   *
   * @param aSrc
   *        Source credit note line. May not be <code>null</code>.
   * @param aDst
   *        Destination invoice line. May not be <code>null</code>.
   */
  public static void cloneToInvoiceLine (@Nonnull final CreditNoteLineType aSrc, @Nonnull final InvoiceLineType aDst)
  {
    aDst.setAccountingCost (aSrc.getAccountingCost () == null ? null : aSrc.getAccountingCost ().clone ());
    aDst.setAccountingCostCode (aSrc.getAccountingCostCode () == null ? null : aSrc.getAccountingCostCode ().clone ());
    {
      final List <AllowanceChargeType> retAllowanceCharge = new ArrayList <> ();
      for (final AllowanceChargeType aItem : aSrc.getAllowanceCharge ())
        retAllowanceCharge.add (aItem == null ? null : aItem.clone ());
      aDst.setAllowanceCharge (retAllowanceCharge);
    }
    {
      final List <BillingReferenceType> retBillingReference = new ArrayList <> ();
      for (final BillingReferenceType aItem : aSrc.getBillingReference ())
        retBillingReference.add (aItem == null ? null : aItem.clone ());
      aDst.setBillingReference (retBillingReference);
    }
    {
      final List <DeliveryType> retDelivery = new ArrayList <> ();
      for (final DeliveryType aItem : aSrc.getDelivery ())
        retDelivery.add (aItem == null ? null : aItem.clone ());
      aDst.setDelivery (retDelivery);
    }
    // n:1
    aDst.setDeliveryTerms (aSrc.hasDeliveryTermsEntries () ? aSrc.getDeliveryTermsAtIndex (0).clone () : null);
    {
      final List <LineReferenceType> retDespatchLineReference = new ArrayList <> ();
      for (final LineReferenceType aItem : aSrc.getDespatchLineReference ())
        retDespatchLineReference.add (aItem == null ? null : aItem.clone ());
      aDst.setDespatchLineReference (retDespatchLineReference);
    }
    // Not in Invoice
    /*
     * { final List <ResponseType> retDiscrepancyResponse = new ArrayList <> ();
     * for (final ResponseType aItem : aSrc.getDiscrepancyResponse ())
     * retDiscrepancyResponse.add (aItem == null ? null : aItem.clone ());
     * aDst.setDiscrepancyResponse (retDiscrepancyResponse); }
     */
    {
      final List <DocumentReferenceType> retDocumentReference = new ArrayList <> ();
      for (final DocumentReferenceType aItem : aSrc.getDocumentReference ())
        retDocumentReference.add (aItem == null ? null : aItem.clone ());
      aDst.setDocumentReference (retDocumentReference);
    }
    aDst.setFreeOfChargeIndicator (aSrc.getFreeOfChargeIndicator () == null ? null : aSrc.getFreeOfChargeIndicator ().clone ());
    aDst.setID (aSrc.getID () == null ? null : aSrc.getID ().clone ());
    {
      final List <PeriodType> retInvoicePeriod = new ArrayList <> ();
      for (final PeriodType aItem : aSrc.getInvoicePeriod ())
        retInvoicePeriod.add (aItem == null ? null : aItem.clone ());
      aDst.setInvoicePeriod (retInvoicePeriod);
    }
    // Name change
    aDst.setInvoicedQuantity (aSrc.getCreditedQuantity () == null ? null : cloneToInvoicedQuantity (aSrc.getCreditedQuantity ()));
    aDst.setItem (aSrc.getItem () == null ? null : aSrc.getItem ().clone ());
    aDst.setItemPriceExtension (aSrc.getItemPriceExtension () == null ? null : aSrc.getItemPriceExtension ().clone ());
    aDst.setLineExtensionAmount (aSrc.getLineExtensionAmount () == null ? null : aSrc.getLineExtensionAmount ().clone ());
    {
      final List <NoteType> retNote = new ArrayList <> ();
      for (final NoteType aItem : aSrc.getNote ())
        retNote.add (aItem == null ? null : aItem.clone ());
      aDst.setNote (retNote);
    }
    {
      final List <OrderLineReferenceType> retOrderLineReference = new ArrayList <> ();
      for (final OrderLineReferenceType aItem : aSrc.getOrderLineReference ())
        retOrderLineReference.add (aItem == null ? null : aItem.clone ());
      aDst.setOrderLineReference (retOrderLineReference);
    }
    aDst.setOriginatorParty (aSrc.getOriginatorParty () == null ? null : aSrc.getOriginatorParty ().clone ());
    aDst.setPaymentPurposeCode (aSrc.getPaymentPurposeCode () == null ? null : aSrc.getPaymentPurposeCode ().clone ());
    {
      final List <PaymentTermsType> retPaymentTerms = new ArrayList <> ();
      for (final PaymentTermsType aItem : aSrc.getPaymentTerms ())
        retPaymentTerms.add (aItem == null ? null : aItem.clone ());
      aDst.setPaymentTerms (retPaymentTerms);
    }
    aDst.setPrice (aSrc.getPrice () == null ? null : aSrc.getPrice ().clone ());
    aDst.setPricingReference (aSrc.getPricingReference () == null ? null : aSrc.getPricingReference ().clone ());
    {
      final List <LineReferenceType> retReceiptLineReference = new ArrayList <> ();
      for (final LineReferenceType aItem : aSrc.getReceiptLineReference ())
        retReceiptLineReference.add (aItem == null ? null : aItem.clone ());
      aDst.setReceiptLineReference (retReceiptLineReference);
    }
    // Name change
    {
      final List <InvoiceLineType> retSubLine = new ArrayList <> ();
      for (final CreditNoteLineType aItem : aSrc.getSubCreditNoteLine ())
        if (aItem == null)
          retSubLine.add (null);
        else
        {
          final InvoiceLineType aDstItem = new InvoiceLineType ();
          cloneToInvoiceLine (aItem, aDstItem);
          retSubLine.add (aDstItem);
        }
      aDst.setSubInvoiceLine (retSubLine);
    }
    aDst.setTaxInclusiveLineExtensionAmount (aSrc.getTaxInclusiveLineExtensionAmount () == null ? null
                                                                                                : aSrc.getTaxInclusiveLineExtensionAmount ()
                                                                                                      .clone ());
    aDst.setTaxPointDate (aSrc.getTaxPointDate () == null ? null : aSrc.getTaxPointDate ().clone ());
    {
      final List <TaxTotalType> retTaxTotal = new ArrayList <> ();
      for (final TaxTotalType aItem : aSrc.getTaxTotal ())
        retTaxTotal.add (aItem == null ? null : aItem.clone ());
      aDst.setTaxTotal (retTaxTotal);
    }
    aDst.setUBLExtensions (aSrc.getUBLExtensions () == null ? null : aSrc.getUBLExtensions ().clone ());
    aDst.setUUID (aSrc.getUUID () == null ? null : aSrc.getUUID ().clone ());
  }

  /**
   * Clone a {@link CreditNoteType} to an {@link InvoiceType}. No values or
   * signs or anything is changed.
   *
   * @param aSrc
   *        Source credit note. May not be <code>null</code>.
   * @param aDst
   *        Destination invoice. May not be <code>null</code>.
   */
  public static void cloneCreditNoteToInvoice (@Nonnull final CreditNoteType aSrc, @Nonnull final InvoiceType aDst)
  {
    aDst.setAccountingCost (aSrc.getAccountingCost () == null ? null : aSrc.getAccountingCost ().clone ());
    aDst.setAccountingCostCode (aSrc.getAccountingCostCode () == null ? null : aSrc.getAccountingCostCode ().clone ());
    aDst.setAccountingCustomerParty (aSrc.getAccountingCustomerParty () == null ? null : aSrc.getAccountingCustomerParty ().clone ());
    aDst.setAccountingSupplierParty (aSrc.getAccountingSupplierParty () == null ? null : aSrc.getAccountingSupplierParty ().clone ());
    {
      final List <DocumentReferenceType> retAdditionalDocumentReference = new ArrayList <> ();
      for (final DocumentReferenceType aItem : aSrc.getAdditionalDocumentReference ())
        retAdditionalDocumentReference.add (aItem == null ? null : aItem.clone ());
      aDst.setAdditionalDocumentReference (retAdditionalDocumentReference);
    }
    {
      final List <AllowanceChargeType> retAllowanceCharge = new ArrayList <> ();
      for (final AllowanceChargeType aItem : aSrc.getAllowanceCharge ())
        retAllowanceCharge.add (aItem == null ? null : aItem.clone ());
      aDst.setAllowanceCharge (retAllowanceCharge);
    }
    {
      final List <BillingReferenceType> retBillingReference = new ArrayList <> ();
      for (final BillingReferenceType aItem : aSrc.getBillingReference ())
        retBillingReference.add (aItem == null ? null : aItem.clone ());
      aDst.setBillingReference (retBillingReference);
    }
    aDst.setBuyerCustomerParty (aSrc.getBuyerCustomerParty () == null ? null : aSrc.getBuyerCustomerParty ().clone ());
    {
      final List <DocumentReferenceType> retContractDocumentReference = new ArrayList <> ();
      for (final DocumentReferenceType aItem : aSrc.getContractDocumentReference ())
        retContractDocumentReference.add (aItem == null ? null : aItem.clone ());
      aDst.setContractDocumentReference (retContractDocumentReference);
    }
    aDst.setCopyIndicator (aSrc.getCopyIndicator () == null ? null : aSrc.getCopyIndicator ().clone ());
    aDst.setCustomizationID (aSrc.getCustomizationID () == null ? null : aSrc.getCustomizationID ().clone ());
    {
      final List <DeliveryType> retDelivery = new ArrayList <> ();
      for (final DeliveryType aItem : aSrc.getDelivery ())
        retDelivery.add (aItem == null ? null : aItem.clone ());
      aDst.setDelivery (retDelivery);
    }
    // n:1
    aDst.setDeliveryTerms (aSrc.hasDeliveryTermsEntries () ? aSrc.getDeliveryTermsAtIndex (0).clone () : null);
    {
      final List <DocumentReferenceType> retDespatchDocumentReference = new ArrayList <> ();
      for (final DocumentReferenceType aItem : aSrc.getDespatchDocumentReference ())
        retDespatchDocumentReference.add (aItem == null ? null : aItem.clone ());
      aDst.setDespatchDocumentReference (retDespatchDocumentReference);
    }
    // DiscrepancyResponse is not present in Invoice
    /*
     * { final List <ResponseType> retDiscrepancyResponse = new ArrayList <> ();
     * for (final ResponseType aItem : src.getDiscrepancyResponse ())
     * retDiscrepancyResponse.add (aItem == null ? null : aItem.clone ());
     * ret.setDiscrepancyResponse (retDiscrepancyResponse); }
     */
    aDst.setDocumentCurrencyCode (aSrc.getDocumentCurrencyCode () == null ? null : aSrc.getDocumentCurrencyCode ().clone ());
    aDst.setDueDate (aSrc.getDueDate () == null ? null : aSrc.getDueDate ().clone ());
    aDst.setID (aSrc.getID () == null ? null : aSrc.getID ().clone ());
    // Name change
    {
      final List <InvoiceLineType> retInvoiceLine = new ArrayList <> ();
      for (final CreditNoteLineType aItem : aSrc.getCreditNoteLine ())
        if (aItem == null)
          retInvoiceLine.add (null);
        else
        {
          final InvoiceLineType aNewLine = new InvoiceLineType ();
          cloneToInvoiceLine (aItem, aNewLine);
          retInvoiceLine.add (aNewLine);
        }
      aDst.setInvoiceLine (retInvoiceLine);
    }
    {
      final List <PeriodType> retInvoicePeriod = new ArrayList <> ();
      for (final PeriodType aItem : aSrc.getInvoicePeriod ())
        retInvoicePeriod.add (aItem == null ? null : aItem.clone ());
      aDst.setInvoicePeriod (retInvoicePeriod);
    }
    // Name change
    aDst.setInvoiceTypeCode (cloneToInvoiceTypeCode (aSrc.getCreditNoteTypeCode ()));
    aDst.setIssueDate (aSrc.getIssueDate () == null ? null : aSrc.getIssueDate ().clone ());
    aDst.setIssueTime (aSrc.getIssueTime () == null ? null : aSrc.getIssueTime ().clone ());
    aDst.setLegalMonetaryTotal (aSrc.getLegalMonetaryTotal () == null ? null : aSrc.getLegalMonetaryTotal ().clone ());
    aDst.setLineCountNumeric (aSrc.getLineCountNumeric () == null ? null : aSrc.getLineCountNumeric ().clone ());
    {
      final List <NoteType> retNote = new ArrayList <> ();
      for (final NoteType aItem : aSrc.getNote ())
        retNote.add (aItem == null ? null : aItem.clone ());
      aDst.setNote (retNote);
    }
    aDst.setOrderReference (aSrc.getOrderReference () == null ? null : aSrc.getOrderReference ().clone ());
    {
      final List <DocumentReferenceType> retOriginatorDocumentReference = new ArrayList <> ();
      for (final DocumentReferenceType aItem : aSrc.getOriginatorDocumentReference ())
        retOriginatorDocumentReference.add (aItem == null ? null : aItem.clone ());
      aDst.setOriginatorDocumentReference (retOriginatorDocumentReference);
    }
    aDst.setPayeeParty (aSrc.getPayeeParty () == null ? null : aSrc.getPayeeParty ().clone ());
    aDst.setPaymentAlternativeCurrencyCode (aSrc.getPaymentAlternativeCurrencyCode () == null ? null
                                                                                              : aSrc.getPaymentAlternativeCurrencyCode ()
                                                                                                    .clone ());
    aDst.setPaymentAlternativeExchangeRate (aSrc.getPaymentAlternativeExchangeRate () == null ? null
                                                                                              : aSrc.getPaymentAlternativeExchangeRate ()
                                                                                                    .clone ());
    aDst.setPaymentCurrencyCode (aSrc.getPaymentCurrencyCode () == null ? null : aSrc.getPaymentCurrencyCode ().clone ());
    aDst.setPaymentExchangeRate (aSrc.getPaymentExchangeRate () == null ? null : aSrc.getPaymentExchangeRate ().clone ());
    {
      final List <PaymentMeansType> retPaymentMeans = new ArrayList <> ();
      for (final PaymentMeansType aItem : aSrc.getPaymentMeans ())
        retPaymentMeans.add (aItem == null ? null : aItem.clone ());
      aDst.setPaymentMeans (retPaymentMeans);
    }
    {
      final List <PaymentTermsType> retPaymentTerms = new ArrayList <> ();
      for (final PaymentTermsType aItem : aSrc.getPaymentTerms ())
        retPaymentTerms.add (aItem == null ? null : aItem.clone ());
      aDst.setPaymentTerms (retPaymentTerms);
    }
    // Not in CreditNote
    /*
     * { final List <PaymentType> retPrepaidPayment = new ArrayList <> (); for
     * (final PaymentType aItem : src.getPrepaidPayment ())
     * retPrepaidPayment.add (aItem == null ? null : aItem.clone ());
     * ret.setPrepaidPayment (retPrepaidPayment); }
     */
    aDst.setPricingCurrencyCode (aSrc.getPricingCurrencyCode () == null ? null : aSrc.getPricingCurrencyCode ().clone ());
    aDst.setPricingExchangeRate (aSrc.getPricingExchangeRate () == null ? null : aSrc.getPricingExchangeRate ().clone ());
    aDst.setProfileExecutionID (aSrc.getProfileExecutionID () == null ? null : aSrc.getProfileExecutionID ().clone ());
    aDst.setProfileID (aSrc.getProfileID () == null ? null : aSrc.getProfileID ().clone ());
    {
      final List <ProjectReferenceType> retProjectReference = new ArrayList <> ();
      for (final ProjectReferenceType aItem : aSrc.getProjectReference ())
        retProjectReference.add (aItem == null ? null : aItem.clone ());
      aDst.setProjectReference (retProjectReference);
    }
    {
      final List <DocumentReferenceType> retReceiptDocumentReference = new ArrayList <> ();
      for (final DocumentReferenceType aItem : aSrc.getReceiptDocumentReference ())
        retReceiptDocumentReference.add (aItem == null ? null : aItem.clone ());
      aDst.setReceiptDocumentReference (retReceiptDocumentReference);
    }
    aDst.setSellerSupplierParty (aSrc.getSellerSupplierParty () == null ? null : aSrc.getSellerSupplierParty ().clone ());
    {
      final List <SignatureType> retSignature = new ArrayList <> ();
      for (final SignatureType aItem : aSrc.getSignature ())
        retSignature.add (aItem == null ? null : aItem.clone ());
      aDst.setSignature (retSignature);
    }
    {
      final List <DocumentReferenceType> retStatementDocument = new ArrayList <> ();
      for (final DocumentReferenceType aItem : aSrc.getStatementDocumentReference ())
        retStatementDocument.add (aItem == null ? null : aItem.clone ());
      aDst.setStatementDocumentReference (retStatementDocument);
    }
    aDst.setTaxCurrencyCode (aSrc.getTaxCurrencyCode () == null ? null : aSrc.getTaxCurrencyCode ().clone ());
    aDst.setTaxExchangeRate (aSrc.getTaxExchangeRate () == null ? null : aSrc.getTaxExchangeRate ().clone ());
    aDst.setTaxPointDate (aSrc.getTaxPointDate () == null ? null : aSrc.getTaxPointDate ().clone ());
    aDst.setTaxRepresentativeParty (aSrc.getTaxRepresentativeParty () == null ? null : aSrc.getTaxRepresentativeParty ().clone ());
    {
      final List <TaxTotalType> retTaxTotal = new ArrayList <> ();
      for (final TaxTotalType aItem : aSrc.getTaxTotal ())
        retTaxTotal.add (aItem == null ? null : aItem.clone ());
      aDst.setTaxTotal (retTaxTotal);
    }
    aDst.setUBLExtensions (aSrc.getUBLExtensions () == null ? null : aSrc.getUBLExtensions ().clone ());
    aDst.setUBLVersionID (aSrc.getUBLVersionID () == null ? null : aSrc.getUBLVersionID ().clone ());
    aDst.setUUID (aSrc.getUUID () == null ? null : aSrc.getUUID ().clone ());
    {
      final List <TaxTotalType> retWithholdingTaxTotal = new ArrayList <> ();
      for (final TaxTotalType aItem : aSrc.getWithholdingTaxTotal ())
        retWithholdingTaxTotal.add (aItem == null ? null : aItem.clone ());
      aDst.setWithholdingTaxTotal (retWithholdingTaxTotal);
    }
  }
}
