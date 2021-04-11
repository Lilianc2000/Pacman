package logic;

import java.awt.Color;

import data.Entite;

/**
 * Class Empty
 * Represent an empty case on the map
 * @author Camille Barbarin--Renvoise
 */

public class Empty extends Entite {
	
	// On choisit que les cases vides seront noires
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
