package com.example.supercesi;

import com.example.bdd.GetConnection;
import com.example.bdd.IncidentConnection;
import com.example.bdd.SuperZConnection;
import com.example.beans.IncidentModel;
import com.example.beans.SuperZeroModel;
import com.example.forms.IncidentForm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.supercesi.MapServlet.GetAllIncidents;

@WebServlet(name = "IncidentServlet", value = "/IncidentServlet")
public class IncidentServlet extends HttpServlet {

    public IncidentServlet(){
        super();
    }

    public static GetConnection _getConnection = new GetConnection();
    private static List<SuperZeroModel> _listSuperZMatched = new ArrayList<SuperZeroModel>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomeServlet.GetSuperZDisplaying(request, response);
        GetAllIncidents(request, response);
        List<SuperZeroModel> listSuperZMatching = GetSuperZIncidentMatching(request, response);
        request.setAttribute("listSuperZ", listSuperZMatching);
        boolean isNewIncident = true;
        request.setAttribute("isNewIncident", isNewIncident);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NewIncidentToRegisterInDB(request, response);
        List<SuperZeroModel> listSuperZMatching = GetSuperZIncidentMatching(request, response);
        request.setAttribute("listSuperZ", listSuperZMatching);
        boolean isNewIncident = true;
        request.setAttribute("isNewIncident", isNewIncident);
        response.sendRedirect(request.getContextPath() + "/Home");
    }
    //Public Methods
    public static List<SuperZeroModel> GetSuperZIncidentMatching(HttpServletRequest request, HttpServletResponse response){
        List<SuperZeroModel> SuperZMatchingList = new ArrayList<SuperZeroModel>();
        String incidentToFind = request.getParameter("incident");
        request.setAttribute("incidentDeclared", incidentToFind);
        SuperZConnection superZConnection = new SuperZConnection(_getConnection.getConnection());
        List<SuperZeroModel> listAllSuperZ = superZConnection.GetAllSuperZ();
        for (SuperZeroModel superZ : listAllSuperZ) {
            Boolean match = Arrays.asList(superZ.BusinessIncidents.split(", ")).contains(incidentToFind);
            if(match){
                SuperZMatchingList.add(superZ);
            }
        }
        return SuperZMatchingList;
    }

    //Private Methods
    private void NewIncidentToRegisterInDB(HttpServletRequest request, HttpServletResponse response){
        IncidentForm form = new IncidentForm();
        GetConnection connection = new GetConnection();
        IncidentModel newIncident = form.newIncident(request);
        request.setAttribute("newIncident",newIncident);
        IncidentConnection incidentConnection = new IncidentConnection(connection.getConnection());
        incidentConnection.PostNewIncident(newIncident);
    }

}
