package com.octest.servlets;

import com.octest.beans.Auteur;
import com.octest.forms.ConnectionForm;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Test", value = "/Test")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies !=null) {
            for (Cookie cookie: cookies) {
                if(cookie.getName().equals("prenom")) {
                    request.setAttribute("prenom", cookie.getValue());
                }
            }
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nom = request.getParameter("nom");
    String prenom = request.getParameter("prenom");

    response.addCookie(new Cookie("prenom", prenom));

    HttpSession session = request.getSession();
    session.setAttribute("nom", nom);
    session.setAttribute("prenom", prenom);


    this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }
}
