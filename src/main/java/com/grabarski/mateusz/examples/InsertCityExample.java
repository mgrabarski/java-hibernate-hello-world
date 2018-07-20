package com.grabarski.mateusz.examples;

import com.grabarski.mateusz.domain.models.City;
import com.grabarski.mateusz.domain.models.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Mateusz Grabarski on 19.07.2018.
 */
public class InsertCityExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            City newCity = new City();
            newCity.setName("Ciechocinek");
            newCity.setDistrict("Gliwice2");

            Country poland = session.load(Country.class, "POL");

            poland.addCity(newCity);

            Transaction transaction = session.beginTransaction();
            session.save(poland);
            transaction.commit();
        }
    }
}