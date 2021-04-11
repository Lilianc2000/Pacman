package logic;

import data.Entite;

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
	 * Method to move the Pacman on the map
	 * @param code the moving code of Pacman
	 * @throws Exception 
	 * @return carte the actualized Carte object
	 */
	
	public Carte move_pacman(int code, Pacman pacman) throws Exception {
		// On verifie que le code de deplacement est dans les valeurs possibles
		if (code < 0 || code > 5) {
			throw new Exception ("Wrong moving code detected");
		}
		// On verifie si la case souhaitée est un mur, auquel cas on souleve une exception pour ne pas bouger pacman
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
				code = 1;
				for (int i = 0; i < liste.length; i++) {
					if (liste[i] instanceof Wall) {
						if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
							throw new Exception ("A wall is here");
						}
					}
				}
			}
			else if (int_x == -1) {
				code = 2;
				for (int i = 0; i < liste.length; i++) {
					if (liste[i] instanceof Wall) {
						if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
							throw new Exception ("A wall is here");
						}
					}
				}
			}
			else if (int_y == -1) {
				code = 3;
				for (int i = 0; i < liste.length; i++) {
					if (liste[i] instanceof Wall) {
						if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
							throw new Exception ("A wall is here");
						}
					}
				}
			}
			else {
				code = 4;
				for (int i = 0; i < liste.length; i++) {
					if (liste[i] instanceof Wall) {
						if (liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i].get_x() == liste[PACMAN_POSITION].get_x() -1) {
							throw new Exception ("A wall is here");
						}
					}
				}
			}
		}
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
	 * @return
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
				// Et on les fait bouger
				((Ghost) liste[i]).move_ghost(liste);
			}
		}
	}
}