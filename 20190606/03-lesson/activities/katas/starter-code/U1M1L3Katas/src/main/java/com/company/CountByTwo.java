package com.company;

import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int number;

        System.out.println("Please enter a number");
        number = myScanner.nextInt();

        //loop for counting by two until user input number is reached
        for (int i = 0; i <= number; i = i + 2){
            System.out.println(i + "\r");
        }

    }
}
