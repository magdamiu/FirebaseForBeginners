package com.magdamiu.firebaseforbeginners.model;

/**
 * Created by magdamiu on 24/05/17.
 */

public class Country {

    private String name;
    private String town;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", town='" + town + '\'' +
                '}';
    }

    public Country(String name, String town) {
        this.name = name;
        this.town = town;
    }

    public Country() {
    }
}
