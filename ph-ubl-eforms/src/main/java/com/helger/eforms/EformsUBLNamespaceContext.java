/*
 * Copyright (C) 2020-2021 Philip Helger (www.helger.com)
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
import javax.xml.XMLConstants;

import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.xmldsig.CXMLDSig;

public class EformsUBLNamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final EformsUBLNamespaceContext INSTANCE = new EformsUBLNamespaceContext ();
  }

  protected EformsUBLNamespaceContext ()
  {
    addMapping ("xsi", XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
    addMapping ("xs", XMLConstants.W3C_XML_SCHEMA_NS_URI);
    addMapping ("ext", CEformsUBL.XML_SCHEMA_EXT_NAMESPACE_URL);
    addMapping ("efext", CEformsUBL.XML_SCHEMA_EFEXT_NAMESPACE_URL);
    addMapping ("efbc", CEformsUBL.XML_SCHEMA_EFBC_NAMESPACE_URL);
    addMapping ("efac", CEformsUBL.XML_SCHEMA_EFAC_NAMESPACE_URL);
    addMapping ("cac", CEformsUBL.XML_SCHEMA_CAC_NAMESPACE_URL);
    addMapping ("cbc", CEformsUBL.XML_SCHEMA_CBC_NAMESPACE_URL);
    addMapping ("ds", CXMLDSig.NAMESPACE_URI);

  }

  @Nonnull
  public static EformsUBLNamespaceContext getInstance ()
  {
    return SingletonHolder.INSTANCE;
  }
}