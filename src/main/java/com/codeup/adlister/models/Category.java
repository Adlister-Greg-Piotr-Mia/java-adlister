package com.codeup.adlister.models;

import java.util.List;

public class Category {
    // variables
    private long id;
    private String category;
    private List<Ad> ads;

    // constructors
    public Category(){};
    public Category(long id, String category){
        this.id = id;
        this.category = category;
    }
    public Category(String category){
        this.category = category;
    }

    // getters/setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<Ad> getAds() {
        return ads;
    }

    public void setAds(List<Ad> ads) {
        this.ads = ads;
    }
}
