package peacocktech.in.copydbdemo.model;

/**
 * Created by peacock on 17/10/17.
 */

public class Shapmast {

    private String scode;
    private String sname;
    private String ssortname;
    private String sscode;
    private String imagename;
    private boolean selection = false;



    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsortname() {
        return ssortname;
    }

    public void setSsortname(String ssortname) {
        this.ssortname = ssortname;
    }

    public String getSscode() {
        return sscode;
    }

    public void setSscode(String sscode) {
        this.sscode = sscode;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public boolean getSelection() {

        return selection;
    }

    public void setSelection(boolean selection) {
        this.selection = selection;
    }

}
