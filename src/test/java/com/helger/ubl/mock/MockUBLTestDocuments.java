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
package com.helger.ubl.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotations.ReturnsMutableCopy;
import com.helger.commons.lang.CGStringHelper;
import com.helger.commons.string.StringHelper;
import com.helger.ubl.EUBL20DocumentType;
import com.helger.ubl.EUBL21DocumentType;
import com.helger.ubl.IUBLDocumentType;

@Immutable
public final class MockUBLTestDocuments
{
  private static final String [] UBL20_CATALOGUE_FILES = new String [] { "Consip_Catalogo_UBL.xml",
                                                                        "Mobile_Catalogue_UBL.xml" };

  private static final String [] UBL20_CREDITNOTE_FILES = new String [] { "BII04 XML example full core data 01.xml",
                                                                         "UBL-CreditNote-2.0-Example.xml" };

  private static final String [] UBL20_DESPATCHADVICE_FILES = new String [] { "UBL-DespatchAdvice-2.0-Example.xml" };

  private static final String [] UBL20_FORWARDINGINSTRUCTIONS_FILES = new String [] { "UBL-ForwardingInstructions-2.0-Example-International.xml" };

  private static final String [] UBL20_INVOICE_FILES = new String [] { "BII04 minimal invoice example 02.xml",
                                                                      "BII04 minimal VAT invoice example 01.xml",
                                                                      "BII04 XML example full core data 01.xml",
                                                                      "CENBII-Invoice-maximal.xml",
                                                                      "ERR-10 BII04 minimal VAT invoice example 01.xml",
                                                                      "ERR-11 BII04 minimal invoice example 01.xml",
                                                                      "ERR-13 BII04 minimal invoice example 01.xml",
                                                                      "ERR-18 BII04 minimal invoice example 01.xml",
                                                                      "ERR-19 BII04 minimal invoice example 01.xml",
                                                                      "ERR-2 BII04 minimal invoice example 01.xml",
                                                                      "ERR-3 BII04 minimal VAT invoice example 01.xml",
                                                                      "ERR-4 BII04 minimal invoice example 01.xml",
                                                                      "ERR-5 BII04 minimal VAT invoice example 01.xml",
                                                                      "ERR-9 BII04 minimal VAT invoice example 01.xml",
                                                                      "PEP BII04 minimal invoice example 02.xml",
                                                                      "PEP BII04 minimal VAT invoice example 01.xml",
                                                                      "UBL-Invoice-2.0-Example.xml" };

  private static final String [] UBL20_ORDER_FILES = new String [] { "BII03 Order example 01.xml",
                                                                    "CENBII-Order-maximal.xml",
                                                                    "CENBII-Order-minimal.xml",
                                                                    "UBL-Order-2.0-Example-International.xml",
                                                                    "UBL-Order-2.0-Example.xml" };

  private static final String [] UBL20_ORDER_RESPONSE_SIMPLE_FILES = new String [] { "CENBII-AcceptOrder-maximal.xml",
                                                                                    "CENBII-AcceptOrder-minimal.xml",
                                                                                    "CENBII-RejectOrder-maximal.xml",
                                                                                    "CENBII-RejectOrder-minimal.xml",
                                                                                    "UBL-OrderResponseSimple-2.0-Example.xml" };

  private static final String [] UBL20_QUOTATION_FILES = new String [] { "UBL-Quotation-2.0-Example.xml" };
  private static final String [] UBL20_RECEIPTADVICE_FILES = new String [] { "UBL-ReceiptAdvice-2.0-Example.xml" };
  private static final String [] UBL20_REMITTANCEADVICE_FILES = new String [] { "UBL-RemittanceAdvice-2.0-Example.xml" };
  private static final String [] UBL20_REQUESTFORQUOTATION_FILES = new String [] { "UBL-RequestForQuotation-2.0-Example.xml" };
  private static final String [] UBL20_STATEMENT_FILES = new String [] { "UBL-Statement-2.0-Example.xml" };
  private static final String [] UBL20_WAYBILL_FILES = new String [] { "UBL-Waybill-2.0-Example-International.xml" };

  private MockUBLTestDocuments ()
  {}

