/*
 * Copyright (C) 2020-2021 Philip Helger (www.helger.com)
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
package com.helger.eforms;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.io.resource.ClassPathResource;

/**
 * Constants for Eforms UBL handling.
 */
@Immutable
public final class CEformsUBL
{
  @Nonnull
  private static ClassLoader _getCL ()
  {
    return CEformsUBL.class.getClassLoader ();
  }

  /** The efext namespace URL */
  public static final String XML_SCHEMA_EFEXT_NAMESPACE_URL = "http://data.europa.eu/p27/eforms-ubl-extensions/1";

  /** The efac namespace URL */
  public static final String XML_SCHEMA_EFAC_NAMESPACE_URL = "http://data.europa.eu/p27/eforms-ubl-extension-aggregate-components/1";

  /** The efbc namespace URL */
  public static final String XML_SCHEMA_EFBC_NAMESPACE_URL = "http://data.europa.eu/p27/eforms-ubl-extension-basic-components/1";

  /** The cac namespace URL */
  public static final String XML_SCHEMA_CAC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2";

  /** The cbc namespace URL */
  public static final String XML_SCHEMA_CBC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2";

  /** The ext namespace URL */
  public static final String XML_SCHEMA_EXT_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2";

  public static final ClassPathResource XSD_CAN_XML_STRUCTURE =
          new ClassPathResource("/schemas/eforms/maindoc/UBL-ContractAwardNotice-2.3.xsd", _getCL());
  public static final ClassPathResource XSD_CN_XML_STRUCTURE =
          new ClassPathResource("/schemas/eforms/maindoc/UBL-ContractNotice-2.3.xsd", _getCL());
  public static final ClassPathResource XSD_PIN_XML_STRUCTURE =
          new ClassPathResource("/schemas/eforms/maindoc/UBL-PriorInformationNotice-2.3.xsd", _getCL());
  public static final ClassPathResource XSD_BRIN_XML_STRUCTURE =
          new ClassPathResource("/schemas/eforms/maindoc/EFORMS-BusinessRegistrationInformationNotice.xsd", _getCL());

  @PresentForCodeCoverage
  private static final CEformsUBL INSTANCE = new CEformsUBL();

  private CEformsUBL()
  {}
}
