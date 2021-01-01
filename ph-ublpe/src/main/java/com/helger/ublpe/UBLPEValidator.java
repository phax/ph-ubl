/**
 * Copyright (C) 2014-2021 Philip Helger (www.helger.com)
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
 * Validate all UBLPE document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public final class UBLPEValidator
{
  @PresentForCodeCoverage
  private static final UBLPEValidator s_aInstance = new UBLPEValidator ();

  private UBLPEValidator ()
  {}

  /**
   * Create a validation builder for ApplicationResponseType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEValidatorBuilder <ApplicationResponseType> applicationResponse ()
  {
    return UBLPEValidatorBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a validation builder for CreditNoteType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEValidatorBuilder <CreditNoteType> creditNote ()
  {
    return UBLPEValidatorBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a validation builder for DebitNoteType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEValidatorBuilder <DebitNoteType> debitNote ()
  {
    return UBLPEValidatorBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a validation builder for InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEValidatorBuilder <InvoiceType> invoice ()
  {
    return UBLPEValidatorBuilder.create (InvoiceType.class);
  }

  /**
   * Create a validation builder for SummaryDocumentsType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEValidatorBuilder <SummaryDocumentsType> summaryDocuments ()
  {
    return UBLPEValidatorBuilder.create (SummaryDocumentsType.class);
  }

  /**
   * Create a validation builder for VoidedDocumentsType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static UBLPEValidatorBuilder <VoidedDocumentsType> voidedDocuments ()
  {
    return UBLPEValidatorBuilder.create (VoidedDocumentsType.class);
  }
}
