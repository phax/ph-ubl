/*
 * Copyright (C) 2020-2023 Philip Helger (www.helger.com)
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
package com.helger.dianubl;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.PresentForCodeCoverage;

import dian.gov.co.facturaelectronica.structures_2_1.DianExtensionsType;
import oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ApplicationResponseType;
import oasis.names.specification.ubl.schema.xsd.attacheddocument_21.AttachedDocumentType;
import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;
import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;
import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;

/**
 * Read all DIAN UBL document types.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public final class DianUBLReader
{
  @PresentForCodeCoverage
  private static final DianUBLReader INSTANCE = new DianUBLReader ();

  private DianUBLReader ()
  {}

  /**
   * Create a reader builder for {@link DianExtensionsType}.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static DianUBLReaderBuilder <DianExtensionsType> dianExtensions ()
  {
    return DianUBLReaderBuilder.create (DianExtensionsType.class);
  }

  /**
   * Create a reader builder for ApplicationResponseType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static DianUBLReaderBuilder <ApplicationResponseType> applicationResponse ()
  {
    return DianUBLReaderBuilder.create (ApplicationResponseType.class);
  }

  /**
   * Create a reader builder for AttachedDocumentType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static DianUBLReaderBuilder <AttachedDocumentType> attachedDocument ()
  {
    return DianUBLReaderBuilder.create (AttachedDocumentType.class);
  }

  /**
   * Create a reader builder for CreditNoteType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static DianUBLReaderBuilder <CreditNoteType> creditNote ()
  {
    return DianUBLReaderBuilder.create (CreditNoteType.class);
  }

  /**
   * Create a reader builder for DebitNoteType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static DianUBLReaderBuilder <DebitNoteType> debitNote ()
  {
    return DianUBLReaderBuilder.create (DebitNoteType.class);
  }

  /**
   * Create a reader builder for InvoiceType.
   *
   * @return The builder and never <code>null</code>
   */
  @Nonnull
  public static DianUBLReaderBuilder <InvoiceType> invoice ()
  {
    return DianUBLReaderBuilder.create (InvoiceType.class);
  }
}
