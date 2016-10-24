/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.entities.Utilisateur;
import edu.esprit.dao.implementations.AdministrateurDAO;
import edu.esprit.dao.implementations.UtilisateurDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author esprit
 */
public class MyTableAdminModel extends AbstractTableModel{
     List<Utilisateur> administrateurs;
    String [] entete ={"Nom","Prenom","Email","Login","Age"};
    AdministrateurDAO administrateurDAO=new AdministrateurDAO();
    
     public MyTableAdminModel()
    {
        administrateurs=administrateurDAO.afficherAdministrateurs();
    }

    @Override
    public int getRowCount() {
 return administrateurs.size();
    }

    @Override
    public int getColumnCount() {
return entete.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
switch(columnIndex)
     {
         /*case 0:
             return administrateurs.get(rowIndex).getId();*/
         case 0:
             return administrateurs.get(rowIndex).getNom();
         case 1:
             return administrateurs.get(rowIndex).getPrenom();
         case 2:
             return administrateurs.get(rowIndex).getMail();
         case 3:
             return administrateurs.get(rowIndex).getLogin();
         case 4:
             return administrateurs.get(rowIndex).getAge();
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
