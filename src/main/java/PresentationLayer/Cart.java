package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cart extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        return "cart";
    }
}
