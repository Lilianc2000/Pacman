package logic;

import data.Entite;

public abstract class Level {

	private static Entite[] niveau_1;
	private static Entite[] niveau_2;
	
	public static Entite[] get_carte(int level) {
		
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
