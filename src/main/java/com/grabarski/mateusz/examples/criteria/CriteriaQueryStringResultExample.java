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
public class CriteriaQueryStringResultExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<String> cq = cb.createQuery(String.class);

            Root<Country> root = cq.from(Country.class);
            cq.select(root.get("name"));

            session.createQuery(cq)
                    .setMaxResults(10)
                    .stream()
                    .forEach(s -> System.out.println(s));
        }
    }
}