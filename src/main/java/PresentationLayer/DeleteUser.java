package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUser extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, IOException {
        try {
            String dEmail = request.getParameter("demail"); // gets user input demail

            if(dEmail != null) {// if input dosent contain anything, it dosent go down in the if statement
                LogicFacade.deleteUser(dEmail); // sends input to method
            }
        }catch (Exception ex){
            ex.getMessage();
        }
        return "adminpage";
    }
}
