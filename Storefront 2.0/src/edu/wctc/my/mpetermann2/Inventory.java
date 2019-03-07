package edu.wctc.my.mpetermann2;

import java.util.ArrayList;

public class Inventory {
    private static ArrayList<Product> inv = null;

    private Inventory() {
        inv = new ArrayList<>();

        inv.add(new Product(
                0,
                "Nevada Jack Casino Grade Ceramic 10-gram Poker Chip – Pack of 50",
                "These premium poker chips are made with casino grade ceramic—the same ceramic Casinos " +
                        "prefer! Those looking for an authentic experience should look no further. Available in 9 " +
                        "colorful denominations ranging from $0.25 to $5,000, all artwork is printed directly on the " +
                        "chip using a dye-sublimation process and incorporates Old West style with clear, easy-to-read " +
                        "denominations. The ceramic’s grippy texture makes stacking these chips a breeze.",
                "These premium poker chips are made with casino grade ceramic.",
                new String[]{
                        "https://images-na.ssl-images-amazon.com/images/I/51enCt3eMNL.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/511bu6pblNL.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/51McGAZBK1L.jpg"
                },
                39.99));
        inv.add(new Product(
                1,
                "Bicycle Prestige Dura-Flex Playing Cards",
                "Many professionals prefer the flexibility and durability of plastic cards. " +
                        "The Bicycle Prestige cards offers unmatched durability and is the only 100-Percent " +
                        "plastic card to offer a paper-like feel. Perfect for a neighborhood game or a " +
                        "professional tournament.",
                "Many professionals prefer the flexibility and durability of plastic cards.",
                new String[]{
                        "https://images-na.ssl-images-amazon.com/images/I/61zU1WnhG-L._SL1001_.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/71O-y0ISc-L._SL1000_.jpg"
                },
                8.97));
        inv.add(new Product(
                2,
                "Da Vinci Large 3 Inch Double Sided Casino Grade Pro Dealer Button Puck",
                "The button is double sided with one side off white and one side black and the word Dealer " +
                        "carved on both sides. Made of heavy duty acrylic with rubber bumper. Item height is 3/4 inch. " +
                        "Use in your Texas Holdem poker games.",
                "The button is double sided with one side off white and one side black and the word Dealer " +
                        "carved on both sides.",
                new String[]{"https://images-na.ssl-images-amazon.com/images/I/41qmKpo1tdL.jpg"},
                8.99));
    }

    public static ArrayList<Product> getInventory() {
        if(inv == null)
            new Inventory();

        return inv;
    }
}
