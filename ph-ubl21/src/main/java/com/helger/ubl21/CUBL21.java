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
package com.helger.ubl21;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.io.resource.ClassPathResource;

/**
 * Constants for UBL 2.1 handling.
 *
 * @author Philip Helger
 */
@Immutable
public final class CUBL21
{
  @Nonnull
  private static ClassLoader _getCL ()
  {
    return CUBL21.class.getClassLoader ();
  }

  /** The classpath relative directory where the main XSDs reside */
  public static final String SCHEMA_DIRECTORY = "schemas/ubl21/maindoc/";

  /** The udt namespace URL */
  public static final String XML_SCHEMA_UDT_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:UnqualifiedDataTypes-2";

  /** The qdt namespace URL */
  public static final String XML_SCHEMA_QDT_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:QualifiedDataTypes-2";

  /** The cac namespace URL */
  public static final String XML_SCHEMA_CAC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2";

  /** The cbc namespace URL */
  public static final String XML_SCHEMA_CBC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2";

  /** The cec namespace URL */
  public static final String XML_SCHEMA_CEC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2";

  /** The sac namespace URL */
  public static final String XML_SCHEMA_SAC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:SignatureAggregateComponents-2";

  /** The sbc namespace URL */
  public static final String XML_SCHEMA_SBC_NAMESPACE_URL = "urn:oasis:names:specification:ubl:schema:xsd:SignatureBasicComponents-2";

  public static final ClassPathResource XSD_COMMON_AGGREGATE_COMPONENTS = new ClassPathResource ("/schemas/ubl21/common/UBL-CommonAggregateComponents-2.1.xsd",
                                                                                                 _getCL ());
  public static final ClassPathResource XSD_COMMON_BASIC_COMPONENTS = new ClassPathResource ("/schemas/ubl21/common/UBL-CommonBasicComponents-2.1.xsd",
                                                                                             _getCL ());
  public static final ClassPathResource XSD_COMMON_EXTENSION_COMPONENTS = new ClassPathResource ("/schemas/ubl21/common/UBL-CommonExtensionComponents-2.1.xsd",
                                                                                                 _getCL ());
  public static final ClassPathResource XSD_COMMON_SIGNATURE_COMPONENTS = new ClassPathResource ("/schemas/ubl21/common/UBL-CommonSignatureComponents-2.1.xsd",
                                                                                                 _getCL ());
  public static final ClassPathResource XSD_CORE_COMPONENT_PARAMETERS = new ClassPathResource ("/schemas/ubl21/common/UBL-CoreComponentParameters-2.1.xsd",
                                                                                               _getCL ());
  public static final ClassPathResource XSD_EXTENSION_CONTENT_DATA_TYPE = new ClassPathResource ("/schemas/ubl21/common/UBL-ExtensionContentDataType-2.1.xsd",
                                                                                                 _getCL ());
  public static final ClassPathResource XSD_QUALIFIED_DATA_TYPES = new ClassPathResource ("/schemas/ubl21/common/UBL-QualifiedDataTypes-2.1.xsd",
                                                                                          _getCL ());
  public static final ClassPathResource XSD_SIGNATURE_AGGREGATE_COMPONENTS = new ClassPathResource ("/schemas/ubl21/common/UBL-SignatureAggregateComponents-2.1.xsd",
                                                                                                    _getCL ());
  public static final ClassPathResource XSD_SIGNATURE_BASIC_COMPONENTS = new ClassPathResource ("/schemas/ubl21/common/UBL-SignatureBasicComponents-2.1.xsd",
                                                                                                _getCL ());
  public static final ClassPathResource XSD_UNQUALIFIED_DATA_TYPES = new ClassPathResource ("/schemas/ubl21/common/UBL-UnqualifiedDataTypes-2.1.xsd",
                                                                                            _getCL ());

  @PresentForCodeCoverage
  private static final CUBL21 s_aInstance = new CUBL21 ();

  private CUBL21 ()
  {}
}
