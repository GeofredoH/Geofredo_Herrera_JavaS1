package com.company;

import java.util.Scanner;

public class ConverterApplication {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int userMonth;
        int userDay;

        System.out.print("Enter a number from 1 to 12 (inclusive) to select a month: ");  //asks for user to input from 1 - 12, for month
        userMonth = myScanner.nextInt();

        System.out.print("Enter a number from 1 to 7 (inclusive) to select a day of the week: ");   //asks for user input from 1 - 7 for day
        userDay = myScanner.nextInt();

        ConverterIf conIf = new ConverterIf();              //instantializing ConverterIf and ConverterSwitch objects
        ConverterSwitch conSwitch = new ConverterSwitch();

        System.out.println("\nUsing the ConverterIf implementation, your month is " + conIf.convertMonth(userMonth) +
                " and your day is " + conIf.convertDay(userDay));
        System.out.println("==============================================================================================");
        System.out.println("Using the ConverterSwitch implementation, your month is " + conSwitch.convertMonth(userMonth) +
                " and your day is " + conSwitch.convertDay(userDay));

    }

}
