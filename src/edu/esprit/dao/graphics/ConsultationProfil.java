/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.entities.Utilisateur;
import edu.esprit.dao.implementations.UtilisateurDAO;
import javax.swing.ImageIcon;
//import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author esprit
 */
public class ConsultationProfil extends javax.swing.JFrame {
public String login;
public static int id;

    /**
     * Creates new form AjoutAdministrateur
     */
    public ConsultationProfil() {
        initComponents();
        setLocationRelativeTo(null);
          nomField.setEditable(false);
        prenomField.setEditable(false);
        emailField.setEditable(false);
        loginField.setEditable(false);
        passField.setEditable(false);
        ageField.setEditable(false);
        
    }
    
    public ConsultationProfil(String login,int id) {
       
        this.login=login;
        this.id=id;
         UtilisateurDAO utilisateurDAO=new UtilisateurDAO();
         Utilisateur utilisateur=utilisateurDAO.rechercherUtilisateurByLogin(login);
         initComponents();
         nomField.setEditable(false);
        prenomField.setEditable(false);
        emailField.setEditable(false);
        loginField.setEditable(false);
        passField.setEditable(false);
        ageField.setEditable(false);
         nomField.setText(utilisateur.getNom());
         prenomField.setText(utilisateur.getPrenom());
         emailField.setText(utilisateur.getMail());
         loginField.setText(utilisateur.getLogin());
         passField.setText(utilisateur.getPassword());
         ageField.setText(Integer.toString(utilisateur.getAge()));
         System.out.println(utilisateur.getImage());
         ImageIcon image = new ImageIcon("C:/wamp/www/MobileAppUtilisateur/src/image/"+utilisateur.getImage());
        // String chemin="C:/Users/esprit/Desktop/";
         
         imageLabel.setIcon(image);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nomEdit = new javax.swing.JLabel();
        prenomEdit = new javax.swing.JLabel();
        emailEdit = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ageEdit = new javax.swing.JLabel();
        passEdit = new javax.swing.JLabel();
        nomField = new javax.swing.JTextField();
        prenomField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        loginField = new javax.swing.JTextField();
        passField = new javax.swing.JPasswordField();
        ageField = new javax.swing.JTextField();
        retourButton = new javax.swing.JButton();
        imgpanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setText("Mon profil");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 260, 70));

        nomEdit.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        nomEdit.setText("Nom");
        getContentPane().add(nomEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 80, -1));

        prenomEdit.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        prenomEdit.setText("Prénom");
        getContentPane().add(prenomEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 90, -1));

        emailEdit.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        emailEdit.setText("Email");
        getContentPane().add(emailEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 70, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Login");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 60, -1));

        ageEdit.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ageEdit.setText("Age");
        getContentPane().add(ageEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 80, -1));

        passEdit.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        passEdit.setText("Mot de passe");
        getContentPane().add(passEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 110, -1));

        nomField.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        nomField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(nomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 200, -1));

        prenomField.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        prenomField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(prenomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 200, -1));

        emailField.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        emailField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 200, -1));

        loginField.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        loginField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(loginField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 200, -1));

        passField.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        passField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 200, -1));

        ageField.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        ageField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(ageField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 40, -1));

        retourButton.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        retourButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/retourb.png"))); // NOI18N
        retourButton.setContentAreaFilled(false);
        retourButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                retourButtonMouseClicked(evt);
            }
        });
        retourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retourButtonActionPerformed(evt);
            }
        });
        getContentPane().add(retourButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 100, -1));

        imgpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/avatar.png"))); // NOI18N
        imgpanel.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 170));

        getContentPane().add(imgpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 60, 150, 170));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/back.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, 0, 1100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void retourButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_retourButtonMouseClicked
      this.setVisible(false);
        MenuUtilisateur m=new MenuUtilisateur(login,id);
      m.setVisible(true);
    }//GEN-LAST:event_retourButtonMouseClicked

    private void retourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retourButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_retourButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultationProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultationProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultationProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultationProfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ConsultationProfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ageEdit;
    private javax.swing.JTextField ageField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel emailEdit;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel imgpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField loginField;
    private javax.swing.JLabel nomEdit;
    private javax.swing.JTextField nomField;
    private javax.swing.JLabel passEdit;
    private javax.swing.JPasswordField passField;
    private javax.swing.JLabel prenomEdit;
    private javax.swing.JTextField prenomField;
    private javax.swing.JButton retourButton;
    // End of variables declaration//GEN-END:variables
}