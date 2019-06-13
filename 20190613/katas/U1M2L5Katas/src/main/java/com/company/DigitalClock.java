package com.company;

public class DigitalClock implements Clock, Alarm {

    public void displayTime(){
        System.out.println("Time");
    }
    public void timer(int hour, int minute){
        System.out.println(hour + " hours and " + minute + " minutes remaining");
    }

    public void sound(){
        System.out.println("Buzz");
    }
}
