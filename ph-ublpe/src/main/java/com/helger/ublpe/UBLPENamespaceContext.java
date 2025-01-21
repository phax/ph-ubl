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
package com.helger.ublpe;

import javax.annotation.Nonnull;

import com.helger.ubl20.UBL20NamespaceContext;

/**
 * The namespace context to be used as the namespace prefix mapper.
 *
 * @author Philip Helger
 */
public class UBLPENamespaceContext extends UBL20NamespaceContext
{
  private static final class SingletonHolder
  {
    static final UBLPENamespaceContext INSTANCE = new UBLPENamespaceContext ();
  }

  public UBLPENamespaceContext ()
  {
    addMapping ("sac", CUBLPE.XML_SCHEMA_SAC_NAMESPACE_URL);
  }

  @Nonnull
  public static UBLPENamespaceContext getInstance ()
  {
    return SingletonHolder.INSTANCE;
  }
}
