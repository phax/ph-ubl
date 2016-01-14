/**
 * Copyright (C) 2014-2016 Philip Helger (www.helger.com)
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
 * This file was automatically generated from Genericode file PartyRoleCode-2.1.gc. Do NOT edit!
 * It contains a total of 20 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 * 
 */
@CodingStyleguideUnaware
public enum EPartyRoleCode21
    implements IHasID<String> , IHasDisplayName
{
    AB("AB", "Buyer's agent/representative", "Third party who arranged the purchase of merchandise on behalf of the actual buyer."),
    AE("AE", "Declarant's agent/representative", "Any natural or legal person who makes a declaration to an official body on behalf of another natural or legal person, where legally permitted (CCC)."),
    AF("AF", "Transit principal", "Natural or legal person responsible for the satisfactory performance of a Customs transit operation. Source: CCC."),
    AH("AH", "Transit principal's agent/representative", "Agent acting on behalf of the transit principal (CCC)."),
    AQ("AQ", "Approved consignor", "Person or company approved by the relevant authority in the country to pack and export specific goods under Customs supervision."),
    AR("AR", "Authorized exporter", "Exporter authorized/approved by Customs for special Customs procedures e.g. simplified procedure."),
    AT("AT", "Authorized importer", "Importer authorized/approved by Customs for special Customs procedures e.g. simplified procedure."),
    AU("AU", "Authorized trader (transit)", "Trader authorized/approved by Customs for special transit procedures e.g. simplified procedure."),
    CA("CA", "Carrier", "[3126] Party undertaking or arranging transport of goods between named points."),
    CG("CG", "Carrier's agent", "Party authorized to act for or on behalf of carrier."),
    CN("CN", "Consignee", "[3132] Party to which goods are consigned."),
    CPD("CPD", "Charges payer at destination", "Party, other than the ordering party, which has to pay the charges concerning the destination operations."),
    CX("CX", "Consignee's agent", "Party authorized to act on behalf of the consignee."),
    CZ("CZ", "Consignor", "[3336] Party which, by contract with a carrier, consigns or sends goods with the carrier, or has them conveyed by him. Synonym: shipper, sender."),
    EX("EX", "Exporter", "[3030] Party who makes, or on whose behalf the export declaration is made, and who is the owner of the goods or has similar rights of disposal over them at the time when the declaration is accepted."),
    FW("FW", "Freight forwarder", "Party arranging forwarding of goods."),
    GS("GS", "Consignor's representative", "Party authorised to represent the consignor."),
    IM("IM", "Importer", "[3020] Party who makes - or on whose behalf a Customs clearing agent or other authorized person makes - an import declaration. This may include a person who has possession of the goods or to whom the goods are consigned."),
    IV("IV", "Invoicee", "[3006] Party to whom an invoice is issued."),
    PE("PE", "Payee", "Identifies the credit party when other than the beneficiary.");
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    private EPartyRoleCode21(
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
    public static EPartyRoleCode21 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(EPartyRoleCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(
        @Nullable
        final String sID) {
        final EPartyRoleCode21 eValue = EPartyRoleCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
