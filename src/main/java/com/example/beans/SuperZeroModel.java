package com.example.beans;

import java.sql.Array;

public class SuperZeroModel {

    //Public Properties
    public int Id;
    public String Name;
    public String PhoneNumber;
    public String City;
    public String Latitude;
    public String Longitude;
    public String BusinessIncidents;
    public String Quote;
    public String Picture;

    //Getter
    public int getId() {
        return Id;
    }
    public String getName() {
        return Name;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public String getCity() {
        return City;
    }
    public String getLatitude() {
        return Latitude;
    }
    public String getLongitude() {
        return Longitude;
    }
    public String getBusinessIncidents() {
        return BusinessIncidents;
    }
    public String getQuote() {
        return Quote;
    }
    public String getPicture() {
        return Picture;
    }

    //Setter
    public void setId(int id) {
        Id = id;
    }
    public void setName(String name) {
        Name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public void setCity(String city) {
        City = city;
    }
    public void setLatitude(String latitude) {
        Latitude = latitude;
    }
    public void setLongitude(String longitude) {
        Longitude = longitude;
    }
    public void setBusinessIncidents(String businessIncidents) {
        BusinessIncidents = businessIncidents;
    }
    public void setQuote(String quote) {
        Quote = quote;
    }
    public void setPicture(String picture) {
        Picture = picture;
    }
}