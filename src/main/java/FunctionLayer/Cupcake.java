package FunctionLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
//-------------------------------------Cupecake constructors from the cupcake, so u can make a cupcake---------------------------//
public class Cupcake {
    private static int count =0;
    private static int count1 = 0;
    private int id;
    private int id1;
    private int bottom_id;
    private int topping_id;
    private double topping_price;
    private double bottom_price;
    private double total_price;
    private String topping_name;
    private String bottom_name;
    private int quantity;
    private boolean isFilled; // boolean defaults to false

    public Cupcake(int bottom_id, int topping_id, double total_price, int quantity) {
        this.bottom_id = bottom_id;
        this.topping_id = topping_id;
        this.total_price = total_price;
        this.quantity = quantity;
        isFilled = false;
        this.id1 = count1++;
    }

    public Cupcake(double total_price, String topping_name, String bottom_name, int quantity) {
        this.total_price = total_price;
        this.topping_name = topping_name;
        this.bottom_name = bottom_name;
        this.quantity = quantity;
        isFilled = false;     // sets false to false
        this.id = count++;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBottom_id() {
        return bottom_id;
    }

    public void setBottom_id(int bottom_id) {
        this.bottom_id = bottom_id;
    }

    public int getTopping_id() {
        return topping_id;
    }

    public void setTopping_id(int topping_id) {
        this.topping_id = topping_id;
    }

    public double getTopping_price() {
        return topping_price;
    }

    public void setTopping_price(double topping_price) {
        this.topping_price = topping_price;
    }

    public double getBottom_price() {
        return bottom_price;
    }

    public void setBottom_price(double bottom_price) {
        this.bottom_price = bottom_price;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        total_price = getTopping_price()+getBottom_price()*getQuantity();
        this.total_price = total_price;
    }

    public String getTopping_name() {
        return topping_name;
    }

    public void setTopping_name(String topping_name) {
        this.topping_name = topping_name;
    }

    public String getBottom_name() {
        return bottom_name;
    }

    public void setBottom_name(String bottom_name) {
        this.bottom_name = bottom_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
