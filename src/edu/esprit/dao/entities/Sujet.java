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
public class Sujet implements Comparable<Sujet>{
    private int id;
    private String titre;
    private String text;
    private String reponse;
    private Utilisateur utilisateur;
    
    public Sujet()
            {
        
    }

    public Sujet(String titre, String text) {
        
        this.titre = titre;
        this.text = text;
    }
    
    public Sujet(int id,String titre, String text) {
        this.id=id;
        this.titre = titre;
        this.text = text;
    }
    
    public Sujet(int id,String titre, String text,Utilisateur utilisateur) {
        this.id=id;
        this.titre = titre;
        this.text = text;
        this.utilisateur=utilisateur;
    }
    
  
    
    public Sujet(String titre, String text,Utilisateur utilisateur) {
        this.titre = titre;
        this.text = text;
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
       // return "Sujet{" + "id=" + id + ", titre=" + titre + ", text=" + text + '}';
    return titre+text;
    }

    @Override
    public int compareTo(Sujet t) {
return this.getId()-t.getId();
    }
    
    
}
