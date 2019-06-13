package com.company.interfaces;

import java.util.Scanner;

public class Input implements UserIO{

    Scanner myScanner = new Scanner(System.in);

    public int readInt(String message){
        int userInput;
        System.out.println(message);
        userInput = myScanner.nextInt();
        return userInput;
    }

    public long readLong(String message){
        long userInput;
        System.out.println(message);
        userInput = myScanner.nextLong();
        return userInput;
    }

    public double readDouble(String message){
        double userInput;
        System.out.println(message);
        userInput = myScanner.nextDouble();
        return userInput;
    }

    public float readFloat(String message){
        float userInput;
        System.out.println(message);
        userInput = myScanner.nextFloat();
        return userInput;
    }

    public String readString(String message){
        String userInput;
        myScanner.nextLine();
        System.out.println(message);
        userInput = myScanner.nextLine();
        return userInput;
    }
}
