package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BasicArrayLists2 {
    public static void main(String[] args) {
        Random rand = new Random();

        List<Integer> newList = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            newList.add(rand.nextInt(10)+1);
        }

        System.out.println( "ArrayList: " + newList );
    }
}
