package logic;

import data.Entite;
import data.Fruit;
import data.Ghost;
import data.Pacman;
import data.Wall;

public abstract class Level {

	// Antoine, la premiere ligne du premier niveau est faite. Je te laisse la modifié si tu le souhaites,
	// et compléter les 14 autres lignes ainsi que le niveau 2
	private static Entite[] liste_niveau_1 = new Entite[]
									  {
									  new Wall(0, 0),
									  new Pacman(10, 0, 0, 1), 
									  new Fruit(10, 0, 2),
									  new Fruit(10, 0, 3),
									  new Fruit(10, 0, 4),
									  new Fruit(10, 0, 5),
									  new Fruit(10, 0, 6),
									  new Fruit(10, 0, 7),
									  new Ghost(0, 8),
									  new Wall(0, 9),
									  new Wall(0, 10),
									  new Wall(0, 11),
									  new Wall(0, 12),
									  new Wall(0, 13),
									  new Wall(0, 14),
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
