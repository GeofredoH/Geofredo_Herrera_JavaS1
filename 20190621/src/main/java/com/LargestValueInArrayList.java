package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LargestValueInArrayList {
    public static void main(String[] args) {
        Random rand = new Random();

        List<Integer> numList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numList.add(rand.nextInt(100) + 1);
        }

        System.out.println("ArrayList: " + numList);

        int max = 0;

        for (Integer num : numList) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("The largest value is " + max);
    }
}
