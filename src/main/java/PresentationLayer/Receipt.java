package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Receipt extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession(); // gets session
        Double newCredit = (Double) session.getAttribute("credit-total"); // makes a new attribute
        int id = (int) session.getAttribute("userid"); // gets userid from session
        LogicFacade.updateCredit(id, newCredit); // sends parameter to method
        session.setAttribute("totalcredit", newCredit); // ses new attribute to session with name = totalcredit

        double total = 0;

            for (int i = 0; LogicFacade.getNewOrder().size() < i; i++) {

                double pris = LogicFacade.getNewOrder().get(i).getTotal_price();
                total += pris;// loops arraylist and makes a totalt price of everything inside

            }

        return "receipt";
    }
}
