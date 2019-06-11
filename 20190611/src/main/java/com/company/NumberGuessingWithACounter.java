package com.company;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithACounter {
    public static void main(String[] args) {

        int counter = 1;

        Scanner myScanner = new Scanner(System.in);
        int userInput;

        Random newRandom = new Random();
        int secretNumber = newRandom.nextInt((10-1) + 1)+1; //gets random number

        System.out.println("I'm thinking of a number from 1 to 10");
        System.out.print("Your guess: ");
        userInput = myScanner.nextInt();

        //get user guesses
        if (userInput != secretNumber) {
            while (userInput != secretNumber) {
                System.out.println("That is incorrect. Guess again.");
                System.out.print("Your guess: ");
                userInput = myScanner.nextInt();

                counter++;
            }
            System.out.println("\nThat's right! You're a good guesser.");
            System.out.println("It only took you " + counter + " tries.");
        } else{
            System.out.println("\nThat's right! You're a good guesser.");
            System.out.println("It only took you " + counter + " tries.");

        }
    }
}