package com.helger.ubl21;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.error.IResourceErrorGroup;
import com.helger.ubl.api.AbstractUBLDocumentMarshaller;

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
 * Validate all UBL 2.1 document types.
 * 
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBL21Validator extends AbstractUBLDocumentMarshaller
{
  @PresentForCodeCoverage
  private static final UBL21Validator s_aInstance = new UBL21Validator ();

  private UBL21Validator ()
  {}

  /**
   * Create a validation builder for ApplicationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL21ValidatorBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Validate the passed {@link ApplicationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse)
  {
    return UBL21Marshaller.validateUBLObject (aApplicationResponse,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.APPLICATION_RESPONSE);
  }

  /**
   * Validate the passed {@link ApplicationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aApplicationResponse,
                                              aClassLoader,
                                              EUBL21DocumentType.APPLICATION_RESPONSE);
  }

  /**
   * Validate the passed {@link ApplicationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse)
  {
    return validateApplicationResponse (aApplicationResponse, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ApplicationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                    @Nullable ClassLoader aClassLoader)
  {
    return validateApplicationResponse (aApplicationResponse, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for AttachedDocument.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL21ValidatorBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Validate the passed {@link AttachedDocumentType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument)
  {
    return UBL21Marshaller.validateUBLObject (aAttachedDocument,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.ATTACHED_DOCUMENT);
  }

  /**
   * Validate the passed {@link AttachedDocumentType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                              @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aAttachedDocument, aClassLoader, EUBL21DocumentType.ATTACHED_DOCUMENT);
  }

  /**
   * Validate the passed {@link AttachedDocumentType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument)
  {
    return validateAttachedDocument (aAttachedDocument, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link AttachedDocumentType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                 @Nullable ClassLoader aClassLoader)
  {
    return validateAttachedDocument (aAttachedDocument, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for AwardedNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <AwardedNotificationType> awardedNotification ()
  {
    return UBL21ValidatorBuilder.create (AwardedNotificationType.class);
  }

  /**
   * Validate the passed {@link AwardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification)
  {
    return UBL21Marshaller.validateUBLObject (aAwardedNotification,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.AWARDED_NOTIFICATION);
  }

  /**
   * Validate the passed {@link AwardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aAwardedNotification,
                                              aClassLoader,
                                              EUBL21DocumentType.AWARDED_NOTIFICATION);
  }

  /**
   * Validate the passed {@link AwardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification)
  {
    return validateAwardedNotification (aAwardedNotification, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link AwardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                    @Nullable ClassLoader aClassLoader)
  {
    return validateAwardedNotification (aAwardedNotification, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for BillOfLading.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL21ValidatorBuilder.create (BillOfLadingType.class);
  }

  /**
   * Validate the passed {@link BillOfLadingType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateBillOfLading (@Nonnull final BillOfLadingType aBillOfLading)
  {
    return UBL21Marshaller.validateUBLObject (aBillOfLading, (ClassLoader) null, EUBL21DocumentType.BILL_OF_LADING);
  }

  /**
   * Validate the passed {@link BillOfLadingType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                                          @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aBillOfLading, aClassLoader, EUBL21DocumentType.BILL_OF_LADING);
  }

  /**
   * Validate the passed {@link BillOfLadingType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidBillOfLading (@Nonnull final BillOfLadingType aBillOfLading)
  {
    return validateBillOfLading (aBillOfLading, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link BillOfLadingType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                             @Nullable ClassLoader aClassLoader)
  {
    return validateBillOfLading (aBillOfLading, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CallForTenders.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CallForTendersType> callForTenders ()
  {
    return UBL21ValidatorBuilder.create (CallForTendersType.class);
  }

  /**
   * Validate the passed {@link CallForTendersType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCallForTenders (@Nonnull final CallForTendersType aCallForTenders)
  {
    return UBL21Marshaller.validateUBLObject (aCallForTenders, (ClassLoader) null, EUBL21DocumentType.CALL_FOR_TENDERS);
  }

  /**
   * Validate the passed {@link CallForTendersType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                                            @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aCallForTenders, aClassLoader, EUBL21DocumentType.CALL_FOR_TENDERS);
  }

  /**
   * Validate the passed {@link CallForTendersType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCallForTenders (@Nonnull final CallForTendersType aCallForTenders)
  {
    return validateCallForTenders (aCallForTenders, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link CallForTendersType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                               @Nullable ClassLoader aClassLoader)
  {
    return validateCallForTenders (aCallForTenders, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Catalogue.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CatalogueType> catalogue ()
  {
    return UBL21ValidatorBuilder.create (CatalogueType.class);
  }

  /**
   * Validate the passed {@link CatalogueType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCatalogue (@Nonnull final CatalogueType aCatalogue)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogue, (ClassLoader) null, EUBL21DocumentType.CATALOGUE);
  }

  /**
   * Validate the passed {@link CatalogueType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCatalogue (@Nonnull final CatalogueType aCatalogue,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogue, aClassLoader, EUBL21DocumentType.CATALOGUE);
  }

  /**
   * Validate the passed {@link CatalogueType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCatalogue (@Nonnull final CatalogueType aCatalogue)
  {
    return validateCatalogue (aCatalogue, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link CatalogueType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCatalogue (@Nonnull final CatalogueType aCatalogue, @Nullable ClassLoader aClassLoader)
  {
    return validateCatalogue (aCatalogue, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CatalogueDeletion.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL21ValidatorBuilder.create (CatalogueDeletionType.class);
  }

  /**
   * Validate the passed {@link CatalogueDeletionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogueDeletion,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.CATALOGUE_DELETION);
  }

  /**
   * Validate the passed {@link CatalogueDeletionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                               @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogueDeletion, aClassLoader, EUBL21DocumentType.CATALOGUE_DELETION);
  }

  /**
   * Validate the passed {@link CatalogueDeletionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion)
  {
    return validateCatalogueDeletion (aCatalogueDeletion, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link CatalogueDeletionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                  @Nullable ClassLoader aClassLoader)
  {
    return validateCatalogueDeletion (aCatalogueDeletion, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CatalogueItemSpecificationUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL21ValidatorBuilder.create (CatalogueItemSpecificationUpdateType.class);
  }

  /**
   * Validate the passed {@link CatalogueItemSpecificationUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogueItemSpecificationUpdate,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE);
  }

  /**
   * Validate the passed {@link CatalogueItemSpecificationUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                              @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogueItemSpecificationUpdate,
                                              aClassLoader,
                                              EUBL21DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE);
  }

  /**
   * Validate the passed {@link CatalogueItemSpecificationUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate)
  {
    return validateCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                     (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link CatalogueItemSpecificationUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return validateCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                     aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CataloguePricingUpdate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL21ValidatorBuilder.create (CataloguePricingUpdateType.class);
  }

  /**
   * Validate the passed {@link CataloguePricingUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate)
  {
    return UBL21Marshaller.validateUBLObject (aCataloguePricingUpdate,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.CATALOGUE_PRICING_UPDATE);
  }

  /**
   * Validate the passed {@link CataloguePricingUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                                    @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aCataloguePricingUpdate,
                                              aClassLoader,
                                              EUBL21DocumentType.CATALOGUE_PRICING_UPDATE);
  }

  /**
   * Validate the passed {@link CataloguePricingUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate)
  {
    return validateCataloguePricingUpdate (aCataloguePricingUpdate, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link CataloguePricingUpdateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return validateCataloguePricingUpdate (aCataloguePricingUpdate, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CatalogueRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL21ValidatorBuilder.create (CatalogueRequestType.class);
  }

  /**
   * Validate the passed {@link CatalogueRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogueRequest,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.CATALOGUE_REQUEST);
  }

  /**
   * Validate the passed {@link CatalogueRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                              @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aCatalogueRequest, aClassLoader, EUBL21DocumentType.CATALOGUE_REQUEST);
  }

  /**
   * Validate the passed {@link CatalogueRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest)
  {
    return validateCatalogueRequest (aCatalogueRequest, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link CatalogueRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                 @Nullable ClassLoader aClassLoader)
  {
    return validateCatalogueRequest (aCatalogueRequest, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CertificateOfOrigin.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL21ValidatorBuilder.create (CertificateOfOriginType.class);
  }

  /**
   * Validate the passed {@link CertificateOfOriginType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin)
  {
    return UBL21Marshaller.validateUBLObject (aCertificateOfOrigin,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.CERTIFICATE_OF_ORIGIN);
  }

  /**
   * Validate the passed {@link CertificateOfOriginType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aCertificateOfOrigin,
                                              aClassLoader,
                                              EUBL21DocumentType.CERTIFICATE_OF_ORIGIN);
  }

  /**
   * Validate the passed {@link CertificateOfOriginType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin)
  {
    return validateCertificateOfOrigin (aCertificateOfOrigin, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link CertificateOfOriginType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                    @Nullable ClassLoader aClassLoader)
  {
    return validateCertificateOfOrigin (aCertificateOfOrigin, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for ContractAwardNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ContractAwardNoticeType> contractAwardNotice ()
  {
    return UBL21ValidatorBuilder.create (ContractAwardNoticeType.class);
  }

  /**
   * Validate the passed {@link ContractAwardNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice)
  {
    return UBL21Marshaller.validateUBLObject (aContractAwardNotice,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.CONTRACT_AWARD_NOTICE);
  }

  /**
   * Validate the passed {@link ContractAwardNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aContractAwardNotice,
                                              aClassLoader,
                                              EUBL21DocumentType.CONTRACT_AWARD_NOTICE);
  }

  /**
   * Validate the passed {@link ContractAwardNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice)
  {
    return validateContractAwardNotice (aContractAwardNotice, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ContractAwardNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                    @Nullable ClassLoader aClassLoader)
  {
    return validateContractAwardNotice (aContractAwardNotice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for ContractNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ContractNoticeType> contractNotice ()
  {
    return UBL21ValidatorBuilder.create (ContractNoticeType.class);
  }

  /**
   * Validate the passed {@link ContractNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateContractNotice (@Nonnull final ContractNoticeType aContractNotice)
  {
    return UBL21Marshaller.validateUBLObject (aContractNotice, (ClassLoader) null, EUBL21DocumentType.CONTRACT_NOTICE);
  }

  /**
   * Validate the passed {@link ContractNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                                            @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aContractNotice, aClassLoader, EUBL21DocumentType.CONTRACT_NOTICE);
  }

  /**
   * Validate the passed {@link ContractNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidContractNotice (@Nonnull final ContractNoticeType aContractNotice)
  {
    return validateContractNotice (aContractNotice, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ContractNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                               @Nullable ClassLoader aClassLoader)
  {
    return validateContractNotice (aContractNotice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <CreditNoteType> creditNote ()
  {
    return UBL21ValidatorBuilder.create (CreditNoteType.class);
  }

  /**
   * Validate the passed {@link CreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCreditNote (@Nonnull final CreditNoteType aCreditNote)
  {
    return UBL21Marshaller.validateUBLObject (aCreditNote, (ClassLoader) null, EUBL21DocumentType.CREDIT_NOTE);
  }

  /**
   * Validate the passed {@link CreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                                        @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aCreditNote, aClassLoader, EUBL21DocumentType.CREDIT_NOTE);
  }

  /**
   * Validate the passed {@link CreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCreditNote (@Nonnull final CreditNoteType aCreditNote)
  {
    return validateCreditNote (aCreditNote, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link CreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                           @Nullable ClassLoader aClassLoader)
  {
    return validateCreditNote (aCreditNote, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for DebitNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <DebitNoteType> debitNote ()
  {
    return UBL21ValidatorBuilder.create (DebitNoteType.class);
  }

  /**
   * Validate the passed {@link DebitNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateDebitNote (@Nonnull final DebitNoteType aDebitNote)
  {
    return UBL21Marshaller.validateUBLObject (aDebitNote, (ClassLoader) null, EUBL21DocumentType.DEBIT_NOTE);
  }

  /**
   * Validate the passed {@link DebitNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aDebitNote, aClassLoader, EUBL21DocumentType.DEBIT_NOTE);
  }

  /**
   * Validate the passed {@link DebitNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidDebitNote (@Nonnull final DebitNoteType aDebitNote)
  {
    return validateDebitNote (aDebitNote, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link DebitNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidDebitNote (@Nonnull final DebitNoteType aDebitNote, @Nullable ClassLoader aClassLoader)
  {
    return validateDebitNote (aDebitNote, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for DespatchAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL21ValidatorBuilder.create (DespatchAdviceType.class);
  }

  /**
   * Validate the passed {@link DespatchAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice)
  {
    return UBL21Marshaller.validateUBLObject (aDespatchAdvice, (ClassLoader) null, EUBL21DocumentType.DESPATCH_ADVICE);
  }

  /**
   * Validate the passed {@link DespatchAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                                            @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aDespatchAdvice, aClassLoader, EUBL21DocumentType.DESPATCH_ADVICE);
  }

  /**
   * Validate the passed {@link DespatchAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice)
  {
    return validateDespatchAdvice (aDespatchAdvice, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link DespatchAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                               @Nullable ClassLoader aClassLoader)
  {
    return validateDespatchAdvice (aDespatchAdvice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for DocumentStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <DocumentStatusType> documentStatus ()
  {
    return UBL21ValidatorBuilder.create (DocumentStatusType.class);
  }

  /**
   * Validate the passed {@link DocumentStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus)
  {
    return UBL21Marshaller.validateUBLObject (aDocumentStatus, (ClassLoader) null, EUBL21DocumentType.DOCUMENT_STATUS);
  }

  /**
   * Validate the passed {@link DocumentStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                                            @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aDocumentStatus, aClassLoader, EUBL21DocumentType.DOCUMENT_STATUS);
  }

  /**
   * Validate the passed {@link DocumentStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus)
  {
    return validateDocumentStatus (aDocumentStatus, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link DocumentStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                               @Nullable ClassLoader aClassLoader)
  {
    return validateDocumentStatus (aDocumentStatus, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for DocumentStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <DocumentStatusRequestType> documentStatusRequest ()
  {
    return UBL21ValidatorBuilder.create (DocumentStatusRequestType.class);
  }

  /**
   * Validate the passed {@link DocumentStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest)
  {
    return UBL21Marshaller.validateUBLObject (aDocumentStatusRequest,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.DOCUMENT_STATUS_REQUEST);
  }

  /**
   * Validate the passed {@link DocumentStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aDocumentStatusRequest,
                                              aClassLoader,
                                              EUBL21DocumentType.DOCUMENT_STATUS_REQUEST);
  }

  /**
   * Validate the passed {@link DocumentStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest)
  {
    return validateDocumentStatusRequest (aDocumentStatusRequest, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link DocumentStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                      @Nullable ClassLoader aClassLoader)
  {
    return validateDocumentStatusRequest (aDocumentStatusRequest, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for ExceptionCriteria.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ExceptionCriteriaType> exceptionCriteria ()
  {
    return UBL21ValidatorBuilder.create (ExceptionCriteriaType.class);
  }

  /**
   * Validate the passed {@link ExceptionCriteriaType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria)
  {
    return UBL21Marshaller.validateUBLObject (aExceptionCriteria,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.EXCEPTION_CRITERIA);
  }

  /**
   * Validate the passed {@link ExceptionCriteriaType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                               @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aExceptionCriteria, aClassLoader, EUBL21DocumentType.EXCEPTION_CRITERIA);
  }

  /**
   * Validate the passed {@link ExceptionCriteriaType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria)
  {
    return validateExceptionCriteria (aExceptionCriteria, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ExceptionCriteriaType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                  @Nullable ClassLoader aClassLoader)
  {
    return validateExceptionCriteria (aExceptionCriteria, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for ExceptionNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ExceptionNotificationType> exceptionNotification ()
  {
    return UBL21ValidatorBuilder.create (ExceptionNotificationType.class);
  }

  /**
   * Validate the passed {@link ExceptionNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification)
  {
    return UBL21Marshaller.validateUBLObject (aExceptionNotification,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.EXCEPTION_NOTIFICATION);
  }

  /**
   * Validate the passed {@link ExceptionNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aExceptionNotification,
                                              aClassLoader,
                                              EUBL21DocumentType.EXCEPTION_NOTIFICATION);
  }

  /**
   * Validate the passed {@link ExceptionNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification)
  {
    return validateExceptionNotification (aExceptionNotification, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ExceptionNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                      @Nullable ClassLoader aClassLoader)
  {
    return validateExceptionNotification (aExceptionNotification, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Forecast.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ForecastType> forecast ()
  {
    return UBL21ValidatorBuilder.create (ForecastType.class);
  }

  /**
   * Validate the passed {@link ForecastType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateForecast (@Nonnull final ForecastType aForecast)
  {
    return UBL21Marshaller.validateUBLObject (aForecast, (ClassLoader) null, EUBL21DocumentType.FORECAST);
  }

  /**
   * Validate the passed {@link ForecastType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateForecast (@Nonnull final ForecastType aForecast,
                                                      @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aForecast, aClassLoader, EUBL21DocumentType.FORECAST);
  }

  /**
   * Validate the passed {@link ForecastType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidForecast (@Nonnull final ForecastType aForecast)
  {
    return validateForecast (aForecast, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ForecastType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidForecast (@Nonnull final ForecastType aForecast, @Nullable ClassLoader aClassLoader)
  {
    return validateForecast (aForecast, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for ForecastRevision.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ForecastRevisionType> forecastRevision ()
  {
    return UBL21ValidatorBuilder.create (ForecastRevisionType.class);
  }

  /**
   * Validate the passed {@link ForecastRevisionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision)
  {
    return UBL21Marshaller.validateUBLObject (aForecastRevision,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.FORECAST_REVISION);
  }

  /**
   * Validate the passed {@link ForecastRevisionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                              @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aForecastRevision, aClassLoader, EUBL21DocumentType.FORECAST_REVISION);
  }

  /**
   * Validate the passed {@link ForecastRevisionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision)
  {
    return validateForecastRevision (aForecastRevision, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ForecastRevisionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                 @Nullable ClassLoader aClassLoader)
  {
    return validateForecastRevision (aForecastRevision, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for ForwardingInstructions.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL21ValidatorBuilder.create (ForwardingInstructionsType.class);
  }

  /**
   * Validate the passed {@link ForwardingInstructionsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions)
  {
    return UBL21Marshaller.validateUBLObject (aForwardingInstructions,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.FORWARDING_INSTRUCTIONS);
  }

  /**
   * Validate the passed {@link ForwardingInstructionsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                                    @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aForwardingInstructions,
                                              aClassLoader,
                                              EUBL21DocumentType.FORWARDING_INSTRUCTIONS);
  }

  /**
   * Validate the passed {@link ForwardingInstructionsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions)
  {
    return validateForwardingInstructions (aForwardingInstructions, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ForwardingInstructionsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return validateForwardingInstructions (aForwardingInstructions, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for FreightInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL21ValidatorBuilder.create (FreightInvoiceType.class);
  }

  /**
   * Validate the passed {@link FreightInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice)
  {
    return UBL21Marshaller.validateUBLObject (aFreightInvoice, (ClassLoader) null, EUBL21DocumentType.FREIGHT_INVOICE);
  }

  /**
   * Validate the passed {@link FreightInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                                            @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aFreightInvoice, aClassLoader, EUBL21DocumentType.FREIGHT_INVOICE);
  }

  /**
   * Validate the passed {@link FreightInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice)
  {
    return validateFreightInvoice (aFreightInvoice, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link FreightInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                               @Nullable ClassLoader aClassLoader)
  {
    return validateFreightInvoice (aFreightInvoice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for FulfilmentCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return UBL21ValidatorBuilder.create (FulfilmentCancellationType.class);
  }

  /**
   * Validate the passed {@link FulfilmentCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation)
  {
    return UBL21Marshaller.validateUBLObject (aFulfilmentCancellation,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.FULFILMENT_CANCELATION);
  }

  /**
   * Validate the passed {@link FulfilmentCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                                    @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aFulfilmentCancellation,
                                              aClassLoader,
                                              EUBL21DocumentType.FULFILMENT_CANCELATION);
  }

  /**
   * Validate the passed {@link FulfilmentCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation)
  {
    return validateFulfilmentCancellation (aFulfilmentCancellation, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link FulfilmentCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return validateFulfilmentCancellation (aFulfilmentCancellation, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for GoodsItemItinerary.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return UBL21ValidatorBuilder.create (GoodsItemItineraryType.class);
  }

  /**
   * Validate the passed {@link GoodsItemItineraryType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary)
  {
    return UBL21Marshaller.validateUBLObject (aGoodsItemItinerary,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.GOODS_ITEM_ITINERARY);
  }

  /**
   * Validate the passed {@link GoodsItemItineraryType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                                @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aGoodsItemItinerary,
                                              aClassLoader,
                                              EUBL21DocumentType.GOODS_ITEM_ITINERARY);
  }

  /**
   * Validate the passed {@link GoodsItemItineraryType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary)
  {
    return validateGoodsItemItinerary (aGoodsItemItinerary, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link GoodsItemItineraryType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                   @Nullable ClassLoader aClassLoader)
  {
    return validateGoodsItemItinerary (aGoodsItemItinerary, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for GuaranteeCertificate.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return UBL21ValidatorBuilder.create (GuaranteeCertificateType.class);
  }

  /**
   * Validate the passed {@link GuaranteeCertificateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate)
  {
    return UBL21Marshaller.validateUBLObject (aGuaranteeCertificate,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.GUARANTEE_CERTIFICATE);
  }

  /**
   * Validate the passed {@link GuaranteeCertificateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                                  @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aGuaranteeCertificate,
                                              aClassLoader,
                                              EUBL21DocumentType.GUARANTEE_CERTIFICATE);
  }

  /**
   * Validate the passed {@link GuaranteeCertificateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate)
  {
    return validateGuaranteeCertificate (aGuaranteeCertificate, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link GuaranteeCertificateType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                     @Nullable ClassLoader aClassLoader)
  {
    return validateGuaranteeCertificate (aGuaranteeCertificate, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for InstructionForReturns.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <InstructionForReturnsType> instructionForReturns ()
  {
    return UBL21ValidatorBuilder.create (InstructionForReturnsType.class);
  }

  /**
   * Validate the passed {@link InstructionForReturnsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns)
  {
    return UBL21Marshaller.validateUBLObject (aInstructionForReturns,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.INSTRUCTION_FOR_RETURNS);
  }

  /**
   * Validate the passed {@link InstructionForReturnsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aInstructionForReturns,
                                              aClassLoader,
                                              EUBL21DocumentType.INSTRUCTION_FOR_RETURNS);
  }

  /**
   * Validate the passed {@link InstructionForReturnsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns)
  {
    return validateInstructionForReturns (aInstructionForReturns, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link InstructionForReturnsType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                      @Nullable ClassLoader aClassLoader)
  {
    return validateInstructionForReturns (aInstructionForReturns, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for InventoryReport.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <InventoryReportType> inventoryReport ()
  {
    return UBL21ValidatorBuilder.create (InventoryReportType.class);
  }

  /**
   * Validate the passed {@link InventoryReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateInventoryReport (@Nonnull final InventoryReportType aInventoryReport)
  {
    return UBL21Marshaller.validateUBLObject (aInventoryReport,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.INVENTORY_REPORT);
  }

  /**
   * Validate the passed {@link InventoryReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aInventoryReport, aClassLoader, EUBL21DocumentType.INVENTORY_REPORT);
  }

  /**
   * Validate the passed {@link InventoryReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidInventoryReport (@Nonnull final InventoryReportType aInventoryReport)
  {
    return validateInventoryReport (aInventoryReport, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link InventoryReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                                @Nullable ClassLoader aClassLoader)
  {
    return validateInventoryReport (aInventoryReport, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Invoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <InvoiceType> invoice ()
  {
    return UBL21ValidatorBuilder.create (InvoiceType.class);
  }

  /**
   * Validate the passed {@link InvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateInvoice (@Nonnull final InvoiceType aInvoice)
  {
    return UBL21Marshaller.validateUBLObject (aInvoice, (ClassLoader) null, EUBL21DocumentType.INVOICE);
  }

  /**
   * Validate the passed {@link InvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateInvoice (@Nonnull final InvoiceType aInvoice,
                                                     @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aInvoice, aClassLoader, EUBL21DocumentType.INVOICE);
  }

  /**
   * Validate the passed {@link InvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidInvoice (@Nonnull final InvoiceType aInvoice)
  {
    return validateInvoice (aInvoice, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link InvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidInvoice (@Nonnull final InvoiceType aInvoice, @Nullable ClassLoader aClassLoader)
  {
    return validateInvoice (aInvoice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for ItemInformationRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ItemInformationRequestType> itemInformationRequest ()
  {
    return UBL21ValidatorBuilder.create (ItemInformationRequestType.class);
  }

  /**
   * Validate the passed {@link ItemInformationRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest)
  {
    return UBL21Marshaller.validateUBLObject (aItemInformationRequest,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.ITEM_INFORMATION_REQUEST);
  }

  /**
   * Validate the passed {@link ItemInformationRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                                    @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aItemInformationRequest,
                                              aClassLoader,
                                              EUBL21DocumentType.ITEM_INFORMATION_REQUEST);
  }

  /**
   * Validate the passed {@link ItemInformationRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest)
  {
    return validateItemInformationRequest (aItemInformationRequest, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ItemInformationRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return validateItemInformationRequest (aItemInformationRequest, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Order.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <OrderType> order ()
  {
    return UBL21ValidatorBuilder.create (OrderType.class);
  }

  /**
   * Validate the passed {@link OrderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateOrder (@Nonnull final OrderType aOrder)
  {
    return UBL21Marshaller.validateUBLObject (aOrder, (ClassLoader) null, EUBL21DocumentType.ORDER);
  }

  /**
   * Validate the passed {@link OrderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateOrder (@Nonnull final OrderType aOrder, @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aOrder, aClassLoader, EUBL21DocumentType.ORDER);
  }

  /**
   * Validate the passed {@link OrderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidOrder (@Nonnull final OrderType aOrder)
  {
    return validateOrder (aOrder, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link OrderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidOrder (@Nonnull final OrderType aOrder, @Nullable ClassLoader aClassLoader)
  {
    return validateOrder (aOrder, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for OrderCancellation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL21ValidatorBuilder.create (OrderCancellationType.class);
  }

  /**
   * Validate the passed {@link OrderCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation)
  {
    return UBL21Marshaller.validateUBLObject (aOrderCancellation,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.ORDER_CANCELLATION);
  }

  /**
   * Validate the passed {@link OrderCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                               @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aOrderCancellation, aClassLoader, EUBL21DocumentType.ORDER_CANCELLATION);
  }

  /**
   * Validate the passed {@link OrderCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation)
  {
    return validateOrderCancellation (aOrderCancellation, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link OrderCancellationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                  @Nullable ClassLoader aClassLoader)
  {
    return validateOrderCancellation (aOrderCancellation, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for OrderChange.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <OrderChangeType> orderChange ()
  {
    return UBL21ValidatorBuilder.create (OrderChangeType.class);
  }

  /**
   * Validate the passed {@link OrderChangeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateOrderChange (@Nonnull final OrderChangeType aOrderChange)
  {
    return UBL21Marshaller.validateUBLObject (aOrderChange, (ClassLoader) null, EUBL21DocumentType.ORDER_CHANGE);
  }

  /**
   * Validate the passed {@link OrderChangeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                                         @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aOrderChange, aClassLoader, EUBL21DocumentType.ORDER_CHANGE);
  }

  /**
   * Validate the passed {@link OrderChangeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidOrderChange (@Nonnull final OrderChangeType aOrderChange)
  {
    return validateOrderChange (aOrderChange, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link OrderChangeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                            @Nullable ClassLoader aClassLoader)
  {
    return validateOrderChange (aOrderChange, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for OrderResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <OrderResponseType> orderResponse ()
  {
    return UBL21ValidatorBuilder.create (OrderResponseType.class);
  }

  /**
   * Validate the passed {@link OrderResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateOrderResponse (@Nonnull final OrderResponseType aOrderResponse)
  {
    return UBL21Marshaller.validateUBLObject (aOrderResponse, (ClassLoader) null, EUBL21DocumentType.ORDER_RESPONSE);
  }

  /**
   * Validate the passed {@link OrderResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aOrderResponse, aClassLoader, EUBL21DocumentType.ORDER_RESPONSE);
  }

  /**
   * Validate the passed {@link OrderResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidOrderResponse (@Nonnull final OrderResponseType aOrderResponse)
  {
    return validateOrderResponse (aOrderResponse, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link OrderResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                              @Nullable ClassLoader aClassLoader)
  {
    return validateOrderResponse (aOrderResponse, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for OrderResponseSimple.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL21ValidatorBuilder.create (OrderResponseSimpleType.class);
  }

  /**
   * Validate the passed {@link OrderResponseSimpleType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple)
  {
    return UBL21Marshaller.validateUBLObject (aOrderResponseSimple,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.ORDER_RESPONSE_SIMPLE);
  }

  /**
   * Validate the passed {@link OrderResponseSimpleType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aOrderResponseSimple,
                                              aClassLoader,
                                              EUBL21DocumentType.ORDER_RESPONSE_SIMPLE);
  }

  /**
   * Validate the passed {@link OrderResponseSimpleType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple)
  {
    return validateOrderResponseSimple (aOrderResponseSimple, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link OrderResponseSimpleType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                    @Nullable ClassLoader aClassLoader)
  {
    return validateOrderResponseSimple (aOrderResponseSimple, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for PackingList.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <PackingListType> packingList ()
  {
    return UBL21ValidatorBuilder.create (PackingListType.class);
  }

  /**
   * Validate the passed {@link PackingListType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validatePackingList (@Nonnull final PackingListType aPackingList)
  {
    return UBL21Marshaller.validateUBLObject (aPackingList, (ClassLoader) null, EUBL21DocumentType.PACKING_LIST);
  }

  /**
   * Validate the passed {@link PackingListType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validatePackingList (@Nonnull final PackingListType aPackingList,
                                                         @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aPackingList, aClassLoader, EUBL21DocumentType.PACKING_LIST);
  }

  /**
   * Validate the passed {@link PackingListType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidPackingList (@Nonnull final PackingListType aPackingList)
  {
    return validatePackingList (aPackingList, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link PackingListType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidPackingList (@Nonnull final PackingListType aPackingList,
                                            @Nullable ClassLoader aClassLoader)
  {
    return validatePackingList (aPackingList, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for PriorInformationNotice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <PriorInformationNoticeType> priorInformationNotice ()
  {
    return UBL21ValidatorBuilder.create (PriorInformationNoticeType.class);
  }

  /**
   * Validate the passed {@link PriorInformationNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validatePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice)
  {
    return UBL21Marshaller.validateUBLObject (aPriorInformationNotice,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.PRIOR_INFORMATION_NOTICE);
  }

  /**
   * Validate the passed {@link PriorInformationNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validatePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                                    @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aPriorInformationNotice,
                                              aClassLoader,
                                              EUBL21DocumentType.PRIOR_INFORMATION_NOTICE);
  }

  /**
   * Validate the passed {@link PriorInformationNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidPriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice)
  {
    return validatePriorInformationNotice (aPriorInformationNotice, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link PriorInformationNoticeType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidPriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return validatePriorInformationNotice (aPriorInformationNotice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for ProductActivity.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ProductActivityType> productActivity ()
  {
    return UBL21ValidatorBuilder.create (ProductActivityType.class);
  }

  /**
   * Validate the passed {@link ProductActivityType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateProductActivity (@Nonnull final ProductActivityType aProductActivity)
  {
    return UBL21Marshaller.validateUBLObject (aProductActivity,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.PRODUCT_ACTIVITY);
  }

  /**
   * Validate the passed {@link ProductActivityType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                                             @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aProductActivity, aClassLoader, EUBL21DocumentType.PRODUCT_ACTIVITY);
  }

  /**
   * Validate the passed {@link ProductActivityType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidProductActivity (@Nonnull final ProductActivityType aProductActivity)
  {
    return validateProductActivity (aProductActivity, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ProductActivityType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                                @Nullable ClassLoader aClassLoader)
  {
    return validateProductActivity (aProductActivity, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Quotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <QuotationType> quotation ()
  {
    return UBL21ValidatorBuilder.create (QuotationType.class);
  }

  /**
   * Validate the passed {@link QuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateQuotation (@Nonnull final QuotationType aQuotation)
  {
    return UBL21Marshaller.validateUBLObject (aQuotation, (ClassLoader) null, EUBL21DocumentType.QUOTATION);
  }

  /**
   * Validate the passed {@link QuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateQuotation (@Nonnull final QuotationType aQuotation,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aQuotation, aClassLoader, EUBL21DocumentType.QUOTATION);
  }

  /**
   * Validate the passed {@link QuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidQuotation (@Nonnull final QuotationType aQuotation)
  {
    return validateQuotation (aQuotation, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link QuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidQuotation (@Nonnull final QuotationType aQuotation, @Nullable ClassLoader aClassLoader)
  {
    return validateQuotation (aQuotation, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for ReceiptAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL21ValidatorBuilder.create (ReceiptAdviceType.class);
  }

  /**
   * Validate the passed {@link ReceiptAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice)
  {
    return UBL21Marshaller.validateUBLObject (aReceiptAdvice, (ClassLoader) null, EUBL21DocumentType.RECEIPT_ADVICE);
  }

  /**
   * Validate the passed {@link ReceiptAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aReceiptAdvice, aClassLoader, EUBL21DocumentType.RECEIPT_ADVICE);
  }

  /**
   * Validate the passed {@link ReceiptAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice)
  {
    return validateReceiptAdvice (aReceiptAdvice, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ReceiptAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                              @Nullable ClassLoader aClassLoader)
  {
    return validateReceiptAdvice (aReceiptAdvice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Reminder.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <ReminderType> reminder ()
  {
    return UBL21ValidatorBuilder.create (ReminderType.class);
  }

  /**
   * Validate the passed {@link ReminderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateReminder (@Nonnull final ReminderType aReminder)
  {
    return UBL21Marshaller.validateUBLObject (aReminder, (ClassLoader) null, EUBL21DocumentType.REMINDER);
  }

  /**
   * Validate the passed {@link ReminderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateReminder (@Nonnull final ReminderType aReminder,
                                                      @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aReminder, aClassLoader, EUBL21DocumentType.REMINDER);
  }

  /**
   * Validate the passed {@link ReminderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidReminder (@Nonnull final ReminderType aReminder)
  {
    return validateReminder (aReminder, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link ReminderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidReminder (@Nonnull final ReminderType aReminder, @Nullable ClassLoader aClassLoader)
  {
    return validateReminder (aReminder, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for RemittanceAdvice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL21ValidatorBuilder.create (RemittanceAdviceType.class);
  }

  /**
   * Validate the passed {@link RemittanceAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice)
  {
    return UBL21Marshaller.validateUBLObject (aRemittanceAdvice,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.REMITTANCE_ADVICE);
  }

  /**
   * Validate the passed {@link RemittanceAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                              @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aRemittanceAdvice, aClassLoader, EUBL21DocumentType.REMITTANCE_ADVICE);
  }

  /**
   * Validate the passed {@link RemittanceAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice)
  {
    return validateRemittanceAdvice (aRemittanceAdvice, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link RemittanceAdviceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                 @Nullable ClassLoader aClassLoader)
  {
    return validateRemittanceAdvice (aRemittanceAdvice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for RequestForQuotation.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL21ValidatorBuilder.create (RequestForQuotationType.class);
  }

  /**
   * Validate the passed {@link RequestForQuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation)
  {
    return UBL21Marshaller.validateUBLObject (aRequestForQuotation,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.REQUEST_FOR_QUOTATION);
  }

  /**
   * Validate the passed {@link RequestForQuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                                 @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aRequestForQuotation,
                                              aClassLoader,
                                              EUBL21DocumentType.REQUEST_FOR_QUOTATION);
  }

  /**
   * Validate the passed {@link RequestForQuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation)
  {
    return validateRequestForQuotation (aRequestForQuotation, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link RequestForQuotationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                    @Nullable ClassLoader aClassLoader)
  {
    return validateRequestForQuotation (aRequestForQuotation, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for RetailEvent.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <RetailEventType> retailEvent ()
  {
    return UBL21ValidatorBuilder.create (RetailEventType.class);
  }

  /**
   * Validate the passed {@link RetailEventType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateRetailEvent (@Nonnull final RetailEventType aRetailEvent)
  {
    return UBL21Marshaller.validateUBLObject (aRetailEvent, (ClassLoader) null, EUBL21DocumentType.RETAIL_EVENT);
  }

  /**
   * Validate the passed {@link RetailEventType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateRetailEvent (@Nonnull final RetailEventType aRetailEvent,
                                                         @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aRetailEvent, aClassLoader, EUBL21DocumentType.RETAIL_EVENT);
  }

  /**
   * Validate the passed {@link RetailEventType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidRetailEvent (@Nonnull final RetailEventType aRetailEvent)
  {
    return validateRetailEvent (aRetailEvent, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link RetailEventType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidRetailEvent (@Nonnull final RetailEventType aRetailEvent,
                                            @Nullable ClassLoader aClassLoader)
  {
    return validateRetailEvent (aRetailEvent, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for SelfBilledCreditNote.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL21ValidatorBuilder.create (SelfBilledCreditNoteType.class);
  }

  /**
   * Validate the passed {@link SelfBilledCreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote)
  {
    return UBL21Marshaller.validateUBLObject (aSelfBilledCreditNote,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.SELF_BILLED_CREDIT_NOTE);
  }

  /**
   * Validate the passed {@link SelfBilledCreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                                  @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aSelfBilledCreditNote,
                                              aClassLoader,
                                              EUBL21DocumentType.SELF_BILLED_CREDIT_NOTE);
  }

  /**
   * Validate the passed {@link SelfBilledCreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote)
  {
    return validateSelfBilledCreditNote (aSelfBilledCreditNote, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link SelfBilledCreditNoteType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                     @Nullable ClassLoader aClassLoader)
  {
    return validateSelfBilledCreditNote (aSelfBilledCreditNote, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for SelfBilledInvoice.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL21ValidatorBuilder.create (SelfBilledInvoiceType.class);
  }

  /**
   * Validate the passed {@link SelfBilledInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice)
  {
    return UBL21Marshaller.validateUBLObject (aSelfBilledInvoice,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.SELF_BILLED_INVOICE);
  }

  /**
   * Validate the passed {@link SelfBilledInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                               @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aSelfBilledInvoice, aClassLoader, EUBL21DocumentType.SELF_BILLED_INVOICE);
  }

  /**
   * Validate the passed {@link SelfBilledInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice)
  {
    return validateSelfBilledInvoice (aSelfBilledInvoice, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link SelfBilledInvoiceType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                  @Nullable ClassLoader aClassLoader)
  {
    return validateSelfBilledInvoice (aSelfBilledInvoice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Statement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <StatementType> statement ()
  {
    return UBL21ValidatorBuilder.create (StatementType.class);
  }

  /**
   * Validate the passed {@link StatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateStatement (@Nonnull final StatementType aStatement)
  {
    return UBL21Marshaller.validateUBLObject (aStatement, (ClassLoader) null, EUBL21DocumentType.STATEMENT);
  }

  /**
   * Validate the passed {@link StatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateStatement (@Nonnull final StatementType aStatement,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aStatement, aClassLoader, EUBL21DocumentType.STATEMENT);
  }

  /**
   * Validate the passed {@link StatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidStatement (@Nonnull final StatementType aStatement)
  {
    return validateStatement (aStatement, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link StatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidStatement (@Nonnull final StatementType aStatement, @Nullable ClassLoader aClassLoader)
  {
    return validateStatement (aStatement, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for StockAvailabilityReport.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return UBL21ValidatorBuilder.create (StockAvailabilityReportType.class);
  }

  /**
   * Validate the passed {@link StockAvailabilityReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport)
  {
    return UBL21Marshaller.validateUBLObject (aStockAvailabilityReport,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.STOCK_AVAILABILITY_REPORT);
  }

  /**
   * Validate the passed {@link StockAvailabilityReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aStockAvailabilityReport,
                                              aClassLoader,
                                              EUBL21DocumentType.STOCK_AVAILABILITY_REPORT);
  }

  /**
   * Validate the passed {@link StockAvailabilityReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport)
  {
    return validateStockAvailabilityReport (aStockAvailabilityReport, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link StockAvailabilityReportType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                        @Nullable ClassLoader aClassLoader)
  {
    return validateStockAvailabilityReport (aStockAvailabilityReport, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Tender.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TenderType> tender ()
  {
    return UBL21ValidatorBuilder.create (TenderType.class);
  }

  /**
   * Validate the passed {@link TenderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTender (@Nonnull final TenderType aTender)
  {
    return UBL21Marshaller.validateUBLObject (aTender, (ClassLoader) null, EUBL21DocumentType.TENDER);
  }

  /**
   * Validate the passed {@link TenderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTender (@Nonnull final TenderType aTender,
                                                    @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTender, aClassLoader, EUBL21DocumentType.TENDER);
  }

  /**
   * Validate the passed {@link TenderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTender (@Nonnull final TenderType aTender)
  {
    return validateTender (aTender, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TenderType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTender (@Nonnull final TenderType aTender, @Nullable ClassLoader aClassLoader)
  {
    return validateTender (aTender, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TendererQualification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TendererQualificationType> tendererQualification ()
  {
    return UBL21ValidatorBuilder.create (TendererQualificationType.class);
  }

  /**
   * Validate the passed {@link TendererQualificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTendererQualification (@Nonnull final TendererQualificationType aTendererQualification)
  {
    return UBL21Marshaller.validateUBLObject (aTendererQualification,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.TENDER_QUALIFICATION);
  }

  /**
   * Validate the passed {@link TendererQualificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTendererQualification,
                                              aClassLoader,
                                              EUBL21DocumentType.TENDER_QUALIFICATION);
  }

  /**
   * Validate the passed {@link TendererQualificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTendererQualification (@Nonnull final TendererQualificationType aTendererQualification)
  {
    return validateTendererQualification (aTendererQualification, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TendererQualificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                      @Nullable ClassLoader aClassLoader)
  {
    return validateTendererQualification (aTendererQualification, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TendererQualificationResponse.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return UBL21ValidatorBuilder.create (TendererQualificationResponseType.class);
  }

  /**
   * Validate the passed {@link TendererQualificationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse)
  {
    return UBL21Marshaller.validateUBLObject (aTendererQualificationResponse,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.TENDER_QUALIFICATION_RESPONSE);
  }

  /**
   * Validate the passed {@link TendererQualificationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                                           @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTendererQualificationResponse,
                                              aClassLoader,
                                              EUBL21DocumentType.TENDER_QUALIFICATION_RESPONSE);
  }

  /**
   * Validate the passed {@link TendererQualificationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse)
  {
    return validateTendererQualificationResponse (aTendererQualificationResponse,
                                                  (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TendererQualificationResponseType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                              @Nullable ClassLoader aClassLoader)
  {
    return validateTendererQualificationResponse (aTendererQualificationResponse, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TenderReceipt.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TenderReceiptType> tenderReceipt ()
  {
    return UBL21ValidatorBuilder.create (TenderReceiptType.class);
  }

  /**
   * Validate the passed {@link TenderReceiptType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt)
  {
    return UBL21Marshaller.validateUBLObject (aTenderReceipt, (ClassLoader) null, EUBL21DocumentType.TENDER_RECEIPT);
  }

  /**
   * Validate the passed {@link TenderReceiptType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                                           @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTenderReceipt, aClassLoader, EUBL21DocumentType.TENDER_RECEIPT);
  }

  /**
   * Validate the passed {@link TenderReceiptType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt)
  {
    return validateTenderReceipt (aTenderReceipt, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TenderReceiptType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                              @Nullable ClassLoader aClassLoader)
  {
    return validateTenderReceipt (aTenderReceipt, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TradeItemLocationProfile.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return UBL21ValidatorBuilder.create (TradeItemLocationProfileType.class);
  }

  /**
   * Validate the passed {@link TradeItemLocationProfileType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile)
  {
    return UBL21Marshaller.validateUBLObject (aTradeItemLocationProfile,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.TRADE_ITEM_LOCATION_PROFILE);
  }

  /**
   * Validate the passed {@link TradeItemLocationProfileType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                                      @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTradeItemLocationProfile,
                                              aClassLoader,
                                              EUBL21DocumentType.TRADE_ITEM_LOCATION_PROFILE);
  }

  /**
   * Validate the passed {@link TradeItemLocationProfileType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile)
  {
    return validateTradeItemLocationProfile (aTradeItemLocationProfile, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TradeItemLocationProfileType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                         @Nullable ClassLoader aClassLoader)
  {
    return validateTradeItemLocationProfile (aTradeItemLocationProfile, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TransportationStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL21ValidatorBuilder.create (TransportationStatusType.class);
  }

  /**
   * Validate the passed {@link TransportationStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus)
  {
    return UBL21Marshaller.validateUBLObject (aTransportationStatus,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.TRANSPORTATION_STATUS);
  }

  /**
   * Validate the passed {@link TransportationStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                                  @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTransportationStatus,
                                              aClassLoader,
                                              EUBL21DocumentType.TRANSPORTATION_STATUS);
  }

  /**
   * Validate the passed {@link TransportationStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus)
  {
    return validateTransportationStatus (aTransportationStatus, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportationStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                     @Nullable ClassLoader aClassLoader)
  {
    return validateTransportationStatus (aTransportationStatus, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TransportationStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return UBL21ValidatorBuilder.create (TransportationStatusRequestType.class);
  }

  /**
   * Validate the passed {@link TransportationStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest)
  {
    return UBL21Marshaller.validateUBLObject (aTransportationStatusRequest,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.TRANSPORTATION_STATUS_REQUEST);
  }

  /**
   * Validate the passed {@link TransportationStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                                         @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTransportationStatusRequest,
                                              aClassLoader,
                                              EUBL21DocumentType.TRANSPORTATION_STATUS_REQUEST);
  }

  /**
   * Validate the passed {@link TransportationStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest)
  {
    return validateTransportationStatusRequest (aTransportationStatusRequest, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportationStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                            @Nullable ClassLoader aClassLoader)
  {
    return validateTransportationStatusRequest (aTransportationStatusRequest, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TransportExecutionPlan.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return UBL21ValidatorBuilder.create (TransportExecutionPlanType.class);
  }

  /**
   * Validate the passed {@link TransportExecutionPlanType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan)
  {
    return UBL21Marshaller.validateUBLObject (aTransportExecutionPlan,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN);
  }

  /**
   * Validate the passed {@link TransportExecutionPlanType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                                    @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTransportExecutionPlan,
                                              aClassLoader,
                                              EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN);
  }

  /**
   * Validate the passed {@link TransportExecutionPlanType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan)
  {
    return validateTransportExecutionPlan (aTransportExecutionPlan, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportExecutionPlanType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                       @Nullable ClassLoader aClassLoader)
  {
    return validateTransportExecutionPlan (aTransportExecutionPlan, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TransportExecutionPlanRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return UBL21ValidatorBuilder.create (TransportExecutionPlanRequestType.class);
  }

  /**
   * Validate the passed {@link TransportExecutionPlanRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest)
  {
    return UBL21Marshaller.validateUBLObject (aTransportExecutionPlanRequest,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN_REQUEST);
  }

  /**
   * Validate the passed {@link TransportExecutionPlanRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                                           @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTransportExecutionPlanRequest,
                                              aClassLoader,
                                              EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN_REQUEST);
  }

  /**
   * Validate the passed {@link TransportExecutionPlanRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest)
  {
    return validateTransportExecutionPlanRequest (aTransportExecutionPlanRequest,
                                                  (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportExecutionPlanRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                              @Nullable ClassLoader aClassLoader)
  {
    return validateTransportExecutionPlanRequest (aTransportExecutionPlanRequest, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TransportProgressStatus.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportProgressStatusType> transportProgressStatus ()
  {
    return UBL21ValidatorBuilder.create (TransportProgressStatusType.class);
  }

  /**
   * Validate the passed {@link TransportProgressStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus)
  {
    return UBL21Marshaller.validateUBLObject (aTransportProgressStatus,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS);
  }

  /**
   * Validate the passed {@link TransportProgressStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                                     @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTransportProgressStatus,
                                              aClassLoader,
                                              EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS);
  }

  /**
   * Validate the passed {@link TransportProgressStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus)
  {
    return validateTransportProgressStatus (aTransportProgressStatus, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportProgressStatusType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                        @Nullable ClassLoader aClassLoader)
  {
    return validateTransportProgressStatus (aTransportProgressStatus, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TransportProgressStatusRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return UBL21ValidatorBuilder.create (TransportProgressStatusRequestType.class);
  }

  /**
   * Validate the passed {@link TransportProgressStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest)
  {
    return UBL21Marshaller.validateUBLObject (aTransportProgressStatusRequest,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS_REQUEST);
  }

  /**
   * Validate the passed {@link TransportProgressStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                                            @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTransportProgressStatusRequest,
                                              aClassLoader,
                                              EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS_REQUEST);
  }

  /**
   * Validate the passed {@link TransportProgressStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest)
  {
    return validateTransportProgressStatusRequest (aTransportProgressStatusRequest,
                                                   (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportProgressStatusRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                               @Nullable ClassLoader aClassLoader)
  {
    return validateTransportProgressStatusRequest (aTransportProgressStatusRequest, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TransportServiceDescription.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return UBL21ValidatorBuilder.create (TransportServiceDescriptionType.class);
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription)
  {
    return UBL21Marshaller.validateUBLObject (aTransportServiceDescription,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION);
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                                         @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTransportServiceDescription,
                                              aClassLoader,
                                              EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION);
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription)
  {
    return validateTransportServiceDescription (aTransportServiceDescription, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                            @Nullable ClassLoader aClassLoader)
  {
    return validateTransportServiceDescription (aTransportServiceDescription, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TransportServiceDescriptionRequest.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return UBL21ValidatorBuilder.create (TransportServiceDescriptionRequestType.class);
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest)
  {
    return UBL21Marshaller.validateUBLObject (aTransportServiceDescriptionRequest,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION_REQUEST);
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                                @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aTransportServiceDescriptionRequest,
                                              aClassLoader,
                                              EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION_REQUEST);
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest)
  {
    return validateTransportServiceDescriptionRequest (aTransportServiceDescriptionRequest,
                                                       (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link TransportServiceDescriptionRequestType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return validateTransportServiceDescriptionRequest (aTransportServiceDescriptionRequest,
                                                       aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for UnawardedNotification.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <UnawardedNotificationType> unawardedNotification ()
  {
    return UBL21ValidatorBuilder.create (UnawardedNotificationType.class);
  }

  /**
   * Validate the passed {@link UnawardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification)
  {
    return UBL21Marshaller.validateUBLObject (aUnawardedNotification,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.UNAWARDED_NOTIFICATION);
  }

  /**
   * Validate the passed {@link UnawardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                                   @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aUnawardedNotification,
                                              aClassLoader,
                                              EUBL21DocumentType.UNAWARDED_NOTIFICATION);
  }

  /**
   * Validate the passed {@link UnawardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification)
  {
    return validateUnawardedNotification (aUnawardedNotification, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link UnawardedNotificationType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                      @Nullable ClassLoader aClassLoader)
  {
    return validateUnawardedNotification (aUnawardedNotification, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for UtilityStatement.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <UtilityStatementType> utilityStatement ()
  {
    return UBL21ValidatorBuilder.create (UtilityStatementType.class);
  }

  /**
   * Validate the passed {@link UtilityStatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement)
  {
    return UBL21Marshaller.validateUBLObject (aUtilityStatement,
                                              (ClassLoader) null,
                                              EUBL21DocumentType.UTILITY_STATEMENT);
  }

  /**
   * Validate the passed {@link UtilityStatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                              @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aUtilityStatement, aClassLoader, EUBL21DocumentType.UTILITY_STATEMENT);
  }

  /**
   * Validate the passed {@link UtilityStatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement)
  {
    return validateUtilityStatement (aUtilityStatement, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link UtilityStatementType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                 @Nullable ClassLoader aClassLoader)
  {
    return validateUtilityStatement (aUtilityStatement, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Waybill.
   * 
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21ValidatorBuilder <WaybillType> waybill ()
  {
    return UBL21ValidatorBuilder.create (WaybillType.class);
  }

  /**
   * Validate the passed {@link WaybillType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateWaybill (@Nonnull final WaybillType aWaybill)
  {
    return UBL21Marshaller.validateUBLObject (aWaybill, (ClassLoader) null, EUBL21DocumentType.WAYBILL);
  }

  /**
   * Validate the passed {@link WaybillType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The collected messages during validation. Never<code>null</code>.
   */
  @Deprecated
  @Nullable
  public static IResourceErrorGroup validateWaybill (@Nonnull final WaybillType aWaybill,
                                                     @Nullable ClassLoader aClassLoader)
  {
    return UBL21Marshaller.validateUBLObject (aWaybill, aClassLoader, EUBL21DocumentType.WAYBILL);
  }

  /**
   * Validate the passed {@link WaybillType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidWaybill (@Nonnull final WaybillType aWaybill)
  {
    return validateWaybill (aWaybill, (ClassLoader) null).containsNoError ();
  }

  /**
   * Validate the passed {@link WaybillType} object.
   * 
   * @param sParam
   *          the source object to validate. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return <code>true</code> if the object is valid, <code>false</code>
   *         otherwise.
   */
  @Deprecated
  public static boolean isValidWaybill (@Nonnull final WaybillType aWaybill, @Nullable ClassLoader aClassLoader)
  {
    return validateWaybill (aWaybill, aClassLoader).containsNoError ();
  }
}
