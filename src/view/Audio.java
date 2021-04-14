package view;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public abstract class Audio{
	
	static boolean play = true;
	
	// Fonction de l'audio du jeu
	public static synchronized void playSound(final String url) {
	  new Thread(new Runnable() {
	    public void run() {
	      try {
	    	 play = true;
	    	 InputStream audioSrc = getClass().getResourceAsStream("/view/" + url);
	         Clip clip = AudioSystem.getClip();
	         InputStream bufferedIn = new BufferedInputStream(audioSrc);
	         AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
	         clip.open(audioStream);
	         clip.start(); 
	      } catch (Exception e) {
	      }
	    }
	  }).start();
	}
	
	public static synchronized void stop() {
		
		play = false;
		
	}
}