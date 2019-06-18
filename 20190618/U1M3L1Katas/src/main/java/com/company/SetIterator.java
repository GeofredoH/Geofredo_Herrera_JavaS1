package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator {
    public void printSet(int a, int b, int c, int d, int e) {
        Set<Integer> newSet = new HashSet<>();
        newSet.add(a);
        newSet.add(b);
        newSet.add(c);
        newSet.add(d);
        newSet.add(e);

        Iterator<Integer> iter = newSet.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }
}
