package com.company;

import java.util.Scanner;

public class MultiplyThree {

    public static void main(String[] args) {

        double num1 = 0;
        double num2 = 0;
        double num3 = 0;
        double sum = 0;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter three numbers");
        num1 = myScanner.nextDouble();
        num2 = myScanner.nextDouble();
        num3 = myScanner.nextDouble();

        sum = num1 * num2 * num3;

        System.out.println(sum);

    }
}