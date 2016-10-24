/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.implementations.PhotoDAO;
import edu.esprit.dao.entities.Photo;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Samsung
 */
public class VideoListeModel extends AbstractListModel {

    List<Photo> vid;
    PhotoDAO vidDAO = new PhotoDAO();
    public static String chemin = "";
    static int idVideo;

    public VideoListeModel(int id_experience) {
        vid = vidDAO.afficherPhotoByID(id_experience);
    }

    @Override
    public int getSize() {
        return vid.size();
    }

    @Override
    public Object getElementAt(int index) {
        VideoListeModel.chemin = vid.get(index).getSource();
        VideoListeModel.idVideo=vid.get(index).getId();
        return vid.get(index).getDescription();
    }

}
