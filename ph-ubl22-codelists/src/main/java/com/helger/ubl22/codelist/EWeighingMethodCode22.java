package com.helger.ubl22.codelist;

import com.helger.commons.annotation.CodingStyleguideUnaware;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * This file was automatically generated from Genericode file WeighingMethodCode-2.2.gc. Do NOT edit!
 * It contains a total of 2 entries!
 * @author com.helger.ubl22.main.MainCreateEnumsGenericode22
 */
@CodingStyleguideUnaware
public enum EWeighingMethodCode22
    implements IHasID<String> , IHasDisplayName
{
    SM1("SM1", "SOLAS verification method 1", "Weighing the packed container using calibrated and certified equipment"),
    SM2("SM2", "SOLAS verification method 2", "Weighing all packages and cargo items, including the mass of pallets, dunnage and other securing material to be packed in the container and adding the tare mass of the container to the sum of the single masses, using a certified method approved by the competent authority of the State in which packing of the container was completed.");
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    private EWeighingMethodCode22(
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
    public static EWeighingMethodCode22 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(EWeighingMethodCode22 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(
        @Nullable
        final String sID) {
        final EWeighingMethodCode22 eValue = EWeighingMethodCode22 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
