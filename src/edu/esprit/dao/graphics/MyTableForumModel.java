/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.entities.Reponse;
import edu.esprit.dao.entities.Sujet;
import edu.esprit.dao.implementations.ReponseDAO;
import edu.esprit.dao.implementations.SujetDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Toch
 */
public class MyTableForumModel extends AbstractTableModel {
  
      List<Sujet> s;
      private static final Class<?>[] COLUMN_TYPES = new Class<?>[]{String.class, String.class, String.class, JButton.class};
    String[] entete={"Titre","Text",""};
    SujetDAO sDAO=new SujetDAO();
    static int id_sujet;
 
    
    MyTableForumModel()
    {
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
    public Object getValueAt(final int i, int i1) {
       
switch(i1)
{
    case 0:
    {
        return s.get(i).getTitre();
    
    }
    case 1:
    {
      return s.get(i).getText();
    }
     case 2 : 
     {
       final JButton button = new JButton("repondre");
       button.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent ae) {
                  
                  //Sujet sujet=new Sujet();
                  MyTableForumModel.id_sujet=s.get(i).getId();
                  System.out.println(MyTableForumModel.id_sujet);
                  AjoutReponse rep = new AjoutReponse(MyTableForumModel.id_sujet);
                  
                  rep.setVisible(true);
           }
       });
       return button;
     }
    default:
        return null;
             
}
    }
   
    @Override
    public String getColumnName(int column)
    {
        return entete[column];
    }
      @Override
      public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES[columnIndex];
    }
    
    }
    