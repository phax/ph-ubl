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
package com.helger.ubl21.codelist;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.CodingStyleguideUnaware;
import com.helger.base.id.IHasID;
import com.helger.base.lang.EnumHelper;
import com.helger.base.name.IHasDisplayName;


/**
 * This file was automatically generated from Genericode file PackageLevelCode-2.1.gc. Do NOT edit!
 * It contains a total of 5 entries!
 * @author com.helger.ubl21.supplementary.tools.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EPackageLevelCode21
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "Inner", "Level of packing, if it exists, that is immediately subordinate to the intermediate packaging level."),
    _2("2", "Intermediate", "Level of packaging, if it exists, that is immediately subordinate to the outer packaging level."),
    _3("3", "Outer", "For packed merchandise, outermost level of packaging for a shipment."),
    _4("4", "No packaging hierarchy", "There is no specifiable level of packaging: packaging is inner and outer level as well."),
    _5("5", "Shipment level", "The packaging level being described is the shipment level.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_VERSION = "D10B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    EPackageLevelCode21(@NonNull @Nonempty final String sID, @NonNull final String sDisplayName, @Nullable final String sDescription) {
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
    public static EPackageLevelCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EPackageLevelCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final EPackageLevelCode21 eValue = EPackageLevelCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
