/*
 * Copyright (C) 2014-2026 Philip Helger (www.helger.com)
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
package com.helger.ubl21.supplementary.issues;

import static org.junit.Assert.assertNotNull;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;

import com.helger.collection.commons.CommonsArrayList;
import com.helger.jaxb.JAXBContextCache;
import com.helger.jaxb.JAXBContextCacheKey;
import com.helger.ubl21.UBL21Marshaller;
import com.helger.xml.serialize.write.XMLWriter;
import com.helger.xsds.xades132.CertIDListType;
import com.helger.xsds.xades132.CertIDType;
import com.helger.xsds.xades132.DigestAlgAndValueType;
import com.helger.xsds.xades132.QualifyingPropertiesType;
import com.helger.xsds.xades132.SignedPropertiesType;
import com.helger.xsds.xades132.SignedSignaturePropertiesType;
import com.helger.xsds.xmldsig.CanonicalizationMethodType;
import com.helger.xsds.xmldsig.DigestMethodType;
import com.helger.xsds.xmldsig.ObjectType;
import com.helger.xsds.xmldsig.ReferenceType;
import com.helger.xsds.xmldsig.SignatureMethodType;
import com.helger.xsds.xmldsig.SignatureType;
import com.helger.xsds.xmldsig.SignedInfoType;
import com.helger.xsds.xmldsig.X509IssuerSerialType;

import oasis.names.specification.ubl.schema.xsd.commonsignaturecomponents_21.ObjectFactory;
import oasis.names.specification.ubl.schema.xsd.commonsignaturecomponents_21.UBLDocumentSignaturesType;
import oasis.names.specification.ubl.schema.xsd.signatureaggregatecomponents_21.SignatureInformationType;

public final class Issue67Test
{
  private static final Logger LOGGER = LoggerFactory.getLogger (Issue67Test.class);

  @Test
  public void testBasic ()
  {
    final com.helger.xsds.xmldsig.ObjectType objectType = new ObjectType ();
    final com.helger.xsds.xades132.ObjectFactory objectFactory = new com.helger.xsds.xades132.ObjectFactory ();
    final QualifyingPropertiesType qualifyingPropertiesType = new QualifyingPropertiesType ();
    qualifyingPropertiesType.setTarget ("signature");
    final SignedPropertiesType signedPropertiesType = new SignedPropertiesType ();
    signedPropertiesType.setId ("id-xades-signed-props");
    final SignedSignaturePropertiesType signedSignaturePropertiesType = new SignedSignaturePropertiesType ();
    signedSignaturePropertiesType.setSigningTime (LocalDateTime.now ());
    final com.helger.xsds.xades132.CertIDListType certIDListType = new CertIDListType ();
    final com.helger.xsds.xades132.CertIDType certIDType = new CertIDType ();
    final com.helger.xsds.xades132.DigestAlgAndValueType digestAlgAndValueType = new DigestAlgAndValueType ();
    final com.helger.xsds.xmldsig.DigestMethodType digestMethodType = new DigestMethodType ();
    digestMethodType.setAlgorithm ("http://www.w3.org/2001/04/xmlenc#sha256");
    digestAlgAndValueType.setDigestMethod (digestMethodType);
    digestAlgAndValueType.setDigestValue ("YTJkM2JhYTcwZTBhZTAxOGYwODMyNzY3NTdkZDM3YzhjY2IxOTIyZDZhM2RlZGJiMGY0NDUzZWJhYWI4MDhmYg==".getBytes ());
    certIDType.setCertDigest (digestAlgAndValueType);
    final com.helger.xsds.xmldsig.X509IssuerSerialType x509IssuerSerialType = new X509IssuerSerialType ();
    x509IssuerSerialType.setX509IssuerName ("CN = Contoso Malaysia Sdn Bhd, E = noemail@contoso.com, OU = Contoso Malaysia Sdn Bhd, O = Contoso Malaysia Sdn Bhd, C = MY");
    x509IssuerSerialType.setX509SerialNumber (new BigInteger ("2475382886904809774818644480820936050208702411"));
    certIDType.setIssuerSerial (x509IssuerSerialType);
    certIDListType.addCert (certIDType);
    signedSignaturePropertiesType.setSigningCertificate (certIDListType);
    signedPropertiesType.setSignedSignatureProperties (signedSignaturePropertiesType);
    qualifyingPropertiesType.setSignedProperties (signedPropertiesType);

    objectType.addContent (objectFactory.createQualifyingProperties (qualifyingPropertiesType));
    final SignatureType signatureType = new SignatureType ();
    {
      final SignedInfoType signedInfo = new SignedInfoType ();
      signedInfo.setId ("bla");
      {
        final CanonicalizationMethodType canonMethod = new CanonicalizationMethodType ();
        canonMethod.setAlgorithm ("bla");
        signedInfo.setCanonicalizationMethod (canonMethod);
      }
      {
        final SignatureMethodType sigMethod = new SignatureMethodType ();
        sigMethod.setAlgorithm ("bla");
        signedInfo.setSignatureMethod (sigMethod);
      }
      {
        final ReferenceType ref = new ReferenceType ();
        {
          final DigestMethodType digestMethod = new DigestMethodType ();
          digestMethod.setAlgorithm ("urn:bla");
          ref.setDigestMethod (digestMethod);
        }
        ref.setDigestValue ("abc".getBytes (StandardCharsets.UTF_8));
        signedInfo.addReference (ref);
      }
      signatureType.setSignedInfo (signedInfo);
    }
    signatureType.setSignatureValue ("def".getBytes (StandardCharsets.UTF_8));
    signatureType.addObject (objectType);

    // Additional boilerplate code
    final UBLDocumentSignaturesType ublDocumentSignaturesType = new UBLDocumentSignaturesType ();
    final SignatureInformationType sigInfo = new SignatureInformationType ();
    sigInfo.setSignature (signatureType);
    ublDocumentSignaturesType.addSignatureInformation (sigInfo);

    // This
    final Element aSignaturesElement = new UBL21Marshaller.UBL21JAXBMarshaller <> (UBLDocumentSignaturesType.class,
                                                                                   UBL21Marshaller.getAllBaseXSDs (),
                                                                                   ObjectFactory._UBLDocumentSignatures_QNAME)
    {
      protected jakarta.xml.bind.JAXBContext getJAXBContext (final ClassLoader aClassLoader) throws jakarta.xml.bind.JAXBException
      {
        // Hack that is needed to include Xades 1.3.2 into the JAXB context
        return JAXBContextCache.getInstance ()
                               .getFromCache (JAXBContextCacheKey.createForPackages (new CommonsArrayList <> (UBLDocumentSignaturesType.class.getPackage (),
                                                                                                              com.helger.xsds.xades132.ObjectFactory.class.getPackage ()),
                                                                                     aClassLoader));
      }
    }.getAsElement (ublDocumentSignaturesType);
    assertNotNull (aSignaturesElement);
    LOGGER.info (XMLWriter.getNodeAsString (aSignaturesElement));
  }
}
