/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
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

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;
import org.xml.sax.SAXException;

import com.helger.commons.state.ESuccess;
import com.helger.datetime.util.PDTXMLConverter;
import com.helger.xml.serialize.read.DOMReader;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_2.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import un.unece.uncefact.codelist.specification._54217._2001.CurrencyCodeContentType;

/**
 * Create a minimal UBL 2.0 invoice from scratch.
 *
 * @author Philip Helger
 */
public final class CreateInvoiceFromScratchFuncTest
{
  @Test
  public void testCreateInvoiceFromScratch ()
  {
    final CurrencyCodeContentType eCurrency = CurrencyCodeContentType.EUR;

    final InvoiceType aInvoice = new InvoiceType ();
    aInvoice.setID ("Dummy Invoice number");
    aInvoice.setIssueDate (PDTXMLConverter.getXMLCalendarDateNow ());

    final SupplierPartyType aSupplier = new SupplierPartyType ();
    aInvoice.setAccountingSupplierParty (aSupplier);

    final CustomerPartyType aCustomer = new CustomerPartyType ();
    aInvoice.setAccountingCustomerParty (aCustomer);

    final MonetaryTotalType aMT = new MonetaryTotalType ();
    aMT.setPayableAmount (BigDecimal.TEN).setCurrencyID (eCurrency);
    aInvoice.setLegalMonetaryTotal (aMT);

    final InvoiceLineType aLine = new InvoiceLineType ();
    aLine.setID ("1");

    final ItemType aItem = new ItemType ();
    aLine.setItem (aItem);

    aLine.setLineExtensionAmount (BigDecimal.TEN).setCurrencyID (eCurrency);

    aInvoice.addInvoiceLine (aLine);

    final ESuccess eSuccess = UBL20Writer.invoice ().write (aInvoice, new File ("target/dummy-invoice.xml"));
    assertTrue (eSuccess.isSuccess ());
  }

  @Test
  public void testCreateInvoiceFromScratchWithCustomNamespace () throws SAXException
  {
    final CurrencyCodeContentType eCurrency = CurrencyCodeContentType.EUR;

    final InvoiceType aInvoice = new InvoiceType ();
    aInvoice.setID ("Dummy Invoice number");
    aInvoice.setIssueDate (PDTXMLConverter.getXMLCalendarDateNow ());

    final SupplierPartyType aSupplier = new SupplierPartyType ();
    aInvoice.setAccountingSupplierParty (aSupplier);

    final CustomerPartyType aCustomer = new CustomerPartyType ();
    aInvoice.setAccountingCustomerParty (aCustomer);

    final MonetaryTotalType aMT = new MonetaryTotalType ();
    aMT.setPayableAmount (BigDecimal.TEN).setCurrencyID (eCurrency);
    aInvoice.setLegalMonetaryTotal (aMT);

    final InvoiceLineType aLine = new InvoiceLineType ();
    aLine.setID ("1");

    final ItemType aItem = new ItemType ();
    aLine.setItem (aItem);

    aLine.setLineExtensionAmount (BigDecimal.TEN).setCurrencyID (eCurrency);

    aInvoice.addInvoiceLine (aLine);

    // Add extension
    final UBLExtensionsType aExtensions = new UBLExtensionsType ();
    final UBLExtensionType aExtension = new UBLExtensionType ();
    final ExtensionContentType aExtensionContent = new ExtensionContentType ();
    aExtensionContent.setAny (DOMReader.readXMLDOM ("<root xmlns='urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1'>test</root>")
                                       .getDocumentElement ());
    aExtension.setExtensionContent (aExtensionContent);
    aExtensions.addUBLExtension (aExtension);
    aInvoice.setUBLExtensions (aExtensions);

    final ESuccess eSuccess = UBL20Writer.invoice ().write (aInvoice, new File ("target/dummy-invoice-with-ext.xml"));
    assertTrue (eSuccess.isSuccess ());
  }
}
