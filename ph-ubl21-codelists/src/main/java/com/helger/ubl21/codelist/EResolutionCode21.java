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
package com.helger.ubl21.codelist;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;


/**
 * This file was automatically generated from Genericode file ResolutionCode-2.1.gc. Do NOT edit!
 * It contains a total of 8 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EResolutionCode21
    implements IHasID<String>
{
    LOCAL_INTERPOLATED_VALUE("LOCAL_INTERPOLATED_VALUE"),
    LOCAL_ISSUE_CHANGED_VALUE("LOCAL_ISSUE_CHANGED_VALUE"),
    LOCAL_ISSUE_LEFT_VALUE_UNCHANGED("LOCAL_ISSUE_LEFT_VALUE_UNCHANGED"),
    NEW_VALUE_JOINTLY_IDENTIFIED("NEW_VALUE_JOINTLY_IDENTIFIED"),
    OBSOLETE_VALUE("OBSOLETE_VALUE"),
    PARTNER_ISSUE_CHANGED_VALUE("PARTNER_ISSUE_CHANGED_VALUE"),
    PARTNER_ISSUE_LEFT_VALUE_UNCHANGED("PARTNER_ISSUE_LEFT_VALUE_UNCHANGED"),
    UNRESOLVABLE("UNRESOLVABLE");
    private final String m_sID;

    private EResolutionCode21(
        @Nonnull
        @Nonempty
        final String sID) {
        m_sID = sID;
    }

    @Nonnull
    @Nonempty
    public String getID() {
        return m_sID;
    }

    @Nullable
    public static EResolutionCode21 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(EResolutionCode21 .class, sID);
    }
}
