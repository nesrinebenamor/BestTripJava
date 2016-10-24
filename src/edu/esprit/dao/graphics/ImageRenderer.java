/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;



/**
 *
 * @author Samsung
 */
public class ImageRenderer implements TableCellRenderer{
  JLabel lbl = new JLabel();
  //ImageIcon icon = new ImageIcon(getClass().getResource("b1.jpg"));
    ImageIcon icon=null;
       public ImageRenderer(String iconName) {
            icon = new ImageIcon(getClass().getResource(iconName));
        }

    public ImageRenderer() {
    }
       
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
     lbl.setText((String) value);
    lbl.setIcon(icon);
    return lbl;    }
    
}
