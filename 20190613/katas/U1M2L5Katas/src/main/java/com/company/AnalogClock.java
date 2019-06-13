package com.company;

public class AnalogClock implements Clock{

    public void displayTime(){
        System.out.println("Time");
    }
    public void timer(int hour, int minute){
        System.out.println(hour + " hours and " + minute + " minutes remaining");
    }
}
