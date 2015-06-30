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
package com.helger.ubl20.codelist;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;


/**
 * This file is generated from Genericode file AllowanceChargeReasonCode-2.0.gc. Do NOT edit!
 * 
 */
@CodingStyleguideUnaware
public enum EAllowanceChargeReasonCode20
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "Agreed settlement"),
    _2("2", "Below specification goods"),
    _3("3", "Damaged goods"),
    _4("4", "Short delivery"),
    _5("5", "Price query"),
    _6("6", "Proof of delivery required"),
    _7("7", "Payment on account"),
    _8("8", "Returnable container charge included"),
    _9("9", "Invoice error"),
    _10("10", "Costs for draft"),
    _11("11", "Bank charges"),
    _12("12", "Agent commission"),
    _13("13", "Counter claim"),
    _14("14", "Wrong delivery"),
    _15("15", "Goods returned to agent"),
    _16("16", "Goods partly returned"),
    _17("17", "Transport damage"),
    _18("18", "Goods on consignment"),
    _19("19", "Trade discount"),
    _20("20", "Deduction for late delivery"),
    _21("21", "Advertising costs"),
    _22("22", "Customs duties"),
    _23("23", "Telephone and postal costs"),
    _24("24", "Repair costs"),
    _25("25", "Attorney fees"),
    _26("26", "Taxes"),
    _27("27", "Reclaimed deduction"),
    _28("28", "See separate advice"),
    _29("29", "Buyer refused to take delivery"),
    _30("30", "Direct payment to seller"),
    _31("31", "Buyer disagrees with due date"),
    _32("32", "Goods not delivered"),
    _33("33", "Late delivery"),
    _34("34", "Quoted as paid to you"),
    _35("35", "Goods returned"),
    _36("36", "Invoice not received"),
    _37("37", "Credit note to debtor/not to us"),
    _38("38", "Deducted bonus"),
    _39("39", "Deducted discount"),
    _40("40", "Deducted freight costs"),
    _41("41", "Deduction against other invoices"),
    _42("42", "Credit balance(s)"),
    _43("43", "Reason unknown"),
    _44("44", "Awaiting message from seller"),
    _45("45", "Debit note to seller"),
    _46("46", "Discount beyond terms"),
    _47("47", "See buyer's letter"),
    _48("48", "Allowance/charge error"),
    _49("49", "Substitute product"),
    _50("50", "Terms of sale error"),
    _51("51", "Required data missing"),
    _52("52", "Wrong invoice"),
    _53("53", "Duplicate invoice"),
    _54("54", "Weight error"),
    _55("55", "Additional charge not authorized"),
    _56("56", "Incorrect discount"),
    _57("57", "Price change"),
    _58("58", "Variation"),
    _59("59", "Chargeback"),
    _60("60", "Offset"),
    _61("61", "Indirect payment"),
    _62("62", "Financial reassignment"),
    _63("63", "Reinstatement of chargeback/offset"),
    _64("64", "Expecting new terms"),
    _65("65", "Settlement to agent"),
    _66("66", "Cash discount"),
    _67("67", "Delcredere costs"),
    _68("68", "Early payment allowance adjustment"),
    _69("69", "Incorrect due date for monetary amount"),
    _70("70", "Wrong monetary amount resulting from incorrect free goods quantity"),
    _71("71", "Rack or shelf replenishment service by a supplier"),
    _72("72", "Temporary special promotion"),
    _73("73", "Difference in tax rate"),
    _74("74", "Quantity discount"),
    _75("75", "Promotion discount"),
    _76("76", "Cancellation deadline passed"),
    _77("77", "Pricing discount"),
    _78("78", "Volume discount"),
    _79("79", "Sundry discount"),
    _80("80", "Card holder signature missing"),
    _81("81", "Card expiry date missing"),
    _82("82", "Card number error"),
    _83("83", "Card expired"),
    _84("84", "Test card transaction"),
    _85("85", "Permission limit exceeded"),
    _86("86", "Wrong authorisation code"),
    _87("87", "Wrong authorised amount"),
    _88("88", "Authorisation failed"),
    _89("89", "Card acceptor data error"),
    ZZZ("ZZZ", "Mutually defined");
    private final String m_sID;
    private final String m_sDisplayName;

    private EAllowanceChargeReasonCode20(
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
    public static EAllowanceChargeReasonCode20 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(EAllowanceChargeReasonCode20 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(
        @Nullable
        final String sID) {
        final EAllowanceChargeReasonCode20 eValue = EAllowanceChargeReasonCode20 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
