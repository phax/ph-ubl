/**
 * Copyright (C) 2014-2021 Philip Helger (www.helger.com)
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
package com.helger.ubl20.codelist;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.helger.commons.string.StringHelper;

import un.unece.uncefact.codelist.specification._66411._2001.UnitCodeContentType;

/**
 * Test class for class {@link EUnitOfMeasureCode20}.
 * 
 * @author Philip Helger
 */
public final class EUnitOfMeasureCode20Test
{
  @Test
  public void testAll ()
  {
    for (final EUnitOfMeasureCode20 e : EUnitOfMeasureCode20.values ())
    {
      assertTrue (StringHelper.hasText (e.getID ()));
      assertNotNull (e.getDisplayName ());
      assertSame (e, EUnitOfMeasureCode20.getFromIDOrNull (e.getID ()));
      assertNotNull (EUnitOfMeasureCode20.getDisplayNameFromIDOrNull (e.getID ()));
    }
    for (final UnitCodeContentType e : UnitCodeContentType.values ())
    {
      assertNotNull (EUnitOfMeasureCode20.getFromJAXBOrNull (e));
      assertNotNull (EUnitOfMeasureCode20.getDisplayNameFromJAXBOrNull (e));
    }
  }
}
