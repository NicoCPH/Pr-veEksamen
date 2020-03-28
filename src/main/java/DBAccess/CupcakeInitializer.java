package DBAccess;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.*;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;



public class CupcakeInitializer {

    private static Map<Integer, Bottom> bottomList;
    private static Map<Integer, Topping> toppingList;


    public static Map<Integer, Bottom> getBottomList() {
        return bottomList;
    }

    public static Map<Integer, Topping> getToppingList() {
        return toppingList;
    }

    //.............................. Toppings fra database......................
    public static void initToppings() {
        if (toppingList == null) {
            toppingList = new HashMap<>();
            try {
                Connection con = Connector.connection();
                Statement stmt = con.createStatement();
                String SQL = "SELECT * FROM topping;";
                ResultSet rs = stmt.executeQuery(SQL);
                while (rs.next()) {
                    int id = rs.getInt("topping_id" +
                            "");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    toppingList.put(id, new Topping(id, name, price));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }


    }

    //.............................. Bottoms fra database......................
    public static void initBottoms() {
        if (bottomList == null) {
            bottomList = new HashMap<>();
            try {
                Connection con = Connector.connection();
                Statement stmt = con.createStatement();
                String SQL = "SELECT * FROM bottom;";
                ResultSet rs = stmt.executeQuery(SQL);
                while (rs.next()) {
                    int id = rs.getInt("bottom_id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    bottomList.put(id, new Bottom(id, name, price));

                }

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }


    }
}
