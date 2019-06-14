package com.company.vendingmachine;

public class Chips {
    private String brand;
    private String flavor;
    private int ounces;
    private String type;
    private double price;

    public Chips(String brand, String flavor, int ounces, String type, double price) {
        this.brand = brand;
        this.flavor = flavor;
        this.ounces = ounces;
        this.type = type;
        this.price = price;
    }

    public void expireAfterOpen(int days){
        System.out.println("These now expire " + " days after opening");
    }

    public void becomeStale(){
        System.out.println("Ugh, those are STALE!");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getOunces() {
        return ounces;
    }

    public void setOunces(int ounces) {
        this.ounces = ounces;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
