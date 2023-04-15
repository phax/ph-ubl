/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
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
package com.helger.ubltr;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Test class for class {@link UBLTRDocumentTypes}.
 *
 * @author Philip Helger
 */
@Deprecated (forRemoval = true, since = "8.0.0")
public final class UBLTRDocumentTypesTest
{
  @Test
  public void testGetAllNamespaces ()
  {
    for (final String sNamespace : UBLTRDocumentTypes.getAllLocalNames ())
    {
      assertNotNull (UBLTRDocumentTypes.getDocumentTypeOfLocalName (sNamespace));
      assertNotNull (UBLTRDocumentTypes.getImplementationClassOfLocalName (sNamespace));
      assertNotNull (UBLTRDocumentTypes.getSchemaOfLocalName (sNamespace));
    }
    assertNull (UBLTRDocumentTypes.getDocumentTypeOfLocalName ("any"));
    assertNull (UBLTRDocumentTypes.getImplementationClassOfLocalName ("any"));
    assertNull (UBLTRDocumentTypes.getSchemaOfLocalName ("any"));
    assertNull (UBLTRDocumentTypes.getDocumentTypeOfLocalName (null));
    assertNull (UBLTRDocumentTypes.getImplementationClassOfLocalName (null));
    assertNull (UBLTRDocumentTypes.getSchemaOfLocalName (null));
  }

  @Test
  public void testGetSchemaOfImplementationClass ()
  {
    assertNull (UBLTRDocumentTypes.getDocumentTypeOfImplementationClass (null));
    assertNull (UBLTRDocumentTypes.getSchemaOfImplementationClass (null));
    assertNull (UBLTRDocumentTypes.getSchemaOfImplementationClass (String.class));
    for (final EUBLTRDocumentType eDocType : EUBLTRDocumentType.values ())
    {
      assertSame (eDocType,
                  UBLTRDocumentTypes.getDocumentTypeOfImplementationClass (eDocType.getImplementationClass ()));
      assertSame (eDocType.getSchema (),
                  UBLTRDocumentTypes.getSchemaOfImplementationClass (eDocType.getImplementationClass ()));
      assertNotNull (eDocType.getValidator (null));
    }
  }
}
