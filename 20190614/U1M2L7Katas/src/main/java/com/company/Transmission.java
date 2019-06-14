package com.company;

public class Transmission {
    private int gears;
    private String brand;
    private String model;

    public Transmission(int gears, String brand, String model) {
        this.gears = gears;
        this.brand = brand;
        this.model = model;
    }

    public Transmission() {
        this.gears = 0;
        this.brand = "";
        this.model = "";
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
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
}
