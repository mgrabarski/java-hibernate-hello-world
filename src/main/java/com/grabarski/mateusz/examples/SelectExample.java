package com.grabarski.mateusz.examples;

import com.grabarski.mateusz.domain.CityNameDistrict;
import com.grabarski.mateusz.domain.models.City;
import com.grabarski.mateusz.domain.models.Country;
import com.grabarski.mateusz.domain.selects.CountryWithCountryCode;
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

            Query<City> countryQuery = session.createQuery(" FROM City c WHERE c.country.name = 'Poland'");
            countryQuery.stream().forEach(country -> System.out.println(country.getName() + ", " + country.getDistrict()));
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

    private static void displayCountriesWithCodes(Session session) {
        Query<CountryWithCountryCode> query = session.createQuery(
                "SELECT new com.grabarski.mateusz.domain.selects.CountryWithCountryCode(c.name, c.code) FROM Country c ");
        query.setMaxResults(10);

        query.stream().forEach(countryWithCountryCode -> System.out.println(countryWithCountryCode.getName() + ", " + countryWithCountryCode.getCode()));
    }

    private static void displayCountriesWithOneOfficialLanguage(Session session) {
        Query<Country> query = session.createQuery("" +
                "FROM Country  c " +
                "WHERE " +
                "(SELECT COUNT(*) " +
                "       FROM CountryLanguage cl " +
                "       WHERE cl.country = c AND cl.isOfficial = 'T' ) " +
                "= 1");

        query.stream().forEach(country -> System.out.println(country.getName()));
    }

    private static void displayAllCountriesWhereUsingInputLanguage(Session session, String language) {
        Query<Country> query = session.createQuery(
                "SELECT c FROM Country c JOIN c.countryLanguages l " +
                        "WHERE l.id.language =:language");
        query.setParameter("language", language);

        query.stream().forEach(country -> System.out.println(country.getName()));
    }

    private static void displayAllCountriesWhereUsingLanguageIsOfficial(Session session, String language) {
        Query<Country> query = session.createQuery(
                "SELECT c FROM Country c JOIN c.countryLanguages l " +
                        "WHERE l.id.language =:language AND l.isOfficial = 'T' ");
        query.setParameter("language", language);

        query.stream().forEach(country -> System.out.println(country.getName()));
    }
}