package com.helger.ubl20;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.error.IResourceErrorGroup;
import com.helger.ubl.api.AbstractUBLDocumentMarshaller;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_2.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.billoflading_2.BillOfLadingType;
import oasis.names.specification.ubl.schema.xsd.catalogue_2.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_2.CatalogueDeletionType;
import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_2.CatalogueItemSpecificationUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_2.CataloguePricingUpdateType;
import oasis.names.specification.ubl.schema.xsd.cataloguerequest_2.CatalogueRequestType;
import oasis.names.specification.ubl.schema.xsd.certificateoforigin_2.CertificateOfOriginType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_2.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_2.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.freightinvoice_2.FreightInvoiceType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.order_2.OrderType;
import oasis.names.specification.ubl.schema.xsd.ordercancellation_2.OrderCancellationType;
import oasis.names.specification.ubl.schema.xsd.orderchange_2.OrderChangeType;
import oasis.names.specification.ubl.schema.xsd.orderresponse_2.OrderResponseType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_2.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.packinglist_2.PackingListType;
import oasis.names.specification.ubl.schema.xsd.quotation_2.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_2.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.reminder_2.ReminderType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_2.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_2.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_2.SelfBilledCreditNoteType;
import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_2.SelfBilledInvoiceType;
import oasis.names.specification.ubl.schema.xsd.statement_2.StatementType;
import oasis.names.specification.ubl.schema.xsd.transportationstatus_2.TransportationStatusType;
import oasis.names.specification.ubl.schema.xsd.waybill_2.WaybillType;

/**
 * Validate all UBL 2.0 document types.
 *
 * @author Philip Helger
 */
@SuppressWarnings ("deprecation")
@NotThreadSafe
public final class UBL20Validator extends AbstractUBLDocumentMarshaller
{
  @PresentForCodeCoverage
  private static final UBL20Validator s_aInstance = new UBL20Validator ();

  private UBL20Validator ()
  {}

