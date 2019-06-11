package com.company;

import java.util.Random;

public class Dice {
    public static void main(String[] args) {

        Random rand1 = new Random();
        int die1 = rand1.nextInt((6-1)+1)+1; //die 1 random
        int die2 = rand1.nextInt((6-1)+1)+1; //die 2 random

        System.out.println("HERE COMES THE DICE!\n");
        System.out.println("Roll #1: " + die1);
        System.out.println("Roll #2: " + die2);
        System.out.println("The total is " + (die1 + die2) + "!");
    }
}
