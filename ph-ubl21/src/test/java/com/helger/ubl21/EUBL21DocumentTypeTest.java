/*
 * Copyright (C) 2014-2024 Philip Helger (www.helger.com)
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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.helger.commons.collection.impl.CommonsHashSet;
import com.helger.commons.collection.impl.ICommonsSet;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.string.StringHelper;

/**
 * Test class for class {@link EUBL21DocumentTypeSimple}.
 *
 * @author Philip Helger
 */
@Deprecated (forRemoval = true, since = "8.0.0")
public final class EUBL21DocumentTypeTest
{
  @Test
  public void testAll ()
  {
    final ICommonsSet <Class <?>> aClasses = new CommonsHashSet <> ();
    final ICommonsSet <String> aFilenames = new CommonsHashSet <> ();
    for (final EUBL21DocumentType e : EUBL21DocumentType.values ())
    {
      assertNotNull (e.getImplementationClass ());
      assertTrue (StringHelper.hasText (e.getLocalName ()));
      assertTrue (StringHelper.hasText (e.getNamespaceURI ()));
      assertTrue (e.getAllXSDResources ().size () >= 1);
      for (final IReadableResource aRes : e.getAllXSDResources ())
        assertTrue (e.name (), aRes.exists ());
      assertNotNull (e.getSchema ());
      assertSame (e.getSchema (), e.getSchema ());
      assertSame (e, EUBL21DocumentType.valueOf (e.name ()));
      assertTrue (aClasses.add (e.getImplementationClass ()));
      assertTrue (aFilenames.add (e.getAllXSDResources ().getLast ().getPath ()));
    }
  }
}
