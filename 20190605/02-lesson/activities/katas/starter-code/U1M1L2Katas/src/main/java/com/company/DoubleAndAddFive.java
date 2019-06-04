package com.company;

import java.util.Scanner;

public class DoubleAndAddFive {

    public static void main(String[] args) {

        int num = 0;
        int sum = 0;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a number");
        num = myScanner.nextInt();

        sum = (num * 2) +5;

        System.out.println(sum);

    }
}
