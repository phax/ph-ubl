/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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
import javax.annotation.Nullable;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.ubl.api.IUBLDocumentType;
import com.helger.ubl.api.UBLDocumentType;

import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_21.PackageType;
import tr.gov.efatura.useraccount.CancelUserAccountType;
import tr.gov.efatura.useraccount.ProcessUserAccountType;

/**
 * Enumeration with all available UBLTR document types.
 *
 * @author Philip Helger
 */
public enum EUBLTRDocumentType implements IUBLDocumentType
{
  CANCEL_USER_ACCOUNT (CancelUserAccountType.class, CUBLTR.XSD_HRXML_USER_ACCOUNT),
  PROCESS_USER_ACCOUNT (ProcessUserAccountType.class, CUBLTR.XSD_HRXML_USER_ACCOUNT),
  PACKAGE (PackageType.class, CUBLTR.XSD_PACKAGE);

  private final UBLDocumentType m_aDocType;

  private EUBLTRDocumentType (@Nonnull final Class <?> aClass, @Nonnull @Nonempty final List <String> aXSDPaths)
  {
    m_aDocType = new UBLDocumentType (aClass, aXSDPaths);
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aDocType.getImplementationClass ();
  }

  @Nonnull
  public Package getPackage ()
  {
    return m_aDocType.getPackage ();
  }

  @Nonnull
  public String getLocalName ()
  {
    return m_aDocType.getLocalName ();
  }

  @Nonnull
  public String getNamespaceURI ()
  {
    return m_aDocType.getNamespaceURI ();
  }

  @Nonnull
  public QName getQName ()
  {
    return m_aDocType.getQName ();
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableCopy
  public List <String> getAllXSDPaths ()
  {
    return m_aDocType.getAllXSDPaths ();
  }

  @Nonnull
  public Schema getSchema (@Nullable final ClassLoader aClassLoader)
  {
    return m_aDocType.getSchema (aClassLoader);
  }
}
