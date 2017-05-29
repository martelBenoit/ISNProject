import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import java.lang.Math;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO; 

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class fenetre1VsOrdi {

	Image icone = Toolkit.getDefaultToolkit().getImage("images/icone.png");

	JFrame frameNom = new JFrame();	// JFrame pour le nom et mot de passe du joueur 1
	JPanel panMDP = new JPanel();	// JPanel pour la JFrame precedente

	JFrame pan = new JFrame();		
	JPanel pan1 = new JPanel();
	
	JFrame pan2 = new JFrame();
	JPanel pan3 = new JPanel();
	
	JFrame pan4 = new JFrame();
	JPanel pan5 = new JPanel();
	
	JFrame pan6 = new JFrame();
	JPanel pan7 = new JPanel();
	
	JFrame panFin = new JFrame();
	JPanel panFinal = new JPanel();
	
	JFrame panFin2 = new JFrame();
	JPanel panFinal2 = new JPanel();
	
	double [] tab1;		// Tableau pour enregistrer les coordonnees du porte-avion du joueur 1, les suivants sont pour les autres bateaux
	double [] tab2;
	double [] tab3;
	double [] tab4;
	double [] tab5;
	double [] tab6;
	double [] tab7;
	double [] tab8;
	double [] tab9;
	double [] tab10;
	double [] tab11;	// Tableau pour enregistrer la coordonnee entree par le joueur lors du tir afin de pouvoir comparer avec les autres tableaux
	double [] tab12;    // Tableau pour enregistrer la position aleatoire choisi
	double [] memoireOrdi = new double [5];

	
	int nbreMax = 100;
	double [] tabTir1 = new double [nbreMax];
	int nbreMax2 = 100;
	double [] tabTirOrdi = new double [nbreMax2];
	double [] tabTirChoix = new double [100];
	
	JLabel nomTirJ1;
	
	int ver = 0;
	int hor = 0;
	int chh2 = 0;
	int chv = 0;
	
	int choix;
	int positionDeLaCase = 0;
	int tirageAleatoire = 0; //pour savoir si le tirage aleaoire a deja ete effectué
	int nombreAleatoire = 0;
	
	int chh1 = 0;
	double hord;
	double verd;
	int erreur;
	int placement1;		// Le placement est utile pour pouvoir remettre les bateaux placés sur la fenetre de tir
	int placement2;
	int placement3;
	int placement4;
	int placement5;
	int placement6;
	int placement7;
	int placement8;
	int placement9;
	int placement10;
	
	// Pour enregistrer les coordonnees et faire la tableau avec les cases
	int coo1; 
	int coo2;
	int coo3;
	int coo4;
	int coo5;
	int coo6;
	int coo7;
	int coo8;
	int coo9;
	int coo10;
	
	// Pour enregistrer les coordonnees, mais cette fois de l'ordinateur
	int coo11;
	int coo12;
	int coo13;
	int coo14;
	int coo15;
	int coo16;
	int coo17;
	int coo18;
	int coo19;
	int coo20;
	
	int compteur1 = 0;		// Ces compteurs sont utiles pour pouvoir savoir si toutes les cases d'un bateau ont ete touchees
	int compteur2 = 0;
	int compteur3 = 0;
	int compteur4 = 0;
	int compteur5 = 0;
	int compteur6 = 0;
	int compteur7 = 0;
	int compteur8 = 0;
	int compteur9 = 0;
	int compteur10 = 0;
	
	int compteurTirJ = 0;		// Ces deux compteurs comptent le nombre de tirs de chaque joueur
	int compteurTirOrdi = 0;
	int AutoriseTir = 0; 
	int aucunePiste = 1; //pour savoir si l'ordinateur doit tirer en aleatoire ou alors suivre une piste
	int touchePrecedent = 0;
	int validPosition  = 1;
	int nbA; //Pour la position alatoire de l'ordi
	int nbB;
	int NbAMem = 0, NbBMem = 0;
	int testMemoire = 0;
	int nombreTouche = 1; //pour faire N/S/E/O
	int choixDirection = 0;
	int retourPosition = 0;
	int bateauActuel = 0;
	
	int direction0 = 0, direction1 = 0, direction2 = 0, direction3 = 0, directionTot = 0; //direction0 =; direction1 = ;direction2 =; direction3 =
	int tourAQui = 1;
	int testViable = 0;
	double partdec = 0.0;
	int cooPH = 0;
	int cooPV = 0;
	long t1 = 0;
	
	Font titre = new Font("Arial", Font.PLAIN, 25);
	Font sousTitre = new Font("Arial", Font.PLAIN, 18);
	Font cap = new Font("Arial Black", Font.PLAIN, 16);

	Image imageOpe;
	Icon IconButton;
	
	// Creation de JButton
	JButton continuer, recommencer, valider, continuerPlacement;
	// Label de Titre
	JLabel labelTitre;
	JLabel labelSousTitre;
	// JComboBox pour le choix de bateau
	JComboBox choixBateau, choixPlacement, choixTir;
	// JTextField de la coordonnee de base
	JTextField coordonneeBase, nomJ;
	// Label pour coordonneeDeBase
	JLabel coordonneeDeBase, choisissezB, choisissezP, nomDuJ;
	JLabel vainqueur, vainqueurOrdi;
	
	JButton[][] mesCases = new JButton [10][10];	
	JButton[][] mesCases2 = new JButton [10][10];
	int cpt = 1;
	int cpt3 = 1;
    JLabel[] mesCoordonnees = new JLabel [10];
	JLabel[] mesCoordonneesH = new JLabel [10];

	JLabel votreGrille;
	JLabel grilleDeVosTirs;
	JTextField coordonneeTir;
	JButton boutonTir;
	JLabel nombreCoupsJ, nombreCoupsOrdi;
	JLabel votreTir;
	JButton recommencerBateau;

	JButton finish;

	// Valeurs pour les boucles de boutons
	int i, j;
		
	// char pour les coordonnees du bouton clique
	int a, b, c, d;
		
	// JLabel pour l'explication de la coordonnee de base
	JLabel ast1, ast2, ast3;
		
	int toto = 0; //test placement pour l'erreur
		
	//Méthodes pour placement des bateaux
	
	int configurationVerticale(int chv)
	{
		
		int variable= 0;

		if (chv == 'A' | chv == 'a'){		// Si le premier caractere est A ou a (l'utilisateur choisit s'il met une majuscule ou une minuscule
			variable = 0;	// ver = 0, car le tableau commence a 0
		}
		else if (chv == 'B' | chv =='b'){
			variable = 1;
		}
		else if (chv == 'C' | chv =='c'){
			variable = 2;
		}
		else if (chv == 'D' | chv =='d'){
			variable = 3;
		}
		else if (chv == 'E' | chv =='e'){
			variable = 4;
		}
		else if (chv == 'F' | chv =='f'){
			variable = 5;
		}
		else if (chv == 'G' | chv =='g'){
			variable = 6;
		}
		else if (chv == 'H' | chv =='h'){
			variable = 7;
		}
		else if (chv == 'I' | chv =='i'){
			variable = 8;
		}
		else if (chv == 'J' | chv =='j'){
			variable = 9;
		}
		else{
			variable = 10;
		}
		return variable;
	}
			
	void configurationFenetreJoueur()
	{
         // Informations JComboBox choixBateau
        String bateaux [] = {"Porte-Avion (5 cases)"}; 
        choixBateau = new JComboBox(bateaux);
        choixBateau.setLocation(75,75);
        choixBateau.setSize(180,25);
        
        // Informations JComboBox choixPlacement
        String placement [] = {"Horizontal", "Vertical"};
        choixPlacement = new JComboBox(placement);
        choixPlacement.setLocation(75,155);
        choixPlacement.setSize(100,25);
        
        // Informations JTextField coordonneeBase
        coordonneeBase = new JTextField();
        coordonneeBase.setLocation(75,115);
        coordonneeBase.setSize(100,25);
        
        // Informations JLabel choisissezB
        choisissezB = new JLabel ("Bateau selectionn\u00e9");
        choisissezB.setLocation(265,75);
        choisissezB.setSize(170,25);
        
        // Informations JLabel coordonneeDeBase
        coordonneeDeBase = new JLabel ("Entrez la coordonn\u00e9e de base * (a1 par exemple)");
        coordonneeDeBase.setLocation(189, 115);
        coordonneeDeBase.setSize(290,25);
        
        // Informations JLabel choisissezP
        choisissezP = new JLabel ("Choisissez l'orientation de votre bateau");
        choisissezP.setLocation(189,155);
        choisissezP.setSize(280,25);
        
        // Informations bouton continuer
        continuer = new JButton("Continuer");
        continuer.setLocation(120, 275);
        continuer.setSize(220,30);
        
        // Informations bouton recommencer
        recommencer = new JButton ("Recommencer tout");
        recommencer.setLocation(120,315);
        recommencer.setSize(220,30);
        
        // Informations JButton valider
        valider = new JButton ("Valider");
        valider.setLocation(75,195);
        valider.setSize(100,30);
        
        // Informations label titre
        labelTitre = new JLabel(nomJ.getText()+", entrez les coordonn\u00e9es de vos bateaux");
		labelTitre.setFont(titre); 
        labelTitre.setLocation(0,15);
        labelTitre.setHorizontalAlignment(SwingConstants.CENTER);	
        labelTitre.setSize(700,70);
	}

	void nomDuJoueur(){	
		
		frameNom.setSize(400, 100);			// Definit la taille de la fenetre
		frameNom.setTitle("Identification joueur");			// Definit le titre de la fenetre (en haut a gauche)
		frameNom.setLocationRelativeTo(null);	// Met la fenetre au milieu de l'ecran
        frameNom.setContentPane(panMDP);		// Ajoute le contenu de panMDP
        frameNom.setLayout(null);				// Permet de placer les composants où l'on veut dans la fenetre
        frameNom.setUndecorated(true);
		frameNom.setBackground(new Color(0,0,0,0));
		frameNom.setIconImage(icone);

		JLabel imageChoixNom = new JLabel(new ImageIcon("images/fond/choixBataille.gif"));
		imageChoixNom.setBounds(0,0,400,100);
        
        nomJ = new JTextField();					// Cree le nouveau JTextField
        nomJ.setLocation(50,42);					// Place le JTextField dans la fenetre
        nomJ.setSize(130,25);						// Donne la taille visuelle du JTextField
        
        nomDuJ = new JLabel("Votre nom :");			// Cree le nouveau JLabel avec "Votre nom:" ecrit
        nomDuJ.setLocation(50,17);					// Place le JLabel dans la fenetre
        nomDuJ.setSize(90,25);						// Donne la taille du JLabel
        
        continuerPlacement = new JButton("Continuer");	// Cree le nouveau bouton avec "Continuer" ecrit
        continuerPlacement.setLocation(220, 28);			// Place le JButton dans la fenetre
        continuerPlacement.setSize(120,40);				// Donne la taille du bouton
       
        frameNom.add(nomJ);					// Ajoute nomJ a frameNom
        frameNom.add(nomDuJ);
        frameNom.add(continuerPlacement);
        frameNom.add(imageChoixNom);
       
        EcouteurBoutonContinuerMDP ecouteurMDP = new EcouteurBoutonContinuerMDP();		// Cree un nouvel ecouteur nomme ecouteurMDP
        continuerPlacement.addActionListener(ecouteurMDP);									// Ajout l'ecouteur precedement cree au bouton continuerPlacement

        frameNom.setVisible(true);				// Rend les composants de ce panneau visible
	}
	
	class EcouteurBoutonContinuerMDP implements ActionListener{
		public void actionPerformed (ActionEvent clic){
			String chercher = nomJ.getText();	// Cette string va chercher le nom que le joueur 1 a entre
			if (chercher.equals("")){		// Si l'utilisateur 1 n'a rien entre comme nom, il y a une erreur
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer un nom correct", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else{
				joueur();
				frameNom.dispose();		// ferme la fenetre qui est ouverte
			}
		}
	}
	
	
	void joueur(){

		Sound.playTempSound("son/bruitages/start.wav");
	
		JLabel imageFondChoix = new JLabel(new ImageIcon("images/fond/fondChoix.gif"));
		imageFondChoix.setBounds(0,0,700,465);
		
		pan.setSize(700, 465);
		pan.setTitle("Capitaine " + nomJ.getText());
		pan.setLocationRelativeTo(null);
        pan.setContentPane(pan1);
        pan.setLayout(null);	// Permet de placer les composants où l'on veut dans la fenetre
        pan1.setBackground(Color.LIGHT_GRAY);
		pan.setUndecorated(true);
		pan.setIconImage(icone);
		pan.setBackground(new Color(0,0,0,0));
		
        for( int i = 0; i < mesCases.length; i++ ) {
            for( int j = 0; j < mesCases[0].length; j++ ) {
                mesCases[i][j] = new JButton();
                mesCases[i][j].setSize(20,20);
                mesCases[i][j].setBackground(Color.BLUE);
                mesCases[i][j].setLocation(445+20*i,230+20*j); 
                pan1.add(mesCases[i][j]);
           }  
       }

        char cpt2 = 'A';
        
        for(int k = 0; k < mesCoordonnees.length; k++){
        	mesCoordonnees[k] = new JLabel(String.valueOf(cpt2++));
        	mesCoordonnees[k].setSize(10,10);
        	mesCoordonnees[k].setLocation(435, 233+20*k);
        	pan1.add(mesCoordonnees[k]);
        }
        
        for (int l = 0; l < mesCoordonneesH.length; l++){
        	mesCoordonnees[l] = new JLabel(String.valueOf(cpt++));
        	mesCoordonnees[l].setSize(14,10);
        	mesCoordonnees[l].setLocation(452+20*l,217);
        	pan1.add(mesCoordonnees[l]);	
        }
		
		configurationFenetreJoueur();
		
		// Informations JLabel ast1
        ast1 = new JLabel ("* La coordonn\u00e9e de base repr\u00e9sente la coordonn\u00e9e \u00e0");
        ast1.setLocation(85, 360);
        ast1.setSize(520, 25);
        
        // Informations JLabel ast2
        ast2 = new JLabel ("l'extr\u00e9mit\u00e9 gauche du bateau (s'il est plac\u00e9 horizontalement)");
        ast2.setLocation(75, 380);
        ast2.setSize(500,25);
        
          // Informations JLabel ast2
        ast3 = new JLabel ("et l'extr\u00e9mit\u00e9 du haut (s'il est plac\u00e9 verticalement)");
        ast3.setLocation(75, 400);
        ast3.setSize(500,25);
		
        // Ajout des JButton
        pan.add(continuer);
        pan.add(recommencer);
        pan.add(valider);
       
        // Ajout des JLabel
        pan.add(labelTitre);
        pan.add(coordonneeDeBase);
        pan.add(choisissezB);
        pan.add(choisissezP);
        pan.add(ast1);
        pan.add(ast2);
        pan.add(ast3);
        
        // Ajout de la JComboBox
        pan.add(choixBateau);
        pan.add(choixPlacement);
        
        // Ajout JTextField
        pan.add(coordonneeBase); 

        pan.add(imageFondChoix); 

		coordonneeBase.setFocusable(true); 
        continuer.setEnabled(false);
        recommencer.setEnabled(false);

		// Ajout de l'ecouteur au bouton continuer
        EcouteurBoutonContinuer ecouteurContinuer = new EcouteurBoutonContinuer();
        continuer.addActionListener(ecouteurContinuer);

        EcouteurBoutonValider ecouteurValider = new EcouteurBoutonValider();
        valider.addActionListener(ecouteurValider);
        
        EcouteurBoutonRecommencer ecouteurRecommencer = new EcouteurBoutonRecommencer();
        recommencer.addActionListener(ecouteurRecommencer);
   
        SwingUtilities.invokeLater(new Runnable()
        {
           @Override
           public void run() {
              coordonneeBase.requestFocus();	// obligation de le mettre comme ca si on veut le mettre avant le setVisible :  									
			}
         
        });
        pan.setVisible(true);      
	}

	class EcouteurBoutonContinuer implements ActionListener {
		public void actionPerformed (ActionEvent clic){
			Ordinateur();	// Ouvre la nouvelle fenetre contenue dans la classe fenetreJeu2
			pan.dispose();	// Ferme la fenetre qui est ouverte
		}
	}

	class EcouteurBoutonRecommencer implements ActionListener{
		public void actionPerformed (ActionEvent clic){
		
			int x = choixBateau.getSelectedIndex();
			Object source = choixBateau.getSelectedItem();
		
			int reponseRecommencer1 = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment replacer tous vos bateaux?");
		
			if (reponseRecommencer1 == 0){
				for (int s = 0; s<mesCases.length; s++){
					for (int t = 0; t<mesCases[0].length;t++){
						mesCases[s][t].setBackground(Color.BLUE);
					}
				}
		
				if (source == "Cuirass\u00e9 (4 cases)"){
					for (int u = 0; u<5; u++){
						tab1[u] = 0; // On ne reinitialise pas le deuxieme tableau vu qu'il n'y a pas encore eu de placement
					}
					choixBateau.removeItemAt(x);
					choixBateau.addItem("Porte-Avion (5 cases)");
				}
		
				else if (source == "Contre-Torpilleur (3 cases)"){
					for (int u = 0; u<5; u++){
						tab1[u] = 0;
					}
					for (int v = 0; v<4; v++){
						tab2[v] = 0;
					}
				choixBateau.removeItemAt(x);
				choixBateau.addItem("Porte-Avion (5 cases)");
				}
		
				else if (source == "Sous-Marin (3 cases)"){
					for (int u = 0; u<5; u++){
						tab1[u] = 0;
					}
					for (int v = 0; v<4; v++){
						tab2[v] = 0;
					}
					for (int w = 0; w<3; w++){
						tab3[w] = 0;
					}
				choixBateau.removeItemAt(x);
				choixBateau.addItem("Porte-Avion (5 cases)");
				}
		
				else  if (source == "Avion de chasse (2 cases)"){
					for (int u = 0; u<5; u++){
						tab1[u] = 0;
					}
					for (int v = 0; v<4; v++){
						tab2[v] = 0;
					}
					for (int w = 0; w<3; w++){
						tab3[w] = 0;
					}
					for (int y = 0; y<3; y++){
						tab4[y] = 0;
					}
				choixBateau.removeItemAt(x);
				choixBateau.addItem("Porte-Avion (5 cases)");
				}
		
				if (source == ""){
					for (int u = 0; u<5; u++){
						tab1[u] = 0;
					}
					for (int v = 0; v<4; v++){
						tab2[v] = 0;
					}
					for (int w = 0; w<3; w++){
						tab3[w] = 0;
					}
					for (int y = 0; y<3; y++){
						tab4[y] = 0;
					}
					for (int z = 0; z<2; z++){
						tab5[z] = 0;
					}
					choixBateau.removeItemAt(x);
					choixBateau.addItem("Porte-Avion (5 cases)");
					valider.setEnabled(true);
					continuer.setEnabled(false);
				}
			}
			
			coordonneeBase.requestFocus();
		}
	}

	class EcouteurBoutonValider implements ActionListener { //permet de gerer la coordonnée rentrée
		public void actionPerformed (ActionEvent e){
	
			Object source = choixBateau.getSelectedItem(); 																		
			Object source2 = choixPlacement.getSelectedItem(); // Methode getSelectedItem(); trouvee ici : https://openclassrooms.com/courses/apprenez-a-programmer-en-java/les-champs-de-formulaire
			int x = choixBateau.getSelectedIndex();	// Methode getSelectedIndex(); trouvee ici : https://openclassrooms.com/forum/sujet/suppression-d-un-element-dans-une-jcombobox-88878
			int ver = 0;	// Corrsepond aux lettres
			int hor = 0;	// Correspond aux chiffres
			int chh2 = 0;	// S'il y a 3 caracteres (A10 par exemple), cela sert a avoir le troisieme caractere
			int chv = 0;	// Premier caractere (la lettre)
			int chh1 = 0;	// Deuxieme caractere (le chiffre)
			String ch = coordonneeBase.getText();	// Coordonnee entree par le joueur
			int n = ch.length();	// Permet de definir la longeur de la coordonnee entree par le joueur
		
			coordonneeBase.setText("");
		
			if (n < 2){	// S'il y a moins de 2 caracteres, il y a une erreur comme quoi c'est trop petit
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide (vous n'avez pas entr\u00e9 assez de caract\u00e8res)", "Erreur", JOptionPane.ERROR_MESSAGE);
				coordonneeBase.requestFocus();
			}
			else if (n > 3){
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide (vous avez entr\u00e9 trop de caract\u00e8res)", "Erreur", JOptionPane.ERROR_MESSAGE);
				coordonneeBase.requestFocus();
			}
				
			else{
				chv = ch.charAt(0);	// Permet d'aller chercher le premier caractere entre par la personne
				chh1 = ch.charAt(1)-48;	// On met -48 sinon le chiffre ne s'affiche pas coorectement
				if (chh1<1){
					JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
					coordonneeBase.requestFocus();
				}
				
				else{
					hor = chh1;	// Hor est la variable pour savoir si c'est 1 ou 2, il permet de definir le chiffre/nombre
					if (n==3){	// S'il y a 3 caracteres
						chh2 = ch.charAt(2)-48;	// Va chercher le trosieme caractere
						hor = chh1*10 + chh2;	// On met chh1*10 car le premier chiffre sera 1 et le deuxieme 0, donc cela sera 10+0 donc 10, et si c'est plus que 10, voir if en dessous
							if (hor>10){	// Si l'utilisateur entre un nombre plus grand que 10
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide", "Erreur", JOptionPane.ERROR_MESSAGE);
								coordonneeBase.requestFocus();
							}
					}
		
					hor = hor-1;		// Les coordonnees du tableau vont de 0 a 9, donc il faut mettre -1
					ver = configurationVerticale(chv);
		
		
					if (source == "Porte-Avion (5 cases)"){	// Si l'utilisateur choisit porte-avion
		
						if (source2 == "Horizontal"){	// Si l'utilisateur choisit horizontal
				
							if (ver>9 | hor>5){	// Si l'utilisateur entre une lettre plus "grande" que J ou j, message d'erreur // Si l'utilisateur entre une coordonnee plus grande que 6 (on met 5 car le tableau commence a 0)
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
					
							else {		
								mesCases[hor][ver].setBackground(Color.BLACK);
								mesCases[hor+1][ver].setBackground(Color.BLACK);
								mesCases[hor+2][ver].setBackground(Color.BLACK);
								mesCases[hor+3][ver].setBackground(Color.BLACK);
								mesCases[hor+4][ver].setBackground(Color.BLACK);
								choixBateau.removeItemAt(x);
								choixBateau.addItem("Cuirass\u00e9 (4 cases)");
								int nbreMax = 5;
								hord = (double) hor;
								verd = (double) ver;
								tab1 = new double [nbreMax];
								tab1[0] = hord+verd/10;
								tab1[1] = hord+1+(verd/10);
								tab1[2] = hord+2+(verd/10);
								tab1[3] = hord+3+(verd/10);
								tab1[4] = hord+4+(verd/10);
						
								placement1 = 1;
						
								coo1 = hor;
								coo2 = ver;
						
								recommencer.setEnabled(true);
							}
						}
			
						else if (source2 == "Vertical"){
							if (ver>5){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=5){
								mesCases[hor][ver].setBackground(Color.BLACK);
								mesCases[hor][ver+1].setBackground(Color.BLACK);
								mesCases[hor][ver+2].setBackground(Color.BLACK);
								mesCases[hor][ver+3].setBackground(Color.BLACK);
								mesCases[hor][ver+4].setBackground(Color.BLACK);
								choixBateau.removeItemAt(x);
								choixBateau.addItem("Cuirass\u00e9 (4 cases)");
								int nbreMax = 5;
								hord = (double) hor;
								verd = (double) ver;
								tab1 = new double [nbreMax];
								tab1[0] = hord+(verd/10);
								tab1[1] = hord+((verd+1)/10);
								tab1[2] = hord+((verd+2)/10);
								tab1[3] = hord+((verd+3)/10);
								tab1[4] = hord+((verd+4)/10);
								
								placement1 = 2;
								
								coo1 = hor;
								coo2 = ver;
								
								recommencer.setEnabled(true);
							
							}
						}
					}
			
					if (source == "Cuirass\u00e9 (4 cases)"){
				
						if (source2 == "Horizontal"){
							if (ver>9 | hor>6){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
					
							else{
								int nbreMax = 4;
								hord = (double) hor;
								verd = (double) ver;
								tab2 = new double [nbreMax];
								tab2[0] = hord+verd/10;
								tab2[1] = hord+1+(verd/10);					
								tab2[2] = hord+2+(verd/10);
								tab2[3] = hord+3+(verd/10);

								testPlacementBateaux1();
							
								if (erreur == 2){
									mesCases[hor][ver].setBackground(Color.CYAN);
									mesCases[hor+1][ver].setBackground(Color.CYAN);
									mesCases[hor+2][ver].setBackground(Color.CYAN);
									mesCases[hor+3][ver].setBackground(Color.CYAN);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Contre-Torpilleur (3 cases)");
						
									placement2 = 1;
						
									coo3 = hor;
									coo4 = ver;
			
								}
							}
						}
			
						else if (source2 == "Vertical"){
							if (ver>6){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=6){
										
								int nbreMax = 4;
								hord = (double) hor;
								verd = (double) ver;
								tab2 = new double [nbreMax];
								tab2[0] = hord+(verd/10);
								tab2[1] = hord+((verd+1)/10);
								tab2[2] = hord+((verd+2)/10);
								tab2[3] = hord+((verd+3)/10);

								testPlacementBateaux1();
								
								if (erreur == 2){
								
									mesCases[hor][ver].setBackground(Color.CYAN);
									mesCases[hor][ver+1].setBackground(Color.CYAN);
									mesCases[hor][ver+2].setBackground(Color.CYAN);
									mesCases[hor][ver+3].setBackground(Color.CYAN);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Contre-Torpilleur (3 cases)");
								
									placement2 = 2;
								
									coo3 = hor;
									coo4 = ver;	
								}		
									
							}
						}
		
					}
			
					if (source == "Contre-Torpilleur (3 cases)"){
					
						if (source2 == "Horizontal"){
						
							if (ver>9 | hor>7){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else{
								int nbreMax = 3;
								hord = (double) hor;
								verd = (double) ver;
								tab3 = new double [nbreMax];
								tab3[0] = hord+verd/10;
								tab3[1] = hord+1+(verd/10);
								tab3[2] = hord+2+(verd/10);

								testPlacementBateaux2();
							
								if (erreur == 2){
							
									mesCases[hor][ver].setBackground(Color.YELLOW);
									mesCases[hor+1][ver].setBackground(Color.YELLOW);
									mesCases[hor+2][ver].setBackground(Color.YELLOW);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Sous-Marin (3 cases)");
					
									placement3 = 1;
					
									coo5 = hor;
									coo6 = ver;
					
								}
				
							}
						}
						
						else if (source2 == "Vertical"){
							if (ver>7){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=7){
									
								int nbreMax = 3;
								hord = (double) hor;
								verd = (double) ver;
								tab3 = new double [nbreMax];
								tab3[0] = hord+(verd/10);
								tab3[1] = hord+((verd+1)/10);
								tab3[2] = hord+((verd+2)/10);

								testPlacementBateaux2();
				
								if (erreur == 2){
								
									mesCases[hor][ver].setBackground(Color.YELLOW);
									mesCases[hor][ver+1].setBackground(Color.YELLOW);
									mesCases[hor][ver+2].setBackground(Color.YELLOW);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Sous-Marin (3 cases)");
							
									placement3 = 2;
								
									coo5 = hor;
									coo6 = ver;
								}
							}
						}
					}
					if (source == "Sous-Marin (3 cases)"){
				
						if (source2 == "Horizontal"){
						
							if (ver>9 | hor>7){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else{
						
								int nbreMax = 3;
								hord = (double) hor;
								verd = (double) ver;
								tab4 = new double [nbreMax];
								tab4[0] = hord+verd/10;
								tab4[1] = hord+1+(verd/10);
								tab4[2] = hord+2+(verd/10);

								testPlacementBateaux3();
						
								if (erreur == 2){
						
									mesCases[hor][ver].setBackground(Color.GREEN);
									mesCases[hor+1][ver].setBackground(Color.GREEN);
									mesCases[hor+2][ver].setBackground(Color.GREEN);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Avion de chasse (2 cases)");
				
									placement4 = 1;
				
									coo7 = hor;
									coo8 = ver;
				
				
								}
							}
						}
						else if (source2 == "Vertical"){
							if (ver>7){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=7){
								
								int nbreMax = 3;
								hord = (double) hor;
								verd = (double) ver;
								tab4 = new double [nbreMax];
								tab4[0] = hord+(verd/10);
								tab4[1] = hord+((verd+1)/10);
								tab4[2] = hord+((verd+2)/10);

								testPlacementBateaux3();
							
								if (erreur == 2){
									
									mesCases[hor][ver].setBackground(Color.GREEN);
									mesCases[hor][ver+1].setBackground(Color.GREEN);
									mesCases[hor][ver+2].setBackground(Color.GREEN);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Avion de chasse (2 cases)");
									
									placement4 = 2;
									
									coo7 = hor;
									coo8 = ver;
									
								}			
							}
						}
					}
					if (source == "Avion de chasse (2 cases)"){
						
						if (source2 == "Horizontal"){
							
							if (ver>9 | hor>8){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else{
							
								int nbreMax = 2;
								hord = (double) hor;
								verd = (double) ver;
								tab5 = new double [nbreMax];
								tab5[0] = hord+verd/10;
								tab5[1] = hord+1+(verd/10);

								testPlacementBateaux4();

								if (erreur == 2){
							
									mesCases[hor][ver].setBackground(Color.DARK_GRAY);
									mesCases[hor+1][ver].setBackground(Color.DARK_GRAY);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("");
					
									placement5 = 1;
					
									coo9 = hor;
									coo10 = ver;
					
									continuer.setEnabled(true);
									valider.setEnabled(false);
								}
				
							}
						}
						else if (source2 == "Vertical"){
							if (ver>8){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonn\u00e9e valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=8){
									
								tab5 = new double [2];
								hord = (double) hor;
								verd = (double) ver;
								tab5[0] = hord+(verd/10);
								tab5[1] = hord+((verd+1)/10);

								testPlacementBateaux4();
				
								if (erreur == 2){
								
									mesCases[hor][ver].setBackground(Color.DARK_GRAY);
									mesCases[hor][ver+1].setBackground(Color.DARK_GRAY);
									choixBateau.removeItemAt(x);
									choixBateau.addItem(""); // On ajoute ça pour pouvoir recommencer avec le dernier bateau
									
									placement5 = 2;
									
									coo9 = hor;
									coo10 = ver;
									
									continuer.setEnabled(true);
									valider.setEnabled(false);
								}
							}
						}
					}
				}
			}	
			coordonneeBase.requestFocus();
		}
	}
	
    void Ordinateur(){
		pan2.setSize(400, 100);
		pan2.setTitle("Ordinateur");
		pan2.setLocationRelativeTo(null);
		pan2.setUndecorated(true);
		pan2.setContentPane(pan3);
		pan2.setLayout(null);	// Permet de placer les composants où l'on veut dans la fenetre
		pan2.setIconImage(icone);
		pan2.setBackground(new Color(0,0,0,0));

		JLabel imageBataille = new JLabel(new ImageIcon("images/fond/choixBataille.gif"));
		imageBataille.setBounds(0,0,400,100);
		
		// Informations label titre
		labelSousTitre = new JLabel("L'ordinateur choisit sa composition");
		labelSousTitre.setFont(sousTitre);
		labelSousTitre.setLocation(65,10);
		labelSousTitre.setSize(700, 50);
		
		// Informations bouton continuer
		continuer = new JButton("Ok");
		continuer.setLocation(120, 55);
		continuer.setSize(155,25);
		continuer.setEnabled(false);
		
		pan2.add(labelSousTitre);
		pan2.add(continuer);
		pan2.add(imageBataille);
		
		EcouteurBoutonCommencer ecouteurCommencer = new EcouteurBoutonCommencer();
		continuer.addActionListener(ecouteurCommencer);
			
		pan2.setVisible(true);
		
		continuer.setEnabled(true);	
	}
	
	class EcouteurBoutonCommencer implements ActionListener{
		public void actionPerformed (ActionEvent clic){
			pan3.setVisible(false);
		
			tirJoueur();
			pan2.dispose();

			pan4.setContentPane(pan5);	
		}
	}

	void positionBataille()
	{
	
		if(tirageAleatoire == 0){
			nombreAleatoire = (int) (Math.random() * 10);     //Pour un entier entre 0 et 6
			tirageAleatoire = 1;	
		}
		System.out.println(nombreAleatoire);

		tab6 = new double [5];
		tab7 = new double [4];
		tab8 = new double [4];
		tab9 = new double [3];
		tab10 = new double [2];
		
		if (nombreAleatoire == 0){  //-----------------A5--------------------------
			//porte avion
			hor = 0;
			ver = 0;
			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=4; i++){ 
				tab6[i] = hord+i+(verd/10);
			}

			placement6 = 1;
			coo11 = hor;
			coo12 = ver;

			//cuirassé
			hor = 9;
			ver = 3;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=3; i++){
				tab7[i] = hord+((verd+i)/10);
			}

			placement7 = 2;
			coo13 = hor;
			coo14 = ver;

			//Contre-torpilleur
			hor = 3;
			ver = 7;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=2; i++){
				tab8[i] = hord+((verd+i)/10);
			}
			
			placement8 = 2;
			coo15 = hor;
			coo16 = ver;

			//sous marin
			hor = 7;
			ver = 6;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=2; i++){
				tab9[i] = hord+((verd+i)/10);
			}
			
			placement9 = 2;
			coo17 = hor;
			coo18 = ver;

			//avion chasse
			hor = 1;
			ver = 7;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=1; i++){
				tab10[i] = hord+((verd+i)/10);
			}
			
			placement10 = 2;
			coo19 = hor;
			coo20= ver;

		}
		else if (nombreAleatoire == 1){ //------------------------A9-----------------------------
			//porte avion
			hor = 5;
			ver = 3;
			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=4; i++){ 
			tab6[i] = hord+((verd+i)/10);
			}

			placement6 = 2;
			coo11 = hor;
			coo12 = ver;

			//cuirassé
			hor = 7;
			ver = 1;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=3; i++){
			tab7[i] = hord+((verd+i)/10);
			}

			placement7 = 2;
			coo13 = hor;
			coo14 = ver;

			//Contre-torpilleur
			hor = 7;
			ver = 8;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=2; i++){
			tab8[i] = hord+i+((verd)/10);
			}
			placement8 = 1;
			coo15 = hor;
			coo16 = ver;

			//sous marin
			hor = 1;
			ver = 5;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=2; i++){
			tab9[i] = hord+((verd+i)/10);
			}
			placement9 = 2;
			coo17 = hor;
			coo18 = ver;

			//avion chasse
			hor = 2;
			ver = 8;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=1; i++){
			tab10[i] = hord+((verd+i)/10);
			}
			placement10 = 2;
			coo19 = hor;
			coo20= ver;
		}
		else if (nombreAleatoire == 2){ 	//------------------------c5-----------------------------
			//porte avion
			hor = 1;
			ver = 2;
			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=4; i++){ 
			tab6[i] = hord+i+(verd/10);
			}

			placement6 = 1;
			coo11 = hor;
			coo12 = ver;

			//cuirassé
			hor = 8;
			ver = 2;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=3; i++){
			tab7[i] = hord+((verd+i)/10);
			}

			placement7 = 2;
			coo13 = hor;
			coo14 = ver;

			//Contre-torpilleur
			hor = 3;
			ver = 7;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=2; i++){
			tab8[i] = hord+i+((verd)/10);
			}
			placement8 = 1;
			coo15 = hor;
			coo16 = ver;

			//sous marin
			hor = 0;
			ver = 3;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=2; i++){
			tab9[i] = hord+((verd+i)/10);
			}
			placement9 = 2;
			coo17 = hor;
			coo18 = ver;

			//avion chasse
			hor = 7;
			ver = 8;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=1; i++){
			tab10[i] = hord+i+((verd)/10);
			}
			placement10 = 1;
			coo19 = hor;
			coo20= ver;
		}
		else if(nombreAleatoire == 3){ //------------------------d2-----------------------------	
			hor = 2;
			ver = 8;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=4; i++){ 
			tab6[i] = hord+i+(verd/10);
			}
			placement6 = 1;
			coo11 = hor;
			coo12 = ver;

			hor = 1;
			ver = 6;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=3; i++){
			tab7[i] = hord+i+((verd)/10);
			}
			placement7 = 1;
			coo13 = hor;
			coo14 = ver;

			hor = 9;
			ver = 5;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
			tab8[i] = hord+((verd+i)/10);
			}
			placement8 = 2;
			coo15 = hor;
			coo16 = ver;

			hor = 7;
			ver = 5;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
			tab9[i] = hord+((verd+i)/10);
			}
			placement9 = 2;
			coo17 = hor;
			coo18 = ver;

			hor = 2;
			ver = 3;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=1; i++){
			tab10[i] = hord+((verd+i)/10);
			}
			placement10 = 2;
			coo19 = hor;
			coo20= ver;
			}
		
		else if(nombreAleatoire == 4){ //------------------------d5-----------------------------	
			hor = 6;
			ver = 1;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=4; i++){ 
			tab6[i] = hord+((verd+i)/10);
			}
			placement6 = 2;
			coo11 = hor;
			coo12 = ver;

			hor = 8;
			ver = 4;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=3; i++){
			tab7[i] = hord+((verd+i)/10);
			}
			placement7 = 2;
			coo13 = hor;
			coo14 = ver;

			hor = 4;
			ver = 6;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
			tab8[i] = hord+((verd+i)/10);
			}
			placement8 = 2;
			coo15 = hor;
			coo16 = ver;

			hor = 2;
			ver = 4;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
			tab9[i] = hord+((verd+i)/10);
			}
			placement9 = 2;
			coo17 = hor;
			coo18 = ver;

			hor = 9;
			ver = 2;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=1; i++){
			tab10[i] = hord+((verd+i)/10);
			}
			placement10 = 2;
			coo19 = hor;
			coo20= ver;
		}
			
		else if(nombreAleatoire == 5){ //------------------------c10-----------------------------
			hor = 1;
			ver = 3;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=4; i++){ 
			tab6[i] = hord+((verd+i)/10);
			}
			placement6 = 2;
			coo11 = hor;
			coo12 = ver;

			hor = 4;
			ver = 2;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=3; i++){
			tab7[i] = hord+((verd+i)/10);
			}
			placement7 = 2;
			coo13 = hor;
			coo14 = ver;

			hor = 8;
			ver = 3;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
			tab8[i] = hord+((verd+i)/10);
			}
			placement8 = 2;
			coo15 = hor;
			coo16 = ver;

			hor = 5;
			ver = 6;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
			tab9[i] = hord+((verd+i)/10);
			}
			placement9 = 2;
			coo17 = hor;
			coo18 = ver;

			hor = 2;
			ver = 8;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=1; i++){
			tab10[i] = hord+((verd+i)/10);
			}
			placement10 = 2;
			coo19 = hor;
			coo20= ver;
		}

		if (nombreAleatoire == 6){ //------------------------E10-----------------------------
			hor = 5;
			ver = 8;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=4; i++){ 
				tab6[i] = hord+i+(verd/10);
			}
			placement6 = 1;
			coo11 = hor;
			coo12 = ver;

			hor = 3;
			ver = 6;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=3; i++){
				tab7[i] = hord+i+((verd)/10);
			}
			placement7 = 1;
			coo13 = hor;
			coo14 = ver;

			hor = 3;
			ver = 2;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
				tab8[i] = hord+((verd+i)/10);
			}		
			placement8 = 2;
			coo15 = hor;
			coo16 = ver;

			hor = 4;
			ver = 3;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
				tab9[i] = hord+i+((verd)/10);
			}		
			placement9 = 1;
			coo17 = hor;
			coo18 = ver;

			hor = 1;
			ver = 4;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=1; i++){
				tab10[i] = hord+((verd+i)/10);
			}	
			placement10 = 2;
			coo19 = hor;
			coo20= ver;
		}

		if (nombreAleatoire == 7){ //------------------------G6-----------------------------
			hor = 5;
			ver = 5;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=4; i++){ 
				tab6[i] = hord+((verd+i)/10);
			}
			placement6 = 2;
			coo11 = hor;
			coo12 = ver;

			hor = 7;
			ver = 6;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=3; i++){
				tab7[i] = hord+((verd+i)/10);
			}
			placement7 = 2;
			coo13 = hor;
			coo14 = ver;

			hor = 6;
			ver = 4;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
				tab8[i] = hord+((verd+i)/10);
			}	
			placement8 = 2;
			coo15 = hor;
			coo16 = ver;

			hor = 8;
			ver = 4;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
				tab9[i] = hord+((verd+i)/10);
			}	
			placement9 = 2;
			coo17 = hor;
			coo18 = ver;

			hor = 4;
			ver = 3;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=1; i++){
				tab10[i] = hord+((verd+i)/10);
			}	
			placement10 = 2;
			coo19 = hor;
			coo20= ver;

		}

		if (nombreAleatoire == 8){ //------------------------H6-----------------------------
			hor = 3;
			ver = 1;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=4; i++){ 
				tab6[i] = hord+i+((verd)/10);
			}
			placement6 = 1;
			coo11 = hor;
			coo12 = ver;

			hor = 3;
			ver = 9;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=3; i++){
				tab7[i] = hord+((verd+i)/10);
			}
			placement7 = 2;
			coo13 = hor;
			coo14 = ver;

			hor = 6;
			ver = 6;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
				tab8[i] = hord+((verd+i)/10);
			}
			placement8 = 2;
			coo15 = hor;
			coo16 = ver;

			hor = 1;
			ver = 7;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=2; i++){
				tab9[i] = hord+((verd+i)/10);
			}	
			placement9 = 2;
			coo17 = hor;
			coo18 = ver;

			hor = 2;
			ver = 5;
			hord = (double) hor;
			verd = (double) ver;
			for(int i =0; i<=1; i++){
				tab10[i] = hord+((verd+i)/10);
			}	
			placement10 = 2;
			coo19 = hor;
			coo20= ver;
		}

		if (nombreAleatoire == 9){  //-----------------J1--------------------------
			//porte avion
			hor = 3;
			ver = 2;
			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=4; i++){ 
				tab6[i] = hord+i+(verd/10);
			}

			placement6 = 1;
			coo11 = hor;
			coo12 = ver;

			//cuirassé
			hor = 8;
			ver = 4;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=3; i++){
				tab7[i] = hord+((verd+i)/10);
			}

			placement7 = 2;
			coo13 = hor;
			coo14 = ver;

			//Contre-torpilleur
			hor = 6;
			ver = 6;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=2; i++){
				tab8[i] = hord+((verd+i)/10);
			}
			
			placement8 = 2;
			coo15 = hor;
			coo16 = ver;

			//sous marin
			hor = 1;
			ver = 7;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=2; i++){
				tab9[i] = hord+((verd+i)/10);
			}
			
			placement9 = 1;
			coo17 = hor;
			coo18 = ver;

			//avion chasse
			hor = 2;
			ver = 3;

			hord = (double) hor;
			verd = (double) ver;

			for(int i =0; i<=1; i++){
				tab10[i] = hord+((verd+i)/10);
			}
			
			placement10 = 2;
			coo19 = hor;
			coo20= ver;

		}

	}

	void testPlacementBateaux1(){
		toto = 0;
		
		// Test porte-avion
		for(int i=0; i<=4; i++){
			for(int j=0; j<=3; j++){
				if (tab1[i] == tab2[j]){
					toto++;
				}
			}
		}
		if (toto >= 1){
			erreur = 1;
			JOptionPane.showMessageDialog(null, "Erreur, vous ne pouvez pas placer deux bateaux au m\u00eame endroit", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else{
			erreur = 2;
		}
	}
	
	void testPlacementBateaux2(){
		toto = 0;
	
	// Test avec le porte avion
		for(int i=0; i<=4; i++){
			for(int j=0; j<=2; j++){
				if (tab1[i] == tab3[j]){
					toto++;
				}
			}
		}
			
	//Test avec le Cuirasse
		for(int i=0; i<=3; i++){
			for(int j=0; j<=2; j++){
				if (tab2[i] == tab3[j]){
					toto++;
				}
			}
		}
			
		if (toto >= 1){
			erreur = 1;
			JOptionPane.showMessageDialog(null, "Erreur, vous ne pouvez pas placer deux bateaux au m\u00eame endroit", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else{
			erreur = 2;
		}
	}
	
	void testPlacementBateaux3(){
	
		toto = 0;
	
	// Test avec le porte avion
		for(int i=0; i<=4; i++){
			for(int j=0; j<=2; j++){
				if (tab1[i] == tab4[j]){
				toto++;
				}
			}
		}	
		
	// Test avec le Cuirasse	
		for(int i=0; i<=3; i++){
			for(int j=0; j<=2; j++){
				if (tab2[i] == tab4[j]){
				toto++;
				}
			}
		}
					
		//	Test avec le contre-torpilleur	
		for(int i=0; i<=2; i++){
			for(int j=0; j<=2; j++){
				if (tab3[i] == tab4[j]){
				toto++;
				}
			}
		}
				
		if (toto >= 1){
			erreur = 1;
			JOptionPane.showMessageDialog(null, "Erreur, vous ne pouvez pas placer deux bateaux au m\u00eame endroit", "Erreur", JOptionPane.ERROR_MESSAGE);}
			else{
				erreur = 2;
			}
		}
	
	void testPlacementBateaux4(){
	
		toto = 0;
	
		//Test avec le porte avion
		for(int i=0; i<=4; i++){
			for(int j=0; j<=1; j++){
				if (tab1[i] == tab5[j]){
				toto++;
				}
			}
		}		
			
		//Test avec le Cuirasse
		for(int i=0; i<=3; i++){
			for(int j=0; j<=1; j++){
				if (tab2[i] == tab5[j]){
				toto++;
				}
			}
		}
			
		//Test avec le contre-torpilleur
		for(int i=0; i<=2; i++){
			for(int j=0; j<=1; j++){
				if (tab3[i] == tab5[j]){
				toto++;}
				}}
			
		//Test avec le sous-marin
		for(int i=0; i<=2; i++){
			for(int j=0; j<=1; j++){
				if (tab4[i] == tab5[j]){
				toto++;
				}
			}
		}
				
		if (toto >= 1){
			erreur = 1;
			JOptionPane.showMessageDialog(null, "Erreur, vous ne pouvez pas placer deux bateaux au m\u00eame endroit", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else{
			erreur = 2;
		}
	}
	
	public Image iconToImage(Icon icona, String img)
	{
		BufferedImage buffImage;
		Image imaga;
		
		BufferedImage buffIcona = new BufferedImage(icona.getIconWidth(), icona.getIconHeight(), BufferedImage.TYPE_INT_RGB);
		icona.paintIcon(null, buffIcona.getGraphics(), 0, 0);
		
		buffImage = LectureImage(img);
		
		Graphics g = buffIcona.getGraphics();  
	
		g.drawImage(buffImage , 0, 0, null); 
	
		imaga = Toolkit.getDefaultToolkit().createImage(buffIcona.getSource());
		imaga = imaga.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
	
		return imaga;
	}
	
	BufferedImage LectureImage(String Filename)
	{
	
		BufferedImage buffImage;
  
		buffImage = null;
 	
		try {
			File file   = new File(Filename);  // Creation d'un objet File afin de lire le fichier dont le nom est Filename
			buffImage   = ImageIO.read(file);  // Le fichier file est interprete comme etant une image que l'on nomme image
        } 
       	catch (IOException e){
			System.out.println("Erreur de lecture:"+ e.toString() );	
		}
			
		return(buffImage);	
	}
	
	void tirJoueur(){
	
		pan4.setSize(1000, 580);
		pan4.setTitle("Tir");
		pan4.setLocationRelativeTo(null);
		pan4.setUndecorated(true);
		pan4.setContentPane(pan5);
		pan4.setLayout(null);	// Permet de placer les composants où l'on veut dans la fenetre
		pan4.setIconImage(icone);
		pan4.setBackground(new Color(0,0,0,0));
		
		JLabel imageTir = new JLabel(new ImageIcon("images/fond/fond.gif"));
		imageTir.setBounds(0,0,1000,580);
		
		
		int image = 101;
		for(i = 0; i < mesCases.length; i++ ) {
			for(j = 0; j < mesCases[0].length; j++ ) {
				image--;

				mesCases[i][j] = new JButton();
				mesCases[i][j].setSize(40,40);
				mesCases[i][j].setIcon(new ImageIcon("images/image40/tab1/"+image+".png"));
				mesCases[i][j].setLocation(50+40*i,80+40*j);
				mesCases[i][j].setName("" + i + j);
				pan5.add(mesCases[i][j]);
		   }
		
	   }
		
		if (placement1 == 1){
			for(int a = 1; a <=5; a++){
				IconButton = (mesCases[coo1+a-1][coo2]).getIcon();
				imageOpe = iconToImage(IconButton, "images/bateaux/porte/h/"+a+".png");
				mesCases[coo1+a-1][coo2].setIcon(new ImageIcon(imageOpe));				
				}
		}
		
		else if (placement1 == 2){
			for(int a = 1; a <=5; a++){
				IconButton =  (mesCases[coo1][coo2+a-1]).getIcon();
				imageOpe = iconToImage(IconButton, "images/bateaux/porte/v/"+a+".png");			
				mesCases[coo1][coo2+a-1].setIcon(new ImageIcon(imageOpe));				
			}
		}
		
		if (placement2 == 1){
			for(int a = 1; a <=4; a++){
				IconButton = (mesCases[coo3+a-1][coo4]).getIcon();
				imageOpe = iconToImage(IconButton, "images/bateaux/cuirasse/h/"+a+".png");
				mesCases[coo3+a-1][coo4].setIcon(new ImageIcon(imageOpe));			
			}
		}
			
		
		else if (placement2 == 2){
			for(int a = 1; a <=4; a++){
				IconButton = (mesCases[coo3][coo4+a-1]).getIcon();
				imageOpe = iconToImage(IconButton, "images/bateaux/cuirasse/v/"+a+".png");
				mesCases[coo3][coo4+a-1].setIcon(new ImageIcon(imageOpe));
			}
		}
		
		if (placement3 == 1){
			for(int a = 1; a <=3; a++){
					IconButton = (mesCases[coo5+a-1][coo6]).getIcon();
					imageOpe = iconToImage(IconButton, "images/bateaux/torpilleur/h/"+a+".png");
					mesCases[coo5+a-1][coo6].setIcon(new ImageIcon(imageOpe));
			}
		}
		
		else if (placement3 == 2){
			for(int a = 1; a <=3; a++){
				IconButton = (mesCases[coo5][coo6+a-1]).getIcon();
				imageOpe = iconToImage(IconButton, "images/bateaux/torpilleur/v/"+a+".png");
				mesCases[coo5][coo6+a-1].setIcon(new ImageIcon(imageOpe));
			}
		}
		
		if (placement4 == 1){
			for(int a = 1; a <=3; a++){
				IconButton = (mesCases[coo7+a-1][coo8]).getIcon();
				imageOpe = iconToImage(IconButton, "images/bateaux/torpilleur/h/"+a+".png");			
				mesCases[coo7+a-1][coo8].setIcon(new ImageIcon(imageOpe));
			}
		}
		
		if (placement4 == 2){
			for(int a = 1; a <=3; a++){
				IconButton = (mesCases[coo7][coo8+a-1]).getIcon();
				imageOpe = iconToImage(IconButton, "images/bateaux/torpilleur/v/"+a+".png");			
				mesCases[coo7][coo8+a-1].setIcon(new ImageIcon(imageOpe));
			}
		}
		
		if (placement5 == 1){
			for(int a = 1; a <=2; a++){
				IconButton = (mesCases[coo9+a-1][coo10]).getIcon();
				imageOpe = iconToImage(IconButton, "images/bateaux/avion/h/"+a+".png");			
				mesCases[coo9+a-1][coo10].setIcon(new ImageIcon(imageOpe));
				
			}
		}
		
		else if (placement5 == 2){
			for(int a = 1; a <=2; a++){
				IconButton = (mesCases[coo9][coo10+a-1]).getIcon();
				imageOpe = iconToImage(IconButton, "images/bateaux/avion/v/"+a+".png");			
				mesCases[coo9][coo10+a-1].setIcon(new ImageIcon(imageOpe));
			}
		}
		
		image =0;
		for( int k = 0; k < mesCases2.length; k++ ) {
			for( int l = 0; l < mesCases2[0].length; l++ ) {
				image ++;
				mesCases2[k][l] = new JButton();
				mesCases2[k][l].setSize(40,40);
				mesCases2[k][l].setIcon(new ImageIcon("images/image40/tab2/"+image+".png"));
				mesCases2[k][l].setLocation(540+40*k,80+40*l);
				mesCases2[k][l].setName("" + k + l);
				pan5.add(mesCases2[k][l]);
		   }
		 
	   }

 
		//GERE AFFICHAGE DES LETTRES ET CHIFFRES AU NIVEAU DES TABLEAUX DE JEU
		int cpt = 1;
		char cpt2 = 'A';
		char cpt3 = 'A';
		int cpt4 = 1;
	
		for(int k = 0; k < mesCoordonnees.length; k++){
			mesCoordonnees[k] = new JLabel(String.valueOf( cpt2++ ));
			mesCoordonnees[k].setSize(10,10);
			mesCoordonnees[k].setLocation(40, 87+40*k);
			pan5.add(mesCoordonnees[k]);	
		}
		
		for (int m = 0; m < mesCoordonneesH.length; m++){
			mesCoordonnees[m] = new JLabel(String.valueOf(cpt++));
			mesCoordonnees[m].setSize(14,10);
			mesCoordonnees[m].setLocation(57+40*m,68);
			pan5.add(mesCoordonnees[m]);
		}
	
		for(int k = 0; k < mesCoordonnees.length; k++){
			mesCoordonnees[k] = new JLabel(String.valueOf( cpt3++ ));
			mesCoordonnees[k].setSize(10,10);
			mesCoordonnees[k].setLocation(530, 87+40*k);
			pan5.add(mesCoordonnees[k]);
		}
		
		for (int l = 0; l < mesCoordonneesH.length; l++){
			mesCoordonnees[l] = new JLabel(String.valueOf(cpt4++));
			mesCoordonnees[l].setSize(14,10);
			mesCoordonnees[l].setLocation(547+40*l,68);
			pan5.add(mesCoordonnees[l]);
		}
		
		nomTirJ1 = new JLabel ("Capitaine " + nomJ.getText());
		nomTirJ1.setHorizontalAlignment(JLabel.CENTER);
		nomTirJ1.setLocation(0,10);
		nomTirJ1.setFont(cap);
		nomTirJ1.setSize(1000,25);
		
		votreGrille = new JLabel ("Grille de vos bateaux :");
		votreGrille.setLocation(50,40);
		votreGrille.setSize(150,30);
		
		grilleDeVosTirs = new JLabel ("Grille de vos tirs :");
		grilleDeVosTirs.setLocation(537,40);
		grilleDeVosTirs.setSize(140,30);		

		pan5.add(votreGrille);
		pan5.add(grilleDeVosTirs);
		pan5.add(nomTirJ1);
		pan5.add(imageTir);
		
		
			EcouteurBoutonTir ecouteurTir = new EcouteurBoutonTir();
				for(i = 0; i < mesCases.length; i++ ) {
					for(j = 0; j < mesCases[0].length; j++ ) {
						mesCases2[i][j].addActionListener(ecouteurTir);
					}
				}
		
		pan4.setVisible(true);
		
		
		
	}
	
	class EcouteurBoutonTir implements ActionListener{
		public void actionPerformed (ActionEvent ev){
			
			if(tourAQui == 1){
				
				tourAQui = 0;
				positionBataille();
				String name = ((JButton) ev.getSource()).getName();
			
				a = name.charAt(0)-48;
				b = name.charAt(1)-48;
			
				int nbreMax = 1;
				tab11 = new double [nbreMax];
				hord = a;
				verd = b;
				tab11[0] = hord+(verd/10);		// Faire la conversion (-48)
				double Tir = hord + (verd/10);
				int TestTir = 0;
				
				tabTir1[compteurTirJ] = Tir;	// un compteur est initialise a 0, donc a chaque passage (le compteur augmente), le tir du moment est enregistre dans une autre cellule
				if (compteurTirJ != 0){	// Si le compteur de tir n'est pas egal a 0, alors il passe dans la boucle
						
					for (int i = 0; i < compteurTirJ; i++){
						if (tabTir1[i] == Tir){
							TestTir = 1;
						}
					}
				}
				
				if (TestTir == 1){
					JOptionPane.showMessageDialog(null, "Erreur, coordonnee deja utilisee", "Erreur", JOptionPane.ERROR_MESSAGE);	
					tourAQui = 1;
				}
				
				else{
					compteurTirJ = compteurTirJ + 1;	// Le compteur augment de 1 a chaque passage
					t1 = System.currentTimeMillis();
				
					if (tab11[0] == tab6[0] | tab11[0] == tab6[1] | tab11[0] == tab6[2] | tab11[0] == tab6[3] | tab11[0] == tab6[4]){
						IconButton = (mesCases2[a][b]).getIcon();
						imageOpe = iconToImage(IconButton, "images/couleur/explosion.png");			
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe));
						Sound.playTempSound("son/bruitages/bomb.wav");
						compteur1 = compteur1 + 1;
						
						if (compteur1 == 5){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le porte-avion");
						}
					}																															
					else if (tab11[0] == tab7[0] | tab11[0] == tab7[1] | tab11[0] == tab7[2] | tab11[0] == tab7[3]){
						IconButton = (mesCases2[a][b]).getIcon();
						imageOpe = iconToImage(IconButton, "images/couleur/explosion.png");			
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe));
						Sound.playTempSound("son/bruitages/bomb.wav");
						compteur2 = compteur2 + 1;
					
						if (compteur2 == 4){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le Cuirasse");
						}
					}
					else if (tab11[0] == tab8[0] | tab11[0] == tab8[1] | tab11[0] == tab8[2]){
						IconButton = (mesCases2[a][b]).getIcon();
						imageOpe = iconToImage(IconButton, "images/couleur/explosion.png");			
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe));
						Sound.playTempSound("son/bruitages/bomb.wav");
						compteur3 = compteur3 + 1;
						
						if (compteur3 == 3){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le contre-torpilleur");
						}
					}
					else if (tab11[0] == tab9[0] | tab11[0] == tab9[1] | tab11[0] == tab9[2]){
						IconButton = (mesCases2[a][b]).getIcon();
						imageOpe = iconToImage(IconButton, "images/couleur/explosion.png");			
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe));
						Sound.playTempSound("son/bruitages/bomb.wav");	
						compteur4 = compteur4 + 1;
					
						if (compteur4 == 3){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le sous-marin");
						}
					}
					else if (tab11[0] == tab10[0] | tab11[0] == tab10[1]){
						IconButton = (mesCases2[a][b]).getIcon();
						imageOpe = iconToImage(IconButton, "images/couleur/explosion.png");			
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe));
						Sound.playTempSound("son/bruitages/bomb.wav");
						compteur5 = compteur5 + 1;
					
						if (compteur5 == 2){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule l'avion");
						}
					}
					else{
						IconButton = (mesCases2[a][b]).getIcon();
						imageOpe = iconToImage(IconButton, "images/couleur/croix.png");			
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe));
						Sound.playTempSound("son/bruitages/plouf.wav");
					}
				
					if (compteur1 == 5 & compteur2 == 4 & compteur3 == 3 & compteur4 == 3 & compteur5 == 2){
						try{
						fenetreFinale1();
						}
						catch(NullPointerException e){
						fenetreFinale1();
						}
					}
				tirOrdi();
				}
			}			
		}	
	}
	
	int testPos (int nbA, int nbB){
	
		int nbreMax = 1;
		testViable = 0;
		
		tab11 = new double [nbreMax];
		hord = nbA;
		verd = nbB;
		tab11[0] = hord+(verd/10);		// Faire la conversion (-48)
			
		double TirOrdi = hord + (verd/10);
		int TestTirOrdi = 0;
		
		tabTirOrdi[(compteurTirOrdi)] = TirOrdi;
		if (compteurTirOrdi != 0){
			for (int i = 0; i < compteurTirOrdi; i++){
				if (tabTirOrdi[i] == TirOrdi){
					TestTirOrdi = 1;
				}
				if ((tabTirOrdi[i] == (double)Math.round((TirOrdi+0.1) * 10) / 10) && ((TirOrdi != 0.9) && (TirOrdi != 1.9) && (TirOrdi != 2.9) && (TirOrdi != 3.9) && (TirOrdi != 4.9) && (TirOrdi != 5.9) && (TirOrdi != 6.9) && (TirOrdi != 7.9) && (TirOrdi != 8.9) && (TirOrdi != 9.9))){
					testViable++;
				}
				if ((tabTirOrdi[i] == (double)Math.round((TirOrdi-0.1) * 10) / 10) && ((TirOrdi != 0.0) && (TirOrdi != 1.0) && (TirOrdi != 2.0) && (TirOrdi != 3.0) && (TirOrdi != 4.0) && (TirOrdi != 5.0) && (TirOrdi != 6.0) && (TirOrdi != 7.0) && (TirOrdi != 8.0) && (TirOrdi != 9.0))){
					testViable++;
				}
				if ((tabTirOrdi[i] == (double)Math.round((TirOrdi+1) * 10) / 10) && ((TirOrdi != 9.0) && (TirOrdi != 9.1) && (TirOrdi != 9.2) && (TirOrdi != 9.3) && (TirOrdi != 9.4) && (TirOrdi != 9.5) && (TirOrdi != 9.6) && (TirOrdi != 9.7) && (TirOrdi != 9.8) && (TirOrdi != 9.9))){
					testViable++;
				}
				if ((tabTirOrdi[i] == (double)Math.round((TirOrdi-1) * 10) / 10) && ((TirOrdi != 0.0) && (TirOrdi != 0.1) && (TirOrdi != 0.2) && (TirOrdi != 0.3) && (TirOrdi != 0.4) && (TirOrdi != 0.5) && (TirOrdi != 0.6) && (TirOrdi != 0.7) && (TirOrdi != 0.8) && (TirOrdi != 0.9))){
					testViable++;
				}
			}
		}
			
		if (TestTirOrdi == 1){
		}
		return (TestTirOrdi);
	}
			
	void bonPlacement(){
	
		choixDirection = (int) (Math.random() *4 ); // 0-> droite, 1-> haut, 2->gauche, 3->bas
		
		if(tabTirOrdi[compteurTirOrdi]== 0.0){	
			while((choixDirection == 1) | (choixDirection == 2)){  //pour ne pas tirer hors du plateau
				choixDirection = (int) (Math.random() *4 );
			}
			positionDeLaCase = 1;
		}
		else if (tabTirOrdi[compteurTirOrdi]== 9.0){
			while((choixDirection == 0) | (choixDirection == 1)){
				choixDirection = (int) (Math.random() *4 );
			}
			positionDeLaCase = 1;
		}
		else if (tabTirOrdi[compteurTirOrdi]== 0.9){
			while((choixDirection == 2) | (choixDirection == 3)){
				choixDirection = (int) (Math.random() *4 );
			}
			positionDeLaCase = 1;
		}
		else if (tabTirOrdi[compteurTirOrdi]== 9.9){
			while((choixDirection == 0) | (choixDirection == 3)){
				choixDirection = (int) (Math.random() *4 );
			}
			positionDeLaCase = 1;
		}
		else if((tabTirOrdi[compteurTirOrdi]== 0.1) | (tabTirOrdi[compteurTirOrdi]== 0.2) | (tabTirOrdi[compteurTirOrdi]== 0.3) | (tabTirOrdi[compteurTirOrdi]== 0.4) | (tabTirOrdi[compteurTirOrdi]== 0.5) | (tabTirOrdi[compteurTirOrdi]== 0.6) | (tabTirOrdi[compteurTirOrdi]== 0.7) | (tabTirOrdi[compteurTirOrdi]== 0.8)){
			while(choixDirection == 2){
				choixDirection = (int) (Math.random() *4 );
			}
			positionDeLaCase = 2;
		}
		else if((tabTirOrdi[compteurTirOrdi]== 1.0) | (tabTirOrdi[compteurTirOrdi]== 2.0) | (tabTirOrdi[compteurTirOrdi]== 3.0) | (tabTirOrdi[compteurTirOrdi]== 4.0) | (tabTirOrdi[compteurTirOrdi]== 5.0) | (tabTirOrdi[compteurTirOrdi]== 6.0) | (tabTirOrdi[compteurTirOrdi]== 7.0) | (tabTirOrdi[compteurTirOrdi]== 8.0)){
			while(choixDirection == 1){
				choixDirection = (int) (Math.random() *4 );
			}
			positionDeLaCase = 2;
		}
		else if((tabTirOrdi[compteurTirOrdi]== 9.1) | (tabTirOrdi[compteurTirOrdi]== 9.2) | (tabTirOrdi[compteurTirOrdi]== 9.3) | (tabTirOrdi[compteurTirOrdi]== 9.4) | (tabTirOrdi[compteurTirOrdi]== 9.5) | (tabTirOrdi[compteurTirOrdi]== 9.6) | (tabTirOrdi[compteurTirOrdi]== 9.7) | (tabTirOrdi[compteurTirOrdi]== 9.8)){
			while(choixDirection == 0){
				choixDirection = (int) (Math.random() *4 );
			}
			positionDeLaCase = 2;
			}
		else if(tabTirOrdi[compteurTirOrdi]== 1.9 | tabTirOrdi[compteurTirOrdi]== 2.9 | tabTirOrdi[compteurTirOrdi]== 3.9 | tabTirOrdi[compteurTirOrdi]== 4.9 | tabTirOrdi[compteurTirOrdi]== 5.9 | tabTirOrdi[compteurTirOrdi]== 6.9 | tabTirOrdi[compteurTirOrdi]== 7.9 | tabTirOrdi[compteurTirOrdi]== 8.9){
			while(choixDirection == 3){
				choixDirection = (int) (Math.random() *4 );
			}
			positionDeLaCase = 2;
		}
		else{
			choixDirection = (int) (Math.random() *4 );
		}	
	}
	
	void direction(int choixDirection){
	
		if(choixDirection == 0){
			direction0 = 1;
		}
		else if(choixDirection == 1){
			direction1 = 1;
		}
		else if(choixDirection == 2){
			direction2 = 1;
		}
		else if(choixDirection == 3){
			direction3 = 1;
		}
		
		directionTot = direction0 + direction1 + direction2 + direction3;
	}
	
	void tirOrdi(){

		AutoriseTir = 0;
		
		if(aucunePiste==0){
					
			if(testMemoire==0) { //on vient de toucher une case rouge
			
				
				bonPlacement();
				
				if((compteur6>=2 && bateauActuel ==1) | (compteur7>=2 && bateauActuel == 2) | (compteur8>=2 && bateauActuel == 3) | (compteur9>=2 && bateauActuel == 4)){
					if ((placement1 == 1 && bateauActuel ==1) | (placement2 == 1 && bateauActuel ==2) | (placement3 == 1 && bateauActuel ==3) | (placement4 == 1 && bateauActuel ==4)){
						while((choixDirection == 1) | (choixDirection == 3)){
							bonPlacement();
						}
					}
					else if ((placement1 == 2 && bateauActuel ==1) | (placement2 == 2 && bateauActuel ==2) | (placement3 == 2 && bateauActuel ==3) | (placement4 == 2 && bateauActuel ==4)){
						while((choixDirection == 2) | (choixDirection == 0)){
							bonPlacement();
						}
					}
				}
					
				int nbANew = 0, nbBNew = 0;
				
				if(choixDirection == 0){
					nbANew = nbA + 1;
					nbBNew = nbB;
				}
				else if(choixDirection == 1){
					nbANew = nbA;
					nbBNew = nbB - 1;
				}
				else if(choixDirection == 2){
					nbANew = nbA - 1;
					nbBNew = nbB;
				}
				else if(choixDirection == 3){
					nbANew = nbA;
					nbBNew = nbB + 1;
				}
			
				validPosition = testPos(nbANew, nbBNew);
				direction(choixDirection);
			
				if ((validPosition == 1) && (directionTot >=2)){
			
					if(bateauActuel == 1){	
						NbAMem = (int) memoireOrdi[0];
						partdec = (memoireOrdi[0]- NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
					else if(bateauActuel == 2){	
						NbAMem = (int) memoireOrdi[1];
						partdec = (memoireOrdi[1] - NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
					else if(bateauActuel == 3){	
						NbAMem = (int) memoireOrdi[2];
						partdec = (memoireOrdi[2] - NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
					else if(bateauActuel == 4){	
						NbAMem = (int) memoireOrdi[3];
						partdec = (memoireOrdi[3] - NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
			
					if ((placement1 == 1 && bateauActuel ==1) | (placement2 == 1 && bateauActuel ==2) | (placement3 == 1 && bateauActuel ==3) | (placement4 == 1 && bateauActuel ==4)){
						if(choixDirection == 0){
							choixDirection = 2;
						}
						else{
							choixDirection = 0;
						}
					}
					else{ 
						if(choixDirection == 1){
							choixDirection = 3;
						}
						else{
							choixDirection = 1;
						}
					}
						
					if(choixDirection == 0){
						nbANew = NbAMem + 1;
						nbBNew = NbBMem;
					}
					else if(choixDirection == 1){
						nbANew = NbAMem;
						nbBNew = NbBMem - 1;
					}
					else if(choixDirection == 2){
						nbANew = NbAMem - 1;
						nbBNew = NbBMem;
					}
					else if(choixDirection == 3){
						nbANew = NbAMem;
						nbBNew = NbBMem + 1;
					}
					validPosition = testPos(nbANew, nbBNew);	
					if(validPosition==0){		
						nbA = nbANew;
						nbB = nbBNew;
							
						AutoriseTir = 1;
					}
					else{
						JOptionPane.showMessageDialog(null, "Aucunne Solution envisageable");
					}
				}
				if ((validPosition == 1) && (directionTot <=2)){
					tirOrdi(); //coordonne deja utilisé
				}
			
				else if(validPosition == 0){
					nbA = nbANew;
					nbB = nbBNew;
					AutoriseTir = 1;
				}
			
			}
			
			else if (testMemoire == 1){ //si on vient de toucher une case blanche

				if((compteur6>=2 && bateauActuel ==1) | (compteur7>=2 && bateauActuel == 2) | (compteur8>=2 && bateauActuel == 3) | (compteur9>=2 && bateauActuel == 4)){
					if(bateauActuel == 1){	
						NbAMem = (int) memoireOrdi[0];
						partdec = (memoireOrdi[0]- NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10; //Le nombre sera arrondi à 10^-1
						NbBMem = (int) (partdec * 10);
					}
					else if(bateauActuel == 2){	
						NbAMem = (int) memoireOrdi[1];
						partdec = (memoireOrdi[1] - NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
					else if(bateauActuel == 3){	
						NbAMem = (int) memoireOrdi[2];
						partdec = (memoireOrdi[2] - NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
					else if(bateauActuel == 4){	
						NbAMem = (int) memoireOrdi[3];
						partdec = (memoireOrdi[3] - NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
					
					if ((bateauActuel ==1 && placement1 == 1) | (bateauActuel ==2 &&placement2 == 1) | (bateauActuel ==3 && placement3 == 1) | (bateauActuel ==4 && placement4 == 1)){
						if(choixDirection == 0){
							choixDirection = 2; // horizontal -> gauche
						}
						else{
							choixDirection = 0; // horizontal -> droite
						}
					}
					else{ 
						if(choixDirection == 1){
							choixDirection = 3; // vertical -> bas
						}
						else{
							choixDirection = 1; // vertical -> haut
						}
					}
						
					int nbANew = 0, nbBNew = 0;
						
					if(choixDirection == 0){
						nbANew = NbAMem + 1;
						nbBNew = NbBMem;
					}
					else if(choixDirection == 1){
						nbANew = NbAMem;
						nbBNew = NbBMem - 1;
					}
					else if(choixDirection == 2){
						nbANew = NbAMem - 1;
						nbBNew = NbBMem;
					}
					else if(choixDirection == 3){
						nbANew = NbAMem;
						nbBNew = NbBMem + 1;
					}
								
					validPosition = testPos(nbANew, nbBNew);
					if (validPosition == 1){
						tirOrdi(); //coordonne deja utilisé
					}
					else if(validPosition==0){		
						nbA = nbANew;
						nbB = nbBNew;
							
						AutoriseTir = 1;
					}
				}	
				
				else{

					if(bateauActuel == 1){
						NbAMem = (int) memoireOrdi[0];
						partdec = (memoireOrdi[0] - NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
					if(bateauActuel == 2){
						NbAMem = (int) memoireOrdi[1];
						partdec = (memoireOrdi[1] - NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
					if(bateauActuel == 3){
						NbAMem = (int) memoireOrdi[2];
						partdec = (memoireOrdi[2] - NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
					if(bateauActuel == 4){
						NbAMem = (int) memoireOrdi[3];
						partdec = (memoireOrdi[3] - NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
					if(bateauActuel == 5){
						NbAMem = (int) memoireOrdi[4];
						partdec = (memoireOrdi[4] - NbAMem);
						partdec = (double)Math.round(partdec * 10) / 10;
						NbBMem = (int) (partdec * 10);
					}
						
					validPosition = testPos(NbAMem, NbBMem);
					bonPlacement();

					int nbANew = 0, nbBNew = 0;
							
					if(choixDirection == 0){
						nbANew = NbAMem + 1;
						nbBNew = NbBMem;
					}
					else if(choixDirection == 1){
						nbANew = NbAMem;
						nbBNew = NbBMem - 1;
					}
					else if(choixDirection == 2){
						nbANew = NbAMem - 1;
						nbBNew = NbBMem;
					}
					else if(choixDirection == 3){
						nbANew = NbAMem;
						nbBNew = NbBMem + 1;
					}
						
					validPosition = testPos(nbANew, nbBNew);
					if (validPosition == 1){
						tirOrdi(); //coordonne deja utilisé
					}
				
					else if(validPosition==0){		
						nbA = nbANew;
						nbB = nbBNew;
						
						AutoriseTir = 1;	
					}
				}
			}
		}
				
		else if(aucunePiste==1){		
			nbA = (int) (Math.random() * 10 );     //Pour un entier entre 0 et 9
			nbB = (int) (Math.random() * 10 );     //Pour un entier entre 0 et 9
					
			validPosition = testPos(nbA, nbB);
			bonPlacement();

		/** Savoir si la case est viable pour un bateau */	
		while((testViable == 4) | ((positionDeLaCase == 1) && (testViable == 2)) | ((positionDeLaCase == 2) && (testViable == 3))) {

				nbA = (int) (Math.random() * 10 );     //Pour un entier entre 0 et 9
				nbB = (int) (Math.random() * 10 );     //Pour un entier entre 0 et 9
					
				validPosition = testPos(nbA, nbB);
				bonPlacement();
			}


		/** ----------------------------------------------------------- */
		
			if (validPosition == 1){
				tirOrdi(); //coordonne deja utilisé
			}
			else if(validPosition == 0){
				AutoriseTir = 1;
			}
		}
					
		if(AutoriseTir == 1){

			AutoriseTir =0;	
			direction0 = 0; direction1 = 0; direction2 = 0; direction3 = 0; directionTot = 0; //reset des directions
			compteurTirOrdi = compteurTirOrdi + 1;
			tabTirOrdi[(compteurTirOrdi)] = tab11[0];
			
			

			if (tab11[0] == tab1[0] | tab11[0] == tab1[1] | tab11[0] == tab1[2] | tab11[0] == tab1[3] | tab11[0] == tab1[4]){
				IconButton = (mesCases[nbA][nbB]).getIcon();
				imageOpe = iconToImage(IconButton, "images/couleur/explosion.png");			
				mesCases[nbA][nbB].setIcon(new ImageIcon(imageOpe));
				Sound.playTempSound("son/bruitages/bomb.wav");
				aucunePiste = 0;
				testMemoire = 0;
				touchePrecedent = 1;
				nombreTouche = 1;
				compteur6 = compteur6 + 1;
				bateauActuel = 1;
			
					
				if(compteur6 == 1){
					memoireOrdi[0] = tab11[0];
				}
					
				if (compteur6 == 5){
					compteur6++;
					Sound.playTempSound("son/bruitages/blooey.wav");
					JOptionPane.showMessageDialog(null, "L'ordinateur a coule le porte-avion");
					aucunePiste = 1;
					touchePrecedent = 0;
					}
			}																															
			
			else if (tab11[0] == tab2[0] | tab11[0] == tab2[1] | tab11[0] == tab2[2] | tab11[0] == tab2[3]){
				IconButton = (mesCases[nbA][nbB]).getIcon();
				imageOpe = iconToImage(IconButton, "images/couleur/explosion.png");			
				mesCases[nbA][nbB].setIcon(new ImageIcon(imageOpe));
				Sound.playTempSound("son/bruitages/bomb.wav");
				aucunePiste = 0;
				testMemoire = 0;
				touchePrecedent = 1;
				nombreTouche = 1;
				compteur7 = compteur7 + 1;
				bateauActuel = 2;
			
				
				if(compteur7 == 1){
					memoireOrdi[1] = tab11[0];
				}
				
				if (compteur7 == 4){
					compteur7++;
					Sound.playTempSound("son/bruitages/blooey.wav");
					JOptionPane.showMessageDialog(null, "L'ordinateur a coule le Cuirasse");
					aucunePiste = 1;
					touchePrecedent = 0;
				}
			}
			
			else if (tab11[0] == tab3[0] | tab11[0] == tab3[1] | tab11[0] == tab3[2]){
				IconButton = (mesCases[nbA][nbB]).getIcon();
				imageOpe = iconToImage(IconButton, "images/couleur/explosion.png");			
				mesCases[nbA][nbB].setIcon(new ImageIcon(imageOpe));
				Sound.playTempSound("son/bruitages/bomb.wav");
				aucunePiste = 0;
				testMemoire = 0;
				touchePrecedent = 1;
				nombreTouche = 1;
				compteur8 = compteur8 + 1;
				bateauActuel = 3;

					
				if(compteur8 == 1){
					memoireOrdi[2] = tab11[0];
				}
					
				if (compteur8 == 3){
					compteur8++;
					Sound.playTempSound("son/bruitages/blooey.wav");
					JOptionPane.showMessageDialog(null, "L'ordinateur a coule le contre-torpilleur");
					aucunePiste = 1;
					touchePrecedent = 0;
				}
			}
				
			else if (tab11[0] == tab4[0] | tab11[0] == tab4[1] | tab11[0] == tab4[2]){
				IconButton = (mesCases[nbA][nbB]).getIcon();
				imageOpe = iconToImage(IconButton, "images/couleur/explosion.png");			
				mesCases[nbA][nbB].setIcon(new ImageIcon(imageOpe));
				Sound.playTempSound("son/bruitages/bomb.wav");
				aucunePiste = 0;
				testMemoire = 0;
				touchePrecedent = 1;
				nombreTouche = 1;
				compteur9 = compteur9 + 1;
				bateauActuel = 4;
					
				if(compteur9 == 1){
					memoireOrdi[3] = tab11[0];
				}
					
				if (compteur9 == 3){
					compteur9++;
					Sound.playTempSound("son/bruitages/blooey.wav");
					JOptionPane.showMessageDialog(null, "L'ordinateur a coule le sous-marin");
					aucunePiste = 1;
					touchePrecedent = 0;
				}
			}
				
			else if (tab11[0] == tab5[0] | tab11[0] == tab5[1]){
				IconButton = (mesCases[nbA][nbB]).getIcon();
				imageOpe = iconToImage(IconButton, "images/couleur/explosion.png");			
				mesCases[nbA][nbB].setIcon(new ImageIcon(imageOpe));
				Sound.playTempSound("son/bruitages/bomb.wav");
				aucunePiste = 0;
				testMemoire = 0;
				touchePrecedent = 1;
				nombreTouche = 1;
				compteur10 = compteur10 + 1;
				bateauActuel = 5;
			
				memoireOrdi[4] = tab11[0];
				
				if (compteur10 == 2){
					compteur10++;
					Sound.playTempSound("son/bruitages/blooey.wav");
					JOptionPane.showMessageDialog(null, "L'ordinateur a coule l'avion de chasse");
					aucunePiste = 1;
					touchePrecedent = 0;
				}
			}
			
			else{
				IconButton = (mesCases[nbA][nbB]).getIcon();
				imageOpe = iconToImage(IconButton, "images/couleur/croix.png");			
				mesCases[nbA][nbB].setIcon(new ImageIcon(imageOpe));
				Sound.playTempSound("son/bruitages/plouf.wav");
				if((compteur10>=1 && compteur10<=2)  | (compteur9>=1 && compteur9<=3) | (compteur8>=1 && compteur8<=3) | (compteur7>=1 && compteur7<=4) | (compteur6>=1 && compteur6<=5)){
					touchePrecedent = 1;
				}
				if(touchePrecedent == 1){
					testMemoire = 1;
					nombreTouche++;
					aucunePiste = 0;
					touchePrecedent = 0;
				}
				else{
					aucunePiste = 1;
					touchePrecedent = 0;
					nombreTouche = 1;
				}
			}
			if((tab11[0] == 0.0) | (tab11[0] == 9.0) | (tab11[0] == 9.9) | (tab11[0] == 0.9)){
				if(tab11[0] == tab5[0] | tab11[0] == tab5[1] | tab11[0] == tab4[0] | tab11[0] == tab4[1] | tab11[0] == tab4[2] | tab11[0] == tab3[0] | tab11[0] == tab3[1] | tab11[0] == tab3[2] | tab11[0] == tab1[0] | tab11[0] == tab1[1] | tab11[0] == tab1[2] | tab11[0] == tab1[3] | tab11[0] == tab1[4] | tab11[0] == tab2[0] | tab11[0] == tab2[1] | tab11[0] == tab2[2] | tab11[0] == tab2[3]){
				testMemoire = 1;
				}
			}
			
			tourAQui = 1;
			tabTirChoix[(compteurTirOrdi)] = tab11[0];
			
			if (compteur6 == 6 & compteur7 == 5 & compteur8 == 4 & compteur9 == 4 & compteur10 == 3){
				fenetreFinale2();
			}
			pan5.setVisible(true);
			pan4.setVisible(true);
		}	
	}

	void fenetreFinale1(){
		
		AutoriseTir = 0; //Pour bloquer le jeu car c'est fini
		tourAQui = 0;
	
		JLabel imageV= new JLabel(new ImageIcon("images/victoire.gif"));
			
		panFin.setSize(1012, 416);
		panFin.setTitle("R\u00e9sultat de la partie");
		panFin.setLocationRelativeTo(null);
		panFin.setContentPane(panFinal);
		panFin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		panFin.setResizable(false);
		panFin.setLayout(null);	// Permet de placer les composants où l'on veut dans la fenetre
		panFinal.setBackground(Color.LIGHT_GRAY);
		panFin.setIconImage(icone);
		
		imageV.setBounds(0,0,1012,416);

		vainqueur = new JLabel ("Capitaine " + nomJ.getText() + ", vous avez gagn\u00e9 !  BRAVO !");
		vainqueur.setForeground(java.awt.Color.white);
		vainqueur.setLocation(340,280);
		vainqueur.setSize(350,25);
		
		nombreCoupsJ = new JLabel ("Vous avez gagn\u00e9 en " + compteurTirJ + " tirs.");
		nombreCoupsJ.setForeground(java.awt.Color.white);
		nombreCoupsJ.setLocation(340,300);
		nombreCoupsJ.setSize(320,25);
		
		finish = new JButton("OK");
		finish.setLocation(760, 320);
		finish.setSize(100,25);
		
		panFin.add(vainqueur);
		panFin.add(nombreCoupsJ);
		panFin.add(finish);
		panFin.add(imageV);
	
		EcouteurBoutonOK ecouteurOK = new EcouteurBoutonOK();
		finish.addActionListener(ecouteurOK);

		panFin.setVisible(true);
	}
	
	class EcouteurBoutonOK implements ActionListener{
		public void actionPerformed (ActionEvent clic){
			pan.dispose();
			panFin.dispose();
			pan4.dispose();
			panFin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			nomJ.setText("");
				
		}
	}
			
	void fenetreFinale2(){

		AutoriseTir = 0; 	//Pour bloquer le jeu car c'est fini
		tourAQui = 0;
	
		JLabel imageD= new JLabel(new ImageIcon("images/defaite.gif"));
		imageD.setBounds(0,0,814,528);
		
		panFin2.setSize(814, 528);
		panFin2.setTitle("Fin");
		panFin2.setLocationRelativeTo(null);
		panFin2.setResizable(false);
		panFin2.setContentPane(panFinal2);
		panFin2.setLayout(null);	// Permet de placer les composants où l'on veut dans la fenetre
		panFinal2.setBackground(Color.LIGHT_GRAY);
		panFin2.setIconImage(icone);
		
		vainqueurOrdi = new JLabel ("L'ordinateur a gagn\u00e9, dommage pour vous");
		vainqueurOrdi.setForeground(java.awt.Color.white);
		vainqueurOrdi.setLocation(30,330);
		vainqueurOrdi.setSize(350,25);
		
		nombreCoupsOrdi = new JLabel ("Il a gagn\u00e9 en " + compteurTirOrdi + " tirs.");
		nombreCoupsOrdi.setForeground(java.awt.Color.white);
		nombreCoupsOrdi.setLocation(30,345);
		nombreCoupsOrdi.setSize(320,25);
		
		finish = new JButton("OK");
		finish.setLocation(60, 400);
		finish.setSize(100,25);
		
		panFin2.add(vainqueurOrdi);
		panFin2.add(nombreCoupsOrdi);
		panFin2.add(finish);
		panFin2.add(imageD);

		EcouteurBoutonOK2 ecouteurOK = new EcouteurBoutonOK2();
		finish.addActionListener(ecouteurOK);

		panFin2.setVisible(true);
	}
	
	class EcouteurBoutonOK2 implements ActionListener{
		public void actionPerformed (ActionEvent clic){
			pan.dispose();
			panFin2.dispose();
			pan4.dispose();
			
			nomJ.setText("");
		}
	}		
}