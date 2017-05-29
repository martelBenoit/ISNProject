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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.imageio.ImageIO; 
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;


public class fenetreMain extends JFrame {
	JPanel pan = new JPanel();
	
	JButton boutonJouer = new JButton("Jouer \u00e0 deux");
	JButton boutonOrdi = new JButton("Jouer contre l'ordinateur");
	JButton boutonRegle = new JButton("R\u00e8gles du jeu");
	JButton boutonComment = new JButton("Comment Jouer ?");
	JButton boutonQuitter = new JButton("Quitter");
	JLabel imageFond = new JLabel(new ImageIcon("images/imaPrinc1.png"));
	
	fenetre1VS1 numeroDeux = new fenetre1VS1();
	fenetre1VsOrdi numeroTrois= new fenetre1VsOrdi();
	
	
	JFrame pan2 = new JFrame();	

	Image icone = Toolkit.getDefaultToolkit().getImage("images/icone.png");
		
	
	private URL url;
	private AudioClip sound;

	public fenetreMain(){
	
		
		setIconImage(icone);
	
		Font titre = new Font("Arial Black", Font.PLAIN, 15);
		pan.setLayout(null);
		
		imageFond.setBounds(0,0,1024,720);
		
		boutonOrdi.setBounds(120,380,250,50);
		boutonOrdi.setBackground(java.awt.Color.gray);
		boutonOrdi.setForeground(java.awt.Color.white);
		boutonOrdi.setHorizontalTextPosition(AbstractButton.CENTER);
		boutonOrdi.setFont(titre);

		boutonJouer.setBackground(java.awt.Color.gray);
		boutonJouer.setForeground(java.awt.Color.white);	
		boutonJouer.setBounds(120,310,250,50);
		boutonJouer.setHorizontalTextPosition(AbstractButton.CENTER);
		boutonJouer.setFont(titre);
		
		boutonRegle.setBackground(java.awt.Color.gray);
		boutonRegle.setForeground(java.awt.Color.white);
		boutonRegle.setBounds(120,450,250,50);
		boutonRegle.setHorizontalTextPosition(AbstractButton.CENTER);
		boutonRegle.setFont(titre);
		
		boutonComment.setBounds(120,520,250,50);
		boutonComment.setBackground(java.awt.Color.gray);
		boutonComment.setForeground(java.awt.Color.white);
		boutonComment.setHorizontalTextPosition(AbstractButton.CENTER);
		boutonComment.setFont(titre);
		
		boutonQuitter.setBounds(900,640,110,40);
		boutonQuitter.setBackground(java.awt.Color.gray);
		boutonQuitter.setForeground(java.awt.Color.red);
		boutonQuitter.setHorizontalTextPosition(AbstractButton.CENTER);
		boutonQuitter.setFont(titre);
	
		setTitle("Bataille Navale"); // Titre de la fenetre
		setSize(1024, 720);	// Definit la taille de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// Supprime la fenetre de la memoire lorsqu'elle est fermee
        setLocationRelativeTo(null);	// Met la fenetre au milieu de l'ecran
        setResizable(false);
		
		
		pan.add(boutonOrdi);
		pan.add(boutonJouer);
		pan.add(boutonRegle);
		pan.add(boutonComment);
		pan.add(boutonQuitter);
		
        setContentPane(pan);
		pan.add(imageFond);
		
        EcouteurBoutonJouer ecouteurJouer = new EcouteurBoutonJouer();	// Cree l'ecouteur
        boutonJouer.addActionListener(ecouteurJouer);	// Ajoute l'ecouteur au bouton
		EcouteurBoutonOrdi ecouteurOrdi = new EcouteurBoutonOrdi();
		boutonOrdi.addActionListener(ecouteurOrdi);
		EcouteurBoutonRegle ecouteurRegle = new EcouteurBoutonRegle();
		boutonRegle.addActionListener(ecouteurRegle);
		EcouteurBoutonComment ecouteurComment = new EcouteurBoutonComment();
		boutonComment.addActionListener(ecouteurComment);
		EcouteurBoutonQuitter ecouteurQuitter = new EcouteurBoutonQuitter();
		boutonQuitter.addActionListener(ecouteurQuitter);

		url = this.getClass().getClassLoader().getResource("son/musiqueFond.wav");
		sound = Applet.newAudioClip(url);
		
		sound.play();
		setVisible(true);	// Permet de rendre la fenetre visible
		pan.updateUI();
		pan.repaint();
	}
	
	class EcouteurBoutonJouer implements ActionListener {
		
		public void actionPerformed (ActionEvent clic) {
		
			numeroDeux.mdpEtNomJ1();
			
		}
	}

	class EcouteurBoutonOrdi implements ActionListener {
		
		public void actionPerformed (ActionEvent clic) {
		
			numeroTrois.nomDuJoueur();
		}
	}

	class EcouteurBoutonRegle implements ActionListener {
		
		public void actionPerformed (ActionEvent clic) {
		
			new FenetreRegles();
		}
	}

	class EcouteurBoutonComment implements ActionListener {
		
		public void actionPerformed (ActionEvent clic) {
		
			new fenetreCommentJouer();
		}
	}
	
	class EcouteurBoutonQuitter implements ActionListener {
		
		public void actionPerformed (ActionEvent clic) {
		
			System.exit(0); 
		}
	}

	public static void main (String args[]){
		

		fenetreMain numeroUne = new fenetreMain();
			
	}
}