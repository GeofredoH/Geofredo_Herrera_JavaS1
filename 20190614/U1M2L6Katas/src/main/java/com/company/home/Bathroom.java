package com.company.home;

public class Bathroom {
    private String bathType;
    private boolean productsAvailable;
    private String working;

    public String allowAccess(boolean allow){
        if(allow){
            this.working = "The bathroom is working now.";
            return this.working;
        }else {
            this.working = "Out of Order!";
            return this.working;
        }
    }

    public String flushToilet(){
        return "Wooooosshh!";
    }

    public String runShower(){
        return "Shhhhhhhhhhshshshsssh";
    }

    public Bathroom(String bathType, boolean productsAvailable, String working) {
        this.bathType = bathType;
        this.productsAvailable = productsAvailable;
        this.working = working;
    }

    public String getBathType() {
        return bathType;
    }

    public void setBathType(String bathType) {
        this.bathType = bathType;
    }

    public boolean isProductsAvailable() {
        return productsAvailable;
    }

    public void setProductsAvailable(boolean productsAvailable) {
        this.productsAvailable = productsAvailable;
    }

    public String isWorking() {
        return working;
    }

    public void setWorking(String working) {
        this.working = working;
    }
}
