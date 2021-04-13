package logic;

import java.awt.Color;

import data.Entite;

/**
 * Class Pacman
 * Represents pacman on the map and all his attributes
 * @author Camille Barbarin--Renvoise
 *
 */

public class Pacman extends Entite {
	
	// On choisit que Pacman sera toujours jaune
	private static final Color color = Color.YELLOW;
	
	// Les proprietes propres a pacman
	private int life;
	private int score;
	private int direction_y = 0;
	private int direction_x = 0;
	
	/**
	 * Constructor of Pacman
	 * @param life the initial life of pacman
	 * @param score the initial score of pacman
	 * @param x the initial x position of pacman
	 * @param y the initial y position of pacman
	 */
	public Pacman(int life, int score, int x, int y) {
		super(color, x, y);
		this.life = life;
		this.score = score;
	}
	
	/**
	 * Method to get pacman's score
	 * @return
	 */
	public int get_score() {
		return this.score;
	}
	
	/**
	 * Method to set pacman's score
	 * @param score
	 */
	public void set_score(int score) {
		this.score = score;
	}
	
	/**
	 * Method to increase pacman's score
	 * @param fruit
	 */
	public void eat_fruit(Fruit fruit) {
		score = score + fruit.get_value();
	}
	
	/**
	 * Method to increase pacman's life
	 * @return life an integer
	 */
	public int get_life() {
		return this.life;
	}
	
	/**
	 * Getter for get direction_x attribute of pacman
	 * @return direction_x an integer
	 */
	public int get_direction_x() {
		return this.direction_x;
	}
	
	/**
	 * Getter for get direction_y attribute of pacman
	 * @return direction_y an integer
	 */
	public int get_direction_y() {
		return this.direction_y;
	}
	
	/**
	 * Method to move pacman
	 * @param code the code of moving
	 * @return pacman the updated Pacman object
	 * @throws Exception 
	 */
	public Pacman move_pacman(int code) throws Exception {
		// Direction haute
		if (code == 1) {
			this.direction_y = 0;
			this.direction_x = -1;
		}
		// Direction basse
		else if (code == 2) {	
			this.direction_y = 0;
			this.direction_x = 1;
		}
		// Direction droite
		else if (code == 3) {	
			this.direction_y = 1;
			this.direction_x = 0;
		}
		// Direction gauche
		else if (code == 4) {	
			this.direction_y = -1;
			this.direction_x = 0;
		}
		// Si on a recu un code diff�rent de 1 2 3 ou 4, alors Pacman ne change pas de direction		
		if (this.x + this.direction_x > 14 || this.x + this.direction_x < 0 || this.y + this.direction_y > 14 || this.y + this.direction_y < 0) {
			throw new Exception ("Pacman sort du jeu");
		}
		this.x = this.x + this.direction_x;
		this.y = this.y + this.direction_y;
		
		return this;
	}

	/**
	 * Method to decrease pacman's life
	 */
	public void loose_life() {
		System.out.println("Life loosed");
		this.life = this.life - 1;
	}
}
