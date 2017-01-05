/**
 * Copyright (C) 2014-2017 Philip Helger (www.helger.com)
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

import un.unece.uncefact.codelist.specification._54217._2001.CurrencyCodeContentType;

import com.helger.commons.string.StringHelper;

/**
 * Test class for class {@link ECurrencyCode20}.
 * 
 * @author Philip Helger
 */
public final class ECurrencyCode20Test
{
  @Test
  public void testAll ()
  {
    for (final ECurrencyCode20 e : ECurrencyCode20.values ())
    {
      assertTrue (StringHelper.hasText (e.getID ()));
      assertNotNull (e.getDisplayName ());
      assertSame (e, ECurrencyCode20.getFromIDOrNull (e.getID ()));
      assertNotNull (ECurrencyCode20.getDisplayNameFromIDOrNull (e.getID ()));
    }
    for (final CurrencyCodeContentType e : CurrencyCodeContentType.values ())
    {
      assertNotNull (ECurrencyCode20.getFromJAXBOrNull (e));
      assertNotNull (ECurrencyCode20.getDisplayNameFromJAXBOrNull (e));
    }
  }
}
