/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.FbConnect;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.User;
import edu.esprit.dao.entities.Utilisateur;
import edu.esprit.dao.graphics.AccueilUtilisateur;
import edu.esprit.dao.graphics.EspaceUtilisateur;
import edu.esprit.dao.implementations.UtilisateurDAO;
import static java.lang.System.out;
import javax.swing.JOptionPane;

/**
 *
 * @author esprit
 */
public class GraphReader {

    private static FacebookClient facebookClient;

    public static void main(String[] args) {

    }

    GraphReader(String accessToken) {
        facebookClient = new DefaultFacebookClient(accessToken);
    }

    void runEverything() {
        fetchObject();
    }

    Utilisateur fetchObject() {
        out.println("* fetching single objects *");
        User user = facebookClient.fetchObject("me", User.class);
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO();
        /* System.out.println(user.getName());
         System.out.println(user.getEmail());
         System.out.println(user.getBirthday());
         System.out.println(user.getFirstName());
         System.out.println(user.getBirthday());*/
        JOptionPane.showMessageDialog(null, "Bonjour \n " + user.getFirstName() + " " + user.getLastName());

        Utilisateur curUser = new Utilisateur();
        curUser.setLogin(user.getUsername());
        System.out.println("*******" + user.getUsername());
        curUser.setNom(user.getLastName());
        curUser.setPrenom(user.getFirstName());
        curUser.setMail(user.getEmail());
        if (!utilisateurDAO.verifierExistance(user.getEmail())) {
            utilisateurDAO.ajouterUtilisateur(curUser);
        }
        int id=utilisateurDAO.RecupererId(user.getEmail());
        AccueilUtilisateur e = new AccueilUtilisateur(user.getEmail(),id);
        e.setVisible(true);
        return curUser;

    }

    public static String getAccessToken() {
        return Facebook.access_token;
    }

    public static boolean isConnect() {
        if (facebookClient != null) {
            return true;
        } else {
            return false;
        }
    }
    /*
     public static String addComment(String idpost, String message) {
     FacebookType publishMessageResponse = facebookClient.publish(idpost + "/comments", FacebookType.class, Parameter.with("message", message));
     return publishMessageResponse.getId();
     }
    
    
     public static boolean deleteComment(String idComment) {
     Boolean deleted = facebookClient.deleteObject(idComment);
     return deleted.booleanValue();
     }*/

}
