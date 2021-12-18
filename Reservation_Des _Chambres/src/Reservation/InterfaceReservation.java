package Reservation;

import javax.swing.*;
import java.awt.*;

public class InterfaceReservation extends JPanel{
	private JPanel panneau;
	private CardLayout moncardlayout;
	private Client monclient;
	private int numChambre;

	public InterfaceReservation(CardLayout card, JPanel pann, Client client, int num){
		this.panneau= pann;
		this.moncardlayout= card;
		this.monclient=client;
		this.numChambre=num;
		this.afficherVue();

	}

	public void afficherVue(){
		this.setLayout(new GridLayout(4, 1));  // met le layout en grid 7 lignes, 1 colonne
		Color couleur= new Color(200, 200, 255);
		this.setBackground(couleur);  // modifie couleur panneau

		JLabel etiquette1= new JLabel("Réservation");
		etiquette1.setFont(new Font("", Font.BOLD, 35));
		etiquette1.setHorizontalAlignment(JLabel.CENTER); //  la positionne

		JLabel etiquette2= new JLabel("La chambre "+this.numChambre+" \u00E0 \u00E9t\u00E9 attribu\u00E9e \u00E0 "+this.monclient.getPrenom()+" "+this.monclient.getNom());  // à été attribué à...
		etiquette2.setHorizontalAlignment(JLabel.CENTER); //  la positionne
		this.add(etiquette1);
		this.add(etiquette2);

		JPanel bouton= new JPanel();
		bouton.setBackground(couleur);
		JButton valider= new JButton("Accueil");
		JButton consulter= new JButton("Quitter");
		bouton.add(valider);
		bouton.add(consulter);
		this.add(bouton);

		ControleurBouton controleur= new ControleurBouton(this.moncardlayout, this.panneau, this.monclient);
		valider.addActionListener(controleur);
		consulter.addActionListener(controleur);

		panneau.add(this, "Réservation");
		moncardlayout.show(panneau, "Réservation");
	}


}
