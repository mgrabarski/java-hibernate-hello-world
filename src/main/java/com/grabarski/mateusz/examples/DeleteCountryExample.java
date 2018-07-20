package com.grabarski.mateusz.examples;

import com.grabarski.mateusz.domain.models.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Mateusz Grabarski on 20.07.2018.
 */
public class DeleteCountryExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            Country france = session.load(Country.class, "FRA");

            Transaction transaction = session.beginTransaction();

            session.delete(france);

            transaction.commit();
        }
    }
}