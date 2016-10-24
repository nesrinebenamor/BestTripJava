/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.entities;

/**
 *
 * @author esprit
 */
public class Compagnie extends Recommandation{
    
    private String nom;
    Utilisateur utilisateur;
    
    public Compagnie()
    {
        
    }
    public Compagnie(String nom,String contenu)
    {
       super(contenu);
       this.nom=nom;
    }
     public Compagnie(String nom,String contenu,int nombre)
    {
       super(contenu);
       this.nom=nom;
       nombre++;
    }

    public Compagnie(int id, String contenu,String nom,int nombre,Utilisateur utilisateur) {
        super(id, contenu,nombre,utilisateur);
        this.nom=nom;
    }
    
     public Compagnie(String contenu,String nom,int nombre,Utilisateur utilisateur) {
        super(contenu,nombre,utilisateur);
        this.nom=nom;
    }
    
     public Compagnie(int id, String contenu,String nom) {
        super(id, contenu);
        this.nom=nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Compagnie{"+super.toString() + "nom=" + nom + '}'+" \n ";
    }
    
    
    
}
