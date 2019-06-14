package com.company.home;

import java.sql.SQLOutput;

public class Kitchen {
    private int pans;
    private int pots;
    private boolean food;
    private boolean equipped;
    private int area;

    public Kitchen(int pans, int pots, boolean food, boolean equipped, int area) {
        this.pans = pans;
        this.pots = pots;
        this.food = food;
        this.equipped = equipped;
        this.area = area;
    }

    public void addToFridge(int items){
        System.out.println("Ok, I'll " + items + " items to the fridge.");
    }

    public String cookFood(boolean cook){

            if(cook){
               return ("Your food is cooking.");
            } else {
               return ("Ok I won't cook then.");
            }
    }

    public int getPans() {
        return pans;
    }

    public void setPans(int pans) {
        this.pans = pans;
    }

    public int getPots() {
        return pots;
    }

    public void setPots(int pots) {
        this.pots = pots;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
