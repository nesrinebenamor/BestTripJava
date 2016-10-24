/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.interfaces;

import edu.esprit.dao.entities.Experience;
import java.util.List;

/**
 *
 * @author Samsung
 */
public interface IExperienceDAO {
    public boolean ajouterExperience(Experience exp);
    public boolean modifExperience(Experience exp);
    public List<Experience> affichExperience();
    public boolean suppExperience(int id);
    public Experience cherchExperienceById(int id);
    public void genereExperiencesPDF();
    public List<Experience> affichExperience(int id);

}
