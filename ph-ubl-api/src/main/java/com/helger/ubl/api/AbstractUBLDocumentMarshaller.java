/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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
package com.helger.ubl.api;

import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.namespace.NamespaceContext;

/**
 * Base class for document marshallers encapsulating the common elements.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public abstract class AbstractUBLDocumentMarshaller
{
  private static ValidationEventHandler s_aGlobalEventHandler = null;
  private static NamespaceContext s_aGlobalNamespaceContext = null;

  protected AbstractUBLDocumentMarshaller ()
  {}

  /**
   * Set a global event handler that should be passed to all read/write actions.
   * If no global validation handler is defined, a default logging event handler
   * is used.
   *
   * @param aGlobalEventHandler
   *          The new global event handler. May be <code>null</code> to
   *          indicate, that the default handler should be used.
   */
  public static final void setGlobalValidationEventHandler (@Nullable final ValidationEventHandler aGlobalEventHandler)
  {
    s_aGlobalEventHandler = aGlobalEventHandler;
  }

  /**
   * @return The current global validation event handler. May be
   *         <code>null</code> to indicate that no global validation event
   *         handler is defined, and the default validation handler is used.
   */
  @Nullable
  public static final ValidationEventHandler getGlobalValidationEventHandler ()
  {
    return s_aGlobalEventHandler;
  }

  /**
   * Set a global namespace context that should be passed to all write actions.
   * If no global namespace context is defined, a default namespace context is
   * used.
   *
   * @param aGlobalNamespaceContext
   *          The new global namespace context. May be <code>null</code> to
   *          indicate, that the default namespace context should be used.
   */
  public static final void setGlobalNamespaceContext (@Nullable final NamespaceContext aGlobalNamespaceContext)
  {
    s_aGlobalNamespaceContext = aGlobalNamespaceContext;
  }

  /**
   * @return The current global namespace context. May be <code>null</code> to
   *         indicate that no global namespace context is defined, and the
   *         default namespace context is used.
   */
  @Nullable
  public static final NamespaceContext getGlobalNamespaceContext ()
  {
    return s_aGlobalNamespaceContext;
  }
}
