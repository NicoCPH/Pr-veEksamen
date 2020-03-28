package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
// -------------------------- Metoden tager imod email og credit parameter fra JSP siden og kører en metode  til at ændre credit-----------
public class
EditCredit extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, IOException {
        try {
            String email = request.getParameter("email");
            int credit = Integer.parseInt(request.getParameter("credit"));
            if (credit >= 0) {
                LogicFacade.editCredit(email,credit);
            }
        } catch (NumberFormatException exs) {
            exs.getMessage();
        }


        return "adminpage";
    }
}
