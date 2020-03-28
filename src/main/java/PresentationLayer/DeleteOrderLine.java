package PresentationLayer;
/**
 @author Mark, Nicolas, Henrik, Jean-Poul
 */
import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    public class DeleteOrderLine extends Command {
        @Override
        String execute (HttpServletRequest request, HttpServletResponse response) throws
                LoginSampleException, IOException {
            try{
                String deleteOrder = request.getParameter("delete"); // gets input from user.

                if (deleteOrder != null) { // if input dosent contain anything, it dosent go down in the if statement
                    int deleteid = Integer.parseInt(deleteOrder); // parses to and int
                    OrderMapper.getOrderById(deleteid); // sends id to method
                    OrderMapper.getOrderById1(deleteid);// sends id to method
                    return "cart";
                }
            }catch (Exception e){
                e.getMessage();
            }

            return "cart";
        }

    }
