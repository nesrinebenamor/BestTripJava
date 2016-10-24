/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.entities.Reponse;
//import edu.esprit.dao.interfaces.IReponseDAO;
import edu.esprit.dao.technique.MyConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toch
 */
public class ReponseDAO {
    
    private Connection connection;

     public ReponseDAO()
    {
        try {
            connection=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(ReponseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     public void ajouterReponse(Reponse reponse) {
 String requete="INSERT INTO `reponse`(`contenu`,`id_sujet`) VALUES (?,?)";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,reponse.getContenu());
       
       ps.setInt(2,reponse.getSujet().getId());
       
       //String chaine=reponse.getDate();
       /*
       //java.util.Date date = new java.util.Date();
       Date date = new SimpleDateFormat("dd/MM/yyyy").parse(chaine);
       java.sql.Date sqlDate = new java.sql.Date(date.getTime());
       ps.setDate(2,sqlDate);*/
       
       ps.executeUpdate();
       } catch(SQLException ex)
       {
         Logger.getLogger(ReponseDAO.class.getName()).log(Level.SEVERE,null,ex);
       }
    }
     
     public List<Reponse> afficherReponse(int id_sujet) {
        List<Reponse> maliste=new ArrayList<Reponse>();
         String requete="select * from reponse where id_sujet=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      
      ps.setInt(1,id_sujet);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               Reponse reponse=new Reponse();
               reponse.setContenu(resultat.getString("contenu"));
              //reponse.setDate(resultat.getString("date"));
              
              maliste.add(reponse);
           }
           return maliste;
       } catch(SQLException ex)
       {
         Logger.getLogger(ReponseDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }
     
     public void supprimerReponse(int id) {
        String requete="delete from reponse where id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setInt(1, id);
       ps.executeUpdate();
           System.out.println("suppression effectuée avec succès");
       } catch(SQLException ex)
       {
           System.out.println("erreur lors de la suppression"+ex.getMessage());
       }
    }
     
     public void modifierReponse(Reponse reponse) {
String requete="update reponse set contenu=? where id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, reponse.getContenu());
       //ps.setString(2, reponse.getDate());
       //ps.setInt(2, id);
       ps.executeUpdate();
           System.out.println("mise a jour effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(ReponseDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
        
    }
     
     public Reponse rechercherReponseById(int id) {
          Reponse reponse=new Reponse();
        String requete="SELECT * FROM `reponse` WHERE id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setInt(1,id);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               reponse.setContenu(resultat.getString("contenu"));
               //reponse.setDate(resultat.getString("date"));
               
           }
           return reponse;
       } catch(SQLException ex)
       {
          Logger.getLogger(ReponseDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
       
    }
     
    
    
}
