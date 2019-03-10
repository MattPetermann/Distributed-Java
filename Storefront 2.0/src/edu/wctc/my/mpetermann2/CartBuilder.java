package edu.wctc.my.mpetermann2;

import javax.servlet.http.Cookie;

public class CartBuilder {
    public static String getCartString(Cookie[] cookies) {
        //Initialize json string
        String json = "{\"cart\": [";

        //Cross reference cookies against inventory
        for(Cookie c : cookies) {
            if(c.getName().indexOf("cart_") != 1 && c.getMaxAge() != 0) {
                String id = c.getName().substring(5);
                for (Product p : Inventory.getInventory()) {
                    if(("" + p.getId()).equals(id)){
                        //Add the id and count to json string
                        json += json.length() > 10 ? "," : "";
                        json += "{\"id\": " + id + ", \"name\": \"" + p.getName() +
                                "\", \"qty\": " + c.getValue() +
                                ", \"price\": " + p.getPrice() + "}";
                    }
                }
            }
        }

        //Close json string
        return json + "]}";
    }
}
