package com.company;

import java.util.Scanner;

public class SubtractTwo {

    public static void main(String[] args) {

        int num1 = 0;
        int num2 =0;
        int sum = 0;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter two numbers");
        num1 = myScanner.nextInt();
        num2 = myScanner.nextInt();

        sum = num1 - num2;

        System.out.println(sum);

    }
}
