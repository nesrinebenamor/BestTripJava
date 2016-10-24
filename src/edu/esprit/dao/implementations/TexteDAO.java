/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.interfaces.ITexteDAO;
import edu.esprit.dao.entities.Experience;
import edu.esprit.dao.entities.Texte;
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
public class TexteDAO implements ITexteDAO
{
    private Connection cnx;

    public TexteDAO() {
        try {
            cnx=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(TexteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public boolean ajouterTexte(Texte text) 
    {
        boolean test=false;
        String requete="insert into texte(Contenu,Id_experience) values(?,?)";
        try {         
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1,text.getContenu());
            ps.setInt(2,text.getExp().getId());        
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
    public boolean modifTexte(Texte text) {
       boolean test=false;
        String requete="update texte set Contenu=?, Id_experience=? where id=?";     
        try {         
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1,text.getContenu());
            ps.setInt(2,text.getExp().getId());
            ps.setInt(3,text.getId());
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
    public List<Texte> afficherTexteByID(int id)
    {
       List <Texte> listeTexte=new ArrayList <>();
         String requete="select * from Texte where Id_experience=?";
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
               listeTexte.add(new Texte(res.getInt("Id"), res.getString("Contenu"),exp));
               
           }
           return listeTexte;
       } catch(SQLException ex)
       {
          ex.printStackTrace();
           return null;
       }
    }
    @Override
    public List<Texte> affichTexte() 
    {
         List <Texte> listeTexte=new ArrayList <>();
         String requete="select * from Texte";
         ExperiencesDAO expDAO = new ExperiencesDAO();
         Experience exp=new Experience();
       try
       {
       PreparedStatement ps = cnx.prepareStatement(requete);      
       ResultSet res=ps.executeQuery();
           while(res.next())
           {
               exp=expDAO.cherchExperienceById(res.getInt("Id_experience"));
               listeTexte.add(new Texte(res.getInt("Id"), res.getString("Contenu"),exp));
               
           }
           return listeTexte;
       } catch(SQLException ex)
       {
          ex.printStackTrace();
           return null;
       }
    }

    @Override
    public boolean suppTexte(int id) {
         
         boolean test=false;
         String requete="delete from texte where id=?";
         
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
    public Texte cherchTexteById(int id) {
         String requete="select * from Texte where id=?";
         ExperiencesDAO expDAO = new ExperiencesDAO();
         Experience exp=new Experience();
       try
       {
       PreparedStatement ps = cnx.prepareStatement(requete);
       ps.setInt(1,id);
       ResultSet res=ps.executeQuery();   
       Texte texte=new Texte();
           while(res.next())
           {
               exp=expDAO.cherchExperienceById(res.getInt("Id_experience"));
               texte = new Texte(res.getInt("Id"), res.getString("Contenu"),exp);
               
           }
           return texte;
       } catch(SQLException ex)
       {
          ex.printStackTrace();
           return null;
       }
    }

}
