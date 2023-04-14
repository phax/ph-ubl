package com.helger.ubl23;

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
    @Nonnull
    public static ICommonsList <ClassPathResource> getAllXSDs (@Nonnull final ClassPathResource aXSD)
    {
      return new CommonsArrayList <> (CCCTS.getXSDResource (),
                                      CXMLDSig.getXSDResource (),
                                      CXAdES132.getXSDResource (),
                                      CXAdES141.getXSDResource (),
                                      aXSD);
    }

    public UBL23JAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nonnull final ClassPathResource aXSD,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, getAllXSDs (aXSD), createSimpleJAXBElement (aRootElementQName, aType));

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBL23NamespaceContext.getInstance ().getClone ();
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

  private UBL23Marshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CUBL23.SCHEMA_DIRECTORY + sXSDPath, CUBL23.getCL ());
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new UBL23JAXBMarshaller <> (ApplicationResponseType.class,
                                       _getCPR ("UBL-ApplicationResponse-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.applicationresponse_23.ObjectFactory._ApplicationResponse_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new UBL23JAXBMarshaller <> (AttachedDocumentType.class,
                                       _getCPR ("UBL-AttachedDocument-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.attacheddocument_23.ObjectFactory._AttachedDocument_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <AwardedNotificationType> awardedNotification ()
  {
    return new UBL23JAXBMarshaller <> (AwardedNotificationType.class,
                                       _getCPR ("UBL-AwardedNotification-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.awardednotification_23.ObjectFactory._AwardedNotification_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <BillOfLadingType> billOfLading ()
  {
    return new UBL23JAXBMarshaller <> (BillOfLadingType.class,
                                       _getCPR ("UBL-BillOfLading-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.billoflading_23.ObjectFactory._BillOfLading_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <BusinessCardType> businessCard ()
  {
    return new UBL23JAXBMarshaller <> (BusinessCardType.class,
                                       _getCPR ("UBL-BusinessCard-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.businesscard_23.ObjectFactory._BusinessCard_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CallForTendersType> callForTenders ()
  {
    return new UBL23JAXBMarshaller <> (CallForTendersType.class,
                                       _getCPR ("UBL-CallForTenders-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.callfortenders_23.ObjectFactory._CallForTenders_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CatalogueType> catalogue ()
  {
    return new UBL23JAXBMarshaller <> (CatalogueType.class,
                                       _getCPR ("UBL-Catalogue-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.catalogue_23.ObjectFactory._Catalogue_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CatalogueDeletionType> catalogueDeletion ()
  {
    return new UBL23JAXBMarshaller <> (CatalogueDeletionType.class,
                                       _getCPR ("UBL-CatalogueDeletion-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguedeletion_23.ObjectFactory._CatalogueDeletion_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return new UBL23JAXBMarshaller <> (CatalogueItemSpecificationUpdateType.class,
                                       _getCPR ("UBL-CatalogueItemSpecificationUpdate-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_23.ObjectFactory._CatalogueItemSpecificationUpdate_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return new UBL23JAXBMarshaller <> (CataloguePricingUpdateType.class,
                                       _getCPR ("UBL-CataloguePricingUpdate-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_23.ObjectFactory._CataloguePricingUpdate_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CatalogueRequestType> catalogueRequest ()
  {
    return new UBL23JAXBMarshaller <> (CatalogueRequestType.class,
                                       _getCPR ("UBL-CatalogueRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguerequest_23.ObjectFactory._CatalogueRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CertificateOfOriginType> certificateOfOrigin ()
  {
    return new UBL23JAXBMarshaller <> (CertificateOfOriginType.class,
                                       _getCPR ("UBL-CertificateOfOrigin-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.certificateoforigin_23.ObjectFactory._CertificateOfOrigin_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CommonTransportationReportType> commonTransportationReport ()
  {
    return new UBL23JAXBMarshaller <> (CommonTransportationReportType.class,
                                       _getCPR ("UBL-CommonTransportationReport-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.commontransportationreport_23.ObjectFactory._CommonTransportationReport_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ContractAwardNoticeType> contractAwardNotice ()
  {
    return new UBL23JAXBMarshaller <> (ContractAwardNoticeType.class,
                                       _getCPR ("UBL-ContractAwardNotice-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ObjectFactory._ContractAwardNotice_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ContractNoticeType> contractNotice ()
  {
    return new UBL23JAXBMarshaller <> (ContractNoticeType.class,
                                       _getCPR ("UBL-ContractNotice-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.contractnotice_23.ObjectFactory._ContractNotice_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new UBL23JAXBMarshaller <> (CreditNoteType.class,
                                       _getCPR ("UBL-CreditNote-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_23.ObjectFactory._CreditNote_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new UBL23JAXBMarshaller <> (DebitNoteType.class,
                                       _getCPR ("UBL-DebitNote-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.debitnote_23.ObjectFactory._DebitNote_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DespatchAdviceType> despatchAdvice ()
  {
    return new UBL23JAXBMarshaller <> (DespatchAdviceType.class,
                                       _getCPR ("UBL-DespatchAdvice-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.despatchadvice_23.ObjectFactory._DespatchAdvice_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DigitalAgreementType> digitalAgreement ()
  {
    return new UBL23JAXBMarshaller <> (DigitalAgreementType.class,
                                       _getCPR ("UBL-DigitalAgreement-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.digitalagreement_23.ObjectFactory._DigitalAgreement_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DigitalCapabilityType> digitalCapability ()
  {
    return new UBL23JAXBMarshaller <> (DigitalCapabilityType.class,
                                       _getCPR ("UBL-DigitalCapability-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.digitalcapability_23.ObjectFactory._DigitalCapability_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DocumentStatusType> documentStatus ()
  {
    return new UBL23JAXBMarshaller <> (DocumentStatusType.class,
                                       _getCPR ("UBL-DocumentStatus-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.documentstatus_23.ObjectFactory._DocumentStatus_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <DocumentStatusRequestType> documentStatusRequest ()
  {
    return new UBL23JAXBMarshaller <> (DocumentStatusRequestType.class,
                                       _getCPR ("UBL-DocumentStatusRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.documentstatusrequest_23.ObjectFactory._DocumentStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <EnquiryType> enquiry ()
  {
    return new UBL23JAXBMarshaller <> (EnquiryType.class,
                                       _getCPR ("UBL-Enquiry-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.enquiry_23.ObjectFactory._Enquiry_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <EnquiryResponseType> enquiryResponse ()
  {
    return new UBL23JAXBMarshaller <> (EnquiryResponseType.class,
                                       _getCPR ("UBL-EnquiryResponse-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.enquiryresponse_23.ObjectFactory._EnquiryResponse_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ExceptionCriteriaType> exceptionCriteria ()
  {
    return new UBL23JAXBMarshaller <> (ExceptionCriteriaType.class,
                                       _getCPR ("UBL-ExceptionCriteria-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.exceptioncriteria_23.ObjectFactory._ExceptionCriteria_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ExceptionNotificationType> exceptionNotification ()
  {
    return new UBL23JAXBMarshaller <> (ExceptionNotificationType.class,
                                       _getCPR ("UBL-ExceptionNotification-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.exceptionnotification_23.ObjectFactory._ExceptionNotification_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ExportCustomsDeclarationType> exportCustomsDeclaration ()
  {
    return new UBL23JAXBMarshaller <> (ExportCustomsDeclarationType.class,
                                       _getCPR ("UBL-ExportCustomsDeclaration-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_23.ObjectFactory._ExportCustomsDeclaration_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ExpressionOfInterestRequestType> expressionOfInterestRequest ()
  {
    return new UBL23JAXBMarshaller <> (ExpressionOfInterestRequestType.class,
                                       _getCPR ("UBL-ExpressionOfInterestRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_23.ObjectFactory._ExpressionOfInterestRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ExpressionOfInterestResponseType> expressionOfInterestResponse ()
  {
    return new UBL23JAXBMarshaller <> (ExpressionOfInterestResponseType.class,
                                       _getCPR ("UBL-ExpressionOfInterestResponse-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_23.ObjectFactory._ExpressionOfInterestResponse_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ForecastType> forecast ()
  {
    return new UBL23JAXBMarshaller <> (ForecastType.class,
                                       _getCPR ("UBL-Forecast-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forecast_23.ObjectFactory._Forecast_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ForecastRevisionType> forecastRevision ()
  {
    return new UBL23JAXBMarshaller <> (ForecastRevisionType.class,
                                       _getCPR ("UBL-ForecastRevision-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forecastrevision_23.ObjectFactory._ForecastRevision_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ForwardingInstructionsType> forwardingInstructions ()
  {
    return new UBL23JAXBMarshaller <> (ForwardingInstructionsType.class,
                                       _getCPR ("UBL-ForwardingInstructions-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forwardinginstructions_23.ObjectFactory._ForwardingInstructions_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <FreightInvoiceType> freightInvoice ()
  {
    return new UBL23JAXBMarshaller <> (FreightInvoiceType.class,
                                       _getCPR ("UBL-FreightInvoice-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.freightinvoice_23.ObjectFactory._FreightInvoice_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return new UBL23JAXBMarshaller <> (FulfilmentCancellationType.class,
                                       _getCPR ("UBL-FulfilmentCancellation-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_23.ObjectFactory._FulfilmentCancellation_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <GoodsCertificateType> goodsCertificate ()
  {
    return new UBL23JAXBMarshaller <> (GoodsCertificateType.class,
                                       _getCPR ("UBL-GoodsCertificate-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.goodscertificate_23.ObjectFactory._GoodsCertificate_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return new UBL23JAXBMarshaller <> (GoodsItemItineraryType.class,
                                       _getCPR ("UBL-GoodsItemItinerary-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_23.ObjectFactory._GoodsItemItinerary_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <GoodsItemPassportType> goodsItemPassport ()
  {
    return new UBL23JAXBMarshaller <> (GoodsItemPassportType.class,
                                       _getCPR ("UBL-GoodsItemPassport-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.goodsitempassport_23.ObjectFactory._GoodsItemPassport_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return new UBL23JAXBMarshaller <> (GuaranteeCertificateType.class,
                                       _getCPR ("UBL-GuaranteeCertificate-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.guaranteecertificate_23.ObjectFactory._GuaranteeCertificate_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ImportCustomsDeclarationType> importCustomsDeclaration ()
  {
    return new UBL23JAXBMarshaller <> (ImportCustomsDeclarationType.class,
                                       _getCPR ("UBL-ImportCustomsDeclaration-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_23.ObjectFactory._ImportCustomsDeclaration_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <InstructionForReturnsType> instructionForReturns ()
  {
    return new UBL23JAXBMarshaller <> (InstructionForReturnsType.class,
                                       _getCPR ("UBL-InstructionForReturns-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.instructionforreturns_23.ObjectFactory._InstructionForReturns_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <InventoryReportType> inventoryReport ()
  {
    return new UBL23JAXBMarshaller <> (InventoryReportType.class,
                                       _getCPR ("UBL-InventoryReport-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.inventoryreport_23.ObjectFactory._InventoryReport_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <InvoiceType> invoice ()
  {
    return new UBL23JAXBMarshaller <> (InvoiceType.class,
                                       _getCPR ("UBL-Invoice-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.invoice_23.ObjectFactory._Invoice_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ItemInformationRequestType> itemInformationRequest ()
  {
    return new UBL23JAXBMarshaller <> (ItemInformationRequestType.class,
                                       _getCPR ("UBL-ItemInformationRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.iteminformationrequest_23.ObjectFactory._ItemInformationRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ManifestType> manifest ()
  {
    return new UBL23JAXBMarshaller <> (ManifestType.class,
                                       _getCPR ("UBL-Manifest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.manifest_23.ObjectFactory._Manifest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <OrderType> order ()
  {
    return new UBL23JAXBMarshaller <> (OrderType.class,
                                       _getCPR ("UBL-Order-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.order_23.ObjectFactory._Order_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <OrderCancellationType> orderCancellation ()
  {
    return new UBL23JAXBMarshaller <> (OrderCancellationType.class,
                                       _getCPR ("UBL-OrderCancellation-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.ordercancellation_23.ObjectFactory._OrderCancellation_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <OrderChangeType> orderChange ()
  {
    return new UBL23JAXBMarshaller <> (OrderChangeType.class,
                                       _getCPR ("UBL-OrderChange-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderchange_23.ObjectFactory._OrderChange_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <OrderResponseType> orderResponse ()
  {
    return new UBL23JAXBMarshaller <> (OrderResponseType.class,
                                       _getCPR ("UBL-OrderResponse-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderresponse_23.ObjectFactory._OrderResponse_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <OrderResponseSimpleType> orderResponseSimple ()
  {
    return new UBL23JAXBMarshaller <> (OrderResponseSimpleType.class,
                                       _getCPR ("UBL-OrderResponseSimple-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderresponsesimple_23.ObjectFactory._OrderResponseSimple_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <PackingListType> packingList ()
  {
    return new UBL23JAXBMarshaller <> (PackingListType.class,
                                       _getCPR ("UBL-PackingList-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.packinglist_23.ObjectFactory._PackingList_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <PriorInformationNoticeType> priorInformationNotice ()
  {
    return new UBL23JAXBMarshaller <> (PriorInformationNoticeType.class,
                                       _getCPR ("UBL-PriorInformationNotice-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.ObjectFactory._PriorInformationNotice_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ProductActivityType> productActivity ()
  {
    return new UBL23JAXBMarshaller <> (ProductActivityType.class,
                                       _getCPR ("UBL-ProductActivity-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.productactivity_23.ObjectFactory._ProductActivity_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ProofOfReexportationType> proofOfReexportation ()
  {
    return new UBL23JAXBMarshaller <> (ProofOfReexportationType.class,
                                       _getCPR ("UBL-ProofOfReexportation-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportation_23.ObjectFactory._ProofOfReexportation_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ProofOfReexportationReminderType> proofOfReexportationReminder ()
  {
    return new UBL23JAXBMarshaller <> (ProofOfReexportationReminderType.class,
                                       _getCPR ("UBL-ProofOfReexportationReminder-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_23.ObjectFactory._ProofOfReexportationReminder_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ProofOfReexportationRequestType> proofOfReexportationRequest ()
  {
    return new UBL23JAXBMarshaller <> (ProofOfReexportationRequestType.class,
                                       _getCPR ("UBL-ProofOfReexportationRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_23.ObjectFactory._ProofOfReexportationRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <QualificationApplicationRequestType> qualificationApplicationRequest ()
  {
    return new UBL23JAXBMarshaller <> (QualificationApplicationRequestType.class,
                                       _getCPR ("UBL-QualificationApplicationRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_23.ObjectFactory._QualificationApplicationRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <QualificationApplicationResponseType> qualificationApplicationResponse ()
  {
    return new UBL23JAXBMarshaller <> (QualificationApplicationResponseType.class,
                                       _getCPR ("UBL-QualificationApplicationResponse-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_23.ObjectFactory._QualificationApplicationResponse_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <QuotationType> quotation ()
  {
    return new UBL23JAXBMarshaller <> (QuotationType.class,
                                       _getCPR ("UBL-Quotation-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.quotation_23.ObjectFactory._Quotation_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ReceiptAdviceType> receiptAdvice ()
  {
    return new UBL23JAXBMarshaller <> (ReceiptAdviceType.class,
                                       _getCPR ("UBL-ReceiptAdvice-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.receiptadvice_23.ObjectFactory._ReceiptAdvice_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <ReminderType> reminder ()
  {
    return new UBL23JAXBMarshaller <> (ReminderType.class,
                                       _getCPR ("UBL-Reminder-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.reminder_23.ObjectFactory._Reminder_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <RemittanceAdviceType> remittanceAdvice ()
  {
    return new UBL23JAXBMarshaller <> (RemittanceAdviceType.class,
                                       _getCPR ("UBL-RemittanceAdvice-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.remittanceadvice_23.ObjectFactory._RemittanceAdvice_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <RequestForQuotationType> requestForQuotation ()
  {
    return new UBL23JAXBMarshaller <> (RequestForQuotationType.class,
                                       _getCPR ("UBL-RequestForQuotation-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.requestforquotation_23.ObjectFactory._RequestForQuotation_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <RetailEventType> retailEvent ()
  {
    return new UBL23JAXBMarshaller <> (RetailEventType.class,
                                       _getCPR ("UBL-RetailEvent-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.retailevent_23.ObjectFactory._RetailEvent_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return new UBL23JAXBMarshaller <> (SelfBilledCreditNoteType.class,
                                       _getCPR ("UBL-SelfBilledCreditNote-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_23.ObjectFactory._SelfBilledCreditNote_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return new UBL23JAXBMarshaller <> (SelfBilledInvoiceType.class,
                                       _getCPR ("UBL-SelfBilledInvoice-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_23.ObjectFactory._SelfBilledInvoice_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <StatementType> statement ()
  {
    return new UBL23JAXBMarshaller <> (StatementType.class,
                                       _getCPR ("UBL-Statement-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.statement_23.ObjectFactory._Statement_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return new UBL23JAXBMarshaller <> (StockAvailabilityReportType.class,
                                       _getCPR ("UBL-StockAvailabilityReport-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_23.ObjectFactory._StockAvailabilityReport_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderType> tender ()
  {
    return new UBL23JAXBMarshaller <> (TenderType.class,
                                       _getCPR ("UBL-Tender-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tender_23.ObjectFactory._Tender_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderContractType> tenderContract ()
  {
    return new UBL23JAXBMarshaller <> (TenderContractType.class,
                                       _getCPR ("UBL-TenderContract-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tendercontract_23.ObjectFactory._TenderContract_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TendererQualificationType> tendererQualification ()
  {
    return new UBL23JAXBMarshaller <> (TendererQualificationType.class,
                                       _getCPR ("UBL-TendererQualification-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualification_23.ObjectFactory._TendererQualification_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return new UBL23JAXBMarshaller <> (TendererQualificationResponseType.class,
                                       _getCPR ("UBL-TendererQualificationResponse-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_23.ObjectFactory._TendererQualificationResponse_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderReceiptType> tenderReceipt ()
  {
    return new UBL23JAXBMarshaller <> (TenderReceiptType.class,
                                       _getCPR ("UBL-TenderReceipt-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderreceipt_23.ObjectFactory._TenderReceipt_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderStatusType> tenderStatus ()
  {
    return new UBL23JAXBMarshaller <> (TenderStatusType.class,
                                       _getCPR ("UBL-TenderStatus-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatus_23.ObjectFactory._TenderStatus_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderStatusRequestType> tenderStatusRequest ()
  {
    return new UBL23JAXBMarshaller <> (TenderStatusRequestType.class,
                                       _getCPR ("UBL-TenderStatusRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_23.ObjectFactory._TenderStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TenderWithdrawalType> tenderWithdrawal ()
  {
    return new UBL23JAXBMarshaller <> (TenderWithdrawalType.class,
                                       _getCPR ("UBL-TenderWithdrawal-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_23.ObjectFactory._TenderWithdrawal_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return new UBL23JAXBMarshaller <> (TradeItemLocationProfileType.class,
                                       _getCPR ("UBL-TradeItemLocationProfile-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_23.ObjectFactory._TradeItemLocationProfile_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransitCustomsDeclarationType> transitCustomsDeclaration ()
  {
    return new UBL23JAXBMarshaller <> (TransitCustomsDeclarationType.class,
                                       _getCPR ("UBL-TransitCustomsDeclaration-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_23.ObjectFactory._TransitCustomsDeclaration_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportationStatusType> transportationStatus ()
  {
    return new UBL23JAXBMarshaller <> (TransportationStatusType.class,
                                       _getCPR ("UBL-TransportationStatus-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatus_23.ObjectFactory._TransportationStatus_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return new UBL23JAXBMarshaller <> (TransportationStatusRequestType.class,
                                       _getCPR ("UBL-TransportationStatusRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_23.ObjectFactory._TransportationStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return new UBL23JAXBMarshaller <> (TransportExecutionPlanType.class,
                                       _getCPR ("UBL-TransportExecutionPlan-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplan_23.ObjectFactory._TransportExecutionPlan_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return new UBL23JAXBMarshaller <> (TransportExecutionPlanRequestType.class,
                                       _getCPR ("UBL-TransportExecutionPlanRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_23.ObjectFactory._TransportExecutionPlanRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportProgressStatusType> transportProgressStatus ()
  {
    return new UBL23JAXBMarshaller <> (TransportProgressStatusType.class,
                                       _getCPR ("UBL-TransportProgressStatus-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatus_23.ObjectFactory._TransportProgressStatus_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return new UBL23JAXBMarshaller <> (TransportProgressStatusRequestType.class,
                                       _getCPR ("UBL-TransportProgressStatusRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_23.ObjectFactory._TransportProgressStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return new UBL23JAXBMarshaller <> (TransportServiceDescriptionType.class,
                                       _getCPR ("UBL-TransportServiceDescription-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescription_23.ObjectFactory._TransportServiceDescription_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return new UBL23JAXBMarshaller <> (TransportServiceDescriptionRequestType.class,
                                       _getCPR ("UBL-TransportServiceDescriptionRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_23.ObjectFactory._TransportServiceDescriptionRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <UnawardedNotificationType> unawardedNotification ()
  {
    return new UBL23JAXBMarshaller <> (UnawardedNotificationType.class,
                                       _getCPR ("UBL-UnawardedNotification-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.unawardednotification_23.ObjectFactory._UnawardedNotification_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest ()
  {
    return new UBL23JAXBMarshaller <> (UnsubscribeFromProcedureRequestType.class,
                                       _getCPR ("UBL-UnsubscribeFromProcedureRequest-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_23.ObjectFactory._UnsubscribeFromProcedureRequest_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse ()
  {
    return new UBL23JAXBMarshaller <> (UnsubscribeFromProcedureResponseType.class,
                                       _getCPR ("UBL-UnsubscribeFromProcedureResponse-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_23.ObjectFactory._UnsubscribeFromProcedureResponse_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <UtilityStatementType> utilityStatement ()
  {
    return new UBL23JAXBMarshaller <> (UtilityStatementType.class,
                                       _getCPR ("UBL-UtilityStatement-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.utilitystatement_23.ObjectFactory._UtilityStatement_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <WaybillType> waybill ()
  {
    return new UBL23JAXBMarshaller <> (WaybillType.class,
                                       _getCPR ("UBL-Waybill-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.waybill_23.ObjectFactory._Waybill_QNAME);
  }

  @Nonnull
  public static UBL23JAXBMarshaller <WeightStatementType> weightStatement ()
  {
    return new UBL23JAXBMarshaller <> (WeightStatementType.class,
                                       _getCPR ("UBL-WeightStatement-2.3.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.weightstatement_23.ObjectFactory._WeightStatement_QNAME);
  }
}
