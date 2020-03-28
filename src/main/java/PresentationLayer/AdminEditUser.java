package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminEditUser extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            String password1 = request.getParameter("password1");// get password  1 from user
            String password2 = request.getParameter("password2");// get password  2 from user
            String email = request.getParameter("email"); //gets an email input from user
            int credit = Integer.parseInt(request.getParameter("credit")); //gets an credit input from user
            if (credit < 0) { // if credit is below 0, it dosent go to if statment
                LogicFacade.editCredit(email,credit);
            }
            if ( password1.equals( password2 ) ) { // checks if password1 is the same as password 2
                LogicFacade.editPassword(email,password1);
            }
        } catch (NumberFormatException exs) {
            exs.getMessage();
        }

        return "adminpage";
    }
}
