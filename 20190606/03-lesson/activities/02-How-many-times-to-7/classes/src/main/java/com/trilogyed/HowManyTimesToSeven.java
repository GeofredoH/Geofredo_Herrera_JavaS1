package com.trilogyed;

import java.util.Random;

public class HowManyTimesToSeven {
    public static void main(String[] args) {
        Random die = new Random();
        int die1;
        int die2;
        int sum;
        int tracker = 0;
        boolean isFirstTime = false;
        int firstSeven = 0;

        //loop to roll each die 100 times
        for (int i = 1; i <= 100; i++) {
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

        System.out.println(tracker + " times out of 100 we rolled a 7");

    }
}
