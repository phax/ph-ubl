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
package com.helger.ubl20;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.helger.commons.collection.impl.CommonsHashSet;
import com.helger.commons.collection.impl.ICommonsSet;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.string.StringHelper;

/**
 * Test class for class {@link EUBL20DocumentType}.
 *
 * @author Philip Helger
 */
public final class EUBL20DocumentTypeTest
{
  @Test
  public void testAll ()
  {
    final ICommonsSet <Class <?>> aClasses = new CommonsHashSet <> ();
    final ICommonsSet <String> aFilenames = new CommonsHashSet <> ();
    for (final EUBL20DocumentType e : EUBL20DocumentType.values ())
    {
      assertNotNull (e.getImplementationClass ());

      assertTrue (e.getAllXSDResources ().size () >= 1);
      for (final IReadableResource aRes : e.getAllXSDResources ())
        assertTrue (e.name (), aRes.exists ());

      assertTrue (StringHelper.hasText (e.getRootElementLocalName ()));
      assertTrue (StringHelper.hasText (e.getRootElementNamespaceURI ()));

      assertSame (e, EUBL20DocumentType.valueOf (e.name ()));
      assertTrue (aClasses.add (e.getImplementationClass ()));
      assertTrue (aFilenames.add (e.getAllXSDResources ().getLastOrNull ().getPath ()));
    }

    assertEquals ("OrderCancellation", EUBL20DocumentType.ORDER_CANCELLATION.getRootElementLocalName ());
    assertEquals ("urn:oasis:names:specification:ubl:schema:xsd:OrderCancellation-2",
                  EUBL20DocumentType.ORDER_CANCELLATION.getRootElementNamespaceURI ());
  }
}
