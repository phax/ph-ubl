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
package com.helger.ubl24;

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
    private final QName m_aRootElementQName;

    public UBL24JAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nonnull @Nonempty final ICommonsList <ClassPathResource> aXSDs,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, aXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      m_aRootElementQName = aRootElementQName;

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBL24NamespaceContext.getInstance ().getClone ();
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
                                                                                             CUBL24.XSD_UNQUALIFIED_DATA_TYPES,
                                                                                             CUBL24.XSD_QUALIFIED_DATA_TYPES,
                                                                                             CUBL24.XSD_SIGNATURE_BASIC_COMPONENTS,
                                                                                             CUBL24.XSD_COMMON_BASIC_COMPONENTS,
                                                                                             CUBL24.XSD_SIGNATURE_AGGREGATE_COMPONENTS,
                                                                                             CUBL24.XSD_COMMON_SIGNATURE_COMPONENTS,
                                                                                             CUBL24.XSD_COMMON_EXTENSION_COMPONENTS,
                                                                                             CUBL24.XSD_COMMON_AGGREGATE_COMPONENTS);

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBaseXSDs ()
  {
    return BASE_XSDS.getClone ();
  }

  @Nonnull
  @ReturnsMutableCopy
  private static ICommonsList <ClassPathResource> _getAllXSDs (@Nonnull final ClassPathResource aXSD)
  {
    final ICommonsList <ClassPathResource> ret = BASE_XSDS.getClone ();
    ret.add (aXSD);
    return ret;
  }

  private UBL24Marshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CUBL24.SCHEMA_DIRECTORY + sXSDPath, CUBL24.getCL ());
  }

  // Automatically created from here on

  private static final ClassPathResource CPR_APPLICATIONRESPONSE = _getCPR ("UBL-ApplicationResponse-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllApplicationResponseXSDs ()
  {
    return _getAllXSDs (CPR_APPLICATIONRESPONSE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new UBL24JAXBMarshaller <> (ApplicationResponseType.class,
                                       getAllApplicationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.applicationresponse_24.ObjectFactory._ApplicationResponse_QNAME);
  }

  private static final ClassPathResource CPR_ATTACHEDDOCUMENT = _getCPR ("UBL-AttachedDocument-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllAttachedDocumentXSDs ()
  {
    return _getAllXSDs (CPR_ATTACHEDDOCUMENT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new UBL24JAXBMarshaller <> (AttachedDocumentType.class,
                                       getAllAttachedDocumentXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.attacheddocument_24.ObjectFactory._AttachedDocument_QNAME);
  }

  private static final ClassPathResource CPR_AWARDEDNOTIFICATION = _getCPR ("UBL-AwardedNotification-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllAwardedNotificationXSDs ()
  {
    return _getAllXSDs (CPR_AWARDEDNOTIFICATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <AwardedNotificationType> awardedNotification ()
  {
    return new UBL24JAXBMarshaller <> (AwardedNotificationType.class,
                                       getAllAwardedNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.awardednotification_24.ObjectFactory._AwardedNotification_QNAME);
  }

  private static final ClassPathResource CPR_BILLOFLADING = _getCPR ("UBL-BillOfLading-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBillOfLadingXSDs ()
  {
    return _getAllXSDs (CPR_BILLOFLADING);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <BillOfLadingType> billOfLading ()
  {
    return new UBL24JAXBMarshaller <> (BillOfLadingType.class,
                                       getAllBillOfLadingXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.billoflading_24.ObjectFactory._BillOfLading_QNAME);
  }

  private static final ClassPathResource CPR_BUSINESSCARD = _getCPR ("UBL-BusinessCard-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBusinessCardXSDs ()
  {
    return _getAllXSDs (CPR_BUSINESSCARD);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <BusinessCardType> businessCard ()
  {
    return new UBL24JAXBMarshaller <> (BusinessCardType.class,
                                       getAllBusinessCardXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.businesscard_24.ObjectFactory._BusinessCard_QNAME);
  }

  private static final ClassPathResource CPR_BUSINESSINFORMATION = _getCPR ("UBL-BusinessInformation-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBusinessInformationXSDs ()
  {
    return _getAllXSDs (CPR_BUSINESSINFORMATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <BusinessInformationType> businessInformation ()
  {
    return new UBL24JAXBMarshaller <> (BusinessInformationType.class,
                                       getAllBusinessInformationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.businessinformation_24.ObjectFactory._BusinessInformation_QNAME);
  }

  private static final ClassPathResource CPR_CALLFORTENDERS = _getCPR ("UBL-CallForTenders-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCallForTendersXSDs ()
  {
    return _getAllXSDs (CPR_CALLFORTENDERS);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CallForTendersType> callForTenders ()
  {
    return new UBL24JAXBMarshaller <> (CallForTendersType.class,
                                       getAllCallForTendersXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.callfortenders_24.ObjectFactory._CallForTenders_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUE = _getCPR ("UBL-Catalogue-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CatalogueType> catalogue ()
  {
    return new UBL24JAXBMarshaller <> (CatalogueType.class,
                                       getAllCatalogueXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogue_24.ObjectFactory._Catalogue_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEDELETION = _getCPR ("UBL-CatalogueDeletion-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueDeletionXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEDELETION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CatalogueDeletionType> catalogueDeletion ()
  {
    return new UBL24JAXBMarshaller <> (CatalogueDeletionType.class,
                                       getAllCatalogueDeletionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguedeletion_24.ObjectFactory._CatalogueDeletion_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEITEMSPECIFICATIONUPDATE = _getCPR ("UBL-CatalogueItemSpecificationUpdate-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueItemSpecificationUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEITEMSPECIFICATIONUPDATE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return new UBL24JAXBMarshaller <> (CatalogueItemSpecificationUpdateType.class,
                                       getAllCatalogueItemSpecificationUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_24.ObjectFactory._CatalogueItemSpecificationUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEPRICINGUPDATE = _getCPR ("UBL-CataloguePricingUpdate-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCataloguePricingUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEPRICINGUPDATE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return new UBL24JAXBMarshaller <> (CataloguePricingUpdateType.class,
                                       getAllCataloguePricingUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_24.ObjectFactory._CataloguePricingUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEREQUEST = _getCPR ("UBL-CatalogueRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueRequestXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CatalogueRequestType> catalogueRequest ()
  {
    return new UBL24JAXBMarshaller <> (CatalogueRequestType.class,
                                       getAllCatalogueRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguerequest_24.ObjectFactory._CatalogueRequest_QNAME);
  }

  private static final ClassPathResource CPR_CERTIFICATEOFORIGIN = _getCPR ("UBL-CertificateOfOrigin-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCertificateOfOriginXSDs ()
  {
    return _getAllXSDs (CPR_CERTIFICATEOFORIGIN);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CertificateOfOriginType> certificateOfOrigin ()
  {
    return new UBL24JAXBMarshaller <> (CertificateOfOriginType.class,
                                       getAllCertificateOfOriginXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.certificateoforigin_24.ObjectFactory._CertificateOfOrigin_QNAME);
  }

  private static final ClassPathResource CPR_COMMONTRANSPORTATIONREPORT = _getCPR ("UBL-CommonTransportationReport-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCommonTransportationReportXSDs ()
  {
    return _getAllXSDs (CPR_COMMONTRANSPORTATIONREPORT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CommonTransportationReportType> commonTransportationReport ()
  {
    return new UBL24JAXBMarshaller <> (CommonTransportationReportType.class,
                                       getAllCommonTransportationReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.commontransportationreport_24.ObjectFactory._CommonTransportationReport_QNAME);
  }

  private static final ClassPathResource CPR_CONTRACTAWARDNOTICE = _getCPR ("UBL-ContractAwardNotice-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllContractAwardNoticeXSDs ()
  {
    return _getAllXSDs (CPR_CONTRACTAWARDNOTICE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ContractAwardNoticeType> contractAwardNotice ()
  {
    return new UBL24JAXBMarshaller <> (ContractAwardNoticeType.class,
                                       getAllContractAwardNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.contractawardnotice_24.ObjectFactory._ContractAwardNotice_QNAME);
  }

  private static final ClassPathResource CPR_CONTRACTNOTICE = _getCPR ("UBL-ContractNotice-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllContractNoticeXSDs ()
  {
    return _getAllXSDs (CPR_CONTRACTNOTICE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ContractNoticeType> contractNotice ()
  {
    return new UBL24JAXBMarshaller <> (ContractNoticeType.class,
                                       getAllContractNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.contractnotice_24.ObjectFactory._ContractNotice_QNAME);
  }

  private static final ClassPathResource CPR_CREDITNOTE = _getCPR ("UBL-CreditNote-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_CREDITNOTE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new UBL24JAXBMarshaller <> (CreditNoteType.class,
                                       getAllCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_24.ObjectFactory._CreditNote_QNAME);
  }

  private static final ClassPathResource CPR_DEBITNOTE = _getCPR ("UBL-DebitNote-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDebitNoteXSDs ()
  {
    return _getAllXSDs (CPR_DEBITNOTE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new UBL24JAXBMarshaller <> (DebitNoteType.class,
                                       getAllDebitNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.debitnote_24.ObjectFactory._DebitNote_QNAME);
  }

  private static final ClassPathResource CPR_DESPATCHADVICE = _getCPR ("UBL-DespatchAdvice-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDespatchAdviceXSDs ()
  {
    return _getAllXSDs (CPR_DESPATCHADVICE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DespatchAdviceType> despatchAdvice ()
  {
    return new UBL24JAXBMarshaller <> (DespatchAdviceType.class,
                                       getAllDespatchAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.despatchadvice_24.ObjectFactory._DespatchAdvice_QNAME);
  }

  private static final ClassPathResource CPR_DIGITALAGREEMENT = _getCPR ("UBL-DigitalAgreement-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDigitalAgreementXSDs ()
  {
    return _getAllXSDs (CPR_DIGITALAGREEMENT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DigitalAgreementType> digitalAgreement ()
  {
    return new UBL24JAXBMarshaller <> (DigitalAgreementType.class,
                                       getAllDigitalAgreementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.digitalagreement_24.ObjectFactory._DigitalAgreement_QNAME);
  }

  private static final ClassPathResource CPR_DIGITALCAPABILITY = _getCPR ("UBL-DigitalCapability-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDigitalCapabilityXSDs ()
  {
    return _getAllXSDs (CPR_DIGITALCAPABILITY);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DigitalCapabilityType> digitalCapability ()
  {
    return new UBL24JAXBMarshaller <> (DigitalCapabilityType.class,
                                       getAllDigitalCapabilityXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.digitalcapability_24.ObjectFactory._DigitalCapability_QNAME);
  }

  private static final ClassPathResource CPR_DOCUMENTSTATUS = _getCPR ("UBL-DocumentStatus-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDocumentStatusXSDs ()
  {
    return _getAllXSDs (CPR_DOCUMENTSTATUS);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DocumentStatusType> documentStatus ()
  {
    return new UBL24JAXBMarshaller <> (DocumentStatusType.class,
                                       getAllDocumentStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.documentstatus_24.ObjectFactory._DocumentStatus_QNAME);
  }

  private static final ClassPathResource CPR_DOCUMENTSTATUSREQUEST = _getCPR ("UBL-DocumentStatusRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDocumentStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_DOCUMENTSTATUSREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <DocumentStatusRequestType> documentStatusRequest ()
  {
    return new UBL24JAXBMarshaller <> (DocumentStatusRequestType.class,
                                       getAllDocumentStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.documentstatusrequest_24.ObjectFactory._DocumentStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_ENQUIRY = _getCPR ("UBL-Enquiry-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllEnquiryXSDs ()
  {
    return _getAllXSDs (CPR_ENQUIRY);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <EnquiryType> enquiry ()
  {
    return new UBL24JAXBMarshaller <> (EnquiryType.class,
                                       getAllEnquiryXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.enquiry_24.ObjectFactory._Enquiry_QNAME);
  }

  private static final ClassPathResource CPR_ENQUIRYRESPONSE = _getCPR ("UBL-EnquiryResponse-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllEnquiryResponseXSDs ()
  {
    return _getAllXSDs (CPR_ENQUIRYRESPONSE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <EnquiryResponseType> enquiryResponse ()
  {
    return new UBL24JAXBMarshaller <> (EnquiryResponseType.class,
                                       getAllEnquiryResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.enquiryresponse_24.ObjectFactory._EnquiryResponse_QNAME);
  }

  private static final ClassPathResource CPR_EXCEPTIONCRITERIA = _getCPR ("UBL-ExceptionCriteria-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExceptionCriteriaXSDs ()
  {
    return _getAllXSDs (CPR_EXCEPTIONCRITERIA);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ExceptionCriteriaType> exceptionCriteria ()
  {
    return new UBL24JAXBMarshaller <> (ExceptionCriteriaType.class,
                                       getAllExceptionCriteriaXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exceptioncriteria_24.ObjectFactory._ExceptionCriteria_QNAME);
  }

  private static final ClassPathResource CPR_EXCEPTIONNOTIFICATION = _getCPR ("UBL-ExceptionNotification-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExceptionNotificationXSDs ()
  {
    return _getAllXSDs (CPR_EXCEPTIONNOTIFICATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ExceptionNotificationType> exceptionNotification ()
  {
    return new UBL24JAXBMarshaller <> (ExceptionNotificationType.class,
                                       getAllExceptionNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exceptionnotification_24.ObjectFactory._ExceptionNotification_QNAME);
  }

  private static final ClassPathResource CPR_EXPORTCUSTOMSDECLARATION = _getCPR ("UBL-ExportCustomsDeclaration-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExportCustomsDeclarationXSDs ()
  {
    return _getAllXSDs (CPR_EXPORTCUSTOMSDECLARATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ExportCustomsDeclarationType> exportCustomsDeclaration ()
  {
    return new UBL24JAXBMarshaller <> (ExportCustomsDeclarationType.class,
                                       getAllExportCustomsDeclarationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_24.ObjectFactory._ExportCustomsDeclaration_QNAME);
  }

  private static final ClassPathResource CPR_EXPRESSIONOFINTERESTREQUEST = _getCPR ("UBL-ExpressionOfInterestRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExpressionOfInterestRequestXSDs ()
  {
    return _getAllXSDs (CPR_EXPRESSIONOFINTERESTREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ExpressionOfInterestRequestType> expressionOfInterestRequest ()
  {
    return new UBL24JAXBMarshaller <> (ExpressionOfInterestRequestType.class,
                                       getAllExpressionOfInterestRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_24.ObjectFactory._ExpressionOfInterestRequest_QNAME);
  }

  private static final ClassPathResource CPR_EXPRESSIONOFINTERESTRESPONSE = _getCPR ("UBL-ExpressionOfInterestResponse-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExpressionOfInterestResponseXSDs ()
  {
    return _getAllXSDs (CPR_EXPRESSIONOFINTERESTRESPONSE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ExpressionOfInterestResponseType> expressionOfInterestResponse ()
  {
    return new UBL24JAXBMarshaller <> (ExpressionOfInterestResponseType.class,
                                       getAllExpressionOfInterestResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_24.ObjectFactory._ExpressionOfInterestResponse_QNAME);
  }

  private static final ClassPathResource CPR_FORECAST = _getCPR ("UBL-Forecast-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForecastXSDs ()
  {
    return _getAllXSDs (CPR_FORECAST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ForecastType> forecast ()
  {
    return new UBL24JAXBMarshaller <> (ForecastType.class,
                                       getAllForecastXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forecast_24.ObjectFactory._Forecast_QNAME);
  }

  private static final ClassPathResource CPR_FORECASTREVISION = _getCPR ("UBL-ForecastRevision-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForecastRevisionXSDs ()
  {
    return _getAllXSDs (CPR_FORECASTREVISION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ForecastRevisionType> forecastRevision ()
  {
    return new UBL24JAXBMarshaller <> (ForecastRevisionType.class,
                                       getAllForecastRevisionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forecastrevision_24.ObjectFactory._ForecastRevision_QNAME);
  }

  private static final ClassPathResource CPR_FORWARDINGINSTRUCTIONS = _getCPR ("UBL-ForwardingInstructions-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForwardingInstructionsXSDs ()
  {
    return _getAllXSDs (CPR_FORWARDINGINSTRUCTIONS);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ForwardingInstructionsType> forwardingInstructions ()
  {
    return new UBL24JAXBMarshaller <> (ForwardingInstructionsType.class,
                                       getAllForwardingInstructionsXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forwardinginstructions_24.ObjectFactory._ForwardingInstructions_QNAME);
  }

  private static final ClassPathResource CPR_FREIGHTINVOICE = _getCPR ("UBL-FreightInvoice-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllFreightInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_FREIGHTINVOICE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <FreightInvoiceType> freightInvoice ()
  {
    return new UBL24JAXBMarshaller <> (FreightInvoiceType.class,
                                       getAllFreightInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.freightinvoice_24.ObjectFactory._FreightInvoice_QNAME);
  }

  private static final ClassPathResource CPR_FULFILMENTCANCELLATION = _getCPR ("UBL-FulfilmentCancellation-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllFulfilmentCancellationXSDs ()
  {
    return _getAllXSDs (CPR_FULFILMENTCANCELLATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return new UBL24JAXBMarshaller <> (FulfilmentCancellationType.class,
                                       getAllFulfilmentCancellationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_24.ObjectFactory._FulfilmentCancellation_QNAME);
  }

  private static final ClassPathResource CPR_GOODSCERTIFICATE = _getCPR ("UBL-GoodsCertificate-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGoodsCertificateXSDs ()
  {
    return _getAllXSDs (CPR_GOODSCERTIFICATE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <GoodsCertificateType> goodsCertificate ()
  {
    return new UBL24JAXBMarshaller <> (GoodsCertificateType.class,
                                       getAllGoodsCertificateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.goodscertificate_24.ObjectFactory._GoodsCertificate_QNAME);
  }

  private static final ClassPathResource CPR_GOODSITEMITINERARY = _getCPR ("UBL-GoodsItemItinerary-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGoodsItemItineraryXSDs ()
  {
    return _getAllXSDs (CPR_GOODSITEMITINERARY);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return new UBL24JAXBMarshaller <> (GoodsItemItineraryType.class,
                                       getAllGoodsItemItineraryXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_24.ObjectFactory._GoodsItemItinerary_QNAME);
  }

  private static final ClassPathResource CPR_GOODSITEMPASSPORT = _getCPR ("UBL-GoodsItemPassport-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGoodsItemPassportXSDs ()
  {
    return _getAllXSDs (CPR_GOODSITEMPASSPORT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <GoodsItemPassportType> goodsItemPassport ()
  {
    return new UBL24JAXBMarshaller <> (GoodsItemPassportType.class,
                                       getAllGoodsItemPassportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.goodsitempassport_24.ObjectFactory._GoodsItemPassport_QNAME);
  }

  private static final ClassPathResource CPR_GUARANTEECERTIFICATE = _getCPR ("UBL-GuaranteeCertificate-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGuaranteeCertificateXSDs ()
  {
    return _getAllXSDs (CPR_GUARANTEECERTIFICATE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return new UBL24JAXBMarshaller <> (GuaranteeCertificateType.class,
                                       getAllGuaranteeCertificateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.guaranteecertificate_24.ObjectFactory._GuaranteeCertificate_QNAME);
  }

  private static final ClassPathResource CPR_IMPORTCUSTOMSDECLARATION = _getCPR ("UBL-ImportCustomsDeclaration-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllImportCustomsDeclarationXSDs ()
  {
    return _getAllXSDs (CPR_IMPORTCUSTOMSDECLARATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ImportCustomsDeclarationType> importCustomsDeclaration ()
  {
    return new UBL24JAXBMarshaller <> (ImportCustomsDeclarationType.class,
                                       getAllImportCustomsDeclarationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_24.ObjectFactory._ImportCustomsDeclaration_QNAME);
  }

  private static final ClassPathResource CPR_INSTRUCTIONFORRETURNS = _getCPR ("UBL-InstructionForReturns-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInstructionForReturnsXSDs ()
  {
    return _getAllXSDs (CPR_INSTRUCTIONFORRETURNS);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <InstructionForReturnsType> instructionForReturns ()
  {
    return new UBL24JAXBMarshaller <> (InstructionForReturnsType.class,
                                       getAllInstructionForReturnsXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.instructionforreturns_24.ObjectFactory._InstructionForReturns_QNAME);
  }

  private static final ClassPathResource CPR_INVENTORYREPORT = _getCPR ("UBL-InventoryReport-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInventoryReportXSDs ()
  {
    return _getAllXSDs (CPR_INVENTORYREPORT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <InventoryReportType> inventoryReport ()
  {
    return new UBL24JAXBMarshaller <> (InventoryReportType.class,
                                       getAllInventoryReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.inventoryreport_24.ObjectFactory._InventoryReport_QNAME);
  }

  private static final ClassPathResource CPR_INVOICE = _getCPR ("UBL-Invoice-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_INVOICE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <InvoiceType> invoice ()
  {
    return new UBL24JAXBMarshaller <> (InvoiceType.class,
                                       getAllInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.invoice_24.ObjectFactory._Invoice_QNAME);
  }

  private static final ClassPathResource CPR_ITEMINFORMATIONREQUEST = _getCPR ("UBL-ItemInformationRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllItemInformationRequestXSDs ()
  {
    return _getAllXSDs (CPR_ITEMINFORMATIONREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ItemInformationRequestType> itemInformationRequest ()
  {
    return new UBL24JAXBMarshaller <> (ItemInformationRequestType.class,
                                       getAllItemInformationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.iteminformationrequest_24.ObjectFactory._ItemInformationRequest_QNAME);
  }

  private static final ClassPathResource CPR_MANIFEST = _getCPR ("UBL-Manifest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllManifestXSDs ()
  {
    return _getAllXSDs (CPR_MANIFEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ManifestType> manifest ()
  {
    return new UBL24JAXBMarshaller <> (ManifestType.class,
                                       getAllManifestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.manifest_24.ObjectFactory._Manifest_QNAME);
  }

  private static final ClassPathResource CPR_ORDER = _getCPR ("UBL-Order-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderXSDs ()
  {
    return _getAllXSDs (CPR_ORDER);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <OrderType> order ()
  {
    return new UBL24JAXBMarshaller <> (OrderType.class,
                                       getAllOrderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.order_24.ObjectFactory._Order_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCANCELLATION = _getCPR ("UBL-OrderCancellation-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderCancellationXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCANCELLATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <OrderCancellationType> orderCancellation ()
  {
    return new UBL24JAXBMarshaller <> (OrderCancellationType.class,
                                       getAllOrderCancellationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.ordercancellation_24.ObjectFactory._OrderCancellation_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCHANGE = _getCPR ("UBL-OrderChange-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderChangeXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCHANGE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <OrderChangeType> orderChange ()
  {
    return new UBL24JAXBMarshaller <> (OrderChangeType.class,
                                       getAllOrderChangeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderchange_24.ObjectFactory._OrderChange_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSE = _getCPR ("UBL-OrderResponse-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <OrderResponseType> orderResponse ()
  {
    return new UBL24JAXBMarshaller <> (OrderResponseType.class,
                                       getAllOrderResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponse_24.ObjectFactory._OrderResponse_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSESIMPLE = _getCPR ("UBL-OrderResponseSimple-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseSimpleXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSESIMPLE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <OrderResponseSimpleType> orderResponseSimple ()
  {
    return new UBL24JAXBMarshaller <> (OrderResponseSimpleType.class,
                                       getAllOrderResponseSimpleXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponsesimple_24.ObjectFactory._OrderResponseSimple_QNAME);
  }

  private static final ClassPathResource CPR_PACKINGLIST = _getCPR ("UBL-PackingList-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPackingListXSDs ()
  {
    return _getAllXSDs (CPR_PACKINGLIST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <PackingListType> packingList ()
  {
    return new UBL24JAXBMarshaller <> (PackingListType.class,
                                       getAllPackingListXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.packinglist_24.ObjectFactory._PackingList_QNAME);
  }

  private static final ClassPathResource CPR_PRIORINFORMATIONNOTICE = _getCPR ("UBL-PriorInformationNotice-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPriorInformationNoticeXSDs ()
  {
    return _getAllXSDs (CPR_PRIORINFORMATIONNOTICE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <PriorInformationNoticeType> priorInformationNotice ()
  {
    return new UBL24JAXBMarshaller <> (PriorInformationNoticeType.class,
                                       getAllPriorInformationNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.priorinformationnotice_24.ObjectFactory._PriorInformationNotice_QNAME);
  }

  private static final ClassPathResource CPR_PRODUCTACTIVITY = _getCPR ("UBL-ProductActivity-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProductActivityXSDs ()
  {
    return _getAllXSDs (CPR_PRODUCTACTIVITY);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ProductActivityType> productActivity ()
  {
    return new UBL24JAXBMarshaller <> (ProductActivityType.class,
                                       getAllProductActivityXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.productactivity_24.ObjectFactory._ProductActivity_QNAME);
  }

  private static final ClassPathResource CPR_PROOFOFREEXPORTATION = _getCPR ("UBL-ProofOfReexportation-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProofOfReexportationXSDs ()
  {
    return _getAllXSDs (CPR_PROOFOFREEXPORTATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ProofOfReexportationType> proofOfReexportation ()
  {
    return new UBL24JAXBMarshaller <> (ProofOfReexportationType.class,
                                       getAllProofOfReexportationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportation_24.ObjectFactory._ProofOfReexportation_QNAME);
  }

  private static final ClassPathResource CPR_PROOFOFREEXPORTATIONREMINDER = _getCPR ("UBL-ProofOfReexportationReminder-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProofOfReexportationReminderXSDs ()
  {
    return _getAllXSDs (CPR_PROOFOFREEXPORTATIONREMINDER);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ProofOfReexportationReminderType> proofOfReexportationReminder ()
  {
    return new UBL24JAXBMarshaller <> (ProofOfReexportationReminderType.class,
                                       getAllProofOfReexportationReminderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_24.ObjectFactory._ProofOfReexportationReminder_QNAME);
  }

  private static final ClassPathResource CPR_PROOFOFREEXPORTATIONREQUEST = _getCPR ("UBL-ProofOfReexportationRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProofOfReexportationRequestXSDs ()
  {
    return _getAllXSDs (CPR_PROOFOFREEXPORTATIONREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ProofOfReexportationRequestType> proofOfReexportationRequest ()
  {
    return new UBL24JAXBMarshaller <> (ProofOfReexportationRequestType.class,
                                       getAllProofOfReexportationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_24.ObjectFactory._ProofOfReexportationRequest_QNAME);
  }

  private static final ClassPathResource CPR_PURCHASERECEIPT = _getCPR ("UBL-PurchaseReceipt-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPurchaseReceiptXSDs ()
  {
    return _getAllXSDs (CPR_PURCHASERECEIPT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <PurchaseReceiptType> purchaseReceipt ()
  {
    return new UBL24JAXBMarshaller <> (PurchaseReceiptType.class,
                                       getAllPurchaseReceiptXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.purchasereceipt_24.ObjectFactory._PurchaseReceipt_QNAME);
  }

  private static final ClassPathResource CPR_QUALIFICATIONAPPLICATIONREQUEST = _getCPR ("UBL-QualificationApplicationRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQualificationApplicationRequestXSDs ()
  {
    return _getAllXSDs (CPR_QUALIFICATIONAPPLICATIONREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <QualificationApplicationRequestType> qualificationApplicationRequest ()
  {
    return new UBL24JAXBMarshaller <> (QualificationApplicationRequestType.class,
                                       getAllQualificationApplicationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_24.ObjectFactory._QualificationApplicationRequest_QNAME);
  }

  private static final ClassPathResource CPR_QUALIFICATIONAPPLICATIONRESPONSE = _getCPR ("UBL-QualificationApplicationResponse-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQualificationApplicationResponseXSDs ()
  {
    return _getAllXSDs (CPR_QUALIFICATIONAPPLICATIONRESPONSE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <QualificationApplicationResponseType> qualificationApplicationResponse ()
  {
    return new UBL24JAXBMarshaller <> (QualificationApplicationResponseType.class,
                                       getAllQualificationApplicationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_24.ObjectFactory._QualificationApplicationResponse_QNAME);
  }

  private static final ClassPathResource CPR_QUOTATION = _getCPR ("UBL-Quotation-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQuotationXSDs ()
  {
    return _getAllXSDs (CPR_QUOTATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <QuotationType> quotation ()
  {
    return new UBL24JAXBMarshaller <> (QuotationType.class,
                                       getAllQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.quotation_24.ObjectFactory._Quotation_QNAME);
  }

  private static final ClassPathResource CPR_RECEIPTADVICE = _getCPR ("UBL-ReceiptAdvice-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReceiptAdviceXSDs ()
  {
    return _getAllXSDs (CPR_RECEIPTADVICE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ReceiptAdviceType> receiptAdvice ()
  {
    return new UBL24JAXBMarshaller <> (ReceiptAdviceType.class,
                                       getAllReceiptAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.receiptadvice_24.ObjectFactory._ReceiptAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REMINDER = _getCPR ("UBL-Reminder-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReminderXSDs ()
  {
    return _getAllXSDs (CPR_REMINDER);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <ReminderType> reminder ()
  {
    return new UBL24JAXBMarshaller <> (ReminderType.class,
                                       getAllReminderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.reminder_24.ObjectFactory._Reminder_QNAME);
  }

  private static final ClassPathResource CPR_REMITTANCEADVICE = _getCPR ("UBL-RemittanceAdvice-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRemittanceAdviceXSDs ()
  {
    return _getAllXSDs (CPR_REMITTANCEADVICE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <RemittanceAdviceType> remittanceAdvice ()
  {
    return new UBL24JAXBMarshaller <> (RemittanceAdviceType.class,
                                       getAllRemittanceAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.remittanceadvice_24.ObjectFactory._RemittanceAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REQUESTFORQUOTATION = _getCPR ("UBL-RequestForQuotation-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRequestForQuotationXSDs ()
  {
    return _getAllXSDs (CPR_REQUESTFORQUOTATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <RequestForQuotationType> requestForQuotation ()
  {
    return new UBL24JAXBMarshaller <> (RequestForQuotationType.class,
                                       getAllRequestForQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.requestforquotation_24.ObjectFactory._RequestForQuotation_QNAME);
  }

  private static final ClassPathResource CPR_RETAILEVENT = _getCPR ("UBL-RetailEvent-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRetailEventXSDs ()
  {
    return _getAllXSDs (CPR_RETAILEVENT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <RetailEventType> retailEvent ()
  {
    return new UBL24JAXBMarshaller <> (RetailEventType.class,
                                       getAllRetailEventXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.retailevent_24.ObjectFactory._RetailEvent_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDCREDITNOTE = _getCPR ("UBL-SelfBilledCreditNote-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDCREDITNOTE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return new UBL24JAXBMarshaller <> (SelfBilledCreditNoteType.class,
                                       getAllSelfBilledCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_24.ObjectFactory._SelfBilledCreditNote_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDINVOICE = _getCPR ("UBL-SelfBilledInvoice-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDINVOICE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return new UBL24JAXBMarshaller <> (SelfBilledInvoiceType.class,
                                       getAllSelfBilledInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_24.ObjectFactory._SelfBilledInvoice_QNAME);
  }

  private static final ClassPathResource CPR_STATEMENT = _getCPR ("UBL-Statement-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllStatementXSDs ()
  {
    return _getAllXSDs (CPR_STATEMENT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <StatementType> statement ()
  {
    return new UBL24JAXBMarshaller <> (StatementType.class,
                                       getAllStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.statement_24.ObjectFactory._Statement_QNAME);
  }

  private static final ClassPathResource CPR_STOCKAVAILABILITYREPORT = _getCPR ("UBL-StockAvailabilityReport-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllStockAvailabilityReportXSDs ()
  {
    return _getAllXSDs (CPR_STOCKAVAILABILITYREPORT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return new UBL24JAXBMarshaller <> (StockAvailabilityReportType.class,
                                       getAllStockAvailabilityReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_24.ObjectFactory._StockAvailabilityReport_QNAME);
  }

  private static final ClassPathResource CPR_TENDER = _getCPR ("UBL-Tender-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderXSDs ()
  {
    return _getAllXSDs (CPR_TENDER);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderType> tender ()
  {
    return new UBL24JAXBMarshaller <> (TenderType.class,
                                       getAllTenderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tender_24.ObjectFactory._Tender_QNAME);
  }

  private static final ClassPathResource CPR_TENDERCONTRACT = _getCPR ("UBL-TenderContract-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderContractXSDs ()
  {
    return _getAllXSDs (CPR_TENDERCONTRACT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderContractType> tenderContract ()
  {
    return new UBL24JAXBMarshaller <> (TenderContractType.class,
                                       getAllTenderContractXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendercontract_24.ObjectFactory._TenderContract_QNAME);
  }

  private static final ClassPathResource CPR_TENDERERQUALIFICATION = _getCPR ("UBL-TendererQualification-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTendererQualificationXSDs ()
  {
    return _getAllXSDs (CPR_TENDERERQUALIFICATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TendererQualificationType> tendererQualification ()
  {
    return new UBL24JAXBMarshaller <> (TendererQualificationType.class,
                                       getAllTendererQualificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualification_24.ObjectFactory._TendererQualification_QNAME);
  }

  private static final ClassPathResource CPR_TENDERERQUALIFICATIONRESPONSE = _getCPR ("UBL-TendererQualificationResponse-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTendererQualificationResponseXSDs ()
  {
    return _getAllXSDs (CPR_TENDERERQUALIFICATIONRESPONSE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return new UBL24JAXBMarshaller <> (TendererQualificationResponseType.class,
                                       getAllTendererQualificationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_24.ObjectFactory._TendererQualificationResponse_QNAME);
  }

  private static final ClassPathResource CPR_TENDERRECEIPT = _getCPR ("UBL-TenderReceipt-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderReceiptXSDs ()
  {
    return _getAllXSDs (CPR_TENDERRECEIPT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderReceiptType> tenderReceipt ()
  {
    return new UBL24JAXBMarshaller <> (TenderReceiptType.class,
                                       getAllTenderReceiptXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderreceipt_24.ObjectFactory._TenderReceipt_QNAME);
  }

  private static final ClassPathResource CPR_TENDERSTATUS = _getCPR ("UBL-TenderStatus-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderStatusXSDs ()
  {
    return _getAllXSDs (CPR_TENDERSTATUS);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderStatusType> tenderStatus ()
  {
    return new UBL24JAXBMarshaller <> (TenderStatusType.class,
                                       getAllTenderStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatus_24.ObjectFactory._TenderStatus_QNAME);
  }

  private static final ClassPathResource CPR_TENDERSTATUSREQUEST = _getCPR ("UBL-TenderStatusRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TENDERSTATUSREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderStatusRequestType> tenderStatusRequest ()
  {
    return new UBL24JAXBMarshaller <> (TenderStatusRequestType.class,
                                       getAllTenderStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_24.ObjectFactory._TenderStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TENDERWITHDRAWAL = _getCPR ("UBL-TenderWithdrawal-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderWithdrawalXSDs ()
  {
    return _getAllXSDs (CPR_TENDERWITHDRAWAL);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TenderWithdrawalType> tenderWithdrawal ()
  {
    return new UBL24JAXBMarshaller <> (TenderWithdrawalType.class,
                                       getAllTenderWithdrawalXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_24.ObjectFactory._TenderWithdrawal_QNAME);
  }

  private static final ClassPathResource CPR_TRADEITEMLOCATIONPROFILE = _getCPR ("UBL-TradeItemLocationProfile-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTradeItemLocationProfileXSDs ()
  {
    return _getAllXSDs (CPR_TRADEITEMLOCATIONPROFILE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return new UBL24JAXBMarshaller <> (TradeItemLocationProfileType.class,
                                       getAllTradeItemLocationProfileXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_24.ObjectFactory._TradeItemLocationProfile_QNAME);
  }

  private static final ClassPathResource CPR_TRANSITCUSTOMSDECLARATION = _getCPR ("UBL-TransitCustomsDeclaration-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransitCustomsDeclarationXSDs ()
  {
    return _getAllXSDs (CPR_TRANSITCUSTOMSDECLARATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransitCustomsDeclarationType> transitCustomsDeclaration ()
  {
    return new UBL24JAXBMarshaller <> (TransitCustomsDeclarationType.class,
                                       getAllTransitCustomsDeclarationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_24.ObjectFactory._TransitCustomsDeclaration_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTATIONSTATUS = _getCPR ("UBL-TransportationStatus-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportationStatusXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTATIONSTATUS);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportationStatusType> transportationStatus ()
  {
    return new UBL24JAXBMarshaller <> (TransportationStatusType.class,
                                       getAllTransportationStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatus_24.ObjectFactory._TransportationStatus_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTATIONSTATUSREQUEST = _getCPR ("UBL-TransportationStatusRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportationStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTATIONSTATUSREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return new UBL24JAXBMarshaller <> (TransportationStatusRequestType.class,
                                       getAllTransportationStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_24.ObjectFactory._TransportationStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTEXECUTIONPLAN = _getCPR ("UBL-TransportExecutionPlan-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportExecutionPlanXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTEXECUTIONPLAN);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return new UBL24JAXBMarshaller <> (TransportExecutionPlanType.class,
                                       getAllTransportExecutionPlanXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplan_24.ObjectFactory._TransportExecutionPlan_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTEXECUTIONPLANREQUEST = _getCPR ("UBL-TransportExecutionPlanRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportExecutionPlanRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTEXECUTIONPLANREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return new UBL24JAXBMarshaller <> (TransportExecutionPlanRequestType.class,
                                       getAllTransportExecutionPlanRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_24.ObjectFactory._TransportExecutionPlanRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTPROGRESSSTATUS = _getCPR ("UBL-TransportProgressStatus-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportProgressStatusXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTPROGRESSSTATUS);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportProgressStatusType> transportProgressStatus ()
  {
    return new UBL24JAXBMarshaller <> (TransportProgressStatusType.class,
                                       getAllTransportProgressStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatus_24.ObjectFactory._TransportProgressStatus_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTPROGRESSSTATUSREQUEST = _getCPR ("UBL-TransportProgressStatusRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportProgressStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTPROGRESSSTATUSREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return new UBL24JAXBMarshaller <> (TransportProgressStatusRequestType.class,
                                       getAllTransportProgressStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_24.ObjectFactory._TransportProgressStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTSERVICEDESCRIPTION = _getCPR ("UBL-TransportServiceDescription-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportServiceDescriptionXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTSERVICEDESCRIPTION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return new UBL24JAXBMarshaller <> (TransportServiceDescriptionType.class,
                                       getAllTransportServiceDescriptionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescription_24.ObjectFactory._TransportServiceDescription_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTSERVICEDESCRIPTIONREQUEST = _getCPR ("UBL-TransportServiceDescriptionRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportServiceDescriptionRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTSERVICEDESCRIPTIONREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return new UBL24JAXBMarshaller <> (TransportServiceDescriptionRequestType.class,
                                       getAllTransportServiceDescriptionRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_24.ObjectFactory._TransportServiceDescriptionRequest_QNAME);
  }

  private static final ClassPathResource CPR_UNAWARDEDNOTIFICATION = _getCPR ("UBL-UnawardedNotification-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnawardedNotificationXSDs ()
  {
    return _getAllXSDs (CPR_UNAWARDEDNOTIFICATION);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <UnawardedNotificationType> unawardedNotification ()
  {
    return new UBL24JAXBMarshaller <> (UnawardedNotificationType.class,
                                       getAllUnawardedNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unawardednotification_24.ObjectFactory._UnawardedNotification_QNAME);
  }

  private static final ClassPathResource CPR_UNSUBSCRIBEFROMPROCEDUREREQUEST = _getCPR ("UBL-UnsubscribeFromProcedureRequest-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnsubscribeFromProcedureRequestXSDs ()
  {
    return _getAllXSDs (CPR_UNSUBSCRIBEFROMPROCEDUREREQUEST);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest ()
  {
    return new UBL24JAXBMarshaller <> (UnsubscribeFromProcedureRequestType.class,
                                       getAllUnsubscribeFromProcedureRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_24.ObjectFactory._UnsubscribeFromProcedureRequest_QNAME);
  }

  private static final ClassPathResource CPR_UNSUBSCRIBEFROMPROCEDURERESPONSE = _getCPR ("UBL-UnsubscribeFromProcedureResponse-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnsubscribeFromProcedureResponseXSDs ()
  {
    return _getAllXSDs (CPR_UNSUBSCRIBEFROMPROCEDURERESPONSE);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse ()
  {
    return new UBL24JAXBMarshaller <> (UnsubscribeFromProcedureResponseType.class,
                                       getAllUnsubscribeFromProcedureResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_24.ObjectFactory._UnsubscribeFromProcedureResponse_QNAME);
  }

  private static final ClassPathResource CPR_UTILITYSTATEMENT = _getCPR ("UBL-UtilityStatement-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUtilityStatementXSDs ()
  {
    return _getAllXSDs (CPR_UTILITYSTATEMENT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <UtilityStatementType> utilityStatement ()
  {
    return new UBL24JAXBMarshaller <> (UtilityStatementType.class,
                                       getAllUtilityStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.utilitystatement_24.ObjectFactory._UtilityStatement_QNAME);
  }

  private static final ClassPathResource CPR_WAYBILL = _getCPR ("UBL-Waybill-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWaybillXSDs ()
  {
    return _getAllXSDs (CPR_WAYBILL);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <WaybillType> waybill ()
  {
    return new UBL24JAXBMarshaller <> (WaybillType.class,
                                       getAllWaybillXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.waybill_24.ObjectFactory._Waybill_QNAME);
  }

  private static final ClassPathResource CPR_WEIGHTSTATEMENT = _getCPR ("UBL-WeightStatement-2.4.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWeightStatementXSDs ()
  {
    return _getAllXSDs (CPR_WEIGHTSTATEMENT);
  }

  @Nonnull
  public static UBL24JAXBMarshaller <WeightStatementType> weightStatement ()
  {
    return new UBL24JAXBMarshaller <> (WeightStatementType.class,
                                       getAllWeightStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.weightstatement_24.ObjectFactory._WeightStatement_QNAME);
  }
}
