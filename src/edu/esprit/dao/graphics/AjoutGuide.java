/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.entities.Guide;
import edu.esprit.dao.entities.Utilisateur;
import edu.esprit.dao.implementations.GuideDAO;
import edu.esprit.dao.implementations.UtilisateurDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class AjoutGuide extends javax.swing.JFrame {
     private int id;
     private String login;
    /**
     * Creates new form ajoutguide
     */
    public AjoutGuide() {
        initComponents();
    }

    public AjoutGuide(int id, String login) {
        this.id = id;
        this.login = login;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nom = new javax.swing.JTextField();
        prix = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resume = new javax.swing.JTextArea();
        ajouterguide = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1063, 737));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nom guide");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Resumé");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Prix");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));
        getContentPane().add(nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 310, -1));
        getContentPane().add(prix, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 320, -1));

        resume.setColumns(20);
        resume.setRows(5);
        jScrollPane1.setViewportView(resume);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 310, -1));

        ajouterguide.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ajouterguide.setIcon(new javax.swing.ImageIcon("C:\\Users\\Samsung\\Desktop\\img\\book-add-icon.png")); // NOI18N
        ajouterguide.setText("Ajouter");
        ajouterguide.setContentAreaFilled(false);
        ajouterguide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterguideActionPerformed(evt);
            }
        });
        getContentPane().add(ajouterguide, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel4.setText("Ajouter Guide");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        jButton1.setText("retour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Samsung\\Desktop\\img\\back.jpg")); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(1063, 737));
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajouterguideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterguideActionPerformed
        String varnom = nom.getText();
        String varresume = resume.getText();
        String varprix = prix.getText();
        Guide g = new Guide();
        UtilisateurDAO utDAO=new UtilisateurDAO();
        Utilisateur ut=new Utilisateur();
        System.out.println(login);
        ut=utDAO.rechercherUtilisateurByLogin(login);
        //System.out.println(ut.getId());
        g.setNom(varnom);
        g.setResume(varresume);
        g.setResume(varprix);
        g.setUtilisateur(ut);
        
        GuideDAO gDAO = new GuideDAO();
        gDAO.ajouterguide(g);
        JOptionPane.showMessageDialog(rootPane, "ajout effectué");        // TODO add your handling code here:
    }//GEN-LAST:event_ajouterguideActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.setVisible(false);
       MenuGuide m=new MenuGuide();
       m.setVisible(true);        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(AjoutGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjoutGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjoutGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjoutGuide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjoutGuide().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajouterguide;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField prix;
    private javax.swing.JTextArea resume;
    // End of variables declaration//GEN-END:variables
}