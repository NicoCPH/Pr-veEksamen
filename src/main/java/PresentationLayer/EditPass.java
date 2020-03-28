package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//---------- Metoden tager imod email, password1 og password2 parameter fra JSP siden og kører en metode  til at ændre password------------//
public class EditPass extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            String email = request.getParameter("uemail");


            if ( password1.equals( password2) && password1 != null ) {
                LogicFacade.editPassword(email,password1);
            }
        } catch (NumberFormatException exs) {
            exs.getMessage();
        }

        return "adminpage";
    }
}
