package edu.wctc.my.mpetermann2;

import java.util.ArrayList;

public class Inventory {
    private static ArrayList<Product> inv = null;

    private Inventory() {
        inv = new ArrayList<>();

        inv.add(new Product("Nevada Jack Poker Chips", "25 count", "http://placehold.it/240x240", 19.99));
        inv.add(new Product("Faded Spades Playing Cards", "100% plastic", "http://placehold.it/240x240", 14.99));
        inv.add(new Product("Acrylic Dealer Puck", "4\" diameter", "http://placehold.it/240x240", 9.99));
    }

    public static ArrayList<Product> getInventory() {
        if(inv == null)
            new Inventory();

        return inv;
    }
}
