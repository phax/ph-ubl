/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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
package com.helger.ubl23;

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

import oasis.names.specification.ubl.schema.xsd.catalogue_23.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.creditnote_23.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_23.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_23.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_23.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.order_23.OrderType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_23.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.quotation_23.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_23.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_23.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_23.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.statement_23.StatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_23.WaybillType;

/**
 * Some cross functionality testing
 *
 * @author Philip Helger
 */
public final class UBL23FuncTest
{
  @Test
  public void testReadAndWriteCatalogue ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.CATALOGUE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.CATALOGUE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final CatalogueType aUBLObject = UBL23Reader.catalogue ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.catalogue ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.catalogue ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final CatalogueType aUBLObject2 = UBL23Reader.catalogue ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.catalogue ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.catalogue ().validate (new CatalogueType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteCreditNote ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.CREDIT_NOTE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.CREDIT_NOTE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final CreditNoteType aUBLObject = UBL23Reader.creditNote ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.creditNote ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.creditNote ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final CreditNoteType aUBLObject2 = UBL23Reader.creditNote ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.creditNote ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.creditNote ().validate (new CreditNoteType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteDespatchAdvice ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.DESPATCH_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.DESPATCH_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final DespatchAdviceType aUBLObject = UBL23Reader.despatchAdvice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.despatchAdvice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.despatchAdvice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final DespatchAdviceType aUBLObject2 = UBL23Reader.despatchAdvice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.despatchAdvice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.despatchAdvice ().validate (new DespatchAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteForwardingInstructions ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.FORWARDING_INSTRUCTIONS))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.FORWARDING_INSTRUCTIONS.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final ForwardingInstructionsType aUBLObject = UBL23Reader.forwardingInstructions ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.forwardingInstructions ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.forwardingInstructions ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ForwardingInstructionsType aUBLObject2 = UBL23Reader.forwardingInstructions ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.forwardingInstructions ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.forwardingInstructions ().validate (new ForwardingInstructionsType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteInvoices ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.INVOICE))
    {
      if (false)
        System.out.println (sFilename);

      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.INVOICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final InvoiceType aUBLObject = UBL23Reader.invoice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.invoice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.invoice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final InvoiceType aUBLObject2 = UBL23Reader.invoice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.invoice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.invoice ().validate (new InvoiceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteOrders ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.ORDER))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.ORDER.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final OrderType aUBLObject = UBL23Reader.order ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);
      assertNull (UBL23Reader.applicationResponse ().read (aDoc));

      // Validate
      IErrorList aErrors = UBL23Validator.order ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.order ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final OrderType aUBLObject2 = UBL23Reader.order ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.order ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.order ().validate (new OrderType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteOrderResponseSimple ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.ORDER_RESPONSE_SIMPLE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.ORDER_RESPONSE_SIMPLE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final OrderResponseSimpleType aUBLObject = UBL23Reader.orderResponseSimple ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.orderResponseSimple ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.orderResponseSimple ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final OrderResponseSimpleType aUBLObject2 = UBL23Reader.orderResponseSimple ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.orderResponseSimple ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.orderResponseSimple ().validate (new OrderResponseSimpleType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteQuotation ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.QUOTATION))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.QUOTATION.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final QuotationType aUBLObject = UBL23Reader.quotation ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.quotation ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.quotation ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final QuotationType aUBLObject2 = UBL23Reader.quotation ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.quotation ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.quotation ().validate (new QuotationType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteReceiptAdvice ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.RECEIPT_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.RECEIPT_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final ReceiptAdviceType aUBLObject = UBL23Reader.receiptAdvice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.receiptAdvice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.receiptAdvice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ReceiptAdviceType aUBLObject2 = UBL23Reader.receiptAdvice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.receiptAdvice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.receiptAdvice ().validate (new ReceiptAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteRemittanceAdvice ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.REMITTANCE_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.REMITTANCE_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final RemittanceAdviceType aUBLObject = UBL23Reader.remittanceAdvice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.remittanceAdvice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.remittanceAdvice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final RemittanceAdviceType aUBLObject2 = UBL23Reader.remittanceAdvice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.remittanceAdvice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.remittanceAdvice ().validate (new RemittanceAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteRequestForQuotation ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.REQUEST_FOR_QUOTATION))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.REQUEST_FOR_QUOTATION.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final RequestForQuotationType aUBLObject = UBL23Reader.requestForQuotation ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.requestForQuotation ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.requestForQuotation ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final RequestForQuotationType aUBLObject2 = UBL23Reader.requestForQuotation ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.requestForQuotation ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.requestForQuotation ().validate (new RequestForQuotationType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteStatement ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.STATEMENT))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.STATEMENT.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final StatementType aUBLObject = UBL23Reader.statement ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.statement ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.statement ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final StatementType aUBLObject2 = UBL23Reader.statement ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.statement ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.statement ().validate (new StatementType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteWaybill ()
  {
    for (final String sFilename : MockUBL23TestDocuments.getUBL23TestDocuments (EUBL23DocumentType.WAYBILL))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL23DocumentType.WAYBILL.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final WaybillType aUBLObject = UBL23Reader.waybill ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL23Validator.waybill ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL23Writer.waybill ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final WaybillType aUBLObject2 = UBL23Reader.waybill ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      CommonsTestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL23Validator.waybill ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL23Validator.waybill ().validate (new WaybillType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }
}
