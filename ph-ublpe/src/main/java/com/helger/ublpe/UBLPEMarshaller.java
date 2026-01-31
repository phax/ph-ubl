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
package com.helger.ublpe;

import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;
import com.helger.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.ubl20.CUBL20;
import com.helger.ubl20.UBL20Marshaller;
import com.helger.ubl20.UBL20Marshaller.UBL20JAXBMarshaller;
import com.helger.xml.namespace.MapBasedNamespaceContext;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import sunat.names.specification.ubl.peru.schema.xsd.summarydocuments_1.SummaryDocumentsType;
import sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.VoidedDocumentsType;

/**
 * The class provides all the UBL PE marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class UBLPEMarshaller
{
  public static class UBLPEJAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    private final QName m_aRootElementQName;

    public UBLPEJAXBMarshaller (@NonNull final Class <JAXBTYPE> aType,
                                @Nullable final ICommonsList <ClassPathResource> aSourceXSDs,
                                @NonNull final QName aRootElementQName)
    {
      super (aType, aSourceXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      m_aRootElementQName = aRootElementQName;

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBLPENamespaceContext.getInstance ().getClone ();
      // Avoid overwriting an already mapped context
      if (!aNSContext.isNamespaceURIMapped (aRootElementQName.getNamespaceURI ()))
        aNSContext.addDefaultNamespaceURI (aRootElementQName.getNamespaceURI ());
      setNamespaceContext (aNSContext);
    }

    @NonNull
    public final QName getRootElementQName ()
    {
      return m_aRootElementQName;
    }

    @NonNull
    public final String getRootElementNamespaceURI ()
    {
      return m_aRootElementQName.getNamespaceURI ();
    }

    @Nullable
    public Schema getSchema ()
    {
      return createValidationSchema ();
    }
  }

  private UBLPEMarshaller ()
  {}

  @NonNull
  public static UBL20JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return UBL20Marshaller.applicationResponse ();
  }

  @NonNull
  public static UBL20JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return UBL20Marshaller.creditNote ();
  }

  @NonNull
  public static UBL20JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return UBL20Marshaller.debitNote ();
  }

  @NonNull
  public static UBL20JAXBMarshaller <InvoiceType> invoice ()
  {
    return UBL20Marshaller.invoice ();
  }

  private static final ICommonsList <ClassPathResource> XSDS_SD = new CommonsArrayList <> (CUBL20.XSD_CODELIST_UNIT_CODE,
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
                                                                                                                  CUBLPE.getCL ()),
                                                                                           new ClassPathResource (CUBLPE.SCHEMA_DIRECTORY +
                                                                                                                  "maindoc/UBLPE-SummaryDocuments-1.0.xsd",
                                                                                                                  CUBLPE.getCL ()));

  @NonNull
  public static UBLPEJAXBMarshaller <SummaryDocumentsType> summaryDocuments ()
  {
    return new UBLPEJAXBMarshaller <> (SummaryDocumentsType.class,
                                       XSDS_SD,
                                       sunat.names.specification.ubl.peru.schema.xsd.summarydocuments_1.ObjectFactory._SummaryDocuments_QNAME);
  }

  private static final ICommonsList <ClassPathResource> XSDS_VD = new CommonsArrayList <> (CUBL20.XSD_CODELIST_UNIT_CODE,
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
                                                                                                                  CUBLPE.getCL ()),
                                                                                           new ClassPathResource (CUBLPE.SCHEMA_DIRECTORY +
                                                                                                                  "maindoc/UBLPE-VoidedDocuments-1.0.xsd",
                                                                                                                  CUBLPE.getCL ()));

  @NonNull
  public static UBLPEJAXBMarshaller <VoidedDocumentsType> voidedDocuments ()
  {
    return new UBLPEJAXBMarshaller <> (VoidedDocumentsType.class,
                                       XSDS_VD,
                                       sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.ObjectFactory._VoidedDocuments_QNAME);
  }
}
