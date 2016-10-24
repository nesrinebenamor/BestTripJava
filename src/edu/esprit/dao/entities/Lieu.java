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
public class Lieu extends Recommandation{
    
    private String adresse;
    Utilisateur utilisateur;
    
    public Lieu(){
        
    }
    
    public Lieu(String adresse,String contenu)
    {
        super(contenu);
        this.adresse=adresse;
    }
    
     public Lieu(String adresse,String contenu,int nombre)
    {
        super(contenu);
        this.adresse=adresse;
        nombre++;
    }
    
    public Lieu(int id,String contenu,String adresse)
    {
        super(id,contenu);
        this.adresse=adresse;
    }
    
    public Lieu(int id,String contenu,String adresse,int nombre)
    {
        super(id,contenu,nombre);
        this.adresse=adresse;
    }
    
     public Lieu(int id,String contenu,String adresse,int nombre,Utilisateur utilisateur)
    {
        super(id,contenu,nombre,utilisateur);
        this.adresse=adresse;
    }
     
      public Lieu(String contenu,String adresse,int nombre,Utilisateur utilisateur)
    {
        super(contenu,nombre,utilisateur);
        this.adresse=adresse;
    }
    
    public String getAdresse()
    {
        return adresse;
    }
    
    public void setAdresse(String adresse)
    {
        this.adresse=adresse;
    }

    @Override
    public String toString() {
        return "Lieu{" +super.toString() +"adresse=" + adresse + '}'+" \n ";
    }
    
    
    
}
