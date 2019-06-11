package com.company;

public class Radio {

    private String manufacturer;
    private String model;
    private int numSpeaker;
    private String station;
    private int volume;
    private boolean powered;

    public Radio(String manufacturer, String model, int numSpeaker, String station, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.numSpeaker = numSpeaker;
        this.station = station;
        this.volume = volume;
        this.powered = powered;
    }

    public boolean isPowered() {
        return this.powered;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getNumSpeakers() {
        return this.numSpeaker;
    }

    public String getStation() {

        return station;
    }

    public int getVolume() {
        return volume;
    }

    public void togglePower() {
        if (powered = true){
            powered = false;
        }else{
            powered = true;
        }
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setNumSpeakers(int numSpeaker){
        this.numSpeaker = numSpeaker;
    }

    public void setStation(String station){
        this.station = station;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }


}

