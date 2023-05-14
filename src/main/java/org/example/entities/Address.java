package org.example.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Address {

    @EmbeddedId    // pentru că e vorba de mai multe coloane care vor forma cheia primară
    private AddressId id;

    private Integer squareMeters;

    @Enumerated(value = EnumType.STRING)
    private BuildingType buildingType;

    public Address() {

    }

    public Address(AddressId id, Integer squareMeters, BuildingType buildingType) {
        this.id = id;
        this.squareMeters = squareMeters;
        this.buildingType = buildingType;
    }

    public AddressId getId() {
        return id;
    }

    public void setId(AddressId id) {
        this.id = id;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }
}
