/*
 * Copyright (C) 2020-2023 Philip Helger (www.helger.com)
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
package com.helger.dianubl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.math.BigDecimal;
import java.time.Month;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.error.list.IErrorList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;

import dian.gov.co.facturaelectronica.structures_2_1.AuthorizationProvider;
import dian.gov.co.facturaelectronica.structures_2_1.AuthrorizedInvoices;
import dian.gov.co.facturaelectronica.structures_2_1.CoID2Type;
import dian.gov.co.facturaelectronica.structures_2_1.DianExtensionsType;
import dian.gov.co.facturaelectronica.structures_2_1.InvoiceControl;
import dian.gov.co.facturaelectronica.structures_2_1.SoftwareProvider;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.CountryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PeriodType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21.IdentificationCodeType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.ExtensionContentType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionType;
import oasis.names.specification.ubl.schema.xsd.commonextensioncomponents_21.UBLExtensionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_21.IdentifierType;
import oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_21.NumericType;

/**
 * Some cross functionality testing
 *
 * @author Philip Helger
 */
public final class DianUBLFuncTest
{
  private static final Logger LOGGER = LoggerFactory.getLogger (DianUBLFuncTest.class);

  @Test
  public void testReadAndWriteCancelUserAccount ()
  {
    for (final String sFilename : MockDianUBLTestDocuments.getUBLPETestDocuments (EDianUBLDocumentType.INVOICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EDianUBLDocumentType.INVOICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final InvoiceType aUBLObject = DianUBLReader.invoice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = DianUBLValidator.invoice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename + ": " + aErrors.toString (), aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = DianUBLWriter.invoice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final InvoiceType aUBLObject2 = DianUBLReader.invoice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = DianUBLValidator.invoice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = DianUBLValidator.invoice ().validate (new InvoiceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadInstanceAndAddExtension ()
  {
    // This is based on test-dian/Generica.xml
    final InvoiceType aInvoice = DianUBLReader.invoice ()
                                              .read (new File ("src/test/resources/external/test-ubl/invoice1.xml"));
    assertNotNull (aInvoice);

    // The main extension, filled with values from test-dian/Generica.xml
    final DianExtensionsType aDian = new DianExtensionsType ();
    {
      final InvoiceControl aIC = new InvoiceControl ();
      aIC.setInvoiceAuthorization (new NumericType (BigDecimal.valueOf (18760000001L)));
      {
        final PeriodType aAuthPeriod = new PeriodType ();
        aAuthPeriod.setStartDate (PDTFactory.createLocalDate (2019, Month.JANUARY, 19));
        aAuthPeriod.setEndDate (PDTFactory.createLocalDate (2030, Month.JANUARY, 19));
        aIC.setAuthorizationPeriod (aAuthPeriod);
      }
      {
        final AuthrorizedInvoices aAI = new AuthrorizedInvoices ();
        aAI.setPrefix ("SETP");
        aAI.setFrom (990000000L);
        aAI.setTo (995000000L);
        aIC.setAuthorizedInvoices (aAI);
      }
      aDian.setInvoiceControl (aIC);
    }
    {
      final CountryType aIS = new CountryType ();
      final IdentificationCodeType aIC = new IdentificationCodeType ();
      aIC.setListAgencyID ("6");
      aIC.setListAgencyName ("United Nations Economic Commission for Europe");
      aIC.setListSchemeURI ("urn:oasis:names:specification:ubl:codelist:gc:CountryIdentificationCode-2.1");
      aIC.setValue ("CO");
      aIS.setIdentificationCode (aIC);
      aDian.setInvoiceSource (aIS);
    }

    {
      final SoftwareProvider aSP = new SoftwareProvider ();
      {
        final CoID2Type aSPID = new CoID2Type ();
        aSPID.setSchemeAgencyID ("195");
        aSPID.setSchemeAgencyName ("CO, DIAN (Dirección de Impuestos y Aduanas Nacionales)");
        aSPID.setSchemeID ("11");
        aSPID.setSchemeName ("31");
        aSPID.setValue ("800197268");
        aSP.setProviderID (aSPID);
      }
      {
        final IdentifierType aSWID = new IdentifierType ();
        aSWID.setSchemeAgencyID ("195");
        aSWID.setSchemeAgencyName ("CO, DIAN (Dirección de Impuestos y Aduanas Nacionales)");
        aSWID.setValue ("56f2ae4e-9812-4fad-9255-08fcfcd5ccb0");
        aSP.setSoftwareID (aSWID);
      }
      aDian.setSoftwareProvider (aSP);
      {
        final IdentifierType aSSC = new IdentifierType ();
        aSSC.setSchemeAgencyID ("195");
        aSSC.setSchemeAgencyName ("CO, DIAN (Dirección de Impuestos y Aduanas Nacionales)");
        aSSC.setValue ("a8d18e4e5aa00b44a0b1f9ef413ad8215116bd3ce91730d580eaed795c83b5a32fe6f0823abc71400b3d59eb542b7de8");
        aDian.setSoftwareSecurityCode (aSSC);
      }

      {
        final AuthorizationProvider aAP = new AuthorizationProvider ();
        final CoID2Type aID = new CoID2Type ();
        aID.setSchemeAgencyID ("195");
        aID.setSchemeAgencyName ("CO, DIAN (Dirección de Impuestos y Aduanas Nacionales)");
        aID.setSchemeID ("11");
        aID.setSchemeName ("31");
        aID.setValue ("800197268");
        aAP.setAuthorizationProviderID (aID);
        aDian.setAuthorizationProvider (aAP);
      }

      aDian.setQRCode ("https://catalogo-vpfe-hab.dian.gov.co/Document/FindDocument?documentKey=941cf36af62dbbc06f105d2a80e9bfe683a90e84960eae4d351cc3afbe8f848c26c39bac4fbc80fa254824c6369ea694&partitionKey=co|06|94&emissionDate=20190620");
    }

    // Add to UBL
    final UBLExtensionsType aExtensions = new UBLExtensionsType ();
    final UBLExtensionType aExtension = new UBLExtensionType ();
    final ExtensionContentType aExtCont = new ExtensionContentType ();
    {
      final Document aDoc = DianUBLWriter.dianExtensions ().getAsDocument (aDian);
      assertNotNull (aDoc);
      // Must set as "org.w3c.Element"
      aExtCont.setAny (aDoc.getDocumentElement ());
    }
    aExtension.setExtensionContent (aExtCont);
    aExtensions.addUBLExtension (aExtension);
    aInvoice.setUBLExtensions (aExtensions);

    // Write XML to String
    final String sResult = DianUBLWriter.invoice ().setFormattedOutput (true).getAsString (aInvoice);
    LOGGER.info (sResult);
  }
}
