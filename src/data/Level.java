package data;

import logic.Carte;
import logic.Fruit;
import logic.Ghost;
import logic.Pacman;
import logic.Wall;

/**
 * Abstract Static Class to define ours levels
 * @author Lilian Cizeron
 *
 */
public abstract class Level {

	/**
	 * Level 1 has 3 ghosts and every fruits have the value 10
	 * @author Antoine Chrétien
	 */
	private static Entite[] liste_niveau_1 = new Entite[]
									  {
									  new Wall(0, 0),
									  new Pacman(10, 0, 1, 0), 
									  new Fruit(10, 5, 3),
									  new Fruit(10, 8, 7),
									  new Fruit(10, 1, 11),
									  new Fruit(10, 8, 13),
									  new Fruit(10, 14, 2),
									  new Fruit(10, 13, 9),  
									  new Fruit(10, 6, 0),
									  new Fruit(10, 12, 5),
									  new Fruit(10, 5, 10),
									  new Fruit(10, 10, 13),
									  new Wall(0, 4),
									  new Wall(0, 5),
									  new Wall(0, 12),
									  new Wall(0, 13),
									  new Wall(0, 14),
									  new Wall(1,2),
									  new Wall(1,4),
									  new Wall(1,5),
									  new Wall(1,7),
									  new Wall(1,8),
									  new Wall(1,9),
									  new Wall(1,10),
									  new Wall(1,12),
									  new Wall(1,13),
									  new Wall(1,14),
									  new Wall(2,1),
									  new Wall(2,2),
									  new Wall(2,4),
									  new Wall(2,5),
									  new Wall(2,7),
									  new Wall(2,8),
									  new Wall(2,13),
									  new Wall(2,14),
									  new Wall(3,1),
									  new Wall(3,4),
									  new Wall(3,5),
									  new Wall(3,7),
									  new Wall(3,10),
									  new Wall(3,11),
									  new Wall(3,13),
									  new Wall(3,14),
									  new Wall(4,1),
									  new Wall(4,3),
									  new Wall(4,4),
									  new Wall(4,5),
									  new Wall(4,7),
									  new Wall(4,9),
									  new Wall(4,10),
									  new Wall(4,11),
									  new Wall(4,13),
									  new Wall(4,14),
									  new Wall(5,1),
									  new Wall(6,1),
									  new Wall(6,2),
									  new Wall(6,4),
									  new Wall(6,5),
									  new Wall(6,6),
									  new Wall(6,7),
									  new Wall(6,9),
									  new Wall(6,10),
									  new Wall(6,11),
									  new Wall(6,12),
									  new Wall(6,13),
									  new Wall(7,1),
									  new Wall(7,2),
									  new Wall(7,4),
									  new Wall(7,5),
									  new Wall(7,6),
									  new Wall(7,7),
									  new Wall(7,9),
									  new Wall(7,10),
									  new Wall(7,11),
									  new Wall(7,12),
									  new Wall(8,2),
									  new Wall(8,4),
									  new Wall(8,9),
									  new Wall(8,14),
									  new Wall(9,0),
									  new Wall(9,2),
									  new Wall(9,4),
									  new Wall(9,6),
									  new Wall(9,7),
									  new Wall(9,8),
									  new Wall(9,9),
									  new Wall(9,11),
									  new Wall(9,12),
									  new Wall(9,13),
									  new Wall(9,14),
									  new Wall(10,0),
									  new Wall(11,0),
									  new Wall(11,2),
									  new Wall(11,3),
									  new Wall(11,4),
									  new Wall(11,6),
									  new Wall(11,7),
									  new Wall(11,8),
									  new Wall(11,9),
									  new Wall(11,11),
									  new Wall(11,12),
									  new Wall(11,13),
									  new Wall(12,0),
									  new Wall(12,2),
									  new Wall(12,3),
									  new Wall(12,4),
									  new Wall(12,6),
									  new Wall(12,7),
									  new Wall(12,8),
									  new Wall(12,9),
									  new Wall(12,11),
									  new Wall(12,12),
									  new Wall(12,13),
									  new Wall(13,0),
									  new Wall(13,2),
									  new Wall(13,6),
									  new Wall(13,12),
									  new Wall(13,13),
									  new Wall(14,0),
									  new Wall(14,4),
									  new Wall(14,8),
									  new Wall(14,9),
									  new Wall(14,10),
									  new Fruit(10, 0, 1),
									  new Fruit(10, 0, 2),
									  new Fruit(10, 0, 3),
									  new Fruit(10, 0, 6),
									  new Fruit(10, 0, 7),
									  new Fruit(10, 0, 8),
									  new Fruit(10, 0, 9),
									  new Fruit(10, 0, 10),
									  new Fruit(10, 0, 11),
									  new Fruit(10, 1, 1),
									  new Fruit(10, 1, 3),
									  new Fruit(10, 1, 6),
									  new Fruit(10, 2, 0),
									  new Fruit(10, 2, 3),
									  new Fruit(10, 2, 6),
									  new Fruit(10, 2, 9),
									  new Fruit(10, 2, 10),
									  new Fruit(10, 2, 11),
									  new Fruit(10, 2, 12),
									  new Fruit(10, 3, 0),
									  new Fruit(10, 3, 2),
									  new Fruit(10, 3, 3),
									  new Fruit(10, 3, 6),
									  new Fruit(10, 3, 8),
									  new Fruit(10, 3, 9),
									  new Fruit(10, 3, 12),
									  new Fruit(10, 4, 0),
									  new Fruit(10, 4, 2),
									  new Fruit(10, 4, 6),
									  new Fruit(10, 4, 8),
									  new Fruit(10, 4, 12),
									  new Fruit(10, 5, 0),
									  new Fruit(10, 5, 2),
									  new Fruit(10, 5, 4),
									  new Fruit(10, 5, 5),
									  new Fruit(10, 5, 6),
									  new Fruit(10, 5, 7),
									  new Fruit(10, 5, 8),
									  new Fruit(10, 5, 9),
									  new Fruit(10, 5, 11),
									  new Fruit(10, 5, 12),
									  new Fruit(10, 5, 13),
									  new Fruit(10, 5, 14),
									  new Fruit(10, 6, 3),
									  new Fruit(10, 6, 8),
									  new Fruit(10, 6, 14),
									  new Fruit(10, 7, 0),
									  new Fruit(10, 7, 3),
									  new Fruit(10, 7, 8),
									  new Fruit(10, 7, 13),
									  new Fruit(10, 7, 14),
									  new Fruit(10, 8, 1),
									  new Fruit(10, 8, 0),
									  new Fruit(10, 8, 1),
									  new Fruit(10, 8, 3),
									  new Fruit(10, 8, 5),
									  new Fruit(10, 8, 6),
									  new Fruit(10, 8, 8),
									  new Fruit(10, 8, 10),
									  new Fruit(10, 8, 11),
									  new Fruit(10, 8, 12),
									  new Fruit(10, 9, 1),
									  new Fruit(10, 9, 3),
									  new Fruit(10, 9, 5),
									  new Fruit(10, 9, 10),
									  new Fruit(10, 10, 1),
									  new Fruit(10, 10, 2),
									  new Fruit(10, 10, 3),
									  new Fruit(10, 10, 4),
									  new Fruit(10, 10, 5),
									  new Fruit(10, 10, 6),
									  new Fruit(10, 10, 7),
									  new Fruit(10, 10, 8),
									  new Fruit(10, 10, 9),
									  new Fruit(10, 10, 10),
									  new Fruit(10, 10, 11),
									  new Fruit(10, 10, 12),
									  new Fruit(10, 10, 14),
									  new Fruit(10, 11, 1),
									  new Fruit(10, 11, 5),
									  new Fruit(10, 11, 10),
									  new Fruit(10, 11, 14),
									  new Fruit(10, 12, 1),
									  new Fruit(10, 12, 10),
									  new Fruit(10, 12, 14),
									  new Fruit(10, 13, 1),
									  new Fruit(10, 13, 3),
									  new Fruit(10, 13, 4),
									  new Fruit(10, 13, 5),
									  new Fruit(10, 13, 7),
									  new Fruit(10, 13, 8),
									  new Fruit(10, 13, 10),
									  new Fruit(10, 13, 11),
									  new Fruit(10, 13, 14),
									  new Fruit(10, 14, 1),
									  new Fruit(10, 14, 3),
									  new Fruit(10, 14, 5),
									  new Fruit(10, 14, 6),
									  new Fruit(10, 14, 7),
									  new Fruit(10, 14, 11),
									  new Fruit(10, 14, 12),
									  new Fruit(10, 14, 13),
									  new Fruit(10, 14, 14),
									  new Ghost(6, 0),
									  new Ghost(12, 5),
									  new Ghost(5, 10),
									  new Ghost(10, 13),
									  
									  
									  
									  
									  
									  };
								
