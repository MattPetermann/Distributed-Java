package edu.wctc.my.mpetermann2;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventory {
    private static ArrayList<Product> inv = null;

    private Inventory() {
        inv = new ArrayList<>();

        inv.add(new Product(
                0,
                "Nevada Jack Casino Grade Ceramic 10-gram Poker Chip Pack of 50",
                "These premium poker chips are made with casino grade ceramic—the same ceramic Casinos " +
                        "prefer! Those looking for an authentic experience should look no further. Available in 9 " +
                        "colorful denominations ranging from $0.25 to $5,000, all artwork is printed directly on the " +
                        "chip using a dye-sublimation process and incorporates Old West style with clear, easy-to-read " +
                        "denominations. The ceramic’s grippy texture makes stacking these chips a breeze.",
                new String[]{
                        "https://images-na.ssl-images-amazon.com/images/I/51enCt3eMNL.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/511bu6pblNL.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/51McGAZBK1L.jpg"
                },
                39.99,
                "Chips"
        ));
        inv.add(new Product(
                1,
                "Bicycle Prestige Dura-Flex Playing Cards",
                "Many professionals prefer the flexibility and durability of plastic cards. " +
                        "The Bicycle Prestige cards offers unmatched durability and is the only 100-Percent " +
                        "plastic card to offer a paper-like feel. Perfect for a neighborhood game or a " +
                        "professional tournament.",
                new String[]{
                        "https://images-na.ssl-images-amazon.com/images/I/61zU1WnhG-L._SL1001_.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/71O-y0ISc-L._SL1000_.jpg"
                },
                8.97,
                "Cards"));
        inv.add(new Product(
                2,
                "Da Vinci Large 3 Inch Double Sided Casino Grade Pro Dealer Button Puck",
                "The button is double sided with one side off white and one side black and the word Dealer " +
                        "carved on both sides. Made of heavy duty acrylic with rubber bumper. Item height is 3/4 inch. " +
                        "Use in your Texas Holdem poker games.",
                new String[]{
                        "https://images-na.ssl-images-amazon.com/images/I/41qmKpo1tdL.jpg"
                },
                8.99,
                "Accessories"
        ));
        inv.add(new Product(
                3,
                "BBO Poker Ultimate Folding Poker Table for 10 Players with Felt Playing Surface, " +
                        "92 x 44-Inch Oval",
                "Compact enough to fit into your SUV, the easily portable Ultimate poker table from BBO Poker " +
                        "seats up to 10 and folds down for easy storage. The Ultimate has heavy duty steel folding legs, " +
                        "a sturdy reinforced frame, an easy-to-clean faux leather vinyl armrest (which is removable for " +
                        "quick changes to the playing surface), and a beautiful scratch-resistant laminate racetrack " +
                        "with ten 3-inch stainless steel cup holders. " +
                        "The Ultimate offers a choice of two playing surfaces -- poker felt or water-resistant suited " +
                        "speed cloth (a smooth polyester weave fabric that provides faster card slides). The table " +
                        "measures 92 x 44 x 30 inches (LxWxH). " +
                        "BBO Poker Tables manufactures stylish, high quality poker tables and game night tables for " +
                        "players who demand a premium showpiece at an affordable price. All tables are upholstered in " +
                        "California. In 2015, BBO Poker Tables was named the official poker table supplier of the " +
                        "World Poker Tour.",
                new String[]{
                        "https://images-na.ssl-images-amazon.com/images/I/6138QQQl7CL._SL1250_.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/710bmO7eQBL._SL1250_.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/615rv4coe-L._SL1250_.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/61UEZt-pgxL._SL1250_.jpg"
                },
                755.00,
                "Tables"
        ));
        inv.add(new Product(
                4,
                "Brybelly Clear Acrylic Chip Rack - Holds 100 Chips",
                "Acrylic chip trays hold 100 poker chips each. Twenty chips in a row, five rows per tray. " +
                        "For home or professional use.",
                new String[] {
                        "https://images-na.ssl-images-amazon.com/images/I/51QflRnsFeL._SL1000_.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/61202dbDtEL._SL1000_.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/615wBBfTquL._SL1000_.jpg"
                },
                6.99,
                "Storage"
        ));
        inv.add(new Product(
                5,
                "Brybelly Acrylic Poker Chip Carrier (1000-Count) with Chip Trays",
                "If you want to bring the casino feel to your next home game, this 1,000 count acrylic poker " +
                        "chip carrier is the perfect solution. This case holds 1,000 poker chips " +
                        "(CHIPS ARE NOT INCLUDED). Each carrier is constructed of durable acrylic with reinforced " +
                        "corners. The top opens easily and a secure handle makes it convenient to transport your " +
                        "chips from place to place. The carrier measures approximately 10-Inch L x 8-Inch W x 13-Inch H. " +
                        "This is the same type of carrier that you would see in a casino when a security guard delivers " +
                        "large quantities of chips to a gaming table. Ten stackable acrylic chip trays are also " +
                        "included. Each chip tray holds 100 chips (Chips Not Included). This acrylic carrier is great " +
                        "for storing your poker chips when they aren't in use, and it also serves as a great way to " +
                        "showcase your important chips. Heavy-duty and made to last, this 1,000 count acrylic carrier " +
                        "with 10 acrylic chip trays makes a great gift idea for any avid poker enthusiast.",
                new String[] {
                        "https://images-na.ssl-images-amazon.com/images/I/711cp18DHpL._SL1500_.jpg",
                        "https://images-na.ssl-images-amazon.com/images/I/71%2BM8V5usJL._SL1455_.jpg"
                },
                64.99,
                "Storage"
        ));
    }

    public static ArrayList<Product> getInventory() {
        if(inv == null)
            new Inventory();

        return inv;
    }

    public static ArrayList<String> getCategories() {
        ArrayList<String> categories = new ArrayList<>();

        for(Product p : getInventory()) {
            boolean exists = false;
            for(String cat : categories) {
                if(cat.equals(p.getCategory()))
                    exists = true;
            }
            if(!exists) categories.add(p.getCategory());
        }

        return categories;
    }
}