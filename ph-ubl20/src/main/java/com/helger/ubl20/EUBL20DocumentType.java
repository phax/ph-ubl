/**
 * Copyright (C) 2014-2017 Philip Helger (www.helger.com)
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
import javax.xml.validation.Schema;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.string.StringHelper;
import com.helger.jaxb.builder.IJAXBDocumentType;
import com.helger.jaxb.builder.JAXBDocumentType;

/**
 * Enumeration with all available UBL 2.0 document types.
 *
 * @author Philip Helger
 */
public enum EUBL20DocumentType implements IJAXBDocumentType
{
  APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ApplicationResponseType.class,
                        "UBL-ApplicationResponse-2.0.xsd"),
  ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_2.AttachedDocumentType.class,
                     "UBL-AttachedDocument-2.0.xsd"),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_2.BillOfLadingType.class,
                  "UBL-BillOfLading-2.0.xsd"),
  CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_2.CatalogueType.class, "UBL-Catalogue-2.0.xsd"),
  CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_2.CatalogueDeletionType.class,
                      "UBL-CatalogueDeletion-2.0.xsd"),
  CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_2.CatalogueItemSpecificationUpdateType.class,
                                       "UBL-CatalogueItemSpecificationUpdate-2.0.xsd"),
  CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_2.CataloguePricingUpdateType.class,
                            "UBL-CataloguePricingUpdate-2.0.xsd"),
  CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_2.CatalogueRequestType.class,
                     "UBL-CatalogueRequest-2.0.xsd"),
  CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_2.CertificateOfOriginType.class,
                         "UBL-CertificateOfOrigin-2.0.xsd"),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType.class, "UBL-CreditNote-2.0.xsd"),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType.class, "UBL-DebitNote-2.0.xsd"),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_2.DespatchAdviceType.class,
                   "UBL-DespatchAdvice-2.0.xsd"),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_2.ForwardingInstructionsType.class,
                           "UBL-ForwardingInstructions-2.0.xsd"),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_2.FreightInvoiceType.class,
                   "UBL-FreightInvoice-2.0.xsd"),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType.class, "UBL-Invoice-2.0.xsd"),
  ORDER (oasis.names.specification.ubl.schema.xsd.order_2.OrderType.class, "UBL-Order-2.0.xsd"),
  ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_2.OrderCancellationType.class,
                      "UBL-OrderCancellation-2.0.xsd"),
  ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_2.OrderChangeType.class,
                "UBL-OrderChange-2.0.xsd"),
  ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_2.OrderResponseType.class,
                  "UBL-OrderResponse-2.0.xsd"),
  ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_2.OrderResponseSimpleType.class,
                         "UBL-OrderResponseSimple-2.0.xsd"),
  PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_2.PackingListType.class,
                "UBL-PackingList-2.0.xsd"),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_2.QuotationType.class, "UBL-Quotation-2.0.xsd"),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_2.ReceiptAdviceType.class,
                  "UBL-ReceiptAdvice-2.0.xsd"),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_2.ReminderType.class, "UBL-Reminder-2.0.xsd"),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_2.RemittanceAdviceType.class,
                     "UBL-RemittanceAdvice-2.0.xsd"),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_2.RequestForQuotationType.class,
                         "UBL-RequestForQuotation-2.0.xsd"),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_2.SelfBilledCreditNoteType.class,
                           "UBL-SelfBilledCreditNote-2.0.xsd"),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_2.SelfBilledInvoiceType.class,
                       "UBL-SelfBilledInvoice-2.0.xsd"),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_2.StatementType.class, "UBL-Statement-2.0.xsd"),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_2.TransportationStatusType.class,
                         "UBL-TransportationStatus-2.0.xsd"),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_2.WaybillType.class, "UBL-Waybill-2.0.xsd");

  private final JAXBDocumentType m_aDocType;

  private EUBL20DocumentType (@Nonnull final Class <?> aClass, @Nonnull final String sXSDPath)
  {
    m_aDocType = new JAXBDocumentType (aClass,
                                       new CommonsArrayList <> (CUBL20.SCHEMA_DIRECTORY + sXSDPath),
                                       s -> StringHelper.trimEnd (s, "Type"));
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aDocType.getImplementationClass ();
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableCopy
  public ICommonsList <String> getAllXSDPaths ()
  {
    return m_aDocType.getAllXSDPaths ();
  }

  @Nonnull
  public String getNamespaceURI ()
  {
    return m_aDocType.getNamespaceURI ();
  }

  @Nonnull
  @Nonempty
  public String getLocalName ()
  {
    return m_aDocType.getLocalName ();
  }

  @Nonnull
  public Schema getSchema (@Nullable final ClassLoader aClassLoader)
  {
    return m_aDocType.getSchema (aClassLoader);
  }
}
