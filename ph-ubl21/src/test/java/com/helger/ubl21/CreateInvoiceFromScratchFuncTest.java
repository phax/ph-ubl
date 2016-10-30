package com.helger.ubl21;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;

import com.helger.commons.state.ESuccess;
import com.helger.datetime.util.PDTXMLConverter;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CustomerPartyType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.InvoiceLineType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.ItemType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.MonetaryTotalType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.SupplierPartyType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

public class CreateInvoiceFromScratchFuncTest
{
  @Test
  public void testCreateInvoiceFromScratch ()
  {
    final String sCurrency = "EUR";

    final InvoiceType aInvoice = new InvoiceType ();
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

    final ESuccess eSuccess = UBL21Writer.invoice ().write (aInvoice, new File ("target/dummy-invoice.xml"));
    assertTrue (eSuccess.isSuccess ());
  }
}
