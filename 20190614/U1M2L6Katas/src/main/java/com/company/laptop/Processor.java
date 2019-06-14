package com.company.laptop;

public class Processor {
    private String brand;
    private String model;
    private float speed;
    private boolean ecoMode;

    public Processor(String brand, String model, float speed) {
        this.brand = brand;
        this.model = model;
        this.speed = speed;
    }

    public void speedUp(){
        this.speed++;
    }

    public void toggleEcoMode() {
        this.ecoMode = !ecoMode;
    }

    public boolean isEcoMode() {
        return ecoMode;
    }

    public void setEcoMode(boolean ecoMode) {
        this.ecoMode = ecoMode;
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
