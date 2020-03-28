package FunctionLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
//--------------------------- order constructor that makes orders.------------------------------------//
import java.sql.Timestamp;

public class Orders {

    private String email;
    private String firstName;
    private String lastName;
    private double credit;
    private int order_id;
    private int users_id;
    private int orderUsers_id;
    private Timestamp order_date;

    public Orders(int order_id, int users_id, Timestamp order_date) {
        this.order_id = order_id;
        this.users_id = users_id;
        this.order_date = order_date;
    }

    public Orders(String email, String firstName, String lastName, double credit, int order_id, int users_id, Timestamp order_date) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credit = credit;
        this.order_id = order_id;
        this.users_id = users_id;
        this.order_date = order_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }


    public int getOrderUsers_id() {
        return orderUsers_id;
    }

    public void setOrderUsers_id(int orderUsers_id) {
        this.orderUsers_id = orderUsers_id;
    }
}
