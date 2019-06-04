package com.company;

import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        double player1 = 0;
        double player2 = 0;
        double player3 = 0;
        double totalSalary = 0;

        System.out.println("Enter the salary for player 1");
        player1 = myScanner.nextDouble();

        System.out.println("Enter the salary for player 2");
        player2 = myScanner.nextDouble();

        System.out.println("Enter the salary for player 3");
        player3 = myScanner.nextDouble();

        totalSalary = player1 + player2 + player3;

        System.out.format("The total salary for all three players is $%.2f ", totalSalary);

        if(totalSalary > 40000000)
        {
            double tax = (totalSalary - 40000000) * .18;

            System.out.format("The luxury tax is $%.2f", tax);
        }



    }
}
