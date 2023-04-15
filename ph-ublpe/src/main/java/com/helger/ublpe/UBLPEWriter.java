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
 * Write all UBLPE document types.
 *
 * @author Philip Helger
 * @deprecated Use {@link UBLPEMarshaller} instead
 */
@NotThreadSafe
@Deprecated (forRemoval = true, since = "8.0.0")
public final class UBLPEWriter
{
  @PresentForCodeCoverage
  private static final UBLPEWriter INSTANCE = new UBLPEWriter ();

  private UBLPEWriter ()
  {}

  /**
   * Create a writer builder for ApplicationResponseType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEWriterBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBLPEWriterBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a writer builder for CreditNoteType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEWriterBuilder <CreditNoteType> creditNote ()
  {
    return UBLPEWriterBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a writer builder for DebitNoteType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEWriterBuilder <DebitNoteType> debitNote ()
  {
    return UBLPEWriterBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a writer builder for InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEWriterBuilder <InvoiceType> invoice ()
  {
    return UBLPEWriterBuilder.create (InvoiceType.class);
  }

  /**
   * Create a writer builder for SummaryDocumentsType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEWriterBuilder <SummaryDocumentsType> summaryDocuments ()
  {
    return UBLPEWriterBuilder.create (SummaryDocumentsType.class);
  }

  /**
   * Create a writer builder for VoidedDocumentsType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEWriterBuilder <VoidedDocumentsType> voidedDocuments ()
  {
    return UBLPEWriterBuilder.create (VoidedDocumentsType.class);
  }
}
