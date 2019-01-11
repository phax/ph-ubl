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
package com.helger.ubl21;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.helger.commons.state.ESuccess;
import com.helger.datetime.util.PDTXMLConverter;
import com.helger.xml.XMLFactory;
import com.helger.xml.namespace.MapBasedNamespaceContext;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxSchemeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxSubtotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IDType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

/**
 * Create a minimal UBL 2.1 invoice from scratch.
 *
 * @author Philip Helger
 */
public final class CreateInvoiceFromScratchFuncTest
{
  @Test
  public void testCreateInvoiceFromScratch ()
  {
    final String sCurrency = "EUR";

    // Create domain object
    final InvoiceType aInvoice = new InvoiceType ();

    // Fill it
    aInvoice.setID ("Dummy Invoice number");
    aInvoice.setIssueDate (PDTXMLConverter.getXMLCalendarDateNow ());

    final SupplierPartyType aSupplier = new SupplierPartyType ();
    aInvoice.setAccountingSupplierParty (aSupplier);

    final CustomerPartyType aCustomer = new CustomerPartyType ();
    aInvoice.setAccountingCustomerParty (aCustomer);

    final MonetaryTotalType aMT = new MonetaryTotalType ();
    aMT.setPayableAmount (BigDecimal.TEN).setCurrencyID (sCurrency);
    aInvoice.setLegalMonetaryTotal (aMT);

    final InvoiceLineType aLine = new InvoiceLineType ();
    aLine.setID ("1");

    final ItemType aItem = new ItemType ();
    aLine.setItem (aItem);

    aLine.setLineExtensionAmount (BigDecimal.TEN).setCurrencyID (sCurrency);

    aInvoice.addInvoiceLine (aLine);

    // Add some TaxTotal
    /**
     * <pre>
    <cac:TaxSubtotal>
      <cbc:TaxableAmount currencyID="EUR">10.00</cbc:TaxableAmount>
      <cbc:TaxAmount currencyID="EUR">10.00</cbc:TaxAmount>
      <cac:TaxCategory>
        <cbc:ID schemeID="UNCL5305" schemeAgencyID="6">Z</cbc:ID>
        <cbc:Percent>10.00</cbc:Percent>
        <cac:TaxScheme>
          <cbc:ID schemeAgencyID="6" schemeID="UN/ECE 5153">VAT</cbc:ID>
        </cac:TaxScheme>
      </cac:TaxCategory>
    </cac:TaxSubtotal>
     * </pre>
     */
    {
      final TaxSubtotalType aTaxSubtotal = new TaxSubtotalType ();
      aTaxSubtotal.setTaxableAmount (BigDecimal.TEN).setCurrencyID (sCurrency);
      aTaxSubtotal.setTaxAmount (BigDecimal.TEN).setCurrencyID (sCurrency);

      final TaxCategoryType aTaxCategory = new TaxCategoryType ();
      final IDType aTCID = new IDType ();
      aTCID.setSchemeID ("UNCL5305");
      aTCID.setSchemeAgencyID ("6");
      aTCID.setValue ("Z");
      aTaxCategory.setID (aTCID);

      aTaxCategory.setPercent (BigDecimal.TEN);

      final TaxSchemeType aTaxScheme = new TaxSchemeType ();
      final IDType aTSID = new IDType ();
      aTSID.setSchemeID ("UNCL5305");
      aTSID.setSchemeAgencyID ("6");
      aTSID.setValue ("VAT");
      aTaxScheme.setID (aTSID);
      aTaxCategory.setTaxScheme (aTaxScheme);

      aTaxSubtotal.setTaxCategory (aTaxCategory);

      final TaxTotalType aTaxTotal = new TaxTotalType ();
      aTaxTotal.setTaxAmount (BigDecimal.TEN).setCurrencyID (sCurrency);
      aTaxTotal.addTaxSubtotal (aTaxSubtotal);
      aInvoice.addTaxTotal (aTaxTotal);
    }

    // Write to disk
    final ESuccess eSuccess = UBL21Writer.invoice ().write (aInvoice, new File ("target/dummy-invoice.xml"));
    assertTrue (eSuccess.isSuccess ());
  }

  /**
   * This is an example that creates an XML schema compliant invoice <b>AND</b>
   * adds an extension as requested in issue #10
   */
  @Test
  public void testCreateInvoiceFromScratchWithExtension ()
  {
    final String sCurrency = "EUR";

    // Create domain object
    final InvoiceType aInvoice = new InvoiceType ();

    // Fill it
    aInvoice.setID ("Dummy Invoice number");
    aInvoice.setIssueDate (PDTXMLConverter.getXMLCalendarDateNow ());

    final SupplierPartyType aSupplier = new SupplierPartyType ();
    aInvoice.setAccountingSupplierParty (aSupplier);

    final CustomerPartyType aCustomer = new CustomerPartyType ();
    aInvoice.setAccountingCustomerParty (aCustomer);

    final MonetaryTotalType aMT = new MonetaryTotalType ();
    aMT.setPayableAmount (BigDecimal.TEN).setCurrencyID (sCurrency);
    aInvoice.setLegalMonetaryTotal (aMT);

    final InvoiceLineType aLine = new InvoiceLineType ();
    aLine.setID ("1");

    final ItemType aItem = new ItemType ();
    aLine.setItem (aItem);

    aLine.setLineExtensionAmount (BigDecimal.TEN).setCurrencyID (sCurrency);

    aInvoice.addInvoiceLine (aLine);

    // Example extension content from issue #10:
    /**
     * <pre>
       <aife:FactureExtension xmlns:aife="urn:AIFE:Facture:Extension">
         <aife:CategoryCode>XX</aife:CategoryCode>
       </aife:FactureExtension>
     * </pre>
     */
    final Document aDoc = XMLFactory.newDocument ();
    final String sNamespaceURI = "urn:AIFE:Facture:Extension";
    final Node eRoot = aDoc.appendChild (aDoc.createElementNS (sNamespaceURI, "FactureExtension"));
    final Node eCategoryCode = eRoot.appendChild (aDoc.createElementNS (sNamespaceURI, "CategoryCode"));
    eCategoryCode.appendChild (aDoc.createTextNode ("XX"));

    // Now add the extension
    final UBLExtensionsType aExtensions = new UBLExtensionsType ();
    final UBLExtensionType aExtension = new UBLExtensionType ();
    final ExtensionContentType aExtensionContent = new ExtensionContentType ();
    // Add the root element - NEVER use the whole document!
    aExtensionContent.setAny (aDoc.getDocumentElement ());
    aExtension.setExtensionContent (aExtensionContent);
    aExtensions.addUBLExtension (aExtension);
    aInvoice.setUBLExtensions (aExtensions);

    // Write to disk ("as is")
    ESuccess eSuccess = UBL21Writer.invoice ().write (aInvoice, new File ("target/dummy-invoice-with-extension.xml"));
    assertTrue (eSuccess.isSuccess ());

    // doesn't work as expected yet
    if (false)
    {
      // Write to disk with a custom namespace prefix mapping
      final UBL21WriterBuilder <InvoiceType> aBuilder = UBL21Writer.invoice ();
      final MapBasedNamespaceContext aCtx = (MapBasedNamespaceContext) aBuilder.getNamespaceContext ();
      aCtx.addMapping ("aife", sNamespaceURI);
      eSuccess = aBuilder.write (aInvoice, new File ("target/dummy-invoice-with-extension-and-ns.xml"));
      assertTrue (eSuccess.isSuccess ());
    }
  }
}
