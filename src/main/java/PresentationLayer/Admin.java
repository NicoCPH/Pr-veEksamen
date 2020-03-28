package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Admin extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
            String email = request.getParameter( "email" ); //gets an email input from user
            String firstName = request.getParameter( "firstname" ); // gets firstname input from user
            String lastName = request.getParameter( "lastname" ); // gets lastname input from user
            String password1 = request.getParameter( "password1" ); // get password  1 from user
            String password2 = request.getParameter( "password2" ); // get password 2 from user

            if ( password1.equals( password2 ) ) { // checks if password1 is the same as password 2
                User user = LogicFacade.createAdmin( email, password1, firstName, lastName ); // makes a new admin
                HttpSession session = request.getSession(); // gets the session so we can set the attributes that we need

                session.setAttribute("email",email);// sets email in session
                session.setAttribute( "user", user );// sets user in session
                session.setAttribute( "role", user.getRole() ); // sets role in session
                return user.getRole() + "page";
            } else {
                throw new LoginSampleException( "the two passwords did not match" );
            }

        }
    }
