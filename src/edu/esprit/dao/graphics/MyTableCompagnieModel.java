/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;


import edu.esprit.dao.entities.Compagnie;
import edu.esprit.dao.implementations.CompagnieDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author esprit
 */
public class MyTableCompagnieModel extends AbstractTableModel{
    
     List<Compagnie> compagnies;
    String [] entete ={"Nom","Description","Nombre"};
    CompagnieDAO compagnieDAO=new CompagnieDAO();
    
     public MyTableCompagnieModel()
    {
        compagnies=compagnieDAO.afficherCompagnies();
    }

    @Override
    public int getRowCount() {
      return compagnies.size();
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
             return compagnies.get(rowIndex).getId();*/
         case 0:
             return compagnies.get(rowIndex).getNom();
         case 1:
             return compagnies.get(rowIndex).getContenu();
         case 2:
             return compagnies.get(rowIndex).getNombre();
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
