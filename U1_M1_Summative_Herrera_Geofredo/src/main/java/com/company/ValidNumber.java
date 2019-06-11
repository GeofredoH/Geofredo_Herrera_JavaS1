package com.company;

import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int userInput;

        System.out.println("Please enter a number between 1 and 10 (inclusive)");
        userInput = myScanner.nextInt();

        //validates user input
        while (userInput < 1 || userInput > 10) {
            System.out.println("You must enter a number between 1 and 10, please try again.");
            userInput = myScanner.nextInt();
        }

        System.out.println(userInput);
    }
}
