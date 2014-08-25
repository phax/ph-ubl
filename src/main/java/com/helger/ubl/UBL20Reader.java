package com.helger.ubl;

import java.io.File;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.transform.Source;

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

import org.w3c.dom.Node;

import com.helger.commons.annotations.PresentForCodeCoverage;
import com.helger.commons.io.IReadableResource;
import com.helger.commons.xml.transform.TransformSourceFactory;

/**
 * Read all UBL 2.0 document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
 public final class UBL20Reader extends AbstractUBLDocumentMarshaller
 {
   @PresentForCodeCoverage
   @SuppressWarnings ("unused")
   private static final UBL20Reader s_aInstance = new UBL20Reader ();

   private UBL20Reader ()
  {}

  /**
   * Interpret the passed DOM {@link Node} as a ApplicationResponse using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Node aNode)
  {
    return readApplicationResponse (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ApplicationResponse using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Node aNode,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, ApplicationResponseType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ApplicationResponse using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final File aSource)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ApplicationResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final File aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ApplicationResponse
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final IReadableResource aSource)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ApplicationResponse
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final IReadableResource aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readApplicationResponse (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ApplicationResponse using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Source aSource)
  {
    return readApplicationResponse (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ApplicationResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ApplicationResponseType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static ApplicationResponseType readApplicationResponse (@Nonnull final Source aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, ApplicationResponseType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a AttachedDocument using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Node aNode)
  {
    return readAttachedDocument (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a AttachedDocument using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Node aNode,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, AttachedDocumentType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a AttachedDocument using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final File aSource)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a AttachedDocument using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final File aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a AttachedDocument using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final IReadableResource aSource)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a AttachedDocument using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final IReadableResource aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readAttachedDocument (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a AttachedDocument using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Source aSource)
  {
    return readAttachedDocument (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a AttachedDocument using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated AttachedDocumentType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static AttachedDocumentType readAttachedDocument (@Nonnull final Source aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, AttachedDocumentType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a BillOfLading using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Node aNode)
  {
    return readBillOfLading (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a BillOfLading using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Node aNode,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, BillOfLadingType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a BillOfLading using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final File aSource)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a BillOfLading using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final File aSource,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a BillOfLading using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final IReadableResource aSource)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a BillOfLading using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final IReadableResource aSource,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readBillOfLading (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a BillOfLading using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Source aSource)
  {
    return readBillOfLading (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a BillOfLading using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated BillOfLadingType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static BillOfLadingType readBillOfLading (@Nonnull final Source aSource,
                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, BillOfLadingType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Catalogue using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Node aNode)
  {
    return readCatalogue (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Catalogue using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Node aNode,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CatalogueType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Catalogue using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final File aSource)
  {
    return readCatalogue (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Catalogue using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final File aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogue (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Catalogue using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final IReadableResource aSource)
  {
    return readCatalogue (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Catalogue using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final IReadableResource aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogue (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Catalogue using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Source aSource)
  {
    return readCatalogue (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Catalogue using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CatalogueType readCatalogue (@Nonnull final Source aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CatalogueType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueDeletion using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Node aNode)
  {
    return readCatalogueDeletion (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueDeletion using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Node aNode,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CatalogueDeletionType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueDeletion using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final File aSource)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CatalogueDeletion using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final File aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueDeletion using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final IReadableResource aSource)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueDeletion using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final IReadableResource aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueDeletion (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueDeletion using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Source aSource)
  {
    return readCatalogueDeletion (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueDeletion using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueDeletionType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueDeletionType readCatalogueDeletion (@Nonnull final Source aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CatalogueDeletionType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueItemSpecificationUpdate
   * using the global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Node aNode)
  {
    return readCatalogueItemSpecificationUpdate (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueItemSpecificationUpdate
   * using a custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Node aNode,
                                                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CatalogueItemSpecificationUpdateType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueItemSpecificationUpdate
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final File aSource)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CatalogueItemSpecificationUpdate
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final File aSource,
                                                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * CatalogueItemSpecificationUpdate using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final IReadableResource aSource)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a
   * CatalogueItemSpecificationUpdate using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final IReadableResource aSource,
                                                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueItemSpecificationUpdate (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueItemSpecificationUpdate
   * using the global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Source aSource)
  {
    return readCatalogueItemSpecificationUpdate (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueItemSpecificationUpdate
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueItemSpecificationUpdateType or
   *         <code>null</code> in case of a parsing error
   */
  @Nullable
  public static CatalogueItemSpecificationUpdateType readCatalogueItemSpecificationUpdate (@Nonnull final Source aSource,
                                                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CatalogueItemSpecificationUpdateType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CataloguePricingUpdate using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Node aNode)
  {
    return readCataloguePricingUpdate (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CataloguePricingUpdate using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Node aNode,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CataloguePricingUpdateType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CataloguePricingUpdate using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final File aSource)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CataloguePricingUpdate using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final File aSource,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CataloguePricingUpdate
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final IReadableResource aSource)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CataloguePricingUpdate
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final IReadableResource aSource,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCataloguePricingUpdate (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CataloguePricingUpdate using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Source aSource)
  {
    return readCataloguePricingUpdate (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CataloguePricingUpdate using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CataloguePricingUpdateType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static CataloguePricingUpdateType readCataloguePricingUpdate (@Nonnull final Source aSource,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CataloguePricingUpdateType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueRequest using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Node aNode)
  {
    return readCatalogueRequest (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CatalogueRequest using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Node aNode,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CatalogueRequestType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CatalogueRequest using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final File aSource)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CatalogueRequest using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final File aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueRequest using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final IReadableResource aSource)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CatalogueRequest using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final IReadableResource aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCatalogueRequest (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueRequest using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Source aSource)
  {
    return readCatalogueRequest (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CatalogueRequest using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CatalogueRequestType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static CatalogueRequestType readCatalogueRequest (@Nonnull final Source aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CatalogueRequestType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CertificateOfOrigin using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Node aNode)
  {
    return readCertificateOfOrigin (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CertificateOfOrigin using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Node aNode,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CertificateOfOriginType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CertificateOfOrigin using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final File aSource)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CertificateOfOrigin using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final File aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CertificateOfOrigin
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final IReadableResource aSource)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CertificateOfOrigin
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final IReadableResource aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCertificateOfOrigin (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CertificateOfOrigin using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Source aSource)
  {
    return readCertificateOfOrigin (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CertificateOfOrigin using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CertificateOfOriginType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static CertificateOfOriginType readCertificateOfOrigin (@Nonnull final Source aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CertificateOfOriginType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a CreditNote using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Node aNode)
  {
    return readCreditNote (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a CreditNote using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Node aNode,
                                               @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, CreditNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a CreditNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final File aSource)
  {
    return readCreditNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a CreditNote using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final File aSource,
                                               @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCreditNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CreditNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final IReadableResource aSource)
  {
    return readCreditNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a CreditNote using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final IReadableResource aSource,
                                               @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readCreditNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a CreditNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Source aSource)
  {
    return readCreditNote (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a CreditNote using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated CreditNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static CreditNoteType readCreditNote (@Nonnull final Source aSource,
                                               @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, CreditNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a DebitNote using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Node aNode)
  {
    return readDebitNote (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a DebitNote using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Node aNode,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, DebitNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a DebitNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final File aSource)
  {
    return readDebitNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a DebitNote using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final File aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readDebitNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DebitNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final IReadableResource aSource)
  {
    return readDebitNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DebitNote using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final IReadableResource aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readDebitNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a DebitNote using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Source aSource)
  {
    return readDebitNote (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a DebitNote using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DebitNoteType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DebitNoteType readDebitNote (@Nonnull final Source aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, DebitNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a DespatchAdvice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Node aNode)
  {
    return readDespatchAdvice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a DespatchAdvice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Node aNode,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, DespatchAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a DespatchAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final File aSource)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a DespatchAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final File aSource,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DespatchAdvice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final IReadableResource aSource)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a DespatchAdvice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final IReadableResource aSource,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readDespatchAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a DespatchAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Source aSource)
  {
    return readDespatchAdvice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a DespatchAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated DespatchAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static DespatchAdviceType readDespatchAdvice (@Nonnull final Source aSource,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, DespatchAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ForwardingInstructions using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Node aNode)
  {
    return readForwardingInstructions (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ForwardingInstructions using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Node aNode,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, ForwardingInstructionsType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ForwardingInstructions using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final File aSource)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ForwardingInstructions using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final File aSource,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ForwardingInstructions
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final IReadableResource aSource)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ForwardingInstructions
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final IReadableResource aSource,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readForwardingInstructions (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ForwardingInstructions using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Source aSource)
  {
    return readForwardingInstructions (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ForwardingInstructions using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ForwardingInstructionsType or <code>null</code> in
   *         case of a parsing error
   */
  @Nullable
  public static ForwardingInstructionsType readForwardingInstructions (@Nonnull final Source aSource,
                                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, ForwardingInstructionsType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a FreightInvoice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Node aNode)
  {
    return readFreightInvoice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a FreightInvoice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Node aNode,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, FreightInvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a FreightInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final File aSource)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a FreightInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final File aSource,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a FreightInvoice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final IReadableResource aSource)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a FreightInvoice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final IReadableResource aSource,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readFreightInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a FreightInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Source aSource)
  {
    return readFreightInvoice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a FreightInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated FreightInvoiceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static FreightInvoiceType readFreightInvoice (@Nonnull final Source aSource,
                                                       @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, FreightInvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Invoice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Node aNode)
  {
    return readInvoice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Invoice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Node aNode,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, InvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Invoice using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final File aSource)
  {
    return readInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Invoice using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final File aSource,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Invoice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final IReadableResource aSource)
  {
    return readInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Invoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final IReadableResource aSource,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Invoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Source aSource)
  {
    return readInvoice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Invoice using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated InvoiceType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static InvoiceType readInvoice (@Nonnull final Source aSource,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, InvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Order using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static OrderType readOrder (@Nonnull final Node aNode)
  {
    return readOrder (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Order using a custom validation
   * event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static OrderType readOrder (@Nonnull final Node aNode,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, OrderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Order using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static OrderType readOrder (@Nonnull final File aSource)
  {
    return readOrder (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Order using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static OrderType readOrder (@Nonnull final File aSource,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readOrder (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Order using the global
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static OrderType readOrder (@Nonnull final IReadableResource aSource)
  {
    return readOrder (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Order using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static OrderType readOrder (@Nonnull final IReadableResource aSource,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readOrder (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Order using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static OrderType readOrder (@Nonnull final Source aSource)
  {
    return readOrder (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Order using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static OrderType readOrder (@Nonnull final Source aSource,
                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, OrderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderCancellation using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Node aNode)
  {
    return readOrderCancellation (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderCancellation using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Node aNode,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, OrderCancellationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderCancellation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final File aSource)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a OrderCancellation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final File aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderCancellation using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final IReadableResource aSource)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderCancellation using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final IReadableResource aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readOrderCancellation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderCancellation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Source aSource)
  {
    return readOrderCancellation (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderCancellation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderCancellationType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static OrderCancellationType readOrderCancellation (@Nonnull final Source aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, OrderCancellationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderChange using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Node aNode)
  {
    return readOrderChange (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderChange using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Node aNode,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, OrderChangeType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderChange using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final File aSource)
  {
    return readOrderChange (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a OrderChange using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final File aSource,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readOrderChange (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderChange using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final IReadableResource aSource)
  {
    return readOrderChange (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderChange using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final IReadableResource aSource,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readOrderChange (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderChange using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Source aSource)
  {
    return readOrderChange (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderChange using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderChangeType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderChangeType readOrderChange (@Nonnull final Source aSource,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, OrderChangeType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponse using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Node aNode)
  {
    return readOrderResponse (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponse using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Node aNode,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, OrderResponseType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderResponse using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final File aSource)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a OrderResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final File aSource,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponse using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final IReadableResource aSource)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponse using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final IReadableResource aSource,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponse (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponse using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Source aSource)
  {
    return readOrderResponse (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponse using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static OrderResponseType readOrderResponse (@Nonnull final Source aSource,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, OrderResponseType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponseSimple using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Node aNode)
  {
    return readOrderResponseSimple (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a OrderResponseSimple using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Node aNode,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, OrderResponseSimpleType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a OrderResponseSimple using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final File aSource)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a OrderResponseSimple using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final File aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponseSimple
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final IReadableResource aSource)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a OrderResponseSimple
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final IReadableResource aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readOrderResponseSimple (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponseSimple using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Source aSource)
  {
    return readOrderResponseSimple (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a OrderResponseSimple using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated OrderResponseSimpleType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static OrderResponseSimpleType readOrderResponseSimple (@Nonnull final Source aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, OrderResponseSimpleType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a PackingList using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Node aNode)
  {
    return readPackingList (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a PackingList using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Node aNode,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, PackingListType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a PackingList using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static PackingListType readPackingList (@Nonnull final File aSource)
  {
    return readPackingList (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a PackingList using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static PackingListType readPackingList (@Nonnull final File aSource,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readPackingList (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a PackingList using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static PackingListType readPackingList (@Nonnull final IReadableResource aSource)
  {
    return readPackingList (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a PackingList using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static PackingListType readPackingList (@Nonnull final IReadableResource aSource,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readPackingList (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a PackingList using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Source aSource)
  {
    return readPackingList (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a PackingList using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated PackingListType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static PackingListType readPackingList (@Nonnull final Source aSource,
                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, PackingListType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Quotation using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Node aNode)
  {
    return readQuotation (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Quotation using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Node aNode,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, QuotationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Quotation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static QuotationType readQuotation (@Nonnull final File aSource)
  {
    return readQuotation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Quotation using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static QuotationType readQuotation (@Nonnull final File aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readQuotation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Quotation using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static QuotationType readQuotation (@Nonnull final IReadableResource aSource)
  {
    return readQuotation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Quotation using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static QuotationType readQuotation (@Nonnull final IReadableResource aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readQuotation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Quotation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Source aSource)
  {
    return readQuotation (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Quotation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated QuotationType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static QuotationType readQuotation (@Nonnull final Source aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, QuotationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a ReceiptAdvice using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Node aNode)
  {
    return readReceiptAdvice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a ReceiptAdvice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Node aNode,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, ReceiptAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a ReceiptAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final File aSource)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a ReceiptAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final File aSource,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ReceiptAdvice using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final IReadableResource aSource)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a ReceiptAdvice using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final IReadableResource aSource,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readReceiptAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a ReceiptAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Source aSource)
  {
    return readReceiptAdvice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a ReceiptAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReceiptAdviceType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReceiptAdviceType readReceiptAdvice (@Nonnull final Source aSource,
                                                     @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, ReceiptAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Reminder using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReminderType readReminder (@Nonnull final Node aNode)
  {
    return readReminder (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Reminder using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReminderType readReminder (@Nonnull final Node aNode,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, ReminderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Reminder using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReminderType readReminder (@Nonnull final File aSource)
  {
    return readReminder (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Reminder using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReminderType readReminder (@Nonnull final File aSource,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readReminder (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Reminder using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReminderType readReminder (@Nonnull final IReadableResource aSource)
  {
    return readReminder (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Reminder using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReminderType readReminder (@Nonnull final IReadableResource aSource,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readReminder (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Reminder using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReminderType readReminder (@Nonnull final Source aSource)
  {
    return readReminder (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Reminder using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated ReminderType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static ReminderType readReminder (@Nonnull final Source aSource,
                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, ReminderType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a RemittanceAdvice using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Node aNode)
  {
    return readRemittanceAdvice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a RemittanceAdvice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Node aNode,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, RemittanceAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a RemittanceAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final File aSource)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a RemittanceAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final File aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RemittanceAdvice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final IReadableResource aSource)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RemittanceAdvice using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final IReadableResource aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readRemittanceAdvice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a RemittanceAdvice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Source aSource)
  {
    return readRemittanceAdvice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a RemittanceAdvice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RemittanceAdviceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static RemittanceAdviceType readRemittanceAdvice (@Nonnull final Source aSource,
                                                           @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, RemittanceAdviceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a RequestForQuotation using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Node aNode)
  {
    return readRequestForQuotation (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a RequestForQuotation using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Node aNode,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, RequestForQuotationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a RequestForQuotation using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final File aSource)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a RequestForQuotation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final File aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RequestForQuotation
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final IReadableResource aSource)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a RequestForQuotation
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final IReadableResource aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readRequestForQuotation (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a RequestForQuotation using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Source aSource)
  {
    return readRequestForQuotation (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a RequestForQuotation using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated RequestForQuotationType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static RequestForQuotationType readRequestForQuotation (@Nonnull final Source aSource,
                                                                 @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, RequestForQuotationType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledCreditNote using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Node aNode)
  {
    return readSelfBilledCreditNote (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledCreditNote using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Node aNode,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, SelfBilledCreditNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledCreditNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final File aSource)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledCreditNote using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final File aSource,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledCreditNote
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final IReadableResource aSource)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledCreditNote
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final IReadableResource aSource,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledCreditNote (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledCreditNote using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Source aSource)
  {
    return readSelfBilledCreditNote (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledCreditNote using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledCreditNoteType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static SelfBilledCreditNoteType readSelfBilledCreditNote (@Nonnull final Source aSource,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, SelfBilledCreditNoteType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledInvoice using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Node aNode)
  {
    return readSelfBilledInvoice (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a SelfBilledInvoice using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Node aNode,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, SelfBilledInvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final File aSource)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a SelfBilledInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final File aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledInvoice using
   * the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final IReadableResource aSource)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a SelfBilledInvoice using
   * a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final IReadableResource aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readSelfBilledInvoice (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledInvoice using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Source aSource)
  {
    return readSelfBilledInvoice (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a SelfBilledInvoice using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated SelfBilledInvoiceType or <code>null</code> in case of
   *         a parsing error
   */
  @Nullable
  public static SelfBilledInvoiceType readSelfBilledInvoice (@Nonnull final Source aSource,
                                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, SelfBilledInvoiceType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Statement using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static StatementType readStatement (@Nonnull final Node aNode)
  {
    return readStatement (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Statement using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static StatementType readStatement (@Nonnull final Node aNode,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, StatementType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Statement using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static StatementType readStatement (@Nonnull final File aSource)
  {
    return readStatement (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Statement using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static StatementType readStatement (@Nonnull final File aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readStatement (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Statement using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static StatementType readStatement (@Nonnull final IReadableResource aSource)
  {
    return readStatement (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Statement using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static StatementType readStatement (@Nonnull final IReadableResource aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readStatement (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Statement using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static StatementType readStatement (@Nonnull final Source aSource)
  {
    return readStatement (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Statement using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated StatementType or <code>null</code> in case of a
   *         parsing error
   */
  @Nullable
  public static StatementType readStatement (@Nonnull final Source aSource,
                                             @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, StatementType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportationStatus using the
   * global validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Node aNode)
  {
    return readTransportationStatus (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a TransportationStatus using a
   * custom validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Node aNode,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, TransportationStatusType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a TransportationStatus using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final File aSource)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a TransportationStatus using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final File aSource,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportationStatus
   * using the global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final IReadableResource aSource)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a TransportationStatus
   * using a custom validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final IReadableResource aSource,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readTransportationStatus (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a TransportationStatus using the
   * global validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Source aSource)
  {
    return readTransportationStatus (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a TransportationStatus using a
   * custom validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated TransportationStatusType or <code>null</code> in case
   *         of a parsing error
   */
  @Nullable
  public static TransportationStatusType readTransportationStatus (@Nonnull final Source aSource,
                                                                   @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, TransportationStatusType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed DOM {@link Node} as a Waybill using the global
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Node aNode)
  {
    return readWaybill (aNode, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed DOM {@link Node} as a Waybill using a custom
   * validation event handler.
   * 
   * @param aNode
   *          the DOM node. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Node aNode,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aNode, WaybillType.class, aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link File} as a Waybill using the global validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static WaybillType readWaybill (@Nonnull final File aSource)
  {
    return readWaybill (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link File} as a Waybill using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source file to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static WaybillType readWaybill (@Nonnull final File aSource,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readWaybill (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Waybill using the
   * global validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static WaybillType readWaybill (@Nonnull final IReadableResource aSource)
  {
    return readWaybill (TransformSourceFactory.create (aSource));
  }

  /**
   * Interpret the passed {@link IReadableResource} as a Waybill using a custom
   * validation event handler.
   * 
   * @param aSource
   *          the resource to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static WaybillType readWaybill (@Nonnull final IReadableResource aSource,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return readWaybill (TransformSourceFactory.create (aSource), aCustomEventHandler);
  }

  /**
   * Interpret the passed {@link Source} as a Waybill using the global
   * validation event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Source aSource)
  {
    return readWaybill (aSource, getGlobalValidationEventHandler ());
  }

  /**
   * Interpret the passed {@link Source} as a Waybill using a custom validation
   * event handler.
   * 
   * @param aSource
   *          the source to read from. May not be <code>null</code>.
   * @param aCustomEventHandler
   *          The custom event handler to use. May be <code>null</code>.
   * @return The evaluated WaybillType or <code>null</code> in case of a parsing
   *         error
   */
  @Nullable
  public static WaybillType readWaybill (@Nonnull final Source aSource,
                                         @Nullable final ValidationEventHandler aCustomEventHandler)
  {
    return UBL20Marshaller.readUBLDocument (aSource, WaybillType.class, aCustomEventHandler);
  }
 }
