/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Test class for class {@link UBL20DocumentTypes}.
 *
 * @author Philip Helger
 */
public final class UBL20DocumentTypesTest
{
  @Test
  public void testGetAllNamespaces ()
  {
    assertNotNull (UBL20DocumentTypes.getAllNamespaces ());
    assertNotNull (UBL20DocumentTypes.getAllLocalNames ());
    assertEquals (UBL20DocumentTypes.getAllNamespaces ().size (), UBL20DocumentTypes.getAllLocalNames ().size ());

    for (final String sNamespace : UBL20DocumentTypes.getAllNamespaces ())
    {
      assertNotNull (UBL20DocumentTypes.getDocumentTypeOfNamespace (sNamespace));
      assertNotNull (UBL20DocumentTypes.getImplementationClassOfNamespace (sNamespace));
      assertNotNull (UBL20DocumentTypes.getSchemaOfNamespace (sNamespace));
    }
    assertNull (UBL20DocumentTypes.getDocumentTypeOfNamespace ("any"));
    assertNull (UBL20DocumentTypes.getImplementationClassOfNamespace ("any"));
    assertNull (UBL20DocumentTypes.getSchemaOfNamespace ("any"));
    assertNull (UBL20DocumentTypes.getDocumentTypeOfNamespace (null));
    assertNull (UBL20DocumentTypes.getImplementationClassOfNamespace (null));
    assertNull (UBL20DocumentTypes.getSchemaOfNamespace (null));

    for (final String sNamespace : UBL20DocumentTypes.getAllLocalNames ())
    {
      assertNotNull (UBL20DocumentTypes.getDocumentTypeOfLocalName (sNamespace));
      assertNotNull (UBL20DocumentTypes.getImplementationClassOfLocalName (sNamespace));
      assertNotNull (UBL20DocumentTypes.getSchemaOfLocalName (sNamespace));
    }
    assertNull (UBL20DocumentTypes.getDocumentTypeOfLocalName ("any"));
    assertNull (UBL20DocumentTypes.getImplementationClassOfLocalName ("any"));
    assertNull (UBL20DocumentTypes.getSchemaOfLocalName ("any"));
    assertNull (UBL20DocumentTypes.getDocumentTypeOfLocalName (null));
    assertNull (UBL20DocumentTypes.getImplementationClassOfLocalName (null));
    assertNull (UBL20DocumentTypes.getSchemaOfLocalName (null));
  }

  @Test
  public void testGetSchemaOfImplementationClass ()
  {
    assertNull (UBL20DocumentTypes.getDocumentTypeOfImplementationClass (null));
    assertNull (UBL20DocumentTypes.getSchemaOfImplementationClass (null));
    assertNull (UBL20DocumentTypes.getSchemaOfImplementationClass (String.class));
    for (final EUBL20DocumentType eDocType : EUBL20DocumentType.values ())
    {
      assertSame (eDocType,
                  UBL20DocumentTypes.getDocumentTypeOfImplementationClass (eDocType.getImplementationClass ()));
      assertSame (eDocType.getSchema (),
                  UBL20DocumentTypes.getSchemaOfImplementationClass (eDocType.getImplementationClass ()));
      assertNotNull (eDocType.getValidator (null));
    }
  }
}
