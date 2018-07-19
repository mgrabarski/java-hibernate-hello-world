package com.grabarski.mateusz.examples;

import com.grabarski.mateusz.domain.models.CountryLanguage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Created by Mateusz Grabarski on 19.07.2018.
 */
public class CountryLanguageExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            Query<CountryLanguage> query = session.createQuery("FROM  CountryLanguage ");
            query.setMaxResults(10);

            query.stream().forEach(countryLanguage -> System.out.println(countryLanguage.getId().getCountryCode()));
        }
    }
}