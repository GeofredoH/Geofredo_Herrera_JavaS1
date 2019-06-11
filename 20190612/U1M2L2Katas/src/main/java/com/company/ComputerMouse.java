package com.company;

public class ComputerMouse {

    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation;

    public ComputerMouse(String manufacturer, String model, int xPosition, int yPosition, int[] lastClickedLocation) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.lastClickedLocation = lastClickedLocation;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int[] getLastClickedLocation() {
        return lastClickedLocation;
    }

    public void move(int deltaX, int deltaY){
        this.xPosition = deltaX;
        this.yPosition = deltaY;
    }

    public void click(int[] i){
        lastClickedLocation = i;
    }
}
