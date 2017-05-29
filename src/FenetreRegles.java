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

public class FenetreRegles extends JFrame {

	JPanel pan = new JPanel();
	JLabel titre = new JLabel("R\u00e8gles de la bataille navale", JLabel.CENTER);
	JLabel sousTitre = new JLabel("<html>      Chaque joueur a 5 bateaux qu'il place sur les 100 cases disponibles.<br>Il peut les placer horizontalement ou verticalement, mais pas en diagonale.</html>", JLabel.CENTER);
	JLabel detail = new JLabel("<html>Les bateaux font de 2 a 5 cases :<br> -1 Porte-Avion: 5 cases<br> -1 Cuirass\u00e9: 4 cases<br> -1 Contre-Torpilleur: 3 cases<br> -1 Sous-Marin: 3 cases<br> -1 Avion de chasse: 2 cases</html>");
	JLabel jeuxDeux = new JLabel("<html>Pour le jeu \u00e0  deux :<br>Les joueur donnent \u00e0  tour de r\u00f4le les coordonn\u00e9es d'une case de l'adversaire pour pouvoir toucher un de ses bateaux.<br>Le joueur gagnant est celui qui \u00e0 trouv\u00e9 tous les bateaux de l'autre joueur.</html>");
	JLabel jeuxOrdi = new JLabel("<html>Pour le jeu contre l'ordinateur :<br> Vous jouez \u00e0  tour de r\u00f4le avec l'ordinateur sur le m\u00eame principe que le jeux \u00e0 deux.</html>");
	// pas le droit de placer les bateaux cote a cote (attention)
	JButton boutonOk = new JButton("Ok");
	
	public FenetreRegles(){
	
		setTitle("Regles");
		setSize(700,330);
		setLocationRelativeTo(null);	// Met la fenetre au milieu de l'ecran
        setResizable(false);
		pan.setLayout(null);
		setUndecorated(true);
		Font titreR = new Font("Arial Black", Font.PLAIN, 20);
		Font titreS = new Font("Arial", Font.PLAIN, 12);
		
		titre.setBounds(0,0,700,50);
		titre.setForeground(java.awt.Color.white);	
		titre.setFont(titreR);
		pan.add(titre);
		
		sousTitre.setBounds(10,35,700,50);
		sousTitre.setForeground(java.awt.Color.black);	
		sousTitre.setFont(titreS);
		pan.add(sousTitre);
		
		detail.setBounds(10,40,700,200);
		detail.setForeground(java.awt.Color.black);	
		detail.setFont(titreS);
		pan.add(detail);
		
		jeuxDeux.setBounds(10,120,700,200);
		jeuxDeux.setForeground(java.awt.Color.black);	
		jeuxDeux.setFont(titreS);
		pan.add(jeuxDeux);
		
		jeuxOrdi.setBounds(10,165,700,200);
		jeuxOrdi.setForeground(java.awt.Color.black);	
		jeuxOrdi.setFont(titreS);
		pan.add(jeuxOrdi);
		
		boutonOk.setBounds(300,300,100,25);
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
		FenetreRegles fen = new FenetreRegles();
	}
}
