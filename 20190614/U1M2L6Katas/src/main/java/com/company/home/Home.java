package com.company.home;

public class Home {
    private String color;
    private int floors;
    private int bedRooms;
    private Basement basement;
    private Bathroom bathRoom;
    private Kitchen kitchen;
    private boolean openOrClose;

    public Home(String color, int floors, int bedRooms) {
        this.color = color;
        this.floors = floors;
        this.bedRooms = bedRooms;
    }

    public Home(){
        this.color = "";
        this.floors = 0;
        this.bedRooms = 0;
    }

    public void lockOut(boolean lockedOrNot){
        if(lockedOrNot){
            openOrClose = true;
        } else {
            openOrClose = false;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getBedRooms() {
        return bedRooms;
    }

    public void setBedRooms(int bedRooms) {
        this.bedRooms = bedRooms;
    }

    public Basement getBasement() {
        return basement;
    }

    public void setBasement(Basement basement) {
        this.basement = basement;
    }

    public Bathroom getBathRoom() {
        return bathRoom;
    }

    public void setBathRoom(Bathroom bathRoom) {
        this.bathRoom = bathRoom;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }
}
