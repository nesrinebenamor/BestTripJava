/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.tests;

import edu.esprit.dao.entities.Utilisateur;
import edu.esprit.dao.implementations.AdministrateurDAO;
import edu.esprit.dao.implementations.UtilisateurDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esprit
 */
public class TestUtilisateurDAO {
    
    public static void main(String[] args) {
        Utilisateur utilisateur=new Utilisateur();
        utilisateur.setNom("user1");
        utilisateur.setPrenom("user");
        utilisateur.setLogin("login1");
        utilisateur.setPassword("pass1");
        utilisateur.setAge(13);
        utilisateur.setMail("user.user1@esprit.tn");
        
        Utilisateur utilisateur2=new Utilisateur();
        utilisateur2.setNom("administrateur");
        utilisateur2.setLogin("login2");
        utilisateur2.setPrenom("admin");
        utilisateur2.setAge(26);
        utilisateur2.setPassword("pass2");
        utilisateur2.setMail("admini.administrateur@esprit.tn");
        
        
    
    UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
    //utilisateurDAO.ajouterUtilisateur(utilisateur);
    System.out.println(utilisateur);
    utilisateurDAO.modifierUtilisateur(utilisateur2);
    System.out.println("le nouveau"+utilisateur);
    utilisateurDAO.afficherUtilisateurs();
    
    AdministrateurDAO administrateurDAO = new AdministrateurDAO();
    //administrateurDAO.ajouterAdministrateur(utilisateur2);
    administrateurDAO.afficherAdministrateurs();
    
    List<Utilisateur> mesutilisateurs=new ArrayList<Utilisateur>();
    List<Utilisateur> mesadministrateurs=new ArrayList<Utilisateur>();
        
    mesutilisateurs=utilisateurDAO.afficherUtilisateurs();
    mesadministrateurs=administrateurDAO.afficherAdministrateurs();
        /*System.out.println("La liste des utilisateurs : \n");
        System.out.println(mesutilisateurs);
        System.out.println(" \n ");
        System.out.println("La liste des administrateurs : \n");
        System.out.println(mesadministrateurs);
        System.out.println(" \n ");    */
        
        
        
    }
    
}
