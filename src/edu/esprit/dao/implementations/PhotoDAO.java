/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.interfaces.IPhotoDAO;
import edu.esprit.dao.entities.Experience;
import edu.esprit.dao.entities.Photo;
import edu.esprit.dao.entities.Video;
import edu.esprit.dao.technique.MyConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samsung
 */
public class PhotoDAO implements IPhotoDAO{
  private Connection cnx;

    public PhotoDAO() {
                try {
            cnx=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(TexteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
  
    @Override
    public boolean ajouterPhoto(Photo vid) {
        boolean test=false;
        String requete="insert into photo(description,taille,source,id_experience) values(?,?,?,?)";
        try {         
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1,vid.getDescription());
            ps.setInt(2,vid.getTaille());
            ps.setString(3,vid.getSource());
            ps.setInt(4,vid.getExp().getId());
            if(ps.executeUpdate()>0)
              test=true;
            System.out.println("ajout effectué");
            return test;
        } catch (SQLException ex) {
           ex.printStackTrace();
           return false;
        }
    }

    @Override
    public boolean modifPhoto(Photo ph) {
        boolean test=false;
        String requete="UPDATE video SET  extension =? , taille =? , source =?,id_experience=? WHERE  Id =?";
        try {         
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1,ph.getDescription());
            ps.setInt(2,ph.getTaille());
            ps.setString(3,ph.getSource());
            ps.setInt(4,ph.getExp().getId());
            ps.setInt(5,ph.getId());
            if(ps.executeUpdate()>0)
              test=true;
            System.out.println("modification effectué");
            return test;
        } catch (SQLException ex) {
           ex.printStackTrace();
           return false;
        }    
    }

    @Override
    public List<Photo> affichPhoto() {
        List <Photo> listePhoto=new ArrayList <>();
         String requete="select * from photo";
         ExperiencesDAO expDAO = new ExperiencesDAO();
         Experience exp=new Experience();
       try
       {
          PreparedStatement ps = cnx.prepareStatement(requete);      
          ResultSet res=ps.executeQuery();
           while(res.next())
           {
               exp=expDAO.cherchExperienceById(res.getInt("id_experience"));
               listePhoto.add(new Photo(res.getInt("Id"), res.getString("description"),res.getInt("taille"),res.getString("source"),exp));
               
           }
           return listePhoto;
       } catch(SQLException ex)
       {
          ex.printStackTrace();
           return null;
       }    
    }

    @Override
    public boolean suppPhoto(int id) {
         boolean test=false;
         String requete="delete from photo where Id=?";
         
         try {         
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1,id);
            if(ps.executeUpdate()>0)
              test=true;
            System.out.println("suppression effectué");
            return test;
        } catch (SQLException ex) {
           ex.printStackTrace();
           return false;
        }    
    }

    @Override
    public Photo cherchPhotoById(int id) {
               String requete="select * from photo where Id=?";
       try
       {
       PreparedStatement ps = cnx.prepareStatement(requete);
       ps.setInt(1,id);
       ResultSet res=ps.executeQuery();    
       Photo ph=new Photo();
           while(res.next())
           {
               ph = new Photo(res.getInt("Id"), res.getString("description"),res.getInt("taille"),res.getString("source"));
               
           }
           return ph;
       } catch(SQLException ex)
       {
          ex.printStackTrace();
           return null;
       }   
    }

    @Override
    public List<Photo> afficherPhotoByID(int id) {
    
    List <Photo> listePhoto=new ArrayList <>();
         String requete="select * from photo where id_experience=?";
         ExperiencesDAO expDAO = new ExperiencesDAO();
         Experience exp=new Experience();
       try
       {
       PreparedStatement ps = cnx.prepareStatement(requete);
       ps.setInt(1,id);
       ResultSet res=ps.executeQuery();
           while(res.next())
           {
               exp=expDAO.cherchExperienceById(res.getInt("id_experience"));
               listePhoto.add(new Photo(res.getInt("Id"), res.getString("description"), res.getInt("taille"), res.getString("source"), exp));
               
           }
           return listePhoto;
       } catch(SQLException ex)
       {
          ex.printStackTrace();
           return null;
       }
    }
    
}
