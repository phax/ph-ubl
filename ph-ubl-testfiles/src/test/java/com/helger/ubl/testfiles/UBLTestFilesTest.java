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
package com.helger.ubl.testfiles;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.annotation.Nonnull;

import org.junit.Test;

import com.helger.commons.io.resource.ClassPathResource;

/**
 * Test class for class {@link UBLTestFiles}.
 *
 * @author Philip Helger
 */
public final class UBLTestFilesTest
{
  private static void _test (@Nonnull final List <String> aFiles)
  {
    for (final String sFile : aFiles)
      assertTrue (sFile + " does not exist", new ClassPathResource (sFile).exists ());
  }

  @Test
  public void testExistence ()
  {
    _test (UBLTestFiles.CATALOGUE_FILES);
    _test (UBLTestFiles.CREDIT_NOTE_FILES);
    _test (UBLTestFiles.DEBIT_NOTE_FILES);
    _test (UBLTestFiles.DESPATCH_ADVICE_FILES);
    _test (UBLTestFiles.EXCEPTION_CRITERIA_FILES);
    _test (UBLTestFiles.EXCEPTION_NOTIFICATION_FILES);
    _test (UBLTestFiles.FORECAST_FILES);
    _test (UBLTestFiles.FORECAST_REVISION_FILES);
    _test (UBLTestFiles.FORWARDING_INSTRUCTIONS_FILES);
    _test (UBLTestFiles.FREIGHT_INVOICE_FILES);
    _test (UBLTestFiles.FULFILMENT_CANCELLATION_FILES);
    _test (UBLTestFiles.GOODS_ITEM_ITINERARY_FILES);
    _test (UBLTestFiles.INSTRUCTION_FOR_RETURNS_FILES);
    _test (UBLTestFiles.INVENTORY_REPORT_FILES);
    _test (UBLTestFiles.INVOICE_FILES);
    _test (UBLTestFiles.ORDER_FILES);
    _test (UBLTestFiles.ORDER_CANCELLATION_FILES);
    _test (UBLTestFiles.ORDER_CHANGE_FILES);
    _test (UBLTestFiles.ORDER_RESPONSE_FILES);
    _test (UBLTestFiles.ORDER_RESPONSE_SIMPLE_FILES);
    _test (UBLTestFiles.PRODUCT_ACTIVITY_FILES);
    _test (UBLTestFiles.QUOTATION_FILES);
    _test (UBLTestFiles.RECEIPT_ADVICE_FILES);
    _test (UBLTestFiles.REMINDER_FILES);
    _test (UBLTestFiles.REMITTANCE_ADVICE_FILES);
    _test (UBLTestFiles.REQUEST_FOR_QUOTATION_FILES);
    _test (UBLTestFiles.RETAIL_EVENT_FILES);
    _test (UBLTestFiles.SELF_BILLED_CREDIT_NOTE_FILES);
    _test (UBLTestFiles.STATEMENT_FILES);
    _test (UBLTestFiles.STOCK_AVAILABILITY_REPORT_FILES);
    _test (UBLTestFiles.TRADE_ITEM_LOCATION_PROFILE_FILES);
    _test (UBLTestFiles.TRANSPORTATION_STATUS_FILES);
    _test (UBLTestFiles.TRANSPORTATION_STATUS_REQUEST_FILES);
    _test (UBLTestFiles.TRANSPORT_EXECUTION_PLAN_FILES);
    _test (UBLTestFiles.TRANSPORT_EXECUTION_PLAN_REQUEST_FILES);
    _test (UBLTestFiles.TRANSPORT_PROGRESS_STATUS_FILES);
    _test (UBLTestFiles.TRANSPORT_PROGRESS_STATUS_REQUEST_FILES);
    _test (UBLTestFiles.TRANSPORT_SERVICE_DESCRIPTION_FILES);
    _test (UBLTestFiles.TRANSPORT_SERVICE_DESCRIPTION_REQUEST_FILES);
    _test (UBLTestFiles.WAYBILL_FILES);
  }
}
