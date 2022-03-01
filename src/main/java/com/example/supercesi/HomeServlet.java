package com.example.supercesi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String selectedChoise = "";
//        request.setAttribute("selectedChoice",selectedChoise);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedChoice = request.getParameter("selectedButton");
        request.setAttribute("selectedButton", selectedChoice);

        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);

    }
}
