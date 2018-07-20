package com.grabarski.mateusz.examples;

import com.grabarski.mateusz.domain.models.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Mateusz Grabarski on 20.07.2018.
 */
public class MoveCityExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            Country germany = session.load(Country.class, "BEU");
            Country belgium = session.load(Country.class, "BEL");

            Transaction transaction = session.beginTransaction();

            session.createQuery("UPDATE City c SET c.country =:dest " +
                    "WHERE c.country=:src")
                    .setParameter("src", belgium)
                    .setParameter("dest", germany)
                    .executeUpdate();

            transaction.commit();
        }
    }
}