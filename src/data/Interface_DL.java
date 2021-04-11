package data;

import logic.Carte;

/**
 * Interface between Data and Logic packages
 * Represent an empty case on the map
 * @author Antoine Chr�tien
 */

public interface Interface_DL {
	
	/**
	 * Method to get the x position of the Entity
	 * @return x the x position of the Entity
	 */
	public int get_X();
	
	/**
	 * Method to get the y position of the Entity
	 * @return y the y position of the Entity
	 */
	public int get_Y();
	
}
