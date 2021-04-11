package logic;

import data.Entite;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class Carte
 * Represents the map in which the Entite
 * @author Camille Barbarin--Renvoise
 */

public class Carte implements Interface_VL{

	// Entites list on the map
	private Entite[] liste;
	
	// Pacman's position in the list
	private int PACMAN_POSITION;
	
	/**
	 * Constructor of a map
	 * @param liste a list of Entite to put on the map
	 */
	public Carte(Entite[] liste) {
		// On verifie qu'il y a au moins 3 elements, sinon le jeu n'a plus aucun interet
		assert liste.length > 2 : "You can not play with less than 3 elements";
		// On recupere les items dans la carte
		this.liste = liste;
		// On recherche pacman pour stocker sa position
		for (int i = 0; i < liste.length; i++) {
			if (liste[i] instanceof Pacman) {
				PACMAN_POSITION = i;
			}
		}
	}
	
	/**
	 * Method to know if fruits are on the map
	 * @return true if fruits are on the map
	 */
	public boolean are_Fruits() {
		// On balaye toutes les entites de la carte pour verifier s'il y a au moins un fruit
		for (int i = 0; i < liste.length; i++) {
			if (liste[i] instanceof Fruit) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to get all entities on the map
	 * @return liste a list of Entite
	 */
	public Entite[] get_all() {
		return liste;
	}
	
	/**
	 * Verifies if the future cell of an entite (ghost or pacman) is a wall or not
	 * @param entite an Entite object (precisely a ghost or a pacman)
	 * @param direction_x an integer in {-1, 0, 1}
	 * @param direction_y an integer in {-1, 0, 1}
	 * @return is_a_wall a boolean (true if it is a wall)
	 * @throws Exception 
	 */
	public boolean is_a_wall(Entite entite) throws Exception {
		// On calcule le futur emplacement du fantome ou du pacman passé en paramètre
		int x = entite.get_x();
		int y = entite.get_y();
		int future_x = -1;
		int future_y = -1;
		if (entite instanceof Pacman) {
			future_x = x + ((Pacman) entite).get_direction_x();
			future_y = y + ((Pacman) entite).get_direction_y();
		}
		else if (entite instanceof Ghost) {
			future_x = x + ((Ghost) entite).get_direction_x();
			future_y = y + ((Ghost) entite).get_direction_y();
		}
		else {
			throw new Exception("L'entité n'est ni un fantome ni un pacman");
		}
		// On boucle sur la liste des entités pour vérifier s'il existe un mur sur cette future position
		for (int i = 0; i < liste.length; i++) {
			if (this.liste[i] instanceof Wall && this.liste[i].get_x() == future_x  && this.liste[i].get_y() == future_y ) {
				// On renvoie is_a_wall = true si l'entité veut se déplacer sur un mur
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method to move the Pacman on the map
	 * @param code the moving code of Pacman
	 * @throws Exception 
	 * @return carte the actualized Carte object
	 */	
	public Carte move_pacman(int code, Pacman pacman) throws Exception {
		// On verifie que le code de deplacement est dans les valeurs possibles
		if (code < 1 || code > 5) {
			throw new Exception ("Wrong moving code detected");
		}
		// On verifie si la case souhaitee est un mur, auquel cas on souleve une exception et on de deplace pas pacman
		if (code == 1) {
			for (int i = 0; i < liste.length; i++) {
				if (liste[i] instanceof Wall) {
					if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
						throw new Exception ("A wall is here");
					}
				}
			}
		}
		else if (code == 2) {
			for (int i = 0; i < liste.length; i++) {
				if (liste[i] instanceof Wall) {
					if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
						throw new Exception ("A wall is here");
					}
				}
			}
		}
		else if (code == 3) {
			for (int i = 0; i < liste.length; i++) {
				if (liste[i] instanceof Wall) {
					if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
						throw new Exception ("A wall is here");
					}
				}
			}
		}
		else if (code == 4) {
			for (int i = 0; i < liste.length; i++) {
				if (liste[i] instanceof Wall) {
					if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
						throw new Exception ("A wall is here");
					}
				}
			}
		}
		else if (code == 5) {
			int int_x = pacman.get_direction_x();
			int int_y = pacman.get_direction_y();
			if (int_x == 1) {
				code = 2;
				for (int i = 0; i < liste.length; i++) {
					if (liste[i] instanceof Wall) {
						if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
							throw new Exception ("A wall is here");
						}
					}
				}
			}
			else if (int_x == -1) {
				code = 1;
				for (int i = 0; i < liste.length; i++) {
					if (liste[i] instanceof Wall) {
						if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
							throw new Exception ("A wall is here");
						}
					}
				}
			}
			else if (int_y == -1) {
				code = 4;
				for (int i = 0; i < liste.length; i++) {
					if (liste[i] instanceof Wall) {
						if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
							throw new Exception ("A wall is here");
						}
					}
				}
			}
			else if (int_y == 1) {
				code = 3;
				for (int i = 0; i < liste.length; i++) {
					if (liste[i] instanceof Wall) {
						if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
							throw new Exception ("A wall is here");
						}
					}
				}
			}
		}
		System.out.println("check walls passed");
		// Si on est toujours la, c'est qu'on peut bouger
		liste[PACMAN_POSITION] = ((Pacman) liste[PACMAN_POSITION]).move_pacman(code);		
		// On verifie si on n'a pas mange un fruit ou rencontrer un fantome
		eat_fruit();
		find_ghost();
		return this;
	}
	
	/**
	 * Private method to check if Pacman ate a fruit while moving
	 */
	private void eat_fruit() {
		// On verifie si, dans la liste des entites, un fruit a les memes coordonnees que notre pacman
		for (int i = 0; i < liste.length; i++) {
			if (liste[i].get_x() == liste[PACMAN_POSITION].get_x() && liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i] instanceof Fruit) {
				// Si oui, on signale a pacman qu'il a mange
				((Pacman) liste[PACMAN_POSITION]).eat_fruit((Fruit) liste[i]);
				// Et on fait remplace le fruit par une case vide
				liste[i] = new Empty(liste[PACMAN_POSITION].get_x(), liste[PACMAN_POSITION].get_y());
			}	
		}
	}
	
	/**
	 * Private method to check if pacman hurted a ghost while moving 
	 * Gives the PACMAN_POSITION attribute for carte
	 * @returns position an integer
	 */
	private void find_ghost() {
		// On verifie si, dans la liste des entites, un fantome a les memes coordonnees que notre pacman
		for (int i = 0; i < liste.length; i++) {	
			if (liste[i].get_x() == liste[PACMAN_POSITION].get_x() && liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i] instanceof Ghost) {
				// Si oui, pacman perd une vie
				((Pacman) liste[PACMAN_POSITION]).loose_life();
			}
		}
	}
	
	/**
	 * Getter for PACMAN_POSITION attribute of carte
	 * @return position an integer
	 */
	public int get_position() {
		return this.PACMAN_POSITION;
	}

	/**
	 * Method to move all ghosts of the map
	 * @return this the actualized map
	 */
	public void move_ghost() {
		// On recherche dans la liste tous les fantomes
		for (int i = 0; i < liste.length; i++) {
			if (liste[i] instanceof Ghost) {
				// Et on les fait bouger, seulement si leur direction n'est pas un mur
				try {
					if (is_a_wall(liste[i]) == false) {
						((Ghost) liste[i]).move_ghost(liste);
					}
					// Si la direction du fantome n'est pas un valide (= c'est un mur) on cherche une autre direction pour le fantome, tant que la direction suivante est un mur ET que il n'y a pas une direction linéaire ET tant que l'on ne bouge pas ET que on est pas out of bounds
					while(is_a_wall(liste[i]) && (((Ghost) liste[i]).get_direction_x() != 0 && ((Ghost) liste[i]).get_direction_y() != 0) && (((Ghost) liste[i]).get_direction_x() == 0 && ((Ghost) liste[i]).get_direction_y() == 0) && (liste[i].get_x() + ((Ghost) liste[i]).get_direction_x() < 0 && liste[i].get_y() + ((Ghost) liste[i]).get_direction_x() > 14 && liste[i].get_y() + ((Ghost) liste[i]).get_direction_y() < 0 && liste[i].get_y() + ((Ghost) liste[i]).get_direction_y() > 14)) {
						((Ghost) liste[i]).set_direction_x(ThreadLocalRandom.current().nextInt(-1, 1));
						((Ghost) liste[i]).set_direction_y(ThreadLocalRandom.current().nextInt(-1, 1));
					} 
				}
				catch (Exception e) {
				e.printStackTrace();
				}				
			}
		}
	}
}
