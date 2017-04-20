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
package com.helger.ubl22.codelist;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;


/**
 * This file was automatically generated from Genericode file WeighingMethodCode-2.2.gc. Do NOT edit!
 * It contains a total of 2 entries!
 * @author com.helger.ubl22.main.MainCreateEnumsGenericode22
 */
@CodingStyleguideUnaware
public enum EWeighingMethodCode22
    implements IHasID<String> , IHasDisplayName
{
    SM1("SM1", "SOLAS verification method 1", "Weighing the packed container using calibrated and certified equipment"),
    SM2("SM2", "SOLAS verification method 2", "Weighing all packages and cargo items, including the mass of pallets, dunnage and other securing material to be packed in the container and adding the tare mass of the container to the sum of the single masses, using a certified method approved by the competent authority of the State in which packing of the container was completed.");
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    private EWeighingMethodCode22(
        @Nonnull
        @Nonempty
        final String sID,
        @Nonnull
        final String sDisplayName,
        @Nullable
        final String sDescription) {
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
    public static EWeighingMethodCode22 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(EWeighingMethodCode22 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(
        @Nullable
        final String sID) {
        final EWeighingMethodCode22 eValue = EWeighingMethodCode22 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
