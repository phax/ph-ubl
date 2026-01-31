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
package com.helger.ubl24;

import java.util.List;

import org.jspecify.annotations.NonNull;

import com.helger.annotation.concurrent.Immutable;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;
import com.helger.ubl.testfiles.UBLTestFiles;

@Immutable
public final class MockUBL24TestDocuments
{
  private MockUBL24TestDocuments ()
  {}

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <String> getUBL24TestDocuments (@NonNull final EUBL24DocumentType eType)
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
      case EXCEPTION_CRITERIA:
        aFiles = UBLTestFiles.EXCEPTION_CRITERIA_FILES;
        break;
      case EXCEPTION_NOTIFICATION:
        aFiles = UBLTestFiles.EXCEPTION_NOTIFICATION_FILES;
        break;
      case FORECAST:
        aFiles = UBLTestFiles.FORECAST_FILES;
        break;
      case FORECAST_REVISION:
        aFiles = UBLTestFiles.FORECAST_REVISION_FILES;
        break;
      case FORWARDING_INSTRUCTIONS:
        aFiles = UBLTestFiles.FORWARDING_INSTRUCTIONS_FILES;
        break;
      case FREIGHT_INVOICE:
        aFiles = UBLTestFiles.FREIGHT_INVOICE_FILES;
        break;
      case GOODS_ITEM_ITINERARY:
        aFiles = UBLTestFiles.GOODS_ITEM_ITINERARY_FILES;
        break;
      case INSTRUCTION_FOR_RETURNS:
        aFiles = UBLTestFiles.INSTRUCTION_FOR_RETURNS_FILES;
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
      case ORDER_CHANGE:
        aFiles = UBLTestFiles.ORDER_CHANGE_FILES;
        break;
      case ORDER_RESPONSE:
        aFiles = UBLTestFiles.ORDER_RESPONSE_FILES;
        break;
      case ORDER_RESPONSE_SIMPLE:
        aFiles = UBLTestFiles.ORDER_RESPONSE_SIMPLE_FILES;
        break;
      case PRODUCT_ACTIVITY:
        aFiles = UBLTestFiles.PRODUCT_ACTIVITY_FILES;
        break;
      case QUOTATION:
        aFiles = UBLTestFiles.QUOTATION_FILES;
        break;
      case RECEIPT_ADVICE:
        aFiles = UBLTestFiles.RECEIPT_ADVICE_FILES;
        break;
      case REMINDER:
        aFiles = UBLTestFiles.REMINDER_FILES;
        break;
      case REMITTANCE_ADVICE:
        aFiles = UBLTestFiles.REMITTANCE_ADVICE_FILES;
        break;
      case REQUEST_FOR_QUOTATION:
        aFiles = UBLTestFiles.REQUEST_FOR_QUOTATION_FILES;
        break;
      case RETAIL_EVENT:
        aFiles = UBLTestFiles.RETAIL_EVENT_FILES;
        break;
      case SELF_BILLED_CREDIT_NOTE:
        aFiles = UBLTestFiles.SELF_BILLED_CREDIT_NOTE_FILES;
        break;
      case STATEMENT:
        aFiles = UBLTestFiles.STATEMENT_FILES;
        break;
      case STOCK_AVAILABILITY_REPORT:
        aFiles = UBLTestFiles.STOCK_AVAILABILITY_REPORT_FILES;
        break;
      case TRADE_ITEM_LOCATION_PROFILE:
        aFiles = UBLTestFiles.TRADE_ITEM_LOCATION_PROFILE_FILES;
        break;
      case TRANSPORTATION_STATUS:
        aFiles = UBLTestFiles.TRANSPORTATION_STATUS_FILES;
        break;
      case TRANSPORTATION_STATUS_REQUEST:
        aFiles = UBLTestFiles.TRANSPORTATION_STATUS_REQUEST_FILES;
        break;
      case TRANSPORT_EXECUTION_PLAN:
        aFiles = UBLTestFiles.TRANSPORT_EXECUTION_PLAN_FILES;
        break;
      case TRANSPORT_EXECUTION_PLAN_REQUEST:
        aFiles = UBLTestFiles.TRANSPORT_EXECUTION_PLAN_REQUEST_FILES;
        break;
      case TRANSPORT_PROGRESS_STATUS:
        aFiles = UBLTestFiles.TRANSPORT_PROGRESS_STATUS_FILES;
        break;
      case TRANSPORT_PROGRESS_STATUS_REQUEST:
        aFiles = UBLTestFiles.TRANSPORT_PROGRESS_STATUS_REQUEST_FILES;
        break;
      case TRANSPORT_SERVICE_DESCRIPTION:
        aFiles = UBLTestFiles.TRANSPORT_SERVICE_DESCRIPTION_FILES;
        break;
      case TRANSPORT_SERVICE_DESCRIPTION_REQUEST:
        aFiles = UBLTestFiles.TRANSPORT_SERVICE_DESCRIPTION_REQUEST_FILES;
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
