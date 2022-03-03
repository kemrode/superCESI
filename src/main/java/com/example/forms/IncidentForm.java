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
        String[] incident = request.getParameterValues("incident");
        String checked = "";
        for(int i=0;i<incident.length;i++){
            checked = incident[i];
        }
        newIncident.setType(checked);
        return newIncident;
    }

}
