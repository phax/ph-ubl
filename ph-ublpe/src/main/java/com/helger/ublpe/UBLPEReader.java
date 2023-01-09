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
package com.helger.ublpe;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;

import oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;
import sunat.names.specification.ubl.peru.schema.xsd.summarydocuments_1.SummaryDocumentsType;
import sunat.names.specification.ubl.peru.schema.xsd.voideddocuments_1.VoidedDocumentsType;

/**
 * Read all UBLPE document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBLPEReader
{
  @PresentForCodeCoverage
  private static final UBLPEReader INSTANCE = new UBLPEReader ();

  private UBLPEReader ()
  {}

  /**
   * Create a reader builder for ApplicationResponseType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEReaderBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBLPEReaderBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a reader builder for CreditNoteType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEReaderBuilder <CreditNoteType> creditNote ()
  {
    return UBLPEReaderBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a reader builder for DebitNoteType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEReaderBuilder <DebitNoteType> debitNote ()
  {
    return UBLPEReaderBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a reader builder for InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEReaderBuilder <InvoiceType> invoice ()
  {
    return UBLPEReaderBuilder.create (InvoiceType.class);
  }

  /**
   * Create a reader builder for SummaryDocumentsType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEReaderBuilder <SummaryDocumentsType> summaryDocuments ()
  {
    return UBLPEReaderBuilder.create (SummaryDocumentsType.class);
  }

  /**
   * Create a reader builder for VoidedDocumentsType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEReaderBuilder <VoidedDocumentsType> voidedDocuments ()
  {
    return UBLPEReaderBuilder.create (VoidedDocumentsType.class);
  }
}
