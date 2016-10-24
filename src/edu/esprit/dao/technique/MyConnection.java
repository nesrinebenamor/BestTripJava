/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.technique;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esprit
 */
public class MyConnection {
    Properties properties;
    private String url;
    private String login;
    private String pwd;
    private static Connection instance;
    
    private MyConnection() throws IOException
    { properties=new Properties();
        try {
            properties.load(new FileInputStream(new File("Configuration.properties")));
            url=properties.getProperty("url");
            login=properties.getProperty("utilisateur");
            pwd=properties.getProperty("pwd");
            instance=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connection établie");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Connection getInstance() throws IOException
    {
        if(instance==null)
        {
            new MyConnection();
        }
        return instance;
    }
    
    
}
