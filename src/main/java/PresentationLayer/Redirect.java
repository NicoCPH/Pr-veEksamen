package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * One example on this could be this button: href="FrontController?target=redirect&destination=customerpage"
 * Destination hentes når man trykker på knappen inde i jsp siden.
 * FrontController?target=redirect&destination=customerpage
 * man sendes til java klassen redirect
 * hvor man har initializeret en String ved navn destination, som får en værdi
 * herefter går den ned i switch casen for at udføre sin opgave
 * og breaker til sidst
 */


public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, IOException {

        String destination = request.getParameter("destination");

        switch (destination) {

            case "index": request.setAttribute("message", "Index side"); break;
            case "login": request.setAttribute( "message", "Login side"); break;
            case "edituser": request.setAttribute( "message", "Rediger bruger side"); break;
            case "overview": request.setAttribute( "message", "Oversigt over kunde/ordre bruger side"); break;
            case "customeroverview": request.setAttribute( "message", "Specifik kunde ordre"); break;
            case "payment": request.setAttribute( "message", "Betalings side"); break;
            case "receipt": request.setAttribute( "message", "Kvitterings side"); break;
            case "cart": request.setAttribute( "message", "Kurv siden"); break;
            case "customerpage": request.setAttribute( "message", "Kunde side"); break;

            case "adminpage": if (request.getSession().getAttribute("role").equals("admin") ) {
                request.setAttribute("message", "Admin side");
            } else { throw new LoginSampleException("Du er ikke en admin bruger"); }; break;

            case "logout": request.getSession().invalidate(); request.setAttribute( "message", "logout side"); break;

            default: request.setAttribute("message", "Denne side findes ikke"); break;

        }
        return destination;
    }
}
