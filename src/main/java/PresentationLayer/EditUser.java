package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import DBAccess.UserMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class EditUser extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            String email = request.getParameter("email");

            if ( password1.equals( password2 ) ) {
                LogicFacade.editPassword(email,password1);
            }
        } catch (NumberFormatException exs) {
            exs.getMessage();
        }

        return "edituser";
    }
}


