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
package com.helger.ubltr;

import java.util.List;

import org.jspecify.annotations.NonNull;

import com.helger.annotation.concurrent.Immutable;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;

@Immutable
public final class MockUBLTRTestDocuments
{
  private static final String PREFIX = "external/";

  private MockUBLTRTestDocuments ()
  {}

  @NonNull
  @ReturnsMutableCopy
  public static List <String> getUBLTRTestDocuments (@NonNull final EUBLTRDocumentType eType)
  {
    List <String> aFiles = null;
    switch (eType)
    {
      case CANCEL_USER_ACCOUNT:
        aFiles = new CommonsArrayList <> (PREFIX + "tr_useraccount/5_KULLANICI_SILME.xml",
                                          PREFIX + "tr_useraccount/9_FATURA_SAKLAMA_KULLANICI_SILME.xml");
        break;
      case PROCESS_USER_ACCOUNT:
        aFiles = new CommonsArrayList <> (PREFIX + "tr_useraccount/4_KULLANICI_ACMA.xml",
                                          PREFIX + "tr_useraccount/8_FATURA_SAKLAMA_KULLANICI_ACMA.xml");
        break;
      default:
        throw new IllegalArgumentException ("No test files available for type " + eType);
    }

    return aFiles;
  }
}
