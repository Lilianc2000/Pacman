package data;

import logic.Carte;

/**
 * Interface between Data and Logic packages
 * Represent an empty case on the map
 * @author Antoine Chretien
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
	
	/**
	 * this method give an initial map for a level give. We have initialize 3 Maps for levels 1,2 and 3
	 * @param level
	 * @return a list with the initial coordinate of Pacman, walls, Fruits(with values) and Ghosts
	 */
	public Carte get_carte(int level);
 
}
