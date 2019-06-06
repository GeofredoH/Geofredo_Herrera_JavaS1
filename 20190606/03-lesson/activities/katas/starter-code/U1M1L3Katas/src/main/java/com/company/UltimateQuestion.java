package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int number;
        boolean correctAnswer = false;

        //loop that keeps asking until the user enters the correct answer
        while(!correctAnswer){
            System.out.println("Enter a number between 1 and 100");
            number = myScanner.nextInt();

            if (number == 42){ //conditional that checks if the users answer entered 42
                correctAnswer = true;
            }
        }

        System.out.println("That's the number I was looking for! 42 is definitely the answer!");

    }
}
