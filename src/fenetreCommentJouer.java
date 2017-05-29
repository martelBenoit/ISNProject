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

public class fenetreCommentJouer extends JFrame {

	JPanel pan = new JPanel();
	JLabel titre = new JLabel("Voici comment jouer a la bataille navale dans ce programme:", JLabel.CENTER);
	JLabel sousTitre = new JLabel("<html>Chaque joueur dispose de 5 bateaux. Un porte-avion (5 cases), un croiseur (4 cases), un contre-torpilleur (3 cases), <br> un sous-marin (3 cases) et un torpilleur (2 cases).</html>", JLabel.CENTER);
	JLabel detail = new JLabel("<html>Au debut du programme, vous devrez entrer un nom ainsi qu'un mot de passe. Ce dernier est la pour que l'adversaire ne<br> puisse pas tricher. Valable uniquement pour le mode a deux</html>");
	JLabel jeuxDeux = new JLabel("<html>Ensuite, il faudra entrer les coordonnees dans des petites cases. Vous aurez une grille en bas de la fenetre pour voir <br>où sont places vos bateaux, ils seront places en vert sur la grille. Une fois que les coordonnees sont enregistrees, <br> vous pouvez passer au jeu.</html>");
	JLabel jeuxOrdi = new JLabel("<html>Vous aurez ensuite une nouvelle fenetre avec avec deux grilles differentes, mais de meme taille :<br> - Une grille de vos bateaux avec les tirs que votre adversaire a fait (grille de gauche) <br> - Une grille avec les tir que vous avez fait (grille de droite) <br> <br> Pour tirer sur les bateaux de votre adversaire, vous devez cliquer sur la case voulue sur la grille de droite. <br> Lorsque vous faites un tir sur un bateau adverse, la case se met en rouge et lorsque vous tirez dans l'eau,<br> la case devient blanche. <br>Une fois qu'un joueur a coule tous les bateaux de son adversaire, il a gagne.</html>");
	JButton boutonOk = new JButton("Ok");
	
	public fenetreCommentJouer(){
	
		setTitle("Comment Jouer");
		setSize(700,420);
		setLocationRelativeTo(null);	// Met la fenetre au milieu de l'ecran
        setResizable(false);
		pan.setLayout(null);
		setUndecorated(true);
		
		Font titreR = new Font("Arial Black", Font.PLAIN, 20);
		Font titreS = new Font("Arial", Font.PLAIN, 12);
		
		titre.setBounds(0,5,700,50);
		titre.setForeground(java.awt.Color.white);	
		titre.setFont(titreR);
		pan.add(titre);
		
		sousTitre.setBounds(10,45,700,50);
		sousTitre.setForeground(java.awt.Color.black);	
		sousTitre.setFont(titreS);
		pan.add(sousTitre);
		
		detail.setBounds(10,55,700,200);
		detail.setForeground(java.awt.Color.black);	
		detail.setFont(titreS);
		pan.add(detail);
		
		jeuxDeux.setBounds(10,90,700,200);
		jeuxDeux.setForeground(java.awt.Color.black);	
		jeuxDeux.setFont(titreS);
		pan.add(jeuxDeux);
		
		jeuxOrdi.setBounds(10,190,700,200);
		jeuxOrdi.setForeground(java.awt.Color.black);	
		jeuxOrdi.setFont(titreS);
		pan.add(jeuxOrdi);
		
		boutonOk.setBounds(300,370,100,25);
		pan.add(boutonOk);
		
		EcouteurBoutonOk ecouteurOk = new EcouteurBoutonOk();
		boutonOk.addActionListener(ecouteurOk);
	
		setContentPane(pan);
		setVisible(true);
	}
	
	class EcouteurBoutonOk implements ActionListener {
		
		public void actionPerformed (ActionEvent clic) {
		
			dispose();
		}
	}
	
	public static void main (String args[]){
		fenetreCommentJouer fen = new fenetreCommentJouer();
	}
}