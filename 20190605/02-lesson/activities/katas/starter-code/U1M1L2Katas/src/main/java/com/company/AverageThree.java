package com.company;

import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {

        double num1 = 0.00;
        double num2 = 0.00;
        double num3 = 0.00;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter 3 numbers");
        System.out.println("The first number is: ");
        num1 = myScanner.nextDouble();

        System.out.println("The second number is: ");
        num2 = myScanner.nextDouble();

        System.out.println("The third number is: ");
        num3 = myScanner.nextDouble();

        double sum = (num1 + num2 + num3) / 3;

        System.out.format("The average is %.2f", sum);
    }
}
