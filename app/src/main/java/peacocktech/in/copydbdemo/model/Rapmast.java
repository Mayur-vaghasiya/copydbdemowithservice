package peacocktech.in.copydbdemo.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by peacock on 31/10/17.
 */

public class Rapmast implements Serializable {

    private boolean isSelected = false;

    private String Ser_no, Stone_no, S_CODE, S_NAME, Q_CODE, Q_NAME, C_CODE, C_NAME, CT_CODE, CT_NAME, SY_CODE,
            SY_NAME, FL_CODE, TIN_CODE, SIN_CODE, BIN_CODE, SBIN_CODE, BRN_CODE, TN_CODE, FL_NAME,
            Rough_name, Ent_date, Upt_date, alphabet, Rough_carat, Pol_Carat, Pol_percent, TotAmt,
            PerCrt_static, RapAmt, RapDisc,DolDisc, RapRate, PerCrt_Default, Rapdisc_static, TotAmtStatic;

    private ArrayList<Rapmast> list;

    // For Update Constructorc
    public Rapmast(String ser_no, String s_code, String s_name, String q_code, String q_name, String c_code, String c_name, String ct_code, String ct_name,
                   String sy_code, String sy_name, String fl_code, String tin_code, String sin_code, String bin_code, String sbin_code, String brn_code,
                   String tn_code, String fl_name, String pol_carat, String pol_percent, String rough_carat, String dolDisc, String rapRate,
                   String rapAmt, String rapDisc, String totAmt, String perCrt_default, String perCrt_static, int i1, String udp_date, String totAmtStatic,
                   String rough_name, String stone_no) {


        Ser_no = ser_no;
        Stone_no = stone_no;
        S_CODE = s_code;
        S_NAME = s_name;
        Q_CODE = q_code;
        Q_NAME = q_name;
        C_CODE = c_code;
        C_NAME = c_name;
        CT_CODE = ct_code;
        CT_NAME = ct_name;
        SY_CODE = sy_code;
        SY_NAME = sy_name;
        FL_CODE = fl_code;
        TIN_CODE = tin_code;
        SIN_CODE = sin_code;
        BIN_CODE = bin_code;
        SBIN_CODE = sbin_code;
        BRN_CODE = brn_code;
        TN_CODE = tn_code;
        FL_NAME = fl_name;
        Rough_name = rough_name;
        Upt_date = udp_date;
        Rough_carat = rough_carat;
        Pol_Carat = pol_carat;
        Pol_percent = pol_percent;
        TotAmt = totAmt;
        PerCrt_static = perCrt_static;
        RapAmt = rapAmt;
        RapDisc = rapDisc;
        DolDisc = dolDisc;
        RapRate = rapRate;
        PerCrt_Default = perCrt_default;
        Rapdisc_static = String.valueOf(i1);
        TotAmtStatic = totAmtStatic;


    }
    // Insert Constructor
    public Rapmast(String ser_no, String s_code, String s_name, String q_code, String q_name, String c_code, String c_name, String ct_code, String ct_name,
                   String sy_code, String sy_name, String fl_code, String tin_code, String sin_code, String bin_code, String sbin_code, String brn_code,
                   String tn_code, String fl_name, String pol_carat, String pol_percent, String rough_carat, String dolDisc, String rapRate,
                   String rapAmt, String rapDisc, String totAmt, String perCrt_default, String perCrt_static, int i1,String ent_date , String udp_date, String totAmtStatic,
                   String rough_name, String stone_no) {


        Ser_no = ser_no;
        Stone_no = stone_no;
        S_CODE = s_code;
        S_NAME = s_name;
        Q_CODE = q_code;
        Q_NAME = q_name;
        C_CODE = c_code;
        C_NAME = c_name;
        CT_CODE = ct_code;
        CT_NAME = ct_name;
        SY_CODE = sy_code;
        SY_NAME = sy_name;
        FL_CODE = fl_code;
        TIN_CODE = tin_code;
        SIN_CODE = sin_code;
        BIN_CODE = bin_code;
        SBIN_CODE = sbin_code;
        BRN_CODE = brn_code;
        TN_CODE = tn_code;
        FL_NAME = fl_name;
        Rough_name = rough_name;
        Ent_date = ent_date;
        Upt_date = udp_date;
        Rough_carat = rough_carat;
        Pol_Carat = pol_carat;
        Pol_percent = pol_percent;
        TotAmt = totAmt;
        PerCrt_static = perCrt_static;
        RapAmt = rapAmt;
        RapDisc = rapDisc;
        DolDisc = dolDisc;
        RapRate = rapRate;
        PerCrt_Default = perCrt_default;
        Rapdisc_static = String.valueOf(i1);
        TotAmtStatic = totAmtStatic;


    }


    public Rapmast() {
    }

    public Rapmast(String rough_name, String stone_no) {
        Stone_no = stone_no;
        Rough_name = rough_name;
    }

    public Rapmast(ArrayList<Rapmast> list) {
        this.list = list;
    }

    public ArrayList<Rapmast> getList() {
        return list;
    }

