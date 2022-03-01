package com.example.supercesi;

import com.example.bdd.SuperZConnection;
import com.example.beans.SuperZeroModel;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SuperZConnection connectionBDD = new SuperZConnection();
        List<SuperZeroModel> list = connectionBDD.GetAllSuperZ();
        request.setAttribute("list",list);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedChoice = request.getParameter("selectedButton");
        request.setAttribute("selectedButton", selectedChoice);

        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);

    }
}
