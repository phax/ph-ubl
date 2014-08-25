package com.helger.ubl;

import java.io.File;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

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

import org.w3c.dom.Document;

import com.helger.commons.annotations.PresentForCodeCoverage;
import com.helger.commons.state.ESuccess;

/**
 * Write all UBL 2.0 document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
 public final class UBL20Writer extends AbstractUBLDocumentMarshaller
 {
   @PresentForCodeCoverage
   @SuppressWarnings ("unused")
   private static final UBL20Writer s_aInstance = new UBL20Writer ();

   private UBL20Writer ()
  {}

  /**
   * Convert the passed {@link ApplicationResponseType} to a DOM
   * {@link Document} using the global validation event handler.
   * 
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse)
  {
    return writeApplicationResponse (aApplicationResponse, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a DOM
   * {@link Document} using a custom validation event handler.
   * 
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aApplicationResponse,
                                             EUBL20DocumentType.APPLICATION_RESPONSE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a {@link File} using
   * the global validation event handler.
   * 
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nonnull final File aResult)
  {
    return writeApplicationResponse (aApplicationResponse, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a {@link File} using
   * a custom validation event handler.
   * 
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeApplicationResponse (aApplicationResponse, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a custom
   * {@link Result} using the global validation event handler.
   * 
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nonnull final Result aResult)
  {
    return writeApplicationResponse (aApplicationResponse, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a custom
   * {@link Result} using a custom validation event handler.
   * 
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aApplicationResponse,
                                             EUBL20DocumentType.APPLICATION_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a DOM {@link Document}
   * using the global validation event handler.
   * 
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument)
  {
    return writeAttachedDocument (aAttachedDocument, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a DOM {@link Document}
   * using a custom validation event handler.
   * 
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aAttachedDocument,
                                             EUBL20DocumentType.ATTACHED_DOCUMENT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a {@link File} using the
   * global validation event handler.
   * 
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nonnull final File aResult)
  {
    return writeAttachedDocument (aAttachedDocument, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a {@link File} using a
   * custom validation event handler.
   * 
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeAttachedDocument (aAttachedDocument, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a custom {@link Result}
   * using the global validation event handler.
   * 
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nonnull final Result aResult)
  {
    return writeAttachedDocument (aAttachedDocument, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a custom {@link Result}
   * using a custom validation event handler.
   * 
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aAttachedDocument,
                                             EUBL20DocumentType.ATTACHED_DOCUMENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a DOM {@link Document} using
   * the global validation event handler.
   * 
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading)
  {
    return writeBillOfLading (aBillOfLading, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a DOM {@link Document} using
   * a custom validation event handler.
   * 
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aBillOfLading, EUBL20DocumentType.BILL_OF_LADING, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a {@link File} using the
   * global validation event handler.
   * 
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading, @Nonnull final File aResult)
  {
    return writeBillOfLading (aBillOfLading, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a {@link File} using a
   * custom validation event handler.
   * 
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ValidationEventHandler aCustomEventHandler,
                                            @Nonnull final File aResult)
  {
    return writeBillOfLading (aBillOfLading, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a custom {@link Result}
   * using the global validation event handler.
   * 
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading, @Nonnull final Result aResult)
  {
    return writeBillOfLading (aBillOfLading, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a custom {@link Result}
   * using a custom validation event handler.
   * 
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ValidationEventHandler aCustomEventHandler,
                                            @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aBillOfLading,
                                             EUBL20DocumentType.BILL_OF_LADING,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CatalogueType} to a DOM {@link Document} using
   * the global validation event handler.
   * 
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue)
  {
    return writeCatalogue (aCatalogue, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueType} to a DOM {@link Document} using a
   * custom validation event handler.
   * 
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogue, EUBL20DocumentType.CATALOGUE, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueType} to a {@link File} using the global
   * validation event handler.
   * 
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue, @Nonnull final File aResult)
  {
    return writeCatalogue (aCatalogue, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueType} to a {@link File} using a custom
   * validation event handler.
   * 
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeCatalogue (aCatalogue, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueType} to a custom {@link Result} using
   * the global validation event handler.
   * 
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue, @Nonnull final Result aResult)
  {
    return writeCatalogue (aCatalogue, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueType} to a custom {@link Result} using a
   * custom validation event handler.
   * 
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogue, EUBL20DocumentType.CATALOGUE, aCustomEventHandler, aResult);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a DOM {@link Document}
   * using the global validation event handler.
   * 
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a DOM {@link Document}
   * using a custom validation event handler.
   * 
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             EUBL20DocumentType.CATALOGUE_DELETION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a {@link File} using
   * the global validation event handler.
   * 
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nonnull final File aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a {@link File} using a
   * custom validation event handler.
   * 
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a custom {@link Result}
   * using the global validation event handler.
   * 
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nonnull final Result aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a custom {@link Result}
   * using a custom validation event handler.
   * 
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             EUBL20DocumentType.CATALOGUE_DELETION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a DOM
   * {@link Document} using the global validation event handler.
   * 
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a DOM
   * {@link Document} using a custom validation event handler.
   * 
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             EUBL20DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a
   * {@link File} using the global validation event handler.
   * 
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nonnull final File aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a
   * {@link File} using a custom validation event handler.
   * 
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                @Nonnull final File aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  aCustomEventHandler,
                                                  new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a custom
   * {@link Result} using the global validation event handler.
   * 
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nonnull final Result aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  getGlobalValidationEventHandler (),
                                                  aResult);
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a custom
   * {@link Result} using a custom validation event handler.
   * 
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             EUBL20DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a DOM
   * {@link Document} using the global validation event handler.
   * 
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a DOM
   * {@link Document} using a custom validation event handler.
   * 
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             EUBL20DocumentType.CATALOGUE_PRICING_UPDATE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a {@link File}
   * using the global validation event handler.
   * 
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nonnull final File aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a {@link File}
   * using a custom validation event handler.
   * 
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a custom
   * {@link Result} using the global validation event handler.
   * 
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nonnull final Result aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a custom
   * {@link Result} using a custom validation event handler.
   * 
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             EUBL20DocumentType.CATALOGUE_PRICING_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a DOM {@link Document}
   * using the global validation event handler.
   * 
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest)
  {
    return writeCatalogueRequest (aCatalogueRequest, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a DOM {@link Document}
   * using a custom validation event handler.
   * 
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueRequest,
                                             EUBL20DocumentType.CATALOGUE_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a {@link File} using the
   * global validation event handler.
   * 
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nonnull final File aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a {@link File} using a
   * custom validation event handler.
   * 
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a custom {@link Result}
   * using the global validation event handler.
   * 
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nonnull final Result aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a custom {@link Result}
   * using a custom validation event handler.
   * 
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCatalogueRequest,
                                             EUBL20DocumentType.CATALOGUE_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a DOM
   * {@link Document} using the global validation event handler.
   * 
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a DOM
   * {@link Document} using a custom validation event handler.
   * 
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             EUBL20DocumentType.CERTIFICATE_OF_ORIGIN,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a {@link File} using
   * the global validation event handler.
   * 
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nonnull final File aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a {@link File} using
   * a custom validation event handler.
   * 
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a custom
   * {@link Result} using the global validation event handler.
   * 
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nonnull final Result aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a custom
   * {@link Result} using a custom validation event handler.
   * 
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             EUBL20DocumentType.CERTIFICATE_OF_ORIGIN,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a DOM {@link Document} using
   * the global validation event handler.
   * 
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote)
  {
    return writeCreditNote (aCreditNote, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CreditNoteType} to a DOM {@link Document} using a
   * custom validation event handler.
   * 
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aCreditNote, EUBL20DocumentType.CREDIT_NOTE, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a {@link File} using the
   * global validation event handler.
   * 
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote, @Nonnull final File aResult)
  {
    return writeCreditNote (aCreditNote, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CreditNoteType} to a {@link File} using a custom
   * validation event handler.
   * 
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ValidationEventHandler aCustomEventHandler,
                                          @Nonnull final File aResult)
  {
    return writeCreditNote (aCreditNote, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CreditNoteType} to a custom {@link Result} using
   * the global validation event handler.
   * 
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote, @Nonnull final Result aResult)
  {
    return writeCreditNote (aCreditNote, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a custom {@link Result} using
   * a custom validation event handler.
   * 
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ValidationEventHandler aCustomEventHandler,
                                          @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aCreditNote, EUBL20DocumentType.CREDIT_NOTE, aCustomEventHandler, aResult);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a DOM {@link Document} using
   * the global validation event handler.
   * 
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote)
  {
    return writeDebitNote (aDebitNote, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DebitNoteType} to a DOM {@link Document} using a
   * custom validation event handler.
   * 
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aDebitNote, EUBL20DocumentType.DEBIT_NOTE, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a {@link File} using the global
   * validation event handler.
   * 
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote, @Nonnull final File aResult)
  {
    return writeDebitNote (aDebitNote, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DebitNoteType} to a {@link File} using a custom
   * validation event handler.
   * 
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeDebitNote (aDebitNote, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DebitNoteType} to a custom {@link Result} using
   * the global validation event handler.
   * 
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote, @Nonnull final Result aResult)
  {
    return writeDebitNote (aDebitNote, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a custom {@link Result} using a
   * custom validation event handler.
   * 
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aDebitNote, EUBL20DocumentType.DEBIT_NOTE, aCustomEventHandler, aResult);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   * 
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice)
  {
    return writeDespatchAdvice (aDespatchAdvice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   * 
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aDespatchAdvice, EUBL20DocumentType.DESPATCH_ADVICE, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a {@link File} using the
   * global validation event handler.
   * 
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nonnull final File aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a {@link File} using a
   * custom validation event handler.
   * 
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   * 
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nonnull final Result aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   * 
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aDespatchAdvice,
                                             EUBL20DocumentType.DESPATCH_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a DOM
   * {@link Document} using the global validation event handler.
   * 
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions)
  {
    return writeForwardingInstructions (aForwardingInstructions, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a DOM
   * {@link Document} using a custom validation event handler.
   * 
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aForwardingInstructions,
                                             EUBL20DocumentType.FORWARDING_INSTRUCTIONS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a {@link File}
   * using the global validation event handler.
   * 
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nonnull final File aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a {@link File}
   * using a custom validation event handler.
   * 
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a custom
   * {@link Result} using the global validation event handler.
   * 
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nonnull final Result aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a custom
   * {@link Result} using a custom validation event handler.
   * 
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aForwardingInstructions,
                                             EUBL20DocumentType.FORWARDING_INSTRUCTIONS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a DOM {@link Document}
   * using the global validation event handler.
   * 
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice)
  {
    return writeFreightInvoice (aFreightInvoice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a DOM {@link Document}
   * using a custom validation event handler.
   * 
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aFreightInvoice, EUBL20DocumentType.FREIGHT_INVOICE, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a {@link File} using the
   * global validation event handler.
   * 
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nonnull final File aResult)
  {
    return writeFreightInvoice (aFreightInvoice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a {@link File} using a
   * custom validation event handler.
   * 
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeFreightInvoice (aFreightInvoice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a custom {@link Result}
   * using the global validation event handler.
   * 
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nonnull final Result aResult)
  {
    return writeFreightInvoice (aFreightInvoice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a custom {@link Result}
   * using a custom validation event handler.
   * 
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aFreightInvoice,
                                             EUBL20DocumentType.FREIGHT_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link InvoiceType} to a DOM {@link Document} using the
   * global validation event handler.
   * 
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice)
  {
    return writeInvoice (aInvoice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link InvoiceType} to a DOM {@link Document} using a
   * custom validation event handler.
   * 
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aInvoice, EUBL20DocumentType.INVOICE, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link InvoiceType} to a {@link File} using the global
   * validation event handler.
   * 
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice, @Nonnull final File aResult)
  {
    return writeInvoice (aInvoice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InvoiceType} to a {@link File} using a custom
   * validation event handler.
   * 
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final File aResult)
  {
    return writeInvoice (aInvoice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InvoiceType} to a custom {@link Result} using the
   * global validation event handler.
   * 
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice, @Nonnull final Result aResult)
  {
    return writeInvoice (aInvoice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link InvoiceType} to a custom {@link Result} using a
   * custom validation event handler.
   * 
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aInvoice, EUBL20DocumentType.INVOICE, aCustomEventHandler, aResult);
  }

  /**
   * Convert the passed {@link OrderType} to a DOM {@link Document} using the
   * global validation event handler.
   * 
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder)
  {
    return writeOrder (aOrder, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderType} to a DOM {@link Document} using a
   * custom validation event handler.
   * 
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrder, EUBL20DocumentType.ORDER, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderType} to a {@link File} using the global
   * validation event handler.
   * 
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder, @Nonnull final File aResult)
  {
    return writeOrder (aOrder, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderType} to a {@link File} using a custom
   * validation event handler.
   * 
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                     @Nonnull final File aResult)
  {
    return writeOrder (aOrder, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderType} to a custom {@link Result} using the
   * global validation event handler.
   * 
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder, @Nonnull final Result aResult)
  {
    return writeOrder (aOrder, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderType} to a custom {@link Result} using a
   * custom validation event handler.
   * 
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                     @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrder, EUBL20DocumentType.ORDER, aCustomEventHandler, aResult);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a DOM {@link Document}
   * using the global validation event handler.
   * 
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation)
  {
    return writeOrderCancellation (aOrderCancellation, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a DOM {@link Document}
   * using a custom validation event handler.
   * 
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderCancellation,
                                             EUBL20DocumentType.ORDER_CANCELLATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a {@link File} using
   * the global validation event handler.
   * 
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nonnull final File aResult)
  {
    return writeOrderCancellation (aOrderCancellation, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a {@link File} using a
   * custom validation event handler.
   * 
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeOrderCancellation (aOrderCancellation, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a custom {@link Result}
   * using the global validation event handler.
   * 
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nonnull final Result aResult)
  {
    return writeOrderCancellation (aOrderCancellation, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a custom {@link Result}
   * using a custom validation event handler.
   * 
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderCancellation,
                                             EUBL20DocumentType.ORDER_CANCELLATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a DOM {@link Document} using
   * the global validation event handler.
   * 
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange)
  {
    return writeOrderChange (aOrderChange, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderChangeType} to a DOM {@link Document} using
   * a custom validation event handler.
   * 
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderChange, EUBL20DocumentType.ORDER_CHANGE, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a {@link File} using the
   * global validation event handler.
   * 
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange, @Nonnull final File aResult)
  {
    return writeOrderChange (aOrderChange, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderChangeType} to a {@link File} using a custom
   * validation event handler.
   * 
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writeOrderChange (aOrderChange, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderChangeType} to a custom {@link Result} using
   * the global validation event handler.
   * 
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange, @Nonnull final Result aResult)
  {
    return writeOrderChange (aOrderChange, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a custom {@link Result} using
   * a custom validation event handler.
   * 
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderChange,
                                             EUBL20DocumentType.ORDER_CHANGE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a DOM {@link Document}
   * using the global validation event handler.
   * 
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse)
  {
    return writeOrderResponse (aOrderResponse, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderResponseType} to a DOM {@link Document}
   * using a custom validation event handler.
   * 
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponse, EUBL20DocumentType.ORDER_RESPONSE, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a {@link File} using the
   * global validation event handler.
   * 
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nonnull final File aResult)
  {
    return writeOrderResponse (aOrderResponse, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseType} to a {@link File} using a
   * custom validation event handler.
   * 
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeOrderResponse (aOrderResponse, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseType} to a custom {@link Result}
   * using the global validation event handler.
   * 
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nonnull final Result aResult)
  {
    return writeOrderResponse (aOrderResponse, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a custom {@link Result}
   * using a custom validation event handler.
   * 
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponse,
                                             EUBL20DocumentType.ORDER_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a DOM
   * {@link Document} using the global validation event handler.
   * 
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a DOM
   * {@link Document} using a custom validation event handler.
   * 
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             EUBL20DocumentType.ORDER_RESPONSE_SIMPLE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a {@link File} using
   * the global validation event handler.
   * 
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nonnull final File aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a {@link File} using
   * a custom validation event handler.
   * 
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a custom
   * {@link Result} using the global validation event handler.
   * 
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nonnull final Result aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a custom
   * {@link Result} using a custom validation event handler.
   * 
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             EUBL20DocumentType.ORDER_RESPONSE_SIMPLE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link PackingListType} to a DOM {@link Document} using
   * the global validation event handler.
   * 
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList)
  {
    return writePackingList (aPackingList, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link PackingListType} to a DOM {@link Document} using
   * a custom validation event handler.
   * 
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aPackingList, EUBL20DocumentType.PACKING_LIST, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link PackingListType} to a {@link File} using the
   * global validation event handler.
   * 
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList, @Nonnull final File aResult)
  {
    return writePackingList (aPackingList, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PackingListType} to a {@link File} using a custom
   * validation event handler.
   * 
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writePackingList (aPackingList, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PackingListType} to a custom {@link Result} using
   * the global validation event handler.
   * 
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList, @Nonnull final Result aResult)
  {
    return writePackingList (aPackingList, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link PackingListType} to a custom {@link Result} using
   * a custom validation event handler.
   * 
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aPackingList,
                                             EUBL20DocumentType.PACKING_LIST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link QuotationType} to a DOM {@link Document} using
   * the global validation event handler.
   * 
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation)
  {
    return writeQuotation (aQuotation, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link QuotationType} to a DOM {@link Document} using a
   * custom validation event handler.
   * 
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aQuotation, EUBL20DocumentType.QUOTATION, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link QuotationType} to a {@link File} using the global
   * validation event handler.
   * 
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation, @Nonnull final File aResult)
  {
    return writeQuotation (aQuotation, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link QuotationType} to a {@link File} using a custom
   * validation event handler.
   * 
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeQuotation (aQuotation, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link QuotationType} to a custom {@link Result} using
   * the global validation event handler.
   * 
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation, @Nonnull final Result aResult)
  {
    return writeQuotation (aQuotation, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link QuotationType} to a custom {@link Result} using a
   * custom validation event handler.
   * 
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aQuotation, EUBL20DocumentType.QUOTATION, aCustomEventHandler, aResult);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   * 
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice)
  {
    return writeReceiptAdvice (aReceiptAdvice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   * 
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aReceiptAdvice, EUBL20DocumentType.RECEIPT_ADVICE, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a {@link File} using the
   * global validation event handler.
   * 
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nonnull final File aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a {@link File} using a
   * custom validation event handler.
   * 
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   * 
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nonnull final Result aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   * 
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aReceiptAdvice,
                                             EUBL20DocumentType.RECEIPT_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ReminderType} to a DOM {@link Document} using the
   * global validation event handler.
   * 
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder)
  {
    return writeReminder (aReminder, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ReminderType} to a DOM {@link Document} using a
   * custom validation event handler.
   * 
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aReminder, EUBL20DocumentType.REMINDER, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ReminderType} to a {@link File} using the global
   * validation event handler.
   * 
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder, @Nonnull final File aResult)
  {
    return writeReminder (aReminder, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReminderType} to a {@link File} using a custom
   * validation event handler.
   * 
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final File aResult)
  {
    return writeReminder (aReminder, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReminderType} to a custom {@link Result} using
   * the global validation event handler.
   * 
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder, @Nonnull final Result aResult)
  {
    return writeReminder (aReminder, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ReminderType} to a custom {@link Result} using a
   * custom validation event handler.
   * 
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aReminder, EUBL20DocumentType.REMINDER, aCustomEventHandler, aResult);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   * 
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   * 
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             EUBL20DocumentType.REMITTANCE_ADVICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a {@link File} using the
   * global validation event handler.
   * 
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nonnull final File aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a {@link File} using a
   * custom validation event handler.
   * 
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   * 
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nonnull final Result aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   * 
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             EUBL20DocumentType.REMITTANCE_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a DOM
   * {@link Document} using the global validation event handler.
   * 
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation)
  {
    return writeRequestForQuotation (aRequestForQuotation, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a DOM
   * {@link Document} using a custom validation event handler.
   * 
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aRequestForQuotation,
                                             EUBL20DocumentType.REQUEST_FOR_QUOTATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a {@link File} using
   * the global validation event handler.
   * 
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nonnull final File aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a {@link File} using
   * a custom validation event handler.
   * 
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a custom
   * {@link Result} using the global validation event handler.
   * 
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nonnull final Result aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a custom
   * {@link Result} using a custom validation event handler.
   * 
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aRequestForQuotation,
                                             EUBL20DocumentType.REQUEST_FOR_QUOTATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a DOM
   * {@link Document} using the global validation event handler.
   * 
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a DOM
   * {@link Document} using a custom validation event handler.
   * 
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             EUBL20DocumentType.SELF_BILLED_CREDIT_NOTE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a {@link File} using
   * the global validation event handler.
   * 
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nonnull final File aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a {@link File} using
   * a custom validation event handler.
   * 
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a custom
   * {@link Result} using the global validation event handler.
   * 
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nonnull final Result aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a custom
   * {@link Result} using a custom validation event handler.
   * 
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             EUBL20DocumentType.SELF_BILLED_CREDIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a DOM {@link Document}
   * using the global validation event handler.
   * 
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a DOM {@link Document}
   * using a custom validation event handler.
   * 
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             EUBL20DocumentType.SELF_BILLED_INVOICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a {@link File} using
   * the global validation event handler.
   * 
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nonnull final File aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a {@link File} using a
   * custom validation event handler.
   * 
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a custom {@link Result}
   * using the global validation event handler.
   * 
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nonnull final Result aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a custom {@link Result}
   * using a custom validation event handler.
   * 
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             EUBL20DocumentType.SELF_BILLED_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link StatementType} to a DOM {@link Document} using
   * the global validation event handler.
   * 
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement)
  {
    return writeStatement (aStatement, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link StatementType} to a DOM {@link Document} using a
   * custom validation event handler.
   * 
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aStatement, EUBL20DocumentType.STATEMENT, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link StatementType} to a {@link File} using the global
   * validation event handler.
   * 
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement, @Nonnull final File aResult)
  {
    return writeStatement (aStatement, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StatementType} to a {@link File} using a custom
   * validation event handler.
   * 
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeStatement (aStatement, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StatementType} to a custom {@link Result} using
   * the global validation event handler.
   * 
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement, @Nonnull final Result aResult)
  {
    return writeStatement (aStatement, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link StatementType} to a custom {@link Result} using a
   * custom validation event handler.
   * 
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aStatement, EUBL20DocumentType.STATEMENT, aCustomEventHandler, aResult);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a DOM
   * {@link Document} using the global validation event handler.
   * 
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus)
  {
    return writeTransportationStatus (aTransportationStatus, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a DOM
   * {@link Document} using a custom validation event handler.
   * 
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aTransportationStatus,
                                             EUBL20DocumentType.TRANSPORTATION_STATUS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a {@link File} using
   * the global validation event handler.
   * 
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nonnull final File aResult)
  {
    return writeTransportationStatus (aTransportationStatus, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a {@link File} using
   * a custom validation event handler.
   * 
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeTransportationStatus (aTransportationStatus, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a custom
   * {@link Result} using the global validation event handler.
   * 
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nonnull final Result aResult)
  {
    return writeTransportationStatus (aTransportationStatus, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a custom
   * {@link Result} using a custom validation event handler.
   * 
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aTransportationStatus,
                                             EUBL20DocumentType.TRANSPORTATION_STATUS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link WaybillType} to a DOM {@link Document} using the
   * global validation event handler.
   * 
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill)
  {
    return writeWaybill (aWaybill, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link WaybillType} to a DOM {@link Document} using a
   * custom validation event handler.
   * 
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.writeUBLDocument (aWaybill, EUBL20DocumentType.WAYBILL, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link WaybillType} to a {@link File} using the global
   * validation event handler.
   * 
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill, @Nonnull final File aResult)
  {
    return writeWaybill (aWaybill, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link WaybillType} to a {@link File} using a custom
   * validation event handler.
   * 
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final File aResult)
  {
    return writeWaybill (aWaybill, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link WaybillType} to a custom {@link Result} using the
   * global validation event handler.
   * 
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill, @Nonnull final Result aResult)
  {
    return writeWaybill (aWaybill, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link WaybillType} to a custom {@link Result} using a
   * custom validation event handler.
   * 
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL20Marshaller.writeUBLDocument (aWaybill, EUBL20DocumentType.WAYBILL, aCustomEventHandler, aResult);
  }
 }
