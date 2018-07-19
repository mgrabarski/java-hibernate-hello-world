package com.grabarski.mateusz;

import com.grabarski.mateusz.domain.CityNameDistrict;
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

            // return ony name from query
//            Query<String> query = session.createQuery("SELECT c.name FROM City c");
//            query.setMaxResults(10);
//
//            query.stream().forEach(s -> System.out.println(s));

            // return ony name and district from query
//            Query<Object[]> query = session.createQuery("SELECT c.name, c.district FROM City c");
//            query.setMaxResults(10);
//
//            query.stream().forEach(objects -> System.out.println(objects[0] + ", " + objects[1]));

            // query will map fields to object
            Query<CityNameDistrict> query = session.createQuery("SELECT new com.grabarski.mateusz.domain.CityNameDistrict(c.name, c.district) FROM City c");
            query.setMaxResults(10);

            query.stream().forEach(cityNameDistrict -> System.out.println(cityNameDistrict.getName() + ", " + cityNameDistrict.getDistrict()));
        }
    }
}