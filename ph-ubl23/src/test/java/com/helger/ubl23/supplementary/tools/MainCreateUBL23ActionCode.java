/*
 * Copyright (C) 2014-2022 Philip Helger (www.helger.com)
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
package com.helger.ubl23.supplementary.tools;

import java.io.File;
import java.nio.charset.StandardCharsets;

import com.helger.commons.io.file.SimpleFileIO;
import com.helger.ubl.api.codegen.AbstractCreateUBLActionCode;
import com.helger.ubl23.EUBL23DocumentType;

public class MainCreateUBL23ActionCode extends AbstractCreateUBLActionCode
{
  private static String _getPrefix (final String sWhat, final String sClassName)
  {
    return "package com.helger.ubl23;\n" +
           "\n" +
           "import javax.annotation.Nonnull;\n" +
           "import javax.annotation.concurrent.NotThreadSafe;\n" +
           "\n" +
           "import com.helger.commons.annotation.PresentForCodeCoverage;\n" +
           "\n" +
           "import oasis.names.specification.ubl.schema.xsd.applicationresponse_23.ApplicationResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.attacheddocument_23.AttachedDocumentType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.awardednotification_23.AwardedNotificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.billoflading_23.BillOfLadingType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.businesscard_23.BusinessCardType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.callfortenders_23.CallForTendersType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogue_23.CatalogueType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_23.CatalogueDeletionType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_23.CatalogueItemSpecificationUpdateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_23.CataloguePricingUpdateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguerequest_23.CatalogueRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.certificateoforigin_23.CertificateOfOriginType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.commontransportationreport_23.CommonTransportationReportType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ContractAwardNoticeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.contractnotice_23.ContractNoticeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.creditnote_23.CreditNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.debitnote_23.DebitNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.despatchadvice_23.DespatchAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.digitalagreement_23.DigitalAgreementType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.digitalcapability_23.DigitalCapabilityType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.documentstatus_23.DocumentStatusType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_23.DocumentStatusRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.enquiry_23.EnquiryType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.enquiryresponse_23.EnquiryResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_23.ExceptionCriteriaType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.exceptionnotification_23.ExceptionNotificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_23.ExportCustomsDeclarationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_23.ExpressionOfInterestRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_23.ExpressionOfInterestResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.forecast_23.ForecastType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.forecastrevision_23.ForecastRevisionType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_23.ForwardingInstructionsType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.freightinvoice_23.FreightInvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_23.FulfilmentCancellationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.goodscertificate_23.GoodsCertificateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_23.GoodsItemItineraryType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.goodsitempassport_23.GoodsItemPassportType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_23.GuaranteeCertificateType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.importcustomsdeclaration_23.ImportCustomsDeclarationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.instructionforreturns_23.InstructionForReturnsType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.inventoryreport_23.InventoryReportType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.invoice_23.InvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_23.ItemInformationRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.manifest_23.ManifestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.order_23.OrderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.ordercancellation_23.OrderCancellationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderchange_23.OrderChangeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponse_23.OrderResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_23.OrderResponseSimpleType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.packinglist_23.PackingListType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.PriorInformationNoticeType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.productactivity_23.ProductActivityType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.proofofreexportation_23.ProofOfReexportationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.proofofreexportationrequest_23.ProofOfReexportationRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.proofofreexportationreminder_23.ProofOfReexportationReminderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_23.QualificationApplicationRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_23.QualificationApplicationResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.quotation_23.QuotationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.receiptadvice_23.ReceiptAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.reminder_23.ReminderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.remittanceadvice_23.RemittanceAdviceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.requestforquotation_23.RequestForQuotationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.retailevent_23.RetailEventType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_23.SelfBilledCreditNoteType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_23.SelfBilledInvoiceType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.statement_23.StatementType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_23.StockAvailabilityReportType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tender_23.TenderType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendercontract_23.TenderContractType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendererqualification_23.TendererQualificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_23.TendererQualificationResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderreceipt_23.TenderReceiptType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderstatus_23.TenderStatusType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_23.TenderStatusRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_23.TenderWithdrawalType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_23.TradeItemLocationProfileType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transitcustomsdeclaration_23.TransitCustomsDeclarationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportationstatus_23.TransportationStatusType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_23.TransportationStatusRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_23.TransportExecutionPlanType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_23.TransportExecutionPlanRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_23.TransportProgressStatusType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_23.TransportProgressStatusRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportservicedescription_23.TransportServiceDescriptionType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_23.TransportServiceDescriptionRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.unawardednotification_23.UnawardedNotificationType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_23.UnsubscribeFromProcedureRequestType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_23.UnsubscribeFromProcedureResponseType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.utilitystatement_23.UtilityStatementType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.waybill_23.WaybillType;\n" +
           "import oasis.names.specification.ubl.schema.xsd.weightstatement_23.WeightStatementType;\n" +
           "\n" +
           "/**\n" +
           " * " +
           sWhat +
           " all UBL 2.3 document types.\n" +
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
    StringBuilder aSB = new StringBuilder (_getPrefix ("Read", "UBL23Reader"));
    for (final EUBL23DocumentType e : EUBL23DocumentType.values ())
      append (e, EPhase.READ, aSB, "UBL23ReaderBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl23/UBL23Reader.java"),
                            aSB.append ("}").toString (),
                            StandardCharsets.UTF_8);

    aSB = new StringBuilder (_getPrefix ("Write", "UBL23Writer"));
    for (final EUBL23DocumentType e : EUBL23DocumentType.values ())
      append (e, EPhase.WRITE, aSB, "UBL23WriterBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl23/UBL23Writer.java"),
                            aSB.append ("}").toString (),
                            StandardCharsets.UTF_8);

    aSB = new StringBuilder (_getPrefix ("Validate", "UBL23Validator"));
    for (final EUBL23DocumentType e : EUBL23DocumentType.values ())
      append (e, EPhase.VALIDATE, aSB, "UBL23ValidatorBuilder");
    SimpleFileIO.writeFile (new File ("src/main/java/com/helger/ubl23/UBL23Validator.java"),
                            aSB.append ("}").toString (),
                            StandardCharsets.UTF_8);

    System.out.println ("Done");
  }
}
