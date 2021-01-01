/**
 * Copyright (C) 2014-2021 Philip Helger (www.helger.com)
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

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * This file was automatically generated from Genericode file DocumentStatusCode-2.0.gc. Do NOT edit!
 * It contains a total of 4 entries!
 * @author com.helger.ubl20.main.MainCreateEnumsGenericode20
 */
@CodingStyleguideUnaware
public enum EDocumentStatusCode20
    implements IHasID<String> , IHasDisplayName
{
    Cancelled("Cancelled", "Document has been cancelled"),
    Disputed("Disputed", "Document is disputed"),
    NoStatus("NoStatus", "No status on document"),
    Revised("Revised", "Document has been revised");
    public static final String AGENCY_ID = "UBL";
    public static final String AGENCY_LONG_NAME = "OASIS Universal Business Language";
    public static final String LIST_VERSION = "2.0";
    private final String m_sID;
    private final String m_sDisplayName;

    private EDocumentStatusCode20(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName) {
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
    public static EDocumentStatusCode20 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EDocumentStatusCode20 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final EDocumentStatusCode20 eValue = EDocumentStatusCode20 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
