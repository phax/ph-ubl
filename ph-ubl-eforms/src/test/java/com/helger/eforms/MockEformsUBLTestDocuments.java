/*
 * Copyright (C) 2021-2025 Jonatan Sunden
 * Copyright (C) 2021-2025 Philip Helger (www.helger.com)
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

import com.helger.annotation.concurrent.Immutable;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;

import jakarta.annotation.Nonnull;

@Immutable
public final class MockEformsUBLTestDocuments
{
  private static final String PREFIX = "external/examples/";

  private MockEformsUBLTestDocuments ()
  {}

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <String> getTestDocuments (@Nonnull final EFormsUBLDocumentType eType)
  {
    switch (eType)
    {
      case CONTRACT_AWARD_NOTICE:
        return new CommonsArrayList <> (PREFIX + "can-modif_24_duration.xml",
                                        PREFIX + "can-modif_24_value.xml",
                                        PREFIX + "can_23_contracts.xml",
                                        PREFIX + "can_24_FRA_comments.xml",
                                        PREFIX + "can_24_LSBU.xml",
                                        PREFIX + "can_24_maximal.xml",
                                        PREFIX + "can_24_minimal.xml",
                                        PREFIX + "can_24_UKRI.xml",
                                        PREFIX + "can_25_ENG.xml",
                                        PREFIX + "can_25_ENG_Buyers.xml",
                                        PREFIX + "can_25_ITA.xml",
                                        PREFIX + "can_25_withheld.xml",
                                        PREFIX + "can_81_FRA.xml",
                                        PREFIX + "t02_ESP.xml",
                                        PREFIX + "veat_24.xml",
                                        PREFIX + "veat_25.xml");
      case CONTRACT_NOTICE:
        return new CommonsArrayList <> (PREFIX + "change-cn_24_open_dates.xml",
                                        PREFIX + "change-cn_24_suppliers.xml",
                                        PREFIX + "cn-desg_24.xml",
                                        PREFIX + "cn-social_24.xml",
                                        PREFIX + "cn_23.xml",
                                        PREFIX + "cn_24_FRA_comments.xml",
                                        PREFIX + "cn_24_maximal.xml",
                                        PREFIX + "cn_24_minimal.xml",
                                        PREFIX + "cn_24_multilingual.xml",
                                        PREFIX + "cn_24_nego_accel.xml",
                                        PREFIX + "cn_24_open.xml",
                                        PREFIX + "cn_24_open_accel.xml",
                                        PREFIX + "cn_25.xml",
                                        PREFIX + "cn_81.xml",
                                        PREFIX + "cn_81_FRA.xml",
                                        PREFIX + "qu-sy_25.xml");
      case PRIOR_INFORMATION_NOTICE:
        return new CommonsArrayList <> (PREFIX + "pin-buyer_24_published.xml",
                                        PREFIX + "pin-buyer_24_minimal.xml",
                                        PREFIX + "pin-cfc_25.xml",
                                        PREFIX + "pin-only_24.xml",
                                        PREFIX + "pin-only_24_lots.xml",
                                        PREFIX + "pin-only_24_maximal.xml",
                                        PREFIX + "pin-only_81.xml",
                                        PREFIX + "pin-only_81_FRA.xml",
                                        PREFIX + "t01_PRT.xml");
      default:
        throw new IllegalArgumentException ("No test files available for type " + eType);
    }
  }
}
