/*
 * Copyright (C) 2014-2024 Philip Helger (www.helger.com)
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

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
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
    private final QName m_aRootElementQName;

    public UBL21JAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nonnull @Nonempty final ICommonsList <ClassPathResource> aXSDs,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, aXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      m_aRootElementQName = aRootElementQName;

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBL21NamespaceContext.getInstance ().getClone ();
      // Avoid overwriting an already mapped context
      if (!aNSContext.isNamespaceURIMapped (aRootElementQName.getNamespaceURI ()))
        aNSContext.addDefaultNamespaceURI (aRootElementQName.getNamespaceURI ());
      setNamespaceContext (aNSContext);
    }

    @Nonnull
    public final QName getRootElementQName ()
    {
      return m_aRootElementQName;
    }

    @Nonnull
    public final String getRootElementNamespaceURI ()
    {
      return m_aRootElementQName.getNamespaceURI ();
    }

    @Nullable
    public Schema getSchema ()
    {
      return createValidationSchema ();
    }
  }

  private static final ICommonsList <ClassPathResource> BASE_XSDS = new CommonsArrayList <> (CCCTS.getXSDResource (),
                                                                                             CXMLDSig.getXSDResource (),
                                                                                             CXAdES132.getXSDResource (),
                                                                                             CXAdES141.getXSDResource (),
                                                                                             CUBL21.XSD_UNQUALIFIED_DATA_TYPES,
                                                                                             CUBL21.XSD_QUALIFIED_DATA_TYPES,
                                                                                             CUBL21.XSD_SIGNATURE_BASIC_COMPONENTS,
                                                                                             CUBL21.XSD_COMMON_BASIC_COMPONENTS,
                                                                                             CUBL21.XSD_SIGNATURE_AGGREGATE_COMPONENTS,
                                                                                             CUBL21.XSD_COMMON_SIGNATURE_COMPONENTS,
                                                                                             CUBL21.XSD_COMMON_EXTENSION_COMPONENTS,
                                                                                             CUBL21.XSD_COMMON_AGGREGATE_COMPONENTS);

  @Nonnull
  @ReturnsMutableCopy
  private static ICommonsList <ClassPathResource> _getAllXSDs (@Nonnull final ClassPathResource aXSD)
  {
    final ICommonsList <ClassPathResource> ret = BASE_XSDS.getClone ();
    ret.add (aXSD);
    return ret;
  }

  private UBL21Marshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CUBL21.SCHEMA_DIRECTORY + sXSDPath, CUBL21.getCL ());
  }

  // Automatically created from here on

  private static final ClassPathResource CPR_APPLICATIONRESPONSE = _getCPR ("UBL-ApplicationResponse-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllApplicationResponseXSDs ()
  {
    return _getAllXSDs (CPR_APPLICATIONRESPONSE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new UBL21JAXBMarshaller <> (ApplicationResponseType.class,
                                       getAllApplicationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ObjectFactory._ApplicationResponse_QNAME);
  }

  private static final ClassPathResource CPR_ATTACHEDDOCUMENT = _getCPR ("UBL-AttachedDocument-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllAttachedDocumentXSDs ()
  {
    return _getAllXSDs (CPR_ATTACHEDDOCUMENT);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new UBL21JAXBMarshaller <> (AttachedDocumentType.class,
                                       getAllAttachedDocumentXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.attacheddocument_21.ObjectFactory._AttachedDocument_QNAME);
  }

  private static final ClassPathResource CPR_AWARDEDNOTIFICATION = _getCPR ("UBL-AwardedNotification-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllAwardedNotificationXSDs ()
  {
    return _getAllXSDs (CPR_AWARDEDNOTIFICATION);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <AwardedNotificationType> awardedNotification ()
  {
    return new UBL21JAXBMarshaller <> (AwardedNotificationType.class,
                                       getAllAwardedNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.awardednotification_21.ObjectFactory._AwardedNotification_QNAME);
  }

  private static final ClassPathResource CPR_BILLOFLADING = _getCPR ("UBL-BillOfLading-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBillOfLadingXSDs ()
  {
    return _getAllXSDs (CPR_BILLOFLADING);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <BillOfLadingType> billOfLading ()
  {
    return new UBL21JAXBMarshaller <> (BillOfLadingType.class,
                                       getAllBillOfLadingXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.billoflading_21.ObjectFactory._BillOfLading_QNAME);
  }

  private static final ClassPathResource CPR_CALLFORTENDERS = _getCPR ("UBL-CallForTenders-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCallForTendersXSDs ()
  {
    return _getAllXSDs (CPR_CALLFORTENDERS);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CallForTendersType> callForTenders ()
  {
    return new UBL21JAXBMarshaller <> (CallForTendersType.class,
                                       getAllCallForTendersXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.callfortenders_21.ObjectFactory._CallForTenders_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUE = _getCPR ("UBL-Catalogue-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CatalogueType> catalogue ()
  {
    return new UBL21JAXBMarshaller <> (CatalogueType.class,
                                       getAllCatalogueXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogue_21.ObjectFactory._Catalogue_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEDELETION = _getCPR ("UBL-CatalogueDeletion-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueDeletionXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEDELETION);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CatalogueDeletionType> catalogueDeletion ()
  {
    return new UBL21JAXBMarshaller <> (CatalogueDeletionType.class,
                                       getAllCatalogueDeletionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguedeletion_21.ObjectFactory._CatalogueDeletion_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEITEMSPECIFICATIONUPDATE = _getCPR ("UBL-CatalogueItemSpecificationUpdate-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueItemSpecificationUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEITEMSPECIFICATIONUPDATE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return new UBL21JAXBMarshaller <> (CatalogueItemSpecificationUpdateType.class,
                                       getAllCatalogueItemSpecificationUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_21.ObjectFactory._CatalogueItemSpecificationUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEPRICINGUPDATE = _getCPR ("UBL-CataloguePricingUpdate-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCataloguePricingUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEPRICINGUPDATE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return new UBL21JAXBMarshaller <> (CataloguePricingUpdateType.class,
                                       getAllCataloguePricingUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_21.ObjectFactory._CataloguePricingUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEREQUEST = _getCPR ("UBL-CatalogueRequest-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueRequestXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEREQUEST);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CatalogueRequestType> catalogueRequest ()
  {
    return new UBL21JAXBMarshaller <> (CatalogueRequestType.class,
                                       getAllCatalogueRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguerequest_21.ObjectFactory._CatalogueRequest_QNAME);
  }

  private static final ClassPathResource CPR_CERTIFICATEOFORIGIN = _getCPR ("UBL-CertificateOfOrigin-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCertificateOfOriginXSDs ()
  {
    return _getAllXSDs (CPR_CERTIFICATEOFORIGIN);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CertificateOfOriginType> certificateOfOrigin ()
  {
    return new UBL21JAXBMarshaller <> (CertificateOfOriginType.class,
                                       getAllCertificateOfOriginXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.certificateoforigin_21.ObjectFactory._CertificateOfOrigin_QNAME);
  }

  private static final ClassPathResource CPR_CONTRACTAWARDNOTICE = _getCPR ("UBL-ContractAwardNotice-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllContractAwardNoticeXSDs ()
  {
    return _getAllXSDs (CPR_CONTRACTAWARDNOTICE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ContractAwardNoticeType> contractAwardNotice ()
  {
    return new UBL21JAXBMarshaller <> (ContractAwardNoticeType.class,
                                       getAllContractAwardNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.contractawardnotice_21.ObjectFactory._ContractAwardNotice_QNAME);
  }

  private static final ClassPathResource CPR_CONTRACTNOTICE = _getCPR ("UBL-ContractNotice-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllContractNoticeXSDs ()
  {
    return _getAllXSDs (CPR_CONTRACTNOTICE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ContractNoticeType> contractNotice ()
  {
    return new UBL21JAXBMarshaller <> (ContractNoticeType.class,
                                       getAllContractNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.contractnotice_21.ObjectFactory._ContractNotice_QNAME);
  }

  private static final ClassPathResource CPR_CREDITNOTE = _getCPR ("UBL-CreditNote-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_CREDITNOTE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new UBL21JAXBMarshaller <> (CreditNoteType.class,
                                       getAllCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_21.ObjectFactory._CreditNote_QNAME);
  }

  private static final ClassPathResource CPR_DEBITNOTE = _getCPR ("UBL-DebitNote-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDebitNoteXSDs ()
  {
    return _getAllXSDs (CPR_DEBITNOTE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new UBL21JAXBMarshaller <> (DebitNoteType.class,
                                       getAllDebitNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.debitnote_21.ObjectFactory._DebitNote_QNAME);
  }

  private static final ClassPathResource CPR_DESPATCHADVICE = _getCPR ("UBL-DespatchAdvice-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDespatchAdviceXSDs ()
  {
    return _getAllXSDs (CPR_DESPATCHADVICE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <DespatchAdviceType> despatchAdvice ()
  {
    return new UBL21JAXBMarshaller <> (DespatchAdviceType.class,
                                       getAllDespatchAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.despatchadvice_21.ObjectFactory._DespatchAdvice_QNAME);
  }

  private static final ClassPathResource CPR_DOCUMENTSTATUS = _getCPR ("UBL-DocumentStatus-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDocumentStatusXSDs ()
  {
    return _getAllXSDs (CPR_DOCUMENTSTATUS);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <DocumentStatusType> documentStatus ()
  {
    return new UBL21JAXBMarshaller <> (DocumentStatusType.class,
                                       getAllDocumentStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.documentstatus_21.ObjectFactory._DocumentStatus_QNAME);
  }

  private static final ClassPathResource CPR_DOCUMENTSTATUSREQUEST = _getCPR ("UBL-DocumentStatusRequest-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDocumentStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_DOCUMENTSTATUSREQUEST);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <DocumentStatusRequestType> documentStatusRequest ()
  {
    return new UBL21JAXBMarshaller <> (DocumentStatusRequestType.class,
                                       getAllDocumentStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.documentstatusrequest_21.ObjectFactory._DocumentStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_EXCEPTIONCRITERIA = _getCPR ("UBL-ExceptionCriteria-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExceptionCriteriaXSDs ()
  {
    return _getAllXSDs (CPR_EXCEPTIONCRITERIA);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ExceptionCriteriaType> exceptionCriteria ()
  {
    return new UBL21JAXBMarshaller <> (ExceptionCriteriaType.class,
                                       getAllExceptionCriteriaXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exceptioncriteria_21.ObjectFactory._ExceptionCriteria_QNAME);
  }

  private static final ClassPathResource CPR_EXCEPTIONNOTIFICATION = _getCPR ("UBL-ExceptionNotification-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExceptionNotificationXSDs ()
  {
    return _getAllXSDs (CPR_EXCEPTIONNOTIFICATION);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ExceptionNotificationType> exceptionNotification ()
  {
    return new UBL21JAXBMarshaller <> (ExceptionNotificationType.class,
                                       getAllExceptionNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exceptionnotification_21.ObjectFactory._ExceptionNotification_QNAME);
  }

  private static final ClassPathResource CPR_FORECAST = _getCPR ("UBL-Forecast-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForecastXSDs ()
  {
    return _getAllXSDs (CPR_FORECAST);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ForecastType> forecast ()
  {
    return new UBL21JAXBMarshaller <> (ForecastType.class,
                                       getAllForecastXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forecast_21.ObjectFactory._Forecast_QNAME);
  }

  private static final ClassPathResource CPR_FORECASTREVISION = _getCPR ("UBL-ForecastRevision-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForecastRevisionXSDs ()
  {
    return _getAllXSDs (CPR_FORECASTREVISION);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ForecastRevisionType> forecastRevision ()
  {
    return new UBL21JAXBMarshaller <> (ForecastRevisionType.class,
                                       getAllForecastRevisionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forecastrevision_21.ObjectFactory._ForecastRevision_QNAME);
  }

  private static final ClassPathResource CPR_FORWARDINGINSTRUCTIONS = _getCPR ("UBL-ForwardingInstructions-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForwardingInstructionsXSDs ()
  {
    return _getAllXSDs (CPR_FORWARDINGINSTRUCTIONS);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ForwardingInstructionsType> forwardingInstructions ()
  {
    return new UBL21JAXBMarshaller <> (ForwardingInstructionsType.class,
                                       getAllForwardingInstructionsXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forwardinginstructions_21.ObjectFactory._ForwardingInstructions_QNAME);
  }

  private static final ClassPathResource CPR_FREIGHTINVOICE = _getCPR ("UBL-FreightInvoice-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllFreightInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_FREIGHTINVOICE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <FreightInvoiceType> freightInvoice ()
  {
    return new UBL21JAXBMarshaller <> (FreightInvoiceType.class,
                                       getAllFreightInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.freightinvoice_21.ObjectFactory._FreightInvoice_QNAME);
  }

  private static final ClassPathResource CPR_FULFILMENTCANCELLATION = _getCPR ("UBL-FulfilmentCancellation-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllFulfilmentCancellationXSDs ()
  {
    return _getAllXSDs (CPR_FULFILMENTCANCELLATION);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return new UBL21JAXBMarshaller <> (FulfilmentCancellationType.class,
                                       getAllFulfilmentCancellationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_21.ObjectFactory._FulfilmentCancellation_QNAME);
  }

  private static final ClassPathResource CPR_GOODSITEMITINERARY = _getCPR ("UBL-GoodsItemItinerary-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGoodsItemItineraryXSDs ()
  {
    return _getAllXSDs (CPR_GOODSITEMITINERARY);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return new UBL21JAXBMarshaller <> (GoodsItemItineraryType.class,
                                       getAllGoodsItemItineraryXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_21.ObjectFactory._GoodsItemItinerary_QNAME);
  }

  private static final ClassPathResource CPR_GUARANTEECERTIFICATE = _getCPR ("UBL-GuaranteeCertificate-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGuaranteeCertificateXSDs ()
  {
    return _getAllXSDs (CPR_GUARANTEECERTIFICATE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return new UBL21JAXBMarshaller <> (GuaranteeCertificateType.class,
                                       getAllGuaranteeCertificateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.guaranteecertificate_21.ObjectFactory._GuaranteeCertificate_QNAME);
  }

  private static final ClassPathResource CPR_INSTRUCTIONFORRETURNS = _getCPR ("UBL-InstructionForReturns-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInstructionForReturnsXSDs ()
  {
    return _getAllXSDs (CPR_INSTRUCTIONFORRETURNS);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <InstructionForReturnsType> instructionForReturns ()
  {
    return new UBL21JAXBMarshaller <> (InstructionForReturnsType.class,
                                       getAllInstructionForReturnsXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.instructionforreturns_21.ObjectFactory._InstructionForReturns_QNAME);
  }

  private static final ClassPathResource CPR_INVENTORYREPORT = _getCPR ("UBL-InventoryReport-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInventoryReportXSDs ()
  {
    return _getAllXSDs (CPR_INVENTORYREPORT);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <InventoryReportType> inventoryReport ()
  {
    return new UBL21JAXBMarshaller <> (InventoryReportType.class,
                                       getAllInventoryReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.inventoryreport_21.ObjectFactory._InventoryReport_QNAME);
  }

  private static final ClassPathResource CPR_INVOICE = _getCPR ("UBL-Invoice-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_INVOICE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <InvoiceType> invoice ()
  {
    return new UBL21JAXBMarshaller <> (InvoiceType.class,
                                       getAllInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.invoice_21.ObjectFactory._Invoice_QNAME);
  }

  private static final ClassPathResource CPR_ITEMINFORMATIONREQUEST = _getCPR ("UBL-ItemInformationRequest-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllItemInformationRequestXSDs ()
  {
    return _getAllXSDs (CPR_ITEMINFORMATIONREQUEST);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ItemInformationRequestType> itemInformationRequest ()
  {
    return new UBL21JAXBMarshaller <> (ItemInformationRequestType.class,
                                       getAllItemInformationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.iteminformationrequest_21.ObjectFactory._ItemInformationRequest_QNAME);
  }

  private static final ClassPathResource CPR_ORDER = _getCPR ("UBL-Order-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderXSDs ()
  {
    return _getAllXSDs (CPR_ORDER);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <OrderType> order ()
  {
    return new UBL21JAXBMarshaller <> (OrderType.class,
                                       getAllOrderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.order_21.ObjectFactory._Order_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCANCELLATION = _getCPR ("UBL-OrderCancellation-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderCancellationXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCANCELLATION);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <OrderCancellationType> orderCancellation ()
  {
    return new UBL21JAXBMarshaller <> (OrderCancellationType.class,
                                       getAllOrderCancellationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.ordercancellation_21.ObjectFactory._OrderCancellation_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCHANGE = _getCPR ("UBL-OrderChange-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderChangeXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCHANGE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <OrderChangeType> orderChange ()
  {
    return new UBL21JAXBMarshaller <> (OrderChangeType.class,
                                       getAllOrderChangeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderchange_21.ObjectFactory._OrderChange_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSE = _getCPR ("UBL-OrderResponse-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <OrderResponseType> orderResponse ()
  {
    return new UBL21JAXBMarshaller <> (OrderResponseType.class,
                                       getAllOrderResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponse_21.ObjectFactory._OrderResponse_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSESIMPLE = _getCPR ("UBL-OrderResponseSimple-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseSimpleXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSESIMPLE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <OrderResponseSimpleType> orderResponseSimple ()
  {
    return new UBL21JAXBMarshaller <> (OrderResponseSimpleType.class,
                                       getAllOrderResponseSimpleXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponsesimple_21.ObjectFactory._OrderResponseSimple_QNAME);
  }

  private static final ClassPathResource CPR_PACKINGLIST = _getCPR ("UBL-PackingList-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPackingListXSDs ()
  {
    return _getAllXSDs (CPR_PACKINGLIST);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <PackingListType> packingList ()
  {
    return new UBL21JAXBMarshaller <> (PackingListType.class,
                                       getAllPackingListXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.packinglist_21.ObjectFactory._PackingList_QNAME);
  }

  private static final ClassPathResource CPR_PRIORINFORMATIONNOTICE = _getCPR ("UBL-PriorInformationNotice-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPriorInformationNoticeXSDs ()
  {
    return _getAllXSDs (CPR_PRIORINFORMATIONNOTICE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <PriorInformationNoticeType> priorInformationNotice ()
  {
    return new UBL21JAXBMarshaller <> (PriorInformationNoticeType.class,
                                       getAllPriorInformationNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.priorinformationnotice_21.ObjectFactory._PriorInformationNotice_QNAME);
  }

  private static final ClassPathResource CPR_PRODUCTACTIVITY = _getCPR ("UBL-ProductActivity-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProductActivityXSDs ()
  {
    return _getAllXSDs (CPR_PRODUCTACTIVITY);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ProductActivityType> productActivity ()
  {
    return new UBL21JAXBMarshaller <> (ProductActivityType.class,
                                       getAllProductActivityXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.productactivity_21.ObjectFactory._ProductActivity_QNAME);
  }

  private static final ClassPathResource CPR_QUOTATION = _getCPR ("UBL-Quotation-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQuotationXSDs ()
  {
    return _getAllXSDs (CPR_QUOTATION);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <QuotationType> quotation ()
  {
    return new UBL21JAXBMarshaller <> (QuotationType.class,
                                       getAllQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.quotation_21.ObjectFactory._Quotation_QNAME);
  }

  private static final ClassPathResource CPR_RECEIPTADVICE = _getCPR ("UBL-ReceiptAdvice-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReceiptAdviceXSDs ()
  {
    return _getAllXSDs (CPR_RECEIPTADVICE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ReceiptAdviceType> receiptAdvice ()
  {
    return new UBL21JAXBMarshaller <> (ReceiptAdviceType.class,
                                       getAllReceiptAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.receiptadvice_21.ObjectFactory._ReceiptAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REMINDER = _getCPR ("UBL-Reminder-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReminderXSDs ()
  {
    return _getAllXSDs (CPR_REMINDER);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <ReminderType> reminder ()
  {
    return new UBL21JAXBMarshaller <> (ReminderType.class,
                                       getAllReminderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.reminder_21.ObjectFactory._Reminder_QNAME);
  }

  private static final ClassPathResource CPR_REMITTANCEADVICE = _getCPR ("UBL-RemittanceAdvice-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRemittanceAdviceXSDs ()
  {
    return _getAllXSDs (CPR_REMITTANCEADVICE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <RemittanceAdviceType> remittanceAdvice ()
  {
    return new UBL21JAXBMarshaller <> (RemittanceAdviceType.class,
                                       getAllRemittanceAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.remittanceadvice_21.ObjectFactory._RemittanceAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REQUESTFORQUOTATION = _getCPR ("UBL-RequestForQuotation-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRequestForQuotationXSDs ()
  {
    return _getAllXSDs (CPR_REQUESTFORQUOTATION);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <RequestForQuotationType> requestForQuotation ()
  {
    return new UBL21JAXBMarshaller <> (RequestForQuotationType.class,
                                       getAllRequestForQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.requestforquotation_21.ObjectFactory._RequestForQuotation_QNAME);
  }

  private static final ClassPathResource CPR_RETAILEVENT = _getCPR ("UBL-RetailEvent-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRetailEventXSDs ()
  {
    return _getAllXSDs (CPR_RETAILEVENT);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <RetailEventType> retailEvent ()
  {
    return new UBL21JAXBMarshaller <> (RetailEventType.class,
                                       getAllRetailEventXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.retailevent_21.ObjectFactory._RetailEvent_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDCREDITNOTE = _getCPR ("UBL-SelfBilledCreditNote-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDCREDITNOTE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return new UBL21JAXBMarshaller <> (SelfBilledCreditNoteType.class,
                                       getAllSelfBilledCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_21.ObjectFactory._SelfBilledCreditNote_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDINVOICE = _getCPR ("UBL-SelfBilledInvoice-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDINVOICE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return new UBL21JAXBMarshaller <> (SelfBilledInvoiceType.class,
                                       getAllSelfBilledInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_21.ObjectFactory._SelfBilledInvoice_QNAME);
  }

  private static final ClassPathResource CPR_STATEMENT = _getCPR ("UBL-Statement-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllStatementXSDs ()
  {
    return _getAllXSDs (CPR_STATEMENT);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <StatementType> statement ()
  {
    return new UBL21JAXBMarshaller <> (StatementType.class,
                                       getAllStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.statement_21.ObjectFactory._Statement_QNAME);
  }

  private static final ClassPathResource CPR_STOCKAVAILABILITYREPORT = _getCPR ("UBL-StockAvailabilityReport-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllStockAvailabilityReportXSDs ()
  {
    return _getAllXSDs (CPR_STOCKAVAILABILITYREPORT);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return new UBL21JAXBMarshaller <> (StockAvailabilityReportType.class,
                                       getAllStockAvailabilityReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_21.ObjectFactory._StockAvailabilityReport_QNAME);
  }

  private static final ClassPathResource CPR_TENDER = _getCPR ("UBL-Tender-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderXSDs ()
  {
    return _getAllXSDs (CPR_TENDER);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TenderType> tender ()
  {
    return new UBL21JAXBMarshaller <> (TenderType.class,
                                       getAllTenderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tender_21.ObjectFactory._Tender_QNAME);
  }

  private static final ClassPathResource CPR_TENDERRECEIPT = _getCPR ("UBL-TenderReceipt-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderReceiptXSDs ()
  {
    return _getAllXSDs (CPR_TENDERRECEIPT);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TenderReceiptType> tenderReceipt ()
  {
    return new UBL21JAXBMarshaller <> (TenderReceiptType.class,
                                       getAllTenderReceiptXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderreceipt_21.ObjectFactory._TenderReceipt_QNAME);
  }

  private static final ClassPathResource CPR_TENDERERQUALIFICATION = _getCPR ("UBL-TendererQualification-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTendererQualificationXSDs ()
  {
    return _getAllXSDs (CPR_TENDERERQUALIFICATION);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TendererQualificationType> tendererQualification ()
  {
    return new UBL21JAXBMarshaller <> (TendererQualificationType.class,
                                       getAllTendererQualificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualification_21.ObjectFactory._TendererQualification_QNAME);
  }

  private static final ClassPathResource CPR_TENDERERQUALIFICATIONRESPONSE = _getCPR ("UBL-TendererQualificationResponse-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTendererQualificationResponseXSDs ()
  {
    return _getAllXSDs (CPR_TENDERERQUALIFICATIONRESPONSE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return new UBL21JAXBMarshaller <> (TendererQualificationResponseType.class,
                                       getAllTendererQualificationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_21.ObjectFactory._TendererQualificationResponse_QNAME);
  }

  private static final ClassPathResource CPR_TRADEITEMLOCATIONPROFILE = _getCPR ("UBL-TradeItemLocationProfile-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTradeItemLocationProfileXSDs ()
  {
    return _getAllXSDs (CPR_TRADEITEMLOCATIONPROFILE);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return new UBL21JAXBMarshaller <> (TradeItemLocationProfileType.class,
                                       getAllTradeItemLocationProfileXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_21.ObjectFactory._TradeItemLocationProfile_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTEXECUTIONPLAN = _getCPR ("UBL-TransportExecutionPlan-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportExecutionPlanXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTEXECUTIONPLAN);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return new UBL21JAXBMarshaller <> (TransportExecutionPlanType.class,
                                       getAllTransportExecutionPlanXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplan_21.ObjectFactory._TransportExecutionPlan_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTEXECUTIONPLANREQUEST = _getCPR ("UBL-TransportExecutionPlanRequest-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportExecutionPlanRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTEXECUTIONPLANREQUEST);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return new UBL21JAXBMarshaller <> (TransportExecutionPlanRequestType.class,
                                       getAllTransportExecutionPlanRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_21.ObjectFactory._TransportExecutionPlanRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTPROGRESSSTATUS = _getCPR ("UBL-TransportProgressStatus-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportProgressStatusXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTPROGRESSSTATUS);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportProgressStatusType> transportProgressStatus ()
  {
    return new UBL21JAXBMarshaller <> (TransportProgressStatusType.class,
                                       getAllTransportProgressStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatus_21.ObjectFactory._TransportProgressStatus_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTPROGRESSSTATUSREQUEST = _getCPR ("UBL-TransportProgressStatusRequest-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportProgressStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTPROGRESSSTATUSREQUEST);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return new UBL21JAXBMarshaller <> (TransportProgressStatusRequestType.class,
                                       getAllTransportProgressStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_21.ObjectFactory._TransportProgressStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTSERVICEDESCRIPTION = _getCPR ("UBL-TransportServiceDescription-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportServiceDescriptionXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTSERVICEDESCRIPTION);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return new UBL21JAXBMarshaller <> (TransportServiceDescriptionType.class,
                                       getAllTransportServiceDescriptionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescription_21.ObjectFactory._TransportServiceDescription_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTSERVICEDESCRIPTIONREQUEST = _getCPR ("UBL-TransportServiceDescriptionRequest-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportServiceDescriptionRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTSERVICEDESCRIPTIONREQUEST);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return new UBL21JAXBMarshaller <> (TransportServiceDescriptionRequestType.class,
                                       getAllTransportServiceDescriptionRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_21.ObjectFactory._TransportServiceDescriptionRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTATIONSTATUS = _getCPR ("UBL-TransportationStatus-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportationStatusXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTATIONSTATUS);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportationStatusType> transportationStatus ()
  {
    return new UBL21JAXBMarshaller <> (TransportationStatusType.class,
                                       getAllTransportationStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatus_21.ObjectFactory._TransportationStatus_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTATIONSTATUSREQUEST = _getCPR ("UBL-TransportationStatusRequest-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportationStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTATIONSTATUSREQUEST);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return new UBL21JAXBMarshaller <> (TransportationStatusRequestType.class,
                                       getAllTransportationStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_21.ObjectFactory._TransportationStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_UNAWARDEDNOTIFICATION = _getCPR ("UBL-UnawardedNotification-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnawardedNotificationXSDs ()
  {
    return _getAllXSDs (CPR_UNAWARDEDNOTIFICATION);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <UnawardedNotificationType> unawardedNotification ()
  {
    return new UBL21JAXBMarshaller <> (UnawardedNotificationType.class,
                                       getAllUnawardedNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unawardednotification_21.ObjectFactory._UnawardedNotification_QNAME);
  }

  private static final ClassPathResource CPR_UTILITYSTATEMENT = _getCPR ("UBL-UtilityStatement-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUtilityStatementXSDs ()
  {
    return _getAllXSDs (CPR_UTILITYSTATEMENT);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <UtilityStatementType> utilityStatement ()
  {
    return new UBL21JAXBMarshaller <> (UtilityStatementType.class,
                                       getAllUtilityStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.utilitystatement_21.ObjectFactory._UtilityStatement_QNAME);
  }

  private static final ClassPathResource CPR_WAYBILL = _getCPR ("UBL-Waybill-2.1.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWaybillXSDs ()
  {
    return _getAllXSDs (CPR_WAYBILL);
  }

  @Nonnull
  public static UBL21JAXBMarshaller <WaybillType> waybill ()
  {
    return new UBL21JAXBMarshaller <> (WaybillType.class,
                                       getAllWaybillXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.waybill_21.ObjectFactory._Waybill_QNAME);
  }
}
