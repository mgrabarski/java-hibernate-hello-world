package com.grabarski.mateusz.examples.criteria.models;

/**
 * Created by Mateusz Grabarski on 20.07.2018.
 */
public class CountryAddLanguage {

    private String countryName;
    private String language;

    public CountryAddLanguage(String countryName, String language) {
        this.countryName = countryName;
        this.language = language;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}