/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.authentificationsec;

import edu.esprit.dao.graphics.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 *
 * @author esprit
 */
public class Driver {
    
    public static void main(String[] arwronggs) {
        System.setProperty("java.security.auth.login.config", "jaastutorial.config");
        LoginContext loginContext=null;
        try {
            loginContext=new LoginContext("ZaJaasTutorial",new ZaCallBackHandler());
        } catch (LoginException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        while(true)
        {
            try {
                loginContext.login();
                System.exit(0);
            } catch (LoginException ex) {
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
