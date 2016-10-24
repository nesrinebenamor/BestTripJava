/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

import edu.esprit.dao.entities.Texte;
import edu.esprit.dao.entities.Video;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface IVideoDAO {
    public boolean ajouterVideo(Video vid);
    public boolean modifVideo(Video vid);
    public List<Video> affichTexte();
    public boolean suppVideo(int id);
    public Video cherchVideoById(int id);
     public List<Video> afficherVidByID(int id);
}
