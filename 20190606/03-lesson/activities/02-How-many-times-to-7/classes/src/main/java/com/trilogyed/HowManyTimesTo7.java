package com.trilogyed;

import java.util.Random;
import java.util.Scanner;

public class HowManyTimesTo7 {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int rolls;
        Random die = new Random();
        int die1;
        int die2;
        int sum;
        int tracker = 0;
        boolean isFirstTime = false;
        int firstSeven = 0;

        System.out.println("Enter the number of times to roll the dice!");
        rolls = myScanner.nextInt();

        //loop to roll each die amount of times user inputs
        for (int i = 1; i <= rolls; i++) {
            die1 = die.nextInt(6) + 1;
            die2 = die.nextInt(6) + 1;

            System.out.println("Roll " + i + " Die 1 = " + die1 + " Die 2 = " + die2 + " Total = " + (die1 + die2));
            sum = die1 + die2;

            if (sum == 7) { //to track the amount of times the dice add up to 7
                tracker++;

                if (!isFirstTime) {//conditional statement to find the first seven rolled
                    firstSeven = i;
                    isFirstTime = true;
                }
            }

        }

        System.out.println("It took " + firstSeven + " rolls to roll the first 7");

        System.out.println(tracker + " times out of " + rolls + " we rolled a 7");

    }
}