/**
 * Copyright (C) 2014-2021 Philip Helger (www.helger.com)
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
package com.helger.ublpe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.helger.commons.error.list.IErrorList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.io.stream.StreamHelper;

import sunat.names.specification.ubl.peru.schema.xsd.summarydocuments_1.SummaryDocumentsType;

/**
 * Test class for classes {@link UBLPEReaderBuilder},
 * {@link UBLPEValidatorBuilder} and {@link UBLPEWriterBuilder}.
 *
 * @author Philip Helger
 */
public final class UBLPEBuilderFuncTest
{
  @Test
  public void testReadAndWriteSummaryDocuments ()
  {
    final UBLPEReaderBuilder <SummaryDocumentsType> aReader = new UBLPEReaderBuilder <> (SummaryDocumentsType.class);
    final UBLPEValidatorBuilder <SummaryDocumentsType> aValidator = new UBLPEValidatorBuilder <> (SummaryDocumentsType.class);
    final UBLPEWriterBuilder <SummaryDocumentsType> aWriter = new UBLPEWriterBuilder <> (SummaryDocumentsType.class).setFormattedOutput (true);

    final String sFilename = MockUBLPETestDocuments.getUBLPETestDocuments (EUBLPEDocumentType.SUMMARY_DOCUMENTS).getFirst ();
    assertNotNull (sFilename);

    // Read from resource
    final SummaryDocumentsType aRead1 = aReader.read (new ClassPathResource (sFilename));
    assertNotNull (aRead1);

    // Read from byte[]
    final SummaryDocumentsType aRead2 = aReader.read (StreamHelper.getAllBytes (new ClassPathResource (sFilename)));
    assertNotNull (aRead2);
    assertEquals (aRead1, aRead2);

    // Validate
    final IErrorList aREG1 = aValidator.validate (aRead1);
    final IErrorList aREG2 = aValidator.validate (aRead2);
    assertEquals (aREG1, aREG2);

    // Write
    final String s = aWriter.getAsString (aRead1);
    System.out.println (s);
  }
}
