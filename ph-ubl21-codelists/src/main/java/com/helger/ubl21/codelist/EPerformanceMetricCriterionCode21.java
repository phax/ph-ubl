/*
 * Copyright (C) 2014-2025 Philip Helger (www.helger.com)
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
 * This file was automatically generated from Genericode file PerformanceMetricCriterionCode-2.1.gc. Do NOT edit!
 * It contains a total of 6 entries!
 * @author com.helger.ubl21.supplementary.tools.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EPerformanceMetricCriterionCode21
    implements IHasID<String>
{
    FILL_RATE("FILL_RATE"),
    FORECAST_ACCURACY("FORECAST_ACCURACY"),
    GROSS_MARGIN("GROSS_MARGIN"),
    IN_STOCK("IN_STOCK"),
    ON_TIME_DELIVERY("ON_TIME_DELIVERY"),
    SUPPLY("SUPPLY");
    public static final String AGENCY_ID = "UBL";
    public static final String AGENCY_LONG_NAME = "OASIS Universal Business Language";
    public static final String LIST_VERSION = "2.1";
    private final String m_sID;

    EPerformanceMetricCriterionCode21(@Nonnull @Nonempty final String sID) {
        m_sID = sID;
    }

    @Nonnull
    @Nonempty
    public String getID() {
        return m_sID;
    }

    @Nullable
    public static EPerformanceMetricCriterionCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EPerformanceMetricCriterionCode21 .class, sID);
    }
}
