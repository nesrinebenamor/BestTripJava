/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.implementations.ExperiencesDAO;
import edu.esprit.dao.entities.Experience;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Samsung
 */
public class MyTableModel extends AbstractTableModel {

    List<Experience> exp;
    private static final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class,String.class,String.class, String.class, Double.class, JButton.class, JButton.class};
    String[] entete = {"Titre","Pays","Date","Type", "Dépense", "", " "};
    ExperiencesDAO expDAO = new ExperiencesDAO();
    JFrame originFrame;
    int id;
    public MyTableModel() {
        this.id=id;
        exp = expDAO.affichExperience(id);
    }

    public MyTableModel(JFrame originFrame,int id) {
        this.id=id;
        exp = expDAO.affichExperience(id);
        this.originFrame = originFrame;
    }

    public JFrame getOriginFrame() {
        return originFrame;
    }

    public void setOriginFrame(JFrame originFrame) {
        this.originFrame = originFrame;
    }

    @Override
    public int getRowCount() {
        return exp.size();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return entete.length;
    }

    @Override
    public Object getValueAt(final int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return exp.get(rowIndex).getTitre();
           case 1:
                return exp.get(rowIndex).getPays();
            case 2:
                return exp.get(rowIndex).getDate();    
            case 3:
                return exp.get(rowIndex).getType();
            case 4:
            return exp.get(rowIndex).getDepense();
            case 5: {
                final JButton button = new JButton("voir plus");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        MenuChoixExperience menu = new MenuChoixExperience(exp.get(rowIndex).getId(),id);
                        menu.setVisible(true);
                        originFrame.setVisible(false);
                    }
                });
                return button;
            }
            case 6: {
                final JButton button = new JButton("supprimer");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        removeRow(rowIndex);
                         
                    }
                });
                return button;
            }

            default:
                return null;

        }
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        this.getValueAt(rowIndex, columnIndex);
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return entete[column];
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged(); //To change body of generated methods, choose Tools | Templates.
         exp = expDAO.affichExperience(id);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        super.addTableModelListener(l); //To change body of generated methods, choose Tools | Templates.
    }
    
  public void removeRow(int position){    
     if(JOptionPane.showConfirmDialog(null,"Voulez vous vraiment supprimer?","suppression",0)==0)                           
                         {  
                            
                             expDAO.suppExperience(exp.get(position).getId());
                            
                          fireTableDataChanged();
                         } 
     
   }
}
