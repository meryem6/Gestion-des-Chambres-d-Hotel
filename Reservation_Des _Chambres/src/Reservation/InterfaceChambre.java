package Reservation;
import javax.swing.*;
import java.awt.*;

public class InterfaceChambre extends JPanel{
	private JPanel panneau;
	private CardLayout moncardlayout;
	private Client monclient;
	private Chambre machambre;
	private ChambreModule chambremodule;

	public InterfaceChambre(CardLayout card, JPanel pann, Client client, Chambre chambre, ChambreModule chambremod){
		this.panneau= pann;
		this.moncardlayout= card;
		this.monclient=client;
		this.machambre=chambre;
		this.chambremodule=chambremod;

		this.afficherVue();
	}

	public void afficherVue(){
		this.setLayout(new GridLayout(5, 1));  // met le layout en grid 7 lignes, 1 colonne
		Color couleur= new Color(200, 200, 255);
		this.setBackground(couleur);  // modifie couleur panneau

		JLabel etiquette1= new JLabel("Chambre r\u00E9serv\u00E9e");
		etiquette1.setFont(new Font("", Font.BOLD, 35));
		etiquette1.setHorizontalAlignment(JLabel.CENTER); //  la positionne

		JLabel etiquette2= new JLabel("Le Client/La Cliente est: "+this.monclient.getPrenom()+" "+this.monclient.getNom());
		etiquette2.setHorizontalAlignment(JLabel.CENTER); //  la positionne

		JLabel etiquette3= new JLabel("La r\u00E9f\u00E9rence de la r\u00E9servation est: "+this.monclient.getNum());
		etiquette3.setHorizontalAlignment(JLabel.CENTER); //  la positionne

		JLabel etiquette4= new JLabel("La chambre allou\u00E9e automatiquement est la chambre num\u00E9ro: "+this.machambre.getNum()+" de cat\u00E9gorie: "+this.machambre.getCat());
		etiquette4.setHorizontalAlignment(JLabel.CENTER); //  la positionne

		this.add(etiquette1);
		this.add(etiquette2);
		this.add(etiquette3);
		this.add(etiquette4);

		JPanel bouton= new JPanel();
		bouton.setBackground(couleur);
		JButton valider= new JButton("Valider");
		JButton consulter= new JButton("Consulter la liste des chambres");
		bouton.add(valider);
		bouton.add(consulter);
		this.add(bouton);

		ControleurChambre controleur= new ControleurChambre(this.moncardlayout, this.panneau, this.monclient, this.chambremodule);
		valider.addActionListener(controleur);
		consulter.addActionListener(controleur);

		panneau.add(this, "Chambre");
		moncardlayout.show(panneau, "Chambre");

	}
}

