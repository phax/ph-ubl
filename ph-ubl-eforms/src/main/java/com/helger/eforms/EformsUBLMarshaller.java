/*
 * Copyright (C) 2021-2025 Jonatan Sunden
 * Copyright (C) 2021-2025 Philip Helger (www.helger.com)
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

import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;
import com.helger.eforms.jaxb.brin.BusinessRegistrationInformationNoticeType;
import com.helger.eforms.jaxb.ext.EformsExtension;
import com.helger.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.ubl23.CUBL23;
import com.helger.ubl23.UBL23Marshaller;
import com.helger.ubl23.UBL23Marshaller.UBL23JAXBMarshaller;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;
import com.helger.xsds.xades132.CXAdES132;
import com.helger.xsds.xades141.CXAdES141;
import com.helger.xsds.xmldsig.CXMLDSig;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_23.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.PriorInformationNoticeType;

/**
 * The class provides all the eForms UBL marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class EformsUBLMarshaller
{
  public static class EformsUBLJAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    public EformsUBLJAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                    @Nullable final ICommonsList <ClassPathResource> aSourceXSDs,
                                    @Nonnull final QName aRootElementQName)
    {
      super (aType, aSourceXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = EformsUBLNamespaceContext.getInstance ().getClone ();
      // Avoid overwriting an already mapped context
      if (!aNSContext.isNamespaceURIMapped (aRootElementQName.getNamespaceURI ()))
        aNSContext.addDefaultNamespaceURI (aRootElementQName.getNamespaceURI ());
      setNamespaceContext (aNSContext);
    }

    @Nullable
    public Schema getSchema ()
    {
      return createValidationSchema ();
    }
  }

  private EformsUBLMarshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CEformsUBL.SCHEMA_DIRECTORY + sXSDPath, CEformsUBL.getCL ());
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ContractAwardNoticeType> contractAwardNotice ()
  {
    return UBL23Marshaller.contractAwardNotice ();
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ContractNoticeType> contractNotice ()
  {
    return UBL23Marshaller.contractNotice ();
  }

  @Nonnull
  public static UBL23JAXBMarshaller <PriorInformationNoticeType> priorInformationNotice ()
  {
    return UBL23Marshaller.priorInformationNotice ();
  }

  private static final ICommonsList <ClassPathResource> XSDS_EXT = new CommonsArrayList <> (CCCTS.getXSDResource (),
                                                                                                 CXMLDSig.getXSDResource (),
                                                                                                 CXAdES132.getXSDResource (),
                                                                                                 CXAdES141.getXSDResource (),
                                                                                                 CUBL23.XSD_COMMON_AGGREGATE_COMPONENTS,
                                                                                                 CEformsUBL.XSD_EFORMS_EXTENSION_BASIC_COMPONENTS,
                                                                                                 CEformsUBL.XSD_EFORMS_EXTENSION_AGGREGATE_COMPONENTS,
                                                                                                 CEformsUBL.XSD_EFORMS_EXTENSION_APEX);

  @Nonnull
  public static EformsUBLJAXBMarshaller <EformsExtension> eFormsExtension ()
  {
    return new EformsUBLJAXBMarshaller <> (EformsExtension.class,
                                           XSDS_EXT,
                                           new QName (CEformsUBL.XML_SCHEMA_EFEXT_NAMESPACE_URL, "EformsExtension"));
  }

  private static final ICommonsList <ClassPathResource> XSDS_BRIN;
  static
  {
    XSDS_BRIN = XSDS_EXT.getClone ();
    XSDS_BRIN.add (CEformsUBL.XSD_EFORMS_BRIN);
  }

  @Nonnull
  public static EformsUBLJAXBMarshaller <BusinessRegistrationInformationNoticeType> businessRegistrationInformationNotice ()
  {
    return new EformsUBLJAXBMarshaller <> (BusinessRegistrationInformationNoticeType.class,
                                           XSDS_BRIN,
                                           com.helger.eforms.jaxb.brin.ObjectFactory._BusinessRegistrationInformationNotice_QNAME);
  }
}
