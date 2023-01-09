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
           "import oasis.names.specification.ubl.schema.xsd.applicationresponse_22.ApplicationResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.attacheddocument_22.AttachedDocumentType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.awardednotification_22.AwardedNotificationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.billoflading_22.BillOfLadingType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.businesscard_22.BusinessCardType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.callfortenders_22.CallForTendersType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogue_22.CatalogueType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguedeletion_22.CatalogueDeletionType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.catalogueitemspecificationupdate_22.CatalogueItemSpecificationUpdateType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguepricingupdate_22.CataloguePricingUpdateType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.cataloguerequest_22.CatalogueRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.certificateoforigin_22.CertificateOfOriginType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.contractawardnotice_22.ContractAwardNoticeType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.contractnotice_22.ContractNoticeType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.creditnote_22.CreditNoteType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.debitnote_22.DebitNoteType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.despatchadvice_22.DespatchAdviceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.digitalagreement_22.DigitalAgreementType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.digitalcapability_22.DigitalCapabilityType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.documentstatus_22.DocumentStatusType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.documentstatusrequest_22.DocumentStatusRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.enquiry_22.EnquiryType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.enquiryresponse_22.EnquiryResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.exceptioncriteria_22.ExceptionCriteriaType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.exceptionnotification_22.ExceptionNotificationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.expressionofinterestrequest_22.ExpressionOfInterestRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.expressionofinterestresponse_22.ExpressionOfInterestResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.forecast_22.ForecastType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.forecastrevision_22.ForecastRevisionType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.forwardinginstructions_22.ForwardingInstructionsType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.freightinvoice_22.FreightInvoiceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.fulfilmentcancellation_22.FulfilmentCancellationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.goodsitemitinerary_22.GoodsItemItineraryType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.guaranteecertificate_22.GuaranteeCertificateType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.instructionforreturns_22.InstructionForReturnsType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.inventoryreport_22.InventoryReportType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.invoice_22.InvoiceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.iteminformationrequest_22.ItemInformationRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.order_22.OrderType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.ordercancellation_22.OrderCancellationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderchange_22.OrderChangeType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponse_22.OrderResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.orderresponsesimple_22.OrderResponseSimpleType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.packinglist_22.PackingListType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.priorinformationnotice_22.PriorInformationNoticeType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.productactivity_22.ProductActivityType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.qualificationapplicationrequest_22.QualificationApplicationRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.qualificationapplicationresponse_22.QualificationApplicationResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.quotation_22.QuotationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.receiptadvice_22.ReceiptAdviceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.reminder_22.ReminderType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.remittanceadvice_22.RemittanceAdviceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.requestforquotation_22.RequestForQuotationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.retailevent_22.RetailEventType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledcreditnote_22.SelfBilledCreditNoteType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.selfbilledinvoice_22.SelfBilledInvoiceType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.statement_22.StatementType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.stockavailabilityreport_22.StockAvailabilityReportType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tender_22.TenderType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendercontract_22.TenderContractType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendererqualification_22.TendererQualificationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tendererqualificationresponse_22.TendererQualificationResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderreceipt_22.TenderReceiptType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderstatus_22.TenderStatusType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderstatusrequest_22.TenderStatusRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tenderwithdrawal_22.TenderWithdrawalType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.tradeitemlocationprofile_22.TradeItemLocationProfileType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportationstatus_22.TransportationStatusType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportationstatusrequest_22.TransportationStatusRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportexecutionplan_22.TransportExecutionPlanType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportexecutionplanrequest_22.TransportExecutionPlanRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportprogressstatus_22.TransportProgressStatusType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportprogressstatusrequest_22.TransportProgressStatusRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportservicedescription_22.TransportServiceDescriptionType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.transportservicedescriptionrequest_22.TransportServiceDescriptionRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.unawardednotification_22.UnawardedNotificationType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedurerequest_22.UnsubscribeFromProcedureRequestType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.unsubscribefromprocedureresponse_22.UnsubscribeFromProcedureResponseType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.utilitystatement_22.UtilityStatementType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.waybill_22.WaybillType;\r\n" +
           "import oasis.names.specification.ubl.schema.xsd.weightstatement_22.WeightStatementType;\r\n" +
           "/**\n" +
           " * " +
           sWhat +
           " all UBL 2.2 document types.\n" +
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
