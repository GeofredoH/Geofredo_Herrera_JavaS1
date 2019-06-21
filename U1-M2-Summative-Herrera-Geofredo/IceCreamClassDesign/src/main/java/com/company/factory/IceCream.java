package com.company.factory;

import java.util.Scanner;

public class IceCream {
    private String brand;
    private String name;
    private String flavor;
    private String packageType;
    private double ounces;
    private double unitPrice;
    private int batchNumber;

    //the class modeled for a factory must initialize all properties before making ice cream
    public IceCream(String brand, String name, String flavor, String packageType, double ounces, double unitPrice) {
        this.brand = brand;
        this.name = name;
        this.flavor = flavor;
        this.packageType = packageType;
        this.ounces = ounces;
        this.unitPrice = unitPrice;
    }

    public IceCream() {
        this.brand = "";
        this.name = "";
        this.flavor = "";
        this.packageType = "";
        this.ounces = 0;
        this.unitPrice = 0;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public double getOunces() {
        return ounces;
    }

    public void setOunces(double ounces) {
        this.ounces = ounces;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }
}
