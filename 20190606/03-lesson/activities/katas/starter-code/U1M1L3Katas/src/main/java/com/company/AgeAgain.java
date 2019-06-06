package com.company;

import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {

        int age = 0;

        Scanner myScanner = new Scanner(System.in);

        System.out.println("What is your age?");
        age = myScanner.nextInt();

        //begin conditional statements to determine what questions to ask
        if (age < 14) {

            String grade;

            myScanner.nextLine(); //to consume line
            System.out.println("What grade are you in?");
            grade = myScanner.nextLine();

            System.out.println("Wow! " + grade + " grade - that sounds exciting!");
        } else if (age >= 14 && age <= 18) {
            String answer;

            myScanner.nextLine(); //to consume line
            System.out.println("Are you planning to go to college? (yes or no)");
            answer = myScanner.nextLine();

            //if else statement nested within another if else if statement
            if (answer.equals("yes")) {
                String college;

                System.out.println("What college?");
                college = myScanner.nextLine();

                System.out.println(college + " is a great school!");
            } else {
                String plans;

                System.out.println("What do you want to do after high school?");
                plans = myScanner.nextLine();

                System.out.println("Wow, " + plans + " sounds like a plan!");
            }
        } else {
            String job;

            myScanner.nextLine(); //to consume line
            System.out.println("What is your job?");
            job = myScanner.nextLine();

            System.out.println(job + " sounds like a great job!");
        }

    }
}
