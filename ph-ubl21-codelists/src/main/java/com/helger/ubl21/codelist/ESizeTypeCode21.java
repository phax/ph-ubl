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

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * This file was automatically generated from Genericode file SizeTypeCode-2.1.gc. Do NOT edit!
 * It contains a total of 40 entries!
 * @author com.helger.ubl21.supplementary.tools.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum ESizeTypeCode21
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "Dime coated tank", "A tank coated with dime."),
    _2("2", "Epoxy coated tank", "A tank coated with epoxy."),
    _6("6", "Pressurized tank", "A tank capable of holding pressurized goods."),
    _7("7", "Refrigerated tank", "A tank capable of keeping goods refrigerated."),
    _9("9", "Stainless steel tank", "A tank made of stainless steel."),
    _10("10", "Nonworking reefer container 40 ft", "A 40 foot refrigerated container that is not actively controlling temperature of the product."),
    _12("12", "Europallet", "80 x 120 cm."),
    _13("13", "Scandinavian pallet", "100 x 120 cm."),
    _14("14", "Trailer", "Non self-propelled vehicle designed for the carriage of cargo so that it can be towed by a motor vehicle."),
    _15("15", "Nonworking reefer container 20 ft", "A 20 foot refrigerated container that is not actively controlling temperature of the product."),
    _16("16", "Exchangeable pallet", "Standard pallet exchangeable following international convention."),
    _17("17", "Semi-trailer", "Non self propelled vehicle without front wheels designed for the carriage of cargo and provided with a kingpin."),
    _18("18", "Tank container 20 feet", "A tank container with a length of 20 feet."),
    _19("19", "Tank container 30 feet", "A tank container with a length of 30 feet."),
    _20("20", "Tank container 40 feet", "A tank container with a length of 40 feet."),
    _21("21", "Container IC 20 feet", "A container owned by InterContainer, a European railway subsidiary, with a length of 20 feet."),
    _22("22", "Container IC 30 feet", "A container owned by InterContainer, a European railway subsidiary, with a length of 30 feet."),
    _23("23", "Container IC 40 feet", "A container owned by InterContainer, a European railway subsidiary, with a length of 40 feet."),
    _24("24", "Refrigerated tank 20 feet", "A refrigerated tank with a length of 20 feet."),
    _25("25", "Refrigerated tank 30 feet", "A refrigerated tank with a length of 30 feet."),
    _26("26", "Refrigerated tank 40 feet", "A refrigerated tank with a length of 40 feet."),
    _27("27", "Tank container IC 20 feet", "A tank container owned by InterContainer, a European railway subsidiary, with a length of 20 feet."),
    _28("28", "Tank container IC 30 feet", "A tank container owned by InterContainer, a European railway subsidiary, with a length of 30 feet."),
    _29("29", "Tank container IC 40 feet", "A tank container, owned by InterContainer, a European railway subsidiary, with a length of 40 feet."),
    _30("30", "Refrigerated tank IC 20 feet", "A refrigerated tank owned by InterContainer, a European railway subsidiary, with a length of 20 feet."),
    _31("31", "Temperature controlled container 30 ft.", "Temperature controlled container measuring 30 feet."),
    _32("32", "Refrigerated tank IC 40 feet", "A refrigerated tank owned by InterContainer, a European railway subsidiary, with a length of 40 feet."),
    _33("33", "Movable case: L < 6,15m", "A movable case with a length less than 6,15 metres."),
    _34("34", "Movable case: 6,15m < L < 7,82m", "A movable case with a length between 6,15 metres and 7,82 metres."),
    _35("35", "Movable case: 7,82m < L < 9,15m", "A movable case with a length between 7,82 metres and 9,15 metres."),
    _36("36", "Movable case: 9,15m < L < 10,90m", "A movable case with a length between 9,15 metres and 10,90 metres."),
    _37("37", "Movable case: 10,90m < L < 13,75m", "A movable case with a length between 10,90 metres and 13,75 metres."),
    _38("38", "Totebin", "A steel open top unit of about 1,5 * 1,5 * 2,5 meters for road transport of bulk cargo."),
    _39("39", "Temperature controlled container 20 ft", "Temperature controlled container measuring 20 feet."),
    _40("40", "Temperature controlled container 40 ft", "A temperature controlled container measuring 40 feet."),
    _41("41", "Non working refrigerated (reefer) container 30ft.", "A 30 foot refrigerated (reefer) container that is not actively cooling the product."),
    _42("42", "Dual trailers", "Two trailers linked together one behind another and pulled by one tractor."),
    _43("43", "20 ft IL container (open top)", "An open top container that is 20 feet in internal length."),
    _44("44", "20 ft IL container (closed top)", "A closed top container that is 20 feet in internal length."),
    _45("45", "40 ft IL container (closed top)", "A closed top container that is 40 feet in internal length.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_VERSION = "D10B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    ESizeTypeCode21(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName, @Nullable final String sDescription) {
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
    public static ESizeTypeCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(ESizeTypeCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final ESizeTypeCode21 eValue = ESizeTypeCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
