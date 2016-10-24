/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.entities;

/**
 *
 * @author Samsung
 */
public class Texte {
    private int Id;
    private String Contenu;
    private Experience exp;
    
    public Texte() {
    }

    public Texte(int Id, String Contenu) {
        this.Id = Id;
        this.Contenu = Contenu;
    }

    public Texte(int Id, String Contenu,Experience exp) 
    {
        this.Id = Id;
        this.Contenu = Contenu;
        this.exp=exp;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public Experience getExp() {
        return exp;
    }

    public void setExp(Experience exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "Texte{" + "Id=" + Id + ", Contenu=" + Contenu + ", exp=" + exp + '}';
    }

  
   
    
    
}
