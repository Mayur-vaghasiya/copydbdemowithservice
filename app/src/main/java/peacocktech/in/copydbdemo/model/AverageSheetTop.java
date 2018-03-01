package peacocktech.in.copydbdemo.model;

/**
 * Created by peacock on 17/10/17.
 */

public class AverageSheetTop {

    Double weight;
    Double price;


    int id;

    public AverageSheetTop() {
    }

    public AverageSheetTop(Double weight, Double price) {
        this.weight = weight;
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
