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
package com.helger.ubl21.codelist;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;


/**
 * This file was automatically generated from Genericode file TransportMeansTypeCode-2.1.gc. Do NOT edit!
 * It contains a total of 260 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum ETransportMeansTypeCode21
    implements IHasID<String> , IHasDisplayName
{
    _31("31", "Truck", "Automotive vehicle designed for hauling loads."),
    _32("32", "Truck, tanker", "Automotive vehicle with a tank."),
    _33("33", "Tractor", "Automotive vehicle with an engine designed for pulling."),
    _34("34", "Van", "Closed automotive vehicle designed for carrying freight."),
    _35("35", "Tiptanker", "Automotive vehicle designed with a tank lifting capability."),
    _36("36", "Truck, dry bulk", "Automotive vehicle designed for carrying dry bulk cargo."),
    _37("37", "Truck, container", "Automotive vehicle designed for carrying containers."),
    _38("38", "Carrier, car", "Automotive vehicle designed for carrying motorcars."),
    _39("39", "Truck, reefer", "Automotive vehicle designed for the carriage of frozen cargo."),
    _60("60", "Multimodal, type unknown", "Multimodal transport of unknown type."),
    _70("70", "Fixed transport installation, type unknown", "Fixed transport installation of unknown type."),
    _71("71", "Pipeline", "A line of one or more pipes for continuous transport of liquid or gas commodity."),
    _72("72", "Powerline", "A line of one or more cables or wires for continuous transport of electricity."),
    _80("80", "Vessel, type unknown", "Vessel of unknown type."),
    _81("81", "Motor freighter", "Motorized vessel designed for carrying general cargo."),
    _82("82", "Motor tanker", "Motorized vessel designed for carrying liquid cargo."),
    _83("83", "Container vessel", "Vessel designed for carrying containers."),
    _84("84", "Gas tanker", "Vessel with tanks designed for carrying gas."),
    _85("85", "Motor freighter, tug", "Motorized vessel designed for carrying cargo and capable of towing."),
    _86("86", "Motor tanker, tug", "Motorized vessel designed for carrying liquid cargo and capable of towing."),
    _87("87", "Motor freighter with one or more ships alongside", "Motorized vessel designed for carrying general cargo that has one or more vessels alongside."),
    _88("88", "Motor freighter with tanker", "Motorized vessel designed for carrying general cargo alongside a vessel designed for carrying liquid cargo."),
    _89("89", "Motor freighter pushing one or more freighters", "Motorized vessel designed for carrying general cargo, pushing one or more vessels also designed for carrying general cargo."),
    _150("150", "General cargo vessel", "Vessel designed to carry general cargo."),
    _151("151", "Unit carrier", "Vessel designed to carry unit loads"),
    _152("152", "Bulk carrier", "Vessel designed to carry bulk cargo."),
    _153("153", "Tanker", "Vessel solely equipped with tanks to carry cargo."),
    _154("154", "Liquefied gas tanker", "Tanker designed to carry liquefied gas."),
    _155("155", "Other special tanker", "Tanker designed to carry other special liquids."),
    _157("157", "Cargo and passenger vessel", "Vessel designed to carry cargo and passengers."),
    _159("159", "Passenger ship", "Vessel designed to carry more than 12 passengers."),
    _160("160", "Assistance vessel", "Vessel designed to give assistance."),
    _170("170", "Other sea-going vessel", "Sea-going vessel, not otherwise specified."),
    _172("172", "Work ship", "Vessel designed to assist in work."),
    _173("173", "Push boat", "Vessel designed to push other vessels."),
    _174("174", "Dredger", "Vessel designed to scoop or suck mud or sand."),
    _175("175", "Fishing boat", "Vessel designed for fishing."),
    _176("176", "Research and education ship", "Vessel designed for research and education."),
    _177("177", "Navy vessel", "Vessel operated by a Navy."),
    _178("178", "Structure, floating", "Any floating structure."),
    _180("180", "Pleasure boat", "Vessel designed for recreation."),
    _181("181", "Speedboat", "Vessel designed for speed, often used for recreation."),
    _182("182", "Sailing boat with auxiliary motor", "Vessel designed primarily for sailing outfitted with an auxiliary motor."),
    _183("183", "Sailing yacht", "A specific type of vessel mostly used for pleasure and designed for sailing."),
    _184("184", "Boat for sport fishing", "Vessel designed for sport fishing."),
    _185("185", "Craft, pleasure, longer than 20 metres", "Vessel longer than 20 metres, designed for recreation."),
    _189("189", "Craft, other, recreational", "Vessel designed for recreation, not otherwise specified."),
    _190("190", "Fast ship", "Fast, all-purpose vessel."),
    _191("191", "Hydrofoil", "Vessel with wing-like structure for skimming at high speed."),
    _192("192", "Catamaran, fast", "Fast vessel designed with two parallel hulls."),
    _210("210", "Train, railroad", "One or more rail wagons pulled or pushed by one or more locomotive units, or self-propelled, that move over rail tracks."),
    _220("220", "Train, passenger", "Train designed to carry passengers."),
    _230("230", "Train, freight", "Train for carrying freight."),
    _310("310", "Truck, mail", "Automotive vehicle designed for carrying mail."),
    _311("311", "Truck dump", "Automotive vehicle designed with a cargo-dumping capability."),
    _312("312", "Truck, forklift", "Automotive vehicle designed for lifting cargo and heavy objects."),
    _313("313", "Loader, shovel", "Automotive vehicle designed for shoveling sand and other bulk material."),
    _314("314", "Truck, platform, fixed", "Automotive vehicle designed with a fixed platform."),
    _315("315", "Carrier, straddle", "Automotive vehicle designed for lifting and transporting containers."),
    _320("320", "Crane, mobile", "Automotive vehicle with cargo crane."),
    _330("330", "Bus", "Automotive vehicle designed for carrying more than 8 passengers including the driver."),
    _341("341", "Van, delivery", "Automotive vehicle designed for making fast deliveries."),
    _342("342", "Van, light", "Automotive vehicle designed for light carriage."),
    _343("343", "Van, furniture", "Automotive vehicle designed for carrying furniture."),
    _360("360", "Tractor, industrial", "Automotive vehicle designed for towing one or more trailers."),
    _362("362", "Truck, freezer with isothermic trailer", "Automotive vehicle designed for carrying frozen goods with a trailer designed for carrying temperature-controlled goods."),
    _363("363", "Truck, isothermic with isothermic trailer", "Automotive vehicle with trailer designed to carry temperature-controlled goods."),
    _364("364", "Truck, refrigerated with isothermic trailer", "Automotive vehicle designed for carrying refrigerated goods with a trailer designed for carrying temperature-controlled goods."),
    _365("365", "Truck, freezer with refrigerated trailer", "Automotive vehicle designed for carrying frozen goods with a trailer designed for carrying refrigerated goods."),
    _366("366", "Truck, isothermic with refrigerated trailer", "Automotive vehicle designed to carry temperature-controlled goods with a trailer designed to carry refrigerated goods."),
    _367("367", "Truck, opening floor, with extendable trailer", "Automotive vehicle with an opening floor with an extendable trailer."),
    _368("368", "Truck, rigid, with tank and tank trailer", "Rigid automotive vehicle designed with a tank with a tank trailer."),
    _369("369", "Truck, bulk with tank trailer", "Automotive vehicle designed for bulk carrying with a tank trailer."),
    _370("370", "Truck, rigid with tank and bulk trailer", "Rigid automotive vehicle designed with a tank with a trailer capable of carrying bulk cargo and liquid."),
    _371("371", "Truck, bulk with bulk trailer", "Automotive vehicle and trailer both designed for carrying bulk cargo."),
    _372("372", "Truck, tautliner with extendable trailer", "Automotive tautliner vehicle with extendable trailer."),
    _373("373", "Truck, tautliner with removable roof and extendable trailer", "Automotive tautliner vehicle with removable roof and extendable trailer."),
    _374("374", "Truck, bulk truck with extendable trailer", "Automotive vehicle designed for carrying bulk cargo with an extendable trailer."),
    _375("375", "Truck, refrigerated with freezer trailer", "Automotive vehicle designed for carrying refrigerated goods with a trailer designed for carrying frozen goods."),
    _376("376", "Truck, isothermic with freezer trailer", "Automotive vehicle designed for carrying temperature-controlled goods with a trailer designed for carrying frozen goods."),
    _377("377", "Truck, furniture with trailer", "Automotive vehicle designed for carrying furniture with a trailer."),
    _378("378", "Truck, tautliner with furniture trailer", "Automotive tautliner vehicle with trailer designed for carrying furniture."),
    _379("379", "Truck, tautliner, removable roof with furniture trailer", "Automotive tautliner vehicle designed with a removable roof with a trailer designed for carrying furniture."),
    _380("380", "Truck, tip-up with gondola trailer", "Automotive vehicle designed with a tip-up capability with a gondola trailer."),
    _381("381", "Truck, tautliner with gondola trailer", "Automotive tautliner vehicle with a gondola trailer."),
    _382("382", "Truck, tautliner, with removable roof and gondola trailer", "Automotive tautliner vehicle with removable roof and a gondola trailer."),
    _383("383", "Truck, opening-floor with gondola trailer", "Automotive vehicle with an opening floor and with a gondola trailer."),
    _384("384", "Truck, bulk with gondola trailer", "Automotive vehicle designed for carrying bulk cargo with a gondola trailer."),
    _385("385", "Truck, tip-up with extendable gondola trailer", "Automotive vehicle designed with a tip-up capability with an extendable gondola trailer."),
    _386("386", "Truck, tautliner with extendable gondola trailer", "Automotive tautliner vehicle with an extendable gondola trailer."),
    _387("387", "Truck, tautliner, removable roof with extendable gondola trailer", "Automotive tautliner vehicle designed with a removable roof and with an extendable gondola trailer."),
    _388("388", "Truck, opening floor with extendable gondola trailer", "Automotive tautliner vehicle designed with an opening floor and with an extendable gondola trailer."),
    _389("389", "Truck, bulk with extendable gondola trailer", "Automotive vehicle designed for carrying bulk cargo with an extendable gondola trailer."),
    _390("390", "Truck, tip-up truck with opening-floor trailer", "Automotive vehicle designed with a tip-up capability with an opening-floor trailer."),
    _391("391", "Truck, tautliner with opening-floor trailer", "Automotive tautliner vehicle with opening-floor trailer."),
    _392("392", "Truck, tautliner, removable roof, with opening-floor trailer", "Automotive tautliner vehicle with a removable roof, with an opening-floor trailer."),
    _393("393", "Truck, opening-floor with opening-floor trailer", "Automotive vehicle and trailer both with opening floors."),
    _394("394", "Truck, bulk truck with opening-floor trailer", "Automotive vehicle designed for carrying bulk cargo with an opening-floor trailer."),
    _395("395", "Truck, with trailer", "Automotive vehicle designed to pull a trailer, with a trailer attached."),
    _396("396", "Truck, tilt, with tilt trailer", "Automotive vehicle with a tilt capability with a trailer also with a tilt capability."),
    _397("397", "Truck, refrigerated, with refrigerated trailer", "Automotive vehicle designed to carry refrigerated goods with a trailer also capable of carrying refrigerated goods."),
    _398("398", "Truck, freezer with freezer trailer", "Automotive vehicle capable of carrying frozen goods with a trailer also capable of carrying frozen goods."),
    _399("399", "Truck, removal with removal trailer", "Automotive vehicle designed to carry household effects with a trailer also capable of carrying household effects."),
    _810("810", "Motor freighter pushing at least one tank-ship", "Motorized vessel designed for carrying general cargo, pushing at least one vessel designed to carry liquid cargo."),
    _811("811", "Tug, freighter", "Vessel designed to push or pull another vessel that is also capable of carrying general cargo."),
    _812("812", "Tug, tanker", "Vessel designed to push or pull another vessel also capable of carrying liquid cargo."),
    _813("813", "Tug, freighter, coupled", "Vessel designed to push or pull another vessel that is also capable of carrying general cargo tied to one or more other vessels."),
    _814("814", "Tug, freighter/tanker, coupled", "Vessel designed to push or pull another vessel that is also capable of carrying either general or liquid cargo tied to one or more other vessels."),
    _815("815", "Freightbarge", "Lighter designed for carrying general cargo."),
    _816("816", "Tankbarge", "Lighter designed for carrying liquid cargo."),
    _817("817", "Freightbarge with containers", "Lighter designed for carrying containers."),
    _818("818", "Tankbarge, gas", "Lighter designed for carrying gas."),
    _821("821", "Pushtow, one cargo barge", "Vessel designed for pushing/towing, facilitating the movement of one cargo barge."),
    _822("822", "Pushtow, two cargo barges", "Combination designed for pushing/towing, facilitating the movement of two cargo barges."),
    _823("823", "Pushtow, three cargo barges", "Combination designed for pushing/towing, facilitating the movement of three cargo barges."),
    _824("824", "Pushtow, four cargo barges", "Combination designed for pushing/towing, facilitating the movement of four cargo barges."),
    _825("825", "Pushtow, five cargo barges", "Combination designed for pushing/towing, facilitating the movement of five cargo barges."),
    _826("826", "Pushtow, six cargo barges", "Combination designed for pushing/towing, facilitating the movement of six cargo barges."),
    _827("827", "Pushtow, seven cargo barges", "Combination designed for pushing/towing, facilitating the movement of seven cargo barges."),
    _828("828", "Pushtow, eight cargo barges", "Combination designed for pushing/towing, facilitating the movement of eight cargo barges."),
    _829("829", "Pushtow, nine cargo barges", "Combination designed for pushing/towing, facilitating the movement of nine or more cargo barges."),
    _831("831", "Pushtow, one gas/tank barge", "Combination designed for pushing/towing, moving one tanker or gas barge."),
    _832("832", "Pushtow, two barges at least one tanker or gas barge", "Combination designed for pushing/towing, moving two barges of which at least one tanker or gas barge."),
    _833("833", "Pushtow, three barges at least one tanker or gas barge", "Combination designed for pushing/towing, moving three barges of which at least one is a tanker or gas barge."),
    _834("834", "Pushtow, four barges at least one tanker or gas barge", "Combination designed for pushing/towing, moving four barges of which at least one is a tanker or gas barge."),
    _835("835", "Pushtow, five barges at least one tanker or gas barge", "Combination designed for pushing/towing, moving five barges of which at least one is a tanker of gas barge."),
    _836("836", "Pushtow, six barges at least one tanker or gas barge", "Combination designed for pushing/towing, moving six barges of which at least one is a tanker or gas barge."),
    _837("837", "Pushtow, seven barges at least one tanker or gas barge", "Combination designed for pushing/towing, moving seven barges of which at least one is a tanker or gas barge."),
    _838("838", "Pushtow, eight barges at least one tanker or gas barge", "Combination designed for pushing/towing, moving eight barges of which at least one is a tanker or gas barge."),
    _839("839", "Pushtow, nine or more barges at least one tanker or gas barge", "Combination designed for pushing/towing, moving nine or more barges of which at least one is a tanker or gas barge."),
    _840("840", "Tug, single", "Vessel designed for pushing another vessel that is the only boat used for a tow."),
    _841("841", "Tug, one or more tows", "Vessel designed for pushing another vessel that is involved in one or more concurrent tows."),
    _842("842", "Tug, assisting a vessel or linked combination", "Vessel designed for pushing another vessel that is assisting one vessel or a combination of vessels or tugs and vessels."),
    _843("843", "Pushboat, single", "Vessel designed for pushing."),
    _844("844", "Passenger ship, ferry, red cross ship, cruise ship", "Vessels designed for carrying passengers."),
    _845("845", "Service vessel, police patrol, port services", "Vessel designed to perform a specific dedicated service."),
    _846("846", "Vessel, work maintenance craft, floating derrick, cable-ship, buoy-ship, dredge", "Vessel designed to perform a specific type of work."),
    _847("847", "Object, towed, not otherwise specified", "An object in tow that is not otherwise specified."),
    _848("848", "Fishing boat", "Vessel designed for fishing."),
    _849("849", "Bunkership", "Vessel designed for carrying and delivering bunkers."),
    _850("850", "Barge, tanker, chemical", "Vessel designed to carry liquid or bulk chemicals."),
    _851("851", "Object, not otherwise specified", "A floating object that is not otherwise specified."),
    _852("852", "Service vessel", "A tender (vessel for logistical support), dealing with the transport of small material and maintenance requirements outside the port area on rivers and other inland waterways."),
    _853("853", "Police patrol vessel", "A vessel for the supervision by police of applicable rules and regulations."),
    _854("854", "Port service vessel", "A port tender (vessel for logistical support), dealing with the transport of material and people within a port area."),
    _855("855", "Navigation surveillance vessel", "A vessel of the competent authority (waterway) dealing with the surveillance of navigation."),
    _1501("1501", "Grain vessel", "Vessel designed to carry grain."),
    _1502("1502", "Timber/log carrier", "Vessel designed to carry logs and timber."),
    _1503("1503", "Wood chips vessel", "Vessel designed to carry wood chips."),
    _1504("1504", "Steel products vessel", "Vessel designed to carry steel products."),
    _1505("1505", "Carrier, general cargo/container", "Vessel designed to carry general cargo and containers."),
    _1506("1506", "Temperature controlled cargo vessels", "Vessel designed to carry temperature-controlled cargo."),
    _1511("1511", "Full container ship/cellular vessel", "Vessel designed to carry containers only."),
    _1512("1512", "RoRo vessel", "Vessel with ramp designed to carry roll-on/roll-off cargo."),
    _1513("1513", "Car carrier", "Vessel designed to carry automotive vehicles or their knock-down parts."),
    _1514("1514", "Livestock carrier", "Vessel designed to carry livestock."),
    _1515("1515", "Barge carrier - Lash ship", "Vessel designed to carry barges. Lash means lighters aboard ship."),
    _1516("1516", "Chemical carrier", "Vessel designed to carry chemicals in bulk or drums not in tanks."),
    _1517("1517", "Irradiated fuel carrier", "Vessel designed to carry irradiated fuel."),
    _1518("1518", "Heavy cargo vessel", "Ship designed to carry heavy cargo."),
    _1519("1519", "RoRo/Container vessel", "Vessel designed to carry both containers and roll-on/roll-off cargo."),
    _1521("1521", "Dry bulk carrier", "Vessel designed to carry dry bulk (expellers)."),
    _1522("1522", "Ore carrier", "Vessel designed to carry ore."),
    _1523("1523", "Cement carrier", "Vessel designed to carry cement."),
    _1524("1524", "Gravel carrier", "Vessel designed to carry gravel."),
    _1525("1525", "Coal carrier", "Vessel designed to carry coal."),
    _1531("1531", "Crude oil tanker", "Tanker designed to carry crude oil."),
    _1532("1532", "Chemical tanker, coaster", "Tanker designed to carry chemicals in coastal traffic."),
    _1533("1533", "Chemical tanker, deep sea", "Tanker designed to carry chemicals in deep sea."),
    _1534("1534", "Oil and other derivatives tanker", "Tanker designed to carry oil and other derivatives."),
    _1541("1541", "LPG tanker", "Vessel designed to carry Liquefied Petroleum Gas (LPG)."),
    _1542("1542", "LNG tanker", "Tanker designed to carry Liquefied Natural Gas (LNG)."),
    _1543("1543", "LNG/LPG tanker", "Tanker designed to carry Liquefied Natural Gas (LNG) and Liquefied Petroleum Gas (LPG)."),
    _1551("1551", "Asphalt/bitumen tanker", "Tanker designed asphalt and bitumen."),
    _1552("1552", "Molasses tanker", "Tanker designed to carry molasses."),
    _1553("1553", "Vegetable oil tanker", "Tanker designed to carry vegetable oil."),
    _1591("1591", "Cruise ship", "Passenger ship designed to carry tourists on specified routes."),
    _1592("1592", "Ferry", "Vessel designed to ply regularly between two or more ports."),
    _1593("1593", "Other passenger ship", "Vessel designed to carry passengers, not otherwise specified."),
    _1594("1594", "Passenger ship, sailing", "Vessel designed to carry passengers and mainly propelled by sails."),
    _1601("1601", "Tug, without tow", "Vessel designed to tow objects but sailing alone."),
    _1602("1602", "Tug, with tow", "Vessel designed to tow, and towing an object."),
    _1603("1603", "Salvage vessel", "Vessel designed to salvage."),
    _1604("1604", "Rescue vessel", "Vessel designed to effect rescue operations."),
    _1605("1605", "Oil combat vessel", "Vessel designed to combat oil spills."),
    _1606("1606", "Oil rig", "Object designed for drilling oil at sea."),
    _1607("1607", "Hospital vessel", "Vessel designed to serve as a hospital at sea."),
    _1711("1711", "Pilot boat", "Vessel designed to convey pilots to/from ships."),
    _1712("1712", "Patrol/measure ship", "Vessel designed to guard, patrol or measure."),
    _1721("1721", "Supply vessel", "Vessel designed to provide supplies."),
    _1723("1723", "Offshore support vessel", "Vessel designed to provide offshore support."),
    _1724("1724", "Pontoon", "Flat-bottomed vessel with a flat deck."),
    _1725("1725", "Stone dumping vessel", "Vessel designed to dump stones."),
    _1726("1726", "Cable layer", "Vessel designed to lay cable."),
    _1727("1727", "Buoyage vessel", "Vessel designed to handle buoys."),
    _1728("1728", "Icebreaker", "Vessel designed to break ice."),
    _1729("1729", "Pipelaying vessel", "Vessel designed to lay pipe."),
    _1751("1751", "Trawler", "Vessel designed to drag a bag-like net."),
    _1752("1752", "Cutter", "Small vessel that sometimes can be carried on a larger ship."),
    _1753("1753", "Factory ship", "Vessel designed as a fish factory."),
    _1761("1761", "Fishery research vessel", "Vessel designed for fishery research."),
    _1762("1762", "Climate registration vessel", "Vessel designed for climate registration."),
    _1763("1763", "Ship for environmental measurement", "Vessel designed for environmental monitoring and measurement."),
    _1764("1764", "Scientific vessel", "Vessel designed for scientific purposes."),
    _1765("1765", "Sailing school ship", "Vessel designed for training, powered by sail."),
    _1766("1766", "Training vessel", "Vessel designed for training."),
    _1781("1781", "Crane, floating", "A crane mounted on a barge or pontoon."),
    _1782("1782", "Dock, floating", "A submersible floating structure used as a dock."),
    _2201("2201", "Train, super express", "Train designed for high speed."),
    _2202("2202", "Train, sleeper", "Passenger train that includes carriages for sleeping."),
    _2203("2203", "Train, passenger, hired group", "A chartered train."),
    _2301("2301", "Blocktrain", "Train for carrying freight to the same destination."),
    _2302("2302", "Train, container", "Train for carrying containers."),
    _2303("2303", "Train, with one wagon", "Train with a single wagon for carrying freight."),
    _2304("2304", "Train, with more than one and less than 20 wagons", "Train with more than one and less than 20 wagons for carrying freight."),
    _2305("2305", "Train, with more than 20 wagons", "Train with more than 20 wagons for carrying freight."),
    _3100("3100", "Truck, tautliner with removal trailer", "Automotive tautline truck with trailer capable of carrying household effects."),
    _3101("3101", "Truck, tautliner with removable roof and removal trailer", "Automotive tautline vehicle with removable roof and a trailer capable of carrying household effects."),
    _3102("3102", "Car, with caravan", "Automobile towing a house trailer."),
    _3103("3103", "Truck, tautliner, 25 tonne", "Automotive tautline vehicle with a 25 tonne capacity."),
    _3104("3104", "Truck, tautliner, 25 tonne with removable roof", "Automotive tautline vehicle with a 25 tonne capacity and a removable roof."),
    _3105("3105", "Lorry, articulated, flat bed, 25 tonne", "Articulated automotive vehicle with a flat bed and 25 tonne capacity."),
    _3106("3106", "Lorry, articulated, flat bed, 24 tonne, with 10 metre crane", "Articulated automotive vehicle with a flat bed and 25 tonne capacity with a 10 metre crane attached."),
    _3107("3107", "Lorry, articulated, flat bed, 24 tonne, with 15 metre crane", "Articulated automotive vehicle with a flat bed and 25 tonne capacity with a 15 metre crane attached."),
    _3108("3108", "Lorry, articulated, flat bed, 24 tonne, with 18 metre crane", "Articulated automotive vehicle with a flat bed and 25 tonne capacity with an 18 metre crane attached."),
    _3109("3109", "Lorry, articulated, flat bed, 10 tonne", "Articulated automotive vehicle with a flat bed and 10 tonne capacity."),
    _3110("3110", "Truck, tautliner, 25 tonne, with 90 cubic metre trailer", "Automotive tautline vehicle with a 25 tonne capacity and a 90 cubic metre trailer."),
    _3111("3111", "Truck, tautliner, 25 tonne, with 120 cubic metre trailer", "Automotive tautline vehicle with a 25 tonne capacity and a 120 cubic metre trailer."),
    _3112("3112", "Lorry, flat with trailer and 10 metre crane", "Automotive vehicle with flat bed and trailer and 10 metre crane."),
    _3113("3113", "Lorry, articulated with tank", "Articulated automotive vehicle with tank designed for carrying liquid or bulk goods."),
    _3114("3114", "Lorry, flat, 15 tonne", "Automotive vehicle with flat bed and a 15 tonne capacity."),
    _3115("3115", "Lorry, flat, 15 tonne with crane", "Automotive vehicle with flat bed and a 15 tonne capacity and attached crane."),
    _3116("3116", "Truck, isothermic", "Automotive vehicle designed to carry temperature-controlled goods."),
    _3117("3117", "Truck, refrigerated", "Automotive vehicle designed to carry refrigerated goods."),
    _3118("3118", "Van, freezer", "Automotive vehicle designed to carry frozen goods."),
    _3119("3119", "Van, isothermic", "Automotive vehicle designed to carry temperature-controlled goods."),
    _3120("3120", "Van, refrigerated", "Automotive vehicle designed to carry refrigerated goods."),
    _3121("3121", "Truck, bulk", "Automotive vehicle designed to carry bulk goods."),
    _3122("3122", "Truck, tip-up", "Automotive vehicle designed with a tip-up capability."),
    _3123("3123", "Truck, articulated, tip-up", "Articulated automotive vehicle designed with a tip-up capability."),
    _3124("3124", "Truck, rigid, with tank", "Rigid automotive vehicle designed with a tank."),
    _3125("3125", "Truck, tautliner", "Automotive vehicle with non-rigid sides."),
    _3126("3126", "Truck, tautliner, with removable roof", "Automotive tautline vehicle with a removable roof."),
    _3127("3127", "Truck, with opening floor", "Automotive vehicle with a floor that can be opened."),
    _3128("3128", "Truck, freezer", "Automotive vehicle designed to carry frozen goods."),
    _3129("3129", "Truck, with crane for moving goods, without trailer", "A truck with a crane for moving goods, without a trailer."),
    _3130("3130", "Truck, with crane for moving goods, with trailer", "A truck with a crane for moving goods, with a trailer."),
    _3131("3131", "Truck, with crane for lifting goods, without trailer", "A truck with a crane for lifting goods, without a trailer."),
    _3132("3132", "Truck, with crane for lifting goods, with trailer", "A truck with a crane for lifting goods, with a trailer."),
    _3133("3133", "Taxi cab", "Automotive vehicle licensed to ply for hire."),
    _3134("3134", "Truck, furniture", "Automotive vehicle designed for carrying furniture."),
    _3135("3135", "Truck, hydrant", "Automotive vehicle designed for the delivery of fuel from a fixed installation to a means of transport."),
    _3136("3136", "Car", "Automotive vehicle designed to carry a small number of passengers."),
    _3137("3137", "Truck, with tail-lift", "Automotive vehicle with a hydraulic lifting device on the rear of the vehicle for loading and unloading goods."),
    _3138("3138", "Armoured vehicle", "Automotive vehicle designed with fortified body for enhanced protection."),
    _3201("3201", "Car, elevator", "Automotive vehicle with raisable work platform."),
    _3301("3301", "Bus, with trailer", "Automotive vehicle with an attached trailer for carrying passengers and/or luggage."),
    _3302("3302", "Bus, highway", "Automotive vehicle designed for highway travel."),
    _3303("3303", "Bus, sightseeing", "Automotive vehicle designed for sightseeing."),
    _3304("3304", "Bus, airport/city", "Automotive vehicle designed to carry passengers and their baggage between an airport and a city and return.");
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    private ETransportMeansTypeCode21(
        @Nonnull
        @Nonempty
        final String sID,
        @Nonnull
        final String sDisplayName,
        @Nullable
        final String sDescription) {
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
    public static ETransportMeansTypeCode21 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(ETransportMeansTypeCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(
        @Nullable
        final String sID) {
        final ETransportMeansTypeCode21 eValue = ETransportMeansTypeCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
