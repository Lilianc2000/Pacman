package view;

import data.Entite;
import data.Level;
import logic.Carte;
import logic.Fruit;
import logic.Pacman;
import logic.Wall;
import logic.Ghost;

/**
 * Main method of the program
 * @author Lilian Cizeron
 * @param int the number of case in X and Y 
 */

public class Main {
		
	public static void main(String[] args) {
		
		int taille = -1;
		try{
    		taille = Integer.parseInt(args[0]);				//Taille de la carte n*n
      	}
    	catch(Exception e) {
    		System.out.println("Please, type an integer.");
    		System.exit(-1);
    	}
		

		Entite[] item = new Entite[taille * taille];
		item[0] = new Pacman(10, 0, 0, 1);
		item[1] = new Fruit(10, 0, 2);
		item[2] = new Fruit(10, 0, 3);
		item[3] = new Fruit(10, 0, 4);
		item[4] = new Fruit(10, 0, 5);
		item[5] = new Fruit(10, 0, 6);
		item[6] = new Fruit(10, 0, 7);
		item[7] = new Ghost(0, 8);
		item[8] = new Wall(0, 9);
		item[9] = new Wall(0, 10);
		item[10] = new Wall(0, 11);
		item[11] = new Wall(0, 12);
		item[12] = new Wall(0, 13);
		item[13] = new Wall(0, 14);
		item[14] = new Wall(0, 0);
		item[15] = new Fruit(10, 1, 1);
		item[16] = new Fruit(10, 2, 1);
		item[17] = new Fruit(10, 3, 1);
		item[18] = new Fruit(10, 4, 1);
		item[19] = new Fruit(10, 5, 1);
		item[20] = new Fruit(10, 6, 1);
		item[21] = new Fruit(10, 7, 1);
		item[22] = new Fruit(10, 8, 1);
		item[23] = new Fruit(10, 9, 1);
		item[24] = new Fruit(10, 10, 1);
		item[25] = new Fruit(10, 11, 1);
		item[26] = new Fruit(10, 12, 1);
		item[27] = new Fruit(10, 13, 1);
		item[28] = new Wall(14, 1);
		item[29] = new Wall(0, 0);
		item[30] = new Wall(1, 0);
		item[31] = new Wall(2, 0);
		item[32] = new Wall(3, 0);
		item[33] = new Wall(4, 0);
		item[34] = new Wall(5, 0);
		item[35] = new Wall(6, 0);
		item[36] = new Wall(7, 0);
		item[37] = new Wall(8, 0);
		item[38] = new Wall(9, 0);
		item[39] = new Wall(10, 0);
		item[40] = new Wall(11, 0);
		item[41] = new Wall(12, 0);
		item[42] = new Ghost(13, 1);
		
		int k = 43;
		
		for (int i = 1; i < taille; i++) {
			
			for (int j = 2; j < taille; j++) {
				
				item[k] = new Wall(i, j);
				k = k + 1;
				
			}
				
		}
		

		int lvl = 1;
		
		//Carte carte = Level.get_carte(lvl);
		Carte carte = new Carte(item);
		int Xresolution = 60 * taille, Yresolution = 65 * taille;			//Résolution de la fenetre
		GUI frame = new GUI(taille, carte, 0, lvl, Xresolution, Yresolution);
        frame.setSize(Xresolution, Yresolution);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setTitle("Pacman Game");
		
	}

}
