package logic;

import java.awt.Color;

import data.Entite;

/**
 * Class Ghost
 * Represents a ghost with his variable and functions
 * @author Camille Barbarin--Renvoise
 */

public class Ghost extends Entite {
	
	// On choisit que les fantomes seront rouges
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
	 * Getter for direction_x attribute of ghost
	 * @return direction_x an integer
	 */
	public int get_direction_x() {
		return this.direction_x;
	}
	
	/**
	 * Getter for direction_y attribute of ghost
	 * @return direction_y an integer
	 */
	public int get_direction_y() {
		return this.direction_y;
	}
	
	/**
	 * Setter for direction_x attribute of ghost
	 * @return direction_x an integer
	 */
	public void set_direction_x(int dir) {
		this.direction_x = dir;
	}
	
	/**
	 * Setter for direction_y attribute of ghost
	 * @return direction_y an integer
	 */
	public void set_direction_y(int dir) {
		this.direction_y = dir;
	}
	
	/**
	 * Method to move a ghost
	 * @param liste the list of entities on the map (including walls)
	 */
	public void move_ghost(Entite[] liste) {
		// On met a jour la position du fantome
		this.x = this.x + direction_x;
		this.y = this.y + direction_y;
	}
}
