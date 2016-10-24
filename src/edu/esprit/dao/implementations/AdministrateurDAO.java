/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.entities.Utilisateur;
import edu.esprit.dao.interfaces.IAdministrateurDAO;
import edu.esprit.dao.technique.MyConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esprit
 */
public class AdministrateurDAO implements IAdministrateurDAO {

    private Connection connection;

    public AdministrateurDAO() {
        try {
            connection = MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean ajouterAdministrateur(Utilisateur utilisateur) {
        boolean test = false;
        String requete = "INSERT INTO `utilisateur`(`EstAdministrateur`, `Nom`, `Prenom`, `Email`,`login`, `password`, `Age`) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setBoolean(1, true);
            ps.setString(2, utilisateur.getNom());
            ps.setString(3, utilisateur.getPrenom());
            ps.setString(4, utilisateur.getMail());
            ps.setString(5, utilisateur.getLogin());
            ps.setString(6, utilisateur.getPassword());
            ps.setInt(7, utilisateur.getAge());
            ps.executeUpdate();
            test = true;
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return test;
    }

    @Override
    public boolean modifierAdministrateur(Utilisateur utilisateur) {
        boolean test = false;
        String requete = "update utilisateur set nom=? , prenom=? , email=? ,login=?,password=?, age=? where id=? and EstAdministrateur=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, utilisateur.getNom());
            ps.setString(2, utilisateur.getPrenom());
            ps.setString(3, utilisateur.getMail());
            ps.setString(4, utilisateur.getLogin());
            ps.setString(5, utilisateur.getPassword());
            ps.setInt(6, utilisateur.getAge());
            ps.setInt(7, utilisateur.getId());
            ps.setBoolean(8, true);
            ps.executeUpdate();
            test = true;
            System.out.println("mise a jour effectuée avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise a jour" + ex.getMessage());
        }
        return test;
    }

    @Override
    public Utilisateur rechercherAdministrateurById(int id) {
        Utilisateur utilisateur = new Utilisateur();
        String requete = "SELECT * FROM `utilisateur` WHERE id=? and EstAdministrateur=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.setBoolean(2, true);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                utilisateur.setNom(resultat.getString("nom"));
                utilisateur.setPrenom(resultat.getString("prenom"));
                utilisateur.setMail(resultat.getString("email"));
                utilisateur.setLogin(resultat.getString("login"));
                utilisateur.setPassword(resultat.getString("password"));
                utilisateur.setAge(resultat.getInt("age"));
            }
            return utilisateur;
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise a jour" + ex.getMessage());
            return null;
        }
    }

    @Override
    public Utilisateur rechercherAdministrateurByNom(String nom) {
        Utilisateur utilisateur = new Utilisateur();
        String requete = "SELECT * FROM `utilisateur` WHERE login=? and EstAdministrateur=1";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, nom);
            //ps.setBoolean(2, true);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                utilisateur.setId(resultat.getInt("Id"));
                utilisateur.setNom(resultat.getString("nom"));
                utilisateur.setPrenom(resultat.getString("prenom"));
                utilisateur.setMail(resultat.getString("email"));
                utilisateur.setLogin(resultat.getString("login"));
                utilisateur.setPassword(resultat.getString("password"));
                utilisateur.setAge(resultat.getInt("age"));
            }
            return utilisateur;
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise a jour" + ex.getMessage());
            return null;
        }
    }

    @Override
    public int recupererId(String login) {
        int id = 0;
        String requete = "SELECT * FROM `utilisateur` WHERE login=? and EstAdministrateur=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, login);
            ps.setBoolean(2, true);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                id = resultat.getInt("Id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise a jour" + ex.getMessage());
        }
        return id;
    }

    @Override
    public List<Utilisateur> afficherAdministrateurs() {
        List<Utilisateur> maliste = new ArrayList<Utilisateur>();
        String requete = "select * from utilisateur where EstAdministrateur=1";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            //ps.setBoolean(1, true);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(resultat.getInt("Id"));
                utilisateur.setNom(resultat.getString("nom"));
                utilisateur.setPrenom(resultat.getString("prenom"));
                utilisateur.setMail(resultat.getString("email"));
                utilisateur.setLogin(resultat.getString("login"));
                utilisateur.setPassword(resultat.getString("password"));
                utilisateur.setAge(resultat.getInt("age"));
                maliste.add(utilisateur);
            }
            return maliste;
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise a jour" + ex.getMessage());
            return null;
        }
    }

    @Override
    public boolean supprimerAdministrateur(int id) {
        boolean test = false;
        String requete = "delete from utilisateur where id=? and EstAdministrateur=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.setBoolean(2, true);
            ps.executeUpdate();
            test = true;
            System.out.println("suppression effectuée avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression" + ex.getMessage());
        }
        return test;
    }

    @Override
    public boolean ajouterAdministrateurByNom(String nom) {
        boolean test = false;
        String requete = "update utilisateur set EstAdministrateur=? where login=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setBoolean(1, true);
            ps.setString(2, nom);
            ps.executeUpdate();
            test = true;
            System.out.println("Administrateur ajouté avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'ajout " + ex.getMessage());
        }
        return test;
    }

    @Override
    public boolean supprimerAdministrateurByNom(String nom) {
        boolean test = false;
        String requete = "update utilisateur set EstAdministrateur=? where login=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setBoolean(1, false);
            ps.setString(2, nom);
            ps.executeUpdate();
            test = true;
            System.out.println("suppression effectuée avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(AdministrateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression" + ex.getMessage());
        }
        return test;
    }

    @Override
    public boolean authenitification(String login, String password) {
        boolean test = false;
        String requete = "select * from utilisateur where EstAdministrateur=?, login=? and password=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setBoolean(1, true);
            ps.setString(2, login);
            ps.setString(3, password);
            ps.executeQuery();
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                System.out.println("login et password sont valides");
                test = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("login et password sont non valides" + ex.getMessage());
        }
        return test;
    }

    @Override
    public boolean estAdmin(String login) {
        boolean test = false;
        Utilisateur utilisateur = new Utilisateur();
        String requete = "select * from utilisateur where login=? and EstAdministrateur is null";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, login);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                test = resultat.getBoolean("EstAdministrateur");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise a jour" + ex.getMessage());
        }
        return test;
    }

}
