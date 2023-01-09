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
 * This file was automatically generated from Genericode file HazardousCategoryCode-2.1.gc. Do NOT edit!
 * It contains a total of 18 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EHazardousCategoryCode21
    implements IHasID<String> , IHasDisplayName
{
    ADR("ADR", "European agreement on the international carriage of dangerous goods on road (ADR)", "European agreement on the international carriage of dangerous goods on road. ADR is the abbreviation of \"Accord europeen relatif au transport international des marchandises dangereuses par route\"."),
    ADS("ADS", "NDR European agreement for the transport of dangerous goods on the river Rhine", "European agreement giving regulations for the transport of dangerous goods on the river Rhine, officially known as: \"Accord europeen relatif au transport international des marchandises dangereuses par navigation sur le Rhin.\"."),
    ADT("ADT", "CA, Transport Canada's dangerous goods requirements", "Canadian transport of dangerous goods requirements as published by Transport Canada in the Canadian Gazette, Part II."),
    ADU("ADU", "JP, Japanese maritime safety agency dangerous goods regulation code", "Regulation regarding the handling of dangerous goods on vessels issued by Japanese maritime safety agency."),
    ADV("ADV", "MARPOL 73/78", "International Convention for the Prevention of Pollution from Ships, 1973, as modified by the Protocol of 1978 relating."),
    AGS("AGS", "DE, ADR and GGVS combined regulations for combined transport", "Combined German and European regulations for the transportation of dangerous goods on German and other European roads. ADR means: Accord Europeen relatif au Transport international des marchandises Dangereuses par Route. GGVS means: Gefahrgutverordnung Strasse."),
    ANR("ANR", "ADNR, Autorisation de transport de matieres Dangereuses pour la Navigation sur le Rhin", "Regulations for dangerous goods transportation on the Rhine."),
    ARD("ARD", "DE, ARD and RID - Combined regulations for combined transport", "Combined European regulations for the combined transportation of dangerous goods on roads and rails. ARD means: Autorisation de transport par Route de matieres dangereuses. RID means: Reglement International concernant le transport des marchandises Dangereuses par chemin de fer."),
    CFR("CFR", "US, 49 Code of federal regulations", "United States federal regulations issued by the US Department of transportation covering the domestic transportation of dangerous goods by truck, rail, water and air."),
    COM("COM", "DE, ADR, RID, GGVS and GGVE - Combined regulations for combined transport", "Combined German and European regulations for the combined transportation of dangerous goods on German and other European roads and rails. ADR means: Accord Europeen relatif au transport international des marchandises Dangereuse par Route. RID means: Reglement International concernant le transport des marchandises Dangereuses par chemin de fer. GGVS means: Gefahrgutverordnung Strasse. GGVE means: Gefahrgutverordnung Eisenbahn."),
    GVE("GVE", "DE, GGVE (Gefahrgutverordnung Eisenbahn)", "German regulation for the transportation of dangerous goods on rail."),
    GVS("GVS", "DE, GGVS (Gefahrgutverordnung Strasse)", "German regulation for the transportation of dangerous goods on road."),
    ICA("ICA", "IATA ICAO", "Regulations covering the international transportation of dangerous goods issued by the International Air Transport Association and the International Civil Aviation Organization."),
    IMD("IMD", "IMO IMDG code", "Regulations regarding the transportation of dangerous goods on ocean-going vessels issued by the International Maritime Organization."),
    RGE("RGE", "DE, RID and GGVE, Combined regulations for combined transport on rails", "Combined German and European regulations for the transportation of dangerous goods on German and other European rails. RID means: Reglement International concernant le transport des marchandises Dangereuses par chemin de fer. GGVE means: Gefahrgutverordnung Eisenbahn."),
    RID("RID", "Railroad dangerous goods book (RID)", "International regulations concerning the international carriage of dangerous goods by rail. RID is the abbreviation of \"Reglement International concernant le transport des marchandises Dangereuses par chemin de fer\"."),
    UI("UI", "UK IMO book", "The United Kingdom (UK) version of the International Maritime Organisation (IMO) book on dangerous goods."),
    ZZZ("ZZZ", "Mutually defined", "Additional and/or other information for the transportation of dangerous goods which are mutually defined.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_VERSION = "D10B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    private EHazardousCategoryCode21(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName, @Nullable final String sDescription) {
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
    public static EHazardousCategoryCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EHazardousCategoryCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final EHazardousCategoryCode21 eValue = EHazardousCategoryCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
