package com.company;

import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        int userInput;

        int[] userArray = new int[5];

        for (int i = 0; i < userArray.length; i++) { //gets user input and adds it to userArray
            System.out.println("Please enter an integer");
            userInput = myScanner.nextInt();

            userArray[i] = userInput;
        }

        for (int numbers : userArray) { //outputs array elements
            System.out.println(numbers);
        }
    }
}
