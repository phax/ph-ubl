/**
 * Copyright (C) 2014-2021 Philip Helger (www.helger.com)
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
package com.helger.ubl21;

import javax.annotation.Nonnull;
import javax.xml.XMLConstants;

import com.helger.commons.annotation.Singleton;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.xmldsig.CXMLDSig;

/**
 * The namespace context to be used as the namespace prefix mapper.
 *
 * @author Philip Helger
 */
@Singleton
public class UBL21NamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final UBL21NamespaceContext INSTANCE = new UBL21NamespaceContext ();
  }

  protected UBL21NamespaceContext ()
  {
    addMapping ("xsi", XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
    addMapping ("xs", XMLConstants.W3C_XML_SCHEMA_NS_URI);
    addMapping ("cac", CUBL21.XML_SCHEMA_CAC_NAMESPACE_URL);
    addMapping ("cbc", CUBL21.XML_SCHEMA_CBC_NAMESPACE_URL);
    addMapping ("cec", CUBL21.XML_SCHEMA_CEC_NAMESPACE_URL);
    addMapping ("ds", CXMLDSig.NAMESPACE_URI);
  }

  @Nonnull
  public static UBL21NamespaceContext getInstance ()
  {
    return SingletonHolder.INSTANCE;
  }
}
