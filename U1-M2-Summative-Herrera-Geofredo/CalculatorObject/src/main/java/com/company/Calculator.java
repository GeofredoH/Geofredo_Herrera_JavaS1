package com.company;

public class Calculator { //this class has all the methods called for in instructions, no constructor or properties.

    public void add(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }

    public void subtract(int a, int b) {
        System.out.println(a + " - " + b + " = " + (a - b));
    }

    public void multiply(int a, int b) {
        System.out.println(a + " * " + b + " = " + (a * b));
    }

    public void divide(int a, int b) {
        if (a % b != 0) {
            System.out.println(a + " / " + b + " = " + (a / b) + " with a remainder of " + a % b);
        } else {
            System.out.println(a + " / " + b + " = " + (a / b));
        }
    }

    public void add(double a, double b) {
        System.out.format("%.1f + %.1f = %.1f\n", a, b, (a + b));
    }

    public void subtract(double a, double b) {
        System.out.format("%.1f - %.1f = %.1f\n", a, b, (a - b));
    }

    public void multiply(double a, double b) {
        System.out.format("%.1f * %.1f = %.1f\n", a, b, (a * b));
    }

    public void divide(double a, double b) {
        System.out.format("%.1f / %.1f = %.1f\n", a, b, (a / b));
    }
}
