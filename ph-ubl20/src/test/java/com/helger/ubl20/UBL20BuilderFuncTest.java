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
package com.helger.ubl20;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.helger.base.io.stream.StreamHelper;
import com.helger.diagnostics.error.list.IErrorList;
import com.helger.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

/**
 * Test class for classes {@link UBL20Marshaller}.
 *
 * @author Philip Helger
 */
public final class UBL20BuilderFuncTest
{
  @Test
  public void testReadAndWriteInvoice ()
  {
    final GenericJAXBMarshaller <InvoiceType> aMarshaller = UBL20Marshaller.invoice ();

    final String sFilename = MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentType.INVOICE).get (0);

    // Read from resource
    final InvoiceType aRead1 = aMarshaller.read (new ClassPathResource (sFilename));
    assertNotNull (aRead1);

    // Read from byte[]
    final InvoiceType aRead2 = aMarshaller.read (StreamHelper.getAllBytes (new ClassPathResource (sFilename)));
    assertNotNull (aRead2);
    assertEquals (aRead1, aRead2);

    // Validate
    final IErrorList aREG1 = aMarshaller.validate (aRead1);
    final IErrorList aREG2 = aMarshaller.validate (aRead2);
    assertEquals (aREG1, aREG2);

    // Write
    final String s = aMarshaller.getAsString (aRead1);
    System.out.println (s);
  }
}
