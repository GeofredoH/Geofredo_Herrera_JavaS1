package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("How much is the mortgage amount?");
        double mortgage = myScanner.nextDouble();

        System.out.println("What is the loan term in months?");
        double term = myScanner.nextDouble();

        System.out.println("What is the interest (APR without % symbol) rate?");
        double rate = myScanner.nextDouble();

        rate = rate / 1200; //APR divided by term and converted to decimal form

        double numerator = mortgage * (rate * (Math.pow(rate + 1, term))); //Calculated monthly payment in 2 variables to avoid confusion (numerator)
        double denominator = (Math.pow(rate + 1, term)) - 1; //Calculated monthly payment in 2 variables to avoid confusion (denominator)

        double monthlyPay = numerator / denominator; //monthly payment calculation

        System.out.println("Your monthly payment is " + monthlyPay);

    }
}
