package com.company;

import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {

        byte correct = 0; //count correct answers

        Scanner myScanner = new Scanner(System.in);
        String userInput;
        byte userSelection;

        System.out.print("Are you ready for a quiz? ");
        userInput = myScanner.nextLine();

        System.out.println("Okay, here it comes!\n");
        System.out.println("Q1) The first email from space was sent using the Macintosh Portable.\n" //question 1
                + "             1) True\n"
                + "             2) False\n");
        userSelection = myScanner.nextByte();

        //correct and wrong answer messages
        if (userSelection == 1) {
            System.out.println("That's right!\n");
            correct++;
        } else {
            System.out.println("Sorry, it's true.\n");
        }

        System.out.println("Q2 What year was Apple founded?\n"
                + "             1) 1972\n"
                + "             2) 1968\n"
                + "             3) 1976\n");
        userSelection = myScanner.nextByte();

        //correct and wrong answer messages
        if (userSelection == 3) {
            System.out.println("That's correct; on April 1, 1976 Apple was founded in Cupertino CA.\n"); //question 2
            correct++;
        } else {
            System.out.println("Sorry, it was actually founded in 1976.\n");
        }


        System.out.println("Q3) What was the last version of Windows that was based on MS-DOS?\n" //question 3
                + "             1) Windows 98\n"
                + "             2) Windows 95\n"
                + "             3) Windows NT 3.1\n");
        userSelection = myScanner.nextByte();

        //correct and wrong answer messages
        if (userSelection == 1) {
            System.out.println("Absolutely! Windows 98 was also designed specifically for consumers.\n");
            correct++;
        } else {
            System.out.println("Nope, It's Windows 98.\n");
        }

        System.out.println("Overall, you got " + correct + " out of 3 correct" //displays outcome
                + "\nThanks for playing!");

    }
}
