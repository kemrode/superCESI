package com.example.supercesi;

import com.example.bdd.GetConnection;
import com.example.bdd.SuperZConnection;
import com.example.beans.SuperZeroModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.supercesi.MapServlet.GetAllIncidents;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {

    //Constructor
    public HomeServlet(){
        super();
    }
    public static GetConnection _getConnection = new GetConnection();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetSuperZDisplaying(request, response);
        GetAllIncidents(request, response);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SelectionForm(request);
        SelectionLocationMethod(request);
        GetSuperZDisplaying(request, response);
        GetAllIncidents(request, response);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    //Public Methods
    public static void GetSuperZDisplaying(HttpServletRequest request, HttpServletResponse response){
        SuperZConnection connectionBDD = new SuperZConnection(_getConnection.getConnection());
        ArrayList<SuperZeroModel> list = connectionBDD.GetAllSuperZ();
        request.setAttribute("list",list);
    }

    //Private Methods
    private void SelectionForm(HttpServletRequest request){
        String selectedChoice = request.getParameter("selectedButton");
        request.setAttribute("selectedButton", selectedChoice);
    }
    private void SelectionLocationMethod(HttpServletRequest request){
        String locationMethod = request.getParameter("myPosit");
        request.setAttribute("locationMethod", locationMethod);
    }
}
