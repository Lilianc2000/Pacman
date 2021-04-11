package logic;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

import data.Entite;

/**
 * Class Ghost
 * Represent a ghost with his variable and functions
 * @author Lilian Cizeron
 *
 */

public class Ghost extends Entite {
	
	// La couleur des fantomes : rouge
	private static final Color color = Color.RED;
	
	// La direction des fantomes
	private int direction_x = 0;
	private int direction_y = -1;
	
	/**
	 * Constructor of Ghost
	 * @param x the x position of the ghost
	 * @param y the y position of the ghost
	 */
	
	public Ghost(int x, int y) {
		
		super(color, x, y);
		
	}
	
	/**
	 * Method to move a ghost
	 * @param liste the list of entities on the map (including walls)
	 * @return this the actuallized ghost
	 */
	
	public void move_ghost(Entite[] liste) {
		for (int i = 0; i < liste.length; i++) {
			// Si ou on veut aller il y a un mur, on tente une autre direction
			if (liste[i].get_x() == this.x + direction_x || liste[i].get_y() == this.y + direction_y || liste[i] instanceof Wall || this.x + direction_x < 0 || this.x + direction_x > 14 || this.y + direction_y < 0 || this.y + direction_y > 14) {
				// Alors on cherche une autre direction pour le fantome, tant que la direction suivante est un mur ET que il n'y a pas une direction lin√©aire ET tant que l'on ne bouge pas ET que on est pas out of bounds
				while((liste[i].get_x() == this.x + direction_x && liste[i].get_y() == this.y + direction_y && liste[i] instanceof Wall) && (direction_x != 0 && direction_y != 0) && (direction_x == 0 && direction_y == 0) && (this.x + direction_x < 0 && this.x + direction_x > 14 && this.y + direction_y < 0 && this.y + direction_y > 14)) {
					direction_x = ThreadLocalRandom.current().nextInt(-1, 1);
					direction_y = ThreadLocalRandom.current().nextInt(-1, 1);
				}
			}
		}
		// On met a† jour la position du fantome
		this.x = this.x + direction_x;
		this.y = this.y + direction_y;
	}
}
