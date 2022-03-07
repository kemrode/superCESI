package com.example.bdd;

import com.example.beans.IncidentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncidentConnection {

    private Connection _connection;

    //contructor
    public IncidentConnection(Connection connection){
        _connection = connection;
    }

    //Public Methods
    //Get Method
    public List<IncidentModel> GetAllIncident(){
        List<IncidentModel> listIncidents = new ArrayList<IncidentModel>();
        String sql = "SELECT * FROM incident;";
        try{
            PreparedStatement preparedStatement = _connection.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                IncidentModel incident = new IncidentModel();
                incident.setCity(result.getString("city"));
                incident.setType(result.getString("type"));
                incident.setLatitude(result.getString("Latitude"));
                incident.setLongitude(result.getString("Longitude"));
                listIncidents.add(incident);
            }
            result.close();
            preparedStatement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return listIncidents;
    }

    //Post Method
    public void PostNewIncident(IncidentModel incidentToPost){
        String sql = "INSERT INTO incident(city, Latitude, Longitude, type) VALUES(?,?,?,?);";
        if(incidentToPost != null){
            try{
                PreparedStatement preparedStatement = _connection.prepareStatement(sql);
                preparedStatement.setString(1, incidentToPost.getCity());
                preparedStatement.setString(2,incidentToPost.getLatitude());
                preparedStatement.setString(3, incidentToPost.getLongitude());
                preparedStatement.setString(4, incidentToPost.getType());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
