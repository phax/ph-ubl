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
package com.helger.ubl24;

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

import oasis.names.specification.ubl.schema.xsd.applicationresponse_24.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_24.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.awardednotification_24.AwardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.billoflading_24.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.businesscard_24.BusinessCardType;
import oasis.names.specification.ubl.schema.xsd.businessinformation_24.BusinessInformationType;
import oasis.names.specification.ubl.schema.xsd.callfortenders_24.CallForTendersType;
import oasis.names.specification.ubl.schema.xsd.catalogue_24.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_24.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_24.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_24.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_24.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_24.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.commontransportationreport_24.CommonTransportationReportType;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_24.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_24.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.creditnote_24.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_24.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_24.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.digitalagreement_24.DigitalAgreementType;
import oasis.names.specification.ubl.schema.xsd.digitalcapability_24.DigitalCapabilityType;
import oasis.names.specification.ubl.schema.xsd.documentstatus_24.DocumentStatusType;
import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_24.DocumentStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.enquiry_24.EnquiryType;
import oasis.names.specification.ubl.schema.xsd.enquiryresponse_24.EnquiryResponseType;
import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_24.ExceptionCriteriaType;
import oasis.names.specification.ubl.schema.xsd.exceptionnotification_24.ExceptionNotificationType;
import oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_24.ExportCustomsDeclarationType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_24.ExpressionOfInterestRequestType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_24.ExpressionOfInterestResponseType;
import oasis.names.specification.ubl.schema.xsd.forecast_24.ForecastType;
import oasis.names.specification.ubl.schema.xsd.forecastrevision_24.ForecastRevisionType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_24.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_24.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_24.FulfilmentCancellationType;
import oasis.names.specification.ubl.schema.xsd.goodscertificate_24.GoodsCertificateType;
import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_24.GoodsItemItineraryType;
import oasis.names.specification.ubl.schema.xsd.goodsitempassport_24.GoodsItemPassportType;
import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_24.GuaranteeCertificateType;
import oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_24.ImportCustomsDeclarationType;
import oasis.names.specification.ubl.schema.xsd.instructionforreturns_24.InstructionForReturnsType;
import oasis.names.specification.ubl.schema.xsd.inventoryreport_24.InventoryReportType;
import oasis.names.specification.ubl.schema.xsd.invoice_24.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_24.ItemInformationRequestType;
import oasis.names.specification.ubl.schema.xsd.manifest_24.ManifestType;
import oasis.names.specification.ubl.schema.xsd.order_24.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_24.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_24.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_24.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_24.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_24.PackingListType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_24.PriorInformationNoticeType;
import oasis.names.specification.ubl.schema.xsd.productactivity_24.ProductActivityType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportation_24.ProofOfReexportationType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_24.ProofOfReexportationReminderType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_24.ProofOfReexportationRequestType;
import oasis.names.specification.ubl.schema.xsd.purchasereceipt_24.PurchaseReceiptType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_24.QualificationApplicationRequestType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_24.QualificationApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.quotation_24.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_24.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_24.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_24.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_24.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.retailevent_24.RetailEventType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_24.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_24.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_24.StatementType;
import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_24.StockAvailabilityReportType;
import oasis.names.specification.ubl.schema.xsd.tender_24.TenderType;
import oasis.names.specification.ubl.schema.xsd.tendercontract_24.TenderContractType;
import oasis.names.specification.ubl.schema.xsd.tendererqualification_24.TendererQualificationType;
import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_24.TendererQualificationResponseType;
import oasis.names.specification.ubl.schema.xsd.tenderreceipt_24.TenderReceiptType;
import oasis.names.specification.ubl.schema.xsd.tenderstatus_24.TenderStatusType;
import oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_24.TenderStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_24.TenderWithdrawalType;
import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_24.TradeItemLocationProfileType;
import oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_24.TransitCustomsDeclarationType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_24.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_24.TransportationStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_24.TransportExecutionPlanType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_24.TransportExecutionPlanRequestType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_24.TransportProgressStatusType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_24.TransportProgressStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescription_24.TransportServiceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_24.TransportServiceDescriptionRequestType;
import oasis.names.specification.ubl.schema.xsd.unawardednotification_24.UnawardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_24.UnsubscribeFromProcedureRequestType;
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_24.UnsubscribeFromProcedureResponseType;
import oasis.names.specification.ubl.schema.xsd.utilitystatement_24.UtilityStatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_24.WaybillType;
import oasis.names.specification.ubl.schema.xsd.weightstatement_24.WeightStatementType;

