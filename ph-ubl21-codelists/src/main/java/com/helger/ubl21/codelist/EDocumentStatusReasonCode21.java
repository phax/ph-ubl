/*
 * Copyright (C) 2014-2025 Philip Helger (www.helger.com)
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
package com.helger.ubl21.codelist;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.CodingStyleguideUnaware;
import com.helger.base.id.IHasID;
import com.helger.base.lang.EnumHelper;
import com.helger.base.name.IHasDisplayName;


/**
 * This file was automatically generated from Genericode file DocumentStatusReasonCode-2.1.gc. Do NOT edit!
 * It contains a total of 106 entries!
 * @author com.helger.ubl21.supplementary.tools.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EDocumentStatusReasonCode21
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "Address ex delivery area", "The address for delivery is outside the area of the carrier/transporter."),
    _2("2", "After transport departed", "The goods/consignments/equipment arrived after the means of transport has departed."),
    _3("3", "Agent refusal", "The agent of the customer refused to accept delivery."),
    _4("4", "Altered seals", "The seals on the equipment have been changed from those notified."),
    _5("5", "Appointment scheduled", "An arrangement has been made to deliver at a specific time."),
    _6("6", "Attempt unsuccessful", "An unsuccessful attempt has been made to deliver the goods/consignments/equipment."),
    _7("7", "Business closed", "The goods/consignments/equipment could not be delivered/collected as the business was closed."),
    _8("8", "Changed schedule", "The goods/consignments/equipment cannot/will not be delivered/collected at the arranged time because of a change of schedule."),
    _9("9", "Complementary address needed", "A further address is needed to effect delivery/collection of the goods/consignments/equipment."),
    _10("10", "Computer system down", "The computer system is inoperative."),
    _11("11", "Credit approval requested", "The consignee requests delivery on a credit base."),
    _12("12", "Customer arrangements", "Goods/consignments/equipment require delivery arrangements by the customer."),
    _13("13", "Customs refusal", "The Customs authorities have refused to clear the goods/consignments/equipment."),
    _14("14", "Damaged", "The goods/consignments/equipment have been damaged."),
    _15("15", "Delivery at specific requested dates/times/periods", "Delivery of the goods/consignments/equipment is requested at specific dates/times/periods."),
    _16("16", "Destination incorrect", "The goods/consignments/equipment have been sent to wrong destination."),
    _17("17", "Departure delay", "The transport has been delayed in departing on the arranged transport action."),
    _18("18", "Derailment", "The train carrying the goods/consignments/equipment has been derailed."),
    _19("19", "Discrepancy", "There is a discrepancy between the details of goods/ equipment previously provided and the actual situation."),
    _20("20", "Dock strike", "The goods/consignments/equipment cannot be delivered/collected due to a dock strike."),
    _21("21", "Due to customer", "An action in the transport chain has been affected due to action of the customer."),
    _22("22", "Empty", "The package/equipment is found to be empty."),
    _23("23", "Equipment failure", "Delivery/collection could not be effected due to equipment failure."),
    _24("24", "Examination required by relevant authority", "An examination of the goods/equipment has been ordered by the relevant authority."),
    _25("25", "Export restrictions", "The goods/consignments/equipment have been prohibited from export pending further investigation."),
    _26("26", "Frustrated export", "Attempts to export the goods/consignments/equipment have been unsuccessful."),
    _27("27", "Goods units missing", "The tally of goods/consignments/equipment does not match the quantity as per advice. Result: less than advised."),
    _28("28", "Import restrictions", "The goods/consignments/equipment need import checks and tests pending being released for importation."),
    _29("29", "Incorrect pick information", "The goods/consignments/equipment were not collected due to incorrect pick information."),
    _30("30", "Incorrect address", "The address given for the action was incorrect."),
    _31("31", "Industrial dispute", "The action was frustrated by an industrial dispute."),
    _32("32", "Instructions awaited", "Further instructions are required."),
    _33("33", "Lost goods/consignments/equipment", "The goods/consignments/equipment have been lost in the course of a movement along the transport chain."),
    _34("34", "Means of transport damaged", "The means of transport on which the goods/consignments/equipment were being (were to be) moved has been damaged."),
    _35("35", "Mechanical breakdown", "There has been a mechanical breakdown of the means of transport/equipment on which the goods/consignments/equipment was being (was to be) moved."),
    _36("36", "Mechanical inspection", "A mechanical inspection of the means of transport/ equipment on which the goods/consignments/equipment were being (were to be) moved, is required."),
    _37("37", "Missing and/or incorrect documents", "The goods/consignments/equipment require complete and correct documentation."),
    _38("38", "New delivery arrangements", "Alternative delivery arrangements advised by consignee after failed delivery."),
    _39("39", "No recipient contact information", "No information available concerning the responsible person at delivery address."),
    _40("40", "Not identified", "The goods/consignments/equipment expected to be located and identified in the transport chain cannot be identified."),
    _41("41", "Not loaded", "The goods/consignments/equipment to be loaded onto a means of transport have not been loaded on the expected transport."),
    _42("42", "On deck", "The goods/consignments/equipment have been stowed on deck."),
    _43("43", "Package not ready", "The package was not available for collection."),
    _44("44", "Package tracking number unknown", "The package tracking number is unknown."),
    _45("45", "Partly missing", "The goods/consignments/equipment are partly, but not completely, missing."),
    _46("46", "Payment not received", "The expected payment for the transport action was not received."),
    _47("47", "Payment refused", "The payer refused to pay for the service."),
    _48("48", "Plundered", "The goods/consignments/equipment have been plundered."),
    _49("49", "Refused without reason given", "The transport action/documentation has been refused without explanation."),
    _50("50", "Scheduled past cut-off", "The goods/consignments/equipment to be delivered/collected have been scheduled past/later than the cut-off time."),
    _51("51", "Shunted to siding", "The transport on which the goods/consignments/equipment is to be placed has been shunted to siding."),
    _52("52", "Signature not required", "No signature required."),
    _53("53", "Sorted wrong route", "The goods/consignments/equipment have been sorted erroneously to an incorrect route."),
    _54("54", "Special service required", "A special service is required for the goods/consignments/equipment."),
    _55("55", "Split", "The consignment of goods has been split into two or more consignments."),
    _56("56", "Totally missing", "The total goods/consignments/equipment is missing."),
    _57("57", "Tracking information unavailable", "The tracking information of the goods/consignments/equipment is unavailable."),
    _58("58", "Transit delay", "The goods/consignments/equipment have been delayed in transit."),
    _59("59", "Unable to locate", "The goods/consignments/equipment cannot be located."),
    _60("60", "Unacceptable condition", "The goods/consignments/equipment were in unacceptable condition at time of delivery/collection."),
    _61("61", "Under deck", "The goods/consignments/equipment have been stowed under/below deck."),
    _62("62", "Unknown", "The reason is unknown."),
    _63("63", "Weather conditions", "The weather conditions have affected collection/delivery."),
    _64("64", "Expired free time", "The goods/consignments/equipment have been in a storage facility for longer than permitted free time."),
    _65("65", "Outstanding claims settled", "Outstanding claims in respect of goods/consignments/equipment have been settled."),
    _66("66", "Stolen", "A consignment or goods have been stolen."),
    _67("67", "Administrative error", "An administrative error has occurred."),
    _68("68", "Undefined incident attributed to buyer", "An undefined incident has been attributed to the buyer."),
    _69("69", "Undefined incident attributed to carrier", "An undefined incident has been attributed to the carrier."),
    _70("70", "Undefined incident attributed to logistic service provider", "An undefined incident has been attributed to the logistic service provider."),
    _71("71", "Change in agreed product reference", "An agreed reference associated with a product has changed."),
    _72("72", "Difference in replenishment figures", "A difference has been identified between the opening inventory balance, the physical count of incoming replenishment inventory, and the closing inventory balance."),
    _73("73", "Lost quantity of variable measurement product", "A quantity of a variable measurement product which has been lost."),
    _74("74", "Damaged during manipulation in warehouse", "Product damaged during the manipulation process in a warehouse."),
    _75("75", "Product degenerated during storage or transport", "A product has degenerated during storage or transport."),
    _76("76", "Destroyed", "The goods, consignments, or equipment have been destroyed."),
    _77("77", "Best before date expired", "A product's best before date has expired."),
    _78("78", "Log number assignment", "Log number is assigned."),
    _79("79", "Entry point assessment of Data Maintenance Request (DMR)", "initial comment An entry point is providing its initial comments on a DMR."),
    _80("80", "Entry point assessment of Data Maintenance Request (DMR)", "latest comment An entry point is providing its latest comments on a DMR."),
    _81("81", "Unable to take corrective action", "Corrective action could not be taken."),
    _82("82", "International assessment group reporting on Data", "Maintenance Request (DMR) The international assessment group has determined if the Data Maintenance Request (DMR) is to be included in the next publication of the standard."),
    _84("84", "Central secretariat review cycle start", "Report start of the central secretariat review cycle."),
    _85("85", "Data structure tag assigned", "A data structure has been assigned a permanent tag."),
    _87("87", "Error", "Information is in error."),
    _88("88", "Accident involving means of transport", "The means of transport being used to move the consignment has been involved in an accident."),
    _89("89", "Order or instruction status change", "A status of an order or instruction has changed."),
    _90("90", "Not accepted by delivery party", "The delivery was not accepted by the delivery party."),
    _91("91", "Delivery requested to another location by ordering party", "Goods have been delivered to another location following an instruction from the ordering party."),
    _92("92", "Incorrect goods delivered", "The goods delivered were incorrect."),
    _93("93", "Undefined incident attributed to customs authority", "An undefined incident has been attributed to the customs authority."),
    _94("94", "Imperfect item", "Item has defect(s)."),
    _95("95", "Excess goods delivered", "Excess goods have been delivered."),
    _96("96", "Goods partially delivered", "Goods were partially delivered."),
    _97("97", "Remove to federal court", "Action has been removed to a federal court level."),
    _98("98", "Change of venue granted", "A change in venue has been approved."),
    _99("99", "Replenish inventory", "The goods, consignment and/or equipment have replenished inventory."),
    _100("100", "Unloading date and or time not received", "The unloading date and or time was not received."),
    _101("101", "Stacked pallets not acceptable", "Stacked pallets are not accepted by the goods recipient."),
    _102("102", "Pallets containing mixed goods not acceptable", "Pallets containing mixed goods are not accepted by goods recipient."),
    _103("103", "Product expiry date not acceptable", "The product expiry date is not accepted."),
    _104("104", "Pallet and goods height higher than permitted", "The combined height of the pallet and goods is higher than permitted."),
    _105("105", "Delivery order not received", "The delivery order was not received."),
    _106("106", "Back-orders not permitted by goods recipient", "Back-orders are not permitted by the goods recipient."),
    _107("107", "Article identification not found in computer system", "Article identification is not found in computer system."),
    _108("108", "Goods not barcoded", "Goods are not barcoded.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_ID = "tred9013";
    public static final String LIST_VERSION = "D12B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    EDocumentStatusReasonCode21(@NonNull @Nonempty final String sID, @NonNull final String sDisplayName, @Nullable final String sDescription) {
        m_sID = sID;
        m_sDisplayName = sDisplayName;
        m_sDescription = sDescription;
    }

    @NonNull
    @Nonempty
    public String getID() {
        return m_sID;
    }

    @NonNull
    public String getDisplayName() {
        return m_sDisplayName;
    }

    @Nullable
    public String getDescription() {
        return m_sDescription;
    }

    @Nullable
    public static EDocumentStatusReasonCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EDocumentStatusReasonCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final EDocumentStatusReasonCode21 eValue = EDocumentStatusReasonCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
