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
package com.helger.ublpe;

import org.jspecify.annotations.NonNull;

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;
import com.helger.io.resource.ClassPathResource;
import com.helger.ubl20.CUBL20;
import com.helger.ubl20.EUBL20DocumentType;

import sunat.names.specification.ubl.peru.schema.xsd.summarydocuments_1.SummaryDocumentsType;
import sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.VoidedDocumentsType;

/**
 * Enumeration with all available UBLPE document types.
 *
 * @author Philip Helger
 */
public enum EUBLPEDocumentType
{
  APPLICATION_RESPONSE (EUBL20DocumentType.APPLICATION_RESPONSE),
  CREDIT_NOTE (EUBL20DocumentType.CREDIT_NOTE),
  DEBIT_NOTE (EUBL20DocumentType.DEBIT_NOTE),
  INVOICE (EUBL20DocumentType.INVOICE),
  SUMMARY_DOCUMENTS (SummaryDocumentsType.class,
                     new CommonsArrayList <> (CUBL20.XSD_CODELIST_UNIT_CODE,
                                              CUBL20.XSD_CODELIST_MIME_MEDIA_TYPE_CODE,
                                              CUBL20.XSD_CODELIST_CURRENCY_CODE,
                                              CUBL20.XSD_CODELIST_LANGUAGE_CODE,
                                              CUBL20.XSD_UNQUALIFIED_DATA_TYPES,
                                              CUBL20.XSD_QUALIFIED_DATA_TYPES,
                                              CUBL20.XSD_COMMON_BASIC_COMPONENTS,
                                              CUBL20.XSD_COMMON_AGGREGATE_COMPONENTS,
                                              CUBL20.XSD_COMMON_EXTENSION_COMPONENTS,
                                              new ClassPathResource (CUBLPE.SCHEMA_DIRECTORY +
                                                                     "common/UBLPE-SunatAggregateComponents-1.0.xsd",
                                                                     _getCL ()),
                                              new ClassPathResource (CUBLPE.SCHEMA_DIRECTORY + "maindoc/UBLPE-SummaryDocuments-1.0.xsd",
                                                                     _getCL ()))),
  VOIDED_DOCUMENTS (VoidedDocumentsType.class,
                    new CommonsArrayList <> (CUBL20.XSD_CODELIST_UNIT_CODE,
                                             CUBL20.XSD_CODELIST_MIME_MEDIA_TYPE_CODE,
                                             CUBL20.XSD_CODELIST_CURRENCY_CODE,
                                             CUBL20.XSD_CODELIST_LANGUAGE_CODE,
                                             CUBL20.XSD_UNQUALIFIED_DATA_TYPES,
                                             CUBL20.XSD_QUALIFIED_DATA_TYPES,
                                             CUBL20.XSD_COMMON_BASIC_COMPONENTS,
                                             CUBL20.XSD_COMMON_AGGREGATE_COMPONENTS,
                                             CUBL20.XSD_COMMON_EXTENSION_COMPONENTS,
                                             new ClassPathResource (CUBLPE.SCHEMA_DIRECTORY +
                                                                    "common/UBLPE-SunatAggregateComponents-1.0.xsd",
                                                                    _getCL ()),
                                             new ClassPathResource (CUBLPE.SCHEMA_DIRECTORY + "maindoc/UBLPE-VoidedDocuments-1.0.xsd",
                                                                    _getCL ())));

  @NonNull
  private static ClassLoader _getCL ()
  {
    return EUBLPEDocumentType.class.getClassLoader ();
  }

  private final Class <?> m_aImplClass;
  private final ICommonsList <ClassPathResource> m_aXSDs;

  EUBLPEDocumentType (@NonNull final EUBL20DocumentType eOther)
  {
    m_aImplClass = eOther.getImplementationClass ();
    m_aXSDs = eOther.getAllXSDResources ();
  }

  EUBLPEDocumentType (@NonNull final Class <?> aClass, @NonNull @Nonempty final ICommonsList <ClassPathResource> aXSDPaths)
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
