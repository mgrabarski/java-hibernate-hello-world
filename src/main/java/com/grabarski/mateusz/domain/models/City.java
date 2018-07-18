package com.grabarski.mateusz.domain.models;

import javax.persistence.*;

/**
 * Created by Mateusz Grabarski on 18.07.2018.
 */
@Entity
@Table(name = "city")
public class City {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // database generate id
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "CountryCode")
    private String countryCode;

    @Column(name = "District")
    private String district;

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}