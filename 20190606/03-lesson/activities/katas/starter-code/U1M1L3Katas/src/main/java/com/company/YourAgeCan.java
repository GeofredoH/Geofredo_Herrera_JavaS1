package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int age;

        System.out.println("Please enter your age");
        age = myScanner.nextInt();

        //conditional statements to check age and output elgibilities
        if (age >= 18 && age <= 20) {
            System.out.println("Vote");
        } else if (age >= 21 && age <= 34) {
            System.out.println("Drink alcohol");
            System.out.println("Vote");

        } else if (age >= 35 && age <= 54) {
            System.out.println("Be president");
            System.out.println("Drink alcohol");
            System.out.println("Vote");
        } else if (age >= 55 && age <= 64) {
            System.out.println("Is elgible for AARP");
            System.out.println("Be president");
            System.out.println("Drink alcohol");
            System.out.println("Vote");
        } else if (age >= 65 && age <= 79) {
            System.out.println("Can retire");
            System.out.println("Is elgible for AARP");
            System.out.println("Be president");
            System.out.println("Drink alcohol");
            System.out.println("Vote");
        } else if (age >= 80 && age <= 89) {
            System.out.println("Is an octogenerian");
            System.out.println("Can retire");
            System.out.println("Is elgible for AARP");
            System.out.println("Be president");
            System.out.println("Drink alcohol");
            System.out.println("Vote");
        } else if (age >= 90) {
            System.out.println("Is more than a century old");
            System.out.println("Is an octogenerian");
            System.out.println("Can retire");
            System.out.println("Is elgible for AARP");
            System.out.println("Be president");
            System.out.println("Drink alcohol");
            System.out.println("Vote");
        }else{
        }
    }
}
