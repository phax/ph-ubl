/*
 * Copyright (C) 2026 Philip Helger (www.helger.com)
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
package com.helger.hrubl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import javax.xml.validation.Schema;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.junit.Test;
import org.w3c.dom.Document;

import com.helger.base.enforce.ValueEnforcer;
import com.helger.base.io.stream.StreamHelper;
import com.helger.base.state.ESuccess;
import com.helger.diagnostics.error.list.IErrorList;
import com.helger.io.resource.ClassPathResource;
import com.helger.unittest.support.TestHelper;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;

import hr.gov.mfin.schema.xsd.hrextensionaggregatecomponents_1.HRFISK20DataType;
import hr.gov.mfin.schema.xsd.hrextensionaggregatecomponents_1.HRObracunPDVPoNaplatiType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

/**
 * Test class for reading and writing Croatian UBL documents.
 */
public final class HrUblFuncTest
{
  private static final String CASH_BASIS_TEXT = "Obračun po naplaćenoj naknadi";

  /**
   * @return The first Croatian extension in the passed extensions or <code>null</code> if there is none.
   */
  @Nullable
  private static HRFISK20DataType _getHrExtension (@Nullable final UBLExtensionsType aExtensions)
  {
    if (aExtensions != null)
      for (final UBLExtensionType aExtension : aExtensions.getUBLExtension ())
        if (aExtension.getExtensionContent () != null)
        {
          final HRFISK20DataType ret = HrUblHelper.getHrExtension (aExtension.getExtensionContent ());
          if (ret != null)
            return ret;
        }
    return null;
  }

