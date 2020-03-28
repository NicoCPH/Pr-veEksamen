package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LoginSampleException;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "logout", new Logout() );
        commands.put( "register", new Register() );
        commands.put( "cart", new Cart() );
        commands.put( "admin", new Admin() );
        commands.put( "payment", new Payment() );
        commands.put( "receipt", new Receipt() );
        commands.put( "customeroverview", new CustomerOverview() );
        commands.put( "shopping", new Shopping() );
        commands.put( "edituser", new EditUser() );
        commands.put( "adminedituser", new AdminEditUser() );
        commands.put( "dropdown", new addCupcakes() );
        commands.put( "orderline", new OrderLine() );
        commands.put( "redirect", new Redirect() );
        commands.put( "deleteuser", new DeleteUser());
        commands.put( "editcredit", new EditCredit());
        commands.put( "editpass", new EditPass() );
        commands.put( "deleteorder", new DeleteOrder() );
        commands.put( "deleteorderline", new DeleteOrderLine() );
        commands.put( "registeradmin", new RegisterAdmin() );
        commands.put( "registeruser", new RegisterAdminUser() );
    }

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response )
            throws LoginSampleException, IOException;

}
