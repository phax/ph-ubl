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
package com.helger.ubl23;

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

import oasis.names.specification.ubl.schema.xsd.applicationresponse_23.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_23.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.awardednotification_23.AwardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.billoflading_23.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.businesscard_23.BusinessCardType;
import oasis.names.specification.ubl.schema.xsd.callfortenders_23.CallForTendersType;
import oasis.names.specification.ubl.schema.xsd.catalogue_23.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_23.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_23.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_23.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_23.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_23.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.commontransportationreport_23.CommonTransportationReportType;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_23.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.creditnote_23.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_23.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_23.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.digitalagreement_23.DigitalAgreementType;
import oasis.names.specification.ubl.schema.xsd.digitalcapability_23.DigitalCapabilityType;
import oasis.names.specification.ubl.schema.xsd.documentstatus_23.DocumentStatusType;
import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_23.DocumentStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.enquiry_23.EnquiryType;
import oasis.names.specification.ubl.schema.xsd.enquiryresponse_23.EnquiryResponseType;
import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_23.ExceptionCriteriaType;
import oasis.names.specification.ubl.schema.xsd.exceptionnotification_23.ExceptionNotificationType;
import oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_23.ExportCustomsDeclarationType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_23.ExpressionOfInterestRequestType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_23.ExpressionOfInterestResponseType;
import oasis.names.specification.ubl.schema.xsd.forecast_23.ForecastType;
import oasis.names.specification.ubl.schema.xsd.forecastrevision_23.ForecastRevisionType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_23.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_23.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_23.FulfilmentCancellationType;
import oasis.names.specification.ubl.schema.xsd.goodscertificate_23.GoodsCertificateType;
import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_23.GoodsItemItineraryType;
import oasis.names.specification.ubl.schema.xsd.goodsitempassport_23.GoodsItemPassportType;
import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_23.GuaranteeCertificateType;
import oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_23.ImportCustomsDeclarationType;
import oasis.names.specification.ubl.schema.xsd.instructionforreturns_23.InstructionForReturnsType;
import oasis.names.specification.ubl.schema.xsd.inventoryreport_23.InventoryReportType;
import oasis.names.specification.ubl.schema.xsd.invoice_23.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_23.ItemInformationRequestType;
import oasis.names.specification.ubl.schema.xsd.manifest_23.ManifestType;
import oasis.names.specification.ubl.schema.xsd.order_23.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_23.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_23.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_23.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_23.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_23.PackingListType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.PriorInformationNoticeType;
import oasis.names.specification.ubl.schema.xsd.productactivity_23.ProductActivityType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportation_23.ProofOfReexportationType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_23.ProofOfReexportationReminderType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_23.ProofOfReexportationRequestType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_23.QualificationApplicationRequestType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_23.QualificationApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.quotation_23.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_23.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_23.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_23.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_23.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.retailevent_23.RetailEventType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_23.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_23.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_23.StatementType;
import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_23.StockAvailabilityReportType;
import oasis.names.specification.ubl.schema.xsd.tender_23.TenderType;
import oasis.names.specification.ubl.schema.xsd.tendercontract_23.TenderContractType;
import oasis.names.specification.ubl.schema.xsd.tendererqualification_23.TendererQualificationType;
import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_23.TendererQualificationResponseType;
import oasis.names.specification.ubl.schema.xsd.tenderreceipt_23.TenderReceiptType;
import oasis.names.specification.ubl.schema.xsd.tenderstatus_23.TenderStatusType;
import oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_23.TenderStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_23.TenderWithdrawalType;
import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_23.TradeItemLocationProfileType;
import oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_23.TransitCustomsDeclarationType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_23.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_23.TransportationStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_23.TransportExecutionPlanType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_23.TransportExecutionPlanRequestType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_23.TransportProgressStatusType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_23.TransportProgressStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescription_23.TransportServiceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_23.TransportServiceDescriptionRequestType;
import oasis.names.specification.ubl.schema.xsd.unawardednotification_23.UnawardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_23.UnsubscribeFromProcedureRequestType;
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_23.UnsubscribeFromProcedureResponseType;
import oasis.names.specification.ubl.schema.xsd.utilitystatement_23.UtilityStatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_23.WaybillType;
import oasis.names.specification.ubl.schema.xsd.weightstatement_23.WeightStatementType;

