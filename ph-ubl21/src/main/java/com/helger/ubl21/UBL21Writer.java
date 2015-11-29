package com.helger.ubl21;

import java.io.File;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import com.helger.commons.annotation.PresentForCodeCoverage;
import com.helger.commons.state.ESuccess;
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
 * Write all UBL 2.1 document types.
 *
 * @author Philip Helger
 */
@SuppressWarnings ("deprecation")
@NotThreadSafe
public final class UBL21Writer extends AbstractUBLDocumentMarshaller
{
  @PresentForCodeCoverage
  private static final UBL21Writer s_aInstance = new UBL21Writer ();

  private UBL21Writer ()
  {}

  /**
   * Create a writer builder for ApplicationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBL21WriterBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse)
  {
    return writeApplicationResponse (aApplicationResponse, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader)
  {
    return writeApplicationResponse (aApplicationResponse, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aApplicationResponse,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.APPLICATION_RESPONSE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aApplicationResponse,
                                             aClassLoader,
                                             EUBL21DocumentType.APPLICATION_RESPONSE,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nonnull final File aResult)
  {
    return writeApplicationResponse (aApplicationResponse, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final File aResult)
  {
    return writeApplicationResponse (aApplicationResponse, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeApplicationResponse (aApplicationResponse, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeApplicationResponse (aApplicationResponse,
                                     aClassLoader,
                                     aCustomEventHandler,
                                     new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nonnull final Result aResult)
  {
    return writeApplicationResponse (aApplicationResponse, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final Result aResult)
  {
    return writeApplicationResponse (aApplicationResponse, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aApplicationResponse,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.APPLICATION_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ApplicationResponseType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aApplicationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeApplicationResponse (@Nonnull final ApplicationResponseType aApplicationResponse,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aApplicationResponse,
                                             aClassLoader,
                                             EUBL21DocumentType.APPLICATION_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for AttachedDocument.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <AttachedDocumentType> attachedDocument ()
  {
    return UBL21WriterBuilder.create (AttachedDocumentType.class);
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
  @Deprecated
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument)
  {
    return writeAttachedDocument (aAttachedDocument, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader)
  {
    return writeAttachedDocument (aAttachedDocument, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aAttachedDocument,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ATTACHED_DOCUMENT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aAttachedDocument,
                                             aClassLoader,
                                             EUBL21DocumentType.ATTACHED_DOCUMENT,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nonnull final File aResult)
  {
    return writeAttachedDocument (aAttachedDocument, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final File aResult)
  {
    return writeAttachedDocument (aAttachedDocument, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeAttachedDocument (aAttachedDocument, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeAttachedDocument (aAttachedDocument, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nonnull final Result aResult)
  {
    return writeAttachedDocument (aAttachedDocument, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final Result aResult)
  {
    return writeAttachedDocument (aAttachedDocument, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aAttachedDocument,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ATTACHED_DOCUMENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link AttachedDocumentType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aAttachedDocument
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAttachedDocument (@Nonnull final AttachedDocumentType aAttachedDocument,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aAttachedDocument,
                                             aClassLoader,
                                             EUBL21DocumentType.ATTACHED_DOCUMENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for AwardedNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <AwardedNotificationType> awardedNotification ()
  {
    return UBL21WriterBuilder.create (AwardedNotificationType.class);
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification)
  {
    return writeAwardedNotification (aAwardedNotification, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                   @Nullable final ClassLoader aClassLoader)
  {
    return writeAwardedNotification (aAwardedNotification, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aAwardedNotification,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.AWARDED_NOTIFICATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aAwardedNotification,
                                             aClassLoader,
                                             EUBL21DocumentType.AWARDED_NOTIFICATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                   @Nonnull final File aResult)
  {
    return writeAwardedNotification (aAwardedNotification, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final File aResult)
  {
    return writeAwardedNotification (aAwardedNotification, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeAwardedNotification (aAwardedNotification, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeAwardedNotification (aAwardedNotification,
                                     aClassLoader,
                                     aCustomEventHandler,
                                     new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                   @Nonnull final Result aResult)
  {
    return writeAwardedNotification (aAwardedNotification, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final Result aResult)
  {
    return writeAwardedNotification (aAwardedNotification, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aAwardedNotification,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.AWARDED_NOTIFICATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link AwardedNotificationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aAwardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeAwardedNotification (@Nonnull final AwardedNotificationType aAwardedNotification,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aAwardedNotification,
                                             aClassLoader,
                                             EUBL21DocumentType.AWARDED_NOTIFICATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for BillOfLading.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <BillOfLadingType> billOfLading ()
  {
    return UBL21WriterBuilder.create (BillOfLadingType.class);
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
  @Deprecated
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading)
  {
    return writeBillOfLading (aBillOfLading, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader)
  {
    return writeBillOfLading (aBillOfLading, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aBillOfLading,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.BILL_OF_LADING,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a DOM {@link Document} using
   * a custom validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader,
                                            @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aBillOfLading,
                                             aClassLoader,
                                             EUBL21DocumentType.BILL_OF_LADING,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading, @Nonnull final File aResult)
  {
    return writeBillOfLading (aBillOfLading, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader,
                                            @Nonnull final File aResult)
  {
    return writeBillOfLading (aBillOfLading, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ValidationEventHandler aCustomEventHandler,
                                            @Nonnull final File aResult)
  {
    return writeBillOfLading (aBillOfLading, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader,
                                            @Nullable final ValidationEventHandler aCustomEventHandler,
                                            @Nonnull final File aResult)
  {
    return writeBillOfLading (aBillOfLading, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nonnull final Result aResult)
  {
    return writeBillOfLading (aBillOfLading, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader,
                                            @Nonnull final Result aResult)
  {
    return writeBillOfLading (aBillOfLading, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ValidationEventHandler aCustomEventHandler,
                                            @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aBillOfLading,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.BILL_OF_LADING,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link BillOfLadingType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aBillOfLading
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeBillOfLading (@Nonnull final BillOfLadingType aBillOfLading,
                                            @Nullable final ClassLoader aClassLoader,
                                            @Nullable final ValidationEventHandler aCustomEventHandler,
                                            @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aBillOfLading,
                                             aClassLoader,
                                             EUBL21DocumentType.BILL_OF_LADING,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CallForTenders.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CallForTendersType> callForTenders ()
  {
    return UBL21WriterBuilder.create (CallForTendersType.class);
  }

  /**
   * Convert the passed {@link CallForTendersType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders)
  {
    return writeCallForTenders (aCallForTenders, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CallForTendersType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                              @Nullable final ClassLoader aClassLoader)
  {
    return writeCallForTenders (aCallForTenders, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CallForTendersType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCallForTenders,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CALL_FOR_TENDERS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CallForTendersType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCallForTenders,
                                             aClassLoader,
                                             EUBL21DocumentType.CALL_FOR_TENDERS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CallForTendersType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                              @Nonnull final File aResult)
  {
    return writeCallForTenders (aCallForTenders, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CallForTendersType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final File aResult)
  {
    return writeCallForTenders (aCallForTenders, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CallForTendersType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeCallForTenders (aCallForTenders, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CallForTendersType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeCallForTenders (aCallForTenders, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CallForTendersType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                              @Nonnull final Result aResult)
  {
    return writeCallForTenders (aCallForTenders, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CallForTendersType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final Result aResult)
  {
    return writeCallForTenders (aCallForTenders, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CallForTendersType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCallForTenders,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CALL_FOR_TENDERS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CallForTendersType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aCallForTenders
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCallForTenders (@Nonnull final CallForTendersType aCallForTenders,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCallForTenders,
                                             aClassLoader,
                                             EUBL21DocumentType.CALL_FOR_TENDERS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Catalogue.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CatalogueType> catalogue ()
  {
    return UBL21WriterBuilder.create (CatalogueType.class);
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
  @Deprecated
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue)
  {
    return writeCatalogue (aCatalogue, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader)
  {
    return writeCatalogue (aCatalogue, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogue,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CATALOGUE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogue,
                                             aClassLoader,
                                             EUBL21DocumentType.CATALOGUE,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue, @Nonnull final File aResult)
  {
    return writeCatalogue (aCatalogue, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final File aResult)
  {
    return writeCatalogue (aCatalogue, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeCatalogue (aCatalogue, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeCatalogue (aCatalogue, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue, @Nonnull final Result aResult)
  {
    return writeCatalogue (aCatalogue, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final Result aResult)
  {
    return writeCatalogue (aCatalogue, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogue,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CATALOGUE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CatalogueType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aCatalogue
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogue (@Nonnull final CatalogueType aCatalogue,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogue,
                                             aClassLoader,
                                             EUBL21DocumentType.CATALOGUE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CatalogueDeletion.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CatalogueDeletionType> catalogueDeletion ()
  {
    return UBL21WriterBuilder.create (CatalogueDeletionType.class);
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
  @Deprecated
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CATALOGUE_DELETION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             aClassLoader,
                                             EUBL21DocumentType.CATALOGUE_DELETION,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nonnull final File aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final File aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nonnull final Result aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final Result aResult)
  {
    return writeCatalogueDeletion (aCatalogueDeletion, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CATALOGUE_DELETION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CatalogueDeletionType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aCatalogueDeletion
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueDeletion (@Nonnull final CatalogueDeletionType aCatalogueDeletion,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueDeletion,
                                             aClassLoader,
                                             EUBL21DocumentType.CATALOGUE_DELETION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CatalogueItemSpecificationUpdate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return UBL21WriterBuilder.create (CatalogueItemSpecificationUpdateType.class);
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
  @Deprecated
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  aClassLoader,
                                                  getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             aClassLoader,
                                             EUBL21DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nonnull final File aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader,
                                                                @Nonnull final File aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  aClassLoader,
                                                  new StreamResult (aResult));
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
  @Deprecated
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
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                @Nonnull final File aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  aClassLoader,
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
  @Deprecated
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
   * {@link Result} using the global validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader,
                                                                @Nonnull final Result aResult)
  {
    return writeCatalogueItemSpecificationUpdate (aCatalogueItemSpecificationUpdate,
                                                  aClassLoader,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CatalogueItemSpecificationUpdateType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aCatalogueItemSpecificationUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueItemSpecificationUpdate (@Nonnull final CatalogueItemSpecificationUpdateType aCatalogueItemSpecificationUpdate,
                                                                @Nullable final ClassLoader aClassLoader,
                                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueItemSpecificationUpdate,
                                             aClassLoader,
                                             EUBL21DocumentType.CATALOGUE_ITEM_SPECIFICATION_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CataloguePricingUpdate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return UBL21WriterBuilder.create (CataloguePricingUpdateType.class);
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
  @Deprecated
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CATALOGUE_PRICING_UPDATE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             aClassLoader,
                                             EUBL21DocumentType.CATALOGUE_PRICING_UPDATE,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nonnull final File aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final File aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate,
                                        aClassLoader,
                                        aCustomEventHandler,
                                        new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nonnull final Result aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final Result aResult)
  {
    return writeCataloguePricingUpdate (aCataloguePricingUpdate,
                                        aClassLoader,
                                        getGlobalValidationEventHandler (),
                                        aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CATALOGUE_PRICING_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CataloguePricingUpdateType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aCataloguePricingUpdate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCataloguePricingUpdate (@Nonnull final CataloguePricingUpdateType aCataloguePricingUpdate,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCataloguePricingUpdate,
                                             aClassLoader,
                                             EUBL21DocumentType.CATALOGUE_PRICING_UPDATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CatalogueRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CatalogueRequestType> catalogueRequest ()
  {
    return UBL21WriterBuilder.create (CatalogueRequestType.class);
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
  @Deprecated
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest)
  {
    return writeCatalogueRequest (aCatalogueRequest, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader)
  {
    return writeCatalogueRequest (aCatalogueRequest, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CATALOGUE_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.CATALOGUE_REQUEST,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nonnull final File aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final File aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nonnull final Result aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final Result aResult)
  {
    return writeCatalogueRequest (aCatalogueRequest, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CATALOGUE_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CatalogueRequestType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aCatalogueRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCatalogueRequest (@Nonnull final CatalogueRequestType aCatalogueRequest,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCatalogueRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.CATALOGUE_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CertificateOfOrigin.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CertificateOfOriginType> certificateOfOrigin ()
  {
    return UBL21WriterBuilder.create (CertificateOfOriginType.class);
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
  @Deprecated
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CERTIFICATE_OF_ORIGIN,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             aClassLoader,
                                             EUBL21DocumentType.CERTIFICATE_OF_ORIGIN,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nonnull final File aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final File aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin,
                                     aClassLoader,
                                     aCustomEventHandler,
                                     new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nonnull final Result aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final Result aResult)
  {
    return writeCertificateOfOrigin (aCertificateOfOrigin, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CERTIFICATE_OF_ORIGIN,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CertificateOfOriginType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aCertificateOfOrigin
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCertificateOfOrigin (@Nonnull final CertificateOfOriginType aCertificateOfOrigin,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCertificateOfOrigin,
                                             aClassLoader,
                                             EUBL21DocumentType.CERTIFICATE_OF_ORIGIN,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for ContractAwardNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ContractAwardNoticeType> contractAwardNotice ()
  {
    return UBL21WriterBuilder.create (ContractAwardNoticeType.class);
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice)
  {
    return writeContractAwardNotice (aContractAwardNotice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                   @Nullable final ClassLoader aClassLoader)
  {
    return writeContractAwardNotice (aContractAwardNotice, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aContractAwardNotice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CONTRACT_AWARD_NOTICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aContractAwardNotice,
                                             aClassLoader,
                                             EUBL21DocumentType.CONTRACT_AWARD_NOTICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                   @Nonnull final File aResult)
  {
    return writeContractAwardNotice (aContractAwardNotice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final File aResult)
  {
    return writeContractAwardNotice (aContractAwardNotice, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeContractAwardNotice (aContractAwardNotice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeContractAwardNotice (aContractAwardNotice,
                                     aClassLoader,
                                     aCustomEventHandler,
                                     new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                   @Nonnull final Result aResult)
  {
    return writeContractAwardNotice (aContractAwardNotice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final Result aResult)
  {
    return writeContractAwardNotice (aContractAwardNotice, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aContractAwardNotice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CONTRACT_AWARD_NOTICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ContractAwardNoticeType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aContractAwardNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractAwardNotice (@Nonnull final ContractAwardNoticeType aContractAwardNotice,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aContractAwardNotice,
                                             aClassLoader,
                                             EUBL21DocumentType.CONTRACT_AWARD_NOTICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for ContractNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ContractNoticeType> contractNotice ()
  {
    return UBL21WriterBuilder.create (ContractNoticeType.class);
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeContractNotice (@Nonnull final ContractNoticeType aContractNotice)
  {
    return writeContractNotice (aContractNotice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                              @Nullable final ClassLoader aClassLoader)
  {
    return writeContractNotice (aContractNotice, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aContractNotice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CONTRACT_NOTICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aContractNotice,
                                             aClassLoader,
                                             EUBL21DocumentType.CONTRACT_NOTICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                              @Nonnull final File aResult)
  {
    return writeContractNotice (aContractNotice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final File aResult)
  {
    return writeContractNotice (aContractNotice, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeContractNotice (aContractNotice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeContractNotice (aContractNotice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                              @Nonnull final Result aResult)
  {
    return writeContractNotice (aContractNotice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final Result aResult)
  {
    return writeContractNotice (aContractNotice, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aContractNotice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CONTRACT_NOTICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ContractNoticeType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aContractNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeContractNotice (@Nonnull final ContractNoticeType aContractNotice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aContractNotice,
                                             aClassLoader,
                                             EUBL21DocumentType.CONTRACT_NOTICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for CreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <CreditNoteType> creditNote ()
  {
    return UBL21WriterBuilder.create (CreditNoteType.class);
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
  @Deprecated
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote)
  {
    return writeCreditNote (aCreditNote, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link CreditNoteType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader)
  {
    return writeCreditNote (aCreditNote, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCreditNote,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CREDIT_NOTE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader,
                                          @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aCreditNote,
                                             aClassLoader,
                                             EUBL21DocumentType.CREDIT_NOTE,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote, @Nonnull final File aResult)
  {
    return writeCreditNote (aCreditNote, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CreditNoteType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader,
                                          @Nonnull final File aResult)
  {
    return writeCreditNote (aCreditNote, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ValidationEventHandler aCustomEventHandler,
                                          @Nonnull final File aResult)
  {
    return writeCreditNote (aCreditNote, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link CreditNoteType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader,
                                          @Nullable final ValidationEventHandler aCustomEventHandler,
                                          @Nonnull final File aResult)
  {
    return writeCreditNote (aCreditNote, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote, @Nonnull final Result aResult)
  {
    return writeCreditNote (aCreditNote, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader,
                                          @Nonnull final Result aResult)
  {
    return writeCreditNote (aCreditNote, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ValidationEventHandler aCustomEventHandler,
                                          @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCreditNote,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.CREDIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link CreditNoteType} to a custom {@link Result} using
   * a custom validation event handler.
   *
   * @param aCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeCreditNote (@Nonnull final CreditNoteType aCreditNote,
                                          @Nullable final ClassLoader aClassLoader,
                                          @Nullable final ValidationEventHandler aCustomEventHandler,
                                          @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aCreditNote,
                                             aClassLoader,
                                             EUBL21DocumentType.CREDIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for DebitNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <DebitNoteType> debitNote ()
  {
    return UBL21WriterBuilder.create (DebitNoteType.class);
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
  @Deprecated
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote)
  {
    return writeDebitNote (aDebitNote, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DebitNoteType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader)
  {
    return writeDebitNote (aDebitNote, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aDebitNote,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.DEBIT_NOTE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aDebitNote,
                                             aClassLoader,
                                             EUBL21DocumentType.DEBIT_NOTE,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote, @Nonnull final File aResult)
  {
    return writeDebitNote (aDebitNote, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DebitNoteType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final File aResult)
  {
    return writeDebitNote (aDebitNote, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeDebitNote (aDebitNote, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DebitNoteType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeDebitNote (aDebitNote, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote, @Nonnull final Result aResult)
  {
    return writeDebitNote (aDebitNote, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final Result aResult)
  {
    return writeDebitNote (aDebitNote, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aDebitNote,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.DEBIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link DebitNoteType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aDebitNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDebitNote (@Nonnull final DebitNoteType aDebitNote,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aDebitNote,
                                             aClassLoader,
                                             EUBL21DocumentType.DEBIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for DespatchAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <DespatchAdviceType> despatchAdvice ()
  {
    return UBL21WriterBuilder.create (DespatchAdviceType.class);
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
  @Deprecated
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice)
  {
    return writeDespatchAdvice (aDespatchAdvice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader)
  {
    return writeDespatchAdvice (aDespatchAdvice, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aDespatchAdvice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.DESPATCH_ADVICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aDespatchAdvice,
                                             aClassLoader,
                                             EUBL21DocumentType.DESPATCH_ADVICE,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nonnull final File aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final File aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nonnull final Result aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final Result aResult)
  {
    return writeDespatchAdvice (aDespatchAdvice, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aDespatchAdvice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.DESPATCH_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link DespatchAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aDespatchAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDespatchAdvice (@Nonnull final DespatchAdviceType aDespatchAdvice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aDespatchAdvice,
                                             aClassLoader,
                                             EUBL21DocumentType.DESPATCH_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for DocumentStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <DocumentStatusType> documentStatus ()
  {
    return UBL21WriterBuilder.create (DocumentStatusType.class);
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus)
  {
    return writeDocumentStatus (aDocumentStatus, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                              @Nullable final ClassLoader aClassLoader)
  {
    return writeDocumentStatus (aDocumentStatus, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aDocumentStatus,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.DOCUMENT_STATUS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aDocumentStatus,
                                             aClassLoader,
                                             EUBL21DocumentType.DOCUMENT_STATUS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                              @Nonnull final File aResult)
  {
    return writeDocumentStatus (aDocumentStatus, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final File aResult)
  {
    return writeDocumentStatus (aDocumentStatus, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeDocumentStatus (aDocumentStatus, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeDocumentStatus (aDocumentStatus, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                              @Nonnull final Result aResult)
  {
    return writeDocumentStatus (aDocumentStatus, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final Result aResult)
  {
    return writeDocumentStatus (aDocumentStatus, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aDocumentStatus,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.DOCUMENT_STATUS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link DocumentStatusType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aDocumentStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatus (@Nonnull final DocumentStatusType aDocumentStatus,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aDocumentStatus,
                                             aClassLoader,
                                             EUBL21DocumentType.DOCUMENT_STATUS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for DocumentStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <DocumentStatusRequestType> documentStatusRequest ()
  {
    return UBL21WriterBuilder.create (DocumentStatusRequestType.class);
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest)
  {
    return writeDocumentStatusRequest (aDocumentStatusRequest, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                     @Nullable final ClassLoader aClassLoader)
  {
    return writeDocumentStatusRequest (aDocumentStatusRequest, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aDocumentStatusRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.DOCUMENT_STATUS_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aDocumentStatusRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.DOCUMENT_STATUS_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                     @Nonnull final File aResult)
  {
    return writeDocumentStatusRequest (aDocumentStatusRequest, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nonnull final File aResult)
  {
    return writeDocumentStatusRequest (aDocumentStatusRequest, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final File aResult)
  {
    return writeDocumentStatusRequest (aDocumentStatusRequest, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final File aResult)
  {
    return writeDocumentStatusRequest (aDocumentStatusRequest,
                                       aClassLoader,
                                       aCustomEventHandler,
                                       new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                     @Nonnull final Result aResult)
  {
    return writeDocumentStatusRequest (aDocumentStatusRequest, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nonnull final Result aResult)
  {
    return writeDocumentStatusRequest (aDocumentStatusRequest,
                                       aClassLoader,
                                       getGlobalValidationEventHandler (),
                                       aResult);
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aDocumentStatusRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.DOCUMENT_STATUS_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link DocumentStatusRequestType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aDocumentStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeDocumentStatusRequest (@Nonnull final DocumentStatusRequestType aDocumentStatusRequest,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aDocumentStatusRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.DOCUMENT_STATUS_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for ExceptionCriteria.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ExceptionCriteriaType> exceptionCriteria ()
  {
    return UBL21WriterBuilder.create (ExceptionCriteriaType.class);
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria)
  {
    return writeExceptionCriteria (aExceptionCriteria, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                 @Nullable final ClassLoader aClassLoader)
  {
    return writeExceptionCriteria (aExceptionCriteria, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aExceptionCriteria,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.EXCEPTION_CRITERIA,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aExceptionCriteria,
                                             aClassLoader,
                                             EUBL21DocumentType.EXCEPTION_CRITERIA,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                 @Nonnull final File aResult)
  {
    return writeExceptionCriteria (aExceptionCriteria, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final File aResult)
  {
    return writeExceptionCriteria (aExceptionCriteria, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeExceptionCriteria (aExceptionCriteria, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeExceptionCriteria (aExceptionCriteria, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                 @Nonnull final Result aResult)
  {
    return writeExceptionCriteria (aExceptionCriteria, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final Result aResult)
  {
    return writeExceptionCriteria (aExceptionCriteria, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aExceptionCriteria,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.EXCEPTION_CRITERIA,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ExceptionCriteriaType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aExceptionCriteria
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionCriteria (@Nonnull final ExceptionCriteriaType aExceptionCriteria,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aExceptionCriteria,
                                             aClassLoader,
                                             EUBL21DocumentType.EXCEPTION_CRITERIA,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for ExceptionNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ExceptionNotificationType> exceptionNotification ()
  {
    return UBL21WriterBuilder.create (ExceptionNotificationType.class);
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification)
  {
    return writeExceptionNotification (aExceptionNotification, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                     @Nullable final ClassLoader aClassLoader)
  {
    return writeExceptionNotification (aExceptionNotification, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aExceptionNotification,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.EXCEPTION_NOTIFICATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aExceptionNotification,
                                             aClassLoader,
                                             EUBL21DocumentType.EXCEPTION_NOTIFICATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                     @Nonnull final File aResult)
  {
    return writeExceptionNotification (aExceptionNotification, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nonnull final File aResult)
  {
    return writeExceptionNotification (aExceptionNotification, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final File aResult)
  {
    return writeExceptionNotification (aExceptionNotification, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final File aResult)
  {
    return writeExceptionNotification (aExceptionNotification,
                                       aClassLoader,
                                       aCustomEventHandler,
                                       new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                     @Nonnull final Result aResult)
  {
    return writeExceptionNotification (aExceptionNotification, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nonnull final Result aResult)
  {
    return writeExceptionNotification (aExceptionNotification,
                                       aClassLoader,
                                       getGlobalValidationEventHandler (),
                                       aResult);
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aExceptionNotification,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.EXCEPTION_NOTIFICATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ExceptionNotificationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aExceptionNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeExceptionNotification (@Nonnull final ExceptionNotificationType aExceptionNotification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aExceptionNotification,
                                             aClassLoader,
                                             EUBL21DocumentType.EXCEPTION_NOTIFICATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Forecast.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ForecastType> forecast ()
  {
    return UBL21WriterBuilder.create (ForecastType.class);
  }

  /**
   * Convert the passed {@link ForecastType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForecast (@Nonnull final ForecastType aForecast)
  {
    return writeForecast (aForecast, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ForecastType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForecast (@Nonnull final ForecastType aForecast, @Nullable final ClassLoader aClassLoader)
  {
    return writeForecast (aForecast, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ForecastType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForecast (@Nonnull final ForecastType aForecast,
                                        @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aForecast,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.FORECAST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ForecastType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForecast (@Nonnull final ForecastType aForecast,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aForecast, aClassLoader, EUBL21DocumentType.FORECAST, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ForecastType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecast (@Nonnull final ForecastType aForecast, @Nonnull final File aResult)
  {
    return writeForecast (aForecast, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForecastType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecast (@Nonnull final ForecastType aForecast,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nonnull final File aResult)
  {
    return writeForecast (aForecast, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForecastType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecast (@Nonnull final ForecastType aForecast,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final File aResult)
  {
    return writeForecast (aForecast, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForecastType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecast (@Nonnull final ForecastType aForecast,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final File aResult)
  {
    return writeForecast (aForecast, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForecastType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecast (@Nonnull final ForecastType aForecast, @Nonnull final Result aResult)
  {
    return writeForecast (aForecast, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ForecastType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecast (@Nonnull final ForecastType aForecast,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nonnull final Result aResult)
  {
    return writeForecast (aForecast, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ForecastType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecast (@Nonnull final ForecastType aForecast,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aForecast,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.FORECAST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ForecastType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aForecast
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecast (@Nonnull final ForecastType aForecast,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aForecast,
                                             aClassLoader,
                                             EUBL21DocumentType.FORECAST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for ForecastRevision.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ForecastRevisionType> forecastRevision ()
  {
    return UBL21WriterBuilder.create (ForecastRevisionType.class);
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision)
  {
    return writeForecastRevision (aForecastRevision, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                @Nullable final ClassLoader aClassLoader)
  {
    return writeForecastRevision (aForecastRevision, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aForecastRevision,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.FORECAST_REVISION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aForecastRevision,
                                             aClassLoader,
                                             EUBL21DocumentType.FORECAST_REVISION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                @Nonnull final File aResult)
  {
    return writeForecastRevision (aForecastRevision, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final File aResult)
  {
    return writeForecastRevision (aForecastRevision, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeForecastRevision (aForecastRevision, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeForecastRevision (aForecastRevision, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                @Nonnull final Result aResult)
  {
    return writeForecastRevision (aForecastRevision, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final Result aResult)
  {
    return writeForecastRevision (aForecastRevision, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aForecastRevision,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.FORECAST_REVISION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ForecastRevisionType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aForecastRevision
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForecastRevision (@Nonnull final ForecastRevisionType aForecastRevision,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aForecastRevision,
                                             aClassLoader,
                                             EUBL21DocumentType.FORECAST_REVISION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for ForwardingInstructions.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ForwardingInstructionsType> forwardingInstructions ()
  {
    return UBL21WriterBuilder.create (ForwardingInstructionsType.class);
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
  @Deprecated
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions)
  {
    return writeForwardingInstructions (aForwardingInstructions, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader)
  {
    return writeForwardingInstructions (aForwardingInstructions, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aForwardingInstructions,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.FORWARDING_INSTRUCTIONS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aForwardingInstructions,
                                             aClassLoader,
                                             EUBL21DocumentType.FORWARDING_INSTRUCTIONS,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nonnull final File aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final File aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions,
                                        aClassLoader,
                                        aCustomEventHandler,
                                        new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nonnull final Result aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final Result aResult)
  {
    return writeForwardingInstructions (aForwardingInstructions,
                                        aClassLoader,
                                        getGlobalValidationEventHandler (),
                                        aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aForwardingInstructions,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.FORWARDING_INSTRUCTIONS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ForwardingInstructionsType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aForwardingInstructions
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeForwardingInstructions (@Nonnull final ForwardingInstructionsType aForwardingInstructions,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aForwardingInstructions,
                                             aClassLoader,
                                             EUBL21DocumentType.FORWARDING_INSTRUCTIONS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for FreightInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <FreightInvoiceType> freightInvoice ()
  {
    return UBL21WriterBuilder.create (FreightInvoiceType.class);
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
  @Deprecated
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice)
  {
    return writeFreightInvoice (aFreightInvoice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader)
  {
    return writeFreightInvoice (aFreightInvoice, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aFreightInvoice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.FREIGHT_INVOICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aFreightInvoice,
                                             aClassLoader,
                                             EUBL21DocumentType.FREIGHT_INVOICE,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nonnull final File aResult)
  {
    return writeFreightInvoice (aFreightInvoice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final File aResult)
  {
    return writeFreightInvoice (aFreightInvoice, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeFreightInvoice (aFreightInvoice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final File aResult)
  {
    return writeFreightInvoice (aFreightInvoice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nonnull final Result aResult)
  {
    return writeFreightInvoice (aFreightInvoice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nonnull final Result aResult)
  {
    return writeFreightInvoice (aFreightInvoice, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aFreightInvoice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.FREIGHT_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link FreightInvoiceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aFreightInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFreightInvoice (@Nonnull final FreightInvoiceType aFreightInvoice,
                                              @Nullable final ClassLoader aClassLoader,
                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aFreightInvoice,
                                             aClassLoader,
                                             EUBL21DocumentType.FREIGHT_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for FulfilmentCancellation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <FulfilmentCancellationType> fulfilmentCancellation ()
  {
    return UBL21WriterBuilder.create (FulfilmentCancellationType.class);
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation)
  {
    return writeFulfilmentCancellation (aFulfilmentCancellation, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                      @Nullable final ClassLoader aClassLoader)
  {
    return writeFulfilmentCancellation (aFulfilmentCancellation, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aFulfilmentCancellation,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.FULFILMENT_CANCELATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aFulfilmentCancellation,
                                             aClassLoader,
                                             EUBL21DocumentType.FULFILMENT_CANCELATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                      @Nonnull final File aResult)
  {
    return writeFulfilmentCancellation (aFulfilmentCancellation, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final File aResult)
  {
    return writeFulfilmentCancellation (aFulfilmentCancellation, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeFulfilmentCancellation (aFulfilmentCancellation, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeFulfilmentCancellation (aFulfilmentCancellation,
                                        aClassLoader,
                                        aCustomEventHandler,
                                        new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                      @Nonnull final Result aResult)
  {
    return writeFulfilmentCancellation (aFulfilmentCancellation, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final Result aResult)
  {
    return writeFulfilmentCancellation (aFulfilmentCancellation,
                                        aClassLoader,
                                        getGlobalValidationEventHandler (),
                                        aResult);
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aFulfilmentCancellation,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.FULFILMENT_CANCELATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link FulfilmentCancellationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aFulfilmentCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeFulfilmentCancellation (@Nonnull final FulfilmentCancellationType aFulfilmentCancellation,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aFulfilmentCancellation,
                                             aClassLoader,
                                             EUBL21DocumentType.FULFILMENT_CANCELATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for GoodsItemItinerary.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <GoodsItemItineraryType> goodsItemItinerary ()
  {
    return UBL21WriterBuilder.create (GoodsItemItineraryType.class);
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary)
  {
    return writeGoodsItemItinerary (aGoodsItemItinerary, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                  @Nullable final ClassLoader aClassLoader)
  {
    return writeGoodsItemItinerary (aGoodsItemItinerary, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                  @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aGoodsItemItinerary,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.GOODS_ITEM_ITINERARY,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                  @Nullable final ClassLoader aClassLoader,
                                                  @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aGoodsItemItinerary,
                                             aClassLoader,
                                             EUBL21DocumentType.GOODS_ITEM_ITINERARY,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                  @Nonnull final File aResult)
  {
    return writeGoodsItemItinerary (aGoodsItemItinerary, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                  @Nullable final ClassLoader aClassLoader,
                                                  @Nonnull final File aResult)
  {
    return writeGoodsItemItinerary (aGoodsItemItinerary, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                  @Nullable final ValidationEventHandler aCustomEventHandler,
                                                  @Nonnull final File aResult)
  {
    return writeGoodsItemItinerary (aGoodsItemItinerary, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                  @Nullable final ClassLoader aClassLoader,
                                                  @Nullable final ValidationEventHandler aCustomEventHandler,
                                                  @Nonnull final File aResult)
  {
    return writeGoodsItemItinerary (aGoodsItemItinerary, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                  @Nonnull final Result aResult)
  {
    return writeGoodsItemItinerary (aGoodsItemItinerary, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                  @Nullable final ClassLoader aClassLoader,
                                                  @Nonnull final Result aResult)
  {
    return writeGoodsItemItinerary (aGoodsItemItinerary, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                  @Nullable final ValidationEventHandler aCustomEventHandler,
                                                  @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aGoodsItemItinerary,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.GOODS_ITEM_ITINERARY,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link GoodsItemItineraryType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aGoodsItemItinerary
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGoodsItemItinerary (@Nonnull final GoodsItemItineraryType aGoodsItemItinerary,
                                                  @Nullable final ClassLoader aClassLoader,
                                                  @Nullable final ValidationEventHandler aCustomEventHandler,
                                                  @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aGoodsItemItinerary,
                                             aClassLoader,
                                             EUBL21DocumentType.GOODS_ITEM_ITINERARY,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for GuaranteeCertificate.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <GuaranteeCertificateType> guaranteeCertificate ()
  {
    return UBL21WriterBuilder.create (GuaranteeCertificateType.class);
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate)
  {
    return writeGuaranteeCertificate (aGuaranteeCertificate, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                    @Nullable final ClassLoader aClassLoader)
  {
    return writeGuaranteeCertificate (aGuaranteeCertificate, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aGuaranteeCertificate,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.GUARANTEE_CERTIFICATE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aGuaranteeCertificate,
                                             aClassLoader,
                                             EUBL21DocumentType.GUARANTEE_CERTIFICATE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                    @Nonnull final File aResult)
  {
    return writeGuaranteeCertificate (aGuaranteeCertificate, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nonnull final File aResult)
  {
    return writeGuaranteeCertificate (aGuaranteeCertificate, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeGuaranteeCertificate (aGuaranteeCertificate, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeGuaranteeCertificate (aGuaranteeCertificate,
                                      aClassLoader,
                                      aCustomEventHandler,
                                      new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                    @Nonnull final Result aResult)
  {
    return writeGuaranteeCertificate (aGuaranteeCertificate, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nonnull final Result aResult)
  {
    return writeGuaranteeCertificate (aGuaranteeCertificate, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aGuaranteeCertificate,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.GUARANTEE_CERTIFICATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link GuaranteeCertificateType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aGuaranteeCertificate
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeGuaranteeCertificate (@Nonnull final GuaranteeCertificateType aGuaranteeCertificate,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aGuaranteeCertificate,
                                             aClassLoader,
                                             EUBL21DocumentType.GUARANTEE_CERTIFICATE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for InstructionForReturns.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <InstructionForReturnsType> instructionForReturns ()
  {
    return UBL21WriterBuilder.create (InstructionForReturnsType.class);
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns)
  {
    return writeInstructionForReturns (aInstructionForReturns, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                     @Nullable final ClassLoader aClassLoader)
  {
    return writeInstructionForReturns (aInstructionForReturns, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aInstructionForReturns,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.INSTRUCTION_FOR_RETURNS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aInstructionForReturns,
                                             aClassLoader,
                                             EUBL21DocumentType.INSTRUCTION_FOR_RETURNS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                     @Nonnull final File aResult)
  {
    return writeInstructionForReturns (aInstructionForReturns, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nonnull final File aResult)
  {
    return writeInstructionForReturns (aInstructionForReturns, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final File aResult)
  {
    return writeInstructionForReturns (aInstructionForReturns, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final File aResult)
  {
    return writeInstructionForReturns (aInstructionForReturns,
                                       aClassLoader,
                                       aCustomEventHandler,
                                       new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                     @Nonnull final Result aResult)
  {
    return writeInstructionForReturns (aInstructionForReturns, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nonnull final Result aResult)
  {
    return writeInstructionForReturns (aInstructionForReturns,
                                       aClassLoader,
                                       getGlobalValidationEventHandler (),
                                       aResult);
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aInstructionForReturns,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.INSTRUCTION_FOR_RETURNS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link InstructionForReturnsType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aInstructionForReturns
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInstructionForReturns (@Nonnull final InstructionForReturnsType aInstructionForReturns,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aInstructionForReturns,
                                             aClassLoader,
                                             EUBL21DocumentType.INSTRUCTION_FOR_RETURNS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for InventoryReport.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <InventoryReportType> inventoryReport ()
  {
    return UBL21WriterBuilder.create (InventoryReportType.class);
  }

  /**
   * Convert the passed {@link InventoryReportType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport)
  {
    return writeInventoryReport (aInventoryReport, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link InventoryReportType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                               @Nullable final ClassLoader aClassLoader)
  {
    return writeInventoryReport (aInventoryReport, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link InventoryReportType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                               @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aInventoryReport,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.INVENTORY_REPORT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link InventoryReportType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                               @Nullable final ClassLoader aClassLoader,
                                               @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aInventoryReport,
                                             aClassLoader,
                                             EUBL21DocumentType.INVENTORY_REPORT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link InventoryReportType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                               @Nonnull final File aResult)
  {
    return writeInventoryReport (aInventoryReport, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InventoryReportType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                               @Nullable final ClassLoader aClassLoader,
                                               @Nonnull final File aResult)
  {
    return writeInventoryReport (aInventoryReport, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InventoryReportType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                               @Nullable final ValidationEventHandler aCustomEventHandler,
                                               @Nonnull final File aResult)
  {
    return writeInventoryReport (aInventoryReport, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InventoryReportType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                               @Nullable final ClassLoader aClassLoader,
                                               @Nullable final ValidationEventHandler aCustomEventHandler,
                                               @Nonnull final File aResult)
  {
    return writeInventoryReport (aInventoryReport, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InventoryReportType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                               @Nonnull final Result aResult)
  {
    return writeInventoryReport (aInventoryReport, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link InventoryReportType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                               @Nullable final ClassLoader aClassLoader,
                                               @Nonnull final Result aResult)
  {
    return writeInventoryReport (aInventoryReport, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link InventoryReportType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                               @Nullable final ValidationEventHandler aCustomEventHandler,
                                               @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aInventoryReport,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.INVENTORY_REPORT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link InventoryReportType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aInventoryReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInventoryReport (@Nonnull final InventoryReportType aInventoryReport,
                                               @Nullable final ClassLoader aClassLoader,
                                               @Nullable final ValidationEventHandler aCustomEventHandler,
                                               @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aInventoryReport,
                                             aClassLoader,
                                             EUBL21DocumentType.INVENTORY_REPORT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Invoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <InvoiceType> invoice ()
  {
    return UBL21WriterBuilder.create (InvoiceType.class);
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
  @Deprecated
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice)
  {
    return writeInvoice (aInvoice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link InvoiceType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice, @Nullable final ClassLoader aClassLoader)
  {
    return writeInvoice (aInvoice, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aInvoice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.INVOICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link InvoiceType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aInvoice, aClassLoader, EUBL21DocumentType.INVOICE, aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice, @Nonnull final File aResult)
  {
    return writeInvoice (aInvoice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InvoiceType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nonnull final File aResult)
  {
    return writeInvoice (aInvoice, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final File aResult)
  {
    return writeInvoice (aInvoice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link InvoiceType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final File aResult)
  {
    return writeInvoice (aInvoice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice, @Nonnull final Result aResult)
  {
    return writeInvoice (aInvoice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link InvoiceType} to a custom {@link Result} using the
   * global validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nonnull final Result aResult)
  {
    return writeInvoice (aInvoice, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aInvoice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link InvoiceType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeInvoice (@Nonnull final InvoiceType aInvoice,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aInvoice,
                                             aClassLoader,
                                             EUBL21DocumentType.INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for ItemInformationRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ItemInformationRequestType> itemInformationRequest ()
  {
    return UBL21WriterBuilder.create (ItemInformationRequestType.class);
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest)
  {
    return writeItemInformationRequest (aItemInformationRequest, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                      @Nullable final ClassLoader aClassLoader)
  {
    return writeItemInformationRequest (aItemInformationRequest, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aItemInformationRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ITEM_INFORMATION_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aItemInformationRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.ITEM_INFORMATION_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                      @Nonnull final File aResult)
  {
    return writeItemInformationRequest (aItemInformationRequest, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final File aResult)
  {
    return writeItemInformationRequest (aItemInformationRequest, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeItemInformationRequest (aItemInformationRequest, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeItemInformationRequest (aItemInformationRequest,
                                        aClassLoader,
                                        aCustomEventHandler,
                                        new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                      @Nonnull final Result aResult)
  {
    return writeItemInformationRequest (aItemInformationRequest, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final Result aResult)
  {
    return writeItemInformationRequest (aItemInformationRequest,
                                        aClassLoader,
                                        getGlobalValidationEventHandler (),
                                        aResult);
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aItemInformationRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ITEM_INFORMATION_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ItemInformationRequestType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aItemInformationRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeItemInformationRequest (@Nonnull final ItemInformationRequestType aItemInformationRequest,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aItemInformationRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.ITEM_INFORMATION_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Order.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <OrderType> order ()
  {
    return UBL21WriterBuilder.create (OrderType.class);
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
  @Deprecated
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder)
  {
    return writeOrder (aOrder, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder, @Nullable final ClassLoader aClassLoader)
  {
    return writeOrder (aOrder, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aOrder, (ClassLoader) null, EUBL21DocumentType.ORDER, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ClassLoader aClassLoader,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aOrder, aClassLoader, EUBL21DocumentType.ORDER, aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder, @Nonnull final File aResult)
  {
    return writeOrder (aOrder, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ClassLoader aClassLoader,
                                     @Nonnull final File aResult)
  {
    return writeOrder (aOrder, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                     @Nonnull final File aResult)
  {
    return writeOrder (aOrder, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ClassLoader aClassLoader,
                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                     @Nonnull final File aResult)
  {
    return writeOrder (aOrder, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder, @Nonnull final Result aResult)
  {
    return writeOrder (aOrder, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderType} to a custom {@link Result} using the
   * global validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ClassLoader aClassLoader,
                                     @Nonnull final Result aResult)
  {
    return writeOrder (aOrder, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aOrder,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ORDER,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aOrder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrder (@Nonnull final OrderType aOrder,
                                     @Nullable final ClassLoader aClassLoader,
                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aOrder,
                                             aClassLoader,
                                             EUBL21DocumentType.ORDER,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for OrderCancellation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <OrderCancellationType> orderCancellation ()
  {
    return UBL21WriterBuilder.create (OrderCancellationType.class);
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
  @Deprecated
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation)
  {
    return writeOrderCancellation (aOrderCancellation, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader)
  {
    return writeOrderCancellation (aOrderCancellation, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderCancellation,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ORDER_CANCELLATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderCancellation,
                                             aClassLoader,
                                             EUBL21DocumentType.ORDER_CANCELLATION,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nonnull final File aResult)
  {
    return writeOrderCancellation (aOrderCancellation, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final File aResult)
  {
    return writeOrderCancellation (aOrderCancellation, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeOrderCancellation (aOrderCancellation, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeOrderCancellation (aOrderCancellation, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nonnull final Result aResult)
  {
    return writeOrderCancellation (aOrderCancellation, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final Result aResult)
  {
    return writeOrderCancellation (aOrderCancellation, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderCancellation,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ORDER_CANCELLATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderCancellationType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aOrderCancellation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderCancellation (@Nonnull final OrderCancellationType aOrderCancellation,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderCancellation,
                                             aClassLoader,
                                             EUBL21DocumentType.ORDER_CANCELLATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for OrderChange.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <OrderChangeType> orderChange ()
  {
    return UBL21WriterBuilder.create (OrderChangeType.class);
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
  @Deprecated
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange)
  {
    return writeOrderChange (aOrderChange, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderChangeType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader)
  {
    return writeOrderChange (aOrderChange, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderChange,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ORDER_CHANGE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a DOM {@link Document} using
   * a custom validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderChange,
                                             aClassLoader,
                                             EUBL21DocumentType.ORDER_CHANGE,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange, @Nonnull final File aResult)
  {
    return writeOrderChange (aOrderChange, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderChangeType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final File aResult)
  {
    return writeOrderChange (aOrderChange, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writeOrderChange (aOrderChange, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderChangeType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writeOrderChange (aOrderChange, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange, @Nonnull final Result aResult)
  {
    return writeOrderChange (aOrderChange, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final Result aResult)
  {
    return writeOrderChange (aOrderChange, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderChange,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ORDER_CHANGE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderChangeType} to a custom {@link Result} using
   * a custom validation event handler.
   *
   * @param aOrderChange
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderChange (@Nonnull final OrderChangeType aOrderChange,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderChange,
                                             aClassLoader,
                                             EUBL21DocumentType.ORDER_CHANGE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for OrderResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <OrderResponseType> orderResponse ()
  {
    return UBL21WriterBuilder.create (OrderResponseType.class);
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
  @Deprecated
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse)
  {
    return writeOrderResponse (aOrderResponse, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderResponseType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader)
  {
    return writeOrderResponse (aOrderResponse, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderResponse,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ORDER_RESPONSE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderResponse,
                                             aClassLoader,
                                             EUBL21DocumentType.ORDER_RESPONSE,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nonnull final File aResult)
  {
    return writeOrderResponse (aOrderResponse, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nonnull final File aResult)
  {
    return writeOrderResponse (aOrderResponse, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeOrderResponse (aOrderResponse, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeOrderResponse (aOrderResponse, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nonnull final Result aResult)
  {
    return writeOrderResponse (aOrderResponse, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nonnull final Result aResult)
  {
    return writeOrderResponse (aOrderResponse, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderResponse,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ORDER_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderResponseType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aOrderResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponse (@Nonnull final OrderResponseType aOrderResponse,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderResponse,
                                             aClassLoader,
                                             EUBL21DocumentType.ORDER_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for OrderResponseSimple.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <OrderResponseSimpleType> orderResponseSimple ()
  {
    return UBL21WriterBuilder.create (OrderResponseSimpleType.class);
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
  @Deprecated
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ORDER_RESPONSE_SIMPLE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             aClassLoader,
                                             EUBL21DocumentType.ORDER_RESPONSE_SIMPLE,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nonnull final File aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final File aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple,
                                     aClassLoader,
                                     aCustomEventHandler,
                                     new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nonnull final Result aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final Result aResult)
  {
    return writeOrderResponseSimple (aOrderResponseSimple, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.ORDER_RESPONSE_SIMPLE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link OrderResponseSimpleType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aOrderResponseSimple
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeOrderResponseSimple (@Nonnull final OrderResponseSimpleType aOrderResponseSimple,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aOrderResponseSimple,
                                             aClassLoader,
                                             EUBL21DocumentType.ORDER_RESPONSE_SIMPLE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for PackingList.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <PackingListType> packingList ()
  {
    return UBL21WriterBuilder.create (PackingListType.class);
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
  @Deprecated
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList)
  {
    return writePackingList (aPackingList, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link PackingListType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader)
  {
    return writePackingList (aPackingList, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aPackingList,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.PACKING_LIST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link PackingListType} to a DOM {@link Document} using
   * a custom validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aPackingList,
                                             aClassLoader,
                                             EUBL21DocumentType.PACKING_LIST,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList, @Nonnull final File aResult)
  {
    return writePackingList (aPackingList, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PackingListType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final File aResult)
  {
    return writePackingList (aPackingList, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writePackingList (aPackingList, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PackingListType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writePackingList (aPackingList, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList, @Nonnull final Result aResult)
  {
    return writePackingList (aPackingList, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link PackingListType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final Result aResult)
  {
    return writePackingList (aPackingList, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aPackingList,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.PACKING_LIST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link PackingListType} to a custom {@link Result} using
   * a custom validation event handler.
   *
   * @param aPackingList
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePackingList (@Nonnull final PackingListType aPackingList,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aPackingList,
                                             aClassLoader,
                                             EUBL21DocumentType.PACKING_LIST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for PriorInformationNotice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <PriorInformationNoticeType> priorInformationNotice ()
  {
    return UBL21WriterBuilder.create (PriorInformationNoticeType.class);
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice)
  {
    return writePriorInformationNotice (aPriorInformationNotice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                      @Nullable final ClassLoader aClassLoader)
  {
    return writePriorInformationNotice (aPriorInformationNotice, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aPriorInformationNotice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.PRIOR_INFORMATION_NOTICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aPriorInformationNotice,
                                             aClassLoader,
                                             EUBL21DocumentType.PRIOR_INFORMATION_NOTICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                      @Nonnull final File aResult)
  {
    return writePriorInformationNotice (aPriorInformationNotice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final File aResult)
  {
    return writePriorInformationNotice (aPriorInformationNotice, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writePriorInformationNotice (aPriorInformationNotice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writePriorInformationNotice (aPriorInformationNotice,
                                        aClassLoader,
                                        aCustomEventHandler,
                                        new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                      @Nonnull final Result aResult)
  {
    return writePriorInformationNotice (aPriorInformationNotice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final Result aResult)
  {
    return writePriorInformationNotice (aPriorInformationNotice,
                                        aClassLoader,
                                        getGlobalValidationEventHandler (),
                                        aResult);
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aPriorInformationNotice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.PRIOR_INFORMATION_NOTICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link PriorInformationNoticeType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aPriorInformationNotice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writePriorInformationNotice (@Nonnull final PriorInformationNoticeType aPriorInformationNotice,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aPriorInformationNotice,
                                             aClassLoader,
                                             EUBL21DocumentType.PRIOR_INFORMATION_NOTICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for ProductActivity.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ProductActivityType> productActivity ()
  {
    return UBL21WriterBuilder.create (ProductActivityType.class);
  }

  /**
   * Convert the passed {@link ProductActivityType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeProductActivity (@Nonnull final ProductActivityType aProductActivity)
  {
    return writeProductActivity (aProductActivity, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ProductActivityType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                               @Nullable final ClassLoader aClassLoader)
  {
    return writeProductActivity (aProductActivity, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ProductActivityType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                               @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aProductActivity,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.PRODUCT_ACTIVITY,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ProductActivityType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                               @Nullable final ClassLoader aClassLoader,
                                               @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aProductActivity,
                                             aClassLoader,
                                             EUBL21DocumentType.PRODUCT_ACTIVITY,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ProductActivityType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                               @Nonnull final File aResult)
  {
    return writeProductActivity (aProductActivity, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ProductActivityType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                               @Nullable final ClassLoader aClassLoader,
                                               @Nonnull final File aResult)
  {
    return writeProductActivity (aProductActivity, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ProductActivityType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                               @Nullable final ValidationEventHandler aCustomEventHandler,
                                               @Nonnull final File aResult)
  {
    return writeProductActivity (aProductActivity, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ProductActivityType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                               @Nullable final ClassLoader aClassLoader,
                                               @Nullable final ValidationEventHandler aCustomEventHandler,
                                               @Nonnull final File aResult)
  {
    return writeProductActivity (aProductActivity, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ProductActivityType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                               @Nonnull final Result aResult)
  {
    return writeProductActivity (aProductActivity, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ProductActivityType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                               @Nullable final ClassLoader aClassLoader,
                                               @Nonnull final Result aResult)
  {
    return writeProductActivity (aProductActivity, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ProductActivityType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                               @Nullable final ValidationEventHandler aCustomEventHandler,
                                               @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aProductActivity,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.PRODUCT_ACTIVITY,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ProductActivityType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aProductActivity
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeProductActivity (@Nonnull final ProductActivityType aProductActivity,
                                               @Nullable final ClassLoader aClassLoader,
                                               @Nullable final ValidationEventHandler aCustomEventHandler,
                                               @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aProductActivity,
                                             aClassLoader,
                                             EUBL21DocumentType.PRODUCT_ACTIVITY,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Quotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <QuotationType> quotation ()
  {
    return UBL21WriterBuilder.create (QuotationType.class);
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
  @Deprecated
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation)
  {
    return writeQuotation (aQuotation, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link QuotationType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader)
  {
    return writeQuotation (aQuotation, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aQuotation,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.QUOTATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link QuotationType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aQuotation,
                                             aClassLoader,
                                             EUBL21DocumentType.QUOTATION,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation, @Nonnull final File aResult)
  {
    return writeQuotation (aQuotation, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link QuotationType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final File aResult)
  {
    return writeQuotation (aQuotation, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeQuotation (aQuotation, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link QuotationType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeQuotation (aQuotation, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation, @Nonnull final Result aResult)
  {
    return writeQuotation (aQuotation, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link QuotationType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final Result aResult)
  {
    return writeQuotation (aQuotation, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aQuotation,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.QUOTATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link QuotationType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeQuotation (@Nonnull final QuotationType aQuotation,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aQuotation,
                                             aClassLoader,
                                             EUBL21DocumentType.QUOTATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for ReceiptAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ReceiptAdviceType> receiptAdvice ()
  {
    return UBL21WriterBuilder.create (ReceiptAdviceType.class);
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
  @Deprecated
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice)
  {
    return writeReceiptAdvice (aReceiptAdvice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader)
  {
    return writeReceiptAdvice (aReceiptAdvice, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aReceiptAdvice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.RECEIPT_ADVICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aReceiptAdvice,
                                             aClassLoader,
                                             EUBL21DocumentType.RECEIPT_ADVICE,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nonnull final File aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nonnull final File aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nonnull final Result aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nonnull final Result aResult)
  {
    return writeReceiptAdvice (aReceiptAdvice, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aReceiptAdvice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.RECEIPT_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ReceiptAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aReceiptAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReceiptAdvice (@Nonnull final ReceiptAdviceType aReceiptAdvice,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aReceiptAdvice,
                                             aClassLoader,
                                             EUBL21DocumentType.RECEIPT_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Reminder.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <ReminderType> reminder ()
  {
    return UBL21WriterBuilder.create (ReminderType.class);
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
  @Deprecated
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder)
  {
    return writeReminder (aReminder, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link ReminderType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder, @Nullable final ClassLoader aClassLoader)
  {
    return writeReminder (aReminder, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aReminder,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.REMINDER,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link ReminderType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aReminder, aClassLoader, EUBL21DocumentType.REMINDER, aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder, @Nonnull final File aResult)
  {
    return writeReminder (aReminder, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReminderType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nonnull final File aResult)
  {
    return writeReminder (aReminder, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final File aResult)
  {
    return writeReminder (aReminder, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link ReminderType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final File aResult)
  {
    return writeReminder (aReminder, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder, @Nonnull final Result aResult)
  {
    return writeReminder (aReminder, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link ReminderType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nonnull final Result aResult)
  {
    return writeReminder (aReminder, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aReminder,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.REMINDER,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link ReminderType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aReminder
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeReminder (@Nonnull final ReminderType aReminder,
                                        @Nullable final ClassLoader aClassLoader,
                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                        @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aReminder,
                                             aClassLoader,
                                             EUBL21DocumentType.REMINDER,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for RemittanceAdvice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <RemittanceAdviceType> remittanceAdvice ()
  {
    return UBL21WriterBuilder.create (RemittanceAdviceType.class);
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
  @Deprecated
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.REMITTANCE_ADVICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             aClassLoader,
                                             EUBL21DocumentType.REMITTANCE_ADVICE,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nonnull final File aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final File aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nonnull final Result aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final Result aResult)
  {
    return writeRemittanceAdvice (aRemittanceAdvice, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.REMITTANCE_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link RemittanceAdviceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aRemittanceAdvice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRemittanceAdvice (@Nonnull final RemittanceAdviceType aRemittanceAdvice,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aRemittanceAdvice,
                                             aClassLoader,
                                             EUBL21DocumentType.REMITTANCE_ADVICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for RequestForQuotation.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <RequestForQuotationType> requestForQuotation ()
  {
    return UBL21WriterBuilder.create (RequestForQuotationType.class);
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
  @Deprecated
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation)
  {
    return writeRequestForQuotation (aRequestForQuotation, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader)
  {
    return writeRequestForQuotation (aRequestForQuotation, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aRequestForQuotation,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.REQUEST_FOR_QUOTATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aRequestForQuotation,
                                             aClassLoader,
                                             EUBL21DocumentType.REQUEST_FOR_QUOTATION,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nonnull final File aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final File aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final File aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation,
                                     aClassLoader,
                                     aCustomEventHandler,
                                     new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nonnull final Result aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nonnull final Result aResult)
  {
    return writeRequestForQuotation (aRequestForQuotation, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aRequestForQuotation,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.REQUEST_FOR_QUOTATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link RequestForQuotationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aRequestForQuotation
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRequestForQuotation (@Nonnull final RequestForQuotationType aRequestForQuotation,
                                                   @Nullable final ClassLoader aClassLoader,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler,
                                                   @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aRequestForQuotation,
                                             aClassLoader,
                                             EUBL21DocumentType.REQUEST_FOR_QUOTATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for RetailEvent.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <RetailEventType> retailEvent ()
  {
    return UBL21WriterBuilder.create (RetailEventType.class);
  }

  /**
   * Convert the passed {@link RetailEventType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRetailEvent (@Nonnull final RetailEventType aRetailEvent)
  {
    return writeRetailEvent (aRetailEvent, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link RetailEventType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRetailEvent (@Nonnull final RetailEventType aRetailEvent,
                                           @Nullable final ClassLoader aClassLoader)
  {
    return writeRetailEvent (aRetailEvent, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link RetailEventType} to a DOM {@link Document} using
   * a custom validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRetailEvent (@Nonnull final RetailEventType aRetailEvent,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aRetailEvent,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.RETAIL_EVENT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link RetailEventType} to a DOM {@link Document} using
   * a custom validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeRetailEvent (@Nonnull final RetailEventType aRetailEvent,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aRetailEvent,
                                             aClassLoader,
                                             EUBL21DocumentType.RETAIL_EVENT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link RetailEventType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRetailEvent (@Nonnull final RetailEventType aRetailEvent, @Nonnull final File aResult)
  {
    return writeRetailEvent (aRetailEvent, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RetailEventType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRetailEvent (@Nonnull final RetailEventType aRetailEvent,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final File aResult)
  {
    return writeRetailEvent (aRetailEvent, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RetailEventType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRetailEvent (@Nonnull final RetailEventType aRetailEvent,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writeRetailEvent (aRetailEvent, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RetailEventType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRetailEvent (@Nonnull final RetailEventType aRetailEvent,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final File aResult)
  {
    return writeRetailEvent (aRetailEvent, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link RetailEventType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRetailEvent (@Nonnull final RetailEventType aRetailEvent, @Nonnull final Result aResult)
  {
    return writeRetailEvent (aRetailEvent, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link RetailEventType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRetailEvent (@Nonnull final RetailEventType aRetailEvent,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nonnull final Result aResult)
  {
    return writeRetailEvent (aRetailEvent, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link RetailEventType} to a custom {@link Result} using
   * a custom validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRetailEvent (@Nonnull final RetailEventType aRetailEvent,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aRetailEvent,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.RETAIL_EVENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link RetailEventType} to a custom {@link Result} using
   * a custom validation event handler.
   *
   * @param aRetailEvent
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeRetailEvent (@Nonnull final RetailEventType aRetailEvent,
                                           @Nullable final ClassLoader aClassLoader,
                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                           @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aRetailEvent,
                                             aClassLoader,
                                             EUBL21DocumentType.RETAIL_EVENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for SelfBilledCreditNote.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return UBL21WriterBuilder.create (SelfBilledCreditNoteType.class);
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
  @Deprecated
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.SELF_BILLED_CREDIT_NOTE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             aClassLoader,
                                             EUBL21DocumentType.SELF_BILLED_CREDIT_NOTE,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nonnull final File aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nonnull final File aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote,
                                      aClassLoader,
                                      aCustomEventHandler,
                                      new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nonnull final Result aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nonnull final Result aResult)
  {
    return writeSelfBilledCreditNote (aSelfBilledCreditNote, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.SELF_BILLED_CREDIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link SelfBilledCreditNoteType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aSelfBilledCreditNote
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledCreditNote (@Nonnull final SelfBilledCreditNoteType aSelfBilledCreditNote,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aSelfBilledCreditNote,
                                             aClassLoader,
                                             EUBL21DocumentType.SELF_BILLED_CREDIT_NOTE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for SelfBilledInvoice.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return UBL21WriterBuilder.create (SelfBilledInvoiceType.class);
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
  @Deprecated
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.SELF_BILLED_INVOICE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             aClassLoader,
                                             EUBL21DocumentType.SELF_BILLED_INVOICE,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nonnull final File aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final File aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final File aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nonnull final Result aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nonnull final Result aResult)
  {
    return writeSelfBilledInvoice (aSelfBilledInvoice, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.SELF_BILLED_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link SelfBilledInvoiceType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aSelfBilledInvoice
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeSelfBilledInvoice (@Nonnull final SelfBilledInvoiceType aSelfBilledInvoice,
                                                 @Nullable final ClassLoader aClassLoader,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler,
                                                 @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aSelfBilledInvoice,
                                             aClassLoader,
                                             EUBL21DocumentType.SELF_BILLED_INVOICE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Statement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <StatementType> statement ()
  {
    return UBL21WriterBuilder.create (StatementType.class);
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
  @Deprecated
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement)
  {
    return writeStatement (aStatement, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link StatementType} to a DOM {@link Document} using
   * the global validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader)
  {
    return writeStatement (aStatement, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aStatement,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.STATEMENT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link StatementType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aStatement,
                                             aClassLoader,
                                             EUBL21DocumentType.STATEMENT,
                                             aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement, @Nonnull final File aResult)
  {
    return writeStatement (aStatement, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StatementType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final File aResult)
  {
    return writeStatement (aStatement, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeStatement (aStatement, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StatementType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final File aResult)
  {
    return writeStatement (aStatement, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement, @Nonnull final Result aResult)
  {
    return writeStatement (aStatement, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link StatementType} to a custom {@link Result} using
   * the global validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nonnull final Result aResult)
  {
    return writeStatement (aStatement, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aStatement,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.STATEMENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link StatementType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStatement (@Nonnull final StatementType aStatement,
                                         @Nullable final ClassLoader aClassLoader,
                                         @Nullable final ValidationEventHandler aCustomEventHandler,
                                         @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aStatement,
                                             aClassLoader,
                                             EUBL21DocumentType.STATEMENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for StockAvailabilityReport.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <StockAvailabilityReportType> stockAvailabilityReport ()
  {
    return UBL21WriterBuilder.create (StockAvailabilityReportType.class);
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport)
  {
    return writeStockAvailabilityReport (aStockAvailabilityReport, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                       @Nullable final ClassLoader aClassLoader)
  {
    return writeStockAvailabilityReport (aStockAvailabilityReport, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aStockAvailabilityReport,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.STOCK_AVAILABILITY_REPORT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                       @Nullable final ClassLoader aClassLoader,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aStockAvailabilityReport,
                                             aClassLoader,
                                             EUBL21DocumentType.STOCK_AVAILABILITY_REPORT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                       @Nonnull final File aResult)
  {
    return writeStockAvailabilityReport (aStockAvailabilityReport, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                       @Nullable final ClassLoader aClassLoader,
                                                       @Nonnull final File aResult)
  {
    return writeStockAvailabilityReport (aStockAvailabilityReport, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                                       @Nonnull final File aResult)
  {
    return writeStockAvailabilityReport (aStockAvailabilityReport, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                       @Nullable final ClassLoader aClassLoader,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                                       @Nonnull final File aResult)
  {
    return writeStockAvailabilityReport (aStockAvailabilityReport,
                                         aClassLoader,
                                         aCustomEventHandler,
                                         new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                       @Nonnull final Result aResult)
  {
    return writeStockAvailabilityReport (aStockAvailabilityReport, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                       @Nullable final ClassLoader aClassLoader,
                                                       @Nonnull final Result aResult)
  {
    return writeStockAvailabilityReport (aStockAvailabilityReport,
                                         aClassLoader,
                                         getGlobalValidationEventHandler (),
                                         aResult);
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                                       @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aStockAvailabilityReport,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.STOCK_AVAILABILITY_REPORT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link StockAvailabilityReportType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aStockAvailabilityReport
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeStockAvailabilityReport (@Nonnull final StockAvailabilityReportType aStockAvailabilityReport,
                                                       @Nullable final ClassLoader aClassLoader,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                                       @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aStockAvailabilityReport,
                                             aClassLoader,
                                             EUBL21DocumentType.STOCK_AVAILABILITY_REPORT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Tender.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TenderType> tender ()
  {
    return UBL21WriterBuilder.create (TenderType.class);
  }

  /**
   * Convert the passed {@link TenderType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTender (@Nonnull final TenderType aTender)
  {
    return writeTender (aTender, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TenderType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTender (@Nonnull final TenderType aTender, @Nullable final ClassLoader aClassLoader)
  {
    return writeTender (aTender, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TenderType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTender (@Nonnull final TenderType aTender,
                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTender,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TENDER,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TenderType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTender (@Nonnull final TenderType aTender,
                                      @Nullable final ClassLoader aClassLoader,
                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTender, aClassLoader, EUBL21DocumentType.TENDER, aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TenderType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTender (@Nonnull final TenderType aTender, @Nonnull final File aResult)
  {
    return writeTender (aTender, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TenderType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTender (@Nonnull final TenderType aTender,
                                      @Nullable final ClassLoader aClassLoader,
                                      @Nonnull final File aResult)
  {
    return writeTender (aTender, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TenderType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTender (@Nonnull final TenderType aTender,
                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                      @Nonnull final File aResult)
  {
    return writeTender (aTender, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TenderType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTender (@Nonnull final TenderType aTender,
                                      @Nullable final ClassLoader aClassLoader,
                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                      @Nonnull final File aResult)
  {
    return writeTender (aTender, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TenderType} to a custom {@link Result} using the
   * global validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTender (@Nonnull final TenderType aTender, @Nonnull final Result aResult)
  {
    return writeTender (aTender, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TenderType} to a custom {@link Result} using the
   * global validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTender (@Nonnull final TenderType aTender,
                                      @Nullable final ClassLoader aClassLoader,
                                      @Nonnull final Result aResult)
  {
    return writeTender (aTender, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TenderType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTender (@Nonnull final TenderType aTender,
                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTender,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TENDER,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TenderType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aTender
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTender (@Nonnull final TenderType aTender,
                                      @Nullable final ClassLoader aClassLoader,
                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTender,
                                             aClassLoader,
                                             EUBL21DocumentType.TENDER,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TendererQualification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TendererQualificationType> tendererQualification ()
  {
    return UBL21WriterBuilder.create (TendererQualificationType.class);
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification)
  {
    return writeTendererQualification (aTendererQualification, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                     @Nullable final ClassLoader aClassLoader)
  {
    return writeTendererQualification (aTendererQualification, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTendererQualification,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TENDER_QUALIFICATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTendererQualification,
                                             aClassLoader,
                                             EUBL21DocumentType.TENDER_QUALIFICATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                     @Nonnull final File aResult)
  {
    return writeTendererQualification (aTendererQualification, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nonnull final File aResult)
  {
    return writeTendererQualification (aTendererQualification, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final File aResult)
  {
    return writeTendererQualification (aTendererQualification, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final File aResult)
  {
    return writeTendererQualification (aTendererQualification,
                                       aClassLoader,
                                       aCustomEventHandler,
                                       new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                     @Nonnull final Result aResult)
  {
    return writeTendererQualification (aTendererQualification, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nonnull final Result aResult)
  {
    return writeTendererQualification (aTendererQualification,
                                       aClassLoader,
                                       getGlobalValidationEventHandler (),
                                       aResult);
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTendererQualification,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TENDER_QUALIFICATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TendererQualificationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTendererQualification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualification (@Nonnull final TendererQualificationType aTendererQualification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTendererQualification,
                                             aClassLoader,
                                             EUBL21DocumentType.TENDER_QUALIFICATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TendererQualificationResponse.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TendererQualificationResponseType> tendererQualificationResponse ()
  {
    return UBL21WriterBuilder.create (TendererQualificationResponseType.class);
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse)
  {
    return writeTendererQualificationResponse (aTendererQualificationResponse, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                             @Nullable final ClassLoader aClassLoader)
  {
    return writeTendererQualificationResponse (aTendererQualificationResponse,
                                               aClassLoader,
                                               getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTendererQualificationResponse,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TENDER_QUALIFICATION_RESPONSE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                             @Nullable final ClassLoader aClassLoader,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTendererQualificationResponse,
                                             aClassLoader,
                                             EUBL21DocumentType.TENDER_QUALIFICATION_RESPONSE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                             @Nonnull final File aResult)
  {
    return writeTendererQualificationResponse (aTendererQualificationResponse, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                             @Nullable final ClassLoader aClassLoader,
                                                             @Nonnull final File aResult)
  {
    return writeTendererQualificationResponse (aTendererQualificationResponse,
                                               aClassLoader,
                                               new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                                             @Nonnull final File aResult)
  {
    return writeTendererQualificationResponse (aTendererQualificationResponse,
                                               aCustomEventHandler,
                                               new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                             @Nullable final ClassLoader aClassLoader,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                                             @Nonnull final File aResult)
  {
    return writeTendererQualificationResponse (aTendererQualificationResponse,
                                               aClassLoader,
                                               aCustomEventHandler,
                                               new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                             @Nonnull final Result aResult)
  {
    return writeTendererQualificationResponse (aTendererQualificationResponse,
                                               getGlobalValidationEventHandler (),
                                               aResult);
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                             @Nullable final ClassLoader aClassLoader,
                                                             @Nonnull final Result aResult)
  {
    return writeTendererQualificationResponse (aTendererQualificationResponse,
                                               aClassLoader,
                                               getGlobalValidationEventHandler (),
                                               aResult);
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                                             @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTendererQualificationResponse,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TENDER_QUALIFICATION_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TendererQualificationResponseType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTendererQualificationResponse
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTendererQualificationResponse (@Nonnull final TendererQualificationResponseType aTendererQualificationResponse,
                                                             @Nullable final ClassLoader aClassLoader,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                                             @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTendererQualificationResponse,
                                             aClassLoader,
                                             EUBL21DocumentType.TENDER_QUALIFICATION_RESPONSE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TenderReceipt.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TenderReceiptType> tenderReceipt ()
  {
    return UBL21WriterBuilder.create (TenderReceiptType.class);
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt)
  {
    return writeTenderReceipt (aTenderReceipt, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                             @Nullable final ClassLoader aClassLoader)
  {
    return writeTenderReceipt (aTenderReceipt, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTenderReceipt,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TENDER_RECEIPT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTenderReceipt,
                                             aClassLoader,
                                             EUBL21DocumentType.TENDER_RECEIPT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                             @Nonnull final File aResult)
  {
    return writeTenderReceipt (aTenderReceipt, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nonnull final File aResult)
  {
    return writeTenderReceipt (aTenderReceipt, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeTenderReceipt (aTenderReceipt, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final File aResult)
  {
    return writeTenderReceipt (aTenderReceipt, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                             @Nonnull final Result aResult)
  {
    return writeTenderReceipt (aTenderReceipt, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nonnull final Result aResult)
  {
    return writeTenderReceipt (aTenderReceipt, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTenderReceipt,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TENDER_RECEIPT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TenderReceiptType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aTenderReceipt
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTenderReceipt (@Nonnull final TenderReceiptType aTenderReceipt,
                                             @Nullable final ClassLoader aClassLoader,
                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                             @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTenderReceipt,
                                             aClassLoader,
                                             EUBL21DocumentType.TENDER_RECEIPT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TradeItemLocationProfile.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TradeItemLocationProfileType> tradeItemLocationProfile ()
  {
    return UBL21WriterBuilder.create (TradeItemLocationProfileType.class);
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile)
  {
    return writeTradeItemLocationProfile (aTradeItemLocationProfile, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                        @Nullable final ClassLoader aClassLoader)
  {
    return writeTradeItemLocationProfile (aTradeItemLocationProfile, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                        @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTradeItemLocationProfile,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRADE_ITEM_LOCATION_PROFILE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                        @Nullable final ClassLoader aClassLoader,
                                                        @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTradeItemLocationProfile,
                                             aClassLoader,
                                             EUBL21DocumentType.TRADE_ITEM_LOCATION_PROFILE,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                        @Nonnull final File aResult)
  {
    return writeTradeItemLocationProfile (aTradeItemLocationProfile, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                        @Nullable final ClassLoader aClassLoader,
                                                        @Nonnull final File aResult)
  {
    return writeTradeItemLocationProfile (aTradeItemLocationProfile, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                                        @Nonnull final File aResult)
  {
    return writeTradeItemLocationProfile (aTradeItemLocationProfile, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                        @Nullable final ClassLoader aClassLoader,
                                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                                        @Nonnull final File aResult)
  {
    return writeTradeItemLocationProfile (aTradeItemLocationProfile,
                                          aClassLoader,
                                          aCustomEventHandler,
                                          new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                        @Nonnull final Result aResult)
  {
    return writeTradeItemLocationProfile (aTradeItemLocationProfile, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                        @Nullable final ClassLoader aClassLoader,
                                                        @Nonnull final Result aResult)
  {
    return writeTradeItemLocationProfile (aTradeItemLocationProfile,
                                          aClassLoader,
                                          getGlobalValidationEventHandler (),
                                          aResult);
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                                        @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTradeItemLocationProfile,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRADE_ITEM_LOCATION_PROFILE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TradeItemLocationProfileType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTradeItemLocationProfile
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTradeItemLocationProfile (@Nonnull final TradeItemLocationProfileType aTradeItemLocationProfile,
                                                        @Nullable final ClassLoader aClassLoader,
                                                        @Nullable final ValidationEventHandler aCustomEventHandler,
                                                        @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTradeItemLocationProfile,
                                             aClassLoader,
                                             EUBL21DocumentType.TRADE_ITEM_LOCATION_PROFILE,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TransportationStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportationStatusType> transportationStatus ()
  {
    return UBL21WriterBuilder.create (TransportationStatusType.class);
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
  @Deprecated
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus)
  {
    return writeTransportationStatus (aTransportationStatus, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader)
  {
    return writeTransportationStatus (aTransportationStatus, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportationStatus,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORTATION_STATUS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportationStatus,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORTATION_STATUS,
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
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nonnull final File aResult)
  {
    return writeTransportationStatus (aTransportationStatus, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a {@link File} using
   * the global validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nonnull final File aResult)
  {
    return writeTransportationStatus (aTransportationStatus, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeTransportationStatus (aTransportationStatus, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a {@link File} using
   * a custom validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final File aResult)
  {
    return writeTransportationStatus (aTransportationStatus,
                                      aClassLoader,
                                      aCustomEventHandler,
                                      new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nonnull final Result aResult)
  {
    return writeTransportationStatus (aTransportationStatus, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nonnull final Result aResult)
  {
    return writeTransportationStatus (aTransportationStatus, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportationStatus,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORTATION_STATUS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TransportationStatusType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportationStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatus (@Nonnull final TransportationStatusType aTransportationStatus,
                                                    @Nullable final ClassLoader aClassLoader,
                                                    @Nullable final ValidationEventHandler aCustomEventHandler,
                                                    @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportationStatus,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORTATION_STATUS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TransportationStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportationStatusRequestType> transportationStatusRequest ()
  {
    return UBL21WriterBuilder.create (TransportationStatusRequestType.class);
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest)
  {
    return writeTransportationStatusRequest (aTransportationStatusRequest, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                           @Nullable final ClassLoader aClassLoader)
  {
    return writeTransportationStatusRequest (aTransportationStatusRequest,
                                             aClassLoader,
                                             getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportationStatusRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORTATION_STATUS_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                           @Nullable final ClassLoader aClassLoader,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportationStatusRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORTATION_STATUS_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                           @Nonnull final File aResult)
  {
    return writeTransportationStatusRequest (aTransportationStatusRequest, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                           @Nullable final ClassLoader aClassLoader,
                                                           @Nonnull final File aResult)
  {
    return writeTransportationStatusRequest (aTransportationStatusRequest, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                                           @Nonnull final File aResult)
  {
    return writeTransportationStatusRequest (aTransportationStatusRequest,
                                             aCustomEventHandler,
                                             new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                           @Nullable final ClassLoader aClassLoader,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                                           @Nonnull final File aResult)
  {
    return writeTransportationStatusRequest (aTransportationStatusRequest,
                                             aClassLoader,
                                             aCustomEventHandler,
                                             new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                           @Nonnull final Result aResult)
  {
    return writeTransportationStatusRequest (aTransportationStatusRequest, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                           @Nullable final ClassLoader aClassLoader,
                                                           @Nonnull final Result aResult)
  {
    return writeTransportationStatusRequest (aTransportationStatusRequest,
                                             aClassLoader,
                                             getGlobalValidationEventHandler (),
                                             aResult);
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                                           @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportationStatusRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORTATION_STATUS_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TransportationStatusRequestType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportationStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportationStatusRequest (@Nonnull final TransportationStatusRequestType aTransportationStatusRequest,
                                                           @Nullable final ClassLoader aClassLoader,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                                           @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportationStatusRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORTATION_STATUS_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TransportExecutionPlan.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportExecutionPlanType> transportExecutionPlan ()
  {
    return UBL21WriterBuilder.create (TransportExecutionPlanType.class);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan)
  {
    return writeTransportExecutionPlan (aTransportExecutionPlan, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                      @Nullable final ClassLoader aClassLoader)
  {
    return writeTransportExecutionPlan (aTransportExecutionPlan, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportExecutionPlan,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportExecutionPlan,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                      @Nonnull final File aResult)
  {
    return writeTransportExecutionPlan (aTransportExecutionPlan, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final File aResult)
  {
    return writeTransportExecutionPlan (aTransportExecutionPlan, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeTransportExecutionPlan (aTransportExecutionPlan, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final File aResult)
  {
    return writeTransportExecutionPlan (aTransportExecutionPlan,
                                        aClassLoader,
                                        aCustomEventHandler,
                                        new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                      @Nonnull final Result aResult)
  {
    return writeTransportExecutionPlan (aTransportExecutionPlan, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nonnull final Result aResult)
  {
    return writeTransportExecutionPlan (aTransportExecutionPlan,
                                        aClassLoader,
                                        getGlobalValidationEventHandler (),
                                        aResult);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportExecutionPlan,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportExecutionPlan
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlan (@Nonnull final TransportExecutionPlanType aTransportExecutionPlan,
                                                      @Nullable final ClassLoader aClassLoader,
                                                      @Nullable final ValidationEventHandler aCustomEventHandler,
                                                      @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportExecutionPlan,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TransportExecutionPlanRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportExecutionPlanRequestType> transportExecutionPlanRequest ()
  {
    return UBL21WriterBuilder.create (TransportExecutionPlanRequestType.class);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest)
  {
    return writeTransportExecutionPlanRequest (aTransportExecutionPlanRequest, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                             @Nullable final ClassLoader aClassLoader)
  {
    return writeTransportExecutionPlanRequest (aTransportExecutionPlanRequest,
                                               aClassLoader,
                                               getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportExecutionPlanRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                             @Nullable final ClassLoader aClassLoader,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportExecutionPlanRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                             @Nonnull final File aResult)
  {
    return writeTransportExecutionPlanRequest (aTransportExecutionPlanRequest, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                             @Nullable final ClassLoader aClassLoader,
                                                             @Nonnull final File aResult)
  {
    return writeTransportExecutionPlanRequest (aTransportExecutionPlanRequest,
                                               aClassLoader,
                                               new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                                             @Nonnull final File aResult)
  {
    return writeTransportExecutionPlanRequest (aTransportExecutionPlanRequest,
                                               aCustomEventHandler,
                                               new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                             @Nullable final ClassLoader aClassLoader,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                                             @Nonnull final File aResult)
  {
    return writeTransportExecutionPlanRequest (aTransportExecutionPlanRequest,
                                               aClassLoader,
                                               aCustomEventHandler,
                                               new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                             @Nonnull final Result aResult)
  {
    return writeTransportExecutionPlanRequest (aTransportExecutionPlanRequest,
                                               getGlobalValidationEventHandler (),
                                               aResult);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                             @Nullable final ClassLoader aClassLoader,
                                                             @Nonnull final Result aResult)
  {
    return writeTransportExecutionPlanRequest (aTransportExecutionPlanRequest,
                                               aClassLoader,
                                               getGlobalValidationEventHandler (),
                                               aResult);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                                             @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportExecutionPlanRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TransportExecutionPlanRequestType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportExecutionPlanRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportExecutionPlanRequest (@Nonnull final TransportExecutionPlanRequestType aTransportExecutionPlanRequest,
                                                             @Nullable final ClassLoader aClassLoader,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler,
                                                             @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportExecutionPlanRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_EXECUTION_PLAN_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TransportProgressStatus.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportProgressStatusType> transportProgressStatus ()
  {
    return UBL21WriterBuilder.create (TransportProgressStatusType.class);
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus)
  {
    return writeTransportProgressStatus (aTransportProgressStatus, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                       @Nullable final ClassLoader aClassLoader)
  {
    return writeTransportProgressStatus (aTransportProgressStatus, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportProgressStatus,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                       @Nullable final ClassLoader aClassLoader,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportProgressStatus,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                       @Nonnull final File aResult)
  {
    return writeTransportProgressStatus (aTransportProgressStatus, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                       @Nullable final ClassLoader aClassLoader,
                                                       @Nonnull final File aResult)
  {
    return writeTransportProgressStatus (aTransportProgressStatus, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                                       @Nonnull final File aResult)
  {
    return writeTransportProgressStatus (aTransportProgressStatus, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                       @Nullable final ClassLoader aClassLoader,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                                       @Nonnull final File aResult)
  {
    return writeTransportProgressStatus (aTransportProgressStatus,
                                         aClassLoader,
                                         aCustomEventHandler,
                                         new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                       @Nonnull final Result aResult)
  {
    return writeTransportProgressStatus (aTransportProgressStatus, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                       @Nullable final ClassLoader aClassLoader,
                                                       @Nonnull final Result aResult)
  {
    return writeTransportProgressStatus (aTransportProgressStatus,
                                         aClassLoader,
                                         getGlobalValidationEventHandler (),
                                         aResult);
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                                       @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportProgressStatus,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TransportProgressStatusType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportProgressStatus
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatus (@Nonnull final TransportProgressStatusType aTransportProgressStatus,
                                                       @Nullable final ClassLoader aClassLoader,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                                       @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportProgressStatus,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TransportProgressStatusRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportProgressStatusRequestType> transportProgressStatusRequest ()
  {
    return UBL21WriterBuilder.create (TransportProgressStatusRequestType.class);
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest)
  {
    return writeTransportProgressStatusRequest (aTransportProgressStatusRequest, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                              @Nullable final ClassLoader aClassLoader)
  {
    return writeTransportProgressStatusRequest (aTransportProgressStatusRequest,
                                                aClassLoader,
                                                getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportProgressStatusRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                              @Nullable final ClassLoader aClassLoader,
                                                              @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportProgressStatusRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                              @Nonnull final File aResult)
  {
    return writeTransportProgressStatusRequest (aTransportProgressStatusRequest, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                              @Nullable final ClassLoader aClassLoader,
                                                              @Nonnull final File aResult)
  {
    return writeTransportProgressStatusRequest (aTransportProgressStatusRequest,
                                                aClassLoader,
                                                new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                                              @Nonnull final File aResult)
  {
    return writeTransportProgressStatusRequest (aTransportProgressStatusRequest,
                                                aCustomEventHandler,
                                                new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                              @Nullable final ClassLoader aClassLoader,
                                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                                              @Nonnull final File aResult)
  {
    return writeTransportProgressStatusRequest (aTransportProgressStatusRequest,
                                                aClassLoader,
                                                aCustomEventHandler,
                                                new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                              @Nonnull final Result aResult)
  {
    return writeTransportProgressStatusRequest (aTransportProgressStatusRequest,
                                                getGlobalValidationEventHandler (),
                                                aResult);
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                              @Nullable final ClassLoader aClassLoader,
                                                              @Nonnull final Result aResult)
  {
    return writeTransportProgressStatusRequest (aTransportProgressStatusRequest,
                                                aClassLoader,
                                                getGlobalValidationEventHandler (),
                                                aResult);
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportProgressStatusRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TransportProgressStatusRequestType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportProgressStatusRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportProgressStatusRequest (@Nonnull final TransportProgressStatusRequestType aTransportProgressStatusRequest,
                                                              @Nullable final ClassLoader aClassLoader,
                                                              @Nullable final ValidationEventHandler aCustomEventHandler,
                                                              @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportProgressStatusRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_PROGRESS_STATUS_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TransportServiceDescription.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportServiceDescriptionType> transportServiceDescription ()
  {
    return UBL21WriterBuilder.create (TransportServiceDescriptionType.class);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription)
  {
    return writeTransportServiceDescription (aTransportServiceDescription, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                           @Nullable final ClassLoader aClassLoader)
  {
    return writeTransportServiceDescription (aTransportServiceDescription,
                                             aClassLoader,
                                             getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportServiceDescription,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                           @Nullable final ClassLoader aClassLoader,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportServiceDescription,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                           @Nonnull final File aResult)
  {
    return writeTransportServiceDescription (aTransportServiceDescription, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                           @Nullable final ClassLoader aClassLoader,
                                                           @Nonnull final File aResult)
  {
    return writeTransportServiceDescription (aTransportServiceDescription, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                                           @Nonnull final File aResult)
  {
    return writeTransportServiceDescription (aTransportServiceDescription,
                                             aCustomEventHandler,
                                             new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                           @Nullable final ClassLoader aClassLoader,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                                           @Nonnull final File aResult)
  {
    return writeTransportServiceDescription (aTransportServiceDescription,
                                             aClassLoader,
                                             aCustomEventHandler,
                                             new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                           @Nonnull final Result aResult)
  {
    return writeTransportServiceDescription (aTransportServiceDescription, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                           @Nullable final ClassLoader aClassLoader,
                                                           @Nonnull final Result aResult)
  {
    return writeTransportServiceDescription (aTransportServiceDescription,
                                             aClassLoader,
                                             getGlobalValidationEventHandler (),
                                             aResult);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                                           @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportServiceDescription,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aTransportServiceDescription
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescription (@Nonnull final TransportServiceDescriptionType aTransportServiceDescription,
                                                           @Nullable final ClassLoader aClassLoader,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler,
                                                           @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportServiceDescription,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for TransportServiceDescriptionRequest.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <TransportServiceDescriptionRequestType> transportServiceDescriptionRequest ()
  {
    return UBL21WriterBuilder.create (TransportServiceDescriptionRequestType.class);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest)
  {
    return writeTransportServiceDescriptionRequest (aTransportServiceDescriptionRequest,
                                                    getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                  @Nullable final ClassLoader aClassLoader)
  {
    return writeTransportServiceDescriptionRequest (aTransportServiceDescriptionRequest,
                                                    aClassLoader,
                                                    getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                  @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportServiceDescriptionRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                  @Nullable final ClassLoader aClassLoader,
                                                                  @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportServiceDescriptionRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION_REQUEST,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                  @Nonnull final File aResult)
  {
    return writeTransportServiceDescriptionRequest (aTransportServiceDescriptionRequest, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a
   * {@link File} using the global validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                  @Nullable final ClassLoader aClassLoader,
                                                                  @Nonnull final File aResult)
  {
    return writeTransportServiceDescriptionRequest (aTransportServiceDescriptionRequest,
                                                    aClassLoader,
                                                    new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                  @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                  @Nonnull final File aResult)
  {
    return writeTransportServiceDescriptionRequest (aTransportServiceDescriptionRequest,
                                                    aCustomEventHandler,
                                                    new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a
   * {@link File} using a custom validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                  @Nullable final ClassLoader aClassLoader,
                                                                  @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                  @Nonnull final File aResult)
  {
    return writeTransportServiceDescriptionRequest (aTransportServiceDescriptionRequest,
                                                    aClassLoader,
                                                    aCustomEventHandler,
                                                    new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a
   * custom {@link Result} using the global validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                  @Nonnull final Result aResult)
  {
    return writeTransportServiceDescriptionRequest (aTransportServiceDescriptionRequest,
                                                    getGlobalValidationEventHandler (),
                                                    aResult);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a
   * custom {@link Result} using the global validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                  @Nullable final ClassLoader aClassLoader,
                                                                  @Nonnull final Result aResult)
  {
    return writeTransportServiceDescriptionRequest (aTransportServiceDescriptionRequest,
                                                    aClassLoader,
                                                    getGlobalValidationEventHandler (),
                                                    aResult);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a
   * custom {@link Result} using a custom validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                  @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                  @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportServiceDescriptionRequest,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link TransportServiceDescriptionRequestType} to a
   * custom {@link Result} using a custom validation event handler.
   *
   * @param aTransportServiceDescriptionRequest
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeTransportServiceDescriptionRequest (@Nonnull final TransportServiceDescriptionRequestType aTransportServiceDescriptionRequest,
                                                                  @Nullable final ClassLoader aClassLoader,
                                                                  @Nullable final ValidationEventHandler aCustomEventHandler,
                                                                  @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aTransportServiceDescriptionRequest,
                                             aClassLoader,
                                             EUBL21DocumentType.TRANSPORT_SERVICE_DESCRIPTION_REQUEST,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for UnawardedNotification.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <UnawardedNotificationType> unawardedNotification ()
  {
    return UBL21WriterBuilder.create (UnawardedNotificationType.class);
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification)
  {
    return writeUnawardedNotification (aUnawardedNotification, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a DOM
   * {@link Document} using the global validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                     @Nullable final ClassLoader aClassLoader)
  {
    return writeUnawardedNotification (aUnawardedNotification, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aUnawardedNotification,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.UNAWARDED_NOTIFICATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a DOM
   * {@link Document} using a custom validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aUnawardedNotification,
                                             aClassLoader,
                                             EUBL21DocumentType.UNAWARDED_NOTIFICATION,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                     @Nonnull final File aResult)
  {
    return writeUnawardedNotification (aUnawardedNotification, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a {@link File}
   * using the global validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nonnull final File aResult)
  {
    return writeUnawardedNotification (aUnawardedNotification, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final File aResult)
  {
    return writeUnawardedNotification (aUnawardedNotification, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a {@link File}
   * using a custom validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final File aResult)
  {
    return writeUnawardedNotification (aUnawardedNotification,
                                       aClassLoader,
                                       aCustomEventHandler,
                                       new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                     @Nonnull final Result aResult)
  {
    return writeUnawardedNotification (aUnawardedNotification, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a custom
   * {@link Result} using the global validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nonnull final Result aResult)
  {
    return writeUnawardedNotification (aUnawardedNotification,
                                       aClassLoader,
                                       getGlobalValidationEventHandler (),
                                       aResult);
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aUnawardedNotification,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.UNAWARDED_NOTIFICATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link UnawardedNotificationType} to a custom
   * {@link Result} using a custom validation event handler.
   *
   * @param aUnawardedNotification
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUnawardedNotification (@Nonnull final UnawardedNotificationType aUnawardedNotification,
                                                     @Nullable final ClassLoader aClassLoader,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler,
                                                     @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aUnawardedNotification,
                                             aClassLoader,
                                             EUBL21DocumentType.UNAWARDED_NOTIFICATION,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for UtilityStatement.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <UtilityStatementType> utilityStatement ()
  {
    return UBL21WriterBuilder.create (UtilityStatementType.class);
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement)
  {
    return writeUtilityStatement (aUtilityStatement, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a DOM {@link Document}
   * using the global validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                @Nullable final ClassLoader aClassLoader)
  {
    return writeUtilityStatement (aUtilityStatement, aClassLoader, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aUtilityStatement,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.UTILITY_STATEMENT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a DOM {@link Document}
   * using a custom validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aUtilityStatement,
                                             aClassLoader,
                                             EUBL21DocumentType.UTILITY_STATEMENT,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                @Nonnull final File aResult)
  {
    return writeUtilityStatement (aUtilityStatement, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a {@link File} using the
   * global validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final File aResult)
  {
    return writeUtilityStatement (aUtilityStatement, aClassLoader, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeUtilityStatement (aUtilityStatement, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a {@link File} using a
   * custom validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final File aResult)
  {
    return writeUtilityStatement (aUtilityStatement, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                @Nonnull final Result aResult)
  {
    return writeUtilityStatement (aUtilityStatement, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a custom {@link Result}
   * using the global validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nonnull final Result aResult)
  {
    return writeUtilityStatement (aUtilityStatement, aClassLoader, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aUtilityStatement,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.UTILITY_STATEMENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link UtilityStatementType} to a custom {@link Result}
   * using a custom validation event handler.
   *
   * @param aUtilityStatement
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeUtilityStatement (@Nonnull final UtilityStatementType aUtilityStatement,
                                                @Nullable final ClassLoader aClassLoader,
                                                @Nullable final ValidationEventHandler aCustomEventHandler,
                                                @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aUtilityStatement,
                                             aClassLoader,
                                             EUBL21DocumentType.UTILITY_STATEMENT,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Create a writer builder for Waybill.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBL21WriterBuilder <WaybillType> waybill ()
  {
    return UBL21WriterBuilder.create (WaybillType.class);
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
  @Deprecated
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill)
  {
    return writeWaybill (aWaybill, getGlobalValidationEventHandler ());
  }

  /**
   * Convert the passed {@link WaybillType} to a DOM {@link Document} using the
   * global validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill, @Nullable final ClassLoader aClassLoader)
  {
    return writeWaybill (aWaybill, aClassLoader, getGlobalValidationEventHandler ());
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
  @Deprecated
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aWaybill,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.WAYBILL,
                                             aCustomEventHandler);
  }

  /**
   * Convert the passed {@link WaybillType} to a DOM {@link Document} using a
   * custom validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The created DOM document or <code>null</code> in case of conversion
   *         error
   */
  @Deprecated
  @Nullable
  public static Document writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL21Marshaller.writeUBLDocument (aWaybill, aClassLoader, EUBL21DocumentType.WAYBILL, aCustomEventHandler);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill, @Nonnull final File aResult)
  {
    return writeWaybill (aWaybill, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link WaybillType} to a {@link File} using the global
   * validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nonnull final File aResult)
  {
    return writeWaybill (aWaybill, aClassLoader, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final File aResult)
  {
    return writeWaybill (aWaybill, aCustomEventHandler, new StreamResult (aResult));
  }

  /**
   * Convert the passed {@link WaybillType} to a {@link File} using a custom
   * validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the file to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final File aResult)
  {
    return writeWaybill (aWaybill, aClassLoader, aCustomEventHandler, new StreamResult (aResult));
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
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill, @Nonnull final Result aResult)
  {
    return writeWaybill (aWaybill, getGlobalValidationEventHandler (), aResult);
  }

  /**
   * Convert the passed {@link WaybillType} to a custom {@link Result} using the
   * global validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nonnull final Result aResult)
  {
    return writeWaybill (aWaybill, aClassLoader, getGlobalValidationEventHandler (), aResult);
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
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aWaybill,
                                             (ClassLoader) null,
                                             EUBL21DocumentType.WAYBILL,
                                             aCustomEventHandler,
                                             aResult);
  }

  /**
   * Convert the passed {@link WaybillType} to a custom {@link Result} using a
   * custom validation event handler.
   *
   * @param aWaybill
   *          the source object to convert. May not be <code>null</code>.
   * @param aClassLoader
   *          Optional class loader to be used for JAXBContext. May be
   *          <code>null</code> to indicate to use the default class loader.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @param aResult
   *          the result object to write to. May not be <code>null</code>.
   * @return {@link ESuccess#SUCCESS} in case of success,
   *         {@link ESuccess#FAILURE} in case of an error
   */
  @Deprecated
  @Nonnull
  public static ESuccess writeWaybill (@Nonnull final WaybillType aWaybill,
                                       @Nullable final ClassLoader aClassLoader,
                                       @Nullable final ValidationEventHandler aCustomEventHandler,
                                       @Nonnull final Result aResult)
  {
    return UBL21Marshaller.writeUBLDocument (aWaybill,
                                             aClassLoader,
                                             EUBL21DocumentType.WAYBILL,
                                             aCustomEventHandler,
                                             aResult);
  }
}
