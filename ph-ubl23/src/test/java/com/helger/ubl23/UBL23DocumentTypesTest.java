/**
 * Copyright (C) 2014-2019 Philip Helger (www.helger.com)
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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Test class for class {@link UBL23DocumentTypes}.
 *
 * @author Philip Helger
 */
public final class UBL23DocumentTypesTest
{
  @Test
  public void testGetAllNamespaces ()
  {
    assertNotNull (UBL23DocumentTypes.getAllNamespaces ());
    assertNotNull (UBL23DocumentTypes.getAllLocalNames ());
    assertEquals (UBL23DocumentTypes.getAllNamespaces ().size (), UBL23DocumentTypes.getAllLocalNames ().size ());

    for (final String sNamespace : UBL23DocumentTypes.getAllNamespaces ())
    {
      assertNotNull (UBL23DocumentTypes.getDocumentTypeOfNamespace (sNamespace));
      assertNotNull (UBL23DocumentTypes.getImplementationClassOfNamespace (sNamespace));
      assertNotNull (UBL23DocumentTypes.getSchemaOfNamespace (sNamespace));
    }
    assertNull (UBL23DocumentTypes.getDocumentTypeOfNamespace ("any"));
    assertNull (UBL23DocumentTypes.getImplementationClassOfNamespace ("any"));
    assertNull (UBL23DocumentTypes.getSchemaOfNamespace ("any"));
    assertNull (UBL23DocumentTypes.getDocumentTypeOfNamespace (null));
    assertNull (UBL23DocumentTypes.getImplementationClassOfNamespace (null));
    assertNull (UBL23DocumentTypes.getSchemaOfNamespace (null));

    for (final String sNamespace : UBL23DocumentTypes.getAllLocalNames ())
    {
      assertNotNull (UBL23DocumentTypes.getDocumentTypeOfLocalName (sNamespace));
      assertNotNull (UBL23DocumentTypes.getImplementationClassOfLocalName (sNamespace));
      assertNotNull (UBL23DocumentTypes.getSchemaOfLocalName (sNamespace));
    }
    assertNull (UBL23DocumentTypes.getDocumentTypeOfLocalName ("any"));
    assertNull (UBL23DocumentTypes.getImplementationClassOfLocalName ("any"));
    assertNull (UBL23DocumentTypes.getSchemaOfLocalName ("any"));
    assertNull (UBL23DocumentTypes.getDocumentTypeOfLocalName (null));
    assertNull (UBL23DocumentTypes.getImplementationClassOfLocalName (null));
    assertNull (UBL23DocumentTypes.getSchemaOfLocalName (null));
  }

  @Test
  public void testGetSchemaOfImplementationClass ()
  {
    assertNull (UBL23DocumentTypes.getDocumentTypeOfImplementationClass (null));
    assertNull (UBL23DocumentTypes.getSchemaOfImplementationClass (null));
    assertNull (UBL23DocumentTypes.getSchemaOfImplementationClass (String.class));
    for (final EUBL23DocumentType eDocType : EUBL23DocumentType.values ())
    {
      assertSame (eDocType,
                  UBL23DocumentTypes.getDocumentTypeOfImplementationClass (eDocType.getImplementationClass ()));
      assertSame (eDocType.getSchema (),
                  UBL23DocumentTypes.getSchemaOfImplementationClass (eDocType.getImplementationClass ()));
      assertNotNull (eDocType.getValidator ());
    }
  }
}
