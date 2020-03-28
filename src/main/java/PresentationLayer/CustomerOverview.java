package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomerOverview extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        try {
            int id = Integer.parseInt(request.getParameter("id")); // gets id from user input
            request.setAttribute("showorders", LogicFacade.showOrders(id)); // sets showorders, in request scope, sends whats in the method with it.
        } catch (Exception ne) {
            ne.getMessage();
        }
         return "customeroverview";
    }
}
