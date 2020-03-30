package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
/**
 * This method executes when is called through the command.java
 * it's surrounded by a try-catch which catches any potential nullpointer errors
 * @throws java.lang.NullPointerException
 * The method gets the session, and gets the parameters topping_id, bottom_id and quantity
 * Then its using the parameter's which is the ids from the topping and bottom,
 * to look after name and prices in the CupcakeInitializer method that returns an arrayList of Cupcakes
 * @param sum1 Adds the prices from bottom and topping together
 * @param sum2 Adds the totalt price of topping and bottom and multiply with quantity
 * Then its setting up a new session Attribute and so you can get the order printed through an arraylist
 * and adding to another method which makes a new arraylist of orders. which later is used to insert to database
 * @return "customerpage" which goes to Command.java and return you to customerpage.jsp site
 */
import DBAccess.CupcakeInitializer;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class addCupcakes extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            HttpSession session = request.getSession(true);
            int topping_id = Integer.parseInt(request.getParameter("topping"));
            int bottom_id = Integer.parseInt(request.getParameter("bottom"));

            String tName = CupcakeInitializer.getBottomList().get(bottom_id).getName();
            String bName= CupcakeInitializer.getToppingList().get(topping_id).getName();
            double bPrice = CupcakeInitializer.getBottomList().get(bottom_id).getPrice();
            double tPrice = CupcakeInitializer.getToppingList().get(topping_id).getPrice();
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double sum1 = bPrice+tPrice;
            double sum2 = sum1*quantity;

           session.setAttribute("neworder", LogicFacade.newOrder(sum2,tName,bName,quantity));
           session.setAttribute("sum", sum2);
           LogicFacade.initCupcake(bottom_id, topping_id, sum2, quantity);

        }catch(NullPointerException ex){
            ex.getMessage();
        }
        return "customerpage";
    }
}
