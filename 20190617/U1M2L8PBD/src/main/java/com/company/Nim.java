package com.company;

import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String userInput;
        int userNumber;

        String player1;
        String player2;

        System.out.print("Player 1, enter your name: ");
        player1 = myScanner.nextLine();

        System.out.print("Player 2, enter your name: ");
        player2 = myScanner.nextLine();

        int a = 3;
        int b = 4;
        int c = 5;
        boolean stillAvailable = true;

        while(stillAvailable){

            if (a < 1 && b < 1 && c < 1){ //Checks if piles are empty before prompting player1
                stillAvailable = false;
                System.out.println("\na: " + a + "\tb: " + b + "\tc: " + c +"\n");
                System.out.println(player1 + ", there are no counters left, so YOU WIN! ");
                break;
            }else {
                stillAvailable = true;
            }

            System.out.println("\na: " + a + "\tb: " + b + "\tc: " + c +"\n");
            System.out.print("\n" + player1 + ", choose a pile: ");
            userInput = myScanner.nextLine();

            System.out.print("How many to remove from pile " + userInput + " ");
            userNumber = myScanner.nextInt();
            myScanner.nextLine();

            //decrements counters according to player1 selection
            if (userInput.equals("a")){
                a -= userNumber;
            }else if (userInput.equals("b")){
                b -= userNumber;
            }else if (userInput.equals("c")){
                c -= userNumber;
            }else {
                System.out.println("");
            }

            if (a < 1 && b < 1 && c < 1){ //Checks if piles are empty, if not players2's turn
                stillAvailable = false;
                System.out.println("\na: " + a + "\tb: " + b + "\tc: " + c +"\n");
                System.out.println(player2 + ", there are no counters left, so YOU WIN! ");
                break;
            }else {
                stillAvailable = true;
            }

            System.out.println("\na: " + a + "\tb: " + b + "\tc: " + c +"\n");
            System.out.print("\n" + player2 + ", choose a pile: ");
            userInput = myScanner.nextLine();

            System.out.print("How many to remove from pile " + userInput + " ");
            userNumber = myScanner.nextInt();
            myScanner.nextLine();

            //decrements counters according to player2 selection
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
//        System.out.println("\na: " + a + "\tb: " + b + "\tc: " + c +"\n");
//        System.out.println("\nAll piles are empty. Good Job!");

    }
}
