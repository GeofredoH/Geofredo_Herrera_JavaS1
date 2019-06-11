package com.company;

import java.util.Scanner;

public class SpaceBoxing {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        double earthWeight;
        double spaceWeight = 0;
        int userInput;

        System.out.print("Please enter your current earth weight: ");
        earthWeight = myScanner.nextDouble();

        System.out.print("\nI have information for the following planets:\n" +
                "   1. Venus   2. Mars     3. Jupiter\n" +
                "   4. Saturn  5. Uranus   6. Neptune\n");

        System.out.print("\nWhich planet are you visiting? ");
        userInput = myScanner.nextInt();

        //finds planet and calculates weight
        if (userInput == 1) {
            spaceWeight = earthWeight * .78;
        } else if (userInput == 2) {
            spaceWeight = earthWeight * .39;
        } else if (userInput == 3) {
            spaceWeight = earthWeight * 2.65;
        } else if (userInput == 4) {
            spaceWeight = earthWeight * 1.17;
        } else if (userInput == 5) {
            spaceWeight = earthWeight * 1.05;
        } else if (userInput == 6) {
            spaceWeight = earthWeight * 1.23;
        } else{
            System.exit(0);
        }



        System.out.println("\nYour weight would be " + spaceWeight + " pounds on that planet.");

    }
}
