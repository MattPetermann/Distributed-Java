package edu.wctc.my.mpetermann2;

import java.util.ArrayList;

public class Inventory {
    private static ArrayList<Product> inv = null;

    private Inventory() {
        inv = new ArrayList<>();

        inv.add(new Product("Product 1", "This is product one.", "http://placehold.it/240x240", 7.99));
        inv.add(new Product("Product 2", "This is product two.", "http://placehold.it/240x240", 8.99));
        inv.add(new Product("Product 3", "This is product three.", "http://placehold.it/240x240", 9.99));
    }

    public static ArrayList<Product> getInventory() {
        if(inv == null)
            new Inventory();

        return inv;
    }
}
