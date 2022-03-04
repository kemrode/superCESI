package com.example.supercesi;

import com.example.bdd.GetConnection;
import com.example.bdd.SuperZConnection;
import com.example.beans.SuperZeroModel;
import com.example.forms.ConnectionForm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SuperZeroFormServlet", value = "/SuperZeroFormServlet")
public class SuperZeroFormServlet extends HttpServlet {

    public SuperZeroFormServlet(){
        super();
    }

    private GetConnection _getConnection = new GetConnection();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/SuperZeroForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionForm form = new ConnectionForm();
        //Appel mapbox API pour obtenir Lat et Long en fonction de la ville
        SuperZeroModel superZ = form.newSuperZ(request);
        SuperZConnection superZConnection = new SuperZConnection(_getConnection.getConnection());
        superZConnection.PostNewSuperZ(superZ);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }
}
