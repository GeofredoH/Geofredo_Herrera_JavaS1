package com.company.home;

public class Basement {
    private int area;
    private int length;
    private int width;
    private String flooringType;
    private int itemAmount;

    public void storeUnusedItem(int items){
        this.itemAmount += items;
    }

    public int returnItems(int items){
        this.itemAmount -= items;
        return items;
    }

    public Basement(int area, int length, int width, String flooringType, int itemAmount) {
        this.area = area;
        this.length = length;
        this.width = width;
        this.flooringType = flooringType;
        this.itemAmount = itemAmount;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }
}
