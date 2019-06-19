package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FindingAValueInAnArrayList {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int userInput;
        List<Integer> list = new ArrayList<>();
        Random rand = new Random();

        for(int i = 0; i < 10; i++){
            list.add(i, rand.nextInt(50)+1);
        }

        System.out.println(list);
        System.out.print("Value to find: ");
        userInput = myScanner.nextInt();

        for (Integer number: list){
            if (userInput == number){
                System.out.println(number + " is in the ArrayList.");
            }
        }

    }
}
