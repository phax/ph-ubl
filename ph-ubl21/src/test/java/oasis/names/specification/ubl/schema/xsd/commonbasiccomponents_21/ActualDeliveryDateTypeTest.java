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
package oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_21;

import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import org.junit.Test;

/**
 * Test class for class {@link ActualDeliveryDateType}.
 *
 * @author Philip Helger
 */
public final class ActualDeliveryDateTypeTest
{
  @Test
  public void testGetterAndSetterPresent ()
  {
    final ActualDeliveryDateType x = new ActualDeliveryDateType ();
    assertNull (x.getValue ());
    x.setValue ((LocalDate) null);
  }
}
