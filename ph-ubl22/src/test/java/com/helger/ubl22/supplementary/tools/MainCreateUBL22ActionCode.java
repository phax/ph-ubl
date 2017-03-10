/**
 * Copyright (C) 2014-2017 Philip Helger (www.helger.com)
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
package com.helger.ubl22.supplementary.tools;

import java.io.File;
import java.nio.charset.StandardCharsets;

import com.helger.commons.io.file.SimpleFileIO;
import com.helger.ubl.api.codegen.AbstractCreateUBLActionCode;
import com.helger.ubl22.EUBL22DocumentType;

public class MainCreateUBL22ActionCode extends AbstractCreateUBLActionCode
{
  private static String _getPrefix (final String sWhat, final String sClassName)
  {
    return "package com.helger.ubl22;\n" +
           "\n" +
           "import javax.annotation.Nonnull;\n" +
           "import javax.annotation.concurrent.NotThreadSafe;\n" +
           "\n" +
           "import com.helger.commons.annotation.PresentForCodeCoverage;\n" +
           "\n" +
           "import oasis.names.specification.ubl.schema.xsd.applicationresponse_22.ApplicationResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.attacheddocument_22.AttachedDocumentType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.awardednotification_22.AwardedNotificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.billoflading_22.BillOfLadingType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.businesscard_22.BusinessCardType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.callfortenders_22.CallForTendersType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogue_22.CatalogueType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_22.CatalogueDeletionType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_22.CatalogueItemSpecificationUpdateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_22.CataloguePricingUpdateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguerequest_22.CatalogueRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.certificateoforigin_22.CertificateOfOriginType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.contractawardnotice_22.ContractAwardNoticeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.contractnotice_22.ContractNoticeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.creditnote_22.CreditNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.debitnote_22.DebitNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.despatchadvice_22.DespatchAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.documentstatus_22.DocumentStatusType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_22.DocumentStatusRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_22.ExceptionCriteriaType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.exceptionnotification_22.ExceptionNotificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.forecast_22.ForecastType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.forecastrevision_22.ForecastRevisionType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_22.ForwardingInstructionsType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.freightinvoice_22.FreightInvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_22.FulfilmentCancellationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_22.GoodsItemItineraryType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_22.GuaranteeCertificateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.instructionforreturns_22.InstructionForReturnsType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.inventoryreport_22.InventoryReportType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.invoice_22.InvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_22.ItemInformationRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.order_22.OrderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.ordercancellation_22.OrderCancellationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderchange_22.OrderChangeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponse_22.OrderResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_22.OrderResponseSimpleType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.packinglist_22.PackingListType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_22.PriorInformationNoticeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.productactivity_22.ProductActivityType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.quotation_22.QuotationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.receiptadvice_22.ReceiptAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.reminder_22.ReminderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.remittanceadvice_22.RemittanceAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.requestforquotation_22.RequestForQuotationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.retailevent_22.RetailEventType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_22.SelfBilledCreditNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_22.SelfBilledInvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.statement_22.StatementType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_22.StockAvailabilityReportType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tender_22.TenderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendererqualification_22.TendererQualificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_22.TendererQualificationResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderreceipt_22.TenderReceiptType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_22.TradeItemLocationProfileType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportationstatus_22.TransportationStatusType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_22.TransportationStatusRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_22.TransportExecutionPlanType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_22.TransportExecutionPlanRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_22.TransportProgressStatusType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_22.TransportProgressStatusRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportservicedescription_22.TransportServiceDescriptionType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_22.TransportServiceDescriptionRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.unawardednotification_22.UnawardedNotificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.utilitystatement_22.UtilityStatementType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.waybill_22.WaybillType;\n" +
           "/**\n" +
           " * " +
           sWhat +
           " all UBL 2.1 document types.\n" +
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
           " s_aInstance = new " +
           sClassName +
           " ();\n" +
           "\n" +
           "  private " +
           sClassName +
           " () {}\n";
  }

  public static void main (final String [] args)
  {
    StringBuilder aSB = new StringBuilder (_getPrefix ("Read", "UBL22Reader"));
    for (final EUBL22DocumentType e : EUBL22DocumentType.values ())
      append (e, EPhase.READ, aSB, "UBL22ReaderBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl22/UBL22Reader.java"),
                            aSB.append ("}").toString (),
                            StandardCharsets.UTF_8);

    aSB = new StringBuilder (_getPrefix ("Write", "UBL22Writer"));
    for (final EUBL22DocumentType e : EUBL22DocumentType.values ())
      append (e, EPhase.WRITE, aSB, "UBL22WriterBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl22/UBL22Writer.java"),
                            aSB.append ("}").toString (),
                            StandardCharsets.UTF_8);

    aSB = new StringBuilder (_getPrefix ("Validate", "UBL22Validator"));
    for (final EUBL22DocumentType e : EUBL22DocumentType.values ())
      append (e, EPhase.VALIDATE, aSB, "UBL22ValidatorBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl22/UBL22Validator.java"),
                            aSB.append ("}").toString (),
                            StandardCharsets.UTF_8);

    System.out.println ("Done");
  }
}
