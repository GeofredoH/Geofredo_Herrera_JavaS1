package com.company.restaurant;

public class Food {
    private String name;
    private String ingredients;
    private int cookTime;
    private double price;

    public Food(String name, String ingredients, int cookTime, double price) {
        this.name = name;
        this.ingredients = ingredients;
        this.cookTime = cookTime;
        this.price = price;
    }

    public void prepIngred(){
        System.out.println("Get the ingredients ready");
    }

    public void coolDown(){
        System.out.println("Give this food a minute to rest");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
