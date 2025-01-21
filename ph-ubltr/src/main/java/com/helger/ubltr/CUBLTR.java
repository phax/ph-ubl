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
package com.helger.ubltr;

import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.PresentForCodeCoverage;

/**
 * Constants for UBLTR handling.
 *
 * @author Philip Helger
 */
@Immutable
public final class CUBLTR
{
  /** The classpath relative directory where the main XSDs reside */
  public static final String SCHEMA_DIRECTORY = "external/schemas/ubltr/";

  public static final String XML_NS_EFATURA = "http://www.efatura.gov.tr/package-namespace";
  public static final String XML_NS_HRXML = "http://www.hr-xml.org/3";
  public static final String XML_NS_OAGIS = "http://www.openapplications.org/oagis/9";

  @PresentForCodeCoverage
  private static final CUBLTR INSTANCE = new CUBLTR ();

  private CUBLTR ()
  {}
}
