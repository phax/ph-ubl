/*
 * Copyright (C) 2014-2024 Philip Helger (www.helger.com)
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
package com.helger.ubl20.helper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.BillingReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CreditNoteLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DeliveryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.DocumentReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.LineReferenceType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SignatureType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CreditedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InvoicedQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

/**
 * Some helper methods based on Invoice data types.
 *
 * @author Philip Helger
 * @since 6.1.3
 */
@Immutable
public final class UBL20InvoiceHelper
{
  private UBL20InvoiceHelper ()
  {}

  /**
   * @param aSrc
   *        Source {@link InvoicedQuantityType}
   * @return The created {@link CreditedQuantityType}
   */
  @Nonnull
  public static CreditedQuantityType cloneToCreditedQuantity (@Nonnull final InvoicedQuantityType aSrc)
  {
    final CreditedQuantityType ret = new CreditedQuantityType ();
    aSrc.cloneTo (ret);
    return ret;
  }

  /**
   * Clone an {@link InvoiceLineType} to a {@link CreditNoteLineType}. No values
   * or signs or anything is changed.
   *
   * @param aSrc
   *        Source invoice line. May not be <code>null</code>.
   * @param aDst
   *        Destination credit note line. May not be <code>null</code>.
   */
  public static void cloneToCreditNoteLine (@Nonnull final InvoiceLineType aSrc, @Nonnull final CreditNoteLineType aDst)
  {
    aDst.setAccountingCost (aSrc.getAccountingCost () == null ? null : aSrc.getAccountingCost ().clone ());
    aDst.setAccountingCostCode (aSrc.getAccountingCostCode () == null ? null : aSrc.getAccountingCostCode ().clone ());
    // Not present
    /*
     * { final List <AllowanceChargeType> retAllowanceCharge = new ArrayList <>
     * (); for (final AllowanceChargeType aItem : src.getAllowanceCharge ())
     * retAllowanceCharge.add (aItem == null ? null : aItem.clone ());
     * ret.setAllowanceCharge (retAllowanceCharge); }
     */
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
    // Not present
    /*
     * ret.setDeliveryTerms (src.getDeliveryTerms () == null ? null :
     * src.getDeliveryTerms ().clone ());
     */
    {
      final List <LineReferenceType> retDespatchLineReference = new ArrayList <> ();
      for (final LineReferenceType aItem : aSrc.getDespatchLineReference ())
        retDespatchLineReference.add (aItem == null ? null : aItem.clone ());
      aDst.setDespatchLineReference (retDespatchLineReference);
    }
    {
      final List <DocumentReferenceType> retDocumentReference = new ArrayList <> ();
      for (final DocumentReferenceType aItem : aSrc.getDocumentReference ())
        retDocumentReference.add (aItem == null ? null : aItem.clone ());
      aDst.setDocumentReference (retDocumentReference);
    }
    // Not present
    /*
     * ret.setFreeOfChargeIndicator (src.getFreeOfChargeIndicator () == null ?
     * null : src.getFreeOfChargeIndicator ().clone ());
     */
    aDst.setID (aSrc.getID () == null ? null : aSrc.getID ().clone ());
    // Name change
    aDst.setCreditedQuantity (aSrc.getInvoicedQuantity () == null ? null : cloneToCreditedQuantity (aSrc.getInvoicedQuantity ()));
    aDst.setItem (aSrc.getItem () == null ? null : aSrc.getItem ().clone ());
    aDst.setLineExtensionAmount (aSrc.getLineExtensionAmount () == null ? null : aSrc.getLineExtensionAmount ().clone ());
    aDst.setNote (aSrc.getNote () == null ? null : aSrc.getNote ().clone ());
    // Not present
    /*
     * { final List <OrderLineReferenceType> retOrderLineReference = new
     * ArrayList <> (); for (final OrderLineReferenceType aItem :
     * src.getOrderLineReference ()) retOrderLineReference.add (aItem == null ?
     * null : aItem.clone ()); ret.setOrderLineReference
     * (retOrderLineReference); }
     */
    // Not present
    /*
     * ret.setOriginatorParty (src.getOriginatorParty () == null ? null :
     * src.getOriginatorParty ().clone ());
     */
    // Not present
    /*
     * { final List <PaymentTermsType> retPaymentTerms = new ArrayList <> ();
     * for (final PaymentTermsType aItem : src.getPaymentTerms ())
     * retPaymentTerms.add (aItem == null ? null : aItem.clone ());
     * ret.setPaymentTerms (retPaymentTerms); }
     */
    aDst.setPrice (aSrc.getPrice () == null ? null : aSrc.getPrice ().clone ());
    aDst.setPricingReference (aSrc.getPricingReference () == null ? null : aSrc.getPricingReference ().clone ());
    {
      final List <LineReferenceType> retReceiptLineReference = new ArrayList <> ();
      for (final LineReferenceType aItem : aSrc.getReceiptLineReference ())
        retReceiptLineReference.add (aItem == null ? null : aItem.clone ());
      aDst.setReceiptLineReference (retReceiptLineReference);
    }
    aDst.setTaxPointDate (aSrc.getTaxPointDate () == null ? null : aSrc.getTaxPointDate ().clone ());
    {
      final List <TaxTotalType> retTaxTotal = new ArrayList <> ();
      for (final TaxTotalType aItem : aSrc.getTaxTotal ())
        retTaxTotal.add (aItem == null ? null : aItem.clone ());
      aDst.setTaxTotal (retTaxTotal);
    }
    aDst.setUUID (aSrc.getUUID () == null ? null : aSrc.getUUID ().clone ());
  }

