/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.implementations.VideoDAO;
import edu.esprit.dao.entities.Video;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Samsung
 */
public class listeModel extends AbstractListModel{
        List<Video> vid;
        VideoDAO vidDAO=new VideoDAO();
        public static String chemin="";
        static int id_photo;


    public listeModel() {
    }



    public listeModel(int id_experience) {
        vid=vidDAO.afficherVidByID(id_experience);
        
    }
        
    @Override
    public int getSize() {
        return vid.size();
    }

    @Override
    public Object getElementAt(int index) {
        listeModel.chemin="C:/wamp/www/integration/symphony/ProjetBestTrip/web/uploads/photos/" + vid.get(index).getSource();
        id_photo=vid.get(index).getId();
       return vid.get(index).getExtension();
    }
    
}
