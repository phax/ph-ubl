/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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

import javax.annotation.concurrent.Immutable;

import com.helger.commons.collection.CollectionHelper;

/**
 * List of all UBL test files categorized by document type.
 *
 * @author Philip Helger
 */
@Immutable
public final class UBLTestFiles
{
  public static final List <String> CATALOGUE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/catalogue/Consip_Catalogo_UBL.xml",
                                                                                            "test-ubl/catalogue/Mobile_Catalogue_UBL.xml");

  public static final List <String> CREDIT_NOTE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/creditnote/BII04 XML example full core data 01.xml",
                                                                                              "test-ubl/creditnote/UBL-CreditNote-2.0-Example.xml",
                                                                                              "test-ubl/creditnote/UBL-CreditNote-2.1-Example.xml");

  public static final List <String> DEBIT_NOTE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/debitnote/UBL-DebitNote-2.1-Example.xml");

  public static final List <String> DESPATCH_ADVICE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/despatchadvice/UBL-DespatchAdvice-2.0-Example.xml");

  public static final List <String> EXCEPTION_CRITERIA_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/exceptioncriteria/UBL-ExceptionCriteria-2.1-Example.xml");

  public static final List <String> EXCEPTION_NOTIFICATION_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/exceptionnotification/UBL-ExceptionNotification-2.1-Example.xml");

  public static final List <String> FORECAST_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/forecast/UBL-Forecast-2.1-Example.xml");

  public static final List <String> FORECAST_REVISION_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/forecastrevision/UBL-ForecastRevision-2.1-Example.xml");

  public static final List <String> FORWARDING_INSTRUCTIONS_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/forwardinginstructions/UBL-ForwardingInstructions-2.0-Example-International.xml");

  public static final List <String> FREIGHT_INVOICE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/freightinvoice/UBL-FreightInvoice-2.1-Example.xml");

  public static final List <String> FULFILMENT_CANCELLATION_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/fulfilmentcancellation/UBL-FulfilmentCancellation-2.1-Example.xml");

  public static final List <String> GOODS_ITEM_ITINERARY_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/goodsitemitinerary/UBL-GoodsItemItinerary-2.1-Example.xml");

  public static final List <String> INSTRUCTION_FOR_RETURNS_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/instructionforreturns/UBL-InstructionForReturns-2.1-Example.xml");

  public static final List <String> INVENTORY_REPORT_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/inventoryreport/UBL-InventoryReport-2.1-Example.xml");

  public static final List <String> INVOICE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/invoice/BII04 minimal invoice example 02.xml",
                                                                                          "test-ubl/invoice/BII04 minimal VAT invoice example 01.xml",
                                                                                          "test-ubl/invoice/BII04 XML example full core data 01.xml",
                                                                                          "test-ubl/invoice/CENBII-Invoice-maximal.xml",
                                                                                          "test-ubl/invoice/ERR-10 BII04 minimal VAT invoice example 01.xml",
                                                                                          "test-ubl/invoice/ERR-11 BII04 minimal invoice example 01.xml",
                                                                                          "test-ubl/invoice/ERR-13 BII04 minimal invoice example 01.xml",
                                                                                          "test-ubl/invoice/ERR-18 BII04 minimal invoice example 01.xml",
                                                                                          "test-ubl/invoice/ERR-19 BII04 minimal invoice example 01.xml",
                                                                                          "test-ubl/invoice/ERR-2 BII04 minimal invoice example 01.xml",
                                                                                          "test-ubl/invoice/ERR-3 BII04 minimal VAT invoice example 01.xml",
                                                                                          "test-ubl/invoice/ERR-4 BII04 minimal invoice example 01.xml",
                                                                                          "test-ubl/invoice/ERR-5 BII04 minimal VAT invoice example 01.xml",
                                                                                          "test-ubl/invoice/ERR-9 BII04 minimal VAT invoice example 01.xml",
                                                                                          "test-ubl/invoice/PEP BII04 minimal invoice example 02.xml",
                                                                                          "test-ubl/invoice/PEP BII04 minimal VAT invoice example 01.xml",
                                                                                          "test-ubl/invoice/UBL-Invoice-2.0-Detached.xml",
                                                                                          /*
                                                                                           * Fails
                                                                                           * because
                                                                                           * of
                                                                                           * extensions:
                                                                                           * "test-ubl/invoice/UBL-Invoice-2.0-Enveloped.xml"
                                                                                           */
                                                                                          "test-ubl/invoice/UBL-Invoice-2.0-Example-NS1.xml",
                                                                                          "test-ubl/invoice/UBL-Invoice-2.0-Example-NS2.xml",
                                                                                          "test-ubl/invoice/UBL-Invoice-2.0-Example-NS3.xml",
                                                                                          "test-ubl/invoice/UBL-Invoice-2.0-Example-NS4.xml",
                                                                                          "test-ubl/invoice/UBL-Invoice-2.0-Example.xml",
                                                                                          "test-ubl/invoice/UBL-Invoice-2.1-Example-Trivial.xml",
                                                                                          "test-ubl/invoice/UBL-Invoice-2.1-Example.xml");

  public static final List <String> ORDER_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/order/BII03 Order example 01.xml",
                                                                                        "test-ubl/order/CENBII-Order-maximal.xml",
                                                                                        "test-ubl/order/CENBII-Order-minimal.xml",
                                                                                        "test-ubl/order/UBL-Order-2.0-Example-International.xml",
                                                                                        "test-ubl/order/UBL-Order-2.0-Example.xml",
                                                                                        "test-ubl/order/UBL-Order-2.1-Example.xml");

  public static final List <String> ORDER_CANCELLATION_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/ordercancellation/UBL-OrderCancellation-2.1-Example.xml");

  public static final List <String> ORDER_CHANGE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/orderchange/UBL-OrderChange-2.1-Example.xml");

  public static final List <String> ORDER_RESPONSE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/orderresponse/UBL-OrderResponse-2.1-Example.xml");

  public static final List <String> ORDER_RESPONSE_SIMPLE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/orderresponsesimple/CENBII-AcceptOrder-maximal.xml",
                                                                                                        "test-ubl/orderresponsesimple/CENBII-AcceptOrder-minimal.xml",
                                                                                                        "test-ubl/orderresponsesimple/CENBII-RejectOrder-maximal.xml",
                                                                                                        "test-ubl/orderresponsesimple/CENBII-RejectOrder-minimal.xml",
                                                                                                        "test-ubl/orderresponsesimple/UBL-OrderResponseSimple-2.0-Example.xml",
                                                                                                        "test-ubl/orderresponsesimple/UBL-OrderResponseSimple-2.1-Example.xml");

  public static final List <String> PRODUCT_ACTIVITY_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/productactivity/UBL-ProductActivity-2.1-Example-1.xml",
                                                                                                   "test-ubl/productactivity/UBL-ProductActivity-2.1-Example-2.xml",
                                                                                                   "test-ubl/productactivity/UBL-ProductActivity-2.1-Example-3.xml");

  public static final List <String> QUOTATION_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/quotation/UBL-Quotation-2.0-Example.xml",
                                                                                            "test-ubl/quotation/UBL-Quotation-2.1-Example.xml");

  public static final List <String> RECEIPT_ADVICE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/receiptadvice/UBL-ReceiptAdvice-2.0-Example.xml");

  public static final List <String> REMINDER_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/reminder/UBL-Reminder-2.1-Example.xml");

  public static final List <String> REMITTANCE_ADVICE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/remittanceadvice/UBL-RemittanceAdvice-2.0-Example.xml");

  public static final List <String> REQUEST_FOR_QUOTATION_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/requestforquotation/UBL-RequestForQuotation-2.0-Example.xml",
                                                                                                        "test-ubl/requestforquotation/UBL-RequestForQuotation-2.1-Example.xml");

  public static final List <String> RETAIL_EVENT_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/retailevent/UBL-RetailEvent-2.1-Example.xml");

  public static final List <String> SELF_BILLED_CREDIT_NOTE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/selfbilledcreditnote/UBL-SelfBilledCreditNote-2.1-Example.xml");

  public static final List <String> STATEMENT_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/statement/UBL-Statement-2.0-Example.xml");

  public static final List <String> STOCK_AVAILABILITY_REPORT_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/stockavailabilityreport/UBL-StockAvailabilityReport-2.1-Example.xml");

  public static final List <String> TRADE_ITEM_LOCATION_PROFILE_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/tradeitemlocationprofile/UBL-TradeItemLocationProfile-2.1-Example.xml");

  public static final List <String> TRANSPORTATION_STATUS_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/transportationstatus/UBL-TransportationStatus-2.1-Example.xml");

  public static final List <String> TRANSPORTATION_STATUS_REQUEST_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/transportationstatusrequest/UBL-TransportationStatusRequest-2.1-Example.xml");

  public static final List <String> TRANSPORT_EXECUTION_PLAN_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/transportexecutionplan/UBL-TransportExecutionPlan-2.1-Example.xml");

  public static final List <String> TRANSPORT_EXECUTION_PLAN_REQUEST_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/transportexecutionplanrequest/UBL-TransportExecutionPlanRequest-2.1-Example.xml");

  public static final List <String> TRANSPORT_PROGRESS_STATUS_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/transportprogressstatus/UBL-TransportProgressStatus-2.1-Example.xml");

  public static final List <String> TRANSPORT_PROGRESS_STATUS_REQUEST_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/transportprogressstatusrequest/UBL-TransportProgressStatusRequest-2.1-Example.xml");

  public static final List <String> TRANSPORT_SERVICE_DESCRIPTION_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/transportservicedescription/UBL-TransportServiceDescription-2.1-Example.xml");

  public static final List <String> TRANSPORT_SERVICE_DESCRIPTION_REQUEST_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/transportservicedescriptionrequest/UBL-TransportServiceDescriptionRequest-2.1-Example.xml");

  public static final List <String> WAYBILL_FILES = CollectionHelper.newUnmodifiableList ("test-ubl/waybill/UBL-Waybill-2.0-Example-International.xml");

  public UBLTestFiles ()
  {}
}
