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
package com.helger.ubl20.codelist;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;


/**
 * This file is generated from Genericode file LineStatusCode-2.0.gc. Do NOT edit!
 * 
 */
@CodingStyleguideUnaware
public enum ELineStatusCode20
    implements IHasID<String> , IHasDisplayName
{
    Added("Added", "Line has been added."),
    Cancelled("Cancelled", "Line has been cancelled."),
    Disputed("Disputed", "Line is disputed."),
    NoStatus("NoStatus", "Line has no status."),
    Revised("Revised", "Line has been revised.");
    private final String m_sID;
    private final String m_sDisplayName;

    private ELineStatusCode20(
        @Nonnull
        @Nonempty
        final String sID,
        @Nonnull
        final String sDisplayName) {
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
    public static ELineStatusCode20 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(ELineStatusCode20 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(
        @Nullable
        final String sID) {
        final ELineStatusCode20 eValue = ELineStatusCode20 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
