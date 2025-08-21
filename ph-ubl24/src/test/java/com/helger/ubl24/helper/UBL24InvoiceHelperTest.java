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
package com.helger.ubl24.helper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.diagnostics.error.list.IErrorList;
import com.helger.io.resource.ClassPathResource;
import com.helger.ubl24.EUBL24DocumentType;
import com.helger.ubl24.MockUBL24TestDocuments;
import com.helger.ubl24.UBL24Marshaller;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;

import oasis.names.specification.ubl.schema.xsd.creditnote_24.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_24.InvoiceType;

/**
 * Test class for class {@link UBL24InvoiceHelper}.
 *
 * @author Philip Helger
 */
public final class UBL24InvoiceHelperTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (UBL24InvoiceHelperTest.class);

  @Test
  public void testComvertBackAndForth ()
  {
    for (final String sFilename : MockUBL24TestDocuments.getUBL24TestDocuments (EUBL24DocumentType.INVOICE))
    {
      LOGGER.info (sFilename);

      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL24Marshaller.invoice ().getSchema ()));
      assertNotNull (sFilename, aDoc);
      final InvoiceType aUBLObject = UBL24Marshaller.invoice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Convert Invoice to CreditNote
      final CreditNoteType aCreditNote = new CreditNoteType ();
      UBL24InvoiceHelper.cloneInvoiceToCreditNote (aUBLObject, aCreditNote);

      // Validate CreditNote
      IErrorList aErrors = UBL24Marshaller.creditNote ().validate (aCreditNote);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // Convert CreditNote back to Invoice
      final InvoiceType aInvoice2 = new InvoiceType ();
      UBL24CreditNoteHelper.cloneCreditNoteToInvoice (aCreditNote, aInvoice2);

      // Validate Invoice again
      aErrors = UBL24Marshaller.invoice ().validate (aInvoice2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }
  }
}
