package view;

/**
 * Required package for the GUI
 * @depend java.awt
 * @depend java.swing
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import data.Entite;
import data.Level;
import logic.Carte;
import logic.Empty;
import logic.Fruit;
import logic.Ghost;
import logic.Pacman;
import logic.Wall;

/**
 * Graphical User Interface Class
 * Use to display the game and to interact with the user
 * @author Lilian Cizeron
 *
 */

public class GUI extends JFrame {

	//Serial UID of the frame
	private static final long serialVersionUID = 0;

	// Objet pour l'interface
	private JPanel contentPane;
	
	// Creation des objets graphiques des objets
	private ImageIcon pacman = new ImageIcon(GUI.class.getResource("/view/pacman.png"));
	private ImageIcon ghost = new ImageIcon(GUI.class.getResource("/view/ghost.png"));
	private ImageIcon fruit = new ImageIcon(GUI.class.getResource("/view/fruit.png"));
	private ImageIcon wall = new ImageIcon(GUI.class.getResource("/view/wall.png"));
	private ImageIcon empty = new ImageIcon(GUI.class.getResource("/view/null.png"));
	
	// Suivi du clavier
	public boolean upPressed, downPressed, rightPressed, leftPressed;
			
	// Creation du tableau pour l'affichage
	private JTable table_1;
	private ImageIcon[][] donnee;
	private String[] entetes;
	
	// Variables diverses
	private int PACMAN_POSITION = -1;
	private int taille = -1;
	private int SCORE = -1;
	private Carte carte;
	private Entite[] item;
	private DefaultTableModel modele;
	private int lvl = -1;
	private int Xresolution;
	private int Yresolution;
	private JLabel score;
	private JLabel life;
	
	/**
	 * Constructor of the GUI
	 * @param taille the number of case in x and y
	 * @param carte the carte to show
	 * @param score_pre the score to initialize the game
	 * @param pacman_life the remaining pacman life
	 * @param lvl the lvl of the carte initialized
	 * @param Xresolution the x resolution of the window
	 * @param Yresolution the y resolution of the window
	 * @throws Exception 
	 */
	
	public GUI(int taille, Carte carte, int score_pre, int lvl, int Xresolution, int Yresolution, int pacman_life) throws Exception{
		
		// Recuperation de la taille de la map
		this.taille = taille;
		
		// Recuperation de la carte
		this.carte = carte;
		this.item = carte.get_all();
		this.lvl = lvl;
		
		// Recuperation de la taille de la fenêtre
		this.Xresolution = Xresolution;
		this.Yresolution = Yresolution;
			
		// Recuperation du score initial et de la vie restante
		this.SCORE = score_pre;
		((Pacman) item[carte.get_position()]).set_life(pacman_life);
				
		// On definit les parametres de base de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// Creation de la barre de menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Creation du bouton start et ajout a la barre de menu
		JButton btnStart = new JButton("Start");
		menuBar.add(btnStart);
		
		// Creation du bounton exit et ajout a la barre de menu
		JButton btnExit = new JButton("Exit");
		menuBar.add(btnExit);
		
		// Creation de la zone de score et ajout a la barre de menu
		score = new JLabel("Score : " + this.SCORE + "  ");
		menuBar.add(score);
		
		// Creation du contenant de nos items
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	       
		// Creation du panneau d'affichage
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		// Initialisation du tableau de donnee
		donnee = new ImageIcon[this.taille][this.taille];
		entetes = new String[this.taille];
		initialize_table();
		
		// Creation de la zone d'affichage de la vie et ajout a la barre de menu
		life = new JLabel("              Life remaining : " + ((Pacman) item[PACMAN_POSITION]).get_life());
		menuBar.add(life);
		
		// On initialise le tableau graphique
		modele = new DefaultTableModel(donnee, entetes);
		table_1 = new JTable(modele)
		{          
			private static final long serialVersionUID = 1;
            
			// Permet de detecter le type des variables dans le tableau et de les afficher correctement
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int colonne)
           {
               return getValueAt(0, colonne).getClass();
           }
			
            public boolean isCellEditable(int x, int y) {
            	return false;
            }
        };
        
