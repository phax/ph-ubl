/**
 * Copyright (C) 2020-2021 Philip Helger (www.helger.com)
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

import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;

@Immutable
public final class MockDianUBLTestDocuments
{
  private static final String PREFIX = "test-dian/";

  private MockDianUBLTestDocuments ()
  {}

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <String> getUBLPETestDocuments (@Nonnull final EDianUBLDocumentType eType)
  {
    ICommonsList <String> aFiles;
    switch (eType)
    {
      case APPLICATION_RESPONSE:
        aFiles = new CommonsArrayList <> ();
        break;
      case ATTACHED_DOCUMENT:
        aFiles = new CommonsArrayList <> ();
        break;
      case CREDIT_NOTE:
        aFiles = new CommonsArrayList <> (PREFIX + "CreditNote.xml");
        break;
      case DEBIT_NOTE:
        aFiles = new CommonsArrayList <> (PREFIX + "DebitNote.xml");
        break;
      case INVOICE:
        aFiles = new CommonsArrayList <> (PREFIX + "Combustible.xml",
                                          PREFIX + "Consumidor Final.xml",
                                          PREFIX + "EmisorAutoretenedor.xml",
                                          PREFIX + "ExcluidosExentos.xml",
                                          PREFIX + "Exportacion.xml",
                                          PREFIX + "Generica.xml",
                                          PREFIX + "GenericaPagoAnticipado.xml",
                                          PREFIX + "Mandatos.xml",
                                          PREFIX + "Servicios.xml");
        break;
      default:
        throw new IllegalArgumentException ("No test files available for type " + eType);
    }

    return aFiles;
  }
}
