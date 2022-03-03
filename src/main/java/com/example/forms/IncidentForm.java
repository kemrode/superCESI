package com.example.forms;

import com.example.beans.IncidentModel;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class IncidentForm {

    //Constructor
    public IncidentForm(){};

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
