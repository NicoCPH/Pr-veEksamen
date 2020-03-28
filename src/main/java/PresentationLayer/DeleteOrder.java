package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, IOException {
        String id = request.getParameter("id"); // gets id from input
        try {
            LogicFacade.deleteOrder(Integer.parseInt(id));// makes intput to an integer and send to method
        } catch (NumberFormatException ne) {
            throw new LoginSampleException("Kunden har ingen ordre");
        }

        return "overview";
    }
}
