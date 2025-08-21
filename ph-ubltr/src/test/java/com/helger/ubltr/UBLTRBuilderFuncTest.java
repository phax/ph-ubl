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
package com.helger.ubltr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.base.io.stream.StreamHelper;
import com.helger.diagnostics.error.list.IErrorList;
import com.helger.io.resource.ClassPathResource;
import com.helger.ubltr.UBLTRMarshaller.UBLTRJAXBMarshaller;

import tr.gov.efatura.useraccount.CancelUserAccountType;

/**
 * Test class for classes {@link UBLTRMarshaller}.
 *
 * @author Philip Helger
 */
public final class UBLTRBuilderFuncTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (UBLTRBuilderFuncTest.class);

  @Test
  public void testReadAndWriteCancelUserAccount ()
  {
    final UBLTRJAXBMarshaller <CancelUserAccountType> aMarshaller = UBLTRMarshaller.cancelUserAccount ();

    final String sFilename = MockUBLTRTestDocuments.getUBLTRTestDocuments (EUBLTRDocumentType.CANCEL_USER_ACCOUNT).get (0);

    // Read from resource
    final CancelUserAccountType aRead1 = aMarshaller.read (new ClassPathResource (sFilename));
    assertNotNull (aRead1);

    // Read from byte[]
    final CancelUserAccountType aRead2 = aMarshaller.read (StreamHelper.getAllBytes (new ClassPathResource (sFilename)));
    assertNotNull (aRead2);
    assertEquals (aRead1, aRead2);

    // Validate
    final IErrorList aREG1 = aMarshaller.validate (aRead1);
    final IErrorList aREG2 = aMarshaller.validate (aRead2);
    assertEquals (aREG1, aREG2);

    // Write
    final String sXML = aMarshaller.getAsString (aRead1);
    LOGGER.info ("Created XML:\n" + sXML);
  }
}
