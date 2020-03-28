package DBAccess;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Orders;
import FunctionLayer.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
public class UserMapper {


    //--------- Creates and user and inserts the new user in the database-----------//
    public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, role, first_name, last_name, credit) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
            ps.setDouble(6, user.getCredit());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    //---- select all users and looks for a user with the specific data from  the database---//
    public static User login(String email, String password) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT users_id, role, first_name, last_name FROM users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String role = rs.getString("role");
                int id = rs.getInt("users_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                User user = new User(email, password, role, firstName, lastName);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    //------- this creates a users with a role as an admin---------//
    public static void createAdmin(User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO users (email, password, role, first_name, last_name, credit) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
            ps.setDouble(6, user.getCredit());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

//-------- this initalizes all users, so it can be shown later in the code, and add it in an arraylist------//
    public static List<User> initUserList(List<User> userlist) throws LoginSampleException {
        if (userlist == null) {
            userlist = new ArrayList<>();
            try {
                Connection con = Connector.connection();
                Statement st = con.createStatement();
                String SQL = "SELECT * FROM `users`;";
                ResultSet rs = st.executeQuery(SQL);
                while (rs.next()) {
                    int usersId = rs.getInt("users_id");
                    String email = rs.getString("email");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String password = rs.getString("password");
                    double credit = rs.getDouble("credit");
                    String role = rs.getString("role");
                    userlist.add(new User(usersId, email, firstName, lastName, password, role, credit));
                }

            } catch (ClassNotFoundException | SQLException ex) {
                throw new LoginSampleException(ex.getMessage());
            }
        }

        return userlist;
    }


    /*
    Metode til at redigere kredit på en brugers konto:
    Opretter connection til databasen, hvorefter der laves en sql update på credit i databasen,
    som laves på en valgt bruger via brugerens email.
    Herefter executer preparedStatement'et koden.
    Try/catch: loginsampleexception via en getMessage.
            */
    public static User editCredit(double editCredit, String email) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE cupcakedb.users SET credit = ? WHERE (email = ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble(1, editCredit);
            ps.setString(2, email);
            ps.executeUpdate();
            User user = new User(email, editCredit);
            return user;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    //------- This method edits a password with a given email from user input----//
    public static User editPassword(String editPassword, String email) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE cupcakedb.users SET password = ? WHERE (email = ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, editPassword);
            ps.setString(2, email);
            ps.executeUpdate();
            User user = new User(email, editPassword);
            return user;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }

    }
//---------- This method deletes a user with a given email input from admin -------//
    public static User deleteUser(String email) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "DELETE from cupcakedb.users WHERE email = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.executeUpdate();
            User user = new User(email);
            System.out.println(user.toString());
            return user;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

// this method updates credit with a given user_id given from an input--------//
    public static User updateCredit(int id, double newCredit) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE cupcakedb.users SET credit = ? WHERE (users_id = ?);";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setDouble(1, newCredit);
            ps.setInt(2, id);
            ps.executeUpdate();
            User user = new User(id, newCredit);
            return user;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    //---- shows credit from given users_id-------//
    public static double showCredit(int id) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT credit FROM cupcakedb.users WHERE users_id = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            double credit = rs.getDouble("credit");
            return credit;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


}
