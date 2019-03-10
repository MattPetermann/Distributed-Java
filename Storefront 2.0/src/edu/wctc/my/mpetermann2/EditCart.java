package edu.wctc.my.mpetermann2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditCart")
public class EditCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get values from request
        String id = request.getParameter("id");
        String value = request.getParameter("value");

        //Create a new cookie to override the old one
        Cookie newCookie = new Cookie("cart_" + id, value);
        newCookie.setMaxAge(60*60*24);
        response.addCookie(newCookie);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Forward to get
        doGet(request, response);
    }
}
