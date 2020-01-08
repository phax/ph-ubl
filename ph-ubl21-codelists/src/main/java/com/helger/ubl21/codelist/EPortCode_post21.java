/**
 * Copyright (C) 2014-2020 Philip Helger (www.helger.com)
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
 * This file was automatically generated from Genericode file PortCode-2.1-post.gc. Do NOT edit!
 * It contains a total of 757 entries!
 * @author com.helger.ubl21.main.MainCreateEnumsGenericode21
 */
@CodingStyleguideUnaware
public enum EPortCode_post21
    implements IHasID<String> , IHasDisplayName
{
    AEAUH("AEAUH", "Abu Dhabi", "Abu Dhabi", "AE", "AZ", "AUH", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "1101", "2428N", "05422E"),
    AEDXB("AEDXB", "Dubai", "Dubai", "AE", "DU", "DXB", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "0407", "2515N", "05516E"),
    AFKBL("AFKBL", "Kabul", "Kabul", "AF", null, "KBL", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    AGANU("AGANU", "Antigua", "Antigua", "AG", null, "ANU", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9601", null, null),
    AIAXA("AIAXA", "Anguilla", "Anguilla", "AI", null, "AXA", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    ALTIA("ALTIA", "Tirana", "Tirana", "AL", null, "TIA", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    AMEVN("AMEVN", "Yerevan", "Yerevan", "AM", "ER", "EVN", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0907", "4011N", "04431E"),
    AOLOB("AOLOB", "Lobito", "Lobito", "AO", null, "LOB", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "RL", "0103", null, null),
    AOLAD("AOLAD", "Luanda", "Luanda", "AO", null, "LAD", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    ARBUE("ARBUE", "Buenos Aires", "Buenos Aires", "AR", "C", "BUE", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "3435S", "05840W"),
    ARCOR("ARCOR", "C\u00f3rdoba", "Cordoba", "AR", "X", "COR", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0212", "3124S", "06411W"),
    ARLQU("ARLQU", "La Quiaca", "La Quiaca", "AR", "Y", "LQU", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AI", "0307", "2206S", "06537W"),
    ARMDQ("ARMDQ", "Mar del Plata", "Mar del Plata", "AR", "B", "MDQ", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "1101", "3803S", "05732W"),
    ARPOC("ARPOC", "Pocitos", "Pocitos", "AR", "A", "POC", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "0004", null, null),
    ARROS("ARROS", "Rosario", "Rosario", "AR", "S", "ROS", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "3257S", "06039W"),
    ARSSJ("ARSSJ", "San Salvador de Jujuy", "San Salvador de Jujuy", "AR", "Y", "SSJ", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0601", "2411S", "06518W"),
    ASPPG("ASPPG", "Pago Pago", "Pago Pago", "AS", null, "PPG", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    ATGRZ("ATGRZ", "Graz", "Graz", "AT", null, "GRZ", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    ATHIR("ATHIR", "Hirschegg", "Hirschegg", "AT", null, "HIR", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    ATINN("ATINN", "Innsbruck", "Innsbruck", "AT", null, "INN", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "9506", null, null),
    ATJUN("ATJUN", "Jungholz", "Jungholz", "AT", null, "JUN", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    ATKLU("ATKLU", "Klagenfurt", "Klagenfurt", "AT", "2", "KLU", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "1101", "4637N", "01418E"),
    ATMIT("ATMIT", "Mittelberg", "Mittelberg", "AT", null, "MIT", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    ATRZL("ATRZL", "Riezlern", "Riezlern", "AT", null, "RZL", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    ATSZG("ATSZG", "Salzburg", "Salzburg", "AT", null, "SZG", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    ATTAT("ATTAT", "Tattendorf", "Tattendorf", "AT", "03", "TAT", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0901", "4757N", "01618E"),
    ATVIE("ATVIE", "Wien", "Wien", "AT", null, "VIE", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    AUADL("AUADL", "Adelaide", "Adelaide", "AU", "SA", "ADL", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AC", "0307", "3455S", "13835E"),
    AUBNE("AUBNE", "Brisbane", "Brisbane", "AU", "QLD", "BNE", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AC", "0307", "2728S", "15301E"),
    AUCBR("AUCBR", "Canberra", "Canberra", "AU", "ACT", "CBR", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AC", "9511", null, null),
    AUCLM("AUCLM", "Claremont", "Claremont", "AU", "WA", "CLM", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "1107", "3159S", "11547E"),
    AUDRW("AUDRW", "Darwin", "Darwin", "AU", "NT", "DRW", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AC", "0307", "1227S", "13050E"),
    AUGLW("AUGLW", "Glen Waverley", "Glen Waverley", "AU", "VIC", "GLW", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "1001", "3753S", "14510E"),
    AUHFR("AUHFR", "Henderson", "Henderson", "AU", "WA", "HFR", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "RL", "1201", "3210S", "11546E"),
    AUHBA("AUHBA", "Hobart", "Hobart", "AU", "TAS", "HBA", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AC", "0307", "4252S", "14718E"),
    AUKNO("AUKNO", "Knoxfield", "Knoxfield", "AU", "VIC", "KNO", "----56--", null, null, null, null, null, "5", "6", null, null, "Postal Exchange, Multimodal", null, "RL", "0901", "3749S", "14458E"),
    AUMAS("AUMAS", "Mascot", "Mascot", "AU", "NSW", "MAS", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0212", "3355S", "15111E"),
    AUMEL("AUMEL", "Melbourne", "Melbourne", "AU", "VIC", "MEL", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AC", "0307", "3749S", "14458E"),
    AUMLL("AUMLL", "Mooloolaba", "Mooloolaba", "AU", "QLD", "MLL", "1-3-5---", null, "1", null, "3", null, "5", null, null, null, "Port, Road Terminal, Postal Exchange", null, "RL", "1107", "2641S", "15308E"),
    AUPER("AUPER", "Perth", "Perth", "AU", "WA", "PER", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AC", "0307", "3157S", "11551E"),
    AUSTL("AUSTL", "Saint Leonards", "Saint Leonards", "AU", "NSW", "STL", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "1101", "3349S", "15112E"),
    AUSYD("AUSYD", "Sydney", "Sydney", "AU", "NSW", "SYD", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AC", "0307", "3351S", "15112E"),
    AUWTN("AUWTN", "Webberton", "Webberton", "AU", "WA", "WTN", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0901", "2845S", "11437E"),
    AUWFD("AUWFD", "Wedgefield", "Wedgefield", "AU", "WA", "WFD", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RQ", "0907", "2022S", "11836E"),
    AWORJ("AWORJ", "Oranjestad", "Oranjestad", "AW", null, "ORJ", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9401", null, null),
    AZBAK("AZBAK", "Baku", "Baku", "AZ", null, "BAK", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9207", null, null),
    BARAJ("BARAJ", "Rajlovac", "Rajlovac", "BA", "BIH", "RAJ", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0401", "4352N", "01818E"),
    BBBGI("BBBGI", "Bridgetown", "Bridgetown", "BB", null, "BGI", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    BDAKH("BDAKH", "Akhaura", "Akhaura", "BD", null, "AKH", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    BDCGP("BDCGP", "Chittagong", "Chittagong", "BD", null, "CGP", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9601", null, null),
    BDDAC("BDDAC", "Dhaka", "Dhaka", "BD", null, "DAC", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    BDLAK("BDLAK", "Laksham", "Laksham", "BD", null, "LAK", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    BDMYM("BDMYM", "Mymensingh", "Mymensingh", "BD", null, "MYM", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    BDPAR("BDPAR", "Parbatipur", "Parbatipur", "BD", null, "PAR", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    BEANR("BEANR", "Antwerpen", "Antwerpen", "BE", "VAN", "ANR", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0307", "5113N", "00425E"),
    BEBIE("BEBIE", "Bierges", "Bierges", "BE", "WBR", "BIE", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0307", "5043N", "00436E"),
    BELIB("BELIB", "Libramont-Chevigny", "Libramont-Chevigny", "BE", "WLX", "LIB", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "AI", "0307", "4955N", "00523E"),
    BFOUA("BFOUA", "Ouagadougou", "Ouagadougou", "BF", null, "OUA", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    BGSOF("BGSOF", "Sofia", "Sofia", "BG", null, "SOF", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    BHBAH("BHBAH", "Bahrain International Airport", "Bahrain International Airport", "BH", "15", "BAH", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "1101", "2616N", "05038E"),
    BIBJM("BIBJM", "Bujumbura", "Bujumbura", "BI", null, "BJM", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    BJCOO("BJCOO", "Cotonou", "Cotonou", "BJ", null, "COO", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    BMBDA("BMBDA", "Hamilton", "Hamilton", "BM", null, "BDA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    BNBWN("BNBWN", "Bandar Seri Begawan", "Bandar Seri Begawan", "BN", null, "BWN", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "0307", "0453N", "11456E"),
    BOCBB("BOCBB", "Cochabamba", "Cochabamba", "BO", "C", "CBB", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "0407", "1723S", "06609W"),
    BOLPB("BOLPB", "La Paz", "La Paz", "BO", "L", "LPB", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0407", "1630S", "06809W"),
    BOSRZ("BOSRZ", "Santa Cruz", "Santa Cruz", "BO", "L", "SRZ", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0407", "1747S", "06311W"),
    BQBON("BQBON", "Bonaire", "Bonaire", "BQ", null, "BON", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "1101", "1207N", "06816W"),
    BQSAB("BQSAB", "Saba", "Saba", "BQ", null, "SAB", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "1101", "1738N", "06314W"),
    BQEUX("BQEUX", "Sint Eustatius", "Sint Eustatius", "BQ", null, "EUX", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "1101", "1729N", "06258W"),
    BRRIO("BRRIO", "Rio de Janeiro", "Rio de Janeiro", "BR", "RJ", "RIO", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    BRSAO("BRSAO", "Sao Paulo", "Sao Paulo", "BR", "SP", "SAO", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    BSNAS("BSNAS", "Nassau", "Nassau", "BS", "NP", "NAS", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0212", "2505N", "07721W"),
    BTPHU("BTPHU", "Phuntsholing", "Phuntsholing", "BT", null, "PHU", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    BTTHI("BTTHI", "Thimbu", "Thimbu", "BT", null, "QJC", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "QQ", "9401", null, null),
    BWGBE("BWGBE", "Gaborone", "Gaborone", "BW", null, "GBE", "--3456--", null, null, null, "3", "4", "5", "6", null, null, "Road Terminal, Airport, Postal Exchange, Multimodal", null, "AI", "0907", "2440S", "02555E"),
    BYMSQ("BYMSQ", "Minsk", "Minsk", "BY", null, "MSQ", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9401", null, null),
    BZBZE("BZBZE", "Belize City", "Belize City", "BZ", null, "BZE", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    CAYYC("CAYYC", "Calgary Apt", "Calgary Apt", "CA", "AB", "YYC", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CAECB("CAECB", "Echo Bay", "Echo Bay", "CA", "ON", "ECB", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "RL", "1201", "4629N", "08404W"),
    CAYHZ("CAYHZ", "Halifax Apt", "Halifax Apt", "CA", "NS", "YHZ", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "8103", null, null),
    CAYHM("CAYHM", "Hamilton Apt", "Hamilton Apt", "CA", "ON", "YHM", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CAYTO("CAYTO", "Metropolitan Area Apt/Toronto", "Metropolitan Area Apt/Toronto", "CA", "ON", "YTO", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "1101", null, null),
    CAMTR("CAMTR", "Montreal", "Montreal", "CA", "QC", "YMQ", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AS", "9905", null, null),
    CAYOW("CAYOW", "Ottawa Apt", "Ottawa Apt", "CA", "ON", "YOW", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "RL", "0207", "4519N", "07539W"),
    CAYQB("CAYQB", "Quebec Apt", "Quebec Apt", "CA", "QC", "YQB", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CAYQR("CAYQR", "Regina Apt", "Regina Apt", "CA", "SK", "YQR", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CARBC("CARBC", "Richmond", "Richmond", "CA", "BC", "RBC", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "0001", null, null),
    CAYSJ("CAYSJ", "Saint-John Apt", "Saint-John Apt", "CA", "NB", "YSJ", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "1101", "4515N", "06602W"),
    CAYYT("CAYYT", "Saint-Johns-Apt", "Saint-Johns-Apt", "CA", "NL", "YYT", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "1101", "4737N", "05245W"),
    CATOR("CATOR", "Toronto", "Toronto", "CA", "ON", "YTO", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AS", "9905", null, null),
    CAVAN("CAVAN", "Vancouver", "Vancouver", "CA", "BC", "YVR", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AS", "9905", null, null),
    CAYVR("CAYVR", "Vancouver Apt", "Vancouver Apt", "CA", "BC", "YVR", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CAYWG("CAYWG", "Winnipeg Apt", "Winnipeg Apt", "CA", "MB", "YWG", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CCCCK("CCCCK", "Cocos Islands", "Cocos Islands", "CC", null, "CCK", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0501", "1200S", "09650E"),
    CDKAS("CDKAS", "Kasumbalesa", "Kasumbalesa", "CD", "KA", "KAS", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "0307", "1211S", "02747E"),
    CDFIH("CDFIH", "Kinshasa", "Kinshasa", "CD", null, "FIH", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9501", null, null),
    CDFBM("CDFBM", "Lubumbashi", "Lubumbashi", "CD", null, "FBM", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AI", "9501", null, null),
    CDUVI("CDUVI", "Uvira", "Uvira", "CD", null, "UVI", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    CFALI("CFALI", "Alindao", "Alindao", "CF", null, "ALI", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFBAB("CFBAB", "Baboua", "Baboua", "CF", null, "BAB", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFBBY("CFBBY", "Bambari", "Bambari", "CF", null, "BBY", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9808", null, null),
    CFBGF("CFBGF", "Bangui", "Bangui", "CF", null, "BGF", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CFBAO("CFBAO", "Baoro", "Baoro", "CF", null, "BAO", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFBTG("CFBTG", "Batangafo", "Batangafo", "CF", null, "BTG", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9808", null, null),
    CFIRO("CFIRO", "Birao", "Birao", "CF", null, "IRO", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CFBOC("CFBOC", "Bocaranga", "Bocaranga", "CF", null, "BOC", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "0207", "0658N", "01538E"),
    CFBOD("CFBOD", "Boda", "Boda", "CF", null, "BOD", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFBSN("CFBSN", "Bossangoa", "Bossangoa", "CF", null, "BSN", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "9808", null, null),
    CFBEM("CFBEM", "Bossemb\u00e9l\u00e9", "Bossembele", "CF", null, "BEM", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0212", "0516N", "01739E"),
    CFBOP("CFBOP", "Bouar", "Bouar", "CF", null, "BOP", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CFBOZ("CFBOZ", "Bozoum", "Bozoum", "CF", null, "BOZ", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9808", null, null),
    CFBIV("CFBIV", "Bria", "Bria", "CF", null, "BIV", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9808", null, null),
    CFCRF("CFCRF", "Carnot", "Carnot", "CF", null, "CRF", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9808", null, null),
    CFDEK("CFDEK", "Dekoa", "Dekoa", "CF", null, "DEK", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFGRI("CFGRI", "Grimari", "Grimari", "CF", null, "GRI", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFKAB("CFKAB", "Kaga Bandoro", "Kaga Bandoro", "CF", null, "KAB", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFKEM("CFKEM", "Kemb\u00e9", "Kembe", "CF", null, "KEM", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFMKI("CFMKI", "M'Baiki", "M'Baiki", "CF", null, "MKI", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9808", null, null),
    CFMKI_1("CFMKI", "M'boki", "M'boki", "CF", null, "MKI", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9808", null, null),
    CFMOB("CFMOB", "Mobaye", "Mobaye", "CF", null, "MOB", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFMON("CFMON", "Mongoumba", "Mongoumba", "CF", null, "MON", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFNDL("CFNDL", "Nd\u00e9l\u00e9", "Ndele", "CF", null, "NDL", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9808", null, null),
    CFNOL("CFNOL", "Nola", "Nola", "CF", null, "NOL", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFOBO("CFOBO", "Obo", "Obo", "CF", null, "OBO", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFPAO("CFPAO", "Paoua", "Paoua", "CF", null, "PAO", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CFSIB("CFSIB", "Sibut", "Sibut", "CF", null, "SIB", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    CGBZV("CGBZV", "Brazzaville", "Brazzaville", "CG", null, "BZV", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CGPNR("CGPNR", "Pointe Noire", "Pointe Noire", "CG", null, "PNR", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    CHBSL("CHBSL", "Basel", "Basel", "CH", "BS", "BSL", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "RL", "8103", null, null),
    CHBUC("CHBUC", "Buchs", "Buchs", "CH", "SG", "BUC", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RQ", "9501", null, null),
    CHCHI("CHCHI", "Chiasso", "Chiasso", "CH", "TI", "CHI", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RQ", "9506", null, null),
    CHGVA("CHGVA", "Gen\u00e8ve", "Geneve", "CH", "GE", "GVA", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    CHGRS("CHGRS", "Gr\u00fcsch", "Grusch", "CH", "GR", "GRS", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0901", "4658N", "00938E"),
    CHLAU("CHLAU", "Lausanne", "Lausanne", "CH", "VD", "LAU", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RQ", "9307", null, null),
    CHZJA("CHZJA", "Le Locle", "Le Locle", "CH", null, "ZJA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RQ", "9601", null, null),
    CHMOT("CHMOT", "M\u00f4tiers", "Motiers", "CH", "NE", "MOT", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "RQ", "0907", "4655N", "00636E"),
    CHSIM("CHSIM", "Saint-Imier", "Saint-Imier", "CH", "BE", "SIM", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RQ", "1101", "4709N", "00700E"),
    CHTRA("CHTRA", "Travers", "Travers", "CH", "NE", "TRA", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RQ", "0907", "4656N", "00641E"),
    CHVSX("CHVSX", "Versoix", "Versoix", "CH", "GE", "VSX", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "1001", "4617N", "00610E"),
    CHZLL("CHZLL", "Zofingen", "Zofingen", "CH", "AG", "ZLL", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "4717N", "00756E"),
    CHZRH("CHZRH", "Zurich", "Zurich", "CH", "ZH", "ZRH", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CIABJ("CIABJ", "Abidjan", "Abidjan", "CI", null, "ABJ", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    CIFEK("CIFEK", "Ferkess\u00e9dougou", "Ferkessedougou", "CI", null, "FEK", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0212", "0936N", "00512W"),
    CKAIT("CKAIT", "Aitutaki", "Aitutaki", "CK", null, "AIT", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    CKRAR("CKRAR", "Rarotonga", "Rarotonga", "CK", null, "RAR", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    CLCCP("CLCCP", "Concepci\u00f3n", "Concepcion", "CL", "BI", "CCP", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0501", "3649S", "07303W"),
    CLSCL("CLSCL", "Santiago", "Santiago", "CL", "RM", "SCL", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0501", "3327S", "07038W"),
    CMDLA("CMDLA", "Douala", "Douala", "CM", null, "DLA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    CMYAO("CMYAO", "Yaound\u00e9", "Yaounde", "CM", "CE", "NSI", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "1101", "0352N", "01131E"),
    CNBJS("CNBJS", "Beijing", "Beijing", "CN", "11", "BJS", "-23456--", null, null, "2", "3", "4", "5", "6", null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AS", "0907", null, null),
    CNPEK("CNPEK", "Capital International Apt/Beijing", "Capital International Apt/Beijing", "CN", "11", "PEK", "---456--", null, null, null, null, "4", "5", "6", null, null, "Airport, Postal Exchange, Multimodal", null, "AS", "0901", "4005N", "11635E"),
    CNCGB("CNCGB", "Changbai", "Changbai", "CN", "22", "CGB", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0601", "4125N", "12810E"),
    CNCGQ("CNCGQ", "Changchun", "Changchun", "CN", "22", "CGQ", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNCSX("CNCSX", "Changsha", "Changsha", "CN", "43", "CSX", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "0701", "2811N", "05900E"),
    CNDLC("CNDLC", "Dalian", "Dalian", "CN", "21", "DLC", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNRLC("CNRLC", "Erenhot", "Erenhot", "CN", "15", "RLC", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "AS", "9506", null, null),
    CNFOC("CNFOC", "Fuzhou", "Fuzhou", "CN", "35", "FOC", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "0401", "2603N", "11918E"),
    CNCAN("CNCAN", "Guangzhou", "Guangzhou", "CN", "44", "CAN", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNHAK("CNHAK", "Haikou", "Haikou", "CN", "46", "HAK", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "0907", null, null),
    CNHLD("CNHLD", "Hailar", "Hailar", "CN", "15", "HLD", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AS", "9506", null, null),
    CNHGH("CNHGH", "Hangzhou", "Hangzhou", "CN", "33", "HGH", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNHFE("CNHFE", "Hefei", "Hefei", "CN", "34", "HFE", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNHKM("CNHKM", "Hekou", "Hekou", "CN", "53", "HKM", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "AS", "0907", null, null),
    CNHET("CNHET", "Hohhot", "Hohhot", "CN", "15", "HET", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNJMN("CNJMN", "Jiangmen", "Jiangmen", "CN", "44", "JMN", "1-3-5---", null, "1", null, "3", null, "5", null, null, null, "Port, Road Terminal, Postal Exchange", null, "AS", "9506", null, null),
    CNKMG("CNKMG", "Kunming", "Kunming", "CN", "53", "KMG", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNLXA("CNLXA", "Lhasa", "Lhasa", "CN", "54", "LXA", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AS", "9506", null, null),
    CNKHN("CNKHN", "Nanchang", "Nanchang", "CN", "36", "KHN", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNNKG("CNNKG", "Nanjing", "Nanjing", "CN", "32", "NKG", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNNNG("CNNNG", "Nanning", "Nanning", "CN", "45", "NNG", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNPIN("CNPIN", "Pingxiang", "Pingxiang", "CN", "45", "PIN", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AS", "0907", null, null),
    CNTAO("CNTAO", "Qingdao", "Qingdao", "CN", "37", "TAO", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNSHA("CNSHA", "Shanghai", "Shanghai", "CN", "31", "SHA", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNSWA("CNSWA", "Shantou", "Shantou", "CN", "44", "SWA", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNSHE("CNSHE", "Shenyang", "Shenyang", "CN", "21", "SHE", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNSZH("CNSZH", "Suzhou", "Suzhou", "CN", "32", "SZV", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AS", "0501", "3118N", "12036E"),
    CNTSN("CNTSN", "Tianjin", "Tianjin", "CN", "12", "TSN", "123456--", null, "1", "2", "3", "4", "5", "6", null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AS", "0907", "3908N", "11710E"),
    CNTME("CNTME", "Tumen", "Tumen", "CN", "22", "TME", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AS", "9506", null, null),
    CNURC("CNURC", "\u00dcr\u00fcmqi", "Urumqi", "CN", "65", "URC", "-23456--", null, null, "2", "3", "4", "5", "6", null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AS", "0907", "4348N", "08735E"),
    CNWEI("CNWEI", "Weihai", "Weihai", "CN", "37", "WEI", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AS", "0907", null, null),
    CNWEH("CNWEH", "Weihai Apt", "Weihai Apt", "CN", "37", "WEH", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AS", "0901", null, null),
    CNWUH("CNWUH", "Wuhan", "Wuhan", "CN", "42", "WUH", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNSIA("CNSIA", "Xi An", "Xi An", "CN", "61", "SIA", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNXMN("CNXMN", "Xiamen", "Xiamen", "CN", "35", "XMN", "12-45---", null, "1", "2", null, "4", "5", null, null, null, "Port, Rail Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNYDZ("CNYDZ", "Yadong", "Yadong", "CN", "54", "YDZ", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0601", "2726N", "08855E"),
    CNCGO("CNCGO", "Zhengzhou", "Zhengzhou", "CN", "41", "CGO", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AS", "9503", null, null),
    CNZHQ("CNZHQ", "Zhuanqiao", "Zhuanqiao", "CN", "31", "ZHQ", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RQ", "0901", "3113N", "12127E"),
    CNZUH("CNZUH", "Zhuhai", "Zhuhai", "CN", "44", "ZUH", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AS", "0501", "2216N", "11334E"),
    COBAQ("COBAQ", "Barranquilla", "Barranquilla", "CO", null, "BAQ", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    COBOG("COBOG", "Bogot\u00e1", "Bogota", "CO", "CUN", "BOG", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0307", "0436N", "07405W"),
    CRSJO("CRSJO", "San Jos\u00e9", "San Jose", "CR", "SJ", "SJO", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0407", "0956N", "08405W"),
    CUHAV("CUHAV", "La Habana", "La Habana", "CU", "03", "HAV", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0501", "2307N", "08221W"),
    CVVXE("CVVXE", "Sao Vicente", "Sao Vicente", "CV", null, "VXE", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    CWCUR("CWCUR", "Cura\u00e7ao", "Curacao", "CW", null, "CUR", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "1101", "1210N", "06900W"),
    CXXCH("CXXCH", "Christmas Island", "Christmas Island", "CX", null, "XCH", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    CYLCA("CYLCA", "Larnaca", "Larnaca", "CY", null, "LCA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    CYLMS("CYLMS", "Limassol", "Limassol", "CY", null, "LMS", "1-3-5---", null, "1", null, "3", null, "5", null, null, null, "Port, Road Terminal, Postal Exchange", null, "RL", "0701", "3441N", "03303E"),
    CYNIC("CYNIC", "Nicosia", "Nicosia", "CY", null, "NIC", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    CZBVA("CZBVA", "Breclav", "Breclav", "CZ", null, "BVA", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AA", "9701", null, null),
    CZBRQ("CZBRQ", "Brno", "Brno", "CZ", null, "BRQ", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AA", "9606", null, null),
    CZCKB("CZCKB", "Cesk\u00e9 Budejovice", "Ceske Budejovice", "CZ", null, "CKB", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AA", "0212", "4859N", "01428E"),
    CZCHB("CZCHB", "Cheb", "Cheb", "CZ", null, "CHB", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AA", "9509", null, null),
    CZDCB("CZDCB", "Dec\u00edn", "Decin", "CZ", null, "DCB", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "AA", "0212", "5047N", "01413E"),
    CZLBR("CZLBR", "Liberec", "Liberec", "CZ", null, "LBR", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AA", "9509", null, null),
    CZMRN("CZMRN", "Merin", "Merin", "CZ", null, "MRN", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RQ", "0907", "4923N", "15530E"),
    CZMIB("CZMIB", "Milotice nad Becvou", "Milotice nad Becvou", "CZ", "OL", "MIB", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "RQ", "1001", "4932N", "01750E"),
    CZOLO("CZOLO", "Olomouc", "Olomouc", "CZ", null, "OLO", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AA", "9701", null, null),
    CZOSR("CZOSR", "Ostrava", "Ostrava", "CZ", null, "OSR", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AA", "9606", null, null),
    CZPRB("CZPRB", "Pardubice", "Pardubice", "CZ", null, "PRB", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AA", "9701", null, null),
    CZPLZ("CZPLZ", "Plzen", "Plzen", "CZ", null, "PLZ", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AA", "9701", null, null),
    CZPRG("CZPRG", "Praha", "Praha", "CZ", null, "PRG", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AA", "9606", null, null),
    CZTNC("CZTNC", "Trinec", "Trinec", "CZ", null, "TNC", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AA", "9509", null, null),
    CZULN("CZULN", "Ust\u00ed nad Labem", "Usti nad Labem", "CZ", null, "ULN", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "AA", "0212", "5040N", "01402E"),
    CZZAT("CZZAT", "Zatec", "Zatec", "CZ", null, "ZAT", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AA", "9701", null, null),
    DEAT3("DEAT3", "Altrip", "Altrip", "DE", "RP", "AT3", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RQ", "1007", "4926N", "00829E"),
    DEBER("DEBER", "Berlin", "Berlin", "DE", "BE", "BER", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0207", "5231N", "01323E"),
    DEBRE("DEBRE", "Bremen", "Bremen", "DE", "HB", "BRE", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    DEDRS("DEDRS", "Dresden", "Dresden", "DE", "SN", "DRS", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    DEDHF("DEDHF", "Dudenhofen", "Dudenhofen", "DE", "RP", "DHF", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "1101", "4919N", "00823E"),
    DEDUS("DEDUS", "D\u00fcsseldorf", "Dusseldorf", "DE", "NW", "DUS", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0207", "5114N", "00647E"),
    DEFRA("DEFRA", "Frankfurt am Main", "Frankfurt am Main", "DE", "HE", "FRA", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0212", "5007N", "00841E"),
    DEHAM("DEHAM", "Hamburg", "Hamburg", "DE", "HH", "HAM", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    DEHAJ("DEHAJ", "Hannover", "Hannover", "DE", "NI", "HAJ", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0307", "5222N", "00943E"),
    DEHPB("DEHPB", "Hohenpeissenberg", "Hohenpeissenberg", "DE", "BY", "HPB", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0901", "4748N", "01100E"),
    DEHNB("DEHNB", "Hornberg", "Hornberg", "DE", "BW", "HNB", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "RL", "1107", null, null),
    DECGN("DECGN", "K\u00f6ln", "Koln", "DE", "NW", "CGN", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0207", "5057N", "00656E"),
    DELEJ("DELEJ", "Leipzig", "Leipzig", "DE", "SN", "LEJ", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    DELBC("DELBC", "L\u00fcbeck", "Lubeck", "DE", "SH", "LBC", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    DEMYK("DEMYK", "Maikammer", "Maikammer", "DE", "RP", "MYK", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "1101", "4918N", "00807E"),
    DEMUC("DEMUC", "M\u00fcnchen", "Munchen", "DE", "BY", "MUC", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0307", "4809N", "01135E"),
    DENRI("DENRI", "Norheim", "Norheim", "DE", "RP", "NRI", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0901", "4948N", "00749E"),
    DEOBE("DEOBE", "Oberhausen", "Oberhausen", "DE", "NW", "OBE", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "0212", "5128N", "00651E"),
    DEOFG("DEOFG", "Offenburg", "Offenburg", "DE", "BW", "OFG", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "9501", null, null),
    DEPOB("DEPOB", "Pleisweiler-Oberhofen", "Pleisweiler-Oberhofen", "DE", "RP", "POB", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "1201", "4907N", "00800E"),
    DERKF("DERKF", "Riekofen", "Riekofen", "DE", "BY", "RKF", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0901", "4855N", "01221E"),
    DEROS("DEROS", "Rosenheim", "Rosenheim", "DE", "BY", "ROS", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "9501", null, null),
    DERSK("DERSK", "Rostock", "Rostock", "DE", "MV", "RLG", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "1101", "5405N", "01208E"),
    DESCN("DESCN", "Saarbr\u00fccken", "Saarbrucken", "DE", "SL", "SCN", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    DETRI("DETRI", "Trier", "Trier", "DE", "RP", "TRI", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "9501", null, null),
    DEZOA("DEZOA", "Zirndorf (Auhausen)", "Zirndorf (Auhausen)", "DE", "BY", "ZOA", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RQ", "0907", "4901N", "01037E"),
    DJJIB("DJJIB", "Djibouti", "Djibouti", "DJ", null, "JIB", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    DKAAL("DKAAL", "Aalborg", "Aalborg", "DK", null, "AAL", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9606", null, null),
    DKAAR("DKAAR", "\u00c5rhus", "Arhus", "DK", "070", "AAR", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0212", "5609N", "01013E"),
    DKFRC("DKFRC", "Fredericia", "Fredericia", "DK", null, "FRC", "12--5---", null, "1", "2", null, null, "5", null, null, null, "Port, Rail Terminal, Postal Exchange", null, "AF", "9606", null, null),
    DKCPH("DKCPH", "K\u00f8benhavn", "Kobenhavn", "DK", null, "CPH", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9606", null, null),
    DMDOM("DMDOM", "Dominica", "Dominica", "DM", null, "DOM", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    DOSDQ("DOSDQ", "Santo Domingo", "Santo Domingo", "DO", "01", "SDQ", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "0307", "1828N", "06954W"),
    DZALG("DZALG", "Alger (Algiers)", "Alger (Algiers)", "DZ", "16", "ALG", "123456--", null, "1", "2", "3", "4", "5", "6", null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AI", "1101", "3645N", "00303E"),
    ECGYE("ECGYE", "Guayaquil", "Guayaquil", "EC", "G", "GYE", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "1101", "0210S", "07954W"),
    ECUIO("ECUIO", "Quito", "Quito", "EC", null, "UIO", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    EETLL("EETLL", "Tallinn", "Tallinn", "EE", "37", "TLL", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0212", "5926N", "02444E"),
    EGALY("EGALY", "El Iskandariya (= Alexandria)", "El Iskandariya (= Alexandria)", "EG", null, "ALY", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    EGCAI("EGCAI", "El Qahira (= Cairo)", "El Qahira (= Cairo)", "EG", null, "CAI", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    ERASM("ERASM", "Asmara", "Asmara", "ER", "AS", "ASM", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0307", "1520N", "03856E"),
    ESADT("ESADT", "Alcaudete de la Jaya", "Alcaudete de la Jaya", "ES", null, "ADT", "12345-7-", null, "1", "2", "3", "4", "5", null, "7", null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange, Fixed Transport", null, "RQ", "1001", "3947N", "00452W"),
    ESALC("ESALC", "Alicante", "Alicante", "ES", null, "ALC", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    ESBCN("ESBCN", "Barcelona", "Barcelona", "ES", null, "BCN", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    ESBLJ("ESBLJ", "Belvis de la Jara", "Belvis de la Jara", "ES", "TO", "BLJ", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RQ", "1001", "3945N", "00457W"),
    ESBIO("ESBIO", "Bilbao", "Bilbao", "ES", null, "BIO", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    ESSIO("ESSIO", "Casasimarro", "Casasimarro", "ES", "CU", "SIO", "123456--", null, "1", "2", "3", "4", "5", "6", null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "RQ", "1001", "3922N", "00202W"),
    ESECT("ESECT", "El Casar de Talamanca", "El Casar de Talamanca", "ES", "GU", "ECT", "123-567-", null, "1", "2", "3", null, "5", "6", "7", null, "Port, Rail Terminal, Road Terminal, Postal Exchange, Multimodal, Fixed Transport", null, "RQ", "1001", "4042N", "00326W"),
    ESROM("ESROM", "El Rompido", "El Rompido", "ES", "H", "ROM", "123-567-", null, "1", "2", "3", null, "5", "6", "7", null, "Port, Rail Terminal, Road Terminal, Postal Exchange, Multimodal, Fixed Transport", null, "RQ", "1001", "3713N", "00707W"),
    ESHTY("ESHTY", "Hontanaya", "Hontanaya", "ES", "CU", "HTY", "12--5---", null, "1", "2", null, null, "5", null, null, null, "Port, Rail Terminal, Postal Exchange", null, "RQ", "1001", "3944N", "00250W"),
    ESETH("ESETH", "Huete", "Huete", "ES", "CU", "ETH", "123-56--", null, "1", "2", "3", null, "5", "6", null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange, Multimodal", null, "RQ", "1001", "4008N", "00241W"),
    ESLPA("ESLPA", "Las Palmas de Gran Canaria", "Las Palmas de Gran Canaria", "ES", "GC", "LPA", "1-3456--", null, "1", null, "3", "4", "5", "6", null, null, "Port, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AI", "0907", "2806N", "01525W"),
    ESMAD("ESMAD", "Madrid", "Madrid", "ES", null, "MAD", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9506", null, null),
    ESAGP("ESAGP", "M\u00e1laga", "Malaga", "ES", null, "AGP", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0212", "3643N", "00425W"),
    ESMRN("ESMRN", "Maracena", "Maracena", "ES", null, "MRN", "12--56--", null, "1", "2", null, null, "5", "6", null, null, "Port, Rail Terminal, Postal Exchange, Multimodal", null, "RQ", "1001", "3712N", "00338W"),
    ESMGA("ESMGA", "Mugia", "Mugia", "ES", "C", "MGA", "1---56--", null, "1", null, null, null, "5", "6", null, null, "Port, Postal Exchange, Multimodal", null, "RQ", "1001", "4306N", "00913W"),
    ESPMI("ESPMI", "Palma de Mallorca", "Palma de Mallorca", "ES", null, "PMI", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0207", "3934N", "00238E"),
    ESPLI("ESPLI", "Playa Ingles", "Playa Ingles", "ES", "GC", "PLI", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "RQ", "1001", "2746N", "01535W"),
    ESPRT("ESPRT", "Portosin", "Portosin", "ES", null, "PRT", "12--56--", null, "1", "2", null, null, "5", "6", null, null, "Port, Rail Terminal, Postal Exchange, Multimodal", null, "RQ", "1201", "4246N", "00857W"),
    ESPRE("ESPRE", "Puerto Calero", "Puerto Calero", "ES", "GC", "PRE", "123-56--", null, "1", "2", "3", null, "5", "6", null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange, Multimodal", null, "RQ", "1001", "2855N", "01342W"),
    ESPPS("ESPPS", "Puerto de Playa de Santiago", "Puerto de Playa de Santiago", "ES", "TF", "PPS", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "RL", "1201", "2802N", "01712W"),
    ESPRO("ESPRO", "Puerto Rosario", "Puerto Rosario", "ES", "GC", "PRO", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "RQ", "1001", "2830N", "01352W"),
    ESSCT("ESSCT", "Santa Cruz de Tenerife", "Santa Cruz de Tenerife", "ES", null, "SCT", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9704", null, null),
    ESSVQ("ESSVQ", "Sevilla", "Sevilla", "ES", null, "SVQ", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    ESVLC("ESVLC", "Valencia", "Valencia", "ES", null, "VLC", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    ETADD("ETADD", "Addis Ababa", "Addis Ababa", "ET", null, "ADD", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", null, null, null),
    ETDIR("ETDIR", "Dire Dawa", "Dire Dawa", "ET", null, "DIR", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", null, null, null),
    FJNAN("FJNAN", "Nadi", "Nadi", "FJ", null, "NAN", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    FJSUV("FJSUV", "Suva", "Suva", "FJ", null, "SUV", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    FKFBE("FKFBE", "Fox Bay", "Fox Bay", "FK", null, "FBE", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9808", null, null),
    FKMPN("FKMPN", "Mount Pleasant", "Mount Pleasant", "FK", null, "MPN", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9808", null, null),
    FRAYS("FRAYS", "Aire-sur-la Lys", "Aire-sur-la Lys", "FR", "62", "AYS", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AA", "1101", "5038N", "00224E"),
    FRAJA("FRAJA", "Ajaccio", "Ajaccio", "FR", "2A", "AJA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRNCY("FRNCY", "Annecy", "Annecy", "FR", "74", "NCY", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRANM("FRANM", "Annemasse", "Annemasse", "FR", "74", "QNJ", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "9501", null, null),
    FRARR("FRARR", "Arras", "Arras", "FR", "62", "QRV", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "0207", "5017N", "00247E"),
    FRBVD("FRBVD", "Ballainvilliers", "Ballainvilliers", "FR", "91", "BVD", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RQ", "0907", "4840N", "00217E"),
    FRBIA("FRBIA", "Bastia", "Bastia", "FR", "2B", "BIA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRBEL("FRBEL", "Bellegarde-sur-Valserine", "Bellegarde-sur-Valserine", "FR", "01", "XBF", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "0401", "4606N", "00549E"),
    FRBSN("FRBSN", "Besan\u00e7on", "Besancon", "FR", "25", "QBQ", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "0212", "4715N", "00602E"),
    FRBOD("FRBOD", "Bordeaux", "Bordeaux", "FR", "33", "BOD", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRBEB("FRBEB", "Bourg-en-Bresse", "Bourg-en-Bresse", "FR", "01", "XBK", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0212", "4612N", "00513E"),
    FRCQF("FRCQF", "Calais", "Calais", "FR", "62", "CQF", "12-45---", null, "1", "2", null, "4", "5", null, null, null, "Port, Rail Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRCMF("FRCMF", "Chamb\u00e9ry", "Chambery", "FR", "73", "CMF", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRCFE("FRCFE", "Clermont-Ferrand", "Clermont-Ferrand", "FR", "63", "CFE", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0207", "4546N", "00305E"),
    FRDEL("FRDEL", "Delle", "Delle", "FR", "90", "DEL", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "AF", "9506", null, null),
    FRDNR("FRDNR", "Dinard", "Dinard", "FR", "35", "DNR", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "1201", null, null),
    FRDIN("FRDIN", "Divonne-les-Bains", "Divonne-les-Bains", "FR", "01", "DIN", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0212", "4622N", "00608E"),
    FRDOU("FRDOU", "Douvaine", "Douvaine", "FR", "74", "DOU", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RQ", "9601", null, null),
    FRDKK("FRDKK", "Dunkerque", "Dunkerque", "FR", "59", "XDK", "12--5---", null, "1", "2", null, null, "5", null, null, null, "Port, Rail Terminal, Postal Exchange", null, "AF", "9501", null, null),
    FRERN("FRERN", "Erstein", "Erstein", "FR", "67", "ERN", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0401", "4826N", "00740E"),
    FREVI("FREVI", "\u00c9vian-les-Bains", "Evian-les-Bains", "FR", "74", "EVI", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "0212", "4623N", "00635E"),
    FRFEV("FRFEV", "Ferney-Voltaire", "Ferney-Voltaire", "FR", "01", "FEV", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "1201", "4615N", "00607E"),
    FRGAD("FRGAD", "Gaillard", "Gaillard", "FR", "74", "GAD", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9803", null, null),
    FRGSQ("FRGSQ", "Garcelles-Secqueville", "Garcelles-Secqueville", "FR", "14", "GSQ", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "RL", "1201", "4906N", "00017W"),
    FRGEX("FRGEX", "Gex", "Gex", "FR", "01", "GEX", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "AI", "0501", "4620N", "00604E"),
    FRHON("FRHON", "Honfleur", "Honfleur", "FR", "64", "HON", "12-45---", null, "1", "2", null, "4", "5", null, null, null, "Port, Rail Terminal, Airport, Postal Exchange", null, "AF", "1201", null, null),
    FRLEH("FRLEH", "Le Havre", "Le Havre", "FR", "76", "LEH", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRLLE("FRLLE", "Lille", "Lille", "FR", "59", "LLE", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0701", "5038N", "00304E"),
    FRLIG("FRLIG", "Limoges", "Limoges", "FR", "87", "LIG", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRLIA("FRLIA", "L'Isle-d'Abeau", "L'Isle-d'Abeau", "FR", "38", "LIA", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "0401", "4537N", "00514E"),
    FRLIO("FRLIO", "Lyon", "Lyon", "FR", "69", "LIO", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9506", null, null),
    FRMT5("FRMT5", "Mantilly", "Mantilly", "FR", "61", "MT5", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RQ", "0907", "4831N", "00049W"),
    FRXME("FRXME", "Marcy-L'\u00c9toile", "Marcy-L'Etoile", "FR", "69", "XME", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0901", "4547N", "00443E"),
    FRMRS("FRMRS", "Marseille", "Marseille", "FR", "13", "MRS", "12-45---", null, "1", "2", null, "4", "5", null, null, null, "Port, Rail Terminal, Airport, Postal Exchange", null, "AF", "0212", "4318N", "00524E"),
    FRMZM("FRMZM", "Metz", "Metz", "FR", "57", "ETZ", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "1101", "4908N", "00610E"),
    FRMIL("FRMIL", "Millau", "Millau", "FR", "12", "MIL", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "AF", "9506", null, null),
    FRMPL("FRMPL", "Montpellier", "Montpellier", "FR", "34", "MPL", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRMOR("FRMOR", "Morteau", "Morteau", "FR", "25", "MOR", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "AF", "9506", null, null),
    FRMLH("FRMLH", "Mulhouse", "Mulhouse", "FR", "68", "MLH", "12-45---", null, "1", "2", null, "4", "5", null, null, null, "Port, Rail Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRENC("FRENC", "Nancy", "Nancy", "FR", "54", "ENC", "12-45---", null, "1", "2", null, "4", "5", null, null, null, "Port, Rail Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRNTE("FRNTE", "Nantes", "Nantes", "FR", "44", "NTE", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRNCE("FRNCE", "Nice", "Nice", "FR", "06", "NCE", "12-45---", null, "1", "2", null, "4", "5", null, null, null, "Port, Rail Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRORY("FRORY", "Orly", "Orly", "FR", "94", "ORY", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9501", null, null),
    FRORY_1("FRORY", "Orly Apt/Paris", "Orly Apt/Paris", "FR", "94", "ORY", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9501", null, null),
    FROYO("FROYO", "Oyonnax", "Oyonnax", "FR", "01", "OYO", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "AF", "9506", null, null),
    FRPAR("FRPAR", "Paris", "Paris", "FR", "75", "PAR", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "9501", null, null),
    FRPGF("FRPGF", "Perpignan", "Perpignan", "FR", "66", "PGF", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRPRM("FRPRM", "Prevessin-Moens", "Prevessin-Moens", "FR", "01", "PRM", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RQ", "9601", null, null),
    FRRNS("FRRNS", "Rennes", "Rennes", "FR", "35", "RNS", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRROU("FRROU", "Roubaix", "Roubaix", "FR", "59", "XRX", "12--5---", null, "1", "2", null, null, "5", null, null, null, "Port, Rail Terminal, Postal Exchange", null, "AF", "9506", null, null),
    FRSTC("FRSTC", "Saint-Claude", "Saint-Claude", "FR", "39", "XTC", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "AF", "1101", null, null),
    FRSJG("FRSJG", "Saint-Julien-en-Genevois", "Saint-Julien-en-Genevois", "FR", "74", "SJG", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "1101", "4608N", "00605E"),
    FRSXB("FRSXB", "Strasbourg", "Strasbourg", "FR", "67", "SXB", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRTRY("FRTRY", "Thoiry", "Thoiry", "FR", "74", "TRY", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9803", null, null),
    FRTLS("FRTLS", "Toulouse", "Toulouse", "FR", "31", "TLS", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRTUF("FRTUF", "Tours", "Tours", "FR", "37", "TUF", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    FRVAF("FRVAF", "Valence", "Valence", "FR", "26", "VAF", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0401", "4456N", "00453E"),
    GALBV("GALBV", "Libreville", "Libreville", "GA", null, "LBV", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    GAPOG("GAPOG", "Port Gentil", "Port Gentil", "GA", null, "POG", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    GBAN2("GBAN2", "Ancaster", "Ancaster", "GB", "LIN", "AN2", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "1201", "5258N", "00032W"),
    GBBHM("GBBHM", "Birmingham", "Birmingham", "GB", "WMD", "BHX", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9511", null, null),
    GBDVR("GBDVR", "Dover", "Dover", "GB", "KEN", "QQD", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AF", "9511", null, null),
    GBGLW("GBGLW", "Glasgow", "Glasgow", "GB", "STD", "GLA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9511", null, null),
    GBLON("GBLON", "London", "London", "GB", "LND", "LON", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AF", "0701", null, null),
    GBRDN("GBRDN", "Reading", "Reading", "GB", "RDG", "RDN", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AF", "0507", "5127N", "00058W"),
    GDGND("GDGND", "Grenada", "Grenada", "GD", null, "GND", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    GETBS("GETBS", "Tbilisi", "Tbilisi", "GE", null, "TBS", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    GFCAY("GFCAY", "Cayenne", "Cayenne", "GF", null, "CAY", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9506", null, null),
    GFQKR("GFQKR", "Kourou", "Kourou", "GF", null, "QKR", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9506", null, null),
    GHACC("GHACC", "Accra", "Accra", "GH", null, "ACC", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", null, null, null),
    GHKTP("GHKTP", "Kotoka", "Kotoka", "GH", null, "KTP", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9601", null, null),
    GHTKD("GHTKD", "Takoradi", "Takoradi", "GH", null, "TKD", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    GIGIB("GIGIB", "Gibraltar", "Gibraltar", "GI", null, "GIB", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    GMBAK("GMBAK", "Bakau", "Bakau", "GM", null, "BAK", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    GMBJL("GMBJL", "Banjul", "Banjul", "GM", null, "BJL", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    GMBAN("GMBAN", "Bansang", "Bansang", "GM", null, "BAN", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    GMBSS("GMBSS", "Basse Santa Su", "Basse Santa Su", "GM", null, "BSS", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    GMBRB("GMBRB", "Brikama Ba", "Brikama Ba", "GM", null, "BRB", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    GMBWI("GMBWI", "Bwiam", "Bwiam", "GM", null, "BWI", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    GMFAR("GMFAR", "Farafenni", "Farafenni", "GM", null, "FAR", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    GMKAU("GMKAU", "Kau-ur", "Kau-ur", "GM", null, "KAU", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "0212", "1342N", "01519W"),
    GMKUN("GMKUN", "Kuntair", "Kuntair", "GM", null, "KUN", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    GMJTB("GMJTB", "MacCarthy Island (Jangjangbureh)", "MacCarthy Island (Jangjangbureh)", "GM", "M", "JTB", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "0212", "1332N", "01446W"),
    GMMAK("GMMAK", "Mansa Konko", "Mansa Konko", "GM", null, "MAK", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9808", null, null),
    GMSKE("GMSKE", "Serekunda", "Serekunda", "GM", null, "SKE", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9601", null, null),
    GNCKY("GNCKY", "Conakry", "Conakry", "GN", null, "CKY", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    GPBBR("GPBBR", "Basse-Terre", "Basse-Terre", "GP", null, "BBR", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0212", "1600N", "06143W"),
    GPPTP("GPPTP", "Pointe-\u00e0-Pitre", "Pointe-a-Pitre", "GP", null, "PTP", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9506", null, null),
    GPSBH("GPSBH", "Saint Barthelemy", "Saint Barthelemy", "GP", null, "SBH", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "1101", null, null),
    GQBSG("GQBSG", "Bata", "Bata", "GQ", null, "BSG", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "RQ", "9506", null, null),
    GQSIS("GQSIS", "Santa Isabel", "Santa Isabel", "GQ", null, "SIS", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9601", null, null),
    GRATH("GRATH", "Ath\u00ednai", "Athinai", "GR", null, "ATH", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0212", "3759N", "02344E"),
    GRKLP("GRKLP", "Kalampaka", "Kalampaka", "GR", "44", "KLP", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "1107", null, null),
    GRRHO("GRRHO", "Rhodes", "Rhodes", "GR", null, "RHO", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    GRSOR("GRSOR", "Soupri", "Soupri", "GR", null, "SOR", "1-3-5---", null, "1", null, "3", null, "5", null, null, null, "Port, Road Terminal, Postal Exchange", null, "RL", "1107", null, null),
    GRSKG("GRSKG", "Thessalon\u00edki", "Thessaloniki", "GR", null, "SKG", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0212", "4038N", "02257E"),
    GTGUA("GTGUA", "Guatemala City", "Guatemala City", "GT", null, "GUA", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    GTSNJ("GTSNJ", "San Jose", "San Jose", "GT", null, "SNJ", "1-3-5---", null, "1", null, "3", null, "5", null, null, null, "Port, Road Terminal, Postal Exchange", null, "AI", "9401", null, null),
    GUGUM("GUGUM", "Guam", "Guam", "GU", null, "GUM", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    GWOXB("GWOXB", "Bissau", "Bissau", "GW", "BS", "OXB", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "1151N", "01535W"),
    GYGEO("GYGEO", "Georgetown", "Georgetown", "GY", null, "GEO", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    GYTHI("GYTHI", "Thimery", "Thimery", "GY", null, "THI", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    HKHKG("HKHKG", "Hong Kong", "Hong Kong", "HK", null, "HKG", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    HNPCR("HNPCR", "Puerto Cort\u00e9s", "Puerto Cortes", "HN", null, "PCR", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9401", null, null),
    HNSAP("HNSAP", "San Pedro Sula", "San Pedro Sula", "HN", null, "SAP", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    HNTGU("HNTGU", "Tegucigalpa", "Tegucigalpa", "HN", null, "TGU", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    HRDMH("HRDMH", "Donji Miholjac", "Donji Miholjac", "HR", null, "DMH", "--3-5--B", null, null, null, "3", null, "5", null, null, "B", "Road Terminal, Postal Exchange, Border Crossing", null, "RL", "0701", "4546N", "01810E"),
    HRVKV("HRVKV", "Viskovo", "Viskovo", "HR", null, "VKV", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0701", "4522N", "01423E"),
    HRVUK("HRVUK", "Vukovar", "Vukovar", "HR", "16", "VUK", "123-5--B", null, "1", "2", "3", null, "5", null, null, "B", "Port, Rail Terminal, Road Terminal, Postal Exchange, Border Crossing", null, "RL", "0607", "4521N", "01900E"),
    HRZAG("HRZAG", "Zagreb", "Zagreb", "HR", "01", "ZAG", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "4548N", "01600E"),
    HTPAP("HTPAP", "Port-au-Prince", "Port-au-Prince", "HT", null, "PAP", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    HUBUD("HUBUD", "Budapest", "Budapest", "HU", null, "BUD", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    HUNAS("HUNAS", "N\u00e1dasd", "Nadasd", "HU", "VA", "NAS", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "1201", "4657N", "01637E"),
    IDBDO("IDBDO", "Bandung, Java", "Bandung, Java", "ID", null, "BDO", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    IDDPS("IDDPS", "Denpasar, Bali", "Denpasar, Bali", "ID", "BA", "DPS", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "0507", "0839S", "11513E"),
    IDJKT("IDJKT", "Jakarta, Java", "Jakarta, Java", "ID", "JK", "JKT", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0407", "0608S", "10650E"),
    IDDJJ("IDDJJ", "Jayapura, Irian Jaya", "Jayapura, Irian Jaya", "ID", "IJ", "DJJ", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "0307", "0232S", "14042E"),
    IDMDC("IDMDC", "Manado", "Manado", "ID", null, "MDC", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    IDMES("IDMES", "Medan, Sumatra", "Medan, Sumatra", "ID", null, "MES", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    IDPNK("IDPNK", "Pontianak, Kalimantan", "Pontianak, Kalimantan", "ID", null, "PNK", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    IDSRG("IDSRG", "Semarang", "Semarang", "ID", "JT", "SRG", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "0907", "0658S", "11029E"),
    IDSZH("IDSZH", "Senipah", "Senipah", "ID", "KI", "SZH", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "0501", "0057S", "11709E"),
    IDSUB("IDSUB", "Surabaya", "Surabaya", "ID", "JI", "SUB", "123456--", null, "1", "2", "3", "4", "5", "6", null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AI", "0407", "0714S", "11245E"),
    IDTJB("IDTJB", "Tanjung Balai", "Tanjung Balai", "ID", null, "TJB", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "QQ", "8103", null, null),
    IDUPG("IDUPG", "Ujung Pandang, Sulawesi", "Ujung Pandang, Sulawesi", "ID", null, "UPG", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    IEATH("IEATH", "Athlone", "Athlone", "IE", null, "ATH", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RQ", "9701", null, null),
    IEORK("IEORK", "Cork", "Cork", "IE", null, "ORK", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9508", null, null),
    IEDUB("IEDUB", "Dublin", "Dublin", "IE", null, "DUB", "12-45---", null, "1", "2", null, "4", "5", null, null, null, "Port, Rail Terminal, Airport, Postal Exchange", null, "AF", "9508", null, null),
    IEGWY("IEGWY", "Galway", "Galway", "IE", null, "GWY", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AF", "9508", null, null),
    IEKID("IEKID", "Killenard", "Killenard", "IE", "LS", "KID", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "1107", null, null),
    IELMK("IELMK", "Limerick", "Limerick", "IE", null, "LMK", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9508", null, null),
    IEPTL("IEPTL", "Portlaoise", "Portlaoise", "IE", "LS", "PTL", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0207", "5302N", "00716W"),
    IESNN("IESNN", "Shannon", "Shannon", "IE", null, "SNN", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AF", "9508", null, null),
    IEWAT("IEWAT", "Waterford", "Waterford", "IE", null, "WAT", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9508", null, null),
    ILHFA("ILHFA", "Haifa", "Haifa", "IL", null, "HFA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    ILTLV("ILTLV", "Tel Aviv-Yafo", "Tel Aviv-Yafo", "IL", "TA", "TLV", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0507", "3203N", "03445E"),
    INMAA("INMAA", "Chennai (ex Madras)", "Chennai (ex Madras)", "IN", "TN", "MAA", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AA", "0407", "1305N", "08017E"),
    INDEL("INDEL", "Delhi", "Delhi", "IN", "DL", "DEL", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AA", "0002", null, null),
    INKOC("INKOC", "Kochi", "Kochi", "IN", null, "KOC", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    INCCU("INCCU", "Kolkata (ex Calcutta)", "Kolkata (ex Calcutta)", "IN", "WB", "CCU", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AA", "0201", "2234N", "08821E"),
    INBOM("INBOM", "Mumbai (ex Bombay)", "Mumbai (ex Bombay)", "IN", "MH", "BOM", "123456--", null, "1", "2", "3", "4", "5", "6", null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AA", "0501", "1858N", "07249E"),
    IODGA("IODGA", "Diego Garcia", "Diego Garcia", "IO", null, "DGA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "0201", null, null),
    IQBGW("IQBGW", "Baghd\u00e5d", "Baghdad", "IQ", "BG", "BGW", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "3320N", "04423E"),
    IQEBL("IQEBL", "Erbil International Apt", "Erbil International Apt", "IQ", null, "EBL", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "RL", "0701", "3614N", "04357E"),
    IRABD("IRABD", "Abadan", "Abadan", "IR", null, "ABD", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    IRBAJ("IRBAJ", "Bajgiran", "Bajgiran", "IR", null, "BAJ", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    IRAMD("IRAMD", "Bandar Amirabad", "Bandar Amirabad", "IR", "21", "AMD", "123-56--", null, "1", "2", "3", null, "5", "6", null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange, Multimodal", null, "RL", "0901", "3647N", "05321E"),
    IRNEK("IRNEK", "Bandar Neka", "Bandar Neka", "IR", null, "NEK", "1-3-56--", null, "1", null, "3", null, "5", "6", null, null, "Port, Road Terminal, Postal Exchange, Multimodal", null, "RL", "0901", "3652N", "05332E"),
    IRKHS("IRKHS", "Khosravi", "Khosravi", "IR", null, "KHS", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    IRPYK("IRPYK", "Payam Apt", "Payam Apt", "IR", null, "PYK", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "RL", "0601", "3547N", "05049E"),
    IRTAJ("IRTAJ", "Tajabad", "Tajabad", "IR", null, "TAJ", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    IRTHR("IRTHR", "Tehran", "Tehran", "IR", null, "THR", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    IRZAN("IRZAN", "Zanjan", "Zanjan", "IR", null, "ZAN", "-2345-7-", null, null, "2", "3", "4", "5", null, "7", null, "Rail Terminal, Road Terminal, Airport, Postal Exchange, Fixed Transport", null, "RL", "0307", "3640N", "04828E"),
    ITBLQ("ITBLQ", "Bologna", "Bologna", "IT", null, "BLQ", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "1101", null, null),
    ITGOA("ITGOA", "Genova", "Genova", "IT", "GE", "GOA", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "1201", "3757N", "01242E"),
    ITLIN("ITLIN", "Linate Apt/Milano", "Linate Apt/Milano", "IT", null, "LIN", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", null, null, null),
    ITLOP("ITLOP", "Lonate Pozzolo", "Lonate Pozzolo", "IT", "VA", "LOP", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0401", "4536N", "00845E"),
    ITMIL("ITMIL", "Milano", "Milano", "IT", null, "MIL", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "AI", "1101", null, null),
    ITPC2("ITPC2", "Poggio a Caiano", "Poggio a Caiano", "IT", "PO", "PC2", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "1201", "4349N", "01103E"),
    ITROM("ITROM", "Roma", "Roma", "IT", "RM", "ROM", "123456--", null, "1", "2", "3", "4", "5", "6", null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AI", "1201", "4154N", "01229E"),
    ITTRN("ITTRN", "Torino", "Torino", "IT", null, "TRN", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    ITVCE("ITVCE", "Venezia", "Venezia", "IT", "VE", "VCE", "12345--B", null, "1", "2", "3", "4", "5", null, null, "B", "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange, Border Crossing", null, "AI", "0907", "4526N", "01220E"),
    ITVEN("ITVEN", "Ventimiglia", "Ventimiglia", "IT", "IM", "VEN", "1-3-5---", null, "1", null, "3", null, "5", null, null, null, "Port, Road Terminal, Postal Exchange", null, "AI", "1201", "4347N", "00736E"),
    JMKIN("JMKIN", "Kingston", "Kingston", "JM", null, "KIN", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    JMSAP("JMSAP", "Saint Andrew Parish", "Saint Andrew Parish", "JM", null, "SAP", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "1107", null, null),
    JOAMM("JOAMM", "Amman", "Amman", "JO", null, "AMM", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    JPFUK("JPFUK", "Fukuoka", "Fukuoka", "JP", "40", "FUK", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0401", "3330N", "13030E"),
    JPGOS("JPGOS", "Gosen", "Gosen", "JP", "15", "GOS", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RQ", "1001", "3744N", "13910E"),
    JPHKT("JPHKT", "Hakata/Fukuoka", "Hakata/Fukuoka", "JP", "40", "HKT", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "0401", "3336N", "13025E"),
    JPDNA("JPDNA", "Kadena", "Kadena", "JP", "47", "DNA", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AF", "0006", null, null),
    JPKKJ("JPKKJ", "Kitakyushu", "Kitakyushu", "JP", "40", "KKJ", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0401", "3350N", "13050E"),
    JPUKB("JPUKB", "Kobe", "Kobe", "JP", "28", "UKB", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0401", "3441N", "13510E"),
    JPMOJ("JPMOJ", "Moji/Kitakyushu", "Moji/Kitakyushu", "JP", "40", "MOJ", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "0401", "3354N", "13058E"),
    JPNGO("JPNGO", "Nagoya, Aichi", "Nagoya, Aichi", "JP", "23", "NGO", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9907", null, null),
    JPNAH("JPNAH", "Naha, Okinawa", "Naha, Okinawa", "JP", "47", "NAH", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9907", null, null),
    JPOSA("JPOSA", "Osaka", "Osaka", "JP", "27", "ITM", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "1101", "3440N", "13530E"),
    JPSHS("JPSHS", "Shimonoseki", "Shimonoseki", "JP", "35", "SHS", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AF", "9907", null, null),
    JPTYO("JPTYO", "Tokyo", "Tokyo", "JP", "13", "TYO", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0401", "3541N", "13945E"),
    JPQTS("JPQTS", "Tosu", "Tosu", "JP", "41", "QTS", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RQ", "1001", "3322N", "13031E"),
    JPYOK("JPYOK", "Yokohama", "Yokohama", "JP", "14", "YOK", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0401", "3527N", "13939E"),
    KEMBA("KEMBA", "Mombasa", "Mombasa", "KE", null, "MBA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    KENBO("KENBO", "Nairobi", "Nairobi", "KE", null, "NBO", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    KHPNH("KHPNH", "Phnom Penh", "Phnom Penh", "KH", null, "PNH", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    KMYVA("KMYVA", "Moroni", "Moroni", "KM", null, "YVA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    KNBAS("KNBAS", "Basseterre, Saint Kitts", "Basseterre, Saint Kitts", "KN", null, "BAS", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "1101", null, null),
    KNSKB("KNSKB", "Saint Kitts", "Saint Kitts", "KN", null, "SKB", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "1101", null, null),
    KPFNJ("KPFNJ", "Pyongyang", "Pyongyang", "KP", null, "FNJ", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    KRPUS("KRPUS", "Busan", "Busan", "KR", "26", "PUS", "1234567-", null, "1", "2", "3", "4", "5", "6", "7", null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal, Fixed Transport", null, "AF", "1001", "3508N", "12903E"),
    KRSEL("KRSEL", "Seoul", "Seoul", "KR", "11", "SEL", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0507", "3733N", "12659E"),
    KWKWI("KWKWI", "Kuwait", "Kuwait", "KW", null, "KWI", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    KYGCM("KYGCM", "Grand Cayman", "Grand Cayman", "KY", null, "GCM", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "0307", "1917N", "08121W"),
    KZALA("KZALA", "Almaty", "Almaty", "KZ", null, "ALA", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    KZAST("KZAST", "Astana (ex Tselinograd)", "Astana (ex Tselinograd)", "KZ", null, "TSE", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0001", null, null),
    KZHOR("KZHOR", "Horgos", "Horgos", "KZ", null, "HOR", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9809", null, null),
    KZKOR("KZKOR", "Kordai", "Kordai", "KZ", null, "KOR", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "0001", null, null),
    KZSCK("KZSCK", "Shchuchinsk", "Shchuchinsk", "KZ", "SEV", "SCK", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "AI", "0501", "5256N", "07012E"),
    KZURA("KZURA", "Uralsk", "Uralsk", "KZ", null, "URA", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0001", null, null),
    LAVTE("LAVTE", "Vientiane", "Vientiane", "LA", null, "VTE", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    LBBEY("LBBEY", "Beirut", "Beirut", "LB", null, "BEY", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0207", "3350N", "03529E"),
    LBNAQ("LBNAQ", "En N\u00e2qo\u00fbra", "En Naqoura", "LB", null, "NAQ", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0401", "3307N", "03508E"),
    LCSLU("LCSLU", "Saint Lucia Apt", "Saint Lucia Apt", "LC", null, "SLU", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "1101", "1342N", "06056W"),
    LKCMB("LKCMB", "Colombo", "Colombo", "LK", null, "CMB", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0212", "0655N", "07951E"),
    LKKAT("LKKAT", "Katunayake", "Katunayake", "LK", null, "KAT", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "0006", "0710N", "07952E"),
    LKMTL("LKMTL", "Mattala", "Mattala", "LK", "33", "MTL", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "1101", "0621N", "08107E"),
    LKNBW("LKNBW", "Nittambuwa", "Nittambuwa", "LK", null, "NBW", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0901", "7820N", "80553E"),
    LRMLW("LRMLW", "Monrovia", "Monrovia", "LR", null, "MLW", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    LSMSU("LSMSU", "Maseru", "Maseru", "LS", null, "MSU", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9401", null, null),
    LTVNO("LTVNO", "Vilnius", "Vilnius", "LT", null, "VNO", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    LULUX("LULUX", "Luxembourg", "Luxembourg", "LU", null, "LUX", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    LUSCH("LUSCH", "Schengen", "Schengen", "LU", "G", "SCH", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "1107", null, null),
    LVRIX("LVRIX", "Riga", "Riga", "LV", "RIX", "RIX", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    LYBEN("LYBEN", "Bingazi (Benghazi)", "Bingazi (Benghazi)", "LY", null, "BEN", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    MACAS("MACAS", "Casablanca", "Casablanca", "MA", "CAS", "CMN", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "1101", "3335N", "00736W"),
    MATNG("MATNG", "Tangier", "Tangier", "MA", null, "TNG", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0701", "3547N", "00549W"),
    MCMON("MCMON", "Monaco", "Monaco", "MC", null, "MON", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "QQ", "8103", null, null),
    MDKIV("MDKIV", "Chisin\u00e3u (ex Kishinev)", "Chisinau (ex Kishinev)", "MD", null, "KIV", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0201", "4701N", "02850E"),
    MGTNR("MGTNR", "Antananarivo", "Antananarivo", "MG", null, "TNR", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    MGIVA("MGIVA", "Ivato", "Ivato", "MG", null, "IVA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    MGTMM("MGTMM", "Tamatave (Toamasina)", "Tamatave (Toamasina)", "MG", null, "TMM", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    MLBKO("MLBKO", "Bamako", "Bamako", "ML", null, "BKO", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    MMRGN("MMRGN", "Yangon", "Yangon", "MM", null, "RGN", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    MNULN("MNULN", "Ulaanbaatar", "Ulaanbaatar", "MN", null, "ULN", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    MOMFM("MOMFM", "Macau", "Macau", "MO", null, "MFM", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0207", "2212N", "11332E"),
    MQFDF("MQFDF", "Fort-de-France", "Fort-de-France", "MQ", null, "FDF", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    MQLFR("MQLFR", "Le Fran\u00e7ois", "Le Francois", "MQ", null, "LFR", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "RL", "0212", "1436N", "06054W"),
    MQLMT("MQLMT", "Le Lamentin", "Le Lamentin", "MQ", null, "LMT", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "RL", "0212", "1436N", "06100W"),
    MQSHL("MQSHL", "Sch\u00c2\u009clcher", "Scholcher", "MQ", null, "SHL", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "RL", "0212", "1436N", "06106W"),
    MRNKC("MRNKC", "Nouakchott", "Nouakchott", "MR", null, "NKC", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    MSPLY("MSPLY", "Plymouth", "Plymouth", "MS", null, "PLY", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "RQ", "9506", null, null),
    MTMLA("MTMLA", "Valletta, Malta", "Valletta, Malta", "MT", null, "MLA", "1--456--", null, "1", null, null, "4", "5", "6", null, null, "Port, Airport, Postal Exchange, Multimodal", null, "AI", "1201", "3553N", "01430E"),
    MTZTN("MTZTN", "Zejtun", "Zejtun", "MT", null, "ZTN", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RQ", "1001", "3551N", "01432E"),
    MUMRU("MUMRU", "Sir Seewoosagur Ramgoolam Int Apt", "Sir Seewoosagur Ramgoolam Int Apt", "MU", null, "MRU", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0401", "2026S", "05741E"),
    MVMLE("MVMLE", "Male", "Male", "MV", null, "MLE", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "1101", "0410N", "07330E"),
    MWLLW("MWLLW", "Lilongwe", "Lilongwe", "MW", null, "LLW", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    MWLBE("MWLBE", "Limbe", "Limbe", "MW", null, "LBE", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9601", null, null),
    MXMEX("MXMEX", "Mexico City", "Mexico City", "MX", null, "MEX", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0212", "1924N", "09903W"),
    MXTLY("MXTLY", "Tolcayuca", "Tolcayuca", "MX", "HID", "TLY", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0607", "1957N", "09855W"),
    MXVER("MXVER", "Veracruz", "Veracruz", "MX", "VER", "VER", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0907", "1912N", "09605W"),
    MYBKI("MYBKI", "Kota Kinabalu, Sabah", "Kota Kinabalu, Sabah", "MY", null, "BKI", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    MYKUL("MYKUL", "Kuala Lumpur", "Kuala Lumpur", "MY", null, "KUL", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    MYKCH("MYKCH", "Kuching, Sarawak", "Kuching, Sarawak", "MY", null, "KCH", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    MYPKG("MYPKG", "Port Klang (Pelabuhan Klang)", "Port Klang (Pelabuhan Klang)", "MY", "10", "PKG", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "1101", "0300N", "10124E"),
    MZBEW("MZBEW", "Beira", "Beira", "MZ", null, "BEW", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    MZMPM("MZMPM", "Maputo", "Maputo", "MZ", null, "MPM", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    NAKAS("NAKAS", "Karasburg", "Karasburg", "NA", null, "KAS", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9805", null, null),
    NAMAR("NAMAR", "Mariental", "Mariental", "NA", null, "MAR", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    NAWOR("NAWOR", "Noordoewer", "Noordoewer", "NA", "KA", "WOR", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "AI", "0307", "2845S", "01737E"),
    NAOHI("NAOHI", "Oshakati", "Oshakati", "NA", null, "OHI", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9805", null, null),
    NAOTJ("NAOTJ", "Otjiwarongo", "Otjiwarongo", "NA", null, "OTJ", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9805", null, null),
    NASWP("NASWP", "Swakopmund", "Swakopmund", "NA", null, "SWP", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9805", null, null),
    NAWDH("NAWDH", "Windhoek", "Windhoek", "NA", null, "WDH", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    NCNOU("NCNOU", "Noum\u00e9a", "Noumea", "NC", null, "NOU", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0212", "2216S", "16627E"),
    NCTON("NCTON", "Tontouta", "Tontouta", "NC", null, "TON", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9709", null, null),
    NENIM("NENIM", "Niamey", "Niamey", "NE", null, "NIM", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    NFNLK("NFNLK", "Norfolk Island", "Norfolk Island", "NF", null, "NLK", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    NGKAD("NGKAD", "Kaduna", "Kaduna", "NG", null, "KAD", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    NGKAN("NGKAN", "Kano", "Kano", "NG", null, "KAN", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    NGLOS("NGLOS", "Lagos", "Lagos", "NG", null, "LOS", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    NICIO("NICIO", "Corinto", "Corinto", "NI", null, "CIO", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9401", null, null),
    NIMGA("NIMGA", "Managua", "Managua", "NI", null, "MGA", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    NLAMS("NLAMS", "Amsterdam", "Amsterdam", "NL", null, "AMS", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9602", null, null),
    NLGRD("NLGRD", "Groede", "Groede", "NL", "ZE", "GRD", "-23-5-7-", null, null, "2", "3", null, "5", null, "7", null, "Rail Terminal, Road Terminal, Postal Exchange, Fixed Transport", null, "RL", "0901", "5123N", "00330E"),
    NLLER("NLLER", "Leersum", "Leersum", "NL", "UT", "LER", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "1107", null, null),
    NLNRG("NLNRG", "Norg", "Norg", "NL", null, "NRG", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "RQ", "0907", "5303N", "00627E"),
    NLROL("NLROL", "Rolde", "Rolde", "NL", null, "ROL", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RQ", "0907", "5259N", "00638E"),
    NLROO("NLROO", "Roosendaal", "Roosendaal", "NL", null, "ZYO", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AF", "9602", null, null),
    NLRTM("NLRTM", "Rotterdam", "Rotterdam", "NL", "ZH", "RTM", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0501", "5155N", "00430E"),
    NLRUI("NLRUI", "Ruinen", "Ruinen", "NL", "DR", "RUI", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0901", "5246N", "00621E"),
    NLSPT("NLSPT", "Stompetoren", "Stompetoren", "NL", "NH", "SPT", "1-3-56--", null, "1", null, "3", null, "5", "6", null, null, "Port, Road Terminal, Postal Exchange, Multimodal", null, "RL", "0901", "5237N", "00449E"),
    NLVIS("NLVIS", "Vries", "Vries", "NL", "GR", "VIS", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RQ", "0907", "5304N", "00634E"),
    NLWTG("NLWTG", "Watergang", "Watergang", "NL", "NH", "WTG", "--3-567-", null, null, null, "3", null, "5", "6", "7", null, "Road Terminal, Postal Exchange, Multimodal, Fixed Transport", null, "RL", "1107", null, null),
    NOOSL("NOOSL", "Oslo", "Oslo", "NO", "03", "OSL", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    NPKTM("NPKTM", "Kathmandu", "Kathmandu", "NP", null, "KTM", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "9401", null, null),
    NRINU("NRINU", "Nauru Island", "Nauru Island", "NR", null, "INU", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    NUIUE("NUIUE", "Niue Island", "Niue Island", "NU", null, "IUE", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    NZAKL("NZAKL", "Auckland", "Auckland", "NZ", "AUK", "AKL", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AC", "9601", null, null),
    OMMCT("OMMCT", "Muscat", "Muscat", "OM", null, "MCT", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    PAONX("PAONX", "Colon", "Colon", "PA", null, "ONX", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9601", null, null),
    PAPTY("PAPTY", "Panam\u00e1, Ciudad de", "Panama, Ciudad de", "PA", "8", "PAC", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "0407", "0858N", "07932W"),
    PELIM("PELIM", "Lima", "Lima", "PE", null, "LIM", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    PFFAA("PFFAA", "Faaa, Tahiti", "Faaa, Tahiti", "PF", null, "FAA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9710", null, null),
    PFPPT("PFPPT", "Papeete", "Papeete", "PF", null, "PPT", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    PGRAW("PGRAW", "Arawa", "Arawa", "PG", null, "RAW", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0001", "0613S", "15533E"),
    PGBOR("PGBOR", "Boroko", "Boroko", "PG", null, "BOR", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9601", null, null),
    PGJAC("PGJAC", "Jacksons", "Jacksons", "PG", null, "JAC", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    PHMNL("PHMNL", "Manila", "Manila", "PH", null, "MNL", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    PKISB("PKISB", "Islamabad", "Islamabad", "PK", "IS", "ISB", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    PKKHI("PKKHI", "Karachi", "Karachi", "PK", "SD", "KHI", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    PKLHE("PKLHE", "Lahore", "Lahore", "PK", "PB", "LHE", "-23456--", null, null, "2", "3", "4", "5", "6", null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AI", "0701", null, null),
    PKUET("PKUET", "Quetta", "Quetta", "PK", "BA", "UET", "-23456--", null, null, "2", "3", "4", "5", "6", null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AI", "0701", null, null),
    PKRWP("PKRWP", "Rawalpindi", "Rawalpindi", "PK", "PB", "RWP", "-23456--", null, null, "2", "3", "4", "5", "6", null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AI", "0701", null, null),
    PLBYT("PLBYT", "Bytom", "Bytom", "PL", null, "BYT", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "AI", "9601", null, null),
    PLDZD("PLDZD", "Dzialoszyce", "Dzialoszyce", "PL", "SK", "DZD", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RQ", "1001", "5022N", "02021E"),
    PLKTW("PLKTW", "Katowice", "Katowice", "PL", null, "KTW", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    PLOPR("PLOPR", "Opor\u00f3w", "Oporow", "PL", "LD", "OPR", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RQ", "1001", "5215N", "01933E"),
    PLPRZ("PLPRZ", "Przemysl", "Przemysl", "PL", null, "PRZ", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    PLSLH("PLSLH", "Sulech\u00f3w", "Sulechow", "PL", "LB", "SLH", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "1107", "5205N", "01538E"),
    PLSZZ("PLSZZ", "Szczecin", "Szczecin", "PL", null, "SZZ", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    PNPCN("PNPCN", "Pitcairn Is", "Pitcairn Is", "PN", null, "PCN", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9601", null, null),
    PRSJU("PRSJU", "San Juan", "San Juan", "PR", null, "SIG", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "1101", "1827N", "06605W"),
    PSRMH("PSRMH", "Ramallah (Ram Allah)", "Ramallah (Ram Allah)", "PS", null, "RMH", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0907", "3154N", "03512E"),
    PTFNC("PTFNC", "Funchal, Madeira", "Funchal, Madeira", "PT", "30", "FNC", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "3238N", "01654W"),
    PTLIS("PTLIS", "Lisboa", "Lisboa", "PT", "11", "LIS", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "3843N", "00908W"),
    PTPDL("PTPDL", "Ponta Delgada", "Ponta Delgada", "PT", "20", "PDL", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "3744N", "02540W"),
    PTOPO("PTOPO", "Porto", "Porto", "PT", "13", "OPO", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "4109N", "00837W"),
    PTTER("PTTER", "Terceira Island Apt", "Terceira Island Apt", "PT", "20", "TER", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0401", "3843N", "02713W"),
    PYASU("PYASU", "Asunci\u00f3n", "Asuncion", "PY", "ASU", "ASU", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0212", "2516S", "05740W"),
    PYENO("PYENO", "Encarnaci\u00f3n", "Encarnacion", "PY", "7", "ENO", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0212", "2720S", "05554W"),
    PYSLO("PYSLO", "San Lorenzo", "San Lorenzo", "PY", null, "SLO", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    QADOH("QADOH", "Doha", "Doha", "QA", null, "DOH", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    RELPT("RELPT", "Le Port", "Le Port", "RE", null, "LPT", "1-3-5---", null, "1", null, "3", null, "5", null, null, null, "Port, Road Terminal, Postal Exchange", null, "AF", "0401", "2055S", "05518E"),
    RESDR("RESDR", "Saint-Andr\u00e9", "Saint-Andre", "RE", null, "SDR", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0212", "2056S", "05539E"),
    RESGL("RESGL", "Saint-Gilles-les Bains", "Saint-Gilles-les Bains", "RE", null, "SGL", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0212", "2102S", "05514E"),
    RESJH("RESJH", "Saint-Joseph", "Saint-Joseph", "RE", null, "SJH", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "RL", "0212", "2121S", "05537E"),
    RESPL("RESPL", "Saint-Paul", "Saint-Paul", "RE", null, "SPL", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0212", "2059S", "05516E"),
    RESPH("RESPH", "Saint-Philippe", "Saint-Philippe", "RE", null, "SPH", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "RL", "0212", "2121S", "05546E"),
    ROBUH("ROBUH", "Bucuresti", "Bucuresti", "RO", null, "BUH", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AC", "9506", null, null),
    ROBUV("ROBUV", "Bucuresti 50 Vama", "Bucuresti 50 Vama", "RO", null, "BUV", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AC", "8309", null, null),
    ROBUN("ROBUN", "Bucuresti Nord", "Bucuresti Nord", "RO", null, "BUN", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "AC", "8309", null, null),
    RSBEG("RSBEG", "Belgrade (Beograd)", "Belgrade (Beograd)", "RS", null, "BEG", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "RL", "0607", "4450N", "02031E"),
    RSNOS("RSNOS", "Novo Selo", "Novo Selo", "RS", null, "NOS", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0607", "4243N", "02019E"),
    RUEKA("RUEKA", "Ekaterinburg", "Ekaterinburg", "RU", "SVE", "EKA", "-23456--", null, null, "2", "3", "4", "5", "6", null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange, Multimodal", null, "RL", "0901", "5650N", "06036E"),
    RUMOW("RUMOW", "Moskva", "Moskva", "RU", null, "MOW", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    RULED("RULED", "Saint Petersburg (ex Leningrad)", "Saint Petersburg (ex Leningrad)", "RU", "SPE", "LED", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "5953N", "03015E"),
    RUSKD("RUSKD", "Skhodnya", "Skhodnya", "RU", "MOS", "SKD", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0901", "5557N", "03718E"),
    RUZAL("RUZAL", "Zavolzh'ye", "Zavolzh'ye", "RU", "NIZ", "ZAL", "----56--", null, null, null, null, null, "5", "6", null, null, "Postal Exchange, Multimodal", null, "RL", "1007", "5639N", "04324E"),
    RUZEL("RUZEL", "Zelenograd", "Zelenograd", "RU", "MOS", "ZEL", "-23-56--", null, null, "2", "3", null, "5", "6", null, null, "Rail Terminal, Road Terminal, Postal Exchange, Multimodal", null, "RL", "0901", "5556N", "03717E"),
    RWKGL("RWKGL", "Kigali", "Kigali", "RW", null, "KGL", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    SADMM("SADMM", "Ad Dammam", "Ad Dammam", "SA", "04", "DMM", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "RL", "0501", "2625N", "05006E"),
    SAJED("SAJED", "Jeddah", "Jeddah", "SA", null, "JED", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    SARUH("SARUH", "Riyadh", "Riyadh", "SA", null, "RUH", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9401", null, null),
    SBHIR("SBHIR", "Honiara, Guadalcanal Is", "Honiara, Guadalcanal Is", "SB", null, "HIR", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    SCSEZ("SCSEZ", "Mah\u00e9 Island Apt", "Mahe Island Apt", "SC", null, "SEZ", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0212", "0440S", "05528E"),
    SDKRT("SDKRT", "Khartoum", "Khartoum", "SD", null, "KRT", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    SDPZU("SDPZU", "Port Sudan", "Port Sudan", "SD", null, "PZU", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    SEGOT("SEGOT", "G\u00f6teborg", "Goteborg", "SE", "O", "XWL", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0207", null, null),
    SESTO("SESTO", "Stockholm", "Stockholm", "SE", "AB", "STO", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    SGSIN("SGSIN", "Singapore", "Singapore", "SG", null, "SIN", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    SHTDC("SHTDC", "Tristan da Cunha", "Tristan da Cunha", "SH", null, "TDC", "1---5---", null, "1", null, null, null, "5", null, null, null, "Port, Postal Exchange", null, "AI", "9810", null, null),
    SILJU("SILJU", "Ljubljana", "Ljubljana", "SI", null, "LJU", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    SKBTS("SKBTS", "Bratislava", "Bratislava", "SK", "BL", "BTS", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0907", "4809N", "01707E"),
    SKKSC("SKKSC", "Kosice", "Kosice", "SK", "KI", "KSC", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "0401", "4843N", "02115E"),
    SKILZ("SKILZ", "Zilina", "Zilina", "SK", null, "ILZ", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    SLFNA("SLFNA", "Freetown", "Freetown", "SL", null, "FNA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9401", null, null),
    SNDKR("SNDKR", "Dakar", "Dakar", "SN", null, "DKR", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    SOMGQ("SOMGQ", "Mogadishu", "Mogadishu", "SO", null, "MGQ", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    SRPBM("SRPBM", "Paramaribo", "Paramaribo", "SR", null, "PBM", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    STANG("STANG", "Angolares", "Angolares", "ST", null, "ANG", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    STGUA("STGUA", "Guadalupe", "Guadalupe", "ST", null, "GUA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    STMAD("STMAD", "Madalena", "Madalena", "ST", null, "MAD", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    STNEV("STNEV", "Neves", "Neves", "ST", null, "NEV", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    STRIA("STRIA", "Ribeira Afonso", "Ribeira Afonso", "ST", null, "RIA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    STSTA("STSTA", "Santana", "Santana", "ST", null, "STA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    STSAM("STSAM", "Santo Amaro", "Santo Amaro", "ST", null, "SAM", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    STTMS("STTMS", "Sao Tome Island", "Sao Tome Island", "ST", null, "TMS", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    STTRI("STTRI", "Trindade", "Trindade", "ST", null, "TRI", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    SVSAL("SVSAL", "San Salvador", "San Salvador", "SV", null, "SAL", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    SVSTA("SVSTA", "Santa Ana", "Santa Ana", "SV", null, "STA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9601", null, null),
    SXSXM("SXSXM", "Sint-Maarten Apt", "Sint-Maarten Apt", "SX", null, "SXM", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "1101", "1803N", "06307W"),
    SYALP("SYALP", "Aleppo (Alep)", "Aleppo (Alep)", "SY", null, "ALP", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    SYDAM("SYDAM", "Damascus (Damas)", "Damascus (Damas)", "SY", null, "DAM", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    SYQDR("SYQDR", "Dera'a", "Dera'a", "SY", null, "QDR", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9805", null, null),
    SZMTS("SZMTS", "Manzini", "Manzini", "SZ", null, "MTS", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9805", null, null),
    SZQMN("SZQMN", "Mbabane", "Mbabane", "SZ", null, "QMN", "-2-45---", null, null, "2", null, "4", "5", null, null, null, "Rail Terminal, Airport, Postal Exchange", null, "AI", "9805", null, null),
    TCGDT("TCGDT", "Grand Turk Island", "Grand Turk Island", "TC", null, "GDT", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    TDNDJ("TDNDJ", "N'Djamena", "N'Djamena", "TD", null, "NDJ", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0212", "1207N", "01503E"),
    TDSRH("TDSRH", "Sarh", "Sarh", "TD", null, "SRH", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9805", null, null),
    TGDPG("TGDPG", "Dapaong", "Dapaong", "TG", null, "DPG", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0601", "1051N", "00012E"),
    TGLFW("TGLFW", "Lome", "Lome", "TG", null, "LFW", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    THBKK("THBKK", "Bangkok", "Bangkok", "TH", null, "BKK", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    THHDY("THHDY", "Hat Yai", "Hat Yai", "TH", null, "HDY", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9805", null, null),
    THQJX("THQJX", "Nong Khai", "Nong Khai", "TH", "43", "QJX", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "1752N", "10244E"),
    TMCRZ("TMCRZ", "Tchardjou", "Tchardjou", "TM", null, "CRZ", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9808", null, null),
    TNMIR("TNMIR", "Monastir", "Monastir", "TN", null, "MIR", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    TNTUN("TNTUN", "Tunis", "Tunis", "TN", null, "TUN", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    TOTBU("TOTBU", "Nuku'alofa", "Nuku'alofa", "TO", null, "TBU", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0212", "2108S", "17512W"),
    TRANK("TRANK", "Ankara", "Ankara", "TR", "06", "ANK", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    TRFAT("TRFAT", "Fatih", "Fatih", "TR", "34", "FAT", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "QQ", "0212", null, null),
    TRIST("TRIST", "Istanbul", "Istanbul", "TR", "34", "IST", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "9601", null, null),
    TRIZM("TRIZM", "Izmir", "Izmir", "TR", "35", "IZM", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0601", "3825N", "02709E"),
    TTPIA("TTPIA", "Piarco", "Piarco", "TT", null, "PIA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    TTPOS("TTPOS", "Port-of-Spain", "Port-of-Spain", "TT", "POS", "POS", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0212", "1039N", "06131W"),
    TVFUN("TVFUN", "Funafuti", "Funafuti", "TV", null, "FUN", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    TWTPE("TWTPE", "Taipei", "Taipei", "TW", "TPE", "TPE", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "1101", "2502N", "12131E"),
    TZARK("TZARK", "Arusha", "Arusha", "TZ", null, "ARK", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9601", null, null),
    TZDAR("TZDAR", "Dar es Salaam", "Dar es Salaam", "TZ", null, "DAR", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0307", "0648S", "03917E"),
    TZZNZ("TZZNZ", "Zanzibar", "Zanzibar", "TZ", null, "ZNZ", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    UAIEV("UAIEV", "Kiev", "Kiev", "UA", null, "IEV", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9501", null, null),
    UGKLA("UGKLA", "Kampala", "Kampala", "UG", null, "KLA", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9501", null, null),
    USAJB("USAJB", "Albany", "Albany", "US", "IL", "AJB", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "1001", "4147N", "09013W"),
    USLXR("USLXR", "Albers", "Albers", "US", "IL", "LXR", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "0901", "3832N", "08936W"),
    USZAK("USZAK", "Alcan", "Alcan", "US", "AK", "ZAK", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "0901", "6243N", "14111W"),
    USZXA("USZXA", "Alexander", "Alexander", "US", "IL", "ZXA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "0901", "3943N", "09002W"),
    USAXP("USAXP", "Alexandria", "Alexandria", "US", "KY", "AXP", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "0901", "3857N", "08423W"),
    USLEV("USLEV", "Alexis", "Alexis", "US", "IL", "LEV", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "0901", "4103N", "09033W"),
    USNYZ("USNYZ", "Allegany", "Allegany", "US", "NY", "NYZ", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "0901", "4205N", "07829W"),
    USQWU("USQWU", "Allenton", "Allenton", "US", "NC", "QWU", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "0901", "3435N", "07855W"),
    USQEA("USQEA", "Ames", "Ames", "US", "TX", "QEA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "0901", "3003N", "09444W"),
    USANC("USANC", "Anchorage", "Anchorage", "US", "AK", "ANC", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0001", null, null),
    USUSQ("USUSQ", "Andalusia", "Andalusia", "US", "IL", "USQ", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0901", "4126N", "09043W"),
    USHJG("USHJG", "Anderson", "Anderson", "US", "CA", "HJG", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "0901", "4026N", "12217W"),
    USYRU("USYRU", "Anna", "Anna", "US", "IL", "YRU", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "0901", "3727N", "08914W"),
    USATL("USATL", "Atlanta", "Atlanta", "US", "GA", "ATL", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0001", null, null),
    USBOS("USBOS", "Boston", "Boston", "US", "MA", "BOS", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    USBUF("USBUF", "Buffalo", "Buffalo", "US", "NY", "BUF", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0207", null, null),
    USCHI("USCHI", "Chicago", "Chicago", "US", "IL", "CHI", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0207", null, null),
    USCG4("USCG4", "Clarksburg", "Clarksburg", "US", "NJ", "CG4", "123-56--", null, "1", "2", "3", null, "5", "6", null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange, Multimodal", null, "RQ", "1001", "4050N", "07459W"),
    USDEN("USDEN", "Denver", "Denver", "US", "CO", "DEN", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0001", null, null),
    USELP("USELP", "El Paso", "El Paso", "US", "TX", "ELP", "--345---", null, null, null, "3", "4", "5", null, null, null, "Road Terminal, Airport, Postal Exchange", null, "AI", "1101", "3145N", "10629W"),
    USFA2("USFA2", "Felda", "Felda", "US", "FL", "FA2", "1-3-5---", null, "1", null, "3", null, "5", null, null, null, "Port, Road Terminal, Postal Exchange", null, "RQ", "0607", "2632N", "08126W"),
    USGOH("USGOH", "Goshen", "Goshen", "US", "CT", "GOH", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "RQ", "1001", "4151N", "07314W"),
    USHG7("USHG7", "Hamburg", "Hamburg", "US", "NY", "HG7", "-23-56--", null, null, "2", "3", null, "5", "6", null, null, "Rail Terminal, Road Terminal, Postal Exchange, Multimodal", null, "RL", "1201", "4242N", "07849W"),
    USHNL("USHNL", "Honolulu", "Honolulu", "US", "HI", "HNL", "1-345---", null, "1", null, "3", "4", "5", null, null, null, "Port, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "2118N", "15751W"),
    USHOU("USHOU", "Houston", "Houston", "US", "TX", "IAH", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9501", null, null),
    USYKL("USYKL", "Hoyt Lakes", "Hoyt Lakes", "US", "MN", "YKL", "123-5---", null, "1", "2", "3", null, "5", null, null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0607", "4731N", "09207W"),
    USMKC("USMKC", "Kansas City", "Kansas City", "US", "MO", "MKC", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0207", "3906N", "09434W"),
    USLAX("USLAX", "Los Angeles", "Los Angeles", "US", "CA", "LAX", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0001", null, null),
    USMIA("USMIA", "Miami", "Miami", "US", "FL", "MIA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0001", null, null),
    USIYH("USIYH", "Miami Beach", "Miami Beach", "US", "FL", "IYH", "1-3-5---", null, "1", null, "3", null, "5", null, null, null, "Port, Road Terminal, Postal Exchange", null, "RL", "0901", "2547N", "08008W"),
    USMSP("USMSP", "Minneapolis/St Paul Apt", "Minneapolis/St Paul Apt", "US", "MN", "MSP", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "RL", "0201", "4453N", "09312W"),
    USMSY("USMSY", "New Orleans", "New Orleans", "US", "LA", "MSY", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9811", null, null),
    USNYC("USNYC", "New York", "New York", "US", "NY", "NYC", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0401", "4042N", "07400W"),
    USNOG("USNOG", "Norton", "Norton", "US", "VA", "NOG", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0607", "3656N", "08238W"),
    USOAK("USOAK", "Oakland", "Oakland", "US", "CA", "OAK", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0001", null, null),
    USORD("USORD", "O'Hare Apt/Chicago", "O'Hare Apt/Chicago", "US", "IL", "ORD", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0201", "4158N", "08754W"),
    USPHL("USPHL", "Philadelphia", "Philadelphia", "US", "PA", "PHL", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0001", null, null),
    USPY5("USPY5", "Picatinny Arsenal", "Picatinny Arsenal", "US", "NJ", "PY5", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "RL", "1201", "4057N", "07432W"),
    USP43("USP43", "Priceville", "Priceville", "US", "AL", "P43", "123-56--", null, "1", "2", "3", null, "5", "6", null, null, "Port, Rail Terminal, Road Terminal, Postal Exchange, Multimodal", null, "RQ", "1007", "3454N", "08688W"),
    USRGS("USRGS", "Rogers", "Rogers", "US", "CT", "RGS", "1-3-5---", null, "1", null, "3", null, "5", null, null, null, "Port, Road Terminal, Postal Exchange", null, "RL", "0601", "4150N", "07154W"),
    USSFO("USSFO", "San Francisco", "San Francisco", "US", "CA", "SFO", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    USSB4("USSB4", "Saybrook", "Saybrook", "US", "OH", "SB4", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RL", "0607", "4150N", "08054W"),
    USSEA("USSEA", "Seattle", "Seattle", "US", "WA", "SEA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    USSU9("USSU9", "Sigurd", "Sigurd", "US", "UT", "SU9", "-2--5---", null, null, "2", null, null, "5", null, null, null, "Rail Terminal, Postal Exchange", null, "RL", "1201", "3850N", "11158W"),
    USITG("USITG", "Summit", "Summit", "US", "IL", "ITG", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "RQ", "0907", "4147N", "08748W"),
    USTPA("USTPA", "Tampa", "Tampa", "US", "FL", "TPA", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9601", null, null),
    USTR9("USTR9", "Tremont", "Tremont", "US", "IL", "TR9", "--3-5---", null, null, null, "3", null, "5", null, null, null, "Road Terminal, Postal Exchange", null, "RL", "1107", "4031N", "89293W"),
    USINZ("USINZ", "Trinity", "Trinity", "US", "TX", "INZ", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "1201", "3056N", "09522W"),
    USTUS("USTUS", "Tucson International Apt", "Tucson International Apt", "US", "AZ", "TUS", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "0701", "3207N", "11057W"),
    USWUY("USWUY", "Waurika", "Waurika", "US", "OK", "WUY", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "1201", "3410N", "09800W"),
    USDTW("USDTW", "Wayne County Apt/Detroit", "Wayne County Apt/Detroit", "US", "MI", "DTW", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "0201", null, null),
    UYMVD("UYMVD", "Montevideo", "Montevideo", "UY", null, "MVD", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9701", null, null),
    UZTAS("UZTAS", "Tashkent", "Tashkent", "UZ", null, "TAS", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9501", null, null),
    VAVAT("VAVAT", "Vatican City", "Vatican City", "VA", null, "VAT", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9501", null, null),
    VCKTN("VCKTN", "Kingstown", "Kingstown", "VC", null, "KTN", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "RL", "0212", "1308N", "06113W"),
    VECCS("VECCS", "Caracas", "Caracas", "VE", null, "CCS", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9501", null, null),
    VEJMV("VEJMV", "Jos\u00e9 Maria Vargas", "Jose Maria Vargas", "VE", null, "JMV", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9710", null, null),
    VEMAI("VEMAI", "Maiquet\u00eda", "Maiquetia", "VE", "A", "MAI", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "0212", "1036N", "06657W"),
    VEMAR("VEMAR", "Maracaibo", "Maracaibo", "VE", null, "MAR", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9501", null, null),
    VGRAD("VGRAD", "Road Town, Tortola", "Road Town, Tortola", "VG", null, "RAD", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9501", null, null),
    VNHAN("VNHAN", "Hanoi", "Hanoi", "VN", null, "HAN", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9501", null, null),
    VNSGN("VNSGN", "Ho Chi Minh City", "Ho Chi Minh City", "VN", "65", "SGN", "1-3456--", null, "1", null, "3", "4", "5", "6", null, null, "Port, Road Terminal, Airport, Postal Exchange, Multimodal", null, "AI", "0401", "1046N", "10640E"),
    VUVLI("VUVLI", "Port Vila", "Port Vila", "VU", null, "VLI", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9501", null, null),
    WFMAU("WFMAU", "Mat\u00e2'utu", "Mata'utu", "WF", null, "MAU", "1-3-5---", null, "1", null, "3", null, "5", null, null, null, "Port, Road Terminal, Postal Exchange", null, "AI", "0401", "1317S", "17608W"),
    WSAPW("WSAPW", "Apia", "Apia", "WS", null, "APW", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9501", null, null),
    YEADE("YEADE", "Aden", "Aden", "YE", null, "ADE", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "9501", null, null),
    YEHOD("YEHOD", "Hodeidah", "Hodeidah", "YE", null, "HOD", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AI", "0401", "1450N", "04254E"),
    ZABFN("ZABFN", "Bloemfontein", "Bloemfontein", "ZA", null, "BFN", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    ZACPT("ZACPT", "Cape Town", "Cape Town", "ZA", null, "CPT", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    ZADUR("ZADUR", "Durban", "Durban", "ZA", null, "DUR", "12345---", null, "1", "2", "3", "4", "5", null, null, null, "Port, Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AI", "9501", null, null),
    ZAERM("ZAERM", "Ermelo", "Ermelo", "ZA", "MP", "ERM", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AI", "0501", "2632S", "02959E"),
    ZAJNB("ZAJNB", "Johannesburg", "Johannesburg", "ZA", null, "JNB", "-2345---", null, null, "2", "3", "4", "5", null, null, null, "Rail Terminal, Road Terminal, Airport, Postal Exchange", null, "AF", "9501", null, null),
    ZAPRF("ZAPRF", "Piet Retief", "Piet Retief", "ZA", "MP", "PRF", "-23-5---", null, null, "2", "3", null, "5", null, null, null, "Rail Terminal, Road Terminal, Postal Exchange", null, "AI", "0501", "2700S", "03048E"),
    ZAPZB("ZAPZB", "Pietermaritzburg", "Pietermaritzburg", "ZA", null, "PZB", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AF", "9501", null, null),
    ZAPLN("ZAPLN", "Pinelands", "Pinelands", "ZA", "WC", "PLN", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "RL", "1107", "3355N", "01830E"),
    ZAPED("ZAPED", "Port Edward", "Port Edward", "ZA", null, "PED", "1-3-56--", null, "1", null, "3", null, "5", "6", null, null, "Port, Road Terminal, Postal Exchange, Multimodal", null, "RL", "0601", "3103S", "03013E"),
    ZAPLZ("ZAPLZ", "Port Elizabeth", "Port Elizabeth", "ZA", null, "PLZ", "1--45---", null, "1", null, null, "4", "5", null, null, null, "Port, Airport, Postal Exchange", null, "AF", "9501", null, null),
    ZAPRY("ZAPRY", "Pretoria", "Pretoria", "ZA", null, "PRY", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AF", "9501", null, null),
    ZMCHA("ZMCHA", "Chachacha", "Chachacha", "ZM", null, "CHA", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9709", null, null),
    ZMLUM("ZMLUM", "Lumamba", "Lumamba", "ZM", null, "LUM", "----5---", null, null, null, null, null, "5", null, null, null, "Postal Exchange", null, "AI", "9805", null, null),
    ZMLUN("ZMLUN", "Lusaka", "Lusaka", "ZM", null, "LUN", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9501", null, null),
    ZWBUQ("ZWBUQ", "Bulawayo", "Bulawayo", "ZW", null, "BUQ", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9501", null, null),
    ZWHRE("ZWHRE", "Harare", "Harare", "ZW", null, "HRE", "---45---", null, null, null, null, "4", "5", null, null, null, "Airport, Postal Exchange", null, "AI", "9501", null, null);
    private final String m_sID;
    private final String m_sDisplayName;
    private final String m_sNamenodiacritics;
    private final String m_sCountry;
    private final String m_sSubdivision;
    private final String m_sIATA;
    private final String m_sFunctions;
    private final String m_sFunction_unknown;
    private final String m_sFunction_port;
    private final String m_sFunction_rail;
    private final String m_sFunction_road;
    private final String m_sFunction_air;
    private final String m_sFunction_post;
    private final String m_sFunction_multi;
    private final String m_sFunction_fixed;
    private final String m_sFunction_border;
    private final String m_sFunction;
    private final String m_sChange;
    private final String m_sStatus;
    private final String m_sDate;
    private final String m_sLatitude;
    private final String m_sLongitude;

    private EPortCode_post21(
        @Nonnull
        @Nonempty
        final String sID,
        @Nonnull
        final String sDisplayName,
        @Nullable
        final String sNamenodiacritics,
        @Nullable
        final String sCountry,
        @Nullable
        final String sSubdivision,
        @Nullable
        final String sIATA,
        @Nullable
        final String sFunctions,
        @Nullable
        final String sFunction_unknown,
        @Nullable
        final String sFunction_port,
        @Nullable
        final String sFunction_rail,
        @Nullable
        final String sFunction_road,
        @Nullable
        final String sFunction_air,
        @Nullable
        final String sFunction_post,
        @Nullable
        final String sFunction_multi,
        @Nullable
        final String sFunction_fixed,
        @Nullable
        final String sFunction_border,
        @Nullable
        final String sFunction,
        @Nullable
        final String sChange,
        @Nullable
        final String sStatus,
        @Nullable
        final String sDate,
        @Nullable
        final String sLatitude,
        @Nullable
        final String sLongitude) {
        m_sID = sID;
        m_sDisplayName = sDisplayName;
        m_sNamenodiacritics = sNamenodiacritics;
        m_sCountry = sCountry;
        m_sSubdivision = sSubdivision;
        m_sIATA = sIATA;
        m_sFunctions = sFunctions;
        m_sFunction_unknown = sFunction_unknown;
        m_sFunction_port = sFunction_port;
        m_sFunction_rail = sFunction_rail;
        m_sFunction_road = sFunction_road;
        m_sFunction_air = sFunction_air;
        m_sFunction_post = sFunction_post;
        m_sFunction_multi = sFunction_multi;
        m_sFunction_fixed = sFunction_fixed;
        m_sFunction_border = sFunction_border;
        m_sFunction = sFunction;
        m_sChange = sChange;
        m_sStatus = sStatus;
        m_sDate = sDate;
        m_sLatitude = sLatitude;
        m_sLongitude = sLongitude;
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
    public String getNamenodiacritics() {
        return m_sNamenodiacritics;
    }

    @Nullable
    public String getCountry() {
        return m_sCountry;
    }

    @Nullable
    public String getSubdivision() {
        return m_sSubdivision;
    }

    @Nullable
    public String getIATA() {
        return m_sIATA;
    }

    @Nullable
    public String getFunctions() {
        return m_sFunctions;
    }

    @Nullable
    public String getFunction_unknown() {
        return m_sFunction_unknown;
    }

    @Nullable
    public String getFunction_port() {
        return m_sFunction_port;
    }

    @Nullable
    public String getFunction_rail() {
        return m_sFunction_rail;
    }

    @Nullable
    public String getFunction_road() {
        return m_sFunction_road;
    }

    @Nullable
    public String getFunction_air() {
        return m_sFunction_air;
    }

    @Nullable
    public String getFunction_post() {
        return m_sFunction_post;
    }

    @Nullable
    public String getFunction_multi() {
        return m_sFunction_multi;
    }

    @Nullable
    public String getFunction_fixed() {
        return m_sFunction_fixed;
    }

    @Nullable
    public String getFunction_border() {
        return m_sFunction_border;
    }

    @Nullable
    public String getFunction() {
        return m_sFunction;
    }

    @Nullable
    public String getChange() {
        return m_sChange;
    }

    @Nullable
    public String getStatus() {
        return m_sStatus;
    }

    @Nullable
    public String getDate() {
        return m_sDate;
    }

    @Nullable
    public String getLatitude() {
        return m_sLatitude;
    }

    @Nullable
    public String getLongitude() {
        return m_sLongitude;
    }

    @Nullable
    public static EPortCode_post21 getFromIDOrNull(
        @Nullable
        final String sID) {
        return EnumHelper.getFromIDOrNull(EPortCode_post21 .class, sID);
    }

    @Nullable
    public static String getDisplayNameFromIDOrNull(
        @Nullable
        final String sID) {
        final EPortCode_post21 eValue = EPortCode_post21 .getFromIDOrNull(sID);
        return ((eValue == null)?null:eValue.getDisplayName());
    }
}
