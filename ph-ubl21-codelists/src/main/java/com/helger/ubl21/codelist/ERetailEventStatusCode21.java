/**
 * Copyright (C) 2014-2015 Philip Helger (www.helger.com)
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
import com.helger.commons.annotations.CodingStyleguideUnaware;
import com.helger.commons.annotations.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;


/**
 * This file was automatically generated from Genericode file RetailEventStatusCode-2.1.gc. Do NOT edit!
 * It contains a total of 9 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 * 
 */
@CodingStyleguideUnaware
public enum ERetailEventStatusCode21
    implements IHasID<String>
{
    ACKNOWLEDGED("ACKNOWLEDGED"),
    ACTIVE("ACTIVE"),
    CANCELED("CANCELED"),
    COMPLETED("COMPLETED"),
    EXPIRED("EXPIRED"),
    PLANNED("PLANNED"),
    PROPOSED("PROPOSED"),
    REJECTED("REJECTED"),
    TERMINATED("TERMINATED");
    private final String m_sID;

    private ERetailEventStatusCode21(
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
    public static ERetailEventStatusCode21 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(ERetailEventStatusCode21 .class, sID);
    }
}
