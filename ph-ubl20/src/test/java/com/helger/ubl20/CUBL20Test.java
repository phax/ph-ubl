/*
 * Copyright (C) 2014-2026 Philip Helger (www.helger.com)
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

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Test class for class {@link CUBL20}.
 *
 * @author Philip Helger
 */
public final class CUBL20Test
{
  @Test
  public void testBasic () throws Exception
  {
    assertTrue (CUBL20.XSD_CODELIST_CURRENCY_CODE.exists ());
    assertTrue (CUBL20.XSD_CODELIST_LANGUAGE_CODE.exists ());
    assertTrue (CUBL20.XSD_CODELIST_MIME_MEDIA_TYPE_CODE.exists ());
    assertTrue (CUBL20.XSD_CODELIST_UNIT_CODE.exists ());
    assertTrue (CUBL20.XSD_COMMON_AGGREGATE_COMPONENTS.exists ());
    assertTrue (CUBL20.XSD_COMMON_BASIC_COMPONENTS.exists ());
    assertTrue (CUBL20.XSD_COMMON_EXTENSION_COMPONENTS.exists ());
    assertTrue (CUBL20.XSD_CORE_COMPONENT_PARAMETERS.exists ());
    assertTrue (CUBL20.XSD_EXTENSION_CONTENT_DATA_TYPE.exists ());
    assertTrue (CUBL20.XSD_QUALIFIED_DATA_TYPES.exists ());
    assertTrue (CUBL20.XSD_UNQUALIFIED_DATA_TYPES.exists ());
  }
}
