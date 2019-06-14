package com.company.concreteapproach;

public class Triangle extends Shape {
    private double lengthA;
    private double lengthB;
    private double lengthC;

    public Triangle(double lengthA, double lengthB, double lengthC) {
        this.lengthA = lengthA;
        this.lengthB = lengthB;
        this.lengthC = lengthC;
    }

    @Override
    public double area() {
        double s = perimeter()/2;
        return Math.sqrt((s * (s - lengthA) * (s - lengthB) * (s - lengthC)));
    }

    @Override
    public double perimeter() {

        return lengthA + lengthB + lengthC;
    }
}
