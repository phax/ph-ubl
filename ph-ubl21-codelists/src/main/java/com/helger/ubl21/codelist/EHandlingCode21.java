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
 * This file was automatically generated from Genericode file HandlingCode-2.1.gc. Do NOT edit!
 * It contains a total of 12 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EHandlingCode21
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "Heat sensitive", "The object is heat sensitive."),
    _2("2", "Store in dry environment", "The object must be stored in dry environment."),
    _3("3", "Stacked", "The identified item is, or can be stacked."),
    _4("4", "Mooring to be arranged", "Request to arrange boatmen to (de)moor the vessel at the berth."),
    _5("5", "Mooring arranged", "Information that the boatmen to (de)moor the vessel at the berth are already arranged."),
    _6("6", "Pilotage to be arranged", "Request to arrange the pilotage for the vessel."),
    _7("7", "Pilotage arranged", "Information that pilotage for the vessel is already arranged."),
    _8("8", "Berth towage to be arranged", "Request to arrange the towage for the vessel to/from the berth in the port."),
    _9("9", "Disposal of waste to be arranged", "Request to arrange the disposal of waste."),
    _10("10", "Transshipment to be arranged", "The consignment has to be transshipped."),
    _11("11", "Refrigeration required", "Item must be refrigerated for proper handling."),
    _12("12", "Refrigeration not required", "Item does not need to be refrigerated for proper handling.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_ID = "tred4079";
    public static final String LIST_VERSION = "D12B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    private EHandlingCode21(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName, @Nullable final String sDescription) {
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
    public static EHandlingCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EHandlingCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final EHandlingCode21 eValue = EHandlingCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
