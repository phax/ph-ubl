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

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * This file was automatically generated from Genericode file MiscellaneousEventTypeCode-2.1.gc. Do NOT edit!
 * It contains a total of 17 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EMiscellaneousEventTypeCode21
    implements IHasID<String>
{
    ASSORTMENT_CHARGE("ASSORTMENT_CHARGE"),
    DISASTER("DISASTER"),
    FORECAST_DECREASE("FORECAST_DECREASE"),
    FORECAST_INCREASE("FORECAST_INCREASE"),
    FREIGHT_FLOW_ALLOCATION("FREIGHT_FLOW_ALLOCATION"),
    INVENTORY_POLICY_CHANGE("INVENTORY_POLICY_CHANGE"),
    LABOR("LABOR"),
    LOCATION_OF_CLOSING("LOCATION_OF_CLOSING"),
    LOCATION_OF_OPENING("LOCATION_OF_OPENING"),
    OTHER("OTHER"),
    OUT_OF_STOCK("OUT_OF_STOCK"),
    PACKAGING_LABELING_CHANGE("PACKAGING_LABELING_CHANGE"),
    PRICE_DECREASE("PRICE_DECREASE"),
    PRICE_INCREASE("PRICE_INCREASE"),
    STORE_FORMAT_OF_PLANOGRAM_CHANGE("STORE_FORMAT_OF_PLANOGRAM_CHANGE"),
    TEST_MARKET("TEST_MARKET"),
    WEATHER("WEATHER");
    public static final String AGENCY_ID = "UBL";
    public static final String AGENCY_LONG_NAME = "OASIS Universal Business Language";
    public static final String LIST_VERSION = "2.1";
    private final String m_sID;

    private EMiscellaneousEventTypeCode21(@Nonnull @Nonempty final String sID) {
        m_sID = sID;
    }

    @Nonnull
    @Nonempty
    public String getID() {
        return m_sID;
    }

    @Nullable
    public static EMiscellaneousEventTypeCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EMiscellaneousEventTypeCode21 .class, sID);
    }
}
