package com.company;

public class TV {

    private String manufacturer;
    private String model;
    private int screenSize;
    private String channel;
    private int volume;
    private boolean powered;

    public TV(String manufacturer, String model, int screenSize, String channel, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.screenSize = screenSize;
        this.channel = channel;
        this.volume = volume;
        this.powered = powered;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getModel() {
        return this.model;
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    public String getChannel() {
        return this.channel;
    }

    public int getVolume() {
        return this.volume;
    }

    public boolean isPowered() {
        return this.powered;
    }

    public void togglePower() {
        if (powered = true) {
            powered = false;
        } else {
            powered = true;
        }
    }

}
