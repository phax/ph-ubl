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
 * Test class for class {@link UBL20DocumentMarshaller}.
 *
 * @author Philip Helger
 */
public final class FuncTestUBL20
{
  @Test
  public void testReadAndWriteCatalogue () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.CATALOGUE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.CATALOGUE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final CatalogueType aUBLObject = UBL20Reader.readCatalogue (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateCatalogue (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeCatalogue (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final CatalogueType aUBLObject2 = UBL20Reader.readCatalogue (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateCatalogue (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateCatalogue (new CatalogueType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteCreditNote () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.CREDIT_NOTE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.CREDIT_NOTE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final CreditNoteType aUBLObject = UBL20Reader.readCreditNote (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateCreditNote (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeCreditNote (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final CreditNoteType aUBLObject2 = UBL20Reader.readCreditNote (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateCreditNote (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateCreditNote (new CreditNoteType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteDespatchAdvice () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.DESPATCH_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.DESPATCH_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final DespatchAdviceType aUBLObject = UBL20Reader.readDespatchAdvice (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateDespatchAdvice (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeDespatchAdvice (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final DespatchAdviceType aUBLObject2 = UBL20Reader.readDespatchAdvice (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateDespatchAdvice (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateDespatchAdvice (new DespatchAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteForwardingInstructions () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.FORWARDING_INSTRUCTIONS))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.FORWARDING_INSTRUCTIONS.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final ForwardingInstructionsType aUBLObject = UBL20Reader.readForwardingInstructions (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateForwardingInstructions (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeForwardingInstructions (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ForwardingInstructionsType aUBLObject2 = UBL20Reader.readForwardingInstructions (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateForwardingInstructions (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateForwardingInstructions (new ForwardingInstructionsType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteInvoice () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.INVOICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.INVOICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final InvoiceType aUBLObject = UBL20Reader.readInvoice (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateInvoice (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeInvoice (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final InvoiceType aUBLObject2 = UBL20Reader.readInvoice (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateInvoice (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateInvoice (new InvoiceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteOrder () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.ORDER))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.ORDER.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final OrderType aUBLObject = UBL20Reader.readOrder (aDoc);
      assertNotNull (sFilename, aUBLObject);
      assertNull (UBL20Reader.readApplicationResponse (aDoc));

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateOrder (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeOrder (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final OrderType aUBLObject2 = UBL20Reader.readOrder (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateOrder (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateOrder (new OrderType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteOrderResponseSimple () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.ORDER_RESPONSE_SIMPLE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.ORDER_RESPONSE_SIMPLE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final OrderResponseSimpleType aUBLObject = UBL20Reader.readOrderResponseSimple (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateOrderResponseSimple (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeOrderResponseSimple (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final OrderResponseSimpleType aUBLObject2 = UBL20Reader.readOrderResponseSimple (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateOrderResponseSimple (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateOrderResponseSimple (new OrderResponseSimpleType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteQuotation () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.QUOTATION))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.QUOTATION.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final QuotationType aUBLObject = UBL20Reader.readQuotation (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateQuotation (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeQuotation (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final QuotationType aUBLObject2 = UBL20Reader.readQuotation (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateQuotation (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateQuotation (new QuotationType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteReceiptAdvice () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.RECEIPT_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.RECEIPT_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final ReceiptAdviceType aUBLObject = UBL20Reader.readReceiptAdvice (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateReceiptAdvice (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeReceiptAdvice (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final ReceiptAdviceType aUBLObject2 = UBL20Reader.readReceiptAdvice (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateReceiptAdvice (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateReceiptAdvice (new ReceiptAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteRemittanceAdvice () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.REMITTANCE_ADVICE))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.REMITTANCE_ADVICE.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final RemittanceAdviceType aUBLObject = UBL20Reader.readRemittanceAdvice (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateRemittanceAdvice (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeRemittanceAdvice (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final RemittanceAdviceType aUBLObject2 = UBL20Reader.readRemittanceAdvice (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateRemittanceAdvice (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateRemittanceAdvice (new RemittanceAdviceType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteRequestForQuotation () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.REQUEST_FOR_QUOTATION))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.REQUEST_FOR_QUOTATION.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final RequestForQuotationType aUBLObject = UBL20Reader.readRequestForQuotation (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateRequestForQuotation (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeRequestForQuotation (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final RequestForQuotationType aUBLObject2 = UBL20Reader.readRequestForQuotation (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateRequestForQuotation (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateRequestForQuotation (new RequestForQuotationType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteStatement () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.STATEMENT))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.STATEMENT.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final StatementType aUBLObject = UBL20Reader.readStatement (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateStatement (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeStatement (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final StatementType aUBLObject2 = UBL20Reader.readStatement (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateStatement (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateStatement (new StatementType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }

  @Test
  public void testReadAndWriteWaybill () throws SAXException
  {
    for (final String sFilename : MockUBLTestDocuments.getUBL20TestDocuments (EUBL20DocumentType.WAYBILL))
    {
      // Read
      final Document aDoc = DOMReader.readXMLDOM (new ClassPathResource (sFilename),
                                                  new DOMReaderSettings ().setSchema (EUBL20DocumentType.WAYBILL.getSchema ()));
      assertNotNull (sFilename, aDoc);
      final WaybillType aUBLObject = UBL20Reader.readWaybill (aDoc);
      assertNotNull (sFilename, aUBLObject);

      // Validate
      IResourceErrorGroup aErrors = UBL20Validator.validateWaybill (aUBLObject);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());

      // write again
      final Document aDoc2 = UBL20Writer.writeWaybill (aUBLObject);
      assertNotNull (aDoc2);
      assertEquals (aDoc.getDocumentElement ().getNamespaceURI (), aDoc2.getDocumentElement ().getNamespaceURI ());
      assertEquals (aDoc.getDocumentElement ().getLocalName (), aDoc2.getDocumentElement ().getLocalName ());

      // read again
      final WaybillType aUBLObject2 = UBL20Reader.readWaybill (aDoc2);
      assertNotNull (sFilename, aUBLObject2);
      PHTestUtils.testDefaultImplementationWithEqualContentObject (aUBLObject, aUBLObject2);

      // Validate
      aErrors = UBL20Validator.validateWaybill (aUBLObject2);
      assertNotNull (sFilename, aErrors);
      assertFalse (sFilename, aErrors.containsAtLeastOneError ());
    }

    // Validate
    final IResourceErrorGroup aErrors = UBL20Validator.validateWaybill (new WaybillType ());
    assertNotNull (aErrors);
    assertTrue (aErrors.containsAtLeastOneError ());
  }
}
