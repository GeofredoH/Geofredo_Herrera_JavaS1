package com.company;

public class Constable extends Player{   //inherits Player methods

    private String jurisdiction;

    //constructor calls superclass constructor with super keyword
    public Constable(String name, String jurisdiction){
        super(name, 60, 60, 20, 5, 100);
        this.jurisdiction = jurisdiction;
    }

    public void arrest(){
        System.out.println("YOU ARE UNDER ARREST!");
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }
}
