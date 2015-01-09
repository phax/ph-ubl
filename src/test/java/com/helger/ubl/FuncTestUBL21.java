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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import oasis.names.specification.ubl.schema.xsd.catalogue_21.CatalogueType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.despatchadvice_21.DespatchAdviceType;
import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_21.ForwardingInstructionsType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;
import oasis.names.specification.ubl.schema.xsd.order_21.OrderType;
import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_21.OrderResponseSimpleType;
import oasis.names.specification.ubl.schema.xsd.quotation_21.QuotationType;
import oasis.names.specification.ubl.schema.xsd.receiptadvice_21.ReceiptAdviceType;
import oasis.names.specification.ubl.schema.xsd.remittanceadvice_21.RemittanceAdviceType;
import oasis.names.specification.ubl.schema.xsd.requestforquotation_21.RequestForQuotationType;
import oasis.names.specification.ubl.schema.xsd.statement_21.StatementType;
import oasis.names.specification.ubl.schema.xsd.waybill_21.WaybillType;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.helger.commons.error.IResourceErrorGroup;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.mock.PHTestUtils;
import com.helger.commons.xml.serialize.DOMReader;
import com.helger.commons.xml.serialize.DOMReaderSettings;
import com.helger.ubl.mock.MockUBLTestDocuments;

/**
 * Test class for class {@link UBL21DocumentMarshaller}.
 *
 * @author Philip Helger
 */
public final class FuncTestUBL21
{
  @Test
  public void testReadAndWriteCatalogue () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.CATALOGUE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.CATALOGUE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final CatalogueType aUBLObject = UBL21Reader.readCatalogue (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateCatalogue (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeCatalogue (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final CatalogueType aUBLObject2 = UBL21Reader.readCatalogue (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateCatalogue (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateCatalogue (new CatalogueType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteCreditNote () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.CREDIT_NOTE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.CREDIT_NOTE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final CreditNoteType aUBLObject = UBL21Reader.readCreditNote (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateCreditNote (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeCreditNote (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final CreditNoteType aUBLObject2 = UBL21Reader.readCreditNote (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateCreditNote (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateCreditNote (new CreditNoteType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteDespatchAdvice () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.DESPATCH_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.DESPATCH_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final DespatchAdviceType aUBLObject = UBL21Reader.readDespatchAdvice (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateDespatchAdvice (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeDespatchAdvice (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final DespatchAdviceType aUBLObject2 = UBL21Reader.readDespatchAdvice (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateDespatchAdvice (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateDespatchAdvice (new DespatchAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteForwardingInstructions () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.FORWARDING_INSTRUCTIONS))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.FORWARDING_INSTRUCTIONS.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final ForwardingInstructionsType aUBLObject = UBL21Reader.readForwardingInstructions (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateForwardingInstructions (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeForwardingInstructions (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ForwardingInstructionsType aUBLObject2 = UBL21Reader.readForwardingInstructions (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateForwardingInstructions (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateForwardingInstructions (new ForwardingInstructionsType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteInvoices () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.INVOICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.INVOICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final InvoiceType aUBLObject = UBL21Reader.readInvoice (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateInvoice (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeInvoice (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final InvoiceType aUBLObject2 = UBL21Reader.readInvoice (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateInvoice (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateInvoice (new InvoiceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteOrders () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.ORDER))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.ORDER.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final OrderType aUBLObject = UBL21Reader.readOrder (aDoc);
      assertNotNull (sFilename, aUBLObject);
      assertNull (UBL21Reader.readApplicationResponse (aDoc));

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateOrder (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeOrder (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final OrderType aUBLObject2 = UBL21Reader.readOrder (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateOrder (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateOrder (new OrderType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteOrderResponseSimple () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.ORDER_RESPONSE_SIMPLE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.ORDER_RESPONSE_SIMPLE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final OrderResponseSimpleType aUBLObject = UBL21Reader.readOrderResponseSimple (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateOrderResponseSimple (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeOrderResponseSimple (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final OrderResponseSimpleType aUBLObject2 = UBL21Reader.readOrderResponseSimple (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateOrderResponseSimple (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateOrderResponseSimple (new OrderResponseSimpleType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteQuotation () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.QUOTATION))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.QUOTATION.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final QuotationType aUBLObject = UBL21Reader.readQuotation (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateQuotation (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeQuotation (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final QuotationType aUBLObject2 = UBL21Reader.readQuotation (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateQuotation (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateQuotation (new QuotationType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteReceiptAdvice () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.RECEIPT_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.RECEIPT_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final ReceiptAdviceType aUBLObject = UBL21Reader.readReceiptAdvice (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateReceiptAdvice (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeReceiptAdvice (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ReceiptAdviceType aUBLObject2 = UBL21Reader.readReceiptAdvice (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateReceiptAdvice (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateReceiptAdvice (new ReceiptAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteRemittanceAdvice () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.REMITTANCE_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.REMITTANCE_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final RemittanceAdviceType aUBLObject = UBL21Reader.readRemittanceAdvice (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateRemittanceAdvice (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeRemittanceAdvice (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final RemittanceAdviceType aUBLObject2 = UBL21Reader.readRemittanceAdvice (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateRemittanceAdvice (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateRemittanceAdvice (new RemittanceAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteRequestForQuotation () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.REQUEST_FOR_QUOTATION))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.REQUEST_FOR_QUOTATION.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final RequestForQuotationType aUBLObject = UBL21Reader.readRequestForQuotation (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateRequestForQuotation (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeRequestForQuotation (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final RequestForQuotationType aUBLObject2 = UBL21Reader.readRequestForQuotation (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateRequestForQuotation (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateRequestForQuotation (new RequestForQuotationType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteStatement () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.STATEMENT))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.STATEMENT.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final StatementType aUBLObject = UBL21Reader.readStatement (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateStatement (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeStatement (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final StatementType aUBLObject2 = UBL21Reader.readStatement (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateStatement (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateStatement (new StatementType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteWaybill () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL21TestDocuments (EUBL21DocumentType.WAYBILL))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL21DocumentType.WAYBILL.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final WaybillType aUBLObject = UBL21Reader.readWaybill (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL21Validator.validateWaybill (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL21Writer.writeWaybill (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final WaybillType aUBLObject2 = UBL21Reader.readWaybill (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL21Validator.validateWaybill (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL21Validator.validateWaybill (new WaybillType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }
}
