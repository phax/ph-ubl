/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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

import com.helger.commons.error.IResourceErrorGroup;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.io.stream.StreamHelper;

import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;

/**
 * Test class for classes {@link UBL20ReaderBuilder},
 * {@link UBL20ValidatorBuilder} and {@link UBL20WriterBuilder}.
 *
 * @author Philip Helger
 */
public final class UBL20BuilderFuncTest
{
  @Test
  public void testReadAndWriteInvoice ()
  {
    final UBL20ReaderBuilder <InvoiceType> aReader = UBL20ReaderBuilder.create (InvoiceType.class);
    final UBL20ValidatorBuilder <InvoiceType> aValidator = UBL20ValidatorBuilder.create (InvoiceType.class);
    final UBL20WriterBuilder <InvoiceType> aWriter = UBL20WriterBuilder.create (InvoiceType.class);

    final String sFilename = MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentType.INVOICE).get (0);

    // Read from resource
    final InvoiceType aRead1 = aReader.read (new ClassPathResource (sFilename));
    assertNotNull (aRead1);

    // Read from byte[]
    final InvoiceType aRead2 = aReader.read (StreamHelper.getAllBytes (new ClassPathResource (sFilename)));
    assertNotNull (aRead2);
    assertEquals (aRead1, aRead2);

    // Validate
    final IResourceErrorGroup aREG1 = aValidator.validate (aRead1);
    final IResourceErrorGroup aREG2 = aValidator.validate (aRead2);
    assertEquals (aREG1, aREG2);

    // Write
    final String s = aWriter.writeToString (aRead1);
    System.out.println (s);
  }
}
