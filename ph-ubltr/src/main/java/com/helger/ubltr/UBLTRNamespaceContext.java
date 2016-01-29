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

import javax.annotation.Nonnull;

import com.helger.commons.annotation.Singleton;
import com.helger.commons.xml.CXML;
import com.helger.commons.xml.namespace.MapBasedNamespaceContext;
import com.helger.ubl21.CUBL21;

/**
 * The namespace context to be used as the namespace prefix mapper.
 *
 * @author Philip Helger
 */
@Singleton
public class UBLTRNamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final UBLTRNamespaceContext s_aInstance = new UBLTRNamespaceContext ();
  }

  protected UBLTRNamespaceContext ()
  {
    addMapping ("xsi", CXML.XML_NS_XSI);
    addMapping ("xs", CXML.XML_NS_XSD);
    addMapping ("cac", CUBL21.XML_SCHEMA_CAC_NAMESPACE_URL);
    addMapping ("cbc", CUBL21.XML_SCHEMA_CBC_NAMESPACE_URL);
    addMapping ("cec", CUBL21.XML_SCHEMA_CEC_NAMESPACE_URL);
  }

  @Nonnull
  public static UBLTRNamespaceContext getInstance ()
  {
    return SingletonHolder.s_aInstance;
  }
}
