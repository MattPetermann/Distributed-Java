package edu.wctc.my.mpetermann2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteFromCart")
public class DeleteFromCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Kill desired cookie
        String cookieName = "cart_" + request.getParameter("id");
        Cookie[] cookies = request.getCookies();
        for(Cookie c : cookies) {
            if(c.getName().equals(cookieName)){
                //Add a new cookie to the response
                Cookie deadCookie = new Cookie(c.getName(), c.getValue());
                deadCookie.setMaxAge(0);
                response.addCookie(deadCookie);

                //Remove the cookie from local array
                c.setMaxAge(0);
            }
        }

        //Return with updated JSON response
        response.getWriter().write(CartBuilder.getCartString(cookies));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Forward response to get
        doGet(request, response);
    }
}
