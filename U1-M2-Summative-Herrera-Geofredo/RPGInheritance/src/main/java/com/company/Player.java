package com.company;

public class Player {        //superclass, extended by Farmer, Constable, and Warrior
    private String name;
    private int strength;
    private int stamina;
    private int speed;
    private int attackPower;
    private int health;

    public Player(String name, int strength, int stamina, int speed, int attackPower, int health) {  //constructor
        this.name = name;
        this.strength = strength;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
        this.health = health;
    }

    public Player() {        //default constructor
        this.name = "";
        this.strength = 0;
        this.stamina = 0;
        this.speed = 0;
        this.attackPower = 0;
        this.health = 0;
    }

    public void heal(){
        System.out.println("I'm starting to feel better!");
        health++;
    }

    public void run(){
        System.out.println("RUN!");
        decreaseStamina();
    }

    public void decreaseHealth(int decrease){
        health -= decrease;
        System.out.println("Ouch!");
    }

    public int attack(){
        System.out.println("HYAAAA!");
        return attackPower;
    }

    public void increaseStamina(){
        stamina++;
    }

    public void decreaseStamina(){
        stamina--;
    }

    public String getName() {     //getters and setters
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
