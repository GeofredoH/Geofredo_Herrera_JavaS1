package com.company;

public class CalculatorApp {
    public static void main(String[] args) {

        Calculator mathWiz = new Calculator(); //instantializing new calculator object

        mathWiz.add(1, 1);
        mathWiz.subtract(23, 52);       //calling the methods for the numbers given
        mathWiz.multiply(34, 2);        //overloaded methods determine the data type, int or double
        mathWiz.divide(12, 3);
        mathWiz.divide(12, 7);
        mathWiz.add(3.4, 2.3);
        mathWiz.multiply(6.7, 4.4);
        mathWiz.subtract(5.5, 0.5);
        mathWiz.divide(10.8, 2.2);
    }
}
