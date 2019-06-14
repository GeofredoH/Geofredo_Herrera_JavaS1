package com.company.vendingmachine;

public class HealthFood {
    private String brand;
    private String flavor;
    private int ounces;
    private String type;
    private double price;
    private int calories;
    private boolean organic;

    public HealthFood(String brand, String flavor, int ounces, String type, double price, int calories, boolean organic) {
        this.brand = brand;
        this.flavor = flavor;
        this.ounces = ounces;
        this.type = type;
        this.price = price;
        this.calories = calories;
        this.organic = organic;
    }

    public void expireAfterOpen(int days){
        System.out.println("These now expire " + " days after opening");
    }

    public void becomeStale(){
        System.out.println("Ugh, these are STALE!");
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

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isOrganic() {
        return organic;
    }

    public void setOrganic(boolean organic) {
        this.organic = organic;
    }
}
