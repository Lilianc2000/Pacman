package game;

import java.awt.Color;

/**
 * Class Empty
 * Represent an empty case on the map
 * @author Lilian Cizeron
 *
 */

public class Empty extends Entite {
	
	// La couleur du vide : noir
	private static final Color color = Color.BLACK;
	
	/**
	 * Constructor of Empty
	 * @param x the x position of the empty case
	 * @param y the y position of the empty case
	 */
	
	public Empty(int x, int y) {
		
		super(color, x, y);
		
	}

}
