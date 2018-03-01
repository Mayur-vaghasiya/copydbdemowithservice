package peacocktech.in.copydbdemo.model;

/**
 * Created by peacock on 30/10/17.
 */

public class wheelmast {

    private String wcode;
    private String wvalue;

    public wheelmast(String code, String name) {
        this.wcode=code;
        this.wvalue=name;
    }

    public String getWcode() {
        return wcode;
    }

    public void setWcode(String wcode) {
        this.wcode = wcode;
    }

    public String getWvalue() {
        return wvalue;
    }

    public void setWvalue(String wvalue) {
        this.wvalue = wvalue;
    }

}
