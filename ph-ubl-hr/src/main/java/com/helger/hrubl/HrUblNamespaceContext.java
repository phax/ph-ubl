/*
 * Copyright (C) 2026 Philip Helger (www.helger.com)
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
package com.helger.hrubl;

import org.jspecify.annotations.NonNull;

import com.helger.ubl21.UBL21NamespaceContext;

/**
 * The namespace context to be used as the namespace prefix mapper.
 */
public class HrUblNamespaceContext extends UBL21NamespaceContext
{
  private static final class SingletonHolder
  {
    static final HrUblNamespaceContext INSTANCE = new HrUblNamespaceContext ();
  }

  protected HrUblNamespaceContext ()
  {
    super ();
    // Change cec to ext - the prefix used by the Croatian examples
    addMapping ("ext", getCustomNamespaceURI ("cec"));
    removeMapping ("cec");
    // Add the Croatian extension mapping
    addMapping ("hrextac", CHrUbl.XML_SCHEMA_HREXTAC_NAMESPACE_URL);
  }

  @NonNull
  public static HrUblNamespaceContext getInstance ()
  {
    return SingletonHolder.INSTANCE;
  }
}
