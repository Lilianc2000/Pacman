package logic;

import java.awt.Color;

import data.Entite;

/**
 * Class Wall
 * Represents a wall on the map
 * @author Camille Barbarin--Renvoise
 */

public class Wall extends Entite {

	// On choisit que les murs sont bleus
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
