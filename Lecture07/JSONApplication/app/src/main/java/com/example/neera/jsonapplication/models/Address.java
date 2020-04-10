package com.example.neera.jsonapplication.models;

/**
 * Created by Neera on 26/09/17.
 */

public class Address {

    String city, zipcode;

    public Address(String city, String zipcode) {
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }
}
