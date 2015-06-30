/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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
package com.helger.ubl;

import javax.annotation.Nonnull;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.error.IResourceErrorGroup;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.io.resource.IReadableResource;
import com.helger.commons.lang.ClassHelper;
import com.helger.commons.string.StringHelper;
import com.helger.commons.xml.schema.XMLSchemaCache;
import com.helger.commons.xml.schema.XMLSchemaValidationHelper;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Enumeration with all available UBL 2.0 document types.
 *
 * @author Philip Helger
 */
public enum EUBL20DocumentType implements IUBLDocumentType
{
  APPLICATION_RESPONSE (oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ApplicationResponseType.class, "UBL-ApplicationResponse-2.0.xsd"),
  ATTACHED_DOCUMENT (oasis.names.specification.ubl.schema.xsd.attacheddocument_2.AttachedDocumentType.class, "UBL-AttachedDocument-2.0.xsd"),
  BILL_OF_LADING (oasis.names.specification.ubl.schema.xsd.billoflading_2.BillOfLadingType.class, "UBL-BillOfLading-2.0.xsd"),
  CATALOGUE (oasis.names.specification.ubl.schema.xsd.catalogue_2.CatalogueType.class, "UBL-Catalogue-2.0.xsd"),
  CATALOGUE_DELETION (oasis.names.specification.ubl.schema.xsd.cataloguedeletion_2.CatalogueDeletionType.class, "UBL-CatalogueDeletion-2.0.xsd"),
  CATALOGUE_ITEM_SPECIFICATION_UPDATE (oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_2.CatalogueItemSpecificationUpdateType.class, "UBL-CatalogueItemSpecificationUpdate-2.0.xsd"),
  CATALOGUE_PRICING_UPDATE (oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_2.CataloguePricingUpdateType.class, "UBL-CataloguePricingUpdate-2.0.xsd"),
  CATALOGUE_REQUEST (oasis.names.specification.ubl.schema.xsd.cataloguerequest_2.CatalogueRequestType.class, "UBL-CatalogueRequest-2.0.xsd"),
  CERTIFICATE_OF_ORIGIN (oasis.names.specification.ubl.schema.xsd.certificateoforigin_2.CertificateOfOriginType.class, "UBL-CertificateOfOrigin-2.0.xsd"),
  CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType.class, "UBL-CreditNote-2.0.xsd"),
  DEBIT_NOTE (oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType.class, "UBL-DebitNote-2.0.xsd"),
  DESPATCH_ADVICE (oasis.names.specification.ubl.schema.xsd.despatchadvice_2.DespatchAdviceType.class, "UBL-DespatchAdvice-2.0.xsd"),
  FORWARDING_INSTRUCTIONS (oasis.names.specification.ubl.schema.xsd.forwardinginstructions_2.ForwardingInstructionsType.class, "UBL-ForwardingInstructions-2.0.xsd"),
  FREIGHT_INVOICE (oasis.names.specification.ubl.schema.xsd.freightinvoice_2.FreightInvoiceType.class, "UBL-FreightInvoice-2.0.xsd"),
  INVOICE (oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType.class, "UBL-Invoice-2.0.xsd"),
  ORDER (oasis.names.specification.ubl.schema.xsd.order_2.OrderType.class, "UBL-Order-2.0.xsd"),
  ORDER_CANCELLATION (oasis.names.specification.ubl.schema.xsd.ordercancellation_2.OrderCancellationType.class, "UBL-OrderCancellation-2.0.xsd"),
  ORDER_CHANGE (oasis.names.specification.ubl.schema.xsd.orderchange_2.OrderChangeType.class, "UBL-OrderChange-2.0.xsd"),
  ORDER_RESPONSE (oasis.names.specification.ubl.schema.xsd.orderresponse_2.OrderResponseType.class, "UBL-OrderResponse-2.0.xsd"),
  ORDER_RESPONSE_SIMPLE (oasis.names.specification.ubl.schema.xsd.orderresponsesimple_2.OrderResponseSimpleType.class, "UBL-OrderResponseSimple-2.0.xsd"),
  PACKING_LIST (oasis.names.specification.ubl.schema.xsd.packinglist_2.PackingListType.class, "UBL-PackingList-2.0.xsd"),
  QUOTATION (oasis.names.specification.ubl.schema.xsd.quotation_2.QuotationType.class, "UBL-Quotation-2.0.xsd"),
  RECEIPT_ADVICE (oasis.names.specification.ubl.schema.xsd.receiptadvice_2.ReceiptAdviceType.class, "UBL-ReceiptAdvice-2.0.xsd"),
  REMINDER (oasis.names.specification.ubl.schema.xsd.reminder_2.ReminderType.class, "UBL-Reminder-2.0.xsd"),
  REMITTANCE_ADVICE (oasis.names.specification.ubl.schema.xsd.remittanceadvice_2.RemittanceAdviceType.class, "UBL-RemittanceAdvice-2.0.xsd"),
  REQUEST_FOR_QUOTATION (oasis.names.specification.ubl.schema.xsd.requestforquotation_2.RequestForQuotationType.class, "UBL-RequestForQuotation-2.0.xsd"),
  SELF_BILLED_CREDIT_NOTE (oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_2.SelfBilledCreditNoteType.class, "UBL-SelfBilledCreditNote-2.0.xsd"),
  SELF_BILLED_INVOICE (oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_2.SelfBilledInvoiceType.class, "UBL-SelfBilledInvoice-2.0.xsd"),
  STATEMENT (oasis.names.specification.ubl.schema.xsd.statement_2.StatementType.class, "UBL-Statement-2.0.xsd"),
  TRANSPORTATION_STATUS (oasis.names.specification.ubl.schema.xsd.transportationstatus_2.TransportationStatusType.class, "UBL-TransportationStatus-2.0.xsd"),
  WAYBILL (oasis.names.specification.ubl.schema.xsd.waybill_2.WaybillType.class, "UBL-Waybill-2.0.xsd");

  private final Class <?> m_aClass;
  private final String m_sLocalName;
  private final String m_sNamespaceURI;
  private final QName m_aQName;
  private final String m_sXSDPath;
  @CodingStyleguideUnaware
  private Schema m_aSchema;

  private EUBL20DocumentType (@Nonnull final Class <?> aClass, @Nonnull final String sXSDPath)
  {
    ValueEnforcer.notNull (aClass, "Class");
    ValueEnforcer.notEmpty (sXSDPath, "XSDPath");

    // Check whether it is an @XmlType class
    final XmlType aXmlType = aClass.getAnnotation (XmlType.class);
    if (aXmlType == null)
      throw new IllegalArgumentException ("The passed class does not have an @XMLType annotation!");

    // Get the package of the passed Class
    final Package aPackage = aClass.getPackage ();

    // The package must have the annotation "XmlSchema" with the corresponding
    // namespace it supports
    final XmlSchema aXmlSchema = aPackage.getAnnotation (XmlSchema.class);
    if (aXmlSchema == null)
      throw new IllegalArgumentException ("The package '" + aPackage.getName () + "' has no @XmlSchema annotation!");

    // Hack: build the element name from the type, excluding the "Type" at the
    // end
    String sLocalName = ClassHelper.getClassLocalName (aClass);
    sLocalName = sLocalName.substring (0, sLocalName.length () - "Type".length ());

    m_aClass = aClass;
    m_sLocalName = sLocalName;
    m_sNamespaceURI = aXmlSchema.namespace ();
    if (StringHelper.hasNoText (m_sNamespaceURI))
      throw new IllegalArgumentException ("The package '" +
                                          aPackage.getName () +
                                          "' has no namespace in the @XmlSchema annotation!");
    m_aQName = new QName (m_sNamespaceURI, sLocalName);
    m_sXSDPath = CUBL20.SCHEMA_DIRECTORY + sXSDPath;
  }

  @Nonnull
  public Class <?> getImplementationClass ()
  {
    return m_aClass;
  }

  @Nonnull
  public Package getPackage ()
  {
    return m_aClass.getPackage ();
  }

  @Nonnull
  public String getLocalName ()
  {
    return m_sLocalName;
  }

  @Nonnull
  public String getNamespaceURI ()
  {
    return m_sNamespaceURI;
  }

  @Nonnull
  public QName getQName ()
  {
    return m_aQName;
  }

  @Nonnull
  public String getXSDPath ()
  {
    return m_sXSDPath;
  }

  @Nonnull
  public IReadableResource getXSDResource ()
  {
    return new ClassPathResource (m_sXSDPath);
  }

  @Nonnull
  @SuppressFBWarnings ("RCN_REDUNDANT_NULLCHECK_OF_NONNULL_VALUE")
  public Schema getSchema ()
  {
    if (m_aSchema == null)
    {
      // Lazy initialization
      final IReadableResource aXSDRes = getXSDResource ();
      m_aSchema = XMLSchemaCache.getInstance ().getSchema (aXSDRes);
      if (m_aSchema == null)
        throw new IllegalStateException ("Failed to create Schema from " + aXSDRes);
    }
    return m_aSchema;
  }

  @Nonnull
  public Validator getValidator ()
  {
    return getSchema ().newValidator ();
  }

  @Nonnull
  public IResourceErrorGroup validateXML (@Nonnull final IReadableResource aXML)
  {
    return XMLSchemaValidationHelper.validate (getSchema (), aXML);
  }
}
