package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CopyingArrayLists {
    public static void main(String[] args) {
        Random rand = new Random();

        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            newList.add(rand.nextInt(100)+1);
        }

        List<Integer> newList2 = new ArrayList<>();
        newList2.addAll(newList);

        newList.set(newList.size()-1, -7);

        System.out.println(newList);
        System.out.println(newList2);

    }
}
