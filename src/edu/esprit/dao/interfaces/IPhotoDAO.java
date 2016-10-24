/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

import edu.esprit.dao.entities.Photo;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface IPhotoDAO {
     public boolean ajouterPhoto(Photo vid);
    public boolean modifPhoto(Photo vid);
    public List<Photo> affichPhoto();
    public boolean suppPhoto(int id);
    public Photo cherchPhotoById(int id);
     public List<Photo> afficherPhotoByID(int id);
}
