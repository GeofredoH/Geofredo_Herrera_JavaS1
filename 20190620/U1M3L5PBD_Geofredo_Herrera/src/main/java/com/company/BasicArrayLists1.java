package com.company;

import java.util.ArrayList;
import java.util.List;

public class BasicArrayLists1 {
    public static void main(String[] args) {
        List<Integer> numList= new ArrayList<>();


//        for(Integer i: numList){
//            numList.add(i,-113);
//            i++;
//        }
        for(int i = 0; i < 10; i++){
            numList.add(-113);
        }

        for(int e = 0; e < numList.size(); e++){
            System.out.println("Slot " + e + ": " + numList.get(e));
        }
    }
}
