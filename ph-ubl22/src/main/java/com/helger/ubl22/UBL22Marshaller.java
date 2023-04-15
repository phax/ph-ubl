package com.helger.ubl22;

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

    public UBL22JAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nonnull final ClassPathResource aXSD,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, getAllXSDs (aXSD), createSimpleJAXBElement (aRootElementQName, aType));

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBL22NamespaceContext.getInstance ().getClone ();
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

  private UBL22Marshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CUBL22.SCHEMA_DIRECTORY + sXSDPath, CUBL22.getCL ());
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new UBL22JAXBMarshaller <> (ApplicationResponseType.class,
                                       _getCPR ("UBL-ApplicationResponse-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.applicationresponse_22.ObjectFactory._ApplicationResponse_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new UBL22JAXBMarshaller <> (AttachedDocumentType.class,
                                       _getCPR ("UBL-AttachedDocument-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.attacheddocument_22.ObjectFactory._AttachedDocument_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <AwardedNotificationType> awardedNotification ()
  {
    return new UBL22JAXBMarshaller <> (AwardedNotificationType.class,
                                       _getCPR ("UBL-AwardedNotification-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.awardednotification_22.ObjectFactory._AwardedNotification_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <BillOfLadingType> billOfLading ()
  {
    return new UBL22JAXBMarshaller <> (BillOfLadingType.class,
                                       _getCPR ("UBL-BillOfLading-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.billoflading_22.ObjectFactory._BillOfLading_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <BusinessCardType> businessCard ()
  {
    return new UBL22JAXBMarshaller <> (BusinessCardType.class,
                                       _getCPR ("UBL-BusinessCard-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.businesscard_22.ObjectFactory._BusinessCard_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CallForTendersType> callForTenders ()
  {
    return new UBL22JAXBMarshaller <> (CallForTendersType.class,
                                       _getCPR ("UBL-CallForTenders-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.callfortenders_22.ObjectFactory._CallForTenders_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CatalogueType> catalogue ()
  {
    return new UBL22JAXBMarshaller <> (CatalogueType.class,
                                       _getCPR ("UBL-Catalogue-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.catalogue_22.ObjectFactory._Catalogue_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CatalogueDeletionType> catalogueDeletion ()
  {
    return new UBL22JAXBMarshaller <> (CatalogueDeletionType.class,
                                       _getCPR ("UBL-CatalogueDeletion-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguedeletion_22.ObjectFactory._CatalogueDeletion_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return new UBL22JAXBMarshaller <> (CatalogueItemSpecificationUpdateType.class,
                                       _getCPR ("UBL-CatalogueItemSpecificationUpdate-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_22.ObjectFactory._CatalogueItemSpecificationUpdate_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return new UBL22JAXBMarshaller <> (CataloguePricingUpdateType.class,
                                       _getCPR ("UBL-CataloguePricingUpdate-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_22.ObjectFactory._CataloguePricingUpdate_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CatalogueRequestType> catalogueRequest ()
  {
    return new UBL22JAXBMarshaller <> (CatalogueRequestType.class,
                                       _getCPR ("UBL-CatalogueRequest-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguerequest_22.ObjectFactory._CatalogueRequest_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CertificateOfOriginType> certificateOfOrigin ()
  {
    return new UBL22JAXBMarshaller <> (CertificateOfOriginType.class,
                                       _getCPR ("UBL-CertificateOfOrigin-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.certificateoforigin_22.ObjectFactory._CertificateOfOrigin_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ContractAwardNoticeType> contractAwardNotice ()
  {
    return new UBL22JAXBMarshaller <> (ContractAwardNoticeType.class,
                                       _getCPR ("UBL-ContractAwardNotice-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.contractawardnotice_22.ObjectFactory._ContractAwardNotice_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ContractNoticeType> contractNotice ()
  {
    return new UBL22JAXBMarshaller <> (ContractNoticeType.class,
                                       _getCPR ("UBL-ContractNotice-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.contractnotice_22.ObjectFactory._ContractNotice_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new UBL22JAXBMarshaller <> (CreditNoteType.class,
                                       _getCPR ("UBL-CreditNote-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_22.ObjectFactory._CreditNote_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new UBL22JAXBMarshaller <> (DebitNoteType.class,
                                       _getCPR ("UBL-DebitNote-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.debitnote_22.ObjectFactory._DebitNote_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DespatchAdviceType> despatchAdvice ()
  {
    return new UBL22JAXBMarshaller <> (DespatchAdviceType.class,
                                       _getCPR ("UBL-DespatchAdvice-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.despatchadvice_22.ObjectFactory._DespatchAdvice_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DigitalAgreementType> digitalAgreement ()
  {
    return new UBL22JAXBMarshaller <> (DigitalAgreementType.class,
                                       _getCPR ("UBL-DigitalAgreement-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.digitalagreement_22.ObjectFactory._DigitalAgreement_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DigitalCapabilityType> digitalCapability ()
  {
    return new UBL22JAXBMarshaller <> (DigitalCapabilityType.class,
                                       _getCPR ("UBL-DigitalCapability-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.digitalcapability_22.ObjectFactory._DigitalCapability_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DocumentStatusType> documentStatus ()
  {
    return new UBL22JAXBMarshaller <> (DocumentStatusType.class,
                                       _getCPR ("UBL-DocumentStatus-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.documentstatus_22.ObjectFactory._DocumentStatus_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <DocumentStatusRequestType> documentStatusRequest ()
  {
    return new UBL22JAXBMarshaller <> (DocumentStatusRequestType.class,
                                       _getCPR ("UBL-DocumentStatusRequest-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.documentstatusrequest_22.ObjectFactory._DocumentStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <EnquiryType> enquiry ()
  {
    return new UBL22JAXBMarshaller <> (EnquiryType.class,
                                       _getCPR ("UBL-Enquiry-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.enquiry_22.ObjectFactory._Enquiry_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <EnquiryResponseType> enquiryResponse ()
  {
    return new UBL22JAXBMarshaller <> (EnquiryResponseType.class,
                                       _getCPR ("UBL-EnquiryResponse-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.enquiryresponse_22.ObjectFactory._EnquiryResponse_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ExceptionCriteriaType> exceptionCriteria ()
  {
    return new UBL22JAXBMarshaller <> (ExceptionCriteriaType.class,
                                       _getCPR ("UBL-ExceptionCriteria-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.exceptioncriteria_22.ObjectFactory._ExceptionCriteria_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ExceptionNotificationType> exceptionNotification ()
  {
    return new UBL22JAXBMarshaller <> (ExceptionNotificationType.class,
                                       _getCPR ("UBL-ExceptionNotification-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.exceptionnotification_22.ObjectFactory._ExceptionNotification_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ExpressionOfInterestRequestType> expressionOfInterestRequest ()
  {
    return new UBL22JAXBMarshaller <> (ExpressionOfInterestRequestType.class,
                                       _getCPR ("UBL-ExpressionOfInterestRequest-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_22.ObjectFactory._ExpressionOfInterestRequest_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ExpressionOfInterestResponseType> expressionOfInterestResponse ()
  {
    return new UBL22JAXBMarshaller <> (ExpressionOfInterestResponseType.class,
                                       _getCPR ("UBL-ExpressionOfInterestResponse-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_22.ObjectFactory._ExpressionOfInterestResponse_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ForecastType> forecast ()
  {
    return new UBL22JAXBMarshaller <> (ForecastType.class,
                                       _getCPR ("UBL-Forecast-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forecast_22.ObjectFactory._Forecast_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ForecastRevisionType> forecastRevision ()
  {
    return new UBL22JAXBMarshaller <> (ForecastRevisionType.class,
                                       _getCPR ("UBL-ForecastRevision-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forecastrevision_22.ObjectFactory._ForecastRevision_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ForwardingInstructionsType> forwardingInstructions ()
  {
    return new UBL22JAXBMarshaller <> (ForwardingInstructionsType.class,
                                       _getCPR ("UBL-ForwardingInstructions-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forwardinginstructions_22.ObjectFactory._ForwardingInstructions_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <FreightInvoiceType> freightInvoice ()
  {
    return new UBL22JAXBMarshaller <> (FreightInvoiceType.class,
                                       _getCPR ("UBL-FreightInvoice-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.freightinvoice_22.ObjectFactory._FreightInvoice_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return new UBL22JAXBMarshaller <> (FulfilmentCancellationType.class,
                                       _getCPR ("UBL-FulfilmentCancellation-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_22.ObjectFactory._FulfilmentCancellation_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return new UBL22JAXBMarshaller <> (GoodsItemItineraryType.class,
                                       _getCPR ("UBL-GoodsItemItinerary-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_22.ObjectFactory._GoodsItemItinerary_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return new UBL22JAXBMarshaller <> (GuaranteeCertificateType.class,
                                       _getCPR ("UBL-GuaranteeCertificate-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.guaranteecertificate_22.ObjectFactory._GuaranteeCertificate_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <InstructionForReturnsType> instructionForReturns ()
  {
    return new UBL22JAXBMarshaller <> (InstructionForReturnsType.class,
                                       _getCPR ("UBL-InstructionForReturns-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.instructionforreturns_22.ObjectFactory._InstructionForReturns_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <InventoryReportType> inventoryReport ()
  {
    return new UBL22JAXBMarshaller <> (InventoryReportType.class,
                                       _getCPR ("UBL-InventoryReport-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.inventoryreport_22.ObjectFactory._InventoryReport_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <InvoiceType> invoice ()
  {
    return new UBL22JAXBMarshaller <> (InvoiceType.class,
                                       _getCPR ("UBL-Invoice-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.invoice_22.ObjectFactory._Invoice_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ItemInformationRequestType> itemInformationRequest ()
  {
    return new UBL22JAXBMarshaller <> (ItemInformationRequestType.class,
                                       _getCPR ("UBL-ItemInformationRequest-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.iteminformationrequest_22.ObjectFactory._ItemInformationRequest_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <OrderType> order ()
  {
    return new UBL22JAXBMarshaller <> (OrderType.class,
                                       _getCPR ("UBL-Order-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.order_22.ObjectFactory._Order_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <OrderCancellationType> orderCancellation ()
  {
    return new UBL22JAXBMarshaller <> (OrderCancellationType.class,
                                       _getCPR ("UBL-OrderCancellation-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.ordercancellation_22.ObjectFactory._OrderCancellation_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <OrderChangeType> orderChange ()
  {
    return new UBL22JAXBMarshaller <> (OrderChangeType.class,
                                       _getCPR ("UBL-OrderChange-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderchange_22.ObjectFactory._OrderChange_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <OrderResponseType> orderResponse ()
  {
    return new UBL22JAXBMarshaller <> (OrderResponseType.class,
                                       _getCPR ("UBL-OrderResponse-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderresponse_22.ObjectFactory._OrderResponse_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <OrderResponseSimpleType> orderResponseSimple ()
  {
    return new UBL22JAXBMarshaller <> (OrderResponseSimpleType.class,
                                       _getCPR ("UBL-OrderResponseSimple-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderresponsesimple_22.ObjectFactory._OrderResponseSimple_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <PackingListType> packingList ()
  {
    return new UBL22JAXBMarshaller <> (PackingListType.class,
                                       _getCPR ("UBL-PackingList-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.packinglist_22.ObjectFactory._PackingList_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <PriorInformationNoticeType> priorInformationNotice ()
  {
    return new UBL22JAXBMarshaller <> (PriorInformationNoticeType.class,
                                       _getCPR ("UBL-PriorInformationNotice-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.priorinformationnotice_22.ObjectFactory._PriorInformationNotice_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ProductActivityType> productActivity ()
  {
    return new UBL22JAXBMarshaller <> (ProductActivityType.class,
                                       _getCPR ("UBL-ProductActivity-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.productactivity_22.ObjectFactory._ProductActivity_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <QualificationApplicationRequestType> qualificationApplicationRequest ()
  {
    return new UBL22JAXBMarshaller <> (QualificationApplicationRequestType.class,
                                       _getCPR ("UBL-QualificationApplicationRequest-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_22.ObjectFactory._QualificationApplicationRequest_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <QualificationApplicationResponseType> qualificationApplicationResponse ()
  {
    return new UBL22JAXBMarshaller <> (QualificationApplicationResponseType.class,
                                       _getCPR ("UBL-QualificationApplicationResponse-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_22.ObjectFactory._QualificationApplicationResponse_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <QuotationType> quotation ()
  {
    return new UBL22JAXBMarshaller <> (QuotationType.class,
                                       _getCPR ("UBL-Quotation-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.quotation_22.ObjectFactory._Quotation_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ReceiptAdviceType> receiptAdvice ()
  {
    return new UBL22JAXBMarshaller <> (ReceiptAdviceType.class,
                                       _getCPR ("UBL-ReceiptAdvice-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.receiptadvice_22.ObjectFactory._ReceiptAdvice_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <ReminderType> reminder ()
  {
    return new UBL22JAXBMarshaller <> (ReminderType.class,
                                       _getCPR ("UBL-Reminder-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.reminder_22.ObjectFactory._Reminder_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <RemittanceAdviceType> remittanceAdvice ()
  {
    return new UBL22JAXBMarshaller <> (RemittanceAdviceType.class,
                                       _getCPR ("UBL-RemittanceAdvice-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.remittanceadvice_22.ObjectFactory._RemittanceAdvice_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <RequestForQuotationType> requestForQuotation ()
  {
    return new UBL22JAXBMarshaller <> (RequestForQuotationType.class,
                                       _getCPR ("UBL-RequestForQuotation-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.requestforquotation_22.ObjectFactory._RequestForQuotation_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <RetailEventType> retailEvent ()
  {
    return new UBL22JAXBMarshaller <> (RetailEventType.class,
                                       _getCPR ("UBL-RetailEvent-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.retailevent_22.ObjectFactory._RetailEvent_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return new UBL22JAXBMarshaller <> (SelfBilledCreditNoteType.class,
                                       _getCPR ("UBL-SelfBilledCreditNote-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_22.ObjectFactory._SelfBilledCreditNote_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return new UBL22JAXBMarshaller <> (SelfBilledInvoiceType.class,
                                       _getCPR ("UBL-SelfBilledInvoice-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_22.ObjectFactory._SelfBilledInvoice_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <StatementType> statement ()
  {
    return new UBL22JAXBMarshaller <> (StatementType.class,
                                       _getCPR ("UBL-Statement-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.statement_22.ObjectFactory._Statement_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return new UBL22JAXBMarshaller <> (StockAvailabilityReportType.class,
                                       _getCPR ("UBL-StockAvailabilityReport-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_22.ObjectFactory._StockAvailabilityReport_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderType> tender ()
  {
    return new UBL22JAXBMarshaller <> (TenderType.class,
                                       _getCPR ("UBL-Tender-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tender_22.ObjectFactory._Tender_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderContractType> tenderContract ()
  {
    return new UBL22JAXBMarshaller <> (TenderContractType.class,
                                       _getCPR ("UBL-TenderContract-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tendercontract_22.ObjectFactory._TenderContract_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TendererQualificationType> tendererQualification ()
  {
    return new UBL22JAXBMarshaller <> (TendererQualificationType.class,
                                       _getCPR ("UBL-TendererQualification-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualification_22.ObjectFactory._TendererQualification_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return new UBL22JAXBMarshaller <> (TendererQualificationResponseType.class,
                                       _getCPR ("UBL-TendererQualificationResponse-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_22.ObjectFactory._TendererQualificationResponse_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderReceiptType> tenderReceipt ()
  {
    return new UBL22JAXBMarshaller <> (TenderReceiptType.class,
                                       _getCPR ("UBL-TenderReceipt-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderreceipt_22.ObjectFactory._TenderReceipt_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderStatusType> tenderStatus ()
  {
    return new UBL22JAXBMarshaller <> (TenderStatusType.class,
                                       _getCPR ("UBL-TenderStatus-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatus_22.ObjectFactory._TenderStatus_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderStatusRequestType> tenderStatusRequest ()
  {
    return new UBL22JAXBMarshaller <> (TenderStatusRequestType.class,
                                       _getCPR ("UBL-TenderStatusRequest-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_22.ObjectFactory._TenderStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TenderWithdrawalType> tenderWithdrawal ()
  {
    return new UBL22JAXBMarshaller <> (TenderWithdrawalType.class,
                                       _getCPR ("UBL-TenderWithdrawal-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_22.ObjectFactory._TenderWithdrawal_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return new UBL22JAXBMarshaller <> (TradeItemLocationProfileType.class,
                                       _getCPR ("UBL-TradeItemLocationProfile-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_22.ObjectFactory._TradeItemLocationProfile_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportationStatusType> transportationStatus ()
  {
    return new UBL22JAXBMarshaller <> (TransportationStatusType.class,
                                       _getCPR ("UBL-TransportationStatus-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatus_22.ObjectFactory._TransportationStatus_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return new UBL22JAXBMarshaller <> (TransportationStatusRequestType.class,
                                       _getCPR ("UBL-TransportationStatusRequest-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_22.ObjectFactory._TransportationStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return new UBL22JAXBMarshaller <> (TransportExecutionPlanType.class,
                                       _getCPR ("UBL-TransportExecutionPlan-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplan_22.ObjectFactory._TransportExecutionPlan_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return new UBL22JAXBMarshaller <> (TransportExecutionPlanRequestType.class,
                                       _getCPR ("UBL-TransportExecutionPlanRequest-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_22.ObjectFactory._TransportExecutionPlanRequest_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportProgressStatusType> transportProgressStatus ()
  {
    return new UBL22JAXBMarshaller <> (TransportProgressStatusType.class,
                                       _getCPR ("UBL-TransportProgressStatus-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatus_22.ObjectFactory._TransportProgressStatus_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return new UBL22JAXBMarshaller <> (TransportProgressStatusRequestType.class,
                                       _getCPR ("UBL-TransportProgressStatusRequest-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_22.ObjectFactory._TransportProgressStatusRequest_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return new UBL22JAXBMarshaller <> (TransportServiceDescriptionType.class,
                                       _getCPR ("UBL-TransportServiceDescription-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescription_22.ObjectFactory._TransportServiceDescription_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return new UBL22JAXBMarshaller <> (TransportServiceDescriptionRequestType.class,
                                       _getCPR ("UBL-TransportServiceDescriptionRequest-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_22.ObjectFactory._TransportServiceDescriptionRequest_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <UnawardedNotificationType> unawardedNotification ()
  {
    return new UBL22JAXBMarshaller <> (UnawardedNotificationType.class,
                                       _getCPR ("UBL-UnawardedNotification-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.unawardednotification_22.ObjectFactory._UnawardedNotification_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <UnsubscribeFromProcedureRequestType> unsubscribeFromProcedureRequest ()
  {
    return new UBL22JAXBMarshaller <> (UnsubscribeFromProcedureRequestType.class,
                                       _getCPR ("UBL-UnsubscribeFromProcedureRequest-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_22.ObjectFactory._UnsubscribeFromProcedureRequest_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <UnsubscribeFromProcedureResponseType> unsubscribeFromProcedureResponse ()
  {
    return new UBL22JAXBMarshaller <> (UnsubscribeFromProcedureResponseType.class,
                                       _getCPR ("UBL-UnsubscribeFromProcedureResponse-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_22.ObjectFactory._UnsubscribeFromProcedureResponse_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <UtilityStatementType> utilityStatement ()
  {
    return new UBL22JAXBMarshaller <> (UtilityStatementType.class,
                                       _getCPR ("UBL-UtilityStatement-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.utilitystatement_22.ObjectFactory._UtilityStatement_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <WaybillType> waybill ()
  {
    return new UBL22JAXBMarshaller <> (WaybillType.class,
                                       _getCPR ("UBL-Waybill-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.waybill_22.ObjectFactory._Waybill_QNAME);
  }

  @Nonnull
  public static UBL22JAXBMarshaller <WeightStatementType> weightStatement ()
  {
    return new UBL22JAXBMarshaller <> (WeightStatementType.class,
                                       _getCPR ("UBL-WeightStatement-2.2.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.weightstatement_22.ObjectFactory._WeightStatement_QNAME);
  }
}
