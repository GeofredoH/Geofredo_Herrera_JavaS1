package com.company.vendingmachine;

public class Gum {
    private String brand;
    private String type;
    private String flavor;
    private int sticks;
    private String color;
    private double price;

    public Gum(String brand, String type, String flavor, int sticks, String color, double price) {
        this.brand = brand;
        this.type = type;
        this.flavor = flavor;
        this.sticks = sticks;
        this.color = color;
        this.price = price;
    }

    public void expire(){
        System.out.println("These are now expired");
    }

    public void changeColor(String color){
        this.color = color;
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

    public int getSticks() {
        return sticks;
    }

    public void setSticks(int sticks) {
        this.sticks = sticks;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
