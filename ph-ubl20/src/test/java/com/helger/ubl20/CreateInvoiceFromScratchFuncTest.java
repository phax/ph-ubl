package com.helger.ubl20;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;

import com.helger.commons.state.ESuccess;
import com.helger.datetime.util.PDTXMLConverter;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.SupplierPartyType;
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
}
