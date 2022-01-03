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
package com.helger.ubl23.helper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.commons.error.list.IErrorList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.ubl23.EUBL23DocumentType;
import com.helger.ubl23.MockUBL23TestDocuments;
import com.helger.ubl23.UBL23Reader;
import com.helger.ubl23.UBL23Validator;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;

import oasis.names.specification.ubl.schema.xsd.creditnote_23.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_23.InvoiceType;

/**
 * Test class for class {@link UBL23InvoiceHelper}.
 *
 * @author Philip Helger
 */
public final class UBL23InvoiceHelperTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (UBL23InvoiceHelperTest.class);

  @Test
  public void testComvertBackAndForth ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.INVOICE))
    {
      LOGGER.info (sFilename);

      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.INVOICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final InvoiceType aUBLObject = UBL23Reader.invoice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Convert Invoice to CreditNote
      final CreditNoteType aCreditNote = new CreditNoteType ();
      UBL23InvoiceHelper.cloneInvoiceToCreditNote (aUBLObject, aCreditNote);

      // Validate CreditNote
      IErrorList aErrors = UBL23Validator.creditNote ().validate (aCreditNote);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // Convert CreditNote back to Invoice
      final InvoiceType aInvoice2 = new InvoiceType ();
      UBL23CreditNoteHelper.cloneCreditNoteToInvoice (aCreditNote, aInvoice2);

      // Validate Invoice again
      aErrors = UBL23Validator.invoice ().validate (aInvoice2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }
  }
}
