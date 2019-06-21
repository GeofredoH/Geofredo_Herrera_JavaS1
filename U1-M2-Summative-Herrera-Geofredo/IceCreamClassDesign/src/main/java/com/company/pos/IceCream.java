package com.company.pos;

public class IceCream {
    private String name;
    private String flavorDescription;
    private String coneType;
    private int scoops;
    private String extraToppings;
    private boolean sundae;

    //the class modeled for a point-of-sale system must only initialize
    // the name property because all other values are highly changeable
    public IceCream(String name) {
        this.name = name;
    }

    public IceCream() {
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlavorDescription() {
        return flavorDescription;
    }

    public void setFlavorDescription(String flavorDescription) {
        this.flavorDescription = flavorDescription;
    }

    public String getConeType() {
        return coneType;
    }

    public void setConeType(String coneType) {
        this.coneType = coneType;
    }

    public int getScoops() {
        return scoops;
    }

    public void setScoops(int scoops) {
        this.scoops = scoops;
    }

    public String getExtraToppings() {
        return extraToppings;
    }

    public void setExtraToppings(String extraToppings) {
        this.extraToppings = extraToppings;
    }

    public boolean isASundae() {
        return sundae;
    }

    public void setSundae(boolean sundae) {
        this.sundae = sundae;
    }
}
