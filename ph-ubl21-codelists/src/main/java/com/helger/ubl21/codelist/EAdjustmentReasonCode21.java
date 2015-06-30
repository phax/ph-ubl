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

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;


/**
 * This file was automatically generated from Genericode file AdjustmentReasonCode-2.1.gc. Do NOT edit!
 * It contains a total of 21 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 * 
 */
@CodingStyleguideUnaware
public enum EAdjustmentReasonCode21
    implements IHasID<String>
{
    CANCELED_PROMOTION("CANCELED_PROMOTION"),
    DISCONTINUED_PRODUCT("DISCONTINUED_PRODUCT"),
    DISTRIBUTION_ISSUE("DISTRIBUTION_ISSUE"),
    EXPANDED_PROMOTION("EXPANDED_PROMOTION"),
    FORWARD_BUY("FORWARD_BUY"),
    INVENTORY_POLICY_CHANGE("INVENTORY_POLICY_CHANGE"),
    MISCELLANEOUS_EVENT("MISCELLANEOUS_EVENT"),
    NEW_LOCATION("NEW_LOCATION"),
    NEW_PRODUCT("NEW_PRODUCT"),
    NEW_PROMOTION("NEW_PROMOTION"),
    ORDER_POLICY_CHANGE("ORDER_POLICY_CHANGE"),
    OVERSTOCK_CONDITION("OVERSTOCK_CONDITION"),
    PRICE_CHANGE("PRICE_CHANGE"),
    PRODUCTION_ISSUE("PRODUCTION_ISSUE"),
    PRODUCT_CHANGEOVER("PRODUCT_CHANGEOVER"),
    REDUCED_PROMOTION("REDUCED_PROMOTION"),
    REVISED_PLAN("REVISED_PLAN"),
    REVISED_PROMOTION("REVISED_PROMOTION"),
    STORE_CLOSURE("STORE_CLOSURE"),
    TRANSPORTATION_ISSUE("TRANSPORTATION_ISSUE"),
    WEATHER_RELATED_EVENT("WEATHER_RELATED_EVENT");
    private final String m_sID;

    private EAdjustmentReasonCode21(
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
    public static EAdjustmentReasonCode21 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(EAdjustmentReasonCode21 .class, sID);
    }
}
