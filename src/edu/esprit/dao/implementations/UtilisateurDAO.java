/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.entities.Compagnie;
import edu.esprit.dao.entities.Lieu;
import edu.esprit.dao.entities.Recommandation;
import edu.esprit.dao.entities.Utilisateur;
import edu.esprit.dao.interfaces.IUtilisateurDAO;
import edu.esprit.dao.technique.MyConnection;
import java.io.File;
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
public class UtilisateurDAO implements IUtilisateurDAO{
    
     private Connection connection;
     
     public UtilisateurDAO()
    {
        try {
            connection=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
          boolean test=false;
//        final Random r = new SecureRandom();
//        byte[] salt = new byte[32];
//        r.nextBytes(salt);
///** String encodedSalt = Base64.encodeBase64String(salt); */
//
//        
//        System.out.println("salt=>"+r);        
        
   //String requete="INSERT INTO `utilisateur`(`nom`, `prenom`, `email`, `username`, `password`, `age`,`image`) VALUES (?,?,?,?,?,?,?)";
   String requete="INSERT INTO `utilisateur`( `username`, `username_canonical`,`email`, `email_canonical`, `enabled`,`password`, `roles`,`nom`, `prenom`,`age`,`image`) VALUES (?,?,?,?,?,?,?,?,?,?,?)"; 
   try
       {File afile=new File(utilisateur.getImage());
       if(afile.renameTo(new File("C:/wamp/www/ProjetBestTrip/web/uploads/photos"+afile.getName())))
       {
           System.out.println("File is moved successfully");
       }
       else {
           System.out.println("File is failed to move");
       }       
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,utilisateur.getLogin());
       ps.setString(2, utilisateur.getLogin());
       ps.setString(3, utilisateur.getMail());
       ps.setString(4,utilisateur.getMail());
       ps.setInt(5,1);
       ps.setString(6,utilisateur.getPassword());
       ps.setString(7,"a:0:{}");
       ps.setString(8,utilisateur.getNom());
       ps.setString(9,utilisateur.getPrenom());
       ps.setInt(10,utilisateur.getAge());
       ps.setString(11,utilisateur.getImage());
      
       //ps.setString(7, utilisateur.getImage());
       ps.executeUpdate();
       test=true;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           
       }   
     return test;
    }

    @Override
    public boolean modifierUtilisateur(Utilisateur utilisateur) {
         boolean test=false; 
String requete="UPDATE `utilisateur` SET `nom`=? , `prenom`=? , `email`=? ,username=? ,password=?, `age`=? ,image=? where `id`=?"; 
     try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, utilisateur.getNom());
       ps.setString(2, utilisateur.getPrenom());
       ps.setString(3, utilisateur.getMail());
       ps.setString(4,utilisateur.getLogin());
       ps.setString(5,utilisateur.getPassword());
       ps.setInt(6,utilisateur.getAge());
        ps.setString(7,utilisateur.getImage());
       ps.setInt(8, utilisateur.getId());
      
       ps.executeUpdate();
       test=true;
           System.out.println("mise a jour effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
        return test;
    }