        // On defini ses proprietes
        table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_1.setRowHeight(60);
        table_1.setCellSelectionEnabled(false);
        table_1.setFocusable(true);
        table_1.setIntercellSpacing(new Dimension(0, 0));
        contentPane.add(table_1);
        
        // Suivi du clavier
        // Le suivi du clavier est fait sur le tableau car celui-ci occupe tout le JPanel et donc on ne peut obtenir le focus sur le JPanel
        table_1.addKeyListener(new KeyboardListener());
        
        // Creation de l'action du bouton exit
        ActionListener action_exit = new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
				// On quitte en envoyant un code du score de pacman, cela peut toujours être utile
        		System.exit(((Pacman) item[PACMAN_POSITION]).get_score());
		
        	}
        	
        };
        
        btnExit.addActionListener(action_exit);
        
        // Creation de l'action du bouton start
        ActionListener action_start = new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		// On desactive le bouton et on lance un thread contenant la boucle du jeu
        		// Le thread est ici indispensable car on ne peux pas boucler a l'interieur de l'action du bouton
        		// Cela empeche le programme de s'executer normalement
        		btnStart.setEnabled(false);
        		table_1.requestFocus();
        		new Thread() {
        			public void run() {
        				
        				try {
        					
        					// On joue l'audio de lancement, puis on lance le jeu
        					Audio.playSound("pacman_beginning.wav");
            				Thread.sleep(4000);
        					game();

        				} 
            			
            			catch (Exception e1) {
            					
        				}
            			
            			finally {
            				
            				// Une fois le thread fini, on peut reactiver le bouton start
            				SwingUtilities.invokeLater(new Runnable() {
                                public void run() {
                                     btnStart.setEnabled(true);
                                }
            				});
            				
            			}
        				
        			}
        				
        		}.start();
        	}
        	
        };
        
       btnStart.addActionListener(action_start);
       
	}
	
	/**
	 * Method to set the initial map with items of the game
	 * @throws Exception 
	 */
	
	private void initialize_table() throws Exception {
		
		// On rempli le tableau avec les elements necessaires
		for (int i = 0; i < item.length; i++) {
			
			// Si l'item donne est un pacman, alors on remplie le tableau donne avec un objet pacman image, aux coordonnees de l'item
			if (item[i] instanceof Pacman) {
				
				// On en profite pour lui donner son score initial
				((Pacman) item[i]).set_score(this.SCORE);
				assert PACMAN_POSITION == -1 : "More than 1 Pacman detected";
				this.donnee[(item[i]).get_x()][(item[i]).get_y()] = this.pacman;
				
				// On enregistre la position de pacman, ici et pas plus tot pour verifier qu'on en a que un 
				PACMAN_POSITION = i;
						
			}
			
			// Si l'item donne est un fantome, alors on remplie le tableau donne avec un objet fantome image, aux coordonnees de l'item
			else if (item[i] instanceof Ghost) {

				this.donnee[item[i].get_x()][item[i].get_y()] = this.ghost;	
				
			}
			
			// Si l'item donne est un fruit, alors on remplie le tableau donne avec un objet fruit image, aux coordonnees de l'item
			else if (item[i] instanceof Fruit) {
				
				this.donnee[item[i].get_x()][item[i].get_y()] = this.fruit;
				
			}
			
			// Si l'item est du vide, alors on remplie le tableau donne avec un objet empty image, aux coordonnees de l'item
			else if (item[i] instanceof Empty) {
				
				this.donnee[item[i].get_x()][item[i].get_y()] = this.empty;
				
			}
			
			// Si l'item est un mur, alors on remplie le tableau donne avec un objet wall image, aux coordonnees de l'item
			else if (item[i] instanceof Wall){
				
				this.donnee[item[i].get_x()][item[i].get_y()] = this.wall;
				
			}
			else {
				throw new Exception("Case manquante");
			}
					
		}
		
		// On verifie qu'il y a bien un pacman a l'initialisation
		assert PACMAN_POSITION != -1 : "No Pacman detected";
		
	}
	
	/**
	 * Method to move item on the gui
	 * @param item a list of Entite to draw
	 */
	
	private void change_gui(Entite[] item) {
		
		// On vide le tableau
		for (int i = 0; i < donnee.length; i++) {
			
			for (int j = 0; j < donnee.length; j++) {
				
				modele.setValueAt(null, i, j);
				
			}
			
		}
		
		// On rempli le tableau avec les elements necessaires
		for (int i = 0; i < item.length; i++) {
			
			try {
				// Si l'item donne est un pacman, alors on remplie le tableau donne avec un objet pacman image, aux coordonnees de l'item
				if (item[i] instanceof Pacman) {

					modele.setValueAt(this.pacman, item[i].get_x(), item[i].get_y());
								
				}
				
				// Si l'item donne est un fantome, alors on remplie le tableau donne avec un objet fantome image, aux coordonnees de l'item
				else if (item[i] instanceof Ghost) {
					
					if (modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.pacman) {
						
						// Si un pacman est présent sur sa case, on ne fait rien
						
					}
					else {
						
					modele.setValueAt(this.ghost, item[i].get_x(), item[i].get_y());	
					
					}
				}
				
				// Si l'item donne est un fruit, alors on remplie le tableau donne avec un objet fruit image, aux coordonnees de l'item
				else if (item[i] instanceof Fruit) {
				
					if (modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.pacman || modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.ghost) {
					
						// Si un pacman ou un fantome est présent sur sa case, on ne fait rien
						
					}
					else {
					
						modele.setValueAt(this.fruit, item[i].get_x(), item[i].get_y());	
					
					}
				}
					
				// Si l'item est du vide, alors on remplie le tableau donne avec un objet empty image, aux coordonnees de l'item
				else if (item[i] instanceof Empty) {
				
					if (modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.pacman || modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.ghost || modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.fruit) {
					
						// Si un pacman ou un fantome ou un fruit est présent sur sa case, on ne fait rien
					
					}
					else {
					
						modele.setValueAt(this.empty, item[i].get_x(), item[i].get_y());	
					
					}
				}
					
				// Si l'item est un mur, alors on remplie le tableau donne avec un objet wall image, aux coordonnees de l'item

				else if (item[i] instanceof Wall){
					
					if (modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.pacman || modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.ghost || modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.fruit || modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.empty) {
						
						// Si un pacman ou un fantome ou un fruit est présent sur sa case, on ne fait rien
						
					}
					else {
						
						modele.setValueAt(this.wall, item[i].get_x(), item[i].get_y());	
						
					}
				}
			}
			
			catch(Exception e) {
				
			}
							
		}
		
		// S'il reste des cases null, on y met empty
		for (int i = 0; i < donnee.length; i++) {
			for (int j = 0; j < donnee.length; j++) {
				if (modele.getValueAt(i, j) == null) {
					
					modele.setValueAt(this.empty, i, j);
					
				}
				
			}
			
		}
		
		// On met a jour le tableau
		modele.fireTableDataChanged();
		
	}
	
	/**
	 * Method to launch the game
	 * @throws Exception 
	 */
	
	@SuppressWarnings("static-access")
	private void game() throws Exception {
		
		// Tant qu'il y a des fruits en jeu et que Pacman a de la vie, on peut jouer
		while (carte.are_Fruits() && ((Pacman) item[PACMAN_POSITION]).get_life() > 0) {
			
			// On check le deplacement toutes les 565 ms (la duree du son de deplacement)
			Thread.sleep(565);
			
			try {
				// Si on a pressé UP, alors on envoie le code 1 pour le déplacement
				if (upPressed) {
					
					carte.move_pacman(1, (Pacman) item[PACMAN_POSITION]);
				
				}
			
				// Si on a pressé DOWN, alors on envoie le code 2 pour le déplacement
				else if (downPressed) {

					carte.move_pacman(2, (Pacman) item[PACMAN_POSITION]);
				
				}
			
				// Si on a pressé RIGHT, alors on envoie le code 3 pour le déplacement
				else if (rightPressed) {

					carte.move_pacman(3,(Pacman) item[PACMAN_POSITION]);
				
				}
			
				// Si on a pressé LEFT, alors on envoie le code 4 pour le déplacement
				else if (leftPressed) {

					carte.move_pacman(4, (Pacman) item[PACMAN_POSITION]);
				
				}
			
				// Sinon, on doit continuer dans la meme direction, on envoie donc le code 5
				else {

					carte.move_pacman(5, (Pacman) item[PACMAN_POSITION]);
					
				}
			}
			catch (Exception e) {

				
			}
			finally {
				
				// On joue la musique du en jeu
				Audio.playSound("pacman_chomp.wav");
				
				// On fait bouger les fantomes
				carte.move_ghost();

				// On rebalaye tout le tableau après le déplacement de pacman et donc aussi les déplacements des fantomes
				Entite[] item2 = carte.get_all();
			
				// Et on redraw le tableau
				change_gui(item2);
				
				// On affiche le score et la vie restante
				this.SCORE = ((Pacman) this.item[PACMAN_POSITION]).get_score();
				this.setTitle("Pacman Game - Score : " + this.SCORE);
				score.setText("Score : " + this.SCORE + "  ");
				life.setText("              Life remaining : " + ((Pacman) item[PACMAN_POSITION]).get_life());
		
			}
		}
		
		// Si on a arreté de jouer et qu'il y a encore des fruits, c'est que pacman n'a plus de vie, et donc on arrete le jeu
		if (carte.are_Fruits()) {
			
			Thread.sleep(1000);
			
			// On joue le son de defaite et on ouvre une popup indiquant le score
			Audio.playSound("pacman_death.wav");
			Thread.sleep(2000);
			JOptionPane box = new JOptionPane();
			box.showMessageDialog(this, "You loose ! Your score : " + this.SCORE);
			
			// On termine le programme en envoyant le dernier score de pacman, cela peut toujours servir
			System.exit(((Pacman) item[PACMAN_POSITION]).get_score());
			
					
		}
				
		// Sinon, c'est que l'on veut changer de niveau
		else {
			
			Thread.sleep(1000);
			
			 // On récupère la nouvelle carte
			Carte new_map = Level.get_carte(lvl + 1);
			
			// On crée une nouvelle fenêtre en jouant le son de la victoire
			Audio.playSound("victory.wav");
			Thread.sleep(2000);
			GUI frame = new GUI(this.taille, new_map, this.SCORE, this.lvl + 1, this.Xresolution, this.Yresolution, ((Pacman) item[PACMAN_POSITION]).get_life());
			frame.setSize(Xresolution, Yresolution);
	        frame.setResizable(false);
	        frame.setVisible(true);
	        frame.setTitle("Pacman Game");
	        
			// On fait disparaitre la actuelle
			this.dispose();
		}
	
	}
	
	// Classe intermediaire pour lire les inputs claviers des flèches (récupérer chez canva)
	private class KeyboardListener extends KeyAdapter
	    {

	        @Override
	        public void keyPressed(KeyEvent event)
	        {
	            switch (event.getKeyCode()) {
	                case KeyEvent.VK_UP:
	                    upPressed = true;
	                    break;
	                case KeyEvent.VK_DOWN:
	                    downPressed = true;
	                    break;
	                case KeyEvent.VK_LEFT:
	                    leftPressed = true;
	                    break;
	                case KeyEvent.VK_RIGHT:
	                    rightPressed = true;
	                    break;
	                	
	            }
	        }

	        @Override
	        public void keyReleased(KeyEvent event)
	        {
	            switch (event.getKeyCode()) {
	                case KeyEvent.VK_UP:
	                    upPressed = false;
	                    break;
	                case KeyEvent.VK_DOWN:
	                    downPressed = false;
	                    break;
	                case KeyEvent.VK_LEFT:
	                    leftPressed = false;
	                    break;
	                case KeyEvent.VK_RIGHT:
	                    rightPressed = false;
	                    break;
	            }
	        }
	    }

}
