/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.implementations;

import edu.esprit.dao.entities.Compagnie;
import edu.esprit.dao.entities.Recommandation;
import edu.esprit.dao.interfaces.IRecommandationDAO;
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
public class RecommandationDAO implements IRecommandationDAO{
    
      private Connection connection;
     
     public RecommandationDAO()
    {
        try {
            connection=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(RecommandationDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Recommandation> afficherRecommandations() {
List<Recommandation> maliste=new ArrayList<Recommandation>();
         String requete="select * from recommandation";
       try
       {
       PreparedStatement ps=connection.prepareStatement(requete);
      
       ResultSet resultat=ps.executeQuery();
           while(resultat.next())
           {
               Recommandation recommandation=new Recommandation();
               recommandation.setId(resultat.getInt("id"));
               recommandation.setContenu(resultat.getString("contenu"));
               recommandation.setNombre(resultat.getInt("Nombre"));
               
             
              maliste.add(recommandation);
           }
           return maliste;
       } catch(SQLException ex)
       {
          Logger.getLogger(RecommandationDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
           return null;
       }
    }
    
}
