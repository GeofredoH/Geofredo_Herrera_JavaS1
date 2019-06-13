package com.company.interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BetterInput implements UserIO {

    Scanner myScanner = new Scanner(System.in);

    public int readInt(String message) {
        try {
            int userInput;
            System.out.println(message);
            userInput = myScanner.nextInt();
            return userInput;

        } catch (InputMismatchException ex) {
            System.out.println("Incorrect input try again.");
            myScanner.next();
            return readInt("Enter an integer");
        }
    }

    public long readLong(String message) {
        try {
            long userInput;
            System.out.println(message);
            userInput = myScanner.nextLong();
            return userInput;

        } catch (InputMismatchException ex) {
            System.out.println("Incorrect input try again.");
            myScanner.next();
            return readLong("Enter a long");
        }
    }

    public double readDouble(String message) {
        try {
            double userInput;
            System.out.println(message);
            userInput = myScanner.nextDouble();
            return userInput;

        } catch (InputMismatchException ex) {
            System.out.println("Incorrect input try again.");
            myScanner.next();
            return readDouble("Enter a double");
        }
    }

    public float readFloat(String message) {
        try {
            float userInput;
            System.out.println(message);
            userInput = myScanner.nextFloat();
            return userInput;

        } catch (InputMismatchException ex) {
            System.out.println("Incorrect input try again.");
            myScanner.next();
            return readFloat("Enter a float");
        }
    }

    public String readString(String message) {
        try {
            String userInput;
            myScanner.nextLine();
            System.out.println(message);
            userInput = myScanner.nextLine();
            return userInput;

        } catch (InputMismatchException ex) {
            System.out.println("Incorrect input type try again.");
            myScanner.next();
            return readString("Enter a string");
        }
    }
}