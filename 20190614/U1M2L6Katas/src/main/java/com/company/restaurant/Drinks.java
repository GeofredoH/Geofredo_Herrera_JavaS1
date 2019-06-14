package com.company.restaurant;

public class Drinks {
    private String name;
    private int ounces;
    private boolean frozen;
    private boolean alcohol;

    public Drinks(String name, int ounces, boolean frozen, boolean alcohol) {
        this.name = name;
        this.ounces = ounces;
        this.frozen = frozen;
        this.alcohol = alcohol;
    }

    public void mix(String drink1, String drink2) {
        System.out.println("Ok, I will now mix " + drink1 + " and " + drink2);
    }

    public void expire() {
        System.out.println("This is expired now");
    }

    public void melt() {
        this.frozen = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOunces() {
        return ounces;
    }

    public void setOunces(int ounces) {
        this.ounces = ounces;
    }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean isAlcohol() {
        return alcohol;
    }

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }
}
