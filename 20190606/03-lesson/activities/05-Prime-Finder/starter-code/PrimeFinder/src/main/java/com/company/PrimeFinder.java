package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {

        int primeTracker = 0; //tracks the amount of times a number is divisible by another number
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter a number: ");
        int number = myScanner.nextInt();

        //loop to take the user input and check if each number is prime up to the input number
        for (int i = 2; i <= number; i++) {
            for (int e = 2; e <= number; e++) {
                if (i % e == 0) {
                    primeTracker++;
                }
            }

            if (primeTracker < 2) { //conditional statement to evaluate if a number is prime and output its value
                System.out.println(i + "\r");
            }
            primeTracker = 0; //resets primeTracker to 0 to evaluate another number

        }


    }
}
