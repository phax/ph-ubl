/*
 * Copyright (C) 2026 Philip Helger (www.helger.com)
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
package com.helger.ubl25;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.w3c.dom.Document;

import com.helger.diagnostics.error.list.IErrorList;
import com.helger.io.resource.ClassPathResource;
import com.helger.unittest.support.TestHelper;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;

import oasis.names.specification.ubl.schema.xsd.catalogue_25.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.creditnote_25.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_25.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_25.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_25.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.order_25.OrderType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_25.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.quotation_25.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_25.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_25.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_25.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.statement_25.StatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_25.WaybillType;

/**
 * Some cross functionality testing
 *
 * @author Philip Helger
 */
public final class UBL25FuncTest
{
  @Test
  public void testReadAndWriteCatalogue ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.CATALOGUE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.catalogue ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final CatalogueType aUBLObject = UBL25Marshaller.catalogue ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.catalogue ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.catalogue ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final CatalogueType aUBLObject2 = UBL25Marshaller.catalogue ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.catalogue ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.catalogue ().validate (new CatalogueType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteCreditNote ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.CREDIT_NOTE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.creditNote ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final CreditNoteType aUBLObject = UBL25Marshaller.creditNote ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.creditNote ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.creditNote ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final CreditNoteType aUBLObject2 = UBL25Marshaller.creditNote ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.creditNote ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.creditNote ().validate (new CreditNoteType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteDespatchAdvice ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.DESPATCH_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.despatchAdvice ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final DespatchAdviceType aUBLObject = UBL25Marshaller.despatchAdvice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.despatchAdvice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.despatchAdvice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final DespatchAdviceType aUBLObject2 = UBL25Marshaller.despatchAdvice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.despatchAdvice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.despatchAdvice ().validate (new DespatchAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteForwardingInstructions ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.FORWARDING_INSTRUCTIONS))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.forwardingInstructions ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final ForwardingInstructionsType aUBLObject = UBL25Marshaller.forwardingInstructions ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.forwardingInstructions ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.forwardingInstructions ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ForwardingInstructionsType aUBLObject2 = UBL25Marshaller.forwardingInstructions ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.forwardingInstructions ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.forwardingInstructions ().validate (new ForwardingInstructionsType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteInvoices ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.INVOICE))
    {
      if (false)
        System.out.println (sFilename);

      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.invoice ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final InvoiceType aUBLObject = UBL25Marshaller.invoice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.invoice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.invoice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final InvoiceType aUBLObject2 = UBL25Marshaller.invoice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.invoice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.invoice ().validate (new InvoiceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteOrders ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.ORDER))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.order ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final OrderType aUBLObject = UBL25Marshaller.order ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);
      assertNull (UBL25Marshaller.applicationResponse ().read (aDoc));

      // Validate
      IErrorList aErrors = UBL25Marshaller.order ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.order ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final OrderType aUBLObject2 = UBL25Marshaller.order ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.order ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.order ().validate (new OrderType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteOrderResponseSimple ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.ORDER_RESPONSE_SIMPLE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.orderResponseSimple ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final OrderResponseSimpleType aUBLObject = UBL25Marshaller.orderResponseSimple ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.orderResponseSimple ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.orderResponseSimple ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final OrderResponseSimpleType aUBLObject2 = UBL25Marshaller.orderResponseSimple ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.orderResponseSimple ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.orderResponseSimple ().validate (new OrderResponseSimpleType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteQuotation ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.QUOTATION))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.quotation ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final QuotationType aUBLObject = UBL25Marshaller.quotation ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.quotation ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.quotation ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final QuotationType aUBLObject2 = UBL25Marshaller.quotation ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.quotation ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.quotation ().validate (new QuotationType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteReceiptAdvice ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.RECEIPT_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.receiptAdvice ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final ReceiptAdviceType aUBLObject = UBL25Marshaller.receiptAdvice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.receiptAdvice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.receiptAdvice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ReceiptAdviceType aUBLObject2 = UBL25Marshaller.receiptAdvice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.receiptAdvice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.receiptAdvice ().validate (new ReceiptAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteRemittanceAdvice ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.REMITTANCE_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.remittanceAdvice ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final RemittanceAdviceType aUBLObject = UBL25Marshaller.remittanceAdvice ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.remittanceAdvice ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.remittanceAdvice ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final RemittanceAdviceType aUBLObject2 = UBL25Marshaller.remittanceAdvice ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.remittanceAdvice ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.remittanceAdvice ().validate (new RemittanceAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteRequestForQuotation ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.REQUEST_FOR_QUOTATION))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.requestForQuotation ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final RequestForQuotationType aUBLObject = UBL25Marshaller.requestForQuotation ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.requestForQuotation ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.requestForQuotation ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final RequestForQuotationType aUBLObject2 = UBL25Marshaller.requestForQuotation ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.requestForQuotation ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.requestForQuotation ().validate (new RequestForQuotationType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteStatement ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.STATEMENT))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.statement ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final StatementType aUBLObject = UBL25Marshaller.statement ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.statement ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.statement ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final StatementType aUBLObject2 = UBL25Marshaller.statement ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.statement ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.statement ().validate (new StatementType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteWaybill ()
  {
    for (final String sFilename : MockUBL25TestDocuments.getUBL25TestDocuments (EUBL25DocumentType.WAYBILL))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (UBL25Marshaller.waybill ()
                                                                                                     .getSchema ()));
      assertNotNull (sFilename, aDoc);
      final WaybillType aUBLObject = UBL25Marshaller.waybill ().read (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IErrorList aErrors = UBL25Marshaller.waybill ().validate (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL25Marshaller.waybill ().getAsDocument (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final WaybillType aUBLObject2 = UBL25Marshaller.waybill ().read (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);
      TestHelper.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject.clone ());

      // Validate
      aErrors = UBL25Marshaller.waybill ().validate (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IErrorList aErrors = UBL25Marshaller.waybill ().validate (new WaybillType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }
}
