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

import com.helger.annotation.Nonempty;
import com.helger.annotation.style.CodingStyleguideUnaware;
import com.helger.base.id.IHasID;
import com.helger.base.lang.EnumHelper;
import com.helger.base.name.IHasDisplayName;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;


/**
 * This file was automatically generated from Genericode file ItemClassificationCode-2.1.gc. Do NOT edit!
 * It contains a total of 165 entries!
 * @author com.helger.ubl21.supplementary.tools.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EItemClassificationCode21
    implements IHasID<String> , IHasDisplayName
{
    AA("AA", "Product version number", "Number assigned by manufacturer or seller to identify the release of a product."),
    AB("AB", "Assembly", "The item number is that of an assembly."),
    AC("AC", "HIBC (Health Industry Bar Code)", "Article identifier used within health sector to indicate data used conforms to HIBC."),
    AD("AD", "Cold roll number", "Number assigned to a cold roll."),
    AE("AE", "Hot roll number", "Number assigned to a hot roll."),
    AF("AF", "Slab number", "Number assigned to a slab, which is produced in a particular production step."),
    AG("AG", "Software revision number", "A number assigned to indicate a revision of software."),
    AH("AH", "UPC (Universal Product Code) Consumer package code (1-5-5)", "An 11-digit code that uniquely identifies consumer packaging of a product; does not have a check digit."),
    AI("AI", "UPC (Universal Product Code) Consumer package code (1-5-5-1)", "A 12-digit code that uniquely identifies the consumer packaging of a product, including a check digit."),
    AJ("AJ", "Sample number", "Number assigned to a sample."),
    AK("AK", "Pack number", "Number assigned to a pack containing a stack of items put together (e.g. cold roll sheets (steel product))."),
    AL("AL", "UPC (Universal Product Code) Shipping container code (1-2-5-5)", "A 13-digit code that uniquely identifies the manufacturer's shipping unit, including the packaging indicator."),
    AM("AM", "UPC (Universal Product Code)/EAN (European article number) Shipping container code (1-2-5-5-1)", "A 14-digit code that uniquely identifies the manufacturer's shipping unit, including the packaging indicator and the check digit."),
    AN("AN", "UPC (Universal Product Code) suffix", "A suffix used in conjunction with a higher level UPC (Universal product code) to define packing variations for a product."),
    AO("AO", "State label code", "A code which specifies the codification of the state's labelling requirements."),
    AP("AP", "Heat number", "Number assigned to the heat (also known as the iron charge) for the production of steel products."),
    AQ("AQ", "Coupon number", "A number identifying a coupon."),
    AR("AR", "Resource number", "A number to identify a resource."),
    AS("AS", "Work task number", "A number to identify a work task."),
    AT("AT", "Price look up number", "Identification number on a product allowing a quick electronic retrieval of price information for that product."),
    AU("AU", "NSN (North Atlantic Treaty Organization Stock Number)", "Number assigned under the NATO (North Atlantic Treaty Organization) codification system to provide the identification of an approved item of supply."),
    AV("AV", "Refined product code", "A code specifying the product refinement designation."),
    AW("AW", "Exhibit", "A code indicating that the product is identified by an exhibit number."),
    AX("AX", "End item", "A number specifying an end item."),
    AY("AY", "Federal supply classification", "A code to specify a product's Federal supply classification."),
    AZ("AZ", "Engineering data list", "A code specifying the product's engineering data list."),
    BA("BA", "Milestone event number", "A number to identify a milestone event."),
    BB("BB", "Lot number", "A number indicating the lot number of a product."),
    BC("BC", "National drug code 4-4-2 format", "A code identifying the product in national drug format 4-4-2."),
    BD("BD", "National drug code 5-3-2 format", "A code identifying the product in national drug format 5-3-2."),
    BE("BE", "National drug code 5-4-1 format", "A code identifying the product in national drug format 5-4-1."),
    BF("BF", "National drug code 5-4-2 format", "A code identifying the product in national drug format 5-4-2."),
    BG("BG", "National drug code", "A code specifying the national drug classification."),
    BH("BH", "Part number", "A number indicating the part."),
    BI("BI", "Local Stock Number (LSN)", "A local number assigned to an item of stock."),
    BJ("BJ", "Next higher assembly number", "A number specifying the next higher assembly or component into which the product is being incorporated."),
    BK("BK", "Data category", "A code specifying a category of data."),
    BL("BL", "Control number", "To specify the control number."),
    BM("BM", "Special material identification code", "A number to identify the special material code."),
    BN("BN", "Locally assigned control number", "A number assigned locally for control purposes."),
    BO("BO", "Buyer's colour", "Colour assigned by buyer."),
    BP("BP", "Buyer's part number", "Reference number assigned by the buyer to identify an article."),
    BQ("BQ", "Variable measure product code", "A code assigned to identify a variable measure item."),
    BR("BR", "Financial phase", "To specify as an item, the financial phase."),
    BS("BS", "Contract breakdown", "To specify as an item, the contract breakdown."),
    BT("BT", "Technical phase", "To specify as an item, the technical phase."),
    BU("BU", "Dye lot number", "Number identifying a dye lot."),
    BV("BV", "Daily statement of activities", "A statement listing activities of one day."),
    BW("BW", "Periodical statement of activities within a bilaterally agreed time period", "Periodical statement listing activities within a bilaterally agreed time period."),
    BX("BX", "Calendar week statement of activities", "A statement listing activities of a calendar week."),
    BY("BY", "Calendar month statement of activities", "A statement listing activities of a calendar month."),
    BZ("BZ", "Original equipment number", "Original equipment number allocated to spare parts by the manufacturer."),
    CC("CC", "Industry commodity code", "The codes given to certain commodities by an industry."),
    CG("CG", "Commodity grouping", "Code for a group of articles with common characteristics (e.g. used for statistical purposes)."),
    CL("CL", "Colour number", "Code for the colour of an article."),
    CR("CR", "Contract number", "Reference number identifying a contract."),
    CV("CV", "Customs article number", "Code defined by Customs authorities to an article or a group of articles for Customs purposes."),
    DR("DR", "Drawing revision number", "Reference number indicating that a change or revision has been applied to a drawing."),
    DW("DW", "Drawing", "Reference number identifying a drawing of an article."),
    EC("EC", "Engineering change level", "Reference number indicating that a change or revision has been applied to an article's specification."),
    EF("EF", "Material code", "Code defining the material's type, surface, geometric form plus various classifying characteristics."),
    EN("EN", "International Article Numbering Association (EAN)", "Number assigned to a manufacturer's product according to the International Article Numbering Association."),
    GB("GB", "Buyer's internal product group code", "Product group code used within a buyer's internal systems."),
    GN("GN", "National product group code", "National product group code. Administered by a national agency."),
    GS("GS", "General specification number", "The item number is a general specification number."),
    HS("HS", "Harmonised system", "The item number is part of, or is generated in the context of the Harmonised Commodity Description and Coding System (Harmonised System), as developed and maintained by the World Customs Organization (WCO)."),
    IB("IB", "ISBN (International Standard Book Number)", "A unique number identifying a book."),
    IN("IN", "Buyer's item number", "The item number has been allocated by the buyer."),
    IS("IS", "ISSN (International Standard Serial Number)", "A unique number identifying a serial publication."),
    IT("IT", "Buyer's style number", "Number given by the buyer to a specific style or form of an article, especially used for garments."),
    IZ("IZ", "Buyer's size code", "Code given by the buyer to designate the size of an article in textile and shoe industry."),
    MA("MA", "Machine number", "The item number is a machine number."),
    MF("MF", "Manufacturer's (producer's) article number", "The number given to an article by its manufacturer."),
    MN("MN", "Model number", "Reference number assigned by the manufacturer to differentiate variations in similar products in a class or group."),
    MP("MP", "Product/service identification number", "Reference number identifying a product or service."),
    NB("NB", "Batch number", "The item number is a batch number."),
    ON("ON", "Customer order number", "Reference number of a customer's order."),
    PD("PD", "Part number description", "Reference number identifying a description associated with a number ultimately used to identify an article."),
    PL("PL", "Purchaser's order line number", "Reference number identifying a line entry in a customer's order for goods or services."),
    PO("PO", "Purchase order number", "Reference number identifying a customer's order."),
    PV("PV", "Promotional variant number", "The item number is a promotional variant number."),
    QS("QS", "Buyer's qualifier for size", "The item number qualifies the size of the buyer."),
    RC("RC", "Returnable container number", "Reference number identifying a returnable container."),
    RN("RN", "Release number", "Reference number identifying a release from a buyer's purchase order."),
    RU("RU", "Run number", "The item number identifies the production or manufacturing run or sequence in which the item was manufactured, processed or assembled."),
    RY("RY", "Record keeping of model year", "The item number relates to the year in which the particular model was kept."),
    SA("SA", "Supplier's article number", "Number assigned to an article by the supplier of that article."),
    SG("SG", "Standard group of products (mixed assortment)", "The item number relates to a standard group of other items (mixed) which are grouped together as a single item for identification purposes."),
    SK("SK", "SKU (Stock keeping unit)", "Reference number of a stock keeping unit."),
    SN("SN", "Serial number", "Identification number of an item which distinguishes this specific item out of a number of identical items."),
    SRS("SRS", "RSK number", "Plumbing and heating."),
    SRT("SRT", "IFLS (Institut Francais du Libre Service) 5 digit product classification code", "5 digit code for product classification managed by the Institut Francais du Libre Service."),
    SRU("SRU", "IFLS (Institut Francais du Libre Service) 9 digit product classification code", "9 digit code for product classification managed by the Institut Francais du Libre Service."),
    SRV("SRV", "EAN.UCC Global Trade Item Number", "A unique number, up to 14-digits, assigned according to the numbering structure of the EAN.UCC system. 'EAN' stands for the 'International Article Numbering Association', and 'UCC' for the 'Uniform Code Council'."),
    SRW("SRW", "EDIS (Energy Data Identification System)", "European system for identification of meter data."),
    SRX("SRX", "Slaughter number", "Unique number given by a slaughterhouse to an animal or a group of animals of the same breed."),
    SRY("SRY", "Official animal number", "Unique number given by a national authority to identify an animal individually."),
    SRZ("SRZ", "Harmonized tariff schedule", "The international Harmonized Tariff Schedule (HTS) to classify the article for customs, statistical and other purposes."),
    SS("SS", "Supplier's supplier article number", "Article number referring to a sales catalogue of supplier's supplier."),
    SSA("SSA", "46 Level DOT Code", "A US Department of Transportation (DOT) code to identify hazardous (dangerous) goods, managed by the Customs and Border Protection (CBP) agency."),
    SSB("SSB", "Airline Tariff 6D", "A US code agreed to by the airline industry to identify hazardous (dangerous) goods, managed by the Customs and Border Protection (CBP) agency."),
    SSC("SSC", "Title 49 Code of Federal Regulations", "A US Customs and Border Protection (CBP) code used to identify hazardous (dangerous) goods."),
    SSD("SSD", "International Civil Aviation Administration code", "A US Department of Transportation/Federal Aviation Administration code used to identify hazardous (dangerous) goods, managed by the Customs and Border Protection (CBP) agency."),
    SSE("SSE", "Hazardous Materials ID DOT", "A US Department of Transportation (DOT) code used to identify hazardous (dangerous) goods, managed by the Customs and Border Protection (CBP) agency."),
    SSF("SSF", "Endorsement", "A US Customs and Border Protection (CBP) code used to identify hazardous (dangerous) goods."),
    SSG("SSG", "Air Force Regulation 71-4", "A department of Defense/Air Force code used to identify hazardous (dangerous) goods, managed by the Customs and Border Protection (CBP) agency."),
    SSH("SSH", "Breed", "The breed of the item (e.g. plant or animal)."),
    SSI("SSI", "Chemical Abstract Service (CAS) registry number", "A unique numerical identifier for for chemical compounds, polymers, biological sequences, mixtures and alloys."),
    SSJ("SSJ", "Engine model designation", "A name or designation to identify an engine model."),
    SSK("SSK", "Institutional Meat Purchase Specifications (IMPS) Number", "A number assigned by agricultural authorities to identify and track meat and meat products."),
    SSL("SSL", "Price Look-Up code (PLU)", "Identification number affixed to produce in stores to retrieve price information."),
    SSM("SSM", "International Maritime Organization (IMO) Code", "An International Maritime Organization (IMO) code used to identify hazardous (dangerous) goods."),
    SSN("SSN", "Bureau of Explosives 600-A (rail)", "A Department of Transportation/Federal Railroad Administration code used to identify hazardous (dangerous) goods."),
    SSO("SSO", "United Nations Dangerous Goods List", "A UN code used to classify and identify dangerous goods."),
    SSP("SSP", "International Code of Botanical Nomenclature (ICBN)", "A code established by the International Code of Botanical Nomenclature (ICBN) used to classify and identify botanical articles and commodities."),
    SSQ("SSQ", "International Code of Zoological Nomenclature (ICZN)", "A code established by the International Code of Zoological Nomenclature (ICZN) used to classify and identify animals."),
    SSR("SSR", "International Code of Nomenclature for Cultivated Plants (ICNCP)", "A code established by the International Code of Nomenclature for Cultivated Plants (ICNCP) used to classify and identify animals."),
    SSS("SSS", "Distributor\u00d5s article identifier", "Identifier assigned to an article by the distributor of that article."),
    SST("SST", "Norwegian Classification system ENVA", "Product classification system used in the Norwegian market."),
    SSU("SSU", "Supplier assigned classification", "Product classification assigned by the supplier."),
    SSV("SSV", "Mexican classification system AMECE", "Product classification system used in the Mexican market."),
    SSW("SSW", "German classification system CCG", "Product classification system used in the German market."),
    SSX("SSX", "Finnish classification system EANFIN", "Product classification system used in the Finnish market."),
    SSY("SSY", "Canadian classification system ICC", "Product classification system used in the Canadian market."),
    SSZ("SSZ", "French classification system IFLS5", "Product classification system used in the French market."),
    ST("ST", "Style number", "Number given to a specific style or form of an article, especially used for garments."),
    STA("STA", "Dutch classification system CBL", "Product classification system used in the Dutch market."),
    STB("STB", "Japanese classification system JICFS", "Product classification system used in the Japanese market."),
    STC("STC", "European Union dairy subsidy eligibility classification", "Category of product eligible for EU subsidy (applies for certain dairy products with specific level of fat content)."),
    STD("STD", "GS1 Spain classification system", "Product classification system used in the Spanish market."),
    STE("STE", "GS1 Poland classification system", "Product classification system used in the Polish market."),
    STF("STF", "Federal Agency on Technical Regulating and Metrology of the Russian Federation", "A Russian government agency that serves as a national standardization body of the Russian Federation."),
    STG("STG", "Efficient Consumer Response (ECR) Austria classification system", "Product classification system used in the Austrian market."),
    STH("STH", "GS1 Italy classification system", "Product classification system used in the Italian market."),
    STI("STI", "CPV (Common Procurement Vocabulary)", "Official classification system for public procurement in the European Union."),
    STJ("STJ", "IFDA (International Foodservice Distributors Association)", "International Foodservice Distributors Association (IFDA)."),
    STK("STK", "AHFS (American Hospital Formulary Service) pharmacologic - therapeutic classification", "Pharmacologic - therapeutic classification maintained by the American Hospital Formulary Service (AHFS)."),
    STL("STL", "ATC (Anatomical Therapeutic Chemical) classification system", "Anatomical Therapeutic Chemical classification system maintained by the World Health Organisation (WHO)."),
    STM("STM", "CLADIMED (Classification des Dispositifs M\u008edicaux)", "A five level classification system for medical decvices maintained by the CLADIMED organisation used in the French market."),
    STN("STN", "CMDR (Canadian Medical Device Regulations) classification system", "Classification system related to the Canadian Medical Device Regulations maintained by Health Canada."),
    STO("STO", "CNDM (Classificazione Nazionale dei Dispositivi Medici)", "A classification system for medical devices used in the Italian market."),
    STP("STP", "UK DM&D (Dictionary of Medicines & Devices) standard coding scheme", "A classification system for medicines and devices used in the UK market."),
    STQ("STQ", "eCl@ss", "Standardized material and service classification and dictionary maintained by eClass e.V."),
    STR("STR", "EDMA (European Diagnostic Manufacturers Association) Products Classification", "Classification for in vitro diagnostics medical devices maintained by the European Diagnostic Manufacturers Association."),
    STS("STS", "EGAR (European Generic Article Register)", "A classification system for medical devices."),
    STT("STT", "GMDN (Global Medical Devices Nomenclature)", "Nomenclature system for identification of medical devices officially apprroved by the European Union."),
    STU("STU", "GPI (Generic Product Identifier)", "A drug classification system managed by Medi-Span."),
    STV("STV", "HCPCS (Healthcare Common Procedure Coding System)", "A classification system used with US healthcare insurance programs."),
    STW("STW", "ICPS (International Classification for Patient Safety)", "A patient safety taxonomy maintained by the World Health Organisation."),
    STX("STX", "MedDRA (Medical Dictionary for Regulatory Activities)", "A medical dictionary maintained by the International Federation of Pharmaceutical Manufacturers and Associations (IFPMA)."),
    STY("STY", "Medical Columbus", "Medical product classification system used in the German market."),
    STZ("STZ", "NAPCS (North American Product Classification System)", "Product classification system used in the North American market."),
    SUA("SUA", "NHS (National Health Services) eClass", "Product and Service classification system used in United Kingdom market."),
    SUB("SUB", "US FDA (Food and Drug Administration) Product Code Classification Database", "US FDA Product Code Classification Database contains medical device names and associated information developed by the Center for Devices and Radiological Health (CDRH)."),
    SUC("SUC", "SNOMED CT (Systematized Nomenclature of Medicine-Clinical Terms)", "A medical nomenclature system developed between the NHS and the College of American Pathologists."),
    SUD("SUD", "UMDNS (Universal Medical Device Nomenclature System)", "A standard international nomenclature and computer coding system for medical devices maintained by the Emergency Care Research Institute (ECRI)."),
    SUE("SUE", "GS1 Global Returnable Asset Identifier, non-serialised", "A unique, 13-digit number assigned according to the numbering structure of the GS1 system and used to identify a type of Reusable Transport Item (RTI)."),
    TG("TG", "Transport group number", "(8012) Additional number to form article groups for packing and/or transportation purposes."),
    UA("UA", "Ultimate customer's article number", "Number assigned by ultimate customer to identify relevant article."),
    UP("UP", "UPC (Universal product code)", "Number assigned to a manufacturer's product by the Product Code Council."),
    VN("VN", "Vendor item number", "Reference number assigned by a vendor/seller identifying a product/service/article."),
    VP("VP", "Vendor's (seller's) part number", "Reference number assigned by a vendor/seller identifying an article."),
    VS("VS", "Vendor's supplemental item number", "The item number is a specified by the vendor as a supplemental number for the vendor's purposes."),
    VX("VX", "Vendor specification number", "The item number has been allocated by the vendor as a specification number."),
    ZZZ("ZZZ", "Mutually defined", "Item type identification mutually agreed between interchanging parties.");
    public static final String AGENCY_ID = "6";
    public static final String AGENCY_LONG_NAME = "United Nations Economic Commission for Europe";
    public static final String LIST_ID = "tred7143";
    public static final String LIST_VERSION = "D12B";
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sDescription;

    EItemClassificationCode21(@Nonnull @Nonempty final String sID, @Nonnull final String sDisplayName, @Nullable final String sDescription) {
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
    public static EItemClassificationCode21 getFromIDOrNull(@Nullable final String sID) {
        return EnumHelper.getFromIDOrNull(EItemClassificationCode21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(@Nullable final String sID) {
        final EItemClassificationCode21 eValue = EItemClassificationCode21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
