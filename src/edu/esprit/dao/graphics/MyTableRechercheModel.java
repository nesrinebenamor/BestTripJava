/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.entities.Utilisateur;
import edu.esprit.dao.implementations.UtilisateurDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author esprit
 */
public class MyTableRechercheModel extends AbstractTableModel{
    
    List<Utilisateur> utilisateurs;
    Utilisateur utilisateur=new Utilisateur();
    String nom="";
    String [] entete ={"Nom","Prenom","Email","Login","Age"};
    UtilisateurDAO utilisateurDAO=new UtilisateurDAO();
    
     public MyTableRechercheModel(String nom)
    {   
        utilisateurDAO.rechercherUtilisateurByNom(nom);
    }

    @Override
    public int getRowCount() {
    return 1;
    }

    @Override
    public int getColumnCount() {
        return entete.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
         case 1:
             return utilisateur.getNom();
         case 2:
             return utilisateur.getPrenom();
         case 3:
             return utilisateur.getMail();
         case 4:
             return utilisateur.getLogin();
         case 5:
             return utilisateur.getAge();
         default:
             return null;
    }
    }
        
         @Override
    public String getColumnName(int column)
    {
     return entete[column];   
    }
    
}