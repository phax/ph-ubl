/*
 * Copyright (C) 2014-2023 Philip Helger (www.helger.com)
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
 * This file was automatically generated from Genericode file AllowanceChargeReasonCode-2.1.gc. Do NOT edit!
 * It contains a total of 98 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EAllowanceChargeReasonCode21
    implements IHasID<String> , IHasDisplayName
{
    _1("1", "Agreed settlement", "An adjustment made based on an agreement between partners."),
    _2("2", "Below specification goods", "Goods of inferior quality."),
    _3("3", "Damaged goods", "An adjustment due to the damage of goods."),
    _4("4", "Short delivery", "An adjustment made because the delivered quantity was less than expected."),
    _5("5", "Price query", "An adjustment due to a price query."),
    _6("6", "Proof of delivery required", "The buyer requires that proof of delivery be made before payment."),
    _7("7", "Payment on account", "Buyer is to make payment later."),
    _8("8", "Returnable container charge included", "Adjustment made to deduct the returnable container charge."),
    _9("9", "Invoice error", "Invoice not in accordance with the order."),
    _10("10", "Costs for draft", "Cost of draft has been deducted from payment."),
    _11("11", "Bank charges", "Bank charges have been deducted from payment."),
    _12("12", "Agent commission", "Agent commission has been deducted from payment."),
    _13("13", "Counter claim", "Buyer claims an existing (financial) obligation from seller which (partly) offsets the outstanding invoice(s)."),
    _14("14", "Wrong delivery", "Delivery not according to specifications."),
    _15("15", "Goods returned to agent", "Goods returned to agent."),
    _16("16", "Goods partly returned", "Goods partly returned."),
    _17("17", "Transport damage", "Goods damaged in transit."),
    _18("18", "Goods on consignment", "Buyer does not accept invoice(s) charge as it relates to goods where the ownership remains with the seller until sold."),
    _19("19", "Trade discount", "Trade discount deducted from payment."),
    _20("20", "Deduction for late delivery", "Penalty amount deducted for later delivery."),
    _21("21", "Advertising costs", "Advertising costs deducted from payment."),
    _22("22", "Customs duties", "Customs duties deducted from payment."),
    _23("23", "Telephone and postal costs", "Telephone and postal costs deducted from payment."),
    _24("24", "Repair costs", "Repair costs deducted from payment."),
    _25("25", "Attorney fees", "Attorney fees deducted from payment."),
    _26("26", "Taxes", "Taxes deducted from payment."),
    _27("27", "Reclaimed deduction", "Buyer reclaims an unspecified deduction from the invoice(s) (to be) paid."),
    _28("28", "See separate advice", "Buyer or seller refers to separate correspondence about a related shipment(s) and/or invoice(s) and/or a payment(s)."),
    _29("29", "Buyer refused to take delivery", "Buyer refused to take delivery."),
    _30("30", "Direct payment to seller", "Buyer states to have paid to seller."),
    _31("31", "Buyer disagrees with due date", "Buyer disagrees with due date."),
    _32("32", "Goods not delivered", "Buyer has not received the goods."),
    _33("33", "Late delivery", "Goods delivered too late."),
    _34("34", "Quoted as paid to you", "Factor informs the seller that a certain invoice(s) was paid by the buyer directly to the seller."),
    _35("35", "Goods returned", "Buyer returned the goods to seller."),
    _36("36", "Invoice not received", "Buyer claims he did not receive the invoice for which payment is requested."),
    _37("37", "Credit note to debtor/not to us", "Factor informs the seller that he did not receive copy of a credit note sent to the buyer."),
    _38("38", "Deducted bonus", "Buyer has/will deduct a bonus he is entitled to from the payment."),
    _39("39", "Deducted discount", "Buyer has/will deduct the discount he is entitled to from the payment."),
    _40("40", "Deducted freight costs", "Buyer has/will deduct freight costs from the payment."),
    _41("41", "Deduction against other invoices", "Deduction against invoices already settled."),
    _42("42", "Credit balance(s)", "Buyer makes use of existing credit balance(s) to offset (partly) the outstanding invoice(s)."),
    _43("43", "Reason unknown", "Factor informs the seller that the reason of a commercial dispute raised by the buyer is unknown."),
    _44("44", "Awaiting message from seller", "Buyer or factor are waiting for a (reply) message from the seller before a commercial dispute can be settled."),
    _45("45", "Debit note to seller", "Buyer issued debit note to seller."),
    _46("46", "Discount beyond terms", "Buyer has taken a discount larger than the discount terms agreed with the seller."),
    _47("47", "See buyer's letter", "See correspondence from buyer."),
    _48("48", "Allowance/charge error", "Error made by seller in the amount of allowance/charge."),
    _49("49", "Substitute product", "Product delivered not fully according to specification."),
    _50("50", "Terms of sale error", "Terms of sale not according to purchase order."),
    _51("51", "Required data missing", "A message sent by buyer to seller or by seller to buyer did not contain data required to take action/decision."),
    _52("52", "Wrong invoice", "Invoice issued to wrong party."),
    _53("53", "Duplicate invoice", "Invoice sent twice."),
    _54("54", "Weight error", "Weight not in accordance with the order."),
    _55("55", "Additional charge not authorized", "Additional charge not authorised."),
    _56("56", "Incorrect discount", "Buyer states that calculated discount on the invoice(s) is wrongly calculated."),
    _57("57", "Price change", "Price has been changed."),
    _58("58", "Variation", "The adjustment is a variation from an agreed value."),
    _59("59", "Chargeback", "Balance of one or more items charged back to seller."),
    _60("60", "Offset", "Allocation of one or more debit items to one or more credit items or vice-versa."),
    _61("61", "Indirect payment", "Payment in settlement of an invoice has been made to a party other than the designated creditor."),
    _62("62", "Financial reassignment", "Previously assigned invoice/credit note is being reassigned."),
    _63("63", "Reinstatement of chargeback/offset", "Reversal or cancellation of a chargeback and/or offset relating to an incorrect balance."),
    _64("64", "Expecting new terms", "Buyer expects that seller revises the terms of payment of an invoice."),
    _65("65", "Settlement to agent", "Invoice has been/to be paid to seller's agent."),
    _66("66", "Cash discount", "An adjustment has been made due to the application of a cash discount."),
    _67("67", "Delcredere costs", "Costs deducted from a total amount to pay for the services of central payment."),
    _68("68", "Early payment allowance adjustment", "Adjustment results from the application of an early payment allowance."),
    _69("69", "Incorrect due date for monetary amount", "Adjustment has been made because an incorrect due date was referred to with regard to the monetary amount."),
    _70("70", "Wrong monetary amount resulting from incorrect free goods quantity", "Adjustment has been made because of a wrong monetary amount resulting from an incorrect free goods quantity."),
    _71("71", "Rack or shelf replenishment service by a supplier", "Adjustment due to the replenishment of the racks or shelves by a supplier."),
    _72("72", "Temporary special promotion", "Adjustment due to a temporary special promotion."),
    _73("73", "Difference in tax rate", "Adjustment due to a difference in tax rate."),
    _74("74", "Quantity discount", "Adjustment due to a quantity discount."),
    _75("75", "Promotion discount", "Adjustment due to a promotion discount."),
    _76("76", "Cancellation deadline passed", "The cancellation has occurred after the deadline."),
    _77("77", "Pricing discount", "An adjustment has been made due to the application of a pricing discount."),
    _78("78", "Volume discount", "Discount for reaching or exceeding an agreed accumulated volume."),
    _79("79", "Sundry discount", "Adjustment has been made due to the application of a sundry discount."),
    _80("80", "Card holder signature missing", "The adjustment was made due to the card holder not signing the filing document."),
    _81("81", "Card expiry date missing", "The adjustment was made due to the card acceptor not specifying the expiry date within the filing document."),
    _82("82", "Card number error", "The adjustment was made due to the card acceptor specifying an erroneous card number within the filing document."),
    _83("83", "Card expired", "The adjustment was made due to the card acceptor specifying an expired expiry date within the filing document or electronic data."),
    _84("84", "Test card transaction", "The adjustment was made due to a test card transaction, used for installing, maintaining or debugging purposes."),
    _85("85", "Permission limit exceeded", "The adjustment was made due to the permission limit defined by card issuer or card company was exceeded without prior authorisation. Synonym: Floor limit."),
    _86("86", "Wrong authorisation code", "The adjustment was made due to the authorisation code provided did not fit to the specified transaction."),
    _87("87", "Wrong authorised amount", "The adjustment was made due to the specified amount not meeting the authorised amount for the transaction."),
    _88("88", "Authorisation failed", "The adjustment was made due to the authorisation needed had failed."),
    _89("89", "Card acceptor data error", "The adjustment was made due to the data regarding the card acceptor is erroneous."),
    _90("90", "Treasury management service charge", "Charge for the service of treasury management."),
    _91("91", "Agreed discount", "The reason for the adjustment is that a mutually agreed discount has been applied."),
    _92("92", "Expediting fee", "The reason for the adjustment is that a fee for expediting has been applied."),
    _93("93", "Invoicing fee", "The reason for the adjustment is that a fee for invoicing has been applied."),
    _94("94", "Freight charge", "The reason for the adjustment is that freight charges has been applied."),
    _95("95", "Small order processing service charge", "The reason for the adjustment is that a fee for processing of a small order (an order below a defined threshold) has been applied."),
    _96("96", "Currency exchange differences", "An adjustment made due to a change in a currency exchange rate."),
    _97("97", "Insolvency", "An adjustment made due to the partner's inability to pay open debts."),
    ZZZ("ZZZ", "Mutually defined", "A code assigned within a code list to be used on an interim basis and as defined among trading partners until a precise code can be assigned to the code list.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_ID = "UN/ECE 3155";
    public static final String LIST_VERSION = "D10B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    private EAllowanceChargeReasonCode21(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName, @Nullable final String sDescription) {
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
    public static EAllowanceChargeReasonCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EAllowanceChargeReasonCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final EAllowanceChargeReasonCode21 eValue = EAllowanceChargeReasonCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
