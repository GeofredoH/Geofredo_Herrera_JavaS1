package com.company;

public class App {

    public TV createTV(){
        String manufacturer = "Zenith";
        String model = "U2121H";
        int screenSize = 83;
        String channel = "NBC";
        int volume = 55;
        boolean powered = false;

        TV television = new TV(manufacturer, model, screenSize, channel, volume, powered);
        return television;
    }

    public Radio createRadio(){
        String manufacturer = "Sony";
        String model = "V32";
        int numSpeaker = 2;
        String station = "WUNV";
        int volume = 30;
        boolean powered = true;

        Radio noiseBox = new Radio(manufacturer, model, numSpeaker, station, volume, powered);
        return noiseBox;
    }

    public Microwave createMicrowave(){
        String manufacturer = "Haier";
        String model = "X1200w";
        int secondsLeft = 45;
        String time = "12:00";
        boolean running = false;

        Microwave heater = new Microwave(manufacturer, model, secondsLeft, time, running);
        return heater;
    }

    public CoffeeMaker createCoffeeMaker(){
        String manufacturer = "Sunbeam";
        String model = "C12";
        int carafeSize = 12;
        int cupsLeft = 8;
        boolean powered = true;

        CoffeeMaker coffeeBean = new CoffeeMaker(manufacturer, model, carafeSize, cupsLeft, powered);
        return coffeeBean;
    }

    public Car createCar(){
        String make = "Honda";
        String model = "Accord";
        String type = "Sedan";
        String color = "Blue";
        String engine = "2.6L V6";
        String transmission = "CVT";
        int numDoors = 4;
        double mpg = 31.7;
        int milesDriven = 25218;

        Car ride = new Car(make, model, type, color, engine, transmission, numDoors, mpg, milesDriven);
        return ride;
    }

    public ComputerMouse createComputerMouse(){
        String manufacturer = "Razer";
        String model = "Naga";
        int xPosition = 960;
        int yPosition = 540;
        int[] lastClickedLocation = {0,0};

        ComputerMouse clicker = new ComputerMouse(manufacturer, model, xPosition, yPosition, lastClickedLocation);
        return clicker;
    }
}
