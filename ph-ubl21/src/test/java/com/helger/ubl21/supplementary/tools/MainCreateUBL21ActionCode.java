/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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
package com.helger.ubl21.supplementary.tools;

import java.io.File;

import com.helger.commons.charset.CCharset;
import com.helger.commons.io.file.SimpleFileIO;
import com.helger.ubl.api.codegen.AbstractCreateUBLActionCode;
import com.helger.ubl21.EUBL21DocumentType;

public class MainCreateUBL21ActionCode extends AbstractCreateUBLActionCode
{
  private static final String ENUM_CLASS = "EUBL21DocumentType.";
  private static final String MARSHALLER_CLASS = "UBL21Marshaller";

  private static String _getPrefix (final String sWhat, final String sClassName)
  {
    return "package com.helger.ubl21;\n" +
           "\n" +
           "import java.io.File;\n" +
           "\n" +
           "import javax.annotation.Nonnull;\n" +
           "import javax.annotation.Nullable;\n" +
           "import javax.annotation.concurrent.NotThreadSafe;\n" +
           "import javax.xml.bind.ValidationEventHandler;\n" +
           "import javax.xml.transform.Result;\n" +
           "import javax.xml.transform.Source;\n" +
           "import javax.xml.transform.stream.StreamResult;\n" +
           "\n" +
           "import org.w3c.dom.Document;\n" +
           "import org.w3c.dom.Node;\n" +
           "\n" +
           "import com.helger.commons.annotation.PresentForCodeCoverage;\n" +
           "import com.helger.commons.error.IResourceErrorGroup;\n" +
           "import com.helger.commons.io.resource.IReadableResource;\n" +
           "import com.helger.commons.state.ESuccess;\n" +
           "import com.helger.commons.xml.transform.TransformSourceFactory;\n" +
           "import com.helger.ubl.api.AbstractUBLDocumentMarshaller;\n" +
           "\n" +
           "import oasis.names.specification.ubl.schema.xsd.applicationresponse_21.ApplicationResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.attacheddocument_21.AttachedDocumentType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.awardednotification_21.AwardedNotificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.billoflading_21.BillOfLadingType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.callfortenders_21.CallForTendersType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogue_21.CatalogueType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_21.CatalogueDeletionType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_21.CatalogueItemSpecificationUpdateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_21.CataloguePricingUpdateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguerequest_21.CatalogueRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.certificateoforigin_21.CertificateOfOriginType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.contractawardnotice_21.ContractAwardNoticeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.contractnotice_21.ContractNoticeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.creditnote_21.CreditNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.despatchadvice_21.DespatchAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.documentstatus_21.DocumentStatusType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_21.DocumentStatusRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_21.ExceptionCriteriaType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.exceptionnotification_21.ExceptionNotificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.forecast_21.ForecastType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.forecastrevision_21.ForecastRevisionType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_21.ForwardingInstructionsType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.freightinvoice_21.FreightInvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_21.FulfilmentCancellationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_21.GoodsItemItineraryType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_21.GuaranteeCertificateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.instructionforreturns_21.InstructionForReturnsType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.inventoryreport_21.InventoryReportType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.invoice_21.InvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_21.ItemInformationRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.order_21.OrderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.ordercancellation_21.OrderCancellationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderchange_21.OrderChangeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponse_21.OrderResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_21.OrderResponseSimpleType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.packinglist_21.PackingListType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_21.PriorInformationNoticeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.productactivity_21.ProductActivityType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.quotation_21.QuotationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.receiptadvice_21.ReceiptAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.reminder_21.ReminderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.remittanceadvice_21.RemittanceAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.requestforquotation_21.RequestForQuotationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.retailevent_21.RetailEventType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_21.SelfBilledCreditNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_21.SelfBilledInvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.statement_21.StatementType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_21.StockAvailabilityReportType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tender_21.TenderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendererqualification_21.TendererQualificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_21.TendererQualificationResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderreceipt_21.TenderReceiptType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_21.TradeItemLocationProfileType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportationstatus_21.TransportationStatusType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_21.TransportationStatusRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_21.TransportExecutionPlanType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_21.TransportExecutionPlanRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_21.TransportProgressStatusType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_21.TransportProgressStatusRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportservicedescription_21.TransportServiceDescriptionType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_21.TransportServiceDescriptionRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.unawardednotification_21.UnawardedNotificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.utilitystatement_21.UtilityStatementType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.waybill_21.WaybillType;\n" +
           "/**\n" +
           " * " +
           sWhat +
           " all UBL 2.1 document types.\n" +
           " * \n" +
           " * @author Philip Helger\n" +
           " */" +
           "@SuppressWarnings (\"deprecation\")\n" +
           "@NotThreadSafe\n" +
           "public final class " +
           sClassName +
           " extends AbstractUBLDocumentMarshaller\n" +
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
    StringBuilder aSB = new StringBuilder (_getPrefix ("Read", "UBL21Reader"));
    for (final EUBL21DocumentType e : EUBL21DocumentType.values ())
      append (e, EPhase.READ, aSB, "UBL21ReaderBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl21/UBL21Reader.java"),
                            aSB.append ("}").toString (),
                            CCharset.CHARSET_UTF_8_OBJ);

    aSB = new StringBuilder (_getPrefix ("Write", "UBL21Writer"));
    for (final EUBL21DocumentType e : EUBL21DocumentType.values ())
      append (e, EPhase.WRITE, aSB, "UBL21WriterBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl21/UBL21Writer.java"),
                            aSB.append ("}").toString (),
                            CCharset.CHARSET_UTF_8_OBJ);

    aSB = new StringBuilder (_getPrefix ("Validate", "UBL21Validator"));
    for (final EUBL21DocumentType e : EUBL21DocumentType.values ())
      append (e, EPhase.VALIDATE, aSB, "UBL21ValidatorBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl21/UBL21Validator.java"),
                            aSB.append ("}").toString (),
                            CCharset.CHARSET_UTF_8_OBJ);

    System.out.println ("Done");
  }
}
