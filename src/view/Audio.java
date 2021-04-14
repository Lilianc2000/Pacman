package view;

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
	        Clip clip = AudioSystem.getClip();
	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
	          Main.class.getResourceAsStream("/view/" + url));
	        clip.open(inputStream);
	        clip.start(); 
	      } catch (Exception e) {
	        System.err.println(e.getMessage());
	      }
	    }
	  }).start();
	}
	
	public static void stop() {
		
		play = false;
		
	}
}