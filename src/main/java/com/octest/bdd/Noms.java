package com.octest.bdd;

import com.octest.beans.Utilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Noms {
    private Connection connexion;

    public List<Utilisateur> recupererUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();

        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();

        try {

            statement = connexion.createStatement();
            resultat = statement.executeQuery("select nom,prenom from noms;");

            while (resultat.next()) {
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");

                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setNom(nom);
                utilisateur.setPrenom(prenom);

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }

        return utilisateurs;
    }

    private void loadDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/javaee", "Franck", "Postgres1505");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        loadDatabase();
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("insert into noms (nom,prenom) values(?,?);");
            preparedStatement.setString(1, utilisateur.getNom());
            preparedStatement.setString(2, utilisateur.getPrenom());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
