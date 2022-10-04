package com.octest.servlets;

import com.octest.bdd.Noms;
import com.octest.beans.Utilisateur;
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
        Noms tableNoms = new Noms();
        request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());

        this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nom = request.getParameter("nom");
    String prenom = request.getParameter("prenom");

    Utilisateur utilisateur = new Utilisateur();
    utilisateur.setNom(nom);
    utilisateur.setPrenom(prenom);

    Noms tableNoms = new Noms();
    tableNoms.ajouterUtilisateur(utilisateur);

    request.setAttribute("utilisateurs", tableNoms.recupererUtilisateurs());

    this.getServletContext().getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request, response);
    }
}
