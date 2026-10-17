/*
 * Copyright (C) 2026 Philip Helger (www.helger.com)
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
package com.helger.hrubl;

import org.jspecify.annotations.NonNull;

import com.helger.annotation.concurrent.Immutable;
import com.helger.annotation.style.PresentForCodeCoverage;
import com.helger.io.resource.ClassPathResource;

/**
 * Constants for Croatian UBL (CIUS-HR with the EXT-HR extension) handling.
 */
@Immutable
public final class CHrUBL
{
  private static final String PREFIX = "external/schemas/";

  /** The classpath relative directory where the Croatian XSDs reside */
  public static final String SCHEMA_DIRECTORY = PREFIX + "hr/";

  /** The hrextac namespace URL - the namespace of the Croatian UBL extension */
  public static final String XML_SCHEMA_HREXTAC_NAMESPACE_URL = "urn:mfin.gov.hr:schema:xsd:HRExtensionAggregateComponents-1";

  public static final ClassPathResource XSD_HR_EXTENSION_AGGREGATE_COMPONENTS = new ClassPathResource (SCHEMA_DIRECTORY +
                                                                                                       "common/HRExtensionAggregateComponents-1.xsd",
                                                                                                       getCL ());

  @PresentForCodeCoverage
  private static final CHrUBL INSTANCE = new CHrUBL ();

  private CHrUBL ()
  {}

  /**
   * @return The class loader to be used to load the resources of this module. Never <code>null</code>.
   */
  @NonNull
  public static ClassLoader getCL ()
  {
    return CHrUBL.class.getClassLoader ();
  }
}