    public void setList(ArrayList<Rapmast> list) {
        this.list = list;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getSer_no() {
        return Ser_no;
    }

    public void setSer_no(String ser_no) {
        Ser_no = ser_no;
    }

    public String getStone_no() {
        return Stone_no;
    }

    public void setStone_no(String stone_no) {
        Stone_no = stone_no;
    }

    public String getS_CODE() {
        return S_CODE;
    }

    public void setS_CODE(String s_CODE) {
        S_CODE = s_CODE;
    }

    public String getS_NAME() {
        return S_NAME;
    }

    public void setS_NAME(String s_NAME) {
        S_NAME = s_NAME;
    }

    public String getQ_CODE() {
        return Q_CODE;
    }

    public void setQ_CODE(String q_CODE) {
        Q_CODE = q_CODE;
    }

    public String getQ_NAME() {
        return Q_NAME;
    }

    public void setQ_NAME(String q_NAME) {
        Q_NAME = q_NAME;
    }

    public String getC_CODE() {
        return C_CODE;
    }

    public void setC_CODE(String c_CODE) {
        C_CODE = c_CODE;
    }

    public String getC_NAME() {
        return C_NAME;
    }

    public void setC_NAME(String c_NAME) {
        C_NAME = c_NAME;
    }

    public String getCT_CODE() {
        return CT_CODE;
    }

    public void setCT_CODE(String CT_CODE) {
        this.CT_CODE = CT_CODE;
    }

    public String getCT_NAME() {
        return CT_NAME;
    }

    public void setCT_NAME(String CT_NAME) {
        this.CT_NAME = CT_NAME;
    }

    public String getSY_CODE() {
        return SY_CODE;
    }

    public void setSY_CODE(String SY_CODE) {
        this.SY_CODE = SY_CODE;
    }

    public String getSY_NAME() {
        return SY_NAME;
    }

    public void setSY_NAME(String SY_NAME) {
        this.SY_NAME = SY_NAME;
    }

    public String getFL_CODE() {
        return FL_CODE;
    }

    public void setFL_CODE(String FL_CODE) {
        this.FL_CODE = FL_CODE;
    }

    public String getTIN_CODE() {
        return TIN_CODE;
    }

    public void setTIN_CODE(String TIN_CODE) {
        this.TIN_CODE = TIN_CODE;
    }

    public String getSIN_CODE() {
        return SIN_CODE;
    }

    public void setSIN_CODE(String SIN_CODE) {
        this.SIN_CODE = SIN_CODE;
    }

    public String getBIN_CODE() {
        return BIN_CODE;
    }

    public void setBIN_CODE(String BIN_CODE) {
        this.BIN_CODE = BIN_CODE;
    }

    public String getSBIN_CODE() {
        return SBIN_CODE;
    }

    public void setSBIN_CODE(String SBIN_CODE) {
        this.SBIN_CODE = SBIN_CODE;
    }

    public String getBRN_CODE() {
        return BRN_CODE;
    }

    public void setBRN_CODE(String BRN_CODE) {
        this.BRN_CODE = BRN_CODE;
    }

    public String getTN_CODE() {
        return TN_CODE;
    }

    public void setTN_CODE(String TN_CODE) {
        this.TN_CODE = TN_CODE;
    }

    public String getFL_NAME() {
        return FL_NAME;
    }

    public void setFL_NAME(String FL_NAME) {
        this.FL_NAME = FL_NAME;
    }

    public String getRough_name() {
        return Rough_name;
    }

    public void setRough_name(String rough_name) {
        Rough_name = rough_name;
    }

    public String getEnt_date() {
        return Ent_date;
    }

    public void setEnt_date(String ent_date) {
        Ent_date = ent_date;
    }

    public String getUpt_date() {
        return Upt_date;
    }

    public void setUpt_date(String upt_date) {
        Upt_date = upt_date;
    }

    public String getPol_Carat() {
        return Pol_Carat;
    }

    public void setPol_Carat(String pol_Carat) {
        Pol_Carat = pol_Carat;
    }

    public String getPol_percent() {
        return Pol_percent;
    }

    public void setPol_percent(String pol_percent) {
        Pol_percent = pol_percent;
    }

    public String getRough_carat() {
        return Rough_carat;
    }

    public void setRough_carat(String rough_carat) {
        Rough_carat = rough_carat;
    }

    public String getDolDisc() {
        return DolDisc;
    }

    public void setDolDisc(String dolDisc) {
        DolDisc = dolDisc;
    }

    public String getRapRate() {
        return RapRate;
    }

    public void setRapRate(String rapRate) {
        RapRate = rapRate;
    }

    public String getRapAmt() {
        return RapAmt;
    }

    public void setRapAmt(String rapAmt) {
        RapAmt = rapAmt;
    }

    public String getRapDisc() {
        return RapDisc;
    }

    public void setRapDisc(String rapDisc) {
        RapDisc = rapDisc;
    }

    public String getTotAmt() {
        return TotAmt;
    }

    public void setTotAmt(String totAmt) {
        TotAmt = totAmt;
    }

    public String getPerCrt_Default() {
        return PerCrt_Default;
    }

    public void setPerCrt_Default(String perCrt_Default) {
        PerCrt_Default = perCrt_Default;
    }

    public String getPerCrt_static() {
        return PerCrt_static;
    }

    public void setPerCrt_static(String perCrt_static) {
        PerCrt_static = perCrt_static;
    }

    public String getRapdisc_static() {
        return Rapdisc_static;
    }

    public void setRapdisc_static(String rapdisc_static) {
        Rapdisc_static = rapdisc_static;
    }

    public String getTotAmtStatic() {
        return TotAmtStatic;
    }

    public void setTotAmtStatic(String totAmtStatic) {
        TotAmtStatic = totAmtStatic;
    }


}
