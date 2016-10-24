/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

import edu.esprit.dao.entities.Guide;
import java.util.List;

/**
 *
 * @author ACER
 */
public interface IGuideDAO {
     public void ajouterguide(Guide g);
    public void modifierguide(Guide g);
    public Guide rechercherguideByNom(String nom);
    public List<Guide> afficherguide(); 
    public void supprimerguide( String nom);
    public int recupererID(String nom);
}
