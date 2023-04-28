/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
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
package com.helger.ubl20;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.xml.namespace.MapBasedNamespaceContext;

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
 * The class provides all the UBL 2.0 marshallers for reading, writing and
 * validation.
 *
 * @author Philip Helger
 * @since 8.0.0
 */
public final class UBL20Marshaller
{
  public static class UBL20JAXBMarshaller <JAXBTYPE> extends GenericJAXBMarshaller <JAXBTYPE>
  {
    private static final ICommonsList <ClassPathResource> BASE_XSDS = new CommonsArrayList <> (CUBL20.XSD_CODELIST_CURRENCY_CODE,
                                                                                               CUBL20.XSD_CODELIST_LANGUAGE_CODE,
                                                                                               CUBL20.XSD_CODELIST_MIME_MEDIA_TYPE_CODE,
                                                                                               CUBL20.XSD_CODELIST_UNIT_CODE,
                                                                                               CUBL20.XSD_UNQUALIFIED_DATA_TYPES,
                                                                                               CUBL20.XSD_QUALIFIED_DATA_TYPES,
                                                                                               CUBL20.XSD_COMMON_BASIC_COMPONENTS,
                                                                                               CUBL20.XSD_COMMON_EXTENSION_COMPONENTS,
                                                                                               CUBL20.XSD_COMMON_AGGREGATE_COMPONENTS);

    @Nonnull
    public static ICommonsList <ClassPathResource> getAllXSDs (@Nonnull final ClassPathResource aXSD)
    {
      final ICommonsList <ClassPathResource> ret = BASE_XSDS.getClone ();
      ret.add (aXSD);
      return ret;
    }

    public UBL20JAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nonnull final ClassPathResource aXSD,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, getAllXSDs (aXSD), createSimpleJAXBElement (aRootElementQName, aType));

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBL20NamespaceContext.getInstance ().getClone ();
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

