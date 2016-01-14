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
package com.helger.ubl21.codelist;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;


/**
 * This file was automatically generated from Genericode file CargoTypeCode-2.1.gc. Do NOT edit!
 * It contains a total of 23 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 * 
 */
@CodingStyleguideUnaware
public enum ECargoTypeCode21
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "Documents", "Printed, typed or written matter including leaflets, pamphlets, certificates etc., which are not subject to import duties and taxes, restrictions and prohibitions."),
    _2("2", "Low value non-dutiable consignments", "Imported consignments/items/goods in respect of which Customs duties and other taxes are waived as they are below a value determined by the Customs administration."),
    _3("3", "Low value dutiable consignments", "Imported consignments/items/goods in respect of which Customs duties and other taxes are payable are below a certain amount as determined by the Customs administration."),
    _4("4", "High value consignments", "Imported consignments/items/goods which are determined as having a value above a certain amount fixed by the Customs administration, which may or may not attract duties and taxes."),
    _5("5", "Other non-containerized", "Non-containerized cargo which cannot be categorized by any of the other nature of cargo code."),
    _6("6", "Vehicles", "Vehicles which are not stowed in containers."),
    _7("7", "Roll-on roll-off", "Cargo transported or to be transported on roll-on roll-off vessels and which is transportable on its own wheels or stowed on special heavy duty trailers."),
    _8("8", "Palletized", "Non-containerized cargo which is palletized."),
    _9("9", "Containerized", "Cargo stowed or to be stowed in a container."),
    _10("10", "Breakbulk", "Non-containerized cargo stowed in vessels' holds."),
    _11("11", "Hazardous cargo", "Cargo with dangerous properties, according to appropriate dangerous goods regulations."),
    _12("12", "General cargo", "Cargo of a general nature, not otherwise specified."),
    _13("13", "Liquid cargo", "Cargo in liquid form."),
    _14("14", "Temperature controlled cargo", "Cargo transported under specified temperature conditions."),
    _15("15", "Environmental pollutant cargo", "Cargo is an environmental pollutant."),
    _16("16", "Not-hazardous cargo", "Cargo which is not hazardous."),
    _17("17", "Diplomatic", "Cargo transported under diplomatic conditions."),
    _18("18", "Military", "Cargo for military purposes."),
    _19("19", "Obnoxious", "Cargo that is objectionable to human senses."),
    _20("20", "Out of gauge", "Cargo that has at least one non-standard dimension."),
    _21("21", "Household goods and personal effects", "Cargo consisting of household goods and personal effects."),
    _22("22", "Frozen cargo", "Cargo of frozen products."),
    _23("23", "Ballast only", "No cargo, means of transport is carrying only ballast.");
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    private ECargoTypeCode21(
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
    public static ECargoTypeCode21 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(ECargoTypeCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(
        @Nullable
        final String sID) {
        final ECargoTypeCode21 eValue = ECargoTypeCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
