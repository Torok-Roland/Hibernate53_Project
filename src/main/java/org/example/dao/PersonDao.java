package org.example.dao;

import org.example.database.DataBaseConfig;
import org.example.entities.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonDao {

    public Person createPerson (Person person){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(person);

        transaction.commit();
        session.close();

        return person;
    }

}
