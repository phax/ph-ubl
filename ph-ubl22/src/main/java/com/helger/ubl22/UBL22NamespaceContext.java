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
package com.helger.ubl22;

import javax.xml.XMLConstants;

import com.helger.annotation.misc.Singleton;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.xmldsig.CXMLDSig;
import com.helger.xsds.xmldsig11.CXMLDSig11;

import jakarta.annotation.Nonnull;

/**
 * The namespace context to be used as the namespace prefix mapper.
 *
 * @author Philip Helger
 */
@Singleton
public class UBL22NamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final UBL22NamespaceContext INSTANCE = new UBL22NamespaceContext ();
  }

  protected UBL22NamespaceContext ()
  {
    addMapping ("xsi", XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
    addMapping ("xs", XMLConstants.W3C_XML_SCHEMA_NS_URI);
    addMapping ("cac", CUBL22.XML_SCHEMA_CAC_NAMESPACE_URL);
    addMapping ("cbc", CUBL22.XML_SCHEMA_CBC_NAMESPACE_URL);
    addMapping ("cec", CUBL22.XML_SCHEMA_CEC_NAMESPACE_URL);
    addMapping ("csc", CUBL22.XML_SCHEMA_CSC_NAMESPACE_URL);
    addMapping ("ds", CXMLDSig.NAMESPACE_URI);
    addMapping ("ds11", CXMLDSig11.NAMESPACE_URI);
  }

  @Nonnull
  public static UBL22NamespaceContext getInstance ()
  {
    return SingletonHolder.INSTANCE;
  }
}
