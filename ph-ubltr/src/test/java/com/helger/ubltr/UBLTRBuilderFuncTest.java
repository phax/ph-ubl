/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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
package com.helger.ubltr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.helger.commons.error.IResourceErrorGroup;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.io.stream.StreamHelper;

import tr.gov.efatura.useraccount.CancelUserAccountType;

/**
 * Test class for classes {@link UBLTRReaderBuilder},
 * {@link UBLTRValidatorBuilder} and {@link UBLTRWriterBuilder}.
 *
 * @author Philip Helger
 */
public final class UBLTRBuilderFuncTest
{
  @Test
  public void testReadAndWriteCancelUserAccount ()
  {
    final UBLTRReaderBuilder <CancelUserAccountType> aReader = UBLTRReaderBuilder.create (CancelUserAccountType.class);
    final UBLTRValidatorBuilder <CancelUserAccountType> aValidator = UBLTRValidatorBuilder.create (CancelUserAccountType.class);
    final UBLTRWriterBuilder <CancelUserAccountType> aWriter = new UBLTRWriterBuilder <CancelUserAccountType> (CancelUserAccountType.class).setFormattedOutput (true);

    final String sFilename = MockUBLTRTestDocuments.getUBLTRTestDocuments (EUBLTRDocumentType.CANCEL_USER_ACCOUNT)
                                                   .get (0);

    // Read from resource
    final CancelUserAccountType aRead1 = aReader.read (new ClassPathResource (sFilename));
    assertNotNull (aRead1);

    // Read from byte[]
    final CancelUserAccountType aRead2 = aReader.read (StreamHelper.getAllBytes (new ClassPathResource (sFilename)));
    assertNotNull (aRead2);
    assertEquals (aRead1, aRead2);

    // Validate
    final IResourceErrorGroup aREG1 = aValidator.validate (aRead1);
    final IResourceErrorGroup aREG2 = aValidator.validate (aRead2);
    assertEquals (aREG1, aREG2);

    // Write
    final String s = aWriter.getAsString (aRead1);
    System.out.println (s);
  }
}
