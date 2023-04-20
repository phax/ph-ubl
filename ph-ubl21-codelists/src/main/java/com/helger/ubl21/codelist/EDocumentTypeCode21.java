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
 * This file was automatically generated from Genericode file DocumentTypeCode-2.1.gc. Do NOT edit!
 * It contains a total of 21 entries!
 * @author com.helger.ubl21.supplementary.tools.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EDocumentTypeCode21
    implements IHasID<String> , IHasDisplayName
{
    _105("105", "Purchase order", "Document/message issued within an enterprise to initiate the purchase of articles, materials or services required for the production or manufacture of goods to be offered for sale or otherwise supplied to customers."),
    _220("220", "Order", "Document/message by means of which a buyer initiates a transaction with a seller involving the supply of goods or services as specified, according to conditions set out in an offer, or otherwise known to the buyer."),
    _223("223", "Lease order", "Document/message for goods in leasing contracts."),
    _224("224", "Rush order", "Document/message for urgent ordering."),
    _245("245", "Delivery release", "Document/message issued by a buyer releasing the despatch of goods after receipt of the Ready for despatch advice from the seller."),
    _315("315", "Contract", "(1296) Document/message evidencing an agreement between the seller and the buyer for the supply of goods or services; its effects are equivalent to those of an order followed by an acknowledgement of order."),
    _320("320", "Acknowledgement of order", "Document/message acknowledging an undertaking to fulfil an order and confirming conditions or acceptance of conditions."),
    _325("325", "Proforma invoice", "Document/message serving as a preliminary invoice, containing - on the whole - the same information as the final invoice, but not actually claiming payment."),
    _326("326", "Partial invoice", "Document/message specifying details of an incomplete invoice."),
    _380("380", "Commercial invoice", "(1334) Document/message claiming payment for goods or services supplied under conditions agreed between seller and buyer."),
    _389("389", "Self-billed invoice", "An invoice the invoicee is producing instead of the seller."),
    _393("393", "Factored invoice", "Invoice assigned to a third party for collection."),
    _394("394", "Lease invoice", "Usage of INVOIC-message for goods in leasing contracts."),
    _395("395", "Consignment invoice", "Commercial invoice that covers a transaction other than one involving a sale."),
    _398("398", "Cross docking despatch advice", "Document by means of which the supplier or consignor informs the buyer, consignee or the distribution centre about the despatch of goods for cross docking."),
    _399("399", "Transshipment despatch advice", "Document by means of which the supplier or consignor informs the buyer, consignee or the distribution centre about the despatch of goods for transshipment."),
    _455("455", "Extended credit advice", "Document/message sent by an account servicing institution to one of its account owners, to inform the account owner of an entry that has been or will be credited to its account for a specified amount on the date indicated. It provides extended commercial information concerning the relevant remittance advice."),
    _481("481", "Remittance advice", "Document/message advising of the remittance of payment."),
    _533("533", "Original accounting voucher", "To indicate that the document/message justifying an accounting entry is original."),
    _534("534", "Copy accounting voucher", "To indicate that the document/message justifying an accounting entry is a copy."),
    _640("640", "Delivery order", "Document/message issued by a party entitled to authorize the release of goods specified therein to a named consignee, to be retained by the custodian of the goods.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_VERSION = "D10B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    EDocumentTypeCode21(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName, @Nullable final String sDescription) {
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
    public static EDocumentTypeCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EDocumentTypeCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final EDocumentTypeCode21 eValue = EDocumentTypeCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
