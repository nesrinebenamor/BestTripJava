/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samsung
 */
public class Experience 
 {
    private int id;
    private String Contenu;
    private String date;
    private double depense;
    private String titre;
    private Utilisateur user;
    private String pays;
    private String type;
    private String climat;
    
    public Experience() {
     

    }

    public Experience(String Contenu, String date, double depense, String titre, Utilisateur user) {
        this.Contenu = Contenu;
        this.date = date;
        this.depense = depense;
        this.titre = titre;
        this.user = user;
    }

    public Experience(String Contenu, String date, double depense, String titre) {
        this.Contenu = Contenu;
        this.date = date;
        this.depense = depense;
        this.titre = titre;
    }
    
    
    public Experience(int id, String Contenu, String date, double depense) {
        this.id = id;
        this.Contenu = Contenu;
        this.date = date;
        this.depense = depense;
        //ListeTexte=new ArrayList<Texte>();
        //ListeVideo=new ArrayList<Video>();
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Experience(int id, String Contenu, String date, double depense, String titre) {
        this.id = id;
        this.Contenu = Contenu;
        this.date = date;
        this.depense = depense;
        this.titre = titre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getDepense() {
        return depense;
    }

    public void setDepense(double depense) {
        this.depense = depense;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClimat() {
        return climat;
    }

    public void setClimat(String climat) {
        this.climat = climat;
    }

    public Experience(int id, String Contenu, String date, double depense, String titre, Utilisateur user, String pays, String type, String climat) {
        this.id = id;
        this.Contenu = Contenu;
        this.date = date;
        this.depense = depense;
        this.titre = titre;
        this.user = user;
        this.pays = pays;
        this.type = type;
        this.climat = climat;
    }

    
    public Experience(int id, String Contenu, String date, double depense, String titre, String pays, String type) {
        this.id = id;
        this.Contenu = Contenu;
        this.date = date;
        this.depense = depense;
        this.titre = titre;
       
        this.pays = pays;
        this.type = type;
    }


    
      public Date convtoDate(String s)
      {
        try {
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(this.date);
            return d;
        } catch (ParseException ex) {
            Logger.getLogger(Experience.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

      }
    
    
}
