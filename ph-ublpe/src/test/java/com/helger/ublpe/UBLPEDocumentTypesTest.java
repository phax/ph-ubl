/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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
package com.helger.ublpe;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Test class for class {@link UBLPEDocumentTypes}.
 *
 * @author Philip Helger
 */
public final class UBLPEDocumentTypesTest
{
  @Test
  public void testGetAllNamespaces ()
  {
    for (final String sNamespace : UBLPEDocumentTypes.getAllLocalNames ())
    {
      assertNotNull (UBLPEDocumentTypes.getDocumentTypeOfLocalName (sNamespace));
      assertNotNull (UBLPEDocumentTypes.getImplementationClassOfLocalName (sNamespace));
      assertNotNull (UBLPEDocumentTypes.getSchemaOfLocalName (sNamespace));
    }
    assertNull (UBLPEDocumentTypes.getDocumentTypeOfLocalName ("any"));
    assertNull (UBLPEDocumentTypes.getImplementationClassOfLocalName ("any"));
    assertNull (UBLPEDocumentTypes.getSchemaOfLocalName ("any"));
    assertNull (UBLPEDocumentTypes.getDocumentTypeOfLocalName (null));
    assertNull (UBLPEDocumentTypes.getImplementationClassOfLocalName (null));
    assertNull (UBLPEDocumentTypes.getSchemaOfLocalName (null));
  }

  @Test
  public void testGetSchemaOfImplementationClass ()
  {
    assertNull (UBLPEDocumentTypes.getDocumentTypeOfImplementationClass (null));
    assertNull (UBLPEDocumentTypes.getSchemaOfImplementationClass (null));
    assertNull (UBLPEDocumentTypes.getSchemaOfImplementationClass (String.class));
    for (final EUBLPEDocumentType eDocType : EUBLPEDocumentType.values ())
    {
      assertSame (eDocType, UBLPEDocumentTypes.getDocumentTypeOfImplementationClass (eDocType.getImplementationClass ()));
      assertSame (eDocType.getSchema (), UBLPEDocumentTypes.getSchemaOfImplementationClass (eDocType.getImplementationClass ()));
      assertNotNull (eDocType.getValidator (null));
    }
  }
}
