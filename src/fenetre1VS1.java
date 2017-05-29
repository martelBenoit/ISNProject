// Programme : Cree les methodes pour jouer a la bataille navale

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;
import java.util.ArrayList;

public class fenetre1VS1 {
	
	JFrame frameNomEtMdp = new JFrame();	// JFrame pour le nom et mot de passe du joueur 1
	JPanel panMDP = new JPanel();	// JPanel pour la JFrame precedente
	
	JFrame frameNomEtMdp2 = new JFrame();	// Idem qu'au dessus, mais pour le joueur 2
	JPanel panMDP2 = new JPanel();	// Idem qu'au dessus, mais pour le joueur 2
	
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

	//Mise en place des icones pour les différentes fenetres
	Image icone = Toolkit.getDefaultToolkit().getImage("images/icone.png");

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
	int nbreMax = 100;
	double [] tabTir1 = new double [nbreMax];
	int nbreMax2 = 100;
	double [] tabTir2 = new double [nbreMax2];
	
	JLabel nomTirJ1;
	JLabel nomTirJ2;
	
	int ver = 0;
	int hor = 0;
	int chh2 = 0;
	int chv = 0;
	
	int choix;
	
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
	
	// Pour enregistrer les coordonnees et faire la tableau avec les cases en vert
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
	
	// Pour enregistrer les coordonnees, mais cette fois du joueur 2
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
	
	int compteurTir1 = 0;		// Ces deux compteurs comptent le nombre de tirs de chaque joueur
	int compteurTir2 = 0;

	int tourAQui = 1;
	
	boolean reponseMDP1 = true;		// Ces deux boolean servent lors de la demande de mot de passe, pour savoir si la personne a entre ou non le bon mdp et dans le mauvais cas, recommencer
	boolean reponseMDP2 = true;
	
	String vaChercherMDP, vaChercherMDP2;
	
	Font titre = new Font("Arial", Font.PLAIN, 21);
	Font sousTitre = new Font("Arial", Font.PLAIN, 18); 
	Font tir = new Font("Arial Black", Font.PLAIN, 16);

	Image imageOpe1;
	Image imageOpe2;
	Icon IconButton1;
	Icon IconButton2;

	
	// Creation de JButton
	JButton continuer, recommencer, valider, continuerMDP, continuerMDP2, demandeContinuer1, demandeContinuer2, demandeContinuer3, continuerTir1, continuerTir2;
	// Label de Titre
	JLabel labelTitre, nomFenetreJ1, nomFenetreJ2;
	// JComboBox pour le choix de bateau
	JComboBox choixBateau, choixPlacement, choixTir;
	// JTextField de la coordonnee de base
	JTextField coordonneeBase,  coordonneeBase2, nomJ1, nomJ2, MDPj1, MDPj2, demande1, demande2, demande3;
	// Label pour coordonneeDeBase
	JLabel coordonneeDeBase, choisissezB, choisissezP, nomDuJ1, nomDuJ2, motDePj1, motDePj2;
	JLabel vainqueur, vainqueur2;
	String tableau[];
	String tableauCoordonnees;;
	
	JButton[][] mesCases = new JButton [10][10];
	JButton[][] mesCases2 = new JButton [10][10];
	JButton[][] mesCases3 = new JButton [10][10];
	JButton[][] mesCases4 = new JButton [10][10];
    int cpt = 1;
    int cpt3 = 1;
    JLabel[] mesCoordonnees = new JLabel [10];
    JLabel[] mesCoordonneesH = new JLabel [10];
    JLabel[] mesCoordonnees2 = new JLabel [10];
    JLabel[] mesCoordonneesH2 = new JLabel [10];
    JLabel[] mesCoordonnees3 = new JLabel [10];
    JLabel[] mesCoordonneesH3 = new JLabel [10];
    JLabel[] mesCoordonnees4 = new JLabel [10];
    JLabel[] mesCoordonneesH4 = new JLabel [10];
    JLabel votreGrille;
    JLabel grilleDeVosTirs;
    JTextField coordonneeTir, coordonneeTir2;
    JButton boutonTir, boutonTir2;
    JLabel votreTir;
    JLabel nbreCoups1, nbreCoups2;
    JLabel tempsDeJeu1, tempsDeJeu2;
    JLabel recordTempsJeu;
    JButton recommencerBateau;
    JLabel pourcentage1, pourcentage2;
    double tempsJeu;
	double tempsFinal;
	double resultat;
	double resultat2;
	int resultat3;
	int resultat4;
	double secondes;
	JButton finish;
	JLabel test;
	int testPourcentage;
	double testPourcentage2;
	JTextField exemple1, exemple2;

	int quelJoueur = 0; //pour savoir sur quelle configuration de joueur on se trouve

	// Valeurs pour les boucles de boutons
	int i;
	int j;
	
	// char pour les coordonnees du bouton clique
	int a;
	int b;
	int c;
	int d;
	
	// JLabel pour l'explication de la coordonnee de base
	JLabel ast1, ast2, ast3;
	
	int abc = 0; //test placement pour l'erreur
	int choixPlacJ = 0; //pour savoir si l'on doit s'occuper des position des bateaux du J1 ou du J2 ------       1-> J1      2-> J2
	
	//Méthodes pour placement des bateaux
	
