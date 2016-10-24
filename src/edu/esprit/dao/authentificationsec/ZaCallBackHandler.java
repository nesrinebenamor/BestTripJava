/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.authentificationsec;

import edu.esprit.dao.graphics.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 *
 * @author esprit
 */
public class ZaCallBackHandler implements CallbackHandler{
    
    
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        NameCallback nameCallback=null;
    PasswordCallback passwordCallback=null;
    int counter=0;
    while(counter<callbacks.length)
    {
        if(callbacks[counter] instanceof NameCallback)
        {
            nameCallback=(NameCallback) callbacks[counter++];
            System.out.println(nameCallback.getPrompt());
            nameCallback.setName(new BufferedReader(new InputStreamReader(System.in)).readLine());
        }else if (callbacks[counter] instanceof PasswordCallback){
            passwordCallback=(PasswordCallback) callbacks[counter++];
            System.out.println(passwordCallback.getPrompt());
            passwordCallback.setPassword(new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray());
        }
    }

    }
    
}
