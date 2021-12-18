package Reservation;

import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.awt.*;

public class InterfaceNoChambre extends JPanel{
	private JPanel panneau;
	private CardLayout moncardlayout;
	private Client monclient;
	private ChambreModule machambre;

	public InterfaceNoChambre(CardLayout card, JPanel pann, Client client, ChambreModule chambre){
		this.panneau= pann;
		this.moncardlayout= card;
		this.monclient=client;
		this.machambre=chambre;

		this.afficherVue();
	}

	public void afficherVue(){
		this.setLayout(new GridLayout(5, 1));  // met le layout en grid 7 lignes, 1 colonne
		Color couleur= new Color(200, 200, 255);
		this.setBackground(couleur);  // modifie couleur panneau

		JLabel etiquette1= new JLabel("Aucune chambre disponible");
		etiquette1.setFont(new Font("", Font.BOLD, 35));
		etiquette1.setHorizontalAlignment(JLabel.CENTER); //  la positionne

		JLabel etiquette2= new JLabel("Le Client/La Cliente est: "+this.monclient.getPrenom()+" "+this.monclient.getNom());
		etiquette2.setHorizontalAlignment(JLabel.CENTER); //  la positionne

		JLabel etiquette3= new JLabel("La r\u00e9f\u00e9rence de la r\u00e9servation est: "+this.monclient.getNum());
		etiquette3.setHorizontalAlignment(JLabel.CENTER); //  la positionne

		JLabel etiquette4= new JLabel("Il n'y a pas de chambre disponible pour la cat\u00e9gorie: "+this.machambre.getCat());
		etiquette4.setHorizontalAlignment(JLabel.CENTER); //  la positionne

		this.add(etiquette1);
		this.add(etiquette2);
		this.add(etiquette3);
		this.add(etiquette4);

		JPanel bouton= new JPanel();
		bouton.setBackground(couleur);
		JButton accueil= new JButton("Accueil");
		JButton quitter= new JButton("Quitter");
		bouton.add(accueil);
		bouton.add(quitter);
		this.add(bouton);

		ControleurBouton controleur= new ControleurBouton( this.moncardlayout,this.panneau, this.monclient);
		accueil.addAncestorListener((AncestorListener) controleur);
		quitter.addAncestorListener((AncestorListener) controleur);

		panneau.add(this, "NoChambre");
		moncardlayout.show(panneau, "NoChambre");

	}
}
