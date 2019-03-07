package edu.wctc.my.mpetermann2;

public class Product {
    private int id;
    private String name;
    private String description;
    private String summary;
    private String[] imageUrls;
    private double price;

    public Product(int id, String name, String description, String summary, String[] urls, double price){
        this.id = id;
        this.name = name;
        this.description = description;
        this.summary = summary;
        this.imageUrls = urls;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
