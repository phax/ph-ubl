/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
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

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.ubl.testfiles.UBLTestFiles;

@Immutable
public final class MockUBLPETestDocuments
{
  private static final String PREFIX = "test-ublpe20/";

  private MockUBLPETestDocuments ()
  {}

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <String> getUBLPETestDocuments (@Nonnull final EUBLPEDocumentType eType)
  {
    ICommonsList <String> aFiles;
    switch (eType)
    {
      case APPLICATION_RESPONSE:
        // none;
        aFiles = new CommonsArrayList <> ();
        break;
      case CREDIT_NOTE:
        aFiles = new CommonsArrayList <> (UBLTestFiles.CREDIT_NOTE_FILES);
        break;
      case DEBIT_NOTE:
        aFiles = new CommonsArrayList <> (UBLTestFiles.DEBIT_NOTE_FILES);
        break;
      case INVOICE:
        aFiles = new CommonsArrayList <> (UBLTestFiles.INVOICE_FILES);
        break;
      case SUMMARY_DOCUMENTS:
        // The other 2 are non-compliant
        aFiles = new CommonsArrayList <> (// PREFIX +
                                          // "summary-documents/ResumenDiario_1.1_NC.xml",
                                          // PREFIX +
                                          // "summary-documents/ResumenDiario_1.1.xml",
                                          PREFIX +
                                          "summary-documents/ResumenDiario.xml");
        break;
      case VOIDED_DOCUMENTS:
        aFiles = new CommonsArrayList <> (PREFIX + "voided-documents/ComunicacionBaja.xml");
        break;
      default:
        throw new IllegalArgumentException ("No test files available for type " + eType);
    }

    return aFiles;
  }
}
