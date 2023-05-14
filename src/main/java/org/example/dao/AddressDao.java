package org.example.dao;

import org.example.database.DataBaseConfig;
import org.example.entities.Address;
import org.example.entities.AddressId;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AddressDao {

    // CRUD
    // create
    // read
    // update
    // delete

    public Address createAddress(Address address) {
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(address);

        transaction.commit();
        session.close();
        return address;
    }

    public Address readAddress(AddressId addressId) {
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Address address = session.find(Address.class, addressId);

        session.close();
        return address;
    }
    public List<Address> readAllAddress() {
        Session session = DataBaseConfig.getSessionFactory().openSession();
        // caută în entitate
        // Adress este numele clasei (al entității)
        List<Address> addresses = session.createQuery("select a from Address a",Address.class).getResultList();
        session.close();
        return addresses;
    }

    public Address updateAddress(Address address) {
        Session session = DataBaseConfig.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        session.merge(address);

        transaction.commit();
        session.close();
        return address;
    }

}
