package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterAdminUser extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, IOException {
        String email = request.getParameter( "email" ); //gets an email input from user
        String firstName = request.getParameter( "firstname" ); // gets firstname input from user
        String lastName = request.getParameter( "lastname" ); // gets lastname input from user
        String password1 = request.getParameter( "password1" ); // get password  1 from user
        String password2 = request.getParameter( "password2" ); // get password 2 from user

        if ( password1.equals( password2 ) ) { // checks if password1 is the same as password 2
            LogicFacade.createUser( email, password1, firstName, lastName ); // makes a new admin
            return "adminpage";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }
}
