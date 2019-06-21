package com.company;

public class Farmer extends Player {    //inherits Player methods

    //constructor calls superclass constructor with super keyword
    public Farmer(String name){
        super(name, 75, 75, 10, 1, 100);
    }
    public void plow(){
        System.out.println("Time to Plow!");
    }

    public void harvest(){
        System.out.println("Time to Harvest!");
    }
}
