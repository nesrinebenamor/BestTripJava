/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;
import java.io.File;

/**
 *
 * @author Samsung
 */
public class VideoUtils {
    public final static String avi = "avi";
    public final static String mpg = "mpg";
    public final static String mp4 = "mp4";
    public final static String mwv = "wmv";
    public final static String mov = "mov";
    
        public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
