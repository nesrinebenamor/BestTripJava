/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

/**
 *
 * @author zamama
 */
import edu.esprit.dao.entities.Newsletter;
import edu.esprit.dao.interfaces.INewsletterDAO;
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
 * @author esprit
 */
public class NewsletterDAO implements INewsletterDAO{
    
     private Connection connection;
     
     public NewsletterDAO()
    {
         try {
             connection=MyConnection.getInstance();
         } catch (IOException ex) {
             Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void ajouterNewsletter(Newsletter newsletter) {
 String requete="INSERT INTO `newsletter`(`contenu`, `date` ,`nom`) VALUES (?,?,?)";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,newsletter.getcontenu());
       Date date;
     try {
         date = new SimpleDateFormat("dd/MM/yyyy").parse(newsletter.getDate());
         java.util.Date sqlDate = new java.sql.Date(date.getTime());
       newsletter.setDate(newsletter.getDate());
       ps.setString(2,newsletter.getDate());
     } catch (ParseException ex) {
         Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
         
       ps.setString(3,newsletter.getnom());
      
       ps.executeUpdate();
       } catch(SQLException ex)
       {
          Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE,null,ex);
       }       
    }

    @Override
    public void modifierNewsletter(Newsletter newsletter,int id) {
String requete="update depot set contenu=? , date=? , nom=?  where id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, newsletter.getcontenu());
       ps.setString(2, newsletter.getDate());
       ps.setString(3,newsletter.getnom());
      
       ps.setInt(4, id);
       ps.executeUpdate();
           System.out.println("mise a jour effectuée avec succés");
       } catch(SQLException ex)
       {
          Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
        
    }

    @Override
    public Newsletter rechercherNewsletterById(int id) {
          Newsletter newsletter=new Newsletter();
        String requete="SELECT * FROM `newsletter` WHERE id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setInt(1,id);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               newsletter.setcontenu(resultat.getString("contenu"));
            Date date;
           try {
               date = new SimpleDateFormat("dd/MM/yyyy").parse(newsletter.getDate());
                  java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                   newsletter.setDate(resultat.getString("date"));
           } catch (ParseException ex) {
               Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
          }
           return newsletter;
       } catch(SQLException ex)
       {
          Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
       }
    
    
    public Newsletter rechercherNewsletterBynom(String nom ) {
          Newsletter newsletter=new Newsletter();
        String requete="SELECT * FROM `newsletter` WHERE nom=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setString(1,nom);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               newsletter.setcontenu(resultat.getString("contenu"));
            Date date;
           try {
               date = new SimpleDateFormat("dd/MM/yyyy").parse(newsletter.getDate());
                  java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                   newsletter.setDate(resultat.getString("date"));
           } catch (ParseException ex) {
               Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
          }
           return newsletter;
       } catch(SQLException ex)
       {
          Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
       
       
       
    }
    
    
     @Override
    public Newsletter rechercherNewsletterBycontenu(String contenu) {
          Newsletter newsletter=new Newsletter();
        String requete="SELECT * FROM `newsletter` WHERE contenu=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setString(1,contenu);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {Date date;
               newsletter.setnom(resultat.getString("nom"));
           try {
               date = new SimpleDateFormat("dd/MM/yyyy").parse(newsletter.getDate());
               java.util.Date sqlDate = new java.sql.Date(date.getTime());
               newsletter.setDate(resultat.getString("date"));
           } catch (ParseException ex) {
               Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
           
               
           }
           return newsletter;
       } catch(SQLException ex)
       {
          Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
       
    }

    @Override
    public List<Newsletter> afficherNewsletters() {
        List<Newsletter> maliste=new ArrayList<Newsletter>();
         String requete="select * from newsletter";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {Date date;
               Newsletter newsletter=new Newsletter();
               newsletter.setcontenu(resultat.getString("contenu"));
           try {
               date = new SimpleDateFormat("dd/MM/yyyy").parse(newsletter.getDate());
                java.util.Date sqlDate = new java.sql.Date(date.getTime());
              newsletter.setDate(resultat.getString("date"));
           } catch (ParseException ex) {
               Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE, null, ex);
           }
              
              newsletter.setnom(resultat.getString("nom"));
              
              maliste.add(newsletter);
           }
           return maliste;
       } catch(SQLException ex)
       {
          Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }
    
     @Override
    public List<Newsletter> afficherNewslettersByNom(String nom) {
        List<Newsletter> maliste=new ArrayList<Newsletter>();
         String requete="select * from newsletter";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               Newsletter newsletter=new Newsletter();
               newsletter.setcontenu(resultat.getString("contenu"));
              newsletter.setDate(resultat.getString("date"));
              newsletter.setnom(resultat.getString("nom"));
              
              maliste.add(newsletter);
           }
           return maliste;
       } catch(SQLException ex)
       {
          Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }

    
    public void supprimerNewsletter(String nom) {
        String requete="delete from newsletter where nom=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, nom);
       ps.executeUpdate();
           System.out.println("suppression effectuée avec succées");
       } catch(SQLException ex)
       {
          Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la suppression"+ex.getMessage());
       }
    }

    @Override
    public void supprimerNewsletter(int id) {
            String requete="delete from Newsletter where id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setInt(1, id);
       ps.executeUpdate();
           System.out.println("suppression effectuée avec succées");
       } catch(SQLException ex)
       {
          Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreure lors de la suppression"+ex.getMessage());
       }
    }
     @Override
    public void supprimerNewsletterByNom(String nom) {
            String requete="delete from Newsletter where Nom=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, nom);
       ps.executeUpdate();
           System.out.println("suppression effectuée avec succées");
       } catch(SQLException ex)
       {
          Logger.getLogger(NewsletterDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreure lors de la suppression"+ex.getMessage());
       }
    }
    }

    
    
    
