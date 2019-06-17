package com.company;

import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        int userNumber;

        int a = 3;
        int b = 3;
        int c = 3;
        boolean stillAvailable = true;

        while(stillAvailable){

            if (a < 1 && b < 1 && c < 1){ //Checks if piles are empty
                stillAvailable = false;
                break;
            }else {
                stillAvailable = true;;
            }

            System.out.println("\na: " + a + "\tb: " + b + "\tc: " + c +"\n");
            System.out.print("Choose a pile: ");
            userInput = myScanner.nextLine();

            System.out.print("How many to remove from pile " + userInput + " ");
            userNumber = myScanner.nextInt();
            myScanner.nextLine();

            //decrements counters according to user selection
            if (userInput.equals("a")){
                a -= userNumber;
            }else if (userInput.equals("b")){
                b -= userNumber;
            }else if (userInput.equals("c")){
                c -= userNumber;
            }else {
                System.out.println("");
            }

        }
        System.out.println("\na: " + a + "\tb: " + b + "\tc: " + c +"\n");
        System.out.println("\nAll piles are empty. Good Job!");

    }
}
