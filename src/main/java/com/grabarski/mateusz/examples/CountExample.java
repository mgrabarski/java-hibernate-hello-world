package com.grabarski.mateusz.examples;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Created by Mateusz Grabarski on 19.07.2018.
 */
public class CountExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            Query<Object[]> query = session.createQuery(
                    "SELECT c.name, c.countryLanguages.size " +
                            "FROM Country c " +
                            "WHERE c.countryLanguages.size > 0 ");

            query.setMaxResults(30);

            query.stream().forEach(objects -> System.out.println("Name: " + objects[0] + ", number = " + objects[1]));
        }
    }
}