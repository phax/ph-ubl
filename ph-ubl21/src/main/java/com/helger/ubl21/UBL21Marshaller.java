/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
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
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;
import com.helger.xsds.xades132.CXAdES132;
import com.helger.xsds.xades141.CXAdES141;
import com.helger.xsds.xmldsig.CXMLDSig;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_21.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.awardednotification_21.AwardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.billoflading_21.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.callfortenders_21.CallForTendersType;
import oasis.names.specification.ubl.schema.xsd.catalogue_21.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_21.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_21.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_21.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_21.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_21.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_21.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_21.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_21.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.documentstatus_21.DocumentStatusType;
import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_21.DocumentStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_21.ExceptionCriteriaType;
import oasis.names.specification.ubl.schema.xsd.exceptionnotification_21.ExceptionNotificationType;
import oasis.names.specification.ubl.schema.xsd.forecast_21.ForecastType;
import oasis.names.specification.ubl.schema.xsd.forecastrevision_21.ForecastRevisionType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_21.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_21.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_21.FulfilmentCancellationType;
import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_21.GoodsItemItineraryType;
import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_21.GuaranteeCertificateType;
import oasis.names.specification.ubl.schema.xsd.instructionforreturns_21.InstructionForReturnsType;
import oasis.names.specification.ubl.schema.xsd.inventoryreport_21.InventoryReportType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_21.ItemInformationRequestType;
import oasis.names.specification.ubl.schema.xsd.order_21.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_21.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_21.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_21.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_21.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_21.PackingListType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_21.PriorInformationNoticeType;
import oasis.names.specification.ubl.schema.xsd.productactivity_21.ProductActivityType;
import oasis.names.specification.ubl.schema.xsd.quotation_21.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_21.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_21.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_21.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_21.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.retailevent_21.RetailEventType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_21.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_21.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_21.StatementType;
import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_21.StockAvailabilityReportType;
import oasis.names.specification.ubl.schema.xsd.tender_21.TenderType;
import oasis.names.specification.ubl.schema.xsd.tendererqualification_21.TendererQualificationType;
import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_21.TendererQualificationResponseType;
import oasis.names.specification.ubl.schema.xsd.tenderreceipt_21.TenderReceiptType;
import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_21.TradeItemLocationProfileType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_21.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_21.TransportationStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_21.TransportExecutionPlanType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_21.TransportExecutionPlanRequestType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_21.TransportProgressStatusType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_21.TransportProgressStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescription_21.TransportServiceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_21.TransportServiceDescriptionRequestType;
import oasis.names.specification.ubl.schema.xsd.unawardednotification_21.UnawardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.utilitystatement_21.UtilityStatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_21.WaybillType;

