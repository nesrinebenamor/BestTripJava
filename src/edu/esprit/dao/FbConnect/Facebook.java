/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.FbConnect;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserNavigationEvent;
import com.restfb.DefaultFacebookClient;
import static edu.esprit.dao.FbConnect.Main.access_token;
import static edu.esprit.dao.FbConnect.Main.firstRequestDone;
import static edu.esprit.dao.FbConnect.Main.secondRequest;
import static edu.esprit.dao.FbConnect.Main.secondRequestDone;
import edu.esprit.dao.entities.Utilisateur;
import edu.esprit.dao.implementations.UtilisateurDAO;
import java.awt.BorderLayout;
import java.io.IOException;
import java.io.StringReader;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

/**
 *
 * @author esprit
 */
public class Facebook {
    public static String API_KEY = "1540989439523369";
    public static String SECRET = "066f6b70737f47375b416ce75730a469";

    public static String firstRequest = "https://graph.facebook.com/oauth/authorize?"
            + "client_id="
            + API_KEY
            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
            + "scope=publish_stream,offline_access,create_event,read_stream,email,user_birthday";

    public static String secondRequest = "https://graph.facebook.com/oauth/access_token?"
            + "client_id="
            + API_KEY
            + "&redirect_uri=http://www.facebook.com/connect/login_success.html&"
            + "client_secret=" + SECRET + "&code=";

    public static String access_token = "";
    public static boolean firstRequestDone = false;
    public static boolean secondRequestDone = false;

    /**
     * @param args
     */
    
    public static String connecterFB()
    {
         SwingUtilities.invokeLater(new Runnable() 
         {
               @Override
            public void run()
            {
                 NativeInterface.open();
                NativeInterface.initialize();
                
                final JFrame loginFrame=new JFrame();
                JPanel webBrowserPanel =new JPanel(new BorderLayout());
                final JWebBrowser webBrowser = new JWebBrowser();
                
                webBrowser.setMenuBarVisible(false);
                webBrowser.setButtonBarVisible(false);
                webBrowser.setLocationBarVisible(false);
                final String fb_url="http://www.facebook.com";
                webBrowser.navigate(fb_url);
                webBrowser.navigate(firstRequest);
                webBrowser.addWebBrowserListener(new WebBrowserAdapter() {
                    @Override
                    public void locationChanged(WebBrowserNavigationEvent e)
                    {
                        super.locationChanged(e);
                        System.out.println("0");
                        if(!firstRequestDone)
                        {
                            System.out.println("0.1");
                            if(e.getNewResourceLocation().contains("http://www.facebook.com/connect/login_success.html?code=")){
                                String[] splits=e.getNewResourceLocation().split("=");
                                 String stage2temp = secondRequest + splits[1];
                                        System.out.println("First =" + splits[1]);
                                        webBrowser.navigate(stage2temp);
                                        firstRequestDone = true;
                                        System.out.println("1");
                            }
                        }
                        else{
                             if (!secondRequestDone) {
                                 System.out.println("2");
                                        System.out.println(webBrowser.getHTMLContent());
                                        // Create reader with the html content
                                        StringReader readerSTR = new StringReader(webBrowser.getHTMLContent());
                                        // Create a callback for html parser
                                        HTMLEditorKit.ParserCallback callback
                                                = new HTMLEditorKit.ParserCallback() {
                                                    @Override
                                                    public void handleText(char[] data, int pos) {
                                                        System.out.println(data);
                                                        System.out.println("3");
                // because there is only one line with the access_token 
                                                        // in the html content you can parse it.
                                                        String string = new String(data);
                                                        //System.out.println(string);
                                                        String[] temp2 = string.split("=");
                                                        
                                                        String[] temp1 = temp2[1].split("&");
                                                        System.out.println(temp1[0]);
                                                        
                                                        //System.out.println(temp2);
                                                        
                                                        //String[] temp3 = temp2[0].split("&");
                                                        
                                                        //System.out.println("access tocken=" + temp3);
                                                        access_token = temp1[0];
                                                                 System.out.println("acce =="+access_token);

                                                        loginFrame.dispose();
                                                        retrieveUser();
                        }
};
                                            try {
                                            // Call the parse method 
                                            new ParserDelegator().parse(readerSTR, callback, false);
                                        } catch (IOException e1) {
                                            e1.printStackTrace();
                                        }
                
            }
         }
    }
    
    
});
                webBrowserPanel.add(webBrowser, BorderLayout.CENTER);
                        loginFrame.add(webBrowserPanel);
                        loginFrame.setSize(400, 500);
                        loginFrame.setVisible(true);
            }
         });
//        DefaultFacebookClient facebookClient = new DefaultFacebookClient(access_token);
//        Utilisateur curU;
//        curU = new GraphReader(access_token).fetchObject();
         return access_token;
    }
   
    
public static void retrieveUser()
{
Utilisateur curU;
        curU = new GraphReader(access_token).fetchObject();
        //curU.setRoles("a:1:{i:0;s:12:\"ROLE_CITYOEN\";}");
        UtilisateurDAO uDAO = new UtilisateurDAO();
        Utilisateur user = uDAO.selectUserByMail(curU.getMail());
        if (user == null) {
            int id = uDAO.insertUser(curU);
            curU.setId(id);
           // MainFrame.getInstance(curU).setVisible(true);
        }
        else{
            //MainFrame.getInstance(user).setVisible(true);
        }
}

public static String getAccessToken()
{
    return access_token;
}
        
}
    
