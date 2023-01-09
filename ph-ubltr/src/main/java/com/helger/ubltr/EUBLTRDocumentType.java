/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
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

import java.util.List;

import javax.annotation.Nonnull;
import javax.xml.validation.Schema;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.string.StringHelper;
import com.helger.jaxb.builder.IJAXBDocumentType;
import com.helger.jaxb.builder.JAXBDocumentType;

import tr.gov.efatura.package_12.TRPackage;
import tr.gov.efatura.useraccount.CancelUserAccountType;
import tr.gov.efatura.useraccount.ProcessUserAccountType;

/**
 * Enumeration with all available UBLTR document types.
 *
 * @author Philip Helger
 */
public enum EUBLTRDocumentType implements IJAXBDocumentType
{
  CANCEL_USER_ACCOUNT (CancelUserAccountType.class, CUBLTR.XSD_HRXML_USER_ACCOUNT),
  PROCESS_USER_ACCOUNT (ProcessUserAccountType.class, CUBLTR.XSD_HRXML_USER_ACCOUNT),
  PACKAGE (TRPackage.class, CUBLTR.XSD_PACKAGE);

  private final JAXBDocumentType m_aDocType;

  private EUBLTRDocumentType (@Nonnull final Class <?> aClass, @Nonnull @Nonempty final List <? extends ClassPathResource> aXSDs)
  {
    m_aDocType = new JAXBDocumentType (aClass, aXSDs, s -> StringHelper.trimEnd (s, "Type"));
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
