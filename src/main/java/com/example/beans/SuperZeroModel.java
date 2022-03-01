package com.example.beans;

import java.sql.Array;

public class SuperZeroModel {

    public int Id;
    public String Name;
    public String PhoneNumber;
    public String City;
    public String Latitude;
    public String Longitude;
    public Array BusinessIncidents;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public Array getBusinessIncidents() {
        return BusinessIncidents;
    }

    public void setBusinessIncidents(Array businessIncidents) {
        BusinessIncidents = businessIncidents;
    }
}