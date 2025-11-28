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

import org.jspecify.annotations.NonNull;

import com.helger.annotation.concurrent.Immutable;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;

@Immutable
public final class MockDianUBLTestDocuments
{
  private static final String PREFIX = "external/test-dian/";

  private MockDianUBLTestDocuments ()
  {}

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <String> getUBLPETestDocuments (@NonNull final EDianUBLDocumentType eType)
  {
    return switch (eType)
    {
      case APPLICATION_RESPONSE -> new CommonsArrayList <> ();
      case ATTACHED_DOCUMENT -> new CommonsArrayList <> ();
      case CREDIT_NOTE -> new CommonsArrayList <> (PREFIX + "CreditNote.xml");
      case DEBIT_NOTE -> new CommonsArrayList <> (PREFIX + "DebitNote.xml");
      case INVOICE -> new CommonsArrayList <> (PREFIX + "Combustible.xml",
                                               PREFIX + "Consumidor Final.xml",
                                               PREFIX + "EmisorAutoretenedor.xml",
                                               PREFIX + "ExcluidosExentos.xml",
                                               PREFIX + "Exportacion.xml",
                                               PREFIX + "Generica.xml",
                                               PREFIX + "GenericaPagoAnticipado.xml",
                                               PREFIX + "Mandatos.xml",
                                               PREFIX + "Servicios.xml");
      default -> throw new IllegalArgumentException ("No test files available for type " + eType);
    };
  }
}
