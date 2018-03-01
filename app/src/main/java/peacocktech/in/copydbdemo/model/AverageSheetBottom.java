package peacocktech.in.copydbdemo.model;

/**
 * Created by peacock on 17/10/17.
 */

public class AverageSheetBottom {

    Double weight;
    Double price1;
    Double price2;
    Double price3;


    int id;

    public AverageSheetBottom() {
    }

    public AverageSheetBottom(Double weight, Double price1, Double price2, Double price3) {
        this.weight = weight;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice1() {
        return price1;
    }

    public void setPrice1(Double price1) {
        this.price1 = price1;
    }

    public Double getPrice2() {
        return price2;
    }

    public void setPrice2(Double price2) {
        this.price2 = price2;
    }

    public Double getPrice3() {
        return price3;
    }

    public void setPrice3(Double price3) {
        this.price3 = price3;
    }
}
