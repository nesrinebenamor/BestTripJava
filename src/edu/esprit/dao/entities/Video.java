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
public class Video {
    
    private int id;
    private String extension;
    private int taille;
    private String source;
    private Experience exp;

    public Video(String extension, int taille, String source, Experience exp) {
        this.extension = extension;
        this.taille = taille;
        this.source = source;
        this.exp = exp;
    }

    
    public Video(int id, String extension, int taille, String source, Experience exp) {
        this.id = id;
        this.extension = extension;
        this.taille = taille;
        this.source = source;
        this.exp = exp;
    }
    
    
    public Experience getExp() {
        return exp;
    }

    public void setExp(Experience exp) {
        this.exp = exp;
    }
    
    public Video() {
    }

    public Video(int id, String extension, int taille, String source) {
        this.id = id;
        this.extension = extension;
        this.taille = taille;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
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

    @Override
    public String toString() {
        return "Video{" + "id=" + id + ", extension=" + extension + ", taille=" + taille + ", source=" + source + ", exp=" + exp + '}';
    }

   
    
    
    
}
