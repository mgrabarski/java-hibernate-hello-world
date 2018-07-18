package com.grabarski.mateusz.domain.models;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Mateusz Grabarski on 18.07.2018.
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Capital")
    private City capital;

    @Column(name = "Code2")
    private String code2;

    @OneToMany(mappedBy = "country")
    private Set<City> cities;

    public Country() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCapital() {
        return capital;
    }

    public void setCapital(City capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }
}