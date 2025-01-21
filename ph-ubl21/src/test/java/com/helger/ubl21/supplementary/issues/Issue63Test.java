/*
 * Copyright (C) 2014-2025 Philip Helger (www.helger.com)
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

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import com.helger.commons.datetime.PDTFactory;
import com.helger.ubl21.UBL21Marshaller;
import com.helger.ubl21.UBL21Marshaller.UBL21JAXBMarshaller;

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
import oasis.names.specification.ubl.schema.xsd.commonsignaturecomponents_21.UBLDocumentSignaturesType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.signatureaggregatecomponents_21.SignatureInformationType;

public final class Issue63Test
{
  private static final Logger LOGGER = LoggerFactory.getLogger (Issue63Test.class);

  @Test
  public void testBasic ()
  {
    final String sCurrency = "SAR";

    // Create domain object
    final InvoiceType aInvoice = new InvoiceType ();

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

    // Main extension
    final UBLExtensionsType ublExtensions = new UBLExtensionsType ();
    {
      final UBLExtensionType ublExtension = new UBLExtensionType ();
      {
        final ExtensionContentType extensionContent = new ExtensionContentType ();
        {
          final UBLDocumentSignaturesType signatures = new UBLDocumentSignaturesType ();
          final SignatureInformationType signatureInfo = new SignatureInformationType ();
          signatureInfo.setID ("signatureID");
          signatures.addSignatureInformation (signatureInfo);

          // Important: convert to Element
          final Element aSignaturesElement = new UBL21JAXBMarshaller <> (UBLDocumentSignaturesType.class,
                                                                         UBL21Marshaller.getAllBaseXSDs (),
                                                                         oasis.names.specification.ubl.schema.xsd.commonsignaturecomponents_21.ObjectFactory._UBLDocumentSignatures_QNAME).getAsElement (signatures);

          extensionContent.setAny (aSignaturesElement);
          ublExtension.setExtensionURI ("urn:oasis:names:specification:ubl:dsig:enveloped:xades");
          ublExtension.setExtensionContent (extensionContent);
        }
        ublExtensions.addUBLExtension (ublExtension);
      }
      aInvoice.setUBLExtensions (ublExtensions);
    }

    // Write to string
    final UBL21JAXBMarshaller <InvoiceType> aMarshaller = UBL21Marshaller.invoice ();
    final String sInvoice = aMarshaller.setFormattedOutput (true).getAsString (aInvoice);
    assertNotNull (sInvoice);
    LOGGER.info (sInvoice);
  }
}
