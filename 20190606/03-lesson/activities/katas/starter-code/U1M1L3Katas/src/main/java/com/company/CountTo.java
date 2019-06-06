package com.company;

import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int number;

        System.out.println("Please enter a number");
        number = myScanner.nextInt();

        //loop to count to user input number and output the count
        for (int i = 0; i <= number; i++){
            System.out.println(i + "\r");
        }

    }
}
