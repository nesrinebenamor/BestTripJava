/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.entities.Sujet;
import edu.esprit.dao.implementations.SujetDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Toch
 */
public class MyTableSujetModel extends AbstractTableModel {
    List<Sujet> s;
    String[] entete={"Titre","Text"};
SujetDAO sDAO=new SujetDAO();
public MyTableSujetModel(){
    s=sDAO.afficherSujet();
}


    @Override
    public int getRowCount() {
return s.size();
    }

    @Override
    public int getColumnCount() {
return entete.length;
        }

    @Override
    public Object getValueAt(int i, int i1) {
       switch(i1)
       {
           case 0:
               return s.get(i).getTitre();
           case 1:
               return s.get(i).getText();
            default:
                return null;
       }
    
    }

    @Override
    public String getColumnName(int i) {
        return entete[i]; //To change body of generated methods, choose Tools | Templates.
    }
    

}

   
