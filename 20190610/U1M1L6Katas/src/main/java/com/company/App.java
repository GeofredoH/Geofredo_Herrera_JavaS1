package com.company;

public class App {

    public static int total(int[] numbers) {

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) { //adds array values together
            sum += numbers[i];
        }

        return sum;
    }

    public static int totalOdd(int[] numbers) {

        int sum = 0;

        for (int i = 1; i < numbers.length; i += 2) { //finds odd values in array
            sum += numbers[i];
        }

        return sum;
    }

    public static int totalEven(int[] numbers) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i += 2) { //finds even values in array
            sum += numbers[i];
        }

        return sum;
    }

    public static int secondLargestNumber(int[] numbers) {
        int max = numbers[1];
        int secondMax = numbers[0];
        int intermediateNumber = 0;

        if (secondMax > max) { //organizes first two values in array
            intermediateNumber = max;
            max = secondMax;
            secondMax = intermediateNumber;
        }

        for (int i = 2; i < numbers.length; i++) { //sorts max and second largest number
            if (numbers[i] > max) {
                secondMax = max;
                max = numbers[i];
            }
            if (numbers[i] < max && numbers[i] > secondMax) {
                secondMax = numbers[i];
            }
        }
        return secondMax;
    }

    public static String[] swapFirstAndLast(String[] words) {

        String first = "";

        for (int i = 0; i < words.length; i++) {

            if (i == 0) {
                first = words[i];
            }

            if (i == (words.length) - 1) { //swaps first and last
//                last = words[i];
                words[0] = words[i];
                words[(words.length) - 1] = first;

            }
        }
        return words;

    }

    public static int[] reverse(int[] digits) {

        int holderVariable;
        int counter = 1;

        for (int i = 0; i < digits.length; i++) { // swaps first and last then increments inward

            holderVariable = digits[(digits.length) - counter];

            digits[digits.length - counter] = digits[i];

            digits[i] = holderVariable;

            counter++;

            if (i >= (digits.length / 2) - 1)
                break;
        }

        return digits;
    }

    public static String concatenateString(String[] words) {

        String newWord = "";

        for (int i = 0; i < words.length; i++) { //concatenates every index incrementation
            newWord += words[i];
        }

        return newWord;
    }

    public static int[] everyThird(int[] passedArray) {

        int[] newArray;

        int indexKeeper = 0;

        if (passedArray.length < 3) { //null if passed array is less than 3
            return null;
        } else {
            newArray = new int[(passedArray.length / 3)]; // new array of correct size

            for (int i = 1; i < passedArray.length; i++) {

                if ((i + 1) % 3 == 0) {
                    newArray[indexKeeper] = passedArray[i];
                    indexKeeper++;
                }
            }
            return newArray;
        }
    }

    public static int[] lessThanFive(int[] passedArray) {

        int[] newArray;
        int newSize = 0;
        int newIndex = 0;

        for (int i = 0; i < passedArray.length; i++) { //find amount of numbers less than 5
            if (passedArray[i] < 5) {
                newSize++;
            }
        }

        if (newSize == 0) {

            return null;
        } else {
            newArray = new int[newSize]; //make new array of correct size
        }

        for (int e = 0; e < passedArray.length; e++) { //add values to new array

            if (passedArray[e] < 5) {

                newArray[newIndex] = passedArray[e];

                newIndex++;
            }
        }

        return newArray;
    }

    public static int[][] splitAtFive(int[] passedArray){

        int counterGreaterThan = 0;
        int counterLessThan = 0;

        for (int i = 0; i < passedArray.length; i++){ //finds amount of >5 and amount of <5
            if (passedArray[i] >= 5){
                counterGreaterThan++;
            }else{
                counterLessThan++;
            }
        }

        int[] array1 = new int[counterLessThan];
        int[] array2 = new int[counterGreaterThan];
        int newIndex = 0; //counters for adding to array2
        int newIndex2 = 0; //counter for adding to array1

        for (int e = 0; e < passedArray.length; e++){ //adds to array1 and array2
            if (passedArray[e] >= 5){
                array2[newIndex] = passedArray[e];
                newIndex++;
            }else {
                array1[newIndex2] = passedArray[e];
                newIndex2++;
            }
        }
        int[][] newArray = {array1, array2}; //combines both arrays into 1 two dimensional array

        return newArray;
    }

    public static String[][] evensAndOdds(String[] words){
        int counterGreaterThan = 0;
        int counterLessThan = 0;

        for (int i = 0; i < words.length; i++){ //counts even and odd indices for new arrays sizes
            if (i%2 == 0){
                counterGreaterThan++;
            }else{
                counterLessThan++;
            }
        }

        String[] array1 = new String[counterGreaterThan];
        String[] array2 = new String[counterLessThan];
        int newIndex = 0; //counters for adding to array1
        int newIndex2 = 0; //counter for adding to array2

        for (int e = 0; e < words.length; e++){ //adds to array1 and array2
            if (e%2 == 0){
                array1[newIndex] = words[e];
                newIndex++;
            }else {
                array2[newIndex2] = words[e];
                newIndex2++;
            }
        }
        String[][] newArray = {array1, array2}; //combines both arrays into 1 two dimensional array

        return newArray;
    }
}
