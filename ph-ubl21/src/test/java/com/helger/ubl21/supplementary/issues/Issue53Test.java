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
package com.helger.ubl21.supplementary.issues;

import java.math.BigDecimal;

import org.junit.Test;

import com.helger.commons.datetime.PDTFactory;
import com.helger.ubl21.CUBL21;
import com.helger.ubl21.UBL21Writer;
import com.helger.ubl21.UBL21WriterBuilder;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.xmldsig.CXMLDSig;

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
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public final class Issue53Test
{
  @Test
  public void testBasic ()
  {
    final String sCurrency = "SAR";

    // Create domain object
    final InvoiceType aInvoice = new InvoiceType ();

    // aInvoice.setUBLExtensions( ublExtensionsType );

    // Fill it
    aInvoice.setID ("Dummy Invoice number");
    aInvoice.setIssueDate (PDTFactory.getCurrentXMLOffsetDateUTC ());

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

    final UBL21WriterBuilder <InvoiceType> typeUBL21WriterBuilder = UBL21Writer.invoice ();

    final MapBasedNamespaceContext aNSContext = new MapBasedNamespaceContext ();
    aNSContext.addDefaultNamespaceURI ("urn:oasis:names:specification:ubl:schema:xsd:Invoice-2");
    aNSContext.addMapping ("cac", CUBL21.XML_SCHEMA_CAC_NAMESPACE_URL);
    aNSContext.addMapping ("cbc", CUBL21.XML_SCHEMA_CBC_NAMESPACE_URL);
    aNSContext.addMapping ("cec", CUBL21.XML_SCHEMA_CEC_NAMESPACE_URL);
    aNSContext.addMapping ("ds", CXMLDSig.NAMESPACE_URI);

    // typeUBL21WriterBuilder.setMarshallerCustomizer( GenericJAXBMarshaller )
    typeUBL21WriterBuilder.setNamespaceContext (aNSContext);
    // typeUBL21WriterBuilder.getMarshallerCustomizer()

    // Write to disk
    final String sInvoice = typeUBL21WriterBuilder.setUseSchema (true).setFormattedOutput (true).getAsString (aInvoice);
    System.out.println (sInvoice);
  }
}
