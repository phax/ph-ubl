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
package com.helger.ubl21;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.error.IResourceErrorGroup;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.lang.ClassHelper;
import com.helger.commons.string.StringHelper;
import com.helger.commons.xml.schema.XMLSchemaCache;
import com.helger.commons.xml.schema.XMLSchemaValidationHelper;
import com.helger.ubl.api.IUBLDocumentType;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Enumeration with all available UBL 2.1 document types.
 *
 * @author Philip Helger
 */
public enum EUBL21DocumentType implements IUBLDocumentType
{
 APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ApplicationResponseType.class, "UBL-ApplicationResponse-2.1.xsd"),
 ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_21.AttachedDocumentType.class, "UBL-AttachedDocument-2.1.xsd"),
 AWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.awardednotification_21.AwardedNotificationType.class, "UBL-AwardedNotification-2.1.xsd"),
 BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_21.BillOfLadingType.class, "UBL-BillOfLading-2.1.xsd"),
 CALL_FOR_TENDERS (oasis.names.specification.ubl.schema.xsd.callfortenders_21.CallForTendersType.class, "UBL-CallForTenders-2.1.xsd"),
 CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_21.CatalogueType.class, "UBL-Catalogue-2.1.xsd"),
 CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_21.CatalogueDeletionType.class, "UBL-CatalogueDeletion-2.1.xsd"),
 CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_21.CatalogueItemSpecificationUpdateType.class, "UBL-CatalogueItemSpecificationUpdate-2.1.xsd"),
 CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_21.CataloguePricingUpdateType.class, "UBL-CataloguePricingUpdate-2.1.xsd"),
 CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_21.CatalogueRequestType.class, "UBL-CatalogueRequest-2.1.xsd"),
 CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_21.CertificateOfOriginType.class, "UBL-CertificateOfOrigin-2.1.xsd"),
 CONTRACT_AWARD_NOTICE (oasis.names.specification.ubl.schema.xsd.contractawardnotice_21.ContractAwardNoticeType.class, "UBL-ContractAwardNotice-2.1.xsd"),
 CONTRACT_NOTICE (oasis.names.specification.ubl.schema.xsd.contractnotice_21.ContractNoticeType.class, "UBL-ContractNotice-2.1.xsd"),
 CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType.class, "UBL-CreditNote-2.1.xsd"),
 DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType.class, "UBL-DebitNote-2.1.xsd"),
 DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_21.DespatchAdviceType.class, "UBL-DespatchAdvice-2.1.xsd"),
 DOCUMENT_STATUS (oasis.names.specification.ubl.schema.xsd.documentstatus_21.DocumentStatusType.class, "UBL-DocumentStatus-2.1.xsd"),
 DOCUMENT_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.documentstatusrequest_21.DocumentStatusRequestType.class, "UBL-DocumentStatusRequest-2.1.xsd"),
 EXCEPTION_CRITERIA (oasis.names.specification.ubl.schema.xsd.exceptioncriteria_21.ExceptionCriteriaType.class, "UBL-ExceptionCriteria-2.1.xsd"),
 EXCEPTION_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.exceptionnotification_21.ExceptionNotificationType.class, "UBL-ExceptionNotification-2.1.xsd"),
 FORECAST (oasis.names.specification.ubl.schema.xsd.forecast_21.ForecastType.class, "UBL-Forecast-2.1.xsd"),
 FORECAST_REVISION (oasis.names.specification.ubl.schema.xsd.forecastrevision_21.ForecastRevisionType.class, "UBL-ForecastRevision-2.1.xsd"),
 FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_21.ForwardingInstructionsType.class, "UBL-ForwardingInstructions-2.1.xsd"),
 FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_21.FreightInvoiceType.class, "UBL-FreightInvoice-2.1.xsd"),
 FULFILMENT_CANCELATION (oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_21.FulfilmentCancellationType.class, "UBL-FulfilmentCancellation-2.1.xsd"),
 GOODS_ITEM_ITINERARY (oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_21.GoodsItemItineraryType.class, "UBL-GoodsItemItinerary-2.1.xsd"),
 GUARANTEE_CERTIFICATE (oasis.names.specification.ubl.schema.xsd.guaranteecertificate_21.GuaranteeCertificateType.class, "UBL-GuaranteeCertificate-2.1.xsd"),
 INSTRUCTION_FOR_RETURNS (oasis.names.specification.ubl.schema.xsd.instructionforreturns_21.InstructionForReturnsType.class, "UBL-InstructionForReturns-2.1.xsd"),
 INVENTORY_REPORT (oasis.names.specification.ubl.schema.xsd.inventoryreport_21.InventoryReportType.class, "UBL-InventoryReport-2.1.xsd"),
 INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType.class, "UBL-Invoice-2.1.xsd"),
 ITEM_INFORMATION_REQUEST (oasis.names.specification.ubl.schema.xsd.iteminformationrequest_21.ItemInformationRequestType.class, "UBL-ItemInformationRequest-2.1.xsd"),
 ORDER (oasis.names.specification.ubl.schema.xsd.order_21.OrderType.class, "UBL-Order-2.1.xsd"),
 ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_21.OrderCancellationType.class, "UBL-OrderCancellation-2.1.xsd"),
 ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_21.OrderChangeType.class, "UBL-OrderChange-2.1.xsd"),
 ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_21.OrderResponseType.class, "UBL-OrderResponse-2.1.xsd"),
 ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_21.OrderResponseSimpleType.class, "UBL-OrderResponseSimple-2.1.xsd"),
 PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_21.PackingListType.class, "UBL-PackingList-2.1.xsd"),
 PRIOR_INFORMATION_NOTICE (oasis.names.specification.ubl.schema.xsd.priorinformationnotice_21.PriorInformationNoticeType.class, "UBL-PriorInformationNotice-2.1.xsd"),
 PRODUCT_ACTIVITY (oasis.names.specification.ubl.schema.xsd.productactivity_21.ProductActivityType.class, "UBL-ProductActivity-2.1.xsd"),
 QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_21.QuotationType.class, "UBL-Quotation-2.1.xsd"),
 RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_21.ReceiptAdviceType.class, "UBL-ReceiptAdvice-2.1.xsd"),
 REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_21.ReminderType.class, "UBL-Reminder-2.1.xsd"),
 REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_21.RemittanceAdviceType.class, "UBL-RemittanceAdvice-2.1.xsd"),
 REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_21.RequestForQuotationType.class, "UBL-RequestForQuotation-2.1.xsd"),
 RETAIL_EVENT (oasis.names.specification.ubl.schema.xsd.retailevent_21.RetailEventType.class, "UBL-RetailEvent-2.1.xsd"),
 SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_21.SelfBilledCreditNoteType.class, "UBL-SelfBilledCreditNote-2.1.xsd"),
 SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_21.SelfBilledInvoiceType.class, "UBL-SelfBilledInvoice-2.1.xsd"),
 STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_21.StatementType.class, "UBL-Statement-2.1.xsd"),
 STOCK_AVAILABILITY_REPORT (oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_21.StockAvailabilityReportType.class, "UBL-StockAvailabilityReport-2.1.xsd"),
 TENDER (oasis.names.specification.ubl.schema.xsd.tender_21.TenderType.class, "UBL-Tender-2.1.xsd"),
 TENDER_QUALIFICATION (oasis.names.specification.ubl.schema.xsd.tendererqualification_21.TendererQualificationType.class, "UBL-TendererQualification-2.1.xsd"),
 TENDER_QUALIFICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_21.TendererQualificationResponseType.class, "UBL-TendererQualificationResponse-2.1.xsd"),
 TENDER_RECEIPT (oasis.names.specification.ubl.schema.xsd.tenderreceipt_21.TenderReceiptType.class, "UBL-TenderReceipt-2.1.xsd"),
 TRADE_ITEM_LOCATION_PROFILE (oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_21.TradeItemLocationProfileType.class, "UBL-TradeItemLocationProfile-2.1.xsd"),
 TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_21.TransportationStatusType.class, "UBL-TransportationStatus-2.1.xsd"),
 TRANSPORTATION_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_21.TransportationStatusRequestType.class, "UBL-TransportationStatusRequest-2.1.xsd"),
 TRANSPORT_EXECUTION_PLAN (oasis.names.specification.ubl.schema.xsd.transportexecutionplan_21.TransportExecutionPlanType.class, "UBL-TransportExecutionPlan-2.1.xsd"),
 TRANSPORT_EXECUTION_PLAN_REQUEST (oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_21.TransportExecutionPlanRequestType.class, "UBL-TransportExecutionPlanRequest-2.1.xsd"),
 TRANSPORT_PROGRESS_STATUS (oasis.names.specification.ubl.schema.xsd.transportprogressstatus_21.TransportProgressStatusType.class, "UBL-TransportProgressStatus-2.1.xsd"),
 TRANSPORT_PROGRESS_STATUS_REQUEST (oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_21.TransportProgressStatusRequestType.class, "UBL-TransportProgressStatusRequest-2.1.xsd"),
 TRANSPORT_SERVICE_DESCRIPTION (oasis.names.specification.ubl.schema.xsd.transportservicedescription_21.TransportServiceDescriptionType.class, "UBL-TransportServiceDescription-2.1.xsd"),
 TRANSPORT_SERVICE_DESCRIPTION_REQUEST (oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_21.TransportServiceDescriptionRequestType.class, "UBL-TransportServiceDescriptionRequest-2.1.xsd"),
 UNAWARDED_NOTIFICATION (oasis.names.specification.ubl.schema.xsd.unawardednotification_21.UnawardedNotificationType.class, "UBL-UnawardedNotification-2.1.xsd"),
 UTILITY_STATEMENT (oasis.names.specification.ubl.schema.xsd.utilitystatement_21.UtilityStatementType.class, "UBL-UtilityStatement-2.1.xsd"),
 WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_21.WaybillType.class, "UBL-Waybill-2.1.xsd");

  private final Class <?> m_aClass;
  private final String m_sLocalName;
  private final String m_sNamespaceURI;
  private final QName m_aQName;
  private final String m_sXSDPath;
  @CodingStyleguideUnaware
  private Schema m_aSchema;

  private EUBL21DocumentType (@Nonnull final Class <?> aClass, @Nonnull final String sXSDPath)
  {
    ValueEnforcer.notNull (aClass, "Class");
    ValueEnforcer.notEmpty (sXSDPath, "XSDPath");

    // Check whether it is an @XmlType class
    final XmlType aXmlType = aClass.getAnnotation (XmlType.class);
    if (aXmlType == null)
      throw new IllegalArgumentException ("The passed class does not have an @XMLType annotation!");

    // Get the package of the passed Class
    final Package aPackage = aClass.getPackage ();

    // The package must have the annotation "XmlSchema" with the corresponding
    // namespace it supports
    final XmlSchema aXmlSchema = aPackage.getAnnotation (XmlSchema.class);
    if (aXmlSchema == null)
      throw new IllegalArgumentException ("The package '" + aPackage.getName () + "' has no @XmlSchema annotation!");

    // Hack: build the element name from the type, excluding the "Type" at the
    // end
    String sLocalName = ClassHelper.getClassLocalName (aClass);
    sLocalName = sLocalName.substring (0, sLocalName.length () - "Type".length ());

    m_aClass = aClass;
    m_sLocalName = sLocalName;
    m_sNamespaceURI = aXmlSchema.namespace ();
    if (StringHelper.hasNoText (m_sNamespaceURI))
      throw new IllegalArgumentException ("The package '" +
                                          aPackage.getName () +
                                          "' has no namespace in the @XmlSchema annotation!");
    m_aQName = new QName (m_sNamespaceURI, sLocalName);
    m_sXSDPath = CUBL21.SCHEMA_DIRECTORY + sXSDPath;
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aClass;
  }

  @Nonnull
  public Package getPackage ()
  {
    return m_aClass.getPackage ();
  }

  @Nonnull
  public String getLocalName ()
  {
    return m_sLocalName;
  }

  @Nonnull
  public String getNamespaceURI ()
  {
    return m_sNamespaceURI;
  }

  @Nonnull
  public QName getQName ()
  {
    return m_aQName;
  }

  @Nonnull
  public String getXSDPath ()
  {
    return m_sXSDPath;
  }

  @Nonnull
  public IReadableResource getXSDResource (@Nullable final ClassLoader aClassLoader)
  {
    return new ClassPathResource (m_sXSDPath, aClassLoader);
  }

  @Nonnull
  @SuppressFBWarnings ("RCN_REDUNDANT_NULLCHECK_OF_NONNULL_VALUE")
  public Schema getSchema (@Nullable final ClassLoader aClassLoader)
  {
    if (m_aSchema == null)
    {
      // Lazy initialization
      final IReadableResource aXSDRes = getXSDResource (aClassLoader);
      m_aSchema = XMLSchemaCache.getInstanceOfClassLoader (aClassLoader).getSchema (aXSDRes);
      if (m_aSchema == null)
        throw new IllegalStateException ("Failed to create Schema from " + aXSDRes);
    }
    return m_aSchema;
  }

  @Nonnull
  public IResourceErrorGroup validateXML (@Nonnull final IReadableResource aXML,
                                          @Nullable final ClassLoader aClassLoader)
  {
    return XMLSchemaValidationHelper.validate (getSchema (aClassLoader), aXML);
  }
}
