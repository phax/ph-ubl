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

import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.PresentForCodeCoverage;

/**
 * Constants for UBL 2.0 handling.
 *
 * @author Philip Helger
 */
@Immutable
public final class CUBL20
{
  /** The classpath relative directory where the main XSDs reside */
  public static final String SCHEMA_DIRECTORY = "schemas/ubl20/maindoc/";

  /** The cac namespace URL */
  public static final String XML_SCHEMA_CAC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2";

  /** The cbc namespace URL */
  public static final String XML_SCHEMA_CBC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2";

  /** The cec namespace URL */
  public static final String XML_SCHEMA_CEC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2";

  @PresentForCodeCoverage
  private static final CUBL20 s_aInstance = new CUBL20 ();

  private CUBL20 ()
  {}
}
