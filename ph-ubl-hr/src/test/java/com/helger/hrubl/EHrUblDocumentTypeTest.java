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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.helger.io.resource.IReadableResource;

/**
 * Test class for class {@link EHrUblDocumentType}.
 */
public final class EHrUblDocumentTypeTest
{
  @Test
  public void testAll ()
  {
    for (final EHrUblDocumentType e : EHrUblDocumentType.values ())
    {
      assertNotNull (e.getImplementationClass ());
      assertTrue (e.getAllXsdResources ().size () >= 1);
      for (final IReadableResource aRes : e.getAllXsdResources ())
        assertTrue (e.name () + " - " + aRes.getPath (), aRes.exists ());
      assertSame (e, EHrUblDocumentType.valueOf (e.name ()));
    }
  }

  @Test
  public void testExtensionXsdIsInjectedBeforeTheRootXsd ()
  {
    for (final EHrUblDocumentType e : new EHrUblDocumentType [] { EHrUblDocumentType.INVOICE,
                                                                  EHrUblDocumentType.CREDIT_NOTE })
    {
      final int nSize = e.getAllXsdResources ().size ();
      assertEquals (e.name (),
                    CHrUbl.XSD_HR_EXTENSION_AGGREGATE_COMPONENTS.getPath (),
                    e.getAllXsdResources ().get (nSize - 2).getPath ());
    }
  }
}
