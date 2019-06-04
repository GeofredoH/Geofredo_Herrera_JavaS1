package com.company;

import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {

        int num1 = 0;
        int sum = 0;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a number");
        num1 = myScanner.nextInt();

        sum = num1 + 13;

        System.out.println(sum);


    }
}
