package com.company;

import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int number;

        System.out.println("Please enter a number");
        number = myScanner.nextInt();

        //loop for counting by thirteen until user input number is reached
        for (int i = 0; i <= number; i = i + 13){
            System.out.println(i + "\r");
        }

    }
}