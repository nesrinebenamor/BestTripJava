/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.esprit.dao.graphics;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.esprit.dao.implementations.GuideDAO;
import edu.esprit.dao.technique.MyConnection;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class AfficherGuide extends javax.swing.JFrame {
 Connection connection=null;
 ResultSet rs = null;
 PreparedStatement pst = null;
    /**
     * Creates new form affguide
     */
    public AfficherGuide() {
        initComponents();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableguide = new javax.swing.JTable();
        nom = new javax.swing.JTextField();
        prix = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        resume = new javax.swing.JTextArea();
        statistique = new javax.swing.JButton();
        guidepdf = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Recherche du guide");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        getContentPane().add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 300, -1));

        tableguide.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableguide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableguideMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableguide);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 510, 95));
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 370, 300, -1));
        getContentPane().add(prix, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 520, 300, -1));

        resume.setColumns(20);
        resume.setRows(5);
        jScrollPane2.setViewportView(resume);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 330, -1));

        statistique.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        statistique.setIcon(new javax.swing.ImageIcon("C:\\Users\\Samsung\\Desktop\\img\\Actions-office-chart-line-icon.png")); // NOI18N
        statistique.setText("Statistique");
        statistique.setContentAreaFilled(false);
        statistique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statistiqueActionPerformed(evt);
            }
        });
        getContentPane().add(statistique, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 570, -1, -1));

        guidepdf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        guidepdf.setIcon(new javax.swing.ImageIcon("C:\\Users\\Samsung\\Desktop\\img\\Adobe-PDF-Document-icon.png")); // NOI18N
        guidepdf.setText("Guide PDF");
        guidepdf.setContentAreaFilled(false);
        guidepdf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        guidepdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guidepdfActionPerformed(evt);
            }
        });
        getContentPane().add(guidepdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nom du guide");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 370, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Resume");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Prix");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel6.setText("Manipulation Guide");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 340, -1));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(table1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 570, 520, 94));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/retourb.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 670, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Samsung\\Desktop\\img\\back.jpg")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      
         try {
            connection=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(GuideDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       try
       {
            String requete="select nom,resume,prix from guide";
       PreparedStatement ps=connection.prepareStatement(requete);
       ResultSet resultat=ps.executeQuery();
       //tableguide.setModel(DbUtils.resultSetToTableModel(resultat));
       table1.setModel(DbUtils.resultSetToTableModel(resultat));
          
       } catch(SQLException ex)
       {
          Logger.getLogger(GuideDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
         
       }
       
        
    }//GEN-LAST:event_formWindowOpened

    private void tableguideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableguideMouseClicked
        try {
            connection=MyConnection.getInstance();
        } catch (IOException ex) {
        }
          
          
        try {
             int row =tableguide.getSelectedRow();
         String tab = (tableguide.getModel().getValueAt(row, 0).toString());
         String sql ="select nom,resume,prix from guide where nom= '"+tab+"' ";
            PreparedStatement ps=connection.prepareStatement(sql);
       ResultSet resultat=ps.executeQuery();
            if (resultat.next()) {
                
            
                String add1=resultat.getString("nom");
                nom.setText(add1);
                String add2=resultat.getString("resume");
                resume.setText(add2);
                String add3=resultat.getString("prix");
                prix.setText(add3);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuideDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
        }
    }//GEN-LAST:event_tableguideMouseClicked

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased

        try {
         String sql ="select nom,resume,prix from guide where nom=? ";
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,searchField.getText());
       ResultSet resultat=ps.executeQuery();
           tableguide.setModel(DbUtils.resultSetToTableModel(resultat));
        } catch (SQLException ex) {
            Logger.getLogger(GuideDAO.class.getName()).log(Level.SEVERE,null,ex);
           System.out.println("erreur lors de la mise a jour"+ex.getMessage());
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    private void statistiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statistiqueActionPerformed
       try {
            String query ="SELECT nom,prix FROM guide";
        JDBCCategoryDataset dataset = new JDBCCategoryDataset(MyConnection.getInstance(),query);
           JFreeChart chart = ChartFactory.createLineChart("Mes guides et leur prix", "nom", "prix", dataset,PlotOrientation.VERTICAL,false,true,true);
            BarRenderer render=null;
            CategoryPlot plot =null;
            render = new BarRenderer();
            ChartFrame frame=new ChartFrame("Mes guides et leur prix",chart);
            frame.setVisible(true);
            frame.setSize(400,650);
            final ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
            final File file1 = new File("chart.png");
            ChartUtilities.saveChartAsPNG(file1, chart, 600, 400,info); 
          
               
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_statistiqueActionPerformed

    private void guidepdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guidepdfActionPerformed
        try {
            
            String value1=nom.getText();
            String value2=resume.getText();
            String value3=prix.getText().toString();
            Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("Guide.pdf"));
        doc.open();
        
        doc.add(new Paragraph("Mon Guide",FontFactory.getFont(FontFactory.TIMES_BOLD,18,Font.BOLD,BaseColor.BLUE)));
        doc.add(new Paragraph(new Date().toString()));
        doc.add(new Paragraph("******************************************************"));
        PdfPTable table = new PdfPTable(2);
        PdfPCell cell = new PdfPCell(new Paragraph("Title"));
        cell.setColspan(4);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBackgroundColor(BaseColor.GREEN);
        table.addCell(cell);
        table.addCell("Nom du guide");
        table.addCell(value1);
        table.addCell("Resume");
        table.addCell(value2);
        table.addCell("Prix");
        table.addCell(value3);
        doc.add(table);
        com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("chart.png");
        img.scaleAbsolute(480,360);
        doc.add(img);
        doc.close();
        JOptionPane.showMessageDialog(null,"Rapport enregistré");
        
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_guidepdfActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
       MenuGuide m=new MenuGuide();
       m.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AfficherGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AfficherGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AfficherGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfficherGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AfficherGuide().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guidepdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField prix;
    private javax.swing.JTextArea resume;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton statistique;
    private javax.swing.JTable table1;
    private javax.swing.JTable tableguide;
    // End of variables declaration//GEN-END:variables
}
