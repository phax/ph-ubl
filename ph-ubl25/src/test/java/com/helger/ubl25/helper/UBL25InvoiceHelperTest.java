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
package com.helger.ubl25.helper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.diagnostics.error.list.IErrorList;
import com.helger.io.resource.ClassPathResource;
import com.helger.ubl25.EUBL25DocumentType;
import com.helger.ubl25.MockUBL25TestDocuments;
import com.helger.ubl25.UBL25Marshaller;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;

import oasis.names.specification.ubl.schema.xsd.creditnote_25.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_25.InvoiceType;

/**
 * Test class for class {@link UBL25InvoiceHelper}.
 *
 * @author Philip Helger
 */
public final class UBL25InvoiceHelperTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (UBL25InvoiceHelperTest.class);

  @Test
  public void testComvertBackAndForth ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.INVOICE))
    {
      LOGGER.info (sFilename);

      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.invoice ().getSchema ()));
      assertNotNull (sFilename, aDoc);
      final InvoiceType aUBLObject = UBL25Marshaller.invoice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Convert Invoice to CreditNote
      final CreditNoteType aCreditNote = new CreditNoteType ();
      UBL25InvoiceHelper.cloneInvoiceToCreditNote (aUBLObject, aCreditNote);

      // Validate CreditNote
      IErrorList aErrors = UBL25Marshaller.creditNote ().validate (aCreditNote);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // Convert CreditNote back to Invoice
      final InvoiceType aInvoice2 = new InvoiceType ();
      UBL25CreditNoteHelper.cloneCreditNoteToInvoice (aCreditNote, aInvoice2);

      // Validate Invoice again
      aErrors = UBL25Marshaller.invoice ().validate (aInvoice2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }
  }
}
