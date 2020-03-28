package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
     Klassen Payment bliver extended af Command. Command tager et http servlet request, et http servlet response
     og laver en metode med hashmaps. Metoden execute tager et request og et response. Den laver herefter et session,
     en variable og henter et id sessionen og sender det til metoden createOrder igennem LogicFacade,
     hvorefter den retunerer klassen payment.
*/
public class Payment extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("userid");
        LogicFacade.createOrder(id);
        double getCredit = LogicFacade.showCredit(id);
        session.setAttribute("credit", getCredit);

        if (getCredit <= 0) {
            throw new LoginSampleException("Du har ikke nok penge på din konto");
        }
        return "payment";
    }
}
