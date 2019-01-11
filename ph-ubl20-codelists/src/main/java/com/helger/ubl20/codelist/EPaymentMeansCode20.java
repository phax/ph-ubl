/**
 * Copyright (C) 2014-2019 Philip Helger (www.helger.com)
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
 * This file is generated from Genericode file PaymentMeansCode-2.0.gc. Do NOT edit!
 * 
 */
@CodingStyleguideUnaware
public enum EPaymentMeansCode20
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "Instrument not defined"),
    _2("2", "Automated clearing house credit"),
    _3("3", "Automated clearing house debit"),
    _4("4", "ACH demand debit reversal"),
    _5("5", "ACH demand credit reversal"),
    _6("6", "ACH demand credit"),
    _7("7", "ACH demand debit"),
    _8("8", "Hold"),
    _9("9", "National or regional clearing"),
    _10("10", "cash"),
    _11("11", "savings credit reversal"),
    _12("12", "savings debit reversal"),
    _13("13", "savings credit"),
    _14("14", "savings debit"),
    _15("15", "Bookentry credit"),
    _16("16", "Bookentry debit"),
    _17("17", "demand cash concentration/disbursement (CCD) credit"),
    _18("18", "demand cash concentration/disbursement (CCD) debit"),
    _19("19", "demand corporate trade payment (CTP) credit"),
    _20("20", "Cheque"),
    _21("21", "Banker's draft"),
    _22("22", "Certified banker's draft"),
    _23("23", "Bank cheque (issued by a banking or similar establishment)"),
    _24("24", "Bill of exchange awaiting acceptance"),
    _25("25", "Certified cheque"),
    _26("26", "Local cheque"),
    _27("27", "demand corporate trade payment (CTP) debit"),
    _28("28", "demand corporate trade exchange (CTX) credit"),
    _29("29", "demand corporate trade exchange (CTX) debit"),
    _30("30", "Credit transfer"),
    _31("31", "Debit transfer"),
    _32("32", "demand cash concentration/disbursement plus (CCD+) credit"),
    _33("33", "demand cash concentration/disbursement plus (CCD+) debit"),
    _34("34", "prearranged payment and deposit (PPD)"),
    _35("35", "savings cash concentration/disbursement (CCD) credit"),
    _36("36", "savings cash concentration/disbursement (CCD) debit"),
    _37("37", "savings corporate trade payment (CTP) credit"),
    _38("38", "savings corporate trade payment (CTP) debit"),
    _39("39", "savings corporate trade exchange (CTX) credit"),
    _40("40", "savings corporate trade exchange (CTX) debit"),
    _41("41", "savings cash concentration/disbursement plus (CCD+) credit"),
    _42("42", "Payment to bank account"),
    _43("43", "savings cash concentration/disbursement plus (CCD+) debit"),
    _44("44", "Accepted bill of exchange"),
    _45("45", "Referenced home-banking credit transfer"),
    _46("46", "Interbank debit transfer"),
    _47("47", "Home-banking debit transfer"),
    _48("48", "Bank card"),
    _49("49", "Direct debit"),
    _50("50", "Payment by postgiro"),
    _51("51", "norme 6 97-Telereglement CFONB (French Organisation for Banking Standards)  - Option A"),
    _52("52", "Urgent commercial payment"),
    _53("53", "Urgent Treasury Payment"),
    _60("60", "Promissory note"),
    _61("61", "Promissory note signed by the debtor"),
    _62("62", "Promissory note signed by the debtor and endorsed by a bank"),
    _63("63", "Promissory note signed by the debtor and endorsed by a third party"),
    _64("64", "Promissory note signed by a bank"),
    _65("65", "Promissory note signed by a bank and endorsed by another bank"),
    _66("66", "Promissory note signed by a third party"),
    _67("67", "Promissory note signed by a third party and endorsed by a bank"),
    _70("70", "Bill drawn by the creditor on the debtor"),
    _74("74", "Bill drawn by the creditor on a bank"),
    _75("75", "Bill drawn by the creditor, endorsed by another bank"),
    _76("76", "Bill drawn by the creditor on a bank and endorsed by a third party"),
    _77("77", "Bill drawn by the creditor on a third party"),
    _78("78", "Bill drawn by creditor on third party, accepted and endorsed by bank"),
    _91("91", "transferable banker's draft"),
    _92("92", "transferable local cheque"),
    _93("93", "Reference giro"),
    _94("94", "Urgent giro"),
    _95("95", "Free format giro"),
    _96("96", "Requested method for payment was not used"),
    _97("97", "Clearing between partners"),
    ZZZ("ZZZ", "Mutually defined");
    private final String m_sID;
    private final String m_sDisplayName;

    private EPaymentMeansCode20(
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
    public static EPaymentMeansCode20 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(EPaymentMeansCode20 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(
        @Nullable
        final String sID) {
        final EPaymentMeansCode20 eValue = EPaymentMeansCode20 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
