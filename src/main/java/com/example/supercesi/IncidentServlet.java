package com.example.supercesi;

import com.example.bdd.GetConnection;
import com.example.bdd.IncidentConnection;
import com.example.beans.IncidentModel;
import com.example.forms.ConnectionForm;
import com.example.forms.IncidentForm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IncidentServlet", value = "/IncidentServlet")
public class IncidentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/IncidentForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IncidentForm form = new IncidentForm();
        IncidentModel newIncident = form.newIncident(request);
        GetConnection connection = new GetConnection();
        IncidentConnection incidentConnection = new IncidentConnection(connection.GetConnection());
        incidentConnection.PostNewIncident(newIncident);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }
}
