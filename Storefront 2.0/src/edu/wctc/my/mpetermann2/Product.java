package edu.wctc.my.mpetermann2;

public class Product {
    private String name;
    private String description;
    private String imageUrl;
    private double price;

    public Product(String n, String d, String i, double p){
        name = n;
        description = d;
        imageUrl = i;
        price = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
