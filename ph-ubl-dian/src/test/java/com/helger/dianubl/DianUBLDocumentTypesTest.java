/*
 * Copyright (C) 2020-2024 Philip Helger (www.helger.com)
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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Test class for class {@link DianUBLDocumentTypes}.
 *
 * @author Philip Helger
 */
@Deprecated (forRemoval = true, since = "8.0.0")
public final class DianUBLDocumentTypesTest
{
  @Test
  public void testGetAllNamespaces ()
  {
    for (final String sNamespace : DianUBLDocumentTypes.getAllLocalNames ())
    {
      assertNotNull (DianUBLDocumentTypes.getDocumentTypeOfLocalName (sNamespace));
      assertNotNull (DianUBLDocumentTypes.getImplementationClassOfLocalName (sNamespace));
      assertNotNull (DianUBLDocumentTypes.getSchemaOfLocalName (sNamespace));
    }
    assertNull (DianUBLDocumentTypes.getDocumentTypeOfLocalName ("any"));
    assertNull (DianUBLDocumentTypes.getImplementationClassOfLocalName ("any"));
    assertNull (DianUBLDocumentTypes.getSchemaOfLocalName ("any"));
    assertNull (DianUBLDocumentTypes.getDocumentTypeOfLocalName (null));
    assertNull (DianUBLDocumentTypes.getImplementationClassOfLocalName (null));
    assertNull (DianUBLDocumentTypes.getSchemaOfLocalName (null));
  }

  @Test
  public void testGetSchemaOfImplementationClass ()
  {
    assertNull (DianUBLDocumentTypes.getDocumentTypeOfImplementationClass (null));
    assertNull (DianUBLDocumentTypes.getSchemaOfImplementationClass (null));
    assertNull (DianUBLDocumentTypes.getSchemaOfImplementationClass (String.class));
    for (final EDianUBLDocumentType eDocType : EDianUBLDocumentType.values ())
    {
      assertSame (eDocType,
                  DianUBLDocumentTypes.getDocumentTypeOfImplementationClass (eDocType.getImplementationClass ()));
      assertSame (eDocType.getSchema (),
                  DianUBLDocumentTypes.getSchemaOfImplementationClass (eDocType.getImplementationClass ()));
      assertNotNull (eDocType.getValidator (null));
    }
  }
}
