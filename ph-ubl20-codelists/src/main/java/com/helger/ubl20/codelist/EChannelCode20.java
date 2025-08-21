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
package com.helger.ubl20.codelist;

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.CodingStyleguideUnaware;
import com.helger.base.id.IHasID;
import com.helger.base.lang.EnumHelper;
import com.helger.base.name.IHasDisplayName;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;

/**
 * This file was automatically generated from Genericode file ChannelCode-2.0.gc. Do NOT edit! It
 * contains a total of 40 entries!
 *
 * @author com.helger.ubl20.supplementary.tools.MainCreateEnumsGenericode20
 */
@CodingStyleguideUnaware
public enum EChannelCode20 implements IHasID <String>, IHasDisplayName
{
  AA ("AA", "Circuit switching"),
  AB ("AB", "SITA"),
  AC ("AC", "ARINC"),
  AD ("AD", "AT&T mailbox"),
  AE ("AE", "Peripheral device"),
  AF ("AF", "U.S. Defense Switched Network"),
  AG ("AG", "U.S. federal telecommunications system"),
  AH ("AH", "World Wide Web"),
  AI ("AI", "International calling country code"),
  AJ ("AJ", "Alternate telephone"),
  AK ("AK", "Videotex number"),
  AL ("AL", "Cellular phone"),
  AM ("AM", "International telephone direct line"),
  AN ("AN", "O.F.T.P. (ODETTE File Transfer Protocol)"),
  AO ("AO", "Uniform Resource Location (URL)"),
  AP ("AP", "Very High Frequency (VHF) radio telephone"),
  CA ("CA", "Cable address"),
  EI ("EI", "EDI transmission"),
  EM ("EM", "Electronic mail"),
  EX ("EX", "Extension"),
  FT ("FT", "File transfer access method"),
  FX ("FX", "Telefax"),
  GM ("GM", "GEIS (General Electric Information Service) mailbox"),
  IE ("IE", "IBM information exchange"),
  IM ("IM", "Internal mail"),
  MA ("MA", "Mail"),
  PB ("PB", "Postbox number"),
  PS ("PS", "Packet switching"),
  SW ("SW", "S.W.I.F.T."),
  TE ("TE", "Telephone"),
  TG ("TG", "Telegraph"),
  TL ("TL", "Telex"),
  TM ("TM", "Telemail"),
  TT ("TT", "Teletext"),
  TX ("TX", "TWX"),
  XF ("XF", "X.400 address"),
  XG ("XG", "Pager"),
  XH ("XH", "International telephone switchboard"),
  XI ("XI", "National telephone direct line"),
  XJ ("XJ", "National telephone switchboard");

  public static final String AGENCY_ID = "6";
  public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
  public static final String LIST_ID = "UN/ECE 3155";
  public static final String LIST_VERSION = "D03A";
  private final String m_sID;
  private final String m_sDisplayName;

  EChannelCode20 (@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName)
  {
    m_sID = sID;
    m_sDisplayName = sDisplayName;
  }

  @Nonnull
  @Nonempty
  public String getID ()
  {
    return m_sID;
  }

  @Nonnull
  public String getDisplayName ()
  {
    return m_sDisplayName;
  }

  @Nullable
  public static EChannelCode20 getFromIDOrNull (@Nullable final String sID)
  {
    return EnumHelper.getFromIDOrNull (EChannelCode20.class, sID);
  }

  @Nullable
  public static String getDisplayNameFromIDOrNull (@Nullable final String sID)
  {
    final EChannelCode20 eValue = EChannelCode20.getFromIDOrNull (sID);
    return ((eValue == null) ? null : eValue.getDisplayName ());
  }
}
