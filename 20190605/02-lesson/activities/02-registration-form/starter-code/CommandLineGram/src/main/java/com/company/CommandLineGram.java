package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter your first name");
        String fName = myScanner.nextLine();

        System.out.println("Enter your last name");
        String lName = myScanner.nextLine();

        System.out.println("Enter your email address");
        String email = myScanner.nextLine();

        System.out.println("Enter your Twitter handle");
        String twitter = myScanner.nextLine();

        System.out.println("Enter your age");
        int age = myScanner.nextInt();

        myScanner.nextLine();

        System.out.println("Enter your country");
        String country = myScanner.nextLine();

        System.out.println("Enter your profession");
        String profession = myScanner.nextLine();

        System.out.println("Enter your favorite operating system");
        String os = myScanner.nextLine();

        System.out.println("Enter your favorite programming language");
        String progLanguage = myScanner.nextLine();

        System.out.println("Enter your favorite computer scientist");
        String scientist = myScanner.nextLine();

        System.out.println("Enter your favorite keyboard shortcut");
        String shortCut = myScanner.nextLine();

        System.out.println("Have you ever built your own computer?");
        String builtAComputer = myScanner.nextLine();

        System.out.println("If you could be any superhero, who would it be?");
        String hero = myScanner.nextLine();


        System.out.println(fName + "\n" + lName + "\n" + email + "\n" + twitter + "\n" + age + "\n" + country + "\n" + profession + "\n" + os + "\n" + progLanguage + "\n" +
                            scientist + "\n" + shortCut + "\n" + builtAComputer + "\n" + hero +"\n");


    }
}
