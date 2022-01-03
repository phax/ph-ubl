/*
 * Copyright (C) 2021-2022 Jonatan Sunden
 * Copyright (C) 2021-2022 Philip Helger (www.helger.com)
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
package com.helger.eforms;

import javax.annotation.Nonnull;

import com.helger.ubl23.UBL23NamespaceContext;

/**
 * EForms XML Namespace context
 *
 * @author Philip Helger
 * @since 6.7.0
 */
public class EformsUBLNamespaceContext extends UBL23NamespaceContext
{
  private static final class SingletonHolder
  {
    static final EformsUBLNamespaceContext INSTANCE = new EformsUBLNamespaceContext ();
  }

  protected EformsUBLNamespaceContext ()
  {
    addMapping ("efext", CEformsUBL.XML_SCHEMA_EFEXT_NAMESPACE_URL);
    addMapping ("efbc", CEformsUBL.XML_SCHEMA_EFBC_NAMESPACE_URL);
    addMapping ("efac", CEformsUBL.XML_SCHEMA_EFAC_NAMESPACE_URL);
  }

  @Nonnull
  public static EformsUBLNamespaceContext getInstance ()
  {
    return SingletonHolder.INSTANCE;
  }
}
