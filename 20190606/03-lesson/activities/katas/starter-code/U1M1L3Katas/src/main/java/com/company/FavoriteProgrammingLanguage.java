package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String language;
        boolean correctAnswer = false;

        //loop that keeps asking until the user enters the correct answer
        while(!correctAnswer){
            System.out.println("What is your favorite programming language?");
            language = myScanner.nextLine();

            if (language.equals("Java")){ //conditional that checks if the users answer is "Java"
                correctAnswer = true;
            }
        }

        System.out.println("That's what I was looking for! Java is definitely the answer!");

    }
}
