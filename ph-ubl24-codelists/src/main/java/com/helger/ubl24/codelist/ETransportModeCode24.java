/*
 * Copyright (C) 2014-2026 Philip Helger (www.helger.com)
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
package com.helger.ubl24.codelist;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.CodingStyleguideUnaware;
import com.helger.base.id.IHasID;
import com.helger.base.lang.EnumHelper;
import com.helger.base.name.IHasDisplayName;


/**
 * This file was automatically generated from Genericode file TransportModeCode-2.4.gc. Do NOT edit!
 * It contains a total of 10 entries!
 * @author com.helger.ubl24.supplementary.tools.MainCreateEnumsGenericode24
 */
@CodingStyleguideUnaware
public enum ETransportModeCode24
    implements IHasID<String> , IHasDisplayName
{
    _0("0", "Transport mode not specified", "Transport mode has not been specified. Notes: 1) This code can be used when the mode is not known or when information on is not available at the time of issuing the document concerned."),
    _1("1", "Maritime transport", "Transport of goods and/or persons is by sea."),
    _2("2", "Rail transport", "Transport of goods and/or persons is by rail."),
    _3("3", "Road transport", "Transport of goods and/or persons is by road."),
    _4("4", "Air transport", "Transport of goods and/or persons is by air."),
    _5("5", "Mail", "Method to convey goods is by mail. Notes: 1) This code is provided for practical reasons, despite the fact that mail is not a genuine mode of transport. In many countries, the value of merchandise exported by mail is considerable, but the exporter or importer concerned would be unable to state by which mode postal items had been conveyed."),
    _6("6", "Multimodal transport", "Method to convey goods and/or persons is by multimodal transport. Notes: 1) This code is provided for practical reasons, despite the fact that multimodal transport is not a genuine mode of transport. It can be used when goods are carried by at least two different modes from a place at which the goods are taken in charge by a transport operator to a place designated for delivery, on the basis of one transport contract. (Operations of pick-up and delivery of goods carried out in the performance of a single mode of transport, as defined in such a contract, shall not be considered as multimodal transport)."),
    _7("7", "Fixed transport installations", "Transport of item is via a fixed transport installation. Notes: 1) This code applies to installations for continuous transport such as pipelines, ropeways and electric power lines."),
    _8("8", "Inland water transport", "Transport of goods and/or persons is by inland water transport."),
    _9("9", "Transport mode not applicable", "The mode of transport is not applicable.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_ID = "UNECE Recommendation 19 - Codes for Modes of Transport";
    public static final String LIST_VERSION = "18B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    ETransportModeCode24(@NonNull @Nonempty final String sID, @NonNull final String sDisplayName, @Nullable final String sDescription) {
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
    public static ETransportModeCode24 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(ETransportModeCode24 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final ETransportModeCode24 eValue = ETransportModeCode24 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
