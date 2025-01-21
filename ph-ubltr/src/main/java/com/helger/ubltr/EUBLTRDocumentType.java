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
package com.helger.ubltr;

import javax.annotation.Nonnull;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;

import tr.gov.efatura.package_12.TRPackage;
import tr.gov.efatura.useraccount.CancelUserAccountType;
import tr.gov.efatura.useraccount.ProcessUserAccountType;

/**
 * Enumeration with all available UBLTR document types.
 *
 * @author Philip Helger
 */
public enum EUBLTRDocumentType
{
  CANCEL_USER_ACCOUNT (CancelUserAccountType.class, UBLTRMarshaller.cancelUserAccount ().getOriginalXSDs ()),
  PROCESS_USER_ACCOUNT (ProcessUserAccountType.class, UBLTRMarshaller.processUserAccount ().getOriginalXSDs ()),
  PACKAGE (TRPackage.class, UBLTRMarshaller.trPackage ().getOriginalXSDs ());

  private final Class <?> m_aImplClass;
  private final ICommonsList <ClassPathResource> m_aXSDs;

  EUBLTRDocumentType (@Nonnull final Class <?> aClass, @Nonnull @Nonempty final ICommonsList <ClassPathResource> aXSDPaths)
  {
    m_aImplClass = aClass;
    m_aXSDs = aXSDPaths;
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aImplClass;
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableCopy
  public ICommonsList <ClassPathResource> getAllXSDResources ()
  {
    return m_aXSDs.getClone ();
  }
}
