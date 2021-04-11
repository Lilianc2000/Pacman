package logic;

import data.Entite;

/**
 * Class carte
 * Contain all method required to interact with the map
 * @author Lilian Cizeron
 *
 */

public class Carte {
	
	// Entites list on the map
	private Entite[] liste;
	
	// Pacman's position in the list
	private int PACMAN_POSITION;
	
	/**
	 * Gives the liste attribute for carte
	 * @returns liste
	 */
	public Entite[] get_liste() {
		return this.liste;
	}
	
	/**
	 * Gives the PACMAN_POSITION attribute for carte
	 * @returns position an integer
	 */
	public int get_position() {
		return this.PACMAN_POSITION;
	}

	/**
	 * Constructor of a map
	 * @param liste a list of Entite to put on the map
	 */	
	public Carte(Entite[] liste) {
		// On v�rifie qu'il y a au moins 3 �l�ments, sinon le jeu ne sert � rien
		assert liste.length > 2 : "You can not play with less than 3 elements";
		// On r�cup�re les items dans la carte
		this.liste = liste;
		// On recherche pacman pour stocker sa position
		for (int i = 0; i < liste.length; i++) {
			if (liste[i] instanceof Pacman) {
				PACMAN_POSITION = i;	
			}	
		}
	}
}
