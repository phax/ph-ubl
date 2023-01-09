/*
 * Copyright (C) 2020-2023 Philip Helger (www.helger.com)
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
import com.helger.ubl21.CUBL21;
import com.helger.ubl21.EUBL21DocumentType;

import dian.gov.co.facturaelectronica.structures_2_1.DianExtensionsType;

/**
 * Enumeration with all available DIAN UBL document types.
 *
 * @author Philip Helger
 */
public enum EDianUBLDocumentType implements IJAXBDocumentType
{
  APPLICATION_RESPONSE (EUBL21DocumentType.APPLICATION_RESPONSE),
  ATTACHED_DOCUMENT (EUBL21DocumentType.ATTACHED_DOCUMENT),
  CREDIT_NOTE (EUBL21DocumentType.CREDIT_NOTE),
  DEBIT_NOTE (EUBL21DocumentType.DEBIT_NOTE),
  INVOICE (EUBL21DocumentType.INVOICE),
  DIAN_EXTENSIONS (DianExtensionsType.class,
                   new CommonsArrayList <> (CUBL21.XSD_UNQUALIFIED_DATA_TYPES,
                                            CUBL21.XSD_COMMON_AGGREGATE_COMPONENTS,
                                            CDianUBL.XSD_DIAN_UBL_STRUCTURE));

  @Nonnull
  private static ClassLoader _getCL ()
  {
    return EDianUBLDocumentType.class.getClassLoader ();
  }

  private final JAXBDocumentType m_aDocType;

  @Nonnull
  private static ICommonsList <ClassPathResource> _injectSTS (@Nonnull final ICommonsList <ClassPathResource> aList)
  {
    final ICommonsList <ClassPathResource> ret = new CommonsArrayList <> ();
    // Copy everything EXCEPT the last item
    if (aList.size () > 1)
      ret.addAll (aList.subList (0, aList.size () - 1));
    // Inject DIAN stuff in the middle
    ret.add (CUBL21.XSD_UNQUALIFIED_DATA_TYPES);
    ret.add (CUBL21.XSD_COMMON_AGGREGATE_COMPONENTS);
    ret.add (CDianUBL.XSD_DIAN_UBL_STRUCTURE);
    // Add the root element last
    ret.add (aList.getLast ());
    return ret;
  }

  EDianUBLDocumentType (@Nonnull final EUBL21DocumentType eOther)
  {
    m_aDocType = new JAXBDocumentType (eOther.getImplementationClass (),
                                       _injectSTS (eOther.getAllXSDResources ()),
                                       s -> StringHelper.trimEnd (s, "Type"));
  }

  EDianUBLDocumentType (@Nonnull final Class <?> aClass, @Nonnull @Nonempty final List <ClassPathResource> aXSDPaths)
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
