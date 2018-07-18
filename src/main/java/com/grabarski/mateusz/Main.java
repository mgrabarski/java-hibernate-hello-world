package com.grabarski.mateusz;

import com.grabarski.mateusz.domain.models.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Created by Mateusz Grabarski on 18.07.2018.
 */
public class Main {

    public static void main(String[] args) {
        Country poland = null;

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();) {

            Query<Country> query = session.createQuery("FROM Country c JOIN FETCH " +
                    "c.capital WHERE c.code =:code");
            query.setParameter("code", "POL");
            poland = query.uniqueResult();

            poland.getCities().forEach(city -> System.out.println(city.getName()));

//            Query<City> query = session.createQuery("FROM City c WHERE c.country.name = 'France'");
//            query.setMaxResults(10);
//
//            query.stream().forEach(city -> System.out.println(city.getName() + " " +
//                    city.getCountryCode().getName()));
        }
//        System.out.println(poland);
    }
}