	/**
	 * Level 2 has 3 ghosts and every fruits have the value 15
	 * @author Antoine Chrétien
	 */
	private static Entite[] liste_niveau_2= new Entite[] 
			{
					  new Wall(0, 0),
					  new Pacman(10, 0, 1, 0), 
					  new Fruit(15, 0, 3),
					  new Fruit(15, 4, 11),
					  new Fruit(15, 7, 5),
					  new Fruit(15, 12, 2),
					  new Fruit(15, 8, 13),
					  new Fruit(15, 11, 10),
					  new Ghost(1, 8),
					  new Fruit(15, 1, 8),
					  new Ghost(7, 3),
					  new Fruit(15, 7, 3),
					  new Ghost(13, 5),
					  new Fruit(15, 13, 5),
					  new Ghost(3, 12),
					  new Fruit(15, 3, 12),
					  new Ghost(8, 8),
					  new Fruit(15, 8, 8),
					  new Ghost(10, 12),
					  new Fruit(15, 10, 12),
					  new Wall(0, 1),
					  new Wall(0, 2),
					  new Wall(0, 8),
					  new Wall(0, 9),
					  new Wall(0, 10),
					  new Wall(0, 11),
					  new Wall(0, 12),
					  new Wall(0, 13),
					  new Wall(0, 14),
					  new Wall(1, 4),
					  new Wall(1, 5),
					  new Wall(1, 6),
					  new Wall(1, 13),
					  new Wall(1, 14),
					  new Wall(2, 1),
					  new Wall(2, 2),
					  new Wall(2, 4),
					  new Wall(2, 5),
					  new Wall(2, 6),
					  new Wall(2, 8),
					  new Wall(2, 9),
					  new Wall(2, 10),
					  new Wall(2, 11),
					  new Wall(2, 13),
					  new Wall(2, 14),
					  new Wall(3, 1),
					  new Wall(3, 2),
					  new Wall(3, 4),
					  new Wall(3, 5),
					  new Wall(3, 6),
					  new Wall(3, 8),
					  new Wall(3, 9),
					  new Wall(3, 10),
					  new Wall(3, 11),
					  new Wall(3, 13),
					  new Wall(3, 14),
					  new Wall(4, 6),
					  new Wall(4, 14),
					  new Wall(5, 0),
					  new Wall(5, 1),
					  new Wall(5, 2),
					  new Wall(5, 3),
					  new Wall(5, 4),
					  new Wall(5, 8),
					  new Wall(5, 9),
					  new Wall(5, 11),
					  new Wall(5, 12),
					  new Wall(5, 14),
					  new Wall(6, 0),
					  new Wall(6, 1),
					  new Wall(6, 2),
					  new Wall(6, 6),
					  new Wall(6, 7),
					  new Wall(6, 8),
					  new Wall(6, 9),
					  new Wall(6, 11),
					  new Wall(6, 12),
					  new Wall(6, 14),
					  new Wall(7, 4),
					  new Wall(7, 6),
					  new Wall(7, 7),
					  new Wall(7, 8),
					  new Wall(7, 9),
					  new Wall(7, 11),
					  new Wall(7, 12),
					  new Wall(7, 14),
					  new Wall(8, 1),
					  new Wall(8, 2),
					  new Wall(8, 3),
					  new Wall(8, 4),
					  new Wall(8, 14),
					  new Wall(9, 1),
					  new Wall(9, 2),
					  new Wall(9, 3),
					  new Wall(9, 4),
					  new Wall(9, 6),
					  new Wall(9, 8),
					  new Wall(9, 9),
					  new Wall(9, 10),
					  new Wall(9, 11),
					  new Wall(9, 13),
					  new Wall(9, 14),
					  new Wall(10, 3),
					  new Wall(10, 4),
					  new Wall(10, 6),
					  new Wall(10, 8),
					  new Wall(10, 9),
					  new Wall(10, 10),
					  new Wall(10, 11),
					  new Wall(10, 13),
					  new Wall(10, 14),
					  new Wall(11, 0),
					  new Wall(11, 1),
					  new Wall(11, 8),
					  new Wall(11, 13),
					  new Wall(11, 14),
					  new Wall(12, 0),
					  new Wall(12, 1),
					  new Wall(12, 3),
					  new Wall(12, 4),
					  new Wall(12, 6),
					  new Wall(12, 8),
					  new Wall(12, 10),
					  new Wall(12, 11),
					  new Wall(12, 12),
					  new Wall(12, 13),
					  new Wall(12, 14),
					  new Wall(13, 0),
					  new Wall(13, 1),
					  new Wall(13, 2),
					  new Wall(13, 3),
					  new Wall(13, 4),
					  new Wall(13, 6),
					  new Wall(13, 8),
					  new Wall(13, 10),
					  new Wall(13, 11),
					  new Wall(13, 12),
					  new Wall(13, 13),
					  new Wall(13, 14),
					  new Wall(14, 0),
					  new Wall(14, 1),
					  new Wall(14, 2),
					  new Wall(14, 3),
					  new Wall(14, 4),
					  new Wall(14, 10),
					  new Wall(14, 11),
					  new Wall(14, 12),
					  new Wall(14, 13),
					  new Wall(14, 14),
					  new Fruit(15, 0, 4),
					  new Fruit(15, 0, 5),
					  new Fruit(15, 0, 6),
					  new Fruit(15, 0, 7),
					  new Fruit(15, 1, 1),
					  new Fruit(15, 1, 2),
					  new Fruit(15, 1, 3),
					  new Fruit(15, 1, 7),
					  new Fruit(15, 1, 9),
					  new Fruit(15, 1, 10),
					  new Fruit(15, 1, 11),
					  new Fruit(15, 1, 12),
					  new Fruit(15, 2, 0),
					  new Fruit(15, 2, 3),
					  new Fruit(15, 2, 7),
					  new Fruit(15, 2, 12),
					  new Fruit(15, 3, 0),
					  new Fruit(15, 3, 3),
					  new Fruit(15, 3, 7),
					  new Fruit(15, 4, 0),
					  new Fruit(15, 4, 1),
					  new Fruit(15, 4, 2),
					  new Fruit(15, 4, 3),
					  new Fruit(15, 4, 4),
					  new Fruit(15, 4, 5),
					  new Fruit(15, 4, 7),
					  new Fruit(15, 4, 8),
					  new Fruit(15, 4, 9),
					  new Fruit(15, 4, 10),
					  new Fruit(15, 4, 12),
					  new Fruit(15, 4, 13),
					  new Fruit(15, 5, 5),
					  new Fruit(15, 5, 6),
					  new Fruit(15, 5, 7),
					  new Fruit(15, 5, 10),
					  new Fruit(15, 5, 13),
					  new Fruit(15, 6, 3),
					  new Fruit(15, 6, 4),
					  new Fruit(15, 6, 5),
					  new Fruit(15, 6, 10),
					  new Fruit(15, 6, 13),
					  new Fruit(15, 7, 0),
					  new Fruit(15, 7, 1),
					  new Fruit(15, 7, 2),
					  new Fruit(15, 7, 10),
					  new Fruit(15, 7, 13),
					  new Fruit(15, 8, 0),
					  new Fruit(15, 8, 5),
					  new Fruit(15, 8, 6),
					  new Fruit(15, 8, 7),
					  new Fruit(15, 8, 9),
					  new Fruit(15, 8, 10),
					  new Fruit(15, 8, 11),
					  new Fruit(15, 8, 12),
					  new Fruit(15, 9, 0),
					  new Fruit(15, 9, 5),
					  new Fruit(15, 9, 7),
					  new Fruit(15, 9, 12),
					  new Fruit(15, 10, 0),
					  new Fruit(15, 10, 1),
					  new Fruit(15, 10, 2),
					  new Fruit(15, 10, 5),
					  new Fruit(15, 10, 7),
					  new Fruit(15, 11, 2),
					  new Fruit(15, 11, 3),
					  new Fruit(15, 11, 4),
					  new Fruit(15, 11, 5),
					  new Fruit(15, 11, 6),
					  new Fruit(15, 11, 7),
					  new Fruit(15, 11, 9),
					  new Fruit(15, 11, 11),
					  new Fruit(15, 11, 12),
					  new Fruit(15, 12, 5),
					  new Fruit(15, 12, 7),
					  new Fruit(15, 12, 9),
					  new Fruit(15, 13, 7),
					  new Fruit(15, 13, 9),
					  new Fruit(15, 14, 5),
					  new Fruit(15, 14, 6),
					  new Fruit(15, 14, 7),
					  new Fruit(15, 14, 8),
					  new Fruit(15, 14, 9),
					  
					  
					  
					  
					  
			};
	
