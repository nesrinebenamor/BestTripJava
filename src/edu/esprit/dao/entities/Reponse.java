/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.entities;

/**
 *
 * @author Toch
 */
public class Reponse {
    private int id;
    private String contenu;
    private  Sujet sujet;
    
    
    public Reponse()
            {
        
    }
    public Reponse(String contenu) {
        this.contenu = contenu;
       
    }

    public Reponse(int id, String contenu) {
        this.id = id;
        this.contenu = contenu;
       
    }
    public Reponse(String contenu,Sujet sujet) {
        this.contenu = contenu;
        this.sujet=sujet;
       
    }

    public Sujet getSujet() {
        return sujet;
    }

    public void setSujet(Sujet sujet) {
        this.sujet = sujet;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    

    @Override
    public String toString() {
      //  return "Sujet{" + "id=" + id + ", contenu=" + contenu + ", date=" + date + '}';
    return contenu;
    }
    
    
}
