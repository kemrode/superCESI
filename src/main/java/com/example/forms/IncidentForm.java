package com.example.forms;

import com.example.beans.IncidentModel;

import javax.servlet.http.HttpServletRequest;
public class IncidentForm {

    //Constructor
    public IncidentForm(){};

    //Public Method
    public IncidentModel newIncident(HttpServletRequest request){
        IncidentModel newIncident = new IncidentModel();
        newIncident.setCity(request.getParameter("incidentCity"));
        newIncident.setLatitude(request.getParameter("latitude"));
        newIncident.setLongitude(request.getParameter("longitude"));
        String[] incident = request.getParameterValues("incident");
        String checked = "";
        for(int i=0;i<incident.length;i++){
            checked = incident[i];
        }
        newIncident.setType(checked);
        return newIncident;
    }

}