	/**
	 * Level 3 has 8 ghosts and every fruits have the value 20
	 * @author Antoine Chrétien
	 */
	private static Entite[] liste_niveau_3= new Entite[] {
			  new Pacman(10, 0, 1, 14), 
			  new Ghost(2,5),
			  new Fruit(20, 2, 5),
			  new Ghost(2,11),
			  new Fruit(20, 2, 11),
			  new Ghost(5,0),
			  new Fruit(20, 5, 0),
			  new Ghost(6,12),
			  new Fruit(20, 6, 12),
			  new Ghost(10,2),
			  new Fruit(20, 10, 2),
			  new Ghost(10,7),
			  new Fruit(20, 10, 7),
			  new Ghost(13,4),
			  new Fruit(20, 13, 4),
			  new Ghost(13,13),
			  new Wall(0, 0),
			  new Wall(0, 1),
			  new Wall(0, 2),
			  new Wall(0, 3),
			  new Wall(0, 4),
			  new Wall(0, 5),
			  new Wall(0, 6),
			  new Wall(0, 7),
			  new Wall(0, 9),
			  new Wall(0, 13),
			  new Wall(0, 14),
			  new Wall(1, 0),
			  new Wall(1, 4),
			  new Wall(1, 11),
			  new Wall(2, 0),
			  new Wall(2, 2),
			  new Wall(2, 4),
			  new Wall(2, 6),
			  new Wall(2, 7),
			  new Wall(2, 9),
			  new Wall(2, 13),
			  new Wall(3, 2),
			  new Wall(3, 6),
			  new Wall(3, 9),
			  new Wall(3, 11),
			  new Wall(3, 13),
			  new Wall(4, 1),
			  new Wall(4, 2),
			  new Wall(4, 4),
			  new Wall(4, 5),
			  new Wall(4, 6),
			  new Wall(4, 8),
			  new Wall(4, 9),
			  new Wall(5, 1),
			  new Wall(5, 2),
			  new Wall(5, 4),
			  new Wall(5, 5),
			  new Wall(5, 6),
			  new Wall(5, 8),
			  new Wall(5, 9),
			  new Wall(5, 10),
			  new Wall(5, 11),
			  new Wall(5, 12),
			  new Wall(5, 13),
			  new Wall(6, 4),
			  new Wall(6, 5),
			  new Wall(6, 6),
			  new Wall(6, 8),
			  new Wall(6, 9),
			  new Wall(6, 10),
			  new Wall(6, 11),
			  new Wall(7, 0),
			  new Wall(7, 2),
			  new Wall(7, 3),
			  new Wall(7, 4),
			  new Wall(7, 5),
			  new Wall(7, 6),
			  new Wall(7, 8),
			  new Wall(7, 13),
			  new Wall(7, 14),
			  new Wall(8, 0),
			  new Wall(8, 2),
			  new Wall(8, 3),
			  new Wall(8, 4),
			  new Wall(8, 10),
			  new Wall(8, 11),
			  new Wall(8, 13),
			  new Wall(8, 14),
			  new Wall(9, 0),
			  new Wall(9, 2),
			  new Wall(9, 3),
			  new Wall(9, 4),
			  new Wall(9, 6),
			  new Wall(9, 7),
			  new Wall(9, 8),
			  new Wall(9, 10),
			  new Wall(9, 11),
			  new Wall(9, 13),
			  new Wall(9, 14),
			  new Wall(10, 0),
			  new Wall(10, 10),
			  new Wall(10, 11),
			  new Wall(10, 13),
			  new Wall(10, 14),
			  new Wall(11, 0),
			  new Wall(11, 1),
			  new Wall(11, 2),
			  new Wall(11, 4),
			  new Wall(11, 5),
			  new Wall(11, 6),
			  new Wall(11, 7),
			  new Wall(11, 8),
			  new Wall(11, 14),
			  new Wall(12, 0),
			  new Wall(12, 1),
			  new Wall(12, 2),
			  new Wall(12, 4),
			  new Wall(12, 5),
			  new Wall(12, 6),
			  new Wall(12, 7),
			  new Wall(12, 9),
			  new Wall(12, 10),
			  new Wall(12, 11),
			  new Wall(12, 12),
			  new Wall(12, 14),
			  new Wall(13, 0),
			  new Wall(13, 9),
			  new Wall(13, 10),
			  new Wall(13, 11),
			  new Wall(13, 12),
			  new Wall(13, 14),
			  new Wall(14, 0),
			  new Wall(14, 4),
			  new Wall(14, 5),
			  new Wall(14, 6),
			  new Wall(14, 7),
			  new Wall(14, 14),
			  new Fruit(20, 0, 8),
			  new Fruit(20, 0, 10),
			  new Fruit(20, 0, 11),
			  new Fruit(20, 0, 12),
			  new Fruit(20, 1, 1),
			  new Fruit(20, 1, 2),
			  new Fruit(20, 1, 3),
			  new Fruit(20, 1, 5),
			  new Fruit(20, 1, 6),
			  new Fruit(20, 1, 7),
			  new Fruit(20, 1, 8),
			  new Fruit(20, 1, 9),
			  new Fruit(20, 1, 10),
			  new Fruit(20, 1, 12),
			  new Fruit(20, 1, 13),
			  new Fruit(20, 2, 1),
			  new Fruit(20, 2, 3),
			  new Fruit(20, 2, 8),
			  new Fruit(20, 2, 10),
			  new Fruit(20, 2, 12),
			  new Fruit(20, 2, 14),
			  new Fruit(20, 3, 0),
			  new Fruit(20, 3, 1),
			  new Fruit(20, 3, 3),
			  new Fruit(20, 3, 4),
			  new Fruit(20, 3, 5),
			  new Fruit(20, 3, 7),
			  new Fruit(20, 3, 8),
			  new Fruit(20, 3, 10),
			  new Fruit(20, 3, 12),
			  new Fruit(20, 3, 14),
			  new Fruit(20, 4, 0),
			  new Fruit(20, 4, 3),
			  new Fruit(20, 4, 7),
			  new Fruit(20, 4, 10),
			  new Fruit(20, 4, 11),
			  new Fruit(20, 4, 12),
			  new Fruit(20, 4, 13),
			  new Fruit(20, 4, 14),
			  new Fruit(20, 5, 3),
			  new Fruit(20, 5, 7),
			  new Fruit(20, 5, 14),
			  new Fruit(20, 6, 0),
			  new Fruit(20, 6, 1),
			  new Fruit(20, 6, 2),
			  new Fruit(20, 6, 3),
			  new Fruit(20, 6, 7),
			  new Fruit(20, 6, 13),
			  new Fruit(20, 6, 14),
			  new Fruit(20, 7, 1),
			  new Fruit(20, 7, 7),
			  new Fruit(20, 7, 9),
			  new Fruit(20, 7, 10),
			  new Fruit(20, 7, 11),
			  new Fruit(20, 7, 12),
			  new Fruit(20, 8, 1),
			  new Fruit(20, 8, 5),
			  new Fruit(20, 8, 6),
			  new Fruit(20, 8, 7),
			  new Fruit(20, 8, 8),
			  new Fruit(20, 8, 9),
			  new Fruit(20, 8, 12),
			  new Fruit(20, 9, 1),
			  new Fruit(20, 9, 5),
			  new Fruit(20, 9, 9),
			  new Fruit(20, 9, 12),
			  new Fruit(20, 10, 1),
			  new Fruit(20, 10, 3),
			  new Fruit(20, 10, 4),
			  new Fruit(20, 10, 5),
			  new Fruit(20, 10, 6),
			  new Fruit(20, 10, 8),
			  new Fruit(20, 10, 9),
			  new Fruit(20, 10, 12),
			  new Fruit(20, 11, 3),
			  new Fruit(20, 11, 9),
			  new Fruit(20, 11, 10),
			  new Fruit(20, 11, 11),
			  new Fruit(20, 11, 12),
			  new Fruit(20, 11, 13),
			  new Fruit(20, 12, 3),
			  new Fruit(20, 12, 8),
			  new Fruit(20, 12, 13),
			  new Fruit(20, 13, 1),
			  new Fruit(20, 13, 2),
			  new Fruit(20, 13, 3),
			  new Fruit(20, 13, 5),
			  new Fruit(20, 13, 6),
			  new Fruit(20, 13, 7),
			  new Fruit(20, 13, 8),
			  new Fruit(20, 14, 1),
			  new Fruit(20, 14, 2),
			  new Fruit(20, 14, 3),
			  new Fruit(20, 14, 8),
			  new Fruit(20, 14, 9),
			  new Fruit(20, 14, 11),
			  new Fruit(20, 14, 12),
			  new Fruit(20, 14, 13),
			  
			  
			  
			  
			
			
	};
	
	private static Carte niveau_1 = new Carte(liste_niveau_1);
	private static Carte niveau_2 = new Carte(liste_niveau_2);
	private static Carte niveau_3 = new Carte(liste_niveau_3);
	
	/**
	 * this method give an initial map for a level give. We have initialize 3 Maps for levels 1,2 and 3
	 * @param level
	 * @return a list with the initial coordinate of Pacman, walls, Fruits(with values) and Ghosts
	 */
	public static Carte get_carte(int level) {
		
		if (level == 1) {
			
			return niveau_1;
			
		}
		
		else if (level == 2) {
			
			return niveau_2;
			
		}
		
		else if(level ==3) {
			
			return niveau_3;
		}
		
		else {
			
			return null;
			
		}
	}

}
