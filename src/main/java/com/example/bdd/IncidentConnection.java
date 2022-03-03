package com.example.bdd;

import com.example.beans.IncidentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IncidentConnection {

    private Connection _connection;

    //contructor
    public IncidentConnection(Connection connection){
        _connection = connection;
    }

    //Get Method

    //Post Method
    public void PostNewIncident(IncidentModel incidentToPost){
        String sql = "INSERT INTO incident(city, type) VALUES(?,?);";
        if(incidentToPost != null){
            try{
                PreparedStatement preparedStatement = _connection.prepareStatement(sql);
                preparedStatement.setString(1, incidentToPost.getCity());
                preparedStatement.setString(2, incidentToPost.getType());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
