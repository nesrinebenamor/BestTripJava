/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;
import edu.esprit.dao.entities.Texte;
import java.util.List;
/**
 *
 * @author Samsung
 */
public interface ITexteDAO {
    
    public boolean ajouterTexte(Texte text);
    public boolean modifTexte(Texte depot);
    public List<Texte> affichTexte();
    public boolean suppTexte(int id);
    public Texte cherchTexteById(int id);
     public List<Texte> afficherTexteByID(int id);
}