	int configurationVerticale(int chv){
		int variable= 0;
	
		if (chv == 'A' | chv == 'a'){		// Si le premier caractere est A ou a (l'utilisateur choisit s'il met une majuscule ou une minuscule
			variable = 0;					// ver = 0, car le tableau commence a 0
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
			
	void configurationFenetreJoueur(){
       
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

        // Informations JLabel ast1
        ast1 = new JLabel ("* La coordonn\u00e9e de base repr\u00e9sente la coordonn\u00e9e \u00e0");
        ast1.setLocation(85, 360);
        ast1.setSize(520, 25);
        
        // Informations JLabel ast2
        ast2 = new JLabel ("l'extr\u00e9mit\u00e9 gauche du bateau (s'il est plac\u00e9 horizontalement)");
        ast2.setLocation(75, 380);
        ast2.setSize(500,25);
        
          // Informations JLabel ast3
        ast3 = new JLabel ("et l'extr\u00e9mit\u00e9 du haut (s'il est plac\u00e9 verticalement)");
        ast3.setLocation(75, 400);
        ast3.setSize(500,25);

        // Informations label titre
		if(quelJoueur == 1){
			labelTitre = new JLabel(nomJ1.getText()+", entrez les coordonn\u00e9es de vos bateaux");
		}
        else if(quelJoueur == 2){
        	labelTitre = new JLabel(nomJ2.getText()+", entrez les coordonn\u00e9es de vos bateaux");
        }

		labelTitre.setFont(titre); 
        labelTitre.setLocation(0,15);
        labelTitre.setHorizontalAlignment(SwingConstants.CENTER);	
        labelTitre.setSize(700,70);

	}

	void mdpEtNomJ1(){	// Nouvelle methode pour definir le nom et le mdp du joueur 1
		

		frameNomEtMdp.setSize(400, 170);			// Definit la taille de la fenetre
		frameNomEtMdp.setTitle("Joueur 1");			// Definit le titre de la fenetre (en haut a gauche)
		frameNomEtMdp.setLocationRelativeTo(null);	// Met la fenetre au milieu de l'ecran
        frameNomEtMdp.setContentPane(panMDP);		// Ajoute le contenu de panMDP
        frameNomEtMdp.setLayout(null);				// Permet de placer les composants où l'on veut dans la fenetre
		frameNomEtMdp.setUndecorated(true);
		frameNomEtMdp.setIconImage(icone);
	
        panMDP.setBackground(Color.LIGHT_GRAY);		// Permet de mettre panMDP en couleur gris clair
        
        nomJ1 = new JTextField();					// Cree le nouveau JTextField
        nomJ1.setLocation(50,50);					// Place le JTextField dans la fenetre
        nomJ1.setSize(130,25);						// Donne la taille visuelle du JTextField
        
        MDPj1 = new JPasswordField();
        MDPj1.setLocation(50, 105);
        MDPj1.setSize(130,25);
        
        nomFenetreJ1 = new JLabel("Joueur 1");	
        nomFenetreJ1.setHorizontalAlignment(SwingConstants.CENTER);	
        nomFenetreJ1.setFont(sousTitre);	
        nomFenetreJ1.setLocation(5,0);					
        nomFenetreJ1.setSize(400,35);						

        nomDuJ1 = new JLabel("Votre nom :");			// Cree le nouveau JLabel avec "Votre nom:" ecrit
        nomDuJ1.setLocation(50,25);					// Place le JLabel dans la fenetre
        nomDuJ1.setSize(90,25);						// Donne la taille du JLabel
        
        motDePj1 = new JLabel("Votre mot de passe :");
        motDePj1.setLocation(50,80);
        motDePj1.setSize(140,25);
        
        continuerMDP = new JButton("Continuer");	// Cree le nouveau bouton avec "Continuer" ecrit
        continuerMDP.setLocation(220, 75);			// Place le JButton dans la fenetre
        continuerMDP.setSize(120,40);				// Donne la taille du bouton
        
        frameNomEtMdp.add(nomFenetreJ1);
        frameNomEtMdp.add(nomJ1);					// Ajoute nomJ1 a frameNomEtMdp
        frameNomEtMdp.add(MDPj1);
        frameNomEtMdp.add(nomDuJ1);
        frameNomEtMdp.add(motDePj1);
        frameNomEtMdp.add(continuerMDP);
        

        
        EcouteurBoutonContinuerMDP ecouteurMDP = new EcouteurBoutonContinuerMDP();		// Cree un nouvel ecouteur nomme ecouteurMDP
        continuerMDP.addActionListener(ecouteurMDP);									// Ajout l'ecouteur precedement cree au bouton continuerMDP

        frameNomEtMdp.setVisible(true);				// Rend les composants de ce panneau visible
       

	}
	
	class EcouteurBoutonContinuerMDP implements ActionListener{
		public void actionPerformed (ActionEvent clic){
			String chercher = nomJ1.getText();	// Cette string va chercher le nom que le joueur 1 a entre
			String chercher2 = MDPj1.getText();	// " " " " " mot de passe " " " " " "
			
			if (chercher.equals("")){		// Si l'utilisateur 1 n'a rien entre comme nom, il y a une erreur
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer un nom correct", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else if (chercher2.equals("")){		// Si l'utilisateur 1 n'a rien entre comme mdp, il y a une erreur
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer un mot de passe correct", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else{
				mdpEtNomJ2();		// execute la methode mdpEtNomJ2
				frameNomEtMdp.dispose();		// ferme la fenetre qui est ouverte
			}
		}
	}
	
	void mdpEtNomJ2(){
		
		frameNomEtMdp2.setSize(400, 170);
		frameNomEtMdp2.setTitle("Joueur 2");
		frameNomEtMdp2.setLocationRelativeTo(null);
        frameNomEtMdp2.setContentPane(panMDP2);
        frameNomEtMdp2.setLayout(null);	// Permet de placer les composants où l'on veut dans la fenetre
		frameNomEtMdp2.setUndecorated(true);
		frameNomEtMdp2.setIconImage(icone);

        panMDP2.setBackground(Color.LIGHT_GRAY);
        
        nomJ2 = new JTextField();
        nomJ2.setLocation(50,55);
        nomJ2.setSize(130,25);
        
        MDPj2 = new JPasswordField();
        MDPj2.setLocation(50, 110);
        MDPj2.setSize(130,25);

        nomFenetreJ2 = new JLabel("Joueur 2");	
        nomFenetreJ2.setHorizontalAlignment(SwingConstants.CENTER);	
        nomFenetreJ2.setFont(sousTitre);	
        nomFenetreJ2.setLocation(5,0);					
        nomFenetreJ2.setSize(400,35);	
        
        nomDuJ2 = new JLabel("Votre nom :");
        nomDuJ2.setLocation(50,30);
        nomDuJ2.setSize(90,25);
        
        motDePj2 = new JLabel("Votre mot de passe :");
        motDePj2.setLocation(50,85);
        motDePj2.setSize(140,25);
        
        continuerMDP2 = new JButton("Continuer");
        continuerMDP2.setLocation(220, 80);
        continuerMDP2.setSize(120,40);
        
        frameNomEtMdp2.add(nomFenetreJ2);
        frameNomEtMdp2.add(nomJ2);
        frameNomEtMdp2.add(MDPj2);
        frameNomEtMdp2.add(nomDuJ2);
        frameNomEtMdp2.add(motDePj2);
        frameNomEtMdp2.add(continuerMDP2);
        
        EcouteurBoutonContinuerMDP2 ecouteurMDP2 = new EcouteurBoutonContinuerMDP2();
        continuerMDP2.addActionListener(ecouteurMDP2);
        
        frameNomEtMdp2.setVisible(true);   
	}
	
	class EcouteurBoutonContinuerMDP2 implements ActionListener{
		public void actionPerformed (ActionEvent clic){
			String chercher = nomJ2.getText();
			String chercher2 = MDPj2.getText();
			
			vaChercherMDP = MDPj2.getText();
			
			if (chercher.equals("")){
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer un nom correct", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else if (chercher2.equals("")){
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer un mot de passe correct", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else{
				joueur1();
				frameNomEtMdp2.dispose(); //ferme la fenetre
			}
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
	
	void joueur1(){
		pan.setSize(700, 465);
		pan.setTitle("Capitaine " + nomJ1.getText());
		pan.setLocationRelativeTo(null);
        pan.setContentPane(pan1);
        pan.setLayout(null);	// Permet de placer les composants où l'on veut dans la fenetre
        pan.setUndecorated(true);
        pan.setBackground(new Color(0,0,0,0));
        pan.setIconImage(icone);

        Sound.playTempSound("son/bruitages/start.wav");
	
        JLabel imageFondChoixJ1 = new JLabel(new ImageIcon("images/fond/fondChoix.gif"));
		imageFondChoixJ1.setBounds(0,0,700,465);
       
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
        	mesCoordonnees[k] = new JLabel(String.valueOf( cpt2++ ));
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

		quelJoueur = 1;
		configurationFenetreJoueur();

		// Informations JTextField coordonneeBase
        coordonneeBase = new JTextField();
        coordonneeBase.setLocation(75,115);
        coordonneeBase.setSize(100,25);
		
        // Ajout des JButton
        pan.add(continuer);
        pan.add(recommencer);
        pan.add(valider);
		
		 // Ajout de la JComboBox
        pan.add(choixBateau);
        pan.add(choixPlacement);
        
        // Ajout JTextField
        pan.add(coordonneeBase);  
       
        // Ajout des JLabel
        pan.add(labelTitre);
        pan.add(coordonneeDeBase);
        pan.add(choisissezB);
        pan.add(choisissezP);
        pan.add(ast1);
        pan.add(ast2);
        pan.add(ast3);
		pan.add(imageFondChoixJ1);
    
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
			joueur2();	// Ouvre la nouvelle fenetre contenue dans la classe fenetreJeu2
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
			
				if (source == "Cuirasse (4 cases)"){
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
			
				else if (source == "Avion de chasse (2 cases)"){
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
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide (vous n'avez pas entre assez de caracteres)", "Erreur", JOptionPane.ERROR_MESSAGE);
				coordonneeBase.requestFocus();
			}
			else if (n > 3){
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide (vous avez entre trop de caracteres)", "Erreur", JOptionPane.ERROR_MESSAGE);
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
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
								coordonneeBase.requestFocus();
							}
						}
			
					hor = hor-1;		// Les coordonnees du tableau vont de 0 a 9, donc il faut mettre -1
		
					ver = configurationVerticale(chv);
			
					if (source == "Porte-Avion (5 cases)"){	// Si l'utilisateur choisit porte-avion
			
						if (source2 == "Horizontal"){	// Si l'utilisateur choisit horizontal
							if (ver>9 | hor>5){	// Si l'utilisateur entre une lettre plus "grande" que J ou j, message d'erreur // Si l'utilisateur entre une coordonnee plus grande que 6 (on met 5 car le tableau commence a 0)
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else {
							
								mesCases[hor][ver].setBackground(Color.BLACK);
								mesCases[hor+1][ver].setBackground(Color.BLACK);
								mesCases[hor+2][ver].setBackground(Color.BLACK);
								mesCases[hor+3][ver].setBackground(Color.BLACK);
								mesCases[hor+4][ver].setBackground(Color.BLACK);
								choixBateau.removeItemAt(x);
								choixBateau.addItem("Cuirasse (4 cases)");
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
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=5){
								mesCases[hor][ver].setBackground(Color.BLACK);
								mesCases[hor][ver+1].setBackground(Color.BLACK);
								mesCases[hor][ver+2].setBackground(Color.BLACK);
								mesCases[hor][ver+3].setBackground(Color.BLACK);
								mesCases[hor][ver+4].setBackground(Color.BLACK);
								choixBateau.removeItemAt(x);
								choixBateau.addItem("Cuirasse (4 cases)");
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

					if (source == "Cuirasse (4 cases)"){
					
						if (source2 == "Horizontal"){
							if (ver>9 | hor>6){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
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
								
								choixPlacJ = 1;
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
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
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
								
								choixPlacJ = 1;
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
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}

							else{
							
								int nbreMax = 3;
								hord = (double) hor;
								verd = (double) ver;
								tab3 = new double [nbreMax];
								tab3[0] = hord+verd/10;
								tab3[1] = hord+1+(verd/10);
								tab3[2] = hord+2+(verd/10);
								
								choixPlacJ = 1;
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
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=7){
								
								int nbreMax = 3;
								hord = (double) hor;
								verd = (double) ver;
								tab3 = new double [nbreMax];
								tab3[0] = hord+(verd/10);
								tab3[1] = hord+((verd+1)/10);
								tab3[2] = hord+((verd+2)/10);
								
								choixPlacJ = 1;
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
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else{
						
								int nbreMax = 3;
								hord = (double) hor;
								verd = (double) ver;
								tab4 = new double [nbreMax];
								tab4[0] = hord+verd/10;
								tab4[1] = hord+1+(verd/10);
								tab4[2] = hord+2+(verd/10);
								
								choixPlacJ = 1;
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
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=7){
								
								int nbreMax = 3;
								hord = (double) hor;
								verd = (double) ver;
								tab4 = new double [nbreMax];
								tab4[0] = hord+(verd/10);
								tab4[1] = hord+((verd+1)/10);
								tab4[2] = hord+((verd+2)/10);
								
								choixPlacJ = 1;
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
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else{
							
								int nbreMax = 2;
								hord = (double) hor;
								verd = (double) ver;
								tab5 = new double [nbreMax];
								tab5[0] = hord+verd/10;
								tab5[1] = hord+1+(verd/10);
								
								choixPlacJ = 1;
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
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=8){
									
								tab5 = new double [2];
								hord = (double) hor;
								verd = (double) ver;
								tab5[0] = hord+(verd/10);
								tab5[1] = hord+((verd+1)/10);
								
								choixPlacJ = 1;
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
	  
	void joueur2(){
		pan2.setSize(700, 465);
		pan2.setTitle("Capitaine " + nomJ2.getText());
		pan2.setLocationRelativeTo(null);
		pan2.setUndecorated(true);
		pan2.setBackground(new Color(0,0,0,0));
        pan3.setBackground(new Color(0,0,0,0));
        pan2.setContentPane(pan3);
        pan2.setLayout(null);	// Permet de placer les composants où l'on veut dans la fenetre
        pan2.setIconImage(icone);

        Sound.playTempSound("son/bruitages/start.wav");
        
		JLabel imageFondChoixJ2 = new JLabel(new ImageIcon("images/fond/fondChoix.gif"));
		imageFondChoixJ2.setBounds(0,0,700,465);
        
        for( int i = 0; i < mesCases.length; i++ ) {
            for( int j = 0; j < mesCases[0].length; j++ ) {
                mesCases2[i][j] = new JButton();
                mesCases2[i][j].setSize(20,20);
                mesCases2[i][j].setBackground(Color.BLUE);
                mesCases2[i][j].setLocation(445+20*i,230+20*j); 
                pan3.add(mesCases2[i][j]);
           }
       }

        char cpt2 = 'A';
        
        for(int k = 0; k < mesCoordonnees2.length; k++){
        	
        	mesCoordonnees2[k] = new JLabel(String.valueOf(cpt2++));
        	mesCoordonnees2[k].setSize(10,10);
        	mesCoordonnees2[k].setLocation(435, 233+20*k);
        	pan3.add(mesCoordonnees2[k]);
      
        }
        
        for (int l = 0; l < mesCoordonneesH2.length; l++){
        	mesCoordonnees2[l] = new JLabel(String.valueOf(cpt3++));
        	mesCoordonnees2[l].setSize(14,10);
        	mesCoordonnees2[l].setLocation(452+20*l,217);
        	pan3.add(mesCoordonnees2[l]);
      
        }
        quelJoueur = 2;
		configurationFenetreJoueur();

        // Informations JTextField coordonneeBase
        coordonneeBase2 = new JTextField();
        coordonneeBase2.setLocation(75,115);
        coordonneeBase2.setSize(100,25);

        // Ajout des JButton
        pan2.add(continuer);
        pan2.add(recommencer);
        pan2.add(valider);
		
		 // Ajout de la JComboBox
        pan2.add(choixBateau);
        pan2.add(choixPlacement);
		
		// Ajout JTextField
        pan2.add(coordonneeBase2);
       
        // Ajout des JLabel
        pan2.add(labelTitre);
        pan2.add(coordonneeDeBase);
        pan2.add(choisissezB);
        pan2.add(choisissezP);
		pan2.add(ast1);
        pan2.add(ast2);
        pan2.add(ast3);
		pan2.add(imageFondChoixJ2);
        
        coordonneeBase2.setFocusable(true);
        
        continuer.setEnabled(false);
        recommencer.setEnabled(false);
        
        // Ajout de l'ecouteur au bouton continuer
        EcouteurBoutonContinuer2 ecouteurContinuer = new EcouteurBoutonContinuer2();
        continuer.addActionListener(ecouteurContinuer);

        EcouteurBoutonValider2 ecouteurValider = new EcouteurBoutonValider2();
        valider.addActionListener(ecouteurValider);
        
        EcouteurBoutonRecommencer2 ecouteurRecommencer = new EcouteurBoutonRecommencer2();
        recommencer.addActionListener(ecouteurRecommencer);
       
        
        SwingUtilities.invokeLater(new Runnable()
        {
           @Override
           public void run()
           {
              coordonneeBase2.requestFocus();	
              									
           }
         
        });
        
        pan2.setVisible(true);
	}
		
	class EcouteurBoutonContinuer2 implements ActionListener{
		public void actionPerformed (ActionEvent clic){
			pan3.setVisible(false);


			do{
		String reponseQuestion = JOptionPane.showInputDialog(null, "Capitaine " + nomJ2.getText() + ", veuillez entrer votre mot de passe");
		
			
				try{
					if (reponseQuestion.equals(MDPj1.getText())){
						tirJoueur1();
						pan2.dispose();
						reponseMDP2 = false;
						tirJoueur2(); 		// On cree deja cela, comme ça on peut mettre les cases en couleur
						pan4.setContentPane(pan5);
					}
				
					else if (!reponseQuestion.equals(MDPj1.getText())){
						JOptionPane.showMessageDialog(null, "Erreur, mauvais mot de passe", "Erreur", JOptionPane.ERROR_MESSAGE);
						reponseMDP2 = true;	
					}
				}
				catch (NullPointerException e){
					JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer votre mot de passe", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
			while (reponseMDP2);	
			
		}
	}

	class EcouteurBoutonRecommencer2 implements ActionListener{
		public void actionPerformed (ActionEvent clic){
			
			int x = choixBateau.getSelectedIndex();
			Object source = choixBateau.getSelectedItem();
			
			int reponseRecommencer1 = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment replacer tous vos bateaux?");
			
			if (reponseRecommencer1 == 0){
				for (int s = 0; s<mesCases2.length; s++){
					for (int t = 0; t<mesCases2[0].length;t++){
						mesCases2[s][t].setBackground(Color.BLUE);
					}
				}
			
				if (source == "Cuirasse (4 cases)"){
					for (int u = 0; u<5; u++){
						tab6[u] = 0;
					}
					choixBateau.removeItemAt(x);
					choixBateau.addItem("Porte-Avion (5 cases)");
				}
				
				else if (source == "Contre-Torpilleur (3 cases)"){
					for (int u = 0; u<5; u++){
						tab6[u] = 0;
					}
					for (int v = 0; v<4; v++){
						tab7[v] = 0;
					}
					choixBateau.removeItemAt(x);
					choixBateau.addItem("Porte-Avion (5 cases)");
				}
				
				else if (source == "Sous-Marin (3 cases)"){
					for (int u = 0; u<5; u++){
						tab6[u] = 0;
					}
					for (int v = 0; v<4; v++){
						tab7[v] = 0;
					}
					for (int w = 0; w<3; w++){
						tab8[w] = 0;
					}
					choixBateau.removeItemAt(x);
					choixBateau.addItem("Porte-Avion (5 cases)");
				}
				
				else if (source == "Avion de chasse (2 cases)"){
					for (int u = 0; u<5; u++){
						tab6[u] = 0;
					}
					for (int v = 0; v<4; v++){
						tab7[v] = 0;
					}
					for (int w = 0; w<3; w++){
						tab8[w] = 0;
					}
					for (int y = 0; y<3; y++){
						tab9[y] = 0;
					}
					choixBateau.removeItemAt(x);
					choixBateau.addItem("Porte-Avion (5 cases)");
				}

				if (source == ""){
					for (int u = 0; u<5; u++){
						tab6[u] = 0;
					}
					for (int v = 0; v<4; v++){
							tab7[v] = 0;
					}
					for (int w = 0; w<3; w++){
							tab8[w] = 0;
					}
					for (int y = 0; y<3; y++){
						tab9[y] = 0;
					}
					for (int z = 0; z<2; z++){
						tab10[z] = 0;
					}
					choixBateau.removeItemAt(x);
					choixBateau.addItem("Porte-Avion (5 cases)");
					valider.setEnabled(true);
					continuer.setEnabled(false);
				}
			}
			coordonneeBase2.requestFocus();
		}
	}

	class EcouteurBoutonValider2 implements ActionListener{
		public void actionPerformed (ActionEvent e){

			Object source = choixBateau.getSelectedItem(); 																		
			Object source2 = choixPlacement.getSelectedItem(); 
			int x = choixBateau.getSelectedIndex();	
			int ver = 0;	// Corrsepond aux lettres
			int hor = 0;	// Correspond aux chiffres
			int chh2 = 0;	// S'il y a 3 caracteres (A10 par exemple), cela sert $ avoir le troisieme caractere
			int chv = 0;	// Premier caractere (la lettre)
			int chh1 = 0;	// Deuxieme caractere (le chiffre)
			String ch = coordonneeBase2.getText();	// Coordonnee entree par le joueur
			
			int n = ch.length();	// Permet de definir la longeur de la coordonnee entree par le joueur
			
			coordonneeBase2.setText("");
			
			if (n < 2){	// S'il y a moins de 2 caracteres, il y a une erreur comme quoi c'est trop petit
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide (vous n'avez pas entre assez de caracteres)", "Erreur", JOptionPane.ERROR_MESSAGE);
				coordonneeBase2.requestFocus();
			}
			else if (n > 3){
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide (vous avez entre trop de caracteres)", "Erreur", JOptionPane.ERROR_MESSAGE);
				coordonneeBase2.requestFocus();
			}
			else{
				chv = ch.charAt(0);	// Permet d'aller chercher le premier caractere entre par la personne
				chh1 = ch.charAt(1)-48;	// On met -48 sinon le chiffre ne s'affiche pas coorectement (trop grand, mais pourquoi?)
				if (chh1<1){
					JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
					coordonneeBase2.requestFocus();
				}
				else{
					hor = chh1;	// Hor est la variable pour savoir si c'est 1 ou 2, il permet de definir le chiffre/nombre
					if (n==3){	// S'il y a 3 caracteres
						chh2 = ch.charAt(2)-48;	// Va chercher le trosieme caractere
						hor = chh1*10 + chh2;	// On met chh1*10 car le premier chiffre sera 1 et le deuxieme 0, donc cela sera 10+0 donc 10, et si c'est plus que 10, voir if en dessous
						if (hor>10){	// Si l'utilisateur entre un nombre plus grand que 10
							JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							coordonneeBase2.requestFocus();
						}
					}
			
					hor = hor-1;		// Les coordonnees du tableau vont de 0 a 9, donc il faut mettre -1
			
					ver = configurationVerticale(chv);
			
					if (source == "Porte-Avion (5 cases)"){
				
						if (source2 == "Horizontal"){
					
							if (ver>9 | hor>5){ // Si l'utilisateur entre une lettre plus "grande" que J ou j, message d'erreur // Si l'utilisateur entre une coordonnee plus grande que 6 (on met 5 car le tableau commence a 0)
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
								coordonneeBase2.requestFocus();
							}
					
							else{
						
								mesCases2[hor][ver].setBackground(Color.BLACK);
								mesCases2[hor+1][ver].setBackground(Color.BLACK);
								mesCases2[hor+2][ver].setBackground(Color.BLACK);
								mesCases2[hor+3][ver].setBackground(Color.BLACK);
								mesCases2[hor+4][ver].setBackground(Color.BLACK);
									
								choixBateau.removeItemAt(x);
								choixBateau.addItem("Cuirasse (4 cases)");
								int nbreMax = 5;
								tab6 = new double [nbreMax];
								hord = (double) hor;
								verd = (double) ver;
								tab6[0] = hord+verd/10;
								tab6[1] = hord+1+(verd/10);
								tab6[2] = hord+2+(verd/10);
								tab6[3] = hord+3+(verd/10);
								tab6[4] = hord+4+(verd/10);
								
								placement6 = 1;
								
								coo11 = hor;
								coo12 = ver;
								
								recommencer.setEnabled(true);		
							}
						}

						else if (source2 == "Vertical"){
							if (ver>5){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=5){
								mesCases2[hor][ver].setBackground(Color.BLACK);
								mesCases2[hor][ver+1].setBackground(Color.BLACK);
								mesCases2[hor][ver+2].setBackground(Color.BLACK);
								mesCases2[hor][ver+3].setBackground(Color.BLACK);
								mesCases2[hor][ver+4].setBackground(Color.BLACK);
								choixBateau.removeItemAt(x);
								choixBateau.addItem("Cuirasse (4 cases)");
								int nbreMax = 5;
								tab6 = new double [nbreMax];
								hord = (double) hor;
								verd = (double) ver;
								tab6[0] = hord+(verd/10);
								tab6[1] = hord+((verd+1)/10);
								tab6[2] = hord+((verd+2)/10);
								tab6[3] = hord+((verd+3)/10);
								tab6[4] = hord+((verd+4)/10);
								
								placement6 = 2;
								
								coo11 = hor;
								coo12 = ver;
								
								recommencer.setEnabled(true);	
							}
						}
					}
								
					if (source == "Cuirasse (4 cases)"){
							
						if (source2 == "Horizontal"){
								
							if (ver>9 | hor>6){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							
							else{
								
								int nbreMax = 4;
								tab7 = new double [nbreMax];
								hord = (double) hor;
								verd = (double) ver;
								tab7[0] = hord+verd/10;
								tab7[1] = hord+1+(verd/10);						
								tab7[2] = hord+2+(verd/10);
								tab7[3] = hord+3+(verd/10);
								
								choixPlacJ = 2;
								testPlacementBateaux1();
									
								if (erreur == 2){
										
									mesCases2[hor][ver].setBackground(Color.CYAN);
									mesCases2[hor+1][ver].setBackground(Color.CYAN);
									mesCases2[hor+2][ver].setBackground(Color.CYAN);
									mesCases2[hor+3][ver].setBackground(Color.CYAN);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Contre-Torpilleur (3 cases)");
									
									placement7 = 1;
									
									coo13 = hor;
									coo14 = ver;
								}	
							}
						}
							
						else if (source2 == "Vertical"){
							if (ver>6){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=6){
											
								int nbreMax = 4;
								tab7 = new double [nbreMax];
								hord = (double) hor;
								verd = (double) ver;
								tab7[0] = hord+(verd/10);
								tab7[1] = hord+((verd+1)/10);
								tab7[2] = hord+((verd+2)/10);
								tab7[3] = hord+((verd+3)/10);
								
								choixPlacJ = 2;
								testPlacementBateaux1();
								
								if (erreur == 2){
									mesCases2[hor][ver].setBackground(Color.CYAN);
									mesCases2[hor][ver+1].setBackground(Color.CYAN);
									mesCases2[hor][ver+2].setBackground(Color.CYAN);
									mesCases2[hor][ver+3].setBackground(Color.CYAN);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Contre-Torpilleur (3 cases)");
									
									placement7 = 2;
									
									coo13 = hor;
									coo14 = ver;
								}
							}
						}
				
					}
						
					if (source == "Contre-Torpilleur (3 cases)"){
								
						if (source2 == "Horizontal"){
									
							if (ver>9 | hor>7){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							
							else{
									
								int nbreMax = 3;
								tab8 = new double [nbreMax];
								hord = (double) hor;
								verd = (double) ver;
								tab8[0] = hord+verd/10;
								tab8[1] = hord+1+(verd/10);
								tab8[2] = hord+2+(verd/10);
								
								choixPlacJ = 2;
								testPlacementBateaux2();
								
								if (erreur == 2){
									
									mesCases2[hor][ver].setBackground(Color.YELLOW);
									mesCases2[hor+1][ver].setBackground(Color.YELLOW);
									mesCases2[hor+2][ver].setBackground(Color.YELLOW);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Sous-Marin (3 cases)");
									
									placement8 = 1;
									
									coo15 = hor;
									coo16 = ver;
								}
						
							}
						}
							
						else if (source2 == "Vertical"){
							if (ver>7){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=7){
											
								int nbreMax = 3;
								tab8 = new double [nbreMax];
								hord = (double) hor;
								verd = (double) ver;
								tab8[0] = hord+(verd/10);
								tab8[1] = hord+((verd+1)/10);
								tab8[2] = hord+((verd+2)/10);

								choixPlacJ = 2;
								testPlacementBateaux2();

								if (erreur == 2){

									mesCases2[hor][ver].setBackground(Color.YELLOW);
									mesCases2[hor][ver+1].setBackground(Color.YELLOW);
									mesCases2[hor][ver+2].setBackground(Color.YELLOW);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Sous-Marin (3 cases)");

									placement8 = 2;

									coo15 = hor;
									coo16 = ver;

								}
							}
						}
							
					}
						
					if (source == "Sous-Marin (3 cases)"){
							
						if (source2 == "Horizontal"){
									
							if (ver>9 | hor>7){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else{
									
								int nbreMax = 3;
								tab9 = new double [nbreMax];
								hord = (double) hor;
								verd = (double) ver;
								tab9[0] = hord+verd/10;
								tab9[1] = hord+1+(verd/10);
								tab9[2] = hord+2+(verd/10);
								
								choixPlacJ = 2;
								testPlacementBateaux3();
									
								if (erreur == 2){
									mesCases2[hor][ver].setBackground(Color.GREEN);
									mesCases2[hor+1][ver].setBackground(Color.GREEN);
									mesCases2[hor+2][ver].setBackground(Color.GREEN);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Avion de chasse (2 cases)");
									
									placement9 = 1;
									
									coo17 = hor;
									coo18 = ver;
								}
						
							}
						}
							
						else if (source2 == "Vertical"){
							if (ver>7){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							
							else if (ver<=7){
											
								int nbreMax = 3;
								tab9 = new double [nbreMax];
								hord = (double) hor;
								verd = (double) ver;
								tab9[0] = hord+(verd/10);
								tab9[1] = hord+((verd+1)/10);
								tab9[2] = hord+((verd+2)/10);
								
								choixPlacJ = 2;
								testPlacementBateaux3();
									
								if (erreur == 2){
								
									mesCases2[hor][ver].setBackground(Color.GREEN);
									mesCases2[hor][ver+1].setBackground(Color.GREEN);
									mesCases2[hor][ver+2].setBackground(Color.GREEN);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("Avion de chasse (2 cases)");
								
									placement9 = 2;
								
									coo17 = hor;
									coo18 = ver;
								}
										
							}
						}
					}
							
					if (source == "Avion de chasse (2 cases)")	{
								
						if (source2 == "Horizontal"){
										
							if (ver>9 | hor>8){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else{
								
								int nbreMax = 2;
								tab10 = new double [nbreMax];
								hord = (double) hor;
								verd = (double) ver;
								tab10[0] = hord+verd/10;
								tab10[1] = hord+1+(verd/10);
								
								choixPlacJ = 2;
								testPlacementBateaux4();
								
								if (erreur == 2){
								
									mesCases2[hor][ver].setBackground(Color.DARK_GRAY);
									mesCases2[hor+1][ver].setBackground(Color.DARK_GRAY);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("");
									
									placement10 = 1;
									
									coo19 = hor;
									coo20 = ver;
									
									continuer.setEnabled(true);
									valider.setEnabled(false);
								}
					
							}
						}
						
						else if (source2 == "Vertical"){
							if (ver>8){
								JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer une coordonnee valide", "Erreur", JOptionPane.ERROR_MESSAGE);
							}
							else if (ver<=8){
												
								int nbreMax = 2;
								tab10 = new double [nbreMax];
								hord = (double) hor;
								verd = (double) ver;
								tab10[0] = hord+(verd/10);
								tab10[1] = hord+((verd+1)/10);
								
								choixPlacJ = 2;
								testPlacementBateaux4();
								
								if (erreur == 2){
								
									mesCases2[hor][ver].setBackground(Color.DARK_GRAY);
									mesCases2[hor][ver+1].setBackground(Color.DARK_GRAY);
									choixBateau.removeItemAt(x);
									choixBateau.addItem("");	// On ajoute ça pour pouvoir recommencer avec le dernier bateau
								
									placement10 = 2;
								
									coo19 = hor;
									coo20 = ver;
								
									continuer.setEnabled(true);
									valider.setEnabled(false);
								}
							}
						}
					}
				}
			}	
			coordonneeBase2.requestFocus();
		}
	}

	void testPlacementBateaux1(){
		abc =0;
		// Test porte-avion
		for(int i=0; i<=4; i++){
			for(int j=0; j<=3; j++){
			if (choixPlacJ == 1){ //si le placement est pour le J1
				if (tab1[i] == tab2[j]){
				abc++;}}
			else if (choixPlacJ == 2){ //si le placement est pour le J2
			if (tab6[i] == tab7[j]){
				abc++;;}}
				}}
				
				if (abc >= 1){
				erreur = 1;
				JOptionPane.showMessageDialog(null, "Erreur, vous ne pouvez pas placer deux bateaux au meme endroit", "Erreur", JOptionPane.ERROR_MESSAGE);}
				else{
				erreur = 2;}			
	}
		
	void testPlacementBateaux2(){
		
		abc = 0;
		
		// Test avec le porte avion
		for(int i=0; i<=4; i++){
		for(int j=0; j<=2; j++){
			if (choixPlacJ == 1){
			if (tab1[i] == tab3[j]){
			abc++;}}
			else if (choixPlacJ == 2){
			if (tab6[i] == tab8[j]){
			abc++;}}
			}}
			
		//Test avec le Cuirasse
		for(int i=0; i<=3; i++){
		for(int j=0; j<=2; j++){
			if (choixPlacJ == 1){
			if (tab2[i] == tab3[j]){
			abc++;}}
			else if (choixPlacJ == 2){
			if (tab7[i] == tab8[j]){
			abc++;}}
			}}
			
			if (abc >= 1){
			erreur = 1;
			JOptionPane.showMessageDialog(null, "Erreur, vous ne pouvez pas placer deux bateaux au meme endroit", "Erreur", JOptionPane.ERROR_MESSAGE);}
			else{
			erreur = 2;}	
	}
		
	void testPlacementBateaux3(){
		
		abc = 0;
		
		// Test avec le porte avion
		for(int i=0; i<=4; i++){
			for(int j=0; j<=2; j++){
				if (choixPlacJ == 1){ //si le placement est pour le J1
				if (tab1[i] == tab4[j]){
				abc++;}}
				else if (choixPlacJ == 2){ //si le placement est pour le J2
				if (tab6[i] == tab9[j]){
				abc++;;}}
				}}	
			
		// Test avec le Cuirasse	
		for(int i=0; i<=3; i++){
			for(int j=0; j<=2; j++){
				if (choixPlacJ == 1){ //si le placement est pour le J1
				if (tab2[i] == tab4[j]){
				abc++;}}
				else if (choixPlacJ == 2){ //si le placement est pour le J2
				if (tab7[i] == tab9[j]){
				abc++;;}}
				}}
					
		//	Test avec le contre-torpilleur	
		for(int i=0; i<=2; i++){
			for(int j=0; j<=2; j++){
				if (choixPlacJ == 1){ //si le placement est pour le J1
				if (tab3[i] == tab4[j]){
				abc++;}}
				else if (choixPlacJ == 2){ //si le placement est pour le J2
				if (tab8[i] == tab9[j]){
				abc++;;}}
				}}
				
		if (abc >= 1){
			erreur = 1;
			JOptionPane.showMessageDialog(null, "Erreur, vous ne pouvez pas placer deux bateaux au meme endroit", "Erreur", JOptionPane.ERROR_MESSAGE);}
			else{
				erreur = 2;}
	}
		
	void testPlacementBateaux4(){
		
		abc = 0;
		
		//Test avec le porte avion
		for(int i=0; i<=4; i++){
			for(int j=0; j<=1; j++){
				if (choixPlacJ == 1){ //si le placement est pour le J1
				if (tab1[i] == tab5[j]){
				abc++;}}
				else if (choixPlacJ == 2){ //si le placement est pour le J2
				if (tab6[i] == tab10[j]){
				abc++;;}}
				}}
			
		//Test avec le Cuirasse
		for(int i=0; i<=3; i++){
			for(int j=0; j<=1; j++){
				if (choixPlacJ == 1){ //si le placement est pour le J1
				if (tab2[i] == tab5[j]){
				abc++;}}
				else if (choixPlacJ == 2){ //si le placement est pour le J2
				if (tab7[i] == tab10[j]){
				abc++;;}}
				}}
			
		//Test avec le contre-torpilleur
		for(int i=0; i<=2; i++){
			for(int j=0; j<=1; j++){
				if (choixPlacJ == 1){ //si le placement est pour le J1
				if (tab3[i] == tab5[j]){
				abc++;}}
				else if (choixPlacJ == 2){ //si le placement est pour le J2
				if (tab8[i] == tab10[j]){
				abc++;;}}
				}}
			
		//Test avec le sous-marin
		for(int i=0; i<=2; i++){
			for(int j=0; j<=1; j++){
				if (choixPlacJ == 1){ //si le placement est pour le J1
				if (tab4[i] == tab5[j]){
				abc++;}}
				else if (choixPlacJ == 2){ //si le placement est pour le J2
				if (tab9[i] == tab10[j]){
				abc++;;}}
				}}
				
		if (abc >= 1){
			erreur = 1;
			JOptionPane.showMessageDialog(null, "Erreur, vous ne pouvez pas placer deux bateaux au meme endroit", "Erreur", JOptionPane.ERROR_MESSAGE);}
		else{
			erreur = 2;}
	}
	
	
	void tirJoueur1(){
		tempsJeu = System.currentTimeMillis();	// Fonction trouvee ici : http://forum.pcastuces.com/sujet.asp?s=9340&f=19
		pan4.setSize(1000, 580);
		pan4.setTitle("Tir");
		pan4.setLocationRelativeTo(null);
	    pan4.setContentPane(pan5);
	    pan4.setLayout(null);	// Permet de placer les composants où l'on veut dans la fenetre
	    pan4.setUndecorated(true);
	    pan4.setIconImage(icone);
		pan4.setBackground(new Color(0,0,0,0));
		
		JLabel imageTirJ1 = new JLabel(new ImageIcon("images/fond/fond.gif"));
		imageTirJ1.setBounds(0,0,1000,580);

	 
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
				IconButton1 = (mesCases[coo1+a-1][coo2]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/porte/h/"+a+".png");
				mesCases[coo1+a-1][coo2].setIcon(new ImageIcon(imageOpe1));				
				}
		}
		
		else if (placement1 == 2){
			for(int a = 1; a <=5; a++){
				IconButton1 =  (mesCases[coo1][coo2+a-1]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/porte/v/"+a+".png");			
				mesCases[coo1][coo2+a-1].setIcon(new ImageIcon(imageOpe1));				
			}
		}
		
		if (placement2 == 1){
			for(int a = 1; a <=4; a++){
				IconButton1 = (mesCases[coo3+a-1][coo4]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/cuirasse/h/"+a+".png");
				mesCases[coo3+a-1][coo4].setIcon(new ImageIcon(imageOpe1));			
			}
		}
			
		
		else if (placement2 == 2){
			for(int a = 1; a <=4; a++){
				IconButton1 = (mesCases[coo3][coo4+a-1]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/cuirasse/v/"+a+".png");
				mesCases[coo3][coo4+a-1].setIcon(new ImageIcon(imageOpe1));
			}
		}
		
		if (placement3 == 1){
			for(int a = 1; a <=3; a++){
					IconButton1 = (mesCases[coo5+a-1][coo6]).getIcon();
					imageOpe1 = iconToImage(IconButton1, "images/bateaux/torpilleur/h/"+a+".png");
					mesCases[coo5+a-1][coo6].setIcon(new ImageIcon(imageOpe1));
			}
		}
		
		else if (placement3 == 2){
			for(int a = 1; a <=3; a++){
				IconButton1 = (mesCases[coo5][coo6+a-1]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/torpilleur/v/"+a+".png");
				mesCases[coo5][coo6+a-1].setIcon(new ImageIcon(imageOpe1));
			}
		}
		
		if (placement4 == 1){
			for(int a = 1; a <=3; a++){
				IconButton1 = (mesCases[coo7+a-1][coo8]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/torpilleur/h/"+a+".png");			
				mesCases[coo7+a-1][coo8].setIcon(new ImageIcon(imageOpe1));
			}
		}
		
		if (placement4 == 2){
			for(int a = 1; a <=3; a++){
				IconButton1 = (mesCases[coo7][coo8+a-1]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/torpilleur/v/"+a+".png");			
				mesCases[coo7][coo8+a-1].setIcon(new ImageIcon(imageOpe1));
			}
		}
		
		if (placement5 == 1){
			for(int a = 1; a <=2; a++){
				IconButton1 = (mesCases[coo9+a-1][coo10]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/avion/h/"+a+".png");			
				mesCases[coo9+a-1][coo10].setIcon(new ImageIcon(imageOpe1));
				
			}
		}
		
		else if (placement5 == 2){
			for(int a = 1; a <=2; a++){
				IconButton1 = (mesCases[coo9][coo10+a-1]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/avion/v/"+a+".png");			
				mesCases[coo9][coo10+a-1].setIcon(new ImageIcon(imageOpe1));
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
	    
	    nomTirJ1 = new JLabel ("Capitaine " + nomJ1.getText());
	    nomTirJ1.setHorizontalAlignment(JLabel.CENTER);
		nomTirJ1.setLocation(0,10);
		nomTirJ1.setFont(tir);
		nomTirJ1.setSize(1000,25);
		
		votreGrille = new JLabel ("Grille de vos bateaux :");
		votreGrille.setLocation(50,40);
		votreGrille.setSize(150,30);
		
		grilleDeVosTirs = new JLabel ("Grille de vos tirs :");
		grilleDeVosTirs.setLocation(537,40);
		grilleDeVosTirs.setSize(140,30);
		
		continuerTir1 = new JButton("Continuer");
		continuerTir1.setLocation(438 ,500);
		continuerTir1.setSize(120,30);
		
		continuerTir1.setEnabled(false);
		

		pan5.add(votreGrille);
		pan5.add(grilleDeVosTirs);
		pan5.add(continuerTir1);
		pan5.add(nomTirJ1);
		pan5.add(imageTirJ1);

		EcouteurBoutonContinuerTir1 ecouteurContTir1 = new EcouteurBoutonContinuerTir1();
		continuerTir1.addActionListener(ecouteurContTir1);
		
		EcouteurBoutonTir ecouteurTir = new EcouteurBoutonTir();
		for(i = 0; i < mesCases.length; i++ ) {
			for(j = 0; j < mesCases[0].length; j++ ) {
				mesCases2[i][j].addActionListener(ecouteurTir);
			}
		}

	    pan4.setVisible(true);	
	}

	class EcouteurBoutonContinuerTir1 implements ActionListener{
		public void actionPerformed (ActionEvent clic){
			
			pan5.setVisible(false);
			pan4.setContentPane(pan7);
			pan7.setVisible(false);
			
			do{
				
				String reponseQuestion = JOptionPane.showInputDialog(null, "Capitaine " + nomJ2.getText() + ", veuillez entrer votre mot de passe");
				try{
				if (reponseQuestion.equals(MDPj2.getText())){
					
					
					continuerTir2.setEnabled(false);
					reponseMDP1 = false;
					pan7.setVisible(true);
				}
				else
					if (!reponseQuestion.equals(MDPj2.getText())){
						JOptionPane.showMessageDialog(null, "Erreur, mauvais mot de passe", "Erreur", JOptionPane.ERROR_MESSAGE);
						reponseMDP1 = true;
					}
				}
				catch (NullPointerException e){
					JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer votre mot de passe", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
				while (reponseMDP1);
			
			
			
		}
	}
	
	class EcouteurBoutonTir implements ActionListener{
		public void actionPerformed (ActionEvent ev){
		
			if(tourAQui == 1){
			
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
				
				tabTir1[compteurTir1] = Tir;	// un compteur est initialise a 0, donc a chaque passage (le compteur augmente), le tir du moment est enregistre dans une autre cellule
				
				if (compteurTir1 != 0){	// Si le compteur de tir n'est pas egal a 0, alors il passe dans la boucle
					
					for (int i = 0; i < compteurTir1; i++){
					
						if (tabTir1[i] == Tir){
							TestTir = 1;
						}
					}
				}
				
				if (TestTir == 1){
					JOptionPane.showMessageDialog(null, "Erreur, coordonnee deja utilisee", "Erreur", JOptionPane.ERROR_MESSAGE);	
				}
				
				else{
				
					compteurTir1 = compteurTir1 + 1;	// Le compteur augmente de 1 a chaque passage

					if (tab11[0] == tab6[0] | tab11[0] == tab6[1] | tab11[0] == tab6[2] | tab11[0] == tab6[3] | tab11[0] == tab6[4]){
						IconButton1 = (mesCases2[a][b]).getIcon();
						IconButton2 = (mesCases3[a][b]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/explosion.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/explosion.png");				
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe1));
						mesCases3[a][b].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/bomb.wav");
						continuerTir1.setEnabled(true);
						compteur1 = compteur1 + 1;
						
						if (compteur1 == 5){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le porte-avion");
						}
					}																															
					
					else if (tab11[0] == tab7[0] | tab11[0] == tab7[1] | tab11[0] == tab7[2] | tab11[0] == tab7[3]){
						IconButton1 = (mesCases2[a][b]).getIcon();
						IconButton2 = (mesCases3[a][b]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/explosion.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/explosion.png");				
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe1));
						mesCases3[a][b].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/bomb.wav");
						continuerTir1.setEnabled(true);
						compteur2 = compteur2 + 1;
						
						if (compteur2 == 4){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le Cuirasse");
						}
					}
				
					else if (tab11[0] == tab8[0] | tab11[0] == tab8[1] | tab11[0] == tab8[2]){
						IconButton1 = (mesCases2[a][b]).getIcon();
						IconButton2 = (mesCases3[a][b]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/explosion.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/explosion.png");				
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe1));
						mesCases3[a][b].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/bomb.wav");
						continuerTir1.setEnabled(true);
						compteur3 = compteur3 + 1;
						
						if (compteur3 == 3){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le contre-torpilleur");
						}
					}
					
					else if (tab11[0] == tab9[0] | tab11[0] == tab9[1] | tab11[0] == tab9[2]){
						IconButton1 = (mesCases2[a][b]).getIcon();
						IconButton2 = (mesCases3[a][b]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/explosion.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/explosion.png");				
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe1));
						mesCases3[a][b].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/bomb.wav");
						continuerTir1.setEnabled(true);
						compteur4 = compteur4 + 1;
						
						if (compteur4 == 3){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le sous-marin");
						}
					}

					else if (tab11[0] == tab10[0] | tab11[0] == tab10[1]){
						IconButton1 = (mesCases2[a][b]).getIcon();
						IconButton2 = (mesCases3[a][b]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/explosion.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/explosion.png");				
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe1));
						mesCases3[a][b].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/bomb.wav");
						continuerTir1.setEnabled(true);
						compteur5 = compteur5 + 1;
						
						if (compteur5 == 2){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le torpilleur");
						}
					}

					else{
						IconButton1 = (mesCases2[a][b]).getIcon();
						IconButton2 = (mesCases3[a][b]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/croix.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/croix.png");				
						mesCases2[a][b].setIcon(new ImageIcon(imageOpe1));
						mesCases3[a][b].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/plouf.wav");
						continuerTir1.setEnabled(true);
					}
				
					tourAQui = 2;

					if (compteur1 == 5 & compteur2 == 4 & compteur3 == 3 & compteur4 == 3 & compteur5 == 2){
						try{fenetreFinale1();
						}
						catch(NullPointerException e){
							fenetreFinale1();
						}
					}
					
			
				}
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Vous avez d\u00e9j\u00e0 tir\u00e9", "Attention", JOptionPane.ERROR_MESSAGE);
			}	
		}
	}

	void tirJoueur2(){
		
	
	    pan7.setLayout(null);
	    pan4.setContentPane(pan7);
	    pan7.setBackground(new Color(0,0,0,0));
	
		JLabel imageTirJ2 = new JLabel(new ImageIcon("images/fond/fond.gif"));
		imageTirJ2.setBounds(0,0,1000,580);
	    
		int image = 101;
		for(i = 0; i < mesCases3.length; i++ ) {
        	for(j = 0; j < mesCases3[0].length; j++ ) {
				image--;
	            mesCases3[i][j] = new JButton();
	            mesCases3[i][j].setSize(40,40);
				mesCases3[i][j].setIcon(new ImageIcon("images/image40/tab1/"+image+".png"));
	            mesCases3[i][j].setLocation(50+40*i,80+40*j);
	            mesCases3[i][j].setName("" + i + j);
	            pan7.add(mesCases3[i][j]);
	       }
	    
	   }
		
		if (placement6 == 1){
			for(int a = 1; a <=5; a++){
				IconButton1 = (mesCases3[coo11+a-1][coo12]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/porte/h/"+a+".png");
				mesCases3[coo11+a-1][coo12].setIcon(new ImageIcon(imageOpe1));				
			}
		}
	
		else if (placement6 == 2){
			for(int a = 1; a <=5; a++){
				IconButton1 =  (mesCases3[coo11][coo12+a-1]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/porte/v/"+a+".png");			
				mesCases3[coo11][coo12+a-1].setIcon(new ImageIcon(imageOpe1));				
			}
		}
	
		if (placement7 == 1){
			for(int a = 1; a <=4; a++){
				IconButton1 = (mesCases3[coo13+a-1][coo14]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/cuirasse/h/"+a+".png");
				mesCases3[coo13+a-1][coo14].setIcon(new ImageIcon(imageOpe1));			
			}
		}
		
		else if (placement7 == 2){
			for(int a = 1; a <=4; a++){
				IconButton1 = (mesCases3[coo13][coo14+a-1]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/cuirasse/v/"+a+".png");
				mesCases3[coo13][coo14+a-1].setIcon(new ImageIcon(imageOpe1));
			}
		}
		
		if (placement8 == 1){
			for(int a = 1; a <=3; a++){
					IconButton1 = (mesCases3[coo15+a-1][coo16]).getIcon();
					imageOpe1 = iconToImage(IconButton1, "images/bateaux/torpilleur/h/"+a+".png");
					mesCases3[coo15+a-1][coo16].setIcon(new ImageIcon(imageOpe1));
			}
		}
		
		else if (placement8 == 2){
			for(int a = 1; a <=3; a++){
				IconButton1 = (mesCases3[coo15][coo16+a-1]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/torpilleur/v/"+a+".png");
				mesCases3[coo15][coo16+a-1].setIcon(new ImageIcon(imageOpe1));
			}
		}
	
		if (placement9 == 1){
			for(int a = 1; a <=3; a++){
				IconButton1 = (mesCases3[coo17+a-1][coo18]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/torpilleur/h/"+a+".png");			
				mesCases3[coo17+a-1][coo18].setIcon(new ImageIcon(imageOpe1));
			}
		}
		
		if (placement9 == 2){
			for(int a = 1; a <=3; a++){
				IconButton1 = (mesCases3[coo17][coo18+a-1]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/torpilleur/v/"+a+".png");			
				mesCases3[coo17][coo18+a-1].setIcon(new ImageIcon(imageOpe1));
			}
		}
		
		if (placement10 == 1){
			for(int a = 1; a <=2; a++){
				IconButton1 = (mesCases3[coo19+a-1][coo20]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/avion/h/"+a+".png");			
				mesCases3[coo19+a-1][coo20].setIcon(new ImageIcon(imageOpe1));
				
			}
		}
	
		else if (placement10 == 2){
			for(int a = 1; a <=2; a++){
				IconButton1 = (mesCases3[coo19][coo20+a-1]).getIcon();
				imageOpe1 = iconToImage(IconButton1, "images/bateaux/avion/v/"+a+".png");			
				mesCases3[coo19][coo20+a-1].setIcon(new ImageIcon(imageOpe1));
			}
		}
		
		image =0;
		for( int k = 0; k < mesCases4.length; k++ ) {
        	for( int l = 0; l < mesCases4[0].length; l++ ) {
				image ++;
	            mesCases4[k][l] = new JButton();
	            mesCases4[k][l].setSize(40,40);
				mesCases4[k][l].setIcon(new ImageIcon("images/image40/tab2/"+image+".png"));
	            mesCases4[k][l].setLocation(540+40*k,80+40*l);
	            mesCases4[k][l].setName("" + k + l);
		        pan7.add(mesCases4[k][l]);
	       }  
	    }
		
		int cpt = 1;
		char cpt2 = 'A';
		char cpt3 = 'A';
		int cpt4 = 1;
		
		for(int k = 0; k < mesCoordonnees.length; k++){
	    	mesCoordonnees[k] = new JLabel(String.valueOf( cpt2++ ));
	    	mesCoordonnees[k].setSize(10,10);
	    	mesCoordonnees[k].setLocation(40, 87+40*k);
	    	pan7.add(mesCoordonnees[k]); 	
	    }
	    
		
	    for (int m = 0; m < mesCoordonneesH.length; m++){
	    	mesCoordonnees[m] = new JLabel(String.valueOf(cpt++));
	    	mesCoordonnees[m].setSize(14,10);
	    	mesCoordonnees[m].setLocation(57+40*m,68);
	    	pan7.add(mesCoordonnees[m]);
	    }
		
		for(int k = 0; k < mesCoordonnees.length; k++){
	    	
	    	mesCoordonnees[k] = new JLabel(String.valueOf( cpt3++ ));
	    	mesCoordonnees[k].setSize(10,10);
	    	mesCoordonnees[k].setLocation(530, 87+40*k);
	    	pan7.add(mesCoordonnees[k]);
	    }
	    
	    for (int l = 0; l < mesCoordonneesH.length; l++){
	    	mesCoordonnees[l] = new JLabel(String.valueOf(cpt4++));
	    	mesCoordonnees[l].setSize(14,10);
	    	mesCoordonnees[l].setLocation(547+40*l,68);
	    	pan7.add(mesCoordonnees[l]);
	    }
	    
	    nomTirJ2 = new JLabel ("Capitaine " + nomJ2.getText());
	    nomTirJ2.setHorizontalAlignment(JLabel.CENTER);
		nomTirJ2.setLocation(0,10);
		nomTirJ2.setFont(tir);
		nomTirJ2.setSize(1000,25);
		
		votreGrille = new JLabel ("Grille de vos bateaux :");
		votreGrille.setLocation(50,40);
		votreGrille.setSize(150,30);
		
		grilleDeVosTirs = new JLabel ("Grille de vos tirs :");
		grilleDeVosTirs.setLocation(537,40);
		grilleDeVosTirs.setSize(140,30);
		
		continuerTir2 = new JButton("Continuer");
		continuerTir2.setLocation(438 ,500);
		continuerTir2.setSize(120,30);
		
		continuerTir2.setEnabled(false);
		
		pan7.add(votreGrille);
		pan7.add(grilleDeVosTirs);
		pan7.add(continuerTir2);
		pan7.add(nomTirJ2);
		pan7.add(imageTirJ2);
	
		EcouteurBoutonTir2 ecouteurTir2 = new EcouteurBoutonTir2();
		for( int k = 0; k < mesCases4.length; k++ ) {
	        for( int l = 0; l < mesCases4[0].length; l++ ) {
	        	mesCases4[k][l].addActionListener(ecouteurTir2);
	        }
		}
		
		EcouteurBoutonContinuerTir2 ecouteurContinuerTir2 = new EcouteurBoutonContinuerTir2();
		continuerTir2.addActionListener(ecouteurContinuerTir2);
		
		pan7.setVisible(true);
	}
		
	class EcouteurBoutonContinuerTir2 implements ActionListener{
		public void actionPerformed (ActionEvent clic){
			pan7.setVisible(false);
			
			do{
			String reponseQuestion = JOptionPane.showInputDialog(null, "Capitaine " + nomJ1.getText() + ", veuillez entrer votre mot de passe");
			
			try{
			if (reponseQuestion.equals(MDPj1.getText())){
				pan4.setContentPane(pan5);
				continuerTir1.setEnabled(false);
				reponseMDP2 = false;
				pan5.setVisible(true);
			}
			else
				if (!reponseQuestion.equals(MDPj1.getText())){
					JOptionPane.showMessageDialog(null, "Erreur, mauvais mot de passe", "Erreur", JOptionPane.ERROR_MESSAGE);
					reponseMDP2 = true;
				}
			}
			catch (NullPointerException e){
				JOptionPane.showMessageDialog(null, "Erreur, veuillez entrer votre mot de passe", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			}
			while (reponseMDP2);
			
			
		}
	}
		
	class EcouteurBoutonTir2 implements ActionListener{
		
		public void actionPerformed (ActionEvent ev){

			if(tourAQui == 2){
				String name = ((JButton) ev.getSource()).getName();
				
				c = name.charAt(0)-48;
				d = name.charAt(1)-48;
				
				int nbreMax = 1;
				tab11 = new double [nbreMax];
				hord = c;
				verd = d;
				tab11[0] = hord+(verd/10);		// Faire la conversion (-48)
				
				
				
				double Tir2 = hord + (verd/10);
				int TestTir2 = 0;
				
				tabTir2[compteurTir2] = Tir2;
				
				if (compteurTir2 != 0){
					for (int i = 0; i < compteurTir2; i++){
					
						if (tabTir2[i] == Tir2){
							TestTir2 = 1;
						}
					}
				}
				
				if (TestTir2 == 1){
					JOptionPane.showMessageDialog(null, "Erreur, coordonnee deja utilisee", "Erreur", JOptionPane.ERROR_MESSAGE);
					
				}
				
				else{
			
					compteurTir2 = compteurTir2 + 1;
				
				
					if (tab11[0] == tab1[0] | tab11[0] == tab1[1] | tab11[0] == tab1[2] | tab11[0] == tab1[3] | tab11[0] == tab1[4]){
						IconButton1 = (mesCases4[c][d]).getIcon();
						IconButton2 = (mesCases[c][d]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/explosion.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/explosion.png");				
						mesCases4[c][d].setIcon(new ImageIcon(imageOpe1));
						mesCases[c][d].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/bomb.wav");
						continuerTir2.setEnabled(true);
						compteur6 = compteur6 + 1;
						
						if (compteur6 == 5){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le porte-avion");
						}
					}																															
					
					else if (tab11[0] == tab2[0] | tab11[0] == tab2[1] | tab11[0] == tab2[2] | tab11[0] == tab2[3]){
						IconButton1 = (mesCases4[c][d]).getIcon();
						IconButton2 = (mesCases[c][d]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/explosion.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/explosion.png");				
						mesCases4[c][d].setIcon(new ImageIcon(imageOpe1));
						mesCases[c][d].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/bomb.wav");
						continuerTir2.setEnabled(true);
						compteur7 = compteur7 + 1;
						
						if (compteur7 == 4){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le Cuirasse");
						}
					}

					else if (tab11[0] == tab3[0] | tab11[0] == tab3[1] | tab11[0] == tab3[2]){
						IconButton1 = (mesCases4[c][d]).getIcon();
						IconButton2 = (mesCases[c][d]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/explosion.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/explosion.png");				
						mesCases4[c][d].setIcon(new ImageIcon(imageOpe1));
						mesCases[c][d].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/bomb.wav");
						continuerTir2.setEnabled(true);
						compteur8 = compteur8 + 1;
						
						if (compteur8 == 3){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le contre-torpilleur");
						}
					}

					else if (tab11[0] == tab4[0] | tab11[0] == tab4[1] | tab11[0] == tab4[2]){
						IconButton1 = (mesCases4[c][d]).getIcon();
						IconButton2 = (mesCases[c][d]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/explosion.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/explosion.png");				
						mesCases4[c][d].setIcon(new ImageIcon(imageOpe1));
						mesCases[c][d].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/bomb.wav");
						continuerTir2.setEnabled(true);
						compteur9 = compteur9 + 1;
						
						if (compteur9 == 3){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le sous-marin");
						}
					}

					else if (tab11[0] == tab5[0] | tab11[0] == tab5[1]){
						IconButton1 = (mesCases4[c][d]).getIcon();
						IconButton2 = (mesCases[c][d]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/explosion.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/explosion.png");				
						mesCases4[c][d].setIcon(new ImageIcon(imageOpe1));
						mesCases[c][d].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/bomb.wav");
						continuerTir2.setEnabled(true);
						compteur10 = compteur10 + 1;
						
						if (compteur10 == 2){
							Sound.playTempSound("son/bruitages/blooey.wav");
							JOptionPane.showMessageDialog(null, "Vous avez coule le torpilleur");
						}
					}

					else{
						IconButton1 = (mesCases4[c][d]).getIcon();
						IconButton2 = (mesCases[c][d]).getIcon();
						imageOpe1 = iconToImage(IconButton1, "images/couleur/croix.png");	
						imageOpe2 = iconToImage(IconButton2, "images/couleur/croix.png");				
						mesCases4[c][d].setIcon(new ImageIcon(imageOpe1));
						mesCases[c][d].setIcon(new ImageIcon(imageOpe2));
						Sound.playTempSound("son/bruitages/plouf.wav");
						continuerTir2.setEnabled(true);
						
					}

					tourAQui = 1;
			
					if (compteur6 == 5 & compteur7 == 4 & compteur8 == 3 & compteur9 == 3 & compteur10 == 2){
						fenetreFinale2();
					}
				}
				
			}
			else{
				JOptionPane.showMessageDialog(null, "Vous avez d\u00e9j\u00e0 tir\u00e9", "Attention", JOptionPane.ERROR_MESSAGE);
			}
		}			
	}
	
		
	void fenetreFinale1(){

			JLabel imageV1 = new JLabel(new ImageIcon("images/victoire.gif"));
			
			panFin.setSize(1012, 416);
			panFin.setTitle("R\u00e9sultat de la partie");
			panFin.setLocationRelativeTo(null);
		    panFin.setContentPane(panFinal);
		    panFin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		    panFin.setResizable(false);
		    panFin.setIconImage(icone);
		    panFin.setLayout(null);	// Permet de placer les composants où l'on veut dans la fenetre
		    panFinal.setBackground(Color.LIGHT_GRAY);

		    imageV1.setBounds(0,0,1012,416);
		    
		    continuerTir1.setEnabled(false);
		    continuerTir2.setEnabled(false);

		    vainqueur = new JLabel ("Capitaine " + nomJ1.getText() + ", vous avez gagne! BRAVO!");
		    vainqueur.setForeground(java.awt.Color.white);
		    vainqueur.setLocation(340,280);
		    vainqueur.setSize(350,25);
		    
		    nbreCoups1 = new JLabel ("Vous avez gagne en " + compteurTir1 + " tirs.");
		    nbreCoups1.setForeground(java.awt.Color.white);
		    nbreCoups1.setLocation(340,300);
		    nbreCoups1.setSize(320,25);
		    
		    finish = new JButton("OK");
		    finish.setLocation(760, 320);
		    finish.setSize(100,25);
		    
		    
		    panFin.add(vainqueur);
		    panFin.add(nbreCoups1);
		    panFin.add(finish);
		    panFin.add(imageV1);
		    
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
				
			}
		}
		
	void fenetreFinale2(){

			JLabel imageV2 = new JLabel(new ImageIcon("images/victoire.gif"));
		
			panFin2.setSize(1012, 416);
			panFin2.setTitle("R\u00e9sultat de la partie");
			panFin2.setLocationRelativeTo(null);
		    panFin2.setContentPane(panFinal2);
		    panFin2.setLayout(null);	// Permet de placer les composants où l'on veut dans la fenetre
		    panFin2.setIconImage(icone);
		    panFinal2.setBackground(Color.LIGHT_GRAY);

		    continuerTir1.setEnabled(false);
		    continuerTir2.setEnabled(false);
		    
		    vainqueur2 = new JLabel ("Capitaine " + nomJ2.getText() + ", vous avez gagne! BRAVO!");
		    vainqueur2.setForeground(java.awt.Color.white);
		    vainqueur2.setLocation(340,280);
		    vainqueur2.setSize(350,25);
		    
		    nbreCoups2 = new JLabel ("Vous avez gagne en " + compteurTir2 + " tirs.");
		    nbreCoups2.setForeground(java.awt.Color.white);
		    nbreCoups2.setLocation(340,300);
		    nbreCoups2.setSize(320,25);
		    
		    finish = new JButton("OK");
		    finish.setLocation(760, 320);
		    finish.setSize(100,25);
		    
		    panFin2.add(vainqueur2);
		    panFin2.add(nbreCoups2);
		    panFin2.add(finish);
		    panFin2.add(imageV2);
		    
		    EcouteurBoutonOK2 ecouteurOK = new EcouteurBoutonOK2();
		    finish.addActionListener(ecouteurOK);

		    panFin2.setVisible(true);
		}
		
	class EcouteurBoutonOK2 implements ActionListener{
			public void actionPerformed (ActionEvent clic){
				pan.dispose();
				panFin2.dispose();
				pan4.dispose();
			}
		}
		
}
