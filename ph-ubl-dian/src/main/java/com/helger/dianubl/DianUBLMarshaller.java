/*
 * Copyright (C) 2020-2025 Philip Helger (www.helger.com)
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.ubl21.CUBL21;
import com.helger.ubl21.UBL21Marshaller;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;

import dian.gov.co.facturaelectronica.structures_2_1.DianExtensionsType;
import oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_21.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

/**
 * The class provides all the Dian UBL marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class DianUBLMarshaller
{
  public static class DianUBLJAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    private static final ICommonsList <ClassPathResource> DIAN_XSDS = new CommonsArrayList <> (CCCTS.getXSDResource (),
                                                                                               CUBL21.XSD_UNQUALIFIED_DATA_TYPES,
                                                                                               CUBL21.XSD_COMMON_AGGREGATE_COMPONENTS,
                                                                                               CDianUBL.XSD_DIAN_UBL_STRUCTURE);

    private final QName m_aRootElementQName;

    @Nonnull
    public static ICommonsList <ClassPathResource> getAllXSDs (@Nullable final ICommonsList <ClassPathResource> aList)
    {
      if (aList == null)
        return DIAN_XSDS;

      final ICommonsList <ClassPathResource> ret = new CommonsArrayList <> ();
      // Copy everything EXCEPT the last item
      if (aList.size () > 1)
        ret.addAll (aList.subList (0, aList.size () - 1));
      // Inject DIAN stuff in the middle
      ret.addAll (DIAN_XSDS);
      // Add the root element last
      ret.add (aList.getLastOrNull ());
      return ret;
    }

    public DianUBLJAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                  @Nullable final ICommonsList <ClassPathResource> aSourceXSDs,
                                  @Nonnull final QName aRootElementQName)
    {
      super (aType, getAllXSDs (aSourceXSDs), createSimpleJAXBElement (aRootElementQName, aType));

      m_aRootElementQName = aRootElementQName;

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = DianUBLNamespaceContext.getInstance ().getClone ();
      // Avoid overwriting an already mapped context
      if (!aNSContext.isNamespaceURIMapped (aRootElementQName.getNamespaceURI ()))
        aNSContext.addDefaultNamespaceURI (aRootElementQName.getNamespaceURI ());
      setNamespaceContext (aNSContext);
    }

    @Nonnull
    public final QName getRootElementQName ()
    {
      return m_aRootElementQName;
    }

    @Nonnull
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

  private DianUBLMarshaller ()
  {}

  @Nonnull
  public static DianUBLJAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new DianUBLJAXBMarshaller <> (ApplicationResponseType.class,
                                         UBL21Marshaller.applicationResponse ().getOriginalXSDs (),
                                         oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ObjectFactory._ApplicationResponse_QNAME);
  }

  @Nonnull
  public static DianUBLJAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new DianUBLJAXBMarshaller <> (AttachedDocumentType.class,
                                         UBL21Marshaller.attachedDocument ().getOriginalXSDs (),
                                         oasis.names.specification.ubl.schema.xsd.attacheddocument_21.ObjectFactory._AttachedDocument_QNAME);
  }

  @Nonnull
  public static DianUBLJAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new DianUBLJAXBMarshaller <> (CreditNoteType.class,
                                         UBL21Marshaller.creditNote ().getOriginalXSDs (),
                                         oasis.names.specification.ubl.schema.xsd.creditnote_21.ObjectFactory._CreditNote_QNAME);
  }

  @Nonnull
  public static DianUBLJAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new DianUBLJAXBMarshaller <> (DebitNoteType.class,
                                         UBL21Marshaller.debitNote ().getOriginalXSDs (),
                                         oasis.names.specification.ubl.schema.xsd.debitnote_21.ObjectFactory._DebitNote_QNAME);
  }

  @Nonnull
  public static DianUBLJAXBMarshaller <DianExtensionsType> dianExtensions ()
  {
    return new DianUBLJAXBMarshaller <> (DianExtensionsType.class,
                                         null,
                                         dian.gov.co.facturaelectronica.structures_2_1.ObjectFactory._DianExtensions_QNAME);
  }

  @Nonnull
  public static DianUBLJAXBMarshaller <InvoiceType> invoice ()
  {
    return new DianUBLJAXBMarshaller <> (InvoiceType.class,
                                         UBL21Marshaller.invoice ().getOriginalXSDs (),
                                         oasis.names.specification.ubl.schema.xsd.invoice_21.ObjectFactory._Invoice_QNAME);
  }
}
