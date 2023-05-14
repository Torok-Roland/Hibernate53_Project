package org.example.dao;

import org.example.database.DataBaseConfig;
import org.example.entities.Address;
import org.example.entities.AddressId;
import org.hibernate.Session;
import org.hibernate.Transaction;

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


}
