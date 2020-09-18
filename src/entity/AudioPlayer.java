/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

/**
 *
 * @author ChaiZhiYing
 */
public class AudioPlayer {

    private Clip clip;             //to play audio
    private String filePath;       //the file path of audio
    private AudioInputStream audioInputStream; //Java Packages

    public AudioPlayer(String filePath) {

        this.filePath = filePath;

        //initialize clip
        try {
            clip = AudioSystem.getClip();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }

        //set audioInputStream
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(this.filePath).getAbsoluteFile());
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }

    public void play() {
        if (!clip.isActive()) {
            clip.start();
        }
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void pause() {
        if (clip.isActive()) {
            clip.stop();
        }
    }
    
    public void restart() {
        if (clip.isActive()) {
            clip.stop();
            System.out.println("stoped"); // i have to put this, in order to not having glitch when two sound collide with each other
        }
        
        clip.setMicrosecondPosition(0);
    }
    
    public void close() {
        clip.close();
    }

    //reset audio
    /*
    public void resetAudioStream() {

        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(this.filePath).getAbsoluteFile());
            clip.open(audioInputStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(0);
        }
    }
    */
}