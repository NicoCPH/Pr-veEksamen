package FunctionLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */

import DBAccess.OrderMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;
import java.util.List;

public class LogicFacade {



    /*
   All methods in this class, is called in the Commands classes and where its needed,
   so all database code from DBAccess pacakage dosen't interfere directly with the specefic java code thats been shown in html.
   So it works kinda like an extra security, called encapsulation.
     */
    private static List<Orders> orderslist;
    private static List<User> userlist;
    private static List<Cupcake> newOrder;
    private static List<Cupcake> cupcakes;
    private static List<Orders> showOrdersList;





    public static List<Orders> getShowOrdersList() {

        return showOrdersList;
    }


    public static List<Orders> getOrdersList() {

        return orderslist;
    }

    public static List<User> getUserList() {

        return userlist;
    }


    public static List<User> user( ) throws LoginSampleException {
        getUserList();
        return UserMapper.initUserList( userlist );
    }


    public static User createUser( String email, String password, String first_name, String last_name ) throws LoginSampleException {
        User user = new User(email, password, "customer", first_name, last_name);
        UserMapper.createUser( user );
        return user;
    }

    public static User createAdmin( String email, String password, String first_name, String last_name ) throws LoginSampleException {
        User user = new User(email, password, "admin", first_name, last_name);
        UserMapper.createAdmin( user );
        return user;
    }

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    }


    public static User editPassword(String email, String password) throws LoginSampleException {
        User user = new User(email, password);
        UserMapper.editPassword(password, email);
        return user;
    }

    public static User editCredit( String email, int credit ) throws LoginSampleException {
        User user = new User(email, credit);
        UserMapper.editCredit(credit, email);
        return user;
    }
    public static void deleteUser(String email) throws LoginSampleException {
        UserMapper.deleteUser(email);
    }

    public static void deleteOrder(int id) throws LoginSampleException {
        OrderMapper.deleteOrder(id);
    }

    public static void updateCredit(int id, double newCredit) throws LoginSampleException {
        UserMapper.updateCredit(id, newCredit);
    }

    public static double showCredit(int id) throws LoginSampleException {
        return UserMapper.showCredit(id);
    }

    public static int createOrder(int id) throws LoginSampleException {
        OrderMapper.createOrder(id);
        return id;
    }

    public static List<Cupcake> newOrder(double sum2, String tName, String bName, int quantity) {
        if (newOrder == null){
            newOrder = new ArrayList<>();
        }
        newOrder.add(new Cupcake(sum2, tName, bName,quantity));
        return newOrder;
    }

    public static void initCupcake(int bottom_id, int topping_id, double total_price, int quantity) {
        if(cupcakes == null){
            cupcakes = new ArrayList<>();
        }
        cupcakes.add(new Cupcake(bottom_id,topping_id,total_price,quantity));
    }

    public static List<Cupcake> getNewOrder() {
        return newOrder;
    }

    public static List<Orders> orders(  ) throws LoginSampleException {
        getOrdersList();
        return OrderMapper.initOrdersList( orderslist );
    }

    public static List<Cupcake> getCupcakes() {
        return cupcakes;
    }

    public static List<Orders> showOrders(int id) throws LoginSampleException {
        getShowOrdersList();
        return OrderMapper.initShowIdsOrders(showOrdersList, id);
    }

}
