/*
 * Copyright (C) 2020-2021 Philip Helger (www.helger.com)
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

import java.util.List;

import javax.annotation.Nonnull;
import javax.xml.validation.Schema;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.string.StringHelper;
import com.helger.jaxb.builder.IJAXBDocumentType;
import com.helger.jaxb.builder.JAXBDocumentType;

import eu.europa.data.p27.eforms_business_registration_information_notice._1.BusinessRegistrationInformationNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_2.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_2.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_2.PriorInformationNoticeType;

public enum EFormsUBLDocumentType implements IJAXBDocumentType
{
  CONTRACT_AWARD_NOTICE(ContractAwardNoticeType.class,
          new CommonsArrayList <> (
                  CEformsUBL.XSD_CAN_XML_STRUCTURE
          )),
  CONTRACT_NOTICE(ContractNoticeType .class,
          new CommonsArrayList <> (
                  CEformsUBL.XSD_CN_XML_STRUCTURE
        )),
  PRIOR_INFORMATION_NOTICE(PriorInformationNoticeType.class,
          new CommonsArrayList <> (
                  CEformsUBL.XSD_PIN_XML_STRUCTURE
          )),
  BUSINESS_REGISTRATION_INFORMATION_NOTICE(BusinessRegistrationInformationNoticeType.class,
          new CommonsArrayList <> (
                  CEformsUBL.XSD_BRIN_XML_STRUCTURE
          ))
  ;

  private final JAXBDocumentType m_aDocType;

  EFormsUBLDocumentType(@Nonnull final Class <?> aClass, @Nonnull @Nonempty final List <ClassPathResource> aXSDPaths)
  {
    m_aDocType = new JAXBDocumentType (aClass, aXSDPaths, s -> StringHelper.trimEnd (s, "Type"));
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aDocType.getImplementationClass ();
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableCopy
  public ICommonsList <ClassPathResource> getAllXSDResources ()
  {
    return m_aDocType.getAllXSDResources ();
  }

  @Nonnull
  public String getNamespaceURI ()
  {
    return m_aDocType.getNamespaceURI ();
  }

  @Nonnull
  @Nonempty
  public String getLocalName ()
  {
    return m_aDocType.getLocalName ();
  }

  @Nonnull
  public Schema getSchema ()
  {
    return m_aDocType.getSchema ();
  }
}