  /**
   * Clone an {@link InvoiceType} to a {@link CreditNoteType}. No values or
   * signs or anything is changed.
   *
   * @param aSrc
   *        Source invoice. May not be <code>null</code>.
   * @param aDst
   *        Destination credit note. May not be <code>null</code>.
   */
  public static void cloneInvoiceToCreditNote (@Nonnull final InvoiceType aSrc, @Nonnull final CreditNoteType aDst)
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
    // Not present
    /*
     * ret.setBuyerCustomerParty (src.getBuyerCustomerParty () == null ? null :
     * src.getBuyerCustomerParty ().clone ());
     */
    {
      final List <DocumentReferenceType> retContractDocumentReference = new ArrayList <> ();
      for (final DocumentReferenceType aItem : aSrc.getContractDocumentReference ())
        retContractDocumentReference.add (aItem == null ? null : aItem.clone ());
      aDst.setContractDocumentReference (retContractDocumentReference);
    }
    aDst.setCopyIndicator (aSrc.getCopyIndicator () == null ? null : aSrc.getCopyIndicator ().clone ());
    aDst.setCustomizationID (aSrc.getCustomizationID () == null ? null : aSrc.getCustomizationID ().clone ());
    // Not present
    /*
     * { final List <DeliveryType> retDelivery = new ArrayList <> (); for (final
     * DeliveryType aItem : src.getDelivery ()) retDelivery.add (aItem == null ?
     * null : aItem.clone ()); ret.setDelivery (retDelivery); }
     */
    // Not present
    /*
     * ret.setDeliveryTerms (src.getDeliveryTerms () == null ? null :
     * src.getDeliveryTerms ().clone ());´
     */
    {
      final List <DocumentReferenceType> retDespatchDocumentReference = new ArrayList <> ();
      for (final DocumentReferenceType aItem : aSrc.getDespatchDocumentReference ())
        retDespatchDocumentReference.add (aItem == null ? null : aItem.clone ());
      aDst.setDespatchDocumentReference (retDespatchDocumentReference);
    }
    // DiscrepancyResponse is not present in Invoice
    aDst.setDocumentCurrencyCode (aSrc.getDocumentCurrencyCode () == null ? null : aSrc.getDocumentCurrencyCode ().clone ());
    aDst.setID (aSrc.getID () == null ? null : aSrc.getID ().clone ());
    // Name change
    {
      final List <CreditNoteLineType> retInvoiceLine = new ArrayList <> ();
      for (final InvoiceLineType aItem : aSrc.getInvoiceLine ())
        if (aItem == null)
          retInvoiceLine.add (null);
        else
        {
          final CreditNoteLineType aNewLine = new CreditNoteLineType ();
          cloneToCreditNoteLine (aItem, aNewLine);
          retInvoiceLine.add (aNewLine);
        }
      aDst.setCreditNoteLine (retInvoiceLine);
    }
    {
      final List <PeriodType> retInvoicePeriod = new ArrayList <> ();
      for (final PeriodType aItem : aSrc.getInvoicePeriod ())
      {
        retInvoicePeriod.add (aItem == null ? null : aItem.clone ());
      }
      aDst.setInvoicePeriod (retInvoicePeriod);
    }
    // Not present
    /*
     * ret.setInvoiceTypeCode (src.getInvoiceTypeCode () == null ? null :
     * src.getInvoiceTypeCode ().clone ());
     */
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
    // Not present
    /*
     * { final List <DocumentReferenceType> retOriginatorDocumentReference = new
     * ArrayList <> (); for (final DocumentReferenceType aItem :
     * src.getOriginatorDocumentReference ()) retOriginatorDocumentReference.add
     * (aItem == null ? null : aItem.clone ());
     * ret.setOriginatorDocumentReference (retOriginatorDocumentReference); }
     */
    aDst.setPayeeParty (aSrc.getPayeeParty () == null ? null : aSrc.getPayeeParty ().clone ());
    aDst.setPaymentAlternativeCurrencyCode (aSrc.getPaymentAlternativeCurrencyCode () == null ? null
                                                                                              : aSrc.getPaymentAlternativeCurrencyCode ()
                                                                                                    .clone ());
    aDst.setPaymentAlternativeExchangeRate (aSrc.getPaymentAlternativeExchangeRate () == null ? null
                                                                                              : aSrc.getPaymentAlternativeExchangeRate ()
                                                                                                    .clone ());
    aDst.setPaymentCurrencyCode (aSrc.getPaymentCurrencyCode () == null ? null : aSrc.getPaymentCurrencyCode ().clone ());
    aDst.setPaymentExchangeRate (aSrc.getPaymentExchangeRate () == null ? null : aSrc.getPaymentExchangeRate ().clone ());
    // Not present
    /*
     * { final List <PaymentMeansType> retPaymentMeans = new ArrayList <> ();
     * for (final PaymentMeansType aItem : src.getPaymentMeans ())
     * retPaymentMeans.add (aItem == null ? null : aItem.clone ());
     * ret.setPaymentMeans (retPaymentMeans); }
     */
    // Not present
    /*
     * { final List <PaymentTermsType> retPaymentTerms = new ArrayList <> ();
     * for (final PaymentTermsType aItem : src.getPaymentTerms ())
     * retPaymentTerms.add (aItem == null ? null : aItem.clone ());
     * ret.setPaymentTerms (retPaymentTerms); }
     */
    // Not present
    /*
     * { final List <PaymentType> retPrepaidPayment = new ArrayList <> (); for
     * (final PaymentType aItem : src.getPrepaidPayment ())
     * retPrepaidPayment.add (aItem == null ? null : aItem.clone ());
     * ret.setPrepaidPayment (retPrepaidPayment); }
     */
    aDst.setPricingCurrencyCode (aSrc.getPricingCurrencyCode () == null ? null : aSrc.getPricingCurrencyCode ().clone ());
    aDst.setPricingExchangeRate (aSrc.getPricingExchangeRate () == null ? null : aSrc.getPricingExchangeRate ().clone ());
    aDst.setProfileID (aSrc.getProfileID () == null ? null : aSrc.getProfileID ().clone ());
    {
      final List <DocumentReferenceType> retReceiptDocumentReference = new ArrayList <> ();
      for (final DocumentReferenceType aItem : aSrc.getReceiptDocumentReference ())
        retReceiptDocumentReference.add (aItem == null ? null : aItem.clone ());
      aDst.setReceiptDocumentReference (retReceiptDocumentReference);
    }
    // Not present
    /*
     * ret.setSellerSupplierParty (src.getSellerSupplierParty () == null ? null
     * : src.getSellerSupplierParty ().clone ());
     */
    {
      final List <SignatureType> retSignature = new ArrayList <> ();
      for (final SignatureType aItem : aSrc.getSignature ())
        retSignature.add (aItem == null ? null : aItem.clone ());
      aDst.setSignature (retSignature);
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
  }
}
