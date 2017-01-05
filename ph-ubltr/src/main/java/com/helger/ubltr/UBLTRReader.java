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

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;

import tr.gov.efatura.package_12.TRPackage;
import tr.gov.efatura.useraccount.CancelUserAccountType;
import tr.gov.efatura.useraccount.ProcessUserAccountType;

/**
 * Read all UBLTR document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBLTRReader
{
  @PresentForCodeCoverage
  private static final UBLTRReader s_aInstance = new UBLTRReader ();

  private UBLTRReader ()
  {}

  /**
   * Create a reader builder for CancelUserAccountType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLTRReaderBuilder <CancelUserAccountType> cancelUserAccount ()
  {
    return UBLTRReaderBuilder.create (CancelUserAccountType.class);
  }

  /**
   * Create a reader builder for ProcessUserAccountType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLTRReaderBuilder <ProcessUserAccountType> processUserAccount ()
  {
    return UBLTRReaderBuilder.create (ProcessUserAccountType.class);
  }

  /**
   * Create a reader builder for TRPackage.<br>
   * Note: "package" is a reserved word.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLTRReaderBuilder <TRPackage> _package ()
  {
    return UBLTRReaderBuilder.create (TRPackage.class);
  }
}