/**
 * The class provides all the UBL 2.0 marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class UBL21Marshaller
{
  public static class UBL21JAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    private static final ICommonsList <ClassPathResource> BASE_XSDS = new CommonsArrayList <> (CCCTS.getXSDResource (),
                                                                                               CXMLDSig.getXSDResource (),
                                                                                               CXAdES132.getXSDResource (),
                                                                                               CXAdES141.getXSDResource ());

    @Nonnull
    public static ICommonsList <ClassPathResource> getAllXSDs (@Nonnull final ClassPathResource aXSD)
    {
      final ICommonsList <ClassPathResource> ret = BASE_XSDS.getClone ();
      ret.add (aXSD);
      return ret;
    }

    public UBL21JAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nonnull final ClassPathResource aXSD,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, getAllXSDs (aXSD), createSimpleJAXBElement (aRootElementQName, aType));

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBL21NamespaceContext.getInstance ().getClone ();
      // Avoid overwriting an already mapped context
      if (!aNSContext.isNamespaceURIMapped (aRootElementQName.getNamespaceURI ()))
        aNSContext.addDefaultNamespaceURI (aRootElementQName.getNamespaceURI ());
      setNamespaceContext (aNSContext);
    }

    @Nullable
    public Schema getSchema ()
    {
      return createValidationSchema ();
    }
  }

  private UBL21Marshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CUBL21.SCHEMA_DIRECTORY + sXSDPath, CUBL21.getCL ());
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new UBL21JAXBMarshaller <> (ApplicationResponseType.class,
                                       _getCPR ("UBL-ApplicationResponse-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ObjectFactory._ApplicationResponse_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new UBL21JAXBMarshaller <> (AttachedDocumentType.class,
                                       _getCPR ("UBL-AttachedDocument-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.attacheddocument_21.ObjectFactory._AttachedDocument_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <AwardedNotificationType> awardedNotification ()
  {
    return new UBL21JAXBMarshaller <> (AwardedNotificationType.class,
                                       _getCPR ("UBL-AwardedNotification-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.awardednotification_21.ObjectFactory._AwardedNotification_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <BillOfLadingType> billOfLading ()
  {
    return new UBL21JAXBMarshaller <> (BillOfLadingType.class,
                                       _getCPR ("UBL-BillOfLading-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.billoflading_21.ObjectFactory._BillOfLading_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CallForTendersType> callForTenders ()
  {
    return new UBL21JAXBMarshaller <> (CallForTendersType.class,
                                       _getCPR ("UBL-CallForTenders-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.callfortenders_21.ObjectFactory._CallForTenders_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CatalogueType> catalogue ()
  {
    return new UBL21JAXBMarshaller <> (CatalogueType.class,
                                       _getCPR ("UBL-Catalogue-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.catalogue_21.ObjectFactory._Catalogue_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CatalogueDeletionType> catalogueDeletion ()
  {
    return new UBL21JAXBMarshaller <> (CatalogueDeletionType.class,
                                       _getCPR ("UBL-CatalogueDeletion-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguedeletion_21.ObjectFactory._CatalogueDeletion_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return new UBL21JAXBMarshaller <> (CatalogueItemSpecificationUpdateType.class,
                                       _getCPR ("UBL-CatalogueItemSpecificationUpdate-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_21.ObjectFactory._CatalogueItemSpecificationUpdate_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return new UBL21JAXBMarshaller <> (CataloguePricingUpdateType.class,
                                       _getCPR ("UBL-CataloguePricingUpdate-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_21.ObjectFactory._CataloguePricingUpdate_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CatalogueRequestType> catalogueRequest ()
  {
    return new UBL21JAXBMarshaller <> (CatalogueRequestType.class,
                                       _getCPR ("UBL-CatalogueRequest-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguerequest_21.ObjectFactory._CatalogueRequest_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CertificateOfOriginType> certificateOfOrigin ()
  {
    return new UBL21JAXBMarshaller <> (CertificateOfOriginType.class,
                                       _getCPR ("UBL-CertificateOfOrigin-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.certificateoforigin_21.ObjectFactory._CertificateOfOrigin_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ContractAwardNoticeType> contractAwardNotice ()
  {
    return new UBL21JAXBMarshaller <> (ContractAwardNoticeType.class,
                                       _getCPR ("UBL-ContractAwardNotice-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.contractawardnotice_21.ObjectFactory._ContractAwardNotice_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ContractNoticeType> contractNotice ()
  {
    return new UBL21JAXBMarshaller <> (ContractNoticeType.class,
                                       _getCPR ("UBL-ContractNotice-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.contractnotice_21.ObjectFactory._ContractNotice_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new UBL21JAXBMarshaller <> (CreditNoteType.class,
                                       _getCPR ("UBL-CreditNote-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_21.ObjectFactory._CreditNote_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new UBL21JAXBMarshaller <> (DebitNoteType.class,
                                       _getCPR ("UBL-DebitNote-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.debitnote_21.ObjectFactory._DebitNote_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <DespatchAdviceType> despatchAdvice ()
  {
    return new UBL21JAXBMarshaller <> (DespatchAdviceType.class,
                                       _getCPR ("UBL-DespatchAdvice-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.despatchadvice_21.ObjectFactory._DespatchAdvice_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <DocumentStatusType> documentStatus ()
  {
    return new UBL21JAXBMarshaller <> (DocumentStatusType.class,
                                       _getCPR ("UBL-DocumentStatus-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.documentstatus_21.ObjectFactory._DocumentStatus_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <DocumentStatusRequestType> documentStatusRequest ()
  {
    return new UBL21JAXBMarshaller <> (DocumentStatusRequestType.class,
                                       _getCPR ("UBL-DocumentStatusRequest-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.documentstatusrequest_21.ObjectFactory._DocumentStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ExceptionCriteriaType> exceptionCriteria ()
  {
    return new UBL21JAXBMarshaller <> (ExceptionCriteriaType.class,
                                       _getCPR ("UBL-ExceptionCriteria-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.exceptioncriteria_21.ObjectFactory._ExceptionCriteria_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ExceptionNotificationType> exceptionNotification ()
  {
    return new UBL21JAXBMarshaller <> (ExceptionNotificationType.class,
                                       _getCPR ("UBL-ExceptionNotification-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.exceptionnotification_21.ObjectFactory._ExceptionNotification_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ForecastType> forecast ()
  {
    return new UBL21JAXBMarshaller <> (ForecastType.class,
                                       _getCPR ("UBL-Forecast-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forecast_21.ObjectFactory._Forecast_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ForecastRevisionType> forecastRevision ()
  {
    return new UBL21JAXBMarshaller <> (ForecastRevisionType.class,
                                       _getCPR ("UBL-ForecastRevision-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forecastrevision_21.ObjectFactory._ForecastRevision_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ForwardingInstructionsType> forwardingInstructions ()
  {
    return new UBL21JAXBMarshaller <> (ForwardingInstructionsType.class,
                                       _getCPR ("UBL-ForwardingInstructions-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forwardinginstructions_21.ObjectFactory._ForwardingInstructions_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <FreightInvoiceType> freightInvoice ()
  {
    return new UBL21JAXBMarshaller <> (FreightInvoiceType.class,
                                       _getCPR ("UBL-FreightInvoice-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.freightinvoice_21.ObjectFactory._FreightInvoice_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return new UBL21JAXBMarshaller <> (FulfilmentCancellationType.class,
                                       _getCPR ("UBL-FulfilmentCancellation-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_21.ObjectFactory._FulfilmentCancellation_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return new UBL21JAXBMarshaller <> (GoodsItemItineraryType.class,
                                       _getCPR ("UBL-GoodsItemItinerary-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_21.ObjectFactory._GoodsItemItinerary_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return new UBL21JAXBMarshaller <> (GuaranteeCertificateType.class,
                                       _getCPR ("UBL-GuaranteeCertificate-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.guaranteecertificate_21.ObjectFactory._GuaranteeCertificate_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <InstructionForReturnsType> instructionForReturns ()
  {
    return new UBL21JAXBMarshaller <> (InstructionForReturnsType.class,
                                       _getCPR ("UBL-InstructionForReturns-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.instructionforreturns_21.ObjectFactory._InstructionForReturns_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <InventoryReportType> inventoryReport ()
  {
    return new UBL21JAXBMarshaller <> (InventoryReportType.class,
                                       _getCPR ("UBL-InventoryReport-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.inventoryreport_21.ObjectFactory._InventoryReport_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <InvoiceType> invoice ()
  {
    return new UBL21JAXBMarshaller <> (InvoiceType.class,
                                       _getCPR ("UBL-Invoice-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.invoice_21.ObjectFactory._Invoice_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ItemInformationRequestType> itemInformationRequest ()
  {
    return new UBL21JAXBMarshaller <> (ItemInformationRequestType.class,
                                       _getCPR ("UBL-ItemInformationRequest-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.iteminformationrequest_21.ObjectFactory._ItemInformationRequest_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <OrderType> order ()
  {
    return new UBL21JAXBMarshaller <> (OrderType.class,
                                       _getCPR ("UBL-Order-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.order_21.ObjectFactory._Order_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <OrderCancellationType> orderCancellation ()
  {
    return new UBL21JAXBMarshaller <> (OrderCancellationType.class,
                                       _getCPR ("UBL-OrderCancellation-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.ordercancellation_21.ObjectFactory._OrderCancellation_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <OrderChangeType> orderChange ()
  {
    return new UBL21JAXBMarshaller <> (OrderChangeType.class,
                                       _getCPR ("UBL-OrderChange-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderchange_21.ObjectFactory._OrderChange_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <OrderResponseType> orderResponse ()
  {
    return new UBL21JAXBMarshaller <> (OrderResponseType.class,
                                       _getCPR ("UBL-OrderResponse-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderresponse_21.ObjectFactory._OrderResponse_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <OrderResponseSimpleType> orderResponseSimple ()
  {
    return new UBL21JAXBMarshaller <> (OrderResponseSimpleType.class,
                                       _getCPR ("UBL-OrderResponseSimple-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderresponsesimple_21.ObjectFactory._OrderResponseSimple_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <PackingListType> packingList ()
  {
    return new UBL21JAXBMarshaller <> (PackingListType.class,
                                       _getCPR ("UBL-PackingList-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.packinglist_21.ObjectFactory._PackingList_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <PriorInformationNoticeType> priorInformationNotice ()
  {
    return new UBL21JAXBMarshaller <> (PriorInformationNoticeType.class,
                                       _getCPR ("UBL-PriorInformationNotice-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.priorinformationnotice_21.ObjectFactory._PriorInformationNotice_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ProductActivityType> productActivity ()
  {
    return new UBL21JAXBMarshaller <> (ProductActivityType.class,
                                       _getCPR ("UBL-ProductActivity-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.productactivity_21.ObjectFactory._ProductActivity_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <QuotationType> quotation ()
  {
    return new UBL21JAXBMarshaller <> (QuotationType.class,
                                       _getCPR ("UBL-Quotation-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.quotation_21.ObjectFactory._Quotation_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ReceiptAdviceType> receiptAdvice ()
  {
    return new UBL21JAXBMarshaller <> (ReceiptAdviceType.class,
                                       _getCPR ("UBL-ReceiptAdvice-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.receiptadvice_21.ObjectFactory._ReceiptAdvice_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ReminderType> reminder ()
  {
    return new UBL21JAXBMarshaller <> (ReminderType.class,
                                       _getCPR ("UBL-Reminder-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.reminder_21.ObjectFactory._Reminder_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <RemittanceAdviceType> remittanceAdvice ()
  {
    return new UBL21JAXBMarshaller <> (RemittanceAdviceType.class,
                                       _getCPR ("UBL-RemittanceAdvice-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.remittanceadvice_21.ObjectFactory._RemittanceAdvice_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <RequestForQuotationType> requestForQuotation ()
  {
    return new UBL21JAXBMarshaller <> (RequestForQuotationType.class,
                                       _getCPR ("UBL-RequestForQuotation-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.requestforquotation_21.ObjectFactory._RequestForQuotation_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <RetailEventType> retailEvent ()
  {
    return new UBL21JAXBMarshaller <> (RetailEventType.class,
                                       _getCPR ("UBL-RetailEvent-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.retailevent_21.ObjectFactory._RetailEvent_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return new UBL21JAXBMarshaller <> (SelfBilledCreditNoteType.class,
                                       _getCPR ("UBL-SelfBilledCreditNote-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_21.ObjectFactory._SelfBilledCreditNote_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return new UBL21JAXBMarshaller <> (SelfBilledInvoiceType.class,
                                       _getCPR ("UBL-SelfBilledInvoice-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_21.ObjectFactory._SelfBilledInvoice_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <StatementType> statement ()
  {
    return new UBL21JAXBMarshaller <> (StatementType.class,
                                       _getCPR ("UBL-Statement-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.statement_21.ObjectFactory._Statement_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return new UBL21JAXBMarshaller <> (StockAvailabilityReportType.class,
                                       _getCPR ("UBL-StockAvailabilityReport-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_21.ObjectFactory._StockAvailabilityReport_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TenderType> tender ()
  {
    return new UBL21JAXBMarshaller <> (TenderType.class,
                                       _getCPR ("UBL-Tender-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tender_21.ObjectFactory._Tender_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TendererQualificationType> tendererQualification ()
  {
    return new UBL21JAXBMarshaller <> (TendererQualificationType.class,
                                       _getCPR ("UBL-TendererQualification-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualification_21.ObjectFactory._TendererQualification_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return new UBL21JAXBMarshaller <> (TendererQualificationResponseType.class,
                                       _getCPR ("UBL-TendererQualificationResponse-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_21.ObjectFactory._TendererQualificationResponse_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TenderReceiptType> tenderReceipt ()
  {
    return new UBL21JAXBMarshaller <> (TenderReceiptType.class,
                                       _getCPR ("UBL-TenderReceipt-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderreceipt_21.ObjectFactory._TenderReceipt_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return new UBL21JAXBMarshaller <> (TradeItemLocationProfileType.class,
                                       _getCPR ("UBL-TradeItemLocationProfile-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_21.ObjectFactory._TradeItemLocationProfile_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportationStatusType> transportationStatus ()
  {
    return new UBL21JAXBMarshaller <> (TransportationStatusType.class,
                                       _getCPR ("UBL-TransportationStatus-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatus_21.ObjectFactory._TransportationStatus_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return new UBL21JAXBMarshaller <> (TransportationStatusRequestType.class,
                                       _getCPR ("UBL-TransportationStatusRequest-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_21.ObjectFactory._TransportationStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return new UBL21JAXBMarshaller <> (TransportExecutionPlanType.class,
                                       _getCPR ("UBL-TransportExecutionPlan-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplan_21.ObjectFactory._TransportExecutionPlan_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return new UBL21JAXBMarshaller <> (TransportExecutionPlanRequestType.class,
                                       _getCPR ("UBL-TransportExecutionPlanRequest-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_21.ObjectFactory._TransportExecutionPlanRequest_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportProgressStatusType> transportProgressStatus ()
  {
    return new UBL21JAXBMarshaller <> (TransportProgressStatusType.class,
                                       _getCPR ("UBL-TransportProgressStatus-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatus_21.ObjectFactory._TransportProgressStatus_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return new UBL21JAXBMarshaller <> (TransportProgressStatusRequestType.class,
                                       _getCPR ("UBL-TransportProgressStatusRequest-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_21.ObjectFactory._TransportProgressStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return new UBL21JAXBMarshaller <> (TransportServiceDescriptionType.class,
                                       _getCPR ("UBL-TransportServiceDescription-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescription_21.ObjectFactory._TransportServiceDescription_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return new UBL21JAXBMarshaller <> (TransportServiceDescriptionRequestType.class,
                                       _getCPR ("UBL-TransportServiceDescriptionRequest-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_21.ObjectFactory._TransportServiceDescriptionRequest_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <UnawardedNotificationType> unawardedNotification ()
  {
    return new UBL21JAXBMarshaller <> (UnawardedNotificationType.class,
                                       _getCPR ("UBL-UnawardedNotification-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.unawardednotification_21.ObjectFactory._UnawardedNotification_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <UtilityStatementType> utilityStatement ()
  {
    return new UBL21JAXBMarshaller <> (UtilityStatementType.class,
                                       _getCPR ("UBL-UtilityStatement-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.utilitystatement_21.ObjectFactory._UtilityStatement_QNAME);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <WaybillType> waybill ()
  {
    return new UBL21JAXBMarshaller <> (WaybillType.class,
                                       _getCPR ("UBL-Waybill-2.1.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.waybill_21.ObjectFactory._Waybill_QNAME);
  }
}
