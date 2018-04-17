/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
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

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.validation.Schema;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.string.StringHelper;
import com.helger.jaxb.builder.IJAXBDocumentType;
import com.helger.jaxb.builder.JAXBDocumentType;
import com.helger.ubl20.EUBL20DocumentType;

import sunat.names.specification.ubl.peru.schema.xsd.summarydocuments_1.SummaryDocumentsType;
import sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.VoidedDocumentsType;

/**
 * Enumeration with all available UBLPE document types.
 *
 * @author Philip Helger
 */
public enum EUBLPEDocumentType implements IJAXBDocumentType
{
  APPLICATION_RESPONSE (EUBL20DocumentType.APPLICATION_RESPONSE),
  CREDIT_NOTE (EUBL20DocumentType.CREDIT_NOTE),
  DEBIT_NOTE (EUBL20DocumentType.DEBIT_NOTE),
  INVOICE (EUBL20DocumentType.INVOICE),
  SUMMARY_DOCUMENTS (SummaryDocumentsType.class,
                     new CommonsArrayList <> (CUBLPE.SCHEMA_DIRECTORY + "maindoc/UBLPE-SummaryDocuments-1.0.xsd")),
  VOIDED_DOCUMENTS (VoidedDocumentsType.class,
                    new CommonsArrayList <> (CUBLPE.SCHEMA_DIRECTORY + "maindoc/UBLPE-VoidedDocuments-1.0.xsd"));

  private final JAXBDocumentType m_aDocType;

  private EUBLPEDocumentType (@Nonnull final EUBL20DocumentType eOther)
  {
    this (eOther.getImplementationClass (), eOther.getAllXSDPaths ());
  }

  private EUBLPEDocumentType (@Nonnull final Class <?> aClass, @Nonnull @Nonempty final List <String> aXSDPaths)
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
  public ICommonsList <String> getAllXSDPaths ()
  {
    return m_aDocType.getAllXSDPaths ();
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
  public Schema getSchema (@Nullable final ClassLoader aClassLoader)
  {
    return m_aDocType.getSchema (aClassLoader);
  }
}
