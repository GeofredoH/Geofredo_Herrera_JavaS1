package com.company.concreteapproach;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area(){
        //code here
        return Math.PI * (radius * radius);
    }

    @Override
    public double perimeter() {
        //code here
        return Math.PI * (radius * 2);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
