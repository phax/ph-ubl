/*
 * Copyright (C) 2021-2023 Jonatan Sunden
 * Copyright (C) 2021-2023 Philip Helger (www.helger.com)
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
 *
 * @author Jonatan Sunden
 * @author Philip Helger
 * @since 6.7.0
 */
@Immutable
public final class CEformsUBL
{
  /** The efext namespace URL */
  public static final String XML_SCHEMA_EFEXT_NAMESPACE_URL = "http://data.europa.eu/p27/eforms-ubl-extensions/1";

  /** The efac namespace URL */
  public static final String XML_SCHEMA_EFAC_NAMESPACE_URL = "http://data.europa.eu/p27/eforms-ubl-extension-aggregate-components/1";

  /** The efbc namespace URL */
  public static final String XML_SCHEMA_EFBC_NAMESPACE_URL = "http://data.europa.eu/p27/eforms-ubl-extension-basic-components/1";

  /** The classpath relative directory where the main XSDs reside */
  public static final String SCHEMA_DIRECTORY = "external/schemas/eforms/";

  public static final ClassPathResource XSD_EFORMS_EXTENSION_BASIC_COMPONENTS = new ClassPathResource (SCHEMA_DIRECTORY +
                                                                                                       "EFORMS-ExtensionBasicComponents-2.3.xsd",
                                                                                                       getCL ());

  public static final ClassPathResource XSD_EFORMS_EXTENSION_AGGREGATE_COMPONENTS = new ClassPathResource (SCHEMA_DIRECTORY +
                                                                                                           "EFORMS-ExtensionAggregateComponents-2.3.xsd",
                                                                                                           getCL ());

  public static final ClassPathResource XSD_EFORMS_EXTENSION_APEX = new ClassPathResource (SCHEMA_DIRECTORY +
                                                                                           "EFORMS-ExtensionApex-2.3.xsd",
                                                                                           getCL ());

  public static final ClassPathResource XSD_EFORMS_BRIN = new ClassPathResource (SCHEMA_DIRECTORY +
                                                                                 "EFORMS-BusinessRegistrationInformationNotice.xsd",
                                                                                 getCL ());

  @PresentForCodeCoverage
  private static final CEformsUBL INSTANCE = new CEformsUBL ();

  private CEformsUBL ()
  {}

  @Nonnull
  public static ClassLoader getCL ()
  {
    return CEformsUBL.class.getClassLoader ();
  }
}
