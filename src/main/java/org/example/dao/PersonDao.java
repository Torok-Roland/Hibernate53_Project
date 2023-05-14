package org.example.dao;

import org.example.database.DataBaseConfig;
import org.example.entities.Address;
import org.example.entities.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDao {

    public Person createPerson (Person person){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(person);

        transaction.commit();
        session.close();

        return person;
    }

    public Person updatePerson (Person person){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(person);

        transaction.commit();
        session.close();

        return person;
    }

    public Person readPerson (String cnp){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Person person = session.find(Person.class, cnp);
        session.close();

        return person;
    }

    public List<Person> readAllPerson(){
        Session session = DataBaseConfig.getSessionFactory().openSession();
        // caută în entitate
        // Person este numele clasei (al entității)
        List<Person> person = session.createQuery("select p from Person p",Person.class).getResultList();
        session.close();
        return person;
    }


}
