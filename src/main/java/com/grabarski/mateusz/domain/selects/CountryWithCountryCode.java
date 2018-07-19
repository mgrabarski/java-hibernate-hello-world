package com.grabarski.mateusz.domain.selects;

/**
 * Created by Mateusz Grabarski on 19.07.2018.
 */
public class CountryWithCountryCode {

    private String name;
    private String code;

    public CountryWithCountryCode(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}