package com.company;

import com.company.interfaces.Vehicle;

public class Car implements Vehicle {

    private String make;
    private String model;
    private int milesTraveled;

    public Car(String make, String model, int milesTraveled) {
        this.make = make;
        this.model = model;
        this.milesTraveled = milesTraveled;
    }

    public Car(){
        this.make = "";
        this.model = "";
        this.milesTraveled = 0;
    }

    public void drive(int miles){
        this.milesTraveled += miles;
    }

    public void displayMilesTraveled(){
        System.out.println(milesTraveled);
    }

    public int getMilesTraveled() {
        return milesTraveled;
    }

    public void setMilesTraveled(int milesTraveled) {
        this.milesTraveled = milesTraveled;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
