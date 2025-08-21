/*
 * Copyright (C) 2014-2025 Philip Helger (www.helger.com)
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
package com.helger.ublpe;

import com.helger.annotation.concurrent.Immutable;
import com.helger.annotation.style.PresentForCodeCoverage;

import jakarta.annotation.Nonnull;

/**
 * Constants for UBLPE handling.
 *
 * @author Philip Helger
 */
@Immutable
public final class CUBLPE
{
  /** The classpath relative directory where the main XSDs reside */
  public static final String SCHEMA_DIRECTORY = "external/schemas/ublpe20/";

  /** The sac namespace URL */
  public static final String XML_SCHEMA_SAC_NAMESPACE_URL = "urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1";

  @PresentForCodeCoverage
  private static final CUBLPE INSTANCE = new CUBLPE ();

  private CUBLPE ()
  {}

  @Nonnull
  public static ClassLoader getCL ()
  {
    return CUBLPE.class.getClassLoader ();
  }
}
