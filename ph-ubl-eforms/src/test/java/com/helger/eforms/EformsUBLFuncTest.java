/*
 * Copyright (C) 2021-2024 Jonatan Sunden
 * Copyright (C) 2021-2024 Philip Helger (www.helger.com)
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
package com.helger.eforms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.error.list.IErrorList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.eforms.jaxb.brin.BusinessRegistrationInformationNoticeType;
import com.helger.eforms.jaxb.ext.EformsExtension;
import com.helger.ubl23.UBL23Marshaller.UBL23JAXBMarshaller;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_23.PartyType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_23.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_23.IssueDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_23.TotalAmountType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_23.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_23.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_23.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_23.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.PriorInformationNoticeType;

public final class EformsUBLFuncTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (EformsUBLFuncTest.class);

  @Test
  public void testCANForms ()
  {
    final UBL23JAXBMarshaller <ContractAwardNoticeType> m = EformsUBLMarshaller.contractAwardNotice ();

    for (final String sFilename : MockEformsUBLTestDocuments.getTestDocuments (EFormsUBLDocumentType.CONTRACT_AWARD_NOTICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename), new DOMReaderSettings ().setSchema (m.getSchema ()));
      final ContractAwardNoticeType aUBLObject = EformsUBLMarshaller.contractAwardNotice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = EformsUBLMarshaller.contractAwardNotice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename + ": " + aErrors, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = EformsUBLMarshaller.contractAwardNotice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ContractAwardNoticeType aUBLObject2 = EformsUBLMarshaller.contractAwardNotice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = EformsUBLMarshaller.contractAwardNotice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = EformsUBLMarshaller.contractAwardNotice ().validate (new ContractAwardNoticeType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testCNForms ()
  {
    final UBL23JAXBMarshaller <ContractNoticeType> m = EformsUBLMarshaller.contractNotice ();

    for (final String sFilename : MockEformsUBLTestDocuments.getTestDocuments (EFormsUBLDocumentType.CONTRACT_NOTICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename), new DOMReaderSettings ().setSchema (m.getSchema ()));
      final ContractNoticeType aUBLObject = EformsUBLMarshaller.contractNotice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = EformsUBLMarshaller.contractNotice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename + ": " + aErrors, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = EformsUBLMarshaller.contractNotice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ContractNoticeType aUBLObject2 = EformsUBLMarshaller.contractNotice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = EformsUBLMarshaller.contractNotice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = EformsUBLMarshaller.contractNotice ().validate (new ContractNoticeType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testPINForms ()
  {
    final UBL23JAXBMarshaller <PriorInformationNoticeType> m = EformsUBLMarshaller.priorInformationNotice ();

    for (final String sFilename : MockEformsUBLTestDocuments.getTestDocuments (EFormsUBLDocumentType.PRIOR_INFORMATION_NOTICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename), new DOMReaderSettings ().setSchema (m.getSchema ()));
      final PriorInformationNoticeType aUBLObject = EformsUBLMarshaller.priorInformationNotice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = EformsUBLMarshaller.priorInformationNotice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename + ": " + aErrors, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = EformsUBLMarshaller.priorInformationNotice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final PriorInformationNoticeType aUBLObject2 = EformsUBLMarshaller.priorInformationNotice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = EformsUBLMarshaller.priorInformationNotice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = EformsUBLMarshaller.priorInformationNotice ().validate (new PriorInformationNoticeType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testUpdateInstanceAndAddExtension ()
  {
    final ContractAwardNoticeType aSourceDoc = EformsUBLMarshaller.contractAwardNotice ()
                                                                  .read (new File ("src/test/resources/external/examples/can_24_maximal.xml"));
    assertNotNull (aSourceDoc);

    final ContractAwardNoticeType aTargetDoc = EformsUBLMarshaller.contractAwardNotice ()
                                                                  .read (new File ("src/test/resources/external/examples/can_24_minimal.xml"));
    assertNotNull (aTargetDoc);

    final EformsExtension aEformsExtension = EformsUBLHelper.getFormsExtension (aSourceDoc.getUBLExtensions ()
                                                                                          .getUBLExtension ()
                                                                                          .get (0)
                                                                                          .getExtensionContent ());

    {
      // Update total amount
      final TotalAmountType totalAmountType = new TotalAmountType ();
      totalAmountType.setValue (new BigDecimal ("99.99"));
      totalAmountType.setCurrencyID ("EUR");
      aEformsExtension.getNoticeResult ().setTotalAmount (totalAmountType);
    }

    {
      // Add to UBL
      final UBLExtensionsType aExtensions = new UBLExtensionsType ();
      final UBLExtensionType aExtension = new UBLExtensionType ();
      final ExtensionContentType aExtCont = new ExtensionContentType ();
      EformsUBLHelper.setFormsExtension (aExtCont, aEformsExtension);
      aExtension.setExtensionContent (aExtCont);
      aExtensions.addUBLExtension (aExtension);
      aTargetDoc.setUBLExtensions (aExtensions);
    }

    // Write XML to String
    final String sResult = EformsUBLMarshaller.contractAwardNotice ().setFormattedOutput (true).getAsString (aTargetDoc);
    assertNotNull (sResult);
    LOGGER.info (sResult);
  }

  @Test
  public void testBRIN ()
  {
    final BusinessRegistrationInformationNoticeType brin = new BusinessRegistrationInformationNoticeType ();
    brin.setID (new IDType ("bla"));
    brin.setIssueDate (new IssueDateType (PDTFactory.getCurrentLocalDate ()));
    {
      final PartyType aBP = new PartyType ();
      brin.setBusinessParty (aBP);
    }
    final String sResult = EformsUBLMarshaller.businessRegistrationInformationNotice ().setFormattedOutput (true).getAsString (brin);
    assertNotNull (sResult);
    LOGGER.info (sResult);

    final BusinessRegistrationInformationNoticeType brin2 = EformsUBLMarshaller.businessRegistrationInformationNotice ().read (sResult);
    assertNotNull (brin2);
    assertEquals (brin, brin2);
  }
}
