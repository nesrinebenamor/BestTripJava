/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.interfaces.IExperienceDAO;
import edu.esprit.dao.entities.Experience;
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
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Samsung
 */
public class ExperiencesDAO implements IExperienceDAO{

    private Connection cnx;

    public ExperiencesDAO() {
               try {
            cnx=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(TexteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean ajouterExperience(Experience exp) {
        boolean test=false;
        String requete="insert into experience(Contenu,Date,depense,Id_utilisateur,Titre) values(?,?,?,?,?)";
        try {         
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1,exp.getContenu());         
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(exp.getDate());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(2, sqlDate);
            ps.setDouble(3,exp.getDepense());
            ps.setInt(4,exp.getUser().getId());
            System.out.println(exp.getUser().getId());
            ps.setString(5,exp.getTitre());
            if(ps.executeUpdate()>0)
              test=true;
            System.out.println("ajout effectué");
            return test;
        } catch (SQLException ex) {
           ex.printStackTrace();
           return false;
        } catch (ParseException ex) {
            Logger.getLogger(ExperiencesDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean modifExperience(Experience exp) 
    {
        boolean test=false;
        String requete="update experience set Contenu=?, Date=? ,depense=?,Titre=? where Id=?";
        try {         
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setString(1,exp.getContenu());
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(exp.getDate());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            ps.setDate(2, sqlDate);
            ps.setDouble(3, exp.getDepense());
            ps.setString(4,exp.getTitre());
            ps.setInt(5,exp.getId());
            if(ps.executeUpdate()>0)
              test=true;
            System.out.println("modification effectué");
            return test;
        } catch (SQLException ex) {
           ex.printStackTrace();
           return false;
        } catch (ParseException ex) {
            Logger.getLogger(ExperiencesDAO.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }
    
    @Override
    public List<Experience> affichExperience() 
    {
//         List <Experience> listeExp=new ArrayList <>();
//         String requete="select * from experience where Id_utilisateur=?";
//       try
//       {
//       PreparedStatement ps = cnx.prepareStatement(requete);     
//       ps.setInt(1,1);
//       ResultSet res=ps.executeQuery();
//           while(res.next())
//           {
//               
//               listeExp.add(new Experience(res.getInt("Id"),res.getString("Contenu"),res.getString("Date"),res.getDouble("depense"),res.getString("Titre")));
//               
//           }
//           return listeExp;
//       } catch(SQLException ex)
//       {
//          ex.printStackTrace();
//           return null;
//       }
        return null;
    }
   
    @Override
    public List<Experience> affichExperience(int id) 
    {
         List <Experience> listeExp=new ArrayList <>();
         String requete="select * from experience where Id_utilisateur=?";
       try
       {
       PreparedStatement ps = cnx.prepareStatement(requete);     
       ps.setInt(1,id);
       ResultSet res=ps.executeQuery();
           while(res.next())
           {
               
               listeExp.add(new Experience(res.getInt("Id"),res.getString("Contenu"),res.getString("Date"),res.getDouble("depense"),res.getString("Titre")));
               
           }
           return listeExp;
       } catch(SQLException ex)
       {
          ex.printStackTrace();
           return null;
       }
    }
    
    @Override
    public boolean suppExperience(int id) 
    {
         boolean test=false;
         String requete="delete from experience where Id=?";         
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
    public Experience cherchExperienceById(int id) {
      String requete="select * from experience where Id=?";
       try
       {
       PreparedStatement ps = cnx.prepareStatement(requete);
       ps.setInt(1,id);
       ResultSet res=ps.executeQuery();
//       if(!res.absolute(1))
//       {
//           System.out.println("Ce Texte n'existe pas"); 
//       }    
          Experience exp=new Experience();
           while(res.next())
           {
               
               exp = new Experience(res.getInt("Id"),res.getString("Contenu"),res.getString("Date"),res.getDouble("depense"),res.getString("Titre"));
               
           }
           return exp;
       } catch(SQLException ex)
       {
          ex.printStackTrace();
           return null;
       }    
    }

    @Override
    public void genereExperiencesPDF() {

        try {
            JasperDesign jd=JRXmlLoader.load("‪C:\\wamp\\www\\BestTrip3A71\\MesExperiences.jrxml");
            String sql="select * from experience where id_utilisateur=${id_utilisateur}";
            JRDesignQuery newQuery=new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr,null,MyConnection.getInstance());
            JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            Logger.getLogger(ExperiencesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExperiencesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
    }
    
    
}
