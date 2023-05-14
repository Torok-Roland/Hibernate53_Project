package org.example;

import org.example.dao.AddressDao;
import org.example.dao.PersonDao;
import org.example.entities.Address;
import org.example.entities.AddressId;
import org.example.entities.BuildingType;
import org.example.entities.Person;

public class Main {

    private static  AddressDao addressDao = new AddressDao();
    private static PersonDao personDao = new PersonDao();

    public static void main(String[] args) {
        AddressId addressId = new AddressId("Primaverii", 14, "Cluj-Napoca");
        Address address = new Address(addressId, 150, BuildingType.PRIVATE_HOUSE);

        addressDao.createAddress(address);

        Person firstPerson = new Person("1980101303930", "Moromete",1998, address);
        personDao.createPerson(firstPerson);



    }
}