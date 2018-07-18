package com.grabarski.mateusz;

import com.grabarski.mateusz.domain.models.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Created by Mateusz Grabarski on 18.07.2018.
 */
public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Query<City> query = session.createQuery("FROM City");
        query.setMaxResults(10);

        query.getResultStream().forEach(city -> System.out.println(city));
    }
}