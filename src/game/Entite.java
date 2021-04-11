package game;

import java.awt.Color;

/**
 * Abstract class Entite
 * Contain all common function and variable for Entities
 * @author Lilian Cizeron
 *
 */

public abstract class Entite {
	
	// La coleur de notre entite
	protected Color color;
	
	// Les coordonnees de notre entite
	protected int x;
	protected int y;
	
	/**
	 * Constructor of Entite
	 * @param color the color of the Entity
	 * @param x the x position of the Entity
	 * @param y the y position of the Entity
	 */
	
	public Entite(Color color, int x, int y) {
		
		this.color = color;
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Method to get the x position of the Entity
	 * @return x the x position of the Entity
	 */
	
	public int get_x() {
		
		return this.x;
		
	}
	
	/**
	 * Method to get the y position of the Entity
	 * @return y the y position of the Entity
	 */
	
	public int get_y() {
		
		return this.y;
		
	}
}
