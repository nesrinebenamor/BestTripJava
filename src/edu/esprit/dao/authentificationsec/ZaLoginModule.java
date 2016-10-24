/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.authentificationsec;

import edu.esprit.dao.graphics.*;
import edu.esprit.dao.technique.MyConnection;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

/**
 *
 * @author esprit
 */
public class ZaLoginModule implements LoginModule{
     private Connection connection;
    public static final String TEST_USER="meher";
    public static final String TEST_PASS="mehermeher";
    private CallbackHandler CallbackHandler=null;
    private boolean authentificationSuccessFlag=false;
    
    public ZaLoginModule()
    {
         try {
            connection=MyConnection.getInstance();
        } catch (IOException ex) {
            Logger.getLogger(ZaLoginModule.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
this.CallbackHandler=callbackHandler;
    }

    public boolean login(String login,String password) throws LoginException {
Callback[] callbackArray=new Callback[2];
NameCallback username=new NameCallback(login);
PasswordCallback pass=new PasswordCallback(password,false);
callbackArray[0]=username;
callbackArray[1]=pass;

        try {
            CallbackHandler.handle(callbackArray);
        } catch (IOException ex) {
            Logger.getLogger(ZaLoginModule.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedCallbackException ex) {
            ex.printStackTrace();
        }
        login=((NameCallback)callbackArray[0]).getName();
        password=new String(((PasswordCallback)callbackArray[1]).getPassword());
        if (TEST_USER.equals(login) && TEST_PASS.equals(password))
        {
            System.out.println("authentification avec succés");
            authentificationSuccessFlag=true;
        }
        else {
            authentificationSuccessFlag=false;
            //throw new FailedLoginException("authentification non aboutie");
             }
return  authentificationSuccessFlag;
    }

    @Override
    public boolean commit() throws LoginException {
return  authentificationSuccessFlag;
    }

    @Override
    public boolean abort() throws LoginException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean logout() throws LoginException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login() throws LoginException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
