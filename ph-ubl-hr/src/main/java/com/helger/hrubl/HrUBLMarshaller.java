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

import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;
import com.helger.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.ubl21.UBL21Marshaller;
import com.helger.xml.namespace.MapBasedNamespaceContext;

import hr.gov.mfin.schema.xsd.hrextensionaggregatecomponents_1.HRFISK20DataType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

/**
 * Marshaller factory for Croatian UBL documents. Croatian invoices and credit notes are plain UBL 2.1 documents that
 * may carry the Croatian extension <code>HRFISK20Data</code> in
 * <code>ext:UBLExtensions/ext:UBLExtension/ext:ExtensionContent</code>. The schema of the Croatian extension is added
 * to the UBL 2.1 schemas, so that the extension is validated as well.
 */
public final class HrUBLMarshaller
{
  public static class HrUBLJAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    private final QName m_aRootElementQName;

    /**
     * Insert the schema of the Croatian extension before the last XSD (which is the one of the root element) of the
     * provided list.
     *
     * @param aList
     *        The list of XSDs to extend. May neither be <code>null</code> nor empty.
     * @return A new list. Never <code>null</code>.
     */
    @NonNull
    public static ICommonsList <ClassPathResource> getAllXSDs (@NonNull final ICommonsList <ClassPathResource> aList)
    {
      final ICommonsList <ClassPathResource> ret = new CommonsArrayList <> ();
      // Copy everything EXCEPT the last item
      ret.addAll (aList.subList (0, aList.size () - 1));
      // Inject the Croatian extension in the middle
      ret.add (CHrUBL.XSD_HR_EXTENSION_AGGREGATE_COMPONENTS);
      // Add the root element last
      ret.add (aList.getLastOrNull ());
      return ret;
    }

    public HrUBLJAXBMarshaller (@NonNull final Class <JAXBTYPE> aType,
                                @NonNull final ICommonsList <ClassPathResource> aSourceXSDs,
                                @NonNull final QName aRootElementQName)
    {
      super (aType, aSourceXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      m_aRootElementQName = aRootElementQName;

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = HrUBLNamespaceContext.getInstance ().getClone ();
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

  private HrUBLMarshaller ()
  {}

  @NonNull
  public static HrUBLJAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new HrUBLJAXBMarshaller <> (CreditNoteType.class,
                                       HrUBLJAXBMarshaller.getAllXSDs (UBL21Marshaller.getAllCreditNoteXSDs ()),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_21.ObjectFactory._CreditNote_QNAME);
  }

  @NonNull
  public static HrUBLJAXBMarshaller <InvoiceType> invoice ()
  {
    return new HrUBLJAXBMarshaller <> (InvoiceType.class,
                                       HrUBLJAXBMarshaller.getAllXSDs (UBL21Marshaller.getAllInvoiceXSDs ()),
                                       oasis.names.specification.ubl.schema.xsd.invoice_21.ObjectFactory._Invoice_QNAME);
  }

  /**
   * @return A marshaller for the Croatian extension element <code>HRFISK20Data</code> itself.
   */
  @NonNull
  public static HrUBLJAXBMarshaller <HRFISK20DataType> hrExtension ()
  {
    return new HrUBLJAXBMarshaller <> (HRFISK20DataType.class,
                                       EHrUBLDocumentType.HR_EXTENSION.getAllXSDResources (),
                                       hr.gov.mfin.schema.xsd.hrextensionaggregatecomponents_1.ObjectFactory._HRFISK20Data_QNAME);
  }
}
