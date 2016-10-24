/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

import edu.esprit.dao.entities.Utilisateur;
import java.util.List;

/**
 *
 * @author esprit
 */
public interface IAdministrateurDAO {
    public boolean ajouterAdministrateur(Utilisateur utilisateur);
    public boolean ajouterAdministrateurByNom(String nom);
    public boolean modifierAdministrateur(Utilisateur utilisateur);
    public int recupererId(String login);
    public Utilisateur rechercherAdministrateurById(int id);
    public Utilisateur rechercherAdministrateurByNom(String nom);
    public List<Utilisateur> afficherAdministrateurs(); 
    public boolean supprimerAdministrateur(int id);
    public boolean supprimerAdministrateurByNom(String nom);
    public boolean authenitification(String login, String password);
    public boolean estAdmin(String login);
    
}
