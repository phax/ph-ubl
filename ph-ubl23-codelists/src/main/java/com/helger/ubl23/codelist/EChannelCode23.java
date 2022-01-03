/*
 * Copyright (C) 2014-2022 Philip Helger (www.helger.com)
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
package com.helger.ubl23.codelist;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * This file was automatically generated from Genericode file ChannelCode-2.3.gc. Do NOT edit!
 * It contains a total of 47 entries!
 * @author com.helger.ubl23.main.MainCreateEnumsGenericode23
 */
@CodingStyleguideUnaware
public enum EChannelCode23
    implements IHasID<String> , IHasDisplayName
{
    AA("AA", "Circuit switching", "A process that, on demand, connects two or more data terminal equipments and permits the exclusive use of a data circuit between them until the connection is released (ISO)."),
    AB("AB", "SITA", "Communications number assigned by Societe Internationale de Telecommunications Aeronautiques (SITA)."),
    AC("AC", "ARINC", "Communications number assigned by Aeronautical Radio Inc."),
    AD("AD", "AT&T mailbox", "AT&T mailbox identifier."),
    AE("AE", "Peripheral device", "Peripheral device identification."),
    AF("AF", "U.S. Defense Switched Network", "The switched telecommunications network of the United States Department of Defense."),
    AG("AG", "U.S. federal telecommunications system", "The switched telecommunications network of the United States government."),
    AH("AH", "World Wide Web", "Data exchange via the World Wide Web."),
    AI("AI", "International calling country code", "Identifies that portion of an international telephone number representing the country code to be used when calling internationally."),
    AJ("AJ", "Alternate telephone", "Identifies the alternate telephone number."),
    AK("AK", "Videotex number", "Code that identifies the communications number for the online videotex service."),
    AL("AL", "Cellular phone", "Identifies the cellular phone number."),
    AM("AM", "International telephone direct line", "The international telephone direct line number."),
    AN("AN", "O.F.T.P. (ODETTE File Transfer Protocol)", "ODETTE File Transfer Protocol."),
    AO("AO", "Uniform Resource Location (URL)", "Identification of the Uniform Resource Location (URL) Synonym: World wide web address."),
    AP("AP", "Very High Frequency (VHF) radio telephone", "VHF radio telephone."),
    AQ("AQ", "X.400 address for mail text", "The X.400 address accepting information in the body text of a message."),
    AR("AR", "AS1 address", "Address capable of receiving messages in accordance with the EDIINT/AS1 protocol for MIME based EDI ."),
    AS("AS", "AS2 address", "Address capable of receiving messages in accordance with the EDIINT/AS2 protocol."),
    AT("AT", "AS3 address", "Address capable of receiving messages in accordance with the EDIINT/AS3 protocol."),
    AU("AU", "File Transfer Protocol", "Address capable for receiving message in accordance with the File Transfer Protocol (IETF RFC 959 et. al.)."),
    AV("AV", "Inmarsat call number", "Contact number based on Inmarsat."),
    AW("AW", "Radio communication call sign", "Contact number for radio communication based on call sign."),
    CA("CA", "Cable address", "The communication number identifies a cable address."),
    EI("EI", "EDI transmission", "Number identifying the service and service user."),
    EM("EM", "Electronic mail", "Exchange of mail by electronic means."),
    EX("EX", "Extension", "Telephone extension."),
    FT("FT", "File transfer access method", "According to ISO."),
    FX("FX", "Telefax", "Device used for transmitting and reproducing fixed graphic material (as printing) by means of signals over telephone lines or other electronic transmission media."),
    GM("GM", "GEIS (General Electric Information Service) mailbox", "The communication number identifies a GEIS mailbox."),
    IE("IE", "IBM information exchange", "The communication number identifies an IBM IE mailbox."),
    IM("IM", "Internal mail", "Internal mail address/number."),
    MA("MA", "Mail", "Postal service document delivery."),
    PB("PB", "Postbox number", "The communication number identifies a postbox."),
    PS("PS", "Packet switching", "The process of routing and transferring data by means of addressed packets so that a channel is occupied only during the transmission; upon completion of the transmission the channel is made available for the transfer of other packets (ISO)."),
    SW("SW", "S.W.I.F.T.", "Communications address assigned by Society for Worldwide Interbank Financial Telecommunications s.c."),
    TE("TE", "Telephone", "Voice/data transmission by telephone."),
    TG("TG", "Telegraph", "Text transmission via telegraph."),
    TL("TL", "Telex", "Transmission of text/data via telex."),
    TM("TM", "Telemail", "Transmission of text/data via telemail."),
    TT("TT", "Teletext", "Transmission of text/data via teletext."),
    TX("TX", "TWX", "Communication service involving Teletypewriter machines connected by wire or electronic transmission media. Teletypewriter machines are the devices used to send and receive signals and produce hardcopy from them."),
    XF("XF", "X.400 address", "The X.400 address."),
    XG("XG", "Pager", "Identifies that the communication number is for a pager."),
    XH("XH", "International telephone switchboard", "The international telephone switchboard number."),
    XI("XI", "National telephone direct line", "The national telephone direct line number."),
    XJ("XJ", "National telephone switchboard", "The national telephone switchboard number.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_ID = "UN/EDIFACT EDED 3155";
    public static final String LIST_VERSION = "18B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    private EChannelCode23(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName, @Nullable final String sDescription) {
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
    public static EChannelCode23 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EChannelCode23 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final EChannelCode23 eValue = EChannelCode23 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
