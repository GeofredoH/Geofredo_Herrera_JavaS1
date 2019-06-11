package com.company;

        import java.util.Random;
        import java.util.Scanner;

public class ANumberGuessingGame {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int userInput;

        Random newRandom = new Random();
        int secretNumber = newRandom.nextInt((10-1) + 1)+1; //gets random number

        System.out.println("I'm thinking of a number from 1 to 10");
        System.out.print("Your guess: ");
        userInput = myScanner.nextInt();

        if (userInput == secretNumber){
            System.out.println("\nThat's right! My secret number was " + secretNumber);
        }else{
            System.out.println("\nSorry, but I was really thinking of " + secretNumber);
        }


    }
}
