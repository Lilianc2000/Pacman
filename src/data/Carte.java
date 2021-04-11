package data;

import logic.Empty;
import logic.Fruit;
import logic.Ghost;
import logic.Pacman;
import logic.Wall;

/**
 * Class carte
 * Contain all method required to interact with the map
 * @author Lilian Cizeron
 *
 */

public class Carte {
	
	// La liste des entites
	private Entite[] liste;
	
	// La position de Pacman dans cette liste
	private int PACMAN_POSITION;
	
	/**
	 * Constructor of a map
	 * @param liste a list of Entite to put on the map
	 */
	
	public Carte(Entite[] liste) {
		
		// On vérifie qu'il y a au moins 3 éléments, sinon le jeu ne sert à rien
		assert liste.length > 2 : "You can not play with less than 3 elements";
		
		// On récupère les items dans la carte
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
	 * @return this the actualized map
	 */
	
	public Carte move_pacman(int code) {
		
		// On vérifie que le code de deplacement fourni est bien dans ceux traites
		assert code <= 5 && code >0 : "Wrong moving code detected";
		
		// On verifie si on ne va pas dans un mur, auquel cas on souleve une exception pour ne pas bouger pacman
		if (code == 1) {
			
			for (int i = 0; i < liste.length; i++) {
				
				if (liste[i] instanceof Wall) {
					
					assert liste[i].get_y() != liste[PACMAN_POSITION].get_y()|| liste[i].get_x() != liste[PACMAN_POSITION].get_x() - 1: "A wall is here.";
					
				}
			}
		
		}
		
		else if (code == 2) {
			
			for (int i = 0; i < liste.length; i++) {
				
				if (liste[i] instanceof Wall) {
					
					assert liste[i].get_y() != liste[PACMAN_POSITION].get_y() || liste[i].get_x() != liste[PACMAN_POSITION].get_x() + 1: "A wall is here.";
					
				}
			}
			
		}
		
		else if (code == 3) {
			
			for (int i = 0; i < liste.length; i++) {
				
				if (liste[i] instanceof Wall) {
				
					assert liste[i].get_y() != liste[PACMAN_POSITION].get_y() + 1 || liste[i].get_x() != liste[PACMAN_POSITION].get_x(): "A wall is here.";
					
				}
			}
			
		}
		
		else if (code == 4) {
			
			for (int i = 0; i < liste.length; i++) {
				
				if (liste[i] instanceof Wall) {
					
					assert liste[i].get_y() != liste[PACMAN_POSITION].get_y() - 1 || liste[i].get_x() != liste[PACMAN_POSITION].get_x() : "A wall is here.";
					
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
	 */
	
	private void find_ghost() {
		
		// On verifie si, dans la liste des entites, un fantome a les memes coordonnees que notre pacman
		for (int i = 0; i < liste.length; i++) {
			
			if (liste[i].get_x() == liste[PACMAN_POSITION].get_x() && liste[i].get_y() == liste[PACMAN_POSITION].get_y() && liste[i] instanceof Ghost) {
				
				// Si oui, pacman perds une vie
				((Pacman) liste[PACMAN_POSITION]).loose_life();
				
			}
			
		}
		
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
