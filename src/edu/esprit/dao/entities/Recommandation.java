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
public class Recommandation {
    private int id;
    private String contenu;
    public int nombre;
    Utilisateur utilisateur;
    
    public Recommandation(){
        
    }
    
    public Recommandation(String contenu)
    {
        this.contenu=contenu;
    }

    public Recommandation(int id, String contenu) {
        this.id = id;
        this.contenu = contenu;
    }
    
    public Recommandation(int id, String contenu,int nombre) {
        this.id = id;
        this.contenu = contenu;
        this.nombre=nombre;
    }
    
     public Recommandation(int id, String contenu,int nombre,Utilisateur utilisateur) {
        this.id = id;
        this.contenu = contenu;
        this.nombre=nombre;
        this.utilisateur=utilisateur;
     }
     
      public Recommandation(String contenu,int nombre,Utilisateur utilisateur) {
        this.contenu = contenu;
        this.nombre=nombre;
        this.utilisateur=utilisateur;
     }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Recommandation{" + "id=" + id + ", contenu=" + contenu + '}';
    }
        
}
