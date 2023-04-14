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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Document;

import com.helger.commons.error.list.IErrorList;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;

import oasis.names.specification.ubl.schema.xsd.catalogue_2.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_2.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_2.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.order_2.OrderType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_2.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.quotation_2.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_2.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_2.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_2.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.statement_2.StatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_2.WaybillType;

/**
 * Some cross functionality testing
 *
 * @author Philip Helger
 */
public final class UBL20FuncTest
{
  @Test
  public void testReadAndWriteCatalogue ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.CATALOGUE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.CATALOGUE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final CatalogueType aUBLObject = UBL20Marshaller.catalogue ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.catalogue ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.catalogue ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final CatalogueType aUBLObject2 = UBL20Marshaller.catalogue ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.catalogue ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.catalogue ().validate (new CatalogueType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteCreditNote ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.CREDIT_NOTE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.CREDIT_NOTE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final CreditNoteType aUBLObject = UBL20Marshaller.creditNote ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.creditNote ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.creditNote ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final CreditNoteType aUBLObject2 = UBL20Marshaller.creditNote ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.creditNote ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.creditNote ().validate (new CreditNoteType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteDespatchAdvice ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.DESPATCH_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.DESPATCH_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final DespatchAdviceType aUBLObject = UBL20Marshaller.despatchAdvice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.despatchAdvice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.despatchAdvice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final DespatchAdviceType aUBLObject2 = UBL20Marshaller.despatchAdvice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.despatchAdvice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.despatchAdvice ().validate (new DespatchAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteForwardingInstructions ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.FORWARDING_INSTRUCTIONS))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.FORWARDING_INSTRUCTIONS.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final ForwardingInstructionsType aUBLObject = UBL20Marshaller.forwardingInstructions ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.forwardingInstructions ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.forwardingInstructions ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ForwardingInstructionsType aUBLObject2 = UBL20Marshaller.forwardingInstructions ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.forwardingInstructions ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.forwardingInstructions ().validate (new ForwardingInstructionsType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteInvoice ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.INVOICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.INVOICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final InvoiceType aUBLObject = UBL20Marshaller.invoice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.invoice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename + ": " + aErrors.toString (), aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.invoice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final InvoiceType aUBLObject2 = UBL20Marshaller.invoice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.invoice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.invoice ().validate (new InvoiceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteOrder ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.ORDER))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.ORDER.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final OrderType aUBLObject = UBL20Marshaller.order ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);
      assertNull (UBL20Marshaller.applicationResponse ().read (aDoc));

      // Validate
      IErrorList aErrors = UBL20Marshaller.order ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.order ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final OrderType aUBLObject2 = UBL20Marshaller.order ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.order ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.order ().validate (new OrderType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteOrderResponseSimple ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.ORDER_RESPONSE_SIMPLE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.ORDER_RESPONSE_SIMPLE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final OrderResponseSimpleType aUBLObject = UBL20Marshaller.orderResponseSimple ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.orderResponseSimple ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.orderResponseSimple ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final OrderResponseSimpleType aUBLObject2 = UBL20Marshaller.orderResponseSimple ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.orderResponseSimple ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.orderResponseSimple ().validate (new OrderResponseSimpleType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteQuotation ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.QUOTATION))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.QUOTATION.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final QuotationType aUBLObject = UBL20Marshaller.quotation ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.quotation ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.quotation ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final QuotationType aUBLObject2 = UBL20Marshaller.quotation ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.quotation ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.quotation ().validate (new QuotationType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteReceiptAdvice ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.RECEIPT_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.RECEIPT_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final ReceiptAdviceType aUBLObject = UBL20Marshaller.receiptAdvice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.receiptAdvice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.receiptAdvice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ReceiptAdviceType aUBLObject2 = UBL20Marshaller.receiptAdvice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.receiptAdvice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.receiptAdvice ().validate (new ReceiptAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteRemittanceAdvice ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.REMITTANCE_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.REMITTANCE_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final RemittanceAdviceType aUBLObject = UBL20Marshaller.remittanceAdvice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.remittanceAdvice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.remittanceAdvice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final RemittanceAdviceType aUBLObject2 = UBL20Marshaller.remittanceAdvice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.remittanceAdvice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.remittanceAdvice ().validate (new RemittanceAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteRequestForQuotation ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.REQUEST_FOR_QUOTATION))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.REQUEST_FOR_QUOTATION.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final RequestForQuotationType aUBLObject = UBL20Marshaller.requestForQuotation ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.requestForQuotation ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.requestForQuotation ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final RequestForQuotationType aUBLObject2 = UBL20Marshaller.requestForQuotation ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.requestForQuotation ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.requestForQuotation ().validate (new RequestForQuotationType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteStatement ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.STATEMENT))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.STATEMENT.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final StatementType aUBLObject = UBL20Marshaller.statement ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.statement ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.statement ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final StatementType aUBLObject2 = UBL20Marshaller.statement ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.statement ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.statement ().validate (new StatementType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteWaybill ()
  {
    for (final String sFilename : MockUBL20TestDocuments.getUBL20TestDocuments (EUBL20DocumentTypeSimple.WAYBILL))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentTypeSimple.WAYBILL.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final WaybillType aUBLObject = UBL20Marshaller.waybill ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL20Marshaller.waybill ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Marshaller.waybill ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final WaybillType aUBLObject2 = UBL20Marshaller.waybill ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL20Marshaller.waybill ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL20Marshaller.waybill ().validate (new WaybillType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }
}
