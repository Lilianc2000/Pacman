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

	// Antoine, la premiere ligne du premier niveau est faite. Je te laisse la modifier si tu le souhaites,
	// et completer les 14 autres lignes ainsi que le niveau 2
	private static Entite[] liste_niveau_1 = new Entite[]
									  {
									  new Wall(0, 0),
									  new Pacman(10, 0, 1, 0), 
									  new Fruit(4, 5, 3),
									  new Fruit(6, 8, 7),
									  new Fruit(7, 1, 11),
									  new Fruit(9, 8, 13),
									  new Fruit(8, 14, 2),
									  new Fruit(10, 13, 9),
									  new Ghost(6, 0),
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
									  };
									  
	private static Entite[] liste_niveau_2;
	
	private static Carte niveau_1 = new Carte(liste_niveau_1);
	private static Carte niveau_2 = new Carte(liste_niveau_2);
	
	public static Carte get_carte(int level) {
		
		if (level == 1) {
			
			return niveau_1;
			
		}
		
		else if (level == 2) {
			
			return niveau_2;
			
		}
		
		else {
			
			return null;
			
		}
	}

}
