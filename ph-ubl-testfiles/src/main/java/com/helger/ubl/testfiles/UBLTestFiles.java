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
  public static final String COMMON_BASE_DIRECTORY = "test-ubl/";

  public static final List <String> CATALOGUE_FILES = CollectionHelper.newUnmodifiableList ("catalogue/Consip_Catalogo_UBL.xml",
                                                                                            "catalogue/Mobile_Catalogue_UBL.xml");

  public static final List <String> CREDIT_NOTE_FILES = CollectionHelper.newUnmodifiableList ("creditnote/BII04 XML example full core data 01.xml",
                                                                                              "creditnote/UBL-CreditNote-2.0-Example.xml",
                                                                                              "creditnote/UBL-CreditNote-2.1-Example.xml");

  public static final List <String> DEBIT_NOTE_FILES = CollectionHelper.newUnmodifiableList ("debitnote/UBL-DebitNote-2.1-Example.xml");

  public static final List <String> DESPATCH_ADVICE_FILES = CollectionHelper.newUnmodifiableList ("despatchadvice/UBL-DespatchAdvice-2.0-Example.xml");

  public static final List <String> EXCEPTION_CRITERIA_FILES = CollectionHelper.newUnmodifiableList ("exceptioncriteria/UBL-ExceptionCriteria-2.1-Example.xml");

  public static final List <String> EXCEPTION_NOTIFICATION_FILES = CollectionHelper.newUnmodifiableList ("exceptionnotification/UBL-ExceptionNotification-2.1-Example.xml");

  public static final List <String> FORECAST_FILES = CollectionHelper.newUnmodifiableList ("forecast/UBL-Forecast-2.1-Example.xml");

  public static final List <String> FORECAST_REVISION_FILES = CollectionHelper.newUnmodifiableList ("forecastrevision/UBL-ForecastRevision-2.1-Example.xml");

  public static final List <String> FORWARDING_INSTRUCTIONS_FILES = CollectionHelper.newUnmodifiableList ("forwardinginstructions/UBL-ForwardingInstructions-2.0-Example-International.xml");

  public static final List <String> FREIGHT_INVOICE_FILES = CollectionHelper.newUnmodifiableList ("freightinvoice/UBL-FreightInvoice-2.1-Example.xml");

  public static final List <String> FULFILMENT_CANCELLATION_FILES = CollectionHelper.newUnmodifiableList ("fulfilmentcancellation/UBL-FulfilmentCancellation-2.1-Example.xml");

  public static final List <String> GOODS_ITEM_ITINERARY_FILES = CollectionHelper.newUnmodifiableList ("goodsitemitinerary/UBL-GoodsItemItinerary-2.1-Example.xml");

  public static final List <String> INSTRUCTION_FOR_RETURNS_FILES = CollectionHelper.newUnmodifiableList ("instructionforreturns/UBL-InstructionForReturns-2.1-Example.xml");

  public static final List <String> INVENTORY_REPORT_FILES = CollectionHelper.newUnmodifiableList ("inventoryreport/UBL-InventoryReport-2.1-Example.xml");

  public static final List <String> INVOICE_FILES = CollectionHelper.newUnmodifiableList ("invoice/BII04 minimal invoice example 02.xml",
                                                                                          "invoice/BII04 minimal VAT invoice example 01.xml",
                                                                                          "invoice/BII04 XML example full core data 01.xml",
                                                                                          "invoice/CENBII-Invoice-maximal.xml",
                                                                                          "invoice/ERR-10 BII04 minimal VAT invoice example 01.xml",
                                                                                          "invoice/ERR-11 BII04 minimal invoice example 01.xml",
                                                                                          "invoice/ERR-13 BII04 minimal invoice example 01.xml",
                                                                                          "invoice/ERR-18 BII04 minimal invoice example 01.xml",
                                                                                          "invoice/ERR-19 BII04 minimal invoice example 01.xml",
                                                                                          "invoice/ERR-2 BII04 minimal invoice example 01.xml",
                                                                                          "invoice/ERR-3 BII04 minimal VAT invoice example 01.xml",
                                                                                          "invoice/ERR-4 BII04 minimal invoice example 01.xml",
                                                                                          "invoice/ERR-5 BII04 minimal VAT invoice example 01.xml",
                                                                                          "invoice/ERR-9 BII04 minimal VAT invoice example 01.xml",
                                                                                          "invoice/PEP BII04 minimal invoice example 02.xml",
                                                                                          "invoice/PEP BII04 minimal VAT invoice example 01.xml",
                                                                                          "invoice/UBL-Invoice-2.0-Detached.xml",
                                                                                          /*
                                                                                           * Fails
                                                                                           * because
                                                                                           * of
                                                                                           * extensions:
                                                                                           * "invoice/UBL-Invoice-2.0-Enveloped.xml"
                                                                                           */
                                                                                          "invoice/UBL-Invoice-2.0-Example-NS1.xml",
                                                                                          "invoice/UBL-Invoice-2.0-Example-NS2.xml",
                                                                                          "invoice/UBL-Invoice-2.0-Example-NS3.xml",
                                                                                          "invoice/UBL-Invoice-2.0-Example-NS4.xml",
                                                                                          "invoice/UBL-Invoice-2.0-Example.xml",
                                                                                          "invoice/UBL-Invoice-2.1-Example-Trivial.xml",
                                                                                          "invoice/UBL-Invoice-2.1-Example.xml");

  public static final List <String> ORDER_FILES = CollectionHelper.newUnmodifiableList ("order/BII03 Order example 01.xml",
                                                                                        "order/CENBII-Order-maximal.xml",
                                                                                        "order/CENBII-Order-minimal.xml",
                                                                                        "order/UBL-Order-2.0-Example-International.xml",
                                                                                        "order/UBL-Order-2.0-Example.xml",
                                                                                        "order/UBL-Order-2.1-Example.xml");

  public static final List <String> ORDER_CANCELLATION_FILES = CollectionHelper.newUnmodifiableList ("ordercancellation/UBL-OrderCancellation-2.1-Example.xml");

  public static final List <String> ORDER_CHANGE_FILES = CollectionHelper.newUnmodifiableList ("orderchange/UBL-OrderChange-2.1-Example.xml");

  public static final List <String> ORDER_RESPONSE_FILES = CollectionHelper.newUnmodifiableList ("orderresponse/UBL-OrderResponse-2.1-Example.xml");

  public static final List <String> ORDER_RESPONSE_SIMPLE_FILES = CollectionHelper.newUnmodifiableList ("orderresponsesimple/CENBII-AcceptOrder-maximal.xml",
                                                                                                        "orderresponsesimple/CENBII-AcceptOrder-minimal.xml",
                                                                                                        "orderresponsesimple/CENBII-RejectOrder-maximal.xml",
                                                                                                        "orderresponsesimple/CENBII-RejectOrder-minimal.xml",
                                                                                                        "orderresponsesimple/UBL-OrderResponseSimple-2.0-Example.xml",
                                                                                                        "orderresponsesimple/UBL-OrderResponseSimple-2.1-Example.xml");

  public static final List <String> PRODUCT_ACTIVITY_FILES = CollectionHelper.newUnmodifiableList ("productactivity/UBL-ProductActivity-2.1-Example-1.xml",
                                                                                                   "productactivity/UBL-ProductActivity-2.1-Example-2.xml",
                                                                                                   "productactivity/UBL-ProductActivity-2.1-Example-3.xml");

  public static final List <String> QUOTATION_FILES = CollectionHelper.newUnmodifiableList ("quotation/UBL-Quotation-2.0-Example.xml",
                                                                                            "quotation/UBL-Quotation-2.1-Example.xml");

  public static final List <String> RECEIPT_ADVICE_FILES = CollectionHelper.newUnmodifiableList ("receiptadvice/UBL-ReceiptAdvice-2.0-Example.xml");

  public static final List <String> REMINDER_FILES = CollectionHelper.newUnmodifiableList ("reminder/UBL-Reminder-2.1-Example.xml");

  public static final List <String> REMITTANCE_ADVICE_FILES = CollectionHelper.newUnmodifiableList ("remittanceadvice/UBL-RemittanceAdvice-2.0-Example.xml");

  public static final List <String> REQUEST_FOR_QUOTATION_FILES = CollectionHelper.newUnmodifiableList ("requestforquotation/UBL-RequestForQuotation-2.0-Example.xml",
                                                                                                        "requestforquotation/UBL-RequestForQuotation-2.1-Example.xml");

  public static final List <String> RETAIL_EVENT_FILES = CollectionHelper.newUnmodifiableList ("retailevent/UBL-RetailEvent-2.1-Example.xml");

  public static final List <String> SELF_BILLED_CREDIT_NOTE_FILES = CollectionHelper.newUnmodifiableList ("selfbilledcreditnote/UBL-SelfBilledCreditNote-2.1-Example.xml");

  public static final List <String> STATEMENT_FILES = CollectionHelper.newUnmodifiableList ("statement/UBL-Statement-2.0-Example.xml");

  public static final List <String> STOCK_AVAILABILITY_REPORT_FILES = CollectionHelper.newUnmodifiableList ("stockavailabilityreport/UBL-StockAvailabilityReport-2.1-Example.xml");

  public static final List <String> TRADE_ITEM_LOCATION_PROFILE_FILES = CollectionHelper.newUnmodifiableList ("tradeitemlocationprofile/UBL-TradeItemLocationProfile-2.1-Example.xml");

  public static final List <String> TRANSPORTATION_STATUS_FILES = CollectionHelper.newUnmodifiableList ("transportationstatus/UBL-TransportationStatus-2.1-Example.xml");

  public static final List <String> TRANSPORTATION_STATUS_REQUEST_FILES = CollectionHelper.newUnmodifiableList ("transportationstatusrequest/UBL-TransportationStatusRequest-2.1-Example.xml");

  public static final List <String> TRANSPORT_EXECUTION_PLAN_FILES = CollectionHelper.newUnmodifiableList ("transportexecutionplan/UBL-TransportExecutionPlan-2.1-Example.xml");

  public static final List <String> TRANSPORT_EXECUTION_PLAN_REQUEST_FILES = CollectionHelper.newUnmodifiableList ("transportexecutionplanrequest/UBL-TransportExecutionPlanRequest-2.1-Example.xml");

  public static final List <String> TRANSPORT_PROGRESS_STATUS_FILES = CollectionHelper.newUnmodifiableList ("transportprogressstatus/UBL-TransportProgressStatus-2.1-Example.xml");

  public static final List <String> TRANSPORT_PROGRESS_STATUS_REQUEST_FILES = CollectionHelper.newUnmodifiableList ("transportprogressstatusrequest/UBL-TransportProgressStatusRequest-2.1-Example.xml");

  public static final List <String> TRANSPORT_SERVICE_DESCRIPTION_FILES = CollectionHelper.newUnmodifiableList ("transportservicedescription/UBL-TransportServiceDescription-2.1-Example.xml");

  public static final List <String> TRANSPORT_SERVICE_DESCRIPTION_REQUEST_FILES = CollectionHelper.newUnmodifiableList ("transportservicedescriptionrequest/UBL-TransportServiceDescriptionRequest-2.1-Example.xml");

  public static final List <String> WAYBILL_FILES = CollectionHelper.newUnmodifiableList ("waybill/UBL-Waybill-2.0-Example-International.xml");

  public UBLTestFiles ()
  {}
}
