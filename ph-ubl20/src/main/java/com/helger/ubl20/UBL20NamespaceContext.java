/*
 * Copyright (C) 2014-2026 Philip Helger (www.helger.com)
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
package com.helger.ubl20;

import javax.xml.XMLConstants;

import org.jspecify.annotations.NonNull;

import com.helger.annotation.misc.Singleton;
import com.helger.xml.namespace.MapBasedNamespaceContext;

/**
 * The namespace context to be used as the namespace prefix mapper.
 *
 * @author Philip Helger
 */
@Singleton
public class UBL20NamespaceContext extends MapBasedNamespaceContext
{
  private static final class SingletonHolder
  {
    static final UBL20NamespaceContext INSTANCE = new UBL20NamespaceContext ();
  }

  protected UBL20NamespaceContext ()
  {
    addMapping ("xsi", XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
    addMapping ("xs", XMLConstants.W3C_XML_SCHEMA_NS_URI);
    addMapping ("cac", CUBL20.XML_SCHEMA_CAC_NAMESPACE_URL);
    addMapping ("cbc", CUBL20.XML_SCHEMA_CBC_NAMESPACE_URL);
    addMapping ("cec", CUBL20.XML_SCHEMA_CEC_NAMESPACE_URL);
  }

  @NonNull
  public static UBL20NamespaceContext getInstance ()
  {
    return SingletonHolder.INSTANCE;
  }
}
