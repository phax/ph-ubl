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
package com.helger.ubltr;

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
import com.helger.xsds.xmldsig.CXMLDSig;

import tr.gov.efatura.package_12.TRPackage;
import tr.gov.efatura.useraccount.CancelUserAccountType;
import tr.gov.efatura.useraccount.ProcessUserAccountType;

/**
 * The class provides all the UBL TR marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class UBLTRMarshaller
{
  public static class UBLTRJAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    private final QName m_aRootElementQName;

    public UBLTRJAXBMarshaller (@NonNull final Class <JAXBTYPE> aType,
                                @Nullable final ICommonsList <ClassPathResource> aSourceXSDs,
                                @NonNull final QName aRootElementQName)
    {
      super (aType, aSourceXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      m_aRootElementQName = aRootElementQName;

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBLTRNamespaceContext.getInstance ().getClone ();
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

  private UBLTRMarshaller ()
  {}

  @NonNull
  private static ClassLoader _getCL ()
  {
    return UBLTRMarshaller.class.getClassLoader ();
  }

  private static final ICommonsList <ClassPathResource> XSD_HRXML_USER_ACCOUNT = new CommonsArrayList <> (CXMLDSig.getXSDResource (),
                                                                                                          new ClassPathResource (CUBLTR.SCHEMA_DIRECTORY +
                                                                                                                                 "HRXML/UserAccount.xsd",
                                                                                                                                 _getCL ()));

  @NonNull
  public static UBLTRJAXBMarshaller <CancelUserAccountType> cancelUserAccount ()
  {
    return new UBLTRJAXBMarshaller <> (CancelUserAccountType.class,
                                       XSD_HRXML_USER_ACCOUNT,
                                       tr.gov.efatura.useraccount.ObjectFactory._CancelUserAccount_QNAME);
  }

  @NonNull
  public static UBLTRJAXBMarshaller <ProcessUserAccountType> processUserAccount ()
  {
    return new UBLTRJAXBMarshaller <> (ProcessUserAccountType.class,
                                       XSD_HRXML_USER_ACCOUNT,
                                       tr.gov.efatura.useraccount.ObjectFactory._ProcessUserAccount_QNAME);
  }

  private static final ICommonsList <ClassPathResource> XSD_PACKAGE = new CommonsArrayList <> ();

  static
  {
    XSD_PACKAGE.addAll (UBL21Marshaller.invoice ().getOriginalXSDs ());
    XSD_PACKAGE.addAll (UBL21Marshaller.applicationResponse ().getOriginalXSDs ());
    XSD_PACKAGE.add (new ClassPathResource (CUBLTR.SCHEMA_DIRECTORY + "Envelope/Package_1_2.xsd", _getCL ()));
    XSD_PACKAGE.addAll (UBL21Marshaller.despatchAdvice ().getOriginalXSDs ());
    XSD_PACKAGE.addAll (UBL21Marshaller.receiptAdvice ().getOriginalXSDs ());
  }

  private static final QName QNAME_PACKAGE = new QName (CUBLTR.XML_NS_EFATURA, "Package");

  @NonNull
  public static UBLTRJAXBMarshaller <TRPackage> trPackage ()
  {
    return new UBLTRJAXBMarshaller <> (TRPackage.class, XSD_PACKAGE, QNAME_PACKAGE);
  }
}
