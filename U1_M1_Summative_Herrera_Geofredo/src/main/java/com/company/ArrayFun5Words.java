package com.company;

import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        String userWord;

        String[] wordArray = new String[5];

        for (int i = 0; i < wordArray.length; i++) { //gets user input and adds to array
            System.out.println("Please enter a word");
            userWord = myScanner.nextLine();

            wordArray[i] = userWord;
        }

        for (String printWords : wordArray) { //outputs array elements
            System.out.println(printWords);
        }
    }
}
