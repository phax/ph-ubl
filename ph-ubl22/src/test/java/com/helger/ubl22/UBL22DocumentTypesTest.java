/*
 * Copyright (C) 2014-2022 Philip Helger (www.helger.com)
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
package com.helger.ubl22;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Test class for class {@link UBL22DocumentTypes}.
 *
 * @author Philip Helger
 */
public final class UBL22DocumentTypesTest
{
  @Test
  public void testGetAllNamespaces ()
  {
    assertNotNull (UBL22DocumentTypes.getAllNamespaces ());
    assertNotNull (UBL22DocumentTypes.getAllLocalNames ());
    assertEquals (UBL22DocumentTypes.getAllNamespaces ().size (), UBL22DocumentTypes.getAllLocalNames ().size ());

    for (final String sNamespace : UBL22DocumentTypes.getAllNamespaces ())
    {
      assertNotNull (UBL22DocumentTypes.getDocumentTypeOfNamespace (sNamespace));
      assertNotNull (UBL22DocumentTypes.getImplementationClassOfNamespace (sNamespace));
      assertNotNull (UBL22DocumentTypes.getSchemaOfNamespace (sNamespace));
    }
    assertNull (UBL22DocumentTypes.getDocumentTypeOfNamespace ("any"));
    assertNull (UBL22DocumentTypes.getImplementationClassOfNamespace ("any"));
    assertNull (UBL22DocumentTypes.getSchemaOfNamespace ("any"));
    assertNull (UBL22DocumentTypes.getDocumentTypeOfNamespace (null));
    assertNull (UBL22DocumentTypes.getImplementationClassOfNamespace (null));
    assertNull (UBL22DocumentTypes.getSchemaOfNamespace (null));

    for (final String sNamespace : UBL22DocumentTypes.getAllLocalNames ())
    {
      assertNotNull (UBL22DocumentTypes.getDocumentTypeOfLocalName (sNamespace));
      assertNotNull (UBL22DocumentTypes.getImplementationClassOfLocalName (sNamespace));
      assertNotNull (UBL22DocumentTypes.getSchemaOfLocalName (sNamespace));
    }
    assertNull (UBL22DocumentTypes.getDocumentTypeOfLocalName ("any"));
    assertNull (UBL22DocumentTypes.getImplementationClassOfLocalName ("any"));
    assertNull (UBL22DocumentTypes.getSchemaOfLocalName ("any"));
    assertNull (UBL22DocumentTypes.getDocumentTypeOfLocalName (null));
    assertNull (UBL22DocumentTypes.getImplementationClassOfLocalName (null));
    assertNull (UBL22DocumentTypes.getSchemaOfLocalName (null));
  }

  @Test
  public void testGetSchemaOfImplementationClass ()
  {
    assertNull (UBL22DocumentTypes.getDocumentTypeOfImplementationClass (null));
    assertNull (UBL22DocumentTypes.getSchemaOfImplementationClass (null));
    assertNull (UBL22DocumentTypes.getSchemaOfImplementationClass (String.class));
    for (final EUBL22DocumentType eDocType : EUBL22DocumentType.values ())
    {
      assertSame (eDocType, UBL22DocumentTypes.getDocumentTypeOfImplementationClass (eDocType.getImplementationClass ()));
      assertSame (eDocType.getSchema (), UBL22DocumentTypes.getSchemaOfImplementationClass (eDocType.getImplementationClass ()));
      assertNotNull (eDocType.getValidator ());
    }
  }
}
