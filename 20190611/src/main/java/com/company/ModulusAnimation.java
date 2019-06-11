package com.company;

public class ModulusAnimation {
    public static void main(String[] args) throws Exception {

        int repeat = 10; //loop iterations

        for (int i = 10; i < 10 * repeat; i++) {
            if (i % 10 == 0) {
                System.out.println("|<0>....|");
            } else if (i % 10 == 1) {
                System.out.println("|.<0>...|");
            } else if (i % 10 == 2) {
                System.out.println("|..<0>..|");
            } else if (i % 10 == 3) {
                System.out.println("|...<0>.|");
            } else if (i % 10 == 4) {
                System.out.println("|....<0>|");
            } else if (i % 10 == 5) {
                System.out.println("|...<0>.|");
            } else if (i % 10 == 6) {
                System.out.println("|..<0>..|");
            } else {
                System.out.println("|.<0>...|");
            }


            Thread.sleep(200);
        }
    }
}