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
public class MyTableUtilisateurModel extends AbstractTableModel{
    
    List<Utilisateur> utilisateurs;
    String [] entete ={"Nom","Prenom","Email","Login","Age"};
    UtilisateurDAO utilisateurDAO=new UtilisateurDAO();
    
     public MyTableUtilisateurModel()
    {
        utilisateurs=utilisateurDAO.afficherUtilisateurs();
    }

    @Override
    public int getRowCount() {
      return utilisateurs.size();
    }

    @Override
    public int getColumnCount() {
    return entete.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
switch(columnIndex)
     {
       /*  case 0:
             return utilisateurs.get(rowIndex).getId();*/
         case 0:
             return utilisateurs.get(rowIndex).getNom();
         case 1:
             return utilisateurs.get(rowIndex).getPrenom();
         case 2:
             return utilisateurs.get(rowIndex).getMail();
         case 3:
             return utilisateurs.get(rowIndex).getLogin();
         case 4:
             return utilisateurs.get(rowIndex).getAge();
//         case 5:
//             return utilisateurs.get(rowIndex).getId();
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
