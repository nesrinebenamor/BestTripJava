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
public class Photo {
    private int id;
    private String description;
    private int taille;
    private String source;
    private Experience exp;

    public Photo(String description, int taille, String source, Experience exp) {
        this.description = description;
        this.taille = taille;
        this.source = source;
        this.exp = exp;
    }

    
    public Photo(int id, String description, int taille, String source, Experience exp) {
        this.id = id;
        this.description = description;
        this.taille = taille;
        this.source = source;
        this.exp = exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Experience getExp() {
        return exp;
    }

    public void setExp(Experience exp) {
        this.exp = exp;
    }

    public Photo() {
    }

    public Photo(int id, String description, int taille, String source) {
        this.id = id;
        this.description = description;
        this.taille = taille;
        this.source = source;
    }

    @Override
    public String toString() {
        return "Photo{" + "id=" + id + ", description=" + description + ", taille=" + taille + ", source=" + source + ", exp=" + exp + '}';
    }

    
}
