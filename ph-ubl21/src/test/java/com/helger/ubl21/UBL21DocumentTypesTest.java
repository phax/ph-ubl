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
package com.helger.ubl21;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Test class for class {@link UBL21DocumentTypes}.
 *
 * @author Philip Helger
 */
public final class UBL21DocumentTypesTest
{
  @Test
  public void testGetAllNamespaces ()
  {
    assertNotNull (UBL21DocumentTypes.getAllNamespaces ());
    assertNotNull (UBL21DocumentTypes.getAllLocalNames ());
    assertEquals (UBL21DocumentTypes.getAllNamespaces ().size (), UBL21DocumentTypes.getAllLocalNames ().size ());

    for (final String sNamespace : UBL21DocumentTypes.getAllNamespaces ())
    {
      assertNotNull (UBL21DocumentTypes.getDocumentTypeOfNamespace (sNamespace));
      assertNotNull (UBL21DocumentTypes.getImplementationClassOfNamespace (sNamespace));
      assertNotNull (UBL21DocumentTypes.getSchemaOfNamespace (sNamespace));
    }
    assertNull (UBL21DocumentTypes.getDocumentTypeOfNamespace ("any"));
    assertNull (UBL21DocumentTypes.getImplementationClassOfNamespace ("any"));
    assertNull (UBL21DocumentTypes.getSchemaOfNamespace ("any"));
    assertNull (UBL21DocumentTypes.getDocumentTypeOfNamespace (null));
    assertNull (UBL21DocumentTypes.getImplementationClassOfNamespace (null));
    assertNull (UBL21DocumentTypes.getSchemaOfNamespace (null));

    for (final String sNamespace : UBL21DocumentTypes.getAllLocalNames ())
    {
      assertNotNull (UBL21DocumentTypes.getDocumentTypeOfLocalName (sNamespace));
      assertNotNull (UBL21DocumentTypes.getImplementationClassOfLocalName (sNamespace));
      assertNotNull (UBL21DocumentTypes.getSchemaOfLocalName (sNamespace));
    }
    assertNull (UBL21DocumentTypes.getDocumentTypeOfLocalName ("any"));
    assertNull (UBL21DocumentTypes.getImplementationClassOfLocalName ("any"));
    assertNull (UBL21DocumentTypes.getSchemaOfLocalName ("any"));
    assertNull (UBL21DocumentTypes.getDocumentTypeOfLocalName (null));
    assertNull (UBL21DocumentTypes.getImplementationClassOfLocalName (null));
    assertNull (UBL21DocumentTypes.getSchemaOfLocalName (null));
  }

  @Test
  public void testGetSchemaOfImplementationClass ()
  {
    assertNull (UBL21DocumentTypes.getDocumentTypeOfImplementationClass (null));
    assertNull (UBL21DocumentTypes.getSchemaOfImplementationClass (null));
    assertNull (UBL21DocumentTypes.getSchemaOfImplementationClass (String.class));
    for (final EUBL21DocumentType eDocType : EUBL21DocumentType.values ())
    {
      assertSame (eDocType,
                  UBL21DocumentTypes.getDocumentTypeOfImplementationClass (eDocType.getImplementationClass ()));
      assertSame (eDocType.getSchema (),
                  UBL21DocumentTypes.getSchemaOfImplementationClass (eDocType.getImplementationClass ()));
      assertNotNull (eDocType.getValidator ());
    }
  }
}
