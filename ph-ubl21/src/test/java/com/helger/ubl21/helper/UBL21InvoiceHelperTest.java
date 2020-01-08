/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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
package com.helger.ubl21.helper;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.commons.error.list.IErrorList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.ubl21.EUBL21DocumentType;
import com.helger.ubl21.MockUBL21TestDocuments;
import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Validator;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;

import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

/**
 * Test class for class {@link UBL21InvoiceHelper}.
 *
 * @author Philip Helger
 */
public final class UBL21InvoiceHelperTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (UBL21InvoiceHelperTest.class);

  @Test
  public void testComvertBackAndForth ()
  {
    for (final String sFilename : MockUBL21TestDocuments.getUBL21TestDocuments (EUBL21DocumentType.INVOICE))
    {
      LOGGER.info (sFilename);

      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.INVOICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final InvoiceType aUBLObject = UBL21Reader.invoice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Convert Invoice to CreditNote
      final CreditNoteType aCreditNote = new CreditNoteType ();
      UBL21InvoiceHelper.cloneInvoiceToCreditNote (aUBLObject, aCreditNote);

      // Validate CreditNote
      IErrorList aErrors = UBL21Validator.creditNote ().validate (aCreditNote);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // Convert CreditNote back to Invoice
      final InvoiceType aInvoice2 = new InvoiceType ();
      UBL21CreditNoteHelper.cloneCreditNoteToInvoice (aCreditNote, aInvoice2);

      // Validate Invoice again
      aErrors = UBL21Validator.invoice ().validate (aInvoice2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }
  }
}
