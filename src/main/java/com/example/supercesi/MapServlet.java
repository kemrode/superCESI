package com.example.supercesi;

import com.example.bdd.IncidentConnection;
import com.example.beans.IncidentModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MapServlet", value = "/MapServlet")
public class MapServlet extends HttpServlet {

    public MapServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        GetAllIncidents(request, response);
//        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public static void GetAllIncidents(HttpServletRequest request, HttpServletResponse response){
        IncidentConnection incidentConnection = new IncidentConnection(HomeServlet._getConnection.getConnection());
        List<IncidentModel> incidentList = incidentConnection.GetAllIncident();
        request.setAttribute("incidentList", incidentList);
    }
}
