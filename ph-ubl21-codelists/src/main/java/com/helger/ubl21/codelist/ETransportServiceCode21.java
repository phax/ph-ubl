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
 * This file was automatically generated from Genericode file TransportServiceCode-2.1.gc. Do NOT edit!
 * It contains a total of 25 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum ETransportServiceCode21
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "Other"),
    _2("2", "ThermoService"),
    _3("3", "DangerousGoodsService"),
    _4("4", "Transport"),
    _5("5", "HandlingService"),
    _6("6", "Consolidation"),
    _7("7", "Splitting"),
    _8("8", "Combined"),
    _9("9", "Single"),
    _10("10", "Loading"),
    _11("11", "Unloading"),
    _12("12", "Insurance"),
    _13("13", "DocumentHandling"),
    _14("14", "AgentService"),
    _15("15", "InspectionService"),
    _16("16", "MaintenanceService"),
    _17("17", "DeviationNotification"),
    _18("18", "DGdeclaration"),
    _19("19", "CustomsDeclaration"),
    _20("20", "ChangeOfStatusNotification"),
    _21("21", "Warehousing"),
    _22("22", "LCL/LCL"),
    _23("23", "LCL/FCL"),
    _24("24", "FCL/FCL"),
    _25("25", "FCL/LCL");
    public static final String AGENCY_ID = "UBL";
    public static final String AGENCY_LONG_NAME = "OASIS Universal Business Language";
    public static final String LIST_VERSION = "2.1";
    private final String m_sID;
    private final String m_sDisplayName;

    private ETransportServiceCode21(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName) {
        m_sID = sID;
        m_sDisplayName = sDisplayName;
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
    public static ETransportServiceCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(ETransportServiceCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final ETransportServiceCode21 eValue = ETransportServiceCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
