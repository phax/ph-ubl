/*
 * Copyright (C) 2020-2025 Philip Helger (www.helger.com)
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
package com.helger.dianubl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.helger.io.resource.IReadableResource;

/**
 * Test class for class {@link EDianUBLDocumentType}.
 *
 * @author Philip Helger
 */
public final class EDianUBLDocumentTypeTest
{
  @Test
  public void testAll ()
  {
    for (final EDianUBLDocumentType e : EDianUBLDocumentType.values ())
    {
      assertNotNull (e.getImplementationClass ());
      assertTrue (e.getAllXSDResources ().size () >= 1);
      for (final IReadableResource aRes : e.getAllXSDResources ())
        assertTrue (e.name (), aRes.exists ());
      assertSame (e, EDianUBLDocumentType.valueOf (e.name ()));
    }
  }
}
