package com.company;

public class Warrior extends Player{   //inherits Player methods

    private int shieldStrength = 100;

    //constructor calls superclass constructor with super keyword
    public Warrior(String name, int shieldStrength){
        super(name, 75, 100, 50, 10, 100);
        this.shieldStrength = shieldStrength;
    }

    public void decreaseShieldStrength() {
        this.shieldStrength--;
    }
}
