/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.FbConnect.Facebook;
import edu.esprit.dao.entities.Utilisateur;
import edu.esprit.dao.implementations.UtilisateurDAO;
import java.util.Properties;
import javax.mail.Session;
import javax.swing.JOptionPane;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.*;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author zamama
 */
public class Authentification extends javax.swing.JFrame {

    public String login="";
    public int id=0;

    /**
     * /**
     * Creates new form auth
     */
    public Authentification() {
        initComponents();
    }

    public Authentification(String login, int id) {
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

        connectButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        nomField = new javax.swing.JTextField();
        passwordFiled = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        connectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/buttonAuth.png"))); // NOI18N
        connectButton.setContentAreaFilled(false);
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });
        getContentPane().add(connectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 459, 130, 50));

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/Sans titre1.png"))); // NOI18N
        jButton1.setText("mot de passe oublié");
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 190, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/fbconnect.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 180, 50));

        nomField.setBackground(new java.awt.Color(209, 208, 208));
        nomField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(nomField, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 300, 20));

        passwordFiled.setBackground(new java.awt.Color(209, 208, 208));
        passwordFiled.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(passwordFiled, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 300, 20));

        jButton3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/Button-Ok-icon.png"))); // NOI18N
        jButton3.setText("s'inscrire");
        jButton3.setContentAreaFilled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 120, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/auth1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed

         String login = nomField.getText();
        String password = passwordFiled.getText();
        int taille=password.length();
         String pwd=password.substring(0,taille) ;
         System.out.println(pwd);
         System.out.println("login"+login);
         System.out.println("pass"+pwd);

       // String pwd='SUBSTR(`password`, 1,'taille' )as password';
        
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        if (utilisateurDAO.authenitification(login, pwd) == true) {
            JOptionPane.showMessageDialog(null, "Authentification effectuée avec succès");
            Utilisateur utilisateur = utilisateurDAO.rechercherUtilisateurByLogin(login);
            login = (String) utilisateur.getLogin();
            id = (int) utilisateur.getId();
            System.out.println(login + id);
            if (utilisateurDAO.estAdmin(login) == true) {
                this.setVisible(false);
                AccueilAdmin c = new AccueilAdmin(login, id);
                // ModificationProfil c=new ModificationProfil(login,id);
                c.setVisible(true);
            } else {
                this.setVisible(false);
                AccueilUtilisateur m = new AccueilUtilisateur(login, id);
                //ConsultationProfil m=new ConsultationProfil(login, id);
                m.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Authentification non aboutie");
        }

    }//GEN-LAST:event_connectButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        Utilisateur utilisateur = new Utilisateur();
        String login = nomField.getText();
        //String password=passwordFiled.getText();

        String email = utilisateurDAO.recupererEmailByLogin(login);
        String password = utilisateurDAO.recupererPasswordByLogin(login);

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session;
        session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("ghaya.zarrouk@esprit.tn", "ghayazarrouk");
                    }

                }
        );

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress("ghaya.zarrouk@esprit.tn"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); //mel base
            message.setSubject("lost password");
            message.setText(password); //mel base
            Transport.send(message);

            JOptionPane.showMessageDialog(null, "Votre mot de passe vous a été envoyé sur votre adresse Mail");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        Facebook.connecterFB();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       AjoutUtilisateur ajout=new AjoutUtilisateur();
       ajout.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Authentification.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Authentification().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nomField;
    private javax.swing.JPasswordField passwordFiled;
    // End of variables declaration//GEN-END:variables
}
