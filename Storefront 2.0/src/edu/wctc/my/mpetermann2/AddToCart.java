package edu.wctc.my.mpetermann2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get values from the request
        String id = request.getParameter("productId");
        String qty = request.getParameter("quantity");

        //Create a browser cookie for cart items

        //Return
        response.setContentType("text/plain");
        response.getWriter().write(id + " " + qty);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
