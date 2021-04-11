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
		
		int k = 15;
		
		for (int i = 1; i < taille; i++) {
			
			for (int j = 0; j < taille; j++) {
				
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
