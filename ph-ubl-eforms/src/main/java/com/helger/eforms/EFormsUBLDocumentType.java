/*
 * Copyright (C) 2021-2026 Jonatan Sunden
 * Copyright (C) 2021-2026 Philip Helger (www.helger.com)
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

import org.jspecify.annotations.NonNull;

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;
import com.helger.eforms.jaxb.brin.BusinessRegistrationInformationNoticeType;
import com.helger.io.resource.ClassPathResource;
import com.helger.ubl23.CUBL23;
import com.helger.ubl23.EUBL23DocumentType;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;
import com.helger.xsds.xades132.CXAdES132;
import com.helger.xsds.xades141.CXAdES141;
import com.helger.xsds.xmldsig.CXMLDSig;

import oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_23.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.PriorInformationNoticeType;

/**
 * EForms document types
 *
 * @author Jonatan Sunden
 * @author Philip Helger
 * @since 6.7.0
 */
public enum EFormsUBLDocumentType
{
  CONTRACT_AWARD_NOTICE (ContractAwardNoticeType.class, EUBL23DocumentType.CONTRACT_AWARD_NOTICE.getAllXSDResources ()),
  CONTRACT_NOTICE (ContractNoticeType.class, EUBL23DocumentType.CONTRACT_NOTICE.getAllXSDResources ()),
  PRIOR_INFORMATION_NOTICE (PriorInformationNoticeType.class, EUBL23DocumentType.PRIOR_INFORMATION_NOTICE.getAllXSDResources ()),
  BUSINESS_REGISTRATION_INFORMATION_NOTICE (BusinessRegistrationInformationNoticeType.class,
                                            new CommonsArrayList <> (CCCTS.getXSDResource (),
                                                                     CXMLDSig.getXSDResource (),
                                                                     CXAdES132.getXSDResource (),
                                                                     CXAdES141.getXSDResource (),
                                                                     CUBL23.XSD_COMMON_AGGREGATE_COMPONENTS,
                                                                     CEformsUBL.XSD_EFORMS_EXTENSION_BASIC_COMPONENTS,
                                                                     CEformsUBL.XSD_EFORMS_EXTENSION_AGGREGATE_COMPONENTS,
                                                                     CEformsUBL.XSD_EFORMS_EXTENSION_APEX,
                                                                     CEformsUBL.XSD_EFORMS_BRIN));

  private final Class <?> m_aImplClass;
  private final ICommonsList <ClassPathResource> m_aXSDs;

  EFormsUBLDocumentType (@NonNull final Class <?> aClass, @NonNull @Nonempty final ICommonsList <ClassPathResource> aXSDPaths)
  {
    m_aImplClass = aClass;
    m_aXSDs = aXSDPaths;
  }

  @NonNull
  public Class <?> getImplementationClass ()
  {
    return m_aImplClass;
  }

  @NonNull
  @Nonempty
  @ReturnsMutableCopy
  public ICommonsList <ClassPathResource> getAllXSDResources ()
  {
    return m_aXSDs.getClone ();
  }
}
