package com.example.beans;

public class IncidentModel {

    //Public Properties
    public int id;
    public String City;
    public String type;
    public String Latitude;
    public String Longitude;

    //Getter
    public int getId() {
        return id;
    }
    public String getCity() {
        return City;
    }
    public String getType() {
        return type;
    }
    public String getLatitude() {
        return Latitude;
    }
    public String getLongitude() {
        return Longitude;
    }

    //Setter
    public void setId(int id) {
        this.id = id;
    }
    public void setCity(String city) {
        City = city;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setLatitude(String latitude) {
        Latitude = latitude;
    }
    public void setLongitude(String longitude) {
        Longitude = longitude;
    }
}
