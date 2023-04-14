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
package com.helger.ubl20.supplementary.tools;

import java.io.File;
import java.nio.charset.StandardCharsets;

import com.helger.commons.io.file.SimpleFileIO;
import com.helger.ubl.api.codegen.AbstractCreateUBLActionCode;
import com.helger.ubl20.EUBL20DocumentType;

@Deprecated
public final class MainCreateUBL20ActionCode extends AbstractCreateUBLActionCode
{
  private static String _getPrefix (final String sWhat, final String sClassName)
  {
    return "package com.helger.ubl20;\n" +
           "\n" +
           "import javax.annotation.Nonnull;\n" +
           "import javax.annotation.concurrent.NotThreadSafe;\n" +
           "\n" +
           "import com.helger.commons.annotation.PresentForCodeCoverage;\n" +
           "\n" +
           "import oasis.names.specification.ubl.schema.xsd.applicationresponse_2.ApplicationResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.attacheddocument_2.AttachedDocumentType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.billoflading_2.BillOfLadingType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogue_2.CatalogueType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_2.CatalogueDeletionType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_2.CatalogueItemSpecificationUpdateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_2.CataloguePricingUpdateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguerequest_2.CatalogueRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.certificateoforigin_2.CertificateOfOriginType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.creditnote_2.CreditNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.debitnote_2.DebitNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.despatchadvice_2.DespatchAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_2.ForwardingInstructionsType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.freightinvoice_2.FreightInvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.invoice_2.InvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.order_2.OrderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.ordercancellation_2.OrderCancellationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderchange_2.OrderChangeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponse_2.OrderResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_2.OrderResponseSimpleType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.packinglist_2.PackingListType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.quotation_2.QuotationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.receiptadvice_2.ReceiptAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.reminder_2.ReminderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.remittanceadvice_2.RemittanceAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.requestforquotation_2.RequestForQuotationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_2.SelfBilledCreditNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_2.SelfBilledInvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.statement_2.StatementType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportationstatus_2.TransportationStatusType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.waybill_2.WaybillType;\n" +
           "\n" +
           "/**\n" +
           " * " +
           sWhat +
           " all UBL 2.0 document types.\n" +
           " * \n" +
           " * @author Philip Helger\n" +
           " */\n" +
           "@NotThreadSafe\n" +
           "public final class " +
           sClassName +
           "\n" +
           "{\n" +
           "  @PresentForCodeCoverage\n" +
           "  private static final " +
           sClassName +
           " INSTANCE = new " +
           sClassName +
           " ();\n" +
           "\n" +
           "  private " +
           sClassName +
           " () {}\n";
  }

  public static void main (final String [] args)
  {
    StringBuilder aSB = new StringBuilder (_getPrefix ("Read", "UBL20Reader"));
    for (final EUBL20DocumentType e : EUBL20DocumentType.values ())
      append (e, EPhase.READ, aSB, "UBL20ReaderBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl20/UBL20Reader.java"),
                            aSB.append ("}").toString (),
                            StandardCharsets.UTF_8);

    aSB = new StringBuilder (_getPrefix ("Write", "UBL20Writer"));
    for (final EUBL20DocumentType e : EUBL20DocumentType.values ())
      append (e, EPhase.WRITE, aSB, "UBL20WriterBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl20/UBL20Writer.java"),
                            aSB.append ("}").toString (),
                            StandardCharsets.UTF_8);

    aSB = new StringBuilder (_getPrefix ("Validate", "UBL20Validator"));
    for (final EUBL20DocumentType e : EUBL20DocumentType.values ())
      append (e, EPhase.VALIDATE, aSB, "UBL20ValidatorBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl20/UBL20Validator.java"),
                            aSB.append ("}").toString (),
                            StandardCharsets.UTF_8);

    System.out.println ("Done");
  }
}
