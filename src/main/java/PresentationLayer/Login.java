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


public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" ); //gets an email input from user
        String password = request.getParameter( "password" ); //gets an password input from user
        User user = LogicFacade.login( email, password ); //Sends input to method

        HttpSession session = request.getSession(); //gets Session

        session.setAttribute( "user", user ); //Sets user to Session
        session.setAttribute( "role", user.getRole() ); //Sets role to Session
        session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke

        session.setAttribute("firstname", user.getFirstName()); //Sets first name to Session
        session.setAttribute("lastname", user.getLastName());//Sets last name to Session
        session.setAttribute("userid", user.getId());//Sets id to Session

        return user.getRole() + "page";
    }

}
