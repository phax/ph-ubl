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
package com.helger.ubl22;

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

import oasis.names.specification.ubl.schema.xsd.applicationresponse_22.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_22.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.awardednotification_22.AwardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.billoflading_22.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.businesscard_22.BusinessCardType;
import oasis.names.specification.ubl.schema.xsd.callfortenders_22.CallForTendersType;
import oasis.names.specification.ubl.schema.xsd.catalogue_22.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_22.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_22.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_22.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_22.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_22.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.contractawardnotice_22.ContractAwardNoticeType;
import oasis.names.specification.ubl.schema.xsd.contractnotice_22.ContractNoticeType;
import oasis.names.specification.ubl.schema.xsd.creditnote_22.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_22.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_22.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.digitalagreement_22.DigitalAgreementType;
import oasis.names.specification.ubl.schema.xsd.digitalcapability_22.DigitalCapabilityType;
import oasis.names.specification.ubl.schema.xsd.documentstatus_22.DocumentStatusType;
import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_22.DocumentStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.enquiry_22.EnquiryType;
import oasis.names.specification.ubl.schema.xsd.enquiryresponse_22.EnquiryResponseType;
import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_22.ExceptionCriteriaType;
import oasis.names.specification.ubl.schema.xsd.exceptionnotification_22.ExceptionNotificationType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_22.ExpressionOfInterestRequestType;
import oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_22.ExpressionOfInterestResponseType;
import oasis.names.specification.ubl.schema.xsd.forecast_22.ForecastType;
import oasis.names.specification.ubl.schema.xsd.forecastrevision_22.ForecastRevisionType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_22.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_22.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_22.FulfilmentCancellationType;
import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_22.GoodsItemItineraryType;
import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_22.GuaranteeCertificateType;
import oasis.names.specification.ubl.schema.xsd.instructionforreturns_22.InstructionForReturnsType;
import oasis.names.specification.ubl.schema.xsd.inventoryreport_22.InventoryReportType;
import oasis.names.specification.ubl.schema.xsd.invoice_22.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_22.ItemInformationRequestType;
import oasis.names.specification.ubl.schema.xsd.order_22.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_22.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_22.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_22.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_22.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_22.PackingListType;
import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_22.PriorInformationNoticeType;
import oasis.names.specification.ubl.schema.xsd.productactivity_22.ProductActivityType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_22.QualificationApplicationRequestType;
import oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_22.QualificationApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.quotation_22.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_22.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_22.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_22.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_22.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.retailevent_22.RetailEventType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_22.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_22.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_22.StatementType;
import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_22.StockAvailabilityReportType;
import oasis.names.specification.ubl.schema.xsd.tender_22.TenderType;
import oasis.names.specification.ubl.schema.xsd.tendercontract_22.TenderContractType;
import oasis.names.specification.ubl.schema.xsd.tendererqualification_22.TendererQualificationType;
import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_22.TendererQualificationResponseType;
import oasis.names.specification.ubl.schema.xsd.tenderreceipt_22.TenderReceiptType;
import oasis.names.specification.ubl.schema.xsd.tenderstatus_22.TenderStatusType;
import oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_22.TenderStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_22.TenderWithdrawalType;
import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_22.TradeItemLocationProfileType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_22.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_22.TransportationStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_22.TransportExecutionPlanType;
import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_22.TransportExecutionPlanRequestType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_22.TransportProgressStatusType;
import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_22.TransportProgressStatusRequestType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescription_22.TransportServiceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_22.TransportServiceDescriptionRequestType;
import oasis.names.specification.ubl.schema.xsd.unawardednotification_22.UnawardedNotificationType;
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_22.UnsubscribeFromProcedureRequestType;
import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_22.UnsubscribeFromProcedureResponseType;
import oasis.names.specification.ubl.schema.xsd.utilitystatement_22.UtilityStatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_22.WaybillType;
import oasis.names.specification.ubl.schema.xsd.weightstatement_22.WeightStatementType;

