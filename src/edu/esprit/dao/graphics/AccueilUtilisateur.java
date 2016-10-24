/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

/**
 *
 * @author zamama
 */
public class AccueilUtilisateur extends javax.swing.JFrame {

    String login;
    int id;

    /**
     * Creates new form acceuil_utilisateur
     */
    public AccueilUtilisateur() {
        initComponents();
    }
    
      public AccueilUtilisateur(int id) {
        initComponents();
        this.id = id;
    }
    public AccueilUtilisateur(String login, int id) {
        initComponents();
        this.login = login;
        this.id = id;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bC = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        forum = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        GC = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        BCONS = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/billl.png"))); // NOI18N
        bC.setContentAreaFilled(false);
        bC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCActionPerformed(evt);
            }
        });
        getContentPane().add(bC, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 60, 80));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Gestion Profil");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 110, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Espace Experience");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Espace Guide");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, -1, -1));

        forum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/3D infographic5_1.png"))); // NOI18N
        forum.setContentAreaFilled(false);
        forum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forumActionPerformed(evt);
            }
        });
        getContentPane().add(forum, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 440, 90, 70));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/logout-icone-7871-64.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 60, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Forum");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 510, -1, -1));

        GC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/avion1.png"))); // NOI18N
        GC.setContentAreaFilled(false);
        GC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GCActionPerformed(evt);
            }
        });
        getContentPane().add(GC, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/logo_Best_Trip.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 150));

        BCONS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/bateau.png"))); // NOI18N
        BCONS.setContentAreaFilled(false);
        BCONS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BCONSMouseClicked(evt);
            }
        });
        getContentPane().add(BCONS, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Espace Recommandation");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 190, 20));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/address-book-icon.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/tt.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 990, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCActionPerformed
        this.setVisible(false);
        MenuUtilisateur a = new MenuUtilisateur(login, id);
        a.setVisible(true);
    }//GEN-LAST:event_bCActionPerformed

    private void GCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GCActionPerformed
        this.setVisible(false);
        MenuGuide a = new MenuGuide(login, id);
        a.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_GCActionPerformed

    private void forumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forumActionPerformed
        ForumGeneral forum = new ForumGeneral();
        forum.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_forumActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        Authentification a = new Authentification();
        a.setVisible(true);    }//GEN-LAST:event_jButton1ActionPerformed

    private void BCONSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCONSMouseClicked
        this.setVisible(false);
        System.out.println(id);
        Acc_Exp a = new Acc_Exp(id,login);
        a.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_BCONSMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       AjoutRecommandation ajR=new AjoutRecommandation(login, id);
       this.setVisible(false);
       ajR.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AccueilUtilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccueilUtilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccueilUtilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccueilUtilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccueilUtilisateur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCONS;
    private javax.swing.JButton GC;
    private javax.swing.JButton bC;
    private javax.swing.JButton forum;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}