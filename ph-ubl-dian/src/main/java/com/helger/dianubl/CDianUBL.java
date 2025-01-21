/*
 * Copyright (C) 2020-2025 Philip Helger (www.helger.com)
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
package com.helger.dianubl;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.io.resource.ClassPathResource;

/**
 * Constants for DIAN UBL handling.
 *
 * @author Philip Helger
 */
@Immutable
public final class CDianUBL
{
  private static final String PREFIX = "external/schemas/";

  /** The classpath relative directory where the main XSDs reside */
  public static final String SCHEMA_DIRECTORY = PREFIX + "dian/";

  /** The sts namespace URL */
  public static final String XML_SCHEMA_STS_NAMESPACE_URL = "dian:gov:co:facturaelectronica:Structures-2-1";

  public static final ClassPathResource XSD_DIAN_UBL_STRUCTURE = new ClassPathResource (SCHEMA_DIRECTORY +
                                                                                        "maindoc/DIAN_UBL_Structures.xsd",
                                                                                        getCL ());

  @PresentForCodeCoverage
  private static final CDianUBL INSTANCE = new CDianUBL ();

  private CDianUBL ()
  {}

  @Nonnull
  public static ClassLoader getCL ()
  {
    return CDianUBL.class.getClassLoader ();
  }
}
