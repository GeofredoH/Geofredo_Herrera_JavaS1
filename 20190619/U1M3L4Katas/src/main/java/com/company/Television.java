package com.company;

public class Television {

    private String brand;
    private String model;
    private String price;
    private String screenSize;

    public Television(String brand, String model, String price, String screenSize) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.screenSize = screenSize;
    }

    public Television() {
        this.brand = "";
        this.model = "";
        this.price = "";
        this.screenSize = "";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }
}
