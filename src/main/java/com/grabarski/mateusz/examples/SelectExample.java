package com.grabarski.mateusz.examples;

import com.grabarski.mateusz.domain.CityNameDistrict;
import com.grabarski.mateusz.domain.models.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Created by Mateusz Grabarski on 19.07.2018.
 */
public class SelectExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            Query<Country> query = session.createQuery("" +
                    "SELECT c " +
                    "FROM Country c JOIN c.countryLanguages l " +
                    "WHERE l.id.language = 'Polish'");
            query.setMaxResults(10);

            query.stream().forEach(country -> System.out.println(country.getName() + ": " + country.getCountryLanguages()));
        }
    }

    private static void displayCityName(Session session) {
        Query<String> query = session.createQuery("SELECT c.name FROM City c");
        query.setMaxResults(10);

        query.stream().forEach(s -> System.out.println(s));
    }

    private static void displayCityNameAndDistrict(Session session) {
        Query<Object[]> query = session.createQuery("SELECT c.name, c.district FROM City c");
        query.setMaxResults(10);

        query.stream().forEach(objects -> System.out.println(objects[0] + ", " + objects[1]));
    }

    private static void displayCityNameAndDistrictAsObject(Session session) {
        // sample how to use custom objects as query results
        Query<CityNameDistrict> query = session.createQuery(
                "SELECT new com.grabarski.mateusz.domain.CityNameDistrict(c.name, c.district) FROM City c");
        query.setMaxResults(10);

        query.stream().forEach(cityNameDistrict -> System.out.println(cityNameDistrict.getName() + ", " + cityNameDistrict.getDistrict()));
    }

    private static void findCityNamesByDistrict(Session session, String district) {
        Query<String> query = session.createQuery("SELECT c.name FROM City c WHERE c.district =:district");
        query.setMaxResults(10);
        query.setParameter("district", district);

        query.stream().forEach(s -> System.out.println(s));
    }
}