package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int number;

        System.out.println("Enter an integer to see if it is even or odd");
        number = myScanner.nextInt();

        if (number % 2 == 0) { //checks if the number is even
            System.out.println("even");
        }
        else{
            System.out.println("odd");
        }

    }
}
