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
package com.helger.ubl21;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.helger.xml.namespace.MapBasedNamespaceContext;

/**
 * Test class for class {@link UBL21NamespaceContext}.
 *
 * @author Philip Helger
 */
public final class UBL21NamespaceContextTest
{
  @Test
  public void testIssue25 ()
  {
    final MapBasedNamespaceContext aNSCtx = UBL21NamespaceContext.getInstance ().getClone ();
    assertSame (aNSCtx, aNSCtx.removeMapping ("cec"));
    assertSame (aNSCtx, aNSCtx.removeMapping ("cec"));
  }

  @Test
  public void testIssue25v2 ()
  {
    try
    {
      // Get the original
      final UBL21NamespaceContext aNSCtx0 = UBL21NamespaceContext.getInstance ();
      // Clone
      final MapBasedNamespaceContext aNSCtx = UBL21NamespaceContext.getInstance ().getClone ();
      // Remove in original
      assertSame (aNSCtx0, aNSCtx0.removeMapping ("cec"));
      assertSame (aNSCtx0, aNSCtx0.removeMapping ("cec"));
      // Remove in clone
      assertSame (aNSCtx, aNSCtx.removeMapping ("cec"));
      assertSame (aNSCtx, aNSCtx.removeMapping ("cec"));
    }
    finally
    {
      // Restore original state
      UBL21NamespaceContext.getInstance ().addMapping ("cec", CUBL21.XML_SCHEMA_CEC_NAMESPACE_URL);
    }
  }
}
