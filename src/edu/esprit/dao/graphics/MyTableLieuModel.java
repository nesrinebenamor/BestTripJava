/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.entities.Lieu;
import edu.esprit.dao.implementations.LieuDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author esprit
 */
public class MyTableLieuModel extends AbstractTableModel{
    
    List<Lieu> lieux;
    String [] entete ={"Adresse","Description","Nombre"};
    LieuDAO lieuDAO=new LieuDAO();
    
     public MyTableLieuModel()
    {
        lieux=lieuDAO.afficherLieu();
    }

    @Override
    public int getRowCount() {
        return lieux.size();
    }

    @Override
    public int getColumnCount() {
        return entete.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
          switch(columnIndex)
     {
        /* case 0:
             return lieux.get(rowIndex).getId();*/
         case 0:
             return lieux.get(rowIndex).getAdresse();
         case 1:
             return lieux.get(rowIndex).getContenu();
         case 2:
             return lieux.get(rowIndex).getNombre();
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
