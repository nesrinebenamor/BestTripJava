/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.entities.Compagnie;
import edu.esprit.dao.entities.Recommandation;
import edu.esprit.dao.interfaces.ICompagnieDAO;
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
public class CompagnieDAO implements ICompagnieDAO{
    
     private Connection connection;
     
     public CompagnieDAO()
    {
        try {
            connection=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean ajouterCompagnie(Compagnie compagnie) {
        boolean test=false;
 String requete="INSERT INTO `recommandation`(`contenu`,`EstCompagnie`,`Nom`,`Adresse`,`Nombre`,`Id_utilisateur`) VALUES (?,?,?,?,?,?)";      
 try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,compagnie.getContenu());
       ps.setBoolean(2,true);
       ps.setString(3,compagnie.getNom());
       ps.setString(4,null);
       ps.setInt(5,compagnie.nombre);
       ps.setInt(6,compagnie.getUtilisateur().getId());
       ps.executeUpdate();
       test=true;     
       } catch(SQLException ex)
       {
          Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE,null,ex);
       }
 return test;
    }

    @Override
    public boolean modifierCompagnie(Compagnie compagnie) {
        boolean test=false;
String requete="UPDATE `recommandation` SET `contenu`=?,`Nom`=? ,`Nombre`=?,Id_utilisateur=? WHERE Id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, compagnie.getContenu());
       ps.setString(2, compagnie.getNom());
       ps.setInt(3,compagnie.nombre);
       ps.setInt(4,compagnie.getUtilisateur().getId());
       ps.setInt(5, compagnie.getId());
       ps.executeUpdate();
       test=true;
           System.out.println("mise a jour effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
        return test;
    }

    @Override
    public Compagnie rechercherCompagnieById(int id) {
         Compagnie compagnie=new Compagnie();
        String requete="SELECT * FROM recommandation WHERE EstCompagnie=? and Id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setBoolean(1,true);
      ps.setInt(2,id);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               compagnie.setId(resultat.getInt("Id"));
               compagnie.setContenu(resultat.getString("Contenu"));
               compagnie.setNom(resultat.getString("Nom"));
               compagnie.setNombre(resultat.getInt("Nombre"));
           }
           return compagnie;
       } catch(SQLException ex)
       {
          Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }

    }

    @Override
    public Compagnie rechercherCompagnieByNom(String nom) {
 Compagnie compagnie=new Compagnie();
        String requete="SELECT * FROM recommandation WHERE EstCompagnie=? and Nom=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setBoolean(1,true);
      ps.setString(2,nom);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               compagnie.setId(resultat.getInt("Id"));
               compagnie.setContenu(resultat.getString("contenu"));
               compagnie.setNom(resultat.getString("Nom"));
               compagnie.setNombre(resultat.getInt("Nombre"));
           }
           return compagnie;
       } catch(SQLException ex)
       {
          Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }

    }
    
    @Override
    public int recupererId(String nom) {
        int id=0;
        String requete="SELECT * FROM recommandation WHERE EstCompagnie=? and Nom=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setBoolean(1,true);
      ps.setString(2,nom);
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
    public List<Compagnie> afficherCompagnies() {
 List<Compagnie> maliste=new ArrayList<Compagnie>();
         String requete="select * from recommandation where EstCompagnie=? ";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setBoolean(1,true);
             ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               Compagnie compagnie=new Compagnie();
               compagnie.setId(resultat.getInt("id"));
               compagnie.setNom(resultat.getString("Nom"));
               compagnie.setContenu(resultat.getString("contenu"));
               compagnie.setNombre(resultat.getInt("Nombre"));
             
              maliste.add(compagnie);
           }
           return maliste;
       } catch(SQLException ex)
       {
          Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }

    @Override
    public boolean supprimerCompagnie(int id) {
        boolean test=false;
 String requete="delete from recommandation where EstCompagnie=? and id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setBoolean(1, true);
       ps.setInt(2, id);
       ps.executeUpdate();
       test=true;
           System.out.println("suppression effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la suppression"+ex.getMessage());
       }
       return test;
    }
    
    @Override
    public boolean supprimerCompagnieByNom(String nom) {
        boolean test=false;
 String requete="delete from recommandation where EstCompagnie=? and nom=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setBoolean(1, true);
       ps.setString(2, nom);
       ps.executeUpdate();
       test=true;
           System.out.println("suppression effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(CompagnieDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la suppression"+ex.getMessage());
       }
       return test;
    }
    }
    
