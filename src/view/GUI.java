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

	/**
	 * Serial UID of the frame
	 */
	private static final long serialVersionUID = 0;

	private JPanel contentPane;
	
	// Création des objets graphiques des objets
	private ImageIcon pacman = new ImageIcon(GUI.class.getResource("/game/pacman.png"));
	private ImageIcon ghost = new ImageIcon(GUI.class.getResource("/game/ghost.png"));
	private ImageIcon fruit = new ImageIcon(GUI.class.getResource("/game/fruit.png"));
	private ImageIcon wall = new ImageIcon(GUI.class.getResource("/game/wall.png"));
	private ImageIcon empty = new ImageIcon(GUI.class.getResource("/game/null.png"));
	private JTable table_1;
	
	// Suivi du clavier
	public boolean upPressed, downPressed, rightPressed, leftPressed;
			
	// Création du tableau pour l'affichage
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
	
	/**
	 * Constructor of the GUI
	 * @param taille the number of case in x and y
	 * @param item the list of objects to draw on the GUI
	 * @param score_pre the score to initialize the game
	 */
	
	public GUI(int taille, Carte carte, int score_pre, int lvl){
		
		// Récupération de la taille de la map
		this.taille = taille;
		
		// Récupération de la carte
		this.carte = carte;
		this.item = carte.get_all();
		this.lvl = lvl;
		
		// Récupération du score initial
		this.SCORE = score_pre;
		
		// On défini les paramètres de base de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// Création de la bar de menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// Création du bouton start et ajout à la bar de menu
		JButton btnStart = new JButton("Start");
		menuBar.add(btnStart);
		
		// Création du bounton exit et ajout à la bar de menu
		JButton btnExit = new JButton("Exit");
		menuBar.add(btnExit);
		
		// Création de la zone de score
		JLabel score = new JLabel("Score = " + this.SCORE);
		menuBar.add(score);
		
		// Création de la fenêtre
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	       
		// Création du panneau d'affichage
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		// Initialisation du tableau
		donnee = new ImageIcon[this.taille][this.taille];
		entetes = new String[this.taille];
		initialize_table(item);
		
		// On initialise le tableau graphique
		
		modele = new DefaultTableModel(donnee, entetes);
		table_1 = new JTable(modele)
		{          
			private static final long serialVersionUID = 1;
            
			// Permet de détecter le type des variables dans le tableau et de les afficher correctement
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int colonne)
           {
               return getValueAt(0, colonne).getClass();
           }
			
            public boolean isCellEditable(int x, int y) {
            	return false;
            }
        };
        
        table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table_1.setRowHeight(60);
        table_1.setCellSelectionEnabled(false);
        table_1.setFocusable(true);
        table_1.setIntercellSpacing(new Dimension(0, 0));
        contentPane.add(table_1);
        
        // Suivi du clavier
        // Le suivi du clavier est fait sur le tableau car celui-ci occupe tout le JPanel et donc on ne peut obtenir le focus sur le JPanel
        table_1.addKeyListener(new KeyboardListener());
        
        // Création de l'action du bouton exit
        ActionListener action_exit = new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
				// On quite en envoyant un code du score de pacman, cela peut toujours être utile
        		System.exit(((Pacman) item[PACMAN_POSITION]).get_score());
		
        	}
        	
        };
        
        btnExit.addActionListener(action_exit);
        
        // Création de l'action du bouton start
        ActionListener action_start = new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		btnStart.setEnabled(false);
        		System.out.println("Game launched");
        		table_1.requestFocus();
        		new Thread() {
        			public void run() {
        				
        				try {
            				
        					game(item, score);
        					
        				} 
            			
            			catch (InterruptedException e1) {
            				
        					e1.printStackTrace();
        					
        				}
            			
            			finally {
            				
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
	 * Method to set the map with items of the game
	 * @param item the list of item in the game
	 * @param donnee the list of the graphicals item in the game
	 */
	
	private void initialize_table(Entite[] item) {
		
		// On rempli le tableau avec les éléments nécessaires
		for (int i = 0; i < item.length; i++) {
			
			// Si l'item donne est un pacman, alors on remplie le tableau donne avec un objet pacman imagé, aux coordonnées de l'item
			if (item[i] instanceof Pacman) {
					
				assert PACMAN_POSITION == -1 : "More than 1 Pacman detected";
				this.donnee[(item[i]).get_x()][(item[i]).get_y()] = this.pacman;
				PACMAN_POSITION = i;
						
			}
			
			// Si l'item donne est un fantome, alors on remplie le tableau donne avec un objet fantome imagé, aux coordonnées de l'item
			else if (item[i] instanceof Ghost) {
					
				this.donnee[item[i].get_x()][item[i].get_y()] = this.ghost;	
				
			}
			
			// Si l'item donne est un fruit, alors on remplie le tableau donne avec un objet fruit imagé, aux coordonnées de l'item
			else if (item[i] instanceof Fruit) {
						
				this.donnee[item[i].get_x()][item[i].get_y()] = this.fruit;
				
			}
			
			// Si l'item est du vide
			else if (item[i] instanceof Empty) {
				
				this.donnee[item[i].get_x()][item[i].get_y()] = this.empty;
				
			}
			
			// Si l'item est un mur
			else if (item[i] instanceof Wall){
				
				this.donnee[item[i].get_x()][item[i].get_y()] = this.wall;
				
			}
					
		}
		
		assert PACMAN_POSITION != -1 : "No Pacman detected";
		
	}
	
	/**
	 * Method to move item on the gui
	 * @param item a list of Entite
	 */
	
	private void change_gui(Entite[] item) {
		
		// On rempli le tableau avec les éléments nécessaires
		for (int i = 0; i < item.length; i++) {
			
			// Si l'item donne est un pacman, alors on remplie le tableau donne avec un objet pacman imagé, aux coordonnées de l'item
			if (item[i] instanceof Pacman) {
							
				for (int j = 0; i < taille; i++) {
					
					for (int k = 0; j < taille; j++) {
						
						if (modele.getValueAt(j, k) == this.pacman) {
							
							modele.setValueAt(this.empty, j, k);
							
						}
						
					}
					
				}
				modele.setValueAt(this.pacman, item[i].get_x(), item[i].get_y());
				PACMAN_POSITION = i;
								
			}
					
			// Si l'item donne est un fantome, alors on remplie le tableau donne avec un objet fantome imagé, aux coordonnées de l'item
			else if (item[i] instanceof Ghost) {
				
				if (modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.pacman) {
					
					
					
				}
				else {
					
					modele.setValueAt(this.ghost, item[i].get_x(), item[i].get_y());	
					
				}
			}
					
			// Si l'item donne est un fruit, alors on remplie le tableau donne avec un objet fruit imagé, aux coordonnées de l'item
			else if (item[i] instanceof Fruit) {

				if (modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.pacman) {
					
					
					
				}
				else {
					
					modele.setValueAt(this.fruit, item[i].get_x(), item[i].get_y());	
					
				}
			}
					
			// Si l'item est du vide
			else if (item[i] instanceof Empty) {

				if (modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.pacman) {
					
					
					
				}
				else {
					
					modele.setValueAt(this.empty, item[i].get_x(), item[i].get_y());	
					
				}
			}
					
			// Si l'item est un mur
			else if (item[i] instanceof Wall){

				if (modele.getValueAt(item[i].get_x(), item[i].get_y()) == this.pacman) {
					
					
					
				}
				else {
					
					modele.setValueAt(this.wall, item[i].get_x(), item[i].get_y());	
					
				}
			}
							
		}
				
		modele.fireTableDataChanged();
		
	}
	
	/**
	 * Method to launch the game
	 * @param item a table of item in the game
	 * @throws InterruptedException 
	 */
	
	private void game(Entite[] item, JLabel score) throws InterruptedException {
		
		// Tant qu'il y a des fruits en jeu et que Pacman a de la vie, on peut le déplacer
		
		while (carte.are_Fruits() && ((Pacman) item[PACMAN_POSITION]).get_life() > 0) {
			
			System.out.println("Waiting actions");
			Thread.sleep(500);
			
			try {
				// Si on a pressé UP, alors on envoie le code 1 pour le déplacement
				if (upPressed) {
				
					carte.move_pacman(1);
				
				}
			
				// Si on a pressé DOWN, alors on envoie le code 2 pour le déplacement
				else if (downPressed) {
				
					carte.move_pacman(2);
				
				}
			
				// Si on a pressé RIGHT, alors on envoie le code 3 pour le déplacement
				else if (rightPressed) {
				
					carte.move_pacman(3);
				
				}
			
				// Si on a pressé LEFT, alors on envoie le code 4 pour le déplacement
				else if (leftPressed) {
				
					carte.move_pacman(4);
				
				}
			
				// Sinon, on doit continuer dans la meme direction, on envoie donc le code 5
				else {
				
					carte.move_pacman(5);
					
				}
			}
			catch (Exception e) {
				
				
				
			}
			finally {
				
				// On fait bouger les fantomes
				carte.move_ghost();
				
				// On rebalaye tout le tableau après le déplacement de pacman et donc aussi les déplacements des fantomes
				Entite[] item2 = new Entite[donnee.length * donnee.length];
				item2 = carte.get_all();
			
				// Et on redraw le tableau
				change_gui(item2);
				
				// On affiche le score
				this.SCORE = ((Pacman) item[PACMAN_POSITION]).get_score();
			
				this.setTitle("Pacman Game - Score : " + this.SCORE);
				score.setText("Score : " + this.SCORE);
		
			}
		}
		// Si on a arreté de jouer et qu'il y a encore des fruits, c'est que pacman n'a plus de vie, et donc on arrete le jeu
		if (carte.are_Fruits()) {
					
			System.out.println("You loose !");
			System.out.println("Your score : " + this.SCORE);
					
		}
				
		// Sinon, c'est que l'on veut changer de niveau
		else {
			 // On récupère la nouvelle carte
			Carte new_map = Level.get_carte(lvl + 1);
			
			// On crée une nouvelle fenêtre
			GUI frame = new GUI(this.taille, new_map, this.SCORE, this.lvl + 1);
			
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
	                    System.out.println("UP");
	                    break;
	                case KeyEvent.VK_DOWN:
	                    downPressed = true;
	                    System.out.println("DOWN");
	                    break;
	                case KeyEvent.VK_LEFT:
	                    leftPressed = true;
	                    System.out.println("LEFT");
	                    break;
	                case KeyEvent.VK_RIGHT:
	                	System.out.println("RIGHT");
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
