package com.grabarski.mateusz.domain.models;

import com.grabarski.mateusz.domain.models.enums.IsOfficial;
import com.grabarski.mateusz.domain.models.keys.CountryLanguageId;

import javax.persistence.*;

/**
 * Created by Mateusz Grabarski on 19.07.2018.
 */
@Entity
@Table(name = "CountryLanguage")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguageId id;

    @Enumerated(EnumType.STRING)
    @Column(name = "IsOfficial")
    private IsOfficial isOfficial;

    @Column(name = "percentage")
    private float percentage;

    @ManyToOne
    @JoinColumn(name = "countryCode")
    @MapsId("countryCode")
    private Country country;

    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }

    public IsOfficial getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(IsOfficial isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}