package com.grabarski.mateusz.examples.criteria;

import com.grabarski.mateusz.domain.models.Country;
import com.grabarski.mateusz.domain.models.CountryLanguage;
import com.grabarski.mateusz.domain.models.enums.IsOfficial;
import com.grabarski.mateusz.examples.criteria.models.CountryAddLanguage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 * Created by Mateusz Grabarski on 20.07.2018.
 */
public class CriteriaQueryJoinExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<CountryAddLanguage> cq = cb.createQuery(CountryAddLanguage.class);

            // FROM Country country JOIN country.cities
            Root<Country> country = cq.from(Country.class);
            Join<Country, CountryLanguage> countryLanguage = country.join("countryLanguages");

            cq.where(cb.equal(countryLanguage.get("isOfficial"), IsOfficial.T));
            cq.select(cb.construct(CountryAddLanguage.class,
                    country.get("name"),
                    countryLanguage.get("id").get("language")));

            session.createQuery(cq)
                    .stream()
                    .forEach(countryAddLanguage ->
                            System.out.println(countryAddLanguage.getCountryName() + ", " + countryAddLanguage.getLanguage()));
        }
    }
}