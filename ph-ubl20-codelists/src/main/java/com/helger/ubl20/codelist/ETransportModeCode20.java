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
package com.helger.ubl20.codelist;

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.CodingStyleguideUnaware;
import com.helger.base.id.IHasID;
import com.helger.base.lang.EnumHelper;
import com.helger.base.name.IHasDisplayName;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;


/**
 * This file was automatically generated from Genericode file TransportModeCode-2.0.gc. Do NOT edit!
 * It contains a total of 10 entries!
 * @author com.helger.ubl20.supplementary.tools.MainCreateEnumsGenericode20
 */
@CodingStyleguideUnaware
public enum ETransportModeCode20
    implements IHasID<String> , IHasDisplayName
{
    _0("0", "Transport mode not specified"),
    _1("1", "Maritime transport"),
    _2("2", "Rail transport"),
    _3("3", "Road transport"),
    _4("4", "Air transport"),
    _5("5", "Mail"),
    _6("6", "Multimodal transport"),
    _7("7", "Fixed transport installation"),
    _8("8", "Inland water transport"),
    _9("9", "Transport mode not applicable");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_ID = "UN/ECE rec 16";
    public static final String LIST_VERSION = "Presented by the CDWG";
    private final String m_sID;
    private final String m_sDisplayName;

    ETransportModeCode20(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName) {
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
    public static ETransportModeCode20 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(ETransportModeCode20 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final ETransportModeCode20 eValue = ETransportModeCode20 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
