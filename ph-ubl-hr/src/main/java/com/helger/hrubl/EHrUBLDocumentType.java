/*
 * Copyright (C) 2026 Philip Helger (www.helger.com)
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
package com.helger.hrubl;

import org.jspecify.annotations.NonNull;

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;
import com.helger.io.resource.ClassPathResource;
import com.helger.ubl21.CUBL21;
import com.helger.ubl21.EUBL21DocumentType;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;

import hr.gov.mfin.schema.xsd.hrextensionaggregatecomponents_1.HRFISK20DataType;

/**
 * Enumeration with all available Croatian UBL document types.
 */
public enum EHrUBLDocumentType
{
  CREDIT_NOTE (EUBL21DocumentType.CREDIT_NOTE),
  INVOICE (EUBL21DocumentType.INVOICE),
  HR_EXTENSION (HRFISK20DataType.class,
                new CommonsArrayList <> (CCCTS.getXSDResource (),
                                         CUBL21.XSD_UNQUALIFIED_DATA_TYPES,
                                         CUBL21.XSD_QUALIFIED_DATA_TYPES,
                                         CUBL21.XSD_COMMON_BASIC_COMPONENTS,
                                         CHrUBL.XSD_HR_EXTENSION_AGGREGATE_COMPONENTS));

  private final Class <?> m_aImplClass;
  private final ICommonsList <ClassPathResource> m_aXSDs;

  EHrUBLDocumentType (@NonNull final EUBL21DocumentType eUBL21)
  {
    m_aImplClass = eUBL21.getImplementationClass ();
    m_aXSDs = HrUBLMarshaller.HrUBLJAXBMarshaller.getAllXSDs (eUBL21.getAllXSDResources ());
  }

  EHrUBLDocumentType (@NonNull final Class <?> aClass, @NonNull @Nonempty final ICommonsList <ClassPathResource> aXSDPaths)
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
