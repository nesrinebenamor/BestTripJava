/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;
import edu.esprit.dao.entities.Reponse;
import java.util.List;
/**
 *
 * @author Toch
 */
public interface IReponseDAO {
    
    public void ajouterReponse(Reponse reponse);
    public List<Reponse> afficherReponse();
    public void supprimerReponse(int id);
    public void modifierUtilisateur(Reponse reponse,int id);
    public Reponse rechercherReponseById(int id);
    
}
