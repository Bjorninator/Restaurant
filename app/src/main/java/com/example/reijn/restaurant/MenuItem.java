package com.example.reijn.restaurant;

public class MenuItem {
    private double price;
    private String name,description,imageurl, category;

    public MenuItem(double price, String name, String description, String imageurl, String category) {
        this.price = price;
        this.name = name;
        this.description = description;
        this.imageurl = imageurl;
        this.category = category;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {

        return price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getCategory() {
        return category;
    }
}
