package com.company;

import java.util.Scanner;

public class AddFiveAndDouble {

    public static void main(String[] args) {

        int num1 = 0;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a number");

        num1 = myScanner.nextInt();

        int answer = (num1 + 5) * 2;
        System.out.println(answer);
    }
}
