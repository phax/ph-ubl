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
package com.helger.ubl23;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.helger.base.string.StringHelper;
import com.helger.collection.commons.CommonsHashSet;
import com.helger.collection.commons.ICommonsSet;
import com.helger.io.resource.IReadableResource;

/**
 * Test class for class {@link EUBL23DocumentType}.
 *
 * @author Philip Helger
 */
public final class EUBL23DocumentTypeTest
{
  @Test
  public void testAll ()
  {
    final ICommonsSet <Class <?>> aClasses = new CommonsHashSet <> ();
    final ICommonsSet <String> aFilenames = new CommonsHashSet <> ();
    for (final EUBL23DocumentType e : EUBL23DocumentType.values ())
    {
      assertNotNull (e.getImplementationClass ());

      assertTrue (e.getAllXSDResources ().size () >= 1);
      for (final IReadableResource aRes : e.getAllXSDResources ())
        assertTrue (e.name (), aRes.exists ());

      assertTrue (StringHelper.isNotEmpty (e.getRootElementLocalName ()));
      assertTrue (StringHelper.isNotEmpty (e.getRootElementNamespaceURI ()));

      assertSame (e, EUBL23DocumentType.valueOf (e.name ()));
      assertTrue (aClasses.add (e.getImplementationClass ()));
      assertTrue (aFilenames.add (e.getAllXSDResources ().getLastOrNull ().getPath ()));
    }

    assertEquals ("OrderCancellation", EUBL23DocumentType.ORDER_CANCELLATION.getRootElementLocalName ());
    assertEquals ("urn:oasis:names:specification:ubl:schema:xsd:OrderCancellation-2",
                  EUBL23DocumentType.ORDER_CANCELLATION.getRootElementNamespaceURI ());
  }
}
