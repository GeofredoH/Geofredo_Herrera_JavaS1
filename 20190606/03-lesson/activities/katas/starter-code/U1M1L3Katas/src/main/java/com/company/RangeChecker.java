package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int number = 0;

        boolean guess = true;

        //loop to check user input number range
        while (guess == true) {
            System.out.println("Please enter a number between 15 and 32 (not inclusive)");
            number = myScanner.nextInt();

            if (number < 16) {
                guess = true;
            } else if (number > 31) {
                guess = true;
            }else {
                guess = false;
                System.out.println(number);
            }
        }

    }
}
