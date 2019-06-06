package com.company;

public class App {

    public static int subtract(int a, int b) {  //subtracts b from a and returns value

        return a - b;
    }

    public static int subtractOrZero(int a, int b) { //subtracts b from a and returns difference or zero
        int difference;

        difference = a - b;

        if (difference < 0)
            return 0;
        else
            return difference;
    }

    public static int max(int a, int b, int c) { //finds and returns the max value
        int[] numbers;
        numbers = new int[]{a, b, c};

        int max = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max)
                max = numbers[i];
        }
        return max;
    }

    public static int min(int a, int b, int c) { //finds and returns the minimum value
        int[] numbers;
        numbers = new int[]{a, b, c};

        int min = 0;
        boolean firstAttempt = true;

        for (int i = 0; i < numbers.length; i++) {

            if (firstAttempt) {
                min = numbers[0];
                firstAttempt = false;
            }

            if (numbers[i] < min)
                min = numbers[i];
        }

        return min;
    }

    public static boolean isLarger(int first, int second) { //determines if the first parameter is less than the second parameter
        boolean trueFalse = false;

        if (first > second)
            trueFalse = true;

        return trueFalse;
    }


}
