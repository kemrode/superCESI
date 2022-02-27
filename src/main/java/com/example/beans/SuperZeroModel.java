package com.example.beans;

public class SuperZeroModel {
    public int Id;
    public String Name;
    public String PhoneNumber;
    public String Coordinates;
    public String[] BusinessIncidents;

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

    public String getCoordinates() {
        return Coordinates;
    }

    public void setCoordinates(String coordinates) {
        Coordinates = coordinates;
    }

    public String[] getBusinessIncidents() {
        return BusinessIncidents;
    }

    public void setBusinessIncidents(String[] businessIncidents) {
        BusinessIncidents = businessIncidents;
    }

}