  private UBL20Marshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CUBL20.SCHEMA_DIRECTORY + sXSDPath, CUBL20.getCL ());
  }

  @Nonnull
  public static UBL20JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new UBL20JAXBMarshaller <> (ApplicationResponseType.class,
                                       _getCPR ("UBL-ApplicationResponse-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ObjectFactory._ApplicationResponse_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new UBL20JAXBMarshaller <> (AttachedDocumentType.class,
                                       _getCPR ("UBL-AttachedDocument-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.attacheddocument_2.ObjectFactory._AttachedDocument_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <BillOfLadingType> billOfLading ()
  {
    return new UBL20JAXBMarshaller <> (BillOfLadingType.class,
                                       _getCPR ("UBL-BillOfLading-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.billoflading_2.ObjectFactory._BillOfLading_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CatalogueType> catalogue ()
  {
    return new UBL20JAXBMarshaller <> (CatalogueType.class,
                                       _getCPR ("UBL-Catalogue-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.catalogue_2.ObjectFactory._Catalogue_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CatalogueDeletionType> catalogueDeletion ()
  {
    return new UBL20JAXBMarshaller <> (CatalogueDeletionType.class,
                                       _getCPR ("UBL-CatalogueDeletion-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguedeletion_2.ObjectFactory._CatalogueDeletion_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return new UBL20JAXBMarshaller <> (CatalogueItemSpecificationUpdateType.class,
                                       _getCPR ("UBL-CatalogueItemSpecificationUpdate-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_2.ObjectFactory._CatalogueItemSpecificationUpdate_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return new UBL20JAXBMarshaller <> (CataloguePricingUpdateType.class,
                                       _getCPR ("UBL-CataloguePricingUpdate-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_2.ObjectFactory._CataloguePricingUpdate_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CatalogueRequestType> catalogueRequest ()
  {
    return new UBL20JAXBMarshaller <> (CatalogueRequestType.class,
                                       _getCPR ("UBL-CatalogueRequest-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.cataloguerequest_2.ObjectFactory._CatalogueRequest_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CertificateOfOriginType> certificateOfOrigin ()
  {
    return new UBL20JAXBMarshaller <> (CertificateOfOriginType.class,
                                       _getCPR ("UBL-CertificateOfOrigin-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.certificateoforigin_2.ObjectFactory._CertificateOfOrigin_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new UBL20JAXBMarshaller <> (CreditNoteType.class,
                                       _getCPR ("UBL-CreditNote-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory._CreditNote_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new UBL20JAXBMarshaller <> (DebitNoteType.class,
                                       _getCPR ("UBL-DebitNote-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.debitnote_2.ObjectFactory._DebitNote_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <DespatchAdviceType> despatchAdvice ()
  {
    return new UBL20JAXBMarshaller <> (DespatchAdviceType.class,
                                       _getCPR ("UBL-DespatchAdvice-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.despatchadvice_2.ObjectFactory._DespatchAdvice_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <ForwardingInstructionsType> forwardingInstructions ()
  {
    return new UBL20JAXBMarshaller <> (ForwardingInstructionsType.class,
                                       _getCPR ("UBL-ForwardingInstructions-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.forwardinginstructions_2.ObjectFactory._ForwardingInstructions_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <FreightInvoiceType> freightInvoice ()
  {
    return new UBL20JAXBMarshaller <> (FreightInvoiceType.class,
                                       _getCPR ("UBL-FreightInvoice-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.freightinvoice_2.ObjectFactory._FreightInvoice_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <InvoiceType> invoice ()
  {
    return new UBL20JAXBMarshaller <> (InvoiceType.class,
                                       _getCPR ("UBL-Invoice-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory._Invoice_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <OrderType> order ()
  {
    return new UBL20JAXBMarshaller <> (OrderType.class,
                                       _getCPR ("UBL-Order-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.order_2.ObjectFactory._Order_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <OrderCancellationType> orderCancellation ()
  {
    return new UBL20JAXBMarshaller <> (OrderCancellationType.class,
                                       _getCPR ("UBL-OrderCancellation-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.ordercancellation_2.ObjectFactory._OrderCancellation_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <OrderChangeType> orderChange ()
  {
    return new UBL20JAXBMarshaller <> (OrderChangeType.class,
                                       _getCPR ("UBL-OrderChange-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderchange_2.ObjectFactory._OrderChange_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <OrderResponseType> orderResponse ()
  {
    return new UBL20JAXBMarshaller <> (OrderResponseType.class,
                                       _getCPR ("UBL-OrderResponse-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderresponse_2.ObjectFactory._OrderResponse_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <OrderResponseSimpleType> orderResponseSimple ()
  {
    return new UBL20JAXBMarshaller <> (OrderResponseSimpleType.class,
                                       _getCPR ("UBL-OrderResponseSimple-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.orderresponsesimple_2.ObjectFactory._OrderResponseSimple_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <PackingListType> packingList ()
  {
    return new UBL20JAXBMarshaller <> (PackingListType.class,
                                       _getCPR ("UBL-PackingList-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.packinglist_2.ObjectFactory._PackingList_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <QuotationType> quotation ()
  {
    return new UBL20JAXBMarshaller <> (QuotationType.class,
                                       _getCPR ("UBL-Quotation-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.quotation_2.ObjectFactory._Quotation_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <ReceiptAdviceType> receiptAdvice ()
  {
    return new UBL20JAXBMarshaller <> (ReceiptAdviceType.class,
                                       _getCPR ("UBL-ReceiptAdvice-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.receiptadvice_2.ObjectFactory._ReceiptAdvice_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <ReminderType> reminder ()
  {
    return new UBL20JAXBMarshaller <> (ReminderType.class,
                                       _getCPR ("UBL-Reminder-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.reminder_2.ObjectFactory._Reminder_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <RemittanceAdviceType> remittanceAdvice ()
  {
    return new UBL20JAXBMarshaller <> (RemittanceAdviceType.class,
                                       _getCPR ("UBL-RemittanceAdvice-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.remittanceadvice_2.ObjectFactory._RemittanceAdvice_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <RequestForQuotationType> requestForQuotation ()
  {
    return new UBL20JAXBMarshaller <> (RequestForQuotationType.class,
                                       _getCPR ("UBL-RequestForQuotation-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.requestforquotation_2.ObjectFactory._RequestForQuotation_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return new UBL20JAXBMarshaller <> (SelfBilledCreditNoteType.class,
                                       _getCPR ("UBL-SelfBilledCreditNote-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_2.ObjectFactory._SelfBilledCreditNote_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return new UBL20JAXBMarshaller <> (SelfBilledInvoiceType.class,
                                       _getCPR ("UBL-SelfBilledInvoice-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_2.ObjectFactory._SelfBilledInvoice_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <StatementType> statement ()
  {
    return new UBL20JAXBMarshaller <> (StatementType.class,
                                       _getCPR ("UBL-Statement-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.statement_2.ObjectFactory._Statement_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <TransportationStatusType> transportationStatus ()
  {
    return new UBL20JAXBMarshaller <> (TransportationStatusType.class,
                                       _getCPR ("UBL-TransportationStatus-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatus_2.ObjectFactory._TransportationStatus_QNAME);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <WaybillType> waybill ()
  {
    return new UBL20JAXBMarshaller <> (WaybillType.class,
                                       _getCPR ("UBL-Waybill-2.0.xsd"),
                                       oasis.names.specification.ubl.schema.xsd.waybill_2.ObjectFactory._Waybill_QNAME);
  }
}
