package Reservation;

import java.awt.*;
import javax.swing.*;

public class ErreurReservation extends JPanel{
	private JPanel panneau;
	private CardLayout moncardlayout;
	private Client monclient;

	public ErreurReservation(CardLayout card, JPanel pann, Client client){
		this.panneau= pann;
		this.moncardlayout= card;
		this.monclient=client;

		this.afficherErreurR();

	}
	public void afficherErreurR(){
		System.out.println("Erreur Réservation");
		this.setLayout(new GridLayout(4, 1)); //4lignes, 1 colonne
		Color couleur= new Color(200, 200, 255);
		this.setBackground(couleur); //couleur fond panneau

		//Creation etiquettes
		JLabel etiquette1= new JLabel("Erreur Réservation");
		etiquette1.setHorizontalAlignment(JLabel.CENTER);
		etiquette1.setFont(new Font("", Font.BOLD, 35));
		this.add(etiquette1);

		JLabel etiquette2= new JLabel("Le Client/La Cliente "+this.monclient.getPrenom()+" "+this.monclient.getNom()+" existe mais n'a pas de r\u00E9servation");
		etiquette2.setHorizontalAlignment(JLabel.CENTER);
		this.add(etiquette2);

		JPanel panbouton= new JPanel();
		panbouton.setBackground(couleur);
		JButton accueil= new JButton("Accueil");  // creer bouton
		JButton quitter= new JButton("Quitter");
		panbouton.add(accueil);   // met les 2 boutons dans le panneau
		panbouton.add(quitter);
		this.add(panbouton);

		ControleurBouton controleur= new ControleurBouton(this.moncardlayout, this.panneau, this.monclient);
		accueil.addActionListener(controleur); 
		quitter.addActionListener(controleur); 

		panneau.add(this, "ErreurReservation");
		moncardlayout.show(panneau, "ErreurReservation");
	}

}
