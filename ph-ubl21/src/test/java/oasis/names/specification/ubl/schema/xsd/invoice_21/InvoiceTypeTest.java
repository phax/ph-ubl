package oasis.names.specification.ubl.schema.xsd.invoice_21;

import org.junit.Test;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.MonetaryTotalType;

public final class InvoiceTypeTest
{
  @Test
  public void testInvoiceType ()
  {
    final InvoiceType aInvoice = new InvoiceType ();
    final MonetaryTotalType aMTT = aInvoice.getLegalMonetaryTotal ();
    if (aMTT != null)
    {
      // Ensure the "Amount getter" is created
      // TODO
      // aMTT.getTaxInclusiveAmountValue ();
    }
  }
}
