/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

/**
 *
 * @author esprit
 */
public class AfficheExperience extends javax.swing.JFrame {

    /**
     * Creates new form AfficheExperience1
     */
    public AfficheExperience() {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        export = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ajout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Liste d'Expérience");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 340, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        MyTableModel model=new MyTableModel(this);
        table.setModel(model);
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 660, 260));

        export.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        export.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/Adobe-PDF-Document-icon.png"))); // NOI18N
        export.setText("Exporter");
        export.setContentAreaFilled(false);
        getContentPane().add(export, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, 130, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/retourb.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 50, 50));

        ajout.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/ajouter-en-plus-icone-9315-48.png"))); // NOI18N
        ajout.setText("Nouvelle expérience");
        ajout.setContentAreaFilled(false);
        ajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajoutActionPerformed(evt);
            }
        });
        getContentPane().add(ajout, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 580, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/back.jpg"))); // NOI18N
        jLabel2.setAutoscrolls(true);
        jLabel2.setMinimumSize(new java.awt.Dimension(1064, 734));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Acc_Exp acc=new Acc_Exp();
        acc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void ajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajoutActionPerformed

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
            java.util.logging.Logger.getLogger(AfficheExperience.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AfficheExperience.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AfficheExperience.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AfficheExperience.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AfficheExperience().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajout;
    private javax.swing.JButton export;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}