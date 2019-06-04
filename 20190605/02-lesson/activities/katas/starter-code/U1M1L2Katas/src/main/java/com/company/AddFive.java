package com.company;

import java.util.Scanner;

public class AddFive {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter 5 numbers");

        int num1 = myScanner.nextInt();
        int num2 = myScanner.nextInt();
        int num3 = myScanner.nextInt();
        int num4 = myScanner.nextInt();
        int num5 = myScanner.nextInt();
        int sum = num1 + num2 + num3 + num4 + num5;
        System.out.println(sum);
    }
}