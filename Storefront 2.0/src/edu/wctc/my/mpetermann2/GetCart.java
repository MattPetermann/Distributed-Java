package edu.wctc.my.mpetermann2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetCart")
public class GetCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie[] cookies = request.getCookies();
        String json = "{\"cart\": [";

        //Cross reference cookies against inventory
        for(Cookie c : cookies) {
            if(c.getName().indexOf("cart_") != 1) {
                String id = c.getName().substring(5);
                for (Product p : Inventory.getInventory()) {
                    if(("" + p.getId()).equals(id)){
                        //Add the id and count to json string
                        json += json.length() > 10 ? "," : "";
                        json += "{\"id\": " + id + ", \"name\": \"" + p.getName() + "\", \"qty\": " + c.getValue() + "}";
                    }
                }
            }
        }

        //Return json string
        response.getWriter().write(json + "]}");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doGet(request, response);
    }
}
