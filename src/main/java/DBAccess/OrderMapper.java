package DBAccess;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.Cupcake;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    //------------------------ Method finds an order by a given user_id---------------------------------//
    public static List<Orders> initShowIdsOrders(List<Orders> showOrdersList, int id) throws LoginSampleException {
        if(showOrdersList == null){
            showOrdersList = new ArrayList<>();
        }
        try {
            PreparedStatement ps;
            Connection con = Connector.connection();
            String SQL = "SELECT \n" +
                    "        u.users_id AS users_id,\n" +
                    "        u.email AS email,\n" +
                    "        u.first_name AS first_name,\n" +
                    "        u.last_name AS last_name,\n" +
                    "        u.credit AS credit,\n" +
                    "        o.order_id AS order_id,\n" +
                    "        o.order_date AS order_date\n" +
                    "    FROM\n" +
                    "        cupcakedb.users u\n" +
                    "        inner JOIN cupcakedb.order o ON u.users_id = o.users_id\n" +
                    "\twhere u.users_id = ?;";
            ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int usersId = rs.getInt("users_id");
                String email = rs.getString("email");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                double credit = rs.getDouble("credit");
                int orderId = rs.getInt("order_id");
                Timestamp orderDate = rs.getTimestamp("order_date");
                showOrdersList.add(new Orders(email, firstName, lastName, credit, orderId, usersId, orderDate));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
        return showOrdersList;
    }


    public static void deleteOrder(int id) throws LoginSampleException {

        try {
            Connection con = Connector.connection();
            String SQL = "DELETE from cupcakedb.order WHERE order_id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    //----puts all data from database in an Arraylist and returns it so its ready to be shown later----//
    public static List<Orders> initOrdersList(List<Orders> orderslist) throws LoginSampleException {
        if (orderslist == null) {
            orderslist = new ArrayList<>();
            try {
                Connection con = Connector.connection();
                Statement st = con.createStatement();
                String SQL = "SELECT * FROM `order`;";
                ResultSet rs = st.executeQuery(SQL);
                while (rs.next()) {
                    int orderId = rs.getInt("order_id");
                    int usersId = rs.getInt("users_id");
                    Timestamp orderDate = rs.getTimestamp("order_date");
                    orderslist.add(new Orders(orderId, usersId, orderDate));
                }

            } catch (ClassNotFoundException | SQLException ex) {
                throw new LoginSampleException(ex.getMessage());
            }
        }
        return orderslist;
    }

    /*
Metoden her tager et id og sender til sql databasen, så man kan se hvilken user der har lavet en ordre på cupcake hjemmesiden.
Metoden opretter connection til databasen, inserter et user_id som fås igennem LogcFacade fra metoden createOrder og
defter fra metoden execute som liggeri klassen Payment.
Herefter laver den et preparedstatement som sætter det id i databasen og autogenerere et order_id
i databasen (order_id laves af databasen).
 */
    public static void createOrderId(int id) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO `order` (users_id) VALUES (?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    /*
    Metoden her tager et id fra metoden createOrderId og sender til sql databasen,
    så man kan se hvilken user der har lavet en ordre på cupcake hjemmesiden.
    Metoden opretter connection til databasen, inserter et order_id, quantity, sum, topping_id og bottom_id via et array
    som fås igennem LogicFacade fra metoden getCupcakes, getCupcakes for sine data fra constructoren i klassen Cupcake.
    Herefter laver den et par preparedstatement ps2 sætter et id i databasen og autogenerere et order_id
    i databasen (order_id laves af databasen). ps3 inserter dataerne fra arrayet ind i databasen via et ResultSet og et executeQuery.

     */
    public static void createOrder(int id) throws LoginSampleException {
        createOrderId(id);
        try {
            for (int i = 0; LogicFacade.getCupcakes().size() > i; i++) {
                int a = LogicFacade.getCupcakes().get(i).getBottom_id();
                int p = LogicFacade.getCupcakes().get(i).getTopping_id();
                int o = LogicFacade.getCupcakes().get(i).getQuantity();
                double q = LogicFacade.getCupcakes().get(i).getTotal_price();
                Connection con = Connector.connection();
                String SQL2 = "SELECT order_id\n" +
                        "FROM `order`\n" +
                        "WHERE users_id = ? ORDER BY order_id desc limit 1;";
                String SQL3 = "INSERT INTO `orderline` (`order_id`, `quantity`, `sum`, `topping_id`, `bottom_id`) VALUES (?, ?, ?, ?, ?);";
                PreparedStatement ps2 = con.prepareStatement(SQL2);
                PreparedStatement ps3 = con.prepareStatement(SQL3);
                ps2.setInt(1, id);
                ResultSet rs = ps2.executeQuery();
                rs.next();
                int orderId = rs.getInt("order_id");
                ps3.setInt(1, orderId);
                ps3.setInt(2, o);
                ps3.setDouble(3, q);
                ps3.setInt(4, p);
                ps3.setInt(5, a);
                ps3.executeUpdate();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    // ---------------- Takes an ArrayList and loops it an takes the id and see if theres something similar,
    // if there is, it deletes it from the Array-----------------------------------------------------------
    public static List<Cupcake> getOrderById(int id) {
        List<Cupcake> cupcakelist = LogicFacade.getNewOrder();
        for (int j = 0; j < cupcakelist.size(); j++) {
            Cupcake obj = cupcakelist.get(j);

            if (obj.getId() == id) {
                //found, delete.
                cupcakelist.remove(j);
                break;
            }
        }
        return cupcakelist;
    }

    // ---------------- Takes an ArrayList and loops it an takes the id and see if theres something similar,
    // if there is, it deletes it from the Array-----------------------------------------------------------
    public static List<Cupcake> getOrderById1(int id) {
        List<Cupcake> cupcakelist1 = LogicFacade.getCupcakes();
        for (int j = 0; j < cupcakelist1.size(); j++) {
            Cupcake obj = cupcakelist1.get(j);
            if (obj.getId1() == id) {
                //found, delete.
                cupcakelist1.remove(j);
                break;
            }
        }
        return cupcakelist1;
    }

    }


