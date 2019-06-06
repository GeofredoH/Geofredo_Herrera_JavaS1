package com.company;

import java.util.Scanner;
import java.util.Random;

public class HiLo {
    public static void main(String[] args) {

        Random r = new Random(); //New random object to choose a random number
        int number = 0; //Will hold the value returned by the Random object
        String name = "";
        int attempts = 1; //counter to keep track of guesses

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Welcome to Hi-Low!");

        System.out.println("Please enter your name");
        name = myScanner.nextLine();

        System.out.println("OK, " + name + ", here are the rules:");

        System.out.println(" 1. The computer will come up with a number between 1 and 100 (inclusive).\n" +
                " 2. The user will be prompted to guess the number.\n" +
                " 3. If the user guesses the number correctly, the program displays:\n" +
                "     1. Congratulations, [name of user]! You win!”\n" +
                "     2. It took you [number of guesses] guesses to find my number!\"\n" +
                "4. If the user does not guess the number correctly, the program will display “Too low!”\n" +
                "   if the guess is too low and “Too high!” if the guess is too high, and then will prompt the user for another guess.  \n" +
                "   This goes on until the number is guessed correctly.");

        number = r.nextInt((100 - 1) + 1); //number is assigned a random number according to the Random object's min and max value

        System.out.println("Guess the number between 1 and 100 (inclusive)");
        int userGuess = myScanner.nextInt(); //to hold user input

        //loop to assess user guess
        while (userGuess != number) {
            if (userGuess > number) {
                System.out.println("Too high!");
            } else {
                System.out.println("Too low!");
            }

            System.out.println("Please enter another guess");
            userGuess = myScanner.nextInt();

            attempts++;
        }

        System.out.println("Congratulations, " + name + "! You win!");
        System.out.println("It took you " + attempts + " guesses to find my number!");
    }
}

