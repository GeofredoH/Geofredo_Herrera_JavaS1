package com.company;

public class ArrayFunReverseIt {
    public static void main(String[] args) {

        int[] forward = {1, 2, 3, 4, 5};
        int[] reverse = new int[forward.length];
        int arrayIndex = 0;

        for (int i = 4; i > -1; i--) { //adds elements in reverse order to array
            reverse[arrayIndex] = forward[i];

            arrayIndex++;
        }

        for (int numbers : forward) { //outputs original array
            System.out.println(numbers);
        }

        for (int numbersAgain : reverse) { //outputs reverse array
            System.out.println(numbersAgain);
        }
    }
}