  private static String _getTestFileBaseDirName (final IUBLDocumentType aDocType)
  {
    return "examples/" +
           StringHelper.trimEnd (CGStringHelper.getClassLocalName (aDocType.getImplementationClass ()), "Type")
                       .toLowerCase (Locale.US) + "/";
  }

  @Nonnull
  @ReturnsMutableCopy
  public static List <String> getUBL20TestDocuments (@Nonnull final EUBL20DocumentType eType)
  {
    final String sBaseDir = _getTestFileBaseDirName (eType);
    String [] aFiles = new String [0];
    switch (eType)
    {
      case CATALOGUE:
        aFiles = UBL20_CATALOGUE_FILES;
        break;
      case CREDIT_NOTE:
        aFiles = UBL20_CREDITNOTE_FILES;
        break;
      case DESPATCH_ADVICE:
        aFiles = UBL20_DESPATCHADVICE_FILES;
        break;
      case FORWARDING_INSTRUCTIONS:
        aFiles = UBL20_FORWARDINGINSTRUCTIONS_FILES;
        break;
      case INVOICE:
        aFiles = UBL20_INVOICE_FILES;
        break;
      case ORDER:
        aFiles = UBL20_ORDER_FILES;
        break;
      case ORDER_RESPONSE_SIMPLE:
        aFiles = UBL20_ORDER_RESPONSE_SIMPLE_FILES;
        break;
      case QUOTATION:
        aFiles = UBL20_QUOTATION_FILES;
        break;
      case RECEIPT_ADVICE:
        aFiles = UBL20_RECEIPTADVICE_FILES;
        break;
      case REQUEST_FOR_QUOTATION:
        aFiles = UBL20_REQUESTFORQUOTATION_FILES;
        break;
      case REMITTANCE_ADVICE:
        aFiles = UBL20_REMITTANCEADVICE_FILES;
        break;
      case STATEMENT:
        aFiles = UBL20_STATEMENT_FILES;
        break;
      case WAYBILL:
        aFiles = UBL20_WAYBILL_FILES;
        break;
      default:
        throw new IllegalArgumentException ("No test files available for type " + eType);
    }

    final List <String> ret = new ArrayList <String> (aFiles.length);
    for (final String sFile : aFiles)
      ret.add (sBaseDir + sFile);
    return ret;
  }

  @Nonnull
  @ReturnsMutableCopy
  public static List <String> getUBL21TestDocuments (@Nonnull final EUBL21DocumentType eType)
  {
    final String sBaseDir = _getTestFileBaseDirName (eType);
    String [] aFiles = new String [0];
    switch (eType)
    {
      case CATALOGUE:
        aFiles = UBL20_CATALOGUE_FILES;
        break;
      case CREDIT_NOTE:
        aFiles = UBL20_CREDITNOTE_FILES;
        break;
      case DESPATCH_ADVICE:
        aFiles = UBL20_DESPATCHADVICE_FILES;
        break;
      case FORWARDING_INSTRUCTIONS:
        aFiles = UBL20_FORWARDINGINSTRUCTIONS_FILES;
        break;
      case INVOICE:
        aFiles = UBL20_INVOICE_FILES;
        break;
      case ORDER:
        aFiles = UBL20_ORDER_FILES;
        break;
      case ORDER_RESPONSE_SIMPLE:
        aFiles = UBL20_ORDER_RESPONSE_SIMPLE_FILES;
        break;
      case QUOTATION:
        aFiles = UBL20_QUOTATION_FILES;
        break;
      case RECEIPT_ADVICE:
        aFiles = UBL20_RECEIPTADVICE_FILES;
        break;
      case REQUEST_FOR_QUOTATION:
        aFiles = UBL20_REQUESTFORQUOTATION_FILES;
        break;
      case REMITTANCE_ADVICE:
        aFiles = UBL20_REMITTANCEADVICE_FILES;
        break;
      case STATEMENT:
        aFiles = UBL20_STATEMENT_FILES;
        break;
      case WAYBILL:
        aFiles = UBL20_WAYBILL_FILES;
        break;
      default:
        throw new IllegalArgumentException ("No test files available for type " + eType);
    }

    final List <String> ret = new ArrayList <String> (aFiles.length);
    for (final String sFile : aFiles)
      ret.add (sBaseDir + sFile);
    return ret;
  }
}