  @NonNull
  private static Document _readDocument (@NonNull final String sFilename, @NonNull final Schema aSchema)
  {
    final Document ret = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                               new DOMReaderSettings ().setSchema (aSchema));
    assertNotNull (sFilename, ret);
    return ret;
  }

  @Test
  public void testReadAndWriteInvoices ()
  {
    final Schema aSchema = HrUblMarshaller.invoice ().getSchema ();
    assertNotNull (aSchema);

    for (final String sFilename : MockHrUblTestDocuments.getHrUblTestDocuments (EHrUblDocumentType.INVOICE))
    {
      // Read
      final Document aDoc = _readDocument (sFilename, aSchema);
      final InvoiceType aUblObject = HrUblMarshaller.invoice ().read (aDoc);
      assertNotNull (sFilename, aUblObject);

      // Validate
      IErrorList aErrors = HrUblMarshaller.invoice ().validate (aUblObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename + ": " + aErrors.toString (), aErrors.containsAtLeastOneError ());

      // All of them have the Croatian extension
      final HRFISK20DataType aHr = _getHrExtension (aUblObject.getUBLExtensions ());
      assertNotNull (sFilename, aHr);

      // write again
      final Document aDoc2 = HrUblMarshaller.invoice ().getAsDocument (aUblObject);
      assertNotNull (sFilename, aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final InvoiceType aUblObject2 = HrUblMarshaller.invoice ().read (aDoc2);
      assertNotNull (sFilename, aUblObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUblObject, aUblObject2);
      assertEquals (sFilename, aHr, _getHrExtension (aUblObject2.getUBLExtensions ()));

      // Validate
      aErrors = HrUblMarshaller.invoice ().validate (aUblObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // An empty invoice is invalid
    final IErrorList aErrors = HrUblMarshaller.invoice ().validate (new InvoiceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteCreditNotes ()
  {
    final Schema aSchema = HrUblMarshaller.creditNote ().getSchema ();
    assertNotNull (aSchema);

    for (final String sFilename : MockHrUblTestDocuments.getHrUblTestDocuments (EHrUblDocumentType.CREDIT_NOTE))
    {
      // Read
      final Document aDoc = _readDocument (sFilename, aSchema);
      final CreditNoteType aUblObject = HrUblMarshaller.creditNote ().read (aDoc);
      assertNotNull (sFilename, aUblObject);

      // Validate
      final IErrorList aErrors = HrUblMarshaller.creditNote ().validate (aUblObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename + ": " + aErrors.toString (), aErrors.containsAtLeastOneError ());

      // This credit note has only the document signature extension
      assertNull (sFilename, _getHrExtension (aUblObject.getUBLExtensions ()));

      // write and read again
      final Document aDoc2 = HrUblMarshaller.creditNote ().getAsDocument (aUblObject);
      assertNotNull (sFilename, aDoc2);
      final CreditNoteType aUblObject2 = HrUblMarshaller.creditNote ().read (aDoc2);
      assertNotNull (sFilename, aUblObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUblObject, aUblObject2);
    }
  }

  @Test
  public void testExtensionValues ()
  {
    {
      // Only the cash basis statement
      final InvoiceType aInvoice = HrUblMarshaller.invoice ()
                                                  .read (new ClassPathResource (MockHrUblTestDocuments.INVOICE_CASH_BASIS));
      assertNotNull (aInvoice);
      final HRFISK20DataType aHr = _getHrExtension (aInvoice.getUBLExtensions ());
      assertNotNull (aHr);
      assertEquals (CASH_BASIS_TEXT, aHr.getHRObracunPDVPoNaplati ().getValue ());
      assertNull (aHr.getHRTaxTotal ());
      assertNull (aHr.getHRLegalMonetaryTotal ());
    }
    {
      // Tax total and out of scope of VAT amount
      final InvoiceType aInvoice = HrUblMarshaller.invoice ()
                                                  .read (new ClassPathResource ("external/test-hr/eRacun-PDV25 i Neoporeziva naknada-trosak.xml"));
      assertNotNull (aInvoice);
      final HRFISK20DataType aHr = _getHrExtension (aInvoice.getUBLExtensions ());
      assertNotNull (aHr);
      assertNull (aHr.getHRObracunPDVPoNaplati ());

      assertEquals (0, new BigDecimal ("25.00").compareTo (aHr.getHRTaxTotal ().getTaxAmount ().getValue ()));
      assertEquals (2, aHr.getHRTaxTotal ().getHRTaxSubtotalCount ());
      assertEquals ("S", aHr.getHRTaxTotal ().getHRTaxSubtotalAtIndex (0).getHRTaxCategory ().getID ().getValue ());
      assertEquals ("HR:PDV25",
                    aHr.getHRTaxTotal ().getHRTaxSubtotalAtIndex (0).getHRTaxCategory ().getName ().getValue ());
      assertEquals ("O", aHr.getHRTaxTotal ().getHRTaxSubtotalAtIndex (1).getHRTaxCategory ().getID ().getValue ());
      assertEquals ("HR:N",
                    aHr.getHRTaxTotal ().getHRTaxSubtotalAtIndex (1).getHRTaxCategory ().getName ().getValue ());

      assertEquals (0,
                    new BigDecimal ("100.00").compareTo (aHr.getHRLegalMonetaryTotal ()
                                                            .getTaxExclusiveAmount ()
                                                            .getValue ()));
      assertEquals (0,
                    new BigDecimal ("10.00").compareTo (aHr.getHRLegalMonetaryTotal ()
                                                           .getOutOfScopeOfVATAmount ()
                                                           .getValue ()));
    }
  }

  @Test
  public void testReadInstanceAndAddExtension ()
  {
    final InvoiceType aInvoice = HrUblMarshaller.invoice ()
                                                .read (new ClassPathResource (MockHrUblTestDocuments.INVOICE_CASH_BASIS));
    assertNotNull (aInvoice);

    // Replace the existing extensions
    final HRFISK20DataType aHr = new HRFISK20DataType ();
    final HRObracunPDVPoNaplatiType aCashBasis = new HRObracunPDVPoNaplatiType ();
    aCashBasis.setValue (CASH_BASIS_TEXT);
    aHr.setHRObracunPDVPoNaplati (aCashBasis);

    final ExtensionContentType aExtContent = new ExtensionContentType ();
    assertNull (HrUblHelper.getHrExtension (aExtContent));
    assertSame (ESuccess.SUCCESS, HrUblHelper.setHrExtension (aExtContent, aHr));
    final UBLExtensionType aExtension = new UBLExtensionType ();
    aExtension.setExtensionContent (aExtContent);
    final UBLExtensionsType aExtensions = new UBLExtensionsType ();
    aExtensions.addUBLExtension (aExtension);
    aInvoice.setUBLExtensions (aExtensions);

    // Write and read again
    final String sXml = HrUblMarshaller.invoice ().setFormattedOutput (true).getAsString (aInvoice);
    assertNotNull (sXml);
    assertTrue (sXml, sXml.contains ("<hrextac:HRFISK20Data"));
    final InvoiceType aInvoice2 = HrUblMarshaller.invoice ().read (sXml);
    assertNotNull (aInvoice2);
    assertEquals (aHr, _getHrExtension (aInvoice2.getUBLExtensions ()));
  }

  @Test
  public void testInvalidExtensionIsRejected ()
  {
    final String sOriginal = new String (StreamHelper.getAllBytes (new ClassPathResource (MockHrUblTestDocuments.INVOICE_CASH_BASIS)),
                                         StandardCharsets.UTF_8);
    ValueEnforcer.isTrue (sOriginal.contains ("HRObracunPDVPoNaplati"), "Test file changed");
    assertNotNull (HrUblMarshaller.invoice ().read (sOriginal));

    // An unknown element in the Croatian extension must be detected
    final String sBroken = sOriginal.replace ("HRObracunPDVPoNaplati", "HRUnknownElement");
    assertNull (HrUblMarshaller.invoice ().read (sBroken));
  }
}
