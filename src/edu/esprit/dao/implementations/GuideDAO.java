/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.entities.Guide;
import edu.esprit.dao.interfaces.IGuideDAO;
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
 * @author ACER
 */
public class GuideDAO implements IGuideDAO{
     private Connection connection;
     
     public GuideDAO()
    {
        try {
            connection=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(GuideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void ajouterguide(Guide g) {
        String requete="INSERT INTO guide (`nom`,`resume`,`prix`,id_utilisateur) VALUES (?,?,?,?)";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
        UtilisateurDAO utilisateurDAO=new UtilisateurDAO();
        GuideDAO guideDAO=new GuideDAO();
       ps.setString(1,g.getNom());
       ps.setString(2,g.getResume());
       ps.setFloat(3,g.getPrix());
           System.out.println(g.getUtilisateur().getId());
       ps.setInt(4,g.getUtilisateur().getId());
      
       ps.executeUpdate();
       } catch(SQLException ex)
       {
          Logger.getLogger(GuideDAO.class.getName()).log(Level.SEVERE,null,ex);
       }       
    }

    @Override
    public void modifierguide(Guide g) {
        String requete="UPDATE guide set nom=? , resume=? , prix=?  where id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
        ps.setString(1,g.getNom());
       ps.setString(2,g.getResume());
       ps.setFloat(3,g.getPrix());
       ps.setInt(4, g.getUtilisateur().getId());
      
     
       ps.executeUpdate();
           System.out.println("mise a jour effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(GuideDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
    }

   

    @Override
    public Guide rechercherguideByNom(String nom) {
         Guide g=new Guide();
        String requete="SELECT * FROM guide WHERE nom=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setString(1,nom);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               g.setNom(resultat.getString("nom"));
               g.setResume(resultat.getString("resume"));
               g.setPrix(resultat.getFloat("prix"));
              
           }
           return g;
       } catch(SQLException ex)
       {
          Logger.getLogger(GuideDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }

    @Override
    public List<Guide> afficherguide() {
        List<Guide> maliste=new ArrayList<Guide>();
         String requete="select * from guide";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ResultSet resultat=ps.executeQuery();
       
           
           while(resultat.next())
           {
               Guide g=new Guide();
               g.setNom(resultat.getString("nom"));
               g.setResume(resultat.getString("resume"));
               g.setPrix(resultat.getFloat("prix"));
            
              maliste.add(g);
               System.out.println(maliste);
           }
           return maliste;
       } catch(SQLException ex)
       {
          Logger.getLogger(GuideDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }

    @Override
    public void supprimerguide(String nom) {
        String requete="delete from guide where nom=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, nom);
       ps.executeUpdate();
           System.out.println("suppression effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(GuideDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la suppression"+ex.getMessage());
       }
    }

    @Override
    public int recupererID(String nom) {
        int id=0;
        String requete="SELECT * FROM guide WHERE nom=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setString(1,nom);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
            id=resultat.getInt("id");     
           }
      
       } catch(SQLException ex)
        {
          Logger.getLogger(GuideDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
        }
       return id;    
    }
    
    
    
}
