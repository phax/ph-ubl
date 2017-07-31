/**
 * Copyright (C) 2014-2017 Philip Helger (www.helger.com)
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

import java.util.List;

import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.ubl21.CUBL21;
import com.helger.ubl21.EUBL21DocumentType;

/**
 * Constants for UBLTR handling.
 *
 * @author Philip Helger
 */
@Immutable
public final class CUBLTR
{
  /** The classpath relative directory where the main XSDs reside */
  public static final String SCHEMA_DIRECTORY = "schemas/ubltr/";

  public static final String XML_NS_EFATURA = "http://www.efatura.gov.tr/package-namespace";
  public static final String XML_NS_HRXML = "http://www.hr-xml.org/3";
  public static final String XML_NS_OAGIS = "http://www.openapplications.org/oagis/9";

  /** List of all XSDs required for using the HRXML UserAccount type */
  @CodingStyleguideUnaware
  public static final List <String> XSD_HRXML_USER_ACCOUNT = new CommonsArrayList <> (CUBL21.XSD_UBL_XMLDSIG,
                                                                                      SCHEMA_DIRECTORY +
                                                                                                              "HRXML/UserAccount.xsd").getAsUnmodifiable ();

  /** List of all XSDs required for using the ULBTR Package type */
  @CodingStyleguideUnaware
  public static final List <String> XSD_PACKAGE;

  static
  {
    final ICommonsList <String> aPackage = new CommonsArrayList <> ();
    aPackage.addAll (EUBL21DocumentType.INVOICE.getAllXSDPaths ());
    aPackage.addAll (EUBL21DocumentType.APPLICATION_RESPONSE.getAllXSDPaths ());
    aPackage.add (SCHEMA_DIRECTORY + "Envelope/Package_1_2.xsd");
    XSD_PACKAGE = aPackage.getAsUnmodifiable ();
  }

  @PresentForCodeCoverage
  private static final CUBLTR s_aInstance = new CUBLTR ();

  private CUBLTR ()
  {}
}
