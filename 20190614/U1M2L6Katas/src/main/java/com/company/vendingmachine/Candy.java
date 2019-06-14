package com.company.vendingmachine;

public class Candy {
    private String brand;
    private String type;
    private String flavor;
    private String color;
    private int ounces;
    private double price;
    private boolean expired;

    public Candy(String brand, String type, String flavor, String color, int ounces, double price) {
        this.brand = brand;
        this.type = type;
        this.flavor = flavor;
        this.color = color;
        this.ounces = ounces;
        this.price = price;
    }

    public void expire(boolean expired){
        this.expired = expired;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOunces() {
        return ounces;
    }

    public void setOunces(int ounces) {
        this.ounces = ounces;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
