/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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
 * This file was automatically generated from Genericode file
 * TransportEquipmentTypeCode-2.1.gc. Do NOT edit! It contains a total of 63
 * entries!
 * 
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum ETransportEquipmentTypeCode21 implements IHasID <String>, IHasDisplayName
{
  AA ("AA", "Ground equipment", "Ground equipment being fuelled or serviced."),
  AB ("AB", "Chain", "Chain used in the securing of cargo."),
  AD ("AD", "Temperature recorder", "Temperature recorder to provide a record of the actual temperature."),
  AE ("AE", "Body trailer", "The part of the vehicle where the cargo is loaded."),
  AG ("AG", "Slipsheet", "A cardboard platform used for holding product for storage or transportation."),
  AH ("AH", "No special equipment needed", "A code to indicate that there is no special equipment needed."),
  AI ("AI", "Vessel hold", "A compartment forming part of a transport vessel."),
  AJ ("AJ", "Flat rack", "Type of open container used for carrying objects."),
  AK ("AK", "Aircraft", "To indicate that the equipment is an aircraft."),
  AL ("AL", "Medical device", "A device used for medical purposes."),
  AM ("AM", "Refrigerated container", "A refrigerated (reefer) container that is actively cooling the product."),
  AN ("AN", "Synthetic pallet 80*120cm", "A pallet with standard dimensions 80*120 centimetres made of synthetic material."),
  AO ("AO", "Synthetic pallet 100*120cm", "A standard pallet with standard dimensions 100*120 centimetres made of synthetic material."),
  AP ("AP", "Clothing hanger rack", "Equipment used to store and transport clothing in a hanging position."),
  AQ ("AQ", "Road/rail trailer", "Trailer designated for combined road/rail use."),
  AT ("AT", "Overhang wagon", "Empty rail wagon added to the loaded wagons, when goods are longer than the loaded wagon."),
  BL ("BL", "Blocks", "A piece of equipment that is normally a piece of wood to fix cargo (e.g. coils) during transport."),
  BPN ("BPN", "Box pallet non-exchangeable", "A box pallet which cannot be exchanged."),
  BPO ("BPO", "Truck being transported", "A road vehicle capable of carrying goods which is being carried on another means of transport."),
  BPP ("BPP",
       "Truck and trailer combination being transported",
       "A road vehicle capable of carrying goods with an attached trailer which is being carried on another means of transport."),
  BPQ ("BPQ",
       "Tractor and trailer being transported",
       "A trailer accompanied by a self-propelling tractor unit which is being carried on another means of transport."),
  BPR ("BPR", "Postal bag", "Bag intended primarily for the conveyance of postal items."),
  BPS ("BPS",
       "Letter Tray",
       "Tray intended primarily for the conveyance of letter mail items of size slightly exceeding C5, in which the items are stood on their long edge."),
  BPT ("BPT", "Roller Cage", "Wheeled wire cage."),
  BPU ("BPU",
       "Flats Tray",
       "Tray intended primarily for the conveyance of letter mail items of from C5 up to in excess of C4, in which the items are stacked one on top of another. May also be used for letter mail smaller items stood on their long edge."),
  BPV ("BPV",
       "Out of bag parcel",
       "Postal item which is conveyed individually, with only the wrapping provided by the mailer for protection."),
  BPW ("BPW",
       "Wheeled Platform",
       "Device, consisting of a flat surface mounted on a wheels, which is designed for the conveyance of items which may safely be stacked. Normally also equipped with a handle to allow the device to be easily manoeuvred."),
  BPX ("BPX",
       "Container non-compliant with the Customs Convention on Containers",
       "The container is not compliant with the Customs Convention on Containers."),
  BPY ("BPY", "Box pallet EUR Y non exchangeable", "A euro-pallet of type Y that may not be exchanged."),
  BPZ ("BPZ", "Roll Pallet 1", "80 X 60 cm pallet on casters."),
  BR ("BR",
      "Barge",
      "Flat bottomed inland cargo vessel for canals and rivers with or without own propulsion for the purpose of transported goods. (Synonym: Lighter)."),
  BX ("BX", "Boxcar", "An enclosed railway goods wagon."),
  CH ("CH", "Chassis", "A wheeled carriage onto which an ocean container is mounted for inland conveyance."),
  CN ("CN",
      "Container",
      "Equipment item as defined by ISO for transport. It must be of: A) permanent character, strong enough for repeated use; B) designed to facilitate the carriage of goods, by one or more modes of transport, without intermediate reloading; C) fitted with devices for its ready handling, particularly."),
  DPA ("DPA", "Deadlight (panel)", "A set of panels fixed inside a porthole."),
  DPB ("DPB", "Roll Pallet 2", "120 X 60 cm pallet on casters."),
  EFP ("EFP", "Exchangeable EUR flat pallet", "A flat euro-pallet that may be exchanged."),
  EYP ("EYP", "Exchangeable EUR Y box pallet", "A euro-pallet of type Y that may be exchanged."),
  FPN ("FPN", "Flat pallet EUR non exchangeable", "A flat euro-pallet that may not be exchanged."),
  FPR ("FPR", "Flat pallet (railway property) non-exchangeable", "A non-exchangeable flat pallet owned by a railroad."),
  IL ("IL", "Lidded stackable rigid tray (CEN TS 14482:2002)", "Lidded stackable rigid tray compliant with CEN TS 14482:2002."),
  LAR ("LAR", "Lashing rope", "A rope for lashing cargo."),
  LU ("LU",
      "Load/unload device on equipment",
      "A mechanical device used in the loading and/or unloading of cargo into and from transport equipment."),
  MPA ("MPA", "Movable panel", "A panel which can be moved."),
  PA ("PA", "Pallet", "A platform on which goods can be stacked in order to facilitate the movement by a forklift or sling."),
  PBP ("PBP", "Identified private box pallet", "A box pallet identified as being privately owned."),
  PFP ("PFP", "Identified private flat pallet", "A flat pallet identified as being privately owned."),
  PL ("PL", "Platform", "A piece of equipment normally having a flat surface, or prepared for carrying cargo with a specific shape."),
  PPA ("PPA", "Protecting panel", "A panel used for protection."),
  PST ("PST", "Portable stove", "A portable heating unit."),
  RF ("RF", "Flat car", "A railway wagon without raised sides or ends."),
  RG ("RG", "Reefer generator", "A generator used to control the temperature in temperature-controlled transport equipment."),
  RGF ("RGF", "Ground facility", "Storage tank or facility capable of receiving shipment of goods or commodity."),
  RO ("RO", "Rope", "Rope used in the securing of cargo."),
  RR ("RR", "Rail car", "To identify that the equipment is a rail car."),
  SPP ("SPP", "Identified special pallet", "A pallet identified as special."),
  STR ("STR", "Strap", "A narrow strip of flexible material."),
  SW ("SW", "Swap body", "Rectangular equipment unit without wheels, which can be mounted on a chassis or positioned on legs."),
  TE ("TE", "Trailer", "A vehicle without motive power, designed for the carriage of cargo and to be towed by a motor vehicle."),
  TP ("TP", "Tarpaulin", "Waterproof material, e.g. canvas, to spread over cargo to protect it from getting wet."),
  TS ("TS",
      "Tackles",
      "Identification of loading tackle used (sheets, ropes, chains, etc.), as specified in DCU 9 to CIM Article 13; and of containers, as specified in Articles 5 and 10 of Annex III to CIM (CIM 17)."),
  TSU ("TSU", "Tarpaulin support", "A device to support a tarpaulin."),
  UL ("UL", "ULD (Unit load device)", "An aircraft container or pallet.");

  private final String m_sID;
  private final String m_sDisplayName;
  private final String m_sDescription;

  private ETransportEquipmentTypeCode21 (@Nonnull @Nonempty final String sID,
                                         @Nonnull final String sDisplayName,
                                         @Nullable final String sDescription)
  {
    m_sID = sID;
    m_sDisplayName = sDisplayName;
    m_sDescription = sDescription;
  }

  @Nonnull
  @Nonempty
  public String getID ()
  {
    return m_sID;
  }

  @Nonnull
  public String getDisplayName ()
  {
    return m_sDisplayName;
  }

  @Nullable
  public String getDescription ()
  {
    return m_sDescription;
  }

  @Nullable
  public static ETransportEquipmentTypeCode21 getFromIDOrNull (@Nullable final String sID)
  {
    return EnumHelper.getFromIDOrNull (ETransportEquipmentTypeCode21.class, sID);
  }

  @Nullable
  public static String getDisplayNameFromIDOrNull (@Nullable final String sID)
  {
    final ETransportEquipmentTypeCode21 eValue = ETransportEquipmentTypeCode21.getFromIDOrNull (sID);
    return ((eValue == null) ? null : eValue.getDisplayName ());
  }
}
