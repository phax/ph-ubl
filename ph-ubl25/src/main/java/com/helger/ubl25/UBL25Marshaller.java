/*
 * Copyright (C) 2026 Philip Helger (www.helger.com)
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
package com.helger.ubl25;

import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.collection.commons.CommonsArrayList;
import com.helger.collection.commons.ICommonsList;
import com.helger.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xsds.ccts.cct.schemamodule.CCCTS;
import com.helger.xsds.xades132.CXAdES132;
import com.helger.xsds.xades141.CXAdES141;
import com.helger.xsds.xmldsig.CXMLDSig;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_25.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_25.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.awardednotification_25.AwardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.billoflading_25.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.businesscard_25.BusinessCardType;
import oasis.names.specification.ubl.schema.xsd.businessinformation_25.BusinessInformationType;
import oasis.names.specification.ubl.schema.xsd.callfortenders_25.CallForTendersType;
import oasis.names.specification.ubl.schema.xsd.catalogue_25.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_25.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_25.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_25.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_25.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_25.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.commontransportationreport_25.CommonTransportationReportType;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_25.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_25.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.creditnote_25.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_25.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.deliverynote_25.DeliveryNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_25.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.digitalagreement_25.DigitalAgreementType;
import oasis.names.specification.ubl.schema.xsd.digitalcapability_25.DigitalCapabilityType;
import oasis.names.specification.ubl.schema.xsd.documentstatus_25.DocumentStatusType;
import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_25.DocumentStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.enquiry_25.EnquiryType;
import oasis.names.specification.ubl.schema.xsd.enquiryresponse_25.EnquiryResponseType;
import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_25.ExceptionCriteriaType;
import oasis.names.specification.ubl.schema.xsd.exceptionnotification_25.ExceptionNotificationType;
import oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_25.ExportCustomsDeclarationType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_25.ExpressionOfInterestRequestType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_25.ExpressionOfInterestResponseType;
import oasis.names.specification.ubl.schema.xsd.forecast_25.ForecastType;
import oasis.names.specification.ubl.schema.xsd.forecastrevision_25.ForecastRevisionType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_25.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_25.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_25.FulfilmentCancellationType;
import oasis.names.specification.ubl.schema.xsd.goodscertificate_25.GoodsCertificateType;
import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_25.GoodsItemItineraryType;
import oasis.names.specification.ubl.schema.xsd.goodsitempassport_25.GoodsItemPassportType;
import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_25.GuaranteeCertificateType;
import oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_25.ImportCustomsDeclarationType;
import oasis.names.specification.ubl.schema.xsd.instructionforreturns_25.InstructionForReturnsType;
import oasis.names.specification.ubl.schema.xsd.inventoryreport_25.InventoryReportType;
import oasis.names.specification.ubl.schema.xsd.invoice_25.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.invoicestatusrequest_25.InvoiceStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.invoicestatusresponse_25.InvoiceStatusResponseType;
import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_25.ItemInformationRequestType;
import oasis.names.specification.ubl.schema.xsd.manifest_25.ManifestType;
import oasis.names.specification.ubl.schema.xsd.order_25.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_25.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_25.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_25.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_25.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_25.PackingListType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_25.PriorInformationNoticeType;
import oasis.names.specification.ubl.schema.xsd.procurementstatus_25.ProcurementStatusType;
import oasis.names.specification.ubl.schema.xsd.procurementstatusrequest_25.ProcurementStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.productactivity_25.ProductActivityType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportation_25.ProofOfReexportationType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_25.ProofOfReexportationReminderType;
import oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_25.ProofOfReexportationRequestType;
import oasis.names.specification.ubl.schema.xsd.purchasereceipt_25.PurchaseReceiptType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_25.QualificationApplicationRequestType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_25.QualificationApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.quotation_25.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_25.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_25.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_25.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_25.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.retailevent_25.RetailEventType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_25.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_25.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_25.StatementType;
import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_25.StockAvailabilityReportType;
import oasis.names.specification.ubl.schema.xsd.tender_25.TenderType;
import oasis.names.specification.ubl.schema.xsd.tendercontract_25.TenderContractType;
import oasis.names.specification.ubl.schema.xsd.tendererqualification_25.TendererQualificationType;
import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_25.TendererQualificationResponseType;
import oasis.names.specification.ubl.schema.xsd.tenderreceipt_25.TenderReceiptType;
import oasis.names.specification.ubl.schema.xsd.tenderstatus_25.TenderStatusType;
import oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_25.TenderStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_25.TenderWithdrawalType;
import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_25.TradeItemLocationProfileType;
import oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_25.TransitCustomsDeclarationType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_25.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_25.TransportationStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_25.TransportExecutionPlanType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_25.TransportExecutionPlanRequestType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_25.TransportProgressStatusType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_25.TransportProgressStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescription_25.TransportServiceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_25.TransportServiceDescriptionRequestType;
import oasis.names.specification.ubl.schema.xsd.unawardednotification_25.UnawardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_25.UnsubscribeFromProcedureRequestType;
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_25.UnsubscribeFromProcedureResponseType;
import oasis.names.specification.ubl.schema.xsd.utilitystatement_25.UtilityStatementType;
import oasis.names.specification.ubl.schema.xsd.wastemovement_25.WasteMovementType;
import oasis.names.specification.ubl.schema.xsd.wastenotification_25.WasteNotificationType;
import oasis.names.specification.ubl.schema.xsd.waybill_25.WaybillType;
import oasis.names.specification.ubl.schema.xsd.weightstatement_25.WeightStatementType;
import oasis.names.specification.ubl.schema.xsd.workreport_25.WorkReportType;

/**
 * The class provides all the UBL 2.5 marshallers for reading, writing and validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class UBL25Marshaller
{
  public static class UBL25JAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    private final QName m_aRootElementQName;

    public UBL25JAXBMarshaller (@NonNull final Class <JAXBTYPE> aType,
                                @NonNull @Nonempty final ICommonsList <ClassPathResource> aXSDs,
                                @NonNull final QName aRootElementQName)
    {
      super (aType, aXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      m_aRootElementQName = aRootElementQName;

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBL25NamespaceContext.getInstance ().getClone ();
      // Avoid overwriting an already mapped context
      if (!aNSContext.isNamespaceURIMapped (aRootElementQName.getNamespaceURI ()))
        aNSContext.addDefaultNamespaceURI (aRootElementQName.getNamespaceURI ());
      setNamespaceContext (aNSContext);
    }

    @NonNull
    public final QName getRootElementQName ()
    {
      return m_aRootElementQName;
    }

    @NonNull
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
                                                                                             CUBL25.XSD_UNQUALIFIED_DATA_TYPES,
                                                                                             CUBL25.XSD_QUALIFIED_DATA_TYPES,
                                                                                             CUBL25.XSD_SIGNATURE_BASIC_COMPONENTS,
                                                                                             CUBL25.XSD_COMMON_BASIC_COMPONENTS,
                                                                                             CUBL25.XSD_SIGNATURE_AGGREGATE_COMPONENTS,
                                                                                             CUBL25.XSD_COMMON_SIGNATURE_COMPONENTS,
                                                                                             CUBL25.XSD_COMMON_EXTENSION_COMPONENTS,
                                                                                             CUBL25.XSD_COMMON_AGGREGATE_COMPONENTS);

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBaseXSDs ()
  {
    return BASE_XSDS.getClone ();
  }

  @NonNull
  @ReturnsMutableCopy
  private static ICommonsList <ClassPathResource> _getAllXSDs (@NonNull final ClassPathResource aXSD)
  {
    final ICommonsList <ClassPathResource> ret = BASE_XSDS.getClone ();
    ret.add (aXSD);
    return ret;
  }

  private UBL25Marshaller ()
  {}

  @NonNull
  private static ClassPathResource _getCPR (@NonNull final String sXSDPath)
  {
    return new ClassPathResource (CUBL25.SCHEMA_DIRECTORY + sXSDPath, CUBL25.getCL ());
  }

  // Automatically created from here on

  private static final ClassPathResource CPR_APPLICATIONRESPONSE = _getCPR ("UBL-ApplicationResponse-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllApplicationResponseXSDs ()
  {
    return _getAllXSDs (CPR_APPLICATIONRESPONSE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new UBL25JAXBMarshaller <> (ApplicationResponseType.class,
                                       getAllApplicationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.applicationresponse_25.ObjectFactory._ApplicationResponse_QNAME);
  }

  private static final ClassPathResource CPR_ATTACHEDDOCUMENT = _getCPR ("UBL-AttachedDocument-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllAttachedDocumentXSDs ()
  {
    return _getAllXSDs (CPR_ATTACHEDDOCUMENT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new UBL25JAXBMarshaller <> (AttachedDocumentType.class,
                                       getAllAttachedDocumentXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.attacheddocument_25.ObjectFactory._AttachedDocument_QNAME);
  }

  private static final ClassPathResource CPR_AWARDEDNOTIFICATION = _getCPR ("UBL-AwardedNotification-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllAwardedNotificationXSDs ()
  {
    return _getAllXSDs (CPR_AWARDEDNOTIFICATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <AwardedNotificationType> awardedNotification ()
  {
    return new UBL25JAXBMarshaller <> (AwardedNotificationType.class,
                                       getAllAwardedNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.awardednotification_25.ObjectFactory._AwardedNotification_QNAME);
  }

  private static final ClassPathResource CPR_BILLOFLADING = _getCPR ("UBL-BillOfLading-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBillOfLadingXSDs ()
  {
    return _getAllXSDs (CPR_BILLOFLADING);
  }

  @NonNull
  public static UBL25JAXBMarshaller <BillOfLadingType> billOfLading ()
  {
    return new UBL25JAXBMarshaller <> (BillOfLadingType.class,
                                       getAllBillOfLadingXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.billoflading_25.ObjectFactory._BillOfLading_QNAME);
  }

  private static final ClassPathResource CPR_BUSINESSCARD = _getCPR ("UBL-BusinessCard-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBusinessCardXSDs ()
  {
    return _getAllXSDs (CPR_BUSINESSCARD);
  }

  @NonNull
  public static UBL25JAXBMarshaller <BusinessCardType> businessCard ()
  {
    return new UBL25JAXBMarshaller <> (BusinessCardType.class,
                                       getAllBusinessCardXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.businesscard_25.ObjectFactory._BusinessCard_QNAME);
  }

  private static final ClassPathResource CPR_BUSINESSINFORMATION = _getCPR ("UBL-BusinessInformation-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBusinessInformationXSDs ()
  {
    return _getAllXSDs (CPR_BUSINESSINFORMATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <BusinessInformationType> businessInformation ()
  {
    return new UBL25JAXBMarshaller <> (BusinessInformationType.class,
                                       getAllBusinessInformationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.businessinformation_25.ObjectFactory._BusinessInformation_QNAME);
  }

  private static final ClassPathResource CPR_CALLFORTENDERS = _getCPR ("UBL-CallForTenders-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCallForTendersXSDs ()
  {
    return _getAllXSDs (CPR_CALLFORTENDERS);
  }

  @NonNull
  public static UBL25JAXBMarshaller <CallForTendersType> callForTenders ()
  {
    return new UBL25JAXBMarshaller <> (CallForTendersType.class,
                                       getAllCallForTendersXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.callfortenders_25.ObjectFactory._CallForTenders_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUE = _getCPR ("UBL-Catalogue-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <CatalogueType> catalogue ()
  {
    return new UBL25JAXBMarshaller <> (CatalogueType.class,
                                       getAllCatalogueXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogue_25.ObjectFactory._Catalogue_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEDELETION = _getCPR ("UBL-CatalogueDeletion-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueDeletionXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEDELETION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <CatalogueDeletionType> catalogueDeletion ()
  {
    return new UBL25JAXBMarshaller <> (CatalogueDeletionType.class,
                                       getAllCatalogueDeletionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguedeletion_25.ObjectFactory._CatalogueDeletion_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEITEMSPECIFICATIONUPDATE = _getCPR ("UBL-CatalogueItemSpecificationUpdate-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueItemSpecificationUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEITEMSPECIFICATIONUPDATE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return new UBL25JAXBMarshaller <> (CatalogueItemSpecificationUpdateType.class,
                                       getAllCatalogueItemSpecificationUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_25.ObjectFactory._CatalogueItemSpecificationUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEPRICINGUPDATE = _getCPR ("UBL-CataloguePricingUpdate-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCataloguePricingUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEPRICINGUPDATE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return new UBL25JAXBMarshaller <> (CataloguePricingUpdateType.class,
                                       getAllCataloguePricingUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_25.ObjectFactory._CataloguePricingUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEREQUEST = _getCPR ("UBL-CatalogueRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueRequestXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <CatalogueRequestType> catalogueRequest ()
  {
    return new UBL25JAXBMarshaller <> (CatalogueRequestType.class,
                                       getAllCatalogueRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguerequest_25.ObjectFactory._CatalogueRequest_QNAME);
  }

  private static final ClassPathResource CPR_CERTIFICATEOFORIGIN = _getCPR ("UBL-CertificateOfOrigin-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCertificateOfOriginXSDs ()
  {
    return _getAllXSDs (CPR_CERTIFICATEOFORIGIN);
  }

  @NonNull
  public static UBL25JAXBMarshaller <CertificateOfOriginType> certificateOfOrigin ()
  {
    return new UBL25JAXBMarshaller <> (CertificateOfOriginType.class,
                                       getAllCertificateOfOriginXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.certificateoforigin_25.ObjectFactory._CertificateOfOrigin_QNAME);
  }

  private static final ClassPathResource CPR_COMMONTRANSPORTATIONREPORT = _getCPR ("UBL-CommonTransportationReport-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCommonTransportationReportXSDs ()
  {
    return _getAllXSDs (CPR_COMMONTRANSPORTATIONREPORT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <CommonTransportationReportType> commonTransportationReport ()
  {
    return new UBL25JAXBMarshaller <> (CommonTransportationReportType.class,
                                       getAllCommonTransportationReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.commontransportationreport_25.ObjectFactory._CommonTransportationReport_QNAME);
  }

  private static final ClassPathResource CPR_CONTRACTAWARDNOTICE = _getCPR ("UBL-ContractAwardNotice-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllContractAwardNoticeXSDs ()
  {
    return _getAllXSDs (CPR_CONTRACTAWARDNOTICE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ContractAwardNoticeType> contractAwardNotice ()
  {
    return new UBL25JAXBMarshaller <> (ContractAwardNoticeType.class,
                                       getAllContractAwardNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.contractawardnotice_25.ObjectFactory._ContractAwardNotice_QNAME);
  }

  private static final ClassPathResource CPR_CONTRACTNOTICE = _getCPR ("UBL-ContractNotice-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllContractNoticeXSDs ()
  {
    return _getAllXSDs (CPR_CONTRACTNOTICE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ContractNoticeType> contractNotice ()
  {
    return new UBL25JAXBMarshaller <> (ContractNoticeType.class,
                                       getAllContractNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.contractnotice_25.ObjectFactory._ContractNotice_QNAME);
  }

  private static final ClassPathResource CPR_CREDITNOTE = _getCPR ("UBL-CreditNote-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_CREDITNOTE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new UBL25JAXBMarshaller <> (CreditNoteType.class,
                                       getAllCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_25.ObjectFactory._CreditNote_QNAME);
  }

  private static final ClassPathResource CPR_DEBITNOTE = _getCPR ("UBL-DebitNote-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDebitNoteXSDs ()
  {
    return _getAllXSDs (CPR_DEBITNOTE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new UBL25JAXBMarshaller <> (DebitNoteType.class,
                                       getAllDebitNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.debitnote_25.ObjectFactory._DebitNote_QNAME);
  }

  private static final ClassPathResource CPR_DELIVERYNOTE = _getCPR ("UBL-DeliveryNote-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDeliveryNoteXSDs ()
  {
    return _getAllXSDs (CPR_DELIVERYNOTE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <DeliveryNoteType> deliveryNote ()
  {
    return new UBL25JAXBMarshaller <> (DeliveryNoteType.class,
                                       getAllDeliveryNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.deliverynote_25.ObjectFactory._DeliveryNote_QNAME);
  }

  private static final ClassPathResource CPR_DESPATCHADVICE = _getCPR ("UBL-DespatchAdvice-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDespatchAdviceXSDs ()
  {
    return _getAllXSDs (CPR_DESPATCHADVICE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <DespatchAdviceType> despatchAdvice ()
  {
    return new UBL25JAXBMarshaller <> (DespatchAdviceType.class,
                                       getAllDespatchAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.despatchadvice_25.ObjectFactory._DespatchAdvice_QNAME);
  }

  private static final ClassPathResource CPR_DIGITALAGREEMENT = _getCPR ("UBL-DigitalAgreement-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDigitalAgreementXSDs ()
  {
    return _getAllXSDs (CPR_DIGITALAGREEMENT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <DigitalAgreementType> digitalAgreement ()
  {
    return new UBL25JAXBMarshaller <> (DigitalAgreementType.class,
                                       getAllDigitalAgreementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.digitalagreement_25.ObjectFactory._DigitalAgreement_QNAME);
  }

  private static final ClassPathResource CPR_DIGITALCAPABILITY = _getCPR ("UBL-DigitalCapability-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDigitalCapabilityXSDs ()
  {
    return _getAllXSDs (CPR_DIGITALCAPABILITY);
  }

  @NonNull
  public static UBL25JAXBMarshaller <DigitalCapabilityType> digitalCapability ()
  {
    return new UBL25JAXBMarshaller <> (DigitalCapabilityType.class,
                                       getAllDigitalCapabilityXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.digitalcapability_25.ObjectFactory._DigitalCapability_QNAME);
  }

  private static final ClassPathResource CPR_DOCUMENTSTATUS = _getCPR ("UBL-DocumentStatus-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDocumentStatusXSDs ()
  {
    return _getAllXSDs (CPR_DOCUMENTSTATUS);
  }

  @NonNull
  public static UBL25JAXBMarshaller <DocumentStatusType> documentStatus ()
  {
    return new UBL25JAXBMarshaller <> (DocumentStatusType.class,
                                       getAllDocumentStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.documentstatus_25.ObjectFactory._DocumentStatus_QNAME);
  }

  private static final ClassPathResource CPR_DOCUMENTSTATUSREQUEST = _getCPR ("UBL-DocumentStatusRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDocumentStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_DOCUMENTSTATUSREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <DocumentStatusRequestType> documentStatusRequest ()
  {
    return new UBL25JAXBMarshaller <> (DocumentStatusRequestType.class,
                                       getAllDocumentStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.documentstatusrequest_25.ObjectFactory._DocumentStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_ENQUIRY = _getCPR ("UBL-Enquiry-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllEnquiryXSDs ()
  {
    return _getAllXSDs (CPR_ENQUIRY);
  }

  @NonNull
  public static UBL25JAXBMarshaller <EnquiryType> enquiry ()
  {
    return new UBL25JAXBMarshaller <> (EnquiryType.class,
                                       getAllEnquiryXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.enquiry_25.ObjectFactory._Enquiry_QNAME);
  }

  private static final ClassPathResource CPR_ENQUIRYRESPONSE = _getCPR ("UBL-EnquiryResponse-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllEnquiryResponseXSDs ()
  {
    return _getAllXSDs (CPR_ENQUIRYRESPONSE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <EnquiryResponseType> enquiryResponse ()
  {
    return new UBL25JAXBMarshaller <> (EnquiryResponseType.class,
                                       getAllEnquiryResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.enquiryresponse_25.ObjectFactory._EnquiryResponse_QNAME);
  }

  private static final ClassPathResource CPR_EXCEPTIONCRITERIA = _getCPR ("UBL-ExceptionCriteria-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExceptionCriteriaXSDs ()
  {
    return _getAllXSDs (CPR_EXCEPTIONCRITERIA);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ExceptionCriteriaType> exceptionCriteria ()
  {
    return new UBL25JAXBMarshaller <> (ExceptionCriteriaType.class,
                                       getAllExceptionCriteriaXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exceptioncriteria_25.ObjectFactory._ExceptionCriteria_QNAME);
  }

  private static final ClassPathResource CPR_EXCEPTIONNOTIFICATION = _getCPR ("UBL-ExceptionNotification-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExceptionNotificationXSDs ()
  {
    return _getAllXSDs (CPR_EXCEPTIONNOTIFICATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ExceptionNotificationType> exceptionNotification ()
  {
    return new UBL25JAXBMarshaller <> (ExceptionNotificationType.class,
                                       getAllExceptionNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exceptionnotification_25.ObjectFactory._ExceptionNotification_QNAME);
  }

  private static final ClassPathResource CPR_EXPORTCUSTOMSDECLARATION = _getCPR ("UBL-ExportCustomsDeclaration-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExportCustomsDeclarationXSDs ()
  {
    return _getAllXSDs (CPR_EXPORTCUSTOMSDECLARATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ExportCustomsDeclarationType> exportCustomsDeclaration ()
  {
    return new UBL25JAXBMarshaller <> (ExportCustomsDeclarationType.class,
                                       getAllExportCustomsDeclarationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_25.ObjectFactory._ExportCustomsDeclaration_QNAME);
  }

  private static final ClassPathResource CPR_EXPRESSIONOFINTERESTREQUEST = _getCPR ("UBL-ExpressionOfInterestRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExpressionOfInterestRequestXSDs ()
  {
    return _getAllXSDs (CPR_EXPRESSIONOFINTERESTREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ExpressionOfInterestRequestType> expressionOfInterestRequest ()
  {
    return new UBL25JAXBMarshaller <> (ExpressionOfInterestRequestType.class,
                                       getAllExpressionOfInterestRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_25.ObjectFactory._ExpressionOfInterestRequest_QNAME);
  }

  private static final ClassPathResource CPR_EXPRESSIONOFINTERESTRESPONSE = _getCPR ("UBL-ExpressionOfInterestResponse-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExpressionOfInterestResponseXSDs ()
  {
    return _getAllXSDs (CPR_EXPRESSIONOFINTERESTRESPONSE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ExpressionOfInterestResponseType> expressionOfInterestResponse ()
  {
    return new UBL25JAXBMarshaller <> (ExpressionOfInterestResponseType.class,
                                       getAllExpressionOfInterestResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_25.ObjectFactory._ExpressionOfInterestResponse_QNAME);
  }

  private static final ClassPathResource CPR_FORECAST = _getCPR ("UBL-Forecast-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForecastXSDs ()
  {
    return _getAllXSDs (CPR_FORECAST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ForecastType> forecast ()
  {
    return new UBL25JAXBMarshaller <> (ForecastType.class,
                                       getAllForecastXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forecast_25.ObjectFactory._Forecast_QNAME);
  }

  private static final ClassPathResource CPR_FORECASTREVISION = _getCPR ("UBL-ForecastRevision-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForecastRevisionXSDs ()
  {
    return _getAllXSDs (CPR_FORECASTREVISION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ForecastRevisionType> forecastRevision ()
  {
    return new UBL25JAXBMarshaller <> (ForecastRevisionType.class,
                                       getAllForecastRevisionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forecastrevision_25.ObjectFactory._ForecastRevision_QNAME);
  }

  private static final ClassPathResource CPR_FORWARDINGINSTRUCTIONS = _getCPR ("UBL-ForwardingInstructions-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForwardingInstructionsXSDs ()
  {
    return _getAllXSDs (CPR_FORWARDINGINSTRUCTIONS);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ForwardingInstructionsType> forwardingInstructions ()
  {
    return new UBL25JAXBMarshaller <> (ForwardingInstructionsType.class,
                                       getAllForwardingInstructionsXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forwardinginstructions_25.ObjectFactory._ForwardingInstructions_QNAME);
  }

  private static final ClassPathResource CPR_FREIGHTINVOICE = _getCPR ("UBL-FreightInvoice-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllFreightInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_FREIGHTINVOICE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <FreightInvoiceType> freightInvoice ()
  {
    return new UBL25JAXBMarshaller <> (FreightInvoiceType.class,
                                       getAllFreightInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.freightinvoice_25.ObjectFactory._FreightInvoice_QNAME);
  }

  private static final ClassPathResource CPR_FULFILMENTCANCELLATION = _getCPR ("UBL-FulfilmentCancellation-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllFulfilmentCancellationXSDs ()
  {
    return _getAllXSDs (CPR_FULFILMENTCANCELLATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return new UBL25JAXBMarshaller <> (FulfilmentCancellationType.class,
                                       getAllFulfilmentCancellationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_25.ObjectFactory._FulfilmentCancellation_QNAME);
  }

  private static final ClassPathResource CPR_GOODSCERTIFICATE = _getCPR ("UBL-GoodsCertificate-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGoodsCertificateXSDs ()
  {
    return _getAllXSDs (CPR_GOODSCERTIFICATE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <GoodsCertificateType> goodsCertificate ()
  {
    return new UBL25JAXBMarshaller <> (GoodsCertificateType.class,
                                       getAllGoodsCertificateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.goodscertificate_25.ObjectFactory._GoodsCertificate_QNAME);
  }

  private static final ClassPathResource CPR_GOODSITEMITINERARY = _getCPR ("UBL-GoodsItemItinerary-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGoodsItemItineraryXSDs ()
  {
    return _getAllXSDs (CPR_GOODSITEMITINERARY);
  }

  @NonNull
  public static UBL25JAXBMarshaller <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return new UBL25JAXBMarshaller <> (GoodsItemItineraryType.class,
                                       getAllGoodsItemItineraryXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_25.ObjectFactory._GoodsItemItinerary_QNAME);
  }

  private static final ClassPathResource CPR_GOODSITEMPASSPORT = _getCPR ("UBL-GoodsItemPassport-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGoodsItemPassportXSDs ()
  {
    return _getAllXSDs (CPR_GOODSITEMPASSPORT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <GoodsItemPassportType> goodsItemPassport ()
  {
    return new UBL25JAXBMarshaller <> (GoodsItemPassportType.class,
                                       getAllGoodsItemPassportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.goodsitempassport_25.ObjectFactory._GoodsItemPassport_QNAME);
  }

  private static final ClassPathResource CPR_GUARANTEECERTIFICATE = _getCPR ("UBL-GuaranteeCertificate-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGuaranteeCertificateXSDs ()
  {
    return _getAllXSDs (CPR_GUARANTEECERTIFICATE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return new UBL25JAXBMarshaller <> (GuaranteeCertificateType.class,
                                       getAllGuaranteeCertificateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.guaranteecertificate_25.ObjectFactory._GuaranteeCertificate_QNAME);
  }

  private static final ClassPathResource CPR_IMPORTCUSTOMSDECLARATION = _getCPR ("UBL-ImportCustomsDeclaration-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllImportCustomsDeclarationXSDs ()
  {
    return _getAllXSDs (CPR_IMPORTCUSTOMSDECLARATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ImportCustomsDeclarationType> importCustomsDeclaration ()
  {
    return new UBL25JAXBMarshaller <> (ImportCustomsDeclarationType.class,
                                       getAllImportCustomsDeclarationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_25.ObjectFactory._ImportCustomsDeclaration_QNAME);
  }

  private static final ClassPathResource CPR_INSTRUCTIONFORRETURNS = _getCPR ("UBL-InstructionForReturns-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInstructionForReturnsXSDs ()
  {
    return _getAllXSDs (CPR_INSTRUCTIONFORRETURNS);
  }

  @NonNull
  public static UBL25JAXBMarshaller <InstructionForReturnsType> instructionForReturns ()
  {
    return new UBL25JAXBMarshaller <> (InstructionForReturnsType.class,
                                       getAllInstructionForReturnsXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.instructionforreturns_25.ObjectFactory._InstructionForReturns_QNAME);
  }

  private static final ClassPathResource CPR_INVENTORYREPORT = _getCPR ("UBL-InventoryReport-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInventoryReportXSDs ()
  {
    return _getAllXSDs (CPR_INVENTORYREPORT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <InventoryReportType> inventoryReport ()
  {
    return new UBL25JAXBMarshaller <> (InventoryReportType.class,
                                       getAllInventoryReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.inventoryreport_25.ObjectFactory._InventoryReport_QNAME);
  }

  private static final ClassPathResource CPR_INVOICE = _getCPR ("UBL-Invoice-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_INVOICE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <InvoiceType> invoice ()
  {
    return new UBL25JAXBMarshaller <> (InvoiceType.class,
                                       getAllInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.invoice_25.ObjectFactory._Invoice_QNAME);
  }

  private static final ClassPathResource CPR_INVOICESTATUSREQUEST = _getCPR ("UBL-InvoiceStatusRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInvoiceStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_INVOICESTATUSREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <InvoiceStatusRequestType> invoiceStatusRequest ()
  {
    return new UBL25JAXBMarshaller <> (InvoiceStatusRequestType.class,
                                       getAllInvoiceStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.invoicestatusrequest_25.ObjectFactory._InvoiceStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_INVOICESTATUSRESPONSE = _getCPR ("UBL-InvoiceStatusResponse-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInvoiceStatusResponseXSDs ()
  {
    return _getAllXSDs (CPR_INVOICESTATUSRESPONSE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <InvoiceStatusResponseType> invoiceStatusResponse ()
  {
    return new UBL25JAXBMarshaller <> (InvoiceStatusResponseType.class,
                                       getAllInvoiceStatusResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.invoicestatusresponse_25.ObjectFactory._InvoiceStatusResponse_QNAME);
  }

  private static final ClassPathResource CPR_ITEMINFORMATIONREQUEST = _getCPR ("UBL-ItemInformationRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllItemInformationRequestXSDs ()
  {
    return _getAllXSDs (CPR_ITEMINFORMATIONREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ItemInformationRequestType> itemInformationRequest ()
  {
    return new UBL25JAXBMarshaller <> (ItemInformationRequestType.class,
                                       getAllItemInformationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.iteminformationrequest_25.ObjectFactory._ItemInformationRequest_QNAME);
  }

  private static final ClassPathResource CPR_MANIFEST = _getCPR ("UBL-Manifest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllManifestXSDs ()
  {
    return _getAllXSDs (CPR_MANIFEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ManifestType> manifest ()
  {
    return new UBL25JAXBMarshaller <> (ManifestType.class,
                                       getAllManifestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.manifest_25.ObjectFactory._Manifest_QNAME);
  }

  private static final ClassPathResource CPR_ORDER = _getCPR ("UBL-Order-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderXSDs ()
  {
    return _getAllXSDs (CPR_ORDER);
  }

  @NonNull
  public static UBL25JAXBMarshaller <OrderType> order ()
  {
    return new UBL25JAXBMarshaller <> (OrderType.class,
                                       getAllOrderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.order_25.ObjectFactory._Order_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCANCELLATION = _getCPR ("UBL-OrderCancellation-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderCancellationXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCANCELLATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <OrderCancellationType> orderCancellation ()
  {
    return new UBL25JAXBMarshaller <> (OrderCancellationType.class,
                                       getAllOrderCancellationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.ordercancellation_25.ObjectFactory._OrderCancellation_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCHANGE = _getCPR ("UBL-OrderChange-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderChangeXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCHANGE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <OrderChangeType> orderChange ()
  {
    return new UBL25JAXBMarshaller <> (OrderChangeType.class,
                                       getAllOrderChangeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderchange_25.ObjectFactory._OrderChange_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSE = _getCPR ("UBL-OrderResponse-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <OrderResponseType> orderResponse ()
  {
    return new UBL25JAXBMarshaller <> (OrderResponseType.class,
                                       getAllOrderResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponse_25.ObjectFactory._OrderResponse_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSESIMPLE = _getCPR ("UBL-OrderResponseSimple-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseSimpleXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSESIMPLE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <OrderResponseSimpleType> orderResponseSimple ()
  {
    return new UBL25JAXBMarshaller <> (OrderResponseSimpleType.class,
                                       getAllOrderResponseSimpleXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponsesimple_25.ObjectFactory._OrderResponseSimple_QNAME);
  }

  private static final ClassPathResource CPR_PACKINGLIST = _getCPR ("UBL-PackingList-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPackingListXSDs ()
  {
    return _getAllXSDs (CPR_PACKINGLIST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <PackingListType> packingList ()
  {
    return new UBL25JAXBMarshaller <> (PackingListType.class,
                                       getAllPackingListXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.packinglist_25.ObjectFactory._PackingList_QNAME);
  }

  private static final ClassPathResource CPR_PRIORINFORMATIONNOTICE = _getCPR ("UBL-PriorInformationNotice-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPriorInformationNoticeXSDs ()
  {
    return _getAllXSDs (CPR_PRIORINFORMATIONNOTICE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <PriorInformationNoticeType> priorInformationNotice ()
  {
    return new UBL25JAXBMarshaller <> (PriorInformationNoticeType.class,
                                       getAllPriorInformationNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.priorinformationnotice_25.ObjectFactory._PriorInformationNotice_QNAME);
  }

  private static final ClassPathResource CPR_PRODUCTACTIVITY = _getCPR ("UBL-ProductActivity-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProductActivityXSDs ()
  {
    return _getAllXSDs (CPR_PRODUCTACTIVITY);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ProductActivityType> productActivity ()
  {
    return new UBL25JAXBMarshaller <> (ProductActivityType.class,
                                       getAllProductActivityXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.productactivity_25.ObjectFactory._ProductActivity_QNAME);
  }

  private static final ClassPathResource CPR_PROCUREMENTSTATUS = _getCPR ("UBL-ProcurementStatus-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProcurementStatusXSDs ()
  {
    return _getAllXSDs (CPR_PROCUREMENTSTATUS);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ProcurementStatusType> procurementStatus ()
  {
    return new UBL25JAXBMarshaller <> (ProcurementStatusType.class,
                                       getAllProcurementStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.procurementstatus_25.ObjectFactory._ProcurementStatus_QNAME);
  }

  private static final ClassPathResource CPR_PROCUREMENTSTATUSREQUEST = _getCPR ("UBL-ProcurementStatusRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProcurementStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_PROCUREMENTSTATUSREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ProcurementStatusRequestType> procurementStatusRequest ()
  {
    return new UBL25JAXBMarshaller <> (ProcurementStatusRequestType.class,
                                       getAllProcurementStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.procurementstatusrequest_25.ObjectFactory._ProcurementStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_PROOFOFREEXPORTATION = _getCPR ("UBL-ProofOfReexportation-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProofOfReexportationXSDs ()
  {
    return _getAllXSDs (CPR_PROOFOFREEXPORTATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ProofOfReexportationType> proofOfReexportation ()
  {
    return new UBL25JAXBMarshaller <> (ProofOfReexportationType.class,
                                       getAllProofOfReexportationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportation_25.ObjectFactory._ProofOfReexportation_QNAME);
  }

  private static final ClassPathResource CPR_PROOFOFREEXPORTATIONREMINDER = _getCPR ("UBL-ProofOfReexportationReminder-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProofOfReexportationReminderXSDs ()
  {
    return _getAllXSDs (CPR_PROOFOFREEXPORTATIONREMINDER);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ProofOfReexportationReminderType> proofOfReexportationReminder ()
  {
    return new UBL25JAXBMarshaller <> (ProofOfReexportationReminderType.class,
                                       getAllProofOfReexportationReminderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_25.ObjectFactory._ProofOfReexportationReminder_QNAME);
  }

  private static final ClassPathResource CPR_PROOFOFREEXPORTATIONREQUEST = _getCPR ("UBL-ProofOfReexportationRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProofOfReexportationRequestXSDs ()
  {
    return _getAllXSDs (CPR_PROOFOFREEXPORTATIONREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ProofOfReexportationRequestType> proofOfReexportationRequest ()
  {
    return new UBL25JAXBMarshaller <> (ProofOfReexportationRequestType.class,
                                       getAllProofOfReexportationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_25.ObjectFactory._ProofOfReexportationRequest_QNAME);
  }

  private static final ClassPathResource CPR_PURCHASERECEIPT = _getCPR ("UBL-PurchaseReceipt-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPurchaseReceiptXSDs ()
  {
    return _getAllXSDs (CPR_PURCHASERECEIPT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <PurchaseReceiptType> purchaseReceipt ()
  {
    return new UBL25JAXBMarshaller <> (PurchaseReceiptType.class,
                                       getAllPurchaseReceiptXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.purchasereceipt_25.ObjectFactory._PurchaseReceipt_QNAME);
  }

  private static final ClassPathResource CPR_QUALIFICATIONAPPLICATIONREQUEST = _getCPR ("UBL-QualificationApplicationRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQualificationApplicationRequestXSDs ()
  {
    return _getAllXSDs (CPR_QUALIFICATIONAPPLICATIONREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <QualificationApplicationRequestType> qualificationApplicationRequest ()
  {
    return new UBL25JAXBMarshaller <> (QualificationApplicationRequestType.class,
                                       getAllQualificationApplicationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_25.ObjectFactory._QualificationApplicationRequest_QNAME);
  }

  private static final ClassPathResource CPR_QUALIFICATIONAPPLICATIONRESPONSE = _getCPR ("UBL-QualificationApplicationResponse-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQualificationApplicationResponseXSDs ()
  {
    return _getAllXSDs (CPR_QUALIFICATIONAPPLICATIONRESPONSE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <QualificationApplicationResponseType> qualificationApplicationResponse ()
  {
    return new UBL25JAXBMarshaller <> (QualificationApplicationResponseType.class,
                                       getAllQualificationApplicationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_25.ObjectFactory._QualificationApplicationResponse_QNAME);
  }

  private static final ClassPathResource CPR_QUOTATION = _getCPR ("UBL-Quotation-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQuotationXSDs ()
  {
    return _getAllXSDs (CPR_QUOTATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <QuotationType> quotation ()
  {
    return new UBL25JAXBMarshaller <> (QuotationType.class,
                                       getAllQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.quotation_25.ObjectFactory._Quotation_QNAME);
  }

  private static final ClassPathResource CPR_RECEIPTADVICE = _getCPR ("UBL-ReceiptAdvice-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReceiptAdviceXSDs ()
  {
    return _getAllXSDs (CPR_RECEIPTADVICE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ReceiptAdviceType> receiptAdvice ()
  {
    return new UBL25JAXBMarshaller <> (ReceiptAdviceType.class,
                                       getAllReceiptAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.receiptadvice_25.ObjectFactory._ReceiptAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REMINDER = _getCPR ("UBL-Reminder-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReminderXSDs ()
  {
    return _getAllXSDs (CPR_REMINDER);
  }

  @NonNull
  public static UBL25JAXBMarshaller <ReminderType> reminder ()
  {
    return new UBL25JAXBMarshaller <> (ReminderType.class,
                                       getAllReminderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.reminder_25.ObjectFactory._Reminder_QNAME);
  }

  private static final ClassPathResource CPR_REMITTANCEADVICE = _getCPR ("UBL-RemittanceAdvice-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRemittanceAdviceXSDs ()
  {
    return _getAllXSDs (CPR_REMITTANCEADVICE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <RemittanceAdviceType> remittanceAdvice ()
  {
    return new UBL25JAXBMarshaller <> (RemittanceAdviceType.class,
                                       getAllRemittanceAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.remittanceadvice_25.ObjectFactory._RemittanceAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REQUESTFORQUOTATION = _getCPR ("UBL-RequestForQuotation-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRequestForQuotationXSDs ()
  {
    return _getAllXSDs (CPR_REQUESTFORQUOTATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <RequestForQuotationType> requestForQuotation ()
  {
    return new UBL25JAXBMarshaller <> (RequestForQuotationType.class,
                                       getAllRequestForQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.requestforquotation_25.ObjectFactory._RequestForQuotation_QNAME);
  }

  private static final ClassPathResource CPR_RETAILEVENT = _getCPR ("UBL-RetailEvent-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRetailEventXSDs ()
  {
    return _getAllXSDs (CPR_RETAILEVENT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <RetailEventType> retailEvent ()
  {
    return new UBL25JAXBMarshaller <> (RetailEventType.class,
                                       getAllRetailEventXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.retailevent_25.ObjectFactory._RetailEvent_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDCREDITNOTE = _getCPR ("UBL-SelfBilledCreditNote-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDCREDITNOTE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return new UBL25JAXBMarshaller <> (SelfBilledCreditNoteType.class,
                                       getAllSelfBilledCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_25.ObjectFactory._SelfBilledCreditNote_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDINVOICE = _getCPR ("UBL-SelfBilledInvoice-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDINVOICE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return new UBL25JAXBMarshaller <> (SelfBilledInvoiceType.class,
                                       getAllSelfBilledInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_25.ObjectFactory._SelfBilledInvoice_QNAME);
  }

  private static final ClassPathResource CPR_STATEMENT = _getCPR ("UBL-Statement-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllStatementXSDs ()
  {
    return _getAllXSDs (CPR_STATEMENT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <StatementType> statement ()
  {
    return new UBL25JAXBMarshaller <> (StatementType.class,
                                       getAllStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.statement_25.ObjectFactory._Statement_QNAME);
  }

  private static final ClassPathResource CPR_STOCKAVAILABILITYREPORT = _getCPR ("UBL-StockAvailabilityReport-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllStockAvailabilityReportXSDs ()
  {
    return _getAllXSDs (CPR_STOCKAVAILABILITYREPORT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return new UBL25JAXBMarshaller <> (StockAvailabilityReportType.class,
                                       getAllStockAvailabilityReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_25.ObjectFactory._StockAvailabilityReport_QNAME);
  }

  private static final ClassPathResource CPR_TENDER = _getCPR ("UBL-Tender-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderXSDs ()
  {
    return _getAllXSDs (CPR_TENDER);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TenderType> tender ()
  {
    return new UBL25JAXBMarshaller <> (TenderType.class,
                                       getAllTenderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tender_25.ObjectFactory._Tender_QNAME);
  }

  private static final ClassPathResource CPR_TENDERCONTRACT = _getCPR ("UBL-TenderContract-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderContractXSDs ()
  {
    return _getAllXSDs (CPR_TENDERCONTRACT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TenderContractType> tenderContract ()
  {
    return new UBL25JAXBMarshaller <> (TenderContractType.class,
                                       getAllTenderContractXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendercontract_25.ObjectFactory._TenderContract_QNAME);
  }

  private static final ClassPathResource CPR_TENDERERQUALIFICATION = _getCPR ("UBL-TendererQualification-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTendererQualificationXSDs ()
  {
    return _getAllXSDs (CPR_TENDERERQUALIFICATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TendererQualificationType> tendererQualification ()
  {
    return new UBL25JAXBMarshaller <> (TendererQualificationType.class,
                                       getAllTendererQualificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualification_25.ObjectFactory._TendererQualification_QNAME);
  }

  private static final ClassPathResource CPR_TENDERERQUALIFICATIONRESPONSE = _getCPR ("UBL-TendererQualificationResponse-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTendererQualificationResponseXSDs ()
  {
    return _getAllXSDs (CPR_TENDERERQUALIFICATIONRESPONSE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return new UBL25JAXBMarshaller <> (TendererQualificationResponseType.class,
                                       getAllTendererQualificationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_25.ObjectFactory._TendererQualificationResponse_QNAME);
  }

  private static final ClassPathResource CPR_TENDERRECEIPT = _getCPR ("UBL-TenderReceipt-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderReceiptXSDs ()
  {
    return _getAllXSDs (CPR_TENDERRECEIPT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TenderReceiptType> tenderReceipt ()
  {
    return new UBL25JAXBMarshaller <> (TenderReceiptType.class,
                                       getAllTenderReceiptXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderreceipt_25.ObjectFactory._TenderReceipt_QNAME);
  }

  private static final ClassPathResource CPR_TENDERSTATUS = _getCPR ("UBL-TenderStatus-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderStatusXSDs ()
  {
    return _getAllXSDs (CPR_TENDERSTATUS);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TenderStatusType> tenderStatus ()
  {
    return new UBL25JAXBMarshaller <> (TenderStatusType.class,
                                       getAllTenderStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatus_25.ObjectFactory._TenderStatus_QNAME);
  }

  private static final ClassPathResource CPR_TENDERSTATUSREQUEST = _getCPR ("UBL-TenderStatusRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TENDERSTATUSREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TenderStatusRequestType> tenderStatusRequest ()
  {
    return new UBL25JAXBMarshaller <> (TenderStatusRequestType.class,
                                       getAllTenderStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_25.ObjectFactory._TenderStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TENDERWITHDRAWAL = _getCPR ("UBL-TenderWithdrawal-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderWithdrawalXSDs ()
  {
    return _getAllXSDs (CPR_TENDERWITHDRAWAL);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TenderWithdrawalType> tenderWithdrawal ()
  {
    return new UBL25JAXBMarshaller <> (TenderWithdrawalType.class,
                                       getAllTenderWithdrawalXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_25.ObjectFactory._TenderWithdrawal_QNAME);
  }

  private static final ClassPathResource CPR_TRADEITEMLOCATIONPROFILE = _getCPR ("UBL-TradeItemLocationProfile-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTradeItemLocationProfileXSDs ()
  {
    return _getAllXSDs (CPR_TRADEITEMLOCATIONPROFILE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return new UBL25JAXBMarshaller <> (TradeItemLocationProfileType.class,
                                       getAllTradeItemLocationProfileXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_25.ObjectFactory._TradeItemLocationProfile_QNAME);
  }

  private static final ClassPathResource CPR_TRANSITCUSTOMSDECLARATION = _getCPR ("UBL-TransitCustomsDeclaration-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransitCustomsDeclarationXSDs ()
  {
    return _getAllXSDs (CPR_TRANSITCUSTOMSDECLARATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TransitCustomsDeclarationType> transitCustomsDeclaration ()
  {
    return new UBL25JAXBMarshaller <> (TransitCustomsDeclarationType.class,
                                       getAllTransitCustomsDeclarationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_25.ObjectFactory._TransitCustomsDeclaration_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTATIONSTATUS = _getCPR ("UBL-TransportationStatus-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportationStatusXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTATIONSTATUS);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TransportationStatusType> transportationStatus ()
  {
    return new UBL25JAXBMarshaller <> (TransportationStatusType.class,
                                       getAllTransportationStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatus_25.ObjectFactory._TransportationStatus_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTATIONSTATUSREQUEST = _getCPR ("UBL-TransportationStatusRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportationStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTATIONSTATUSREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return new UBL25JAXBMarshaller <> (TransportationStatusRequestType.class,
                                       getAllTransportationStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_25.ObjectFactory._TransportationStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTEXECUTIONPLAN = _getCPR ("UBL-TransportExecutionPlan-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportExecutionPlanXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTEXECUTIONPLAN);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return new UBL25JAXBMarshaller <> (TransportExecutionPlanType.class,
                                       getAllTransportExecutionPlanXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplan_25.ObjectFactory._TransportExecutionPlan_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTEXECUTIONPLANREQUEST = _getCPR ("UBL-TransportExecutionPlanRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportExecutionPlanRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTEXECUTIONPLANREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return new UBL25JAXBMarshaller <> (TransportExecutionPlanRequestType.class,
                                       getAllTransportExecutionPlanRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_25.ObjectFactory._TransportExecutionPlanRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTPROGRESSSTATUS = _getCPR ("UBL-TransportProgressStatus-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportProgressStatusXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTPROGRESSSTATUS);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TransportProgressStatusType> transportProgressStatus ()
  {
    return new UBL25JAXBMarshaller <> (TransportProgressStatusType.class,
                                       getAllTransportProgressStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatus_25.ObjectFactory._TransportProgressStatus_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTPROGRESSSTATUSREQUEST = _getCPR ("UBL-TransportProgressStatusRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportProgressStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTPROGRESSSTATUSREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return new UBL25JAXBMarshaller <> (TransportProgressStatusRequestType.class,
                                       getAllTransportProgressStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_25.ObjectFactory._TransportProgressStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTSERVICEDESCRIPTION = _getCPR ("UBL-TransportServiceDescription-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportServiceDescriptionXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTSERVICEDESCRIPTION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return new UBL25JAXBMarshaller <> (TransportServiceDescriptionType.class,
                                       getAllTransportServiceDescriptionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescription_25.ObjectFactory._TransportServiceDescription_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTSERVICEDESCRIPTIONREQUEST = _getCPR ("UBL-TransportServiceDescriptionRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportServiceDescriptionRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTSERVICEDESCRIPTIONREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return new UBL25JAXBMarshaller <> (TransportServiceDescriptionRequestType.class,
                                       getAllTransportServiceDescriptionRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_25.ObjectFactory._TransportServiceDescriptionRequest_QNAME);
  }

  private static final ClassPathResource CPR_UNAWARDEDNOTIFICATION = _getCPR ("UBL-UnawardedNotification-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnawardedNotificationXSDs ()
  {
    return _getAllXSDs (CPR_UNAWARDEDNOTIFICATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <UnawardedNotificationType> unawardedNotification ()
  {
    return new UBL25JAXBMarshaller <> (UnawardedNotificationType.class,
                                       getAllUnawardedNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unawardednotification_25.ObjectFactory._UnawardedNotification_QNAME);
  }

  private static final ClassPathResource CPR_UNSUBSCRIBEFROMPROCEDUREREQUEST = _getCPR ("UBL-UnsubscribeFromProcedureRequest-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnsubscribeFromProcedureRequestXSDs ()
  {
    return _getAllXSDs (CPR_UNSUBSCRIBEFROMPROCEDUREREQUEST);
  }

  @NonNull
  public static UBL25JAXBMarshaller <UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest ()
  {
    return new UBL25JAXBMarshaller <> (UnsubscribeFromProcedureRequestType.class,
                                       getAllUnsubscribeFromProcedureRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_25.ObjectFactory._UnsubscribeFromProcedureRequest_QNAME);
  }

  private static final ClassPathResource CPR_UNSUBSCRIBEFROMPROCEDURERESPONSE = _getCPR ("UBL-UnsubscribeFromProcedureResponse-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnsubscribeFromProcedureResponseXSDs ()
  {
    return _getAllXSDs (CPR_UNSUBSCRIBEFROMPROCEDURERESPONSE);
  }

  @NonNull
  public static UBL25JAXBMarshaller <UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse ()
  {
    return new UBL25JAXBMarshaller <> (UnsubscribeFromProcedureResponseType.class,
                                       getAllUnsubscribeFromProcedureResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_25.ObjectFactory._UnsubscribeFromProcedureResponse_QNAME);
  }

  private static final ClassPathResource CPR_UTILITYSTATEMENT = _getCPR ("UBL-UtilityStatement-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUtilityStatementXSDs ()
  {
    return _getAllXSDs (CPR_UTILITYSTATEMENT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <UtilityStatementType> utilityStatement ()
  {
    return new UBL25JAXBMarshaller <> (UtilityStatementType.class,
                                       getAllUtilityStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.utilitystatement_25.ObjectFactory._UtilityStatement_QNAME);
  }

  private static final ClassPathResource CPR_WASTEMOVEMENT = _getCPR ("UBL-WasteMovement-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWasteMovementXSDs ()
  {
    return _getAllXSDs (CPR_WASTEMOVEMENT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <WasteMovementType> wasteMovement ()
  {
    return new UBL25JAXBMarshaller <> (WasteMovementType.class,
                                       getAllWasteMovementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.wastemovement_25.ObjectFactory._WasteMovement_QNAME);
  }

  private static final ClassPathResource CPR_WASTENOTIFICATION = _getCPR ("UBL-WasteNotification-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWasteNotificationXSDs ()
  {
    return _getAllXSDs (CPR_WASTENOTIFICATION);
  }

  @NonNull
  public static UBL25JAXBMarshaller <WasteNotificationType> wasteNotification ()
  {
    return new UBL25JAXBMarshaller <> (WasteNotificationType.class,
                                       getAllWasteNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.wastenotification_25.ObjectFactory._WasteNotification_QNAME);
  }

  private static final ClassPathResource CPR_WAYBILL = _getCPR ("UBL-Waybill-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWaybillXSDs ()
  {
    return _getAllXSDs (CPR_WAYBILL);
  }

  @NonNull
  public static UBL25JAXBMarshaller <WaybillType> waybill ()
  {
    return new UBL25JAXBMarshaller <> (WaybillType.class,
                                       getAllWaybillXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.waybill_25.ObjectFactory._Waybill_QNAME);
  }

  private static final ClassPathResource CPR_WEIGHTSTATEMENT = _getCPR ("UBL-WeightStatement-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWeightStatementXSDs ()
  {
    return _getAllXSDs (CPR_WEIGHTSTATEMENT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <WeightStatementType> weightStatement ()
  {
    return new UBL25JAXBMarshaller <> (WeightStatementType.class,
                                       getAllWeightStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.weightstatement_25.ObjectFactory._WeightStatement_QNAME);
  }

  private static final ClassPathResource CPR_WORKREPORT = _getCPR ("UBL-WorkReport-2.5.xsd");

  @NonNull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWorkReportXSDs ()
  {
    return _getAllXSDs (CPR_WORKREPORT);
  }

  @NonNull
  public static UBL25JAXBMarshaller <WorkReportType> workReport ()
  {
    return new UBL25JAXBMarshaller <> (WorkReportType.class,
                                       getAllWorkReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.workreport_25.ObjectFactory._WorkReport_QNAME);
  }
}
