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
package com.helger.ubl.testfiles;

import java.util.List;

import com.helger.annotation.concurrent.Immutable;
import com.helger.annotation.style.CodingStyleguideUnaware;
import com.helger.collection.CollectionHelper;

/**
 * List of all UBL test files categorized by document type.
 *
 * @author Philip Helger
 */
@Immutable
@CodingStyleguideUnaware
public final class UBLTestFiles
{
  private static final String PREFIX = "external/test-ubl/";

  public static final List <String> CATALOGUE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                         "catalogue/Consip_Catalogo_UBL.xml",
                                                                                         PREFIX +
                                                                                                                              "catalogue/Mobile_Catalogue_UBL.xml");

  public static final List <String> CREDIT_NOTE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                           "creditnote/BII04 XML example full core data 01.xml",
                                                                                           PREFIX +
                                                                                                                                                 "creditnote/UBL-CreditNote-2.0-Example.xml",
                                                                                           PREFIX +
                                                                                                                                                                                              "creditnote/UBL-CreditNote-2.1-Example.xml");

  public static final List <String> DEBIT_NOTE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                          "debitnote/UBL-DebitNote-2.1-Example.xml");

  public static final List <String> DESPATCH_ADVICE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                               "despatchadvice/UBL-DespatchAdvice-2.0-Example.xml");

  public static final List <String> EXCEPTION_CRITERIA_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                  "exceptioncriteria/UBL-ExceptionCriteria-2.1-Example.xml");

  public static final List <String> EXCEPTION_NOTIFICATION_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                      "exceptionnotification/UBL-ExceptionNotification-2.1-Example.xml");

  public static final List <String> FORECAST_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                        "forecast/UBL-Forecast-2.1-Example.xml");

  public static final List <String> FORECAST_REVISION_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                 "forecastrevision/UBL-ForecastRevision-2.1-Example.xml");

  public static final List <String> FORWARDING_INSTRUCTIONS_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                       "forwardinginstructions/UBL-ForwardingInstructions-2.0-Example-International.xml");

  public static final List <String> FREIGHT_INVOICE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                               "freightinvoice/UBL-FreightInvoice-2.1-Example.xml");

  public static final List <String> FULFILMENT_CANCELLATION_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                       "fulfilmentcancellation/UBL-FulfilmentCancellation-2.1-Example.xml");

  public static final List <String> GOODS_ITEM_ITINERARY_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                    "goodsitemitinerary/UBL-GoodsItemItinerary-2.1-Example.xml");

  public static final List <String> INSTRUCTION_FOR_RETURNS_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                       "instructionforreturns/UBL-InstructionForReturns-2.1-Example.xml");

  public static final List <String> INVENTORY_REPORT_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                "inventoryreport/UBL-InventoryReport-2.1-Example.xml");

  public static final List <String> INVOICE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                       "invoice/BII04 minimal invoice example 02.xml",
                                                                                       PREFIX +
                                                                                                                                       "invoice/BII04 minimal VAT invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                           "invoice/BII04 XML example full core data 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                              "invoice/CENBII-Invoice-maximal.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                    "invoice/ERR-10 BII04 minimal VAT invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                               "invoice/ERR-11 BII04 minimal invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                      "invoice/ERR-13 BII04 minimal invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                             "invoice/ERR-18 BII04 minimal invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    "invoice/ERR-19 BII04 minimal invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "invoice/ERR-2 BII04 minimal invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 "invoice/ERR-3 BII04 minimal VAT invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "invoice/ERR-4 BII04 minimal invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 "invoice/ERR-5 BII04 minimal VAT invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "invoice/ERR-9 BII04 minimal VAT invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     "invoice/PEP BII04 minimal invoice example 02.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         "invoice/PEP BII04 minimal VAT invoice example 01.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 "invoice/UBL-Invoice-2.0-Detached.xml",
                                                                                       /*
                                                                                        * Fails
                                                                                        * because
                                                                                        * of
                                                                                        * extensions:
                                                                                        * PREFIX
                                                                                        * +
                                                                                        * "invoice/UBL-Invoice-2.0-Enveloped.xml"
                                                                                        */
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         "invoice/UBL-Invoice-2.0-Example-NS1.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    "invoice/UBL-Invoice-2.0-Example-NS2.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               "invoice/UBL-Invoice-2.0-Example-NS3.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "invoice/UBL-Invoice-2.0-Example-NS4.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     "invoice/UBL-Invoice-2.0-Example.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            "invoice/UBL-Invoice-2.1-Example-Trivial.xml",
                                                                                       PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "invoice/UBL-Invoice-2.1-Example.xml");

  public static final List <String> ORDER_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                     "order/BII03 Order example 01.xml",
                                                                                     PREFIX +
                                                                                                                         "order/CENBII-Order-maximal.xml",
                                                                                     PREFIX +
                                                                                                                                                           "order/CENBII-Order-minimal.xml",
                                                                                     PREFIX +
                                                                                                                                                                                             "order/UBL-Order-2.0-Example-International.xml",
                                                                                     PREFIX +
                                                                                                                                                                                                                                              "order/UBL-Order-2.0-Example.xml",
                                                                                     PREFIX +
                                                                                                                                                                                                                                                                                 "order/UBL-Order-2.1-Example.xml");

  public static final List <String> ORDER_CANCELLATION_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                  "ordercancellation/UBL-OrderCancellation-2.1-Example.xml");

  public static final List <String> ORDER_CHANGE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                            "orderchange/UBL-OrderChange-2.1-Example.xml");

  public static final List <String> ORDER_RESPONSE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                              "orderresponse/UBL-OrderResponse-2.1-Example.xml");

  public static final List <String> ORDER_RESPONSE_SIMPLE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                     "orderresponsesimple/CENBII-AcceptOrder-maximal.xml",
                                                                                                     PREFIX +
                                                                                                                                                           "orderresponsesimple/CENBII-AcceptOrder-minimal.xml",
                                                                                                     PREFIX +
                                                                                                                                                                                                                 "orderresponsesimple/CENBII-RejectOrder-maximal.xml",
                                                                                                     PREFIX +
                                                                                                                                                                                                                                                                       "orderresponsesimple/CENBII-RejectOrder-minimal.xml",
                                                                                                     PREFIX +
                                                                                                                                                                                                                                                                                                                             "orderresponsesimple/UBL-OrderResponseSimple-2.0-Example.xml",
                                                                                                     PREFIX +
                                                                                                                                                                                                                                                                                                                                                                                            "orderresponsesimple/UBL-OrderResponseSimple-2.1-Example.xml");

  public static final List <String> PRODUCT_ACTIVITY_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                "productactivity/UBL-ProductActivity-2.1-Example-1.xml",
                                                                                                PREFIX +
                                                                                                                                                         "productactivity/UBL-ProductActivity-2.1-Example-2.xml",
                                                                                                PREFIX +
                                                                                                                                                                                                                  "productactivity/UBL-ProductActivity-2.1-Example-3.xml");

  public static final List <String> QUOTATION_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                         "quotation/UBL-Quotation-2.0-Example.xml",
                                                                                         PREFIX +
                                                                                                                                    "quotation/UBL-Quotation-2.1-Example.xml");

  public static final List <String> RECEIPT_ADVICE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                              "receiptadvice/UBL-ReceiptAdvice-2.0-Example.xml");

  public static final List <String> REMINDER_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                        "reminder/UBL-Reminder-2.1-Example.xml");

  public static final List <String> REMITTANCE_ADVICE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                 "remittanceadvice/UBL-RemittanceAdvice-2.0-Example.xml");

  public static final List <String> REQUEST_FOR_QUOTATION_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                     "requestforquotation/UBL-RequestForQuotation-2.0-Example.xml",
                                                                                                     PREFIX +
                                                                                                                                                                    "requestforquotation/UBL-RequestForQuotation-2.1-Example.xml");

  public static final List <String> RETAIL_EVENT_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                            "retailevent/UBL-RetailEvent-2.1-Example.xml");

  public static final List <String> SELF_BILLED_CREDIT_NOTE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                       "selfbilledcreditnote/UBL-SelfBilledCreditNote-2.1-Example.xml");

  public static final List <String> STATEMENT_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                         "statement/UBL-Statement-2.0-Example.xml");

  public static final List <String> STOCK_AVAILABILITY_REPORT_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                         "stockavailabilityreport/UBL-StockAvailabilityReport-2.1-Example.xml");

  public static final List <String> TRADE_ITEM_LOCATION_PROFILE_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                           "tradeitemlocationprofile/UBL-TradeItemLocationProfile-2.1-Example.xml");

  public static final List <String> TRANSPORTATION_STATUS_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                     "transportationstatus/UBL-TransportationStatus-2.1-Example.xml");

  public static final List <String> TRANSPORTATION_STATUS_REQUEST_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                             "transportationstatusrequest/UBL-TransportationStatusRequest-2.1-Example.xml");

  public static final List <String> TRANSPORT_EXECUTION_PLAN_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                        "transportexecutionplan/UBL-TransportExecutionPlan-2.1-Example.xml");

  public static final List <String> TRANSPORT_EXECUTION_PLAN_REQUEST_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                                "transportexecutionplanrequest/UBL-TransportExecutionPlanRequest-2.1-Example.xml");

  public static final List <String> TRANSPORT_PROGRESS_STATUS_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                         "transportprogressstatus/UBL-TransportProgressStatus-2.1-Example.xml");

  public static final List <String> TRANSPORT_PROGRESS_STATUS_REQUEST_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                                 "transportprogressstatusrequest/UBL-TransportProgressStatusRequest-2.1-Example.xml");

  public static final List <String> TRANSPORT_SERVICE_DESCRIPTION_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                             "transportservicedescription/UBL-TransportServiceDescription-2.1-Example.xml");

  public static final List <String> TRANSPORT_SERVICE_DESCRIPTION_REQUEST_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                                                     "transportservicedescriptionrequest/UBL-TransportServiceDescriptionRequest-2.1-Example.xml");

  public static final List <String> WAYBILL_FILES = CollectionHelper.makeUnmodifiable (PREFIX +
                                                                                       "waybill/UBL-Waybill-2.0-Example-International.xml");

  public UBLTestFiles ()
  {}
}
