package logic;

import data.Entite;

/**
 * Interface between the logic and the view parts of the game
 * @author Camille Barbarin--Renvoise
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
		 * @throws Exception 
		 */
		public void move_pacman(int code, Pacman pacman) throws Exception;

		/**
		 * Moves all ghosts that exist on the map
		 * @throws Exception 
		 */
		public void move_ghost();
}