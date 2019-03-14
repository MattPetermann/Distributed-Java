package edu.wctc.my.mpetermann2;

public class Product {
    private int id;
    private String name;
    private String description;
    private String[] imageUrls;
    private double price;
    private String category;

    public Product(int id, String name, String description, String[] urls, double price, String category){
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrls = urls;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public double getPrice() {
        return price;
    }
}
