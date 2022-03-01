package com.example.forms;

import com.example.bdd.GetConnection;
import com.example.beans.SuperZeroModel;

import javax.naming.Name;
import javax.servlet.http.HttpServletRequest;

public class ConnectionForm {

    public SuperZeroModel newSuperZ(HttpServletRequest request){

        SuperZeroModel newSuperZ = new SuperZeroModel();
        newSuperZ.Name = request.getParameter("superName");
        newSuperZ.PhoneNumber = request.getParameter("superPhone");
        newSuperZ.City = request.getParameter("city");

        return newSuperZ;
    }
}
