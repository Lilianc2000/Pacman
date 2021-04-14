package logic;

import data.Entite;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class Carte
 * Represents the map in which entites are moving
 * @author Camille Barbarin--Renvoise
 */

public class Carte implements Interface_VL{

	// Entites list on the map
	private Entite[] liste;
	
	// Pacman's position in the list
	private int PACMAN_POSITION;
	
	/**
	 * Constructor for Carte
	 * @param liste a list of Entite objects to put on the map
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
		// On regarde toutes les entites pour verifier s il y a au moins un fruit
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
		// On initialise deux variables pour les futures coordonnees 
		int future_x = -1;
		int future_y = -1;
		// On calcule les futures coordonnees de notre entite (qui est soit un Pacman soit un Ghost)
		if (entite instanceof Pacman) {
			future_x = ((Pacman) entite).get_x() + ((Pacman) entite).get_direction_x();
			future_y = ((Pacman) entite).get_y() + ((Pacman) entite).get_direction_y();
		}
		else if (entite instanceof Ghost) {
			future_x = ((Ghost) entite).get_x() + ((Ghost) entite).get_direction_x();
			future_y = ((Ghost) entite).get_y() + ((Ghost) entite).get_direction_y();
		}
		// Si l'entite n est ni un Pacman ni un Ghost souleve une exception
		else {
			throw new Exception("L'entite n'est ni un fantome ni un pacman");
		}
		// On boucle sur la liste des entites pour verifier s'il existe un mur sur la future position de l'entite pass�e en param�tre
		for (int i = 0; i < liste.length; i++) {
			if (this.liste[i] instanceof Wall) {
				if (this.liste[i].get_x() == future_x  && this.liste[i].get_y() == future_y) {
				// On retourne true si l'entite veut se deplacer sur un mur
				return true;
				}
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
	public void move_pacman(int code, Pacman pacman) throws Exception {
		// On verifie que le code de deplacement est dans les valeurs possibles
		if (code < 1 || code > 5) {
			throw new Exception ("Wrong moving code detected");
		}
		// On initialise des valeurs a -1 de x et y
		int x = - 1;
		int y = - 1;
		// On calcule les futures coordonnes x et y de Pacman
		if (code == 1) {
			x = pacman.get_x() - 1;
			y = pacman.get_y();
		}
		else if (code == 2) {
			x = pacman.get_x() + 1;
			y = pacman.get_y();
		}
		else if (code == 3) {	
			x = pacman.get_x();
			y = pacman.get_y() + 1;
		}
		else if (code == 4) {	
			x = pacman.get_x();
			y = pacman.get_y() - 1;
		}
		else if (code == 5) {
			x = pacman.get_direction_x() + pacman.get_x();
			y = pacman.get_direction_y() + pacman.get_y();
		}
		// On verifie si la future position de Pacman est un mur, auquel cas on souleve une exception et Pacman ne bouge pas
		boolean verif = false;
		int i = 0;
		while (i < this.liste.length && verif == false) {
			// Si cette cellule est un mur on souleve une exception
			if (liste[i] instanceof Wall && liste[i].get_x() == x && liste[i].get_y() == y) {
				verif = true;
				throw new Exception ("There is a wall on this cell");
			}
			i += 1;
		}
		find_ghost();
		// Si aucune exception n a ete soulevee on deplace Pacman
		liste[PACMAN_POSITION] = pacman.move_pacman(code);
		find_ghost();
		// On verifie si Pacman n'a pas mange un fruit ou rencontre un fantome
		eat_fruit();
	}
	
	/**
	 * Private method to check if Pacman ate a fruit while moving
	 */
	private void eat_fruit() {
		// On verifie si un fruit possede les memes coordonnees que notre pacman
		for (int i = 0; i < liste.length; i++) {
			if (liste[i].get_x() == liste[PACMAN_POSITION].get_x() && liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i] instanceof Fruit) {
				// Si oui, Pacman mange le fruit et gagne des points
				((Pacman) liste[PACMAN_POSITION]).eat_fruit((Fruit) liste[i]);
				// Et on remplace le fruit par une case vide
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
		// On verifie si un fantome a les memes coordonnees que notre pacman
		for (int i = 0; i < liste.length; i++) {	
			if (liste[i].get_x() == liste[PACMAN_POSITION].get_x() && liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i] instanceof Ghost) {
				// Si oui, pacman perd une vie
				((Pacman) liste[PACMAN_POSITION]).loose_life();
			}
		}
	}
	
	/**
	 * Getter for PACMAN_POSITION attribute for carte
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
				// On deplace les fantomes seulement si leur direction n'est pas un mur
				try {
					if (is_a_wall(liste[i]) == false && ((Ghost) liste[i]).get_x() + ((Ghost) liste[i]).get_direction_x() > -1 && ((Ghost) liste[i]).get_x() + ((Ghost) liste[i]).get_direction_x() < 15 && ((Ghost) liste[i]).get_y() + ((Ghost) liste[i]).get_direction_y() > -1 && ((Ghost) liste[i]).get_y() + ((Ghost) liste[i]).get_direction_y() < 15) {
						((Ghost) liste[i]).move_ghost();
					}
					else {
					// Si la direction du fantome n est pas valide (= c'est un mur) on cherche une autre direction pour le fantome, tant que la direction suivante est un mur ET que il n'y a pas une direction lineaire ET tant que l'on ne bouge pas ET que on est pas out of bounds
						while(is_a_wall(liste[i]) || (((Ghost) liste[i]).get_direction_x() != 0 && ((Ghost) liste[i]).get_direction_y() != 0) || (((Ghost) liste[i]).get_direction_x() == 0 && ((Ghost) liste[i]).get_direction_y() == 0) || ((liste[i].get_x() + ((Ghost) liste[i]).get_direction_x()) < 0) || ((liste[i].get_x() + ((Ghost) liste[i]).get_direction_x()) > 14) || ((liste[i].get_y() + ((Ghost) liste[i]).get_direction_y()) < 0) || ((liste[i].get_y() + ((Ghost) liste[i]).get_direction_y()) > 14)) {
							((Ghost) liste[i]).set_direction_x(ThreadLocalRandom.current().nextInt(-1, 2));
							((Ghost) liste[i]).set_direction_y(ThreadLocalRandom.current().nextInt(-1, 2));
						}
						((Ghost) liste[i]).move_ghost();
					} 
				}
				catch (Exception e) {
					
				}				
			}
		}

	}
}
