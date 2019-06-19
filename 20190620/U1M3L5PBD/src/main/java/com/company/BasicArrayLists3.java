package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists3 {
    public static void main(String[] args) {
        Random rand = new Random();

        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < 1000; i++){
            newList.add(rand.nextInt(89)+10);
        }

        System.out.println(newList);
    }
}
