package peacocktech.in.copydbdemo.model;

/**
 * Created by peacock on 15/10/17.
 */

public class RoughList {

    private String RoughCaratTotal="";
    private String FCahr="";
    private String Totalamounts="";
    private String rowid = "";
    private String rough_name = "";
    private String company_name = "";
    private String total_carat = "";
    private String date = "";
    private String broker_name = "";
    private String rough_carat = "";
    private String view_carat = "";
    private String tot_amt = "";
    private String PerCart_Default = "";
    private String Disc = "";
    private String final_per_carat = "";
    private String end_date="";
    private String up_date="";
    private String PerCart_Static = "";
    private String rate = "";
    private String tot_amt_static = "";
    /*18-12-17*/
    private String newroughname = "";


    public RoughList(String rough_name, String company_name, String broker_name, String rough_carat, String view_carat, String tot_amt, String perCrt_default, String rapDisc_static,
                     String douFinPerCarat, String ent_str, String udp_date, String perCrt_static, String rate, String douAmtStatic) {

        this.rough_name = rough_name;

        this.company_name = company_name;
        this.broker_name = broker_name;
        this.rough_carat = rough_carat;
        this.view_carat = view_carat;
        this.tot_amt = tot_amt;
        this.PerCart_Default = perCrt_default;
        this.PerCart_Static = perCrt_static;
        this.tot_amt_static = douAmtStatic;
        this.end_date = ent_str;
        this.up_date = udp_date;
        this.rate = rate;
        this.final_per_carat = douFinPerCarat;
        this.Disc = rapDisc_static;


    }


    public RoughList(String rough_name, String rough_carat, String date, String company_name, String broker_name) {

        this.rough_name = rough_name;
        this.broker_name = broker_name;
        this.rough_carat = rough_carat;
        this.company_name = company_name;
        this.end_date = date;

    }

    public RoughList(String rough_name, String end_date) {
        this.rough_name = rough_name;
        this.end_date = end_date;
    }

    public RoughList() {

    }

    public RoughList(String rough_name) {
        this.rough_name = rough_name;
    }

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
    }

    public String getRough_name() {
        return rough_name;
    }

    public void setRough_name(String rough_name) {
        this.rough_name = rough_name;
    }


    /*18-12-17*/


    public String getRoughCaratTotal() {
        return RoughCaratTotal;
    }

    public void setRoughCaratTotal(String roughCaratTotal) {
        RoughCaratTotal = roughCaratTotal;
    }

    public String getTotalamounts() {
        return Totalamounts;
    }

    public void setTotalamounts(String totalamounts) {
        Totalamounts = totalamounts;
    }

    public String getFCahr() {
        return FCahr;
    }

    public void setFCahr(String FCahr) {
        this.FCahr = FCahr;
    }

    public String getNewroughname() {
        return newroughname;
    }

    public void setNewroughname(String newroughname) {
        this.newroughname = newroughname;
    }


    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getTotal_carat() {
        return total_carat;
    }

    public void setTotal_carat(String total_carat) {
        this.total_carat = total_carat;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBroker_name() {
        return broker_name;
    }

    public void setBroker_name(String broker_name) {
        this.broker_name = broker_name;
    }

    public String getRough_carat() {
        return rough_carat;
    }

    public void setRough_carat(String rough_carat) {
        this.rough_carat = rough_carat;
    }

    public String getView_carat() {
        return view_carat;
    }

    public void setView_carat(String view_carat) {
        this.view_carat = view_carat;
    }

    public String getTot_amt() {
        return tot_amt;
    }

    public void setTot_amt(String tot_amt) {
        this.tot_amt = tot_amt;
    }

    public String getPerCart_Default() {
        return PerCart_Default;
    }

    public void setPerCart_Default(String perCart_Default) {
        this.PerCart_Default = perCart_Default;
    }

    public String getDisc() {
        return Disc;
    }

    public void setDisc(String disc) {
        Disc = disc;
    }

    public String getFinal_per_carat() {
        return final_per_carat;
    }

    public void setFinal_per_carat(String final_per_carat) {
        this.final_per_carat = final_per_carat;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getUp_date() {
        return up_date;
    }

    public void setUp_date(String up_date) {
        this.up_date = up_date;
    }

    public String getPerCart_Static() {
        return PerCart_Static;
    }

    public void setPerCart_Static(String perCart_Static) {
        this.PerCart_Static = perCart_Static;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTot_amt_static() {
        return tot_amt_static;
    }

    public void setTot_amt_static(String tot_amt_static) {
        this.tot_amt_static = tot_amt_static;
    }


}