/**
 * The class provides all the UBL 2.2 marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class UBL22Marshaller
{
  public static class UBL22JAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    private final QName m_aRootElementQName;

    public UBL22JAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nonnull @Nonempty final ICommonsList <ClassPathResource> aXSDs,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, aXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      m_aRootElementQName = aRootElementQName;

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBL22NamespaceContext.getInstance ().getClone ();
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
                                                                                             CUBL22.XSD_UNQUALIFIED_DATA_TYPES,
                                                                                             CUBL22.XSD_QUALIFIED_DATA_TYPES,
                                                                                             CUBL22.XSD_SIGNATURE_BASIC_COMPONENTS,
                                                                                             CUBL22.XSD_COMMON_BASIC_COMPONENTS,
                                                                                             CUBL22.XSD_SIGNATURE_AGGREGATE_COMPONENTS,
                                                                                             CUBL22.XSD_COMMON_SIGNATURE_COMPONENTS,
                                                                                             CUBL22.XSD_COMMON_EXTENSION_COMPONENTS,
                                                                                             CUBL22.XSD_COMMON_AGGREGATE_COMPONENTS);

  @Nonnull
  @ReturnsMutableCopy
  private static ICommonsList <ClassPathResource> _getAllXSDs (@Nonnull final ClassPathResource aXSD)
  {
    final ICommonsList <ClassPathResource> ret = BASE_XSDS.getClone ();
    ret.add (aXSD);
    return ret;
  }

  private UBL22Marshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CUBL22.SCHEMA_DIRECTORY + sXSDPath, CUBL22.getCL ());
  }

  // Automatically created from here on

  private static final ClassPathResource CPR_APPLICATIONRESPONSE = _getCPR ("UBL-ApplicationResponse-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllApplicationResponseXSDs ()
  {
    return _getAllXSDs (CPR_APPLICATIONRESPONSE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new UBL22JAXBMarshaller <> (ApplicationResponseType.class,
                                       getAllApplicationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.applicationresponse_22.ObjectFactory._ApplicationResponse_QNAME);
  }

  private static final ClassPathResource CPR_ATTACHEDDOCUMENT = _getCPR ("UBL-AttachedDocument-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllAttachedDocumentXSDs ()
  {
    return _getAllXSDs (CPR_ATTACHEDDOCUMENT);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new UBL22JAXBMarshaller <> (AttachedDocumentType.class,
                                       getAllAttachedDocumentXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.attacheddocument_22.ObjectFactory._AttachedDocument_QNAME);
  }

  private static final ClassPathResource CPR_AWARDEDNOTIFICATION = _getCPR ("UBL-AwardedNotification-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllAwardedNotificationXSDs ()
  {
    return _getAllXSDs (CPR_AWARDEDNOTIFICATION);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <AwardedNotificationType> awardedNotification ()
  {
    return new UBL22JAXBMarshaller <> (AwardedNotificationType.class,
                                       getAllAwardedNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.awardednotification_22.ObjectFactory._AwardedNotification_QNAME);
  }

  private static final ClassPathResource CPR_BILLOFLADING = _getCPR ("UBL-BillOfLading-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBillOfLadingXSDs ()
  {
    return _getAllXSDs (CPR_BILLOFLADING);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <BillOfLadingType> billOfLading ()
  {
    return new UBL22JAXBMarshaller <> (BillOfLadingType.class,
                                       getAllBillOfLadingXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.billoflading_22.ObjectFactory._BillOfLading_QNAME);
  }

  private static final ClassPathResource CPR_BUSINESSCARD = _getCPR ("UBL-BusinessCard-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBusinessCardXSDs ()
  {
    return _getAllXSDs (CPR_BUSINESSCARD);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <BusinessCardType> businessCard ()
  {
    return new UBL22JAXBMarshaller <> (BusinessCardType.class,
                                       getAllBusinessCardXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.businesscard_22.ObjectFactory._BusinessCard_QNAME);
  }

  private static final ClassPathResource CPR_CALLFORTENDERS = _getCPR ("UBL-CallForTenders-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCallForTendersXSDs ()
  {
    return _getAllXSDs (CPR_CALLFORTENDERS);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CallForTendersType> callForTenders ()
  {
    return new UBL22JAXBMarshaller <> (CallForTendersType.class,
                                       getAllCallForTendersXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.callfortenders_22.ObjectFactory._CallForTenders_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUE = _getCPR ("UBL-Catalogue-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CatalogueType> catalogue ()
  {
    return new UBL22JAXBMarshaller <> (CatalogueType.class,
                                       getAllCatalogueXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogue_22.ObjectFactory._Catalogue_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEDELETION = _getCPR ("UBL-CatalogueDeletion-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueDeletionXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEDELETION);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CatalogueDeletionType> catalogueDeletion ()
  {
    return new UBL22JAXBMarshaller <> (CatalogueDeletionType.class,
                                       getAllCatalogueDeletionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguedeletion_22.ObjectFactory._CatalogueDeletion_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEITEMSPECIFICATIONUPDATE = _getCPR ("UBL-CatalogueItemSpecificationUpdate-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueItemSpecificationUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEITEMSPECIFICATIONUPDATE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return new UBL22JAXBMarshaller <> (CatalogueItemSpecificationUpdateType.class,
                                       getAllCatalogueItemSpecificationUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_22.ObjectFactory._CatalogueItemSpecificationUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEPRICINGUPDATE = _getCPR ("UBL-CataloguePricingUpdate-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCataloguePricingUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEPRICINGUPDATE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return new UBL22JAXBMarshaller <> (CataloguePricingUpdateType.class,
                                       getAllCataloguePricingUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_22.ObjectFactory._CataloguePricingUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEREQUEST = _getCPR ("UBL-CatalogueRequest-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueRequestXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEREQUEST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CatalogueRequestType> catalogueRequest ()
  {
    return new UBL22JAXBMarshaller <> (CatalogueRequestType.class,
                                       getAllCatalogueRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguerequest_22.ObjectFactory._CatalogueRequest_QNAME);
  }

  private static final ClassPathResource CPR_CERTIFICATEOFORIGIN = _getCPR ("UBL-CertificateOfOrigin-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCertificateOfOriginXSDs ()
  {
    return _getAllXSDs (CPR_CERTIFICATEOFORIGIN);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CertificateOfOriginType> certificateOfOrigin ()
  {
    return new UBL22JAXBMarshaller <> (CertificateOfOriginType.class,
                                       getAllCertificateOfOriginXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.certificateoforigin_22.ObjectFactory._CertificateOfOrigin_QNAME);
  }

  private static final ClassPathResource CPR_CONTRACTAWARDNOTICE = _getCPR ("UBL-ContractAwardNotice-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllContractAwardNoticeXSDs ()
  {
    return _getAllXSDs (CPR_CONTRACTAWARDNOTICE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ContractAwardNoticeType> contractAwardNotice ()
  {
    return new UBL22JAXBMarshaller <> (ContractAwardNoticeType.class,
                                       getAllContractAwardNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.contractawardnotice_22.ObjectFactory._ContractAwardNotice_QNAME);
  }

  private static final ClassPathResource CPR_CONTRACTNOTICE = _getCPR ("UBL-ContractNotice-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllContractNoticeXSDs ()
  {
    return _getAllXSDs (CPR_CONTRACTNOTICE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ContractNoticeType> contractNotice ()
  {
    return new UBL22JAXBMarshaller <> (ContractNoticeType.class,
                                       getAllContractNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.contractnotice_22.ObjectFactory._ContractNotice_QNAME);
  }

  private static final ClassPathResource CPR_CREDITNOTE = _getCPR ("UBL-CreditNote-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_CREDITNOTE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new UBL22JAXBMarshaller <> (CreditNoteType.class,
                                       getAllCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_22.ObjectFactory._CreditNote_QNAME);
  }

  private static final ClassPathResource CPR_DEBITNOTE = _getCPR ("UBL-DebitNote-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDebitNoteXSDs ()
  {
    return _getAllXSDs (CPR_DEBITNOTE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new UBL22JAXBMarshaller <> (DebitNoteType.class,
                                       getAllDebitNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.debitnote_22.ObjectFactory._DebitNote_QNAME);
  }

  private static final ClassPathResource CPR_DESPATCHADVICE = _getCPR ("UBL-DespatchAdvice-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDespatchAdviceXSDs ()
  {
    return _getAllXSDs (CPR_DESPATCHADVICE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DespatchAdviceType> despatchAdvice ()
  {
    return new UBL22JAXBMarshaller <> (DespatchAdviceType.class,
                                       getAllDespatchAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.despatchadvice_22.ObjectFactory._DespatchAdvice_QNAME);
  }

  private static final ClassPathResource CPR_DIGITALAGREEMENT = _getCPR ("UBL-DigitalAgreement-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDigitalAgreementXSDs ()
  {
    return _getAllXSDs (CPR_DIGITALAGREEMENT);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DigitalAgreementType> digitalAgreement ()
  {
    return new UBL22JAXBMarshaller <> (DigitalAgreementType.class,
                                       getAllDigitalAgreementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.digitalagreement_22.ObjectFactory._DigitalAgreement_QNAME);
  }

  private static final ClassPathResource CPR_DIGITALCAPABILITY = _getCPR ("UBL-DigitalCapability-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDigitalCapabilityXSDs ()
  {
    return _getAllXSDs (CPR_DIGITALCAPABILITY);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DigitalCapabilityType> digitalCapability ()
  {
    return new UBL22JAXBMarshaller <> (DigitalCapabilityType.class,
                                       getAllDigitalCapabilityXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.digitalcapability_22.ObjectFactory._DigitalCapability_QNAME);
  }

  private static final ClassPathResource CPR_DOCUMENTSTATUS = _getCPR ("UBL-DocumentStatus-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDocumentStatusXSDs ()
  {
    return _getAllXSDs (CPR_DOCUMENTSTATUS);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DocumentStatusType> documentStatus ()
  {
    return new UBL22JAXBMarshaller <> (DocumentStatusType.class,
                                       getAllDocumentStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.documentstatus_22.ObjectFactory._DocumentStatus_QNAME);
  }

  private static final ClassPathResource CPR_DOCUMENTSTATUSREQUEST = _getCPR ("UBL-DocumentStatusRequest-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDocumentStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_DOCUMENTSTATUSREQUEST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DocumentStatusRequestType> documentStatusRequest ()
  {
    return new UBL22JAXBMarshaller <> (DocumentStatusRequestType.class,
                                       getAllDocumentStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.documentstatusrequest_22.ObjectFactory._DocumentStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_ENQUIRY = _getCPR ("UBL-Enquiry-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllEnquiryXSDs ()
  {
    return _getAllXSDs (CPR_ENQUIRY);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <EnquiryType> enquiry ()
  {
    return new UBL22JAXBMarshaller <> (EnquiryType.class,
                                       getAllEnquiryXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.enquiry_22.ObjectFactory._Enquiry_QNAME);
  }

  private static final ClassPathResource CPR_ENQUIRYRESPONSE = _getCPR ("UBL-EnquiryResponse-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllEnquiryResponseXSDs ()
  {
    return _getAllXSDs (CPR_ENQUIRYRESPONSE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <EnquiryResponseType> enquiryResponse ()
  {
    return new UBL22JAXBMarshaller <> (EnquiryResponseType.class,
                                       getAllEnquiryResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.enquiryresponse_22.ObjectFactory._EnquiryResponse_QNAME);
  }

  private static final ClassPathResource CPR_EXCEPTIONCRITERIA = _getCPR ("UBL-ExceptionCriteria-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExceptionCriteriaXSDs ()
  {
    return _getAllXSDs (CPR_EXCEPTIONCRITERIA);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ExceptionCriteriaType> exceptionCriteria ()
  {
    return new UBL22JAXBMarshaller <> (ExceptionCriteriaType.class,
                                       getAllExceptionCriteriaXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exceptioncriteria_22.ObjectFactory._ExceptionCriteria_QNAME);
  }

  private static final ClassPathResource CPR_EXCEPTIONNOTIFICATION = _getCPR ("UBL-ExceptionNotification-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExceptionNotificationXSDs ()
  {
    return _getAllXSDs (CPR_EXCEPTIONNOTIFICATION);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ExceptionNotificationType> exceptionNotification ()
  {
    return new UBL22JAXBMarshaller <> (ExceptionNotificationType.class,
                                       getAllExceptionNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.exceptionnotification_22.ObjectFactory._ExceptionNotification_QNAME);
  }

  private static final ClassPathResource CPR_EXPRESSIONOFINTERESTREQUEST = _getCPR ("UBL-ExpressionOfInterestRequest-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExpressionOfInterestRequestXSDs ()
  {
    return _getAllXSDs (CPR_EXPRESSIONOFINTERESTREQUEST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ExpressionOfInterestRequestType> expressionOfInterestRequest ()
  {
    return new UBL22JAXBMarshaller <> (ExpressionOfInterestRequestType.class,
                                       getAllExpressionOfInterestRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_22.ObjectFactory._ExpressionOfInterestRequest_QNAME);
  }

  private static final ClassPathResource CPR_EXPRESSIONOFINTERESTRESPONSE = _getCPR ("UBL-ExpressionOfInterestResponse-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllExpressionOfInterestResponseXSDs ()
  {
    return _getAllXSDs (CPR_EXPRESSIONOFINTERESTRESPONSE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ExpressionOfInterestResponseType> expressionOfInterestResponse ()
  {
    return new UBL22JAXBMarshaller <> (ExpressionOfInterestResponseType.class,
                                       getAllExpressionOfInterestResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_22.ObjectFactory._ExpressionOfInterestResponse_QNAME);
  }

  private static final ClassPathResource CPR_FORECAST = _getCPR ("UBL-Forecast-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForecastXSDs ()
  {
    return _getAllXSDs (CPR_FORECAST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ForecastType> forecast ()
  {
    return new UBL22JAXBMarshaller <> (ForecastType.class,
                                       getAllForecastXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forecast_22.ObjectFactory._Forecast_QNAME);
  }

  private static final ClassPathResource CPR_FORECASTREVISION = _getCPR ("UBL-ForecastRevision-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForecastRevisionXSDs ()
  {
    return _getAllXSDs (CPR_FORECASTREVISION);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ForecastRevisionType> forecastRevision ()
  {
    return new UBL22JAXBMarshaller <> (ForecastRevisionType.class,
                                       getAllForecastRevisionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forecastrevision_22.ObjectFactory._ForecastRevision_QNAME);
  }

  private static final ClassPathResource CPR_FORWARDINGINSTRUCTIONS = _getCPR ("UBL-ForwardingInstructions-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForwardingInstructionsXSDs ()
  {
    return _getAllXSDs (CPR_FORWARDINGINSTRUCTIONS);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ForwardingInstructionsType> forwardingInstructions ()
  {
    return new UBL22JAXBMarshaller <> (ForwardingInstructionsType.class,
                                       getAllForwardingInstructionsXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forwardinginstructions_22.ObjectFactory._ForwardingInstructions_QNAME);
  }

  private static final ClassPathResource CPR_FREIGHTINVOICE = _getCPR ("UBL-FreightInvoice-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllFreightInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_FREIGHTINVOICE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <FreightInvoiceType> freightInvoice ()
  {
    return new UBL22JAXBMarshaller <> (FreightInvoiceType.class,
                                       getAllFreightInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.freightinvoice_22.ObjectFactory._FreightInvoice_QNAME);
  }

  private static final ClassPathResource CPR_FULFILMENTCANCELLATION = _getCPR ("UBL-FulfilmentCancellation-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllFulfilmentCancellationXSDs ()
  {
    return _getAllXSDs (CPR_FULFILMENTCANCELLATION);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return new UBL22JAXBMarshaller <> (FulfilmentCancellationType.class,
                                       getAllFulfilmentCancellationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_22.ObjectFactory._FulfilmentCancellation_QNAME);
  }

  private static final ClassPathResource CPR_GOODSITEMITINERARY = _getCPR ("UBL-GoodsItemItinerary-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGoodsItemItineraryXSDs ()
  {
    return _getAllXSDs (CPR_GOODSITEMITINERARY);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return new UBL22JAXBMarshaller <> (GoodsItemItineraryType.class,
                                       getAllGoodsItemItineraryXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_22.ObjectFactory._GoodsItemItinerary_QNAME);
  }

  private static final ClassPathResource CPR_GUARANTEECERTIFICATE = _getCPR ("UBL-GuaranteeCertificate-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllGuaranteeCertificateXSDs ()
  {
    return _getAllXSDs (CPR_GUARANTEECERTIFICATE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return new UBL22JAXBMarshaller <> (GuaranteeCertificateType.class,
                                       getAllGuaranteeCertificateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.guaranteecertificate_22.ObjectFactory._GuaranteeCertificate_QNAME);
  }

  private static final ClassPathResource CPR_INSTRUCTIONFORRETURNS = _getCPR ("UBL-InstructionForReturns-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInstructionForReturnsXSDs ()
  {
    return _getAllXSDs (CPR_INSTRUCTIONFORRETURNS);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <InstructionForReturnsType> instructionForReturns ()
  {
    return new UBL22JAXBMarshaller <> (InstructionForReturnsType.class,
                                       getAllInstructionForReturnsXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.instructionforreturns_22.ObjectFactory._InstructionForReturns_QNAME);
  }

  private static final ClassPathResource CPR_INVENTORYREPORT = _getCPR ("UBL-InventoryReport-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInventoryReportXSDs ()
  {
    return _getAllXSDs (CPR_INVENTORYREPORT);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <InventoryReportType> inventoryReport ()
  {
    return new UBL22JAXBMarshaller <> (InventoryReportType.class,
                                       getAllInventoryReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.inventoryreport_22.ObjectFactory._InventoryReport_QNAME);
  }

  private static final ClassPathResource CPR_INVOICE = _getCPR ("UBL-Invoice-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_INVOICE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <InvoiceType> invoice ()
  {
    return new UBL22JAXBMarshaller <> (InvoiceType.class,
                                       getAllInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.invoice_22.ObjectFactory._Invoice_QNAME);
  }

  private static final ClassPathResource CPR_ITEMINFORMATIONREQUEST = _getCPR ("UBL-ItemInformationRequest-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllItemInformationRequestXSDs ()
  {
    return _getAllXSDs (CPR_ITEMINFORMATIONREQUEST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ItemInformationRequestType> itemInformationRequest ()
  {
    return new UBL22JAXBMarshaller <> (ItemInformationRequestType.class,
                                       getAllItemInformationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.iteminformationrequest_22.ObjectFactory._ItemInformationRequest_QNAME);
  }

  private static final ClassPathResource CPR_ORDER = _getCPR ("UBL-Order-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderXSDs ()
  {
    return _getAllXSDs (CPR_ORDER);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <OrderType> order ()
  {
    return new UBL22JAXBMarshaller <> (OrderType.class,
                                       getAllOrderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.order_22.ObjectFactory._Order_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCANCELLATION = _getCPR ("UBL-OrderCancellation-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderCancellationXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCANCELLATION);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <OrderCancellationType> orderCancellation ()
  {
    return new UBL22JAXBMarshaller <> (OrderCancellationType.class,
                                       getAllOrderCancellationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.ordercancellation_22.ObjectFactory._OrderCancellation_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCHANGE = _getCPR ("UBL-OrderChange-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderChangeXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCHANGE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <OrderChangeType> orderChange ()
  {
    return new UBL22JAXBMarshaller <> (OrderChangeType.class,
                                       getAllOrderChangeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderchange_22.ObjectFactory._OrderChange_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSE = _getCPR ("UBL-OrderResponse-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <OrderResponseType> orderResponse ()
  {
    return new UBL22JAXBMarshaller <> (OrderResponseType.class,
                                       getAllOrderResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponse_22.ObjectFactory._OrderResponse_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSESIMPLE = _getCPR ("UBL-OrderResponseSimple-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseSimpleXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSESIMPLE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <OrderResponseSimpleType> orderResponseSimple ()
  {
    return new UBL22JAXBMarshaller <> (OrderResponseSimpleType.class,
                                       getAllOrderResponseSimpleXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponsesimple_22.ObjectFactory._OrderResponseSimple_QNAME);
  }

  private static final ClassPathResource CPR_PACKINGLIST = _getCPR ("UBL-PackingList-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPackingListXSDs ()
  {
    return _getAllXSDs (CPR_PACKINGLIST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <PackingListType> packingList ()
  {
    return new UBL22JAXBMarshaller <> (PackingListType.class,
                                       getAllPackingListXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.packinglist_22.ObjectFactory._PackingList_QNAME);
  }

  private static final ClassPathResource CPR_PRIORINFORMATIONNOTICE = _getCPR ("UBL-PriorInformationNotice-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPriorInformationNoticeXSDs ()
  {
    return _getAllXSDs (CPR_PRIORINFORMATIONNOTICE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <PriorInformationNoticeType> priorInformationNotice ()
  {
    return new UBL22JAXBMarshaller <> (PriorInformationNoticeType.class,
                                       getAllPriorInformationNoticeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.priorinformationnotice_22.ObjectFactory._PriorInformationNotice_QNAME);
  }

  private static final ClassPathResource CPR_PRODUCTACTIVITY = _getCPR ("UBL-ProductActivity-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllProductActivityXSDs ()
  {
    return _getAllXSDs (CPR_PRODUCTACTIVITY);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ProductActivityType> productActivity ()
  {
    return new UBL22JAXBMarshaller <> (ProductActivityType.class,
                                       getAllProductActivityXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.productactivity_22.ObjectFactory._ProductActivity_QNAME);
  }

  private static final ClassPathResource CPR_QUALIFICATIONAPPLICATIONREQUEST = _getCPR ("UBL-QualificationApplicationRequest-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQualificationApplicationRequestXSDs ()
  {
    return _getAllXSDs (CPR_QUALIFICATIONAPPLICATIONREQUEST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <QualificationApplicationRequestType> qualificationApplicationRequest ()
  {
    return new UBL22JAXBMarshaller <> (QualificationApplicationRequestType.class,
                                       getAllQualificationApplicationRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_22.ObjectFactory._QualificationApplicationRequest_QNAME);
  }

  private static final ClassPathResource CPR_QUALIFICATIONAPPLICATIONRESPONSE = _getCPR ("UBL-QualificationApplicationResponse-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQualificationApplicationResponseXSDs ()
  {
    return _getAllXSDs (CPR_QUALIFICATIONAPPLICATIONRESPONSE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <QualificationApplicationResponseType> qualificationApplicationResponse ()
  {
    return new UBL22JAXBMarshaller <> (QualificationApplicationResponseType.class,
                                       getAllQualificationApplicationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_22.ObjectFactory._QualificationApplicationResponse_QNAME);
  }

  private static final ClassPathResource CPR_QUOTATION = _getCPR ("UBL-Quotation-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQuotationXSDs ()
  {
    return _getAllXSDs (CPR_QUOTATION);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <QuotationType> quotation ()
  {
    return new UBL22JAXBMarshaller <> (QuotationType.class,
                                       getAllQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.quotation_22.ObjectFactory._Quotation_QNAME);
  }

  private static final ClassPathResource CPR_RECEIPTADVICE = _getCPR ("UBL-ReceiptAdvice-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReceiptAdviceXSDs ()
  {
    return _getAllXSDs (CPR_RECEIPTADVICE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ReceiptAdviceType> receiptAdvice ()
  {
    return new UBL22JAXBMarshaller <> (ReceiptAdviceType.class,
                                       getAllReceiptAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.receiptadvice_22.ObjectFactory._ReceiptAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REMINDER = _getCPR ("UBL-Reminder-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReminderXSDs ()
  {
    return _getAllXSDs (CPR_REMINDER);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ReminderType> reminder ()
  {
    return new UBL22JAXBMarshaller <> (ReminderType.class,
                                       getAllReminderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.reminder_22.ObjectFactory._Reminder_QNAME);
  }

  private static final ClassPathResource CPR_REMITTANCEADVICE = _getCPR ("UBL-RemittanceAdvice-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRemittanceAdviceXSDs ()
  {
    return _getAllXSDs (CPR_REMITTANCEADVICE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <RemittanceAdviceType> remittanceAdvice ()
  {
    return new UBL22JAXBMarshaller <> (RemittanceAdviceType.class,
                                       getAllRemittanceAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.remittanceadvice_22.ObjectFactory._RemittanceAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REQUESTFORQUOTATION = _getCPR ("UBL-RequestForQuotation-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRequestForQuotationXSDs ()
  {
    return _getAllXSDs (CPR_REQUESTFORQUOTATION);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <RequestForQuotationType> requestForQuotation ()
  {
    return new UBL22JAXBMarshaller <> (RequestForQuotationType.class,
                                       getAllRequestForQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.requestforquotation_22.ObjectFactory._RequestForQuotation_QNAME);
  }

  private static final ClassPathResource CPR_RETAILEVENT = _getCPR ("UBL-RetailEvent-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRetailEventXSDs ()
  {
    return _getAllXSDs (CPR_RETAILEVENT);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <RetailEventType> retailEvent ()
  {
    return new UBL22JAXBMarshaller <> (RetailEventType.class,
                                       getAllRetailEventXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.retailevent_22.ObjectFactory._RetailEvent_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDCREDITNOTE = _getCPR ("UBL-SelfBilledCreditNote-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDCREDITNOTE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return new UBL22JAXBMarshaller <> (SelfBilledCreditNoteType.class,
                                       getAllSelfBilledCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_22.ObjectFactory._SelfBilledCreditNote_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDINVOICE = _getCPR ("UBL-SelfBilledInvoice-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDINVOICE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return new UBL22JAXBMarshaller <> (SelfBilledInvoiceType.class,
                                       getAllSelfBilledInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_22.ObjectFactory._SelfBilledInvoice_QNAME);
  }

  private static final ClassPathResource CPR_STATEMENT = _getCPR ("UBL-Statement-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllStatementXSDs ()
  {
    return _getAllXSDs (CPR_STATEMENT);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <StatementType> statement ()
  {
    return new UBL22JAXBMarshaller <> (StatementType.class,
                                       getAllStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.statement_22.ObjectFactory._Statement_QNAME);
  }

  private static final ClassPathResource CPR_STOCKAVAILABILITYREPORT = _getCPR ("UBL-StockAvailabilityReport-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllStockAvailabilityReportXSDs ()
  {
    return _getAllXSDs (CPR_STOCKAVAILABILITYREPORT);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return new UBL22JAXBMarshaller <> (StockAvailabilityReportType.class,
                                       getAllStockAvailabilityReportXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_22.ObjectFactory._StockAvailabilityReport_QNAME);
  }

  private static final ClassPathResource CPR_TENDER = _getCPR ("UBL-Tender-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderXSDs ()
  {
    return _getAllXSDs (CPR_TENDER);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderType> tender ()
  {
    return new UBL22JAXBMarshaller <> (TenderType.class,
                                       getAllTenderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tender_22.ObjectFactory._Tender_QNAME);
  }

  private static final ClassPathResource CPR_TENDERCONTRACT = _getCPR ("UBL-TenderContract-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderContractXSDs ()
  {
    return _getAllXSDs (CPR_TENDERCONTRACT);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderContractType> tenderContract ()
  {
    return new UBL22JAXBMarshaller <> (TenderContractType.class,
                                       getAllTenderContractXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendercontract_22.ObjectFactory._TenderContract_QNAME);
  }

  private static final ClassPathResource CPR_TENDERRECEIPT = _getCPR ("UBL-TenderReceipt-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderReceiptXSDs ()
  {
    return _getAllXSDs (CPR_TENDERRECEIPT);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderReceiptType> tenderReceipt ()
  {
    return new UBL22JAXBMarshaller <> (TenderReceiptType.class,
                                       getAllTenderReceiptXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderreceipt_22.ObjectFactory._TenderReceipt_QNAME);
  }

  private static final ClassPathResource CPR_TENDERSTATUS = _getCPR ("UBL-TenderStatus-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderStatusXSDs ()
  {
    return _getAllXSDs (CPR_TENDERSTATUS);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderStatusType> tenderStatus ()
  {
    return new UBL22JAXBMarshaller <> (TenderStatusType.class,
                                       getAllTenderStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatus_22.ObjectFactory._TenderStatus_QNAME);
  }

  private static final ClassPathResource CPR_TENDERSTATUSREQUEST = _getCPR ("UBL-TenderStatusRequest-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TENDERSTATUSREQUEST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderStatusRequestType> tenderStatusRequest ()
  {
    return new UBL22JAXBMarshaller <> (TenderStatusRequestType.class,
                                       getAllTenderStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_22.ObjectFactory._TenderStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TENDERWITHDRAWAL = _getCPR ("UBL-TenderWithdrawal-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTenderWithdrawalXSDs ()
  {
    return _getAllXSDs (CPR_TENDERWITHDRAWAL);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderWithdrawalType> tenderWithdrawal ()
  {
    return new UBL22JAXBMarshaller <> (TenderWithdrawalType.class,
                                       getAllTenderWithdrawalXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_22.ObjectFactory._TenderWithdrawal_QNAME);
  }

  private static final ClassPathResource CPR_TENDERERQUALIFICATION = _getCPR ("UBL-TendererQualification-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTendererQualificationXSDs ()
  {
    return _getAllXSDs (CPR_TENDERERQUALIFICATION);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TendererQualificationType> tendererQualification ()
  {
    return new UBL22JAXBMarshaller <> (TendererQualificationType.class,
                                       getAllTendererQualificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualification_22.ObjectFactory._TendererQualification_QNAME);
  }

  private static final ClassPathResource CPR_TENDERERQUALIFICATIONRESPONSE = _getCPR ("UBL-TendererQualificationResponse-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTendererQualificationResponseXSDs ()
  {
    return _getAllXSDs (CPR_TENDERERQUALIFICATIONRESPONSE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return new UBL22JAXBMarshaller <> (TendererQualificationResponseType.class,
                                       getAllTendererQualificationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_22.ObjectFactory._TendererQualificationResponse_QNAME);
  }

  private static final ClassPathResource CPR_TRADEITEMLOCATIONPROFILE = _getCPR ("UBL-TradeItemLocationProfile-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTradeItemLocationProfileXSDs ()
  {
    return _getAllXSDs (CPR_TRADEITEMLOCATIONPROFILE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return new UBL22JAXBMarshaller <> (TradeItemLocationProfileType.class,
                                       getAllTradeItemLocationProfileXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_22.ObjectFactory._TradeItemLocationProfile_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTEXECUTIONPLAN = _getCPR ("UBL-TransportExecutionPlan-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportExecutionPlanXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTEXECUTIONPLAN);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return new UBL22JAXBMarshaller <> (TransportExecutionPlanType.class,
                                       getAllTransportExecutionPlanXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplan_22.ObjectFactory._TransportExecutionPlan_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTEXECUTIONPLANREQUEST = _getCPR ("UBL-TransportExecutionPlanRequest-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportExecutionPlanRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTEXECUTIONPLANREQUEST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return new UBL22JAXBMarshaller <> (TransportExecutionPlanRequestType.class,
                                       getAllTransportExecutionPlanRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_22.ObjectFactory._TransportExecutionPlanRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTPROGRESSSTATUS = _getCPR ("UBL-TransportProgressStatus-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportProgressStatusXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTPROGRESSSTATUS);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportProgressStatusType> transportProgressStatus ()
  {
    return new UBL22JAXBMarshaller <> (TransportProgressStatusType.class,
                                       getAllTransportProgressStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatus_22.ObjectFactory._TransportProgressStatus_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTPROGRESSSTATUSREQUEST = _getCPR ("UBL-TransportProgressStatusRequest-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportProgressStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTPROGRESSSTATUSREQUEST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return new UBL22JAXBMarshaller <> (TransportProgressStatusRequestType.class,
                                       getAllTransportProgressStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_22.ObjectFactory._TransportProgressStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTSERVICEDESCRIPTION = _getCPR ("UBL-TransportServiceDescription-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportServiceDescriptionXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTSERVICEDESCRIPTION);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return new UBL22JAXBMarshaller <> (TransportServiceDescriptionType.class,
                                       getAllTransportServiceDescriptionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescription_22.ObjectFactory._TransportServiceDescription_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTSERVICEDESCRIPTIONREQUEST = _getCPR ("UBL-TransportServiceDescriptionRequest-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportServiceDescriptionRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTSERVICEDESCRIPTIONREQUEST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return new UBL22JAXBMarshaller <> (TransportServiceDescriptionRequestType.class,
                                       getAllTransportServiceDescriptionRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_22.ObjectFactory._TransportServiceDescriptionRequest_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTATIONSTATUS = _getCPR ("UBL-TransportationStatus-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportationStatusXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTATIONSTATUS);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportationStatusType> transportationStatus ()
  {
    return new UBL22JAXBMarshaller <> (TransportationStatusType.class,
                                       getAllTransportationStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatus_22.ObjectFactory._TransportationStatus_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTATIONSTATUSREQUEST = _getCPR ("UBL-TransportationStatusRequest-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportationStatusRequestXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTATIONSTATUSREQUEST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return new UBL22JAXBMarshaller <> (TransportationStatusRequestType.class,
                                       getAllTransportationStatusRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_22.ObjectFactory._TransportationStatusRequest_QNAME);
  }

  private static final ClassPathResource CPR_UNAWARDEDNOTIFICATION = _getCPR ("UBL-UnawardedNotification-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnawardedNotificationXSDs ()
  {
    return _getAllXSDs (CPR_UNAWARDEDNOTIFICATION);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <UnawardedNotificationType> unawardedNotification ()
  {
    return new UBL22JAXBMarshaller <> (UnawardedNotificationType.class,
                                       getAllUnawardedNotificationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unawardednotification_22.ObjectFactory._UnawardedNotification_QNAME);
  }

  private static final ClassPathResource CPR_UNSUBSCRIBEFROMPROCEDUREREQUEST = _getCPR ("UBL-UnsubscribeFromProcedureRequest-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnsubscribeFromProcedureRequestXSDs ()
  {
    return _getAllXSDs (CPR_UNSUBSCRIBEFROMPROCEDUREREQUEST);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest ()
  {
    return new UBL22JAXBMarshaller <> (UnsubscribeFromProcedureRequestType.class,
                                       getAllUnsubscribeFromProcedureRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_22.ObjectFactory._UnsubscribeFromProcedureRequest_QNAME);
  }

  private static final ClassPathResource CPR_UNSUBSCRIBEFROMPROCEDURERESPONSE = _getCPR ("UBL-UnsubscribeFromProcedureResponse-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUnsubscribeFromProcedureResponseXSDs ()
  {
    return _getAllXSDs (CPR_UNSUBSCRIBEFROMPROCEDURERESPONSE);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse ()
  {
    return new UBL22JAXBMarshaller <> (UnsubscribeFromProcedureResponseType.class,
                                       getAllUnsubscribeFromProcedureResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_22.ObjectFactory._UnsubscribeFromProcedureResponse_QNAME);
  }

  private static final ClassPathResource CPR_UTILITYSTATEMENT = _getCPR ("UBL-UtilityStatement-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllUtilityStatementXSDs ()
  {
    return _getAllXSDs (CPR_UTILITYSTATEMENT);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <UtilityStatementType> utilityStatement ()
  {
    return new UBL22JAXBMarshaller <> (UtilityStatementType.class,
                                       getAllUtilityStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.utilitystatement_22.ObjectFactory._UtilityStatement_QNAME);
  }

  private static final ClassPathResource CPR_WAYBILL = _getCPR ("UBL-Waybill-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWaybillXSDs ()
  {
    return _getAllXSDs (CPR_WAYBILL);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <WaybillType> waybill ()
  {
    return new UBL22JAXBMarshaller <> (WaybillType.class,
                                       getAllWaybillXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.waybill_22.ObjectFactory._Waybill_QNAME);
  }

  private static final ClassPathResource CPR_WEIGHTSTATEMENT = _getCPR ("UBL-WeightStatement-2.2.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWeightStatementXSDs ()
  {
    return _getAllXSDs (CPR_WEIGHTSTATEMENT);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <WeightStatementType> weightStatement ()
  {
    return new UBL22JAXBMarshaller <> (WeightStatementType.class,
                                       getAllWeightStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.weightstatement_22.ObjectFactory._WeightStatement_QNAME);
  }
}
