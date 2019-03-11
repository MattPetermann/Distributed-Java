package edu.wctc.my.mpetermann2;

public class Product {
    private int id;
    private String name;
    private String description;
    private String[] imageUrls;
    private double price;

    public Product(int id, String name, String description, String[] urls, double price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrls = urls;
        this.price = price;
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

    public String[] getImageUrls() {
        return imageUrls;
    }

    public double getPrice() {
        return price;
    }
}
