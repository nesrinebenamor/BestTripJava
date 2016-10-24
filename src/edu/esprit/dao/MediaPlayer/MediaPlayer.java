/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.dao.MediaPlayer;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author Samsung
 */
public class MediaPlayer extends EmbeddedMediaPlayerComponent{
    
    public MediaPlayer() {
 
    }

    @Override
    public void stopped(uk.co.caprica.vlcj.player.MediaPlayer mediaPlayer) {
        super.stopped(mediaPlayer); //To change body of generated methods, choose Tools | Templates.
    }
    
}
