package com.company;

public class SomeMath {
    public static void main(String[] args) {

        System.out.println(total5(1, 2, 3, 4, 5));
        System.out.println(average5(1, 3, 5, 7, 9));
        System.out.println(largest5(42.0, 35.1, 2.3, 40.2, 15.6));

    }

    public static int total5(int a, int b, int c, int d, int e) {
        return a + b + c + d + e; //sums all values
    }

    public static double average5(int f, int g, int h, int i, int j) {
        double average = (f + g + h + i + j) / 5; //calculates average
        return average;
    }

    public static double largest5(double k, double l, double m, double n, double o) {
        double largest = k;

        double[] numberHolder = {k, l, m, n, o};

        for (int i = 1; i < numberHolder.length; i++) { //finds largest number
            if (numberHolder[i] > largest) {
                largest = numberHolder[i];
            }
        }
        return largest;
    }

}
