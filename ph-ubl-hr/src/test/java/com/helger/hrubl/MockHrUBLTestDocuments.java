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
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;

/**
 * Provides the Croatian test documents. They are the official examples published by the Croatian Tax Administration
 * ("Primjeri eRacuna"), see the readme.txt in the docs folder of this module. All invoices contain the Croatian
 * extension.
 */
@Immutable
public final class MockHrUBLTestDocuments
{
  private static final String PREFIX = "external/test-hr/";

  /** The file with cash basis VAT - the extension contains only the cash basis statement */
  public static final String INVOICE_CASH_BASIS = PREFIX + "eRacun-PDV25-Obracun PDV po naplati.xml";

  private MockHrUBLTestDocuments ()
  {}

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <String> getHrUBLTestDocuments (@NonNull final EHrUBLDocumentType eType)
  {
    return switch (eType)
    {
      case CREDIT_NOTE -> new CommonsArrayList <> (PREFIX + "Odobrenje.xml");
      case INVOICE -> new CommonsArrayList <> (PREFIX + "Racun za leasing PDV PPMV-aktivacija.xml",
                                               PREFIX + "eRacun-Nije u sustavu PDV.xml",
                                               PREFIX + "eRacun-Oslobodjeno PDV.xml",
                                               PREFIX + "eRacun-PDV-NEOP-POVRATNA-NAKNADA-stavka.xml",
                                               PREFIX + "eRacun-PDV-NEOP-POVRATNA-NAKNADA-trosak.xml",
                                               PREFIX + "eRacun-PDV-NEOP-PP-trosak.xml",
                                               PREFIX + "eRacun-PDV25 i Neoporeziva naknada-trosak.xml",
                                               INVOICE_CASH_BASIS);
      default -> throw new IllegalArgumentException ("No test files available for type " + eType);
    };
  }
}
