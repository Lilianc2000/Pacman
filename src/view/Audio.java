package view;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Audio Class to play sound in the game
 * Code is mostly taken on internet
 * @author Lilian Cizeron
 *
 */
public abstract class Audio{
	
	// Fonction de l'audio du jeu
	public static synchronized void playSound(final String url) {
	// Lancement d'un thread pour ne pas bloquer le programme pendant la lecture du fichier son
	  new Thread(new Runnable() {
	    public void run() {
	      try {
	    	  
	    	 // Ouverture du fichier son
	    	 InputStream audioSrc = getClass().getResourceAsStream("/view/" + url);
	         Clip clip = AudioSystem.getClip();
	         
	         // Mise en buffer (requis pour avoir le son dans le .jar)
	         InputStream bufferedIn = new BufferedInputStream(audioSrc);
	         AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
	         
	         // Lancement du son
	         clip.open(audioStream);
	         clip.start(); 
	         
	      } 
	      catch (Exception e) {
	      }
	    }
	  }).start();
	}
}