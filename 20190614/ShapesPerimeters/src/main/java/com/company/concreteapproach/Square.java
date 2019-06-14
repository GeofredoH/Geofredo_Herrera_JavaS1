package com.company.concreteapproach;

public class Square extends Shape{

    private double length;

    public Square(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double area() {
        return length * length;
    }

    @Override
    public double perimeter() {
        return length * 4;
    }
}
