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
package com.helger.ubl21.codelist;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * This file was automatically generated from Genericode file LocationTypeCode-2.1.gc. Do NOT edit!
 * It contains a total of 297 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum ELocationTypeCode21
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "Place of terms of delivery", "(3018) Point or port of departure, shipment or destination, as required under the applicable terms of delivery, e.g. Incoterms."),
    _2("2", "Payment location", "[3109] To identify the place where the payment has been or should be made."),
    _3("3", "Tare check place", "Place where equipment tare has been or must be checked for official assessment."),
    _4("4", "Goods receipt place", "Place at which the goods have been received."),
    _5("5", "Place of departure", "(3214) Port, airport or other location from which a means of transport or transport equipment is scheduled to depart or has departed."),
    _6("6", "Ward bed", "A bed in a ward."),
    _7("7", "Place of delivery", "(3246) Place to which the goods are to be finally delivered under transport contract terms (operational term)."),
    _8("8", "Place of destination", "Port, airport or other location to which a means of transport or transport equipment is destined."),
    _9("9", "Place of loading", "[3334] Seaport, airport, freight terminal, rail station or other place at which the goods (cargo) are loaded on to the means of transport being used for their carriage."),
    _10("10", "Place of acceptance", "[3348] Place where the goods are taken over by the carrier."),
    _11("11", "Place of discharge", "[3392] Seaport, airport, freight terminal, rail station or other place at which goods are unloaded from the means of transport having been used for their carriage."),
    _12("12", "Port of discharge", "Port at which the goods are discharged from the vessel used for their transport."),
    _13("13", "Place of transhipment", "[3424] Place where goods are to be or have been transferred from one means of transport to another during the course of one transport operation."),
    _14("14", "Goods item storage location", "[3385] To identify the place where a goods item is located."),
    _15("15", "Place of transfer responsibility", "Place where the responsibility is transferred."),
    _16("16", "Place of transfer of ownership", "Place where the ownership of the goods is transferred."),
    _17("17", "Border crossing place", "Place where goods are transported across a country border."),
    _18("18", "Warehouse", "[3156] Warehouse where a particular consignment is to be or has been stored."),
    _19("19", "Factory/plant", "Factory/plant relevant for a particular consignment."),
    _20("20", "Place of ultimate destination of goods", "Place where goods will ultimately be delivered."),
    _21("21", "Terms of sale place", "Place of departure, shipment or destination as specified in the terms of sale agreed between the parties."),
    _22("22", "Customs clearance location", "[3080] Place at which Customs clearance should or has taken place."),
    _23("23", "Port of release", "Port where goods are released from Customs custody."),
    _24("24", "Port of entry", "Port where final documentation is filed for Customs Entry processing."),
    _25("25", "Country", "Country relevant for a particular transaction."),
    _26("26", "City", "City or town relevant for a particular transaction or consignment."),
    _27("27", "Country of origin", "[3239] To identify the country in which the goods have been produced or manufactured, according to criteria laid down for the application of the Customs tariff or quantitative restrictions, or any measure related to trade."),
    _28("28", "Country of destination of goods", "Country to which the goods are to be delivered."),
    _29("29", "Railway station", "Name or identification of a railway station/yard relevant to a particular consignment."),
    _30("30", "Country of source", "Country in which raw material or components were originally produced prior to manufacture or assembly in another country."),
    _31("31", "Building", "A building or part thereof relevant to a particular consignment or transaction."),
    _32("32", "Beginning of chargeable section", "First rail station in a predefined section of the chargeable voyage. A complete voyage may be divided in sections, even within one country, that are separately chargeable using different tariff rules (split tariffs)."),
    _33("33", "Baseport of discharge", "[3356] Place at which the cargo is discharged or unloaded from a means of transport according to the transport contract. The goods may or may not be discharged from the main means of transport at this place or port."),
    _34("34", "Baseport of loading", "[3322] Place at which the cargo is loaded on a means of transport according to the transport contract. The goods may or may not be loaded on the main means of transport at this place or port."),
    _35("35", "Exportation country", "[3220] Country from which the goods were initially exported to the importing country without any commercial transaction taking place in intermediate countries. Synonym: Country whence consigned. Country of despatch: Country from which goods are despatched between countries of a Customs union."),
    _36("36", "Country of ultimate destination", "(3216) Country known to the consignor or his agent at the time of despatch to be the final country to which the goods are to be delivered."),
    _37("37", "Consignment final exportation country", "[3331] To identify the country from which goods have been or will be consigned prior to final importation."),
    _38("38", "Consignment first destination country", "[3219] To identify the country where a consignment is off-loaded from the means of transport used for the original exportation."),
    _39("39", "Country of production", "Country where item has been or will be produced."),
    _40("40", "Country of trading", "Country where item has been or will be traded."),
    _41("41", "Consignment entry customs office location", "[3089] To identify the customs office at which the goods enter the customs territory of destination."),
    _42("42", "Consignment exit customs office location", "[3097] To identify the customs office at which the goods leave or are intended to leave the customs territory of despatch."),
    _43("43", "Place of Customs examination", "Place where Customs undertakes a physical inspection of goods to satisfy themselves that the goods' nature, origin, condition, quantity and value are in accordance with the particulars furnished on the goods declaration (CCC)."),
    _44("44", "Place of authentication of document", "(3410) Place where document is signed or otherwise authenticated. Synonym: Place of issue of document."),
    _45("45", "Customs office of destination (transit)", "(3086) Customs office at which a transit operation is terminated. Synonym: Customs office of transit termination."),
    _46("46", "Region of despatch", "Region from which goods are despatched between countries of a Customs union."),
    _47("47", "Region of destination", "Region known to the consignor or his agent at the time of despatch to be the final region to which the goods are to be delivered."),
    _48("48", "Region of production", "Region where item has been or will be produced."),
    _49("49", "Transit country", "[3263] Country through which a goods or passengers are routed between the country of original departure and final destination."),
    _50("50", "Transit customs office location", "[3107] To identify the customs office which is responsible for transit formalities en-route."),
    _51("51", "Country of invalid transit guarantee", "Country in which the security or guarantee for the movement of goods under a transit procedure is not valid."),
    _52("52", "Country of destination (transit)", "Country at which a Customs transit operation is terminated. Synonym: Country of transit termination."),
    _53("53", "Charge and freight due from", "Place or point from which charges and freight are charged."),
    _54("54", "Manufacturing department", "A department within the manufacturing area (e.g. lacquering, assembly)."),
    _55("55", "Freight charge payable to location", "[3102] Name of a place to which a transport charges tariff applies or where freight and other related charges are to be or have been incurred."),
    _56("56", "End of chargeable section", "Last rail station in a predefined section of the chargeable voyage. A complete voyage may be divided in sections, even within one country, that are separately chargeable using different tariff rules (split tariffs)."),
    _57("57", "Place of payment", "Name of the location at which freight and charges for main transport are payable."),
    _58("58", "Full track loading or unloading", "Identification of the station proceeding to the loading or unloading of a rail wagon on a full track site. (Used only when a rail station is obliged to transfer the load on another wagon for technical reasons - e.g. damage)."),
    _59("59", "Place of loss", "To identify the location where the loss occurred."),
    _60("60", "Place of arrival", "Place at which the transport means arrives."),
    _61("61", "Next port of call", "Next port which the vessel is going to call upon."),
    _62("62", "On-carriage port", "Port of discharge at which the cargo is discharged from the vessel, used for transport after the main transport (transit port)."),
    _63("63", "Sub-project location", "A place at which works occur referring to a sub-project."),
    _64("64", "First optional place of discharge", "The first optional place or port of discharge as mentioned on the transport document where cargo can be discharged at the option of the shipper."),
    _65("65", "Final port or place of discharge", "Name of the seaport, airport, freight terminal, rail station or other place at which the goods (cargo) are finally (to be) unloaded from the means of transport used for their carriage according to the transport contract."),
    _66("66", "Express railway station", "Railway station offering express transportation services."),
    _67("67", "Mixed cargo railway station", "Railway station offering mixed cargo transportation services ."),
    _68("68", "Second optional place of discharge", "The second optional place or port of discharge as mentioned on the transport document where cargo can be discharged at the option of shipper."),
    _69("69", "Next non-discharge port of call", "A code to identify the next port of call for a vessel where no cargo will be discharged."),
    _70("70", "Third optional place of discharge", "The third optional place or port of discharge as mentioned on the transport document where cargo can be discharged at the option of the shipper."),
    _71("71", "Reconsolidation point", "A place where cargo is reconsolidated."),
    _72("72", "Fourth optional place of discharge", "The fourth optional place or port of discharge as mentioned on the transport document where cargo can be discharged at the option of the shipper."),
    _73("73", "Bill of lading release office", "A location where bills of lading are released to customers."),
    _74("74", "Transhipment excluding this place", "Place/location where a transhipment from a means of transport to another means of transport is not authorised."),
    _75("75", "Transhipment limited to this place", "Only place/location where a transhipment from a means of transport to another means of transport is authorised."),
    _76("76", "Original port of loading", "The port where the goods were first loaded on a vessel."),
    _77("77", "First port of call - non-discharging", "Port in the country of destination where the conveyance initially arrives from the 'last place/port of call of conveyance' and where a conveyance will not be discharging cargoes."),
    _78("78", "First port of call - discharging", "Port in the country of destination where the conveyance initially arrives from the 'last place/port of call of conveyance' and where a conveyance will be discharging cargoes."),
    _79("79", "Place/port of first entry", "Place or port where final documentation is filed for Customs entry processing."),
    _80("80", "Place of despatch", "Place at which the goods are taken over for carriage (operational term), if different from the transport contract place of acceptance (see: 10). Synonym: Place of origin of carriage."),
    _81("81", "Fifth optional place of discharge", "The fifth optional place or port of discharge as mentioned on the transport document where cargo can be discharged at the option of the shipper."),
    _82("82", "Pre-carriage port", "Port of loading at which the cargo is loaded on the pre-carriage vessel used for the transport prior to the main transport."),
    _83("83", "Place of delivery (by on carriage)", "Place to which the goods are to be finally delivered."),
    _84("84", "Transport contract place of acceptance", "Place at which the goods are taken over by the carrier according to the contract of carriage."),
    _85("85", "Transport contract place of destination", "Place to which the goods are destined."),
    _86("86", "Country of valid transit guarantee", "Country in which the security or guarantee for the movement of goods under a transit procedure is valid."),
    _87("87", "Place/port of conveyance initial arrival", "Place/port in the country of destination where the conveyance initially arrives from the \"Last place/port of call of conveyance\" (125)."),
    _88("88", "Place of receipt", "Identification of the location at which the cargo is actually received."),
    _89("89", "Place of registration", "Place where the registration occurs."),
    _90("90", "Special treatment place", "Place where one or more special treatments have happened or must happen."),
    _91("91", "Place of document issue", "The place or location where a document is issued."),
    _92("92", "Routing", "Indication of a routing place."),
    _93("93", "Station of application of additional costs", "Rail station where, according to the transport contract, some chargeable operations must happen (re-weighting, re-fixing of the load, control on equipment and on consignment, etc.)."),
    _94("94", "Previous port of call", "Previous port which the vessel has called upon."),
    _95("95", "Sailing destination area", "Geographical area to which the vessel's trip is destined."),
    _96("96", "Place of lodgement of documents", "Customs station where, required documents for Customs declarations, have been lodged."),
    _97("97", "Optional place of discharge", "The optional place or port of discharge as mentioned on the bill of lading where cargo is discharged at the option of the shipper."),
    _98("98", "Place of empty equipment despatch", "The location from which empty equipment is despatched."),
    _99("99", "Place of empty equipment return", "The location to which empty equipment is returned."),
    _100("100", "Place/port of warehouse entry", "Location (e.g. district) within a Customs territory where a warehouse entry was filed to enter merchandise into a Customs bonded warehouse."),
    _101("101", "Country of first sale", "Name of country where firstly a sale took place."),
    _103("103", "Place of transfer", "Place at which goods are transferred from one carrier to another (contractual term)."),
    _104("104", "Place of deconsolidation", "Place where a large consignment is de-grouped into smaller consignments."),
    _105("105", "Place of consumption", "Place/location where goods enter the marketplace (commerce) of the importing country."),
    _106("106", "Region of origin", "Region in which the goods have been produced or manufactured according to the criteria laid down for the purposes of the application of the Customs tariff, of quantitative restrictions or of any other measures related to trade (see: 3238)."),
    _107("107", "Place of consolidation", "Place where smaller consignments of goods are grouped together into a large consignment to be transported as a larger unit."),
    _108("108", "Rate combination point", "Point over which sector rates are combined."),
    _109("109", "Place of prolongation decision of delivery delay", "Place where it has been decided to prolong the delivery delay."),
    _110("110", "Recharging place/location", "Place/location where a consignment has been changed of destination and is subject to a recharge note. (Complementary orders to modify the routing of the transport may be given, upon which a new charge calculation may be applied by the carrier)."),
    _111("111", "Customs office of despatch", "Customs office from which goods are despatched between countries of a Customs union."),
    _112("112", "Region of equipment availability", "Region in which a piece of equipment is requested to be made available for on-hire."),
    _113("113", "Country of despatch", "Country from which goods are despatched within a Customs union."),
    _114("114", "Customs office of export", "Customs office from which goods are taken out of the Customs territory (CCC)."),
    _115("115", "Free zone of export", "Foreign free zone (desc: see 1131 = 131) from which goods are exported to the country of importation."),
    _116("116", "Region of export/despatch", "Region from which the goods were initially exported to the importing country without any commercial transaction taking place in intermediate countries. Region of despatch: region from which goods are despatched between countries of a Customs union."),
    _117("117", "Place of collection", "Place where goods are to be or could be picked up (collected)."),
    _118("118", "Customs office of departure", "Customs office at which a Customs transit operation commences (CCC)."),
    _119("119", "Transit guarantee customs office location", "[3111] To identify the Customs office at which a security or guarantee for the movement of goods under a transit procedure is lodged."),
    _120("120", "Country of transhipment", "Country where goods are transferred under Customs control from the importing means of transport to the exporting means of transport within the area of one Customs office which is the office of both importation and exportation (CCC)."),
    _122("122", "Customs office of destination", "Customs office where the goods are to be cleared (CCC)."),
    _123("123", "Wagon-load railway station", "A railway station where rail wagons are loaded."),
    _124("124", "Siding", "A short railway track for loading or unloading rail wagons, or bypassing of trains, connected with a main track by switch."),
    _125("125", "Last place/port of call of conveyance", "Conveyance departed from this last foreign place/port of call to go to \"Place/port of conveyance initial arrival\" (87)."),
    _126("126", "Country of previous Customs procedure", "Country in which the Customs declaration for the previous Customs procedure has been lodged."),
    _127("127", "Customs office of registration of previous Customs declaration", "Customs office where the previous Customs declaration has been lodged."),
    _128("128", "Participant sender location", "Place where a participant in the movement of goods is located and can be contacted."),
    _129("129", "Wage negotiation district", "The district to which workers belong for the purposes of union wage negotiation."),
    _130("130", "Place of ultimate destination of conveyance", "Seaport, airport, freight terminal, rail station or other place to which a means of transport is ultimately destined."),
    _131("131", "Place of loading of empty equipment", "Seaport, airport, freight terminal, rail station or other place where empty equipment (e.g. containers) was loaded onto means of transport."),
    _132("132", "Place of discharge of empty equipment", "Seaport, airport, freight terminal, rail station or other place where empty equipment (e.g. containers) was unloaded from means of transport."),
    _133("133", "Region of delivery", "(3246) Region to which the goods are to be finally delivered under transport contract terms (operational term)."),
    _134("134", "Petroleum warehouse", "Bonded petroleum warehouse or the supplier source."),
    _135("135", "Place of entry (Customs)", "Place at which the goods enter the Customs territory."),
    _136("136", "Living animals care place", "Place where living animal cares are provided."),
    _137("137", "Re-icing place", "Place where re-icing must be executed."),
    _138("138", "Weighting place", "Place where weight can be ascertained."),
    _139("139", "Marshalling yard", "Station where the wagons are disconnected and reconnected to form a new train."),
    _140("140", "Stopping station", "Station where the train must stop or is stopped for unexpected handling."),
    _141("141", "Loading dock", "Platform specially equipped for loading and unloading of rail wagons."),
    _142("142", "Port connection", "Track connecting a rail station to a dock."),
    _143("143", "Place of expiry", "Place where the documentary credit expires for presentation of required documents."),
    _144("144", "Place of negotiation", "Place where the documentary credit is to be presented for negotiation."),
    _145("145", "Claims payable place", "Place where insurance claims are payable."),
    _146("146", "Documentary credit available in", "Place where the documentary credit is available with any bank."),
    _147("147", "Transport means stowage location", "[8043] To identify a location on board a means of transport where specified goods or transport equipment has been or are to be stowed."),
    _148("148", "For transportation to", "Place/country where goods are to be transported to."),
    _149("149", "Loading on board/despatch/taking in charge at/from", "Place/country where goods have to be loaded on board, despatched or taken in charge."),
    _150("150", "Container stack position", "Stack position of a container at a terminal, depot or freight station."),
    _151("151", "Private box", "A private box used for pick-up and delivery of packages, e.g. of express packages."),
    _152("152", "Next port of discharge", "Next port at which goods are discharged from the vessel used for their transport."),
    _153("153", "Port of call", "Port where a vessel has called upon or will call upon."),
    _154("154", "Place/location of on-hire", "Place/location where an object is contracted for use."),
    _155("155", "Place/location of off-hire", "Place/location where an object's contract for use ends."),
    _156("156", "Other carriers terminal", "A carrier terminal belonging to a carrier other than the original carrier."),
    _157("157", "Country of Value Added Tax (VAT) jurisdiction", "The country governing the VAT regulation to which the transaction is subject."),
    _158("158", "Contact location", "The site where a contact is located."),
    _159("159", "Additional internal destination", "Any location within the consignee's premises where the goods are moved to."),
    _160("160", "Foreign port of call", "A code to identify the foreign port where the vessel calls at or will call at."),
    _161("161", "Maintenance location", "A location where maintenance has been or will be performed."),
    _162("162", "Place or location of sale", "Place or location at which the sale takes place."),
    _163("163", "Direct investment country", "Country in which a direct investment is made or withdrawn."),
    _164("164", "Berth", "Location in port where the vessel is berthed or moored."),
    _165("165", "Construction country", "Country in which the construction work is made."),
    _166("166", "Donation acting country", "Country acting in the donation of aid."),
    _167("167", "Payment transaction country", "Country of the foreign counterpart of the payment transaction."),
    _168("168", "Physical place of return of item", "Physical place at which the item is returned, i.e. the location where the supplier receives the item form the customer."),
    _169("169", "Relay port", "A location where cargo is transferred from one means of transport to another means of transport owned or operated by the same carrier under the same bill of lading."),
    _170("170", "Final port of discharge", "Last port at which cargo is unloaded from a vessel before the cargo is moved to a place of delivery or destination."),
    _171("171", "Place of destination for pre-stacking prior to stowage", "The destination location for which items are to be pre-stacked prior to being stowed together on a means of transport."),
    _172("172", "Reporting location", "The location to which the information being reported is applicable."),
    _173("173", "Transport contract place of despatch", "A place from which goods are despatched as per transport contract."),
    _174("174", "Place of residence", "A place where a party lives."),
    _175("175", "Activity location", "A place at which the activity occurs."),
    _176("176", "Pick-up location", "Location for pick up."),
    _177("177", "Construction site", "A place at which construction works occur."),
    _178("178", "Place of embarkation", "Place where the object is put, or goes, on board the conveyance."),
    _179("179", "Place of disembarkation", "Place where the object or person disembarks from the conveyance."),
    _180("180", "Person birth location", "[3486] Name of the place where a person was born."),
    _181("181", "Registered office", "Identifies the place or location of a registered office."),
    _182("182", "Place of incorporation", "Identifies the location of incorporation."),
    _183("183", "Place of business", "Identifies the place or location of a business."),
    _184("184", "Physical location", "Identifies the physical location."),
    _185("185", "Location to send mail", "Identifies the location to which mail is sent."),
    _186("186", "Foreign registration location", "Identifies the place or location of foreign registration."),
    _187("187", "Tax filed from location", "Identifies the location from which taxes are filed."),
    _188("188", "Filing location", "Identifies the location of the filing entity."),
    _189("189", "Former location", "Identifies an earlier or previous place or location."),
    _190("190", "Head office", "Identifies the place or location of a head office."),
    _191("191", "Property", "Identifies the place or location of property."),
    _192("192", "Correct location", "Identifies the correct place or location."),
    _193("193", "Branch location", "Identifies the place or location of a branch."),
    _194("194", "Former registered location", "Identifies the former registered location of an entity."),
    _195("195", "Future location", "Location to be used in the future."),
    _196("196", "Changed to location", "Identifies the change to location."),
    _197("197", "Place of inquiry", "Place to which an inquiry is made."),
    _198("198", "Original location", "Identifies the original location."),
    _199("199", "Country of last source", "The country where a product or service was last sourced."),
    _200("200", "Place of handling", "Place where a handling operation is to be, or has been, performed."),
    _201("201", "Country of origin as defined by transportation agency", "Country of origin as defined by the transportation agency."),
    _202("202", "Terminal", "A terminus for transport vehicles."),
    _203("203", "Sample location", "Code identifying the location from which a sample is taken."),
    _204("204", "Hospital Advanced Dependency Unit (ADU)", "A designated unit in a hospital for advanced dependency nursing care."),
    _205("205", "Hospital Neonatal Intensive Care Unit (NICU)", "A designated unit in a hospital for the provision of intensive care to neonates."),
    _206("206", "Hospital Paediatric Care Unit (PCU)", "A designated unit in a hospital for the provision of care to paediatric patients."),
    _207("207", "Hospital Intensive Care Unit (ICU)", "An intensive care unit in a hospital."),
    _208("208", "Hospital luxury room", "A room in a hospital for patient accommodation of superior standard."),
    _209("209", "Hospital shared room", "A room in a hospital for shared accommodation of patients."),
    _210("210", "Hospital private room", "A room in a hospital for private accommodation of a patient."),
    _211("211", "Bidding area", "An area for which bids can be made with the same price applicable to the whole area."),
    _212("212", "Price area", "An area for which the same price is applicable to the whole area."),
    _213("213", "Country of destination of equipment", "Country of the last place where the equipment will stop."),
    _214("214", "Aircraft airport stand", "Code used to specify the airport stand allocated to the aircraft."),
    _215("215", "Airport passenger terminal", "Code used to specify the airport terminal used for the embarking or disembarking of passengers."),
    _216("216", "Previous berth", "Place or location in a port where a vessel was previously moored."),
    _217("217", "Next berth", "Place or location in a port where a vessel will be moored, after moving from the current location."),
    _218("218", "Entity location", "Identifies the place or location of the entity."),
    _219("219", "Goods depot", "Depot where goods are received and are available for pick-up."),
    _220("220", "Disinfecting place", "Place where disinfection has been or must be performed."),
    _221("221", "Harbour rail station", "Rail station servicing a harbour."),
    _222("222", "Place of live animal care", "Place where live animal care has been or must be provided."),
    _223("223", "Phytosanitary control place", "Place where phytosanitary control has been or must be performed."),
    _224("224", "Place for re-icing or de-icing", "Place where re-icing or de-icing has been or must be performed."),
    _225("225", "Place of refuelling", "Place where refuelling has been or must be performed."),
    _226("226", "Place of provision of an unexpected service", "Place where an unexpected service has been or must be provided."),
    _227("227", "Private container terminal", "Container terminal managed or owned by a private company."),
    _228("228", "Railway container terminal", "Container terminal managed or owned by a railway company."),
    _229("229", "Inspection site", "The site where an inspection takes or took place."),
    _230("230", "Request only stop", "A location where a stop is only made on request."),
    _231("231", "Grid area", "A section of a grid."),
    _232("232", "Source power area", "The area that is the source of power."),
    _233("233", "Sink power area", "The area that is the destination of power."),
    _234("234", "Scheduled berth", "Place or location in a port where a vessel is scheduled to be moored."),
    _235("235", "Scheduled berth, bow", "Place or location in a port where the bow of a vessel is scheduled to berth."),
    _236("236", "Scheduled berth, stern", "Place or location in a port where the stern of a vessel is scheduled to berth."),
    _237("237", "Balance settlement area", "An area where common rules for balance settlement applies."),
    _238("238", "Market area", "An area with common trading rules."),
    _239("239", "Metering grid area", "A physical area where consumption, production and exchange can be metered."),
    _240("240", "Climate zone", "A geographical area where the climate has common characteristics."),
    _241("241", "Country of birth", "Country where a person or an animal was born."),
    _242("242", "Country of fattening", "Country where an animal has been fattened."),
    _243("243", "Country of slaughter", "Country where an animal has been slaughtered."),
    _244("244", "Country of meat cutting", "Country where the meat is cut into pieces."),
    _245("245", "Meat cutting location", "A location where the meat is cut into pieces."),
    _246("246", "Slaughterhouse", "Place for the slaughter of animals as food."),
    _247("247", "Country of meat mincing", "Country where meat has been cut into very small pieces using a meat grinder."),
    _248("248", "Place of discharge and loading", "Place at which a means of transport is performing both discharge and loading operations, e.g. seaport, airport, freight terminal, rail station."),
    _249("249", "Cargo facility location", "Name of the terminal, warehouse or yard where the goods are to be on or offloaded."),
    _250("250", "Tourist point of interest", "Code to specify that the location is a tourist point of interest."),
    _251("251", "Customs office of payment", "Place where Customs duties/taxes/fees have to be paid."),
    _252("252", "Conveyance facility location at departure", "Name of the location of the last facility (e.g. terminal, warehouse or yard) from which the conveyance will depart."),
    _253("253", "Conveyance facility location at arrival", "Name of the location of the initial facility (e.g. terminal, warehouse or yard) where the conveyance will arrive."),
    _254("254", "Bus station", "Name or identification of a bus station."),
    _255("255", "Ferry terminal", "Name or identification of a ferry terminal."),
    _256("256", "Place of packing", "Place where goods are packaged."),
    _257("257", "Country of assembly", "Country where product is assembled."),
    _258("258", "Town sales office", "The location is a town sales office."),
    _259("259", "Travel agency", "The location is a travel agency."),
    _260("260", "Inland clearance depot", "Depot where goods are cleared by the customs authorities or other governmental authorities in the interior of a country."),
    _261("261", "Place of final production", "Place where the production of the item was finalised."),
    _262("262", "Place of growth", "Place where the product was grown."),
    _263("263", "Place of intermediate production", "Place of any processing prior to final production."),
    _264("264", "Place of nutrient origin", "Place where the nutrient, or item of nourishing food, originated."),
    _265("265", "Place of package material production", "Place where the material used for packaging was produced."),
    _266("266", "Place of processing", "The place where the commodity was processed."),
    _267("267", "Place of species origin", "The place where the species was taken from the wild, or the place where the species was born, artificially propagated, grown or harvested."),
    _268("268", "Place of catch", "Place where the animal was caught, e.g. area of the ocean where the fish was harvested."),
    _269("269", "Government appeal office", "The location of a government office at which an appeal can be lodged."),
    _270("270", "Regulatory office of cross-border goods entry", "To identify the regulatory office at which the goods enter or are intended to enter the customs territory of destination."),
    _271("271", "Regulatory office of cross-border goods exit", "To identify the regulatory office at which the goods leave or are intended to leave the customs territory of dispatch."),
    _272("272", "Government approved establishment", "Facility approved for a specific purpose by a government authority."),
    _273("273", "Free trade zone", "A special area of a country where some normal trade barriers (e.g. tariffs and quotas) are eliminated, a.k.a. foreign free zone."),
    _274("274", "Place of physical examination", "A place where goods are to be examined."),
    _275("275", "Permitted location", "The location at which goods identified on the license, permit, certificate or other document are allowed to be moved or otherwise handled."),
    _276("276", "Landing location", "The place where a means of transport may be parked or tied up, e.g. wharf, quay, railyard, parking lot."),
    _277("277", "Place of loading on final means of transport", "Place where a consignment is placed aboard the means of transport which enters the destination customs territory."),
    _278("278", "Place of regulatory declaration review", "Location where the declaration is reviewed by appropriate government agency."),
    _279("279", "Travel document issuing country or political entity", "The country or political entity issuing the travel document."),
    _280("280", "Compliant facility, registered", "A facility that has been formally documented as compliant with regulations or statutes by a regulatory authority."),
    _281("281", "Bonded warehouse", "A building or other secured area in which dutiable goods may be stored, manipulated, or undergo manufacturing operations without payment of duty."),
    _282("282", "Goods destruction site, designated", "A place designated for the destruction of goods."),
    _283("283", "Goods disposal location, designated", "A place designated for the disposal of goods."),
    _284("284", "Incineration facility", "Facility with a furnace or apparatus for consuming materials completely or reducing materials to ash by burning."),
    _285("285", "Laboratory", "A facility equipped for scientific experimentation, research, testing or determination."),
    _286("286", "Place of assembly", "Facility where product is assembled."),
    _287("287", "Processing site", "Place where an operation or a series of operations are performed in the making or treatment of a product."),
    _288("288", "Quarantine facility", "A place or station where isolation is carried out."),
    _289("289", "Reclamation facility", "A facility where desired substances are recovered from materials or goods."),
    _290("290", "Refinery", "An industrial plant for refining a substance, such as petroleum or sugar."),
    _291("291", "Smelter", "A facility where ores are fused or melted in order to separate the metal contained in them."),
    _292("292", "Prescribed treatment facility", "A facility where goods are subjected to a prescribed treatment."),
    _293("293", "Embassy", "The official headquarters of an ambassador or official diplomat sent by one sovereign or state to another as its resident representative."),
    _294("294", "Region of source", "Region where goods were originally produced."),
    _295("295", "Region of storage", "Region where products have been stored."),
    _296("296", "Ship security incident location", "Location for reporting any security related matter to indicate where the safety/security incident has taken place."),
    _297("297", "Ship-to-ship activity location", "Location where the ship-to-ship activity has taken place."),
    _298("298", "Country of last processing", "The country where the trade item was last processed."),
    ZZZ("ZZZ", "Mutually defined", "Place or location as agreed between the relevant parties.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_VERSION = "D10B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    private ELocationTypeCode21(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName, @Nullable final String sDescription) {
        m_sID = sID;
        m_sDisplayName = sDisplayName;
        m_sDescription = sDescription;
    }

    @Nonnull
    @Nonempty
    public String getID() {
        return m_sID;
    }

    @Nonnull
    public String getDisplayName() {
        return m_sDisplayName;
    }

    @Nullable
    public String getDescription() {
        return m_sDescription;
    }

    @Nullable
    public static ELocationTypeCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(ELocationTypeCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final ELocationTypeCode21 eValue = ELocationTypeCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
