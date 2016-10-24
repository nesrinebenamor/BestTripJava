/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

import edu.esprit.dao.entities.Compagnie;
import edu.esprit.dao.entities.Recommandation;
import java.util.List;

/**
 *
 * @author esprit
 */
public interface IRecommandationDAO {
    
     public List<Recommandation> afficherRecommandations();
    
}
