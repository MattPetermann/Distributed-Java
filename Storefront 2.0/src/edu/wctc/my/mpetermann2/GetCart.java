package edu.wctc.my.mpetermann2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GetCart")
public class GetCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Build a json file based on cookies and send it back
        String json = CartBuilder.getCartString(request.getCookies());
        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Forward to get
        doGet(request, response);
    }
}
