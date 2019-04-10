package edu.wctc.my.mpetermann2;

import java.sql.*;
import java.util.ArrayList;

public class Inventory {
    //Stores the inventory
    private static ArrayList<Product> inv = null;

    //Track if DB is instantiated
    private static boolean _dbExists = false;

    //Instantiate the inventory
    private Inventory() {
        inv = new ArrayList<>();

        if(!_dbExists) {
            createDatabase();
            addContent();
            _dbExists = true;
        }
    }

    //Instantiate the database
    public static void createDatabase() {
        try {
            //Create a connection
            Connection conn = DriverManager.getConnection("jdbc:derby:StoreDB;create=true");

            //Drop existing tables
            dropTables(conn);

            //Add tables
            buildProductTable(conn);
            buildImageTable(conn);
            conn.close();
        } catch (Exception e){}
    }

    //Drop any existing tables in the database
    public static void dropTables(Connection conn) {
        try {
            Statement stmt = conn.createStatement();

            stmt.execute(
                    "DROP TABLE Product"
            );
        }catch (Exception e){}
        try {
            Statement stmt = conn.createStatement();

            stmt.execute(
                    "DROP TABLE Image"
            );
        }catch (Exception e){}
    }

    //Instantiate the product table
    public static void buildProductTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(
                    "CREATE TABLE Product (" +
                            "ProductId INT NOT NULL PRIMARY KEY, " +
                            "ProductName VARCHAR(4000), " +
                            "Description VARCHAR(4000), " +
                            "Price DOUBLE, " +
                            "Category VARCHAR(4000) " +
                            ")"
            );
        } catch (Exception e) {}
    }

    //Instantiate the images table
    public static void buildImageTable(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(
                    "CREATE TABLE Image (" +
                            "ProductId INT, " +
                            "URL VARCHAR(4000)" +
                            ")"
            );
        } catch(Exception e){}
    }

    //Add rows to the database
    public static void addContent() {
        try {
            //Create a connection
            Connection conn = DriverManager.getConnection("jdbc:derby:StoreDB");

            //Add rows
            addProducts(conn);
            addImages(conn);
            conn.close();
        } catch (Exception e){}
    }

    //Add rows to the product table
    public static void addProducts(Connection conn) {
        try {
            Statement stmt = conn.createStatement();

            //Add each product
            stmt.executeUpdate(
                    "INSERT INTO Product " +
                            "(ProductId, ProductName, Description, Price, Category) " +
                            "VALUES (0, 'Nevada Jack Casino Grade Ceramic 10-gram Poker Chip Pack of 50', " +
                            "'These premium poker chips are made with casino grade ceramic—the same ceramic Casinos " +
                            "prefer! Those looking for an authentic experience should look no further. Available in 9 " +
                            "colorful denominations ranging from $0.25 to $5,000, all artwork is printed directly on the " +
                            "chip using a dye-sublimation process and incorporates Old West style with clear, easy-to-read " +
                            "denominations. The ceramic’s grippy texture makes stacking these chips a breeze.', " +
                            "39.99, 'Chips')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Product " +
                            "(ProductId, ProductName, Description, Price, Category) " +
                            "VALUES (1, 'Bicycle Prestige Dura-Flex Playing Cards', " +
                            "'Many professionals prefer the flexibility and durability " +
                            "of plastic cards. The Bicycle Prestige cards offers unmatched " +
                            "durability and is the only 100-Percent plastic card to offer " +
                            "a paper-like feel. Perfect for a neighborhood game or a " +
                            "professional tournament.', " +
                            "8.97, 'Cards')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Product " +
                            "(ProductId, ProductName, Description, Price, Category) " +
                            "VALUES (2, 'Da Vinci Large 3 Inch Double Sided Casino Grade Pro Dealer Button Puck', " +
                            "'The button is double sided with one side off white " +
                            "and one side black and the word Dealer carved on both sides. " +
                            "Made of heavy duty acrylic with rubber bumper. Item height is " +
                            "3/4 inch. Use in your Texas Holdem poker games.', " +
                            "8.99, 'Accessories')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Product " +
                            "(ProductId, ProductName, Description, Price, Category) " +
                            "VALUES (3, 'BBO Poker Ultimate Folding Poker Table for 10 Players with Felt " +
                            "Playing Surface, 92 x 44-Inch Oval', " +
                            "'Compact enough to fit into your SUV, the easily portable Ultimate poker " +
                            "table from BBO Poker seats up to 10 and folds down for easy storage. The " +
                            "Ultimate has heavy duty steel folding legs, a sturdy reinforced frame, an " +
                            "easy-to-clean faux leather vinyl armrest (which is removable for quick " +
                            "changes to the playing surface), and a beautiful scratch-resistant laminate " +
                            "racetrack with ten 3-inch stainless steel cup holders. The Ultimate offers a " +
                            "choice of two playing surfaces -- poker felt or water-resistant suited speed " +
                            "cloth (a smooth polyester weave fabric that provides faster card slides). The " +
                            "table measures 92 x 44 x 30 inches (LxWxH). BBO Poker Tables manufactures " +
                            "stylish, high quality poker tables and game night tables for players who " +
                            "demand a premium showpiece at an affordable price. All tables are upholstered " +
                            "in California. In 2015, BBO Poker Tables was named the official poker table " +
                            "supplier of the World Poker Tour.', " +
                            "755.00, 'Tables')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Product " +
                            "(ProductId, ProductName, Description, Price, Category) " +
                            "VALUES (4, 'Brybelly Clear Acrylic Chip Rack - Holds 100 Chips'," +
                            "'Acrylic chip trays hold 100 poker chips each. Twenty chips in a row, " +
                            "five rows per tray. For home or professional use.', " +
                            "6.99, 'Storage')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Product " +
                            "(ProductId, ProductName, Description, Price, Category) " +
                            "VALUES (5, 'Brybelly Acrylic Poker Chip Carrier (1000-Count) with Chip Trays'," +
                            "'If you want to bring the casino feel to your next home game, this 1,000 count " +
                            "acrylic poker chip carrier is the perfect solution. This case holds 1,000 poker " +
                            "chips (CHIPS ARE NOT INCLUDED). Each carrier is constructed of durable acrylic " +
                            "with reinforced corners. The top opens easily and a secure handle makes it " +
                            "convenient to transport your chips from place to place. The carrier measures " +
                            "approximately 10-Inch L x 8-Inch W x 13-Inch H. This is the same type of carrier " +
                            "that you would see in a casino when a security guard delivers large quantities of " +
                            "chips to a gaming table. Ten stackable acrylic chip trays are also included. Each " +
                            "chip tray holds 100 chips (Chips Not Included). This acrylic carrier is great for " +
                            "storing your poker chips when they aren''t in use, and it also serves as a great way " +
                            "to showcase your important chips. Heavy-duty and made to last, this 1,000 count " +
                            "acrylic carrier with 10 acrylic chip trays makes a great gift idea for any avid " +
                            "poker enthusiast.', " +
                            "64.99, 'Storage')"
            );
        } catch(Exception e){}
    }

    //Add rows to the image table
    public static void addImages(Connection conn) {
        try {
            Statement stmt = conn.createStatement();

            //Add each image
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL)" +
                            "VALUES(0, 'https://images-na.ssl-images-amazon.com/images/I/51enCt3eMNL.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(0, 'https://images-na.ssl-images-amazon.com/images/I/511bu6pblNL.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(0, 'https://images-na.ssl-images-amazon.com/images/I/51McGAZBK1L.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(1, 'https://images-na.ssl-images-amazon.com/images/I/61zU1WnhG-L._SL1001_.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(1, 'https://images-na.ssl-images-amazon.com/images/I/71O-y0ISc-L._SL1000_.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(2, 'https://images-na.ssl-images-amazon.com/images/I/41qmKpo1tdL.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(3, 'https://images-na.ssl-images-amazon.com/images/I/6138QQQl7CL._SL1250_.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(3, 'https://images-na.ssl-images-amazon.com/images/I/710bmO7eQBL._SL1250_.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(3, 'https://images-na.ssl-images-amazon.com/images/I/615rv4coe-L._SL1250_.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(3, 'https://images-na.ssl-images-amazon.com/images/I/61UEZt-pgxL._SL1250_.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(4, 'https://images-na.ssl-images-amazon.com/images/I/51QflRnsFeL._SL1000_.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(4, 'https://images-na.ssl-images-amazon.com/images/I/61202dbDtEL._SL1000_.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(4, 'https://images-na.ssl-images-amazon.com/images/I/615wBBfTquL._SL1000_.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(5, 'https://images-na.ssl-images-amazon.com/images/I/711cp18DHpL._SL1500_.jpg')"
            );
            stmt.executeUpdate(
                    "INSERT INTO Image (ProductId, URL) " +
                            "VALUES(5, 'https://images-na.ssl-images-amazon.com/images/I/71%2BM8V5usJL._SL1455_.jpg')"
            );
        } catch(Exception e){}
    }

    //Retrieve inventory from database
    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();

        if(!_dbExists)
            new Inventory();

        try {
            Connection conn = DriverManager.getConnection("jdbc:derby:StoreDB");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT Product.ProductId, ProductName, Description, Price, Category, URL FROM Product " +
                            "JOIN Image ON Product.ProductId = Image.ProductId"
            );

            //Temp item
            int id = -1;
            String name = "";
            String desc = "";
            ArrayList<String> images = null;
            double price = 0.00;
            String cat = "";

            //Loop over the result set
            while(rs.next()) {
                //This is a new product from the previous row
                if(rs.getInt("ProductId") != id) {
                    //Add the previous item if there is one
                    if(images != null)
                        inventory.add(new Product(id, name, desc,
                                images.toArray(new String[]{}), price, cat));

                    //Update temp values for new item
                    images = new ArrayList<>();
                    id = rs.getInt("ProductId");
                    name = rs.getString("ProductName");
                    desc = rs.getString("Description");
                    images.add(rs.getString("URL"));
                    price = rs.getDouble("Price");
                    cat = rs.getString("Category");
                }
                //This is the same product - just add the image
                else {
                    images.add(rs.getString("URL"));
                }
            }

            inventory.add(new Product(id, name, desc,
                    images.toArray(new String[]{}), price, cat));

            //Clean up
            rs.close();
            stmt.close();
            conn.close();
        } catch(Exception e){
            inventory.add(new Product(77, "error", e.getMessage(),
                    new String[]{"http://placehold.it/500x500"}, 0, ""));
        }

        return inventory;
    }

    //Return a list of categories
    public static ArrayList<String> getCategories() {
        //Empty Array List
        ArrayList<String> categories = new ArrayList<>();

        //If this category is not already saved, save it
        for(Product p : getInventory()) {
            boolean exists = false;
            for(String cat : categories) {
                if(cat.equals(p.getCategory()))
                    exists = true;
            }
            if(!exists) categories.add(p.getCategory());
        }

        //Return the list of categories
        return categories;
    }

    //Count the number of items of specified category
    public static int countItemsInCategory(String category) {
        //Begin count
        int count = 0;

        //Check all items in the inventory
        for(Product p : getInventory())
            if(p.getCategory().equals(category))
                count++;

        //Return number of items
        return count;
    }
}