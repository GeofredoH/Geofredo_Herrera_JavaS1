package com.company.laptop;

public class Memory {
    private int gbAmount;
    private  String brand;
    private String model;
    private String type;
    private String data;

    public Memory(int gbAmount, String brand, String model, String type) {
        this.gbAmount = gbAmount;
        this.brand = brand;
        this.model = model;
        this.type = type;
    }

    public String returnInfo(){
        return data;
    }

    public void storeInfo(String data){
        this.data = data;
    }

    public int getGbAmount() {
        return gbAmount;
    }

    public void setGbAmount(int gbAmount) {
        this.gbAmount = gbAmount;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
