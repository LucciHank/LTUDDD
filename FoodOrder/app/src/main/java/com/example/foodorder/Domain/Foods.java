package com.example.foodorder.Domain;

import java.io.Serializable;

public class Foods implements Serializable {
    private  int Category;
    private String Description;
    private boolean BestFood;
    private int Id;
    private int locationId;
    private double Price;
    private String ImagePath;
    private int PriceId;
    private double Star;
    private int TimeId;
    private int TimeValue;
    private String Title;
    private int numberInCart;

    public Foods() {
    }

    @Override
    public String toString() {
        return  Title;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isBestFood() {
        return BestFood;
    }

    public void setBestFood(boolean bestFood) {
        BestFood = bestFood;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public int getPriceId() {
        return PriceId;
    }

    public void setPriceId(int priceId) {
        PriceId = priceId;
    }

    public double getStar() {
        return Star;
    }

    public void setStar(double star) {
        Star = star;
    }

    public int getTimeId() {
        return TimeId;
    }

    public void setTimeId(int timeId) {
        TimeId = timeId;
    }

    public int getTimeValue() {
        return TimeValue;
    }

    public void setTimeValue(int timeValue) {
        TimeValue = timeValue;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getNumberInCart() {
        return numberInCart;
    }

    public void setNumberInCart(int numberInCart) {
        this.numberInCart = numberInCart;
    }
}
