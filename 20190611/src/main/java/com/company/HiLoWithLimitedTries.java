package com.company;

import java.util.Random;
import java.util.Scanner;

public class HiLoWithLimitedTries {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int guessesRemaining = 2;

        Random rand1 = new Random();
        int secretNumber = rand1.nextInt((100 - 1) + 1) + 1;

        System.out.println("I'm thinking of a number from 1-100.  You have 7 guesses.");
        System.out.print("First Guess: ");
        int userGuess = myScanner.nextInt();

        if (userGuess == secretNumber){ //initial check
            System.out.println("You guessed it! What are the odds?!?");
        }else {
            while (userGuess != secretNumber && guessesRemaining < 8){ //keeps getting guesses
                if (userGuess > secretNumber) {
                    System.out.println("Sorry, you are too high.");
                } else {
                   System.out.println("Sorry, you are too low.");
                }

                System.out.print("Guess # " + guessesRemaining + " ");
                userGuess = myScanner.nextInt();
                guessesRemaining++;
            }

            if (userGuess == secretNumber){ //final check
                System.out.println("You guessed it! What are the odds?!?");
            }
            else if (guessesRemaining > 7){
                System.out.println("Sorry, you didn't guess it in " + 7 + " tries.  You lose.");
            }else {
                System.out.println("You guessed it! What are the odds?!?");
            }
        }
    }
}