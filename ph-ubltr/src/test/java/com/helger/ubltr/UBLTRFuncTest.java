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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.validation.Schema;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.diagnostics.error.list.IErrorList;
import com.helger.io.resource.ClassPathResource;
import com.helger.unittest.support.TestHelper;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;
import com.helger.xml.serialize.write.EXMLSerializeIndent;
import com.helger.xml.serialize.write.XMLWriter;
import com.helger.xml.serialize.write.XMLWriterSettings;

import tr.gov.efatura.useraccount.CancelUserAccountType;
import tr.gov.efatura.useraccount.ProcessUserAccountType;

/**
 * Some cross functionality testing
 *
 * @author Philip Helger
 */
public final class UBLTRFuncTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (UBLTRFuncTest.class);

  @Test
  public void testReadAndWriteCancelUserAccount ()
  {
    final Schema aSchema = UBLTRMarshaller.cancelUserAccount ().getSchema ();

    for (final String sFilename : MockUBLTRTestDocuments.getUBLTRTestDocuments (EUBLTRDocumentType.CANCEL_USER_ACCOUNT))
    {
      LOGGER.info ("Reading '" + sFilename + "'");

      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (aSchema));
      assertNotNull (sFilename, aDoc);
      final CancelUserAccountType aUBLObject = UBLTRMarshaller.cancelUserAccount ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBLTRMarshaller.cancelUserAccount ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBLTRMarshaller.cancelUserAccount ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final CancelUserAccountType aUBLObject2 = UBLTRMarshaller.cancelUserAccount ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBLTRMarshaller.cancelUserAccount ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBLTRMarshaller.cancelUserAccount ().validate (new CancelUserAccountType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteProcessUserAccount ()
  {
    final Schema aSchema = UBLTRMarshaller.processUserAccount ().getSchema ();

    for (final String sFilename : MockUBLTRTestDocuments.getUBLTRTestDocuments (EUBLTRDocumentType.PROCESS_USER_ACCOUNT))
    {
      LOGGER.info ("Reading '" + sFilename + "'");

      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (aSchema));
      assertNotNull (sFilename, aDoc);
      final ProcessUserAccountType aUBLObject = UBLTRMarshaller.processUserAccount ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBLTRMarshaller.processUserAccount ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBLTRMarshaller.processUserAccount ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      if (false)
        LOGGER.info (XMLWriter.getNodeAsString (aDoc2,
                                                new XMLWriterSettings ().setIndent (EXMLSerializeIndent.INDENT_AND_ALIGN)));

      // read again
      final ProcessUserAccountType aUBLObject2 = UBLTRMarshaller.processUserAccount ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBLTRMarshaller.processUserAccount ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBLTRMarshaller.processUserAccount ().validate (new ProcessUserAccountType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }
}