/**
 * The class provides all the UBL 2.3 marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class UBL23Marshaller
{
  public static class UBL23JAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    private final QName m_aRootElementQName;

    public UBL23JAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nonnull @Nonempty final ICommonsList <ClassPathResource> aXSDs,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, aXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      m_aRootElementQName = aRootElementQName;

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBL23NamespaceContext.getInstance ().getClone ();
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
                                                                                             CUBL23.XSD_UNQUALIFIED_DATA_TYPES,
                                                                                             CUBL23.XSD_QUALIFIED_DATA_TYPES,
                                                                                             CUBL23.XSD_SIGNATURE_BASIC_COMPONENTS,
                                                                                             CUBL23.XSD_COMMON_BASIC_COMPONENTS,
                                                                                             CUBL23.XSD_SIGNATURE_AGGREGATE_COMPONENTS,
                                                                                             CUBL23.XSD_COMMON_SIGNATURE_COMPONENTS,
                                                                                             CUBL23.XSD_COMMON_EXTENSION_COMPONENTS,
                                                                                             CUBL23.XSD_COMMON_AGGREGATE_COMPONENTS);

  @Nonnull
  @ReturnsMutableCopy
  private static ICommonsList <ClassPathResource> _getAllXSDs (@Nonnull final ClassPathResource aXSD)
  {
    final ICommonsList <ClassPathResource> ret = BASE_XSDS.getClone ();
    ret.add (aXSD);
    return ret;
  }

  private UBL23Marshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CUBL23.SCHEMA_DIRECTORY + sXSDPath, CUBL23.getCL ());
  }

  // Automatically created from here on

  private static final ClassPathResource CPR_APPLICATIONRESPONSE = _getCPR ("UBL-ApplicationResponse-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllApplicationResponseXSDs ()
  {
    return _getAllXSDs (CPR_APPLICATIONRESPONSE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new UBL23JAXBMarshaller <> (ApplicationResponseType.class,
                                       getAllApplicationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.applicationresponse_23.ObjectFactory._ApplicationResponse_QNAME);
  }

  private static final ClassPathResource CPR_ATTACHEDDOCUMENT = _getCPR ("UBL-AttachedDocument-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllAttachedDocumentXSDs ()
  {
    return _getAllXSDs (CPR_ATTACHEDDOCUMENT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new UBL23JAXBMarshaller <> (AttachedDocumentType.class,
                                       getAllAttachedDocumentXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.attacheddocument_23.ObjectFactory._AttachedDocument_QNAME);
  }

  private static final ClassPathResource CPR_AWARDEDNOTIFICATION = _getCPR ("UBL-AwardedNotification-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllAwardedNotificationXSDs ()
  {
    return _getAllXSDs (CPR_AWARDEDNOTIFICATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <AwardedNotificationType> awardedNotification ()
  {
    return new UBL23JAXBMarshaller <> (AwardedNotificationType.class,
                                       getAllAwardedNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.awardednotification_23.ObjectFactory._AwardedNotification_QNAME);
  }

  private static final ClassPathResource CPR_BILLOFLADING = _getCPR ("UBL-BillOfLading-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBillOfLadingXSDs ()
  {
    return _getAllXSDs (CPR_BILLOFLADING);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <BillOfLadingType> billOfLading ()
  {
    return new UBL23JAXBMarshaller <> (BillOfLadingType.class,
                                       getAllBillOfLadingXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.billoflading_23.ObjectFactory._BillOfLading_QNAME);
  }

  private static final ClassPathResource CPR_BUSINESSCARD = _getCPR ("UBL-BusinessCard-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBusinessCardXSDs ()
  {
    return _getAllXSDs (CPR_BUSINESSCARD);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <BusinessCardType> businessCard ()
  {
    return new UBL23JAXBMarshaller <> (BusinessCardType.class,
                                       getAllBusinessCardXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.businesscard_23.ObjectFactory._BusinessCard_QNAME);
  }

  private static final ClassPathResource CPR_CALLFORTENDERS = _getCPR ("UBL-CallForTenders-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCallForTendersXSDs ()
  {
    return _getAllXSDs (CPR_CALLFORTENDERS);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CallForTendersType> callForTenders ()
  {
    return new UBL23JAXBMarshaller <> (CallForTendersType.class,
                                       getAllCallForTendersXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.callfortenders_23.ObjectFactory._CallForTenders_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUE = _getCPR ("UBL-Catalogue-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CatalogueType> catalogue ()
  {
    return new UBL23JAXBMarshaller <> (CatalogueType.class,
                                       getAllCatalogueXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogue_23.ObjectFactory._Catalogue_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEDELETION = _getCPR ("UBL-CatalogueDeletion-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueDeletionXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEDELETION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CatalogueDeletionType> catalogueDeletion ()
  {
    return new UBL23JAXBMarshaller <> (CatalogueDeletionType.class,
                                       getAllCatalogueDeletionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguedeletion_23.ObjectFactory._CatalogueDeletion_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEITEMSPECIFICATIONUPDATE = _getCPR ("UBL-CatalogueItemSpecificationUpdate-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueItemSpecificationUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEITEMSPECIFICATIONUPDATE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return new UBL23JAXBMarshaller <> (CatalogueItemSpecificationUpdateType.class,
                                       getAllCatalogueItemSpecificationUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_23.ObjectFactory._CatalogueItemSpecificationUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEPRICINGUPDATE = _getCPR ("UBL-CataloguePricingUpdate-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCataloguePricingUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEPRICINGUPDATE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return new UBL23JAXBMarshaller <> (CataloguePricingUpdateType.class,
                                       getAllCataloguePricingUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_23.ObjectFactory._CataloguePricingUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEREQUEST = _getCPR ("UBL-CatalogueRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueRequestXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CatalogueRequestType> catalogueRequest ()
  {
    return new UBL23JAXBMarshaller <> (CatalogueRequestType.class,
                                       getAllCatalogueRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguerequest_23.ObjectFactory._CatalogueRequest_QNAME);
  }

  private static final ClassPathResource CPR_CERTIFICATEOFORIGIN = _getCPR ("UBL-CertificateOfOrigin-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCertificateOfOriginXSDs ()
  {
    return _getAllXSDs (CPR_CERTIFICATEOFORIGIN);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CertificateOfOriginType> certificateOfOrigin ()
  {
    return new UBL23JAXBMarshaller <> (CertificateOfOriginType.class,
                                       getAllCertificateOfOriginXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.certificateoforigin_23.ObjectFactory._CertificateOfOrigin_QNAME);
  }

  private static final ClassPathResource CPR_COMMONTRANSPORTATIONREPORT = _getCPR ("UBL-CommonTransportationReport-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCommonTransportationReportXSDs ()
  {
    return _getAllXSDs (CPR_COMMONTRANSPORTATIONREPORT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CommonTransportationReportType> commonTransportationReport ()
  {
    return new UBL23JAXBMarshaller <> (CommonTransportationReportType.class,
                                       getAllCommonTransportationReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.commontransportationreport_23.ObjectFactory._CommonTransportationReport_QNAME);
  }

  private static final ClassPathResource CPR_CONTRACTAWARDNOTICE = _getCPR ("UBL-ContractAwardNotice-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllContractAwardNoticeXSDs ()
  {
    return _getAllXSDs (CPR_CONTRACTAWARDNOTICE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ContractAwardNoticeType> contractAwardNotice ()
  {
    return new UBL23JAXBMarshaller <> (ContractAwardNoticeType.class,
                                       getAllContractAwardNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ObjectFactory._ContractAwardNotice_QNAME);
  }

  private static final ClassPathResource CPR_CONTRACTNOTICE = _getCPR ("UBL-ContractNotice-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllContractNoticeXSDs ()
  {
    return _getAllXSDs (CPR_CONTRACTNOTICE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ContractNoticeType> contractNotice ()
  {
    return new UBL23JAXBMarshaller <> (ContractNoticeType.class,
                                       getAllContractNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.contractnotice_23.ObjectFactory._ContractNotice_QNAME);
  }

  private static final ClassPathResource CPR_CREDITNOTE = _getCPR ("UBL-CreditNote-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_CREDITNOTE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new UBL23JAXBMarshaller <> (CreditNoteType.class,
                                       getAllCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_23.ObjectFactory._CreditNote_QNAME);
  }

  private static final ClassPathResource CPR_DEBITNOTE = _getCPR ("UBL-DebitNote-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDebitNoteXSDs ()
  {
    return _getAllXSDs (CPR_DEBITNOTE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new UBL23JAXBMarshaller <> (DebitNoteType.class,
                                       getAllDebitNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.debitnote_23.ObjectFactory._DebitNote_QNAME);
  }

  private static final ClassPathResource CPR_DESPATCHADVICE = _getCPR ("UBL-DespatchAdvice-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDespatchAdviceXSDs ()
  {
    return _getAllXSDs (CPR_DESPATCHADVICE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DespatchAdviceType> despatchAdvice ()
  {
    return new UBL23JAXBMarshaller <> (DespatchAdviceType.class,
                                       getAllDespatchAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.despatchadvice_23.ObjectFactory._DespatchAdvice_QNAME);
  }

  private static final ClassPathResource CPR_DIGITALAGREEMENT = _getCPR ("UBL-DigitalAgreement-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDigitalAgreementXSDs ()
  {
    return _getAllXSDs (CPR_DIGITALAGREEMENT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DigitalAgreementType> digitalAgreement ()
  {
    return new UBL23JAXBMarshaller <> (DigitalAgreementType.class,
                                       getAllDigitalAgreementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.digitalagreement_23.ObjectFactory._DigitalAgreement_QNAME);
  }

  private static final ClassPathResource CPR_DIGITALCAPABILITY = _getCPR ("UBL-DigitalCapability-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDigitalCapabilityXSDs ()
  {
    return _getAllXSDs (CPR_DIGITALCAPABILITY);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DigitalCapabilityType> digitalCapability ()
  {
    return new UBL23JAXBMarshaller <> (DigitalCapabilityType.class,
                                       getAllDigitalCapabilityXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.digitalcapability_23.ObjectFactory._DigitalCapability_QNAME);
  }

  private static final ClassPathResource CPR_DOCUMENTSTATUS = _getCPR ("UBL-DocumentStatus-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDocumentStatusXSDs ()
  {
    return _getAllXSDs (CPR_DOCUMENTSTATUS);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DocumentStatusType> documentStatus ()
  {
    return new UBL23JAXBMarshaller <> (DocumentStatusType.class,
                                       getAllDocumentStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.documentstatus_23.ObjectFactory._DocumentStatus_QNAME);
  }

  private static final ClassPathResource CPR_DOCUMENTSTATUSREQUEST = _getCPR ("UBL-DocumentStatusRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDocumentStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_DOCUMENTSTATUSREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DocumentStatusRequestType> documentStatusRequest ()
  {
    return new UBL23JAXBMarshaller <> (DocumentStatusRequestType.class,
                                       getAllDocumentStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.documentstatusrequest_23.ObjectFactory._DocumentStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_ENQUIRY = _getCPR ("UBL-Enquiry-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllEnquiryXSDs ()
  {
    return _getAllXSDs (CPR_ENQUIRY);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <EnquiryType> enquiry ()
  {
    return new UBL23JAXBMarshaller <> (EnquiryType.class,
                                       getAllEnquiryXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.enquiry_23.ObjectFactory._Enquiry_QNAME);
  }

  private static final ClassPathResource CPR_ENQUIRYRESPONSE = _getCPR ("UBL-EnquiryResponse-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllEnquiryResponseXSDs ()
  {
    return _getAllXSDs (CPR_ENQUIRYRESPONSE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <EnquiryResponseType> enquiryResponse ()
  {
    return new UBL23JAXBMarshaller <> (EnquiryResponseType.class,
                                       getAllEnquiryResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.enquiryresponse_23.ObjectFactory._EnquiryResponse_QNAME);
  }

  private static final ClassPathResource CPR_EXCEPTIONCRITERIA = _getCPR ("UBL-ExceptionCriteria-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExceptionCriteriaXSDs ()
  {
    return _getAllXSDs (CPR_EXCEPTIONCRITERIA);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ExceptionCriteriaType> exceptionCriteria ()
  {
    return new UBL23JAXBMarshaller <> (ExceptionCriteriaType.class,
                                       getAllExceptionCriteriaXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exceptioncriteria_23.ObjectFactory._ExceptionCriteria_QNAME);
  }

  private static final ClassPathResource CPR_EXCEPTIONNOTIFICATION = _getCPR ("UBL-ExceptionNotification-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExceptionNotificationXSDs ()
  {
    return _getAllXSDs (CPR_EXCEPTIONNOTIFICATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ExceptionNotificationType> exceptionNotification ()
  {
    return new UBL23JAXBMarshaller <> (ExceptionNotificationType.class,
                                       getAllExceptionNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exceptionnotification_23.ObjectFactory._ExceptionNotification_QNAME);
  }

  private static final ClassPathResource CPR_EXPORTCUSTOMSDECLARATION = _getCPR ("UBL-ExportCustomsDeclaration-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExportCustomsDeclarationXSDs ()
  {
    return _getAllXSDs (CPR_EXPORTCUSTOMSDECLARATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ExportCustomsDeclarationType> exportCustomsDeclaration ()
  {
    return new UBL23JAXBMarshaller <> (ExportCustomsDeclarationType.class,
                                       getAllExportCustomsDeclarationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_23.ObjectFactory._ExportCustomsDeclaration_QNAME);
  }

  private static final ClassPathResource CPR_EXPRESSIONOFINTERESTREQUEST = _getCPR ("UBL-ExpressionOfInterestRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExpressionOfInterestRequestXSDs ()
  {
    return _getAllXSDs (CPR_EXPRESSIONOFINTERESTREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ExpressionOfInterestRequestType> expressionOfInterestRequest ()
  {
    return new UBL23JAXBMarshaller <> (ExpressionOfInterestRequestType.class,
                                       getAllExpressionOfInterestRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_23.ObjectFactory._ExpressionOfInterestRequest_QNAME);
  }

  private static final ClassPathResource CPR_EXPRESSIONOFINTERESTRESPONSE = _getCPR ("UBL-ExpressionOfInterestResponse-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExpressionOfInterestResponseXSDs ()
  {
    return _getAllXSDs (CPR_EXPRESSIONOFINTERESTRESPONSE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ExpressionOfInterestResponseType> expressionOfInterestResponse ()
  {
    return new UBL23JAXBMarshaller <> (ExpressionOfInterestResponseType.class,
                                       getAllExpressionOfInterestResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_23.ObjectFactory._ExpressionOfInterestResponse_QNAME);
  }

  private static final ClassPathResource CPR_FORECAST = _getCPR ("UBL-Forecast-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForecastXSDs ()
  {
    return _getAllXSDs (CPR_FORECAST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ForecastType> forecast ()
  {
    return new UBL23JAXBMarshaller <> (ForecastType.class,
                                       getAllForecastXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forecast_23.ObjectFactory._Forecast_QNAME);
  }

  private static final ClassPathResource CPR_FORECASTREVISION = _getCPR ("UBL-ForecastRevision-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForecastRevisionXSDs ()
  {
    return _getAllXSDs (CPR_FORECASTREVISION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ForecastRevisionType> forecastRevision ()
  {
    return new UBL23JAXBMarshaller <> (ForecastRevisionType.class,
                                       getAllForecastRevisionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forecastrevision_23.ObjectFactory._ForecastRevision_QNAME);
  }

  private static final ClassPathResource CPR_FORWARDINGINSTRUCTIONS = _getCPR ("UBL-ForwardingInstructions-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForwardingInstructionsXSDs ()
  {
    return _getAllXSDs (CPR_FORWARDINGINSTRUCTIONS);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ForwardingInstructionsType> forwardingInstructions ()
  {
    return new UBL23JAXBMarshaller <> (ForwardingInstructionsType.class,
                                       getAllForwardingInstructionsXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forwardinginstructions_23.ObjectFactory._ForwardingInstructions_QNAME);
  }

  private static final ClassPathResource CPR_FREIGHTINVOICE = _getCPR ("UBL-FreightInvoice-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllFreightInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_FREIGHTINVOICE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <FreightInvoiceType> freightInvoice ()
  {
    return new UBL23JAXBMarshaller <> (FreightInvoiceType.class,
                                       getAllFreightInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.freightinvoice_23.ObjectFactory._FreightInvoice_QNAME);
  }

  private static final ClassPathResource CPR_FULFILMENTCANCELLATION = _getCPR ("UBL-FulfilmentCancellation-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllFulfilmentCancellationXSDs ()
  {
    return _getAllXSDs (CPR_FULFILMENTCANCELLATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return new UBL23JAXBMarshaller <> (FulfilmentCancellationType.class,
                                       getAllFulfilmentCancellationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_23.ObjectFactory._FulfilmentCancellation_QNAME);
  }

  private static final ClassPathResource CPR_GOODSCERTIFICATE = _getCPR ("UBL-GoodsCertificate-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGoodsCertificateXSDs ()
  {
    return _getAllXSDs (CPR_GOODSCERTIFICATE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <GoodsCertificateType> goodsCertificate ()
  {
    return new UBL23JAXBMarshaller <> (GoodsCertificateType.class,
                                       getAllGoodsCertificateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.goodscertificate_23.ObjectFactory._GoodsCertificate_QNAME);
  }

  private static final ClassPathResource CPR_GOODSITEMITINERARY = _getCPR ("UBL-GoodsItemItinerary-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGoodsItemItineraryXSDs ()
  {
    return _getAllXSDs (CPR_GOODSITEMITINERARY);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return new UBL23JAXBMarshaller <> (GoodsItemItineraryType.class,
                                       getAllGoodsItemItineraryXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_23.ObjectFactory._GoodsItemItinerary_QNAME);
  }

  private static final ClassPathResource CPR_GOODSITEMPASSPORT = _getCPR ("UBL-GoodsItemPassport-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGoodsItemPassportXSDs ()
  {
    return _getAllXSDs (CPR_GOODSITEMPASSPORT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <GoodsItemPassportType> goodsItemPassport ()
  {
    return new UBL23JAXBMarshaller <> (GoodsItemPassportType.class,
                                       getAllGoodsItemPassportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.goodsitempassport_23.ObjectFactory._GoodsItemPassport_QNAME);
  }

  private static final ClassPathResource CPR_GUARANTEECERTIFICATE = _getCPR ("UBL-GuaranteeCertificate-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGuaranteeCertificateXSDs ()
  {
    return _getAllXSDs (CPR_GUARANTEECERTIFICATE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return new UBL23JAXBMarshaller <> (GuaranteeCertificateType.class,
                                       getAllGuaranteeCertificateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.guaranteecertificate_23.ObjectFactory._GuaranteeCertificate_QNAME);
  }

  private static final ClassPathResource CPR_IMPORTCUSTOMSDECLARATION = _getCPR ("UBL-ImportCustomsDeclaration-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllImportCustomsDeclarationXSDs ()
  {
    return _getAllXSDs (CPR_IMPORTCUSTOMSDECLARATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ImportCustomsDeclarationType> importCustomsDeclaration ()
  {
    return new UBL23JAXBMarshaller <> (ImportCustomsDeclarationType.class,
                                       getAllImportCustomsDeclarationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_23.ObjectFactory._ImportCustomsDeclaration_QNAME);
  }

  private static final ClassPathResource CPR_INSTRUCTIONFORRETURNS = _getCPR ("UBL-InstructionForReturns-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInstructionForReturnsXSDs ()
  {
    return _getAllXSDs (CPR_INSTRUCTIONFORRETURNS);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <InstructionForReturnsType> instructionForReturns ()
  {
    return new UBL23JAXBMarshaller <> (InstructionForReturnsType.class,
                                       getAllInstructionForReturnsXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.instructionforreturns_23.ObjectFactory._InstructionForReturns_QNAME);
  }

  private static final ClassPathResource CPR_INVENTORYREPORT = _getCPR ("UBL-InventoryReport-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInventoryReportXSDs ()
  {
    return _getAllXSDs (CPR_INVENTORYREPORT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <InventoryReportType> inventoryReport ()
  {
    return new UBL23JAXBMarshaller <> (InventoryReportType.class,
                                       getAllInventoryReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.inventoryreport_23.ObjectFactory._InventoryReport_QNAME);
  }

  private static final ClassPathResource CPR_INVOICE = _getCPR ("UBL-Invoice-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_INVOICE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <InvoiceType> invoice ()
  {
    return new UBL23JAXBMarshaller <> (InvoiceType.class,
                                       getAllInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.invoice_23.ObjectFactory._Invoice_QNAME);
  }

  private static final ClassPathResource CPR_ITEMINFORMATIONREQUEST = _getCPR ("UBL-ItemInformationRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllItemInformationRequestXSDs ()
  {
    return _getAllXSDs (CPR_ITEMINFORMATIONREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ItemInformationRequestType> itemInformationRequest ()
  {
    return new UBL23JAXBMarshaller <> (ItemInformationRequestType.class,
                                       getAllItemInformationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.iteminformationrequest_23.ObjectFactory._ItemInformationRequest_QNAME);
  }

  private static final ClassPathResource CPR_MANIFEST = _getCPR ("UBL-Manifest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllManifestXSDs ()
  {
    return _getAllXSDs (CPR_MANIFEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ManifestType> manifest ()
  {
    return new UBL23JAXBMarshaller <> (ManifestType.class,
                                       getAllManifestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.manifest_23.ObjectFactory._Manifest_QNAME);
  }

  private static final ClassPathResource CPR_ORDER = _getCPR ("UBL-Order-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderXSDs ()
  {
    return _getAllXSDs (CPR_ORDER);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <OrderType> order ()
  {
    return new UBL23JAXBMarshaller <> (OrderType.class,
                                       getAllOrderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.order_23.ObjectFactory._Order_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCANCELLATION = _getCPR ("UBL-OrderCancellation-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderCancellationXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCANCELLATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <OrderCancellationType> orderCancellation ()
  {
    return new UBL23JAXBMarshaller <> (OrderCancellationType.class,
                                       getAllOrderCancellationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.ordercancellation_23.ObjectFactory._OrderCancellation_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCHANGE = _getCPR ("UBL-OrderChange-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderChangeXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCHANGE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <OrderChangeType> orderChange ()
  {
    return new UBL23JAXBMarshaller <> (OrderChangeType.class,
                                       getAllOrderChangeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderchange_23.ObjectFactory._OrderChange_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSE = _getCPR ("UBL-OrderResponse-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <OrderResponseType> orderResponse ()
  {
    return new UBL23JAXBMarshaller <> (OrderResponseType.class,
                                       getAllOrderResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponse_23.ObjectFactory._OrderResponse_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSESIMPLE = _getCPR ("UBL-OrderResponseSimple-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseSimpleXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSESIMPLE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <OrderResponseSimpleType> orderResponseSimple ()
  {
    return new UBL23JAXBMarshaller <> (OrderResponseSimpleType.class,
                                       getAllOrderResponseSimpleXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponsesimple_23.ObjectFactory._OrderResponseSimple_QNAME);
  }

  private static final ClassPathResource CPR_PACKINGLIST = _getCPR ("UBL-PackingList-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPackingListXSDs ()
  {
    return _getAllXSDs (CPR_PACKINGLIST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <PackingListType> packingList ()
  {
    return new UBL23JAXBMarshaller <> (PackingListType.class,
                                       getAllPackingListXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.packinglist_23.ObjectFactory._PackingList_QNAME);
  }

  private static final ClassPathResource CPR_PRIORINFORMATIONNOTICE = _getCPR ("UBL-PriorInformationNotice-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPriorInformationNoticeXSDs ()
  {
    return _getAllXSDs (CPR_PRIORINFORMATIONNOTICE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <PriorInformationNoticeType> priorInformationNotice ()
  {
    return new UBL23JAXBMarshaller <> (PriorInformationNoticeType.class,
                                       getAllPriorInformationNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.ObjectFactory._PriorInformationNotice_QNAME);
  }

  private static final ClassPathResource CPR_PRODUCTACTIVITY = _getCPR ("UBL-ProductActivity-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProductActivityXSDs ()
  {
    return _getAllXSDs (CPR_PRODUCTACTIVITY);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ProductActivityType> productActivity ()
  {
    return new UBL23JAXBMarshaller <> (ProductActivityType.class,
                                       getAllProductActivityXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.productactivity_23.ObjectFactory._ProductActivity_QNAME);
  }

  private static final ClassPathResource CPR_PROOFOFREEXPORTATION = _getCPR ("UBL-ProofOfReexportation-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProofOfReexportationXSDs ()
  {
    return _getAllXSDs (CPR_PROOFOFREEXPORTATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ProofOfReexportationType> proofOfReexportation ()
  {
    return new UBL23JAXBMarshaller <> (ProofOfReexportationType.class,
                                       getAllProofOfReexportationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportation_23.ObjectFactory._ProofOfReexportation_QNAME);
  }

  private static final ClassPathResource CPR_PROOFOFREEXPORTATIONREMINDER = _getCPR ("UBL-ProofOfReexportationReminder-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProofOfReexportationReminderXSDs ()
  {
    return _getAllXSDs (CPR_PROOFOFREEXPORTATIONREMINDER);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ProofOfReexportationReminderType> proofOfReexportationReminder ()
  {
    return new UBL23JAXBMarshaller <> (ProofOfReexportationReminderType.class,
                                       getAllProofOfReexportationReminderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_23.ObjectFactory._ProofOfReexportationReminder_QNAME);
  }

  private static final ClassPathResource CPR_PROOFOFREEXPORTATIONREQUEST = _getCPR ("UBL-ProofOfReexportationRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProofOfReexportationRequestXSDs ()
  {
    return _getAllXSDs (CPR_PROOFOFREEXPORTATIONREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ProofOfReexportationRequestType> proofOfReexportationRequest ()
  {
    return new UBL23JAXBMarshaller <> (ProofOfReexportationRequestType.class,
                                       getAllProofOfReexportationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_23.ObjectFactory._ProofOfReexportationRequest_QNAME);
  }

  private static final ClassPathResource CPR_QUALIFICATIONAPPLICATIONREQUEST = _getCPR ("UBL-QualificationApplicationRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQualificationApplicationRequestXSDs ()
  {
    return _getAllXSDs (CPR_QUALIFICATIONAPPLICATIONREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <QualificationApplicationRequestType> qualificationApplicationRequest ()
  {
    return new UBL23JAXBMarshaller <> (QualificationApplicationRequestType.class,
                                       getAllQualificationApplicationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_23.ObjectFactory._QualificationApplicationRequest_QNAME);
  }

  private static final ClassPathResource CPR_QUALIFICATIONAPPLICATIONRESPONSE = _getCPR ("UBL-QualificationApplicationResponse-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQualificationApplicationResponseXSDs ()
  {
    return _getAllXSDs (CPR_QUALIFICATIONAPPLICATIONRESPONSE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <QualificationApplicationResponseType> qualificationApplicationResponse ()
  {
    return new UBL23JAXBMarshaller <> (QualificationApplicationResponseType.class,
                                       getAllQualificationApplicationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_23.ObjectFactory._QualificationApplicationResponse_QNAME);
  }

  private static final ClassPathResource CPR_QUOTATION = _getCPR ("UBL-Quotation-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQuotationXSDs ()
  {
    return _getAllXSDs (CPR_QUOTATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <QuotationType> quotation ()
  {
    return new UBL23JAXBMarshaller <> (QuotationType.class,
                                       getAllQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.quotation_23.ObjectFactory._Quotation_QNAME);
  }

  private static final ClassPathResource CPR_RECEIPTADVICE = _getCPR ("UBL-ReceiptAdvice-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReceiptAdviceXSDs ()
  {
    return _getAllXSDs (CPR_RECEIPTADVICE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ReceiptAdviceType> receiptAdvice ()
  {
    return new UBL23JAXBMarshaller <> (ReceiptAdviceType.class,
                                       getAllReceiptAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.receiptadvice_23.ObjectFactory._ReceiptAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REMINDER = _getCPR ("UBL-Reminder-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReminderXSDs ()
  {
    return _getAllXSDs (CPR_REMINDER);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ReminderType> reminder ()
  {
    return new UBL23JAXBMarshaller <> (ReminderType.class,
                                       getAllReminderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.reminder_23.ObjectFactory._Reminder_QNAME);
  }

  private static final ClassPathResource CPR_REMITTANCEADVICE = _getCPR ("UBL-RemittanceAdvice-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRemittanceAdviceXSDs ()
  {
    return _getAllXSDs (CPR_REMITTANCEADVICE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <RemittanceAdviceType> remittanceAdvice ()
  {
    return new UBL23JAXBMarshaller <> (RemittanceAdviceType.class,
                                       getAllRemittanceAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.remittanceadvice_23.ObjectFactory._RemittanceAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REQUESTFORQUOTATION = _getCPR ("UBL-RequestForQuotation-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRequestForQuotationXSDs ()
  {
    return _getAllXSDs (CPR_REQUESTFORQUOTATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <RequestForQuotationType> requestForQuotation ()
  {
    return new UBL23JAXBMarshaller <> (RequestForQuotationType.class,
                                       getAllRequestForQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.requestforquotation_23.ObjectFactory._RequestForQuotation_QNAME);
  }

  private static final ClassPathResource CPR_RETAILEVENT = _getCPR ("UBL-RetailEvent-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRetailEventXSDs ()
  {
    return _getAllXSDs (CPR_RETAILEVENT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <RetailEventType> retailEvent ()
  {
    return new UBL23JAXBMarshaller <> (RetailEventType.class,
                                       getAllRetailEventXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.retailevent_23.ObjectFactory._RetailEvent_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDCREDITNOTE = _getCPR ("UBL-SelfBilledCreditNote-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDCREDITNOTE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return new UBL23JAXBMarshaller <> (SelfBilledCreditNoteType.class,
                                       getAllSelfBilledCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_23.ObjectFactory._SelfBilledCreditNote_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDINVOICE = _getCPR ("UBL-SelfBilledInvoice-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDINVOICE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return new UBL23JAXBMarshaller <> (SelfBilledInvoiceType.class,
                                       getAllSelfBilledInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_23.ObjectFactory._SelfBilledInvoice_QNAME);
  }

  private static final ClassPathResource CPR_STATEMENT = _getCPR ("UBL-Statement-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllStatementXSDs ()
  {
    return _getAllXSDs (CPR_STATEMENT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <StatementType> statement ()
  {
    return new UBL23JAXBMarshaller <> (StatementType.class,
                                       getAllStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.statement_23.ObjectFactory._Statement_QNAME);
  }

  private static final ClassPathResource CPR_STOCKAVAILABILITYREPORT = _getCPR ("UBL-StockAvailabilityReport-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllStockAvailabilityReportXSDs ()
  {
    return _getAllXSDs (CPR_STOCKAVAILABILITYREPORT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return new UBL23JAXBMarshaller <> (StockAvailabilityReportType.class,
                                       getAllStockAvailabilityReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_23.ObjectFactory._StockAvailabilityReport_QNAME);
  }

  private static final ClassPathResource CPR_TENDER = _getCPR ("UBL-Tender-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderXSDs ()
  {
    return _getAllXSDs (CPR_TENDER);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderType> tender ()
  {
    return new UBL23JAXBMarshaller <> (TenderType.class,
                                       getAllTenderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tender_23.ObjectFactory._Tender_QNAME);
  }

  private static final ClassPathResource CPR_TENDERCONTRACT = _getCPR ("UBL-TenderContract-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderContractXSDs ()
  {
    return _getAllXSDs (CPR_TENDERCONTRACT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderContractType> tenderContract ()
  {
    return new UBL23JAXBMarshaller <> (TenderContractType.class,
                                       getAllTenderContractXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendercontract_23.ObjectFactory._TenderContract_QNAME);
  }

  private static final ClassPathResource CPR_TENDERERQUALIFICATION = _getCPR ("UBL-TendererQualification-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTendererQualificationXSDs ()
  {
    return _getAllXSDs (CPR_TENDERERQUALIFICATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TendererQualificationType> tendererQualification ()
  {
    return new UBL23JAXBMarshaller <> (TendererQualificationType.class,
                                       getAllTendererQualificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualification_23.ObjectFactory._TendererQualification_QNAME);
  }

  private static final ClassPathResource CPR_TENDERERQUALIFICATIONRESPONSE = _getCPR ("UBL-TendererQualificationResponse-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTendererQualificationResponseXSDs ()
  {
    return _getAllXSDs (CPR_TENDERERQUALIFICATIONRESPONSE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return new UBL23JAXBMarshaller <> (TendererQualificationResponseType.class,
                                       getAllTendererQualificationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_23.ObjectFactory._TendererQualificationResponse_QNAME);
  }

  private static final ClassPathResource CPR_TENDERRECEIPT = _getCPR ("UBL-TenderReceipt-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderReceiptXSDs ()
  {
    return _getAllXSDs (CPR_TENDERRECEIPT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderReceiptType> tenderReceipt ()
  {
    return new UBL23JAXBMarshaller <> (TenderReceiptType.class,
                                       getAllTenderReceiptXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderreceipt_23.ObjectFactory._TenderReceipt_QNAME);
  }

  private static final ClassPathResource CPR_TENDERSTATUS = _getCPR ("UBL-TenderStatus-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderStatusXSDs ()
  {
    return _getAllXSDs (CPR_TENDERSTATUS);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderStatusType> tenderStatus ()
  {
    return new UBL23JAXBMarshaller <> (TenderStatusType.class,
                                       getAllTenderStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatus_23.ObjectFactory._TenderStatus_QNAME);
  }

  private static final ClassPathResource CPR_TENDERSTATUSREQUEST = _getCPR ("UBL-TenderStatusRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TENDERSTATUSREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderStatusRequestType> tenderStatusRequest ()
  {
    return new UBL23JAXBMarshaller <> (TenderStatusRequestType.class,
                                       getAllTenderStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_23.ObjectFactory._TenderStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TENDERWITHDRAWAL = _getCPR ("UBL-TenderWithdrawal-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderWithdrawalXSDs ()
  {
    return _getAllXSDs (CPR_TENDERWITHDRAWAL);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderWithdrawalType> tenderWithdrawal ()
  {
    return new UBL23JAXBMarshaller <> (TenderWithdrawalType.class,
                                       getAllTenderWithdrawalXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_23.ObjectFactory._TenderWithdrawal_QNAME);
  }

  private static final ClassPathResource CPR_TRADEITEMLOCATIONPROFILE = _getCPR ("UBL-TradeItemLocationProfile-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTradeItemLocationProfileXSDs ()
  {
    return _getAllXSDs (CPR_TRADEITEMLOCATIONPROFILE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return new UBL23JAXBMarshaller <> (TradeItemLocationProfileType.class,
                                       getAllTradeItemLocationProfileXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_23.ObjectFactory._TradeItemLocationProfile_QNAME);
  }

  private static final ClassPathResource CPR_TRANSITCUSTOMSDECLARATION = _getCPR ("UBL-TransitCustomsDeclaration-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransitCustomsDeclarationXSDs ()
  {
    return _getAllXSDs (CPR_TRANSITCUSTOMSDECLARATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransitCustomsDeclarationType> transitCustomsDeclaration ()
  {
    return new UBL23JAXBMarshaller <> (TransitCustomsDeclarationType.class,
                                       getAllTransitCustomsDeclarationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_23.ObjectFactory._TransitCustomsDeclaration_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTATIONSTATUS = _getCPR ("UBL-TransportationStatus-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportationStatusXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTATIONSTATUS);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportationStatusType> transportationStatus ()
  {
    return new UBL23JAXBMarshaller <> (TransportationStatusType.class,
                                       getAllTransportationStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatus_23.ObjectFactory._TransportationStatus_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTATIONSTATUSREQUEST = _getCPR ("UBL-TransportationStatusRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportationStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTATIONSTATUSREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return new UBL23JAXBMarshaller <> (TransportationStatusRequestType.class,
                                       getAllTransportationStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_23.ObjectFactory._TransportationStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTEXECUTIONPLAN = _getCPR ("UBL-TransportExecutionPlan-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportExecutionPlanXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTEXECUTIONPLAN);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return new UBL23JAXBMarshaller <> (TransportExecutionPlanType.class,
                                       getAllTransportExecutionPlanXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplan_23.ObjectFactory._TransportExecutionPlan_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTEXECUTIONPLANREQUEST = _getCPR ("UBL-TransportExecutionPlanRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportExecutionPlanRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTEXECUTIONPLANREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return new UBL23JAXBMarshaller <> (TransportExecutionPlanRequestType.class,
                                       getAllTransportExecutionPlanRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_23.ObjectFactory._TransportExecutionPlanRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTPROGRESSSTATUS = _getCPR ("UBL-TransportProgressStatus-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportProgressStatusXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTPROGRESSSTATUS);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportProgressStatusType> transportProgressStatus ()
  {
    return new UBL23JAXBMarshaller <> (TransportProgressStatusType.class,
                                       getAllTransportProgressStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatus_23.ObjectFactory._TransportProgressStatus_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTPROGRESSSTATUSREQUEST = _getCPR ("UBL-TransportProgressStatusRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportProgressStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTPROGRESSSTATUSREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return new UBL23JAXBMarshaller <> (TransportProgressStatusRequestType.class,
                                       getAllTransportProgressStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_23.ObjectFactory._TransportProgressStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTSERVICEDESCRIPTION = _getCPR ("UBL-TransportServiceDescription-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportServiceDescriptionXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTSERVICEDESCRIPTION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return new UBL23JAXBMarshaller <> (TransportServiceDescriptionType.class,
                                       getAllTransportServiceDescriptionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescription_23.ObjectFactory._TransportServiceDescription_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTSERVICEDESCRIPTIONREQUEST = _getCPR ("UBL-TransportServiceDescriptionRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportServiceDescriptionRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTSERVICEDESCRIPTIONREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return new UBL23JAXBMarshaller <> (TransportServiceDescriptionRequestType.class,
                                       getAllTransportServiceDescriptionRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_23.ObjectFactory._TransportServiceDescriptionRequest_QNAME);
  }

  private static final ClassPathResource CPR_UNAWARDEDNOTIFICATION = _getCPR ("UBL-UnawardedNotification-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnawardedNotificationXSDs ()
  {
    return _getAllXSDs (CPR_UNAWARDEDNOTIFICATION);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <UnawardedNotificationType> unawardedNotification ()
  {
    return new UBL23JAXBMarshaller <> (UnawardedNotificationType.class,
                                       getAllUnawardedNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unawardednotification_23.ObjectFactory._UnawardedNotification_QNAME);
  }

  private static final ClassPathResource CPR_UNSUBSCRIBEFROMPROCEDUREREQUEST = _getCPR ("UBL-UnsubscribeFromProcedureRequest-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnsubscribeFromProcedureRequestXSDs ()
  {
    return _getAllXSDs (CPR_UNSUBSCRIBEFROMPROCEDUREREQUEST);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest ()
  {
    return new UBL23JAXBMarshaller <> (UnsubscribeFromProcedureRequestType.class,
                                       getAllUnsubscribeFromProcedureRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_23.ObjectFactory._UnsubscribeFromProcedureRequest_QNAME);
  }

  private static final ClassPathResource CPR_UNSUBSCRIBEFROMPROCEDURERESPONSE = _getCPR ("UBL-UnsubscribeFromProcedureResponse-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnsubscribeFromProcedureResponseXSDs ()
  {
    return _getAllXSDs (CPR_UNSUBSCRIBEFROMPROCEDURERESPONSE);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse ()
  {
    return new UBL23JAXBMarshaller <> (UnsubscribeFromProcedureResponseType.class,
                                       getAllUnsubscribeFromProcedureResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_23.ObjectFactory._UnsubscribeFromProcedureResponse_QNAME);
  }

  private static final ClassPathResource CPR_UTILITYSTATEMENT = _getCPR ("UBL-UtilityStatement-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUtilityStatementXSDs ()
  {
    return _getAllXSDs (CPR_UTILITYSTATEMENT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <UtilityStatementType> utilityStatement ()
  {
    return new UBL23JAXBMarshaller <> (UtilityStatementType.class,
                                       getAllUtilityStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.utilitystatement_23.ObjectFactory._UtilityStatement_QNAME);
  }

  private static final ClassPathResource CPR_WAYBILL = _getCPR ("UBL-Waybill-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWaybillXSDs ()
  {
    return _getAllXSDs (CPR_WAYBILL);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <WaybillType> waybill ()
  {
    return new UBL23JAXBMarshaller <> (WaybillType.class,
                                       getAllWaybillXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.waybill_23.ObjectFactory._Waybill_QNAME);
  }

  private static final ClassPathResource CPR_WEIGHTSTATEMENT = _getCPR ("UBL-WeightStatement-2.3.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWeightStatementXSDs ()
  {
    return _getAllXSDs (CPR_WEIGHTSTATEMENT);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <WeightStatementType> weightStatement ()
  {
    return new UBL23JAXBMarshaller <> (WeightStatementType.class,
                                       getAllWeightStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.weightstatement_23.ObjectFactory._WeightStatement_QNAME);
  }
}
