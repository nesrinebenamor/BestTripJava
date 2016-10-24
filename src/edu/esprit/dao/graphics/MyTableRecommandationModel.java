/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.entities.Recommandation;
import edu.esprit.dao.implementations.RecommandationDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author esprit
 */
public class MyTableRecommandationModel extends AbstractTableModel{
    
    List<Recommandation> maliste=new ArrayList<Recommandation>();
    String [] entete ={"Description","Nombre"};
    RecommandationDAO recommandationDAO=new RecommandationDAO();
    
    MyTableRecommandationModel()
    {
        maliste=recommandationDAO.afficherRecommandations();
    }

    @Override
    public int getRowCount() {
return maliste.size();
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
             return maliste.get(rowIndex).getContenu();
         case 2:
             return maliste.get(rowIndex).getNombre();
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
