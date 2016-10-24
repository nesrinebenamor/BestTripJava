/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import edu.esprit.dao.entities.Utilisateur;
import edu.esprit.dao.implementations.AdministrateurDAO;
import edu.esprit.dao.implementations.UtilisateurDAO;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author esprit
 */
public class ModificationAdministrateur extends javax.swing.JFrame {
  String login="";
   int id;
    /**
     * Creates new form ModificationUtilisateur
     */
    public ModificationAdministrateur() {
        initComponents();

    }

    public ModificationAdministrateur(int id,String login) {
        this.id = id;
        this.login=login;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        varNom = new javax.swing.JLabel();
        varPrenom = new javax.swing.JLabel();
        varEmail = new javax.swing.JLabel();
        varLogin = new javax.swing.JLabel();
        varPassword = new javax.swing.JLabel();
        varAge = new javax.swing.JLabel();
        NomEdit = new javax.swing.JTextField();
        PrenomEdit = new javax.swing.JTextField();
        EmailEdit = new javax.swing.JTextField();
        LoginEdit = new javax.swing.JTextField();
        AgeEdit = new javax.swing.JTextField();
        PasswordEdit = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        nomComboBox = new javax.swing.JComboBox();
        ModifierButton = new javax.swing.JButton();
        QuitterButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(599, 319));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(1063, 737));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Modification Administrateur");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, -1));

        varNom.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        varNom.setText("Nom");
        jPanel1.add(varNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 76, -1));

        varPrenom.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        varPrenom.setText("Prenom");
        jPanel1.add(varPrenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 76, 20));

        varEmail.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        varEmail.setText("Email");
        jPanel1.add(varEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 76, -1));

        varLogin.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        varLogin.setText("Login");
        jPanel1.add(varLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 76, -1));

        varPassword.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        varPassword.setText("Password");
        jPanel1.add(varPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 76, -1));

        varAge.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        varAge.setText("Age");
        jPanel1.add(varAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, 76, -1));

        NomEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NomEditKeyPressed(evt);
            }
        });
        jPanel1.add(NomEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 180, -1));

        PrenomEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PrenomEditKeyPressed(evt);
            }
        });
        jPanel1.add(PrenomEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 180, -1));

        EmailEdit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailEditFocusLost(evt);
            }
        });
        jPanel1.add(EmailEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 180, 20));

        LoginEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LoginEditKeyPressed(evt);
            }
        });
        jPanel1.add(LoginEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 180, 20));

        AgeEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AgeEditKeyPressed(evt);
            }
        });
        jPanel1.add(AgeEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 40, -1));

        PasswordEdit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordEditFocusLost(evt);
            }
        });
        jPanel1.add(PasswordEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 180, -1));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Nom d'utilisateur");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 127, -1));

        nomComboBox.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        nomComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                nomComboBoxItemStateChanged(evt);
            }
        });
        jPanel1.add(nomComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 182, -1));

        ModifierButton.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        ModifierButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/modifier.png"))); // NOI18N
        ModifierButton.setContentAreaFilled(false);
        ModifierButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModifierButtonMouseClicked(evt);
            }
        });
        jPanel1.add(ModifierButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 110, 70));

        QuitterButton.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        QuitterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/retourb.png"))); // NOI18N
        QuitterButton.setContentAreaFilled(false);
        QuitterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuitterButtonMouseClicked(evt);
            }
        });
        jPanel1.add(QuitterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 630, 110, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Modifier");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 630, 70, 20));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edu/esprit/dao/images/back.jpg"))); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(1063, 737));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void QuitterButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitterButtonMouseClicked
        this.setVisible(false);
         MenuAdministrateur m = new MenuAdministrateur(login,id);
          m.setVisible(true);
    }//GEN-LAST:event_QuitterButtonMouseClicked

    private void ModifierButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModifierButtonMouseClicked
          login=nomComboBox.getSelectedItem().toString();
          System.out.println(login);
          String prenom=PrenomEdit.getText();
          String email=EmailEdit.getText();
          String nom=NomEdit.getText();
          String password=PasswordEdit.getText();
          int age = Integer.parseInt(AgeEdit.getText());
          AdministrateurDAO administrateurDAO=new AdministrateurDAO();
          id=administrateurDAO.recupererId(login);
          Utilisateur utilisateur=new Utilisateur(id,nom,prenom,email,login,password,age);
          if( administrateurDAO.modifierAdministrateur(utilisateur))
            JOptionPane.showMessageDialog(rootPane,"Modification effectuée");
          else 
            JOptionPane.showMessageDialog(rootPane,"Modification non effectuée");  
    }//GEN-LAST:event_ModifierButtonMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         AdministrateurDAO administrateurDAO=new AdministrateurDAO();
       List<Utilisateur> resultat=administrateurDAO.afficherAdministrateurs();
       nomComboBox.addItem(null);
       for(Utilisateur utilisateur:resultat)
       {
           nomComboBox.addItem(utilisateur.getLogin());
           System.out.println(utilisateur.getLogin());
       }
    }//GEN-LAST:event_formWindowOpened

    private void nomComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_nomComboBoxItemStateChanged
        String nom=nomComboBox.getSelectedItem().toString();
        AdministrateurDAO administrateurDAO=new AdministrateurDAO();
        Utilisateur utilisateur=administrateurDAO.rechercherAdministrateurByNom(nom);
        initComponents();
        NomEdit.setText(utilisateur.getNom());
        PrenomEdit.setText(utilisateur.getPrenom());
        EmailEdit.setText(utilisateur.getMail());
        LoginEdit.setText(utilisateur.getLogin());
        PasswordEdit.setText(utilisateur.getPassword());
        AgeEdit.setText(Integer.toString(utilisateur.getAge()));
      
    }//GEN-LAST:event_nomComboBoxItemStateChanged

    private void AgeEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AgeEditKeyPressed
         char car= evt.getKeyChar();
        if((car<'0' || car>'9' ) && AgeEdit.getText().contains(".")
            && (car!=(char)KeyEvent.VK_BACK_SPACE))
        {
            evt.consume();
            JOptionPane.showMessageDialog(null,"seulment numero","validation  "
                ,JOptionPane.INFORMATION_MESSAGE);
        } else if
        ((car<'0' ||car>'9')&&(car!='.')
            &&(car!=(char)KeyEvent.VK_BACK_SPACE)){
            evt.consume();
            JOptionPane.showMessageDialog(null,"veuiller n'introduire que des chiffres","message de confirmation d'ecrire seulment des chiffres "
                ,JOptionPane.INFORMATION_MESSAGE); }
    }//GEN-LAST:event_AgeEditKeyPressed

    private void NomEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomEditKeyPressed
        char car= evt.getKeyChar();
        if((car<'a' || car>'z' ) && (car<'A' || car>'Z' )
            && (car!=(char)KeyEvent.VK_BACK_SPACE)&& (car!=(char)KeyEvent.VK_SPACE))
        {
            evt.consume();
            JOptionPane.showMessageDialog(null,"seulement les lettres qui sont acceptées ","validation d'accepter des lettres"
                ,JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_NomEditKeyPressed

    private void PrenomEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrenomEditKeyPressed
       char car= evt.getKeyChar();
        if((car<'a' || car>'z' ) && (car<'A' || car>'Z' )
            && (car!=(char)KeyEvent.VK_BACK_SPACE)&& (car!=(char)KeyEvent.VK_SPACE))
        {
            evt.consume();
            JOptionPane.showMessageDialog(null,"seulement les lettres qui sont acceptées ","validation d'accepter des lettres"
                ,JOptionPane.INFORMATION_MESSAGE);
    }     
    }//GEN-LAST:event_PrenomEditKeyPressed

    public boolean isEmail(String chaine)
    {Pattern pat=null;
     Matcher mat=null;    
    pat=Pattern.compile("^[\\w\\-\\_\\+]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
    mat=pat.matcher(chaine);
    if(mat.find())
    {
        return true;
    }
    else 
    {
        return false;
    }
    }
    
    
    
    private void EmailEditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailEditFocusLost
         if(isEmail(EmailEdit.getText()))
       {
           
       }
       else
       {
           JOptionPane.showMessageDialog(null, "Email incorrecte","veuillez entrer un mail valide",JOptionPane.INFORMATION_MESSAGE);
           EmailEdit.requestFocus();
       }
    }//GEN-LAST:event_EmailEditFocusLost

    private void PasswordEditFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordEditFocusLost
       if(PasswordEdit.getPassword().length >=8)
    {
        
    }
    else
    {
          JOptionPane.showMessageDialog(null, "Mot de passe incorrecte","veuillez entrer un mot de passe valide",JOptionPane.INFORMATION_MESSAGE);
           PasswordEdit.requestFocus();
    }
    }//GEN-LAST:event_PasswordEditFocusLost

    private void LoginEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoginEditKeyPressed
    char car= evt.getKeyChar();
        if((car<'a' || car>'z' ) && (car<'A' || car>'Z' )
            && (car!=(char)KeyEvent.VK_BACK_SPACE)&& (car!=(char)KeyEvent.VK_SPACE))
        {
            evt.consume();
            JOptionPane.showMessageDialog(null,"seulement les lettres qui sont acceptées ","validation d'accepter des lettres"
                ,JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_LoginEditKeyPressed

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
            java.util.logging.Logger.getLogger(ModificationAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificationAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificationAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificationAdministrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificationAdministrateur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AgeEdit;
    private javax.swing.JTextField EmailEdit;
    private javax.swing.JTextField LoginEdit;
    private javax.swing.JButton ModifierButton;
    private javax.swing.JTextField NomEdit;
    private javax.swing.JPasswordField PasswordEdit;
    private javax.swing.JTextField PrenomEdit;
    private javax.swing.JButton QuitterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox nomComboBox;
    private javax.swing.JLabel varAge;
    private javax.swing.JLabel varEmail;
    private javax.swing.JLabel varLogin;
    private javax.swing.JLabel varNom;
    private javax.swing.JLabel varPassword;
    private javax.swing.JLabel varPrenom;
    // End of variables declaration//GEN-END:variables
}