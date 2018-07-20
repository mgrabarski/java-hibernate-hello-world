package com.grabarski.mateusz.examples;

import com.grabarski.mateusz.domain.models.Country;
import com.grabarski.mateusz.domain.models.CountryLanguage;
import com.grabarski.mateusz.domain.models.enums.IsOfficial;
import com.grabarski.mateusz.domain.models.keys.CountryLanguageId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Mateusz Grabarski on 20.07.2018.
 */
public class InsertLanguageToNewCountryExample {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration().configure().buildSessionFactory();
             Session session = factory.openSession()) {

            CountryLanguage newLanguage = new CountryLanguage();
            newLanguage.setIsOfficial(IsOfficial.F);
            newLanguage.setPercentage(1f);

            CountryLanguageId id = new CountryLanguageId();
            id.setCountryCode("POL");
            id.setLanguage("akdjfbvadjkvb");

            newLanguage.setId(id);

            Country poland = session.load(Country.class, "POL");
            poland.addLanguage(newLanguage);

            Transaction transaction = session.beginTransaction();
            transaction.commit();
        }
    }
}