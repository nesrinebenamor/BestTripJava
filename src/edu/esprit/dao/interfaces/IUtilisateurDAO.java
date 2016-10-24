/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

import edu.esprit.dao.entities.Recommandation;
import edu.esprit.dao.entities.Compagnie;
import edu.esprit.dao.entities.Lieu;
import edu.esprit.dao.entities.Utilisateur;
import java.util.List;

/**
 *
 * @author esprit
 */
public interface IUtilisateurDAO {
    
    public boolean ajouterUtilisateur(Utilisateur utilisateur);
    public boolean modifierUtilisateur(Utilisateur utilisateur);
    public Utilisateur rechercherUtilisateurById(int id);
    public Utilisateur rechercherUtilisateurByNom(String nom);
    public Utilisateur rechercherUtilisateurByLogin(String login);
    public List<Utilisateur> afficherUtilisateurByNom(String nom);
    public List<Utilisateur> afficherUtilisateurs(); 
    public boolean supprimerUtilisateur(int id);
    public boolean supprimerUtilisateurByNom(String nom);
    public boolean ajouterRecommandation(Recommandation recommandation);
     public boolean modifierRecommandation(Recommandation recommandation);
    public Recommandation rechercherRecommandation(Recommandation recommandation);
    public List<Compagnie> afficherCompagnies(); 
    public List<Lieu> afficherLieux();
    public boolean supprimerRecommandation(Recommandation recommandation);
    public boolean authenitification(String login,String password);
    public int RecupererId(String login);
    public boolean estAdmin(String login);
    public String recupererEmailByLogin(String login);
    public String recupererPasswordByLogin(String login);
    public Utilisateur selectUserByMail(String mail);
    public int insertUser(Utilisateur u);
    public boolean verifierExistance(String mail);
    
    
}
