package logic;

import java.awt.Color;

import data.Entite;

/**
 * Class Pacman
 * Represents pacman on the map and all his attributes
 * @author Camille Barbarin--Renvois�
 *
 */

public class Pacman extends Entite {
	
	// La couleur de pacman, qui sera toujours jaune
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
	 * @return
	 */
	public int get_life() {
		return this.life;
	}
	
	/**
	 * Method to move pacman
	 * @param code the code of moving
	 * @return
	 */
	public Pacman move_pacman(int code) {
		// Direction nord
		if (code == 1) {
			this.direction_y = 0;
			this.direction_x = -1;
		}
		// Direction sud
		else if (code == 2) {	
			this.direction_y = 0;
			this.direction_x = 1;
		}
		// Direction est
		else if (code == 3) {	
			this.direction_y = 1;
			this.direction_x = 0;
		}
		// Direction ouest
		else if (code == 4) {	
			this.direction_y = -1;
			this.direction_x = 0;
		}
		// Si on a recu un autre code que 1 2 3 ou 4, alors on ne change pas de direction
		this.x = this.x + this.direction_x;
		this.y = this.y + this.direction_y;
		
		return this;
	}

	/**
	 * Method to decrease pacman's life
	 * @return actualized pacman
	 */
	public void loose_life() {
		this.life = this.life - 1;
	}
}
