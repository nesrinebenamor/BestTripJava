/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.entities.Reponse;
import edu.esprit.dao.implementations.ReponseDAO;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Toch
 */
public class MyTableReponseModel extends AbstractTableModel {
    
    List<Reponse> r;
    String[] entete={"Réponse"};
ReponseDAO sDAO=new ReponseDAO();

public MyTableReponseModel(int id_sujet){
    r=sDAO.afficherReponse(id_sujet);
     }
    

    @Override
    public int getRowCount() {
return r.size();    }

    @Override
    public int getColumnCount() {
return entete.length;    }
    
    @Override
    public Object getValueAt(int i, int i1) {
       switch(i1)
       {
           case 0:
               return r.get(i).getContenu();
               default:
                return null;
           
       }
    
    }
    
   @Override
    public String getColumnName(int i) {
        return entete[i]; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
