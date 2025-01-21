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
import com.helger.commons.name.IHasDisplayName;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * This file was automatically generated from Genericode file PaymentMeansCode-2.1.gc. Do NOT edit!
 * It contains a total of 75 entries!
 * @author com.helger.ubl21.supplementary.tools.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EPaymentMeansCode21
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "Instrument not defined", "Not defined legally enforceable agreement between two or more parties (expressing a contractual right or a right to the payment of money)."),
    _2("2", "Automated clearing house credit", "A credit transaction made through the automated clearing house system."),
    _3("3", "Automated clearing house debit", "A debit transaction made through the automated clearing house system."),
    _4("4", "ACH demand debit reversal", "A request to reverse an ACH debit transaction to a demand deposit account."),
    _5("5", "ACH demand credit reversal", "A request to reverse a credit transaction to a demand deposit account."),
    _6("6", "ACH demand credit", "A credit transaction made through the ACH system to a demand deposit account."),
    _7("7", "ACH demand debit", "A debit transaction made through the ACH system to a demand deposit account."),
    _8("8", "Hold", "Indicates that the bank should hold the payment for collection by the beneficiary or other instructions."),
    _9("9", "National or regional clearing", "Indicates that the payment should be made using the national or regional clearing."),
    _10("10", "In cash", "Payment by currency (including bills and coins) in circulation, including checking account deposits."),
    _11("11", "ACH savings credit reversal", "A request to reverse an ACH credit transaction to a savings account."),
    _12("12", "ACH savings debit reversal", "A request to reverse an ACH debit transaction to a savings account."),
    _13("13", "ACH savings credit", "A credit transaction made through the ACH system to a savings account."),
    _14("14", "ACH savings debit", "A debit transaction made through the ACH system to a savings account."),
    _15("15", "Bookentry credit", "A credit entry between two accounts at the same bank branch. Synonym: house credit."),
    _16("16", "Bookentry debit", "A debit entry between two accounts at the same bank branch. Synonym: house debit."),
    _17("17", "ACH demand cash concentration/disbursement (CCD) credit", "A credit transaction made through the ACH system to a demand deposit account using the CCD payment format."),
    _18("18", "ACH demand cash concentration/disbursement (CCD) debit", "A debit transaction made through the ACH system to a demand deposit account using the CCD payment format."),
    _19("19", "ACH demand corporate trade payment (CTP) credit", "A credit transaction made through the ACH system to a demand deposit account using the CTP payment format."),
    _20("20", "Cheque", "Payment by a pre-printed form on which instructions are given to an account holder (a bank or building society) to pay a stated sum to a named recipient."),
    _21("21", "Banker's draft", "Issue of a banker's draft in payment of the funds."),
    _22("22", "Certified banker's draft", "Cheque drawn by a bank on itself or its agent. A person who owes money to another buys the draft from a bank for cash and hands it to the creditor who need have no fear that it might be dishonoured."),
    _23("23", "Bank cheque (issued by a banking or similar establishment)", "Payment by a pre-printed form, which has been completed by a financial institution, on which instructions are given to an account holder (a bank or building society) to pay a stated sum to a named recipient."),
    _24("24", "Bill of exchange awaiting acceptance", "Bill drawn by the creditor on the debtor but not yet accepted by the debtor."),
    _25("25", "Certified cheque", "Payment by a pre-printed form stamped with the paying bank's certification on which instructions are given to an account holder (a bank or building society) to pay a stated sum to a named recipient ."),
    _26("26", "Local cheque", "Indicates that the cheque is given local to the recipient."),
    _27("27", "ACH demand corporate trade payment (CTP) debit", "A debit transaction made through the ACH system to a demand deposit account using the CTP payment format."),
    _28("28", "ACH demand corporate trade exchange (CTX) credit", "A credit transaction made through the ACH system to a demand deposit account using the CTX payment format."),
    _29("29", "ACH demand corporate trade exchange (CTX) debit", "A debit transaction made through the ACH system to a demand account using the CTX payment format."),
    _30("30", "Credit transfer", "Payment by credit movement of funds from one account to another."),
    _31("31", "Debit transfer", "Payment by debit movement of funds from one account to another."),
    _32("32", "ACH demand cash concentration/disbursement plus (CCD+) credit", "A credit transaction made through the ACH system to a demand deposit account using the CCD+ payment format."),
    _33("33", "ACH demand cash concentration/disbursement plus (CCD+) debit", "A debit transaction made through the ACH system to a demand deposit account using the CCD+ payment format."),
    _34("34", "ACH prearranged payment and deposit (PPD)", "A consumer credit transaction made through the ACH system to a demand deposit or savings account."),
    _35("35", "ACH savings cash concentration/disbursement (CCD) credit", "A credit transaction made through the ACH system to a demand deposit or savings account."),
    _36("36", "ACH savings cash concentration/disbursement (CCD) debit", "A debit transaction made through the ACH system to a savings account using the CCD payment format."),
    _37("37", "ACH savings corporate trade payment (CTP) credit", "A credit transaction made through the ACH system to a savings account using the CTP payment format."),
    _38("38", "ACH savings corporate trade payment (CTP) debit", "A debit transaction made through the ACH system to a savings account using the CTP payment format."),
    _39("39", "ACH savings corporate trade exchange (CTX) credit", "A credit transaction made through the ACH system to a savings account using the CTX payment format."),
    _40("40", "ACH savings corporate trade exchange (CTX) debit", "A debit transaction made through the ACH system to a savings account using the CTX payment format."),
    _41("41", "ACH savings cash concentration/disbursement plus (CCD+) credit", "A credit transaction made through the ACH system to a savings account using the CCD+ payment format."),
    _42("42", "Payment to bank account", "Payment by an arrangement for settling debts that is operated by the Post Office."),
    _43("43", "ACH savings cash concentration/disbursement plus (CCD+) debit", "A debit transaction made through the ACH system to a savings account using the CCD+ payment format."),
    _44("44", "Accepted bill of exchange", "Bill drawn by the creditor on the debtor and accepted by the debtor."),
    _45("45", "Referenced home-banking credit transfer", "A referenced credit transfer initiated through home-banking."),
    _46("46", "Interbank debit transfer", "A debit transfer via interbank means."),
    _47("47", "Home-banking debit transfer", "A debit transfer initiated through home-banking."),
    _48("48", "Bank card", "Payment by means of a card issued by a bank or other financial institution."),
    _49("49", "Direct debit", "The amount is to be, or has been, directly debited to the customer's bank account."),
    _50("50", "Payment by postgiro", "A method for the transmission of funds through the postal system rather than through the banking system."),
    _51("51", "FR, norme 6 97-Telereglement CFONB (French Organisation for Banking Standards)  - Option A", "A French standard procedure that allows a debtor to pay an amount due to a creditor. The creditor will forward it to its bank, which will collect the money on the bank account of the debtor."),
    _52("52", "Urgent commercial payment", "Payment order which requires guaranteed processing by the most appropriate means to ensure it occurs on the requested execution date, provided that it is issued to the ordered bank before the agreed cut-off time."),
    _53("53", "Urgent Treasury Payment", "Payment order or transfer which must be executed, by the most appropriate means, as urgently as possible and before urgent commercial payments."),
    _60("60", "Promissory note", "Payment by an unconditional promise in writing made by one person to another, signed by the maker, engaging to pay on demand or at a fixed or determinable future time a sum certain in money, to order or to bearer."),
    _61("61", "Promissory note signed by the debtor", "Payment by an unconditional promise in writing made by the debtor to another person, signed by the debtor, engaging to pay on demand or at a fixed or determinable future time a sum certain in money, to order or to bearer."),
    _62("62", "Promissory note signed by the debtor and endorsed by a bank", "Payment by an unconditional promise in writing made by the debtor to another person, signed by the debtor and endorsed by a bank, engaging to pay on demand or at a fixed or determinable future time a sum certain in money, to order or to bearer."),
    _63("63", "Promissory note signed by the debtor and endorsed by a third party", "Payment by an unconditional promise in writing made by the debtor to another person, signed by the debtor and endorsed by a third party, engaging to pay on demand or at a fixed or determinable future time a sum certain in money, to order or to bearer."),
    _64("64", "Promissory note signed by a bank", "Payment by an unconditional promise in writing made by the bank to another person, signed by the bank, engaging to pay on demand or at a fixed or determinable future time a sum certain in money, to order or to bearer."),
    _65("65", "Promissory note signed by a bank and endorsed by another bank", "Payment by an unconditional promise in writing made by the bank to another person, signed by the bank and endorsed by another bank, engaging to pay on demand or at a fixed or determinable future time a sum certain in money, to order or to bearer."),
    _66("66", "Promissory note signed by a third party", "Payment by an unconditional promise in writing made by a third party to another person, signed by the third party, engaging to pay on demand or at a fixed or determinable future time a sum certain in money, to order or to bearer."),
    _67("67", "Promissory note signed by a third party and endorsed by a bank", "Payment by an unconditional promise in writing made by a third party to another person, signed by the third party and endorsed by a bank, engaging to pay on demand or at a fixed or determinable future time a sum certain in money, to order or to bearer."),
    _70("70", "Bill drawn by the creditor on the debtor", "Bill drawn by the creditor on the debtor."),
    _74("74", "Bill drawn by the creditor on a bank", "Bill drawn by the creditor on a bank."),
    _75("75", "Bill drawn by the creditor, endorsed by another bank", "Bill drawn by the creditor, endorsed by another bank."),
    _76("76", "Bill drawn by the creditor on a bank and endorsed by a third party", "Bill drawn by the creditor on a bank and endorsed by a third party."),
    _77("77", "Bill drawn by the creditor on a third party", "Bill drawn by the creditor on a third party."),
    _78("78", "Bill drawn by creditor on third party, accepted and endorsed by bank", "Bill drawn by creditor on third party, accepted and endorsed by bank."),
    _91("91", "Not transferable banker's draft", "Issue a bankers draft not endorsable."),
    _92("92", "Not transferable local cheque", "Issue a cheque not endorsable in payment of the funds."),
    _93("93", "Reference giro", "Ordering customer tells the bank to use the payment system 'Reference giro'. Used in the Finnish national banking system."),
    _94("94", "Urgent giro", "Ordering customer tells the bank to use the bank service 'Urgent Giro' when transferring the payment. Used in Finnish national banking system."),
    _95("95", "Free format giro", "Ordering customer tells the ordering bank to use the bank service 'Free Format Giro' when transferring the payment. Used in Finnish national banking system."),
    _96("96", "Requested method for payment was not used", "If the requested method for payment was or could not be used, this code indicates that."),
    _97("97", "Clearing between partners", "Amounts which two partners owe to each other to be compensated in order to avoid useless payments."),
    ZZZ("ZZZ", "Mutually defined", "A code assigned within a code list to be used on an interim basis and as defined among trading partners until a precise code can be assigned to the code list.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_ID = "UN/ECE 4461";
    public static final String LIST_VERSION = "D10B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    EPaymentMeansCode21(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName, @Nullable final String sDescription) {
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
    public static EPaymentMeansCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EPaymentMeansCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final EPaymentMeansCode21 eValue = EPaymentMeansCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
