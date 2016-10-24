/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.entities;

/**
 *
 * @author zamama
 */


public class Newsletter {
    
    private int id;
    private String contenu;
    private  String date;
    private String nom;
    
    public Newsletter(){}

    public Newsletter(String contenu,String date) {
        this.contenu = contenu;
        this.date = date;
        this.nom=nom;
        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcontenu() {
        return contenu;
    }

    public void setcontenu(String contenu) {
        this.contenu = contenu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
     public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }

   

    @Override
    public String toString() {
        return "Newsletter{" + "contenu=" + contenu + ", date=" + date + "nom" + nom + '}';
    }
    
    
    
    
}
