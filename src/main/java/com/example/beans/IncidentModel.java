package com.example.beans;

public class IncidentModel {

    public int id;
    public String City;
    public String type;
    public String Latitude;
    public String Longitude;

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
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }
}
