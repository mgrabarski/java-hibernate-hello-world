package com.grabarski.mateusz.examples;

import com.grabarski.mateusz.domain.models.City;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * Created by Mateusz Grabarski on 19.07.2018.
 */
public class UpdateExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {


            Query<City> countryQuery = session.createQuery(" FROM City c WHERE c.name = 'Ciechocinek'");

            City ciechocinek = countryQuery.uniqueResult();
            ciechocinek.setDistrict("Małopolska");

            Transaction transaction = session.beginTransaction();
            session.save(ciechocinek);
            transaction.commit();
        }
    }
}