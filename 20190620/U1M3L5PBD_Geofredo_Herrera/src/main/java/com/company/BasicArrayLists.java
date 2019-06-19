package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasicArrayLists {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();

        numList.add(-113);
        numList.add(-113);
        numList.add(-113);
        numList.add(-113);
        numList.add(-113);
        numList.add(-113);
        numList.add(-113);
        numList.add(-113);
        numList.add(-113);
        numList.add(-113);

        System.out.println("Slot 0: " + numList.get(0));
        System.out.println("Slot 1: " + numList.get(1));
        System.out.println("Slot 2: " + numList.get(2));
        System.out.println("Slot 3: " + numList.get(3));
        System.out.println("Slot 4: " + numList.get(4));
        System.out.println("Slot 5: " + numList.get(5));
        System.out.println("Slot 6: " + numList.get(6));
        System.out.println("Slot 7: " + numList.get(7));
        System.out.println("Slot 8: " + numList.get(8));
        System.out.println("Slot 9: " + numList.get(9));

//        numList.stream().forEach(System.out.println("Slot "));

//        int counter = 0;
//        Iterator<Integer> iter = numList.iterator();
//
//        while(iter.hasNext()){
//            System.out.println("Slot " + counter + ": " + iter.next());
//            counter++;
//        }
    }



}
