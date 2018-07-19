package com.grabarski.mateusz.domain.models.keys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Mateusz Grabarski on 19.07.2018.
 */
@Embeddable
public class CountryLanguageId implements Serializable {

    @Column(name = "CountryCode")
    private String countryCode;

    @Column(name = "Language")
    private String language;

    public CountryLanguageId() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return Objects.equals(countryCode, that.countryCode) &&
                Objects.equals(language, that.language);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countryCode, language);
    }
}