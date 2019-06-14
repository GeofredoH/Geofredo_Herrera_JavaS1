package com.company.store;

public class Soda {
    private String brand;
    private String flavor;
    private int ounces;
    private String bottleType;

    public Soda(String brand, String flavor, int ounces, String bottleType) {
        this.brand = brand;
        this.flavor = flavor;
        this.ounces = ounces;
        this.bottleType = bottleType;
    }

    public void evaporate(){
        System.out.println("zzzzzzzzzzzz");
    }

    public void expireAfterOpen(int days){
        System.out.println("This item now expires " + days + " from now.");
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

    public String getBottleType() {
        return bottleType;
    }

    public void setBottleType(String bottleType) {
        this.bottleType = bottleType;
    }
}
