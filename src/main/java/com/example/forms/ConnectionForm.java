package com.example.forms;

import com.example.beans.SuperZeroModel;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ConnectionForm {

    //Constructor
    public ConnectionForm() {};

    //Public Method
    public SuperZeroModel newSuperZ(HttpServletRequest request){
        SuperZeroModel newSuperZ = new SuperZeroModel();
//        Supprimer les latitude et longitude que l'on récupèrera pour l'affichage grâce à la ville
        newSuperZ.Longitude = "0.123456789";
        newSuperZ.Latitude = "0.123456789";
        newSuperZ.setName(request.getParameter("superName"));
        newSuperZ.setPhoneNumber(request.getParameter("superPhone"));
        newSuperZ.setCity(request.getParameter("city"));
        newSuperZ.setBusinessIncidents(getCheckedBoxes(request));
        return newSuperZ;
    }

    //Private Method
    private String getCheckedBoxes(HttpServletRequest request){
        String[] incident = request.getParameterValues("incident");
        String checked = null;
        List<String> test = new ArrayList<String>();
        if(incident.length != 0){
            for(int i=0;i<incident.length;i++){
                if(incident[i] != null){
                    test.add(incident[i]);
                }
            }
            checked = test.toString();
            checked = checked.replaceAll("\\[", "");
            checked = checked.replaceAll("\\]", "");
        }
        return checked;
    }
}
