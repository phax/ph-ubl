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
package com.helger.ubl20;

import java.util.List;

import com.helger.annotation.concurrent.Immutable;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;
import com.helger.ubl.testfiles.UBLTestFiles;

import jakarta.annotation.Nonnull;

@Immutable
public final class MockUBL20TestDocuments
{
  private MockUBL20TestDocuments ()
  {}

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <String> getUBL20TestDocuments (@Nonnull final EUBL20DocumentType eType)
  {
    List <String> aFiles = null;
    switch (eType)
    {
      case CATALOGUE:
        aFiles = UBLTestFiles.CATALOGUE_FILES;
        break;
      case CREDIT_NOTE:
        aFiles = UBLTestFiles.CREDIT_NOTE_FILES;
        break;
      case DEBIT_NOTE:
        aFiles = UBLTestFiles.DEBIT_NOTE_FILES;
        break;
      case DESPATCH_ADVICE:
        aFiles = UBLTestFiles.DESPATCH_ADVICE_FILES;
        break;
      case FORWARDING_INSTRUCTIONS:
        aFiles = UBLTestFiles.FORWARDING_INSTRUCTIONS_FILES;
        break;
      case FREIGHT_INVOICE:
        aFiles = UBLTestFiles.FREIGHT_INVOICE_FILES;
        break;
      case INVOICE:
        aFiles = UBLTestFiles.INVOICE_FILES;
        break;
      case ORDER:
        aFiles = UBLTestFiles.ORDER_FILES;
        break;
      case ORDER_CANCELLATION:
        aFiles = UBLTestFiles.ORDER_CANCELLATION_FILES;
        break;
      case ORDER_RESPONSE:
        aFiles = UBLTestFiles.ORDER_RESPONSE_FILES;
        break;
      case ORDER_RESPONSE_SIMPLE:
        aFiles = UBLTestFiles.ORDER_RESPONSE_SIMPLE_FILES;
        break;
      case QUOTATION:
        aFiles = UBLTestFiles.QUOTATION_FILES;
        break;
      case RECEIPT_ADVICE:
        aFiles = UBLTestFiles.RECEIPT_ADVICE_FILES;
        break;
      case REQUEST_FOR_QUOTATION:
        aFiles = new CommonsArrayList <> (UBLTestFiles.REQUEST_FOR_QUOTATION_FILES);
        aFiles.remove ("external/test-ubl/requestforquotation/UBL-RequestForQuotation-2.1-Example.xml");
        break;
      case REMITTANCE_ADVICE:
        aFiles = UBLTestFiles.REMITTANCE_ADVICE_FILES;
        break;
      case STATEMENT:
        aFiles = UBLTestFiles.STATEMENT_FILES;
        break;
      case WAYBILL:
        aFiles = UBLTestFiles.WAYBILL_FILES;
        break;
      default:
        throw new IllegalArgumentException ("No test files available for type " + eType);
    }

    return new CommonsArrayList <> (aFiles);
  }
}
