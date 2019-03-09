package edu.wctc.my.mpetermann2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //Get values from the request
        String id = request.getParameter("productId");
        String qty = request.getParameter("quantity");

        //Create a browser cookie for new item
        Cookie newCookie = new Cookie("cart_" + id, qty);
        newCookie.setMaxAge(60*60*24);

        //Check if cookie already exists for this item
        Cookie[] currentCookies = request.getCookies();
        for(Cookie c : currentCookies) {
            if(c.getName().equals(newCookie.getName())){
                newCookie.setValue(
                        "" + (Integer.parseInt(c.getValue()) + Integer.parseInt(newCookie.getValue()))
                );
                break;
            }
        }

        //Add the cookie to the response
        response.addCookie(newCookie);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        //Forward post as a get
        doGet(request, response);
    }
}
