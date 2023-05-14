package org.example;

import org.example.dao.AddressDao;
import org.example.dao.PersonDao;
import org.example.entities.Address;
import org.example.entities.AddressId;
import org.example.entities.BuildingType;
import org.example.entities.Person;

public class Main {

    private static AddressDao addressDao = new AddressDao();
    private static PersonDao personDao = new PersonDao();

    public static void main(String[] args) {
        AddressId addressId = new AddressId("Primaverii", 14, "Cluj-Napoca");
        AddressId address2 = new AddressId("Independentei", 7, "Sibiu");

        Address address = new Address(addressId, 150, BuildingType.PRIVATE_HOUSE);
        Address addressTwo = new Address(address2, 220, BuildingType.DUPLEX);

        addressDao.createAddress(address);
        addressDao.createAddress(addressTwo);

        Person firstPerson = new Person("1980101303930", "Moromete", 1998, address);
        personDao.createPerson(firstPerson);

        Address a1 = addressDao.readAddress(addressId);

        System.out.println(a1);

        System.out.println(personDao.readPerson("1980101303930"));

        Person ion = new Person("193040567842345", "Ion", 1993, address);
        Person vlad = new Person("177040567842345", "Vlad", 1977, addressTwo);
        Person mihai = new Person("186040567842345", "Mihai", 1986, address);
        Person dorin = new Person("168040567842345", "Dorin", 1968, addressTwo);
        Person maria = new Person("289121298983556", "Maria", 1989, address);
        Person ioana = new Person("299121298983556", "Ioana", 1999, address);
        Person simona = new Person("278121298983556", "Simona", 1978, address);

        personDao.createPerson(ion);
        personDao.createPerson(vlad);
        personDao.createPerson(mihai);
        personDao.createPerson(dorin);
        personDao.createPerson(maria);
        personDao.createPerson(ioana);
        personDao.createPerson(simona);

        personDao.readAllPerson().forEach(p -> System.out.println(p));

        simona.setName("Irina");
        personDao.updatePerson(simona);

        System.out.println("***********");
        personDao.readAllPerson().forEach(p -> System.out.println(p));

        personDao.removePerson(simona);

        System.out.println("Young");
        personDao.youngThan(1990).forEach(System.out::println);

        System.out.println("---------------------------------------------");
        personDao.allFrom("Cluj-Napoca").forEach(System.out::println);

}
}