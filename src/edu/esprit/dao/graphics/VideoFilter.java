/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.graphics;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Samsung
 */
public class VideoFilter extends FileFilter{

  @Override
  public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Utils.getExtension(f);
        if (extension != null) {
            return extension.equals(VideoUtils.avi) ||
                    extension.equals(VideoUtils.mov) ||
                    extension.equals(VideoUtils.mp4) ||
                    extension.equals(VideoUtils.mpg) ||
                    extension.equals(VideoUtils.mwv);                  
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "*.avi \n *.mov \n *.mp4 \n *.mpg \n *.mwv";
    }
    
}
