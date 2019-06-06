package com.company;

public class FizzBuzz {
    public static void main(String[] args) {

        int number = 1;

        //loop to iterate through numbers up to 100 and to find multiples of 3 and 5
        for (int i = 1; i <= 100; i++) {

            if (number % 3 == 0 && number % 5 == 0) { //checks for multiples
                System.out.println("FIZZBUZZ");
            } else if (number % 3 == 0) {
                System.out.println("FIZZ");
            } else if (number % 5 == 0) {
                System.out.println("BUZZ");
            } else {
                System.out.println(number);
            }
            number++;
        }

    }
}
