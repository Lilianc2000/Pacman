package logic;

import java.awt.Color;

import data.Entite;

/**
 * Class Fruit
 * Represents a fruit on the map
 * @author Camille Barbarin--Renvoise
 */

public class Fruit extends Entite {
	
	// On choisit que les fruits seront blancs
	private static final Color color = Color.WHITE;
	
	// La valeur du fruit (= le nombre de points que Pacman gagne s'il mange le fruit)
	private int value;
	
	/**
	 * Constructor of Fruit
	 * @param value the value of the fruit
	 * @param x the abscissa of the fruit
	 * @param y the ordinate of the fruit
	 */
	public Fruit(int value, int x, int y) {
		super(color, x, y);
		this.value = value;
	}

	/**
	 * Method to get the fruit value
	 * @return value the value of the fruit
	 */
	public int get_value() {
		return value;
	}
}