  /**
   * Create a validation builder for ApplicationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL20ValidatorBuilder.create (ApplicationResponseType.class);
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
    return UBL20Marshaller.validateUBLObject (aApplicationResponse,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.APPLICATION_RESPONSE);
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
                                                                 @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aApplicationResponse,
                                              aClassLoader,
                                              EUBL20DocumentType.APPLICATION_RESPONSE);
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
                                                    @Nullable final ClassLoader aClassLoader)
  {
    return validateApplicationResponse (aApplicationResponse, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for AttachedDocument.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL20ValidatorBuilder.create (AttachedDocumentType.class);
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
    return UBL20Marshaller.validateUBLObject (aAttachedDocument,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.ATTACHED_DOCUMENT);
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
                                                              @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aAttachedDocument, aClassLoader, EUBL20DocumentType.ATTACHED_DOCUMENT);
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
                                                 @Nullable final ClassLoader aClassLoader)
  {
    return validateAttachedDocument (aAttachedDocument, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for BillOfLading.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL20ValidatorBuilder.create (BillOfLadingType.class);
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
    return UBL20Marshaller.validateUBLObject (aBillOfLading, (ClassLoader) null, EUBL20DocumentType.BILL_OF_LADING);
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
                                                          @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aBillOfLading, aClassLoader, EUBL20DocumentType.BILL_OF_LADING);
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
                                             @Nullable final ClassLoader aClassLoader)
  {
    return validateBillOfLading (aBillOfLading, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Catalogue.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CatalogueType> catalogue ()
  {
    return UBL20ValidatorBuilder.create (CatalogueType.class);
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
    return UBL20Marshaller.validateUBLObject (aCatalogue, (ClassLoader) null, EUBL20DocumentType.CATALOGUE);
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
                                                       @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aCatalogue, aClassLoader, EUBL20DocumentType.CATALOGUE);
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
  public static boolean isValidCatalogue (@Nonnull final CatalogueType aCatalogue,
                                          @Nullable final ClassLoader aClassLoader)
  {
    return validateCatalogue (aCatalogue, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CatalogueDeletion.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL20ValidatorBuilder.create (CatalogueDeletionType.class);
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
    return UBL20Marshaller.validateUBLObject (aCatalogueDeletion,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.CATALOGUE_DELETION);
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
                                                               @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aCatalogueDeletion, aClassLoader, EUBL20DocumentType.CATALOGUE_DELETION);
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
                                                  @Nullable final ClassLoader aClassLoader)
  {
    return validateCatalogueDeletion (aCatalogueDeletion, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CatalogueItemSpecificationUpdate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL20ValidatorBuilder.create (CatalogueItemSpecificationUpdateType.class);
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
    return UBL20Marshaller.validateUBLObject (aCatalogueItemSpecificationUpdate,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE);
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
                                                                              @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aCatalogueItemSpecificationUpdate,
                                              aClassLoader,
                                              EUBL20DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE);
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
                                                                 @Nullable final ClassLoader aClassLoader)
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
  public static UBL20ValidatorBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL20ValidatorBuilder.create (CataloguePricingUpdateType.class);
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
    return UBL20Marshaller.validateUBLObject (aCataloguePricingUpdate,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.CATALOGUE_PRICING_UPDATE);
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
                                                                    @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aCataloguePricingUpdate,
                                              aClassLoader,
                                              EUBL20DocumentType.CATALOGUE_PRICING_UPDATE);
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
                                                       @Nullable final ClassLoader aClassLoader)
  {
    return validateCataloguePricingUpdate (aCataloguePricingUpdate, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CatalogueRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL20ValidatorBuilder.create (CatalogueRequestType.class);
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
    return UBL20Marshaller.validateUBLObject (aCatalogueRequest,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.CATALOGUE_REQUEST);
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
                                                              @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aCatalogueRequest, aClassLoader, EUBL20DocumentType.CATALOGUE_REQUEST);
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
                                                 @Nullable final ClassLoader aClassLoader)
  {
    return validateCatalogueRequest (aCatalogueRequest, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CertificateOfOrigin.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL20ValidatorBuilder.create (CertificateOfOriginType.class);
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
    return UBL20Marshaller.validateUBLObject (aCertificateOfOrigin,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.CERTIFICATE_OF_ORIGIN);
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
                                                                 @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aCertificateOfOrigin,
                                              aClassLoader,
                                              EUBL20DocumentType.CERTIFICATE_OF_ORIGIN);
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
                                                    @Nullable final ClassLoader aClassLoader)
  {
    return validateCertificateOfOrigin (aCertificateOfOrigin, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for CreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <CreditNoteType> creditNote ()
  {
    return UBL20ValidatorBuilder.create (CreditNoteType.class);
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
    return UBL20Marshaller.validateUBLObject (aCreditNote, (ClassLoader) null, EUBL20DocumentType.CREDIT_NOTE);
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
                                                        @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aCreditNote, aClassLoader, EUBL20DocumentType.CREDIT_NOTE);
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
                                           @Nullable final ClassLoader aClassLoader)
  {
    return validateCreditNote (aCreditNote, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for DebitNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <DebitNoteType> debitNote ()
  {
    return UBL20ValidatorBuilder.create (DebitNoteType.class);
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
    return UBL20Marshaller.validateUBLObject (aDebitNote, (ClassLoader) null, EUBL20DocumentType.DEBIT_NOTE);
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
                                                       @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aDebitNote, aClassLoader, EUBL20DocumentType.DEBIT_NOTE);
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
  public static boolean isValidDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                          @Nullable final ClassLoader aClassLoader)
  {
    return validateDebitNote (aDebitNote, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for DespatchAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL20ValidatorBuilder.create (DespatchAdviceType.class);
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
    return UBL20Marshaller.validateUBLObject (aDespatchAdvice, (ClassLoader) null, EUBL20DocumentType.DESPATCH_ADVICE);
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
                                                            @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aDespatchAdvice, aClassLoader, EUBL20DocumentType.DESPATCH_ADVICE);
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
                                               @Nullable final ClassLoader aClassLoader)
  {
    return validateDespatchAdvice (aDespatchAdvice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for ForwardingInstructions.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL20ValidatorBuilder.create (ForwardingInstructionsType.class);
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
    return UBL20Marshaller.validateUBLObject (aForwardingInstructions,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.FORWARDING_INSTRUCTIONS);
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
                                                                    @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aForwardingInstructions,
                                              aClassLoader,
                                              EUBL20DocumentType.FORWARDING_INSTRUCTIONS);
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
                                                       @Nullable final ClassLoader aClassLoader)
  {
    return validateForwardingInstructions (aForwardingInstructions, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for FreightInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL20ValidatorBuilder.create (FreightInvoiceType.class);
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
    return UBL20Marshaller.validateUBLObject (aFreightInvoice, (ClassLoader) null, EUBL20DocumentType.FREIGHT_INVOICE);
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
                                                            @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aFreightInvoice, aClassLoader, EUBL20DocumentType.FREIGHT_INVOICE);
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
                                               @Nullable final ClassLoader aClassLoader)
  {
    return validateFreightInvoice (aFreightInvoice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Invoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <InvoiceType> invoice ()
  {
    return UBL20ValidatorBuilder.create (InvoiceType.class);
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
    return UBL20Marshaller.validateUBLObject (aInvoice, (ClassLoader) null, EUBL20DocumentType.INVOICE);
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
                                                     @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aInvoice, aClassLoader, EUBL20DocumentType.INVOICE);
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
  public static boolean isValidInvoice (@Nonnull final InvoiceType aInvoice, @Nullable final ClassLoader aClassLoader)
  {
    return validateInvoice (aInvoice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Order.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <OrderType> order ()
  {
    return UBL20ValidatorBuilder.create (OrderType.class);
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
    return UBL20Marshaller.validateUBLObject (aOrder, (ClassLoader) null, EUBL20DocumentType.ORDER);
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
  public static IResourceErrorGroup validateOrder (@Nonnull final OrderType aOrder,
                                                   @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aOrder, aClassLoader, EUBL20DocumentType.ORDER);
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
  public static boolean isValidOrder (@Nonnull final OrderType aOrder, @Nullable final ClassLoader aClassLoader)
  {
    return validateOrder (aOrder, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for OrderCancellation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL20ValidatorBuilder.create (OrderCancellationType.class);
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
    return UBL20Marshaller.validateUBLObject (aOrderCancellation,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.ORDER_CANCELLATION);
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
                                                               @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aOrderCancellation, aClassLoader, EUBL20DocumentType.ORDER_CANCELLATION);
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
                                                  @Nullable final ClassLoader aClassLoader)
  {
    return validateOrderCancellation (aOrderCancellation, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for OrderChange.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <OrderChangeType> orderChange ()
  {
    return UBL20ValidatorBuilder.create (OrderChangeType.class);
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
    return UBL20Marshaller.validateUBLObject (aOrderChange, (ClassLoader) null, EUBL20DocumentType.ORDER_CHANGE);
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
                                                         @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aOrderChange, aClassLoader, EUBL20DocumentType.ORDER_CHANGE);
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
                                            @Nullable final ClassLoader aClassLoader)
  {
    return validateOrderChange (aOrderChange, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for OrderResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <OrderResponseType> orderResponse ()
  {
    return UBL20ValidatorBuilder.create (OrderResponseType.class);
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
    return UBL20Marshaller.validateUBLObject (aOrderResponse, (ClassLoader) null, EUBL20DocumentType.ORDER_RESPONSE);
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
                                                           @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aOrderResponse, aClassLoader, EUBL20DocumentType.ORDER_RESPONSE);
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
                                              @Nullable final ClassLoader aClassLoader)
  {
    return validateOrderResponse (aOrderResponse, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for OrderResponseSimple.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL20ValidatorBuilder.create (OrderResponseSimpleType.class);
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
    return UBL20Marshaller.validateUBLObject (aOrderResponseSimple,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.ORDER_RESPONSE_SIMPLE);
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
                                                                 @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aOrderResponseSimple,
                                              aClassLoader,
                                              EUBL20DocumentType.ORDER_RESPONSE_SIMPLE);
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
                                                    @Nullable final ClassLoader aClassLoader)
  {
    return validateOrderResponseSimple (aOrderResponseSimple, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for PackingList.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <PackingListType> packingList ()
  {
    return UBL20ValidatorBuilder.create (PackingListType.class);
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
    return UBL20Marshaller.validateUBLObject (aPackingList, (ClassLoader) null, EUBL20DocumentType.PACKING_LIST);
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
                                                         @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aPackingList, aClassLoader, EUBL20DocumentType.PACKING_LIST);
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
                                            @Nullable final ClassLoader aClassLoader)
  {
    return validatePackingList (aPackingList, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Quotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <QuotationType> quotation ()
  {
    return UBL20ValidatorBuilder.create (QuotationType.class);
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
    return UBL20Marshaller.validateUBLObject (aQuotation, (ClassLoader) null, EUBL20DocumentType.QUOTATION);
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
                                                       @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aQuotation, aClassLoader, EUBL20DocumentType.QUOTATION);
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
  public static boolean isValidQuotation (@Nonnull final QuotationType aQuotation,
                                          @Nullable final ClassLoader aClassLoader)
  {
    return validateQuotation (aQuotation, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for ReceiptAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL20ValidatorBuilder.create (ReceiptAdviceType.class);
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
    return UBL20Marshaller.validateUBLObject (aReceiptAdvice, (ClassLoader) null, EUBL20DocumentType.RECEIPT_ADVICE);
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
                                                           @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aReceiptAdvice, aClassLoader, EUBL20DocumentType.RECEIPT_ADVICE);
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
                                              @Nullable final ClassLoader aClassLoader)
  {
    return validateReceiptAdvice (aReceiptAdvice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Reminder.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <ReminderType> reminder ()
  {
    return UBL20ValidatorBuilder.create (ReminderType.class);
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
    return UBL20Marshaller.validateUBLObject (aReminder, (ClassLoader) null, EUBL20DocumentType.REMINDER);
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
                                                      @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aReminder, aClassLoader, EUBL20DocumentType.REMINDER);
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
  public static boolean isValidReminder (@Nonnull final ReminderType aReminder,
                                         @Nullable final ClassLoader aClassLoader)
  {
    return validateReminder (aReminder, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for RemittanceAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL20ValidatorBuilder.create (RemittanceAdviceType.class);
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
    return UBL20Marshaller.validateUBLObject (aRemittanceAdvice,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.REMITTANCE_ADVICE);
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
                                                              @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aRemittanceAdvice, aClassLoader, EUBL20DocumentType.REMITTANCE_ADVICE);
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
                                                 @Nullable final ClassLoader aClassLoader)
  {
    return validateRemittanceAdvice (aRemittanceAdvice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for RequestForQuotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL20ValidatorBuilder.create (RequestForQuotationType.class);
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
    return UBL20Marshaller.validateUBLObject (aRequestForQuotation,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.REQUEST_FOR_QUOTATION);
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
                                                                 @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aRequestForQuotation,
                                              aClassLoader,
                                              EUBL20DocumentType.REQUEST_FOR_QUOTATION);
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
                                                    @Nullable final ClassLoader aClassLoader)
  {
    return validateRequestForQuotation (aRequestForQuotation, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for SelfBilledCreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL20ValidatorBuilder.create (SelfBilledCreditNoteType.class);
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
    return UBL20Marshaller.validateUBLObject (aSelfBilledCreditNote,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.SELF_BILLED_CREDIT_NOTE);
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
                                                                  @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aSelfBilledCreditNote,
                                              aClassLoader,
                                              EUBL20DocumentType.SELF_BILLED_CREDIT_NOTE);
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
                                                     @Nullable final ClassLoader aClassLoader)
  {
    return validateSelfBilledCreditNote (aSelfBilledCreditNote, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for SelfBilledInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL20ValidatorBuilder.create (SelfBilledInvoiceType.class);
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
    return UBL20Marshaller.validateUBLObject (aSelfBilledInvoice,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.SELF_BILLED_INVOICE);
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
                                                               @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aSelfBilledInvoice, aClassLoader, EUBL20DocumentType.SELF_BILLED_INVOICE);
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
                                                  @Nullable final ClassLoader aClassLoader)
  {
    return validateSelfBilledInvoice (aSelfBilledInvoice, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Statement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <StatementType> statement ()
  {
    return UBL20ValidatorBuilder.create (StatementType.class);
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
    return UBL20Marshaller.validateUBLObject (aStatement, (ClassLoader) null, EUBL20DocumentType.STATEMENT);
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
                                                       @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aStatement, aClassLoader, EUBL20DocumentType.STATEMENT);
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
  public static boolean isValidStatement (@Nonnull final StatementType aStatement,
                                          @Nullable final ClassLoader aClassLoader)
  {
    return validateStatement (aStatement, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for TransportationStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL20ValidatorBuilder.create (TransportationStatusType.class);
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
    return UBL20Marshaller.validateUBLObject (aTransportationStatus,
                                              (ClassLoader) null,
                                              EUBL20DocumentType.TRANSPORTATION_STATUS);
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
                                                                  @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aTransportationStatus,
                                              aClassLoader,
                                              EUBL20DocumentType.TRANSPORTATION_STATUS);
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
                                                     @Nullable final ClassLoader aClassLoader)
  {
    return validateTransportationStatus (aTransportationStatus, aClassLoader).containsNoError ();
  }

  /**
   * Create a validation builder for Waybill.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL20ValidatorBuilder <WaybillType> waybill ()
  {
    return UBL20ValidatorBuilder.create (WaybillType.class);
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
    return UBL20Marshaller.validateUBLObject (aWaybill, (ClassLoader) null, EUBL20DocumentType.WAYBILL);
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
                                                     @Nullable final ClassLoader aClassLoader)
  {
    return UBL20Marshaller.validateUBLObject (aWaybill, aClassLoader, EUBL20DocumentType.WAYBILL);
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
  public static boolean isValidWaybill (@Nonnull final WaybillType aWaybill, @Nullable final ClassLoader aClassLoader)
  {
    return validateWaybill (aWaybill, aClassLoader).containsNoError ();
  }
}
