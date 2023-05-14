package org.example.entities;

import jakarta.persistence.Embeddable;

@Embeddable // pentru că AdrdressID este cheie primară compusă pentru Address
public class AddressId {

    private String streetName;
    private Integer streetNumber;
    private String city;

    public AddressId() {
    }

    public AddressId(String streetName, Integer streetNumber, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressId{" +
                "streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                ", city='" + city + '\'' +
                '}';
    }
}
