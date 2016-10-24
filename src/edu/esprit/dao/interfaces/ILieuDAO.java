/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

import edu.esprit.dao.entities.Lieu;
import java.util.List;

/**
 *
 * @author esprit
 */
public interface ILieuDAO {
    public boolean ajouterLieu(Lieu lieu);
    public boolean modifierLieu(Lieu lieu);
    public Lieu rechercherLieuById(int id);
    public Lieu rechercherLieuByAdresse(String adresse);
    public int recupererId(String adresse);
    public List<Lieu> afficherLieu(); 
    public boolean supprimerLieu(int id);
    public boolean supprimerLieuByAdresse(String adresse);
    
}
