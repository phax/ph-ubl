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
package com.helger.ubl24;

import org.jspecify.annotations.NonNull;

import com.helger.annotation.concurrent.Immutable;
import com.helger.annotation.style.PresentForCodeCoverage;
import com.helger.io.resource.ClassPathResource;

/**
 * Constants for UBL 2.4 handling.
 *
 * @author Philip Helger
 */
@Immutable
public final class CUBL24
{
  private static final String PREFIX = "external/schemas/";

  /** The classpath relative directory where the main XSDs reside */
  public static final String SCHEMA_DIRECTORY = PREFIX + "ubl24/maindoc/";

  /** The cac namespace URL */
  public static final String XML_SCHEMA_CAC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2";

  /** The cbc namespace URL */
  public static final String XML_SCHEMA_CBC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2";

  /** The cec namespace URL */
  public static final String XML_SCHEMA_CEC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2";

  /** The csc namespace URL */
  public static final String XML_SCHEMA_CSC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonSignatureComponents-2";

  public static final ClassPathResource XSD_COMMON_AGGREGATE_COMPONENTS = new ClassPathResource (PREFIX +
                                                                                                 "ubl24/common/UBL-CommonAggregateComponents-2.4.xsd",
                                                                                                 getCL ());
  public static final ClassPathResource XSD_COMMON_BASIC_COMPONENTS = new ClassPathResource (PREFIX +
                                                                                             "ubl24/common/UBL-CommonBasicComponents-2.4.xsd",
                                                                                             getCL ());
  public static final ClassPathResource XSD_COMMON_EXTENSION_COMPONENTS = new ClassPathResource (PREFIX +
                                                                                                 "ubl24/common/UBL-CommonExtensionComponents-2.4.xsd",
                                                                                                 getCL ());
  public static final ClassPathResource XSD_COMMON_SIGNATURE_COMPONENTS = new ClassPathResource (PREFIX +
                                                                                                 "ubl24/common/UBL-CommonSignatureComponents-2.4.xsd",
                                                                                                 getCL ());
  public static final ClassPathResource XSD_EXTENSION_CONTENT_DATA_TYPE = new ClassPathResource (PREFIX +
                                                                                                 "ubl24/common/UBL-ExtensionContentDataType-2.4.xsd",
                                                                                                 getCL ());
  public static final ClassPathResource XSD_QUALIFIED_DATA_TYPES = new ClassPathResource (PREFIX +
                                                                                          "ubl24/common/UBL-QualifiedDataTypes-2.4.xsd",
                                                                                          getCL ());
  public static final ClassPathResource XSD_SIGNATURE_AGGREGATE_COMPONENTS = new ClassPathResource (PREFIX +
                                                                                                    "ubl24/common/UBL-SignatureAggregateComponents-2.4.xsd",
                                                                                                    getCL ());
  public static final ClassPathResource XSD_SIGNATURE_BASIC_COMPONENTS = new ClassPathResource (PREFIX +
                                                                                                "ubl24/common/UBL-SignatureBasicComponents-2.4.xsd",
                                                                                                getCL ());
  public static final ClassPathResource XSD_UNQUALIFIED_DATA_TYPES = new ClassPathResource (PREFIX +
                                                                                            "ubl24/common/BDNDR-UnqualifiedDataTypes-1.1.xsd",
                                                                                            getCL ());

  @PresentForCodeCoverage
  private static final CUBL24 INSTANCE = new CUBL24 ();

  private CUBL24 ()
  {}

  @NonNull
  public static ClassLoader getCL ()
  {
    return CUBL24.class.getClassLoader ();
  }
}
