package FunctionLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
//-----------------------------------------------------Bottom constructors from the cupcake-------------------------------------------------//
public class Bottom {
    private int bottom_id;
    private String name;
    private double price;

    public Bottom(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Bottom(int bottom_id, String name, double price) {
        this.bottom_id = bottom_id;
        this.name = name;
        this.price = price;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public void setBottom_id(int bottom_id) {
        this.bottom_id = bottom_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
