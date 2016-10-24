/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

/**
 *
 * @author zamama
 */
import edu.esprit.dao.entities.Newsletter;
import java.util.List;

/**
 *
 * @author esprit
 */
public interface INewsletterDAO {
    
    public void ajouterNewsletter(Newsletter newsletter);
    public void modifierNewsletter(Newsletter newsletter,int id);
    public Newsletter rechercherNewsletterById(int id);
    public Newsletter rechercherNewsletterBycontenu(String contenu);
    public List<Newsletter> afficherNewsletters(); 
    public List<Newsletter> afficherNewslettersByNom(String nom);
    public void supprimerNewsletter(int id);
    public void supprimerNewsletterByNom(String nom);
    
}
