package com.company;

public class Engine {
    private int cylinders;
    private int horsePower;
    private String brand;
    private String model;

    public Engine(int cylinders, int horsePower, String brand, String model) {
        this.cylinders = cylinders;
        this.horsePower = horsePower;
        this.brand = brand;
        this.model = model;
    }

    public Engine() {
        this.cylinders = 0;
        this.horsePower = 0;
        this.brand = "";
        this.model = "";
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
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
