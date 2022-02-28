package com.example.supercesi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/HomeServlet")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String buttonClickOn = request.getParameter("selectButton");
        if(buttonClickOn != null){
            if(buttonClickOn == "incident"){
                request.setAttribute("incident",buttonClickOn);
            } else {
                request.setAttribute("superZ", buttonClickOn);
            }
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/Home.jsp").forward(request, response);

    }
}
