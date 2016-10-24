/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.dao.graphics;

import edu.esprit.dao.entities.Guide;
import edu.esprit.dao.implementations.GuideDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ACER
 */
public class Mytableguide extends AbstractTableModel {
     List<Guide> g;
    String [] entete ={"Nom","Resumé","Prix"};
    GuideDAO gDAO=new GuideDAO();
    public Mytableguide(){
    g=gDAO.afficherguide();
}

    @Override
    public int getRowCount() {
        return g.size();
    }
    

    @Override
    public int getColumnCount() {
        return entete.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex)
     {
         case 0:
             return g.get(rowIndex).getNom();
         case 1:
             return g.get(rowIndex).getResume();
             case 2:
             return g.get(rowIndex).getPrix();
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
