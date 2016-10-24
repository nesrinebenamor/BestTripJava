/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.entities.Reponse;
import edu.esprit.dao.entities.Sujet;
import edu.esprit.dao.interfaces.ISujetDAO;
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
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Toch
 */
public class SujetDAO implements ISujetDAO{
    
    private Connection connection;

     public SujetDAO()
    {
        try {
            connection=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(SujetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
    @Override
     public void ajouterSujet(Sujet sujet) {
 String requete="INSERT INTO `sujet`(`titre`,`text`,`id_utilisateur`) VALUES (?,?,?)";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       UtilisateurDAO utilisateurDAO=new UtilisateurDAO();
       SujetDAO sujetDAO=new SujetDAO();
       ps.setString(1,sujet.getTitre());
       ps.setString(2,sujet.getText());
       ps.setInt(3, sujet.getUtilisateur().getId());
       //ps.setString(3,sujet.getReponse());
       
       //String chaine=sujet.getText();
       
       //java.util.Date date = new java.util.Date();
       /*Date date = new SimpleDateFormat("dd/MM/yyyy").parse(chaine);
       java.sql.Date sqlDate = new java.sql.Date(date.getTime());
       ps.setDate(2,sqlDate);*/
       
       ps.executeUpdate();
       } catch(SQLException ex)
       {
         Logger.getLogger(SujetDAO.class.getName()).log(Level.SEVERE,null,ex);
       }
    }
     
    @Override
     public List<Sujet> afficherSujet() {
        List<Sujet> maliste=new ArrayList<Sujet>();
         String requete="select * from sujet";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);

       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               Sujet sujet=new Sujet();
               sujet.setId(resultat.getInt("id"));
               sujet.setTitre(resultat.getString("titre"));
              sujet.setText(resultat.getString("text"));
              //sujet.setReponse(resultat.getString("reponse"));
              
              maliste.add(sujet);
           }
           return maliste;
       } catch(SQLException ex)
       {
         Logger.getLogger(SujetDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }
     
    @Override
     public void supprimerSujet(int id) {
        String requete="delete from sujet where id=?";
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
     
     
    
    @Override
     public void modifierSujet(Sujet sujet) {
           boolean test=false;
         String requete="update sujet set titre=? , text=? where id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, sujet.getTitre());
       ps.setString(2, sujet.getText());
       //ps.setString(3, sujet.getReponse());
       ps.setInt(3, sujet.getId());
       ps.executeUpdate();
       test=true;
           System.out.println("mise a jour effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(SujetDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
        
    }
    
    @Override
     public Sujet rechercherSujetById(int id) {
          Sujet sujet=new Sujet();
        String requete="SELECT * FROM `sujet` WHERE id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setInt(1,id);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               sujet.setId(id);
               sujet.setTitre(resultat.getString("titre"));
               sujet.setText(resultat.getString("text"));
               //sujet.setText(resultat.getString("reponse"));
               
           }
           return sujet;
       } catch(SQLException ex)
       {
          Logger.getLogger(Sujet.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
       
    }
     
    @Override
     public Sujet rechercherSujetByNom(String nom) {
          Sujet sujet=new Sujet();
        String requete="SELECT * FROM `sujet` WHERE nom=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setString(1,nom);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               sujet.setTitre(resultat.getString("titre"));
               sujet.setText(resultat.getString("text"));
               //sujet.setText(resultat.getString("reponse"));
               
           }
           return sujet;
       } catch(SQLException ex)
       {
          Logger.getLogger(SujetDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
       
    }
     
    @Override
     public Sujet recupererSujetByTitre(String titre) {
          Sujet sujet=new Sujet();
        String requete="SELECT * FROM `sujet` WHERE titre=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setString(1,titre);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               sujet.setTitre(resultat.getString("titre"));
               sujet.setText(resultat.getString("text"));
               //sujet.setReponse(resultat.getString("reponse"));
               
           }
           return sujet;
       } catch(SQLException ex)
       {
          Logger.getLogger(SujetDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
       
    }
     
   
    /*public TreeMap<Sujet,Reponse> afficherSujetByReponse() {
Map<Sujet,Reponse> maListe=new TreeMap<Sujet,Reponse>();
   String requete="select * from sujet s inner join reponse r on s.text=r.contenu";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);

       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           { //String titre=resultat.getString("titre");
           //String contenu=resultat.getString("contenu");
               Sujet sujet=new Sujet();
               Reponse reponse=new Reponse();
               sujet.setTitre(resultat.getString("titre"));
               sujet.setText(resultat.getString("text"));
               reponse.setContenu(resultat.getString("contenu"));
               //reponse.setDate(resultat.getString("date"));
              // sujet.setString(resultat.getString("cotenu"));
              // reponse.setContenu(resultat.getString("contenu"));
              maListe.put(sujet,reponse);
           }
           return (TreeMap<Sujet, Reponse>)maListe;
       } catch(SQLException ex)
       {
         Logger.getLogger(SujetDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }

    /*@Override
    public List<Sujet> afficherSujetByReponse() {
List<Sujet> maliste=new ArrayList<Sujet>();
   String requete="select s.titre,r.contenu from sujet s inner join reponse r on s.text=r.contenu";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);

       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           { String titre=resultat.getString("titre");
           String contenu=resultat.getString("contenu");
               Sujet sujet=new Sujet();
              // Reponse reponse=new Reponse();
               sujet.setTitre(titre);
               sujet.setText(contenu);
              // sujet.setString(resultat.getString("cotenu"));
              // reponse.setContenu(resultat.getString("contenu"));
               System.out.println(sujet);
              maliste.add(sujet);
           }
           return maliste;
       } catch(SQLException ex)
       {
         Logger.getLogger(SujetDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }*/

   
    public int recupererId(String titre) {
 int id=0;
        String requete="SELECT * FROM `sujet` WHERE titre=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setString(1,titre);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               id=resultat.getInt("id");
               
           }
       } catch(SQLException ex)
       {
          Logger.getLogger(Sujet.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
         return id;
    }

    @Override
    public int supprimerById(String titre) {
int id=0;
        String requete="SELECT * FROM `sujet` WHERE titre=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setString(1,titre);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               id=resultat.getInt("id");
               
           }
       } catch(SQLException ex)
       {
          Logger.getLogger(Sujet.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
         return id;    }

    @Override
    public TreeMap<Sujet, Reponse> afficherSujetByReponse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void modifierSujetReponse(Sujet sujet) {
           boolean test=false;
         String requete="update sujet set reponse=? where id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, sujet.getReponse());
       ps.setInt(2, sujet.getId());
       ps.executeUpdate();
       test=true;
           System.out.println("mise a jour effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(SujetDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
        
    }
 
     
}
