/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.implementations.TexteDAO;
import edu.esprit.dao.entities.Experience;
import edu.esprit.dao.entities.Texte;
import java.util.List;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Samsung
 */
public class MyTableTexteModel extends AbstractTableModel {

    List<Texte> texte;
    private static final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class};
    String[] entete = {"Détail"};
    TexteDAO txtDAO = new TexteDAO();
    //AffichagesDetailExperience a=new AffichagesDetailExperience();
    public MyTableTexteModel(int id_experience) {
        texte = txtDAO.afficherTexteByID(id_experience);

    }

    public MyTableTexteModel() {
        texte = txtDAO.afficherTexteByID(2);
    }
    

    @Override
    public int getRowCount() {
        return texte.size();
    }

    @Override
    public int getColumnCount() {
        return entete.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return texte.get(rowIndex).getContenu();
            default:
                return null;
        }
    }
        @Override
     public String getColumnName(int column) {
        return entete[column]; 
      }
}
