/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.interfaces.IVideoDAO;
import edu.esprit.dao.entities.Experience;
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
public class VideoDAO implements IVideoDAO{
private Connection cnx;

    public VideoDAO() {
                try {
            cnx=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(TexteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public boolean ajouterVideo(Video vid) {
        boolean test=false;
        String requete="insert into video(extension,taille,source,Id_experience) values(?,?,?,?)";
        try {         
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1,vid.getExtension());
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
    public boolean modifVideo(Video vid) {
        boolean test=false;
        String requete="UPDATE video SET  extension =? , taille =? , source =?,Id_experience=? WHERE  Id =?";
        try {         
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1,vid.getExtension());
            ps.setInt(2,vid.getTaille());
            ps.setString(3,vid.getSource());
            ps.setInt(4,vid.getExp().getId());
            ps.setInt(5,vid.getId());
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
    public List<Video> affichTexte() 
    {
         List <Video> listeVideo=new ArrayList <>();
         String requete="select * from video";
         ExperiencesDAO expDAO = new ExperiencesDAO();
         Experience exp=new Experience();
       try
       {
          PreparedStatement ps = cnx.prepareStatement(requete);      
          ResultSet res=ps.executeQuery();
           while(res.next())
           {
               exp=expDAO.cherchExperienceById(res.getInt("Id_experience"));
               listeVideo.add(new Video(res.getInt("Id"), res.getString("extension"),res.getInt("taille"),res.getString("source"),exp));
               
           }
           return listeVideo;
       } catch(SQLException ex)
       {
          ex.printStackTrace();
           return null;
       }    
    }

    @Override
    public boolean suppVideo(int id) 
    {
         boolean test=false;
         String requete="delete from video where Id=?";
         
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
    public Video cherchVideoById(int id) 
      {
       String requete="select * from video where Id=?";
       try
       {
       PreparedStatement ps = cnx.prepareStatement(requete);
       ps.setInt(1,id);
       ResultSet res=ps.executeQuery();    
       Video vid=new Video();
           while(res.next())
           {
               vid = new Video(res.getInt("Id"), res.getString("extension"),res.getInt("taille"),res.getString("source"));
               
           }
           return vid;
       } catch(SQLException ex)
       {
          ex.printStackTrace();
           return null;
       }    
      }

    @Override
    public List<Video> afficherVidByID(int id) {
        List <Video> listeVideo=new ArrayList <>();
         String requete="select * from video where Id_experience=?";
         ExperiencesDAO expDAO = new ExperiencesDAO();
         Experience exp=new Experience();
       try
       {
       PreparedStatement ps = cnx.prepareStatement(requete);
       ps.setInt(1,id);
       ResultSet res=ps.executeQuery();
           while(res.next())
           {
               exp=expDAO.cherchExperienceById(res.getInt("Id_experience"));
               listeVideo.add(new Video(res.getInt("Id"), res.getString("extension"), res.getInt("taille"), res.getString("source"), exp));
               
           }
           return listeVideo;
       } catch(SQLException ex)
       {
          ex.printStackTrace();
           return null;
       }
    }
    
}
