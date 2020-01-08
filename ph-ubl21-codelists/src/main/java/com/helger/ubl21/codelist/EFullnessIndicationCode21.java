/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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
import com.helger.commons.name.IHasDisplayName;


/**
 * This file was automatically generated from Genericode file FullnessIndicationCode-2.1.gc. Do NOT edit!
 * It contains a total of 13 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EFullnessIndicationCode21
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "More than one quarter volume available", "Indicates that there is more than a quarter of the volume available."),
    _2("2", "More than half volume available", "Indicates that there is more than a half of the volume available."),
    _3("3", "More than three quarters volume available", "Indicates that there is more than three quarters of the volume available."),
    _4("4", "Empty", "Indicates that the object is empty."),
    _5("5", "Full", "Indicates that the object is full."),
    _6("6", "No volume available", "Indicates that there is no space available in the object."),
    _7("7", "Full, mixed consignment", "Indicates that the equipment is fully loaded, and includes a number LCL (Less Than Container Load) consignments."),
    _8("8", "Full, single consignment", "Indicates that the container is fully loaded with a single FCL (Full Container Load) consignment."),
    _9("9", "Part load", "Container represents part of a consignment declared on a single Customs declaration (i.e. the Customs declaration covers more than one container)."),
    _10("10", "Part load mixed consignments", "Container represents part of the consignment declared on a single Customs declaration with the remainder being in other containers. Other goods, related to other declarations, are also in the container."),
    _11("11", "Single invoiced load", "Merchandise within a container/package covered by a single invoice."),
    _12("12", "Multi invoiced load", "Merchandise within a container/package covered by more than one invoice."),
    _13("13", "Full load, multiple bills", "A container representing a consignment of goods for one consignee with multiple bill of lading numbers.");
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    private EFullnessIndicationCode21(
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
    public static EFullnessIndicationCode21 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(EFullnessIndicationCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(
        @Nullable
        final String sID) {
        final EFullnessIndicationCode21 eValue = EFullnessIndicationCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
