package com.example.supercesi;

import com.example.bdd.GetConnection;
import com.example.bdd.IncidentConnection;
import com.example.beans.IncidentModel;
import com.example.forms.IncidentForm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static com.example.supercesi.MapServlet.GetAllIncidents;

@WebServlet(name = "IncidentServlet", value = "/IncidentServlet")
public class IncidentServlet extends HttpServlet {

    public IncidentServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomeServlet.GetSuperZDisplaying(request, response);
        GetAllIncidents(request, response);
        this.getServletContext().getRequestDispatcher("/WEB-INF/IncidentForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewIncidentToRegisterInDB(request);
        HomeServlet.GetSuperZDisplaying(request, response);
        GetAllIncidents(request, response);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    private void NewIncidentToRegisterInDB(HttpServletRequest request){
        IncidentForm form = new IncidentForm();
        GetConnection connection = new GetConnection();
        IncidentModel newIncident = form.newIncident(request);
        IncidentConnection incidentConnection = new IncidentConnection(connection.getConnection());
        incidentConnection.PostNewIncident(newIncident);
    }
}
