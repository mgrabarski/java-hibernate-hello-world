package com.grabarski.mateusz.examples.criteria;

import com.grabarski.mateusz.domain.models.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Mateusz Grabarski on 20.07.2018.
 */
public class CriteriaQueryExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            CriteriaQuery<Country> countryCriteriaQuery = criteriaBuilder.createQuery(Country.class);

            Root<Country> root = countryCriteriaQuery.from(Country.class);

            countryCriteriaQuery.select(root);
            countryCriteriaQuery.where();

            // TODO: 20.07.2018 copy
        }
    }
}