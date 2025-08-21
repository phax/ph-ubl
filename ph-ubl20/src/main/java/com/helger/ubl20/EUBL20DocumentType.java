/*
 * Copyright (C) 2014-2025 Philip Helger (www.helger.com)
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

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.ReturnsMutableCopy;
import com.helger.base.lang.clazz.ClassHelper;
import com.helger.base.string.StringHelper;
import com.helger.collection.commons.ICommonsList;
import com.helger.io.resource.ClassPathResource;

import jakarta.annotation.Nonnull;

/**
 * Enumeration with all available UBL 2.0 document types.
 *
 * @author Philip Helger
 */
public enum EUBL20DocumentType
{
  APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ApplicationResponseType.class,
                        UBL20Marshaller.getAllApplicationResponseXSDs ()),
  ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_2.AttachedDocumentType.class,
                     UBL20Marshaller.getAllAttachedDocumentXSDs ()),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_2.BillOfLadingType.class,
                  UBL20Marshaller.getAllBillOfLadingXSDs ()),
  CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_2.CatalogueType.class,
             UBL20Marshaller.getAllCatalogueXSDs ()),
  CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_2.CatalogueDeletionType.class,
                      UBL20Marshaller.getAllCatalogueDeletionXSDs ()),
  CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_2.CatalogueItemSpecificationUpdateType.class,
                                       UBL20Marshaller.getAllCatalogueItemSpecificationUpdateXSDs ()),
  CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_2.CataloguePricingUpdateType.class,
                            UBL20Marshaller.getAllCataloguePricingUpdateXSDs ()),
  CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_2.CatalogueRequestType.class,
                     UBL20Marshaller.getAllCatalogueRequestXSDs ()),
  CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_2.CertificateOfOriginType.class,
                         UBL20Marshaller.getAllCertificateOfOriginXSDs ()),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType.class,
               UBL20Marshaller.getAllCreditNoteXSDs ()),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType.class,
              UBL20Marshaller.getAllDebitNoteXSDs ()),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_2.DespatchAdviceType.class,
                   UBL20Marshaller.getAllDespatchAdviceXSDs ()),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_2.ForwardingInstructionsType.class,
                           UBL20Marshaller.getAllForwardingInstructionsXSDs ()),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_2.FreightInvoiceType.class,
                   UBL20Marshaller.getAllFreightInvoiceXSDs ()),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType.class, UBL20Marshaller.getAllInvoiceXSDs ()),
  ORDER (oasis.names.specification.ubl.schema.xsd.order_2.OrderType.class, UBL20Marshaller.getAllOrderXSDs ()),
  ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_2.OrderCancellationType.class,
                      UBL20Marshaller.getAllOrderCancellationXSDs ()),
  ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_2.OrderChangeType.class,
                UBL20Marshaller.getAllOrderChangeXSDs ()),
  ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_2.OrderResponseType.class,
                  UBL20Marshaller.getAllOrderResponseXSDs ()),
  ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_2.OrderResponseSimpleType.class,
                         UBL20Marshaller.getAllOrderResponseSimpleXSDs ()),
  PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_2.PackingListType.class,
                UBL20Marshaller.getAllPackingListXSDs ()),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_2.QuotationType.class,
             UBL20Marshaller.getAllQuotationXSDs ()),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_2.ReceiptAdviceType.class,
                  UBL20Marshaller.getAllReceiptAdviceXSDs ()),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_2.ReminderType.class,
            UBL20Marshaller.getAllReminderXSDs ()),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_2.RemittanceAdviceType.class,
                     UBL20Marshaller.getAllRemittanceAdviceXSDs ()),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_2.RequestForQuotationType.class,
                         UBL20Marshaller.getAllRequestForQuotationXSDs ()),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_2.SelfBilledCreditNoteType.class,
                           UBL20Marshaller.getAllSelfBilledCreditNoteXSDs ()),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_2.SelfBilledInvoiceType.class,
                       UBL20Marshaller.getAllSelfBilledInvoiceXSDs ()),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_2.StatementType.class,
             UBL20Marshaller.getAllStatementXSDs ()),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_2.TransportationStatusType.class,
                         UBL20Marshaller.getAllTransportationStatusXSDs ()),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_2.WaybillType.class, UBL20Marshaller.getAllWaybillXSDs ());

  private final Class <?> m_aImplClass;
  private final ICommonsList <ClassPathResource> m_aXSDs;
  private final String m_sRootElementLocalName;
  private final String m_sRootElementNSURI;

  EUBL20DocumentType (@Nonnull final Class <?> aClass, @Nonnull final ICommonsList <ClassPathResource> aXSDs)
  {
    m_aImplClass = aClass;
    m_aXSDs = aXSDs;
    m_sRootElementLocalName = StringHelper.trimEnd (ClassHelper.getClassLocalName (aClass), "Type");
    m_sRootElementNSURI = aClass.getPackage ().getAnnotation (jakarta.xml.bind.annotation.XmlSchema.class).namespace ();
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aImplClass;
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableCopy
  public ICommonsList <ClassPathResource> getAllXSDResources ()
  {
    return m_aXSDs.getClone ();
  }

  /**
   * @return The local element name of the root element of this document type. E.g.
   *         <code>OrderCancellation</code> for "Order Cancellation".
   */
  @Nonnull
  @Nonempty
  public String getRootElementLocalName ()
  {
    return m_sRootElementLocalName;
  }

  /**
   * @return The XML namespace URI of the root element of this document type. E.g.
   *         <code>urn:oasis:names:specification:ubl:schema:xsd:OrderCancellation-2</code> for
   *         "Order Cancellation".
   */
  @Nonnull
  @Nonempty
  public String getRootElementNamespaceURI ()
  {
    return m_sRootElementNSURI;
  }
}
