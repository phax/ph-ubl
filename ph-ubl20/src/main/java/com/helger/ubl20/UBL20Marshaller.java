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
package com.helger.ubl20;

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
    private final QName m_aRootElementQName;

    public UBL20JAXBMarshaller (@Nonnull final Class <JAXBTYPE> aType,
                                @Nonnull @Nonempty final ICommonsList <ClassPathResource> aXSDs,
                                @Nonnull final QName aRootElementQName)
    {
      super (aType, aXSDs, createSimpleJAXBElement (aRootElementQName, aType));

      m_aRootElementQName = aRootElementQName;

      // Create a special namespace context for the passed document type
      final MapBasedNamespaceContext aNSContext = UBL20NamespaceContext.getInstance ().getClone ();
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
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBaseXSDs ()
  {
    return BASE_XSDS.getClone ();
  }

  @Nonnull
  @ReturnsMutableCopy
  private static ICommonsList <ClassPathResource> _getAllXSDs (@Nonnull final ClassPathResource aXSD)
  {
    final ICommonsList <ClassPathResource> ret = BASE_XSDS.getClone ();
    ret.add (aXSD);
    return ret;
  }

  private UBL20Marshaller ()
  {}

  @Nonnull
  private static ClassPathResource _getCPR (@Nonnull final String sXSDPath)
  {
    return new ClassPathResource (CUBL20.SCHEMA_DIRECTORY + sXSDPath, CUBL20.getCL ());
  }

  // Automatically created from here on

  private static final ClassPathResource CPR_APPLICATIONRESPONSE = _getCPR ("UBL-ApplicationResponse-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllApplicationResponseXSDs ()
  {
    return _getAllXSDs (CPR_APPLICATIONRESPONSE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <ApplicationResponseType> applicationResponse ()
  {
    return new UBL20JAXBMarshaller <> (ApplicationResponseType.class,
                                       getAllApplicationResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ObjectFactory._ApplicationResponse_QNAME);
  }

  private static final ClassPathResource CPR_ATTACHEDDOCUMENT = _getCPR ("UBL-AttachedDocument-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllAttachedDocumentXSDs ()
  {
    return _getAllXSDs (CPR_ATTACHEDDOCUMENT);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <AttachedDocumentType> attachedDocument ()
  {
    return new UBL20JAXBMarshaller <> (AttachedDocumentType.class,
                                       getAllAttachedDocumentXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.attacheddocument_2.ObjectFactory._AttachedDocument_QNAME);
  }

  private static final ClassPathResource CPR_BILLOFLADING = _getCPR ("UBL-BillOfLading-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllBillOfLadingXSDs ()
  {
    return _getAllXSDs (CPR_BILLOFLADING);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <BillOfLadingType> billOfLading ()
  {
    return new UBL20JAXBMarshaller <> (BillOfLadingType.class,
                                       getAllBillOfLadingXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.billoflading_2.ObjectFactory._BillOfLading_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUE = _getCPR ("UBL-Catalogue-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CatalogueType> catalogue ()
  {
    return new UBL20JAXBMarshaller <> (CatalogueType.class,
                                       getAllCatalogueXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogue_2.ObjectFactory._Catalogue_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEDELETION = _getCPR ("UBL-CatalogueDeletion-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueDeletionXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEDELETION);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CatalogueDeletionType> catalogueDeletion ()
  {
    return new UBL20JAXBMarshaller <> (CatalogueDeletionType.class,
                                       getAllCatalogueDeletionXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguedeletion_2.ObjectFactory._CatalogueDeletion_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEITEMSPECIFICATIONUPDATE = _getCPR ("UBL-CatalogueItemSpecificationUpdate-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueItemSpecificationUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEITEMSPECIFICATIONUPDATE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CatalogueItemSpecificationUpdateType> catalogueItemSpecificationUpdate ()
  {
    return new UBL20JAXBMarshaller <> (CatalogueItemSpecificationUpdateType.class,
                                       getAllCatalogueItemSpecificationUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_2.ObjectFactory._CatalogueItemSpecificationUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEPRICINGUPDATE = _getCPR ("UBL-CataloguePricingUpdate-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCataloguePricingUpdateXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEPRICINGUPDATE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CataloguePricingUpdateType> cataloguePricingUpdate ()
  {
    return new UBL20JAXBMarshaller <> (CataloguePricingUpdateType.class,
                                       getAllCataloguePricingUpdateXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_2.ObjectFactory._CataloguePricingUpdate_QNAME);
  }

  private static final ClassPathResource CPR_CATALOGUEREQUEST = _getCPR ("UBL-CatalogueRequest-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCatalogueRequestXSDs ()
  {
    return _getAllXSDs (CPR_CATALOGUEREQUEST);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CatalogueRequestType> catalogueRequest ()
  {
    return new UBL20JAXBMarshaller <> (CatalogueRequestType.class,
                                       getAllCatalogueRequestXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.cataloguerequest_2.ObjectFactory._CatalogueRequest_QNAME);
  }

  private static final ClassPathResource CPR_CERTIFICATEOFORIGIN = _getCPR ("UBL-CertificateOfOrigin-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCertificateOfOriginXSDs ()
  {
    return _getAllXSDs (CPR_CERTIFICATEOFORIGIN);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CertificateOfOriginType> certificateOfOrigin ()
  {
    return new UBL20JAXBMarshaller <> (CertificateOfOriginType.class,
                                       getAllCertificateOfOriginXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.certificateoforigin_2.ObjectFactory._CertificateOfOrigin_QNAME);
  }

  private static final ClassPathResource CPR_CREDITNOTE = _getCPR ("UBL-CreditNote-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_CREDITNOTE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <CreditNoteType> creditNote ()
  {
    return new UBL20JAXBMarshaller <> (CreditNoteType.class,
                                       getAllCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.creditnote_2.ObjectFactory._CreditNote_QNAME);
  }

  private static final ClassPathResource CPR_DEBITNOTE = _getCPR ("UBL-DebitNote-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDebitNoteXSDs ()
  {
    return _getAllXSDs (CPR_DEBITNOTE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <DebitNoteType> debitNote ()
  {
    return new UBL20JAXBMarshaller <> (DebitNoteType.class,
                                       getAllDebitNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.debitnote_2.ObjectFactory._DebitNote_QNAME);
  }

  private static final ClassPathResource CPR_DESPATCHADVICE = _getCPR ("UBL-DespatchAdvice-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllDespatchAdviceXSDs ()
  {
    return _getAllXSDs (CPR_DESPATCHADVICE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <DespatchAdviceType> despatchAdvice ()
  {
    return new UBL20JAXBMarshaller <> (DespatchAdviceType.class,
                                       getAllDespatchAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.despatchadvice_2.ObjectFactory._DespatchAdvice_QNAME);
  }

  private static final ClassPathResource CPR_FORWARDINGINSTRUCTIONS = _getCPR ("UBL-ForwardingInstructions-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllForwardingInstructionsXSDs ()
  {
    return _getAllXSDs (CPR_FORWARDINGINSTRUCTIONS);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <ForwardingInstructionsType> forwardingInstructions ()
  {
    return new UBL20JAXBMarshaller <> (ForwardingInstructionsType.class,
                                       getAllForwardingInstructionsXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.forwardinginstructions_2.ObjectFactory._ForwardingInstructions_QNAME);
  }

  private static final ClassPathResource CPR_FREIGHTINVOICE = _getCPR ("UBL-FreightInvoice-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllFreightInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_FREIGHTINVOICE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <FreightInvoiceType> freightInvoice ()
  {
    return new UBL20JAXBMarshaller <> (FreightInvoiceType.class,
                                       getAllFreightInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.freightinvoice_2.ObjectFactory._FreightInvoice_QNAME);
  }

  private static final ClassPathResource CPR_INVOICE = _getCPR ("UBL-Invoice-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_INVOICE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <InvoiceType> invoice ()
  {
    return new UBL20JAXBMarshaller <> (InvoiceType.class,
                                       getAllInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.invoice_2.ObjectFactory._Invoice_QNAME);
  }

  private static final ClassPathResource CPR_ORDER = _getCPR ("UBL-Order-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderXSDs ()
  {
    return _getAllXSDs (CPR_ORDER);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <OrderType> order ()
  {
    return new UBL20JAXBMarshaller <> (OrderType.class,
                                       getAllOrderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.order_2.ObjectFactory._Order_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCANCELLATION = _getCPR ("UBL-OrderCancellation-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderCancellationXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCANCELLATION);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <OrderCancellationType> orderCancellation ()
  {
    return new UBL20JAXBMarshaller <> (OrderCancellationType.class,
                                       getAllOrderCancellationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.ordercancellation_2.ObjectFactory._OrderCancellation_QNAME);
  }

  private static final ClassPathResource CPR_ORDERCHANGE = _getCPR ("UBL-OrderChange-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderChangeXSDs ()
  {
    return _getAllXSDs (CPR_ORDERCHANGE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <OrderChangeType> orderChange ()
  {
    return new UBL20JAXBMarshaller <> (OrderChangeType.class,
                                       getAllOrderChangeXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderchange_2.ObjectFactory._OrderChange_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSE = _getCPR ("UBL-OrderResponse-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <OrderResponseType> orderResponse ()
  {
    return new UBL20JAXBMarshaller <> (OrderResponseType.class,
                                       getAllOrderResponseXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponse_2.ObjectFactory._OrderResponse_QNAME);
  }

  private static final ClassPathResource CPR_ORDERRESPONSESIMPLE = _getCPR ("UBL-OrderResponseSimple-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllOrderResponseSimpleXSDs ()
  {
    return _getAllXSDs (CPR_ORDERRESPONSESIMPLE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <OrderResponseSimpleType> orderResponseSimple ()
  {
    return new UBL20JAXBMarshaller <> (OrderResponseSimpleType.class,
                                       getAllOrderResponseSimpleXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.orderresponsesimple_2.ObjectFactory._OrderResponseSimple_QNAME);
  }

  private static final ClassPathResource CPR_PACKINGLIST = _getCPR ("UBL-PackingList-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllPackingListXSDs ()
  {
    return _getAllXSDs (CPR_PACKINGLIST);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <PackingListType> packingList ()
  {
    return new UBL20JAXBMarshaller <> (PackingListType.class,
                                       getAllPackingListXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.packinglist_2.ObjectFactory._PackingList_QNAME);
  }

  private static final ClassPathResource CPR_QUOTATION = _getCPR ("UBL-Quotation-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllQuotationXSDs ()
  {
    return _getAllXSDs (CPR_QUOTATION);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <QuotationType> quotation ()
  {
    return new UBL20JAXBMarshaller <> (QuotationType.class,
                                       getAllQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.quotation_2.ObjectFactory._Quotation_QNAME);
  }

  private static final ClassPathResource CPR_RECEIPTADVICE = _getCPR ("UBL-ReceiptAdvice-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReceiptAdviceXSDs ()
  {
    return _getAllXSDs (CPR_RECEIPTADVICE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <ReceiptAdviceType> receiptAdvice ()
  {
    return new UBL20JAXBMarshaller <> (ReceiptAdviceType.class,
                                       getAllReceiptAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.receiptadvice_2.ObjectFactory._ReceiptAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REMINDER = _getCPR ("UBL-Reminder-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllReminderXSDs ()
  {
    return _getAllXSDs (CPR_REMINDER);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <ReminderType> reminder ()
  {
    return new UBL20JAXBMarshaller <> (ReminderType.class,
                                       getAllReminderXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.reminder_2.ObjectFactory._Reminder_QNAME);
  }

  private static final ClassPathResource CPR_REMITTANCEADVICE = _getCPR ("UBL-RemittanceAdvice-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRemittanceAdviceXSDs ()
  {
    return _getAllXSDs (CPR_REMITTANCEADVICE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <RemittanceAdviceType> remittanceAdvice ()
  {
    return new UBL20JAXBMarshaller <> (RemittanceAdviceType.class,
                                       getAllRemittanceAdviceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.remittanceadvice_2.ObjectFactory._RemittanceAdvice_QNAME);
  }

  private static final ClassPathResource CPR_REQUESTFORQUOTATION = _getCPR ("UBL-RequestForQuotation-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllRequestForQuotationXSDs ()
  {
    return _getAllXSDs (CPR_REQUESTFORQUOTATION);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <RequestForQuotationType> requestForQuotation ()
  {
    return new UBL20JAXBMarshaller <> (RequestForQuotationType.class,
                                       getAllRequestForQuotationXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.requestforquotation_2.ObjectFactory._RequestForQuotation_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDCREDITNOTE = _getCPR ("UBL-SelfBilledCreditNote-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledCreditNoteXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDCREDITNOTE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <SelfBilledCreditNoteType> selfBilledCreditNote ()
  {
    return new UBL20JAXBMarshaller <> (SelfBilledCreditNoteType.class,
                                       getAllSelfBilledCreditNoteXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_2.ObjectFactory._SelfBilledCreditNote_QNAME);
  }

  private static final ClassPathResource CPR_SELFBILLEDINVOICE = _getCPR ("UBL-SelfBilledInvoice-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllSelfBilledInvoiceXSDs ()
  {
    return _getAllXSDs (CPR_SELFBILLEDINVOICE);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <SelfBilledInvoiceType> selfBilledInvoice ()
  {
    return new UBL20JAXBMarshaller <> (SelfBilledInvoiceType.class,
                                       getAllSelfBilledInvoiceXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_2.ObjectFactory._SelfBilledInvoice_QNAME);
  }

  private static final ClassPathResource CPR_STATEMENT = _getCPR ("UBL-Statement-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllStatementXSDs ()
  {
    return _getAllXSDs (CPR_STATEMENT);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <StatementType> statement ()
  {
    return new UBL20JAXBMarshaller <> (StatementType.class,
                                       getAllStatementXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.statement_2.ObjectFactory._Statement_QNAME);
  }

  private static final ClassPathResource CPR_TRANSPORTATIONSTATUS = _getCPR ("UBL-TransportationStatus-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllTransportationStatusXSDs ()
  {
    return _getAllXSDs (CPR_TRANSPORTATIONSTATUS);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <TransportationStatusType> transportationStatus ()
  {
    return new UBL20JAXBMarshaller <> (TransportationStatusType.class,
                                       getAllTransportationStatusXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.transportationstatus_2.ObjectFactory._TransportationStatus_QNAME);
  }

  private static final ClassPathResource CPR_WAYBILL = _getCPR ("UBL-Waybill-2.0.xsd");

  @Nonnull
  @ReturnsMutableCopy
  public static ICommonsList <ClassPathResource> getAllWaybillXSDs ()
  {
    return _getAllXSDs (CPR_WAYBILL);
  }

  @Nonnull
  public static UBL20JAXBMarshaller <WaybillType> waybill ()
  {
    return new UBL20JAXBMarshaller <> (WaybillType.class,
                                       getAllWaybillXSDs (),
                                       oasis.names.specification.ubl.schema.xsd.waybill_2.ObjectFactory._Waybill_QNAME);
  }
}
