/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

import edu.esprit.dao.entities.Compagnie;
import java.util.List;

/**
 *
 * @author esprit
 */
public interface ICompagnieDAO {
    public boolean ajouterCompagnie(Compagnie compagnie);
    public boolean modifierCompagnie(Compagnie compagnie);
    public Compagnie rechercherCompagnieById(int id);
    public Compagnie rechercherCompagnieByNom(String nom);
    public int recupererId(String nom);
    public List<Compagnie> afficherCompagnies(); 
    public boolean supprimerCompagnie(int id);
    public boolean supprimerCompagnieByNom(String nom);
    
}
