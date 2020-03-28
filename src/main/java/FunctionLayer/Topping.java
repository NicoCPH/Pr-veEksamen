package FunctionLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
//---------------------------------- Topping constructor that haves all info from toppings-----------------------------------//
public class Topping {
    private int topping_id;
    private String name;
    private double price;

    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Topping(int topping_id, String name, double price) {
        this.topping_id = topping_id;
        this.name = name;
        this.price = price;
    }

    public int getTopping_id() {
        return topping_id;
    }

    public void setTopping_id(int topping_id) {
        this.topping_id = topping_id;
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