/**
 * The class provides all the UBL 2.4 marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class UBL24Marshaller
{
  public static class UBL24JAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    private static final ICommonsList <ClassPathResource> BASE_XSDS = new CommonsArrayList <> (CCCTS.getXSDResource (),
                                                                                               CXMLDSig.getXSDResource (),
                                                                                               CXAdES132.getXSDResource (),
                                                                                               CXAdES141.getXSDResource (),
                                                                                               CUBL24.XSD_UNQUALIFIED_DATA_TYPES,
                                                                                               CUBL24.XSD_QUALIFIED_DATA_TYPES,
                                                                                               CUBL24.XSD_SIGNATURE_BASIC_COMPONENTS,
                                                                                               CUBL24.XSD_COMMON_BASIC_COMPONENTS,
                                                                                               CUBL24.XSD_SIGNATURE_AGGREGATE_COMPONENTS,
                                                                                               CUBL24.XSD_COMMON_SIGNATURE_COMPONENTS,
                                                                                               CUBL24.XSD_COMMON_EXTENSION_COMPONENTS,
                                                                                               CUBL24.XSD_COMMON_AGGREGATE_COMPONENTS);

    @Nonnull
    public static ICommonsList <ClassPathResource> getAllXSDs (@Nonnull final ClassPathResource aXSD)
    {
      final ICommonsList <ClassPathResource> ret = BASE_XSDS.getClone ();
      ret.add (aXSD);
      return ret;
    }

    public UBL24JAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nonnull final ClassPathResource aXSD,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, getAllXSDs (aXSD), createSimpleJAXBElement (aRootElementQName, aType));

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBL24NamespaceContext.getInstance ().getClone ();
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

  private UBL24Marshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CUBL24.SCHEMA_DIRECTORY + sXSDPath, CUBL24.getCL ());
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new UBL24JAXBMarshaller <> (ApplicationResponseType.class,
                                       _getCPR ("UBL-ApplicationResponse-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.applicationresponse_24.ObjectFactory._ApplicationResponse_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new UBL24JAXBMarshaller <> (AttachedDocumentType.class,
                                       _getCPR ("UBL-AttachedDocument-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.attacheddocument_24.ObjectFactory._AttachedDocument_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <AwardedNotificationType> awardedNotification ()
  {
    return new UBL24JAXBMarshaller <> (AwardedNotificationType.class,
                                       _getCPR ("UBL-AwardedNotification-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.awardednotification_24.ObjectFactory._AwardedNotification_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <BillOfLadingType> billOfLading ()
  {
    return new UBL24JAXBMarshaller <> (BillOfLadingType.class,
                                       _getCPR ("UBL-BillOfLading-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.billoflading_24.ObjectFactory._BillOfLading_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <BusinessCardType> businessCard ()
  {
    return new UBL24JAXBMarshaller <> (BusinessCardType.class,
                                       _getCPR ("UBL-BusinessCard-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.businesscard_24.ObjectFactory._BusinessCard_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <BusinessInformationType> businessInformation ()
  {
    return new UBL24JAXBMarshaller <> (BusinessInformationType.class,
                                       _getCPR ("UBL-BusinessInformation-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.businessinformation_24.ObjectFactory._BusinessInformation_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CallForTendersType> callForTenders ()
  {
    return new UBL24JAXBMarshaller <> (CallForTendersType.class,
                                       _getCPR ("UBL-CallForTenders-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.callfortenders_24.ObjectFactory._CallForTenders_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CatalogueType> catalogue ()
  {
    return new UBL24JAXBMarshaller <> (CatalogueType.class,
                                       _getCPR ("UBL-Catalogue-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.catalogue_24.ObjectFactory._Catalogue_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CatalogueDeletionType> catalogueDeletion ()
  {
    return new UBL24JAXBMarshaller <> (CatalogueDeletionType.class,
                                       _getCPR ("UBL-CatalogueDeletion-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguedeletion_24.ObjectFactory._CatalogueDeletion_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return new UBL24JAXBMarshaller <> (CatalogueItemSpecificationUpdateType.class,
                                       _getCPR ("UBL-CatalogueItemSpecificationUpdate-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_24.ObjectFactory._CatalogueItemSpecificationUpdate_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return new UBL24JAXBMarshaller <> (CataloguePricingUpdateType.class,
                                       _getCPR ("UBL-CataloguePricingUpdate-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_24.ObjectFactory._CataloguePricingUpdate_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CatalogueRequestType> catalogueRequest ()
  {
    return new UBL24JAXBMarshaller <> (CatalogueRequestType.class,
                                       _getCPR ("UBL-CatalogueRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguerequest_24.ObjectFactory._CatalogueRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CertificateOfOriginType> certificateOfOrigin ()
  {
    return new UBL24JAXBMarshaller <> (CertificateOfOriginType.class,
                                       _getCPR ("UBL-CertificateOfOrigin-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.certificateoforigin_24.ObjectFactory._CertificateOfOrigin_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CommonTransportationReportType> commonTransportationReport ()
  {
    return new UBL24JAXBMarshaller <> (CommonTransportationReportType.class,
                                       _getCPR ("UBL-CommonTransportationReport-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.commontransportationreport_24.ObjectFactory._CommonTransportationReport_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ContractAwardNoticeType> contractAwardNotice ()
  {
    return new UBL24JAXBMarshaller <> (ContractAwardNoticeType.class,
                                       _getCPR ("UBL-ContractAwardNotice-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.contractawardnotice_24.ObjectFactory._ContractAwardNotice_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ContractNoticeType> contractNotice ()
  {
    return new UBL24JAXBMarshaller <> (ContractNoticeType.class,
                                       _getCPR ("UBL-ContractNotice-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.contractnotice_24.ObjectFactory._ContractNotice_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new UBL24JAXBMarshaller <> (CreditNoteType.class,
                                       _getCPR ("UBL-CreditNote-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_24.ObjectFactory._CreditNote_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new UBL24JAXBMarshaller <> (DebitNoteType.class,
                                       _getCPR ("UBL-DebitNote-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.debitnote_24.ObjectFactory._DebitNote_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DespatchAdviceType> despatchAdvice ()
  {
    return new UBL24JAXBMarshaller <> (DespatchAdviceType.class,
                                       _getCPR ("UBL-DespatchAdvice-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.despatchadvice_24.ObjectFactory._DespatchAdvice_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DigitalAgreementType> digitalAgreement ()
  {
    return new UBL24JAXBMarshaller <> (DigitalAgreementType.class,
                                       _getCPR ("UBL-DigitalAgreement-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.digitalagreement_24.ObjectFactory._DigitalAgreement_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DigitalCapabilityType> digitalCapability ()
  {
    return new UBL24JAXBMarshaller <> (DigitalCapabilityType.class,
                                       _getCPR ("UBL-DigitalCapability-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.digitalcapability_24.ObjectFactory._DigitalCapability_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DocumentStatusType> documentStatus ()
  {
    return new UBL24JAXBMarshaller <> (DocumentStatusType.class,
                                       _getCPR ("UBL-DocumentStatus-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.documentstatus_24.ObjectFactory._DocumentStatus_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DocumentStatusRequestType> documentStatusRequest ()
  {
    return new UBL24JAXBMarshaller <> (DocumentStatusRequestType.class,
                                       _getCPR ("UBL-DocumentStatusRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.documentstatusrequest_24.ObjectFactory._DocumentStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <EnquiryType> enquiry ()
  {
    return new UBL24JAXBMarshaller <> (EnquiryType.class,
                                       _getCPR ("UBL-Enquiry-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.enquiry_24.ObjectFactory._Enquiry_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <EnquiryResponseType> enquiryResponse ()
  {
    return new UBL24JAXBMarshaller <> (EnquiryResponseType.class,
                                       _getCPR ("UBL-EnquiryResponse-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.enquiryresponse_24.ObjectFactory._EnquiryResponse_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ExceptionCriteriaType> exceptionCriteria ()
  {
    return new UBL24JAXBMarshaller <> (ExceptionCriteriaType.class,
                                       _getCPR ("UBL-ExceptionCriteria-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.exceptioncriteria_24.ObjectFactory._ExceptionCriteria_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ExceptionNotificationType> exceptionNotification ()
  {
    return new UBL24JAXBMarshaller <> (ExceptionNotificationType.class,
                                       _getCPR ("UBL-ExceptionNotification-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.exceptionnotification_24.ObjectFactory._ExceptionNotification_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ExportCustomsDeclarationType> exportCustomsDeclaration ()
  {
    return new UBL24JAXBMarshaller <> (ExportCustomsDeclarationType.class,
                                       _getCPR ("UBL-ExportCustomsDeclaration-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_24.ObjectFactory._ExportCustomsDeclaration_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ExpressionOfInterestRequestType> expressionOfInterestRequest ()
  {
    return new UBL24JAXBMarshaller <> (ExpressionOfInterestRequestType.class,
                                       _getCPR ("UBL-ExpressionOfInterestRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_24.ObjectFactory._ExpressionOfInterestRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ExpressionOfInterestResponseType> expressionOfInterestResponse ()
  {
    return new UBL24JAXBMarshaller <> (ExpressionOfInterestResponseType.class,
                                       _getCPR ("UBL-ExpressionOfInterestResponse-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_24.ObjectFactory._ExpressionOfInterestResponse_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ForecastType> forecast ()
  {
    return new UBL24JAXBMarshaller <> (ForecastType.class,
                                       _getCPR ("UBL-Forecast-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forecast_24.ObjectFactory._Forecast_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ForecastRevisionType> forecastRevision ()
  {
    return new UBL24JAXBMarshaller <> (ForecastRevisionType.class,
                                       _getCPR ("UBL-ForecastRevision-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forecastrevision_24.ObjectFactory._ForecastRevision_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ForwardingInstructionsType> forwardingInstructions ()
  {
    return new UBL24JAXBMarshaller <> (ForwardingInstructionsType.class,
                                       _getCPR ("UBL-ForwardingInstructions-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forwardinginstructions_24.ObjectFactory._ForwardingInstructions_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <FreightInvoiceType> freightInvoice ()
  {
    return new UBL24JAXBMarshaller <> (FreightInvoiceType.class,
                                       _getCPR ("UBL-FreightInvoice-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.freightinvoice_24.ObjectFactory._FreightInvoice_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return new UBL24JAXBMarshaller <> (FulfilmentCancellationType.class,
                                       _getCPR ("UBL-FulfilmentCancellation-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_24.ObjectFactory._FulfilmentCancellation_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <GoodsCertificateType> goodsCertificate ()
  {
    return new UBL24JAXBMarshaller <> (GoodsCertificateType.class,
                                       _getCPR ("UBL-GoodsCertificate-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.goodscertificate_24.ObjectFactory._GoodsCertificate_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return new UBL24JAXBMarshaller <> (GoodsItemItineraryType.class,
                                       _getCPR ("UBL-GoodsItemItinerary-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_24.ObjectFactory._GoodsItemItinerary_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <GoodsItemPassportType> goodsItemPassport ()
  {
    return new UBL24JAXBMarshaller <> (GoodsItemPassportType.class,
                                       _getCPR ("UBL-GoodsItemPassport-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.goodsitempassport_24.ObjectFactory._GoodsItemPassport_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return new UBL24JAXBMarshaller <> (GuaranteeCertificateType.class,
                                       _getCPR ("UBL-GuaranteeCertificate-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.guaranteecertificate_24.ObjectFactory._GuaranteeCertificate_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ImportCustomsDeclarationType> importCustomsDeclaration ()
  {
    return new UBL24JAXBMarshaller <> (ImportCustomsDeclarationType.class,
                                       _getCPR ("UBL-ImportCustomsDeclaration-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_24.ObjectFactory._ImportCustomsDeclaration_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <InstructionForReturnsType> instructionForReturns ()
  {
    return new UBL24JAXBMarshaller <> (InstructionForReturnsType.class,
                                       _getCPR ("UBL-InstructionForReturns-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.instructionforreturns_24.ObjectFactory._InstructionForReturns_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <InventoryReportType> inventoryReport ()
  {
    return new UBL24JAXBMarshaller <> (InventoryReportType.class,
                                       _getCPR ("UBL-InventoryReport-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.inventoryreport_24.ObjectFactory._InventoryReport_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <InvoiceType> invoice ()
  {
    return new UBL24JAXBMarshaller <> (InvoiceType.class,
                                       _getCPR ("UBL-Invoice-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.invoice_24.ObjectFactory._Invoice_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ItemInformationRequestType> itemInformationRequest ()
  {
    return new UBL24JAXBMarshaller <> (ItemInformationRequestType.class,
                                       _getCPR ("UBL-ItemInformationRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.iteminformationrequest_24.ObjectFactory._ItemInformationRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ManifestType> manifest ()
  {
    return new UBL24JAXBMarshaller <> (ManifestType.class,
                                       _getCPR ("UBL-Manifest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.manifest_24.ObjectFactory._Manifest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <OrderType> order ()
  {
    return new UBL24JAXBMarshaller <> (OrderType.class,
                                       _getCPR ("UBL-Order-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.order_24.ObjectFactory._Order_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <OrderCancellationType> orderCancellation ()
  {
    return new UBL24JAXBMarshaller <> (OrderCancellationType.class,
                                       _getCPR ("UBL-OrderCancellation-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.ordercancellation_24.ObjectFactory._OrderCancellation_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <OrderChangeType> orderChange ()
  {
    return new UBL24JAXBMarshaller <> (OrderChangeType.class,
                                       _getCPR ("UBL-OrderChange-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderchange_24.ObjectFactory._OrderChange_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <OrderResponseType> orderResponse ()
  {
    return new UBL24JAXBMarshaller <> (OrderResponseType.class,
                                       _getCPR ("UBL-OrderResponse-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderresponse_24.ObjectFactory._OrderResponse_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <OrderResponseSimpleType> orderResponseSimple ()
  {
    return new UBL24JAXBMarshaller <> (OrderResponseSimpleType.class,
                                       _getCPR ("UBL-OrderResponseSimple-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderresponsesimple_24.ObjectFactory._OrderResponseSimple_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <PackingListType> packingList ()
  {
    return new UBL24JAXBMarshaller <> (PackingListType.class,
                                       _getCPR ("UBL-PackingList-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.packinglist_24.ObjectFactory._PackingList_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <PriorInformationNoticeType> priorInformationNotice ()
  {
    return new UBL24JAXBMarshaller <> (PriorInformationNoticeType.class,
                                       _getCPR ("UBL-PriorInformationNotice-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.priorinformationnotice_24.ObjectFactory._PriorInformationNotice_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ProductActivityType> productActivity ()
  {
    return new UBL24JAXBMarshaller <> (ProductActivityType.class,
                                       _getCPR ("UBL-ProductActivity-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.productactivity_24.ObjectFactory._ProductActivity_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ProofOfReexportationType> proofOfReexportation ()
  {
    return new UBL24JAXBMarshaller <> (ProofOfReexportationType.class,
                                       _getCPR ("UBL-ProofOfReexportation-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportation_24.ObjectFactory._ProofOfReexportation_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ProofOfReexportationReminderType> proofOfReexportationReminder ()
  {
    return new UBL24JAXBMarshaller <> (ProofOfReexportationReminderType.class,
                                       _getCPR ("UBL-ProofOfReexportationReminder-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_24.ObjectFactory._ProofOfReexportationReminder_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ProofOfReexportationRequestType> proofOfReexportationRequest ()
  {
    return new UBL24JAXBMarshaller <> (ProofOfReexportationRequestType.class,
                                       _getCPR ("UBL-ProofOfReexportationRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_24.ObjectFactory._ProofOfReexportationRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <PurchaseReceiptType> purchaseReceipt ()
  {
    return new UBL24JAXBMarshaller <> (PurchaseReceiptType.class,
                                       _getCPR ("UBL-PurchaseReceipt-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.purchasereceipt_24.ObjectFactory._PurchaseReceipt_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <QualificationApplicationRequestType> qualificationApplicationRequest ()
  {
    return new UBL24JAXBMarshaller <> (QualificationApplicationRequestType.class,
                                       _getCPR ("UBL-QualificationApplicationRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_24.ObjectFactory._QualificationApplicationRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <QualificationApplicationResponseType> qualificationApplicationResponse ()
  {
    return new UBL24JAXBMarshaller <> (QualificationApplicationResponseType.class,
                                       _getCPR ("UBL-QualificationApplicationResponse-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_24.ObjectFactory._QualificationApplicationResponse_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <QuotationType> quotation ()
  {
    return new UBL24JAXBMarshaller <> (QuotationType.class,
                                       _getCPR ("UBL-Quotation-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.quotation_24.ObjectFactory._Quotation_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ReceiptAdviceType> receiptAdvice ()
  {
    return new UBL24JAXBMarshaller <> (ReceiptAdviceType.class,
                                       _getCPR ("UBL-ReceiptAdvice-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.receiptadvice_24.ObjectFactory._ReceiptAdvice_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ReminderType> reminder ()
  {
    return new UBL24JAXBMarshaller <> (ReminderType.class,
                                       _getCPR ("UBL-Reminder-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.reminder_24.ObjectFactory._Reminder_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <RemittanceAdviceType> remittanceAdvice ()
  {
    return new UBL24JAXBMarshaller <> (RemittanceAdviceType.class,
                                       _getCPR ("UBL-RemittanceAdvice-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.remittanceadvice_24.ObjectFactory._RemittanceAdvice_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <RequestForQuotationType> requestForQuotation ()
  {
    return new UBL24JAXBMarshaller <> (RequestForQuotationType.class,
                                       _getCPR ("UBL-RequestForQuotation-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.requestforquotation_24.ObjectFactory._RequestForQuotation_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <RetailEventType> retailEvent ()
  {
    return new UBL24JAXBMarshaller <> (RetailEventType.class,
                                       _getCPR ("UBL-RetailEvent-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.retailevent_24.ObjectFactory._RetailEvent_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return new UBL24JAXBMarshaller <> (SelfBilledCreditNoteType.class,
                                       _getCPR ("UBL-SelfBilledCreditNote-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_24.ObjectFactory._SelfBilledCreditNote_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return new UBL24JAXBMarshaller <> (SelfBilledInvoiceType.class,
                                       _getCPR ("UBL-SelfBilledInvoice-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_24.ObjectFactory._SelfBilledInvoice_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <StatementType> statement ()
  {
    return new UBL24JAXBMarshaller <> (StatementType.class,
                                       _getCPR ("UBL-Statement-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.statement_24.ObjectFactory._Statement_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return new UBL24JAXBMarshaller <> (StockAvailabilityReportType.class,
                                       _getCPR ("UBL-StockAvailabilityReport-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_24.ObjectFactory._StockAvailabilityReport_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderType> tender ()
  {
    return new UBL24JAXBMarshaller <> (TenderType.class,
                                       _getCPR ("UBL-Tender-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tender_24.ObjectFactory._Tender_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderContractType> tenderContract ()
  {
    return new UBL24JAXBMarshaller <> (TenderContractType.class,
                                       _getCPR ("UBL-TenderContract-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tendercontract_24.ObjectFactory._TenderContract_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TendererQualificationType> tendererQualification ()
  {
    return new UBL24JAXBMarshaller <> (TendererQualificationType.class,
                                       _getCPR ("UBL-TendererQualification-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualification_24.ObjectFactory._TendererQualification_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return new UBL24JAXBMarshaller <> (TendererQualificationResponseType.class,
                                       _getCPR ("UBL-TendererQualificationResponse-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_24.ObjectFactory._TendererQualificationResponse_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderReceiptType> tenderReceipt ()
  {
    return new UBL24JAXBMarshaller <> (TenderReceiptType.class,
                                       _getCPR ("UBL-TenderReceipt-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderreceipt_24.ObjectFactory._TenderReceipt_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderStatusType> tenderStatus ()
  {
    return new UBL24JAXBMarshaller <> (TenderStatusType.class,
                                       _getCPR ("UBL-TenderStatus-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatus_24.ObjectFactory._TenderStatus_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderStatusRequestType> tenderStatusRequest ()
  {
    return new UBL24JAXBMarshaller <> (TenderStatusRequestType.class,
                                       _getCPR ("UBL-TenderStatusRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_24.ObjectFactory._TenderStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderWithdrawalType> tenderWithdrawal ()
  {
    return new UBL24JAXBMarshaller <> (TenderWithdrawalType.class,
                                       _getCPR ("UBL-TenderWithdrawal-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_24.ObjectFactory._TenderWithdrawal_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return new UBL24JAXBMarshaller <> (TradeItemLocationProfileType.class,
                                       _getCPR ("UBL-TradeItemLocationProfile-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_24.ObjectFactory._TradeItemLocationProfile_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransitCustomsDeclarationType> transitCustomsDeclaration ()
  {
    return new UBL24JAXBMarshaller <> (TransitCustomsDeclarationType.class,
                                       _getCPR ("UBL-TransitCustomsDeclaration-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_24.ObjectFactory._TransitCustomsDeclaration_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportationStatusType> transportationStatus ()
  {
    return new UBL24JAXBMarshaller <> (TransportationStatusType.class,
                                       _getCPR ("UBL-TransportationStatus-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatus_24.ObjectFactory._TransportationStatus_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return new UBL24JAXBMarshaller <> (TransportationStatusRequestType.class,
                                       _getCPR ("UBL-TransportationStatusRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_24.ObjectFactory._TransportationStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return new UBL24JAXBMarshaller <> (TransportExecutionPlanType.class,
                                       _getCPR ("UBL-TransportExecutionPlan-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplan_24.ObjectFactory._TransportExecutionPlan_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return new UBL24JAXBMarshaller <> (TransportExecutionPlanRequestType.class,
                                       _getCPR ("UBL-TransportExecutionPlanRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_24.ObjectFactory._TransportExecutionPlanRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportProgressStatusType> transportProgressStatus ()
  {
    return new UBL24JAXBMarshaller <> (TransportProgressStatusType.class,
                                       _getCPR ("UBL-TransportProgressStatus-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatus_24.ObjectFactory._TransportProgressStatus_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return new UBL24JAXBMarshaller <> (TransportProgressStatusRequestType.class,
                                       _getCPR ("UBL-TransportProgressStatusRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_24.ObjectFactory._TransportProgressStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return new UBL24JAXBMarshaller <> (TransportServiceDescriptionType.class,
                                       _getCPR ("UBL-TransportServiceDescription-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescription_24.ObjectFactory._TransportServiceDescription_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return new UBL24JAXBMarshaller <> (TransportServiceDescriptionRequestType.class,
                                       _getCPR ("UBL-TransportServiceDescriptionRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_24.ObjectFactory._TransportServiceDescriptionRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <UnawardedNotificationType> unawardedNotification ()
  {
    return new UBL24JAXBMarshaller <> (UnawardedNotificationType.class,
                                       _getCPR ("UBL-UnawardedNotification-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.unawardednotification_24.ObjectFactory._UnawardedNotification_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest ()
  {
    return new UBL24JAXBMarshaller <> (UnsubscribeFromProcedureRequestType.class,
                                       _getCPR ("UBL-UnsubscribeFromProcedureRequest-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_24.ObjectFactory._UnsubscribeFromProcedureRequest_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse ()
  {
    return new UBL24JAXBMarshaller <> (UnsubscribeFromProcedureResponseType.class,
                                       _getCPR ("UBL-UnsubscribeFromProcedureResponse-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_24.ObjectFactory._UnsubscribeFromProcedureResponse_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <UtilityStatementType> utilityStatement ()
  {
    return new UBL24JAXBMarshaller <> (UtilityStatementType.class,
                                       _getCPR ("UBL-UtilityStatement-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.utilitystatement_24.ObjectFactory._UtilityStatement_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <WaybillType> waybill ()
  {
    return new UBL24JAXBMarshaller <> (WaybillType.class,
                                       _getCPR ("UBL-Waybill-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.waybill_24.ObjectFactory._Waybill_QNAME);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <WeightStatementType> weightStatement ()
  {
    return new UBL24JAXBMarshaller <> (WeightStatementType.class,
                                       _getCPR ("UBL-WeightStatement-2.4.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.weightstatement_24.ObjectFactory._WeightStatement_QNAME);
  }
}
