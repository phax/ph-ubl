/**
 * Copyright (C) 2014-2019 Philip Helger (www.helger.com)
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
           "import oasis.names.specification.ubl.schema.xsd.applicationresponse_23.ApplicationResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.attacheddocument_23.AttachedDocumentType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.awardednotification_23.AwardedNotificationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.billoflading_23.BillOfLadingType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.businesscard_23.BusinessCardType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.callfortenders_23.CallForTendersType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogue_23.CatalogueType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_23.CatalogueDeletionType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_23.CatalogueItemSpecificationUpdateType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_23.CataloguePricingUpdateType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguerequest_23.CatalogueRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.certificateoforigin_23.CertificateOfOriginType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.contractawardnotice_23.ContractAwardNoticeType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.contractnotice_23.ContractNoticeType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.creditnote_23.CreditNoteType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.debitnote_23.DebitNoteType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.despatchadvice_23.DespatchAdviceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.digitalagreement_23.DigitalAgreementType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.digitalcapability_23.DigitalCapabilityType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.documentstatus_23.DocumentStatusType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_23.DocumentStatusRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.enquiry_23.EnquiryType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.enquiryresponse_23.EnquiryResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_23.ExceptionCriteriaType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.exceptionnotification_23.ExceptionNotificationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.exportcustomsdeclaration_23.ExportCustomsDeclarationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_23.ExpressionOfInterestRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_23.ExpressionOfInterestResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.forecast_23.ForecastType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.forecastrevision_23.ForecastRevisionType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_23.ForwardingInstructionsType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.freightinvoice_23.FreightInvoiceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_23.FulfilmentCancellationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.goodscertificate_23.GoodsCertificateType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_23.GoodsItemItineraryType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.goodsitempassport_23.GoodsItemPassportType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_23.GuaranteeCertificateType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.instructionforreturns_23.InstructionForReturnsType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.inventoryreport_23.InventoryReportType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.invoice_23.InvoiceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_23.ItemInformationRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.order_23.OrderType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.ordercancellation_23.OrderCancellationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderchange_23.OrderChangeType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponse_23.OrderResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_23.OrderResponseSimpleType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.packinglist_23.PackingListType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_23.PriorInformationNoticeType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.productactivity_23.ProductActivityType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.proofofreexportation_23.ProofOfReexportationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_23.QualificationApplicationRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_23.QualificationApplicationResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.quotation_23.QuotationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.receiptadvice_23.ReceiptAdviceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.reminder_23.ReminderType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.remittanceadvice_23.RemittanceAdviceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.requestforproofofreexportation_23.RequestForProofOfReexportationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.requestforquotation_23.RequestForQuotationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.retailevent_23.RetailEventType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_23.SelfBilledCreditNoteType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_23.SelfBilledInvoiceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.statement_23.StatementType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_23.StockAvailabilityReportType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tender_23.TenderType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendercontract_23.TenderContractType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendererqualification_23.TendererQualificationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_23.TendererQualificationResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderreceipt_23.TenderReceiptType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderstatus_23.TenderStatusType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_23.TenderStatusRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_23.TenderWithdrawalType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_23.TradeItemLocationProfileType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportationstatus_23.TransportationStatusType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_23.TransportationStatusRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_23.TransportExecutionPlanType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_23.TransportExecutionPlanRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_23.TransportProgressStatusType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_23.TransportProgressStatusRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportservicedescription_23.TransportServiceDescriptionType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_23.TransportServiceDescriptionRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.unawardednotification_23.UnawardedNotificationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_23.UnsubscribeFromProcedureRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_23.UnsubscribeFromProcedureResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.utilitystatement_23.UtilityStatementType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.waybill_23.WaybillType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.weightstatement_23.WeightStatementType;\r\n" +
           "\r\n" +
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