    @Override
    public Utilisateur rechercherUtilisateurById(int id) {
          Utilisateur utilisateur=new Utilisateur();
        String requete="SELECT * FROM `utilisateur` WHERE id=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      ps.setInt(1,id);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               utilisateur.setId(id);
               utilisateur.setNom(resultat.getString("nom"));
               utilisateur.setPrenom(resultat.getString("prenom"));
               utilisateur.setMail(resultat.getString("email"));
               utilisateur.setLogin(resultat.getString("username"));
               utilisateur.setPassword(resultat.getString("password"));
               utilisateur.setAge(resultat.getInt("age"));
               utilisateur.setImage(resultat.getString("image"));
           }
           return utilisateur;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
       
    }
    
    @Override
    public Utilisateur rechercherUtilisateurByLogin(String login) {
       Utilisateur utilisateur=new Utilisateur();
          String requete="select * from utilisateur where username=?";
        // String requete="select * from utilisateur where login=? and EstAdministrateur is null";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,login);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {  utilisateur.setId(resultat.getInt("id"));
               utilisateur.setNom(resultat.getString("nom"));
              utilisateur.setPrenom(resultat.getString("prenom"));
              utilisateur.setMail(resultat.getString("email"));
               utilisateur.setLogin(resultat.getString("username"));
               utilisateur.setPassword(resultat.getString("password"));
              utilisateur.setAge(resultat.getInt("age"));
               utilisateur.setImage(resultat.getString("image"));
           }
           //return utilisateur;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           //return null;
       }
       return utilisateur;
       }

     @Override
      public int RecupererId(String login) {
          Utilisateur utilisateur=new Utilisateur();
         String requete="select * from utilisateur where username=?";
         int id=0;
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,login);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {  
              id=resultat.getInt("id");
           }
           //return utilisateur;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           //return null;
       }
       return id;
       }
    @Override
    public List<Utilisateur> afficherUtilisateurs() {
       List<Utilisateur> maliste=new ArrayList<Utilisateur>();
         String requete="select * from utilisateur where EstAdministrateur is null";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               Utilisateur utilisateur=new Utilisateur();
               utilisateur.setId(resultat.getInt("id"));
               utilisateur.setNom(resultat.getString("nom"));
              utilisateur.setPrenom(resultat.getString("prenom"));
              utilisateur.setMail(resultat.getString("email"));
               utilisateur.setLogin(resultat.getString("username"));
               utilisateur.setPassword(resultat.getString("password"));
              utilisateur.setAge(resultat.getInt("age"));
              maliste.add(utilisateur);
           }
           return maliste;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }  
        @Override
    public List<Utilisateur> afficherUtilisateurByNom(String nom) {
        List<Utilisateur> maliste=new ArrayList<Utilisateur>();
        String requete="select * from utilisateur where EstAdministrateur is null and username=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,nom);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {   Utilisateur utilisateur=new Utilisateur();
               utilisateur.setNom(resultat.getString("nom"));
              utilisateur.setPrenom(resultat.getString("prenom"));
              utilisateur.setMail(resultat.getString("email"));
               utilisateur.setLogin(resultat.getString("username"));
               utilisateur.setPassword(resultat.getString("password"));
              utilisateur.setAge(resultat.getInt("age"));
              maliste.add(utilisateur);
           }
           return maliste;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }
    

    @Override
    public boolean supprimerUtilisateur(int id) {
       boolean test=false;
        String requete="delete from utilisateur where id=? and EstAdministrateur=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setInt(1, id);
       ps.setBoolean(2,false);
       ps.executeUpdate();
       test=true;
           System.out.println("suppression effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la suppression"+ex.getMessage());
       }
       return test;
    }

    @Override
    public boolean ajouterRecommandation(Recommandation recommandation) {
        boolean test=false;
        if(recommandation.getClass()==Compagnie.class)
        {Compagnie c=(Compagnie)recommandation;
         CompagnieDAO compagnieDAO=new CompagnieDAO();
         compagnieDAO.ajouterCompagnie(c);
         test=true;
        }
        else if(recommandation.getClass()==Lieu.class)
        {Lieu l=(Lieu) recommandation;
            LieuDAO lieuDAO=new LieuDAO();
            lieuDAO.ajouterLieu(l);
            test=true;
        }
   return test;
    }

    @Override
    public boolean modifierRecommandation(Recommandation recommandation) {
         boolean test=false;
        if(recommandation.getClass()==Compagnie.class)
        {Compagnie c=(Compagnie)recommandation;
         CompagnieDAO compagnieDAO=new CompagnieDAO();
         compagnieDAO.modifierCompagnie(c);
         test=true;
        }
        else if(recommandation.getClass()==Lieu.class)
        {Lieu l=(Lieu) recommandation;
            LieuDAO lieuDAO=new LieuDAO();
            lieuDAO.modifierLieu(l);
            test=true;
        }
   return test;
    }
    
    @Override
    public List<Compagnie> afficherCompagnies() {
        List<Compagnie> mesCompagnies=new ArrayList<Compagnie>();
        CompagnieDAO compagnieDAO=new CompagnieDAO();
        mesCompagnies=compagnieDAO.afficherCompagnies();
        return mesCompagnies;
    }

    @Override
    public List<Lieu> afficherLieux() {
        List<Lieu> mesLieux=new ArrayList<Lieu>();
        LieuDAO lieuDAO=new LieuDAO();
        mesLieux=lieuDAO.afficherLieu();
        return mesLieux;
    }

    @Override
    public Recommandation rechercherRecommandation(Recommandation recommandation) {
         Recommandation r=new Recommandation();
        if(recommandation.getClass()==Compagnie.class)
        {Compagnie c=(Compagnie)recommandation;
         CompagnieDAO compagnieDAO=new CompagnieDAO();
         r=compagnieDAO.rechercherCompagnieById(recommandation.getId());
        }
        else if(recommandation.getClass()==Lieu.class)
        {Lieu l=(Lieu) recommandation;
            LieuDAO lieuDAO=new LieuDAO();
            r=lieuDAO.rechercherLieuById(recommandation.getId());
        }
   return r;
    }

    @Override
    public boolean supprimerRecommandation(Recommandation recommandation) {
         boolean test=false;
        if(recommandation.getClass()==Compagnie.class)
        {Compagnie c=(Compagnie)recommandation;
         CompagnieDAO compagnieDAO=new CompagnieDAO();
         compagnieDAO.supprimerCompagnie(c.getId());
         test=true;
        }
        else if(recommandation.getClass()==Lieu.class)
        {Lieu l=(Lieu) recommandation;
            LieuDAO lieuDAO=new LieuDAO();
            lieuDAO.supprimerLieu(l.getId());
            test=true;
        }
   return test;
    }

    @Override
    public boolean supprimerUtilisateurByNom(String nom) {
         boolean test=false;
        String requete="delete from utilisateur where login=? ";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, nom);
       ps.executeUpdate();
       test=true;
           System.out.println("suppression effectuée avec succès");
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la suppression"+ex.getMessage());
       }
       return test;
    }

    @Override
    public Utilisateur rechercherUtilisateurByNom(String nom) {
  Utilisateur utilisateur=new Utilisateur();
         String requete="select * from utilisateur where nom=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,nom);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {  utilisateur.setNom(resultat.getString("nom"));
              utilisateur.setPrenom(resultat.getString("prenom"));
              utilisateur.setMail(resultat.getString("email"));
               utilisateur.setLogin(resultat.getString("login"));
               utilisateur.setPassword(resultat.getString("password"));
              utilisateur.setAge(resultat.getInt("age"));
              utilisateur.setImage(resultat.getString("image"));
           }
           return utilisateur;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }

    @Override
    public boolean authenitification(String login, String password) {
        boolean test=false;
         int taille=password.length();
        // String chaine="SUBSTR("+password+", 1,"+taille+" )as password";
         String chaine=password.substring(0, taille);
         System.out.println("chaine="+chaine);
        String requete="select * from utilisateur where username=? and password=substring(password,0,"+taille+")=?";
        System.out.println(requete);
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1, login);
       ps.setString(2,chaine);
       ps.executeQuery();
        ResultSet resultat=ps.executeQuery();
        while(resultat.next())
      { 
           System.out.println("login et password sont valides");
             test=true;
       }
       }
       catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("login et password sont non valides"+ex.getMessage());
       }
       return test;
    }

    @Override
    public boolean estAdmin(String login) {
       boolean test=false;
 Utilisateur utilisateur=new Utilisateur();
         String requete="select * from utilisateur where username=? and EstAdministrateur is not null";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,login);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {  
              test=resultat.getBoolean("EstAdministrateur");
           }
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
       }
       return test;
    }

    @Override
    public String recupererEmailByLogin(String login) {
 Utilisateur utilisateur=new Utilisateur();
         String requete="select * from utilisateur where username=?";
         String email="";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,login);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {  
              email=resultat.getString("Email");
           }
           //return utilisateur;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           //return null;
       }
       return email;
    }

    @Override
    public String recupererPasswordByLogin(String login) {
 Utilisateur utilisateur=new Utilisateur();
         String requete="select * from utilisateur where username=?";
         String password="";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,login);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {  
              password=resultat.getString("Password");
           }
           //return utilisateur;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           //return null;
       }
       return password;
    }

    @Override
    public Utilisateur selectUserByMail(String mail) {
  Utilisateur utilisateur=new Utilisateur();
         String requete="select * from utilisateur where email=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,mail);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {  utilisateur.setNom(resultat.getString("nom"));
              utilisateur.setPrenom(resultat.getString("prenom"));
              utilisateur.setMail(resultat.getString("email"));
               utilisateur.setLogin(resultat.getString("username"));
               utilisateur.setPassword(resultat.getString("password"));
              utilisateur.setAge(resultat.getInt("age"));
              utilisateur.setImage(resultat.getString("image"));
           }
           return utilisateur;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }

    @Override
    public int insertUser(Utilisateur utilisateur) {
          int id=0;
 String requete="INSERT INTO `utilisateur`(`nom`, `prenom`, `email`, `username`, `password`, `age`,`image`) VALUES (?,?,?,?,?,?,?)";
     try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,utilisateur.getNom());
       ps.setString(2,utilisateur.getPrenom());
       ps.setString(3,utilisateur.getMail());
       ps.setString(4,utilisateur.getLogin());
       ps.setString(5,utilisateur.getPassword());
       ps.setInt(6,utilisateur.getAge());
       ps.setString(7, utilisateur.getImage());
       ps.executeUpdate();
       ResultSet rs=ps.getGeneratedKeys();
       if(rs.next())
       {
           id=rs.getInt(1);
       }
       return id;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           return id;
       }   
    }

    @Override
    public boolean verifierExistance(String mail) {
boolean test=false;
Utilisateur utilisateur=new Utilisateur();
         String requete="select * from utilisateur where email=?";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
       ps.setString(1,mail);
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {  
              utilisateur.setMail(resultat.getString("password"));
              test=true;
           }
           //return utilisateur;
       } catch(SQLException ex)
       {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           //return null;
       }
       return test;
    }

   
    }
    
