/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;
import edu.esprit.dao.entities.Reponse;
import edu.esprit.dao.entities.Sujet;
import java.util.List;
import java.util.TreeMap;
/**
 *
 * @author Toch
 */
public interface ISujetDAO {
    
    public void ajouterSujet(Sujet sujet);
    public List<Sujet> afficherSujet();
    public void supprimerSujet(int id);
    public void modifierSujet(Sujet sujet);
    public Sujet rechercherSujetById(int id);
    public Sujet rechercherSujetByNom(String nom);
    public TreeMap<Sujet,Reponse> afficherSujetByReponse();
    public int recupererId(String titre);
    public int supprimerById(String titre);
    public Sujet recupererSujetByTitre(String titre);
    
}
