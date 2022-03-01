package com.example.supercesi;

import com.example.beans.SuperZeroModel;
import com.example.forms.ConnectionForm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "SuperZeroFormServlet", value = "/SuperZeroFormServlet")
public class SuperZeroFormServlet extends HttpServlet {

    public SuperZeroFormServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/SuperZeroForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionForm form = new ConnectionForm();
        form.newSuperZ(request);
        request.setAttribute("form",form);
        this.getServletContext().getRequestDispatcher("/WEB-INF/SuperZeroForm.jsp").forward(request, response);
    }
}
