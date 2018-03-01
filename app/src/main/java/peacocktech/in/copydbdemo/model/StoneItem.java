package peacocktech.in.copydbdemo.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by peacock on 10/11/17.
 */

public class StoneItem implements Serializable {


    public String getRoughName() {
        return roughName;
    }

    public void setRoughName(String roughName) {
        this.roughName = roughName;
    }

    public String getRoughdate() {
        return roughdate;
    }

    public void setRoughdate(String roughdate) {
        this.roughdate = roughdate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public double getTotalCT() {
        return totalCT;
    }

    public void setTotalCT(double totalCT) {
        this.totalCT = totalCT;
    }

    public double getTotalAmt() {
        return totalAmt;
    }

    public void setTotalAmt(double totalAmt) {
        this.totalAmt = totalAmt;
    }

    public double getPerCT() {
        return perCT;
    }

    public void setPerCT(double perCT) {
        this.perCT = perCT;
    }

    public double getLess() {
        return less;
    }

    public void setLess(double less) {
        this.less = less;
    }

    public double getFinPerCT() {
        return finPerCT;
    }

    public void setFinPerCT(double finPerCT) {
        this.finPerCT = finPerCT;
    }

    public ArrayList<Rapmast> getLstRapMaster() {
        return lstRapMaster;
    }

    public void setLstRapMaster(ArrayList<Rapmast> lstRapMaster) {
        this.lstRapMaster = lstRapMaster;
    }

    String roughName="";
    String roughdate="";
    String companyName="";
    String brokerName="";

    double totalCT,totalAmt,perCT,less,finPerCT;
    ArrayList<Rapmast> lstRapMaster;


}
