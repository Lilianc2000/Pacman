package logic;

import data.Entite;

/**
 * Interface between the logic and the view parts of the game
 * @author Camille Barbarin--Renvoisé
 */

public interface Interface_VL {

		/**
		 * Indicates if there are fruits on the map
		 * @return true if there are fruits on the map
		 */
		public boolean are_Fruits();
		
		/**
		 * Gets all the Entite objects that exist on the map
		 * @return liste a list of Entite
		 */
		public Entite[] get_all();
		
		/**
		 * Moves Pacman to another cell of the map
		 * @param code the moving code of Pacman
		 * @return this the actualized map
		 */
		public Carte move_pacman(int code);

		/**
		 * Moves all ghosts that exist on the map
		 */
		public void move_ghost();
}