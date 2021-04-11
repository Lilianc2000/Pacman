package game;

import java.awt.Color;

/**
 * Class Wall
 * Represent a wall on the map
 * @author Lilian Cizeron
 *
 */

public class Wall extends Entite {

	// La couleur du mur : bleu
	private static final Color color = Color.BLUE;
	
	/**
	 * Constructor of Wall
	 * @param x the x position of the wall
	 * @param y the y position of the wall
	 */
	
	public Wall(int x, int y) {

		super(color, x, y);

	}

}
