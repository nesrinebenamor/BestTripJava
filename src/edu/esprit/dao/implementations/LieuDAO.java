/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.entities.Lieu;
import edu.esprit.dao.entities.Recommandation;
import edu.esprit.dao.interfaces.ILieuDAO;
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
 * @author esprit
 */
public class LieuDAO implements ILieuDAO{
    private Connection connection;
     
     public LieuDAO()
    {
        try {
            connection=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(LieuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public boolean ajouterLieu(Lieu lieu) {
        boolean test=false;
 String requete="INSERT INTO `recommandation`(`contenu`, `EstCompagnie`,`Nom`,`Adresse`,`Nombre`,`Id_utilisateur`) VALUES (?,?,?,?,?,?)";      
 try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,lieu.getContenu());
       ps.setBoolean(2,false);
       ps.setString(3, null);
       ps.setString(4,lieu.getAdresse());
       ps.setInt(5,lieu.getNombre());
       ps.setInt(6, lieu.getUtilisateur().getId());
       ps.executeUpdate();
       test=true;
       } catch(SQLException ex)
       {
          Logger.getLogger(LieuDAO.class.getName()).log(Level.SEVERE,null,ex);
       }       
        return test;
    }

    @Override
    public boolean modifierLieu(Lieu lieu) {
        boolean test=false;
String requete="UPDATE `recommandation` SET `contenu`=?,`Adresse`=?,`Nombre`=? ,Id_utilisateur=? WHERE Id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, lieu.getContenu());
       ps.setString(2, lieu.getAdresse());
       ps.setInt(3,lieu.nombre);
       ps.setInt(4,lieu.getUtilisateur().getId());
       ps.setInt(5, lieu.getId());
       ps.executeUpdate();
      test=true;
           System.out.println("mise a jour effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(LieuDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
       return test;
    }

    @Override
    public Lieu rechercherLieuById(int id) {
Lieu lieu=new Lieu();
        String requete="SELECT * FROM recommandation WHERE EstCompagnie=? and Id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setBoolean(1,false);
      ps.setInt(2,id);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               lieu.setId(resultat.getInt("Id"));
               lieu.setAdresse(resultat.getString("Adresse"));
               lieu.setContenu(resultat.getString("Contenu"));
               lieu.setNombre(resultat.getInt("Nombre"));
           }
           return lieu;
       } catch(SQLException ex)
       {
          Logger.getLogger(LieuDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }

    @Override
    public Lieu rechercherLieuByAdresse(String adresse) {
Lieu lieu=new Lieu();
        String requete="SELECT * FROM recommandation WHERE EstCompagnie=? and Adresse=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setBoolean(1,false);
      ps.setString(2,adresse);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               lieu.setId(resultat.getInt("Id"));
               lieu.setAdresse(resultat.getString("Adresse"));
               lieu.setContenu(resultat.getString("contenu"));
               lieu.setNombre(resultat.getInt("Nombre"));
           }
           return lieu;
       } catch(SQLException ex)
       {
          Logger.getLogger(LieuDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }

    @Override
    public List<Lieu> afficherLieu() {
List<Lieu> maliste=new ArrayList<Lieu>();
         String requete="select * from recommandation where EstCompagnie=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setBoolean(1, false);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               Lieu lieu=new Lieu();
               lieu.setId(resultat.getInt("id"));
               lieu.setAdresse(resultat.getString("Adresse"));
               lieu.setContenu(resultat.getString("Contenu"));
               lieu.setNombre(resultat.getInt("Nombre"));
             
              maliste.add(lieu);
           }
           return maliste;
       } catch(SQLException ex)
       {
          Logger.getLogger(LieuDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }

    @Override
    public boolean supprimerLieu(int id) {
        boolean test=false;
String requete="delete from recommandation where EstCompagnie=? and id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setBoolean(1, false);
       ps.setInt(2, id);
       ps.executeUpdate();
       test=true;
           System.out.println("suppression effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(LieuDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la suppression"+ex.getMessage());
       }
       return test;
    }
    
    @Override
    public int recupererId(String adresse) {
        int id=0;
        String requete="SELECT * FROM recommandation WHERE EstCompagnie=? and Adresse=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setBoolean(1,true);
      ps.setString(2,adresse);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
            id=resultat.getInt("Id");
           }
       } catch(SQLException ex)
       {
          Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
        return id;
    }
    
    @Override
    public boolean supprimerLieuByAdresse(String adresse) {
        boolean test=false;
String requete="delete from recommandation where EstCompagnie=? and adresse=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setBoolean(1, false);
       ps.setString(2,adresse );
       ps.executeUpdate();
       test=true;
           System.out.println("suppression effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(LieuDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la suppression"+ex.getMessage());
       }
       return test;
    }
    }
    
