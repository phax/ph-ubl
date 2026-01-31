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
package com.helger.ubl20.codelist;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.CodingStyleguideUnaware;
import com.helger.base.id.IHasID;
import com.helger.base.lang.EnumHelper;
import com.helger.base.name.IHasDisplayName;


/**
 * This file was automatically generated from Genericode file OperatorCode-2.0.gc. Do NOT edit!
 * It contains a total of 2 entries!
 * @author com.helger.ubl20.supplementary.tools.MainCreateEnumsGenericode20
 */
@CodingStyleguideUnaware
public enum EOperatorCode20
    implements IHasID<String> , IHasDisplayName
{
    Divide("Divide", "Divide"),
    Multiply("Multiply", "Multiply");
    public static final String AGENCY_ID = "UBL";
    public static final String AGENCY_LONG_NAME = "OASIS Universal Business Language";
    public static final String LIST_VERSION = "2.0";
    private final String m_sID;
    private final String m_sDisplayName;

    EOperatorCode20(@NonNull @Nonempty final String sID, @NonNull final String sDisplayName) {
        m_sID = sID;
        m_sDisplayName = sDisplayName;
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
    public static EOperatorCode20 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EOperatorCode20 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final EOperatorCode20 eValue = EOperatorCode20 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
